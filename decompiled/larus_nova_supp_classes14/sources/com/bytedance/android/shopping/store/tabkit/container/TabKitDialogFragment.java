package com.bytedance.android.shopping.store.tabkit.container;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.services.apm.api.EnsureManager;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/TabKitDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitDialogFragment extends DialogFragment {
    public static final boolean j = false;
    public TabKitFragment d;
    public FrameLayout e;
    public Bundle f;
    public TabKitRouterParams g;
    public String h;
    public boolean i;

    public static final class a {
    }

    public final int getTheme() {
        return 2131953522;
    }

    static {
        int r0 = hk3.a.a;
        int r1 = n.a;
        Object r2 = Boolean.FALSE;
        int r3 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L166
        Object r5 = null;
        Object r6 = com.bytedance.android.ec.base.settings.d.c.get("tabkit_lite_page_enable_show_now");     // Catch: Throwable -> L57
        if (r6 != null) goto L9;
    L54:
        Object r7 = null;
    L55:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L57
    L59:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L166
        if (r9 == null) goto L63;
        EnsureManager.ensureNotReachHere(r9);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r8) == false) goto L66;
        r8 = null;
    L66:
        if ((r8 instanceof Boolean) == true) goto L68;
        r8 = null;
    L68:
        Object r10 = (Boolean) r8;     // Catch: Throwable -> L166
        if (r10 != null) goto L75;
        Object r11 = com.bytedance.android.ec.base.settings.d.a.get("tabkit_lite_page_enable_show_now");     // Catch: Throwable -> L166
        if ((r11 instanceof Boolean) == true) goto L74;
        r11 = null;
    L74:
        r10 = (Boolean) r11;     // Catch: Throwable -> L166
    L75:
        if (r10 != null) goto L175;
        int r12 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("tabkit_lite_page_enable_show_now");     // Catch: Throwable -> L130
        if (r13 != null) goto L82;
    L127:
        Object r14 = null;
    L128:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L130
    L132:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L156
        if (r16 == null) goto L136;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r15) == false) goto L139;
        r15 = null;
    L139:
        if ((r15 instanceof Boolean) == true) goto L141;
        r15 = null;
    L141:
        r10 = (Boolean) r15;     // Catch: Throwable -> L156
        if (r10 != null) goto L164;
        IHybridHostService r17 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r17 == null) goto L147;
        Object r18 = r17.getHostABValue("tabkit_lite_page_enable_show_now", r2);     // Catch: Throwable -> L156
    L148:
        if (r18 != null) goto L150;
    L155:
        r10 = r2;
        goto L164
    L150:
        if ((r18 instanceof Boolean) == false) goto L153;
        r5 = r18;
    L153:
        Object r19 = (Boolean) r5;     // Catch: Throwable -> L156
        if (r19 == null) goto L155;
    L163:
        r10 = r19;
        goto L164
    L147:
        r18 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("tabkit_lite_page_enable_show_now", r10);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r13 instanceof Boolean) == true) goto L84;
        Object r20 = null;
    L85:
        r14 = (Boolean) r20;     // Catch: Throwable -> L130
        if (r14 != null) goto L128;
        if ((r13 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r21 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L130
        if ((r21 instanceof Boolean) == true) goto L95;
        r21 = null;
    L95:
        r14 = (Boolean) r21;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r22 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L130
        if ((r22 instanceof Boolean) == true) goto L101;
        r22 = null;
    L101:
        r14 = (Boolean) r22;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r23 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L130
        if ((r23 instanceof Boolean) == true) goto L107;
        r23 = null;
    L107:
        r14 = (Boolean) r23;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r24 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L130
        if ((r24 instanceof Boolean) == true) goto L113;
        r24 = null;
    L113:
        r14 = (Boolean) r24;     // Catch: Throwable -> L130
    L115:
        if ((r13 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r25 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r25 instanceof Boolean) == true) goto L121;
        r25 = null;
    L121:
        Object r26 = Result.constructor-impl((Boolean) r25);     // Catch: Throwable -> L123
    L125:
        r14 = r26;
        if (Result.isFailure-impl(r14) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L130
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r13 instanceof JSONArray) == false) goto L127;
    L84:
        r20 = r13;
    L156:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L166
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r29 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L166
        if (r29 == null) goto L161;
        EnsureManager.ensureNotReachHere(r29);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r19) == false) goto L163;
        r19 = r2;
    L130:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L156
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L175:
        j = ((Boolean) r10).booleanValue();
        return;
    L9:
        if ((r6 instanceof Boolean) == true) goto L11;
        Object r31 = null;
    L12:
        r7 = (Boolean) r31;     // Catch: Throwable -> L57
        if (r7 != null) goto L55;
        if ((r6 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r32 = Float.valueOf(((Number) r6).floatValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Boolean) == true) goto L22;
        r32 = null;
    L22:
        r7 = (Boolean) r32;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r33 = Double.valueOf(((Number) r6).doubleValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Boolean) == true) goto L28;
        r33 = null;
    L28:
        r7 = (Boolean) r33;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r34 = Integer.valueOf(((Number) r6).intValue());     // Catch: Throwable -> L57
        if ((r34 instanceof Boolean) == true) goto L34;
        r34 = null;
    L34:
        r7 = (Boolean) r34;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r35 = Long.valueOf(((Number) r6).longValue());     // Catch: Throwable -> L57
        if ((r35 instanceof Boolean) == true) goto L40;
        r35 = null;
    L40:
        r7 = (Boolean) r35;     // Catch: Throwable -> L57
    L42:
        if ((r6 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r36 = SDKSettingsCacheManager.a().fromJson(r6.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r36 instanceof Boolean) == true) goto L48;
        r36 = null;
    L48:
        Object r37 = Result.constructor-impl((Boolean) r36);     // Catch: Throwable -> L50
    L52:
        r7 = r37;
        if (Result.isFailure-impl(r7) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L57
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r6 instanceof JSONArray) == false) goto L54;
    L11:
        r31 = r6;
    L57:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L166
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Object r41 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r42 = Result.exceptionOrNull-impl(r41);
        if (r42 == null) goto L171;
        EnsureManager.ensureNotReachHere(r42);
    L171:
        if (Result.isFailure-impl(r41) == true) goto L174;
        r2 = r41;
    L174:
        r10 = r2;
        goto L175
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        i.b(this.h, Type.FRAGMENT, Action.ON_DESTROY);
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        int r0 = ik3.a.a;
        ik3.a.a(this, this.g);
        i.a("fragment onPause, unique id=" + this.h);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        i.a("fragment onResume, unique id=" + this.h);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (this.i == true) goto L10;
        Function0<Unit> r0 = new TabKitDialogFragment$initDebugTag$1(this);
        Intrinsics.checkNotNullParameter(r0, "block");
        if (ECAppInfoService.e.isLocalTest() == false) goto L9;
        r0.invoke();
        return;
    L9:
        return;
    }

    public TabKitDialogFragment() {
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        d.a(r2);
    }

    public final void onCreate(Bundle r5) {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("key_tabkit_root_fragment_id");
        if (r1 == null) goto L6;
    L7:
        this.h = r1;
        i.a("fragment onCreate, unique id=" + this.h + ", ctx=" + getContext());
        i.b(this.h, Type.FRAGMENT, Action.ON_CREATE);
        Bundle r2 = getArguments();
        if (r2 == null) goto L10;
        Bundle r3 = r2.getBundle("biz_arguments");
    L11:
        this.f = r3;
        if (r3 == null) goto L14;
        Object r4 = r3.get(TabKitRouterParams.KEY_ROUTER_PARAMS);
    L16:
        if ((r4 instanceof TabKitRouterParams) == true) goto L18;
        r4 = null;
    L18:
        this.g = (TabKitRouterParams) r4;
        Bundle r6 = this.f;
        if (r6 == null) goto L23;
        long r7 = r6.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
        Map<Long, TabkitFirstFramePref> r8 = ok3.a.e;
        TabkitFirstFramePref r9 = ok3.a.C0149a.a(r7);
        if (r9 == null) goto L23;
        TabkitFramePref.recordTime$default(r9, "t_on_create_fragment", null, 2, null);
    L23:
        super.onCreate(r5);
        return;
    L14:
        r4 = null;
        goto L16
    L10:
        r3 = null;
    L6:
        r1 = "";
        goto L7
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Bundle r0 = this.f;
        TabKitFragment r1 = null;
        if (r0 == null) goto L7;
        long r2 = r0.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
        Map<Long, TabkitFirstFramePref> r3 = ok3.a.e;
        TabkitFirstFramePref r4 = ok3.a.C0149a.a(r2);
        if (r4 == null) goto L7;
        TabkitFramePref.recordTime$default(r4, "t_on_view_created_fragment", null, 2, null);
    L7:
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        if (r6 != null) goto L39;
        int r7 = ik3.a.a;
        TabKitRouterParams r8 = this.g;
        if (r8 == null) goto L12;
        String r9 = r8.getPageEnterAnim();
    L13:
        if (r9 != null) goto L16;
    L21:
        int r10 = 2131953518;
    L22:
        Dialog r11 = getDialog();
        if (r11 == null) goto L29;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L29;
        WindowManager.LayoutParams r13 = r12.getAttributes();
        if (r13 == null) goto L29;
        Integer r14 = Integer.valueOf(r13.windowAnimations);
    L30:
        if (r14 != null) goto L33;
    L34:
        Dialog r15 = getDialog();
        if (r15 == null) goto L40;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L40;
        r16.setWindowAnimations(r10);
    L40:
        View r17 = r5.findViewById(2131388067);
        if ((r17 instanceof FrameLayout) == true) goto L43;
        r17 = null;
    L43:
        this.e = (FrameLayout) r17;
        Fragment r18 = getChildFragmentManager().findFragmentByTag("tabkit_fragment");
        if ((r18 instanceof TabKitFragment) == true) goto L46;
        r18 = null;
    L46:
        TabKitFragment r19 = (TabKitFragment) r18;
        this.d = r19;
        if (r19 != null) goto L73;
        Bundle r20 = getArguments();
        if (r20 == null) goto L51;
        Serializable r21 = r20.getSerializable("tabkit_fragment_clazz");
    L53:
        if ((r21 instanceof Class) == true) goto L55;
        r21 = null;
    L55:
        Class r22 = (Class) r21;
        if (r22 == null) goto L60;
        Constructor r23 = r22.getDeclaredConstructor(new Class[0]);
        if (r23 == null) goto L60;
        r1 = (TabKitFragment) r23.newInstance(new Object[0]);
    L60:
        this.d = r1;
        if (r1 == null) goto L66;
        Bundle r24 = new Bundle();
        Bundle r25 = this.f;
        if (r25 == null) goto L65;
        r24.putAll(r25);
    L65:
        Unit r26 = Unit.INSTANCE;
        r1.setArguments(r24);
    L66:
        TabKitFragment r27 = this.d;
        if (r27 == null) goto L73;
        FragmentTransaction r28 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r28, r27, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "tabkit_fragment", 2131388067) == true) goto L72;
        r28.add(2131388067, r27, "tabkit_fragment");
    L72:
        r28.commitNowAllowingStateLoss();
        goto L73
    L51:
        r21 = null;
    L73:
        Dialog r29 = getDialog();
        if (r29 == null) goto L78;
        Window r30 = r29.getWindow();
        if (r30 == null) goto L78;
        l0.d(r30);
    L78:
        Dialog r31 = getDialog();
        if (r31 == null) goto L82;
        r31.setOnKeyListener(new h(this));
        return;
    L82:
        return;
    L33:
        if (r14.intValue() == r10) goto L40;
    L29:
        r14 = null;
        goto L30
    L16:
        if (r9.hashCode() != 3135100) goto L21;
        if (r9.equals("fade") == false) goto L21;
        r10 = 2131953520;
        goto L22
    L12:
        r9 = null;
        goto L13
    L39:
        int r32 = ik3.a.a;
        ik3.a.a(this, this.g);
        goto L40
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131560978, r2);
    }
}
