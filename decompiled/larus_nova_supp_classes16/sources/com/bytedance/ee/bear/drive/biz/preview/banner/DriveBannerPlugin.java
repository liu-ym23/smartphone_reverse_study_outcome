package com.bytedance.ee.bear.drive.biz.preview.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveThirdPartyPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.model.ThirdPartyAttachmentPermission;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.facade.common.widget.DLPRiskBannerView;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.s;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.secret.c0;
import com.bytedance.ee.bear.middleground.permission.secret.o;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.util.ui.k;
import com.larksuite.component.universe_design.notice.UDNotice;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J.\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0011J\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010!\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017J\u0018\u0010%\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0017H\u0002J\u0006\u0010(\u001a\u00020\rJ\u0018\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u001c\u0010.\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/banner/DriveBannerPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "mTipsController", "Lcom/bytedance/ee/bear/drive/biz/preview/banner/TipsController;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "secLabelStatus", "", "mRouteService", "Lcom/bytedance/ee/bear/route/RouteService;", "showCustomBanner", "", "banner", "Landroid/view/View;", "bannerId", "", "hideCustomBanner", "showNoNoticeBanner", "driveMetaInfo", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DriveMetaInfo;", "isForceSecret", "", "show", "adminDefault", "secName", "showNoticeBanner", "responseBannerParam", "Lcom/bytedance/ee/bear/middleground/permission/secret/ResponseBannerParam;", "notifyMetaChange", "docMetaInfo", "Lcom/bytedance/ee/bear/DocMetaInfo;", "showForbiddenBanner", "state", "Lcom/bytedance/ee/bear/facade/common/widget/ForbiddenBannerView$ForbiddenState;", "isUpdate", "forceSecretDialog", "updateTitleBarTipsExtra", "titleBarTipsShow", "hideNoticeView", "onAttachToUIContainer", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "checkDLPState", "handleSensitive", "isOwner", "token", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveBannerPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    private static final String TAG = "DriveBannerPlugin";
    private final CompositeDisposable mCompositeDisposable;
    private com.bytedance.ee.bear.route.h mRouteService;
    private com.bytedance.ee.bear.drive.biz.preview.banner.a mTipsController;
    private final int secLabelStatus;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ph5.d {
        public final /* synthetic */ DriveBannerPlugin a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public final void a(PermissionResponse r3) {
            Intrinsics.checkNotNullParameter(r3, "permissionResponse");
            PermissionResponse.Companion.getClass();
            if (PermissionResponse.a.c(r3) == false) goto L6;
            DriveBannerPlugin.access$handleSensitive(this.a, this.b, this.c);
            return;
        }

        public b(DriveBannerPlugin r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements com.bytedance.ee.bear.middleground_permission_export.model.d.a {
        public final /* synthetic */ DriveBannerPlugin a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public c(DriveBannerPlugin r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(int r3) {
            if (r3 != 2) goto L6;
            DriveBannerPlugin.access$handleSensitive(this.a, this.b, this.c);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DriveBannerPlugin a;

        public d(DriveBannerPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ThirdPartyAttachmentPermission r3 = (ThirdPartyAttachmentPermission) r2;
            if (((DriveThirdPartyPermissionVM) DriveBannerPlugin.access$viewModel(this.a, DriveThirdPartyPermissionVM.class)).isFilePermission() == false) goto L11;
            com.bytedance.ee.bear.drive.biz.preview.banner.a r4 = DriveBannerPlugin.access$getMTipsController$p(this.a);
            if (r4 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
            r4 = null;
        L7:
            UDNotice r5 = r4.f;
            if (r5 == null) goto L12;
            r5.setVisibility(8);
            return;
        L12:
            return;
        }
    }

    public static final class e implements SecretSetBannerView.b {
        public final /* synthetic */ DriveBannerPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public static final class a<T> implements Consumer {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final void accept(Object r2) {
                Boolean r3 = (Boolean) r2;
                tt5.a.h(DriveBannerPlugin.TAG, "closeBanner success");
            }
        }

        public static final class b<T> implements Consumer {
            public static final b<T> a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final void accept(Object r2) {
                Throwable r3 = (Throwable) r2;
                tt5.a.d(DriveBannerPlugin.TAG, "closeBanner error");
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ DriveBannerPlugin a;

            public c(DriveBannerPlugin r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                Boolean r4 = (Boolean) r3;
                tt5.a.h(DriveBannerPlugin.TAG, "closeBanner success");
                Toast.showSuccessText(DriveBannerPlugin.access$getContext(this.a), 2131889256);
                o r5 = new o(0);
                com.bytedance.ee.bear.drive.biz.preview.banner.a r0 = DriveBannerPlugin.access$getMTipsController$p(this.a);
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
                r0 = null;
            L5:
                r0.h("", r5);
            }
        }

        public static final class d<T> implements Consumer {
            public final /* synthetic */ DriveBannerPlugin a;

            public d(DriveBannerPlugin r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                Throwable r4 = (Throwable) r3;
                Toast.showFailureText(DriveBannerPlugin.access$getContext(this.a), 2131887364);
                o r5 = new o(0);
                com.bytedance.ee.bear.drive.biz.preview.banner.a r0 = DriveBannerPlugin.access$getMTipsController$p(this.a);
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
                r0 = null;
            L5:
                r0.h("", r5);
            }
        }

        @Override // com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView.b
        public final void a() {
            com.bytedance.ee.bear.route.h r0 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
            s45.h r1 = s45.g.a;
            r0.u5(s45.g.a.a("secret_banner_help_center", "991220891340", "150212615307", null));
            u55.a r2 = (u55.a) ((DriveMetaInfoVM) DriveBannerPlugin.access$viewModel(this.a, DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();
            if (r2 == null) goto L6;
            com.bytedance.ee.bear.middleground.permission.c.N(r2.b.isSecretAdminDefault(), "know_detail", "none");
            return;
        }

        @Override // com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView.b
        public final void b() {
            u55.a r0 = (u55.a) ((DriveMetaInfoVM) DriveBannerPlugin.access$viewModel(this.a, DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();
            if (r0 == null) goto L15;
            DocMetaInfo r1 = r0.b;
            if (r1 == null) goto L16;
            c0 r8 = new c0(k75.a.d(this.a), 12, r1.getRecommendLabelId(), "", 48);
            CompositeDisposable r2 = DriveBannerPlugin.access$getMCompositeDisposable$p(this.a);
            IDocUserPermission r4 = null;
            Flowable r3 = ((com.bytedance.ee.bear.middleground.permission.secret.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground.permission.secret.d.class, null, null, 6)).b(r8);
            DriveBannerPlugin r6 = this.a;
            r2.add(r3.subscribe(new c(r6), new d(r6)));
            if (r1.isRecommendMark() == false) goto L17;
            u55.b r5 = (u55.b) ((DriveMGPermissionVM) DriveBannerPlugin.access$viewModel(this.a, DriveMGPermissionVM.class)).livePerm().getValue();
            DocMetaInfo r7 = r0.b;
            if (r5 == null) goto L13;
            DocPermission r9 = r5.b;
            if (r9 == null) goto L13;
            r4 = r9.a;
        L13:
            com.bytedance.ee.bear.middleground.permission.c.G(fj5.a.d(r7, r4), TipCallBackData.CONFIRM);
            return;
        L17:
            return;
        L16:
            return;
        }

        @Override // com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView.b
        public final void c() {
            u55.a r0 = (u55.a) ((DriveMetaInfoVM) DriveBannerPlugin.access$viewModel(this.a, DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();
            if (r0 == null) goto L25;
            DocMetaInfo r1 = r0.b;
            if (r1 != null) goto L7;
            return;
        L7:
            if (TextUtils.isEmpty(r1.getRecommendLabelId()) == true) goto L9;
            String r2 = r1.getRecommendLabelId();
        L10:
            com.bytedance.ee.bear.drive.biz.preview.banner.a r9 = null;
            DriveBannerPlugin.access$getMCompositeDisposable$p(this.a).add(((com.bytedance.ee.bear.middleground.permission.secret.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground.permission.secret.d.class, null, null, 6)).d(r1.getObjId(), sbb.e.l.b, r2, r1.getSecLabelBannerType(), DriveBannerPlugin.access$getSecLabelStatus$p(this.a)).subscribe(a.a, b.a));
            if (r1.isRecommendMark() == false) goto L19;
            u55.b r3 = (u55.b) ((DriveMGPermissionVM) DriveBannerPlugin.access$viewModel(this.a, DriveMGPermissionVM.class)).livePerm().getValue();
            DocMetaInfo r4 = r0.b;
            if (r3 == null) goto L17;
            DocPermission r5 = r3.b;
            if (r5 == null) goto L17;
            IDocUserPermission r6 = r5.a;
        L18:
            com.bytedance.ee.bear.middleground.permission.c.G(fj5.a.d(r4, r6), "close");
        L17:
            r6 = null;
        L19:
            o r7 = new o(0);
            com.bytedance.ee.bear.drive.biz.preview.banner.a r8 = DriveBannerPlugin.access$getMTipsController$p(this.a);
            if (r8 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
        L23:
            r9.h("", r7);
            return;
        L22:
            r9 = r8;
            goto L23
        L9:
            r2 = r1.getSecretLevel().getId();
            goto L10
        }

        @Override // com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView.b
        public final void d() {
            DriveViewModel r0 = this.b.c;
            if (r0 == null) goto L8;
            WikiInfo r1 = r0.getWikiInfo();
            if (r1 == null) goto L8;
            String r2 = r1.getWikiToken();
            if (r2 == null) goto L8;
        L9:
            String r6 = r2;
            u55.a r3 = (u55.a) ((DriveMetaInfoVM) DriveBannerPlugin.access$viewModel(this.a, DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();
            if (r3 == null) goto L13;
            ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).r3(DriveBannerPlugin.access$getActivity(this.a), this.b.c.getFileId(), sbb.e.l.b, r3.b, r6, "from_banner");
            com.bytedance.ee.bear.middleground.permission.c.N(r3.b.isSecretAdminDefault(), "security_setting", "ccm_permission_security_setting_view");
            return;
        L13:
            return;
        L8:
            r2 = "";
            goto L9
        }

        public e(DriveBannerPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class f extends u75.b.C0306b {
        public final /* synthetic */ DriveBannerPlugin a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[InfoCode.values().length];
                r0[InfoCode.FileInfoSuccess.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public f(DriveBannerPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r4, T r5) {
            Intrinsics.checkNotNullParameter(r4, "code");
            if (a.a[r4.ordinal()] == 1) goto L5;
            return;
        L5:
            if ((r5 instanceof Integer) == false) goto L18;
            com.bytedance.ee.bear.drive.biz.preview.banner.a r6 = DriveBannerPlugin.access$getMTipsController$p(this.a);
            if (r6 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
            r6 = null;
        L9:
            int r7 = ((Number) r5).intValue();
            Context r0 = DriveBannerPlugin.access$getContext(this.a);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r0, "context");
            if (r7 != 10009) goto L12;
            r6.a(new com.bytedance.ee.bear.drive.biz.preview.banner.a.b(UDNotice.Type.ERROR, r0.getString(2131888380)));
            return;
        L12:
            if (r7 != 10013) goto L20;
            r6.a(new com.bytedance.ee.bear.drive.biz.preview.banner.a.b(UDNotice.Type.ERROR, r0.getString(2131888381)));
            return;
        L20:
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ DriveBannerPlugin a;

        public g(DriveBannerPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r13) {
            PreviewViewModel.a r14 = (PreviewViewModel.a) r13;
            if (r14 == null) goto L24;
            DriveBannerPlugin r0 = this.a;
            if (((DriveThirdPartyPermissionVM) DriveBannerPlugin.access$viewModel(r0, DriveThirdPartyPermissionVM.class)).isFilePermission() == true) goto L27;
            com.bytedance.ee.bear.drive.biz.preview.banner.a r1 = DriveBannerPlugin.access$getMTipsController$p(r0);
            if (r1 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
            r1 = null;
        L10:
            r1.getClass();
            Intrinsics.checkNotNullParameter(r14, "data");
            if (r14.getType() != (-1)) goto L16;
            UDNotice r16 = r1.f;
            if (r16 == null) goto L25;
            r16.setVisibility(8);
            return;
        L25:
            return;
        L16:
            if (r14.getType() != 1) goto L18;
            UDNotice.Type r4 = UDNotice.Type.WARNING;
            int r5 = 2131256187;
        L19:
            String r2 = r14.a;
            if (r2 != null) goto L22;
            r2 = "";
        L22:
            r1.a(new com.bytedance.ee.bear.drive.biz.preview.banner.a.b(r4, r5, r2, true, r14.d, r14.c, r14.e, r14.f));
            return;
        L18:
            r4 = UDNotice.Type.INFO;
            r5 = 2131254920;
            goto L19
        L27:
            return;
        }
    }

    public static final class h implements ForbiddenBannerView.a {
        public final /* synthetic */ Ref.ObjectRef<jdb.g> a;
        public final /* synthetic */ DriveBannerPlugin b;

        @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView.a
        public final void B6() {
            ((com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class, null, null, 6)).b(DriveBannerPlugin.access$getContext(this.b));
        }

        @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView.a
        public final void f5() {
            if (((jdb.g) this.a.element).isEnable("ccm.platform.appeal_v2") == false) goto L8;
            String r0 = ((com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class, null, null, 6)).a(k75.a.d(this.b), 12, false);
            com.bytedance.ee.bear.route.h r1 = DriveBannerPlugin.access$getMRouteService$p(this.b);
            if (r1 == null) goto L13;
            r1.u5(r0);
            return;
        L13:
            return;
        L8:
            Document r2 = new Document();
            r2.d = k75.a.d(this.b);
            r2.b = 12;
            String r3 = this.b.getHost().c.getFileName();
            if (r3 != null) goto L11;
            r3 = "";
        L11:
            r2.a = r3;
            r2.S1 = "";
            ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).b(r2, DriveBannerPlugin.access$getActivity(this.b));
        }

        @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView.a
        public final void q8() {
            ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).r(DriveBannerPlugin.access$getMRouteService$p(this.b));
        }

        @Override // com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView.a
        public final void s2() {
            if (((jdb.g) this.a.element).isEnable("ccm.platform.appeal_v2") == false) goto L8;
            String r0 = ((com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class, null, null, 6)).a(k75.a.d(this.b), 12, true);
            com.bytedance.ee.bear.route.h r1 = DriveBannerPlugin.access$getMRouteService$p(this.b);
            if (r1 == null) goto L9;
            r1.u5(r0);
            return;
        L9:
            return;
        }

        public h(Ref.ObjectRef<jdb.g> r1, DriveBannerPlugin r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public final void hideNoticeView() {
        com.bytedance.ee.bear.drive.biz.preview.banner.a r0 = this.mTipsController;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
        r0 = null;
    L5:
        UDNotice r1 = r0.f;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    }

    public DriveBannerPlugin() {
        this.mCompositeDisposable = new CompositeDisposable();
        this.secLabelStatus = 1;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveBannerPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ Context access$getContext(DriveBannerPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ CompositeDisposable access$getMCompositeDisposable$p(DriveBannerPlugin r0) {
        return r0.mCompositeDisposable;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.route.h access$getMRouteService$p(DriveBannerPlugin r0) {
        return r0.mRouteService;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.drive.biz.preview.banner.a access$getMTipsController$p(DriveBannerPlugin r0) {
        return r0.mTipsController;
    }

    public static final /* synthetic */ int access$getSecLabelStatus$p(DriveBannerPlugin r0) {
        return r0.secLabelStatus;
    }

    private final void checkDLPState(DocMetaInfo r26) {
        String r1 = getHost().c.getFileId();
        int r4 = sbb.e.l.b;
        boolean r16 = TextUtils.equals(r26.getOwnerUid(), ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2().uid);
        if (r1 == null) goto L14;
        if (r16 == true) goto L6;
        return;
    L6:
        if (mh5.e.a(r1) == true) goto L16;
        r26.is_external();
        String r14 = r26.getOwnerUid();
        String r13 = r26.getCreatorTenantId();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L12;
        s55.e r12 = new s55.e("FILE_EXTERNAL_SHARE", null, 0, "docx_file", r1, null, null, null, null, null, null, null, null, null, 32742);
        s55.a r2 = s55.a.a;
        s55.a.a(r12, r13, r14, new b(this, r16, r1));
        return;
    L12:
        ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).d(r1, r4, r14, r13, new c(this, r16, r1));
        return;
    L16:
        return;
    }

    private final void updateTitleBarTipsExtra(boolean r2) {
        if (getUIContainer() != null) goto L5;
        return;
    L5:
        View r0 = findViewById(2131382174);
        if (r0 != null) goto L8;
        return;
    L8:
        if (r2 == false) goto L10;
        int r3 = 0;
    L11:
        r0.setVisibility(r3);
        return;
    L10:
        r3 = 8;
        goto L11
    }

    public final void hideCustomBanner(String r3) {
        Intrinsics.checkNotNullParameter(r3, "bannerId");
        tt5.a.h(TAG, "hideCustomBanner, bannerId: " + r3);
        com.bytedance.ee.bear.drive.biz.preview.banner.a r0 = this.mTipsController;
        if (r0 == null) goto L10;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
        r0 = null;
    L6:
        DriveCustomBannerContainer r1 = r0.l;
        if (r1 == null) goto L11;
        r1.b(r3);
        return;
    L11:
        return;
    }

    public final void notifyMetaChange(DocMetaInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "docMetaInfo");
        checkDLPState(r2);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveBannerPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    private final void forceSecretDialog(boolean r8, DocMetaInfo r9) {
        if (r8 == false) goto L12;
        DriveViewModel r10 = getHost().c;
        if (r10 == null) goto L9;
        WikiInfo r11 = r10.getWikiInfo();
        if (r11 == null) goto L9;
        String r12 = r11.getWikiToken();
        if (r12 == null) goto L9;
    L10:
        String r5 = r12;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).r3(getActivity(), getHost().c.getFileId(), sbb.e.l.b, r9, r5, "from_banner");
        return;
    L9:
        r12 = "";
        goto L10
    }

    private final void handleSensitive(final boolean r7, final String r8) {
        DrivePluginHost r0 = getHost();
        if (r0 == null) goto L7;
        DriveViewModel r1 = r0.c;
        if (r1 == null) goto L7;
        final boolean r2 = r1.isInVcState();
    L8:
        DrivePluginHost r3 = getHost();
        if (r3 == null) goto L16;
        DriveViewModel r4 = r3.c;
        if (r4 == null) goto L16;
        w75.a r5 = r4.getFileModel();
        if (r5 == null) goto L16;
        String r6 = r5.f;
        if (r6 == null) goto L16;
    L17:
        com.bytedance.ee.bear.drive.biz.preview.banner.a r9 = this.mTipsController;
        final com.bytedance.ee.bear.drive.biz.preview.banner.a r10 = null;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
        r9 = null;
    L21:
        if (r9.c == true) goto L23;
        com.bytedance.ee.bear.middleground.permission.c.s(r7, r2);
    L23:
        com.bytedance.ee.bear.drive.biz.preview.banner.a r11 = this.mTipsController;
        if (r11 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
    L27:
        Function0<Unit> r12 = new AnonymousClass1(r7, r2);
        final Function0<Unit> r13 = new AnonymousClass2(r8, r7, r2);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r6, "extension");
        Intrinsics.checkNotNullParameter(r12, "seeDetailInvoke");
        Intrinsics.checkNotNullParameter(r13, "closeAction");
        r10.c = true;
        DLPRiskBannerView r14 = r10.h;
        if (r14 == null) goto L30;
        boolean r16 = i75.h.e(r6);
        ViewGroup.LayoutParams r17 = r14.getLayoutParams();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        r10.d((LinearLayout.LayoutParams) r17, r16, r10.o);
    L30:
        r10.b();
        DLPRiskBannerView r18 = r10.h;
        if (r18 == null) goto L33;
        Function0<Unit> r19 = new TipsController$showDLPRiskBanner$1(r10, r13);
        Intrinsics.checkNotNullParameter(r12, "seeDetail");
        Intrinsics.checkNotNullParameter(r19, "closeAction");
        r18.e = r12;
        r18.f = r19;
    L33:
        com.bytedance.ee.bear.middleground.permission.c.t("CCM_OPEN_EXTERNAL_ACCESS", true);
        return;
    L26:
        r10 = r11;
    L16:
        r6 = "";
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin
    public void onAttachToUIContainer(DrivePluginHost r5, t r6) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(r6, "uiContainer");
        super.onAttachToUIContainer(r5, r6);
        DriveNotificationVM r1 = (DriveNotificationVM) new ViewModelProvider(getActivity()).get(DriveNotificationVM.class);
        com.bytedance.ee.bear.drive.biz.preview.banner.a r2 = new com.bytedance.ee.bear.drive.biz.preview.banner.a(r6, getContext());
        this.mTipsController = r2;
        LifecycleOwner r7 = getLifecycleOwner();
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(r7, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r1, "driveNotificationVM");
        r2.s = r5;
        com.bytedance.ee.bear.drive.biz.preview.screen.a r0 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) k75.a.e(r5).liveOuterFullScreenSate.getValue();
        if (r0 == null) goto L5;
        boolean r3 = r0.a;
    L6:
        r2.o = r3;
        r2.p = r5.getActivity().getResources().getDimensionPixelSize(2131166316);
        r2.q = k.e(r5.getActivity());
        k75.a.e(r5).liveOuterFullScreenSate.observe(r7, new com.bytedance.ee.bear.drive.biz.preview.banner.b(r2));
        r1.getShowState().observe(r7, new com.bytedance.ee.bear.drive.biz.preview.banner.c(r2));
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new d(this));
        com.bytedance.ee.bear.drive.biz.preview.banner.a r8 = this.mTipsController;
        if (r8 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
        r8 = null;
    L9:
        e r4 = new e(this, r5);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r4, "listener");
        SecretSetBannerView r9 = r8.g;
        if (r9 == null) goto L12;
        r9.setClick(r4);
    L12:
        r5.c().c(new f(this));
        k75.a.i(r5).getLiveInnerChangeTipsState().observe(getLifecycleOwner(), new g(this));
        return;
    L5:
        r3 = false;
        goto L6
    }

    public void onDetachFromUIContainer(DrivePluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.mCompositeDisposable.clear();
    }

    public final void showCustomBanner(View r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "banner");
        Intrinsics.checkNotNullParameter(r4, "bannerId");
        tt5.a.h(TAG, "showCustomBanner, bannerId: " + r4);
        com.bytedance.ee.bear.drive.biz.preview.banner.a r0 = this.mTipsController;
        if (r0 == null) goto L10;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
        r0 = null;
    L6:
        DriveCustomBannerContainer r1 = r0.l;
        if (r1 == null) goto L11;
        r1.a(r4, r3);
        return;
    L11:
        return;
    }

    public final void showNoticeBanner(u55.a r3, o r4) {
        Intrinsics.checkNotNullParameter(r3, "driveMetaInfo");
        Intrinsics.checkNotNullParameter(r4, "responseBannerParam");
        tt5.a.b(TAG, "showNoNoticeBanner " + r4.d);
        w75.a r0 = getHost().c.getFileModel();
        if (r0 == null) goto L6;
        String r1 = r0.f;
        if (r1 == null) goto L6;
    L13:
        com.bytedance.ee.bear.drive.biz.preview.banner.a r2 = this.mTipsController;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
        r2 = null;
    L16:
        r2.h(r1, r4);
        updateTitleBarTipsExtra(r4.d);
        forceSecretDialog(r4.f, r3.b);
        return;
    L6:
        w75.a r5 = getHost().c.getFileModel();
        if (r5 == null) goto L12;
        w75.b r6 = r5.c();
        if (r6 == null) goto L12;
        r1 = r6.k;
        if (r1 != null) goto L13;
    L12:
        r1 = "";
        goto L13
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }

    public static final /* synthetic */ void access$handleSensitive(DriveBannerPlugin r0, boolean r1, String r2) {
        r0.handleSensitive(r1, r2);
    }

    public final void showForbiddenBanner(boolean r8, ForbiddenBannerView.ForbiddenState r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "state");
        w75.a r1 = getHost().c.getFileModel();
        if (r1 == null) goto L6;
        String r2 = r1.f;
        if (r2 == null) goto L6;
    L13:
        this.mRouteService = (com.bytedance.ee.bear.route.h) getHost().getUserComponent().a(com.bytedance.ee.bear.route.h.class);
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = ((dn4.a) getHost().getUserComponent().a(dn4.a.class)).a();
        com.bytedance.ee.bear.drive.biz.preview.banner.a r4 = this.mTipsController;
        com.bytedance.ee.bear.drive.biz.preview.banner.a r5 = null;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
        r4 = null;
    L16:
        h r6 = new h(r3, this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "delegate");
        ForbiddenBannerView r7 = r4.k;
        if (r7 == null) goto L19;
        r7.setViewDelegate(r6);
    L19:
        com.bytedance.ee.bear.drive.biz.preview.banner.a r11 = this.mTipsController;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
    L23:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "extension");
        Intrinsics.checkNotNullParameter(r9, "state");
        if (r8 == true) goto L26;
    L28:
        boolean r12 = false;
    L29:
        r5.e = r12;
        if (r12 == true) goto L32;
        UDNotice r13 = r5.k;
        if (r13 == null) goto L66;
        r13.setVisibility(8);
        return;
    L66:
        return;
    L32:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.platform.appeal_v2") == false) goto L34;
        s r14 = new com.bytedance.ee.bear.facade.common.widget.t(r5.t);
    L35:
        if (r10 == false) goto L54;
        UDNotice r16 = r5.k;
        if (r16 != null) goto L39;
    L57:
        UDNotice r17 = r5.k;
        if (r17 == null) goto L64;
        boolean r18 = i75.h.e(r2);
        ViewGroup.LayoutParams r19 = r17.getLayoutParams();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        r5.d((LinearLayout.LayoutParams) r19, r18, r5.o);
        return;
    L64:
        return;
    L39:
        if (r9 != ForbiddenBannerView.ForbiddenState.WARNING) goto L42;
        r16.setText(r14.e());
        goto L57
    L42:
        if (r9 != ForbiddenBannerView.ForbiddenState.IN_COMPLAINT) goto L45;
        r16.setText(r14.d());
        goto L57
    L45:
        if (r9 != ForbiddenBannerView.ForbiddenState.COMPLAINT_FAIL) goto L48;
        r16.setText(r14.c());
        goto L57
    L48:
        if (r9 != ForbiddenBannerView.ForbiddenState.COMPLAINT_EXCEED_LIMITS_DAY) goto L51;
        r16.setText(r14.a());
        goto L57
    L51:
        if (r9 != ForbiddenBannerView.ForbiddenState.COMPLAINT_EXCEED_LIMITS) goto L53;
        r16.setText(r14.b());
        goto L57
    L53:
        r16.setVisibility(8);
        goto L57
    L54:
        ForbiddenBannerView r110 = r5.k;
        if (r110 == null) goto L57;
        r110.o6(r9, r14);
        goto L57
    L34:
        s.a r20 = new s.a();
        r20.c = 2131888718;
        r20.e = 2131888719;
        r20.b = 2131888723;
        r20.d = 2131887309;
        r20.a = 2131888714;
        r14 = new s(r5.t, r20);
        goto L35
    L26:
        if (r9 == ForbiddenBannerView.ForbiddenState.COMPLAINT_SUCCESS) goto L28;
        r12 = true;
        goto L29
    L22:
        r5 = r11;
    L6:
        w75.a r21 = getHost().c.getFileModel();
        if (r21 == null) goto L12;
        w75.b r22 = r21.c();
        if (r22 == null) goto L12;
        r2 = r22.k;
        if (r2 != null) goto L13;
    L12:
        r2 = "";
        goto L13
    }

    public final void showNoNoticeBanner(u55.a r5, boolean r6, boolean r7, boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, "driveMetaInfo");
        Intrinsics.checkNotNullParameter(r9, "secName");
        tt5.a.b(TAG, "showNoNoticeBanner " + r7 + ", " + r8);
        w75.a r1 = getHost().c.getFileModel();
        if (r1 == null) goto L6;
        String r2 = r1.f;
        if (r2 == null) goto L6;
    L13:
        com.bytedance.ee.bear.drive.biz.preview.banner.a r3 = this.mTipsController;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsController");
        r3 = null;
    L16:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r9, "secName");
        Intrinsics.checkNotNullParameter(r2, "extension");
        r3.b = r7;
        if (r7 == false) goto L22;
        SecretSetBannerView r0 = r3.g;
        if (r0 == null) goto L21;
        r0.e(r8, r9, Boolean.valueOf(r6));
    L21:
        r3.g(r3.o, r2);
    L22:
        r3.b();
        updateTitleBarTipsExtra(r7);
        forceSecretDialog(r6, r5.b);
        return;
    L6:
        w75.a r4 = getHost().c.getFileModel();
        if (r4 == null) goto L12;
        w75.b r10 = r4.c();
        if (r10 == null) goto L12;
        r2 = r10.k;
        if (r2 != null) goto L13;
    L12:
        r2 = "";
        goto L13
    }
}
