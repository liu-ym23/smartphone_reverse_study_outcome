package com.larus.dora.impl.device_v2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.databinding.LarusDoraDeviceBindPageBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0002#&\b\u0016\u0018\u0000 E2\u00020\u0001:\u0003EFGB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*H\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020\b2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u001a\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020\u0015H\u0002J\b\u0010:\u001a\u00020\u0015H\u0002J \u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00102\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u0010H\u0002J\b\u0010@\u001a\u00020\u0015H\u0002J\b\u0010A\u001a\u00020\u0015H\u0002J\b\u0010B\u001a\u00020\u0015H\u0002J\b\u0010C\u001a\u00020\u0015H\u0016J\b\u0010D\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006H"}, d2 = {"Lcom/larus/dora/impl/device_v2/DoraDeviceBindFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "isChecking", "", "isFirst", "binding", "Lcom/larus/dora/impl/device_v2/DoraDeviceBindFragment$DeviceBindPageBinding;", "dataLoader", "Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader;", "onboardingDialogFragment", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "lastOnboardingDialogFragment", "Landroidx/fragment/app/Fragment;", "prePage", "", "gpsDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "pendingCheckAction", "Lkotlin/Function0;", "", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "pageKey", "productID", "", "Ljava/lang/Integer;", "productModel", "buryPointSource", "unbindDialog", "connectFailedDialog", "Lcom/larus/dora/impl/device/DoraDeviceConnectFailedDialog;", "fragmentLifecycleCallbacks", "com/larus/dora/impl/device_v2/DoraDeviceBindFragment$fragmentLifecycleCallbacks$1", "Lcom/larus/dora/impl/device_v2/DoraDeviceBindFragment$fragmentLifecycleCallbacks$1;", SocialConstants.PARAM_RECEIVER, "com/larus/dora/impl/device_v2/DoraDeviceBindFragment$receiver$1", "Lcom/larus/dora/impl/device_v2/DoraDeviceBindFragment$receiver$1;", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "createPageBinding", "onViewCreated", "view", "setupPage", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslSimplePage;", "dismissUnbindDialog", "startBind", "checkReady", "from", "doNext", "handlePermissionDenied", "reason", "launchOnboarding", "showConnectFailedDialog", "dismissConnectFailedDialog", "onDestroyView", "getCurrentPageName", "Companion", "DeviceBindPageBinding", "DefaultDeviceBindPageBinding", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DoraDeviceBindFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f334950t = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f334951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f334952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.dora.impl.dynamic.loader.d f334953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BottomSheetDialogFragment f334954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f334955j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CommonDialog f334956k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<Unit> f334957l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f334958m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f334959n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f334960o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f334961p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f334962q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DoraDeviceBindFragment$fragmentLifecycleCallbacks$1 f334963r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DoraDeviceBindFragment$receiver$1 f334964s;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.device_v2.DoraDeviceBindFragment$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006!"}, d2 = {"Lcom/larus/dora/impl/device_v2/DoraDeviceBindFragment$Companion$DslBindDevicePage;", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", SocialConstants.PARAM_APP_DESC, "imageLink", "Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "bindButtonInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslButton;", "buyButtonInfo", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;Lcom/larus/dora/impl/dynamic/dsl/DslButton;Lcom/larus/dora/impl/dynamic/dsl/DslButton;)V", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getDesc", "getImageLink", "()Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "getBindButtonInfo", "()Lcom/larus/dora/impl/dynamic/dsl/DslButton;", "getBuyButtonInfo", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C4241a {

            @SerializedName("bind_button_info")
            private final c59.h bindButtonInfo;

            @SerializedName("buy_button_info")
            private final c59.h buyButtonInfo;

            @SerializedName(SocialConstants.PARAM_APP_DESC)
            private final c59.t desc;

            @SerializedName("image_link")
            private final c59.u imageLink;

            @SerializedName("title")
            private final c59.t title;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4241a) == true) goto L8;
                return false;
            L8:
                C4241a r101 = (C4241a) r100;
                if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.imageLink, r101.imageLink) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.bindButtonInfo, r101.bindButtonInfo) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.buyButtonInfo, r101.buyButtonInfo) == true) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                c59.t r100 = this.title;
                int r101 = 0;
                if (r100 != null) goto L5;
                int r102 = 0;
            L6:
                int r103 = r102 * 31;
                c59.t r104 = this.desc;
                if (r104 != null) goto L9;
                int r105 = 0;
            L10:
                int r106 = (r103 + r105) * 31;
                c59.u r107 = this.imageLink;
                if (r107 != null) goto L13;
                int r108 = 0;
            L14:
                int r109 = (r106 + r108) * 31;
                c59.h r110 = this.bindButtonInfo;
                if (r110 != null) goto L17;
                int r111 = 0;
            L18:
                int r112 = (r109 + r111) * 31;
                c59.h r113 = this.buyButtonInfo;
                if (r113 == null) goto L23;
                r101 = r113.hashCode();
            L23:
                return r112 + r101;
            L17:
                r111 = r110.hashCode();
                goto L18
            L13:
                r108 = r107.hashCode();
                goto L14
            L9:
                r105 = r104.hashCode();
                goto L10
            L5:
                r102 = r100.hashCode();
                goto L6
            }

            public final String toString() {
                return "DslBindDevicePage(title=" + this.title + ", desc=" + this.desc + ", imageLink=" + this.imageLink + ", bindButtonInfo=" + this.bindButtonInfo + ", buyButtonInfo=" + this.buyButtonInfo + ')';
            }

            public C4241a() {
                this.title = null;
                this.desc = null;
                this.imageLink = null;
                this.bindButtonInfo = null;
                this.buyButtonInfo = null;
            }

            public final c59.h a() {
                return this.bindButtonInfo;
            }

            public final c59.h b() {
                return this.buyButtonInfo;
            }

            public final c59.t c() {
                return this.desc;
            }

            public final c59.u d() {
                return this.imageLink;
            }

            public final c59.t e() {
                return this.title;
            }
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusDoraDeviceBindPageBinding f334965a;

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final TextView b() {
            return this.f334965a.f332371f;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final SimpleDraweeView d() {
            return this.f334965a.f332370e;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final TextView e() {
            return this.f334965a.f332372g;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final View f() {
            return this.f334965a.f332368c;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final View getRoot() {
            return this.f334965a.f332366a;
        }

        public b(LarusDoraDeviceBindPageBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            this.f334965a = r100;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f334965a.f332368c.setText(r100);
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void c(final j r100) {
            Intrinsics.checkNotNullParameter(r100, "onBackClick");
            e1.x(this.f334965a.f332369d);
            ViewGroup.LayoutParams r101 = this.f334965a.f332369d.getLayoutParams();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams r102 = (RelativeLayout.LayoutParams) r101;
            com.larus.utils.i0.f375410a.getClass();
            r102.topMargin = com.larus.utils.i0.g();
            this.f334965a.f332369d.setLayoutParams(r102);
            this.f334965a.f332369d.setLeftClickListener(new o(r100));
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void g(final s r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            e1.d(this.f334965a.f332367b, new q(r100));
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void h(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f334965a.f332367b.setText(r100);
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void i(final t r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            e1.d(this.f334965a.f332368c, new p(r100));
        }
    }

    public interface c {
        void a(String r100);

        TextView b();

        void c(j r100);

        SimpleDraweeView d();

        TextView e();

        View f();

        void g(s r100);

        View getRoot();

        void h(String r100);

        void i(t r100);
    }

    static {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "DoraDeviceBindFragment";
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.impl.device_v2.DoraDeviceBindFragment$fragmentLifecycleCallbacks$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.impl.device_v2.DoraDeviceBindFragment$receiver$1] */
    public DoraDeviceBindFragment() {
        this.f334953h = new com.larus.dora.impl.dynamic.loader.d();
        this.f334957l = new l();
        this.f334962q = "";
        this.f334963r = new DoraDeviceBindFragment$fragmentLifecycleCallbacks$1();
        this.f334964s = new DoraDeviceBindFragment$receiver$1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication()).unregisterReceiver(this.f334964s);
    }

    public final void Y90(String r100) {
        g49.d.d("DoraDeviceBindFragment", "handlePermissionDenied: ".concat(r100));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        this.f334958m = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k(this));
    }

    public final void W90(String r100, Function0<Unit> r101) {
        g49.d.d("DoraDeviceBindFragment", "checkReady: " + r100 + " start");
        if (Intrinsics.areEqual(r100, "check_from_MAIN") == true) goto L5;
    L8:
        this.f334951f = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraDeviceBindFragment$checkReady$1(r100, r101, this, null), 3, null);
        return;
    L5:
        if (this.f334951f == false) goto L8;
        g49.d.d("DoraDeviceBindFragment", "checkReady: " + r100 + " isChecking");
    }

    public c X90(LayoutInflater r110, ViewGroup r111) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r112 = r110.inflate(R.layout.larus_dora_device_bind_page, r111, false);
        int r113 = R.id.btn_bind;
        TextView r100 = (TextView) ViewBindings.findChildViewById(r112, R.id.btn_bind);
        if (r100 == null) goto L17;
        r113 = R.id.btn_buy;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r112, R.id.btn_buy);
        if (r101 == null) goto L17;
        r113 = R.id.device_nav_bar;
        HistoryDeviceNavigationBar r102 = (HistoryDeviceNavigationBar) ViewBindings.findChildViewById(r112, R.id.device_nav_bar);
        if (r102 == null) goto L17;
        r113 = R.id.iv_main_image;
        SimpleDraweeView r103 = (SimpleDraweeView) ViewBindings.findChildViewById(r112, R.id.iv_main_image);
        if (r103 == null) goto L17;
        r113 = R.id.tv_description;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r112, R.id.tv_description);
        if (r104 == null) goto L17;
        r113 = R.id.tv_title;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r112, R.id.tv_title);
        if (r105 == null) goto L17;
        return new b(new LarusDoraDeviceBindPageBinding((RelativeLayout) r112, r100, r101, r102, r103, r104, r105));
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.impl.device_v2.j] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r110, Bundle r111) {
        String r100 = "";
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Bundle r112 = getArguments();
        if (r112 == null) goto L53;
        r112.getString("page_title");
    L53:
        Bundle r113 = getArguments();     // Catch: Throwable -> L14
        if (r113 == null) goto L9;
        String r114 = r113.getString("product_id");     // Catch: Throwable -> L14
    L10:
        if (r114 != null) goto L12;
        r114 = "";
    L12:
        this.f334960o = Integer.valueOf(CastIntegerProtector.parseInt(r114));     // Catch: Throwable -> L14
    L16:
        Bundle r115 = getArguments();
        if (r115 == null) goto L19;
        String r116 = r115.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L20:
        if (r116 != null) goto L22;
        r116 = "";
    L22:
        this.f334961p = r116;
        Bundle r117 = getArguments();
        if (r117 == null) goto L25;
        String r118 = r117.getString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY);
    L26:
        if (r118 != null) goto L28;
        r118 = "";
    L28:
        boolean r101 = true;
        if (r118.length() != 0) goto L31;
        boolean r102 = true;
    L32:
        if (r102 == false) goto L34;
        r118 = "bind_device_v2";
    L34:
        this.f334959n = r118;
        Bundle r119 = getArguments();
        if (r119 == null) goto L37;
        String r120 = r119.getString("bury_point_source");
    L38:
        if (r120 == null) goto L41;
        r100 = r120;
    L41:
        this.f334962q = r100;
        c r121 = this.f334952g;
        if (r121 == 0) goto L44;
        r121.c(new j(this));
    L44:
        com.larus.dora.impl.dynamic.loader.d.b(this.f334953h, LifecycleOwnerKt.getLifecycleScope(this), 1, this.f334960o, this.f334961p, this.f334959n, new AnonymousClass3(this));
        getParentFragmentManager().registerFragmentLifecycleCallbacks(this.f334963r, false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        Bundle r122 = getArguments();
        if (r122 != null) goto L47;
    L49:
        r101 = false;
    L50:
        if (r101 == false) goto L55;
        W90("check_from_MAIN", new m(this));
        return;
    L55:
        return;
    L47:
        if (r122.getBoolean("key_dora_onboarding_auto_connect") != true) goto L49;
    L37:
        r120 = null;
        goto L38
    L31:
        r102 = false;
        goto L32
    L25:
        r118 = null;
        goto L26
    L19:
        r116 = null;
        goto L20
    L9:
        r114 = null;
    L14:
        th = move-exception;
        this.f334960o = Integer.valueOf(ProductNameType.DORA_LITE.f204375id);
        g49.d.b("DoraDeviceBindFragment", "onViewCreated, error is " + th.getMessage());
        goto L16
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        this.f334952g = X90(r100, r101);
        IntentFilter r103 = new IntentFilter("action.DEVICE_TO_GUIDE");
        LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication()).registerReceiver(this.f334964s, r103);
        Bundle r104 = getArguments();
        String r105 = "";
        if (r104 == null) goto L8;
        String r106 = r104.getString("device_manage", "");
        if (r106 == null) goto L8;
        r105 = r106;
    L8:
        this.f334955j = r105;
        c r107 = this.f334952g;
        if (r107 != null) goto L13;
        return null;
    L13:
        return r107.getRoot();
    }
}
