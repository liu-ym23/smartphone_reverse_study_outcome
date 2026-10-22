package com.bytedance.ee.bear.document.comment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.ClipData;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.sharepermissiondialog.BottomPopupData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.setting.PreloadStrategy;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.doc.editmodeswitchplugin.IEditModeSwitchViewPlugin;
import com.bytedance.ee.bear.doc.follow.event.OpenImageWhiteboard;
import com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl;
import com.bytedance.ee.bear.document.ContentViewWidthChangePlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.authors.Author;
import com.bytedance.ee.bear.document.authors.AuthorsPlugin;
import com.bytedance.ee.bear.document.comment.bean.Card;
import com.bytedance.ee.bear.document.comment.bean.ClipboardData;
import com.bytedance.ee.bear.document.comment.bean.CommentJsRequestBean;
import com.bytedance.ee.bear.document.comment.bean.CopyResult;
import com.bytedance.ee.bear.document.comment.bean.CopyUrlTemplateBean;
import com.bytedance.ee.bear.document.comment.bean.Entity;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.comment.bean.Per;
import com.bytedance.ee.bear.document.comment.bean.ReactionAnimate;
import com.bytedance.ee.bear.document.comment.bean.ReactionPanel;
import com.bytedance.ee.bear.document.comment.bean.SendCommentResult;
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
import com.bytedance.ee.bear.document.comment.bean.ShowToastJsData;
import com.bytedance.ee.bear.document.comment.bean.UpdateReaction;
import com.bytedance.ee.bear.document.comment.imageviewer.OpenCommentImageModel;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.feed.BaseFeedPlugin;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.h5;
import com.bytedance.ee.bear.document.imageviewer.ImageViewerPlugin;
import com.bytedance.ee.bear.document.imageviewer.ImageViewerViewModel;
import com.bytedance.ee.bear.document.imageviewer.bean.AreaCommentMode;
import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin;
import com.bytedance.ee.bear.document.search.BaseSearchPlugin;
import com.bytedance.ee.bear.document.search.SearchViewModel;
import com.bytedance.ee.bear.document.sendtoim.SendToImPlugin;
import com.bytedance.ee.bear.document.tips.BaseTipsPlugin;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.bytedance.ee.bear.middleground.comment.export.CardCommentHeight;
import com.bytedance.ee.bear.middleground.comment.export.CommentBuilder;
import com.bytedance.ee.bear.middleground.comment.export.CommentHostDelegateUtils;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBottomPopupData;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.FocusInputBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ReactionDetail;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.SwitchCardBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SyncReactionResultJsData;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.bear.middleground.comment.export.commentsdk.bean.CommentMetadata;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.reaction.widget.detailwindow.ReactionPopupFacade;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import com.ss.android.lark.reaction.widget.panel.ReactionPanelFacade;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.storage.LarkKVStorage;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CommentPlugin extends DocumentPluginV2 {
    private static final long DURATION_4 = 4000;
    private static final String GET_CLIPBOARD_TOKEN = "LARK-PSDA-ccm_android_comment_plugin_set_clipboard";
    public static final int MAX_COMMENT_IMAGE_COUNT = 9;
    private static final String TAG = "Comment#CommentPlugin";
    private boolean areaCommentReadEnable;
    private boolean asideCommentV2;
    private ArrayList<String> authorIds;
    private final com.bytedance.ee.bear.doc.blockeditpanel.b.a blockMenuClickListener;
    private final SearchViewModel.a closeKeyboardOnDestroyInterceptor;
    private com.bytedance.ee.bear.document.comment.d commentEventDispatcher;
    private com.bytedance.ee.bear.middleground.comment.export.k commentHostConfigDelegate;
    private CommentPanelViewModel commentViewModel;
    private com.bytedance.ee.bear.middleground.comment.export.i config;
    private final sy4.d docFollowStateObserver;
    private EditPanelsManager editPanelsManager;
    private final MutableLiveData<Boolean> enableCalcScrollPosLiveData;
    private boolean enableSkipHalfScreenTopLocationChange;
    private int forceOrientationRequestCount;
    private HashMap<String, Function<Boolean, Unit>> forwardCallbacks;
    private boolean isOwner;
    private final BaseFeedPlugin.a jumpToCommentListener;
    private CommentStyle lastCommentStyle;
    private com.bytedance.ee.bear.doc.blockeditpanel.b mBlockMenuClickListenerHolder;
    private com.bytedance.ee.bear.middleground.comment.export.h mComment;
    private PopupWindow mEmojiPanel;
    private tb5.m mEmojiPanelCallback;
    private BaseFeedPlugin mFeedPlugin;
    private FollowPlugin mFollowPlugin;
    private ImageViewerPlugin mImageViewerPlugin;
    private tb5.m mListenerCb;
    private sy4.e mPresenterState;
    PopupWindow mReaction;
    com.bytedance.ee.bear.middleground.comment.export.s mReactionAnimatePanel;
    private BaseSearchPlugin<?> mSearchPlugin;
    private BaseSelectionPlugin<?> mSelectionPlugin;
    private final com.bytedance.ee.bear.document.plugin.selection.d menuItemClickListener;
    private final com.bytedance.ee.bear.middleground.comment.export.g.a onScrollCallback;
    private String ownerId;
    private Per per;
    private VisibilityBean recordVisibilityBean;
    private ShowCardsJsData showCardsJsData;
    private Observer<ShowCardsJsData> showCardsJsDataObserver;

    public class a implements ReactionPanelFacade.b {
        public final /* synthetic */ tb5.m a;
        public final /* synthetic */ com.bytedance.ee.bear.contract.x b;
        public final /* synthetic */ CommentPlugin c;

        public final /* synthetic */ void b() {
        }

        public final void a(String r3, int r4) {
            tt5.a.h(CommentPlugin.TAG, "ShowContentReactionPanelHandler onReactionClick");
            JSONObject r5 = new JSONObject();
            r5.put("reactionKey", r3);
            r5.put("isUserCancelled", Boolean.FALSE);
            this.a.b(r5);
            CommentPlugin.access$6400(this.c).setOnDismissListener(null);
            PopupWindow r6 = CommentPlugin.access$6400(this.c);
            PopupWindowLancet.handleDismissBeforeOrigin(r6);
            r6.dismiss();
            this.b.q(r3, null);
        }

        public a(CommentPlugin r1, tb5.m r2, com.bytedance.ee.bear.contract.x r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class a0 implements tb5.i<ScrollCommentBean> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            ScrollCommentBean r4 = (ScrollCommentBean) r2;
            tt5.a.h(CommentPlugin.TAG, "JS request scroll comment, data = " + r4);
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.getCur_comment_id() != null) goto L7;
            return;
        L7:
            if (r4.getReplyId() != null) goto L9;
            return;
        L9:
            if (r4.getToken() != null) goto L12;
            return;
        L12:
            if (CommentPlugin.access$3000(this.a) == null) goto L14;
            CommentPlugin.access$3000(this.a).q().invoke(r4);
            return;
        L14:
            tt5.a.d(CommentPlugin.TAG, "can not scroll comment, mComment is null!");
        }
    }

    public class b implements PopupWindow.OnDismissListener {
        public final /* synthetic */ tb5.m a;

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            tt5.a.h(CommentPlugin.TAG, "ShowContentReactionPanelHandler onDismiss");
            JSONObject r0 = new JSONObject();
            r0.put("isUserCancelled", Boolean.TRUE);
            this.a.b(r0);
        }

        public b(tb5.m r1) {
            this.a = r1;
        }
    }

    public class b0 implements tb5.i<SendCommentResult> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            SendCommentResult r5 = (SendCommentResult) r3;
            tt5.a.h(CommentPlugin.TAG, "SendCommentResultHandler, data = " + r5.toString());
            if (CommentPlugin.access$4000(this.a) != null) goto L5;
            return;
        L5:
            if (CommentPlugin.access$4000(this.a).a() == null) goto L16;
            com.bytedance.ee.bear.middleground.comment.performance.d r6 = CommentPlugin.access$4000(this.a).a().b();
            if (r6 != null) goto L9;
            return;
        L9:
            if (r6.a(r5.getReplyUuid()) == false) goto L12;
            r6.d(r5.getReplyUuid(), r5.getRes(), r5.getFailReason());
            return;
        L12:
            if (r6.a(r5.getCommentUuid()) == false) goto L19;
            r6.d(r5.getCommentUuid(), r5.getRes(), r5.getFailReason());
            return;
        L19:
            return;
        }
    }

    public class c implements ze5.c {
        public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.export.h a;
        public final /* synthetic */ CommentInputRequest b;
        public final /* synthetic */ CommentPlugin c;

        public final void a() {
            tt5.a.h(CommentPlugin.TAG, "insert image success");
            com.bytedance.ee.bear.middleground.comment.export.h r0 = this.a;
            CommentInputRequest r1 = this.b;
            r0.X0(r1.content, r1.comment_id, Boolean.valueOf(r1.is_whole));
            CommentPlugin.access$7700(this.c, this.a, this.b);
        }

        public final void b() {
            tt5.a.h(CommentPlugin.TAG, "insert image failed");
            String r0 = xo5.a.c(CommentPlugin.access$7800(this.c), 2131886932, "count", String.valueOf(9));
            Toast.showFailureText(CommentPlugin.access$7900(this.c), r0);
            com.bytedance.ee.bear.middleground.comment.export.h r1 = this.a;
            CommentInputRequest r2 = this.b;
            r1.X0(r2.content, r2.comment_id, Boolean.valueOf(r2.is_whole));
            CommentPlugin.access$7700(this.c, this.a, this.b);
        }

        public c(CommentPlugin r1, com.bytedance.ee.bear.middleground.comment.export.h r2, CommentInputRequest r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class c0 implements tb5.i<CopyUrlTemplateBean> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            CopyUrlTemplateBean r5 = (CopyUrlTemplateBean) r3;
            tt5.a.h(CommentPlugin.TAG, "JS request set copy url template, data = " + r5);
            com.bytedance.ee.bear.middleground.comment.export.h r6 = CommentPlugin.access$5300(this.a);
            String r0 = null;
            if (r5 == null) goto L5;
            String r1 = r5.getTemplate();
        L6:
            r6.m1(r1);
            CommentPanelViewModel r7 = CommentPlugin.access$3100(this.a);
            if (r5 == null) goto L9;
            r0 = r5.getTemplate();
        L9:
            r7.setCopyUrlTemplate(r0);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public class d extends x2.c {
        public final /* synthetic */ CommentPlugin a;

        public d(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r3, Throwable r4) {
            StringBuilder r5 = new StringBuilder("onLoadFail()... code = ");
            r5.append(r3);
            r5.append(", dismiss comment, mComment is showing? ");
            if (CommentPlugin.access$3000(this.a) != null) goto L5;
        L7:
            boolean r6 = false;
        L8:
            r5.append(r6);
            tt5.a.h(CommentPlugin.TAG, r5.toString());
            if (CommentPlugin.access$3000(this.a) != null) goto L11;
            return;
        L11:
            if (CommentPlugin.access$3000(this.a).O(false) == false) goto L15;
            CommentPlugin.access$3000(this.a).Q0(false, true);
            return;
        L15:
            return;
        L5:
            if (CommentPlugin.access$3000(this.a).O(false) == false) goto L7;
            r6 = true;
            goto L8
        }
    }

    public class d0 implements tb5.i<Entity> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            Entity r4 = (Entity) r2;
            tt5.a.h(CommentPlugin.TAG, "JS request set entity, data = " + r4);
            if (r4 == null) goto L7;
            CommentPlugin.access$3000(this.a).o(r4.getToken());
            CommentPlugin.access$3000(this.a).s(sbb.e.d(r4.getType()));
            return;
        }
    }

    public class e extends AnimatorListenerAdapter {
        public final /* synthetic */ CommentPlugin a;

        public e(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r5) {
            CommentPlugin.access$3100(this.a).getCommentAnimationLiveData().setValue(new com.bytedance.ee.bear.middleground.comment.export.a(true, false, false));
            super.onAnimationEnd(r5);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r5) {
            CommentPlugin.access$3100(this.a).getCommentAnimationLiveData().setValue(new com.bytedance.ee.bear.middleground.comment.export.a(true, true, false));
            super.onAnimationStart(r5);
        }
    }

    public class e0 implements tb5.i<Per> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            Per r4 = (Per) r2;
            tt5.a.h(CommentPlugin.TAG, "JS request set permission, data = " + r4);
            CommentPlugin.access$3502(this.a, r4);
        }
    }

    public class f extends AnimatorListenerAdapter {
        public final /* synthetic */ CommentPlugin a;

        public f(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            CommentPlugin.access$3100(this.a).getCommentAnimationLiveData().setValue(new com.bytedance.ee.bear.middleground.comment.export.a(false, false, false));
            super.onAnimationEnd(r4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r5) {
            CommentPlugin.access$3100(this.a).getCommentAnimationLiveData().setValue(new com.bytedance.ee.bear.middleground.comment.export.a(false, true, false));
            super.onAnimationStart(r5);
        }
    }

    public class f0 implements tb5.i<String> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            String r5 = (String) r3;
            tt5.a.h(CommentPlugin.TAG, "JS request set reaction detail");
            String r6 = JSONObjectProtectorUtils.getString(new org.json.JSONObject(r5), "data");     // Catch: JSONException -> L5
        L8:
            if (TextUtils.isEmpty(r6) == true) goto L10;
            CommentPlugin.access$3000(this.a).e(r6);
            return;
        L10:
            tt5.a.d(CommentPlugin.TAG, "SetReactionDetailHandler()... error! data is empty ");
            return;
        L5:
            e = move-exception;
            tt5.a.e(CommentPlugin.TAG, "parse reaction data error!", e, false);
            r6 = "";
            goto L8
        }
    }

    public class g implements com.bytedance.ee.bear.middleground.comment.export.t {
        public final /* synthetic */ CommentPlugin a;

        public final boolean a() {
            if (CommentPlugin.access$3200(this.a) != null) goto L5;
        L7:
            return false;
        L5:
            if (CommentPlugin.access$3200(this.a).b == false) goto L7;
            return true;
        }

        public final boolean b() {
            if (CommentPlugin.access$3200(this.a) != null) goto L5;
        L7:
            return false;
        L5:
            if (CommentPlugin.access$3200(this.a).a == false) goto L7;
            return true;
        }

        public final boolean c() {
            if (CommentPlugin.access$3200(this.a) == null) goto L5;
            return true;
        L5:
            return false;
        }

        public g(CommentPlugin r1) {
            this.a = r1;
        }
    }

    public class g0 implements tb5.i<String> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r26, tb5.m r27) {
            String r1 = (String) r26;
            if (r1 != null) goto L5;
            tt5.a.d(CommentPlugin.TAG, "JS request show cards , but no cards !");
            return;
        L5:
            ShowCardsJsData r3 = (ShowCardsJsData) com.ss.android.lark.utils.z.a(r1, ShowCardsJsData.class);
            if (r3 != null) goto L8;
            tt5.a.d(CommentPlugin.TAG, "JS request show cards, but parse ShowCardsJsData error!");
            return;
        L8:
            tt5.a.h(CommentPlugin.TAG, "JS request show cards, data = " + r3);
            CommentPlugin.access$3502(this.a, r3.permission);
            CommentPlugin.access$3100(this.a).updateCommentCardsRequest(r3);
            int r11 = r1.length();
            com.bytedance.ee.bear.middleground.comment.export.i r2 = CommentPlugin.access$3000(this.a).F0();
            int r4 = s2.a;
            Intrinsics.checkNotNullParameter(r3, "data");
            Intrinsics.checkNotNullParameter(r2, "config");
            Intrinsics.checkNotNullParameter(r3, "data");
            Intrinsics.checkNotNullParameter(r2, "config");
            af5.b r5 = r2.a();
            if (r5 == null) goto L77;
            com.bytedance.ee.bear.middleground.comment.performance.b r10 = r5.c();
            if (r10 == null) goto L77;
            if (r10.b() == false) goto L16;
        L24:
            String r7 = r3.getCur_comment_id();
            if (r7 == null) goto L77;
            if (r3.getCards() == null) goto L62;
            int r6 = r3.getCards().size();
            Iterator<Card> r8 = r3.getCards().iterator();
            int r9 = 0;
            int r16 = 0;
            int r17 = 0;
            int r18 = 0;
        L31:
            if (r8.hasNext() == false) goto L61;
            Card r19 = r8.next();
            int r13 = r19.getCommentType();
            if (r13 == 0) goto L37;
            if (r13 == 1) goto L36;
            tt5.a.k("Comment#PerfRecorder", "unknown commentType: " + r19.getCommentType());
            int r14 = 0;
        L57:
            int r20 = 0;
            int r21 = 0;
        L58:
            r17 = r17 + r14;
            if (Intrinsics.areEqual(r19.getCommentId(), r7) == false) goto L31;
            r18 = r14;
            r16 = r20;
            r9 = r21;
            goto L31
        L36:
            r14 = 1;
            goto L57
        L37:
            List<CommentBean.CommentDetail> r110 = r19.getCommentList();
            if (r110 == null) goto L40;
            r14 = r110.size();
        L41:
            List<CommentBean.CommentDetail> r111 = r19.getCommentList();
            if (r111 == null) goto L57;
            Iterator<T> r112 = r111.iterator();
            r20 = 0;
            r21 = 0;
        L45:
            if (r112.hasNext() == false) goto L58;
            CommentBean.CommentDetail r22 = (CommentBean.CommentDetail) r112.next();
            String r23 = r22.getContent();
            if (r23 == null) goto L49;
            int r24 = r23.length();
        L50:
            r20 = r20 + r24;
            CommentBean.CommentDetail.ExtraEntity r28 = r22.getExtra();
            if (r28 == null) goto L55;
            List r29 = r28.getImage_list();
            if (r29 == null) goto L55;
            int r210 = r29.size();
        L56:
            r21 = r21 + r210;
        L55:
            r210 = 0;
            goto L56
        L49:
            r24 = 0;
            goto L50
        L40:
            r14 = 0;
            goto L41
        L61:
            int r12 = r6;
            int r113 = r9;
            int r30 = r16;
        L63:
            ShowCardsJsData.StatsExtra r31 = r3.getStatsExtra();
            if (r31 == null) goto L66;
            long r114 = r31.clickTime;
        L68:
            if (r114 <= 0) goto L76;
            ShowCardsJsData.StatsExtra r32 = r3.getStatsExtra();
            if (r32 == null) goto L72;
            String r33 = r32.clickFrom;
        L74:
            if (TextUtils.isEmpty(r33) == true) goto L76;
            r10.d(r3.getStatsExtra().clickTime, r3.getStatsExtra().clickFrom);
            goto L76
        L72:
            r33 = null;
        L76:
            r10.c(r7, r18, r12, r17, r30, r113, r11);
            r10.e();
            goto L77
        L66:
            r114 = 0;
            goto L68
        L62:
            r12 = 0;
            r30 = 0;
            r113 = 0;
            r17 = 0;
            r18 = 0;
            goto L63
        L16:
            if (r3.getStatsExtra() == null) goto L77;
            if (TextUtils.isEmpty(r3.getStatsExtra().clickFrom) == true) goto L77;
            if (r3.getStatsExtra().clickTime <= 0) goto L77;
            if (r2.a() != null) goto L24;
        L77:
            Intrinsics.checkNotNullParameter(r3, "data");
            Intrinsics.checkNotNullParameter(r2, "config");
            af5.b r34 = r2.a();
            if (r34 == null) goto L138;
            com.bytedance.ee.bear.middleground.comment.performance.d r36 = r34.b();
            if (r36 == null) goto L138;
            if (r36.b() == false) goto L138;
            if (r3.getCards() == null) goto L138;
            Iterator<Card> r37 = r3.getCards().iterator();
        L89:
            if (r37.hasNext() == false) goto L138;
            Card r38 = r37.next();
            if (r38.getCommentType() != 0) goto L89;
            String r39 = r38.getCommentUUID();
            if (r39 != null) goto L95;
        L98:
            boolean r40 = true;
        L100:
            if (r40 == true) goto L115;
            if (r36.a(r38.getCommentUUID()) == false) goto L115;
            if (r38.getCommentList() == null) goto L115;
            if (r38.getCommentList().size() != 1) goto L115;
            CommentBean.CommentDetail r41 = (CommentBean.CommentDetail) ListProtector.get(r38.getCommentList(), 0);
            if (r41.isSending() == true) goto L113;
            if (r41.getError().isSuccess() == false) goto L113;
            r36.d(r38.getCommentUUID(), "success", null);
        L113:
            if (r41.getError().isSuccess() == true) goto L89;
            r36.d(r38.getCommentUUID(), "fail", String.valueOf(r41.getError().code));
        L115:
            List<CommentBean.CommentDetail> r42 = r38.getCommentList();
            if (r42 == null) goto L89;
            Iterator<T> r43 = r42.iterator();
        L119:
            if (r43.hasNext() == false) goto L89;
            CommentBean.CommentDetail r44 = (CommentBean.CommentDetail) r43.next();
            String r46 = r44.getReplyUUID();
            if (r46 != null) goto L123;
        L126:
            boolean r47 = true;
        L127:
            if (r47 == true) goto L119;
            if (r36.a(r44.getReplyUUID()) == false) goto L119;
            if (r44.isSending() == true) goto L136;
            if (r44.getError().isSuccess() == false) goto L136;
            r36.d(r44.getReplyUUID(), "success", null);
        L136:
            if (r44.getError().isSuccess() == true) goto L119;
            r36.d(r44.getReplyUUID(), "fail", String.valueOf(r44.getError().code));
            goto L119
        L123:
            if (r46.length() == 0) goto L126;
            r47 = false;
            goto L127
        L95:
            if (r39.length() == 0) goto L98;
            r40 = false;
        L138:
            Boolean r48 = w25.c.a;
            if (l35.k.b != 1) goto L141;
            boolean r49 = true;
        L142:
            BearUrl r50 = w25.c.e;
            if (r50 == null) goto L145;
            String r51 = r50.a;
        L146:
            sbb.e r52 = sbb.e.e(r51);
            BearUrl r53 = w25.c.e;
            if (r53 == null) goto L149;
            String r115 = r53.b;
        L151:
            if (TextUtils.equals(r115, r3.getToken()) == true) goto L153;
        L155:
            boolean r54 = false;
        L156:
            String r56 = w25.c.f;
            if (r56 != null) goto L159;
        L162:
            boolean r116 = true;
        L163:
            w25.c.f = r3.getToken();
            if (w25.c.c() == false) goto L175;
            if (r49 == false) goto L175;
            if (r116 == false) goto L175;
            if (r54 == false) goto L175;
            PreloadStrategy r57 = w25.c.b.getPreloadContent().get(FileUploadModel.FROM_COMMENT);
            if (r57 != null) goto L172;
        L176:
            ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).k("comment_view");
            com.bytedance.ee.bear.document.comment.d r58 = CommentPlugin.access$3900(this.a);
            boolean r59 = CommentPlugin.access$3500(this.a).comment;
            r58.getClass();
            r58.a(new t2(r59));
            return;
        L172:
            if (r57.isPreload() == false) goto L174;
            Flowable.just(Boolean.TRUE).subscribeOn(fo5.d.a()).subscribe(new w25.a(r3), w25.b.a);
            goto L176
        L174:
            tt5.a.h("PreloadNextPageExecutor", "startPreload comment, config isPreload: " + r57.isPreload());
        L175:
            tt5.a.h("PreloadNextPageExecutor", "startPreload comment, isFirstPage: " + r49 + "  isNotPreComment " + r116 + "  isDocx " + r54);
            goto L176
        L159:
            if (TextUtils.equals(r56, r3.getToken()) == false) goto L162;
            r116 = false;
            goto L163
        L153:
            if (r52 != sbb.e.o) goto L155;
            r54 = true;
            goto L156
        L149:
            r115 = null;
            goto L151
        L145:
            r51 = null;
            goto L146
        L141:
            r49 = false;
            goto L142
        }
    }

    public class h implements com.bytedance.ee.bear.middleground.comment.export.g {
        public final /* synthetic */ CommentPlugin a;

        public h(CommentPlugin r1) {
            this.a = r1;
        }
    }

    public class h0 implements tb5.i {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public h0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            tt5.a.h(CommentPlugin.TAG, "JS request show content reaction panel");
            CommentPlugin.access$6202(this.a, r3);
            CommentPlugin.access$6300(this.a, r3);
        }
    }

    public class i implements com.bytedance.ee.bear.middleground.comment.export.o {
        public final /* synthetic */ CommentPlugin a;

        public final void j0() {
        }

        public final boolean a() {
            return CommentPlugin.access$3500(this.a).resolve;
        }

        public final boolean b() {
            return CommentPlugin.access$3500(this.a).smartReplyPreview;
        }

        public final boolean c() {
            return CommentPlugin.access$3500(this.a).askSmartReply;
        }

        public final boolean d() {
            return CommentPlugin.access$3500(this.a).delete;
        }

        public final boolean e() {
            w05.i r0 = ((w05.b) this.a.getHostAbility(w05.b.class)).getDocumentInfoProvider();
            if (r0.g().getValue() == null) goto L10;
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
            if (jg5.e.a.a.g() == false) goto L7;
            int r1 = f35.b.a;
            boolean r2 = f35.b.a((DocumentInfo) r0.g().getValue(), "DOWNLOAD").getAllow();
        L8:
            tt5.a.h(CommentPlugin.TAG, "canDownload=" + r2);
            return r2;
        L7:
            r2 = ((DocumentInfo) r0.g().getValue()).getDocPermission().a.canDownload();
            goto L8
        L10:
            tt5.a.h(CommentPlugin.TAG, "DocumentInfoDta = null offline，canDownload=false");
            return false;
        }

        public final boolean f() {
            return CommentPlugin.access$3500(this.a).reviewRevision;
        }

        public final boolean g() {
            w05.i r0 = ((w05.b) this.a.getHostAbility(w05.b.class)).getDocumentInfoProvider();
            if (r0.g().getValue() == null) goto L6;
            int r1 = f35.b.a;
            Boolean r2 = Boolean.valueOf(f35.b.f((DocumentInfo) r0.g().getValue()));
            tt5.a.h(CommentPlugin.TAG, "canCopy=" + r2);
            return r2.booleanValue();
        L6:
            tt5.a.h(CommentPlugin.TAG, "DocumentInfoDta = null offline，canCopy=false");
            return false;
        }

        public final boolean getComment() {
            return CommentPlugin.access$3500(this.a).comment;
        }

        public final boolean h() {
            w05.i r0 = ((w05.b) this.a.getHostAbility(w05.b.class)).getDocumentInfoProvider();
            boolean r2 = false;
            if (r0.g().getValue() == null) goto L11;
            int r1 = f35.b.a;
            DocumentInfo r3 = (DocumentInfo) r0.g().getValue();
            Intrinsics.checkNotNullParameter(r3, "documentInfo");
            IDocUserPermission r4 = r3.getDocPermission().a;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            jg5.e r5 = jg5.e.a.a;
            if (com.bytedance.ee.bear.middleground.permission.b.a() == true) goto L7;
        L9:
            Boolean r6 = Boolean.valueOf(r2);
            tt5.a.h(CommentPlugin.TAG, "canEscape=" + r6);
            return r6.booleanValue();
        L7:
            if (r4.isCopyAuthByKp() == false) goto L9;
            r2 = true;
            goto L9
        L11:
            return false;
        }

        public i(CommentPlugin r1) {
            this.a = r1;
        }
    }

    public class i0 implements tb5.i<ReactionDetail> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public i0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r7, tb5.m r8) {
            final ReactionDetail r9 = (ReactionDetail) r7;
            tt5.a.h(CommentPlugin.TAG, "JS request show reaction detail, data = " + r9);
            com.bytedance.ee.bear.middleground.comment.uitls.s.a r10 = ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).c();
            List r0 = r9.getData();
            r10.getClass();
            List r11 = com.bytedance.ee.bear.middleground.comment.uitls.s.b(r0);
            Iterator r1 = ((ArrayList) r11).iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            ReactionDetailViewModel r2 = (ReactionDetailViewModel) r1.next();
            if (r2.getTotalCount() == r2.getUserInfoList().size()) goto L4;
            boolean r3 = false;
        L9:
            final ReactionPopupFacade r12 = ReactionPopupFacade.S90(r11, r9.getReactionKey(), false);
            r12.f = new m1(this);
            r12.i = new n1(this);
            FragmentManager r4 = CommentPlugin.access$5400(this.a).getSupportFragmentManager();
            LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, "REACTION_DETAIL", r5);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r12, r5) == false) goto L19;
        L14:
            if (r3 == true) goto L16;
            CommentPlugin.access$3000(this.a).Z0(CommentPlugin.access$3000(this.a).b().t(r9.getReferType(), 0, r9.getReferKey()).subscribe(new o1(r12, r9), new p1()));
        L16:
            CommentPlugin.access$3100(this.a).setDetailPanelStatus(1, r9.getReferType(), r9.getReferKey());
            CommentPlugin.access$3000(this.a).F0().b().q(r9.getReferKey());
            return;
        L19:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
        L13:
            r12.show(r4, "REACTION_DETAIL");
            goto L14
        L8:
            r3 = true;
            goto L9
        }
    }

    public class j implements com.bytedance.ee.bear.middleground.comment.export.v {
        public final /* synthetic */ CommentPlugin a;

        public final boolean a() {
            CommentPlugin r0 = this.a;
            return CommentPlugin.access$3700(r0, r0.getDocumentMetadata().isType(sbb.e.n));
        }

        public final boolean canEdit() {
            IDocUserPermission r0 = CommentPlugin.access$3800(this.a);
            if (r0 != null) goto L5;
            return false;
        L5:
            return r0.canEdit();
        }

        public final boolean isOwner() {
            return this.a.getDocumentMetadata().isOwner();
        }

        public j(CommentPlugin r1) {
            this.a = r1;
        }
    }

    public class j0 implements tb5.i<CommentInputRequest> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public j0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r7, tb5.m r8) {
            CommentInputRequest r9 = (CommentInputRequest) r7;
            tt5.a.h(CommentPlugin.TAG, "JS request show input");
            if (r9 != null) goto L6;
            return;
        L6:
            if (CommentPlugin.access$3000(this.a) == null) goto L35;
            r9.doc_url = this.a.getDocumentMetadata().getUrl();
            com.bytedance.ee.bear.middleground.comment.export.i r10 = CommentPlugin.access$3000(this.a).F0();
            int r0 = s2.a;
            Intrinsics.checkNotNullParameter(r9, "data");
            Intrinsics.checkNotNullParameter(r10, "config");
            af5.b r11 = r10.a();
            if (r11 == null) goto L35;
            com.bytedance.ee.bear.middleground.comment.performance.a r12 = r11.d();
            if (r12 == null) goto L35;
            if (r12.a() == false) goto L15;
        L21:
            CommentInputRequest.StatsExtra r1 = r9.getStatsExtra();
            if (r1 == null) goto L24;
            long r3 = r1.clickTime;
        L26:
            if (r3 <= 0) goto L34;
            CommentInputRequest.StatsExtra r2 = r9.getStatsExtra();
            if (r2 == null) goto L30;
            String r4 = r2.clickFrom;
        L32:
            if (TextUtils.isEmpty(r4) == true) goto L34;
            r12.c(r9.getStatsExtra().clickTime, "full_comment", "create", r9.getStatsExtra().clickFrom);
            goto L34
        L30:
            r4 = null;
        L34:
            r12.d();
            goto L35
        L24:
            r3 = 0;
            goto L26
        L15:
            if (r9.getStatsExtra() == null) goto L35;
            if (TextUtils.isEmpty(r9.getStatsExtra().clickFrom) == true) goto L35;
            if (r9.getStatsExtra().clickTime > 0) goto L21;
        L35:
            CommentBean.CommentDetail.ExtraEntity r13 = r9.extra;
            if (r13 == null) goto L38;
            r9.visibilityBean.setType(r13.getVisibility());
        L38:
            ((dn4.a) this.a.getHost().getUserComponent().a(dn4.a.class)).a();
            CommentPlugin.access$3100(this.a).updateCommentInputRequest(r9);
        }
    }

    public class k extends tb5.m.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ CommentPlugin b;

        @Override // tb5.m.a, tb5.m
        public final void a(NonProguard r2) {
            if ((r2 instanceof TipCallBackData) == true) goto L5;
            return;
        L5:
            if (TextUtils.equals(((TipCallBackData) r2).getId(), TipCallBackData.RESULT) == false) goto L9;
            CommentPlugin.access$3000(this.b).l().invoke(this.a);
            return;
        }

        public k(CommentPlugin r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class k0 implements tb5.i<ReactionAnimate> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public k0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            ReactionAnimate r5 = (ReactionAnimate) r3;
            tt5.a.h(CommentPlugin.TAG, "JS request show reaction animate, data = " + r5);
            if (r5 != null) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r5.getReactionKey()) == true) goto L17;
            CommentPlugin.access$5300(this.a);
            CommentPlugin r6 = this.a;
            if (r6.mReactionAnimatePanel != null) goto L11;
            r6.mReactionAnimatePanel = CommentPlugin.access$3000(r6).w0();
        L11:
            if (this.a.mReactionAnimatePanel.isShowing() == false) goto L13;
            tt5.a.h(CommentPlugin.TAG, "ShowReactionAnimateHandler showing reaction");
            return;
        L13:
            this.a.mReactionAnimatePanel.a(r5.getReactionKey());
            return;
        }
    }

    public static class l implements tb5.i<ClipboardData> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public l() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r7, tb5.m r8) {
            ClipboardData r9 = (ClipboardData) r7;
            tt5.a.h(CommentPlugin.TAG, "JS request set clipboard text, data = " + r9);
            if (r9 != null) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r9.getText()) == false) goto L18;
            return;
        L18:
            ClipData r3 = ClipData.newPlainText(null, r9.getText().replace("<doc.at.~#_%=`>", ""));     // Catch: Exception -> L14
            fu5.a r4 = (fu5.a) org.koin.java.a.a(fu5.a.class);     // Catch: Exception -> L14
            if (r4 == null) goto L12;
            r4.a(r9.getEncryptId());     // Catch: Exception -> L14
            if (r4.h(r3, new Token(CommentPlugin.GET_CLIPBOARD_TOKEN)) == false) goto L17;
            r8.a(new CopyResult(0));     // Catch: Exception -> L14
        L17:
            return;
        L12:
            r8.a(new CopyResult(1));     // Catch: Exception -> L14
        L14:
            e = move-exception;
            r8.a(new CopyResult(1));
            tt5.a.e(CommentPlugin.TAG, "ClipboardCopyHandler (): copy failed", e, false);
        }
    }

    public class l0 implements tb5.i<ReactionPanel> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public l0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r17, final tb5.m r18) {
            final ReactionPanel r2 = (ReactionPanel) r17;
            tt5.a.h(CommentPlugin.TAG, "JS request show reaction panel, data = " + r2);
            if (r2 != null) goto L5;
            return;
        L5:
            if (r2.getToolBar() != null) goto L7;
            return;
        L7:
            if (r2.getToolBar().isEmpty() == true) goto L67;
            PopupWindow r3 = this.a.mReaction;
            if (r3 != null) goto L12;
        L14:
            List<ReactionPanel.OperationItem> r4 = r2.getToolBar();
            final boolean r6 = "REACTION".equals(((ReactionPanel.OperationItem) ListProtector.get(r4, 0)).getId());
            if (r6 == false) goto L17;
            ListProtector.remove(r4, 0);
        L17:
            ArrayList r7 = new ArrayList();
            Iterator<ReactionPanel.OperationItem> r5 = r4.iterator();
        L19:
            if (r5.hasNext() == false) goto L44;
            ReactionPanel.OperationItem r8 = r5.next();
            int r9 = ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).c().a(r8.getId());
            if (r9 == (-1)) goto L22;
            if ("COPY".equals(r8.getId()) == false) goto L42;
            w05.i r10 = ((w05.b) this.a.getHostAbility(w05.b.class)).getDocumentInfoProvider();
            if (r10.g().getValue() == null) goto L27;
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
            if (jg5.e.a.a.g() == false) goto L34;
            int r11 = f35.b.a;
            if (f35.b.c((DocumentInfo) r10.g().getValue(), "CONTENT_COPY", BizDomain.FileBizDomainCCM).getAllow() == false) goto L32;
        L41:
            r7.add(new com.ss.android.lark.reaction.widget.panel.e(r8.getText(), r9, new u1(this, r18, r8)));
            goto L19
        L32:
            tt5.a.h(CommentPlugin.TAG, "validateResult no perm no copy button");
            goto L19
        L34:
            if (((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_CONTENT_COPY", FileBizDomain.FileBizDomainCCM, ((DocumentInfo) r10.g().getValue()).getType(), ((DocumentInfo) r10.g().getValue()).getObjToken()).a == true) goto L36;
        L38:
            boolean r12 = false;
        L39:
            if (r12 == true) goto L41;
            tt5.a.h(CommentPlugin.TAG, "validateResult no perm no copy button");
            goto L19
        L36:
            if (((DocumentInfo) r10.g().getValue()).canCopy() == false) goto L38;
            r12 = true;
            goto L39
        L27:
            tt5.a.h(CommentPlugin.TAG, "DocumentInfo == null no copy button");
            goto L19
        L42:
            r7.add(new com.ss.android.lark.reaction.widget.panel.e(r8.getText(), r9, new v1(this, r18, r8)));
            goto L19
        L22:
            tt5.a.d(CommentPlugin.TAG, "ShowOperationHandler: not Found tool resIcon");
            goto L19
        L44:
            final ReactionPanelFacade.a r13 = new ReactionPanelFacade.a(this.a.getHost().getUIContainer().getContentView());
            if (r7.isEmpty() == false) goto L47;
            r7 = null;
        L47:
            if (r7 == null) goto L49;
            ((ArrayList) r13.d).clear();
            ((ArrayList) r13.d).addAll(r7);
        L49:
            r13.c = r6;
            Flowable.just("").subscribeOn(fo5.d.b()).map(new q1()).map(new r1(this, r6, r13, r18)).observeOn(fo5.d.d()).subscribe(new s1(this, r13, r18, r2), new t1());
            return;
        L12:
            if (r3.isShowing() == false) goto L14;
            PopupWindow r14 = this.a.mReaction;
            PopupWindowLancet.handleDismissBeforeOrigin(r14);
            r14.dismiss();
            goto L14
        }
    }

    public class m implements tb5.i {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public m(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            tt5.a.h(CommentPlugin.TAG, "JS request close cards !");
            if (CommentPlugin.access$3000(this.a) == null) goto L5;
            CommentPlugin.access$3000(this.a).Q0(false, true);
            return;
        L5:
            tt5.a.d(CommentPlugin.TAG, "close Card but comment is null");
        }
    }

    public class m0 implements tb5.i<ShowToastJsData> {
        public final /* synthetic */ CommentPlugin a;

        public class a implements Consumer<String> {
            public final /* synthetic */ m0 a;

            public a(m0 r1) {
                this.a = r1;
            }

            public final void accept(Object r3) throws Exception {
                tt5.a.h(CommentPlugin.TAG, "retry success ");
                com.bytedance.ee.bear.middleground.comment.export.p r0 = CommentPlugin.access$3000(this.a.a).b();
                r0.w((String) r3, Action.PUBLISH);
            }
        }

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public m0(CommentPlugin r1) {
            this.a = r1;
        }

        public final void a(ShowToastJsData r4) {
            if (CommentPlugin.access$3000(this.a) != null) goto L6;
            tt5.a.d(CommentPlugin.TAG, "retry: mComment is null, cannot proceed with retry");
            return;
        L6:
            Toast.showLoading(CommentPlugin.access$5100(this.a), CommentPlugin.access$5200(this.a).getText(2131887121));
            if (CommentPlugin.access$4000(this.a) != null) goto L9;
        L13:
            CommentPlugin.access$3000(this.a).b().E(r4.getCommentUUID(), r4.getCommentType(), r4.getReplyUUID()).subscribe(new a(this), new g2(this));
            return;
        L9:
            if (CommentPlugin.access$4000(this.a).a() == null) goto L13;
            if (CommentPlugin.access$4000(this.a).a().b() == null) goto L13;
            CommentPlugin.access$4000(this.a).a().b().e(r4.getCommentUUID(), "create");
            goto L13
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r8, final tb5.m r9) {
            final ShowToastJsData r10 = (ShowToastJsData) r8;
            Toast.cancelLoading();
            if (r10 != null) goto L6;
            tt5.a.d(CommentPlugin.TAG, "JS request show toast , but no data !");
            return;
        L6:
            if (this.a.getDocumentMetadata().getDocumentTypeValue() == 8) goto L8;
        L12:
            tt5.a.h(CommentPlugin.TAG, "JS show  comment toast");
            if (CommentPlugin.access$4000(this.a) == null) goto L23;
            if (CommentPlugin.access$4000(this.a).a() == null) goto L23;
            if (CommentPlugin.access$4000(this.a).a().b() == null) goto L23;
            if (r10.isSuccess() == false) goto L21;
            CommentPlugin.access$4000(this.a).a().b().d(r10.getCommentUUID(), "success", null);
            goto L23
        L21:
            CommentPlugin.access$4000(this.a).a().b().d(r10.getCommentUUID(), "fail", r10.getCode() + "");
        L23:
            if (r10.isSuccess() == false) goto L34;
            FragmentActivity r0 = CommentPlugin.access$4300(this.a);
            Intrinsics.checkNotNullParameter(r0, "context");
            FlowToast.a r1 = FlowToast.a(r0);
            if (TextUtils.isEmpty(r10.getMessage()) == false) goto L27;
            String r5 = com.bytedance.ee.util.ui.n.x(CommentPlugin.access$4200(this.a), 2131887122);
        L28:
            Intrinsics.checkNotNullParameter(r5, "value");
            Intrinsics.checkNotNullParameter(r5, "value");
            r1.b = r5;
            if (TextUtils.isEmpty(r10.getButtonMessage()) == false) goto L31;
            String r11 = com.bytedance.ee.util.ui.n.x(CommentPlugin.access$4100(this.a), 2131887123);
        L32:
            UDToast.b r2 = new y1(r9);
            Intrinsics.checkNotNullParameter(r11, "text");
            Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
            com.larksuite.component.universe_design.toast.a r6 = new com.larksuite.component.universe_design.toast.a(r2);
            Intrinsics.checkNotNullParameter(r11, "text");
            Intrinsics.checkNotNullParameter(r6, JSEventListener.ACTION);
            r1.e = r11;
            r1.f = r6;
            r1.d = CommentPlugin.DURATION_4;
            r1.a().show();
            return;
        L31:
            r11 = r10.getButtonMessage();
            goto L32
        L27:
            r5 = r10.getMessage();
            goto L28
        L34:
            if (r10.isNoPermission() == false) goto L37;
            FragmentActivity r12 = CommentPlugin.access$4400(this.a);
            Intrinsics.checkNotNullParameter(r12, "context");
            FlowToast.a r13 = FlowToast.a(r12);
            r13.e(2131887324);
            UDToast.b r3 = new z1(this, r10);
            Intrinsics.checkNotNullParameter(r3, JSEventListener.ACTION);
            r13.b(2131887322, new com.larksuite.component.universe_design.toast.a(r3));
            r13.d = CommentPlugin.DURATION_4;
            r13.a().show();
            return;
        L37:
            if (r10.isReviewFail() == false) goto L40;
            FragmentActivity r14 = CommentPlugin.access$4500(this.a);
            Intrinsics.checkNotNullParameter(r14, "context");
            FlowToast.a r16 = FlowToast.a(r14);
            r16.e(2131887329);
            UDToast.b r4 = new a2(r9);
            Intrinsics.checkNotNullParameter(r4, JSEventListener.ACTION);
            r16.b(2131887123, new com.larksuite.component.universe_design.toast.a(r4));
            r16.d = CommentPlugin.DURATION_4;
            r16.a().show();
            return;
        L40:
            if (r10.isMultiGeoFail() == false) goto L43;
            FragmentActivity r17 = CommentPlugin.access$4600(this.a);
            Intrinsics.checkNotNullParameter(r17, "context");
            FlowToast.a r18 = FlowToast.a(r17);
            r18.e(2131887325);
            UDToast.b r7 = new b2(this, r10);
            Intrinsics.checkNotNullParameter(r7, JSEventListener.ACTION);
            r18.b(2131887322, new com.larksuite.component.universe_design.toast.a(r7));
            r18.d = CommentPlugin.DURATION_4;
            r18.a().show();
            return;
        L43:
            if (r10.isMultiGeoPrepare() == false) goto L46;
            FragmentActivity r19 = CommentPlugin.access$4700(this.a);
            Intrinsics.checkNotNullParameter(r19, "context");
            FlowToast.a r20 = FlowToast.a(r19);
            r20.e(2131887326);
            UDToast.b r21 = new c2(this, r10);
            Intrinsics.checkNotNullParameter(r21, JSEventListener.ACTION);
            r20.b(2131887322, new com.larksuite.component.universe_design.toast.a(r21));
            r20.d = CommentPlugin.DURATION_4;
            r20.a().show();
            return;
        L46:
            if (r10.isBanFail() == false) goto L49;
            FragmentActivity r22 = CommentPlugin.access$4800(this.a);
            Intrinsics.checkNotNullParameter(r22, "context");
            FlowToast.a r23 = FlowToast.a(r22);
            r23.e(2131889734);
            UDToast.b r24 = new d2(this, r10);
            Intrinsics.checkNotNullParameter(r24, JSEventListener.ACTION);
            r23.b(2131887322, new com.larksuite.component.universe_design.toast.a(r24));
            r23.d = CommentPlugin.DURATION_4;
            r23.a().show();
            return;
        L49:
            if (r10.isCommentQuantityLimit() == false) goto L52;
            FragmentActivity r26 = CommentPlugin.access$4900(this.a);
            Intrinsics.checkNotNullParameter(r26, "context");
            FlowToast.a r27 = FlowToast.a(r26);
            r27.e(2131888894);
            UDToast.b r28 = new e2(this, r10);
            Intrinsics.checkNotNullParameter(r28, JSEventListener.ACTION);
            r27.b(2131887322, new com.larksuite.component.universe_design.toast.a(r28));
            r27.d = CommentPlugin.DURATION_4;
            r27.a().show();
            return;
        L52:
            if (r10.isCancelLoading() == false) goto L55;
            return;
        L55:
            if (r10.getCommentType() != 2) goto L57;
            int r29 = 2131889499;
        L58:
            FragmentActivity r30 = CommentPlugin.access$5000(this.a);
            Intrinsics.checkNotNullParameter(r30, "context");
            FlowToast.a r31 = FlowToast.a(r30);
            r31.e(r29);
            UDToast.b r32 = new f2(this, r10);
            Intrinsics.checkNotNullParameter(r32, JSEventListener.ACTION);
            r31.b(2131887322, new com.larksuite.component.universe_design.toast.a(r32));
            r31.d = CommentPlugin.DURATION_4;
            r31.a().show();
            return;
        L57:
            r29 = 2131887328;
            goto L58
        L8:
            if (CommentPlugin.access$3000(this.a).O(false) == false) goto L12;
            if (r10.isSuccess() == false) goto L12;
        }
    }

    public class n implements tb5.i {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public n(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            tt5.a.h(CommentPlugin.TAG, "JS request close content reaction panel");
            if (CommentPlugin.access$6400(this.a) != null) goto L5;
            return;
        L5:
            if (CommentPlugin.access$6400(this.a).isShowing() == false) goto L9;
            PopupWindow r3 = CommentPlugin.access$6400(this.a);
            PopupWindowLancet.handleDismissBeforeOrigin(r3);
            r3.dismiss();
            return;
        }
    }

    public class n0 implements tb5.i<SwitchCardBean> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public n0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            SwitchCardBean r4 = (SwitchCardBean) r2;
            tt5.a.h(CommentPlugin.TAG, "JS request switch card, data = " + r4);
            if (r4 != null) goto L6;
            return;
        L6:
            if (CommentPlugin.access$3000(this.a) == null) goto L8;
            CommentPlugin.access$3000(this.a).d1().invoke(r4.getCommentId());
            return;
        L8:
            tt5.a.d(CommentPlugin.TAG, "can not switch card, mComment is null!");
        }
    }

    public class o implements tb5.i {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public o(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            tt5.a.h(CommentPlugin.TAG, "JS request close reaction panel");
            PopupWindow r3 = this.a.mReaction;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.isShowing() == false) goto L9;
            PopupWindow r4 = this.a.mReaction;
            PopupWindowLancet.handleDismissBeforeOrigin(r4);
            r4.dismiss();
            return;
        }
    }

    public class o0 implements tb5.i<SyncReactionResultJsData> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public o0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            SyncReactionResultJsData r5 = (SyncReactionResultJsData) r3;
            if (r5 != null) goto L5;
            tt5.a.d(CommentPlugin.TAG, "JS request sync reaction result , but no data !");
            return;
        L5:
            tt5.a.h(CommentPlugin.TAG, "JS request sync reaction result, data = " + r5);
            if (r5.getCommentId() != null) goto L8;
        L15:
            tt5.a.d(CommentPlugin.TAG, "JS request sync reaction result, but no commentId or replyId or reactionKey or actionId!");
            return;
        L8:
            if (r5.getReplyId() == null) goto L15;
            if (r5.getReactionKey() == null) goto L15;
            if (r5.getActionId() == null) goto L15;
            CommentPlugin.access$3000(this.a).a0(r5);
        }
    }

    public class p implements tb5.i<String> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public p(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            String r5 = (String) r3;
            if (r5 != null) goto L5;
            tt5.a.k(CommentPlugin.TAG, "data is null");
            return;
        L5:
            tt5.a.h(CommentPlugin.TAG, "CommentForwardCallback handler");
            String r6 = new org.json.JSONObject(r5).optString("forwardId");     // Catch: Exception -> L8
            CommentPlugin.access$7300(this.a, r6, true);     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            tt5.a.f(CommentPlugin.TAG, e, false);
        }
    }

    public class p0 implements tb5.i<TranslateConfig> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public p0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            TranslateConfig r4 = (TranslateConfig) r2;
            tt5.a.h(CommentPlugin.TAG, "JS set translate config:" + r4);
            CommentPlugin.access$3100(this.a).getTranslateConfig().setValue(r4);
        }
    }

    public class q implements com.bytedance.ee.bear.middleground.comment.export.m {
        public final /* synthetic */ CommentPlugin a;

        public final void c() {
            w05.i r0 = ((w05.b) this.a.getHostAbility(w05.b.class)).getDocumentInfoProvider();
            DocumentPluginHost r1 = (DocumentPluginHost) this.a.getHost();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.g() != null) goto L7;
            return;
        L7:
            if (r0.g().getValue() != null) goto L9;
            return;
        L9:
            if (r1.a() != null) goto L11;
        L13:
            String r2 = "";
        L14:
            String r7 = r2;
            ((cj5.c) org.koin.java.a.a(cj5.c.class)).r3(CommentPlugin.access$7600(this.a), this.a.getDocumentMetadata().getToken(), this.a.getDocumentMetadata().getDocumentTypeValue(), ((DocumentInfo) r0.g().getValue()).getDocMetaInfo(), r7, "from_banner");
            return;
        L11:
            if (r1.a().getWikiInfo() == null) goto L13;
            r2 = r1.a().getWikiInfo().getWikiToken();
            goto L14
        }

        public final boolean d() {
            DocumentPluginHost r0 = (DocumentPluginHost) this.a.getHost();
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.a() != null) goto L8;
            return false;
        L8:
            if (r0.a().liveDocumentInfoData() != null) goto L10;
            return false;
        L10:
            if (r0.a().liveDocumentInfoData().getValue() == null) goto L21;
            DocumentInfo r1 = (DocumentInfo) r0.a().liveDocumentInfoData().getValue();
            Boolean r2 = Boolean.valueOf(r1.getDocPermission().a.canModifySecretLevel());
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
            if (jg5.e.a.a.g() == false) goto L15;
            int r3 = f35.b.a;
            r2 = Boolean.valueOf(f35.b.c(r1, "SECRET_MODIFY", BizDomain.FileBizDomainCCM).getAllow());
        L15:
            if (r2.booleanValue() == true) goto L17;
            return false;
        L17:
            return fj5.a.e(((DocumentInfo) r0.a().liveDocumentInfoData().getValue()).getDocMetaInfo());
        L21:
            return false;
        }

        public final boolean a() {
            if (d() == false) goto L6;
            Context r0 = CommentPlugin.access$7500(this.a);
            Intrinsics.checkNotNullParameter(r0, "context");
            FlowToast.a r1 = FlowToast.a(r0);
            r1.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r0, 2131256189));
            r1.e(2131889918);
            UDToast.b r2 = new i1(this);
            Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
            r1.b(2131889947, new com.larksuite.component.universe_design.toast.a(r2));
            r1.a().show();
            return false;
        L6:
            return true;
        }

        public final boolean b() {
            if (d() == false) goto L6;
            Context r0 = CommentPlugin.access$7400(this.a);
            Intrinsics.checkNotNullParameter(r0, "context");
            FlowToast.a r1 = FlowToast.a(r0);
            r1.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r0, 2131256189));
            r1.e(2131889918);
            UDToast.b r2 = new h1(this);
            Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
            r1.b(2131889947, new com.larksuite.component.universe_design.toast.a(r2));
            r1.a().show();
            return false;
        L6:
            return true;
        }

        public q(CommentPlugin r1) {
            this.a = r1;
        }
    }

    public class q0 implements tb5.i<UpdateReaction> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public q0() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            final UpdateReaction r5 = (UpdateReaction) r3;
            tt5.a.h(CommentPlugin.TAG, "JS request update order, data = " + r5);
            Flowable.just("").subscribeOn(fo5.d.b()).map(new h2()).map(new i2(this, r5)).subscribe(new j2(r5), new k2(r5));
        }
    }

    public class r implements tb5.i<FocusInputBean> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public r(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            FocusInputBean r4 = (FocusInputBean) r2;
            tt5.a.h(CommentPlugin.TAG, "JS request FocusInput: " + r4);
            if (r4 == null) goto L7;
            CommentPlugin.access$3100(this.a).updateFocusInputBean(r4);
            return;
        }
    }

    public class r0 implements tb5.i<String> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public r0(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            String r5 = (String) r3;
            JSONObject r6 = new JSONObject();
            r6.put("isCardShow", Boolean.valueOf(CommentPlugin.access$5300(this.a).i()));
            tt5.a.h(CommentPlugin.TAG, "JS request get card status, callback data = " + r6);
            r4.b(r6);
        }
    }

    public class s implements tb5.h {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.h, tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
        }

        public s(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.h, tb5.i, tb5.o
        public final void handle(Object r4, tb5.m r5) {
            JSONObject r6 = new JSONObject();
            r6.put("smart_compose_enabled", Boolean.valueOf(((com.bytedance.ee.bear.lark.dependency.t) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.t.class)).isDocSmartComposeEnabled()));
            FragmentActivity r0 = CommentPlugin.access$5500(this.a);
            if (Build.VERSION.SDK_INT < 24) goto L8;
            if (r0 == null) goto L8;
            if (yo5.a.a(r0) == false) goto L8;
            r6.put("comment_bubble_right_margin", 16);
            r6.put("safe_right_margin", 16);
        L8:
            tt5.a.h(CommentPlugin.TAG, "JS request get setting, callback data = " + r6);
            r5.b(r6);
        }
    }

    public class t implements tb5.i<ShowCardsJsData> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public t(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            ShowCardsJsData r3 = (ShowCardsJsData) r1;
            tt5.a.h(CommentPlugin.TAG, "JS request hide input");
            CommentPlugin.access$3100(this.a).updateCommentInputRequest(null);
        }
    }

    public class u implements tb5.i<SmartReplyDataForInsert> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public u(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            final SmartReplyDataForInsert r5 = (SmartReplyDataForInsert) r3;
            if (r5 != null) goto L5;
            tt5.a.d(CommentPlugin.TAG, "JS request insert to reply , but no data !");
            return;
        L5:
            tt5.a.h(CommentPlugin.TAG, "JS request insert to reply, data = " + du5.b.k(r5.toString()));
            if (CommentPlugin.access$3000(this.a) != null) goto L8;
            tt5.a.d(CommentPlugin.TAG, "insert to reply but comment is null");
            return;
        L8:
            m05.c.a(r5.getText(), new j1(this, r5), new k1(this, r5));
        }
    }

    public class v implements tb5.i<CommentBottomPopupData> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public v(CommentPlugin r1) {
            this.a = r1;
        }

        public static JSONObject a(v r1, int r2) {
            r1.getClass();
            tt5.a.h(CommentPlugin.TAG, "InviteNoPermissionUserHandler code = " + r2);
            JSONObject r3 = new JSONObject();
            r3.put(TipCallBackData.RESULT, Integer.valueOf(r2));
            return r3;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            tt5.a.h(CommentPlugin.TAG, "InviteNoPermissionUserHandler handle");
            Function2 r0 = CommentPlugin.access$3000(this.a).x0();
            r0.invoke((CommentBottomPopupData) r3, new l1(this, r4));
        }
    }

    public class w implements tb5.i<JSEventListener> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public w(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            JSEventListener r4 = (JSEventListener) r2;
            tt5.a.h(CommentPlugin.TAG, "JS request add common listener, callback = " + r3);
            CommentPlugin.access$6502(this.a, r3);
            CommentPlugin.access$3000(this.a).G0(r3);
            if (CommentPlugin.access$6600(this.a) == null) goto L6;
            CommentPlugin r5 = this.a;
            r5.onCommentStyleChange(CommentPlugin.access$6600(r5));
            return;
        }
    }

    public class x implements tb5.i<CommentJsRequestBean> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public x(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r9, tb5.m r10) {
            CommentJsRequestBean r11 = (CommentJsRequestBean) r9;
            if (r11 != null) goto L5;
        L58:
            tt5.a.d(CommentPlugin.TAG, "JS request native action, data is null!");
            return;
        L5:
            if (TextUtils.isEmpty(r11.getAction()) == true) goto L58;
            tt5.a.h(CommentPlugin.TAG, "JS request native action, action = " + r11.getAction());
            CommentPlugin.access$5300(this.a);
            String r0 = r11.getAction();
            r0.getClass();
            switch(r0.hashCode()) {
                case -1072854300: goto L27;
                case -961740095: goto L23;
                case 114381373: goto L19;
                case 1052832078: goto L15;
                case 1782367593: goto L11;
                default: goto L30;
            };
        L30:
            byte r1 = -1;
        L31:
            if (r1 == 0) goto L55;
            if (r1 != 1) goto L34;
            CommentPlugin.access$3000(this.a).b().v(new CommentMetadata[0]);
            return;
        L34:
            if (r1 == 2) goto L53;
            if (r1 == 3) goto L52;
            if (r1 != 4) goto L70;
            com.bytedance.ee.bear.appsetting.c r2 = com.bytedance.ee.bear.appsetting.c.a.a;
            if (r2.g("ccm.mention.optimizing_authorizaiton_v2") == true) goto L41;
        L51:
            tt5.a.h(CommentPlugin.TAG, "JS request native action, fg is false");
            return;
        L41:
            if (r2.g("ccm.mention.optimizing_authorizaiton") == false) goto L51;
            ArrayList r3 = new ArrayList();     // Catch: Exception -> L49
            JSONArray r12 = new org.json.JSONObject(r11.getOptions()).optJSONArray("userIds");     // Catch: Exception -> L49
            int r4 = 0;
        L45:
            if (r4 >= r12.length()) goto L47;
            r3.add(JSONArrayProtectorUtils.getString(r12, r4));     // Catch: Exception -> L49
            r4 = r4 + 1;     // Catch: Exception -> L49
            goto L45
        L47:
            CommentPlugin.access$3000(this.a).j(r3);     // Catch: Exception -> L49
            return;
        L49:
            e = move-exception;
            tt5.a.f(CommentPlugin.TAG, e, false);
            return;
        L70:
            return;
        L52:
            this.a.translate("", "", 0);
            return;
        L53:
            CommentPlugin.access$3000(this.a).b().m("", false);
            return;
        L55:
            String r13 = r11.getToken();
            if (CommentJsRequestBean.ACTION_BEGIN_SNYC.equals(r11.getOptions()) == false) goto L68;
            CommentPlugin.access$3000(this.a).b().x(r13);
            return;
        L68:
            return;
        L11:
            if (r0.equals(CommentJsRequestBean.ACTION_MENTION_USER_PERMISION_CHANGE) == false) goto L30;
            r1 = 4;
            goto L31
        L15:
            if (r0.equals("translate") == false) goto L30;
            r1 = 3;
            goto L31
        L19:
            if (r0.equals(CommentJsRequestBean.ACTION_SET_TRANSLATE_ENABLE_LANG) == false) goto L30;
            r1 = 2;
            goto L31
        L23:
            if (r0.equals(CommentJsRequestBean.ACTION_ADD_TRANSLATE_COMMENTS) == false) goto L30;
            r1 = 1;
            goto L31
        L27:
            if (r0.equals(CommentJsRequestBean.ACTION_BEGIN_SNYC) == false) goto L30;
            r1 = 0;
            goto L31
        }
    }

    public class y implements tb5.i<OpenCommentImageModel> {
        public final /* synthetic */ CommentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public y(CommentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r8, tb5.m r9) {
            OpenCommentImageModel r10 = (OpenCommentImageModel) r8;
            tt5.a.h(CommentPlugin.TAG, "JS request open comment image viewer, data = " + r10);
            if (r10 != null) goto L6;
            tt5.a.d(CommentPlugin.TAG, "OpenCommentImageViewerHandler() data is null");
            return;
        L6:
            if (OpenCommentImageModel.isActive(r10) == true) goto L8;
            this.a.closeCommentImageViewer();
            return;
        L8:
            ArrayList r3 = new ArrayList(r10.getImageList().size());
            Iterator<OpenCommentImageModel.CommentImageBean> r11 = r10.getImageList().iterator();
        L10:
            if (r11.hasNext() == false) goto L16;
            OpenCommentImageModel.CommentImageBean r1 = r11.next();
            if (r1 == null) goto L10;
            CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r2 = new CommentBean.CommentDetail.ExtraEntity.CommentImageEntity();
            r2.setSrc(r1.getSrc());
            r2.setOriginalSrc(r1.getOriginalSrc());
            r2.setUuid(r1.getToken());
            r2.setAreaMark(r1.getAreaMark());
            r3.add(r2);
            goto L10
        L16:
            if (r10.getPermission() == null) goto L18;
            CommentPlugin.access$3502(this.a, r10.getPermission());
            tt5.a.h(CommentPlugin.TAG, "JS request open comment image viewer, permission = " + CommentPlugin.access$3500(this.a));
        L18:
            String r4 = "";
            if (r10.getCommentId() != null) goto L21;
            String r12 = "";
        L23:
            if (r10.getReplyId() == null) goto L26;
            r4 = r10.getReplyId();
        L26:
            String r5 = r4;
            l05.a r6 = l05.a.a;
            Card r7 = r10.getComment();
            Per r13 = CommentPlugin.access$3500(this.a);
            r6.getClass();
            if (r7 != null) goto L29;
            tt5.a.k("Js2NativeComment", "singleCard2CommentBean card is null");
        L31:
            CommentBean r14 = null;
        L33:
            CommentBean r16 = r14;
            if (CommentPlugin.access$3000(this.a) == null) goto L36;
            CommentPlugin.access$3000(this.a).i8(r12, r5, r3, r10.getActive(), r16, CommentImageShowSource.WEB);
            return;
        L36:
            tt5.a.d(CommentPlugin.TAG, "OpenCommentImageViewerHandler()... mComment is null");
            return;
        L29:
            if (r13 != null) goto L32;
            tt5.a.k("Js2NativeComment", "singleCard2CommentBean per is null");
            goto L31
        L32:
            r14 = l05.a.a(r7, r13);
            goto L33
        L21:
            r12 = r10.getCommentId();
            goto L23
        }
    }

    public class z implements tb5.i<Entity> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public z() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            Entity r3 = (Entity) r1;
            tt5.a.d("Sss", "sss");
        }
    }

    public static /* synthetic */ Unit A(CommentPlugin r1, Boolean r2) {
        return r1.lambda$getNewCardComment$18(r2);
    }

    public static /* synthetic */ void B(CommentPlugin r1, com.bytedance.ee.bear.middleground.comment.export.j r2, TranslateConfig r3) {
        r1.lambda$setConfig$39(r2, r3);
    }

    public static /* synthetic */ Unit C(CommentPlugin r1, String r2, Action r3) {
        return r1.lambda$onAttachToUIContainer$8(r2, r3);
    }

    public static /* synthetic */ void D(CommentPlugin r1) {
        r1.onFeedJumpToComment();
    }

    public static /* synthetic */ Unit E(CommentPlugin r1, Integer r2, Boolean r3) {
        return r1.lambda$getNewCardComment$30(r2, r3);
    }

    public static /* synthetic */ void G(CommentPlugin r1, CommentInputRequest r2) {
        r1.lambda$onAttachToHost$0(r2);
    }

    public static /* synthetic */ Unit H(CommentPlugin r1, String r2, List r3, Boolean r4, String r5) {
        return r1.lambda$getNewCardComment$13(r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit I(CommentPlugin r1, Boolean r2) {
        return r1.lambda$getNewCardComment$27(r2);
    }

    public static /* synthetic */ Unit J(CommentPlugin r1, Boolean r2) {
        return r1.lambda$getNewCardComment$14(r2);
    }

    public static /* synthetic */ Unit K(CommentPlugin r1, Boolean r2) {
        return r1.lambda$getNewCardComment$23(r2);
    }

    public static /* synthetic */ void M(CommentPlugin r1, Boolean r2) {
        r1.lambda$onAttachToHost$3(r2);
    }

    public static /* synthetic */ Unit N(CommentPlugin r1) {
        return r1.lambda$getNewCardComment$26();
    }

    public static /* synthetic */ Unit O(CommentPlugin r1) {
        return r1.lambda$getNewCardComment$33();
    }

    public static /* synthetic */ Unit P(CommentPlugin r1, String r2, CommentInputRequest r3, Boolean r4) {
        return r1.lambda$getNewCardComment$38(r2, r3, r4);
    }

    public static /* synthetic */ void Q(CommentPlugin r1, String r2) {
        r1.onBlockMenuClick(r2);
    }

    public static /* synthetic */ Unit R(CommentPlugin r1, String r2) {
        return r1.lambda$getNewCardComment$35(r2);
    }

    public static /* synthetic */ void T(CommentPlugin r1, String r2, int r3, String r4, float r5) {
        r1.notifyScrollToWeb(r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit U(CommentPlugin r1, String r2, float[] r3, Matrix r4) {
        return r1.lambda$getCommentBuilder$12(r2, r3, r4);
    }

    public static /* synthetic */ Unit V(CommentPlugin r1, Integer r2) {
        return r1.lambda$getNewCardComment$17(r2);
    }

    public static /* synthetic */ Boolean W(CommentPlugin r1) {
        return r1.lambda$getNewCardComment$22();
    }

    public static /* synthetic */ Unit X(CommentPlugin r1, Boolean r2) {
        return r1.lambda$getNewCardComment$28(r2);
    }

    public static /* synthetic */ Unit Y(CommentPlugin r1, Boolean r2) {
        return r1.lambda$getNewCardComment$24(r2);
    }

    public static /* synthetic */ Boolean Z(CommentPlugin r1, String r2) {
        return r1.lambda$getNewCardComment$34(r2);
    }

    public static /* synthetic */ void a(CommentPlugin r1, String r2) {
        r1.lambda$onAttachToHost$4(r2);
    }

    public static /* synthetic */ void a0(CommentPlugin r1, sy4.b r2) {
        r1.onFollowStateChange(r2);
    }

    public static /* synthetic */ Unit c(CommentPlugin r1, List r2) {
        return r1.lambda$getCommentBuilder$11(r2);
    }

    public static /* synthetic */ Unit d(CommentPlugin r1, String r2) {
        return r1.lambda$getNewCardComment$31(r2);
    }

    public static /* synthetic */ void e(CommentPlugin r1, String r2) {
        r1.onBubbleMenuClick(r2);
    }

    public static /* synthetic */ Unit f(CommentPlugin r1, String r2, Integer r3, String r4, Integer r5) {
        return r1.lambda$getNewCardComment$19(r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit g(CommentPlugin r1, Integer r2, Boolean r3) {
        return r1.lambda$getNewCardComment$29(r2, r3);
    }

    public static /* synthetic */ void h(CommentPlugin r1, DocumentInfo r2) {
        r1.lambda$onAttachToHost$7(r2);
    }

    public static /* synthetic */ Unit i(CommentPlugin r1, String r2, String r3) {
        return r1.lambda$getNewCardComment$32(r2, r3);
    }

    public static /* synthetic */ void j(CommentPlugin r1, String r2) {
        r1.lambda$translate$40(r2);
    }

    public static /* synthetic */ void k(CommentPlugin r1, FocusInputBean r2) {
        r1.lambda$onAttachToHost$2(r2);
    }

    public static /* synthetic */ Unit l(CommentPlugin r1, CommentInputRequest r2) {
        return r1.lambda$getNewCardComment$21(r2);
    }

    public static /* synthetic */ Unit m(CommentPlugin r1, String r2) {
        return r1.lambda$getNewCardComment$36(r2);
    }

    public static /* synthetic */ void n(CommentPlugin r1) {
        r1.lambda$onConfigurationChanged$9();
    }

    public static /* synthetic */ Unit o(CommentPlugin r1, String r2, Map r3) {
        return r1.lambda$getNewCardComment$37(r2, r3);
    }

    public static /* synthetic */ void p(CommentPlugin r1, List r2) {
        r1.lambda$onAttachToHost$5(r2);
    }

    public static /* synthetic */ void q(Throwable r1) {
        lambda$translate$41(r1);
    }

    public static /* synthetic */ Unit r(CommentPlugin r1, Boolean r2) {
        return r1.lambda$getNewCardComment$15(r2);
    }

    public static /* synthetic */ Unit s(CommentPlugin r1, String r2) {
        return r1.lambda$getNewCardComment$20(r2);
    }

    public static /* synthetic */ void t(CommentPlugin r1, ShowCardsJsData r2) {
        r1.lambda$onAttachToHost$1(r2);
    }

    public static /* synthetic */ Unit u(CommentPlugin r1, Integer r2) {
        return r1.lambda$getNewCardComment$25(r2);
    }

    public static /* synthetic */ void v(CommentPlugin r1, AuthorsPlugin r2) {
        r1.lambda$onAttachToHost$6(r2);
    }

    public static /* synthetic */ boolean x(CommentPlugin r1, View r2, MotionEvent r3) {
        return r1.lambda$initAsideContainer$10(r2, r3);
    }

    public static /* synthetic */ Unit z(CommentPlugin r1, String r2, String r3, Integer r4, Integer r5) {
        return r1.lambda$getNewCardComment$16(r2, r3, r4, r5);
    }

    public boolean isInputShowing() {
        return commentShow(true);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private boolean commentShow() {
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.O(false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private void destroy() {
        if (this.forceOrientationRequestCount <= 0) goto L7;
        CommentPanelViewModel r1 = this.commentViewModel;
        if (r1 == null) goto L7;
        handleOrientationWhenExit(r1.getForceOrientationRequestHandler());
        this.forceOrientationRequestCount = 0;
    L7:
        com.bytedance.ee.bear.middleground.comment.export.h r2 = this.mComment;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.O(false) == false) goto L12;
        this.mComment.Q0(false, true);
    L12:
        this.mComment.destroy(true);
        this.mComment = null;
    }

    private com.bytedance.ee.bear.middleground.comment.export.k getCommentHostConfigDelegate() {
        com.bytedance.ee.bear.middleground.comment.export.k r1 = this.commentHostConfigDelegate;
        if (r1 == null) goto L5;
        return r1;
    L5:
        ew4.z r2 = ew4.b.a(getHost());
        int r3 = com.bytedance.ee.bear.middleground.comment.export.d.a;
        Intrinsics.checkNotNullParameter(r2, "config");
        CommentHostDelegateUtils.from.1 r4 = new CommentHostDelegateUtils.from.1(r2);
        this.commentHostConfigDelegate = r4;
        return r4;
    }

    private com.bytedance.ee.bear.middleground.comment.export.bean.a getEnterAnimatorInFeed() {
        return new com.bytedance.ee.bear.middleground.comment.export.bean.a(com.bytedance.ee.util.ui.n.v(), 0.0f, false, true, true, new e(this));
    }

    private com.bytedance.ee.bear.middleground.comment.export.bean.a getExitAnimatorInFeed() {
        return new com.bytedance.ee.bear.middleground.comment.export.bean.a(0.0f, com.bytedance.ee.util.ui.n.v(), true, false, false, new f(this));
    }

    private com.bytedance.ee.bear.middleground.comment.export.h getNewCardComment() {
        if (this.mComment != null) goto L28;
        ShowCardsJsData r1 = (ShowCardsJsData) this.commentViewModel.getCommentCardsRequest().getValue();
        if (this.areaCommentReadEnable == false) goto L10;
        if (r1 == null) goto L10;
        if (r1.isInPicture() == false) goto L10;
        boolean r2 = true;
    L12:
        if (supportAsideComment() == false) goto L14;
    L17:
        tt5.a.h(TAG, "createMultiStyleComment...");
        this.mComment = ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).d(getCommentBuilder(r2));
    L18:
        com.bytedance.ee.bear.document.comment.d r3 = this.commentEventDispatcher;
        com.bytedance.ee.bear.middleground.comment.export.h r4 = this.mComment;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, FileUploadModel.FROM_COMMENT);
        r3.a = r4;
        setConfig();
        this.mComment.f().add(new com.bytedance.ee.bear.document.comment.l(this));
        this.mComment.o1(new com.bytedance.ee.bear.document.comment.n(this));
        this.mComment.u1(new com.bytedance.ee.bear.document.comment.s(this));
        this.mComment.b1(new com.bytedance.ee.bear.document.comment.t(this));
        this.mComment.t(new com.bytedance.ee.bear.document.comment.u(this));
        this.mComment.A0(new com.bytedance.ee.bear.document.comment.v(this));
        this.mComment.z(new com.bytedance.ee.bear.document.comment.x(this));
        this.mComment.H0(new com.bytedance.ee.bear.document.comment.y(this));
        this.mComment.U(new com.bytedance.ee.bear.document.comment.z(this));
        this.mComment.e1(new com.bytedance.ee.bear.document.comment.a0(this));
        this.mComment.y(new com.bytedance.ee.bear.document.comment.w(this));
        this.mComment.D(new com.bytedance.ee.bear.document.comment.h0(this));
        this.mComment.y0(new s0(this));
        this.mComment.r0(new b1(this));
        this.mComment.t0(new c1(this));
        this.mComment.q0(new d1(this));
        this.mComment.a().add(new e1(this));
        this.mComment.c().add(new f1(this));
        this.mComment.h1(new g1(this));
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mention.optimizing_authorizaiton") == true) goto L21;
        this.mComment.g0(new com.bytedance.ee.bear.document.comment.m(this));
    L21:
        this.mComment.G(new com.bytedance.ee.bear.document.comment.o(this));
        this.mComment.M(new com.bytedance.ee.bear.document.comment.p(this));
        this.mComment.C0(new com.bytedance.ee.bear.document.comment.q(this));
        this.mComment.j1(new com.bytedance.ee.bear.document.comment.r(this));
        tb5.m r5 = this.mListenerCb;
        if (r5 == null) goto L25;
        this.mComment.G0(r5);
    L25:
        if (this.commentViewModel.getCopyUrlTemplate() == null) goto L28;
        this.mComment.m1(this.commentViewModel.getCopyUrlTemplate());
        goto L28
    L14:
        if (this.asideCommentV2 == true) goto L17;
        this.mComment = ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).g(getCommentBuilder(r2));
    L10:
        r2 = false;
    L28:
        return this.mComment;
    }

    private String getTargetLanguage() {
        TranslateLanguageSetting r1 = (TranslateLanguageSetting) LarkKVStorage.p(new com.ss.android.lark.storage.a("ccm"), "translate", true).getJSONObject("config", TranslateLanguageSetting.class);
        if (r1 != null) goto L5;
        return "";
    L5:
        return r1.getTargetLanguageKey();
    }

    private IDocUserPermission getUserPermission() {
        DocumentInfo r1 = (DocumentInfo) ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider().g().getValue();
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.getDocPermission().a;
    }

    private boolean isFromFeed() {
        CommentPanelViewModel r1 = this.commentViewModel;
        if (r1 != null) goto L5;
        return false;
    L5:
        ShowCardsJsData r2 = (ShowCardsJsData) r1.getCommentCardsRequest().getValue();
        if (r2 != null) goto L8;
        return false;
    L8:
        if ("feed".equals(r2.getFrom()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private /* synthetic */ Boolean lambda$getNewCardComment$22() {
        if (this.areaCommentReadEnable == true) goto L7;
        return Boolean.TRUE;
    L7:
        if (this.mComment.n0() != CommentStyle.HALF_SCREEN) goto L9;
        boolean r1 = true;
    L11:
        if (this.mComment == null) goto L16;
        if (r1 == false) goto L16;
        return Boolean.FALSE;
    L16:
        return Boolean.TRUE;
    L9:
        r1 = false;
        goto L11
    }

    private Unit lambda$getNewCardComment$26() {
        com.bytedance.ee.bear.document.comment.d r1 = this.commentEventDispatcher;
        r1.getClass();
        r1.a(new r2());
        handleOrientationWhenEnter(this.commentViewModel.getInputOrientationHandler());
        return Unit.INSTANCE;
    }

    private /* synthetic */ Unit lambda$getNewCardComment$33() {
        BaseUnspecifiedOrientationPlugin r1 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r1 != null) goto L5;
        return null;
    L5:
        if (ku5.c.k(getContext()) == true) goto L7;
    L10:
        r1.forcePortrait();
        return null;
    L7:
        if (cu5.c.e(getContext()) == false) goto L10;
        if (ku5.c.l() == false) goto L10;
        return null;
    }

    private /* synthetic */ void lambda$onConfigurationChanged$9() {
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.n0() != CommentStyle.HALF_SCREEN) goto L9;
        setConfig();
        this.mComment.f0();
        return;
    }

    private void onClickImageComment() {
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 != null) goto L6;
        tt5.a.k(TAG, "onClickImageComment, but mComment is null!");
        return;
    L6:
        s2.a(r1.F0(), "image_comment");
        com.bytedance.ee.bear.middleground.comment.export.i r2 = this.mComment.F0();
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter("part_comment", "domain");
        Intrinsics.checkNotNullParameter("create", "type");
        Intrinsics.checkNotNullParameter("image_comment", DocRedirectToDocxPlugin.FROM);
        af5.b r3 = r2.a();
        if (r3 == null) goto L12;
        com.bytedance.ee.bear.middleground.comment.performance.a r4 = r3.d();
        if (r4 == null) goto L13;
        r4.c(System.currentTimeMillis(), "part_comment", "create", "image_comment");
        return;
    L13:
        return;
    }

    private void onFeedJumpToComment() {
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 != null) goto L6;
        tt5.a.k(TAG, "onFeedJumpToComment, but mComment is null!");
        return;
    L6:
        s2.a(r1.F0(), "feed");
    }

    private void setConfig() {
        this.config = this.mComment.F0();
        final com.bytedance.ee.bear.middleground.comment.export.j r1 = this.mComment.p0();
        r1.j();
        r1.f();
        if (getUIContainer() != null) goto L5;
    L19:
        CommentStyle r2 = this.mComment.n0();
        CommentStyle r3 = CommentStyle.HALF_SCREEN;
        boolean r4 = false;
        if (r2 == r3) goto L22;
        boolean r5 = true;
    L23:
        r1.d(supportPhoneLandscapeMode(r5));
        CommentPanelViewModel r6 = this.commentViewModel;
        if (this.mComment.n0() == r3) goto L26;
        boolean r7 = true;
    L27:
        r6.setSupportLandscapeMode(supportPhoneLandscapeMode(r7));
        pcb.a.a.b(getActivity()).c(this.commentViewModel);
        this.commentViewModel.getTranslateConfig().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.comment.d0(this, r1));
        if (this.mPresenterState == null) goto L30;
        r4 = true;
    L30:
        r1.h(r4);
        return;
    L26:
        r7 = false;
        goto L27
    L22:
        r5 = false;
        goto L23
    L5:
        if (this.areaCommentReadEnable == false) goto L19;
        View r8 = getUIContainer().getContentView();
        if (r8.getHeight() <= r8.getWidth()) goto L9;
    L14:
        float r9 = r8.getHeight();
    L15:
        r1.i((int) (0.2f * r9));
        int r10 = (int) (0.4f * r9);
        if (this.mPresenterState == null) goto L18;
        r10 = (int) (((double) r9) * 0.5d);
    L18:
        r1.c(r10);
        r1.b((int) (((double) r9) * 0.6d));
        r1.g((int) (r9 * 0.9f));
        goto L19
    L9:
        if (ku5.c.k(getContext()) == true) goto L14;
        r9 = r8.getWidth();
        if (getDocumentMetadata().getOpenSource() != DocsOpenSource.vc) goto L15;
        r9 = r9 * 0.6f;
        goto L15
    }

    public boolean canComment() {
        return this.per.comment;
    }

    public void cancelHighlight() {
        tt5.a.h(TAG, "cancelHighlight by native when keyboard showing");
        com.bytedance.ee.bear.middleground.comment.export.r r1 = this.mComment;
        if (r1 != null) goto L5;
        return;
    L5:
        if ((r1 instanceof com.bytedance.ee.bear.middleground.comment.export.r) == false) goto L9;
        r1.t2();
        return;
    }

    public void closeCommentCards() {
        this.mComment.h0(true);
    }

    public void closeCommentImageViewer() {
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 == null) goto L6;
        r1.v4();
        return;
    }

    public CommentPlugin() {
        this.forceOrientationRequestCount = 0;
        this.commentEventDispatcher = new com.bytedance.ee.bear.document.comment.d();
        this.per = new Per();
        com.bytedance.ee.bear.appsetting.c r1 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.asideCommentV2 = r1.g("ccm.mobile.android_aside_comment_v2");
        this.closeKeyboardOnDestroyInterceptor = new com.bytedance.ee.bear.document.comment.e0(this);
        this.enableCalcScrollPosLiveData = new MutableLiveData(Boolean.FALSE);
        this.onScrollCallback = new com.bytedance.ee.bear.document.comment.f0(this);
        this.docFollowStateObserver = new com.bytedance.ee.bear.document.comment.g0(this);
        this.menuItemClickListener = new com.bytedance.ee.bear.document.comment.i0(this);
        this.blockMenuClickListener = new com.bytedance.ee.bear.document.comment.j0(this);
        this.jumpToCommentListener = new com.bytedance.ee.bear.document.comment.k0(this);
        this.showCardsJsDataObserver = null;
        this.areaCommentReadEnable = r1.g("ccm.doc.image_region_comment_view");
        this.enableSkipHalfScreenTopLocationChange = !r1.i("ccm_mobile_ccm_at_doubao_reverse_in_feishu", false);
        this.authorIds = new ArrayList();
        this.forwardCallbacks = new HashMap();
    }

    private FrameLayout initAsideContainer() {
        View r1 = getUIContainer().findView(2131363249);
        if (r1 == null) goto L5;
        FrameLayout r2 = (FrameLayout) r1;
    L6:
        if (r2 == null) goto L8;
        r2.setOnTouchListener(new x0(this));
    L8:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    private boolean supportAsideComment() {
        if (getDocViewModel() != null) goto L6;
        return false;
    L6:
        if (ForsetiHelper.h() == true) goto L8;
        return false;
    L8:
        if (getDocViewModel().isDocumentType(sbb.e.o) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public com.bytedance.ee.bear.document.comment.e getCommentStateDispatcher() {
        return this.commentEventDispatcher;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_comment_CommentPlugin_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(PopupWindow r1) {
        PopupWindowLancet.handleDismissBeforeOrigin(r1);
        r1.dismiss();
    }

    public static /* synthetic */ com.bytedance.ee.bear.middleground.comment.export.h access$3000(CommentPlugin r1) {
        return r1.mComment;
    }

    public static /* synthetic */ CommentPanelViewModel access$3100(CommentPlugin r1) {
        return r1.commentViewModel;
    }

    public static /* synthetic */ sy4.e access$3200(CommentPlugin r1) {
        return r1.mPresenterState;
    }

    public static /* synthetic */ MutableLiveData access$3300(CommentPlugin r1) {
        return r1.enableCalcScrollPosLiveData;
    }

    public static /* synthetic */ com.bytedance.ee.bear.middleground.comment.export.g.a access$3400(CommentPlugin r1) {
        return r1.onScrollCallback;
    }

    public static /* synthetic */ Per access$3500(CommentPlugin r1) {
        return r1.per;
    }

    public static /* synthetic */ IDocUserPermission access$3800(CommentPlugin r1) {
        return r1.getUserPermission();
    }

    public static /* synthetic */ com.bytedance.ee.bear.document.comment.d access$3900(CommentPlugin r1) {
        return r1.commentEventDispatcher;
    }

    public static /* synthetic */ com.bytedance.ee.bear.middleground.comment.export.i access$4000(CommentPlugin r1) {
        return r1.config;
    }

    public static /* synthetic */ Context access$4100(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ Context access$4200(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ FragmentActivity access$4300(CommentPlugin r1) {
        return r1.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$4400(CommentPlugin r1) {
        return r1.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$4500(CommentPlugin r1) {
        return r1.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$4600(CommentPlugin r1) {
        return r1.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$4700(CommentPlugin r1) {
        return r1.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$4800(CommentPlugin r1) {
        return r1.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$4900(CommentPlugin r1) {
        return r1.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$5000(CommentPlugin r1) {
        return r1.getActivity();
    }

    public static /* synthetic */ Context access$5100(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ Context access$5200(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ com.bytedance.ee.bear.middleground.comment.export.h access$5300(CommentPlugin r1) {
        return r1.getNewCardComment();
    }

    public static /* synthetic */ FragmentActivity access$5400(CommentPlugin r1) {
        return r1.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$5500(CommentPlugin r1) {
        return r1.getActivity();
    }

    public static /* synthetic */ Context access$5600(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ Context access$5700(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ Context access$5800(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ Context access$5900(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ Context access$6000(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ String access$6100(CommentPlugin r1) {
        return r1.getTargetLanguage();
    }

    public static /* synthetic */ PopupWindow access$6400(CommentPlugin r1) {
        return r1.mEmojiPanel;
    }

    public static /* synthetic */ CommentStyle access$6600(CommentPlugin r1) {
        return r1.lastCommentStyle;
    }

    public static /* synthetic */ Context access$6800(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ Context access$6900(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ boolean access$7100(CommentPlugin r1) {
        return r1.isUIContainerAttached();
    }

    public static /* synthetic */ boolean access$7200(CommentPlugin r1) {
        return r1.isUIContainerAttached();
    }

    public static /* synthetic */ Context access$7400(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ Context access$7500(CommentPlugin r1) {
        return r1.getContext();
    }

    public static /* synthetic */ FragmentActivity access$7600(CommentPlugin r1) {
        return r1.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$7800(CommentPlugin r1) {
        return r1.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$7900(CommentPlugin r1) {
        return r1.getActivity();
    }

    private boolean commentShow(boolean r2) {
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.O(r2) == false) goto L7;
        return true;
    }

    private CommentStyle genCommentStyle(boolean r3) {
        if (supportAsideComment() == true) goto L12;
        tt5.a.h(TAG, "supportAsideComment = false");
        if (r3 == false) goto L11;
        if (this.areaCommentReadEnable == false) goto L11;
        return CommentStyle.HALF_SCREEN;
    L11:
        return CommentStyle.FLOAT;
    L12:
        if (r3 == true) goto L14;
    L17:
        ContentViewWidthChangePlugin r4 = (ContentViewWidthChangePlugin) findPlugin(ContentViewWidthChangePlugin.class);
        if (r4 != null) goto L22;
        tt5.a.h(TAG, "plugin == null");
        return CommentStyle.FLOAT;
    L22:
        return r4.getCommentStyle();
    L14:
        if (this.areaCommentReadEnable == false) goto L17;
        tt5.a.h(TAG, "inImage && areaCommentReadEnable");
        return CommentStyle.HALF_SCREEN;
    }

    private boolean getCanFullAccess(boolean r6) {
        IDocUserPermission r1 = getUserPermission();
        boolean r2 = false;
        if (r1 != null) goto L5;
        tt5.a.h(TAG, "DocumentInfoDta = null getCanFullAccess = false");
        return false;
    L5:
        if (r6 == false) goto L16;
        int r7 = f35.b.a;
        Intrinsics.checkNotNullParameter(r1, "iDocUserPermission");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L10;
        PermissionRequest r8 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).b("VIEW_DOC_HISTORY");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(r8, new UserPermissionEntity(r1, null)).getAllow();
    L10:
        if (r1.isFullAccess() == false) goto L12;
    L13:
        r2 = true;
    L15:
        return r2;
    L12:
        if (r1.isSinglePageFullAccess() == false) goto L15;
    L16:
        int r9 = f35.b.a;
        Intrinsics.checkNotNullParameter(r1, "iDocUserPermission");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L20;
        PermissionRequest r10 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).b("FULL_ACCESS");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(r10, new UserPermissionEntity(r1, null)).getAllow();
    L20:
        return r1.isFullAccess();
    }

    private CommentBuilder getCommentBuilder(boolean r8) {
        BearUrl r1 = getDocumentMetadata().getBearUrl();
        FrameLayout r2 = initAsideContainer();
        com.bytedance.ee.bear.middleground.comment.export.k r3 = getCommentHostConfigDelegate();
        CommentBuilder r4 = new CommentBuilder(getActivity(), (FrameLayout) getUIContainer().c(this), getFragmentManager());
        String r5 = r1.b;
        String r6 = "";
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        Intrinsics.checkNotNullParameter(r5, "token");
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r4.d = r5;
        String r7 = r1.e;
        if (r7 == null) goto L9;
        r6 = r7;
    L9:
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r4.e = r6;
        sbb.e r9 = sbb.e.e(r1.a);
        Intrinsics.checkNotNullParameter(r9, "pageType");
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r4.f = r9;
        r4.g = getDocumentMetadata().isType(sbb.e.n);
        r4.i = 1;
        r4.j = 0;
        CommentStyle r10 = genCommentStyle(r8);
        Intrinsics.checkNotNullParameter(r10, "commentStyle");
        r4.o = r10;
        r4.m = true;
        r4.n = true;
        r4.E = r2;
        boolean r11 = false;
        if ("doc".equals(r1.a) == false) goto L12;
    L17:
        boolean r12 = true;
    L18:
        r4.q = r12;
        j r13 = new j(this);
        Intrinsics.checkNotNullParameter(r13, "isOwner");
        r4.r = r13;
        if (getDocumentMetadata().getOpenSource() != DocsOpenSource.vc) goto L21;
    L23:
        r4.p = r11;
        Intrinsics.checkNotNullParameter(r3, "commentHostDelegate");
        r4.F = r3;
        r4.s = true;
        r4.v = new q(this);
        i r14 = new i(this);
        Intrinsics.checkNotNullParameter(r14, "per");
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r4.k = r14;
        Function1 r16 = new com.bytedance.ee.bear.document.comment.l0(this);
        Intrinsics.checkNotNullParameter(r16, JSEventListener.ACTION_READMESSAGE);
        r4.u = r16;
        r4.t = new h(this);
        r4.w = true;
        g r17 = new g(this);
        Intrinsics.checkNotNullParameter(r17, "vcInfo");
        r4.x = r17;
        com.bytedance.ee.bear.middleground.comment.uitls.r r18 = ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).e();
        Intrinsics.checkNotNullParameter(r18, "adminPermission");
        r4.y = r18;
        com.bytedance.ee.bear.appsetting.c r19 = com.bytedance.ee.bear.appsetting.c.a.a;
        r4.z = r19.g("ccm.permission.attachment_seperate_auth_enable");
        r4.A = r19.g("ccm.mobile.comment_markdown_enable");
        com.bytedance.ee.bear.document.bitable.e r20 = (com.bytedance.ee.bear.document.bitable.e) getHostAbilityOrNull(com.bytedance.ee.bear.document.bitable.e.class);
        if (r20 == null) goto L26;
        Intrinsics.checkNotNullParameter(r20, "bitableCommentFunction");
        r4.B = r20;
    L26:
        r4.C = new com.bytedance.ee.bear.document.comment.m0(this);
        r4.D = getHost().getHostFragment();
        return r4;
    L21:
        if (r3.o() == false) goto L23;
        r11 = true;
        goto L23
    L12:
        if ("docx".equals(r1.a) == true) goto L14;
    L16:
        r12 = false;
        goto L18
    L14:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.doc.fontsize") == false) goto L16;
        goto L16
    }

    private void handleCommentVoiceBarShowingChanged(boolean r3) {
        IEditModeSwitchViewPlugin r1 = (IEditModeSwitchViewPlugin) findPlugin(IEditModeSwitchViewPlugin.class);
        if (r1 == null) goto L6;
        r1.setEditButtonVisibilityFromNative(!r3);
    L6:
        if ((getHost() instanceof DocumentPluginHost) == false) goto L9;
        yz4.b.a(getHost()).c((DocumentPluginHost) getHost(), r3);
        return;
    }

    private void handleForceOrientationRequest(boolean r3) {
        CommentPanelViewModel r1 = this.commentViewModel;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r3 == false) goto L9;
        int r4 = this.forceOrientationRequestCount;
        this.forceOrientationRequestCount = r4 + 1;
        if (r4 != 0) goto L17;
        handleOrientationWhenEnter(r1.getForceOrientationRequestHandler());
        return;
    L17:
        return;
    L9:
        int r5 = this.forceOrientationRequestCount;
        if (r5 > 0) goto L13;
        this.forceOrientationRequestCount = 0;
        return;
    L13:
        int r6 = r5 - 1;
        this.forceOrientationRequestCount = r6;
        if (r6 != 0) goto L19;
        handleOrientationWhenExit(r1.getForceOrientationRequestHandler());
        return;
    }

    private void handleOrientationWhenEnter(com.bytedance.ee.bear.document.orientation.p r2) {
        BaseUnspecifiedOrientationPlugin r1 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r1 == null) goto L6;
        r1.onOrientationSupportPanelShowing(r2);
        return;
    }

    private void handleOrientationWhenExit(com.bytedance.ee.bear.document.orientation.p r2) {
        BaseUnspecifiedOrientationPlugin r1 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r1 == null) goto L6;
        r1.onOrientationSupportPanelDismiss(r2);
        return;
    }

    private /* synthetic */ Unit lambda$getCommentBuilder$11(List r4) {
        BaseFeedPlugin r1 = (BaseFeedPlugin) findPlugin(BaseFeedPlugin.class);
        if (r1 == null) goto L5;
        r1.readMessage(r4);
    L6:
        tt5.a.h(TAG, "comment read,   " + this.mListenerCb);
        if (this.mListenerCb != null) goto L9;
        return null;
    L9:
        if (this.mComment.i() == false) goto L14;
        tt5.a.h(TAG, "comment send read");
        JSONObject r2 = new JSONObject();
        r2.put("msgIds", r4);
        r2.put(JSEventListener.ACTION, JSEventListener.ACTION_READMESSAGE);
        this.mListenerCb.b(r2);
        return null;
    L14:
        return null;
    L5:
        tt5.a.d(TAG, "feedPlugin == null");
        goto L6
    }

    private /* synthetic */ Unit lambda$getNewCardComment$14(Boolean r1) {
        if (r1.booleanValue() == false) goto L5;
        handleOrientationWhenEnter(this.commentViewModel.getAtOrientationHandler());
    L7:
        return Unit.INSTANCE;
    L5:
        handleOrientationWhenExit(this.commentViewModel.getAtOrientationHandler());
        goto L7
    }

    private Unit lambda$getNewCardComment$15(Boolean r4) {
        tt5.a.h(TAG, "commentEditFocusChange hasFocus = " + r4);
        com.bytedance.ee.bear.document.comment.d r1 = this.commentEventDispatcher;
        boolean r2 = r4.booleanValue();
        r1.getClass();
        r1.a(new com.bytedance.ee.bear.document.comment.c(r2));
        if (r4.booleanValue() == false) goto L5;
        this.commentViewModel.setActive(true);
    L7:
        return Unit.INSTANCE;
    L5:
        this.commentViewModel.setActive(false);
        goto L7
    }

    private /* synthetic */ Unit lambda$getNewCardComment$17(Integer r3) {
        tt5.a.h(TAG, "panelHeightUpdate height = " + r3);
        if (this.mListenerCb == null) goto L6;
        JSONObject r1 = new JSONObject();
        r1.put("height", r3);
        r1.put(JSEventListener.ACTION, JSEventListener.PANELHEIGHTUPDATE);
        this.mListenerCb.b(r1);
    L6:
        return Unit.INSTANCE;
    }

    private /* synthetic */ Unit lambda$getNewCardComment$18(Boolean r5) {
        tt5.a.h(TAG, "comment close, inputCancelCb = " + this.mListenerCb);
        if (this.commentViewModel == null) goto L24;
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 == null) goto L24;
        if (this.mListenerCb != null) goto L10;
    L16:
        this.commentViewModel.isShowingComment().setValue(Boolean.FALSE);
        handleOrientationWhenExit(this.commentViewModel.getPartOrientationHandler());
        getNewCardComment().u(true);
        if (r5.booleanValue() == true) goto L19;
        this.commentViewModel.getCommentAnimationLiveData().setValue(new com.bytedance.ee.bear.middleground.comment.export.a(false, false, true));
    L19:
        com.bytedance.ee.bear.contract.d r6 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        if (getDocumentMetadata() == null) goto L22;
        String r2 = getDocumentMetadata().getToken();
    L23:
        r6.s("comment_view", r2);
        goto L24
    L22:
        r2 = "";
        goto L23
    L10:
        if (r1.i() == true) goto L14;
        if (this.mComment.n0().isAside() == false) goto L16;
    L14:
        if (isUIContainerAttached() == false) goto L16;
        tt5.a.h(TAG, "comment send cancel");
        JSONObject r3 = new JSONObject();
        r3.put("type", "show_cards");
        r3.put(JSEventListener.ACTION, "cancel");
        this.mListenerCb.b(r3);
    L24:
        return null;
    }

    private /* synthetic */ Unit lambda$getNewCardComment$20(String r2) {
        ((ImageViewerViewModel) ViewModelProviders.of(getActivity()).get(ImageViewerViewModel.class)).setCloseImageViewer(Boolean.TRUE);
        return null;
    }

    private /* synthetic */ Unit lambda$getNewCardComment$21(CommentInputRequest r5) {
        tt5.a.h(TAG, "click area");
        this.mComment.Q0(false, false);
        String r1 = r5.imageId;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        if (r5.isEdit() == false) goto L8;
        AreaCommentMode r2 = AreaCommentMode.EDIT;
    L9:
        clickImageComment(r2, r1, "enterAreaComment", new s15.a(r5.comment_id, r5.reply_id));
        return null;
    L8:
        r2 = AreaCommentMode.CREATE;
        goto L9
    }

    private Unit lambda$getNewCardComment$23(Boolean r3) {
        com.bytedance.ee.bear.document.comment.d r1 = this.commentEventDispatcher;
        boolean r4 = r3.booleanValue();
        r1.getClass();
        r1.a(new com.bytedance.ee.bear.document.comment.a(r4));
        return null;
    }

    private /* synthetic */ Unit lambda$getNewCardComment$24(Boolean r1) {
        if (r1.booleanValue() == false) goto L5;
        handleOrientationWhenEnter(this.commentViewModel.getEditOrientationHandler());
        return null;
    L5:
        handleOrientationWhenExit(this.commentViewModel.getEditOrientationHandler());
        return null;
    }

    private Unit lambda$getNewCardComment$25(Integer r4) {
        if (commentShow() == false) goto L7;
        com.bytedance.ee.bear.document.comment.d r1 = this.commentEventDispatcher;
        int r2 = r4.intValue();
        r1.getClass();
        r1.a(new n2(r2));
        this.commentViewModel.getPanelHeight().setValue(r4);
        this.commentViewModel.getCommentCardsRequest().getValue();
        return null;
    L7:
        return null;
    }

    private /* synthetic */ Unit lambda$getNewCardComment$27(Boolean r1) {
        handleForceOrientationRequest(r1.booleanValue());
        return Unit.INSTANCE;
    }

    private /* synthetic */ Unit lambda$getNewCardComment$28(Boolean r1) {
        handleCommentVoiceBarShowingChanged(r1.booleanValue());
        return Unit.INSTANCE;
    }

    private /* synthetic */ Unit lambda$getNewCardComment$31(String r3) {
        ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.a(com.bytedance.ee.bear.docshost.k.class)).e(r3, (CharSequence) getDocumentMetadata().getTitle().getValue());
        return null;
    }

    private /* synthetic */ Boolean lambda$getNewCardComment$34(String r3) {
        if ((getHost() instanceof DocumentPluginHost) == false) goto L7;
        return Boolean.valueOf(h5.a(r3, (DocumentPluginHost) getHost()));
    L7:
        return Boolean.valueOf(s45.p.a().Ha(getDocumentMetadata().getUrl(), r3));
    }

    private Unit lambda$getNewCardComment$35(String r5) {
        w05.i r6 = ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider();
        if (r6.g().getValue() == null) goto L8;
        int r1 = f35.b.a;
        IDocUserPermission r7 = ((DocumentInfo) r6.g().getValue()).getDocPermission().a;
        Intrinsics.checkNotNullParameter(r7, "iDocUserPermission");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        PermissionRequest r2 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).b("COPY_BY_LEADER");
        boolean r8 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(r2, new UserPermissionEntity(r7, null)).getAllow();
    L9:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).j0();
        jg5.k.a.a.d(r8, true);
        return null;
    L7:
        r8 = r7.isCopyAuthByLeader();
        goto L9
    L8:
        r8 = false;
        goto L9
    }

    private /* synthetic */ Unit lambda$getNewCardComment$36(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        tt5.a.d(TAG, "send to im but content is empty!");
        return null;
    L6:
        SendToImPlugin r1 = (SendToImPlugin) findPlugin(SendToImPlugin.class);
        if (r1 == null) goto L9;
        r1.sendToIm(null, r4);
    L10:
        return null;
    L9:
        tt5.a.k(TAG, "sendToImPlugin is null");
        goto L10
    }

    private /* synthetic */ void lambda$onAttachToHost$0(CommentInputRequest r4) {
        tt5.a.h(TAG, "commentInputRequest data: " + r4);
        if (r4 == null) goto L20;
        com.bytedance.ee.bear.middleground.comment.export.h r1 = getNewCardComment();
        if (commentShow() == false) goto L12;
        if (r4.isForWhole() == false) goto L12;
        if (r1.n0() != CommentStyle.FLOAT) goto L12;
        getNewCardComment().Q0(false, false);
    L12:
        if (r4.isEdit() == false) goto L14;
    L17:
        createNewComment(r1, r4);
        return;
    L14:
        if (r4.directional_reply_id != null) goto L17;
        r1.E(r4, new c(this, r1, r4));
        return;
    L20:
        if (commentShow(true) == false) goto L24;
        getNewCardComment().Q0(true, true);
        return;
    }

    private void lambda$onAttachToHost$1(ShowCardsJsData r9) {
        this.showCardsJsData = r9;
        if (r9 != null) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (this.areaCommentReadEnable == false) goto L25;
        com.bytedance.ee.bear.middleground.comment.export.h r2 = this.mComment;
        if (r2 == null) goto L25;
        CommentStyle r3 = r2.n0();
        CommentStyle r4 = CommentStyle.HALF_SCREEN;
        if (r3 != r4) goto L12;
        boolean r5 = true;
    L14:
        if ((this.mComment instanceof com.bytedance.ee.bear.middleground.comment.export.r) == false) goto L21;
        CommentStyle r6 = genCommentStyle(this.showCardsJsData.isInPicture());
        CommentStyle r7 = CommentStyle.FLOAT;
        if (r6 != r7) goto L18;
        this.mComment.S0(new CommentStyle[]{r4});
    L19:
        this.mComment.M0(genCommentStyle(this.showCardsJsData.isInPicture()));
        goto L25
    L18:
        this.mComment.S0(new CommentStyle[]{r7});
        goto L19
    L21:
        if (r5 == this.showCardsJsData.isInPicture()) goto L25;
        if (this.asideCommentV2 == true) goto L25;
        this.mComment.destroy(false);
        this.mComment = null;
        getNewCardComment();
        goto L25
    L12:
        r5 = false;
    L25:
        this.per = r9.permission;
        String r10 = this.showCardsJsData.getCur_comment_id();
        if (r10 != null) goto L28;
        r10 = "";
    L28:
        l05.a r8 = l05.a.a;
        ShowCardsJsData r11 = this.showCardsJsData;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r11, "showCardsJsData");
        List<Card> r12 = r11.getCards();
        if (r12 != null) goto L31;
        r12 = new ArrayList();
    L31:
        Per r13 = r11.permission;
        Intrinsics.checkNotNullParameter(r12, "cards");
        Intrinsics.checkNotNullParameter(r13, "per");
        ArrayList r14 = new ArrayList();
        Iterator<T> r16 = r12.iterator();
    L33:
        if (r16.hasNext() == false) goto L35;
        Card r17 = (Card) r16.next();
        l05.a.a.getClass();
        r14.add(l05.a.a(r17, r13));
        goto L33
    L35:
        String r18 = r11.getCur_reply_id();
        String r19 = r11.getCur_comment_id();
        if (TextUtils.isEmpty(r18) == false) goto L38;
    L45:
        l05.a.b.clear();
        com.bytedance.ee.bear.middleground.comment.export.h r20 = this.mComment;
        if (r20 == null) goto L50;
        if (r20.n0() != CommentStyle.ASIDE) goto L50;
    L51:
        boolean r21 = true;
    L54:
        if (getNewCardComment().O(false) == true) goto L57;
        if (r21 == true) goto L57;
        rcb.c.c(getActivity());
    L57:
        if (r21 == false) goto L59;
    L63:
        boolean r22 = TextUtils.isEmpty(r10);
        CommentStyle r23 = getNewCardComment().n0();
        if (r22 == true) goto L66;
    L71:
        boolean r24 = true;
    L73:
        if (getNewCardComment().O(false) == true) goto L79;
        if (r24 == false) goto L79;
        handleOrientationWhenEnter(this.commentViewModel.getPartOrientationHandler());
        com.bytedance.ee.bear.middleground.comment.export.h r26 = getNewCardComment();
        ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).f().getClass();
        if (com.bytedance.ee.bear.middleground.comment.card.a.c != CommentStyle.FLOAT) goto L78;
        r1 = true;
    L78:
        r26.u(!r1);
        getNewCardComment().K0(r10, this.showCardsJsData.getCurCommentPos());
        this.commentViewModel.isShowingComment().setValue(Boolean.TRUE);
    L81:
        if (isFromFeed() == false) goto L89;
        BaseFeedPlugin r27 = (BaseFeedPlugin) findPlugin(BaseFeedPlugin.class);
        if (r27 != null) goto L85;
    L87:
        tt5.a.d(TAG, "feedPlugin == null");
        goto L89
    L85:
        if (r27.isShowing() == false) goto L87;
        r27.hideWithAnim();
    L89:
        if (this.showCardsJsData.isCancelHighlight() == false) goto L91;
        this.mComment.t2();
    L91:
        this.mComment.d(r14);
        return;
    L79:
        this.mComment.Q6(r10, this.showCardsJsData.getCurCommentPos());
        goto L81
    L66:
        if (r23 != CommentStyle.FLOAT) goto L68;
    L70:
        r24 = false;
        goto L73
    L68:
        if (r23 == CommentStyle.HALF_SCREEN) goto L70;
    L59:
        if (r14.isEmpty() == false) goto L63;
        if (getNewCardComment().O(false) == true) goto L63;
        return;
    L50:
        if (this.mComment.n0() == CommentStyle.ASIDE_IN_PICTURE) goto L51;
        r21 = false;
        goto L54
    L38:
        if (TextUtils.isEmpty(r19) == true) goto L45;
        Iterator r28 = r14.iterator();
    L41:
        if (r28.hasNext() == false) goto L45;
        CommentBean r29 = (CommentBean) r28.next();
        if (Intrinsics.areEqual(r19, r29.getComment_id()) == false) goto L41;
        r29.setCurrentReplyId(r18);
        goto L41
    }

    private /* synthetic */ void lambda$onAttachToHost$2(FocusInputBean r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 != null) goto L8;
        tt5.a.k(TAG, "mComment is null");
        return;
    L8:
        r1.Qa(r2);
    }

    private /* synthetic */ void lambda$onAttachToHost$3(Boolean r1) {
        com.bytedance.ee.bear.middleground.comment.export.h r2 = this.mComment;
        if (r2 == null) goto L6;
        r2.J();
        return;
    }

    private /* synthetic */ void lambda$onAttachToHost$4(String r3) {
        clickImageComment(AreaCommentMode.CREATE, r3, null, null);
    }

    private /* synthetic */ void lambda$onAttachToHost$5(List r4) {
        tt5.a.h(TAG, "authors updated. size: " + r4.size());
        ArrayList<String> r1 = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Author r2 = (Author) r5.next();
        if (r2.getId() == null) goto L4;
        r1.add(r2.getId());
        goto L4
    L8:
        this.authorIds = r1;
        getNewCardComment().k(this.ownerId, this.isOwner, r1);
    }

    private /* synthetic */ void lambda$onAttachToHost$6(AuthorsPlugin r3) {
        r3.getAuthorsLiveData().observe(getLifecycleOwner(), new y0(this));
    }

    private /* synthetic */ void lambda$onAttachToHost$7(DocumentInfo r4) {
        this.ownerId = r4.getOwnerUid();
        this.isOwner = r4.isOwner();
        tt5.a.h(TAG, "documentInfo updated. ownerId: " + this.ownerId + ", isOwner: " + this.isOwner);
        getNewCardComment().k(this.ownerId, this.isOwner, this.authorIds);
    }

    private /* synthetic */ void lambda$translate$40(String r3) throws Exception {
        this.mComment.b().w(r3, Action.TRANSLATE);
    }

    private static /* synthetic */ void lambda$translate$41(Throwable r1) throws Exception {
        iu5.d.a(TAG, r1);
    }

    private void onBlockMenuClick(String r7) {
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 != null) goto L6;
        tt5.a.k(TAG, "onBlockMenuClick, but mComment is null!");
        return;
    L6:
        com.bytedance.ee.bear.middleground.comment.export.i r2 = r1.F0();
        int r3 = s2.a;
        Intrinsics.checkNotNullParameter(r7, "menuId");
        Intrinsics.checkNotNullParameter(r2, "config");
        if (StringsKt.equals("COMMENT", r7, true) == true) goto L9;
        return;
    L9:
        if (r2.a() == null) goto L20;
        af5.b r8 = r2.a();
        if (r8 == null) goto L18;
        com.bytedance.ee.bear.middleground.comment.performance.a r4 = r8.d();
        if (r4 == null) goto L19;
        r4.c(System.currentTimeMillis(), "part_comment", "create", "block_menu");
        return;
    L19:
        return;
    L18:
        return;
    }

    private void onBubbleMenuClick(String r7) {
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 != null) goto L6;
        tt5.a.k(TAG, "onBubbleMenuClick, but mComment is null!");
        return;
    L6:
        com.bytedance.ee.bear.middleground.comment.export.i r2 = r1.F0();
        int r3 = s2.a;
        Intrinsics.checkNotNullParameter(r7, "menuId");
        Intrinsics.checkNotNullParameter(r2, "config");
        if (StringsKt.equals("COMMENT", r7, true) == true) goto L9;
        return;
    L9:
        if (r2.a() == null) goto L20;
        af5.b r8 = r2.a();
        if (r8 == null) goto L18;
        com.bytedance.ee.bear.middleground.comment.performance.a r4 = r8.d();
        if (r4 == null) goto L19;
        r4.c(System.currentTimeMillis(), "part_comment", "create", "bubble_menu");
        return;
    L19:
        return;
    L18:
        return;
    }

    private void onFollowStateChange(sy4.b r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if ((r8 instanceof sy4.e) == false) goto L36;
        sy4.e r9 = (sy4.e) r8;
        boolean r1 = true;
        if (r9.b == false) goto L13;
        sy4.e r2 = this.mPresenterState;
        if (r2 != null) goto L11;
    L12:
        boolean r3 = true;
    L14:
        this.mPresenterState = r9;
        boolean r4 = r9.a;
        int r5 = getDocumentMetadata().getDocumentTypeValue();
        if (r5 != 2) goto L17;
    L24:
        boolean r6 = true;
    L25:
        tt5.a.h(TAG, "set enableCalcScrollPos... isPresenter = " + r4 + ", documentTypeEnable = " + r6);
        MutableLiveData<Boolean> r7 = this.enableCalcScrollPosLiveData;
        if (r4 == false) goto L29;
        if (r6 == false) goto L29;
    L30:
        r7.setValue(Boolean.valueOf(r1));
        tt5.a.h(TAG, "presenterState.isReplay = " + r9.b + ", isChangedToFollow = " + r3);
        if (this.mComment == null) goto L35;
        getNewCardComment().C(r3);
        return;
    L35:
        return;
    L29:
        r1 = false;
        goto L30
    L17:
        if (r5 == 22) goto L24;
        if (r5 == 3) goto L24;
        if (r5 == 8) goto L24;
        r6 = false;
        goto L25
    L11:
        if (r2.b == false) goto L12;
    L13:
        r3 = false;
        goto L14
    }

    private void showContentReaction(tb5.m r20) {
        PopupWindow r2 = this.mEmojiPanel;
        if (r2 == null) goto L16;
        if (r2.isShowing() == false) goto L16;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_comment_CommentPlugin_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this.mEmojiPanel);
    L16:
        rcb.c.c(this.config.getActivity());     // Catch: Exception -> L13
        com.bytedance.ee.bear.contract.x r3 = (com.bytedance.ee.bear.contract.x) org.koin.java.a.a(com.bytedance.ee.bear.contract.x.class);     // Catch: Exception -> L13
        View r7 = getHost().getUIContainer().getContentView();     // Catch: Exception -> L13
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L13
        ReactionPanelFacade.ReactionScene r4 = ReactionPanelFacade.ReactionScene.IM;     // Catch: Exception -> L13
        Context r6 = r7.getContext();     // Catch: Exception -> L13
        r3.o();     // Catch: Exception -> L13
        r3.h();     // Catch: Exception -> L13
        r3.a();     // Catch: Exception -> L13
        ReactionPanelFacade r5 = new ReactionPanelFacade(r6, r7, r8, true, new a(this, r20, r3), true, false, 2131953375, -1, -1, true, ReactionPanelFacade.ReactionScene.CCM, "");     // Catch: Exception -> L13
        int r9 = (int) Math.max(com.bytedance.ee.util.ui.n.d(320), Math.min(((double) com.bytedance.ee.util.ui.n.v()) * 0.88d, com.bytedance.ee.util.ui.n.d(450)));     // Catch: Exception -> L13
        r5.h = false;     // Catch: Exception -> L13
        r5.s = false;     // Catch: Exception -> L13
        r5.g = r9;     // Catch: Exception -> L13
        r5.e();     // Catch: Exception -> L13
        View r10 = r5.k.findViewById(2131372074);     // Catch: Exception -> L13
        if (r10 == null) goto L11;
        r10.setVisibility(8);     // Catch: Exception -> L13
    L11:
        PopupWindow r11 = new PopupWindow(r5.k, r9, -2);     // Catch: Exception -> L13
        this.mEmojiPanel = r11;     // Catch: Exception -> L13
        r11.setOnDismissListener(new b(r20));     // Catch: Exception -> L13
        this.mEmojiPanel.setFocusable(true);     // Catch: Exception -> L13
        this.mEmojiPanel.setTouchable(true);     // Catch: Exception -> L13
        this.mEmojiPanel.setOutsideTouchable(true);     // Catch: Exception -> L13
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_comment_CommentPlugin_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this.mEmojiPanel, getUIContainer().getContentView(), 81, 0, 0);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        tt5.a.e(TAG, "JS request show Content Reaction panel fail.", e, false);
    }

    private boolean supportPhoneLandscapeMode(boolean r7) {
        boolean r1 = getDocumentMetadata().isDocumentType(sbb.e.o);
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm_mindnote_mobile.screen_view_horizental") == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        boolean r4 = getDocumentMetadata().isDocumentType(sbb.e.m);
        if (ku5.c.k(getContext()) == true) goto L15;
        if (r1 == true) goto L13;
        if (r2 == true) goto L13;
        if (r4 == false) goto L15;
    L13:
        if (r7 == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (getDocumentMetadata().isDocumentType(sbb.e.k) == false) goto L7;
        r2 = true;
        goto L8
    }

    public void addImageComment(String r4) {
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 == null) goto L5;
        r1.Q0(false, false);
    L5:
        clickImageComment(AreaCommentMode.CREATE, r4, "addImageComment", null);
    }

    public void dismissCommentWithStyle(CommentStyle r4) {
        com.bytedance.ee.bear.middleground.comment.export.r r1 = this.mComment;
        if ((r1 instanceof com.bytedance.ee.bear.middleground.comment.export.r) == false) goto L5;
        r1.S0(new CommentStyle[]{r4});
        return;
    L5:
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.n0() == r4) goto L9;
        return;
    L9:
        if (this.mComment.O(false) == false) goto L15;
        this.mComment.Q0(false, false);
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put("biz.comment.showInput", new j0(this));
        r3.put("biz.comment.hideInput", new t(this));
        r3.put("biz.comment.focusInput", new r(this));
        r3.put("biz.comment.showCards", new g0(this));
        r3.put("biz.comment.syncReactionResult", new o0(this));
        r3.put("biz.comment.insertToReply", new u(this));
        r3.put("biz.comment.showToast", new m0(this));
        r3.put("biz.reaction.showDetail", new i0(this));
        r3.put("biz.util.showOperationPanel", new l0(this));
        r3.put("biz.reaction.close", new o(this));
        r3.put("biz.reaction.showContentReactionPanel", new h0(this));
        r3.put("biz.reaction.closeContentReactionPanel", new n(this));
        r3.put("biz.reaction.showReactionAnimate", new k0(this));
        r3.put("biz.reaction.updateOrder", new q0());
        r3.put("biz.clipboard.setText", new l());
        r3.put("biz.translate.setConfig", new p0(this));
        r3.put("biz.comment.requestNative", new x(this));
        r3.put("biz.comment.commonEventListener", new w(this));
        r3.put("biz.comment.closePanel", new m(this));
        r3.put("biz.comment.activeCards", new n0(this));
        r3.put("biz.comment.scrollComment", new a0(this));
        r3.put("biz.util.getAppSetting", new s(this));
        r3.put("biz.comment.setPermission", new e0(this));
        r3.put("biz.comment.cardIsShow", new r0(this));
        r3.put("biz.comment.setEntity", new d0(this));
        r3.put("biz.comment.removeEntity", new z());
        r3.put("biz.statistics.reportEvent", new x35.c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)));
        r3.put("biz.comment.setReactionDetail", new f0(this));
        r3.put("biz.comment.openImageForComment", new y(this));
        r3.put("biz.comment.setCopyUrlTemplate", new c0(this));
        r3.put("biz.comment.sendResult", new b0(this));
        r3.put("biz.comment.inviteNoPermissionUser", new v(this));
        r3.put("biz.comment.afterAddForwardCommentSuccess", new p(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r4) {
        super.onAttachToHost(r4);
        FollowPlugin r1 = (FollowPlugin) getHost().findPlugin(FollowPlugin.class);
        this.mFollowPlugin = r1;
        if (r1 == null) goto L5;
        BaseFollowImpl r2 = r1.getDocumentFollow();
        r2.registerDocFollowStateObserver(this.docFollowStateObserver);
        this.mPresenterState = new sy4.e(r2.isPresenter(), r2.isReplay());
    L5:
        this.commentViewModel = (CommentPanelViewModel) com.bytedance.ee.bear.browser.plugin.q.c(r4, CommentPanelViewModel.class, null);
        pcb.a.a.b(r4.getActivity()).c(this.commentViewModel);
        EditPanelsManager r3 = (EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
        this.editPanelsManager = r3;
        r3.registerEditPanel(getLifecycleOwner(), this.commentViewModel);
        this.commentViewModel.setSupportLandscapeMode(supportPhoneLandscapeMode(true));
        this.commentViewModel.getCommentInputRequest().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.comment.p0(this));
        this.showCardsJsDataObserver = new com.bytedance.ee.bear.document.comment.q0(this);
        this.commentViewModel.getCommentCardsRequest().observeForever(this.showCardsJsDataObserver);
        this.commentViewModel.getFocusInputBean().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.comment.r0(this));
        this.commentViewModel.getChangeShowHeight().observe(getLifecycleOwner(), new t0(this));
        pcb.a.a.b(r4.getActivity()).c(this.commentViewModel);
        BaseSearchPlugin<?> r5 = (BaseSearchPlugin) getHost().findPlugin(BaseSearchPlugin.class);
        this.mSearchPlugin = r5;
        if (r5 == null) goto L8;
        ((SearchViewModel) com.bytedance.ee.bear.browser.plugin.q.b(r5, r5.getModelClass())).addCloseKeyboardOnDestroyInterceptor(this.closeKeyboardOnDestroyInterceptor);
    L8:
        getEditorAbility().getDocumentLoader().S3(new d(this));
        ImageViewerPlugin r6 = (ImageViewerPlugin) findPlugin(ImageViewerPlugin.class);
        this.mImageViewerPlugin = r6;
        if (r6 == null) goto L11;
        r6.setOnCommentClickListener(new u0(this));
    L11:
        BaseSelectionPlugin<?> r7 = (BaseSelectionPlugin) findPlugin(BaseSelectionPlugin.class);
        this.mSelectionPlugin = r7;
        if (r7 == null) goto L14;
        r7.addMenuItemClickListener(this.menuItemClickListener);
    L14:
        com.bytedance.ee.bear.doc.blockeditpanel.b r8 = (com.bytedance.ee.bear.doc.blockeditpanel.b) getHostAbilityOrNull(com.bytedance.ee.bear.doc.blockeditpanel.b.class);
        this.mBlockMenuClickListenerHolder = r8;
        if (r8 == null) goto L17;
        r8.addBlockMenuClickListener(this.blockMenuClickListener);
    L17:
        BaseFeedPlugin r9 = (BaseFeedPlugin) findPlugin(BaseFeedPlugin.class);
        this.mFeedPlugin = r9;
        if (r9 == null) goto L20;
        r9.addJumpToCommentListener(this.jumpToCommentListener);
    L20:
        r4.findPluginToDo(AuthorsPlugin.class, new v0(this));
        ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider().j().observe(getLifecycleOwner(), new w0(this));
    }

    public void onCommentStyleChange(CommentStyle r4) {
        if (supportAsideComment() == true) goto L7;
        tt5.a.h(TAG, "not support aside comment");
        return;
    L7:
        if (this.mListenerCb == null) goto L9;
        JSONObject r1 = new JSONObject();
        r1.put(JSEventListener.ACTION, JSEventListener.SWITCHSTYLE);
        r1.put(JSEventListener.STYLE, r4.getStyle());
        this.mListenerCb.b(r1);
    L10:
        com.bytedance.ee.bear.middleground.comment.export.r r2 = this.mComment;
        if ((r2 instanceof com.bytedance.ee.bear.middleground.comment.export.r) == false) goto L14;
        r2.M0(r4);
        return;
    L14:
        return;
    L9:
        this.lastCommentStyle = r4;
        goto L10
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        this.commentViewModel.setChangeShowHeight(true);
        if (this.mComment == null) goto L5;
        com.bytedance.ee.util.ui.j.d(new com.bytedance.ee.bear.document.comment.o0(this), 200);
        this.mComment.h();
        this.mComment.A();
    L5:
        PopupWindow r4 = this.mEmojiPanel;
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.isShowing() == true) goto L10;
        return;
    L10:
        if (this.mEmojiPanelCallback == null) goto L15;
        this.mEmojiPanel.setOnDismissListener(null);
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_comment_CommentPlugin_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this.mEmojiPanel);
        showContentReaction(this.mEmojiPanelCallback);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r2) {
        super.onDetachFromHost(r2);
        if (this.showCardsJsDataObserver == null) goto L5;
        this.commentViewModel.getCommentCardsRequest().removeObserver(this.showCardsJsDataObserver);
    L5:
        BaseSearchPlugin<?> r3 = this.mSearchPlugin;
        if (r3 == null) goto L8;
        ((SearchViewModel) com.bytedance.ee.bear.browser.plugin.q.b(r3, r3.getModelClass())).removeCloseKeyboardOnDestroyInterceptor(this.closeKeyboardOnDestroyInterceptor);
    L8:
        FollowPlugin r4 = this.mFollowPlugin;
        if (r4 == null) goto L11;
        r4.getDocumentFollow().unregisterDocFollowStateObserver(this.docFollowStateObserver);
    L11:
        ImageViewerPlugin r5 = this.mImageViewerPlugin;
        if (r5 == null) goto L14;
        r5.setOnCommentClickListener(null);
    L14:
        BaseSelectionPlugin<?> r6 = this.mSelectionPlugin;
        if (r6 == null) goto L17;
        r6.removeMenuItemClickListener(this.menuItemClickListener);
    L17:
        com.bytedance.ee.bear.doc.blockeditpanel.b r7 = this.mBlockMenuClickListenerHolder;
        if (r7 == null) goto L20;
        r7.removeBlockMenuClickListener(this.blockMenuClickListener);
    L20:
        BaseFeedPlugin r8 = this.mFeedPlugin;
        if (r8 == null) goto L24;
        r8.removeJumpToCommentListener(this.jumpToCommentListener);
        return;
    }

    public void setInputCommentFullClick(boolean r2) {
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 == null) goto L5;
        r1.u(r2);
        return;
    L5:
        tt5.a.h(TAG, "setInputCommentFullClick, but mComment is null!");
    }

    public void showCommentCards(ShowCardsJsData r2) {
        this.commentViewModel.updateCommentCardsRequest(r2);
    }

    public void showCommentInput(CommentInputRequest r2) {
        this.commentViewModel.updateCommentInputRequest(r2);
    }

    public void switchComment(String r2) {
        if (this.mComment == null) goto L8;
        ShowCardsJsData r1 = (ShowCardsJsData) this.commentViewModel.getCommentCardsRequest().getValue();
        if (r1 == null) goto L9;
        r1.setCur_comment_id(r2);
        this.commentViewModel.updateCommentCardsRequest(r1);
        return;
    L9:
        return;
    }

    public void updatePanelHeight(CardCommentHeight r2) {
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 == null) goto L6;
        r1.Fa(r2);
        return;
    }

    public static /* synthetic */ Per access$3502(CommentPlugin r1, Per r2) {
        r1.per = r2;
        return r2;
    }

    public static /* synthetic */ boolean access$3700(CommentPlugin r1, boolean r2) {
        return r1.getCanFullAccess(r2);
    }

    public static /* synthetic */ tb5.m access$6202(CommentPlugin r1, tb5.m r2) {
        r1.mEmojiPanelCallback = r2;
        return r2;
    }

    public static /* synthetic */ void access$6300(CommentPlugin r1, tb5.m r2) {
        r1.showContentReaction(r2);
    }

    public static /* synthetic */ tb5.m access$6502(CommentPlugin r1, tb5.m r2) {
        r1.mListenerCb = r2;
        return r2;
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$6700(CommentPlugin r1, Class r2) {
        return r1.findPlugin(r2);
    }

    private void createNewComment(com.bytedance.ee.bear.middleground.comment.export.h r1, CommentInputRequest r2) {
        r1.S(r2);
        ((com.bytedance.ee.bear.document.toolbar2.b) org.koin.java.a.a(com.bytedance.ee.bear.document.toolbar2.b.class)).b(getHost());
    }

    private /* synthetic */ Unit lambda$getNewCardComment$29(Integer r4, Boolean r5) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.intValue() <= 0) goto L16;
        if (this.enableSkipHalfScreenTopLocationChange == false) goto L12;
        if (this.mComment.n0() == CommentStyle.HALF_SCREEN) goto L16;
    L12:
        if (Boolean.TRUE.equals(this.commentViewModel.getActive().getValue()) == false) goto L14;
        this.editPanelsManager.requestUpdateWebContentHeight();
        goto L16
    L14:
        this.commentViewModel.setActive(true);
    L16:
        if (r5.booleanValue() == true) goto L18;
    L20:
        return null;
    L18:
        if (r4.intValue() < 0) goto L20;
        JSONObject r6 = new JSONObject();
        r6.put("height", r4);
        r6.put("keyboardType", FileUploadModel.FROM_COMMENT);
        r6.put("position", Integer.valueOf(this.mComment.B()));
        getBridge().a("lark.biz.util.setPanelHeight", r6, null);
        goto L20
    }

    private Unit lambda$getNewCardComment$30(Integer r2, Boolean r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.intValue() <= 0) goto L9;
        com.bytedance.ee.bear.document.comment.d r4 = this.commentEventDispatcher;
        int r5 = r2.intValue();
        r4.getClass();
        r4.a(new q2(r5));
        return null;
    L9:
        return null;
    }

    private Unit lambda$getNewCardComment$32(String r5, String r6) {
        BottomPopupData r1 = new BottomPopupData();
        r1.setConfirmBtnText(com.bytedance.ee.util.ui.n.x(getContext(), 2131887556));
        r1.setTitle(com.bytedance.ee.util.ui.n.x(getContext(), 2131887362));
        r1.setSendLarkText(com.bytedance.ee.util.ui.n.x(getContext(), 2131887558));
        r1.setActionSource(BottomPopupData.GlobalComment);
        StringBuilder r2 = new StringBuilder("<a href=\"lark://client/contact/personcard?chatterId=");
        int r3 = uv4.c.l;
        r2.append(r5);
        r2.append("\">");
        r2.append(r6);
        r2.append(" </a>");
        String r7 = r2.toString();
        r1.setDes(xo5.a.c(getContext(), 2131887557, "username", r7));
        BaseTipsPlugin r8 = (BaseTipsPlugin) findPlugin(BaseTipsPlugin.class);
        if (r8 == null) goto L7;
        r8.showBottomPopup(r1, new k(this, r5));
        return null;
    L7:
        return null;
    }

    private /* synthetic */ Unit lambda$getNewCardComment$37(String r4, Map r5) {
        tt5.a.h(TAG, "onMenuClicked, mListenerCb = " + this.mListenerCb + ", menuId = " + r4 + ", params = " + r5);
        if (this.mListenerCb == null) goto L14;
        r4.getClass();
        if (r4.equals("SEND_IM") == false) goto L7;
    L9:
        JSONObject r1 = new JSONObject();
        r1.put(JSEventListener.ACTION, JSEventListener.ON_MENU_CLICKED);
        r1.put("menuId", r4);
        r1.put("commentId", r5.get("commentId"));
        if (r5.get("commentType") != null) goto L12;
        Object r6 = 0;
    L13:
        r1.put("commentType", r6);
        this.mListenerCb.b(r1);
        goto L14
    L12:
        r6 = r5.get("commentType");
        goto L13
    L7:
        if (r4.equals("COPY_LINK") == true) goto L9;
    L14:
        this.mComment.W0(new com.bytedance.ee.bear.document.comment.b0(this));
        this.mComment.L(new com.bytedance.ee.bear.document.comment.c0(this));
        return null;
    }

    private /* synthetic */ boolean lambda$initAsideContainer$10(View r1, MotionEvent r2) {
        if (r2.getAction() != 1) goto L7;
        this.editPanelsManager.requestNotFocus(getActivity());
        return false;
    L7:
        return false;
    }

    private Unit lambda$onAttachToUIContainer$8(String r6, Action r7) {
        ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).a().getClass();
        int r1 = com.bytedance.ee.bear.middleground.comment.uitls.n.a;
        Intrinsics.checkNotNullParameter(r6, "data");
        JSONObject r2 = JSON.parseObject(r6).getJSONObject("data").getJSONObject("body");     // Catch: Throwable -> L5
    L7:
        if (r2 != null) goto L9;
        r2 = new JSONObject();
        r2.put("error", r6);
    L9:
        r2.put(JSEventListener.ACTION, r7.toString().toLowerCase());
        tb5.m r8 = this.mListenerCb;
        if (r8 == null) goto L16;
        r8.b(r2);
        return null;
    L16:
        return null;
    L5:
        th = move-exception;
        tt5.a.e("CommentTo", "getResultBody error! data: " + r6, th, false);
        JSONObject r3 = new JSONObject();
        r3.put("error", th.toString());
        r2 = r3;
        goto L7
    }

    private /* synthetic */ void lambda$setConfig$39(com.bytedance.ee.bear.middleground.comment.export.j r2, TranslateConfig r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.config == null) goto L8;
        r2.a(r3);
        return;
    }

    private void sendCallback(String r2, boolean r3) {
        if (this.forwardCallbacks.containsKey(r2) == true) goto L11;
        return;
    L11:
        this.forwardCallbacks.get(r2).apply(Boolean.valueOf(r3));     // Catch: Exception -> L8
        this.forwardCallbacks.remove(r2);
        return;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void closeComment(boolean r2, boolean r3) {
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.mComment;
        if (r1 == null) goto L6;
        r1.Q0(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onAttachToUIContainer(r1, r2);
        getNewCardComment().L0(new com.bytedance.ee.bear.document.comment.n0(this));
        com.bytedance.ee.bear.middleground.comment.export.j r3 = this.mComment.p0();
        if (findPlugin(FollowPlugin.class) == null) goto L5;
        boolean r4 = true;
    L6:
        r3.h(r4);
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.commentViewModel.reset();
        destroy();
        pcb.a.a.b(r1.getActivity()).a(this.commentViewModel);
        this.commentViewModel.onDetachFromUI();
    }

    public static /* synthetic */ void access$7300(CommentPlugin r1, String r2, boolean r3) {
        r1.sendCallback(r2, r3);
    }

    public static /* synthetic */ void access$7700(CommentPlugin r1, com.bytedance.ee.bear.middleground.comment.export.h r2, CommentInputRequest r3) {
        r1.createNewComment(r2, r3);
    }

    private /* synthetic */ Unit lambda$getCommentBuilder$12(String r3, float[] r4, Matrix r5) {
        tt5.a.h(TAG, "onClickFollowMark...");
        FollowPlugin r1 = (FollowPlugin) findPlugin(FollowPlugin.class);
        if (r1 == null) goto L5;
        r1.processEvent(new OpenImageWhiteboard(r3, r4, r5));
        return null;
    L5:
        tt5.a.k(TAG, "followPlugin is null");
        return null;
    }

    private Unit lambda$getNewCardComment$38(String r5, CommentInputRequest r6, Boolean r7) {
        com.bytedance.ee.bear.document.comment.d r1 = this.commentEventDispatcher;
        boolean r2 = r6.isReply();
        String r3 = r6.comment_id;
        String r8 = r6.local_comment_id;
        r1.getClass();
        r1.a(new w2(r2, r3, r8));
        ((dn4.a) getHost().getUserComponent().a(dn4.a.class)).a();
        com.bytedance.ee.bear.document.bitable.e r9 = (com.bytedance.ee.bear.document.bitable.e) getHostAbilityOrNull(com.bytedance.ee.bear.document.bitable.e.class);
        if (r9 == null) goto L7;
        r9.onDiscussSend(this.mComment, r5, r7.booleanValue());
        return null;
    L7:
        return null;
    }

    public void addAreaComment(AreaCommentMode r2, String r3, s15.a r4) {
        clickImageComment(r2, r3, ImageViewerViewModel.TYPE_ADD_AREA_COMMENT, r4);
    }

    public void translate(String r2, String r3, int r4) {
        Disposable r5 = this.mComment.b().a(r2, r4, r3).subscribe(new z0(this), new a1());
        this.mComment.Z0(r5);
    }

    private void clickImageComment(AreaCommentMode r4, String r5, String r6, s15.a r7) {
        tt5.a.h(TAG, "click imageViewer comment icon, mode = " + r4 + ", imageId = " + du5.b.h(r5) + ", mListenerCb = " + this.mListenerCb + ", event = " + r6 + ", extra = " + r7);
        if (this.mListenerCb == null) goto L13;
        JSONObject r1 = new JSONObject();
        r1.put(JSEventListener.ACTION, JSEventListener.ACTION_CLICK_IMAGE_COMMENT);
        r1.put("mode", r4.getValue());
        r1.put("imageId", r5);
        if (r6 == null) goto L8;
        r1.put("event", r6);
    L8:
        if (r4 != AreaCommentMode.EDIT) goto L11;
        if (r7 == null) goto L11;
        Intrinsics.checkNotNullParameter(r1, "json");
        r1.put("commentId", r7.a);
        r1.put("replyId", r7.b);
    L11:
        this.mListenerCb.onCallBack(r1.toString());
        onClickImageComment();
        return;
    }

    private Unit lambda$getNewCardComment$13(String r2, List r3, Boolean r4, String r5) {
        boolean r6 = !r4.booleanValue();
        com.bytedance.ee.bear.document.comment.d r7 = this.commentEventDispatcher;
        r7.getClass();
        r7.a(new p2(r6));
        JSONObject r8 = this.commentViewModel.getInputCancelParam(r6, r5);
        if (r6 == false) goto L7;
        tb5.m r9 = this.mListenerCb;
        if (r9 == null) goto L7;
        r9.b(r8);
    L7:
        handleOrientationWhenExit(this.commentViewModel.getInputOrientationHandler());
        if (commentShow(true) == true) goto L12;
        this.commentViewModel.setActive(false);
        return null;
    L12:
        return null;
    }

    private Unit lambda$getNewCardComment$16(String r3, String r4, Integer r5, Integer r6) {
        tt5.a.h(TAG, "comment switch, commentId = " + r3 + ", commentType: " + r5 + ", switchCb = " + this.mListenerCb + ", height = " + r6);
        com.bytedance.ee.bear.document.comment.d r1 = this.commentEventDispatcher;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "commentId");
        Intrinsics.checkNotNullParameter(r4, "commentUUID");
        r1.a(new m2(r3, r4));
        tb5.m r7 = this.mListenerCb;
        if (r7 == null) goto L10;
        int r8 = r5.intValue();
        JSONObject r2 = new JSONObject();
        r2.put("comment_id", r3);
        r2.put("commentType", Integer.valueOf(r8));
        if (r6 == null) goto L7;
        r2.put("height", r6);
    L7:
        TextUtils.isEmpty("");
        r2.put(DocRedirectToDocxPlugin.FROM, "");
        r2.put(JSEventListener.ACTION, JSEventListener.SWITCHCARD);
        r7.b(r2);
        return null;
    L10:
        return null;
    }

    private /* synthetic */ Unit lambda$getNewCardComment$19(String r3, Integer r4, String r5, Integer r6) {
        tt5.a.h(TAG, "onActivateImageChange... commentId = " + r3 + ", replyId = " + r5 + ", index = " + r6 + ", mListenerCb = " + this.mListenerCb);
        JSONObject r1 = new JSONObject();
        r1.put("commentId", r3);
        r1.put("commentType", r4);
        r1.put("replyId", r5);
        r1.put("index", r6);
        r1.put(JSEventListener.ACTION, JSEventListener.ACTIVATEIMAGECHANGE);
        tb5.m r7 = this.mListenerCb;
        if (r7 == null) goto L7;
        r7.b(r1);
        return null;
    L7:
        return null;
    }

    private void notifyScrollToWeb(String r4, int r5, String r6, float r7) {
        tt5.a.h(TAG, "notifyScrollToWeb()... commentId = " + r4 + ", replyId = " + r6 + ", percentage = " + r7 + ", mListenerCb = " + this.mListenerCb);
        if (this.mListenerCb != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put(JSEventListener.ACTION, JSEventListener.SCROLL_COMMENT);
        r1.put("cur_comment_id", r4);
        r1.put("replyId", r6);
        r1.put("commentType", Integer.valueOf(r5));
        r1.put("replyPercentage", Float.valueOf(r7));
        this.mListenerCb.b(r1);
    }

    public void addForwardComment(String r2, VisibilityBean r3, String r4, Function<Boolean, Unit> r5) {
        this.mComment.b().H(r2, r3, r4);
        this.forwardCallbacks.put(r4, r5);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_comment_CommentPlugin_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(PopupWindow r7, View r8, int r9, int r10, int r11) {
        if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L6;
        return;
    L6:
        if ((r7 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r1 = PopupWindowLancet.resolveSource(r8);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r7, r8, r1, r9, r10, r11) == false) goto L14;
        return;
    L14:
        r7.showAtLocation(r8, r9, r10, r11);
        PopupWindowLancet.trackAfterShow(r7, r1, r8);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r7) == false) goto L11;
        r7.showAtLocation(r8, r9, r10, r11);
    }
}
