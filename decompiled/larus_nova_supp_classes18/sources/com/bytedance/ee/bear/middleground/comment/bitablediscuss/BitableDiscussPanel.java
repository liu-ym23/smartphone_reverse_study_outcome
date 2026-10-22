package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.middleground.comment.card.o1;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.card.q1;
import com.bytedance.ee.bear.middleground.comment.control.t;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.CardCommentHeight;
import com.bytedance.ee.bear.middleground.comment.export.CommentDiffUtils;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.FocusInputBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.docsdk.impl.document.service.ContainerThemeWebService;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u009b\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u009b\u0001\u009c\u0001B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ$\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020\u0011H\u0002J\b\u0010C\u001a\u00020\u000fH\u0002J\u001a\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001b2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010G\u001a\u00020EH\u0002J\u001f\u0010Q\u001a\u00020E2\u0006\u00107\u001a\u00020)2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016¢\u0006\u0002\u0010TJ\"\u0010U\u001a\u00020S2\u0006\u0010V\u001a\u00020)2\b\u0010W\u001a\u0004\u0018\u00010)2\u0006\u0010X\u001a\u00020%H\u0002J\u001c\u0010Y\u001a\u00020E2\b\u0010Z\u001a\u0004\u0018\u00010)2\b\u0010[\u001a\u0004\u0018\u00010)H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0006\u0010\\\u001a\u00020%J\u0010\u0010]\u001a\u00020E2\u0006\u0010^\u001a\u00020%H\u0016J\b\u0010_\u001a\u00020SH\u0016J\u0010\u0010`\u001a\u00020E2\u0006\u0010a\u001a\u00020%H\u0016J\u0010\u0010b\u001a\u00020E2\u0006\u0010V\u001a\u00020)H\u0016J\u0010\u0010c\u001a\u00020E2\u0006\u0010d\u001a\u00020eH\u0016J\u001f\u0010f\u001a\u00020E2\u0006\u0010V\u001a\u00020)2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016¢\u0006\u0002\u0010TJ\u0010\u0010g\u001a\u00020E2\u0006\u0010h\u001a\u00020\u001bH\u0016J\b\u0010i\u001a\u00020EH\u0016J\b\u0010j\u001a\u00020EH\u0016JB\u0010k\u001a\u00020E2\u0006\u0010V\u001a\u00020)2\u0006\u0010W\u001a\u00020)2\u000e\u0010l\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010m2\u0006\u0010o\u001a\u00020S2\b\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020sH\u0016J\b\u0010t\u001a\u00020EH\u0016J,\u0010u\u001a\u00020E2\b\u0010v\u001a\u0004\u0018\u00010)2\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010m2\b\u0010x\u001a\u0004\u0018\u00010yH\u0016J\b\u0010z\u001a\u00020)H\u0016J\n\u0010{\u001a\u0004\u0018\u00010|H\u0016J\b\u0010}\u001a\u00020SH\u0016J\b\u0010~\u001a\u00020\u007fH\u0016J\u000b\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001bH\u0016J\u0019\u0010\u0081\u0001\u001a\u00020E2\u000e\u0010\u0082\u0001\u001a\t\u0012\u0004\u0012\u00020E0\u0083\u0001H\u0002J\u0013\u0010\u0084\u0001\u001a\u00020E2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\t\u0010\u0085\u0001\u001a\u00020EH\u0016J\u0011\u0010\u0086\u0001\u001a\u00020E2\u0006\u0010R\u001a\u00020SH\u0016J&\u0010\u0087\u0001\u001a\u00020E2\b\u0010V\u001a\u0004\u0018\u00010)2\b\u0010W\u001a\u0004\u0018\u00010)2\u0007\u0010\u0088\u0001\u001a\u00020SH\u0016J\t\u0010\u0089\u0001\u001a\u00020EH\u0002J\u0011\u0010\u008a\u0001\u001a\f\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u008b\u0001J\u0013\u0010\u008d\u0001\u001a\u00020E2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J\t\u0010\u0090\u0001\u001a\u00020EH\u0002J\t\u0010\u0091\u0001\u001a\u00020EH\u0002J\t\u0010\u0092\u0001\u001a\u00020EH\u0002J\u0013\u0010\u0093\u0001\u001a\u00020E2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J\u0014\u0010\u0096\u0001\u001a\u00030\u0097\u00012\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\t\u0010\u0098\u0001\u001a\u00020%H\u0002J\f\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0019\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0019\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0019\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010IX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010K\"\u0004\bP\u0010M¨\u0006\u009d\u0001"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/BitableDiscussPanel;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "Lcom/bytedance/ee/bear/middleground/comment/card/ICardComment;", "Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/IBitableDiscussPanel;", "config", "Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "commentListeners", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "dataControl", "Lcom/bytedance/ee/bear/middleground/comment/control/DataControl;", "actionControl", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;Lcom/bytedance/ee/bear/middleground/comment/control/DataControl;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;)V", "mActionPanelLayout", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "commentList", "Landroidx/recyclerview/widget/RecyclerView;", "commentAdapter", "Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/BitableDiscussListAdapter;", "commentLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getCommentLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "commentLayoutManager$delegate", "Lkotlin/Lazy;", "bottomView", "Landroid/view/View;", "userAvatar", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "commentInputTV", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "imageViewerWrapper", "Lcom/bytedance/ee/bear/middleground/comment/imageviewer/ImageViewerWrapper;", "mPanelHeightMinPercent", "", "isShowing", "", SendEventContainerMethodParamModel.EventKinds.onShow, "findHightItem", "language", "", "getLanguage", "()Ljava/lang/String;", "language$delegate", "bitableDiscussDataViewModel", "Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/BitableDiscussDataViewModel;", "getBitableDiscussDataViewModel", "()Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/BitableDiscussDataViewModel;", "bitableDiscussDataViewModel$delegate", "sharePermissionViewModel", "Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;", "getSharePermissionViewModel", "()Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;", "sharePermissionViewModel$delegate", "targetId", "locateReplyId", "sendCommentUUID", "sendReplyUUID", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "createContent", "createActionPanelLayout", "onViewCreated", "", "view", "setAvatar", "mEnterAnimator", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentAnimationParam;", "getMEnterAnimator", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentAnimationParam;", "setMEnterAnimator", "(Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentAnimationParam;)V", "mExitAnimator", "getMExitAnimator", "setMExitAnimator", "show", "height", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "scrollToTargetId", "commentId", "replyId", "justScrollTo", "onCommentSend", "localCommentId", "replyUUID", "isOnShow", "updatePanel", "forceContentDiff", "getPanelHeight", "dismiss", "shouldShowAnimator", "switchCard", "commentCardScrollTo", "scrollCommentBean", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/ScrollCommentBean;", "updateTargetId", "onReactionAdd", "itemView", "dismissInputComment", "onOrientationChanged", "showCommentImageViewer", "imageList", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail$ExtraEntity$CommentImageEntity;", "activeIndex", "commentBean", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;", "showSource", "Lcom/bytedance/ee/bear/middleground/comment/export/CommentImageShowSource;", "closeCommentImageViewer", "updateInputUi", "content", "images", "smartReplyDataForInsert", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/SmartReplyDataForInsert;", "getCurrentCommentId", "getPagerAdapter", "Lcom/bytedance/ee/bear/middleground/comment/card/ICommentPagerAdapter;", "getCurrentPos", "getDataViewModel", "Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "getRootView", "excuteTaskAfterRender", "task", "Lkotlin/Function0;", "onCreate", "onStart", "onInputCommentHeightChange", "heightLightComment", ResourceData.KEY_TYPE, "addBottomView", "getBottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onFinishClose", "updatePanelPeekHeight", "expandPanel", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateDialog", "Landroid/app/Dialog;", "isInputGone", "getBitableDiscussFunction", "Lcom/bytedance/ee/bear/middleground/comment/export/bitablecomment/IBitableDiscussFunction;", "Companion", "OnBackPressBottomSheetDialog", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableDiscussPanel extends BaseBottomSheetDialogFragment implements p1, i {
    public static final /* synthetic */ int H = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public String D;
    public String E;
    public String F;
    public String G;
    public final p k;
    public final z l;
    public final t m;
    public final y n;
    public CommonActionPanelLayout o;
    public RecyclerView p;
    public BitableDiscussListAdapter q;
    public final Lazy r;
    public View s;
    public UDAvatar t;
    public CommentTextView u;
    public final jf5.a v;
    public final float w;
    public boolean x;
    public boolean y;
    public boolean z;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/BitableDiscussPanel$OnBackPressBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", ContainerThemeWebService.THEME_CONFIG_KEY, "", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/BitableDiscussPanel;Landroid/content/Context;I)V", "onBackPressed", "", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class OnBackPressBottomSheetDialog extends BottomSheetDialog {
        public final /* synthetic */ BitableDiscussPanel a;

        /* JADX WARN: Multi-variable type inference failed */
        public final void onBackPressed() {
            IImageViewer r0 = this.a.v.c;
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.isShowing() != true) goto L7;
        L8:
            if (r1 == false) goto L10;
            this.a.v.a();
            return;
        L10:
            super/*android.app.Dialog*/.onBackPressed();
            return;
        L7:
            r1 = false;
            goto L8
        }

        public OnBackPressBottomSheetDialog(BitableDiscussPanel r2, Context r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a = r2;
            super(r3, r4);
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ BitableDiscussPanel b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            r2.post(this.a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            ViewGroup r3 = this.b.p;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("commentList");
            r3 = null;
        L5:
            r3.removeCallbacks(this.a);
        }

        public b(c r1, BitableDiscussPanel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements Runnable {
        public boolean a;
        public final /* synthetic */ Function0<Unit> b;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        L3:
            if (this.a == true) goto L5;
            this.b.invoke();     // Catch: Throwable -> L7
        L5:
            this.a = true;     // Catch: Throwable -> L7
        }

        public c(Function0<Unit> r1) {
            this.b = r1;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ BitableDiscussPanel a;

        public d(BitableDiscussPanel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            CommentBean r6 = (CommentBean) r5;
            BitableDiscussListAdapter r0 = this.a.q;
            Map<Object, ? extends Object> r2 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
            r0 = null;
        L5:
            if (r6 == null) goto L7;
            String r3 = r6.getQuote();
        L8:
            r0.setQuote(r3);
            BitableDiscussListAdapter r1 = this.a.q;
            if (r1 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
            r1 = null;
        L11:
            if (r6 == null) goto L13;
            String r4 = r6.getParentToken();
        L14:
            r1.setParentToken(r4);
            BitableDiscussListAdapter r7 = this.a.q;
            if (r7 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
            r7 = null;
        L17:
            if (r6 == null) goto L19;
            String r8 = r6.getParentType();
        L20:
            r7.setParentType(r8);
            BitableDiscussListAdapter r9 = this.a.q;
            if (r9 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
            r9 = null;
        L23:
            if (r6 == null) goto L25;
            String r10 = r6.getPosition();
        L26:
            r9.setPosition(r10);
            BitableDiscussListAdapter r11 = this.a.q;
            if (r11 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
            r11 = null;
        L29:
            if (r6 == null) goto L31;
            r2 = r6.getBizParams();
        L31:
            r11.setBizParams(r2);
            return;
        L25:
            r10 = null;
            goto L26
        L19:
            r8 = null;
            goto L20
        L13:
            r4 = null;
            goto L14
        L7:
            r3 = null;
            goto L8
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ BitableDiscussPanel a;

        public e(BitableDiscussPanel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r18) {
            List<CommentBean.CommentDetail> r0 = (List) r18;
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.bitable.record.fix_discuss_and_phone_field") == true) goto L5;
        L14:
            CommonActionPanelLayout r6 = null;
            if (r0.isEmpty() == false) goto L30;
            BitableDiscussListAdapter r2 = this.a.q;
            if (r2 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
            r2 = null;
        L20:
            if (r2.getItemCount() == 0) goto L30;
            BitableDiscussPanel r3 = this.a;
            if (r3.x == false) goto L30;
            r3.dismissAllowingStateLoss();     // Catch: Exception -> L25
            return;
        L25:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r1 = DialogFragmentLancet.sLastShowStack;
            if (r1 == null) goto L99;
            com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L99:
            return;
        L30:
            if (this.a.z == false) goto L32;
        L41:
            SharePermissionViewModel.PreviewPermissionState r4 = this.a.ka0().h();
            if (r4 != null) goto L44;
        L45:
            BitableDiscussPanel r5 = this.a;
            Iterator<T> r7 = r0.iterator();
        L47:
            if (r7.hasNext() == false) goto L60;
            CommentBean.CommentDetail.ExtraEntity r8 = ((CommentBean.CommentDetail) r7.next()).getExtra();
            if (r8 == null) goto L47;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r9 = r8.getImage_list();
            if (r9 == null) goto L47;
            Iterator<T> r10 = r9.iterator();
        L54:
            if (r10.hasNext() == false) goto L47;
            CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r11 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r10.next();
            if (r11 == null) goto L54;
            String r12 = r11.getToken();
            if (r12 == null) goto L54;
            r5.ka0().m(r5.k, r12);
        L60:
            CommentBean r13 = new CommentBean();
            r13.setComment_list(r0);
            int r14 = CommentDiffUtils.a;
            BitableDiscussListAdapter r15 = this.a.q;
            if (r15 != null) goto L63;
            Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
            BitableDiscussListAdapter r16 = null;
        L64:
            BitableDiscussPanel r17 = this.a;
            p r19 = r17.k;
            String r20 = r17.ha0().i;
            if (r20 != null) goto L67;
            r20 = "";
        L67:
            CommentDiffUtils.a(r16, r19, r13, false, false, r20, false);
            BitableDiscussListAdapter r21 = this.a.q;
            if (r21 != null) goto L70;
            Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
            r21 = null;
        L70:
            r21.setCardPos(0);
            int r22 = h.a;
            if (FeatureGatingModule.getFeatureGatingService().isEnable("base.comment_optimization.enable") == false) goto L73;
            int r23 = 2131886345;
        L74:
            CommonActionPanelLayout r24 = this.a.o;
            if (r24 != null) goto L77;
            Intrinsics.throwUninitializedPropertyAccessException("mActionPanelLayout");
        L78:
            r6.setTitle(xo5.a.c(this.a.getContext(), r23, "num", String.valueOf(r0.size())));
            this.a.k.getActivity().runOnUiThread(new com.bytedance.ee.bear.middleground.comment.bitablediscuss.f(this.a));
            return;
        L77:
            r6 = r24;
            goto L78
        L73:
            r23 = 2131886340;
            goto L74
        L63:
            r16 = r15;
            goto L64
        L44:
            if (r4 != SharePermissionViewModel.PreviewPermissionState.STATE_INIT) goto L60;
        L32:
            if (r0.isEmpty() == true) goto L41;
            CommentBean r25 = this.a.ha0().u(this.a.D);
            if (r25 == null) goto L36;
            String r26 = r25.getCurrentReplyId();
        L38:
            if (TextUtils.isEmpty(r26) == true) goto L40;
            this.a.ha0().i = r26;
        L40:
            this.a.z = true;
            goto L41
        L36:
            r26 = null;
            goto L38
        L5:
            if (r0.isEmpty() == false) goto L14;
            BitableDiscussPanel r27 = this.a;
            if (r27.x == false) goto L14;
            r27.dismissAllowingStateLoss();     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r28 = DialogFragmentLancet.sLastShowStack;
            if (r28 == null) goto L97;
            com.bytedance.crash.d.d(r28, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ BitableDiscussPanel a;

        public f(BitableDiscussPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            BitableDiscussPanel r5 = this.a;
            int r0 = BitableDiscussPanel.H;
            ye5.a r6 = r5.ia0();
            if (r6 == null) goto L10;
            String r1 = r6.getCurrentTableId();
            if (r1 == null) goto L11;
            String r2 = r6.getCurrentRecordId();
            if (r2 == null) goto L12;
            r6.createNewDiscuss(r1, "", r2);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ BitableDiscussPanel a;

        public g(BitableDiscussPanel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            View r0 = this.a.s;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("bottomView");
            r0 = null;
        L6:
            if (r3.booleanValue() == true) goto L8;
        L10:
            int r4 = 8;
        L11:
            r0.setVisibility(r4);
            return;
        L8:
            if (this.a.la0() == true) goto L10;
            r4 = 0;
            goto L11
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Fa(CardCommentHeight r2) {
        Intrinsics.checkNotNullParameter(r2, "height");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void Hg() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void IX() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void LM() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Qa(FocusInputBean r2) {
        Intrinsics.checkNotNullParameter(r2, "focusInputBean");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void RL(com.bytedance.ee.bear.middleground.comment.export.bean.a r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final String UT() {
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void XC(String r1, String r2, String r3, String r4) {
        o1.a(r1, r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void bG(String r1, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2, SmartReplyDataForInsert r3) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void eX(com.bytedance.ee.bear.middleground.comment.export.bean.a r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void h5(Function0 r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void jN() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final q1 jV() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void r20(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void t2() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void tI(String r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void v2() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ boolean wB() {
        return false;
    }

    public final com.bytedance.ee.bear.middleground.comment.bitablediscuss.a ha0() {
        return (com.bytedance.ee.bear.middleground.comment.bitablediscuss.a) this.B.getValue();
    }

    public final ye5.a ia0() {
        y r0 = this.n;
        if ((r0 instanceof BitableDiscussFunction) == true) goto L5;
        return null;
    L5:
        return (ye5.a) r0;
    }

    public final SharePermissionViewModel ka0() {
        return (SharePermissionViewModel) this.C.getValue();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void v4() {
        this.v.a();
    }

    public final void ga0() {
        BottomSheetBehavior<FrameLayout> r0 = ja0();
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        if (r2 == true) goto L12;
        BottomSheetBehavior<FrameLayout> r1 = ja0();
        if (r1 == null) goto L13;
        r1.setState(3);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r0.getState() != 3) goto L7;
        r2 = true;
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final View getRootView() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        return (FrameLayout) r1.findViewById(2131367728);
    L7:
        return null;
    }

    public final BottomSheetBehavior<FrameLayout> ja0() {
        BottomSheetDialog r0 = getDialog();
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r1 = r0;
    L6:
        if (r1 == null) goto L10;
        AppCompatDelegate r2 = r1.getDelegate();
        if (r2 == null) goto L10;
        FrameLayout r3 = (FrameLayout) r2.findViewById(2131368870);
    L11:
        if (r3 != null) goto L13;
        return null;
    L13:
        return BottomSheetBehavior.from(r3);
    L10:
        r3 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final boolean la0() {
        if (ku5.c.k(getContext()) == false) goto L5;
        return false;
    L5:
        if (getResources().getConfiguration().orientation != 2) goto L10;
        return true;
    L10:
        return false;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        View r2 = null;
        if (this.x == true) goto L24;
        View r0 = this.s;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomView");
        r0 = null;
    L8:
        if (r0.getParent() != null) goto L20;
        Dialog r1 = getDialog();
        if (r1 == null) goto L14;
        Window r3 = r1.getWindow();
        if (r3 == null) goto L14;
        FrameLayout r4 = (FrameLayout) r3.findViewById(2131367728);
    L15:
        if (r4 == null) goto L20;
        View r5 = this.s;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("bottomView");
        r5 = null;
    L19:
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-1, -2);
        r6.gravity = 80;
        Unit r7 = Unit.INSTANCE;
        r4.addView(r5, r6);
    L14:
        r4 = null;
    L20:
        BottomSheetBehavior<FrameLayout> r8 = ja0();
        if (r8 == null) goto L23;
        r8.setHideable(true);
        r8.setPeekHeight((int) (n.z(getContext()) * this.w));
    L23:
        fa0(new AnonymousClass1(this));
    L24:
        View r9 = this.s;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("bottomView");
    L29:
        if (la0() == false) goto L31;
        int r10 = 8;
    L32:
        r2.setVisibility(r10);
        this.y = false;
        this.x = true;
        return;
    L31:
        r10 = 0;
        goto L32
    L27:
        r2 = r9;
        goto L29
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final com.bytedance.ee.bear.middleground.comment.card.d z7() {
        return ha0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final boolean isShowing() {
        return this.x;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void E7(String r3) {
        Intrinsics.checkNotNullParameter(r3, "commentId");
        ga0();
        ma0(r3, null, false);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Ni(boolean r2) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (getFragmentManager() == null) goto L18;
        dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L17;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L17:
        return;
    }

    public final void ea0(DialogInterface r5) {
        Intrinsics.checkNotNullParameter(r5, "dialog");
        if (this.x == true) goto L5;
    L7:
        this.l.k0().invoke();
        this.l.z0().invoke(Boolean.FALSE);
        SharePermissionViewModel r0 = ka0();
        if (r0.g.getValue() != SharePermissionViewModel.PreviewPermissionState.STATE_INIT) goto L10;
        r0.h = false;
    L10:
        super.onDismiss(r5);
        this.x = false;
        return;
    L5:
        if (((Boolean) this.l.T().d.invoke()).booleanValue() == false) goto L7;
        this.l.T().c.invoke();
        goto L7
    }

    public final void fa0(Function0<Unit> r4) {
        c r0 = new c(r4);
        ViewGroup r5 = this.p;
        ViewGroup r1 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("commentList");
        r5 = null;
    L5:
        r5.post(r0);
        ViewGroup r6 = this.p;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("commentList");
    L9:
        r1.addOnAttachStateChangeListener(new b(r0, this));
        return;
    L8:
        r1 = r6;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void hc(ScrollCommentBean r3) {
        Intrinsics.checkNotNullParameter(r3, "scrollCommentBean");
        ga0();
        ma0(r3.cur_comment_id, r3.replyId, false);
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super.onConfigurationChanged(r3);
        View r4 = this.s;
        CommonActionPanelLayout r0 = null;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bottomView");
        r4 = null;
    L6:
        if (la0() == false) goto L8;
        int r1 = 8;
    L9:
        r4.setVisibility(r1);
        int r5 = n.z(getContext());
        CommonActionPanelLayout r2 = this.o;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mActionPanelLayout");
    L13:
        r0.setMinimumHeight((int) (r5 * this.w));
        BottomSheetBehavior<FrameLayout> r6 = ja0();
        if (r6 == null) goto L17;
        r6.setHideable(true);
        r6.setPeekHeight((int) (n.z(getContext()) * this.w));
        return;
    L17:
        return;
    L12:
        r0 = r2;
        goto L13
    L8:
        r1 = 0;
        goto L9
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        CommentBean r3 = ha0().u(this.D);
        if (r3 == null) goto L5;
        String r4 = r3.getCurrentReplyId();
    L6:
        this.E = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r3) {
        return new OnBackPressBottomSheetDialog(this, requireContext(), getTheme());
    }

    public final void onDismiss(DialogInterface r2) {
        ea0(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void qN(boolean r1) {
        BitableDiscussListAdapter r2 = this.q;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
        r2 = null;
    L5:
        r2.notifyDataSetChanged();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.bitablediscuss.i
    public final void zT(int r4) {
        ViewGroup r0 = this.p;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("commentList");
        r0 = null;
    L5:
        View r2 = this.s;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomView");
    L9:
        r0.setPadding(0, 0, 0, (r1.getMeasuredHeight() + r4) + n.d(20));
        if (r4 <= 0) goto L13;
        ga0();
        return;
    L13:
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public static void da0(BitableDiscussPanel r3, FragmentManager r4) {
        if ((r3 instanceof Fragment) == false) goto L5;
        BitableDiscussPanel r0 = r3;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "BottomPanelComment", r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r3.show(r4, "BottomPanelComment");
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Q6(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        if (TextUtils.equals(r2, this.D) == false) goto L5;
        return;
    L5:
        ma0(r2, null, false);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void fj(String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "targetId");
        this.D = r3;
        com.bytedance.ee.bear.middleground.comment.bitablediscuss.a r5 = ha0();
        int r0 = com.bytedance.ee.bear.middleground.comment.card.d.l;
        r5.s(r3, null);
        this.k.d0.j("discussion");
        this.y = true;
        com.bytedance.ee.bear.appsetting.c r6 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r7 = LarkContext.getApplication();
        r6.getClass();
        UserSession r1 = ((com.ss.android.lark.passportc.convention.a) k.a(r7, com.ss.android.lark.passportc.convention.a.class)).b();
        if (((dn4.a) k.b(((v) k.a(r7, v.class)).c(r1), dn4.a.class)).a().isCurrentEnable("ccm.bitable.comment_forseti_fix_enable") == true) goto L5;
    L7:
        da0(this, this.k.getActivity().getSupportFragmentManager());
        return;
    L5:
        if (ForsetiHelper.s(this.k.b) == false) goto L7;
        da0(this, this.k.d());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.bitablediscuss.i
    public final void mq(String r1, String r2) {
        this.F = r1;
        this.G = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.widget.TextView] */
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r4, r5);
        com.bytedance.ee.bear.middleground.comment.bitablediscuss.a r6 = ha0();
        String r7 = this.D;
        int r0 = com.bytedance.ee.bear.middleground.comment.card.d.l;
        ?? r1 = 0;
        r6.s(r7, null);
        ka0().n();
        ha0().o.observe(this, new d(this));
        p r8 = this.k;
        r8.d0.c = false;
        r8.N.a(new ef5.i(null));
        com.bytedance.ee.bear.middleground.comment.bitablediscuss.a r9 = ha0();
        MutableLiveData<List<CommentBean>> r10 = r9.f;
        if (r10 == null) goto L5;
        r9.n.addSource(r10, r9.p);
    L5:
        r9.n.removeObservers(this);
        com.bytedance.ee.bear.middleground.comment.bitablediscuss.a r11 = ha0();
        MutableLiveData<List<CommentBean>> r12 = r11.f;
        if (r12 == null) goto L8;
        r11.n.addSource(r12, r11.p);
    L8:
        r11.n.observe(this, new e(this));
        RequestBuilder r13 = Glide.with(requireContext()).load(new BearGlideUrl(((h0) k.a(LarkContext.getApplication(), h0.class)).G2().avatarUrl)).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(2131235295);
        ImageView r14 = this.t;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("userAvatar");
        r14 = null;
    L11:
        r13.into(r14);
        UDAvatar r15 = this.t;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("userAvatar");
        r15 = null;
    L14:
        r15.setAvatarSize(n.d(32));
        CommentTextView r16 = this.u;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("commentInputTV");
    L18:
        r1.setOnClickListener(new f(this));
        ye5.a r17 = ia0();
        if (r17 == null) goto L24;
        LiveData<Boolean> r18 = r17.getCommentAble();
        if (r18 == null) goto L25;
        r18.observe(getViewLifecycleOwner(), new g(this));
        return;
    L25:
        return;
    L24:
        return;
    L17:
        r1 = r16;
        goto L18
    }

    @Override // com.bytedance.ee.bear.middleground.comment.bitablediscuss.i
    public final void H50(String r9, String r10, int r11) {
        BitableDiscussListAdapter r0 = this.q;
        BitableDiscussListAdapter r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
        r0 = null;
    L5:
        String r1 = r0.getHeightLightReplyId();
        if (r1 == null) goto L24;
        List r4 = (List) ha0().n.getValue();
        if (r4 == null) goto L15;
        int r5 = r4.size();
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L15;
        if (TextUtils.equals(((CommentBean.CommentDetail) ListProtector.get(r4, r6)).getReply_id(), r1) == true) goto L16;
        r6 = r6 + 1;
    L16:
        if (r6 == (-1)) goto L24;
        BitableDiscussListAdapter r3 = this.q;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
        r3 = null;
    L20:
        r3.heightLightComment(null, r11);
        BitableDiscussListAdapter r7 = this.q;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
        r7 = null;
    L23:
        r7.notifyItemChanged(r6);
    L15:
        r6 = -1;
    L24:
        if (r9 == null) goto L38;
        int r12 = ha0().v(r9, r10);
        if (r12 == (-1)) goto L39;
        BitableDiscussListAdapter r8 = this.q;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
        r8 = null;
    L30:
        r8.heightLightComment(r10, r11);
        BitableDiscussListAdapter r13 = this.q;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
    L34:
        r2.notifyItemChanged(r12);
        return;
    L33:
        r2 = r13;
        goto L34
    L39:
        return;
    }

    public final int ma0(String r4, String r5, boolean r6) {
        int r7 = ha0().v(r4, r5);
        if (r7 == (-1)) goto L29;
        int r8 = ((LinearLayoutManager) this.r.getValue()).findFirstVisibleItemPosition();
        int r0 = ((LinearLayoutManager) this.r.getValue()).findLastVisibleItemPosition();
        if (r7 < r8) goto L7;
        if (r7 <= r0) goto L29;
    L7:
        RecyclerView r1 = null;
        if (r6 == false) goto L15;
        RecyclerView r9 = this.p;
        if (r9 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("commentList");
    L13:
        r1.scrollToPosition(r7);
        goto L29
    L12:
        r1 = r9;
        goto L13
    L15:
        if (Math.abs(r8 - r7) <= 20) goto L17;
    L24:
        RecyclerView r10 = this.p;
        if (r10 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("commentList");
    L28:
        r1.scrollToPosition(r7);
        goto L29
    L27:
        r1 = r10;
        goto L28
    L17:
        if (Math.abs(r0 - r7) > 20) goto L24;
        RecyclerView r11 = this.p;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("commentList");
    L23:
        r1.smoothScrollToPosition(r7);
        goto L29
    L22:
        r1 = r11;
    L29:
        return r7;
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        CommonActionPanelLayout r2 = new CommonActionPanelLayout(requireContext());
        r2.setLeftIconVisible(true);
        r2.setDividerVisible(false);
        r2.setDragHandlerVisible(true);
        r2.setPanelBackgroundColor(2131100548);
        r2.setOnActionListener(new com.bytedance.ee.bear.middleground.comment.bitablediscuss.e(this));
        View r5 = r2.getConentContainer();
        if (r5 != null) goto L5;
    L7:
        r2.setMinimumHeight((int) (n.z(r2.getContext()) * this.w));
        this.o = r2;
        p r7 = this.k;
        r7.h.getClass();
        this.k.h.getClass();
        this.q = new BitableDiscussListAdapter(r7, CollectionsKt.listOf(new String[]{com.bytedance.ee.bear.middleground.comment.p.a(), null}), this.l, this.n, ka0(), ha0(), (String) this.A.getValue(), new BitableDiscussPanel$createContent$1(this));
        RecyclerView r3 = new RecyclerView(requireContext());
        BitableDiscussListAdapter r4 = this.q;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("commentAdapter");
        r4 = null;
    L10:
        r3.setAdapter(r4);
        r3.setLayoutManager((LinearLayoutManager) this.r.getValue());
        r3.setClipToPadding(false);
        r3.setDescendantFocusability(393216);
        CommonActionPanelLayout r6 = this.o;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mActionPanelLayout");
        r6 = null;
    L13:
        r6.addView(r3, -1, -1);
        this.p = r3;
        View r1 = r17.inflate(2131559202, r18, false);
        this.s = r1;
        if (r1 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("bottomView");
        r1 = null;
    L16:
        this.u = (CommentTextView) r1.findViewById(2131375331);
        View r8 = this.s;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("bottomView");
        r8 = null;
    L19:
        this.t = r8.findViewById(2131391983);
        int r9 = h.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("base.comment_optimization.enable") == false) goto L25;
        AppCompatTextView r10 = this.u;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("commentInputTV");
        r10 = null;
    L24:
        r10.setText(2131886343);
    L25:
        CommonActionPanelLayout r11 = this.o;
        if (r11 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mActionPanelLayout");
        return null;
    L29:
        return r11;
    L5:
        if ((r5.getLayoutParams() instanceof LinearLayout.LayoutParams) == false) goto L7;
        ViewGroup.LayoutParams r12 = r5.getLayoutParams();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) r12;
        r13.weight = 1.0f;
        r5.setLayoutParams(r13);
        goto L7
    }

    public BitableDiscussPanel(p r2, z r3, t r4, y r5) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "commentListeners");
        Intrinsics.checkNotNullParameter(r4, "dataControl");
        Intrinsics.checkNotNullParameter(r5, "actionControl");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.r = LazyKt.lazy(new BitableDiscussPanel$commentLayoutManager$2(this));
        this.v = new jf5.a(r2, r3);
        this.w = 0.5f;
        this.A = LazyKt.lazy(BitableDiscussPanel$language$2.INSTANCE);
        this.B = LazyKt.lazy(new BitableDiscussPanel$bitableDiscussDataViewModel$2(this));
        this.C = LazyKt.lazy(new BitableDiscussPanel$sharePermissionViewModel$2(this));
        this.D = "";
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void i8(String r10, String r11, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r12, int r13, CommentBean r14, CommentImageShowSource r15) {
        Intrinsics.checkNotNullParameter(r10, "commentId");
        Intrinsics.checkNotNullParameter(r11, "replyId");
        Intrinsics.checkNotNullParameter(r15, "showSource");
        this.v.c(r10, r11, r12, r13, true, r14, r15);
    }
}
