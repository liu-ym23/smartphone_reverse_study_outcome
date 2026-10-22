package com.bytedance.ee.bear.drive.biz.preview.more;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.bytedance.ee.bear.drive.ability.DriveMorePanelOpenResult;
import com.bytedance.ee.bear.drive.ability.IDriveMorePanelPlugin;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentPlugin;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentVM;
import com.bytedance.ee.bear.drive.biz.comment.l1;
import com.bytedance.ee.bear.drive.biz.encryption.DriveEncryptionVM;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.biz.feed.DriveFeedVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.preview.more.menu.DriveMoreProvider;
import com.bytedance.ee.bear.drive.biz.preview.more.menu.DriveOfficeMoreProvider;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCFollowVM;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.widgets.BadgeStyle;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0011H\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\b\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u000bH\u0002J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J,\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010-\u001a\u00020+2\u0006\u0010%\u001a\u00020\u000bH\u0002J&\u0010.\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u00100\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020+H\u0002J\b\u00102\u001a\u00020+H\u0002J\b\u00103\u001a\u00020+H\u0002J\b\u00104\u001a\u00020+H\u0002J\u0010\u00105\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u00020\u000bH\u0002J\b\u00107\u001a\u00020+H\u0002J\b\u00108\u001a\u00020\u000bH\u0002J\u0010\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020=H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/DriveSpaceFileMoreMenuPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/more/AbsDriveMoreMenuPlugin;", "Lcom/bytedance/ee/bear/drive/ability/IDriveMorePanelPlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "()V", "mTitleBarBadgeStrategyManger", "Lcom/bytedance/ee/bear/document/titlebar/badge/TitleBarBadgeStrategyManger;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "mIsGuestMode", "", "morePanelAbility", "Lcom/bytedance/ee/bear/more/protocol3/panel/MorePanelAbility;", "aiContainerAbility", "Lcom/bytedance/ee/bear/drive/core/ai/IDrivePreviewAiContainerHostAbility;", "registerMoreConfig", "", "block", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/more/protocol3/panel/MoreDslBuilder;", "Lkotlin/ExtensionFunctionType;", "unregisterMoreConfig", "openMorePanel", "Lcom/bytedance/ee/bear/drive/ability/DriveMorePanelOpenResult;", "params", "Lcom/bytedance/ee/bear/drive/ability/DriveMorePanelOpenParams;", "onAttachToUIContainer", "host", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onDetachFromHost", "initMenuActions", "shouldShowNotificationButton", "canShowCommentEntry", "canShowHeaderCommentEntry", "isHeaderCommentSceneEnabled", "shouldShowCommentHeaderMenu", "isWpsEditing", "isCurrentPreviewPage", "applyCommentMenuIfNeed", "", "Lcom/bytedance/ee/bear/browser/plugin/MenuItem;", "menus", "commentItem", "updateCommentEntryDisplayState", "finalMenus", "shouldSuppressBottomCommentEntry", "instanceFeedItem", "instanceCommentItem", "instanceShareItem", "instanceMoreItem", "openMorePanelInternal", "shouldUseDriveOfficeMore", "instanceSecretItem", "showSecretItem", "showSecretFragment", "meta", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DriveMetaInfo;", "getReportExtras", "Landroid/os/Bundle;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceFileMoreMenuPlugin extends AbsDriveMoreMenuPlugin implements IDriveMorePanelPlugin<DrivePluginHost> {
    private t75.i aiContainerAbility;
    private final CompositeDisposable compositeDisposable;
    private boolean mIsGuestMode;
    private final e45.f mTitleBarBadgeStrategyManger;
    private final com.bytedance.ee.bear.more.protocol3.panel.u morePanelAbility;

    public static final class a implements MenuItem.b {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public a(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
        public final void a(MenuItem r4, View r5) {
            if (DriveSpaceFileMoreMenuPlugin.access$isWpsEditing(this.a) == false) goto L5;
            return;
        L5:
            rcb.c.d(r5);
            k75.a.c(this.a.getHost()).t(this.a.getHost().c.getFileModel(), FileUploadModel.FROM_COMMENT, "ccm_comment_view", null);
            DriveCommentPlugin r6 = (DriveCommentPlugin) DriveSpaceFileMoreMenuPlugin.access$findPlugin(this.a, DriveCommentPlugin.class);
            if (r6 == null) goto L9;
            r6.openHeaderCommentEntry();
            return;
        }
    }

    public static final class b implements MenuItem.b {
        public final /* synthetic */ MenuItem a;
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin b;

        public b(MenuItem r1, DriveSpaceFileMoreMenuPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
        public final void a(MenuItem r4, View r5) {
            rcb.c.d(r5);
            HashMap r6 = new HashMap();
            r6.put("notification_num", Integer.valueOf(this.a.getBadgeNum()));
            k75.a.c(this.b.getHost()).t(this.b.getHost().c.getFileModel(), "notification", "ccm_notification_panel_view", r6);
            com.bytedance.ee.bear.drive.biz.feed.c r7 = ((DriveFeedVM) DriveSpaceFileMoreMenuPlugin.access$viewModel(this.b, DriveFeedVM.class)).getDriveFeedManager();
            if (r7 == null) goto L6;
            r7.c();
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public c(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            DriveSpaceFileMoreMenuPlugin.access$openMorePanelInternal(this.a, new w45.a("native_title_bar"));
        }
    }

    public static final class d implements MenuItem.b {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public d(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
        public final void a(MenuItem r4, View r5) {
            e45.f.a(DriveSpaceFileMoreMenuPlugin.access$getMTitleBarBadgeStrategyManger$p(this.a).d);
            rcb.c.d(r5);
            k75.a.c(this.a.getHost()).t(this.a.getHost().c.getFileModel(), "share", "ccm_permission_share_view", null);
            FragmentActivity r6 = DriveSpaceFileMoreMenuPlugin.access$getActivity(this.a);
            DriveViewModel r7 = this.a.getHost().c;
            u55.b r0 = (u55.b) ((DriveMGPermissionVM) DriveSpaceFileMoreMenuPlugin.access$viewModel(this.a, DriveMGPermissionVM.class)).livePerm().getValue();
            DrivePluginHost r1 = this.a.getHost();
            com.bytedance.ee.bear.drive.biz.preview.more.menu.share.a.a(r6, r7, r0);
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public e(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Integer r2 = (Integer) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public f(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public g(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            u55.a r2 = (u55.a) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public h(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            DocVersion r2 = (DocVersion) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public i(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public j(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            ConnectionService.NetworkState r2 = (ConnectionService.NetworkState) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public k(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            u55.b r2 = (u55.b) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class l<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public l(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Integer r2 = (Integer) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class m<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public m(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            List r2 = (List) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class n<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public n(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class o<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public o(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            DriveSpaceFileMoreMenuPlugin r0 = this.a;
            Intrinsics.checkNotNull(r3);
            DriveSpaceFileMoreMenuPlugin.access$setMIsGuestMode$p(r0, r3.booleanValue());
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class p<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public p(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class q<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public q(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    public static final class r<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileMoreMenuPlugin a;

        public r(DriveSpaceFileMoreMenuPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSpaceFileMoreMenuPlugin.access$initMenuActions(this.a);
        }
    }

    private final boolean showSecretItem() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final boolean canShowCommentEntry() {
        DriveCommentPlugin r0 = (DriveCommentPlugin) findPlugin(DriveCommentPlugin.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (DriveCommentPlugin.canShowCommentEntry$default(r0, null, 1, null) != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean canShowHeaderCommentEntry() {
        DriveCommentPlugin r0 = (DriveCommentPlugin) findPlugin(DriveCommentPlugin.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.canShowHeaderCommentEntry() != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final void initMenuActions() {
        if (isCurrentPreviewPage() == true) goto L5;
        return;
    L5:
        boolean r1 = isHeaderCommentSceneEnabled();
        boolean r2 = !((DriveEncryptionVM) viewModel(DriveEncryptionVM.class)).isEncryptionKeyDeleted();
        u55.b r4 = (u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        if (k75.a.g(this) == true) goto L8;
    L16:
        boolean r5 = false;
    L17:
        boolean r7 = shouldShowNotificationButton();
        StringBuilder r8 = new StringBuilder("DriveSpaceFileMoreMenuPlugin#initMenuActions() showMore=");
        r8.append(r2);
        r8.append(", mIsGuestMode=");
        r8.append(this.mIsGuestMode);
        r8.append(", canRead=");
        MenuItem r9 = null;
        if (r4 == null) goto L20;
        Boolean r10 = Boolean.valueOf(r4.e());
    L21:
        r8.append(r10);
        r8.append(", showNotificationButton=");
        r8.append(r7);
        tt5.a.h("DriveComponent", r8.toString());
        if (r2 == true) goto L25;
        updateCommentEntryDisplayState(canShowCommentEntry(), CollectionsKt.emptyList(), r1);
        tt5.a.h("DriveComponent", "DriveSpaceFileMoreMenuPlugin#initMenuActions() block!");
        return;
    L25:
        if (r4 != null) goto L27;
    L31:
        boolean r3 = false;
    L32:
        MenuItem r6 = instanceMoreItem();
        MenuItem r11 = instanceShareItem();
        if (r7 == false) goto L35;
        r9 = instanceFeedItem();
    L35:
        MenuItem r12 = instanceSecretItem();
        if (r5 == true) goto L40;
        if (r3 == true) goto L40;
        boolean r13 = false;
    L41:
        r6.setEnable(r13);
        if (r5 == true) goto L46;
        if (r3 == true) goto L46;
        boolean r14 = false;
    L47:
        r11.setEnable(r14);
        if (r5 == true) goto L52;
        if (r3 == true) goto L52;
        boolean r16 = false;
    L53:
        r12.setEnable(r16);
        MutableLiveData<Boolean> r17 = titleBarViewModel().getAiEnable();
        if (r5 == true) goto L58;
        if (r3 == true) goto L58;
        boolean r18 = false;
    L59:
        r17.setValue(Boolean.valueOf(r18));
        boolean r19 = showSecretItem();
        if (e45.f.b(this.mTitleBarBadgeStrategyManger.d) == false) goto L62;
        r11.setBadgeNum(1);
        r11.setBadgeStyle(BadgeStyle.point);
    L62:
        Integer r110 = (Integer) ((DriveFeedVM) viewModel(DriveFeedVM.class)).getFeedCount().getValue();
        if (r110 == null) goto L70;
        int r111 = r110.intValue();
        if (r111 <= 0) goto L70;
        if (r9 == null) goto L68;
        r9.setBadgeNum(r111);
    L68:
        if (r9 == null) goto L70;
        r9.setBadgeStyle(BadgeStyle.num);
    L70:
        if (r9 == null) goto L73;
        r9.setEnable(r5);
    L73:
        if (w55.n.d == false) goto L87;
        Integer r112 = (Integer) k75.a.i((DrivePluginHost) getHost()).liveInnerPreviewShowStatus().getValue();
        if (r112 != null) goto L78;
    L80:
        boolean r113 = false;
    L81:
        if (r9 == null) goto L87;
        if (r5 == false) goto L85;
        if (r113 == false) goto L85;
        boolean r20 = true;
    L86:
        r9.setEnable(r20);
    L85:
        r20 = false;
        goto L86
    L78:
        if (r112.intValue() != 2) goto L80;
        r113 = true;
    L87:
        Object r21 = k75.a.i((DrivePluginHost) getHost()).liveInnerShowWPSPresentationAction().getValue();
        Boolean r114 = Boolean.TRUE;
        boolean r22 = Intrinsics.areEqual(r21, r114);
        boolean r115 = Intrinsics.areEqual(k75.a.i((DrivePluginHost) getHost()).liveInnerShowPresentationAction().getValue(), r114);
        if (((DrivePluginHost) getHost()).c.isVCFollowMode() == false) goto L90;
    L93:
        boolean r116 = true;
    L94:
        if (r116 == false) goto L96;
        if (r115 == false) goto L96;
    L97:
        boolean r23 = true;
    L99:
        MenuItem r117 = instancePresentationItem();
        boolean r118 = Intrinsics.areEqual(titleBarViewModel().getOutlineEnable().getValue(), r114);
        MenuItem r119 = createOutlineMenuItem();
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "  host.driveViewModel.isHistoryMode" + ((DrivePluginHost) getHost()).c.isHistoryMode());
        if (AppInfoUtils.e().booleanValue() == false) goto L111;
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "  host.driveViewModel, mempope app, showSecretItem" + r19 + ", showPresentation" + r23 + ", showOutline" + r118);
        ArrayList r24 = new ArrayList();
        if (r19 == false) goto L104;
        r24.add(r12);
    L104:
        if (r23 == false) goto L106;
        r24.add(r117);
    L106:
        if (r23 == true) goto L109;
        if (r118 == false) goto L109;
        r24.add(r119);
    L109:
        r24.add(r11);
        updateCommentEntryDisplayState(canShowCommentEntry(), r24, r1);
        showRightMenu(r24);
        return;
    L111:
        if (((DrivePluginHost) getHost()).c.isHistoryMode() == false) goto L122;
        updateCommentEntryDisplayState(canShowCommentEntry(), CollectionsKt.emptyList(), false);
        if (r23 == false) goto L118;
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "  host.driveViewModel.isHistoryMode" + r23);
        if (r9 != null) goto L117;
        showRightMenu(new MenuItem[]{r117});
        return;
    L117:
        showRightMenu(new MenuItem[]{r117, r9});
        return;
    L118:
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "  host.driveViewModel.isHistoryMode" + r9);
        if (r9 != null) goto L121;
        showRightMenu(CollectionsKt.emptyList());
        return;
    L121:
        showRightMenu(new MenuItem[]{r9});
        return;
    L122:
        if (r23 == false) goto L130;
        ArrayList r26 = new ArrayList();
        if (r19 == false) goto L126;
        r26.add(r12);
    L126:
        r26.add(r117);
        if (r9 == null) goto L129;
        r26.add(r9);
    L129:
        r26.add(r11);
        r26.add(r6);
        showRightMenu(applyCommentMenuIfNeed(r26, instanceCommentItem(), r1));
        return;
    L130:
        ArrayList r27 = new ArrayList();
        if (r19 == false) goto L133;
        r27.add(r12);
    L133:
        if (r118 == false) goto L135;
        r27.add(r119);
    L135:
        if (r9 == null) goto L137;
        r27.add(r9);
    L137:
        r27.add(r11);
        r27.add(r6);
        showRightMenu(applyCommentMenuIfNeed(r27, instanceCommentItem(), r1));
        return;
    L96:
        if (r22 == true) goto L97;
        r23 = false;
        goto L99
    L90:
        if (((dn4.a) ((DrivePluginHost) getHost()).getUserComponent().a(dn4.a.class)).a().isEnable("ccm.drive.mobile_ppt_prefer_transcode_preview") == true) goto L93;
        r116 = false;
    L58:
        r18 = true;
    L52:
        r16 = true;
    L46:
        r14 = true;
    L40:
        r13 = true;
        goto L41
    L27:
        if (r4.h() == false) goto L29;
    L30:
        r3 = true;
        goto L32
    L29:
        if (r4.b.a.isSecretFileView() == false) goto L31;
    L20:
        r10 = null;
        goto L21
    L8:
        if (this.mIsGuestMode == true) goto L16;
        if (r4 != null) goto L11;
    L13:
        boolean r28 = false;
    L14:
        if (r28 == false) goto L16;
        r5 = true;
        goto L17
    L11:
        if (r4.e() != true) goto L13;
        r28 = true;
        goto L14
    }

    private final MenuItem instanceMoreItem() {
        return createMoreMenuItem(new c(this));
    }

    private final boolean isHeaderCommentSceneEnabled() {
        int r0 = l1.a;
        return l1.a(AppInfoUtils.f().booleanValue(), AnonymousClass1.INSTANCE, new C03472(this));
    }

    private final boolean shouldUseDriveOfficeMore() {
        boolean r3 = com.bytedance.ee.bear.bizwidget.officesdk.a.a();     // Catch: Throwable -> L19
        int r4 = t.a;     // Catch: Throwable -> L19
        boolean r5 = true;
        boolean r6 = !DowngradeSettingUtil.a("downgradeOfficeSpaceMorePanel");
    L9:
        if (r3 == false) goto L12;
        if (r6 == false) goto L12;
        boolean r7 = true;
    L13:
        StringBuilder r8 = new StringBuilder("shouldUseDriveOfficeMore, enable=");     // Catch: Throwable -> L19
        r8.append(r7);     // Catch: Throwable -> L19
        r8.append(", fgEnable=");     // Catch: Throwable -> L19
        r8.append(r3);     // Catch: Throwable -> L19
        r8.append(", downgradeEnable=");     // Catch: Throwable -> L19
        r8.append(r6);     // Catch: Throwable -> L19
        r8.append(", hasConfig=");     // Catch: Throwable -> L19
        if (this.morePanelAbility.a() != null) goto L17;
        r5 = false;
    L17:
        r8.append(r5);     // Catch: Throwable -> L19
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, r8.toString());     // Catch: Throwable -> L19
        return r7;
    L12:
        r7 = false;
        goto L13
    L7:
        th = move-exception;
        tt5.a.e("DriveMorePanelHelper", "query downgrade failed, fallback old provider", th, false);     // Catch: Throwable -> L19
        r6 = false;
    L19:
        th = move-exception;
        tt5.a.e(AbsDriveMoreMenuPlugin.TAG, "shouldUseDriveOfficeMore failed, fallback old provider", th, false);
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.ability.IDriveMorePanelPlugin
    public void unregisterMoreConfig() {
        this.morePanelAbility.unregisterMoreConfig();
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "unregisterMoreConfig");
    }

    public DriveSpaceFileMoreMenuPlugin() {
        this.mTitleBarBadgeStrategyManger = new e45.f();
        this.compositeDisposable = new CompositeDisposable();
        this.mIsGuestMode = ((b0) org.koin.java.a.c(b0.class, null, null, 6)).b();
        this.morePanelAbility = new com.bytedance.ee.bear.more.protocol3.panel.f();
    }

    private final Bundle getReportExtras() {
        BaseOpenEntity r0 = getHost().c.getOpenEntity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity");
        Bundle r1 = ((SpaceFileOpenEntity) r0).getExtras();
        if (r1 != null) goto L5;
    L6:
        Bundle r2 = new Bundle();
        r2.putString("module", com.bytedance.ee.bear.drive.report.c.f(i75.h.a(getHost().c.getOpenEntity().getPreviewFrom()), "main", ""));
        return r2;
    L5:
        if (TextUtils.isEmpty(r1.getString("module")) == true) goto L6;
        return r1;
    }

    private final MenuItem instanceCommentItem() {
        MenuItem r1 = new MenuItem(AbsDriveMoreMenuPlugin.COMMENT_MENU_ID, com.bytedance.ee.util.ui.l.a(getContext(), 2131253538, 2131101926), "");
        r1.setClickListener(new a(this));
        return r1;
    }

    private final MenuItem instanceFeedItem() {
        MenuItem r1 = new MenuItem(AbsDriveMoreMenuPlugin.FEED_MENU_ID, com.bytedance.ee.util.ui.l.a(getContext(), 2131253828, 2131101926), "");
        r1.setClickListener(new b(r1, this));
        return r1;
    }

    private final MenuItem instanceSecretItem() {
        MenuItem r1 = new MenuItem(AbsDriveMoreMenuPlugin.SECRET_MENU_ID, com.bytedance.ee.util.ui.l.a(getContext(), 2131255592, 2131101926), "");
        r1.setClickListener(new DriveSpaceFileMoreMenuPlugin$instanceSecretItem$1$1(this));
        return r1;
    }

    private final MenuItem instanceShareItem() {
        MenuItem r1 = new MenuItem(AbsDriveMoreMenuPlugin.SHARE_MENU_ID, com.bytedance.ee.util.ui.l.a(getContext(), 2131255656, 2131101926), "");
        r1.setClickListener(new d(this));
        return r1;
    }

    private final boolean isCurrentPreviewPage() {
        if (isUIContainerAttached() == true) goto L5;
        return false;
    L5:
        t75.i r0 = this.aiContainerAbility;
        String r2 = null;
        if (r0 == null) goto L12;
        t75.e r1 = r0.Mk();
        if (r1 == null) goto L12;
        BaseOpenEntity r3 = r1.c;
        if (r3 == null) goto L12;
        String r4 = r3.getFileId();
    L13:
        if (r4 == null) goto L19;
        BaseOpenEntity r5 = getHost().c.getOpenEntity();
        if (r5 == null) goto L18;
        r2 = r5.getFileId();
    L18:
        if (Intrinsics.areEqual(r4, r2) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        r4 = null;
        goto L13
    }

    private final boolean isWpsEditing() {
        if (isCurrentPreviewPage() == false) goto L15;
        w75.a r0 = getHost().c.getFileModel();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(k75.a.i(getHost()).liveInnerExtraViewVisible().getValue(), Boolean.FALSE) == false) goto L17;
        return true;
    L17:
        return false;
    L7:
        if (r0.q != 2) goto L9;
        r1 = true;
        goto L10
    L15:
        return false;
    }

    private final boolean shouldShowNotificationButton() {
        com.bytedance.ee.drive.render.k r0 = getDriveUIConfig();
        if (r0 == null) goto L7;
        com.bytedance.ee.drive.render.k.g r1 = r0.getTitleBar();
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return true;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveSpaceFileMoreMenuPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ Context access$getContext(DriveSpaceFileMoreMenuPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ LifecycleOwner access$getLifecycleOwner(DriveSpaceFileMoreMenuPlugin r0) {
        return r0.getLifecycleOwner();
    }

    public static final /* synthetic */ e45.f access$getMTitleBarBadgeStrategyManger$p(DriveSpaceFileMoreMenuPlugin r0) {
        return r0.mTitleBarBadgeStrategyManger;
    }

    public static final /* synthetic */ void access$initMenuActions(DriveSpaceFileMoreMenuPlugin r0) {
        r0.initMenuActions();
    }

    public static final /* synthetic */ boolean access$isWpsEditing(DriveSpaceFileMoreMenuPlugin r0) {
        return r0.isWpsEditing();
    }

    private final DriveMorePanelOpenResult openMorePanelInternal(w45.a r12) {
        String r13 = r12.a;
        if (isUIContainerAttached() == true) goto L7;
        StringBuilder r0 = new StringBuilder("openMorePanel blocked, source=");
        r0.append(r13);
        r0.append(", result=");
        DriveMorePanelOpenResult r14 = DriveMorePanelOpenResult.UI_NOT_ATTACHED;
        r0.append(r14);
        tt5.a.k(AbsDriveMoreMenuPlugin.TAG, r0.toString());
        return r14;
    L7:
        if (com.bytedance.ee.util.ui.b.a(getActivity()) == true) goto L45;
        StringBuilder r1 = new StringBuilder("openMorePanel blocked, source=");
        r1.append(r13);
        r1.append(", result=");
        DriveMorePanelOpenResult r16 = DriveMorePanelOpenResult.ACTIVITY_NOT_READY;
        r1.append(r16);
        tt5.a.k(AbsDriveMoreMenuPlugin.TAG, r1.toString());
        return r16;
    L45:
        rcb.c.d(getUIContainer().getContentView());     // Catch: Throwable -> L42
        boolean r5 = e45.f.b(this.mTitleBarBadgeStrategyManger.c);     // Catch: Throwable -> L42
        e45.f.a(this.mTitleBarBadgeStrategyManger.c);     // Catch: Throwable -> L42
        DriveViewModel r6 = getHost().c;     // Catch: Throwable -> L42
        if (r6 != null) goto L14;
    L40:
        StringBuilder r2 = new StringBuilder("openMorePanel blocked, source=");     // Catch: Throwable -> L42
        r2.append(r13);     // Catch: Throwable -> L42
        r2.append(", result=");     // Catch: Throwable -> L42
        DriveMorePanelOpenResult r4 = DriveMorePanelOpenResult.FILE_NOT_READY;     // Catch: Throwable -> L42
        r2.append(r4);     // Catch: Throwable -> L42
        tt5.a.d(AbsDriveMoreMenuPlugin.TAG, r2.toString());     // Catch: Throwable -> L42
        return r4;
    L14:
        if (r6.getFileModel() == null) goto L40;
        int r7 = p55.a.a;     // Catch: Throwable -> L42
        oj5.a r8 = p55.a.b(getHost());     // Catch: Throwable -> L42
        int r9 = h55.a.a;     // Catch: Throwable -> L42
        String r10 = h55.a.C0236a.a(getHost().c);     // Catch: Throwable -> L42
        DriveViewModel r11 = getHost().c;     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r11, "viewModel");     // Catch: Throwable -> L42
        BaseOpenEntity r17 = r11.getOpenEntity();     // Catch: Throwable -> L42
        boolean r18 = true;
        if ((r17 instanceof SpaceFileOpenEntity) == false) goto L27;
        SpaceFileOpenEntity r19 = (SpaceFileOpenEntity) r17;     // Catch: Throwable -> L42
        String r20 = r19.getOriginUrl();     // Catch: Throwable -> L42
        if (r20 != null) goto L21;
    L24:
        boolean r21 = true;
    L25:
        if (r21 == true) goto L27;
        String r22 = r19.getOriginUrl();     // Catch: Throwable -> L42
    L28:
        com.bytedance.ee.bear.more.protocol3.extension.a r23 = new com.bytedance.ee.bear.more.protocol3.extension.a(r10, r22, r8);     // Catch: Throwable -> L42
        boolean r24 = shouldUseDriveOfficeMore();     // Catch: Throwable -> L42
        if (r24 == false) goto L31;
        com.bytedance.ee.bear.more.protocol3.h r26 = new DriveOfficeMoreProvider(getHost(), r23, this.morePanelAbility);     // Catch: Throwable -> L42
    L32:
        StringBuilder r27 = new StringBuilder("openMorePanel success, source=");     // Catch: Throwable -> L42
        r27.append(r13);     // Catch: Throwable -> L42
        r27.append(", useOfficeMore=");     // Catch: Throwable -> L42
        r27.append(r24);     // Catch: Throwable -> L42
        r27.append(", hasConfig=");     // Catch: Throwable -> L42
        if (this.morePanelAbility.a() != null) goto L36;
        r18 = false;
    L36:
        r27.append(r18);     // Catch: Throwable -> L42
        r27.append(", isShowNew=");     // Catch: Throwable -> L42
        r27.append(r5);     // Catch: Throwable -> L42
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, r27.toString());     // Catch: Throwable -> L42
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).O(getHost().getActivity(), r26);     // Catch: Throwable -> L42
        if (r5 == false) goto L46;
        initMenuActions();     // Catch: Throwable -> L42
    L46:
        return DriveMorePanelOpenResult.SUCCESS;
    L31:
        r26 = new DriveMoreProvider(getHost(), r23);     // Catch: Throwable -> L42
        goto L32
    L21:
        if (r20.length() == 0) goto L24;
        r21 = false;
    L27:
        r22 = h55.a.C0236a.a(r11);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        StringBuilder r28 = new StringBuilder("openMorePanel failed, source=");
        r28.append(r13);
        r28.append(", result=");
        DriveMorePanelOpenResult r110 = DriveMorePanelOpenResult.INTERNAL_ERROR;
        r28.append(r110);
        tt5.a.e(AbsDriveMoreMenuPlugin.TAG, r28.toString(), th, false);
        return r110;
    }

    private final void showSecretFragment(u55.a r9) {
        if (r9.b.isGetSecDetailFail() == false) goto L6;
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "isGetSecDetailFail");
        Toast.showFailureText(getContext(), 2131887384);
        return;
    L6:
        DriveViewModel r0 = getHost().c;
        if (r0 == null) goto L12;
        WikiInfo r1 = r0.getWikiInfo();
        if (r1 == null) goto L12;
        String r2 = r1.getWikiToken();
        if (r2 == null) goto L12;
    L13:
        String r6 = r2;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).r3(getActivity(), getHost().c.getFileId(), sbb.e.l.b, r9.b, r6, "from_left_upper");
        return;
    L12:
        r2 = "";
        goto L13
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.aiContainerAbility = null;
        super.onDetachFromHost(r2);
    }

    @Override // com.bytedance.ee.bear.drive.ability.IDriveMorePanelPlugin
    public DriveMorePanelOpenResult openMorePanel(w45.a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return openMorePanelInternal(r2);
    }

    @Override // com.bytedance.ee.bear.drive.ability.IDriveMorePanelPlugin
    public void registerMoreConfig(Function1<? super com.bytedance.ee.bear.more.protocol3.panel.l, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        this.morePanelAbility.registerMoreConfig(r5);     // Catch: Throwable -> L8
        com.bytedance.ee.bear.more.protocol3.panel.w r6 = this.morePanelAbility.a();     // Catch: Throwable -> L8
        if (r6 == null) goto L10;
        List r7 = r6.b;     // Catch: Throwable -> L8
        if (r7 == null) goto L10;
        int r8 = r7.size();     // Catch: Throwable -> L8
    L11:
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "registerMoreConfig success, groupCount=" + r8);     // Catch: Throwable -> L8
        return;
    L10:
        r8 = 0;
    L8:
        th = move-exception;
        tt5.a.e(AbsDriveMoreMenuPlugin.TAG, "registerMoreConfig failed", th, false);
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(DriveSpaceFileMoreMenuPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ DriveMorePanelOpenResult access$openMorePanelInternal(DriveSpaceFileMoreMenuPlugin r0, w45.a r1) {
        return r0.openMorePanelInternal(r1);
    }

    public static final /* synthetic */ void access$setMIsGuestMode$p(DriveSpaceFileMoreMenuPlugin r0, boolean r1) {
        r0.mIsGuestMode = r1;
    }

    public static final /* synthetic */ void access$showSecretFragment(DriveSpaceFileMoreMenuPlugin r0, u55.a r1) {
        r0.showSecretFragment(r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveSpaceFileMoreMenuPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    private final boolean shouldShowCommentHeaderMenu(boolean r3, boolean r4) {
        if (isWpsEditing() == true) goto L12;
        int r0 = l1.a;
        if (r4 == false) goto L8;
        if (r3 == false) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L13;
        return true;
    L13:
        return false;
    L8:
        r5 = false;
        goto L9
    L12:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin
    public void onAttachToUIContainer(DrivePluginHost r5, com.bytedance.ee.bear.browser.plugin.t r6) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(r6, "uiContainer");
        super.onAttachToUIContainer(r5, r6);
        this.aiContainerAbility = (t75.i) r5.getHostAbilityOrNull(t75.i.class);
        e45.f r7 = this.mTitleBarBadgeStrategyManger;
        k65.a r0 = new k65.a((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class), r5.c);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "strategy");
        ArrayList<e45.b> r8 = r7.c;
        Iterator<e45.b> r1 = r8.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(r1.next().getId(), r0.getId()) == false) goto L4;
    L9:
        k75.a.h(this, new j(this));
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new k(this));
        ((DriveFeedVM) viewModel(DriveFeedVM.class)).getFeedCount().observe(getLifecycleOwner(), new l(this));
        ((DriveCommentVM) viewModel(DriveCommentVM.class)).getLiveCommentData().observe(getLifecycleOwner(), new m(this));
        r5.c.liveHistoryMode().observe(getLifecycleOwner(), new n(this));
        ((DriveVCFollowVM) viewModel(DriveVCFollowVM.class)).getLiveIsGuest().observe(getLifecycleOwner(), new o(this));
        k75.a.i(r5).liveInnerShowPresentationAction().observe(getLifecycleOwner(), new p(this));
        k75.a.i(r5).liveInnerShowWPSPresentationAction().observe(getLifecycleOwner(), new q(this));
        k75.a.i(r5).liveInnerExtraViewVisible().observe(getLifecycleOwner(), new r(this));
        if (w55.n.d == false) goto L12;
    L13:
        k75.a.i(r5).liveInnerPreviewShowStatus().observe(getLifecycleOwner(), new e(this));
    L14:
        titleBarViewModel().getOutlineEnable().observe(getLifecycleOwner(), new f(this));
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().observe(getLifecycleOwner(), new g(this));
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveDocVersion().observe(getLifecycleOwner(), new h(this));
        ((DriveEncryptionVM) viewModel(DriveEncryptionVM.class)).getEncryptionKeyDeleted().observe(getLifecycleOwner(), new i(this));
        return;
    L12:
        if (isHeaderCommentSceneEnabled() == false) goto L14;
    L8:
        r8.add(r0);
        goto L9
    }

    public void onDetachFromUIContainer(DrivePluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onDetachFromUIContainer(r2, r3);
        ((DriveCommentVM) viewModel(DriveCommentVM.class)).getLiveCommentEntryDisplayState().setValue(null);
        this.compositeDisposable.clear();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<MenuItem> applyCommentMenuIfNeed(List<? extends MenuItem> r21, MenuItem r22, boolean r23) {
        boolean r3 = canShowCommentEntry();
        boolean r4 = shouldShowCommentHeaderMenu(canShowHeaderCommentEntry(), r23);
        int r5 = u.a;
        DriveSpaceFileMoreMenuPlugin$applyCommentMenuIfNeed$finalMenus$1 r6 = DriveSpaceFileMoreMenuPlugin$applyCommentMenuIfNeed$finalMenus$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r21, "menus");
        Intrinsics.checkNotNullParameter(AbsDriveMoreMenuPlugin.SHARE_MENU_ID, "shareMenuId");
        Intrinsics.checkNotNullParameter(AbsDriveMoreMenuPlugin.COMMENT_MENU_ID, "commentMenuId");
        Intrinsics.checkNotNullParameter(r6, "menuIdProvider");
        boolean r9 = true;
        if (r4 == false) goto L31;
        List<? extends MenuItem> r7 = r21;
        if ((r7 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(r6.invoke(r8.next()), AbsDriveMoreMenuPlugin.COMMENT_MENU_ID) == false) goto L11;
        boolean r10 = true;
    L16:
        if (r10 == true) goto L31;
        List r11 = CollectionsKt.toMutableList(r21);
        if (r21.size() < 4) goto L30;
        Iterator<? extends MenuItem> r12 = r21.iterator();
        int r13 = 0;
    L22:
        if (r12.hasNext() == false) goto L27;
        if (Intrinsics.areEqual(r6.invoke(r12.next()), AbsDriveMoreMenuPlugin.SHARE_MENU_ID) == true) goto L28;
        r13 = r13 + 1;
    L28:
        if (r13 < 0) goto L30;
        ListProtector.remove(r11, r13);
        goto L30
    L27:
        r13 = -1;
    L30:
        ListProtector.add(r11, 0, r22);
        List r14 = r11;
    L33:
        if (r14.size() > r21.size()) goto L35;
    L49:
        updateCommentEntryDisplayState(r3, r14, r23);
        return r14;
    L35:
        if (r21.size() < 4) goto L49;
        List<? extends MenuItem> r16 = r21;
        if ((r16 instanceof Collection) == true) goto L39;
    L41:
        Iterator<T> r17 = r16.iterator();
    L43:
        if (r17.hasNext() == false) goto L47;
        if (Intrinsics.areEqual(((MenuItem) r17.next()).getId(), AbsDriveMoreMenuPlugin.SHARE_MENU_ID) == false) goto L43;
        r9 = false;
    L47:
        if (r9 == false) goto L49;
        tt5.a.k(AbsDriveMoreMenuPlugin.TAG, "applyCommentMenuIfNeed header menu overflow without share, originalCount=" + r21.size() + ", finalCount=" + r14.size() + ", menuIds=" + CollectionsKt.joinToString$default(r16, null, null, null, 0, null, AnonymousClass2.INSTANCE, 31, null));
        goto L49
    L39:
        if (r16.isEmpty() == false) goto L41;
    L15:
        r10 = false;
        goto L16
    L7:
        if (r7.isEmpty() == false) goto L9;
    L31:
        r14 = r21;
        goto L33
    }

    private final void updateCommentEntryDisplayState(boolean r4, List<? extends MenuItem> r5, boolean r6) {
        int r0 = l1.a;
        List<? extends MenuItem> r7 = r5;
        boolean r1 = false;
        if ((r7 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((MenuItem) r8.next()).getId(), AbsDriveMoreMenuPlugin.COMMENT_MENU_ID) == false) goto L9;
        r1 = true;
    L13:
        com.bytedance.ee.bear.drive.biz.comment.g r9 = new com.bytedance.ee.bear.drive.biz.comment.g(r4, r1, r6);
        MutableLiveData<com.bytedance.ee.bear.drive.biz.comment.g> r10 = ((DriveCommentVM) viewModel(DriveCommentVM.class)).getLiveCommentEntryDisplayState();
        if (Intrinsics.areEqual(r10.getValue(), r9) == true) goto L20;
        r10.setValue(r9);
        return;
    L20:
        return;
    L5:
        if (r7.isEmpty() == false) goto L7;
        goto L7
    }
}
