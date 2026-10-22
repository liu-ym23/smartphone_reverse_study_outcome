package com.bytedance.applet.model.floating;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.larus.multitask_management.api.IMultiTaskHostAbility;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends i2.g {
    public static final c a = null;
    public static final StateFlowImpl b = null;
    public static final ConcurrentHashMap<String, e19.h> c = null;
    public static final ConcurrentHashMap<String, PageInfo> d = null;
    public static String e;
    public static String f;

    static {
        a = new c();
        b = j1.a(TuplesKt.to("", new JSONObject()));
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = "";
        f = "";
    }

    public final Rect b() {
        e19.t r0 = e19.t.j;
        e19.t r1 = e19.t.a.a();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.c.c.f(true);
    }

    public final boolean e() {
        e19.t r0 = e19.t.j;
        e19.t r1 = e19.t.a.a();
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.d != true) goto L7;
        return true;
    }

    public final boolean h() {
        e19.t r0 = e19.t.j;
        e19.t r1 = e19.t.a.a();
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.b.a == null) goto L7;
        boolean r2 = true;
    L8:
        if (r2 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r2 = false;
        goto L8
    }

    public final k2.s j() {
        AppletRuntimeManager r0 = AppletRuntimeManager.INSTANCE;
        String r1 = e;
        r0.getClass();
        k2.s r2 = AppletRuntimeManager.e(r1);
        if ((r2 instanceof k2.s) == true) goto L7;
        return null;
    L7:
        return r2;
    }

    public c() {
    }

    public final boolean g(final String r11) {
        Intrinsics.checkNotNullParameter(r11, "viewId");
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.i("FloatingAbilityImpl", "closeFloatingWidget, viewId[" + r11 + ']');
        final e19.h r1 = c.get(r11);
        boolean r4 = false;
        if (r1 != null) goto L5;
        return false;
    L5:
        e19.t r5 = e19.t.j;
        e19.t r6 = e19.t.a.a();
        if (r6 != null) goto L8;
    L10:
        String r7 = null;
        if (r4 == true) goto L13;
    L24:
        StringBuilder r8 = new StringBuilder("try remove Floating widget, packageName[");
        ConcurrentHashMap<String, PageInfo> r9 = d;
        PageInfo r10 = r9.get(r11);
        if (r10 == null) goto L27;
        String r12 = r10.getPackageName();
    L28:
        r8.append(r12);
        r8.append("], pageName[");
        PageInfo r13 = r9.get(r11);
        if (r13 == null) goto L31;
        r7 = r13.getPageName();
    L31:
        r8.append(r7);
        r8.append(']');
        r0.i("FloatingAbilityImpl", r8.toString());
        e19.t r14 = e19.t.a.a();
        if (r14 == null) goto L34;
        r14.m(r1);
    L34:
        return true;
    L27:
        r12 = null;
        goto L28
    L13:
        if (e() == false) goto L24;
        StringBuilder r15 = new StringBuilder("hide Floating widget first, packageName[");
        ConcurrentHashMap<String, PageInfo> r16 = d;
        PageInfo r17 = r16.get(r11);
        if (r17 == null) goto L17;
        String r18 = r17.getPackageName();
    L18:
        r15.append(r18);
        r15.append("], pageName[");
        PageInfo r19 = r16.get(r11);
        if (r19 == null) goto L21;
        r7 = r19.getPageName();
    L21:
        r15.append(r7);
        r15.append(']');
        r0.i("FloatingAbilityImpl", r15.toString());
        e19.t r2 = e19.t.a.a();
        if (r2 == null) goto L34;
        e19.i.a.a(r2, new a(r11, r1), 1);
        goto L34
    L17:
        r18 = null;
        goto L18
    L8:
        if (r6.j(r1) != true) goto L10;
        r4 = true;
        goto L10
    }

    public final boolean a(String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "viewId");
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.i("FloatingAbilityImpl", "setFloatingWidgetVisible, viewId[" + r11 + "], show[" + r12 + ']');
        boolean r4 = false;
        String r5 = null;
        if (r12 == false) goto L39;
        if (r11 != null) goto L8;
        r0.i("FloatingAbilityImpl", "try show current Floating window, viewId is null");
        e19.t r13 = e19.t.j;
        e19.t r14 = e19.t.a.a();
        if (r14 == null) goto L63;
        r14.b();
    L63:
        return true;
    L8:
        e19.h r15 = c.get(r11);
        if (r15 == null) goto L63;
        StringBuilder r7 = new StringBuilder("try enqueue and show Floating window, packageName[");
        ConcurrentHashMap<String, PageInfo> r8 = d;
        PageInfo r9 = r8.get(r11);
        if (r9 == null) goto L14;
        String r10 = r9.getPackageName();
    L15:
        r7.append(r10);
        r7.append("], pageName[");
        PageInfo r16 = r8.get(r11);
        if (r16 == null) goto L18;
        String r17 = r16.getPageName();
    L19:
        r7.append(r17);
        r7.append(']');
        r0.i("FloatingAbilityImpl", r7.toString());
        r15.e(false);
        e19.t r18 = e19.t.j;
        e19.t r19 = e19.t.a.a();
        if (r19 == null) goto L22;
        r19.e(r15);
    L22:
        e19.t r20 = e19.t.a.a();
        if (r20 != null) goto L25;
    L27:
        if (r4 == false) goto L63;
        StringBuilder r110 = new StringBuilder("try show Floating window, packageName[");
        PageInfo r6 = r8.get(r11);
        if (r6 == null) goto L31;
        String r21 = r6.getPackageName();
    L32:
        r110.append(r21);
        r110.append("], pageName[");
        PageInfo r111 = r8.get(r11);
        if (r111 == null) goto L35;
        r5 = r111.getPageName();
    L35:
        r110.append(r5);
        r110.append(']');
        r0.i("FloatingAbilityImpl", r110.toString());
        e19.t r112 = e19.t.a.a();
        if (r112 == null) goto L63;
        r112.b();
        goto L63
    L31:
        r21 = null;
        goto L32
    L25:
        if (r20.j(r15) != true) goto L27;
        r4 = true;
        goto L27
    L18:
        r17 = null;
        goto L19
    L14:
        r10 = null;
        goto L15
    L39:
        if (r11 != null) goto L43;
        r0.i("FloatingAbilityImpl", "try hide current Floating window, viewId is null");
        e19.t r113 = e19.t.j;
        e19.t r114 = e19.t.a.a();
        if (r114 == null) goto L63;
        e19.i.a.a(r114, null, 3);
        goto L63
    L43:
        e19.h r22 = c.get(r11);
        if (r22 == null) goto L63;
        r22.e(true);
        e19.t r23 = e19.t.j;
        e19.t r24 = e19.t.a.a();
        if (r24 != null) goto L49;
    L51:
        if (r4 == false) goto L63;
        StringBuilder r25 = new StringBuilder("try hide Floating window, packageName[");
        ConcurrentHashMap<String, PageInfo> r26 = d;
        PageInfo r27 = r26.get(r11);
        if (r27 == null) goto L55;
        String r28 = r27.getPackageName();
    L56:
        r25.append(r28);
        r25.append("], pageName[");
        PageInfo r115 = r26.get(r11);
        if (r115 == null) goto L59;
        String r116 = r115.getPageName();
    L60:
        r25.append(r116);
        r25.append(']');
        r0.i("FloatingAbilityImpl", r25.toString());
        e19.t r117 = e19.t.a.a();
        if (r117 == null) goto L63;
        e19.i.a.a(r117, null, 3);
        goto L63
    L59:
        r116 = null;
        goto L60
    L55:
        r28 = null;
        goto L56
    L49:
        if (r24.j(r22) != true) goto L51;
        r4 = true;
        goto L51
    }

    public final boolean c(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "pageName");
        Intrinsics.checkNotNullParameter(r6, "packageName");
        Iterator<PageInfo> r0 = d.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        PageInfo r1 = r0.next();
        if (Intrinsics.areEqual(r1.getPageName(), r5) == false) goto L4;
        if (Intrinsics.areEqual(r1.getPackageName(), r6) == false) goto L4;
        boolean r2 = true;
    L11:
        com.bytedance.ai.utils.g.a.i("FloatingAbilityImpl", "hasFloatingPage(" + r5 + ',' + r6 + "): " + r2);
        return r2;
    L10:
        r2 = false;
        goto L11
    }

    public final int d(k2.s r17, PageInfo r18, FragmentActivity r19) {
        Intrinsics.checkNotNullParameter(r17, "page");
        Intrinsics.checkNotNullParameter(r18, "pageInfo");
        int r12 = 1;
        if (r17 != null) goto L7;
        com.bytedance.ai.utils.g.a.i("FloatingAbilityImpl", "try show current Floating window, floating is null");
        e19.t r0 = e19.t.j;
        e19.t r1 = e19.t.a.a();
        if (r1 == null) goto L84;
        r1.b();
    L84:
        com.bytedance.ai.utils.g.a.i("FloatingAbilityImpl", "attachFloatingWidget, packageName[" + r18.getPackageName() + "], pageName[" + r18.getPageName() + "], result[" + r12 + ']');
        return r12;
    L7:
        IMultiTaskHostAbility r2 = (IMultiTaskHostAbility) ServiceManager.get().getService(IMultiTaskHostAbility.class);
        if (r2 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L15;
        com.bytedance.ai.utils.g.a.e("FloatingAbilityImpl", "MultiTaskManagement is enabled, not show Floating window");
    L68:
        r12 = 0;
        goto L84
    L15:
        int r4 = com.bytedance.applet.utils.c.a;
        String r5 = r18.getPageData();
        if (r5 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == false) goto L86;
    L32:
        String r7 = "";
    L33:
        f = r7;
        com.bytedance.ai.utils.g.a.i("FloatingAbilityImpl", "little window request info=" + r18.getPageData());
        String r14 = r18.getPageId();
        e19.h r8 = c.get(r14);
        if (r8 == null) goto L36;
        e19.h r9 = r8;
    L67:
        if (r9 == null) goto L68;
        r9.e(false);
        com.bytedance.ai.utils.g r10 = com.bytedance.ai.utils.g.a;
        r10.i("FloatingAbilityImpl", "try enqueue and show Floating window, packageName[" + r18.getPackageName() + "], pageName[" + r18.getPageName() + ']');
        e19.t r11 = e19.t.j;
        e19.t r13 = e19.t.a.a();
        if (r13 == null) goto L72;
        int r15 = r13.e(r9);
    L73:
        e19.t r16 = e19.t.a.a();
        if (r16 != null) goto L76;
    L78:
        r12 = 0;
    L79:
        if (r12 == 0) goto L83;
        r10.i("FloatingAbilityImpl", "try show Floating window, packageName[" + r18.getPackageName() + "], pageName[" + r18.getPageName() + ']');
        e19.t r20 = e19.t.a.a();
        if (r20 == null) goto L83;
        r20.b();
    L83:
        r12 = r15;
        goto L84
    L76:
        if (r16.j(r9) != true) goto L78;
    L72:
        r15 = 0;
        goto L73
    L36:
        View r21 = r17.realView();
        if (r21 == null) goto L66;
        ReadableMap r22 = r18.getPageSettings();
        Ref.IntRef r23 = new Ref.IntRef();
        if (r22 != null) goto L41;
    L43:
        boolean r24 = false;
    L45:
        if (r24 == true) goto L88;
        int r25 = 0;
    L51:
        r23.element = r25;
        if (r25 >= (-2)) goto L57;
        if (r25 <= 2) goto L57;
        r23.element = -2;
    L57:
        if (r22 != null) goto L59;
    L61:
        boolean r26 = false;
    L62:
        if (r26 == false) goto L64;
        boolean r27 = Intrinsics.areEqual(r22.getString("reshowAfterHighLevel"), CommentScene.COMMENTSCENE_NO_AWEME);
    L65:
        r9 = new b(r23, r27, r18, r21, r17, r14);
        c.put(r14, r9);
        d.put(r14, r18);
        goto L67
    L64:
        r27 = false;
        goto L65
    L59:
        if (r22.hasKey("reshowAfterHighLevel") != true) goto L61;
        r26 = true;
        goto L62
    L88:
        r25 = CastIntegerProtector.parseInt(r22.getString("priority"));     // Catch: NumberFormatException -> L48
    L48:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("FloatingAbilityImpl", "key priority wrong: " + r22.getString("priority"), e);
        r25 = -2;
        goto L51
    L41:
        if (r22.hasKey("priority") != true) goto L43;
        r24 = true;
        goto L45
    L66:
        r9 = null;
        goto L67
    L86:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L27
        r7 = JSONObjectProtectorUtils.getString(new JSONObject(r5), "resource_id");     // Catch: Throwable -> L27
        if (r7 != null) goto L33;
    L27:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Throwable r30 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r30 == null) goto L32;
        FLogger.a.e("DeepResearchUtil", "getDeepSearchResourceId err=" + r30);
        goto L32
    L18:
        if (StringsKt.isBlank(r5) == true) goto L21;
        r6 = false;
        goto L22
    L10:
        if (r2.P0() != true) goto L12;
        r3 = true;
        goto L13
    }

    public final void f(k2.s r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "page");
        e19.h r0 = c.get(r5.getPageID());
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.ai.utils.g.a.i("FloatingAbilityImpl", "updateRequestViewSize id:" + r5.getPageID() + " w:" + r6 + " h:" + r7);
        r0.setWidth(r6);
        r0.setHeight(r7);
        e19.t r8 = e19.t.j;
        e19.t r9 = e19.t.a.a();
        if (r9 == null) goto L9;
        r9.n(r0);
        return;
    }
}
