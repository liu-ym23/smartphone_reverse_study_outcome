package g80;

import android.media.AudioRecord;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {
    static {
    }

    public static void a(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100400, "android/media/AudioRecord", "startRecording", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, false);
        return;
    L6:
        r110.startRecording();
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, true);
    }

    public static void b(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100401, "android/media/AudioRecord", "stop", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, false);
        return;
    L6:
        r110.stop();
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, true);
    }

    @JvmStatic
    public static final void c(AudioRecord r110, TokenCert r111) throws BPEAException {
        Intrinsics.checkNotNullParameter(r110, "audioRecord");
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L5;
        com.bytedance.bpea.entry.api.audiorecord.a.f202180a.getClass();
        com.bytedance.bpea.entry.api.audiorecord.a.C2916a.b(r110, r111);
        return;
    L5:
        f06.c r112 = new f06.c();
        Object[] r100 = new Object[0];
        f06.b r101 = new f06.b();
        if (r112.b(100403, "android/media/AudioRecord", "release", r110, r100, "void", r101).f474982a == false) goto L8;
        r112.a(100403, "android/media/AudioRecord", "release", r110, r100, null, r101, false);
        return;
    L8:
        r110.release();
        r112.a(100403, "android/media/AudioRecord", "release", r110, r100, null, r101, true);
    }

    @JvmStatic
    public static final void d(AudioRecord r100, TokenCert r101) throws BPEAException, IllegalStateException {
        Intrinsics.checkNotNullParameter(r100, "audioRecord");
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L6;
        com.bytedance.bpea.entry.api.audiorecord.a.f202180a.getClass();
        com.bytedance.bpea.entry.api.audiorecord.a.C2916a.c(r100, r101);
        return;
    L6:
        if (fna.g.d() == true) goto L8;
        a(r100);
        return;
    L8:
        a(r100);
        hna.a.b(r100.hashCode());
    }

    @JvmStatic
    public static final void e(AudioRecord r100, TokenCert r101) throws BPEAException, IllegalStateException {
        Intrinsics.checkNotNullParameter(r100, "audioRecord");
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L6;
        com.bytedance.bpea.entry.api.audiorecord.a.f202180a.getClass();
        com.bytedance.bpea.entry.api.audiorecord.a.C2916a.d(r100, r101);
        return;
    L6:
        if (fna.g.d() == true) goto L8;
        b(r100);
        return;
    L8:
        b(r100);
        hna.a.c(r100.hashCode());
    }
}
