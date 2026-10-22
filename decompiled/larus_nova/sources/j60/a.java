package j60;

import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import androidx.camera.video.AudioStats;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f497479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f497480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f497481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f497482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f497483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f497484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f497485g;

    public final void a() {
        long r110 = System.currentTimeMillis();
        BufferedReader r100 = null;
        BufferedReader r101 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L10
        String r102 = r101.readLine();     // Catch: Throwable -> L70
        r101.close();     // Catch: Throwable -> L70
        String[] r103 = r102.split(" ");     // Catch: Throwable -> L70
        long r104 = ((Long.parseLong(r103[13]) + Long.parseLong(r103[14])) + Long.parseLong(r103[15])) + Long.parseLong(r103[16]);
        r101.close();     // Catch: Throwable -> L8
    L9:
        long r111 = r104;
    L17:
        if (this.f497485g == true) goto L71;
        long r105 = 0;
    L31:
        long r106 = this.f497483e;
        if (r106 > (-1)) goto L34;
        long r112 = 0;
        double r107 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r108 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L48:
        if (this.f497483e <= (-1)) goto L66;
        b r109 = this.f497479a;
        if (r109 != null) goto L52;
        long r210 = r105;
        double r113 = r107;
        long r114 = r112;
        long r211 = r111;
        this.f497479a = new b(r110, r108, r108, r113, r113);
        long r115 = r110;
        double r116 = r113;
        double r117 = r108;
    L62:
        b r118 = this.f497479a;
        if ((r115 - r118.f497486a) <= 300000) goto L65;
        r118.f497486a = r114;
        r118.f497487b = AudioStats.AUDIO_AMPLITUDE_NONE;
        r118.f497488c = AudioStats.AUDIO_AMPLITUDE_NONE;
    L65:
        long r119 = r210;
    L67:
        this.f497481c = r119;
        this.f497482d = r211;
        this.f497480b = r117;
        this.f497483e = r115;
        this.f497484f = r116;
        return;
    L52:
        double r120 = r107;
        double r212 = r108;
        r211 = r111;
        r210 = r105;
        r114 = r112;
        if (r109.f497486a != r114) goto L55;
        r115 = r110;
        r109.f497486a = r115;
    L56:
        r117 = r212;
        if (r109.f497487b >= r117) goto L59;
        r109.f497487b = r117;
    L59:
        r116 = r120;
        if (r109.f497488c >= r116) goto L62;
        r109.f497488c = r116;
        goto L62
    L55:
        r115 = r110;
        goto L56
    L66:
        r116 = r107;
        r117 = r108;
        r211 = r111;
        r115 = r110;
        r119 = r105;
        goto L67
    L34:
        if (this.f497485g == false) goto L36;
        double r121 = ((r111 - this.f497482d) * 1.0d) / (r105 - this.f497481c);
    L37:
        double r122 = ((r111 - this.f497482d) * 1000.0d) / (r110 - r106);
        if (i60.a.f488346a != (-1)) goto L44;
        long r123 = Os.sysconf(OsConstants._SC_CLK_TCK);
        r112 = 0;
        if (r123 > 0) goto L43;
        r123 = 100;
    L43:
        i60.a.f488346a = r123;
    L45:
        r108 = r121;
        r107 = r122 / i60.a.f488346a;
        goto L48
    L44:
        r112 = 0;
        goto L45
    L36:
        r121 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L37
    L71:
        BufferedReader r124 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/stat")), 1000);     // Catch: Throwable -> L69
        String r125 = r124.readLine();     // Catch: Throwable -> L24
        r124.close();     // Catch: Throwable -> L24
        String[] r126 = r125.split(" ");     // Catch: Throwable -> L24
        r105 = (((((Long.parseLong(r126[2]) + Long.parseLong(r126[3])) + Long.parseLong(r126[4])) + Long.parseLong(r126[6])) + Long.parseLong(r126[5])) + Long.parseLong(r126[7])) + Long.parseLong(r126[8]);
        r124.close();     // Catch: Throwable -> L23
    L24:
        r100 = r124;
    L25:
        if (r100 != null) goto L75;
    L29:
        r105 = -1;
        goto L31
    L75:
        r100.close();     // Catch: Throwable -> L28
    L11:
        if (r101 != null) goto L83;
    L15:
        r111 = -1;
        goto L17
    L83:
        r101.close();     // Catch: Throwable -> L14
    L10:
        r101 = null;
        goto L11
    }

    public a() {
        this.f497480b = -1.0d;
        this.f497481c = -1;
        this.f497482d = -1;
        this.f497483e = -1;
        this.f497484f = -1.0d;
        this.f497485g = i60.a.c();
    }
}
