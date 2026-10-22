package zj4;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import pk4.j;
import pk4.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<d> f572454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ak4.a f572455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile byte[] f572456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f572457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile c f572458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile b f572459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f572460g;

    /* JADX INFO: renamed from: zj4.a$a, reason: collision with other inner class name */
    public static class C8468a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f572461a = null;

        static {
            f572461a = new a();
        }
    }

    public final int g() {
        byte[] r100 = {16, 0};
        j.d("DoraHealth", "takeBehaviorAwareToggle: request=" + Arrays.toString(r100));
        int r101 = this.f572455b.h(8, 4, n.b(8, 4, 16), r100);
        if (r101 == 0) goto L5;
        return r101;
    L5:
        return this.f572457d;
    }

    public final byte[] h() {
        byte[] r100 = {2, 0};
        j.d("DoraHealth", "takeHeadGesture: request=" + Arrays.toString(r100));
        int r101 = this.f572455b.h(8, 4, n.b(8, 4, 2), r100);
        if (r101 == 0) goto L7;
        j.f("DoraHealth", "takeHeadGesture failed: ret=" + r101);
        return null;
    L7:
        return this.f572456c;
    }

    public final int i() {
        byte[] r100 = {7, 0};
        j.d("DoraHealth", "takeLongHeadDownCalibration: request=" + Arrays.toString(r100));
        int r101 = this.f572455b.h(8, 4, n.b(8, 4, 7), r100);
        if (r101 == 0) goto L5;
        return r101;
    L5:
        return this.f572460g;
    }

    public final b j() {
        byte[] r100 = {6, 0};
        j.d("DoraHealth", "takeLongHeadDownDurationConfig: request=" + Arrays.toString(r100));
        int r101 = this.f572455b.h(8, 4, n.b(8, 4, 6), r100);
        if (r101 == 0) goto L6;
        j.f("DoraHealth", "takeLongHeadDownDurationConfig: request failed, ret=" + r101);
        return null;
    L6:
        j.d("DoraHealth", "takeLongHeadDownDurationConfig: config=" + this.f572459f);
        return this.f572459f;
    }

    public final c k() {
        byte[] r100 = {4, 0};
        j.d("DoraHealth", "takeSedentaryDurationConfig: request=" + Arrays.toString(r100));
        int r101 = this.f572455b.h(8, 4, n.b(8, 4, 4), r100);
        if (r101 == 0) goto L6;
        j.f("DoraHealth", "takeSedentaryDurationConfig: request failed, ret=" + r101);
        return null;
    L6:
        j.d("DoraHealth", "takeSedentaryDurationConfig: config=" + this.f572458e);
        return this.f572458e;
    }

    public a() {
        this.f572454a = new CopyOnWriteArraySet();
        this.f572455b = ak4.a.d();
        this.f572456c = null;
        this.f572457d = -1;
        this.f572458e = null;
        this.f572459f = null;
        this.f572460g = -1;
        new AtomicBoolean(false);
    }

    public final int a(int r100) {
        j.d("DoraHealth", "syncBehaviorAwareToggle: value=" + r100);
        if (r100 == 0) goto L7;
        if (r100 == 1) goto L7;
        boolean r101 = false;
    L8:
        if (r101 == true) goto L11;
        j.f("DoraHealth", "syncBehaviorAwareToggle: invalid value=" + r100);
        return -5;
    L11:
        byte[] r102 = n.u(new byte[]{16, 1}, new byte[]{(byte) r100});
        j.d("DoraHealth", "syncBehaviorAwareToggle: payload=" + Arrays.toString(r102));
        return this.f572455b.i(8, 4, r102);
    L7:
        r101 = true;
        goto L8
    }

    public final int b(byte[] r100) {
        j.d("DoraHealth", "syncHeadGesture: value=" + Arrays.toString(r100));
        if (r100 != null) goto L6;
        return -5;
    L6:
        byte[] r101 = n.u(new byte[]{2, (byte) r100.length}, r100);
        j.d("DoraHealth", "syncHeadGesture: payload=" + Arrays.toString(r101));
        return this.f572455b.i(8, 4, r101);
    }

    public final int c(int r100) {
        j.d("DoraHealth", "syncHeadGestureToggle: value=" + r100);
        byte[] r101 = n.u(new byte[]{1, 1}, new byte[]{(byte) r100});
        j.d("DoraHealth", "syncHeadGestureToggle: payload=" + Arrays.toString(r101));
        return this.f572455b.i(8, 4, r101);
    }

    public final int d(int r100) {
        j.d("DoraHealth", "syncLongHeadDownCalibration: value=" + r100);
        byte[] r101 = n.u(new byte[]{7, 1}, new byte[]{(byte) r100});
        j.d("DoraHealth", "syncLongHeadDownCalibration: payload=" + Arrays.toString(r101));
        return this.f572455b.i(8, 4, r101);
    }

    public final int e(int r100) {
        j.d("DoraHealth", "syncLongHeadDownDuration: minutes=" + r100);
        if (r100 >= 1) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L11;
        j.f("DoraHealth", "syncLongHeadDownDuration: invalid minutes=" + r100 + ", validRange=1-60");
        return -5;
    L11:
        byte[] r102 = n.u(new byte[]{6, 2}, new byte[]{(byte) ((r100 >> 8) & 255), (byte) (r100 & 255)});
        j.d("DoraHealth", "syncLongHeadDownDuration: payload=" + Arrays.toString(r102));
        return this.f572455b.i(8, 4, r102);
    L5:
        if (r100 > 60) goto L7;
        r101 = true;
        goto L8
    }

    public final int f(int r100) {
        j.d("DoraHealth", "syncSedentaryDuration: minutes=" + r100);
        if (r100 >= 20) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L11;
        j.f("DoraHealth", "syncSedentaryDuration: invalid minutes=" + r100 + ", validRange=20-120");
        return -5;
    L11:
        byte[] r102 = n.u(new byte[]{4, 2}, new byte[]{(byte) ((r100 >> 8) & 255), (byte) (r100 & 255)});
        j.d("DoraHealth", "syncSedentaryDuration: payload=" + Arrays.toString(r102));
        return this.f572455b.i(8, 4, r102);
    L5:
        if (r100 > 120) goto L7;
        r101 = true;
        goto L8
    }
}
