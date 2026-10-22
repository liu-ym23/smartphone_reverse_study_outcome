package com.bytedance.ee.bear.share.newshare;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareMinaConfig;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemUtil;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.share.ShareAnalytic;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceSettingGroupLayout;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.supervisor.token.Token;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.pb.security_event.AppDetail;
import com.ss.android.lark.pb.security_event.ContainerType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 ¥\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002¥\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010@\u001a\u00020AH&J\u0012\u0010B\u001a\u00020\u00172\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u00020\u0017H\u0016J\b\u0010F\u001a\u00020\u0017H\u0016J&\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u001a\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020H2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010O\u001a\u00020)2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010P\u001a\u00020\u0017H\u0016J\b\u0010Q\u001a\u00020\u0017H\u0016J\u001a\u0010R\u001a\u00020\u00172\b\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020)H\u0014J\b\u0010V\u001a\u00020\u0017H\u0016J\b\u0010W\u001a\u00020\u0007H\u0002J\b\u0010X\u001a\u00020\u0007H\u0014J\u0010\u0010Y\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010Z\u001a\u00020)2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010[\u001a\u00020)2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020)2\u0006\u0010\\\u001a\u00020]H\u0016J\b\u0010_\u001a\u00020`H\u0002J\u0010\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0002J\b\u0010c\u001a\u00020\u0017H\u0016J\b\u0010d\u001a\u00020\u0017H\u0016J\b\u0010e\u001a\u00020\u0017H\u0016J\b\u0010f\u001a\u00020\u0017H\u0016J\u0018\u0010g\u001a\u00020\u00172\u0006\u0010h\u001a\u00020)2\u0006\u0010i\u001a\u00020\u0007H\u0004J\u0018\u0010j\u001a\u00020\u00172\u0006\u0010k\u001a\u00020)2\u0006\u0010i\u001a\u00020\u0007H\u0002J\u0018\u0010l\u001a\u00020)2\u0006\u0010k\u001a\u00020)2\u0006\u0010i\u001a\u00020\u0007H\u0002J\u0010\u0010m\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0004J\b\u0010n\u001a\u00020\u0007H\u0004J\u000e\u0010o\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007J\b\u0010p\u001a\u00020\u0017H\u0016J\u0006\u0010q\u001a\u00020\u0017J\b\u0010r\u001a\u00020\u0017H\u0014J\"\u0010s\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;2\b\u0010t\u001a\u0004\u0018\u00010\u00072\u0006\u0010u\u001a\u00020`H\u0016J\b\u0010v\u001a\u00020\u0017H\u0016J\b\u0010w\u001a\u00020\u0017H\u0016J\b\u0010x\u001a\u00020\u0017H\u0016J\b\u0010y\u001a\u00020\u0017H\u0016J\b\u0010z\u001a\u00020\u0017H\u0016J\b\u0010{\u001a\u00020\u0017H\u0016J\u0006\u0010|\u001a\u00020\u0017J\b\u0010}\u001a\u00020\u0017H\u0014J\u0016\u0010~\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;2\u0006\u0010\u007f\u001a\u00020\u0007J\u0019\u0010\u0080\u0001\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;2\u0006\u0010\u007f\u001a\u00020\u0007H\u0014J\u001d\u0010\u0081\u0001\u001a\u00020\u00172\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0002J\u0018\u0010\u0086\u0001\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;2\u0007\u0010\u0087\u0001\u001a\u00020\u0007J#\u0010\u0088\u0001\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;2\u0007\u0010\u0089\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u008a\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u008b\u0001\u001a\u00020\u0017H\u0016J\f\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\u0012\u0010\u008d\u0001\u001a\u00020\u00172\u0007\u0010\u008e\u0001\u001a\u00020\u0007H\u0002J\u001d\u0010\u008d\u0001\u001a\u00020\u00172\u0007\u0010\u008e\u0001\u001a\u00020\u00072\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0007H\u0004J\u0013\u0010\u0090\u0001\u001a\u00020\u00172\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0004J\u0011\u0010\u0093\u0001\u001a\u00020\u00172\u0006\u0010t\u001a\u00020\u0007H\u0002J\t\u0010\u0094\u0001\u001a\u00020\u0017H\u0004J\u0013\u0010\u0095\u0001\u001a\u00020\u00172\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0004J\u0007\u0010\u0098\u0001\u001a\u00020\u0017J\u0007\u0010\u0099\u0001\u001a\u00020\u0017J\t\u0010\u009a\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u009b\u0001\u001a\u00020)H\u0002J$\u0010\u009c\u0001\u001a\u00020\u00172\u0007\u0010\u009d\u0001\u001a\u00020\u00072\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u009f\u0001\u001a\u00020)J'\u0010 \u0001\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070¡\u0001j\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`¢\u0001H\u0002J\n\u0010£\u0001\u001a\u00030¤\u0001H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u001b\u00100\u001a\u0002018DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b2\u00103R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006¦\u0001"}, d2 = {"Lcom/bytedance/ee/bear/share/newshare/BaseShareFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/shareview/OnShareItemClickListener;", "Lcom/bytedance/ee/bear/share/export/ISharePanel;", "<init>", "()V", "panelSession", "", "getPanelSession", "()Ljava/lang/String;", "shareExternalViewFromXml", "Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareView;", "getShareExternalViewFromXml", "()Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareView;", "setShareExternalViewFromXml", "(Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareView;)V", "shareTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getShareTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setShareTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "clearFromXmlViewCache", "", "params", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "getParams", "()Lcom/bytedance/ee/bear/share/export/ShareParams;", "setParams", "(Lcom/bytedance/ee/bear/share/export/ShareParams;)V", "originBearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "getOriginBearUrl", "()Lcom/bytedance/ee/bear/domain/BearUrl;", "setOriginBearUrl", "(Lcom/bytedance/ee/bear/domain/BearUrl;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "hasReportShowPanel", "", "permDependency", "Lcom/bytedance/ee/bear/middleground_permission_export/model/api/IPermissionService;", "getPermDependency", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/api/IPermissionService;", "permDependency$delegate", "Lkotlin/Lazy;", "permUIDependency", "Lcom/bytedance/ee/bear/middleground_permission_export/model/api/IShareUIService;", "getPermUIDependency", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/api/IShareUIService;", "permUIDependency$delegate", "externalShareMinaConfig", "Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareMinaConfig;", "mAnalyticService", "Lcom/bytedance/ee/bear/contract/AnalyticService;", "isCreateIn", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "getShareType", "()Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "setShareType", "(Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;)V", "buildShareItemModelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "initData", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "isEditionDoc", "onDestroyView", "onStart", "adjustWindowHeight", "attributes", "Landroid/view/WindowManager$LayoutParams;", "isLandscape", "onDestroy", "getSource", "getHandlerUrl", "doShareToType", "canShareToType", "canShareToCustom", "shareItem", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemModel;", "doShareToCustom", "getDoubaoShareObjType", "", "concatShareUrlForDoubao", ResourceData.KEY_URL, "onShareToLark", "onCopyLink", "onQRCode", "onPasswordLink", "onCopyLinkClicked", "hasPassword", "password", "copyLinkClick", "withPassword", "copyLink", "transformOfficeFolderCopyLink", "getShareUrl", "appendEditionParameter", "onShareMore", "shareOnMore", "doShareMore", "onCacControlled", ResourceData.KEY_TOKEN, ResourceData.KEY_TYPE, "onExportImage", "onSlideExport", "onShareToWechat", "onShareToWechatMoments", "onShareToQQ", "onShareToWeibo", "shareOnWeibo", "doShareToWeibo", "shareOnToTencentApp", "toPlatform", "doShareToTencentApp", "showExternalShareLinkTips", "shareInfo", "Lcom/bytedance/ee/bear/share/export/IShareInfo;", "externalShareCallback", "Lcom/bytedance/ee/bear/middleground_permission_export/model/ExternalShareCallback;", "showShareLinkDialog", "content", "performSdkShareH5", "title", "onCopyText", "onDownLoad", "getShareInfo", "reportShareAction", "platform", "flag", "auditShareAction", "app", "Lcom/ss/android/lark/pb/security_event/AppDetail;", "operationShareAction", "reportShowSharePanel", "showLoadFailedToast", "throwable", "", "hide", "show", "updatePermission", "isShareFragmentShowing", "setAnalyticCommonParams", "userPerm", "publicPerm", "fromVc", "getRenameMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getSpaceSettingGroupLayout", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceSettingGroupLayout;", "Companion", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseShareFragment extends BaseBottomSheetDialogFragment implements com.bytedance.ee.bear.bizwidget.shareview.b, com.bytedance.ee.bear.share.export.i {
    public static final /* synthetic */ int x = 0;
    public final String k;
    public ExternalShareView l;
    public BaseTitleBar m;
    public ShareParams n;
    public BearUrl o;
    public final CompositeDisposable p;
    public boolean q;
    public final Lazy r;
    public final Lazy s;
    public ExternalShareMinaConfig t;
    public com.bytedance.ee.bear.contract.d u;
    public boolean v;
    public ShareType w;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.Lark.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r0[ShareType.CopyLink.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r0[ShareType.QRCode.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r0[ShareType.PasswordLink.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r0[ShareType.ExportImage.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r0[ShareType.SlideExport.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[ShareType.Download.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r0[ShareType.Wechat.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r0[ShareType.WechatMoments.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r0[ShareType.QQ.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[ShareType.Weibo.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r0[ShareType.CopyText.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r0[ShareType.More.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            a = r0;
        }
    }

    public static final class c implements com.bytedance.ee.bear.middleground_permission_export.model.a {
        public final /* synthetic */ BaseShareFragment a;

        @Override // com.bytedance.ee.bear.middleground_permission_export.model.a
        public final void onComplete() {
            this.a.Ia0();
        }

        public c(BaseShareFragment r1) {
            this.a = r1;
        }
    }

    public static final class d implements com.bytedance.ee.bear.middleground_permission_export.model.a {
        public final /* synthetic */ BaseShareFragment a;
        public final /* synthetic */ ShareType b;
        public final /* synthetic */ String c;

        @Override // com.bytedance.ee.bear.middleground_permission_export.model.a
        public final void onComplete() {
            this.a.Ja0(this.b, this.c);
        }

        public d(BaseShareFragment r1, ShareType r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e implements com.bytedance.ee.bear.middleground_permission_export.model.a {
        public final /* synthetic */ BaseShareFragment a;

        @Override // com.bytedance.ee.bear.middleground_permission_export.model.a
        public final void onComplete() {
            this.a.Ka0();
        }

        public e(BaseShareFragment r1) {
            this.a = r1;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ BaseShareFragment a;
        public final /* synthetic */ String b;

        public f(BaseShareFragment r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            BaseShareFragment r6 = this.a;
            String r0 = this.b;
            int r1 = BaseShareFragment.x;
            r6.ja0(true, r0);
            String r7 = this.a.oa0().getToken();
            int r2 = this.a.oa0().getType();
            String r3 = this.a.oa0().getSubType();
            boolean r4 = this.a.oa0().isWiki();
            String r8 = com.bytedance.ee.bear.share.d.a;
            Intrinsics.checkNotNullParameter(r7, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r3, "subType");
            com.bytedance.ee.bear.share.d.d(r7, r2, r3, r4, "copy_link_and_password");
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ BaseShareFragment a;
        public final /* synthetic */ String b;

        public g(BaseShareFragment r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            BaseShareFragment r6 = this.a;
            String r0 = this.b;
            int r1 = BaseShareFragment.x;
            r6.ja0(false, r0);
            String r7 = this.a.oa0().getToken();
            int r2 = this.a.oa0().getType();
            String r3 = this.a.oa0().getSubType();
            boolean r4 = this.a.oa0().isWiki();
            String r8 = com.bytedance.ee.bear.share.d.a;
            Intrinsics.checkNotNullParameter(r7, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r3, "subType");
            com.bytedance.ee.bear.share.d.d(r7, r2, r3, r4, "copy_link");
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ BaseShareFragment a;

        public h(BaseShareFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            String r6 = this.a.oa0().getToken();
            int r0 = this.a.oa0().getType();
            String r1 = this.a.oa0().getSubType();
            boolean r2 = this.a.oa0().isWiki();
            String r3 = com.bytedance.ee.bear.share.d.a;
            Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r1, "subType");
            com.bytedance.ee.bear.share.d.d(r6, r0, r1, r2, DocFeed$Value$Result.CANCEL);
        }
    }

    public static final class i extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ BaseShareFragment c;

        public i(BaseShareFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class j implements com.bytedance.ee.bear.bizwidget.shareview.h.c {
        public final /* synthetic */ ShareType a;
        public final /* synthetic */ BaseShareFragment b;
        public final /* synthetic */ String c;

        public j(ShareType r1, BaseShareFragment r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            if (this.a != ShareType.Wechat) goto L6;
            com.bytedance.ee.bear.share.d.g(this.b.oa0().getToken(), this.b.oa0().getType(), this.b.oa0().getSubType(), this.b.oa0().isWiki(), true);
        L6:
            if (this.b.getContext() != null) goto L8;
            tt5.a.d("BaseShareFragment", "setOnShareBtnClickListener()....context == null");
            return;
        L8:
            if (this.a != ShareType.WechatMoments) goto L10;
            km5.c.f(this.b.requireContext());
        L20:
            this.b.dismissAllowingStateLoss();     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L22;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L22:
            return;
        L10:
            km5.c.j(this.b.requireContext(), this.a, this.c, null);
            goto L20
        }
    }

    public static final class k implements com.bytedance.ee.bear.bizwidget.shareview.h.c {
        public final /* synthetic */ ShareType a;
        public final /* synthetic */ BaseShareFragment b;

        public k(ShareType r1, BaseShareFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.a != ShareType.Wechat) goto L6;
            com.bytedance.ee.bear.share.d.g(this.b.oa0().getToken(), this.b.oa0().getType(), this.b.oa0().getSubType(), this.b.oa0().isWiki(), false);
            return;
        }
    }

    public static final class l implements com.bytedance.ee.bear.bizwidget.shareview.h.b {
        public final /* synthetic */ BaseShareFragment a;

        public l(BaseShareFragment r1) {
            this.a = r1;
        }

        public final void onDismiss() {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public void Pa0() {
    }

    public boolean Yl(ShareType r2) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        return true;
    }

    public void Z90(WindowManager.LayoutParams r1, boolean r2) {
    }

    public abstract km5.a ga0();

    public void ha0() {
        this.l = null;
        this.m = null;
    }

    public final boolean rF(ShareItemModel r2) {
        Intrinsics.checkNotNullParameter(r2, "shareItem");
        return true;
    }

    public com.bytedance.ee.bear.share.export.f sa0() {
        return null;
    }

    public final void Aa0() {
        tt5.a.h("BaseShareFragment", "onExportImage");
        this.w = ShareType.ExportImage;
        String r0 = oa0().getToken();
        if (wa0(oa0()) == false) goto L5;
        r0 = ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).s(r0, oa0().getEditionId());
    L5:
        com.bytedance.ee.bear.share.d.e(r0, oa0().getType(), oa0().getSubType(), oa0().isWiki());
        Ea0("gene_long_image");
        fa0(AppDetail.AppDetailUnknown);
        ((zk5.a) org.koin.java.a.c(zk5.a.class, null, null, 6)).a(sbb.e.d(oa0().getType()).b, r0, OperationName.OPERATION_DOWNLOAD);
    }

    public final void Ba0() {
        tt5.a.h("BaseShareFragment", "onQRCode");
        this.w = ShareType.QRCode;
        Ea0("qrcode");
        com.bytedance.ee.bear.share.d.c(oa0().getToken(), oa0().getType(), oa0().getSubType(), oa0().isWiki());
    }

    public final void Ca0() {
        tt5.a.h("BaseShareFragment", "onShareToLark");
        this.w = ShareType.Lark;
        Ea0("lark");
        String r0 = oa0().getToken();
        int r1 = oa0().getType();
        String r2 = oa0().getSubType();
        boolean r3 = oa0().isWiki();
        String r4 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r0, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r2, "subType");
        com.bytedance.ee.bear.share.d.f("share_lark", "ccm_permission_share_lark_view", new com.bytedance.ee.bear.share.c(r0, r1, r2, r3));
        String r5 = oa0().getToken();
        int r6 = oa0().getType();
        String r7 = oa0().getSubType();
        boolean r8 = oa0().isWiki();
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "subType");
        com.bytedance.ee.bear.share.d.h("ccm_permission_share_lark_view", r5, r6, r7, r8);
        y.a(oa0().getDocName(), na0());
        da0(this);
    }

    public final void Da0() {
        tt5.a.h("BaseShareFragment", "onSlideExport");
        this.w = ShareType.SlideExport;
        com.bytedance.ee.bear.share.d.e(oa0().getToken(), oa0().getType(), oa0().getSubType(), oa0().isWiki());
        Ea0("export");
    }

    public final void Ga0() {
        if (this.q == true) goto L6;
        this.q = true;
        com.bytedance.ee.bear.share.export.f r0 = sa0();
        String[] r1 = ShareAnalytic.a;
        Intrinsics.checkNotNullParameter("show_share_page", "eventName");
        ShareAnalytic.a(r0, "show_share_page", null);
        String r2 = oa0().getToken();
        int r3 = oa0().getType();
        String r4 = oa0().getSubType();
        boolean r5 = oa0().isWiki();
        String r6 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "subType");
        com.bytedance.ee.bear.share.d.h("ccm_permission_share_view", r2, r3, r4, r5);
        return;
    }

    public void ka0() {
        c r0 = new c(this);
        com.bytedance.ee.bear.share.export.f r1 = sa0();
        Intrinsics.checkNotNull(r1);
        La0(r1, r0);
    }

    public void ma0() {
        e r0 = new e(this);
        com.bytedance.ee.bear.share.export.f r1 = sa0();
        Intrinsics.checkNotNull(r1);
        La0(r1, r0);
    }

    public final ShareParams oa0() {
        ShareParams r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return null;
    }

    public final cj5.c pa0() {
        return (cj5.c) this.s.getValue();
    }

    public final HashMap<String, String> qa0() {
        HashMap<String, String> r0 = new HashMap();
        r0.put("Doc_name", oa0().getDocName());
        r0.put("Doc_url", Oa0(ia0(ua0())));
        r0.put("emoji", "👉");
        return r0;
    }

    public final ExternalShareView ra0() {
        View r0 = this.l;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131386051);
    L8:
        this.l = (ExternalShareView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (ExternalShareView) r0;
    }

    public final BaseTitleBar ta0() {
        View r0 = this.m;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131386145);
    L8:
        this.m = (BaseTitleBar) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (BaseTitleBar) r0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.LinearLayout, com.bytedance.ee.bear.widgets.universedesign.SpaceSettingGroupLayout, com.larksuite.component.ignition.widget.setting_group.SettingGroupLayout] */
    public final SpaceSettingGroupLayout va0() {
        ?? r0 = new SpaceSettingGroupLayout(requireContext());
        r0.setItemBackgroundColor(2131101932);
        r0.setDividerBackgroundColor(2131100557);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        int r2 = com.bytedance.ee.util.ui.n.d(16);
        r1.leftMargin = r2;
        r1.rightMargin = r2;
        r1.topMargin = r2;
        r0.setLayoutParams(r1);
        return r0;
    }

    public final void ya0() {
        tt5.a.h("BaseShareFragment", "onCopyLink");
        this.w = ShareType.CopyLink;
        Ea0("copy");
        com.bytedance.ee.bear.share.d.c(oa0().getToken(), oa0().getType(), oa0().getSubType(), oa0().isWiki());
    }

    public BaseShareFragment() {
        this.k = String.valueOf(hashCode());
        this.p = new CompositeDisposable();
        this.r = LazyKt.lazy(BaseShareFragment$permDependency$2.INSTANCE);
        this.s = LazyKt.lazy(BaseShareFragment$permUIDependency$2.INSTANCE);
        this.t = new ExternalShareMinaConfig();
        this.v = true;
    }

    public final void Ia0() {
        if (getActivity() != null) goto L6;
        tt5.a.d("BaseShareFragment", "onShareMore()...activity is null");
        return;
    L6:
        km5.c.b(getActivity(), ia0(ua0()));
        da0(this);
    }

    public final void Ka0() {
        if (getContext() != null) goto L6;
        tt5.a.d("BaseShareFragment", "onShareToWeibo()...context == null");
        return;
    L6:
        Context r0 = getContext();
        if (r0 == null) goto L12;
        String r1 = xo5.a.d(getContext(), 2131888254, qa0());
        ExternalShareMinaConfig r2 = this.t;
        ShareType r3 = ShareType.Weibo;
        if (r2.isShareChannelBanned(r3) == true) goto L11;
        km5.c.i(r0, r3, r1, null);
        goto L12
    L11:
        km5.c.j(r0, r3, r1, null);
    L12:
        da0(this);
    }

    public void initData() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        Object r1 = r0.getSerializable("extra_params");
    L7:
        if ((r1 instanceof ShareParams) == false) goto L9;
        ShareParams r2 = (ShareParams) r1;
    L10:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.n = r2;
        if (TextUtils.isEmpty(oa0().getOriginUrl()) == true) goto L13;
        this.o = s45.p.a().Z(oa0().getOriginUrl());
    L13:
        this.t = com.bytedance.ee.bear.appsetting.c.a.a.c("external_share_config", ExternalShareMinaConfig.class, new ExternalShareMinaConfig());
        return;
    L9:
        r2 = new ShareParams(requireActivity(), null, 2, null);
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public String na0() {
        if (TextUtils.isEmpty(oa0().getOriginUrl()) == false) goto L7;
        return oa0().getUrl();
    L7:
        if (oa0().getType() == sbb.e.l.b) goto L18;
        if (oa0().getType() == sbb.e.i.b) goto L18;
        if (wa0(oa0()) == false) goto L16;
        return ea0(oa0().getUrl());
    L16:
        return oa0().getUrl();
    L18:
        return oa0().getOriginUrl();
    }

    public void onDestroy() {
        super.onDestroy();
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).ga(null);
    }

    public void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        pa0().H9(this, SharePanelState.NOT_SHOW, ga0());
        this.p.dispose();
        ha0();
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Long r1 = null;
        if (this.u != null) goto L5;
        this.u = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
    L5:
        com.bytedance.ee.bear.contract.d r0 = this.u;
        Intrinsics.checkNotNull(r0);
        boolean r3 = true;
        r0.j("analytics_open_time_tag", "is_retry", Boolean.valueOf(!this.v));
        Bundle r2 = getArguments();
        if (r2 == null) goto L8;
        Long r4 = Long.valueOf(r2.getLong("analytics_open_time_t1_end", -1));
    L10:
        if (this.v == false) goto L27;
        Bundle r5 = getArguments();
        if (r5 == null) goto L15;
        r1 = Long.valueOf(r5.getLong("analytics_open_time_t1_start", -1));
    L15:
        if (r1 == null) goto L17;
        long r8 = r1.longValue();
    L19:
        if (r8 == (-1)) goto L27;
        if (r4 == null) goto L22;
        long r9 = r4.longValue();
    L24:
        if (r9 == (-1)) goto L27;
        Intrinsics.checkNotNull(r4);
        long r10 = r4.longValue();
        Intrinsics.checkNotNull(r1);
        long r11 = r10 - r1.longValue();
    L28:
        this.v = false;
        long r12 = System.currentTimeMillis();
        com.bytedance.ee.bear.contract.d r6 = this.u;
        Intrinsics.checkNotNull(r6);
        r6.j("analytics_open_time_tag", "t1", Integer.valueOf((int) r11));
        com.bytedance.ee.bear.contract.d r7 = this.u;
        Intrinsics.checkNotNull(r7);
        if (r4 == null) goto L31;
        long r13 = r4.longValue();
    L33:
        if (r13 != (-1)) goto L35;
        int r14 = 0;
    L36:
        r7.j("analytics_open_time_tag", "t2", Integer.valueOf(r14));
        com.bytedance.ee.bear.contract.d r15 = this.u;
        Intrinsics.checkNotNull(r15);
        r15.j("analytics_open_time_tag", "t2End", Long.valueOf(r12));
        com.bytedance.ee.bear.contract.d r16 = this.u;
        Intrinsics.checkNotNull(r16);
        r16.j("analytics_open_time_tag", "source", Integer.valueOf(oa0().getSource()));
        com.bytedance.ee.bear.contract.d r17 = this.u;
        Intrinsics.checkNotNull(r17);
        if (oa0().getType() == sbb.e.q.b) goto L40;
        r3 = false;
    L40:
        r17.j("analytics_open_time_tag", "is_minutes", Boolean.valueOf(r3));
        return;
    L35:
        Intrinsics.checkNotNull(r4);
        r14 = (int) (r12 - r4.longValue());
        goto L36
    L31:
        r13 = -1;
        goto L33
    L22:
        r9 = -1;
        goto L24
    L17:
        r8 = -1;
    L27:
        r11 = 0;
        goto L28
    L8:
        r4 = null;
        goto L10
    }

    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
    }

    public final String ua0() {
        String r0 = na0();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return "";
    L6:
        if (oa0().getType() == sbb.e.i.b) goto L8;
    L9:
        String r1 = UriProtector.parse(r0).buildUpon().clearQuery().toString();
        if (wa0(oa0()) == true) goto L12;
        return r1;
    L12:
        return ea0(r1);
    L8:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.share.add_extra_param") == false) goto L9;
        return r0;
    }

    public final boolean xa0() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L16;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L17;
        View r2 = r1.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L11:
        if (r2 != null) goto L13;
        return false;
    L13:
        if (r2.getVisibility() != 0) goto L19;
        return true;
    L19:
        return false;
    L17:
        return false;
    L16:
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.i
    public final String getPanelSession() {
        return this.k;
    }

    public static void da0(BaseShareFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void Ea0(String r4) {
        com.bytedance.ee.bear.share.export.f r0 = sa0();
        int r1 = oa0().getSource();
        if (r1 != 0) goto L5;
        String r2 = "left_slide";
    L9:
        String[] r3 = ShareAnalytic.a;
        Intrinsics.checkNotNullParameter(r4, "toPlatform");
        ShareAnalytic.b(r0, r2, r4, null);
        return;
    L5:
        if (r1 == 1) goto L7;
        r2 = "innerpage";
        goto L9
    L7:
        r2 = "grid_more";
        goto L9
    }

    public final void Ma0(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        if (ax4.d.b(r2, 1002) == false) goto L5;
    L8:
        Toast.showFailureText(getContext(), 2131887321);
        return;
    L5:
        if (ax4.d.b(r2, 4) == true) goto L8;
        Toast.showFailureText(getContext(), getString(2131888226));
    }

    public final String Oa0(String r5) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_URL);
        s45.i r0 = s45.i.a;
        int r1 = oa0().getType();
        boolean r2 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        r0.getClass();
        return s45.i.b(r5, r1, r2);
    }

    public final boolean U10(ShareItemModel r8) {
        Intrinsics.checkNotNullParameter(r8, "shareItem");
        tt5.a.h("BaseShareFragment", "doShareCustom, itemId: " + r8.getItemId());
        String r0 = ua0();
        boolean r2 = false;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0 = oa0().getUrl();
    L8:
        String r3 = ia0(r0);
        ShareItemModel.a r4 = r8.getOnClickedListener();
        if (r4 == null) goto L14;
        Context r5 = getContext();
        Context r6 = getContext();
        if (r6 != null) goto L13;
        r6 = LarkContext.getApplication();
    L13:
        Intrinsics.checkNotNull(r6);
        r2 = r4.a(r5, r8, new com.bytedance.ee.bear.share.g(r3, ShareItemUtil.b(r6, oa0().getDocName(), oa0().getType()), null, null));
    L14:
        if (r2 == false) goto L16;
        da0(this);
    L16:
        return r2;
    L5:
        r1 = false;
        goto L6
    }

    public final String ea0(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_URL);
        String r0 = oa0().getEditionId();
        if (r0 != null) goto L5;
        return r3;
    L5:
        return UriProtector.parse(r3).buildUpon().appendQueryParameter("edition_id", r0).toString();
    }

    public final void fa0(AppDetail r10) {
        Intrinsics.checkNotNullParameter(r10, "app");
        String r2 = "";
        if (r10 != AppDetail.AppDetailUnknown) goto L17;
        com.bytedance.ee.bear.middleground_permission_export.model.c r11 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        sbb.e r0 = sbb.e.d(oa0().getType());
        String r1 = oa0().getToken();
        if (oa0().isWiki() == false) goto L7;
        ContainerType r3 = ContainerType.Wiki;
    L9:
        if (oa0().isWiki() == false) goto L16;
        BearUrl r4 = this.o;
        if (r4 == null) goto L16;
        String r5 = r4.b;
        if (r5 == null) goto L16;
        r2 = r5;
    L16:
        r11.e(r0, r1, r3, r2);
        return;
    L7:
        r3 = ContainerType.ContainerTypeUnknown;
        goto L9
    L17:
        com.bytedance.ee.bear.middleground_permission_export.model.c r6 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        sbb.e r7 = sbb.e.d(oa0().getType());
        String r8 = oa0().getToken();
        if (oa0().isWiki() == false) goto L20;
        ContainerType r9 = ContainerType.Wiki;
    L21:
        ContainerType r12 = r9;
        if (oa0().isWiki() == false) goto L29;
        BearUrl r13 = this.o;
        if (r13 == null) goto L29;
        String r14 = r13.b;
        if (r14 == null) goto L29;
        String r15 = r14;
    L30:
        r6.c(r7, r8, r10, r12, r15);
        return;
    L29:
        r15 = "";
        goto L30
    L20:
        r9 = ContainerType.ContainerTypeUnknown;
        goto L21
    }

    public final String ia0(String r4) {
        t45.c r0 = s45.p.a();
        Integer r1 = Integer.valueOf(oa0().getRealType());
        if (r1.intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L11;
        int r3 = r1.intValue();
    L12:
        String r5 = r0.T6(r4, Integer.valueOf(r3));
        if (r5 != null) goto L16;
        return "";
    L16:
        return r5;
    L11:
        r3 = oa0().getType();
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        initData();
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).ga(this);
        this.v = true;
    }

    public void s10(ShareType r10) {
        Intrinsics.checkNotNullParameter(r10, "shareType");
        switch(b.a[r10.ordinal()]) {
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            case 8: goto L32;
            case 9: goto L25;
            case 10: goto L18;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L6;
            default: goto L5;
        };
    L6:
        tt5.a.h("BaseShareFragment", "onShareMore");
        this.w = ShareType.More;
        String r11 = oa0().getToken();
        int r4 = oa0().getType();
        String r5 = oa0().getSubType();
        boolean r6 = oa0().isWiki();
        String r7 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "subType");
        com.bytedance.ee.bear.share.d.f("share_more", "none", new com.bytedance.ee.bear.share.c(r11, r4, r5, r6));
        Ea0("more");
        fa0(AppDetail.Others);
        if (sa0() != null) goto L9;
        tt5.a.d("BaseShareFragment", "onShareMore()...mShareInfo is null!");
        return;
    L9:
        ka0();
        return;
    L10:
        tt5.a.h("BaseShareFragment", "onCopyText");
        this.w = ShareType.CopyText;
        return;
    L11:
        tt5.a.h("BaseShareFragment", "onShareToWeibo");
        ShareType r12 = ShareType.Weibo;
        this.w = r12;
        String r8 = oa0().getToken();
        int r9 = oa0().getType();
        String r13 = oa0().getSubType();
        boolean r14 = oa0().isWiki();
        String r15 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r13, "subType");
        com.bytedance.ee.bear.share.d.f("share_weibo", "none", new com.bytedance.ee.bear.share.c(r8, r9, r13, r14));
        Ea0("weibo");
        fa0(AppDetail.Weibo);
        if (km5.c.e(getContext(), r12) == true) goto L15;
        return;
    L15:
        if (sa0() != null) goto L17;
        tt5.a.d("BaseShareFragment", "onShareToWeibo()...mShareInfo is null!");
        return;
    L17:
        ma0();
        return;
    L18:
        tt5.a.h("BaseShareFragment", "onShareToQQ");
        ShareType r16 = ShareType.QQ;
        this.w = r16;
        String r17 = oa0().getToken();
        int r18 = oa0().getType();
        String r19 = oa0().getSubType();
        boolean r20 = oa0().isWiki();
        String r21 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r17, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r19, "subType");
        com.bytedance.ee.bear.share.d.f("share_qq", "none", new com.bytedance.ee.bear.share.c(r17, r18, r19, r20));
        Ea0("qq");
        fa0(AppDetail.QQ);
        if (km5.c.e(getContext(), r16) == true) goto L22;
        return;
    L22:
        if (sa0() != null) goto L24;
        tt5.a.d("BaseShareFragment", "onShareToQQ()...mShareInfo is null!");
        return;
    L24:
        la0(r16, "qq");
        return;
    L25:
        tt5.a.h("BaseShareFragment", "onShareToWechatMoments");
        ShareType r110 = ShareType.WechatMoments;
        this.w = r110;
        String r22 = oa0().getToken();
        int r23 = oa0().getType();
        String r24 = oa0().getSubType();
        boolean r25 = oa0().isWiki();
        String r26 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r22, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r24, "subType");
        com.bytedance.ee.bear.share.d.f("share_wechat_moments", "none", new com.bytedance.ee.bear.share.c(r22, r23, r24, r25));
        Ea0("wechat_article");
        fa0(AppDetail.WeChatMoments);
        if (km5.c.e(getContext(), r110) == true) goto L29;
        return;
    L29:
        if (sa0() != null) goto L31;
        tt5.a.d("BaseShareFragment", "onShareToWechatMoments()...mShareInfo is null!");
        return;
    L31:
        la0(r110, "wechat_article");
        return;
    L32:
        tt5.a.h("BaseShareFragment", "onShareToWechat");
        ShareType r111 = ShareType.Wechat;
        this.w = r111;
        String r0 = oa0().getToken();
        int r27 = oa0().getType();
        String r28 = oa0().getSubType();
        boolean r29 = oa0().isWiki();
        String r30 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r0, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r28, "subType");
        com.bytedance.ee.bear.share.d.f("share_wechat", "ccm_permission_share_wechat_view", new com.bytedance.ee.bear.share.c(r0, r27, r28, r29));
        Ea0("wechat");
        fa0(AppDetail.WeChat);
        if (km5.c.e(getContext(), r111) == true) goto L36;
        return;
    L36:
        if (sa0() != null) goto L38;
        tt5.a.d("BaseShareFragment", "onShareToWechat()...mShareInfo is null!");
        return;
    L38:
        la0(r111, "wechat");
        return;
    L39:
        tt5.a.h("BaseShareFragment", "onDownLoad");
        this.w = ShareType.Download;
        return;
    L40:
        Da0();
        return;
    L41:
        Aa0();
        return;
    L42:
        tt5.a.h("BaseShareFragment", "onPasswordLink()...");
        this.w = ShareType.PasswordLink;
        return;
    L43:
        Ba0();
        return;
    L44:
        ya0();
        return;
    L45:
        Ca0();
        return;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean wa0(ShareParams r4) {
        if (r4 != null) goto L4;
        return false;
    L4:
        if (r4.isAtVC() == false) goto L7;
        return false;
    L7:
        return ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).p(r4.getToken(), r4.getEditionId(), r4.isAtVC());
    }

    public final void Fa0(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "platform");
        com.bytedance.ee.bear.share.export.f r0 = sa0();
        int r1 = oa0().getSource();
        if (r1 != 0) goto L5;
        String r2 = "left_slide";
    L9:
        ShareAnalytic.b(r0, r2, r4, r5);
        return;
    L5:
        if (r1 == 1) goto L7;
        r2 = "innerpage";
        goto L9
    L7:
        r2 = "grid_more";
        goto L9
    }

    public final void Ja0(final ShareType r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "shareType");
        Intrinsics.checkNotNullParameter(r9, "toPlatform");
        if (getContext() != null) goto L6;
        tt5.a.d("BaseShareFragment", "shareToTencentApp()...context == null");
        return;
    L6:
        Dialog r0 = getDialog();
        if (r0 == null) goto L9;
        r0.hide();
    L9:
        boolean r1 = this.t.isShareChannelBanned(r8);
        boolean r2 = this.t.isShareDomainBanned(r8);
        com.bytedance.ee.bear.share.export.f r3 = sa0();
        if (r3 == null) goto L12;
        boolean r4 = r3.canExport();
    L14:
        if (r2 == false) goto L22;
        Fa0(r9, "2");
        if (oa0().getType() == sbb.e.g.b) goto L18;
    L21:
        String r10 = xo5.a.d(getContext(), 2131888214, qa0());
        Intrinsics.checkNotNull(r10);
        Na0(r8, r10);
        ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).p(r10, new Token("LARK-PSDA-ccm_android_share_dialog_set_clipboard_when_share_to_tencent_banned"));
        return;
    L18:
        if (oa0().getSource() != 2) goto L21;
        if (r4 == false) goto L21;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).m(r8.name());
        da0(this);
        return;
    L22:
        if (r1 == false) goto L33;
        Fa0(r9, "1");
        if (r8 == ShareType.WechatMoments) goto L26;
    L32:
        String r11 = xo5.a.d(getContext(), 2131888213, qa0());
        Intrinsics.checkNotNull(r11);
        Na0(r8, r11);
        ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(r11, false, new Token("LARK-PSDA-ccm_android_share_dialog_set_clipboard_when_share_to_tencent_channel_banned"));
        return;
    L26:
        if (oa0().getType() != sbb.e.g.b) goto L32;
        if (oa0().getSource() != 2) goto L32;
        if (r4 == false) goto L32;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).m(r8.name());
        da0(this);
        return;
    L33:
        Fa0(r9, "0");
        if (r8 == ShareType.Wechat) goto L36;
    L40:
        com.bytedance.ee.bear.share.i.a((NetService) org.koin.java.a.c(NetService.class, null, null, 6), String.valueOf(oa0().getType()), oa0().getToken(), new BaseShareFragment$shareOnToTencentApp$2(this, r8));
        return;
    L36:
        if (this.t.isEnableShareMiniApp() == false) goto L40;
        Context r12 = getContext();
        if (r12 == null) goto L45;
        km5.c.h(r12, ia0(ua0()), oa0());
        da0(this);
        return;
    L45:
        return;
    L12:
        r4 = false;
        goto L14
    }

    public final void La0(com.bytedance.ee.bear.share.export.f r14, com.bytedance.ee.bear.middleground_permission_export.model.a r15) {
        cj5.c r0 = pa0();
        Context r1 = getContext();
        int r2 = oa0().getType();
        String r3 = r14.j();
        if (r14.isLinkShareAnyoneRead() == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        r0.C8(r1, r2, r3, r4, r14.e(), r14.adminCanCross(), r14.externalAccess(), r14.i(), r15, oa0().getSubType(), oa0().isWiki(), r14.g());
        return;
    L5:
        if (r14.isLinkShareAnyoneEdit() == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void Na0(ShareType r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "shareType");
        Intrinsics.checkNotNullParameter(r7, "content");
        com.bytedance.ee.bear.bizwidget.shareview.h.a r0 = new com.bytedance.ee.bear.bizwidget.shareview.h.a(getContext());
        r0.a(r6);
        String r1 = getResources().getString(2131888225);
        r0.a.c.setText(r1);
        r0.a.d.setVisibility(0);
        r0.a.d.setText(r7);
        Context r2 = getContext();
        if (r6 != ShareType.WechatMoments) goto L5;
        int r3 = 2131888247;
    L6:
        String r4 = xo5.a.c(r2, r3, "channelName", km5.c.c(getContext(), r6));
        r0.a.g.setText(r4);
        j r5 = new j(r6, this, r7);
        r0.a.e.setOnClickListener(new com.bytedance.ee.bear.bizwidget.shareview.f(r0, r5));
        k r8 = new k(r6, this);
        r0.a.h.setOnClickListener(new com.bytedance.ee.bear.bizwidget.shareview.e(r0, r8));
        l r9 = new l(this);
        r0.a.b.setOnDismissListener(new com.bytedance.ee.bear.bizwidget.shareview.g(r9));
        r0.b();
        if (r6 != ShareType.Wechat) goto L10;
        String r10 = oa0().getToken();
        int r11 = oa0().getType();
        String r12 = oa0().getSubType();
        boolean r13 = oa0().isWiki();
        String r14 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r12, "subType");
        com.bytedance.ee.bear.share.d.h("ccm_permission_share_wechat_view", r10, r11, r12, r13);
        return;
    L10:
        return;
    L5:
        r3 = 2131888236;
        goto L6
    }

    public final void ja0(boolean r5, String r6) {
        String r0 = Oa0(ua0());
        if (r5 == false) goto L20;
        HashMap r1 = new HashMap();
        r1.put("APP_DISPLAY_NAME", getString(2131890277));
        r1.put("link", r0);
        r1.put("password", r6);
        r0 = xo5.a.d(getContext(), 2131887765, r1);
    L20:
        boolean r2 = ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(r0, false, new Token("LARK-PSDA-ccm_android_share_dialog_copy_link"));     // Catch: Exception -> L8
    L10:
        if (r2 == false) goto L17;
        if (r5 == false) goto L14;
        Toast.showSuccessText(getContext(), getString(2131887723), 0);
    L18:
        da0(this);
        return;
    L14:
        if (wa0(oa0()) == false) goto L16;
        Toast.showSuccessText(getContext(), getString(2131889373), 0);
        goto L18
    L16:
        Toast.showSuccessText(getContext(), getString(2131887727), 0);
        goto L18
    L17:
        Toast.showFailureText(getContext(), getString(2131887724), 0);
    L8:
        e = move-exception;
        tt5.a.f("BaseShareFragment", e, false);
        r2 = false;
        goto L10
    }

    public void la0(ShareType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        Intrinsics.checkNotNullParameter(r3, "toPlatform");
        d r0 = new d(this, r2, r3);
        com.bytedance.ee.bear.share.export.f r4 = sa0();
        Intrinsics.checkNotNull(r4);
        La0(r4, r0);
    }

    public void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r5, r6);
        ra0().setOnShareItemClickListener(this);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).h(oa0().getToken(), oa0().getType());
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
        ta0().setLeftClickListener(new i(this));
        ta0().setMainTitleSize(17.0f);
        if (wa0(oa0()) == false) goto L11;
        ExternalShareView r7 = ra0();
        ShareType r8 = ShareType.CopyLink;
        String r0 = getString(2131889374);
        Iterator r1 = ((ArrayList) r7.f).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ShareItemModel r2 = (ShareItemModel) r1.next();
        if (r2.getType() != r8) goto L6;
        r2.setDescription(r0);
    L10:
        r7.e.y2(r7.f);
        r7.e.notifyDataSetChanged();
        ra0().setEditionDoc(true);
    L11:
        pa0().H9(this, SharePanelState.SHOWING, ga0());
    }

    public final void za0(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "password");
        if (r4 == true) goto L5;
    L7:
        ja0(false, r5);
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L7;
        com.bytedance.ee.bear.widgets.a r0 = new com.bytedance.ee.bear.widgets.a(getContext());
        r0.k(getString(2131887725));
        r0.g(getString(2131887722), new f(this, r5));
        r0.g(getString(2131887726), new g(this, r5));
        r0.b(new h(this));
        r0.q();
        String r6 = oa0().getToken();
        int r7 = oa0().getType();
        String r1 = oa0().getSubType();
        boolean r2 = oa0().isWiki();
        String r3 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r1, "subType");
        com.bytedance.ee.bear.share.d.h("ccm_permission_copy_link_view", r6, r7, r1, r2);
    }

    public final void Ha0(String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "userPerm");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
        jg5.k.a.a.e(oa0().getToken(), oa0().getType(), oa0().getSubType(), oa0().isWiki(), r13, r14, r15, oa0().getModule(), oa0().getSubModule());
        String r1 = oa0().getModule();
        String r2 = oa0().getSubModule();
        String r3 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r13, "userPerm");
        com.bytedance.ee.bear.share.d.a = r13;
        String r0 = "";
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        com.bytedance.ee.bear.share.d.b = r14;
        com.bytedance.ee.bear.share.d.c = r15;
        if (r1 != null) goto L8;
        String r16 = "";
    L9:
        com.bytedance.ee.bear.share.d.d = r16;
        if (r2 == null) goto L13;
        r0 = r2;
    L13:
        com.bytedance.ee.bear.share.d.e = r0;
        tt5.a.h("ShareAnalyticV2", "setCommonParams()...userPerm:" + r13 + ", isFromVc:" + r15 + ", module:" + r1 + ", subModule: " + r2);
        return;
    L8:
        r16 = r1;
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564510, r3, false);
    }

    public final void xq(ShareType r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "shareType");
        tt5.a.h("BaseShareFragment", "onCacControlled, shareType: " + r6 + ", token: " + r7 + ", type: " + r8);
        this.w = r6;
        if (r6 != ShareType.ExportImage) goto L13;
        gj5.c r9 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, r8, r7);
        if (r9.a == true) goto L13;
        if (r9.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L13;
        tt5.a.h("BaseShareFragment", "onCacControlled - ExportImage disabled by cac.");
        ValidateResult r10 = r9.c;
        if (r10 == null) goto L16;
        r10.handleAction();
        return;
    L16:
        return;
    L13:
        if (r8 == 12) goto L17;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, r8, "");
        return;
    }
}
