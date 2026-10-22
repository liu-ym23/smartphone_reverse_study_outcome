package com.bytedance.lynx.service.trail;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.utils.LynxViewBuilderProperty;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f264996a = 0;

    static {
    }

    public static Boolean b(String r100) {
        String r101 = StringsKt.trim(r100).toString().toLowerCase(Locale.ROOT);
        int r102 = r101.hashCode();
        if (r102 == 48) goto L22;
        if (r102 == 49) goto L18;
        if (r102 == 3569038) goto L15;
        if (r102 == 97196323) goto L12;
    L23:
        return null;
    L12:
        if (r101.equals("false") == false) goto L23;
    L25:
        return Boolean.FALSE;
    L15:
        if (r101.equals("true") == false) goto L23;
    L26:
        return Boolean.TRUE;
    L18:
        if (r101.equals("1") == true) goto L26;
    L22:
        if (r101.equals("0") == true) goto L25;
        goto L23
    }

    public static void a(String r100, String r101, LynxViewBuilder r102) {
        if (r100 == null) goto L32;
        if (r101 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r100, LynxViewBuilderProperty.PLATFORM_CONFIG.getKey()) == false) goto L9;
        r102.insertLynxViewConfig(r100, r101);
        return;
    L9:
        if (Intrinsics.areEqual(r100, "enable_unified_pipeline") == false) goto L14;
        Boolean r103 = b(r101);
        if (r103 == null) goto L34;
        LynxViewBuilder r104 = r102.setEnableUnifiedPipeline(r103.booleanValue());
        return;
    L34:
        return;
    L14:
        if (Intrinsics.areEqual(r100, "enable_js_group_thread") == false) goto L22;
        Boolean r105 = b(r101);
        if (r105 == null) goto L36;
        boolean r106 = r105.booleanValue();
        LynxGroup r107 = r102.getLynxGroup();
        if (r107 != null) goto L20;
        r107 = new LynxGroup(new LynxGroup.a());
    L20:
        r107.setEnableJSGroupThread(r106);
        r102.setLynxGroup(r107);
        return;
    L36:
        return;
    L22:
        if (Intrinsics.areEqual(r100, "enable_mts_module") == false) goto L27;
        Boolean r108 = b(r101);
        if (r108 == null) goto L38;
        LynxViewBuilder r109 = r102.setEnableMTSModule(r108.booleanValue());
        return;
    L38:
        return;
    L27:
        if (Intrinsics.areEqual(r100, "embedded_mode") == false) goto L40;
        Integer r110 = StringsKt.toIntOrNull(StringsKt.trim(r101).toString());
        if (r110 == null) goto L41;
        LynxViewBuilder r111 = r102.setEmbeddedMode(r110.intValue());
        return;
    L41:
        return;
    L40:
        return;
    }
}
