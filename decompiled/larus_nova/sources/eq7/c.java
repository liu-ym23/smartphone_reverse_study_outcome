package eq7;

import androidx.camera.video.AudioStats;
import com.alipay.sdk.m.u.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements gq7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<LinkedHashMap<Long, Long>> f473517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<LinkedHashMap<Long, Long>> f473518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f473519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f473520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f473521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f473522f;

    public final long a() {
        if (this.f473519c != 0) goto L14;
        if (((ArrayList) this.f473517a).isEmpty() == true) goto L14;
        Iterator r100 = ((ArrayList) this.f473517a).iterator();
    L8:
        if (r100.hasNext() == false) goto L14;
        Iterator r101 = ((LinkedHashMap) r100.next()).entrySet().iterator();
    L11:
        if (r101.hasNext() == false) goto L8;
        this.f473519c += ((Long) ((Map.Entry) r101.next()).getValue()).longValue();
    L14:
        return this.f473519c;
    }

    public final String toString() {
        return "cputime:{deltaTime:" + this.f473520d + " usage:" + this.f473522f + " totaltime:" + a() + i.f25855d;
    }

    public c() {
        this.f473517a = new ArrayList();
        this.f473518b = new ArrayList();
        this.f473519c = 0;
        this.f473520d = 0;
        this.f473521e = 0;
        this.f473522f = AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
