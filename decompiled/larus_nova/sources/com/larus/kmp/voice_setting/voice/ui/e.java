package com.larus.kmp.voice_setting.voice.ui;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import com.larus.im.FlowRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f354986a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SemanticsPropertyKey<String> f354987b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SemanticsPropertyKey<String> f354988c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SemanticsPropertyKey<String> f354989d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SemanticsPropertyKey<String> f354990e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SemanticsPropertyKey<String> f354991f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final SemanticsPropertyKey<String> f354992g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final SemanticsPropertyKey<String> f354993h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final SemanticsPropertyKey<Integer> f354994i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final SemanticsPropertyKey<Boolean> f354995j = null;

    static {
        f354986a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "voiceDebugScreen", "getVoiceDebugScreen(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "voiceDebugListKind", "getVoiceDebugListKind(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "voiceDebugRowKey", "getVoiceDebugRowKey(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "voiceDebugVoiceId", "getVoiceDebugVoiceId(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "voiceDebugDialogKind", "getVoiceDebugDialogKind(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "voiceDebugAction", "getVoiceDebugAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "voiceDebugPlayState", "getVoiceDebugPlayState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "voiceDebugProgressValue", "getVoiceDebugProgressValue(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "voiceDebugSelected", "getVoiceDebugSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1))};
        f354987b = new SemanticsPropertyKey("VoiceDebugScreen", null, 2, null);
        f354988c = new SemanticsPropertyKey("VoiceDebugListKind", null, 2, null);
        f354989d = new SemanticsPropertyKey("VoiceDebugRowKey", null, 2, null);
        f354990e = new SemanticsPropertyKey("VoiceDebugVoiceId", null, 2, null);
        f354991f = new SemanticsPropertyKey("VoiceDebugDialogKind", null, 2, null);
        f354992g = new SemanticsPropertyKey("VoiceDebugAction", null, 2, null);
        f354993h = new SemanticsPropertyKey("VoiceDebugPlayState", null, 2, null);
        f354994i = new SemanticsPropertyKey("VoiceDebugProgressValue", null, 2, null);
        f354995j = new SemanticsPropertyKey("VoiceDebugSelected", null, 2, null);
    }

    public static final boolean f() {
        gd9.l r100 = FlowRuntime.b().a();     // Catch: Throwable -> L9
        if (r100.isTestChannel() == true) goto L6;
        if (r100.o() == false) goto L7;
    L6:
        return true;
    L7:
        return false;
    }

    public static final String b(String r100, String r101) {
        if (r100 == null) goto L5;
        String r102 = StringsKt.trim(r100).toString();
    L6:
        String r103 = "";
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        if (r101 == null) goto L11;
        String r104 = StringsKt.trim(r101).toString();
    L12:
        if (r104 == null) goto L15;
        r103 = r104;
    L15:
        boolean r105 = true;
        if (r103.length() != 0) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == true) goto L35;
        if (f() == false) goto L35;
        if (r102.length() == 0) goto L27;
        r105 = false;
    L27:
        if (r105 == false) goto L30;
        return r103;
    L30:
        if (StringsKt.contains$default(r102, r103, false, 2, null) == false) goto L33;
        return r102;
    L33:
        return r102 + 65292 + r103;
    L35:
        if (r102.length() > 0) goto L38;
        r105 = false;
    L38:
        if (r105 == true) goto L40;
        return null;
    L40:
        return r102;
    L18:
        r106 = false;
        goto L19
    L11:
        r104 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public static final Modifier e(Modifier r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "tag");
        if (f() == true) goto L5;
        return r100;
    L5:
        Modifier r102 = TestTagKt.testTag(r100, r101);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        return SemanticsModifierKt.semantics$default(r102, false, new f(), 1, null);
    }

    public static final Modifier h(Modifier r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "tag");
        if (f() == true) goto L6;
        return r100;
    L6:
        return TestTagKt.testTag(r100, r101);
    }

    public static final Modifier c(Modifier r110, final String r111, final String r112, final String r113, final String r114, final String r115, final String r116, final String r117, final Integer r210, final Boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (f() == true) goto L6;
        return r110;
    L6:
        return SemanticsModifierKt.semantics$default(r110, false, new b(r111, r112, r113, r114, r115, r116, r117, r210, r211), 1, null);
    }

    public static /* synthetic */ Modifier d(Modifier r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, Integer r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r103 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r104 = null;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r105 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r106 = null;
    L21:
        if ((r111 & 64) == 0) goto L24;
        r107 = null;
    L24:
        if ((r111 & 128) == 0) goto L27;
        r110 = null;
    L27:
        return c(r100, r101, r102, r103, r104, r105, r106, r107, r110, null);
    }

    public static Modifier g(Modifier r110, final String r111, String r112, String r113, String r210, String r211, Boolean r212, Role r213, Boolean r214, int r215) {
        if ((r215 & 2) == 0) goto L5;
        final String r100 = null;
    L7:
        if ((r215 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r215 & 128) == 0) goto L13;
        String r114 = null;
    L15:
        if ((r215 & 256) == 0) goto L17;
        String r115 = null;
    L19:
        if ((r215 & 1024) == 0) goto L21;
        Boolean r116 = null;
    L23:
        if ((r215 & 2048) == 0) goto L25;
        final Role r102 = null;
    L27:
        if ((r215 & 4096) == 0) goto L29;
        final Boolean r103 = null;
    L30:
        Intrinsics.checkNotNullParameter(r110, "$this$voiceStateSemantics");
        Intrinsics.checkNotNullParameter(r111, "stateDescription");
        return SemanticsModifierKt.semantics$default(c(r110, r101, null, null, null, null, r114, r115, null, r116), false, new d(r100, r111, r102, r103), 1, null);
    L29:
        r103 = r214;
        goto L30
    L25:
        r102 = r213;
        goto L27
    L21:
        r116 = r212;
        goto L23
    L17:
        r115 = r211;
        goto L19
    L13:
        r114 = r210;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    public static Modifier a(Modifier r110, final String r111, String r112, String r113, String r210, String r211, String r212, String r213, Boolean r214, String r215, boolean r216, int r217, Boolean r218, int r219) {
        if ((r219 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r219 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r219 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r219 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r219 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r219 & 128) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r219 & 512) == 0) goto L29;
        Boolean r114 = null;
    L31:
        if ((r219 & 1024) == 0) goto L33;
        String r115 = null;
    L35:
        if ((r219 & 2048) == 0) goto L37;
        boolean r116 = true;
    L39:
        if ((r219 & 4096) == 0) goto L41;
        int r117 = Role.Companion.m6769getButtono7Vup1c();
    L43:
        if ((r219 & 8192) == 0) goto L45;
        Boolean r106 = null;
    L46:
        Intrinsics.checkNotNullParameter(r110, "$this$voiceButtonSemantics");
        Intrinsics.checkNotNullParameter(r111, "label");
        Modifier r107 = c(r110, r100, r101, r102, r103, null, r104, r105, null, r114);
        final String r220 = r115;
        final int r221 = r117;
        final Boolean r222 = r106;
        final boolean r223 = r116;
        return SemanticsModifierKt.semantics$default(r107, false, new c(r111, r220, r221, r222, r223), 1, null);
    L45:
        r106 = r218;
        goto L46
    L41:
        r117 = r217;
        goto L43
    L37:
        r116 = r216;
        goto L39
    L33:
        r115 = r215;
        goto L35
    L29:
        r114 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
