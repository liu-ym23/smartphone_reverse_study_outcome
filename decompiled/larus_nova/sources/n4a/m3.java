package n4a;

import androidx.camera.video.AudioStats;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f517521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f517522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f517523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f517524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f517525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f517526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f517527g;

    public m3() {
        this.f517521a = 0;
        this.f517522b = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f517523c = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f517524d = 0;
        this.f517525e = 0;
        this.f517526f = 63;
        this.f517527g = 0;
    }

    public final String a() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L4
        r100.put("time", this.f517524d);     // Catch: Throwable -> L4
        r100.put("lon", this.f517523c);     // Catch: Throwable -> L4
        r100.put("lat", this.f517522b);     // Catch: Throwable -> L4
        r100.put("radius", this.f517525e);     // Catch: Throwable -> L4
        r100.put("locationType", this.f517521a);     // Catch: Throwable -> L4
        r100.put("reType", this.f517526f);     // Catch: Throwable -> L4
        r100.put("reSubType", this.f517527g);     // Catch: Throwable -> L4
    L5:
        if (r100 != null) goto L9;
        return "";
    L9:
        return r100.toString();
    L4:
        r100 = null;
        goto L5
    }

    public final void b(JSONObject r100) {
        this.f517522b = r100.optDouble("lat", this.f517522b);     // Catch: Throwable -> L4
        this.f517523c = r100.optDouble("lon", this.f517523c);     // Catch: Throwable -> L4
        this.f517521a = r100.optInt("locationType", this.f517521a);     // Catch: Throwable -> L4
        this.f517526f = r100.optInt("reType", this.f517526f);     // Catch: Throwable -> L4
        this.f517527g = r100.optInt("reSubType", this.f517527g);     // Catch: Throwable -> L4
        this.f517525e = r100.optInt("radius", this.f517525e);     // Catch: Throwable -> L4
        this.f517524d = r100.optLong("time", this.f517524d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "CoreUtil", "transformLocation");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (m3.class != r100.getClass()) goto L25;
        m3 r101 = (m3) r100;
        if (this.f517521a != r101.f517521a) goto L25;
        if (Double.compare(r101.f517522b, this.f517522b) != 0) goto L25;
        if (Double.compare(r101.f517523c, this.f517523c) != 0) goto L25;
        if (this.f517524d != r101.f517524d) goto L25;
        if (this.f517525e != r101.f517525e) goto L25;
        if (this.f517526f != r101.f517526f) goto L25;
        if (this.f517527g != r101.f517527g) goto L25;
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f517521a), Double.valueOf(this.f517522b), Double.valueOf(this.f517523c), Long.valueOf(this.f517524d), Integer.valueOf(this.f517525e), 0, Integer.valueOf(this.f517526f), Integer.valueOf(this.f517527g)});
    }
}
