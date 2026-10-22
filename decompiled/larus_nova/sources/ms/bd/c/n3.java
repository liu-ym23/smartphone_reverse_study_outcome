package ms.bd.c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.ss.ttm.player.MediaPlayer;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes42.dex */
public final class n3 implements SensorEventListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile n3 f515247f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SensorManager f515248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f515249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f515250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f515251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f515252e;

    public final synchronized void d() {
        monitor-enter(this);
        SensorManager r100 = this.f515248a;     // Catch: Throwable -> L13 Exception -> L18
        if (r100 == null) goto L16;
        if (this.f515249b == 0) goto L8;
    L11:
        this.f515249b++;     // Catch: Throwable -> L13 Exception -> L18
        goto L16
    L8:
        if (this.f515248a.registerListener(this, r100.getDefaultSensor(1), 3) == true) goto L11;
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        monitor-exit(this);
    }

    public final synchronized void e() {
        monitor-enter(this);
        SensorManager r100 = this.f515248a;     // Catch: Throwable -> L10 Exception -> L12
        if (r100 == null) goto L14;
        int r101 = this.f515249b - 1;     // Catch: Throwable -> L10 Exception -> L12
        this.f515249b = r101;     // Catch: Throwable -> L10 Exception -> L12
        if (r101 != 0) goto L14;
        a(r100, this);     // Catch: Throwable -> L10 Exception -> L12
    L14:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        String r102 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "56dd10", new byte[]{55, 39, 20, 47, 27});     // Catch: Throwable -> L10
        goto L14
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r100, int r101) {
    }

    static {
        new DecimalFormat((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "0caff1", new byte[]{113, 47, 66}));
        f515247f = null;
    }

    public final JSONArray c() {
        if (n.b() == 1) goto L6;
        return null;
    L6:
        d();
        monitor-enter(this);     // Catch: Throwable -> L20 Exception -> L22
        int r100 = 0;
    L28:
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20 Exception -> L22
        goto L23
    L10:
        if (this.f515250c != 0) goto L14;
        if (r100 >= 10) goto L14;
        r100 = r100 + 1;     // Catch: Throwable -> L17
        wait(1000);     // Catch: Throwable -> L17
    L14:
        monitor-exit(this);     // Catch: Throwable -> L17
        JSONArray r101 = new JSONArray();
        r101.put(new BigDecimal(this.f515251d[0]).setScale(2, 4));
        r101.put(new BigDecimal(this.f515251d[1]).setScale(2, 4));
        BigDecimal r102 = new BigDecimal(this.f515251d[2]);
    L16:
        r101.put(r102.setScale(2, 4));
        e();
        this.f515250c = 0;
        return r101;
    L20:
        th = move-exception;
        JSONArray r103 = new JSONArray();
        r103.put(new BigDecimal(this.f515251d[0]).setScale(2, 4));
        r103.put(new BigDecimal(this.f515251d[1]).setScale(2, 4));
        r103.put(new BigDecimal(this.f515251d[2]).setScale(2, 4));
        e();
        this.f515250c = 0;
        throw th;
    L23:
        String r104 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "c280af", new byte[]{97, 35, 72, 123, 89});     // Catch: Throwable -> L20
        r101 = new JSONArray();
        r101.put(new BigDecimal(this.f515251d[0]).setScale(2, 4));
        r101.put(new BigDecimal(this.f515251d[1]).setScale(2, 4));
        r102 = new BigDecimal(this.f515251d[2]);
        goto L16
    }

    public n3(Context r100) {
        this.f515248a = null;
        this.f515250c = 0;
        this.f515251d = new float[3];
        this.f515252e = new ArrayList();
        Context r101 = r100.getApplicationContext();
        if (r101 == null) goto L6;
        this.f515248a = (SensorManager) r101.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "5bbd9b", new byte[]{55, 101, 31, 3, 9, 103}));
        return;
    }

    public static n3 b(Context r100) {
        if (f515247f != null) goto L15;
        monitor-enter(n3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f515247f != null) goto L9;
        f515247f = new n3(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(n3.class);     // Catch: Throwable -> L11
    L15:
        return f515247f;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r100) {
        this.f515251d = r100.values;
        this.f515250c = 1;
    }

    public static void a(SensorManager r100, SensorEventListener r101) {
        if (fna.g.d() == true) goto L6;
        r100.unregisterListener(r101);
        return;
    L6:
        r100.unregisterListener(r101);
        if (r101 == null) goto L9;
        int r102 = r101.hashCode();
    L10:
        ona.b.c(new ona.a(r102, null));
        return;
    L9:
        r102 = 0;
        goto L10
    }
}
