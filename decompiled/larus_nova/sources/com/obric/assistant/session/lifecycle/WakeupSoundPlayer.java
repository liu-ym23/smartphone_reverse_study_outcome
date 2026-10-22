package com.obric.assistant.session.lifecycle;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricWakeupSoundConfig;
import com.obric.assistant.ObricWakeupSoundOption;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.t1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class WakeupSoundPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WakeupSoundPlayer f391618a = null;

    static {
        f391618a = new WakeupSoundPlayer();
    }

    public WakeupSoundPlayer() {
    }

    public static Integer c(String r100) {
        String r101 = StringsKt.removePrefix(r100, "raw:");
        if (StringsKt.startsWith$default(r100, "raw:", false, 2, null) == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        int r102 = r101.hashCode();
        if (r102 == (-1621433828)) goto L47;
        if (r102 == (-612322121)) goto L43;
        switch(r102) {
            case -935579990: goto L39;
            case -935579989: goto L35;
            case -935579988: goto L31;
            case -935579987: goto L27;
            case -935579986: goto L23;
            case -935579985: goto L19;
            case -935579984: goto L15;
            default: goto L59;
        };
    L59:
        return null;
    L15:
        if (r101.equals("sound_effect_doubao_peach_07") == true) goto L51;
        return null;
    L51:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_07);
    L19:
        if (r101.equals("sound_effect_doubao_peach_06") == true) goto L52;
        return null;
    L52:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_06);
    L23:
        if (r101.equals("sound_effect_doubao_peach_05") == true) goto L53;
        return null;
    L53:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_05);
    L27:
        if (r101.equals("sound_effect_doubao_peach_04") == true) goto L54;
        return null;
    L54:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_04);
    L31:
        if (r101.equals("sound_effect_doubao_peach_03") == true) goto L55;
        return null;
    L55:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_03);
    L35:
        if (r101.equals("sound_effect_doubao_peach_02") == true) goto L56;
        return null;
    L56:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_02);
    L39:
        if (r101.equals("sound_effect_doubao_peach_01") == true) goto L57;
        return null;
    L57:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_01);
    L43:
        if (r101.equals("sound_effect_assistant_wake_up") == true) goto L58;
        return null;
    L58:
        return Integer.valueOf(R.raw.sound_effect_assistant_wake_up);
    L47:
        if (r101.equals("sound_effect_assistant_listening") == true) goto L50;
        return null;
    L50:
        return Integer.valueOf(R.raw.sound_effect_assistant_listening);
    }

    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof WakeupSoundPlayer$playWakeupSound$1) == false) goto L7;
        WakeupSoundPlayer$playWakeupSound$1 r100 = (WakeupSoundPlayer$playWakeupSound$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L95:
        if (((Boolean) r111).booleanValue() == true) goto L97;
        SoundEffectHelper.INSTANCE.playActivate();
        return Unit.INSTANCE;
    L97:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r100.label = 1;
        t1 r112 = t1.f393353a;
        ObricWakeupSoundConfig r105 = r112.x1();
        if (r105.getEnable() == true) goto L17;
        FLogger.f375446a.i("WakeupSoundPlayer", "playConfiguredWakeupSound skip, config disabled");
        r111 = Boxing.boxBoolean(false);
    L92:
        if (r111 != r102) goto L95;
        return r102;
    L17:
        List<ObricWakeupSoundOption> r106 = r105.getOptions();
        String r107 = r105.getDefaultSoundId();
        String r108 = null;
        if (r106 == null) goto L20;
        List r109 = CollectionsKt.filterNotNull(r106);
    L21:
        if (r109 != null) goto L23;
        r109 = CollectionsKt.emptyList();
    L23:
        String r113 = "";
        if (r109.isEmpty() == false) goto L26;
        ObricWakeupSoundOption r114 = null;
    L48:
        if (r114 != null) goto L50;
        FLogger.f375446a.w("WakeupSoundPlayer", "playConfiguredWakeupSound skip, option not found");
        r111 = Boxing.boxBoolean(false);
        goto L92
    L50:
        String r115 = r114.getType();
        if (Intrinsics.areEqual(r115, TemplateNodeType.RAW) == false) goto L64;
        String r116 = r114.getAudio();
        if (r116 != null) goto L55;
        r116 = "";
    L55:
        Integer r117 = c(r116);
        if (r117 != null) goto L58;
        FLogger.f375446a.w("WakeupSoundPlayer", "playRawWakeupSound unsupported audio=" + r116 + ", id=" + r114.getId());
    L90:
        r104 = false;
    L91:
        r111 = Boxing.boxBoolean(r104);
        goto L92
    L58:
        int r118 = r117.intValue();
        String r119 = r114.getId();
        if (r119 == null) goto L62;
        r113 = r119;
    L62:
        a(r118, r113, r116);
        goto L91
    L64:
        if (Intrinsics.areEqual(r115, "raw_pool") == true) goto L66;
        FLogger.f375446a.w("WakeupSoundPlayer", "playConfiguredWakeupSound skip, unknown type=" + r114.getType());
        goto L90
    L66:
        if (Intrinsics.areEqual(r114.getResourceSource(), "raw_builtin") == true) goto L68;
        FLogger.f375446a.w("WakeupSoundPlayer", "playRawPoolWakeupSound unsupported resourceSource=" + r114.getResourceSource() + ", id=" + r114.getId());
        goto L90
    L68:
        List<String> r120 = r114.getAudioPool();
        if (r120 == null) goto L79;
        List r121 = CollectionsKt.filterNotNull(r120);
        if (r121 == null) goto L79;
        ArrayList r122 = new ArrayList();
        Iterator r123 = r121.iterator();
    L74:
        if (r123.hasNext() == false) goto L78;
        Object r124 = r123.next();
        if ((!StringsKt.isBlank((String) r124)) == false) goto L74;
        r122.add(r124);
        goto L74
    L78:
        r108 = (String) CollectionsKt.randomOrNull(r122, Random.Default);
    L79:
        if (r108 != null) goto L81;
        FLogger.f375446a.w("WakeupSoundPlayer", "playRawPoolWakeupSound empty audioPool, id=" + r114.getId());
        goto L90
    L81:
        Integer r125 = c(r108);
        if (r125 != null) goto L84;
        FLogger.f375446a.w("WakeupSoundPlayer", "playRawPoolWakeupSound unsupported audio=" + r108 + ", id=" + r114.getId());
        goto L90
    L84:
        int r126 = r125.intValue();
        String r127 = r114.getId();
        if (r127 == null) goto L88;
        r113 = r127;
    L88:
        a(r126, r113, r108);
        goto L91
    L26:
        String r128 = r112.d0();
        if (StringsKt.isBlank(r128) == false) goto L31;
        if (r107 != null) goto L30;
        r128 = "";
        goto L31
    L30:
        r128 = r107;
    L31:
        List r129 = r109;
        Iterator r130 = r129.iterator();
    L33:
        if (r130.hasNext() == false) goto L37;
        Object r131 = r130.next();
        if (Intrinsics.areEqual(((ObricWakeupSoundOption) r131).getId(), r128) == false) goto L33;
    L38:
        r114 = (ObricWakeupSoundOption) r131;
        if (r114 != null) goto L48;
        Iterator r132 = r129.iterator();
    L42:
        if (r132.hasNext() == false) goto L46;
        Object r133 = r132.next();
        if (Intrinsics.areEqual(((ObricWakeupSoundOption) r133).getId(), r107) == false) goto L42;
    L47:
        r114 = (ObricWakeupSoundOption) r133;
        goto L48
    L46:
        r133 = null;
        goto L47
    L37:
        r131 = null;
        goto L38
    L20:
        r109 = null;
    L7:
        r100 = new WakeupSoundPlayer$playWakeupSound$1(this, r110);
        goto L8
    }

    public static void a(int r100, String r101, String r102) {
        SoundEffectHelper r103 = SoundEffectHelper.INSTANCE;
        if (r103.playWakeupRaw(r100) == true) goto L5;
        FLogger.f375446a.w("WakeupSoundPlayer", "playResolvedWakeupRaw failed, fallback playActivate, id=" + r101 + ", audio=" + r102);
        r103.playActivate();
    L5:
        FLogger.f375446a.i("WakeupSoundPlayer", "playResolvedWakeupRaw, id=" + r101 + ", audio=" + r102 + ", rawResId=" + r100);
    }
}
