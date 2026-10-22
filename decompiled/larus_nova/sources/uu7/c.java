package uu7;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import wu7.f;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f551772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Interpolator f551773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f551774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f551775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, b> f551776e;

    public class a extends b<Float> {
        public a(float[] r100, uu7.a r101, Float[] r102) {
            super(r100, r101, r102);
        }
    }

    public class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float[] f551777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Property f551778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T[] f551779c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(float[] r100, Property r101, Object[] r102) {
            this.f551777a = r100;
            this.f551778b = r101;
            this.f551779c = r102;
        }
    }

    /* JADX INFO: renamed from: uu7.c$c, reason: collision with other inner class name */
    public class C7937c extends b<Integer> {
        public C7937c(float[] r100, uu7.b r101, Integer[] r102) {
            super(r100, r101, r102);
        }
    }

    public final ObjectAnimator a() {
        PropertyValuesHolder[] r100 = new PropertyValuesHolder[((HashMap) this.f551776e).size()];
        Iterator r101 = ((HashMap) this.f551776e).entrySet().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L20;
        b r103 = (b) ((Map.Entry) r101.next()).getValue();
        float[] r104 = r103.f551777a;
        Keyframe[] r105 = new Keyframe[r104.length];
        int r106 = this.f551775d;
        float r107 = r104[r106];
    L6:
        int r108 = this.f551775d;
        Object[] r109 = r103.f551779c;
        if (r106 >= (r109.length + r108)) goto L19;
        int r110 = r106 - r108;
        int r111 = r106 % r109.length;
        float r112 = r104[r111] - r107;
        if (r112 >= 0.0f) goto L12;
        r112 = r112 + r104[r104.length - 1];
    L12:
        if ((r103 instanceof C7937c) == false) goto L15;
        r105[r110] = Keyframe.ofInt(r112, ((Integer) r109[r111]).intValue());
    L18:
        r106 = r106 + 1;
        goto L6
    L15:
        if ((r103 instanceof a) == false) goto L17;
        r105[r110] = Keyframe.ofFloat(r112, ((Float) r109[r111]).floatValue());
        goto L18
    L17:
        r105[r110] = Keyframe.ofObject(r112, r109[r111]);
        goto L18
    L19:
        r100[r102] = PropertyValuesHolder.ofKeyframe(r103.f551778b, r105);
        r102 = r102 + 1;
        goto L4
    L20:
        ObjectAnimator r113 = ObjectAnimator.ofPropertyValuesHolder(this.f551772a, r100);
        r113.setDuration(this.f551774c);
        r113.setRepeatCount(-1);
        r113.setInterpolator(this.f551773b);
        return r113;
    }

    public c(f r100) {
        this.f551774c = 2000;
        this.f551775d = 0;
        this.f551776e = new HashMap();
        this.f551772a = r100;
    }

    public final void b(float... r100) {
        vu7.a r101 = new vu7.a(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f), new float[0]);
        r101.f557364b = r100;
        this.f551773b = r101;
    }

    public static void c(int r100, int r101) {
        if (r100 != r101) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.format(Locale.getDefault(), "The fractions.length must equal values.length, fraction.length[%d], values.length[%d]", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)}));
    }

    public final void d(float[] r100, uu7.a r101, Float[] r102) {
        c(r100.length, r102.length);
        Map<String, b> r103 = this.f551776e;
        HashMap r104 = (HashMap) r103;
        r104.put(r101.getName(), new a(r100, r101, r102));
    }

    public final void e(float[] r100, uu7.b r101, Integer[] r102) {
        c(r100.length, r102.length);
        Map<String, b> r103 = this.f551776e;
        HashMap r104 = (HashMap) r103;
        r104.put(r101.getName(), new C7937c(r100, r101, r102));
    }
}
