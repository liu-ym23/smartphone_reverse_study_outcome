package com.bytedance.ee.bear.share.newshare;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.document.share.SharePlugin;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.external.AdjustExternalResult;
import com.bytedance.ee.bear.middleground.permission.external.EntityType;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.parcel.BinderParcel;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.share.export.BitableShareRoleMember;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.notification.ShareNotifySetView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.ignition.widget.setting_group.SettingGroupLayout;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.doc.IReminder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.lark.android.encryption.CipherManager;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ¢\u00012\u00020\u00012\u00020\u0002:\u0002¢\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010=\u001a\u00020\u001bH\u0016J\b\u0010>\u001a\u00020%H\u0002J\u001a\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u00122\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J \u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%H\u0002J\u0010\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020%2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010K\u001a\u00020I2\u0006\u0010F\u001a\u00020%H\u0002J\b\u0010L\u001a\u00020IH\u0016J\b\u0010M\u001a\u00020\u001bH\u0016J\b\u0010N\u001a\u00020%H\u0016J\u0010\u0010O\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020QH\u0016J\u001a\u0010R\u001a\u00020\u001b2\b\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020%H\u0014J\u0010\u0010V\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010W\u001a\u00020\u001bH\u0002J\u0012\u0010X\u001a\u00020\u001b2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010Y\u001a\u00020\u001b2\u0006\u0010Z\u001a\u00020[H\u0002J!\u0010\\\u001a\u00020\u001b2\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0002\u0010`J\u0012\u0010a\u001a\u00020\u001b2\b\u0010]\u001a\u0004\u0018\u00010^H\u0002J\b\u0010b\u001a\u00020\u001bH\u0002J\b\u0010c\u001a\u00020\u001bH\u0016J\b\u0010d\u001a\u00020\u001bH\u0016J\b\u0010e\u001a\u00020\u001bH\u0002J\b\u0010f\u001a\u00020\u001bH\u0002J\b\u0010g\u001a\u00020\u001bH\u0002J\b\u0010h\u001a\u00020\u001bH\u0002J\u0010\u0010i\u001a\u00020\u001b2\u0006\u0010j\u001a\u00020kH\u0002J\u0018\u0010l\u001a\u00020\u001b2\u0006\u0010m\u001a\u00020)2\u0006\u0010n\u001a\u00020%H\u0002J\u0010\u0010o\u001a\u00020\u001b2\u0006\u0010m\u001a\u00020)H\u0002J\n\u0010p\u001a\u0004\u0018\u00010qH\u0016J\u0010\u0010r\u001a\u00020%2\u0006\u0010s\u001a\u00020tH\u0016J\u0010\u0010u\u001a\u00020\u001b2\u0006\u0010s\u001a\u00020tH\u0016J\u0010\u0010v\u001a\u00020%2\u0006\u0010s\u001a\u00020tH\u0002J\u0010\u0010w\u001a\u00020%2\u0006\u0010s\u001a\u00020tH\u0002J\b\u0010x\u001a\u00020\u001bH\u0014J\u0018\u0010y\u001a\u00020\u001b2\u0006\u0010s\u001a\u00020t2\u0006\u0010z\u001a\u00020^H\u0014J\b\u0010{\u001a\u00020\u001bH\u0014J\b\u0010|\u001a\u00020%H\u0002J\b\u0010}\u001a\u00020\u001bH\u0002J\u0018\u0010~\u001a\u00020\u001b2\u0006\u0010m\u001a\u00020)2\u0006\u0010s\u001a\u00020tH\u0002J\b\u0010\u007f\u001a\u00020%H\u0002J\u0019\u0010\u0080\u0001\u001a\u00020\u001b2\u0006\u0010m\u001a\u00020)2\u0006\u0010s\u001a\u00020tH\u0002J\t\u0010\u0081\u0001\u001a\u00020%H\u0002J\t\u0010\u0082\u0001\u001a\u00020\u001bH\u0002J\t\u0010\u0083\u0001\u001a\u00020^H\u0014J\u0013\u0010\u0084\u0001\u001a\u00020\u001b2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\t\u0010\u0087\u0001\u001a\u00020\u001bH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020\u001b2\u0007\u0010\u0089\u0001\u001a\u00020!H\u0016J\u000b\u0010\u008a\u0001\u001a\u0004\u0018\u00010^H\u0002J}\u0010\u008b\u0001\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020!2\u0007\u0010\u008c\u0001\u001a\u00020^2\u0007\u0010\u008d\u0001\u001a\u00020^2\u0007\u0010\u008e\u0001\u001a\u00020!2\u0007\u0010\u008f\u0001\u001a\u00020^2\u0007\u0010\u0090\u0001\u001a\u00020^2\u0007\u0010\u0091\u0001\u001a\u0002052\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0017\u0010\u0094\u0001\u001a\u0012\u0012\u0004\u0012\u00020^\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u0095\u00012\t\u0010\u0097\u0001\u001a\u0004\u0018\u000105H\u0016JG\u0010\u0098\u0001\u001a\u00020\u001b2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00012\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u009f\u0001\u001a\u0002052\u0007\u0010 \u0001\u001a\u000205H\u0016J\t\u0010¡\u0001\u001a\u00020%H\u0002R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010#\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006£\u0001"}, d2 = {"Lcom/bytedance/ee/bear/share/newshare/ShareDocFragment;", "Lcom/bytedance/ee/bear/share/newshare/BaseShareFragment;", "Lcom/bytedance/ee/bear/middleground/permission/external/AdjustExternalListener;", "<init>", "()V", "shareContainerFromXml", "Landroid/widget/LinearLayout;", "getShareContainerFromXml", "()Landroid/widget/LinearLayout;", "setShareContainerFromXml", "(Landroid/widget/LinearLayout;)V", "editionBottomCancelFromXml", "Landroid/widget/TextView;", "getEditionBottomCancelFromXml", "()Landroid/widget/TextView;", "setEditionBottomCancelFromXml", "(Landroid/widget/TextView;)V", "cancelDividerFromXml", "Landroid/view/View;", "getCancelDividerFromXml", "()Landroid/view/View;", "setCancelDividerFromXml", "(Landroid/view/View;)V", "contentLayoutFromXml", "getContentLayoutFromXml", "setContentLayoutFromXml", "clearFromXmlViewCache", "", "onDestroyView", "reminder", "Lcom/ss/android/lark/doc/IReminder;", "disabledShareTypes", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "badgeShareTypes", "shareItemCanExport", "", "shareItemPerceiveControl", "shareItemUpdate", "shareDocInfo", "Lcom/bytedance/ee/bear/middleground/permission/share/info/ShareDocInfo;", "publicPerm", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "collAvatarView", "linkShareView", "permSetView", "bitableProView", "notifySetView", "Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView;", "showNotifySetView", "visibleSecretList", "", "Lcom/bytedance/ee/bear/secret/SecretLevel;", "fetchSecretDisposable", "Lio/reactivex/disposables/Disposable;", "enableBitableItem", "enableBitableShareTip", "permissionChangePush", "Lcom/bytedance/ee/space/push/PushObserver;", "secretChangePush", "initData", "onlyShareNotify", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "updateExternalShareView", "canExport", "perceiveControl", "update", "updateShareItems", "modelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "hideTopArea", "buildModelParams", "buildShareItemModelParams", "onStart", "isSupportScreenLandscape", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "adjustWindowHeight", "attributes", "Landroid/view/WindowManager$LayoutParams;", "isLandscape", "changeLayout", "initPeekHeight", "onCreate", "initPush", "params", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "initSecretPush", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "(Ljava/lang/String;Ljava/lang/Integer;)V", "initPermissionPush", "destroyPush", "onDestroy", "updatePermission", "fetchDocPermAndInfo", "fetchVisibleSecret", "disposeSecretFetching", "updateView", "failToFetchPerm", "throwable", "", "updatePermSetInfoToView", "shareInfo", "hasFetchPublicPerm", "updateViewStatus", "getShareInfo", "Lcom/bytedance/ee/bear/share/export/IShareInfo;", "canShareToType", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "doShareToType", "canShareToExternal", "canPassLinkShareGuard", "doShareToWeibo", "doShareToTencentApp", "toPlatform", "doShareMore", "canOpenPasswordLink", "openPasswordLink", "showSafeTipsDialog", "checkUsableSecret", "showAdjustExternalPanel", "canExportImage", "exportImage", "getHandlerUrl", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onResume", "onAdjustFinished", "result", "getTips", "notifyShowSecretApprovalDialog", "secLabelId", "secLabelName", "level", "applyTips", WikiFolderPushPlugin.WIKI_TOKEN, "oldSecretLevel", "defModel", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretApprovalDefModel;", "extraParams", "", "Ljava/io/Serializable;", "newSecretLevel", "notifyShowSecLabelResubmitApprovalDialog", "confirmListener", "Landroid/content/DialogInterface$OnClickListener;", "cancelListener", "secretApprovalInstanceModel", "Lcom/bytedance/ee/bear/secret/SecretApprovalInstanceModel;", "secretApprovalDefModel", "targetSecretLevel", "originSecretLevel", "isDisableShareChannel", "Companion", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ShareDocFragment extends BaseShareFragment implements th5.a {
    public static com.bytedance.ee.bear.share.export.h U;
    public View A;
    public LinearLayout B;
    public IReminder C;
    public boolean D;
    public boolean E;
    public boolean F;
    public ShareDocInfo G;
    public IDocPublicPermission H;
    public View I;
    public View J;
    public View K;
    public View L;
    public ShareNotifySetView M;
    public boolean N;
    public List<SecretLevel> O;
    public Disposable P;
    public final boolean Q;
    public final boolean R;
    public i S;
    public j T;
    public LinearLayout y;
    public TextView z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.Wechat.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[ShareType.WechatMoments.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[ShareType.QQ.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[ShareType.More.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[ShareType.PasswordLink.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[ShareType.ExportImage.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[ShareType.CopyLink.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[ShareType.Lark.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[ShareType.SlideExport.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            a = r0;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ShareDocFragment a;

        public c(ShareDocFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            VisibleSecretResult r4 = (VisibleSecretResult) r3;
            Intrinsics.checkNotNullParameter(r4, "visibleSecretResult");
            tt5.a.h("ShareDocFragment", "fetchVisibleSecret()...visibleSecretResult = " + r4);
            this.a.O = (List) ((Result) r4).data;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            tt5.a.h("ShareDocFragment", "fetchVisibleSecret()...error = " + r4);
        }
    }

    public static final class e extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ boolean c;
        public final /* synthetic */ ShareDocFragment d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            if (this.c == false) goto L14;
            com.bytedance.ee.bear.document.share.a.a r6 = ShareDocFragment.U;
            if (r6 == null) goto L16;
            r6.a();
        L16:
            this.d.dismissAllowingStateLoss();     // Catch: Exception -> L10
        L10:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L14;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        L14:
            String r8 = com.bytedance.ee.bear.share.d.a;
            String r9 = this.d.oa0().getToken();
            int r0 = this.d.oa0().getType();
            String r1 = this.d.oa0().getSubType();
            boolean r2 = this.d.oa0().isWiki();
            Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r1, "subType");
            com.bytedance.ee.bear.share.d.f("bitable_premium_permission_go_check", "ccm_bitable_premium_permission_setting_view", new com.bytedance.ee.bear.share.c(r9, r0, r1, r2));
        }

        public e(boolean r1, ShareDocFragment r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ ShareDocFragment a;

        public f(ShareDocFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Dialog r5 = this.a.getDialog();
            if (r5 == null) goto L21;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r5));
            return;
        }
    }

    public static final class g implements DialogInterface.OnClickListener {
        public final /* synthetic */ ShareDocFragment a;
        public final /* synthetic */ ShareDocInfo b;
        public final /* synthetic */ ShareType c;

        public g(ShareDocFragment r1, ShareDocInfo r2, ShareType r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r14, int r15) {
            tt5.a.h("ShareDocFragment", "showAnyOneLinkShareTipsDialog()...click confirm.");
            ShareDocFragment r16 = this.a;
            ShareDocInfo r0 = this.b;
            ShareType r1 = this.c;
            com.bytedance.ee.bear.share.export.h r2 = ShareDocFragment.U;
            r16.getClass();
            tt5.a.h("ShareDocFragment", "showAdjustExternalPanel()...");
            Context r4 = r16.getContext();
            if (r4 == null) goto L6;
            th5.b r17 = new th5.b(r4, r0.c, r0.getType(), r16.oa0().isWiki(), com.bytedance.ee.bear.share.externalshare.external.g.d(r1), EntityType.LINK_SHARE_ANYONE_READABLE, r0.f.getShareExternal(), r0.f.getSharePartnerTenant(), com.bytedance.ee.bear.share.externalshare.external.g.b(r0));
            ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).Ee(r17);
            return;
        }
    }

    public static final class h implements DialogInterface.OnClickListener {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            tt5.a.h("ShareDocFragment", "showAnyOneLinkShareTipsDialog()...click cancel.");
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void Pa0() {
        tt5.a.h("ShareDocFragment", "fetchDocPermAndInfo() called");
        ((cj5.b) this.r.getValue()).aa().a(oa0().getToken(), oa0().getType());
        Flowable<IDocUserPermission> r0 = ((cj5.b) this.r.getValue()).aa().c(oa0().getToken(), oa0().getType());
        Flowable<IDocPublicPermission> r1 = ((cj5.b) this.r.getValue()).aa().b(oa0().getToken(), oa0().getType());
        Flowable r2 = ((a4) org.koin.java.a.c(a4.class, null, null, 6)).b(oa0().getToken(), oa0().getType());
        Flowable<DocVersion> r3 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).f(oa0().getToken(), oa0().getType());
        Ref.BooleanRef r4 = new Ref.BooleanRef();
        Disposable r5 = Flowable.zip(r0, r2, r3, new com.bytedance.ee.bear.share.newshare.d(this)).observeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.share.newshare.e(this, r4), new com.bytedance.ee.bear.share.newshare.f(this));
        Disposable r6 = r1.subscribe(new com.bytedance.ee.bear.share.newshare.g(this, r4), new com.bytedance.ee.bear.share.newshare.h(r4, this));
        Wa0();
        this.p.add(r5);
        this.p.add(r6);
    }

    public final boolean Ua0() {
        if (this.O != null) goto L6;
        Wa0();
        return false;
    L6:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        jg5.e r0 = jg5.e.a.a;
        List<SecretLevel> r1 = this.O;
        ShareType r2 = this.w;
        if (r2 != null) goto L10;
        r2 = ShareType.PasswordLink;
    L10:
        return hu5.a.f(com.bytedance.ee.bear.middleground.permission.secret.b0.c(r1, com.bytedance.ee.bear.share.externalshare.external.g.d(r2), EntityType.LINK_SHARE_ANYONE_READABLE));
    }

    public final void Wa0() {
        tt5.a.h("ShareDocFragment", "fetchVisibleSecret()...");
        Disposable r0 = this.P;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        Disposable r2 = this.P;
        if (r2 == null) goto L12;
        r2.dispose();
    L12:
        jg5.j r3 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r4 = oa0().getToken();
        int r5 = oa0().getType();
        r3.getClass();
        this.P = com.bytedance.ee.bear.middleground.permission.secret.p.a(r4, r5).subscribe(new c(this), d.a);
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r1 = true;
        goto L8
    }

    public final View Xa0() {
        View r0 = this.A;
        if (r0 != null) goto L9;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131365117);
    L8:
        this.A = r0;
        goto L9
    L7:
        r0 = null;
    L9:
        return r0;
    }

    public final LinearLayout Ya0() {
        View r0 = this.B;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131367798);
    L8:
        this.B = (LinearLayout) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (LinearLayout) r0;
    }

    public final TextView Za0() {
        View r0 = this.z;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131371475);
    L8:
        this.z = (TextView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (TextView) r0;
    }

    public final LinearLayout ab0() {
        View r0 = this.y;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131386050);
    L8:
        this.y = (LinearLayout) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (LinearLayout) r0;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final km5.a ga0() {
        boolean r17 = wa0(oa0());
        int r3 = oa0().getSource();
        int r4 = oa0().getType();
        String r5 = oa0().getToken();
        boolean r6 = oa0().isWiki();
        boolean r7 = this.D;
        String r8 = oa0().getMindnoteViewType();
        boolean r11 = oa0().isAtVC();
        if (oa0().getAdminPerceiveControl() == false) goto L5;
    L8:
        boolean r14 = true;
    L9:
        boolean r15 = this.F;
        ShareDocInfo r2 = this.G;
        if (r2 != null) goto L12;
    L14:
        boolean r16 = false;
    L15:
        IDocPublicPermission r13 = this.H;
        ShareDocInfo r9 = this.G;
        if (r9 == null) goto L18;
        IDocUserPermission r10 = r9.f;
    L19:
        boolean r12 = r14;
        boolean r18 = r16;
        return new km5.a(r3, r4, r5, r6, r7, r8, null, null, r11, r12, r15, r18, r13, r10, r17, oa0().getShowExportImage(), null, 65536);
    L18:
        r10 = null;
        goto L19
    L12:
        if (r2.i() != true) goto L14;
        r16 = true;
        goto L15
    L5:
        if (this.E == true) goto L8;
        r14 = false;
        goto L9
    }

    public ShareDocFragment() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.Q = r0.h("base.advanced_permission.role_inheritance");
        this.R = r0.h("base.advanced_permission.2layerrole_reconciliation");
    }

    public final boolean ba0() {
        return !ku5.c.k(getActivity());
    }

    public final void bb0() {
        Dialog r0 = getDialog();     // Catch: Throwable -> L11
        if (r0 == null) goto L17;
        Window r1 = r0.getWindow();     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        View r2 = r1.getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L13;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r3 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r3 == com.larus.home.impl.utils.c.a) goto L13;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");     // Catch: Throwable -> L11
    L13:
        if (r2 == null) goto L17;
        FrameLayout r4 = (FrameLayout) r2.findViewById(2131368870);     // Catch: Throwable -> L11
        if (r4 == null) goto L17;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();     // Catch: Throwable -> L11
    L19:
        if ((r5 instanceof CoordinatorLayout.LayoutParams) == false) goto L28;
        BottomSheetBehavior r6 = ((CoordinatorLayout.LayoutParams) r5).getBehavior();     // Catch: Throwable -> L11
        if ((r6 instanceof BottomSheetBehavior) == false) goto L29;
        r6.setPeekHeight(com.bytedance.ee.util.ui.n.p(getContext()));     // Catch: Throwable -> L11
        return;
    L29:
        return;
    L28:
        return;
    L17:
        r5 = null;
    L11:
        th = move-exception;
        tt5.a.e("ShareDocFragment", "init peek height", th, false);
    }

    public final boolean cb0() {
        if (oa0().getSource() == 3) goto L10;
        km5.a r0 = new km5.a(oa0().getSource(), oa0().getType(), oa0().getToken(), oa0().isWiki(), false, oa0().getMindnoteViewType(), oa0().getDisabledShareTypes(), oa0().getBadgeShareTypes(), oa0().isAtVC(), oa0().getAdminPerceiveControl(), true, false, null, null, false, oa0().getShowExportImage(), null, 81920);
        boolean r1 = pa0().getProvider().b(r0);     // Catch: Throwable -> L7
    L9:
        if (r1 == true) goto L10;
        return false;
    L7:
        th = move-exception;
        tt5.a.e("ShareDocFragment", "hideTopArea failed", th, false);
        r1 = false;
    L10:
        return true;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void ha0() {
        super.ha0();
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void initData() {
        super.initData();
        String r0 = oa0().getFeedId();
        int r1 = com.bytedance.ee.bear.share.i.a;
        Intrinsics.checkNotNullParameter(r0, "feedId");
        boolean r3 = true;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L17;
        Bundle r4 = getArguments();
        if (r4 == null) goto L12;
        Bundle r5 = r4.getBundle("extra_reminder_binder");
    L13:
        if (r5 == null) goto L17;
        r5.setClassLoader(BinderParcel.class.getClassLoader());
        BinderParcel r6 = (BinderParcel) r5.getParcelable("remind_binder");
        if (r6 == null) goto L17;
        this.C = IReminder.Stub.asInterface(r6.a);
        goto L17
    L12:
        r5 = null;
    L17:
        IReminder r7 = this.C;
        if (r7 == null) goto L24;
        IBinder r8 = r7.asBinder();
        if (r8 == null) goto L24;
        if (r8.isBinderAlive() != true) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == false) goto L36;
        String r10 = oa0().getFeedId();
        Intrinsics.checkNotNullParameter(r10, "feedId");
        if (TextUtils.isEmpty(r10) == false) goto L29;
    L31:
        boolean r11 = false;
    L32:
        if (r11 == false) goto L36;
        if (oa0().getType() == 44) goto L36;
    L37:
        this.N = r3;
        Wa0();
        tt5.a.h("ShareDocFragment", "isOwner=" + oa0().isOwner() + ", passwordSharingEnable=" + oa0().getPasswordSharingEnable() + ", transferOwnerEnable: " + oa0().getTransferOwnerEnable());
        return;
    L29:
        if (TextUtils.isDigitsOnly(r10) == false) goto L31;
        r11 = true;
    L36:
        r3 = false;
    L24:
        r9 = false;
        goto L25
    L5:
        if (TextUtils.isDigitsOnly(r0) == false) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final String na0() {
        if (oa0().isWikiShortcutInSpace() == true) goto L5;
        ShareDocInfo r0 = this.G;
        if (r0 == null) goto L16;
        DocMetaInfo r1 = r0.e;
        if (r1 == null) goto L16;
        String r2 = r1.getUrl();
        if (r2 == null) goto L16;
    L18:
        if (TextUtils.isEmpty(r2) == false) goto L22;
        tt5.a.h("ShareDocFragment", "getHandlerUrl()...metaInfo url is empty.");
        return super.na0();
    L22:
        if (oa0().getType() == 8) goto L24;
    L26:
        boolean r3 = false;
    L27:
        if (r3 == false) goto L29;
        int r4 = com.bytedance.ee.bear.share.externalshare.external.handler.n.a;
        r2 = com.bytedance.ee.bear.share.externalshare.external.handler.n.f(r2, super.na0());
    L29:
        boolean r5 = wa0(oa0());
        if (oa0().isWiki() == false) goto L34;
        String r6 = super.na0();
        String r7 = UriProtector.parse(r2).getHost();
        tt5.a.h("ShareDocFragment", "getHandlerUrl()...metaInfo host = " + r7);
        return UriProtector.parse(r6).buildUpon().authority(r7).build().toString();
    L34:
        if (oa0().isPhoenix() == false) goto L41;
        BearUrl r8 = s45.p.a().Z(r2);
        String r9 = UriProtector.parse(r2).buildUpon().path(s45.p.a().j8(r8.a, r8.b)).toString();
        if (r5 == true) goto L38;
        return r9;
    L38:
        if (s45.p.a().L5(r9) == false) goto L40;
        return r9;
    L40:
        return ea0(r9);
    L41:
        if (r5 == true) goto L43;
        return r2;
    L43:
        if (s45.p.a().L5(r2) == false) goto L45;
        return r2;
    L45:
        return ea0(r2);
    L24:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.share.add_extra_param") == false) goto L26;
        r3 = true;
    L16:
        r2 = "";
        goto L18
    L5:
        if (wa0(oa0()) == false) goto L9;
        return ea0(oa0().getUrl());
    L9:
        return oa0().getUrl();
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("ShareDocFragment", "(" + this + ") destroyPush, permissionChangePush: " + this.S + " secretChangePush:" + this.T);
        i r0 = this.S;
        if (r0 == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Lc(r0);
    L5:
        this.S = null;
        j r1 = this.T;
        if (r1 == null) goto L8;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Ye(r1);
    L8:
        this.T = null;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onDestroyView() {
        super.onDestroyView();
        ha0();
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onResume() {
        super.onResume();
        tt5.a.h("ShareDocFragment", "onResume()...");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        jg5.j.j = new WeakReference(this);
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (com.bytedance.ee.util.ui.n.D(getActivity()) == false) goto L5;
    L8:
        bb0();
        return;
    L5:
        if (rcb.b.b(getActivity()) == true) goto L8;
        if (com.bytedance.ee.util.ui.n.C(getActivity()) == true) goto L8;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void ka0() {
        Ia0();
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void ma0() {
        Ka0();
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final com.bytedance.ee.bear.share.export.f sa0() {
        return this.G;
    }

    public static void Qa0(ShareDocFragment r1) {
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

    public static final void Sa0(ShareDocFragment r6) {
        ShareDocInfo r0 = r6.G;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r6.H != null) goto L7;
        return;
    L7:
        if (r6.cb0() == true) goto L27;
        boolean r1 = r0.g.isOwner();
        boolean r3 = r0.f.canManagePermissionMeta();
        if (r1 == true) goto L14;
        if (r3 == true) goto L14;
        boolean r2 = false;
    L15:
        View r4 = r6.K;
        if (r4 == null) goto L22;
        if (r2 == false) goto L19;
        int r5 = 0;
    L20:
        r4.setVisibility(r5);
        goto L22
    L19:
        r5 = 8;
    L22:
        if (r6.N == false) goto L24;
        KeyEvent.Callback r7 = r6.J;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground_permission_export.model.permissionset.IDocPermSetInfo");
        ((ej5.a) r7).setDivider(true);
        KeyEvent.Callback r8 = r6.K;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground_permission_export.model.permissionset.IDocPermSetInfo");
        ((ej5.a) r8).setDivider(true);
        goto L27
    L24:
        if (r2 == false) goto L26;
        KeyEvent.Callback r9 = r6.J;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground_permission_export.model.permissionset.IDocPermSetInfo");
        ((ej5.a) r9).setDivider(true);
        KeyEvent.Callback r10 = r6.K;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground_permission_export.model.permissionset.IDocPermSetInfo");
        ((ej5.a) r10).setDivider(false);
        goto L27
    L26:
        KeyEvent.Callback r11 = r6.J;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground_permission_export.model.permissionset.IDocPermSetInfo");
        ((ej5.a) r11).setDivider(false);
    L14:
        r2 = true;
    L27:
        IDocPublicPermission r12 = r6.H;
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r0.g = r12;
        r6.oa0().setOwner(r0.isOwner());
        r6.oa0().setDocName(r0.e.getTitle());
        r6.oa0().setCreateTime(r0.e.getCreateTime());
        r6.oa0().setOwnerUid(r0.e.getOwnerUid());
        if (TextUtils.isEmpty(r6.oa0().getDocName()) == false) goto L30;
        r6.oa0().setDocName(sbb.e.a(r6.getContext(), r6.oa0().getType()));
    L30:
        r6.eb0(r0.f.canExport(), r0.f.matchPerceiveControl(), true);
        r6.Ha0(r0.f.getReportJson(), r0.g.getReportJson(), r6.oa0().isAtVC());
        r6.Ga0();
    }

    public final void Ta0(Configuration r3) {
        Ya0().removeView(ab0());
        Ya0().removeView(ra0());
        Ya0().removeView(Xa0());
        Ya0().removeView(Za0());
        if (ku5.c.k(getContext()) == true) goto L12;
        int r4 = r3.orientation;
        if (r4 == 1) goto L12;
        if (r4 == 2) goto L10;
    L13:
        Ya0().addView(Xa0());
        Ya0().addView(Za0());
        return;
    L10:
        if (Ya0() == null) goto L13;
        Ya0().addView(ra0());
        Ya0().addView(ab0());
    L12:
        Ya0().addView(ab0());
        Ya0().addView(ra0());
        goto L13
    }

    public final void Va0(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        super.onDismiss(r3);
        tt5.a.h("ShareDocFragment", "onDismiss()...");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        jg5.j.j = null;
        com.bytedance.ee.bear.document.share.a.a r4 = U;
        if (r4 == null) goto L5;
        SharePlugin.c r5 = r4.c.d;
    L5:
        U = null;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final boolean Yl(ShareType r24) {
        Intrinsics.checkNotNullParameter(r24, "shareType");
        this.w = r24;
        boolean r9 = false;
        switch(b.a[r24.ordinal()]) {
            case 1: goto L65;
            case 2: goto L65;
            case 3: goto L65;
            case 4: goto L65;
            case 5: goto L65;
            case 6: goto L23;
            case 7: goto L5;
            default: goto L111;
        };
    L5:
        ShareDocInfo r1 = this.G;
        if (r1 == null) goto L20;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L12;
        PermissionResponse r2 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new UniBaseEntity(r1.c, sbb.e.d(r1.getType()), BizDomain.FileBizDomainCCM, r1.a(), r1.d(), null, null, null, null, 480, null), "EXPORT"), null);
        r2.getCallback().a(eu5.b.a, r2);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r2) == false) goto L20;
        Qa0(this);
    L113:
        return r9;
    L12:
        int r3 = com.bytedance.ee.bear.share.h.a;
        if (r1.getType() == 125) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L20;
        String r5 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).a(r1.c, r1.getType(), "CCM_EXPORT", "", r1.a());
        if (TextUtils.isEmpty(r5) == true) goto L20;
        Toast.showFailureText(eu5.b.a, r5);
        Qa0(this);
        goto L113
    L15:
        r4 = false;
    L20:
        tt5.a.b("ShareDocFragment", "onExportImage... triggered with status: " + CipherManager.d());
        if (CipherManager.d() != 1) goto L109;
        Toast.showText(getContext(), getString(2131887299), 1);
        CipherManager.h();
        Qa0(this);
    L109:
        r9 = true;
        goto L113
    L23:
        ShareDocInfo r6 = this.G;
        if (r6 == null) goto L109;
        IDocPublicPermission r7 = this.H;
        if (r7 == null) goto L109;
        if (r7.isLinkShareAnyoneRead() != true) goto L30;
        boolean r8 = true;
    L31:
        if (r8 == true) goto L109;
        IDocPublicPermission r10 = this.H;
        if (r10 != null) goto L35;
    L37:
        boolean r11 = false;
    L38:
        if (r11 == true) goto L109;
        if (r7.isLinkShareAnyoneRead() == true) goto L50;
        if (r7.isLinkShareAnyoneEdit() == true) goto L50;
        if (r7.getLinkShareAnyoneReadBlockValue() != 0) goto L47;
    L48:
        db0(r6, ShareType.PasswordLink);
        tt5.a.h("ShareDocFragment", "canOpenPasswordLink()...publicPerm " + r7.getReportJson());
        goto L113
    L47:
        if (r7.getLinkShareAnyoneReadBlockValue() == 3) goto L48;
    L50:
        if (r7.getLinkShareAnyoneReadBlockValue() != 5) goto L57;
        if (Ua0() == false) goto L54;
        db0(r6, ShareType.PasswordLink);
    L55:
        tt5.a.h("ShareDocFragment", "canOpenPasswordLink()...publicPerm " + r7.getReportJson());
        goto L113
    L54:
        Toast.showFailureText(getContext(), 2131887387);
        goto L55
    L57:
        if (r7.adminCanCross() == true) goto L60;
        Toast.showFailureText(getContext(), 2131887246);
        tt5.a.h("ShareDocFragment", "canOpenPasswordLink()...publicPerm " + r7.getReportJson());
        goto L113
    L60:
        if (oa0().isWiki() == true) goto L62;
    L64:
        tt5.a.h("ShareDocFragment", "canOpenPasswordLink()...publicPerm " + r7.getReportJson());
        goto L109
    L62:
        if (r7.getLinkShareAnyoneReadBlockValue() != 1) goto L64;
        Toast.showFailureText(getContext(), 2131887282);
        tt5.a.h("ShareDocFragment", "canOpenPasswordLink()...publicPerm " + r7.getReportJson());
        goto L113
    L35:
        if (r10.isLinkShareAnyoneEdit() != true) goto L37;
        r11 = true;
        goto L38
    L30:
        r8 = false;
        goto L31
    L65:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.i() == false) goto L82;
        ShareDocInfo r12 = this.G;
        if (r12 == null) goto L79;
        boolean r13 = r12.f.isFullAccess();
        if (r12.isLinkShareAnyoneRead() == false) goto L72;
    L75:
        boolean r14 = true;
    L76:
        if (r13 == true) goto L79;
        if (r14 == true) goto L79;
        boolean r15 = true;
    L80:
        if (r15 == false) goto L82;
        Toast.showFailureText(getContext(), 2131888785);
        goto L113
    L72:
        if (r12.isLinkShareAnyoneEdit() == true) goto L75;
        r14 = false;
    L79:
        r15 = false;
    L82:
        int r16 = com.bytedance.ee.bear.share.externalshare.external.handler.n.a;
        if (com.bytedance.ee.bear.share.externalshare.external.handler.n.c(this.G, oa0()) == false) goto L109;
        ShareDocInfo r17 = this.G;
        if (r17 == null) goto L109;
        IDocPublicPermission r18 = this.H;
        if (r18 == null) goto L109;
        if (r18.isLinkShareAnyoneRead() == true) goto L109;
        if (r18.isLinkShareAnyoneEdit() == true) goto L109;
        if (r18.getLinkShareAnyoneReadBlockValue() != 0) goto L99;
    L108:
        db0(r17, r24);
        tt5.a.h("ShareDocFragment", "canPassLinkShareGuard()...linkShareAnyOneRead block_value = " + r18.getLinkShareAnyoneReadBlockValue());
        goto L113
    L99:
        if (r18.getLinkShareAnyoneReadBlockValue() == 3) goto L108;
        if (r18.getLinkShareAnyoneReadBlockValue() == 5) goto L104;
        tt5.a.h("ShareDocFragment", "canPassLinkShareGuard()...use default share, block_value = " + r18.getLinkShareAnyoneReadBlockValue());
        goto L109
    L104:
        if (Ua0() == false) goto L106;
        db0(r17, r24);
        tt5.a.h("ShareDocFragment", "canPassLinkShareGuard()...linkShareAnyOneRead block_value = " + r18.getLinkShareAnyoneReadBlockValue());
        goto L113
    L106:
        tt5.a.h("ShareDocFragment", "canPassLinkShareGuard()...no usable secret, use default share.");
        goto L109
    L111:
        Intrinsics.checkNotNullParameter(r24, "shareType");
        return true;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        Ta0(r2);
        bb0();
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onCreate(Bundle r13) {
        super.onCreate(r13);
        Pa0();
        ShareParams r14 = oa0();
        String r0 = r14.getRealToken();
        boolean r2 = true;
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L13;
        r0 = r14.getToken();
    L13:
        if (this.S == null) goto L15;
        tt5.a.h("ShareDocFragment", "initSecretPush, secretPush already exists.");
    L25:
        Integer r15 = Integer.valueOf(r14.getRealType());
        tt5.a.h("ShareDocFragment", "initSecretPush, token: " + du5.b.k(r0) + ", type: " + r15);
        if (this.T == null) goto L28;
        tt5.a.h("ShareDocFragment", "initSecretPush, secretPush already exists.");
        return;
    L28:
        tt5.a.h("ShareDocFragment", "(" + this + ") initSecretPush, token: " + du5.b.k(r0));
        if (r0 != null) goto L31;
    L34:
        if (r2 == true) goto L40;
        if (r15 == null) goto L41;
        j r3 = new j(this, r0);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).d7(r0, r15.intValue(), r3);
        this.T = r3;
        return;
    L41:
        return;
    L40:
        return;
    L31:
        if (r0.length() == 0) goto L34;
        r2 = false;
        goto L34
    L15:
        tt5.a.h("ShareDocFragment", "(" + this + ") initSecretPush, token: " + du5.b.k(r0));
        if (r0 != null) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == true) goto L25;
        i r5 = new i(this, r0);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).i4(r0, oa0().getRealType(), r5);
        this.S = r5;
        goto L25
    L18:
        if (r0.length() == 0) goto L21;
        r4 = false;
        goto L22
    L5:
        r1 = false;
        goto L7
    }

    public final void onDismiss(DialogInterface r2) {
        Va0(r2);     // Catch: Throwable -> L5
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

    @Override // th5.a
    public final void rU(int r3) {
        tt5.a.h("ShareDocFragment", "onAdjustExternalFinished()...result = " + r3);
        if (r3 != AdjustExternalResult.SUCCESS.getValue()) goto L6;
        Pa0();
        return;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void s10(ShareType r10) {
        Intrinsics.checkNotNullParameter(r10, "shareType");
        String r1 = "";
        boolean r4 = true;
        boolean r5 = false;
        switch(b.a[r10.ordinal()]) {
            case 6: goto L28;
            case 7: goto L23;
            case 8: goto L10;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L4;
        };
    L4:
        super.s10(r10);
        return;
    L5:
        Da0();
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).i();
        Qa0(this);
        return;
    L6:
        com.bytedance.ee.bear.document.share.a.a r11 = U;
        if (r11 == null) goto L9;
        SharePlugin.c r12 = r11.c.d;
    L9:
        Ca0();
        return;
    L10:
        ya0();
        IDocPublicPermission r13 = this.H;
        if (r13 != null) goto L13;
    L15:
        r4 = false;
    L16:
        IDocPublicPermission r14 = this.H;
        if (r14 == null) goto L22;
        String r15 = r14.linkPassword();
        if (r15 == null) goto L22;
        r1 = r15;
    L22:
        za0(r4, r1);
        return;
    L13:
        if (r13.hasLinkPassword() != true) goto L15;
    L23:
        Aa0();
        if (oa0().getType() != 3) goto L26;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).i();
    L27:
        Qa0(this);
        return;
    L26:
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).m("ExportImage");
        goto L27
    L28:
        tt5.a.h("BaseShareFragment", "onPasswordLink()...");
        this.w = ShareType.PasswordLink;
        ShareDocInfo r16 = this.G;
        if (r16 == null) goto L112;
        IDocPublicPermission r0 = this.H;
        if (r0 != null) goto L33;
        return;
    L33:
        if (r0.isLinkShareAnyoneRead() != true) goto L35;
        boolean r2 = true;
    L36:
        if (r2 == true) goto L44;
        IDocPublicPermission r3 = this.H;
        if (r3 != null) goto L40;
    L42:
        boolean r6 = false;
    L43:
        if (r6 == true) goto L44;
        return;
    L40:
        if (r3.isLinkShareAnyoneEdit() != true) goto L42;
        r6 = true;
    L44:
        IDocPublicPermission r7 = this.H;
        if (r7 != null) goto L47;
    L49:
        boolean r8 = false;
    L50:
        if (r8 == false) goto L58;
        IDocPublicPermission r9 = this.H;
        if (r9 == null) goto L54;
        String r17 = r9.linkPassword();
    L56:
        if (TextUtils.isEmpty(r17) == true) goto L58;
        boolean r18 = true;
    L59:
        cj5.c.b r19 = new cj5.c.b();
        if (Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE) == false) goto L71;
        String r20 = oa0().getUrl();
        if (r20.length() != 0) goto L64;
        boolean r21 = true;
    L66:
        if (Boolean.valueOf(r21).booleanValue() == false) goto L69;
        r20 = null;
    L69:
        if (r20 != null) goto L72;
        r20 = oa0().getOriginUrl();
    L72:
        r19.a = r20;
        r19.b = r16.c;
        r19.c = r16.getType();
        r19.d = oa0().getRealToken();
        r19.e = oa0().getRealType();
        r19.f = oa0().isWiki();
        r19.g = r16.f.canManageContainerPermissionMeta();
        r19.h = r16.i();
        r19.i = !r18;
        if (this.R == false) goto L96;
        Boolean r22 = oa0().isPro();
        if (r22 == null) goto L77;
        boolean r23 = r22.booleanValue();
    L78:
        Boolean r24 = oa0().isProAccessConfigBindRole();
        if (r24 == null) goto L81;
        boolean r25 = r24.booleanValue();
    L82:
        IDocPublicPermission r26 = this.H;
        if (r26 != null) goto L85;
    L87:
        if (r5 == false) goto L96;
        if (r23 == false) goto L96;
        Context r27 = getContext();
        if (r25 == false) goto L93;
        if (r27 == null) goto L96;
        int r28 = 2131886154;
    L95:
        String r29 = r27.getString(r28);
    L97:
        r19.k = r29;
        ShareDocInfo r30 = this.G;
        if (r30 == null) goto L105;
        DocMetaInfo r31 = r30.e;
        if (r31 == null) goto L105;
        String r32 = r31.getTenantName();
        if (r32 == null) goto L105;
        r1 = r32;
    L105:
        r19.l = r1;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).rb(getContext(), r19, com.bytedance.ee.bear.share.externalshare.external.g.c(oa0().getModule(), com.bytedance.ee.bear.share.externalshare.external.g.g(r16, true, oa0())), null);
        return;
    L93:
        if (r27 == null) goto L96;
        r28 = 2131886198;
        goto L95
    L85:
        if (r26.isLinkShareClose() == true) goto L87;
        r5 = true;
        goto L87
    L81:
        r25 = false;
        goto L82
    L77:
        r23 = false;
    L96:
        r29 = null;
        goto L97
    L64:
        r21 = false;
        goto L66
    L71:
        r20 = ua0();
        goto L72
    L54:
        r17 = null;
    L58:
        r18 = false;
        goto L59
    L47:
        if (r7.hasLinkPassword() != true) goto L49;
        r8 = true;
        goto L50
    L35:
        r2 = false;
        goto L36
    }

    public static final void Ra0(ShareDocFragment r3, Throwable r4) {
        KeyEvent.Callback r0 = r3.I;
        ej5.a r2 = null;
        if ((r0 instanceof ej5.a) == false) goto L5;
        ej5.a r1 = (ej5.a) r0;
    L6:
        if (r1 == null) goto L8;
        r1.k2(r4);
    L8:
        KeyEvent.Callback r5 = r3.J;
        if ((r5 instanceof ej5.a) == false) goto L11;
        ej5.a r6 = (ej5.a) r5;
    L12:
        if (r6 == null) goto L14;
        r6.k2(r4);
    L14:
        KeyEvent.Callback r7 = r3.K;
        if ((r7 instanceof ej5.a) == false) goto L17;
        r2 = (ej5.a) r7;
    L17:
        if (r2 == null) goto L20;
        r2.k2(r4);
        return;
    L20:
        return;
    L11:
        r6 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void Z90(WindowManager.LayoutParams r2, boolean r3) {
        if (r3 == false) goto L4;
        r2.height = com.bytedance.ee.util.ui.n.p(getActivity()) - BaseBottomSheetDialogFragment.j;
        return;
    L4:
        r2.height = -1;
    }

    public final void db0(ShareDocInfo r18, ShareType r19) {
        ShareType r2 = ShareType.PasswordLink;
        if (r19 != r2) goto L5;
        Integer r15 = Integer.valueOf(SceneType.PASSWORD_SHARE.getValue());
    L6:
        if (r19 != r2) goto L8;
        int r3 = com.bytedance.ee.bear.share.externalshare.external.handler.n.a;
        String r16 = com.bytedance.ee.bear.share.externalshare.external.handler.n.d(getContext(), r18.getType());
    L9:
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).le(getContext(), r18.getType(), r18.c, oa0().getSubType(), oa0().isWiki(), true, "from_share", new g(this, r18, r19), h.a, r15, r16);
        return;
    L8:
        r16 = null;
        goto L9
    L5:
        r15 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void la0(ShareType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        Intrinsics.checkNotNullParameter(r3, "toPlatform");
        Ja0(r2, r3);
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onViewCreated(View r23, Bundle r24) {
        Intrinsics.checkNotNullParameter(r23, "view");
        Ta0(getResources().getConfiguration());
        super.onViewCreated(r23, r24);
        boolean r15 = oa0().isOwner();
        ViewGroup.LayoutParams r13 = new ViewGroup.LayoutParams(-1, -2);
        if (cb0() == true) goto L44;
        Boolean r0 = oa0().isFa();
        if (r0 == null) goto L7;
        boolean r9 = r0.booleanValue();
    L8:
        Boolean r1 = oa0().isPro();
        if (r1 == null) goto L11;
        boolean r16 = r1.booleanValue();
    L12:
        Boolean r2 = oa0().isProAccessConfigBindRole();
        if (r2 == null) goto L15;
        boolean r17 = r2.booleanValue();
    L16:
        ArrayList<BitableShareRoleMember> r18 = oa0().getBitableRoleMembers();
        cj5.c r3 = pa0();
        FragmentActivity r4 = getActivity();
        int r5 = oa0().getType();
        String r6 = oa0().getToken();
        String r7 = oa0().getDocName();
        String r8 = oa0().getModule();
        boolean r10 = oa0().isWiki();
        boolean r11 = oa0().isPhoenix();
        boolean r12 = oa0().isAtVC();
        if (r16 == true) goto L19;
    L21:
        boolean r20 = false;
    L22:
        boolean r25 = r9;
        this.I = r3.i2(r4, this, r5, r6, r7, r8, r10, r11, r12, r25, r20, r17, r18);
        cj5.c r14 = pa0();
        Context r19 = getContext();
        ShareParams r21 = oa0();
        if (r15 == false) goto L25;
    L28:
        boolean r22 = true;
    L29:
        if (r16 == true) goto L31;
    L33:
        boolean r26 = false;
    L34:
        this.J = r14.S7(r19, r21, r22, r26, r17);
        ViewGroup.LayoutParams r27 = r13;
        ab0().addView(this.I, r27);
        SettingGroupLayout r28 = va0();
        ab0().addView(r28);
        r28.addView(this.J, r27);
        View r29 = pa0().s7(getContext(), oa0());
        this.K = r29;
        r28.addView(r29, r27);
        View r30 = this.K;
        int r31 = 8;
        if (r30 == null) goto L37;
        r30.setVisibility(8);
    L37:
        if (r16 == true) goto L39;
    L45:
        ShareNotifySetView r32 = new ShareNotifySetView(requireContext());
        this.M = r32;
        r32.a(oa0().getFeedId(), this.C);
        ab0().addView(this.M, r27);
        ShareNotifySetView r33 = this.M;
        if (r33 == null) goto L53;
        if (this.N == false) goto L50;
        int r110 = 0;
    L51:
        r33.setVisibility(r110);
        goto L53
    L50:
        r110 = 8;
    L53:
        if (oa0().getType() != 44) goto L59;
        BaseTitleBar r34 = ta0();
        Context r35 = getContext();
        if (r35 == null) goto L57;
        String r36 = r35.getString(2131889297);
    L58:
        r34.setTitle(r36);
        goto L59
    L57:
        r36 = null;
    L59:
        eb0(false, false, false);
        if (wa0(oa0()) == false) goto L62;
        ab0().setVisibility(r31);
        Za0().setVisibility(0);
        Xa0().setVisibility(0);
    L63:
        Za0().setOnClickListener(new f(this));
        return;
    L62:
        Za0().setVisibility(r31);
        Xa0().setVisibility(r31);
        goto L63
    L39:
        if (this.Q == false) goto L45;
        View r37 = pa0().n6(getContext(), r25);
        this.L = r37;
        if (r37 == null) goto L43;
        r37.setOnClickListener(new e(r25, this));
    L43:
        r28.addView(this.L, r27);
        goto L45
    L31:
        if (this.R == false) goto L33;
        r26 = true;
        goto L34
    L25:
        if (this.N == true) goto L28;
        r22 = false;
        goto L29
    L19:
        if (this.R == false) goto L21;
        r20 = true;
        goto L22
    L15:
        r17 = false;
        goto L16
    L11:
        r16 = false;
        goto L12
    L7:
        r9 = false;
        goto L8
    L44:
        r27 = r13;
        r31 = 8;
        goto L45
    }

    public final void eb0(boolean r2, boolean r3, boolean r4) {
        this.D = r2;
        this.E = r3;
        this.F = r4;
        km5.a r5 = ga0();
        List<ShareItemModel> r6 = pa0().getProvider().a(r5);     // Catch: Throwable -> L5
    L7:
        ra0().b(r6);
        return;
    L5:
        th = move-exception;
        tt5.a.e("ShareDocFragment", "updateShareItems failed", th, false);
        r6 = CollectionsKt.emptyList();
        goto L7
    }

    @Override // th5.a
    public final void QQ(qe5.e.c r11, qe5.e.b r12, SecretApprovalInstanceModel r13, SecretApprovalDefModel r14, SecretLevel r15, SecretLevel r16) {
        Intrinsics.checkNotNullParameter(r13, "secretApprovalInstanceModel");
        Intrinsics.checkNotNullParameter(r14, "secretApprovalDefModel");
        Intrinsics.checkNotNullParameter(r15, "targetSecretLevel");
        Intrinsics.checkNotNullParameter(r16, "originSecretLevel");
        tt5.a.h("ShareDocFragment", "notifyShowSecLabelResubmitApprovalDialog()...");
        if (getActivity() == null) goto L6;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).l5(getActivity(), oa0().getType(), r11, r12, r13, r14, r15, r16);
        return;
    }

    @Override // th5.a
    public final void sJ(String r15, int r16, String r17, String r18, int r19, String r20, String r21, SecretLevel r22, SecretApprovalDefModel r23, Map<String, ? extends Serializable> r24, SecretLevel r25) {
        Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r17, "secLabelId");
        Intrinsics.checkNotNullParameter(r18, "secLabelName");
        Intrinsics.checkNotNullParameter(r20, "applyTips");
        Intrinsics.checkNotNullParameter(r21, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r22, "oldSecretLevel");
        Intrinsics.checkNotNullParameter(r23, "defModel");
        tt5.a.h("ShareDocFragment", "notifyShowSecretApprovalDialog()...");
        if (getActivity() == null) goto L6;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).ad(getActivity(), r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        return;
    }
}
