package p2a;

import com.larus.audio.w0;
import com.larus.voice_setting.INativeVoiceSettingPlatformEntryService;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
public final class s implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f527494b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f527495c = null;

    public s() {
    }

    static {
        f527494b = new s();
        f527495c = new t();
    }

    public static g u() {
        int r100 = u.f527496a;
        boolean r101 = y.a();
        pd6.b r102 = pd6.c.f528682a;
        b r103 = (b) pd6.c.a(Reflection.getOrCreateKotlinClass(b.class));
        INativeVoiceSettingPlatformEntryService r104 = (INativeVoiceSettingPlatformEntryService) pd6.c.a(Reflection.getOrCreateKotlinClass(INativeVoiceSettingPlatformEntryService.class));
        t r105 = f527495c;
        Intrinsics.checkNotNullParameter(r105, "fallback");
        if (r101 == false) goto L6;
        if (r103 == null) goto L6;
        return r103;
    L6:
        if (r104 != null) goto L9;
        return r105;
    L9:
        return r104;
    }

    @Override // p2a.g
    public final w0 F0() {
        return u().F0();
    }

    @Override // p2a.g
    public final void K2() {
        u().K2();
    }

    @Override // p2a.g
    public final ProfileInfoBaseFragment l() {
        return u().l();
    }
}
