package com.larus.kmp.voice_setting.voice.component;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import com.larus.audio.AudioServiceDelegate;
import com.larus.kmp.voice_setting.platform.VoiceImageUploadBiz;
import com.larus.kmp.voice_setting.platform.VoiceStringKey;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes30.dex */
public final class i implements m5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentFeature f352273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.platform.n0 f352274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f352275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f352276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f352277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f352278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f352279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f352280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f352281i;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f352282a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f352283b = null;

        static {
            int[] r100 = new int[VoicePlatformEffectKind.values().length];
            r100[VoicePlatformEffectKind.CREATE_VOICE_PREFLIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L71:
            r100[VoicePlatformEffectKind.REQUEST_RECORD_PERMISSION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L83:
            r100[VoicePlatformEffectKind.REQUEST_RECORD_MEDIA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L53:
            r100[VoicePlatformEffectKind.START_RECORD_QUALITY_CHECK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L55:
            r100[VoicePlatformEffectKind.STOP_RECORD_QUALITY_CHECK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L65:
            r100[VoicePlatformEffectKind.CANCEL_RECORD_QUALITY_CHECK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L77:
            r100[VoicePlatformEffectKind.PICK_IMAGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L61:
            r100[VoicePlatformEffectKind.CROP_IMAGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
        L73:
            r100[VoicePlatformEffectKind.UPLOAD_IMAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L36
        L75:
            r100[VoicePlatformEffectKind.SHOW_SHELL_FEEDBACK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L37
        L49:
            r100[VoicePlatformEffectKind.PLAY_PREVIEW.ordinal()] = 11;     // Catch: NoSuchFieldError -> L38
        L69:
            r100[VoicePlatformEffectKind.STOP_PREVIEW.ordinal()] = 12;     // Catch: NoSuchFieldError -> L39
        L81:
            r100[VoicePlatformEffectKind.RELEASE_MEDIA.ordinal()] = 13;     // Catch: NoSuchFieldError -> L40
        L47:
            r100[VoicePlatformEffectKind.VIBRATE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L41
        L57:
            r100[VoicePlatformEffectKind.REPORT_EDIT_RESULT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L42
        L21:
            f352282a = r100;
            int[] r101 = new int[VoiceShellFeedbackKind.values().length];
            r101[VoiceShellFeedbackKind.WARNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L43
        L51:
            r101[VoiceShellFeedbackKind.FAILURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L44
        L59:
            r101[VoiceShellFeedbackKind.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L45
        L67:
            r101[VoiceShellFeedbackKind.SHOW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L46
        L26:
            f352283b = r101;
        }
    }

    public static final class b implements Function1<x, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t1a.c f352284a;

        public b(x r100) {
            this.f352284a = r100;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.kmp.voice_setting.voice.component.x, t1a.c] */
        @Override // kotlin.jvm.functions.Function1
        public final x invoke(x r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return this.f352284a;
        }
    }

    @Override // com.larus.kmp.voice_setting.voice.component.m5
    public final void release() {
        this.f352274b.f351698d.a();
        this.f352274b.f351696b.c();
        this.f352274b.f351696b.a(true);
        this.f352274b.f351701g.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.larus.kmp.voice_setting.voice.component.h] */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.larus.kmp.voice_setting.voice.component.f] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.kmp.voice_setting.voice.component.g] */
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
    @Override // com.larus.kmp.voice_setting.voice.component.m5
    public final boolean a(final l5 r210) {
        Intrinsics.checkNotNullParameter(r210, "effectData");
        String r100 = "";
        boolean r101 = false;
        Long r110 = null;
        VoiceDialogImageBridgeFragment r111 = null;
        r111 = null;
        Long r112 = null;
        Long r113 = null;
        switch(a.f352282a[r210.f352355a.ordinal()]) {
            case 1: goto L102;
            case 2: goto L91;
            case 3: goto L90;
            case 4: goto L83;
            case 5: goto L79;
            case 6: goto L75;
            case 7: goto L47;
            case 8: goto L46;
            case 9: goto L45;
            case 10: goto L22;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L6;
            case 15: goto L5;
            default: goto L114;
        };
    L5:
        String r102 = r210.f352366l;
        float r103 = r210.f352367m;
        float r104 = r210.f352368n;
        Intrinsics.checkNotNullParameter(r102, "scene");
        mh9.x.i("voice_edit_result", new ouc.d0(new LinkedHashMap()), CollectionsKt.listOf(new Pair[]{TuplesKt.to("edit_scene", ouc.k.c(r102)), TuplesKt.to("voice_pitch", ouc.k.c(String.valueOf(r103))), TuplesKt.to("voice_speed", ouc.k.c(String.valueOf(r104)))}));
    L112:
        return true;
    L6:
        this.f352274b.f351707m.a(5);
        goto L112
    L7:
        b("[media] release");
        this.f352274b.f351698d.a();
        this.f352274b.f351696b.c();
        this.f352274b.f351696b.a(true);
        this.f352274b.f351701g.d();
        goto L112
    L8:
        b("[preview] stop");
        this.f352274b.f351696b.a(false);
        goto L112
    L9:
        com.larus.kmp.voice_setting.platform.q0 r105 = r210.f352363i;
        if (r105 == null) goto L112;
        StringBuilder r106 = new StringBuilder("[preview] play style=");
        String r107 = r105.f351718a;
        if (r107 == null) goto L16;
        r100 = r107;
    L16:
        r106.append(r100);
        r106.append(", hasUrl=");
        String r108 = r105.f351719b;
        if (r108 != null) goto L19;
    L20:
        r101 = true;
    L21:
        r106.append(!r101);
        b(r106.toString());
        this.f352274b.f351696b.b(r105, new j(this, r105));
        goto L112
    L19:
        if (StringsKt.isBlank(r108) == false) goto L21;
    L22:
        a8 r109 = r210.f352361g;
        if (r109 == null) goto L112;
        VoiceStringKey r114 = r109.f352153b;
        int r115 = a.f352283b[r109.f352152a.ordinal()];
        if (r115 == 1) goto L42;
        if (r115 == 2) goto L39;
        if (r115 != 3) goto L30;
        if (r114 == null) goto L38;
        this.f352274b.f351700f.f(r114);
        goto L112
    L38:
        this.f352274b.f351700f.c(r109.f352154c);
        goto L112
    L30:
        if (r115 != 4) goto L35;
        if (r114 == null) goto L33;
        this.f352274b.f351700f.e(r114);
        goto L112
    L33:
        this.f352274b.f351700f.c(r109.f352154c);
        goto L112
    L35:
        throw new NoWhenBranchMatchedException();
    L39:
        if (r114 == null) goto L41;
        this.f352274b.f351700f.b(r114);
        goto L112
    L41:
        this.f352274b.f351700f.d(r109.f352154c);
        goto L112
    L42:
        if (r114 == null) goto L44;
        this.f352274b.f351700f.a(r114);
        goto L112
    L44:
        this.f352274b.f351700f.c(r109.f352154c);
        goto L112
    L45:
        b("[image] upload effect ignored: Android bridge owns pick-crop-upload pipeline");
        goto L112
    L46:
        b("[image] crop effect ignored: Android bridge owns pick-crop-upload pipeline");
        goto L112
    L47:
        y4 r116 = r210.f352357c;
        if (r116 == null) goto L50;
        String r117 = r116.f352640a;
    L51:
        if (r117 == null) goto L54;
        r100 = r117;
    L54:
        b("[image] pick request source=".concat(r100));
        LifecycleOwner r118 = this.f352273a.getParent();
        com.larus.kmp.voice_setting.platform.j0 r119 = r210.f352358d;
        if (r119 != null) goto L57;
        r119 = new com.larus.kmp.voice_setting.platform.j0(VoiceImageUploadBiz.VOICE_ICON);
    L57:
        Function2<? super String, ? super String, Unit> r120 = new c(this);
        Intrinsics.checkNotNullParameter(r119, "request");
        Intrinsics.checkNotNullParameter(r120, "onResult");
        FragmentActivity r121 = m0.a(r118);
        if (r121 != null) goto L60;
    L59:
        final VoiceDialogImageBridgeFragment r122 = r111;
        if (r122 == null) goto L73;
        Intrinsics.checkNotNullParameter(r119, "request");
        Intrinsics.checkNotNullParameter(r120, "onResult");
        r122.f351943h = r119;
        r122.f351944i = r120;
        com.larus.platform.service.k2 r123 = com.larus.platform.service.k2.f365755a;
        com.larus.platform.api.g3.a.a(r122, r122.getActivity(), false, null, false, new j0(r122), 28);
        r101 = true;
    L73:
        if (r101 == true) goto L112;
        b("[image] bridge unavailable");
        c(this, VoiceDialogActionKind.IMAGE_UPLOAD_RESULT, 0, false, null, null, null, null, null, 254);
        goto L112
    L60:
        FragmentManager r124 = r121.getSupportFragmentManager();
        Fragment r125 = r124.findFragmentByTag("VoiceDialogImageBridge");
        if ((r125 instanceof VoiceDialogImageBridgeFragment) == false) goto L63;
        r111 = (VoiceDialogImageBridgeFragment) r125;
    L63:
        if (r111 != null) goto L59;
        r111 = new VoiceDialogImageBridgeFragment();
        FragmentTransaction r126 = r124.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r126, r111, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "VoiceDialogImageBridge", 0) == true) goto L69;
        r126.add(r111, "VoiceDialogImageBridge");
    L69:
        r126.commitNowAllowingStateLoss();
        goto L59
    L50:
        r117 = null;
        goto L51
    L75:
        StringBuilder r127 = new StringBuilder("[record] cancelQualityCheck session=");
        n0 r128 = r210.f352360f;
        if (r128 == null) goto L78;
        r112 = Long.valueOf(r128.f352385e);
    L78:
        r127.append(r112);
        b(r127.toString());
        this.f352274b.f351698d.a();
        this.f352274b.f351696b.c();
        this.f352274b.f351701g.d();
        goto L112
    L79:
        StringBuilder r129 = new StringBuilder("[record] stopQualityCheck session=");
        n0 r130 = r210.f352360f;
        if (r130 == null) goto L82;
        r113 = Long.valueOf(r130.f352385e);
    L82:
        r129.append(r113);
        b(r129.toString());
        this.f352274b.f351698d.b();
        goto L112
    L83:
        n0 r131 = r210.f352360f;
        if (r131 == null) goto L112;
        this.f352277e = r131.f352381a;
        b("[record] start session=" + r131.f352385e + ", logTraceId=" + r131.f352386f + ", language=" + r131.f352390j + ", blur=" + r131.f352392l);
        this.f352279g = 0;
        this.f352280h = 0;
        this.f352281i = 0;
        this.f352274b.f351701g.a();
        if (this.f352274b.f351701g.c() == false) goto L89;
        this.f352274b.f351701g.b();
    L89:
        this.f352274b.f351707m.a(5);
        BuildersKt.launch$default(w4.a(this.f352273a), null, null, new CommonVoicePlatformEffectExecutor$handleStartRecordQualityCheck$1(this, r131, null), 3, null);
        goto L112
    L90:
        final n0 r132 = r210.f352360f;
        this.f352274b.f351696b.f(new f(this, r132), new g(this, r132));
        goto L112
    L91:
        final n0 r133 = r210.f352360f;
        if (this.f352274b.f351695a.b() == false) goto L101;
        StringBuilder r134 = new StringBuilder("[permission] already granted session=");
        if (r133 == null) goto L96;
        r110 = Long.valueOf(r133.f352385e);
    L96:
        r134.append(r110);
        b(r134.toString());
        VoiceDialogActionKind r135 = VoiceDialogActionKind.RECORD_PERMISSION_RESULT;
        if (r133 == null) goto L99;
        long r136 = r133.f352385e;
    L100:
        c(this, r135, r136, true, null, null, null, null, null, 248);
        goto L112
    L99:
        r136 = 0;
        goto L100
    L101:
        this.f352274b.f351695a.a(new h(this, r133));
        goto L112
    L102:
        final s r137 = r210.f352359e;
        if (r137 == null) goto L112;
        if (m0.b() == false) goto L109;
        d(r210, r137, false, "Downgrade");
        goto L112
    L109:
        if (AudioServiceDelegate.f288288a.P().isRecording() == false) goto L111;
        this.f352274b.f351700f.a(VoiceStringKey.LARUS_MEMO_RECORDING_DENY_ACTIONS_ERROR_TOAST);
        d(r210, r137, false, "AiNoteRecording");
        goto L112
    L111:
        Function0 r138 = new com.larus.kmp.voice_setting.voice.component.a(this, r210, r137);
        Function0 r139 = new com.larus.kmp.voice_setting.voice.component.b(this, r210, r137);
        Intrinsics.checkNotNullParameter(r138, "onTouristConstraints");
        Intrinsics.checkNotNullParameter(r139, "onNext");
        com.larus.platform.service.i3.j(null, r138, r139, 1);
        goto L112
    L114:
        return false;
    }

    public final void b(String r100) {
        ((gd9.h) this.f352275c.getValue()).i("VoiceDialogPlatform", r100);
    }

    public i(VoicePlatformEffectFeature r100, com.larus.kmp.voice_setting.platform.n0 r101) {
        Intrinsics.checkNotNullParameter(r100, "feature");
        Intrinsics.checkNotNullParameter(r101, "gateways");
        this.f352273a = r100;
        this.f352274b = r101;
        this.f352275c = LazyKt.lazy(new d());
        this.f352276d = LazyKt.lazy(new e(this));
        this.f352277e = "";
    }

    public final void d(l5 r100, s r110, boolean r111, String r112) {
        ComponentFeature r101 = this.f352273a;
        x r102 = new x(r100.f352356b, r111, r112, r110);
        t1a.e r103 = s1a.d.a(r101).p(Reflection.getOrCreateKotlinClass(x.class));
        if (r103 == null) goto L5;
        r103.a(new b(r102));
        return;
    L5:
        x1a.b r104 = x1a.a.f562152c;
        if (r104 == null) goto L10;
        r104.log(5, "ComponentArch", "updateData ignored: context destroyed for " + Reflection.getOrCreateKotlinClass(x.class).getQualifiedName());
        return;
    }

    public static void c(i r110, VoiceDialogActionKind r111, long r112, boolean r210, String r211, String r212, String r213, String r214, String r215, int r216) {
        if ((r216 & 2) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r216 & 4) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r216 & 8) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r216 & 16) == 0) goto L17;
        String r113 = null;
    L19:
        if ((r216 & 32) == 0) goto L21;
        String r114 = null;
    L23:
        if ((r216 & 64) == 0) goto L25;
        String r115 = null;
    L27:
        if ((r216 & 128) == 0) goto L29;
        String r116 = null;
    L30:
        BuildersKt.launch$default(w4.a(r110.f352273a), null, null, new CommonVoicePlatformEffectExecutor$publishDialogAction$1(r110, r100, r111, r102, r101, r113, r114, r115, r116, null), 3, null);
        return;
    L29:
        r116 = r215;
        goto L30
    L25:
        r115 = r214;
        goto L27
    L21:
        r114 = r213;
        goto L23
    L17:
        r113 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
