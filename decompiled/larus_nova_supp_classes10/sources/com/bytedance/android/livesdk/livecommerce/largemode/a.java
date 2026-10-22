package com.bytedance.android.livesdk.livecommerce.largemode;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LargeModeConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements b {
    public static final /* synthetic */ int c = 0;
    public boolean a;
    public final float b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.largemode.a$a, reason: collision with other inner class name */
    public static final class C0076a {
        public static float a() {
            Float r0 = ECAppInfoService.e.getCurrentFontScale();
            if (r0 == null) goto L5;
            float r1 = r0.floatValue();
        L7:
            if (r1 < 1.0f) goto L12;
            if (r1 >= 1.15f) goto L12;
            return 1.0f;
        L12:
            if (r1 < 1.15f) goto L15;
            return 1.15f;
        L15:
            return 1.0f;
        L5:
            r1 = 1.0f;
            goto L7
        }
    }

    static {
    }

    public a(float r1) {
        this.b = r1;
        this.a = true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.largemode.b
    public final void a(boolean r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.largemode.b
    public final ComponentLargeModeConfig b(String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "module");
        Intrinsics.checkNotNullParameter(r14, "component");
        if (this.a == false) goto L167;
        Lazy r0 = ECLiveLargeModeConfigHelper.a;
        float r1 = this.b;
        Intrinsics.checkNotNullParameter(r13, "moduleName");
        Intrinsics.checkNotNullParameter(r14, "componentName");
        Map r2 = ECLiveLargeModeConfigHelper.d.get(String.valueOf(r1));
        if (r2 != null) goto L111;
        LinkedHashMap r3 = new LinkedHashMap();
        Map<String, LargeModeConfig> r4 = ECLiveLargeModeConfigHelper.c.get(String.valueOf(r1));
        if (r4 == null) goto L46;
        Iterator<Map.Entry<String, LargeModeConfig>> r5 = r4.entrySet().iterator();
    L11:
        if (r5.hasNext() == false) goto L46;
        Map.Entry<String, LargeModeConfig> r6 = r5.next();
        List<ComponentLargeModeConfig> r7 = r6.getValue().getData();
        if (r7 == null) goto L11;
        if ((!r7.isEmpty()) == true) goto L18;
        r7 = null;
    L18:
        if (r7 == null) goto L11;
        LinkedHashMap r8 = new LinkedHashMap();
        List<ComponentLargeModeConfig> r9 = r6.getValue().getData();
        if (r9 == null) goto L35;
        Iterator<T> r10 = r9.iterator();
    L23:
        if (r10.hasNext() == false) goto L35;
        ComponentLargeModeConfig r11 = (ComponentLargeModeConfig) r10.next();
        String r12 = r11.getComponentName();
        if (r12 == null) goto L23;
        if (r12.length() <= 0) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == true) goto L33;
        r12 = null;
    L33:
        if (r12 == null) goto L23;
        r8.put(r12, r11);
        goto L23
    L29:
        r15 = false;
    L35:
        String r16 = r6.getValue().getComponentName();
        if (r16 == null) goto L11;
        if (r16.length() <= 0) goto L40;
        boolean r17 = true;
    L41:
        if (r17 == true) goto L44;
        r16 = null;
    L44:
        if (r16 == null) goto L11;
        r3.put(r16, r8);
        goto L11
    L40:
        r17 = false;
    L46:
        List r18 = (List) ECLiveLargeModeConfigHelper.b.getValue();
        if (r18 == null) goto L105;
        ArrayList r19 = new ArrayList();
        Iterator r20 = r18.iterator();
    L50:
        if (r20.hasNext() == false) goto L54;
        Object r21 = r20.next();
        if (Intrinsics.areEqual(((LargeModeConfig) r21).getBigFontScale(), String.valueOf(r1)) == false) goto L50;
        r19.add(r21);
        goto L50
    L54:
        Iterator r22 = r19.iterator();
    L56:
        if (r22.hasNext() == false) goto L105;
        LargeModeConfig r23 = (LargeModeConfig) r22.next();
        if (r3.containsKey(r23.getComponentName()) == true) goto L59;
        String r24 = r23.getComponentName();
        if (r24 == null) goto L56;
        if (r24.length() <= 0) goto L82;
        boolean r25 = true;
    L83:
        if (r25 == true) goto L86;
        r24 = null;
    L86:
        if (r24 == null) goto L56;
        LinkedHashMap r26 = new LinkedHashMap();
        List<ComponentLargeModeConfig> r27 = r23.getData();
        if (r27 == null) goto L103;
        Iterator<T> r28 = r27.iterator();
    L91:
        if (r28.hasNext() == false) goto L103;
        ComponentLargeModeConfig r29 = (ComponentLargeModeConfig) r28.next();
        String r110 = r29.getComponentName();
        if (r110 == null) goto L91;
        if (r110.length() <= 0) goto L97;
        boolean r111 = true;
    L98:
        if (r111 == true) goto L101;
        r110 = null;
    L101:
        if (r110 == null) goto L91;
        r26.put(r110, r29);
        goto L91
    L97:
        r111 = false;
    L103:
        r3.put(r24, r26);
        goto L56
    L82:
        r25 = false;
        goto L83
    L59:
        Map r30 = (Map) r3.get(r23.getComponentName());
        if (r30 == null) goto L56;
        List<ComponentLargeModeConfig> r31 = r23.getData();
        if (r31 == null) goto L56;
        Iterator<T> r32 = r31.iterator();
    L65:
        if (r32.hasNext() == false) goto L56;
        ComponentLargeModeConfig r33 = (ComponentLargeModeConfig) r32.next();
        String r34 = r33.getComponentName();
        if (r34 == null) goto L65;
        if (r34.length() <= 0) goto L71;
        boolean r112 = true;
    L72:
        if (r112 == true) goto L75;
        r34 = null;
    L75:
        if (r34 == null) goto L65;
        r30.put(r34, r33);
        goto L65
    L71:
        r112 = false;
    L105:
        if ((!r3.isEmpty()) == false) goto L107;
        LinkedHashMap r35 = r3;
    L108:
        if (r35 == null) goto L110;
        ECLiveLargeModeConfigHelper.d.put(String.valueOf(r1), r3);
        r2 = r35;
        goto L111
    L110:
        r2 = null;
        goto L111
    L107:
        r35 = null;
    L111:
        if (r2 == null) goto L113;
        Map r113 = (Map) r2.get(r13);
    L114:
        if (r113 != null) goto L116;
        return null;
    L116:
        return (ComponentLargeModeConfig) r113.get(r14);
    L113:
        r113 = null;
        goto L114
    L167:
        return null;
    }
}
