package n60;

import android.content.Context;
import android.media.AudioRecord;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bpea.cert.token.TokenCert;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TokenCert f518094a = null;

    public a() {
    }

    static {
        f518094a = TokenCert.with("bpea-live_audiorecordchecker_check_audio_record");
    }

    public static boolean b(TokenCert r110) {
        int r100 = AudioRecord.getMinBufferSize(44100, 3, 2);     // Catch: Exception -> L17
        AudioRecord r101 = new AudioRecord(1, 44100, 3, 2, r100);     // Catch: Exception -> L17
        g80.a.d(r101, r110);     // Catch: Exception -> L15
        if (r100 <= 0) goto L11;
        int r102 = r101.read(new byte[r100], 0, r100);
        g80.a.c(r101, r110);     // Catch: Exception -> L9
    L12:
        if (r102 <= 0) goto L34;
        return true;
    L34:
        return false;
    L9:
        e = move-exception;
        ALogger.e("AudioRecorderChecker", e);
        goto L12
    L11:
        r102 = 0;
    L15:
        e = e;
    L19:
        ALogger.e("AudioRecorderChecker", e);
        if (r101 != null) goto L26;
    L25:
        return false;
    L26:
        g80.a.c(r101, r110);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        ALogger.e("AudioRecorderChecker", e);
    L17:
        e = e;
        r101 = null;
        goto L19
    }

    @Override // n60.d
    public final boolean a(Context r100, String r101) {
        return b(f518094a);
    }
}
