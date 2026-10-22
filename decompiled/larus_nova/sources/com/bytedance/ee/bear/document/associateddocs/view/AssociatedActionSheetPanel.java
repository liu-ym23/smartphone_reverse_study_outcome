package com.bytedance.ee.bear.document.associateddocs.view;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.associated.QuickLaunchBarItemType;
import com.bytedance.ee.bear.document.associateddocs.AssociatedDocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class AssociatedActionSheetPanel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Context, AssociatedDocViewModel> f219016a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<Context, b> f219017b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<Context, com.bytedance.ee.bear.widgets.a> f219018c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static g05.a f219019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f219020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<AssociatedActionSheetPanel> f219021f = null;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.associateddocs.view.AssociatedActionSheetPanel$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C3115a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f219022a = null;

            static {
                int[] r100 = new int[QuickLaunchBarItemType.values().length];
                r100[QuickLaunchBarItemType.ADD_ASSOCIATION_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[QuickLaunchBarItemType.ASSOCIATED_DOC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[QuickLaunchBarItemType.ASSOCIATED_DOC_WITH_COLLABORATOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f219022a = r100;
            }
        }
    }

    public final class b implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f219023a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public final Context getContext() {
            return this.f219023a;
        }

        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f219023a = r100;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
            Intrinsics.checkNotNullParameter(r100, "newConfig");
            com.bytedance.ee.bear.widgets.a r101 = AssociatedActionSheetPanel.f219018c.get(this.f219023a);
            if (r101 == null) goto L14;
            int r102 = r100.orientation;
            LKUIDialog r103 = r101.f240138d;
            if (r103 != null) goto L7;
            return;
        L7:
            if (r103.getWindow() == null) goto L16;
            WindowManager.LayoutParams r104 = r101.f240138d.getWindow().getAttributes();
            if (r102 != 2) goto L11;
            r104.width = (int) (j08.d.c(r101.f240135a).f496834a * 0.5f);
        L12:
            r101.f240138d.getWindow().setAttributes(r104);
            return;
        L11:
            r104.width = j08.d.c(r101.f240135a).f496834a;
            goto L12
        L16:
            return;
        }
    }

    public AssociatedActionSheetPanel() {
    }

    static {
        f219016a = new HashMap();
        f219017b = new HashMap();
        f219018c = new HashMap();
        f219021f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AssociatedActionSheetPanel$Companion$instance$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        f219019d = new g05.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6));
        if ((r100 instanceof FragmentActivity) == false) goto L6;
        AssociatedDocViewModel r101 = (AssociatedDocViewModel) new ViewModelProvider((ViewModelStoreOwner) r100).get(AssociatedDocViewModel.class);
        r101.setAssociatedAnalytic(f219019d);
        f219016a.put(r100, r101);
        return;
    }

    public static void d(Context r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        BearUrl r102 = ((t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class)).Z(r101.f219079a);
        AssociatedDocViewModel r103 = f219016a.get(r100);
        if (r103 == null) goto L6;
        String r104 = r103.getUrlMetaId();
        if (r104 == null) goto L6;
    L7:
        Pattern r105 = com.larksuite.framework.utils.g.f285989a;
        String r106 = r102.f222561b;
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        String r107 = com.larksuite.framework.utils.g.a(r106);
        if (r107 != null) goto L13;
        r107 = "";
    L13:
        HashMap r108 = new HashMap();
        r108.put("click", r101.f219080b);
        r108.put(PickerReporterConstants.KEY.TARGET, r101.f219081c);
        r108.put("plugin_type", "docs");
        r108.put("show_type", r101.f219082d);
        r108.put("url_id", r104);
        String r109 = r101.f219079a;
        if (r109 == null) goto L17;
        String r110 = f05.b.a(r109);
        if (r110 == null) goto L17;
    L18:
        r108.put("biz_type", r110);
        r108.put("op_app_id", "");
        r108.put("obj_file_id", r107);
        String r111 = r102.getType();
        if (r111 != null) goto L21;
        r111 = "";
    L21:
        r108.put("obj_file_type", r111);
        r108.put("obj_file_permission_type", "");
        g05.a r112 = f219019d;
        if (r112 == null) goto L25;
        Intrinsics.checkNotNullParameter(r108, "evenParams");
        r112.a("ccm_application_docs_plugin_click", r108);
        return;
    L25:
        return;
    L17:
        r110 = "";
    L6:
        r104 = "";
        goto L7
    }

    public static void c(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "appUrl");
        RouteBean r103 = new RouteBean();
        Bundle r104 = new Bundle();
        r104.putString(DocViewModel.ASSOCIATE_APP_URL, r102);
        AssociatedDocViewModel r105 = f219016a.get(r100);
        if (r105 == null) goto L6;
        String r106 = r105.getUrlMetaId();
        if (r106 == null) goto L6;
    L7:
        r104.putString(DocViewModel.ASSOCIATE_URL_META_ID, r106);
        r103.f236649n = r104;
        ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).m9(r101, r103);
        BearUrl r107 = ((t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class)).Z(r101);
        ((com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6)).l(sbb.e.d(r107.a()), r107.f222561b, r102);
        return;
    L6:
        r106 = "";
        goto L7
    }

    public static final void a(AssociatedActionSheetPanel r100, NetService r101, Context r102, String r103, String r104) {
        r100.getClass();
        int r105 = r104.hashCode();
        if (r105 == (-543461335)) goto L30;
        if (r105 == (-343127093)) goto L11;
        if (r105 != 2011110042) goto L43;
        r104.equals("Cancel");
        return;
    L43:
        return;
    L11:
        if (r104.equals("Associated_Exiting") == false) goto L44;
        LifecycleOwner r106 = i2c.a.a(r102);
        if (r106 == null) goto L19;
        AssociatedDocViewModel r107 = f219016a.get(r102);
        if (r107 == null) goto L19;
        r107.getAssociatedDoc().observe(r106, new com.bytedance.ee.bear.document.associateddocs.view.b(r100, r101, r103, r102));
    L19:
        if ((r102 instanceof FragmentActivity) == false) goto L40;
        Fragment r108 = Fragment.instantiate(r102, AssociatedDocFragment.class.getName(), new Bundle());
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.bytedance.ee.bear.document.associateddocs.view.AssociatedDocFragment");
        AssociatedDocFragment r109 = (AssociatedDocFragment) r108;
        FragmentManager r110 = ((FragmentActivity) r102).getSupportFragmentManager();
        if ((r109 instanceof Fragment) == false) goto L23;
        AssociatedDocFragment r111 = r109;
    L24:
        LandscapeRestrictionOperation r112 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r111, "AssociatedActionSheetPanel", r112);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r110, r111, r112) == true) goto L45;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
    L28:
        r109.show(r110, "AssociatedActionSheetPanel");
        return;
    L45:
        return;
    L23:
        r111 = null;
        goto L24
    L40:
        return;
    L44:
        return;
    L30:
        if (r104.equals("Create_Associated") == false) goto L46;
        AssociatedDocViewModel r113 = f219016a.get(r102);
        if (r113 == null) goto L42;
        r113.createAndAssociatedDoc(r101, r103, new d(r100, r102, r103));
        return;
    L42:
        return;
    }
}
