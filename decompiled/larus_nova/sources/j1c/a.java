package j1c;

import androidx.camera.video.AudioStats;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import o1c.d;

/* JADX INFO: loaded from: classes37.dex */
public final class a extends g1c.a<Map<Biz, ? extends Double>> implements i1c.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f496893d;

    /* JADX INFO: renamed from: j1c.a$a, reason: collision with other inner class name */
    public static final class C6382a {
    }

    static {
    }

    @Override // g1c.b
    public final boolean isValid() {
        return true;
    }

    public a() {
        super(new HashMap());
        this.f496893d = com.ss.android.lark.preload.c.a().getBizFrequencyDisableValue();
    }

    @Override // g1c.b
    public final Class<k1c.b<Map<Biz, Double>>> b() {
        return l1c.a.class;
    }

    @Override // g1c.a, g1c.b
    public final void e(o1c.c<?, ?> r110) {
        Intrinsics.checkNotNullParameter(r110, "task");
        Intrinsics.checkNotNullParameter(r110, "task");
        Map r100 = (Map) this.f479633c;
        if (r100 == null) goto L7;
        Double r101 = (Double) r100.get(r110.getBiz());
        if (r101 == null) goto L7;
        double r102 = r101.doubleValue();
    L9:
        if (r102 <= 0.9d) goto L13;
        int r103 = 7;
    L11:
        boolean r104 = true;
    L28:
        Log.d("BizFrequency", "checkCondition BizFrequency:" + r110 + " / " + r102 + " / " + r103 + " / " + r104 + " / " + this.f496893d);
        r110.setPriority(r110.getPriority() + (r103 * 10));
        if (r104 == false) goto L31;
        d r111 = r110.R();
        r111.f521750a = true;
        r111.f521751b = null;
        r111.f521752c = null;
        return;
    L31:
        d r112 = r110.R();
        Map<String, ? extends Object> r105 = MapsKt.mapOf(TuplesKt.to("frequency", Double.valueOf(r102)));
        r112.f521750a = false;
        r112.f521751b = "BizFrequency";
        r112.f521752c = r105;
        return;
    L13:
        if (r102 <= 0.7d) goto L16;
        r103 = 5;
        goto L11
    L16:
        if (r102 <= 0.5d) goto L19;
        r103 = 1;
        goto L11
    L19:
        if (r102 <= 0.3d) goto L22;
        r103 = -1;
        goto L11
    L22:
        if (r102 <= 0.1d) goto L25;
        r103 = -3;
        goto L11
    L25:
        if (r102 <= this.f496893d) goto L27;
        r103 = -5;
        goto L11
    L27:
        r103 = -8;
        r104 = false;
    L7:
        r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L9
    }
}
