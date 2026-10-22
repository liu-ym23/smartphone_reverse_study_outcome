package r14;

import android.os.SystemClock;
import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lr14/j0;", "Lt14/a;", "", "duration", "D", "getDuration", "()D", "l", "(D)V", "", "Lr14/l;", "bitRate", "Ljava/util/List;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/List;", ce.f26395j, "(Ljava/util/List;)V", "", "cdnUrlExpired", "J", "getCdnUrlExpired", "()J", ce.f26396k, "(J)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class j0 extends t14.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f535640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f535641b;

    @SerializedName("bit_rate")
    private List<l> bitRate;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f535642c;

    @SerializedName("cdn_url_expired")
    private long cdnUrlExpired;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f535643d;

    @SerializedName("duration")
    private double duration;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f535644e;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "VideoUrlModel{uri='" + e() + "'aK='" + a() + "', urlList=" + g() + "sourceId='" + this.f535640a + "', ratio='" + this.f535641b + "', mVr=" + this.f535642c + ", duration=" + this.duration + ", bitRate=" + this.bitRate + ", createTime=" + this.f535644e + ", ish265=" + this.f535643d + '}';
    }

    public j0() {
        this.f535644e = SystemClock.elapsedRealtime();
    }

    public final List<l> i() {
        return this.bitRate;
    }

    public final void j(List<l> r100) {
        this.bitRate = r100;
    }

    public final void k(long r100) {
        this.cdnUrlExpired = r100;
    }

    public final void l(double r100) {
        this.duration = r100;
    }
}
