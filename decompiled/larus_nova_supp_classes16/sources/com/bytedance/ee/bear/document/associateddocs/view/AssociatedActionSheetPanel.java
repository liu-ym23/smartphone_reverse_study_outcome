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
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class AssociatedActionSheetPanel {
    public static final HashMap<Context, AssociatedDocViewModel> a = null;
    public static final HashMap<Context, b> b = null;
    public static final HashMap<Context, com.bytedance.ee.bear.widgets.a> c = null;
    public static g05.a d;
    public static long e;
    public static final Lazy<AssociatedActionSheetPanel> f = null;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.associateddocs.view.AssociatedActionSheetPanel$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0059a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[QuickLaunchBarItemType.values().length];
                r0[QuickLaunchBarItemType.ADD_ASSOCIATION_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[QuickLaunchBarItemType.ASSOCIATED_DOC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[QuickLaunchBarItemType.ASSOCIATED_DOC_WITH_COLLABORATOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }
    }

    public final class b implements ComponentCallbacks {
        public final Context a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public final Context getContext() {
            return this.a;
        }

        public b(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r4) {
            Intrinsics.checkNotNullParameter(r4, "newConfig");
            com.bytedance.ee.bear.widgets.a r0 = AssociatedActionSheetPanel.c.get(this.a);
            if (r0 == null) goto L14;
            int r5 = r4.orientation;
            LKUIDialog r1 = r0.d;
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.getWindow() == null) goto L16;
            WindowManager.LayoutParams r2 = r0.d.getWindow().getAttributes();
            if (r5 != 2) goto L11;
            r2.width = (int) (j08.d.c(r0.a).a * 0.5f);
        L12:
            r0.d.getWindow().setAttributes(r2);
            return;
        L11:
            r2.width = j08.d.c(r0.a).a;
            goto L12
        L16:
            return;
        }
    }

    public AssociatedActionSheetPanel() {
    }

    static {
        a = new HashMap();
        b = new HashMap();
        c = new HashMap();
        f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AssociatedActionSheetPanel$Companion$instance$2.INSTANCE);
    }

    public static void b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        d = new g05.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6));
        if ((r4 instanceof FragmentActivity) == false) goto L6;
        AssociatedDocViewModel r0 = (AssociatedDocViewModel) new ViewModelProvider((ViewModelStoreOwner) r4).get(AssociatedDocViewModel.class);
        r0.setAssociatedAnalytic(d);
        a.put(r4, r0);
        return;
    }

    public static void d(Context r6, l r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "params");
        BearUrl r0 = ((t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class)).Z(r7.a);
        AssociatedDocViewModel r8 = a.get(r6);
        if (r8 == null) goto L6;
        String r9 = r8.getUrlMetaId();
        if (r9 == null) goto L6;
    L7:
        Pattern r2 = com.larksuite.framework.utils.g.a;
        String r3 = r0.b;
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        String r4 = com.larksuite.framework.utils.g.a(r3);
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        HashMap r5 = new HashMap();
        r5.put("click", r7.b);
        r5.put("target", r7.c);
        r5.put("plugin_type", "docs");
        r5.put("show_type", r7.d);
        r5.put("url_id", r9);
        String r10 = r7.a;
        if (r10 == null) goto L17;
        String r11 = f05.b.a(r10);
        if (r11 == null) goto L17;
    L18:
        r5.put("biz_type", r11);
        r5.put("op_app_id", "");
        r5.put("obj_file_id", r4);
        String r12 = r0.getType();
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        r5.put("obj_file_type", r12);
        r5.put("obj_file_permission_type", "");
        g05.a r13 = d;
        if (r13 == null) goto L25;
        Intrinsics.checkNotNullParameter(r5, "evenParams");
        r13.a("ccm_application_docs_plugin_click", r5);
        return;
    L25:
        return;
    L17:
        r11 = "";
    L6:
        r9 = "";
        goto L7
    }

    public static void c(Context r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "appUrl");
        RouteBean r0 = new RouteBean();
        Bundle r1 = new Bundle();
        r1.putString(DocViewModel.ASSOCIATE_APP_URL, r5);
        AssociatedDocViewModel r6 = a.get(r3);
        if (r6 == null) goto L6;
        String r7 = r6.getUrlMetaId();
        if (r7 == null) goto L6;
    L7:
        r1.putString(DocViewModel.ASSOCIATE_URL_META_ID, r7);
        r0.n = r1;
        ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).m9(r4, r0);
        BearUrl r8 = ((t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class)).Z(r4);
        ((com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6)).l(sbb.e.d(r8.a()), r8.b, r5);
        return;
    L6:
        r7 = "";
        goto L7
    }

    public static final void a(AssociatedActionSheetPanel r2, NetService r3, Context r4, String r5, String r6) {
        r2.getClass();
        int r0 = r6.hashCode();
        if (r0 == (-543461335)) goto L30;
        if (r0 == (-343127093)) goto L11;
        if (r0 != 2011110042) goto L43;
        r6.equals("Cancel");
        return;
    L43:
        return;
    L11:
        if (r6.equals("Associated_Exiting") == false) goto L44;
        LifecycleOwner r7 = i2c.a.a(r4);
        if (r7 == null) goto L19;
        AssociatedDocViewModel r1 = a.get(r4);
        if (r1 == null) goto L19;
        r1.getAssociatedDoc().observe(r7, new com.bytedance.ee.bear.document.associateddocs.view.b(r2, r3, r5, r4));
    L19:
        if ((r4 instanceof FragmentActivity) == false) goto L40;
        Fragment r8 = Fragment.instantiate(r4, AssociatedDocFragment.class.getName(), new Bundle());
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.bytedance.ee.bear.document.associateddocs.view.AssociatedDocFragment");
        Fragment r9 = (AssociatedDocFragment) r8;
        FragmentManager r10 = ((FragmentActivity) r4).getSupportFragmentManager();
        if ((r9 instanceof Fragment) == false) goto L23;
        Fragment r11 = r9;
    L24:
        LandscapeRestrictionOperation r12 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r11, "AssociatedActionSheetPanel", r12);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r11, r12) == true) goto L45;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
    L28:
        r9.show(r10, "AssociatedActionSheetPanel");
        return;
    L45:
        return;
    L23:
        r11 = null;
        goto L24
    L40:
        return;
    L44:
        return;
    L30:
        if (r6.equals("Create_Associated") == false) goto L46;
        AssociatedDocViewModel r13 = a.get(r4);
        if (r13 == null) goto L42;
        r13.createAndAssociatedDoc(r3, r5, new d(r2, r4, r5));
        return;
    L42:
        return;
    }
}
