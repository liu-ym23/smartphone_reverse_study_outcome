package su;

import android.content.Context;
import android.media.AudioRecord;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TokenCert f543578a = null;

    public a() {
    }

    static {
        f543578a = TokenCert.with("bpea-live_audiorecordchecker_check_audio_record");
    }

    @Override // su.d
    public final boolean a(Context r110, String r111) {
        TokenCert r112 = f543578a;
        int r100 = AudioRecord.getMinBufferSize(44100, 3, 2);     // Catch: Exception -> L16
        AudioRecord r101 = new AudioRecord(1, 44100, 3, 2, r100);     // Catch: Exception -> L16
        int r102 = gv.a.f482807a;     // Catch: Exception -> L14
        Intrinsics.checkNotNullParameter(r101, "audioRecord");     // Catch: Exception -> L14
        com.bytedance.bpea.entry.api.audiorecord.a.C2916a r103 = com.bytedance.bpea.entry.api.audiorecord.a.f202180a;     // Catch: Exception -> L14
        r103.getClass();     // Catch: Exception -> L14
        com.bytedance.bpea.entry.api.audiorecord.a.C2916a.c(r101, r112);     // Catch: Exception -> L14
        if (r100 <= 0) goto L11;
        int r104 = r101.read(new byte[r100], 0, r100);
        Intrinsics.checkNotNullParameter(r101, "audioRecord");     // Catch: Exception -> L9
        r103.getClass();     // Catch: Exception -> L9
        com.bytedance.bpea.entry.api.audiorecord.a.C2916a.b(r101, r112);     // Catch: Exception -> L9
    L12:
        if (r104 <= 0) goto L33;
        return true;
    L33:
        return false;
    L9:
        e = move-exception;
        yr.b.d("AudioRecorderChecker", null, e);
        goto L12
    L11:
        r104 = 0;
    L14:
        e = e;
    L18:
        yr.b.d("AudioRecorderChecker", null, e);
        if (r101 == null) goto L35;
        int r105 = gv.a.f482807a;     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r101, "audioRecord");     // Catch: Exception -> L22
        com.bytedance.bpea.entry.api.audiorecord.a.f202180a.getClass();     // Catch: Exception -> L22
        com.bytedance.bpea.entry.api.audiorecord.a.C2916a.b(r101, r112);     // Catch: Exception -> L22
        return false;
    L22:
        e = move-exception;
        yr.b.d("AudioRecorderChecker", null, e);
        return false;
    L35:
        return false;
    L16:
        e = e;
        r101 = null;
        goto L18
    }
}
