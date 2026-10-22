package m8a;

import android.content.Context;
import android.net.Uri;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f512531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f512533c;

    public final Uri b() {
        Uri r100 = this.f512531a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new AssertionError();
    }

    public final Uri a(Context r100) {
        if (i.f512536b == null) goto L5;
    L14:
        int r101 = i.f512536b.a(r100, this.f512532b);
        if (r101 <= 0) goto L18;
        return new Uri.Builder().scheme("res").path(String.valueOf(r101)).build();
    L18:
        return Uri.EMPTY;
    L5:
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (i.f512536b != null) goto L9;
        i.f512536b = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
        goto L14
    }

    public g(Context r100, String r101) {
        this(r100, r101, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public g(Context r100, String r101, double r102, double r103) {
        this.f512532b = r101;
        this.f512533c = r102 * r103;
        Uri r104 = UriProtector.parse(r101);     // Catch: Exception -> L7
        if (r104.getScheme() != null) goto L8;
        r104 = a(r100);     // Catch: Exception -> L7
    L8:
        this.f512531a = r104;
        return;
    L7:
        r104 = a(r100);
        goto L8
    }
}
