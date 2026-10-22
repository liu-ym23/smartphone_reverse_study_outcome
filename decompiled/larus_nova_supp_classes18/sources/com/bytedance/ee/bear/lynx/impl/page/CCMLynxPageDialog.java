package com.bytedance.ee.bear.lynx.impl.page;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import com.suite.lark.component.navroute.forseti.g;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u000eH\u0016J\u001f\u0010%\u001a\u0004\u0018\u00010\u000e2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0002¢\u0006\u0002\u0010)R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/page/CCMLynxPageDialog;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseDialogFragment;", "Lcom/bytedance/ee/bear/lynx/impl/route/RouterAbilityProvider;", "<init>", "()V", "uri", "Landroid/net/Uri;", "contentContainer", "Landroid/widget/FrameLayout;", "titleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "ccmLynxCardView", "Lcom/bytedance/ee/bear/lynx/api/CCMLynxCardView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "addWatermark", "checkFieldInitIsValid", "", "close", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "getBid", "", "getContainerId", "onStart", "adjustWidth", "configuration", "attributes", "Landroid/view/WindowManager$LayoutParams;", "(Landroid/content/res/Configuration;Landroid/view/WindowManager$LayoutParams;)Lkotlin/Unit;", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMLynxPageDialog extends BaseDialogFragment implements com.bytedance.ee.bear.lynx.impl.route.c {
    public static final /* synthetic */ int k = 0;
    public Uri h;
    public FrameLayout i;
    public CCMLynxCardView j;

    public static final class a {
        public static void a(FragmentActivity r8, Bundle r9, Fragment r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r8, "fragmentActivity");
            Intrinsics.checkNotNullParameter(r9, "args");
            DialogFragment r12 = Fragment.instantiate(r8, CCMLynxPageDialog.class.getName(), r9);
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
            DialogFragment r13 = r12;
            r13.setStyle(0, 2131953441);
            if (ForsetiHelper.s(r10) == true) goto L5;
        L6:
            FragmentManager r14 = r8.getSupportFragmentManager();
            LandscapeRestrictionOperation r15 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, "CCMLynxPageDialog", r15);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r13, r15) == true) goto L16;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            r13.show(r14, "CCMLynxPageDialog");
            return;
        L16:
            return;
        L5:
            if (f.e(r13, r10, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, r11, 0, false, 56) == false) goto L6;
        }
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ CCMLynxPageDialog a;
        public final /* synthetic */ View b;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ CCMLynxPageDialog a;

            public a(CCMLynxPageDialog r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                g r3 = com.suite.lark.component.navroute.forseti.f.b(this.a);
                if (r3 == null) goto L6;
                r3.g(null);
                return;
            }
        }

        public b(CCMLynxPageDialog r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            tt5.a.b("CCMLynxPageDialog", "onLayoutChange, left: " + r2 + ", top: " + r3 + ", right: " + r4 + ", bottom: " + r5);
            int r10 = r5 - r3;
            if (r10 <= 0) goto L11;
            tt5.a.h("CCMLynxPageDialog", "onLayoutChange, height: " + r10);
            FrameLayout r11 = this.a.i;
            if (r11 == null) goto L7;
            r11.removeOnLayoutChangeListener(this);
        L7:
            BaseTitleBar r12 = (BaseTitleBar) this.b.findViewById(2131379307);
            if (r12 == null) goto L12;
            CCMLynxPageDialog r13 = this.a;
            r12.setVisibility(0);
            r12.setLeftClickListener(new a(r13));
            return;
        L12:
            return;
        }
    }

    public static final class c implements CCMLynxCardView.b {
        public final /* synthetic */ CCMLynxPageDialog a;

        @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView.b
        public final void a(Map<String, String> r1) {
        }

        @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView.b
        public final void onShow() {
        }

        @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView.b
        public final void H() {
            this.a.close();
        }

        public c(CCMLynxPageDialog r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lynx.impl.route.c
    public final void close() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L11;
        d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment*/.onDestroy();
        CCMLynxCardView r0 = this.j;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        Window r1 = r0.getWindow();
    L6:
        if (r1 == null) goto L12;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        Context r3 = getContext();
        if (r3 == null) goto L10;
        Configuration r4 = r3.getResources().getConfiguration();
        Intrinsics.checkNotNull(r2);
        ba0(r4, r2);
    L10:
        r2.height = -2;
        r2.gravity = 80;
        r1.setAttributes(r2);
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public CCMLynxPageDialog() {
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        WindowManager.LayoutParams r3 = r1.getAttributes();
    L8:
        if (r3 == null) goto L10;
        ba0(r2, r3);
    L10:
        Dialog r4 = getDialog();
        if (r4 == null) goto L15;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L15;
        r5.setAttributes(r3);
    L15:
        CCMLynxCardView r6 = this.j;
        if (r6 == null) goto L19;
        r6.b();
        return;
    L19:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void onCreate(Bundle r2) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment*/.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        Uri r4 = (Uri) r3.getParcelable("uri");
    L6:
        this.h = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void ba0(Configuration r2, WindowManager.LayoutParams r3) {
        int r4 = r2.orientation;
        if (2 != r4) goto L10;
        r3.width = (int) (n.q(getContext()) * 0.7f);
        Dialog r5 = getDialog();
        if (r5 == null) goto L18;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L19;
        r6.setGravity(81);
        Unit r7 = Unit.INSTANCE;
        return;
    L19:
        return;
    L18:
        return;
    L10:
        if (1 != r4) goto L16;
        r3.width = -1;
        Dialog r8 = getDialog();
        if (r8 == null) goto L21;
        Window r9 = r8.getWindow();
        if (r9 == null) goto L22;
        r9.setGravity(8388691);
        Unit r10 = Unit.INSTANCE;
        return;
    L22:
        return;
    L21:
        return;
    L16:
        tt5.a.h("CCMLynxPageDialog", "onConfigurationChanged");
        Unit r11 = Unit.INSTANCE;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r10, r11);
        this.i = (FrameLayout) r10.findViewById(2131379283);
        boolean r0 = true;
        if (ForsetiHelper.s(this) == false) goto L14;
        Bundle r12 = getArguments();
        if (r12 != null) goto L7;
    L9:
        boolean r13 = false;
    L10:
        if (r13 == false) goto L14;
        FrameLayout r14 = this.i;
        if (r14 == null) goto L14;
        r14.addOnLayoutChangeListener(new b(this, r10));
        goto L14
    L7:
        if (r12.getBoolean("add_back_btn_in_forseti", false) != true) goto L9;
        r13 = true;
    L14:
        CCMLynxCardView r15 = (CCMLynxCardView) org.koin.java.a.c(CCMLynxCardView.class, null, new AnonymousClass2(this), 2);
        this.j = r15;
        if (this.h != null) goto L17;
    L20:
        r0 = false;
    L21:
        if (r0 == true) goto L24;
        close();
        return;
    L24:
        Bundle r16 = getArguments();
        if (r16 == null) goto L27;
        Object r17 = r16.get("template-data-bundle-key");
    L29:
        if ((r17 instanceof HashMap) == false) goto L31;
        HashMap r6 = (HashMap) r17;
    L32:
        Bundle r18 = getArguments();
        if (r18 == null) goto L35;
        String r8 = r18.getString("share-context-ID");
    L36:
        CCMLynxCardView r3 = this.j;
        if (r3 == null) goto L44;
        FrameLayout r4 = this.i;
        Intrinsics.checkNotNull(r4);
        Uri r19 = this.h;
        if (r19 == null) goto L42;
        String r110 = r19.toString();
        if (r110 == null) goto L42;
    L43:
        r3.a(r4, r110, r6, new ViewGroup.LayoutParams(-1, -2), r8);
    L42:
        r110 = "";
    L44:
        CCMLynxCardView r111 = this.j;
        if (r111 == null) goto L47;
        r111.f(new c(this));
    L47:
        Dialog r112 = getDialog();
        if (r112 != null) goto L50;
        tt5.a.d("CCMLynxPageDialog", "addWatermark()... dialog == null");
    L51:
        XBridgeMethod r113 = new je5.b(this);
        CCMLynxCardView r114 = this.j;
        if (r114 == null) goto L54;
        r114.h(r113.c, r113);
    L54:
        CCMLynxCardView r115 = this.j;
        if (r115 == null) goto L58;
        r115.registerWeakHolder(Fragment.class, this);
        return;
    L58:
        return;
    L50:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).s(r112);
        goto L51
    L35:
        r8 = null;
        goto L36
    L31:
        r6 = null;
        goto L32
    L27:
        r17 = null;
        goto L29
    L17:
        if (this.i == null) goto L20;
        if (r15 == null) goto L20;
        goto L20
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        if (ForsetiHelper.s(this) == true) goto L8;
        Dialog r6 = getDialog();
        if (r6 == null) goto L8;
        com.ss.android.lark.insets.f r7 = WindowInsetsUtils.a(r6);
        r7.i(UIUtils.getColor(getContext(), 2131100548));
        r7.o(true);
        r7.r(true);
    L8:
        return r3.inflate(2131563609, r4, false);
    }
}
