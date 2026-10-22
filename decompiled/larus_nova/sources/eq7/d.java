package eq7;

import androidx.camera.video.AudioStats;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes3.dex */
public class d implements gq7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f473523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f473524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f473525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f473526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f473527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f473528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f473529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f473530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f473531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f473532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f473533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f473534l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double f473535m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public double f473536n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double f473537o;

    public String toString() {
        return "proc_stat:{pid=" + this.f473524b + " process_name:" + this.f473523a + " minFlt:" + this.f473525c + " cminFlt:" + this.f473526d + " majFlt:" + this.f473527e + " cmajFlt:" + this.f473528f + " cpuTime:" + this.f473529g + " priority:" + this.f473530h + " nice:" + this.f473531i + " delta cpu_time:" + this.f473532j + " cpu_usage:" + (this.f473534l * 100.0d) + "% cpu_usage_normalized:" + (this.f473536n * 100.0d) + "% cpu_rate:" + this.f473535m + "} cpu_rate_normalized:" + this.f473537o + i.f25855d;
    }

    public d() {
        this.f473523a = null;
        this.f473524b = -1;
        this.f473525c = 0;
        this.f473526d = 0;
        this.f473527e = 0;
        this.f473528f = 0;
        this.f473529g = 0;
        this.f473530h = 0;
        this.f473531i = 0;
        this.f473532j = 0;
        this.f473533k = 0;
        this.f473534l = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f473535m = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f473536n = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f473537o = AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
