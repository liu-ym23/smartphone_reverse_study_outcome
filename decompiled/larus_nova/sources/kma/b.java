package kma;

import android.R;
import com.obric.oui.graphic.BlendMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f504114d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.obric.oui.color.b[] f504115e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[][] f504116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.oui.color.b[][] f504117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.obric.oui.color.b[] f504118c;

    static {
        f504114d = new int[]{R.attr.state_enabled};
        f504115e = new com.obric.oui.color.b[]{new com.obric.oui.color.b(0, BlendMode.SRC_OVER)};
    }

    public final b b() {
        int[][] r100 = new int[this.f504116a.length][];
        int r101 = 0;
        int r102 = 0;
    L3:
        int[][] r103 = this.f504116a;
        if (r102 >= r103.length) goto L6;
        int[] r104 = r103[r102];
        r100[r102] = Arrays.copyOf(r104, r104.length);
        r102 = r102 + 1;
        goto L3
    L6:
        com.obric.oui.color.b[][] r105 = new com.obric.oui.color.b[this.f504117b.length][];
        int r106 = 0;
    L7:
        com.obric.oui.color.b[][] r107 = this.f504117b;
        if (r106 >= r107.length) goto L14;
        com.obric.oui.color.b[] r108 = r107[r106];
        com.obric.oui.color.b[] r109 = new com.obric.oui.color.b[r108.length];
        int r110 = 0;
    L11:
        if (r110 >= r108.length) goto L13;
        com.obric.oui.color.b r111 = r108[r110];
        r111.getClass();
        r109[r110] = new com.obric.oui.color.b(r111.f399491a, r111.f399492b);
        r110 = r110 + 1;
        goto L11
    L13:
        r105[r106] = r109;
        r106 = r106 + 1;
        goto L7
    L14:
        com.obric.oui.color.b[] r112 = this.f504118c;
        com.obric.oui.color.b[] r113 = new com.obric.oui.color.b[r112.length];
    L16:
        if (r101 >= r112.length) goto L19;
        com.obric.oui.color.b r114 = r112[r101];
        r114.getClass();
        r113[r101] = new com.obric.oui.color.b(r114.f399491a, r114.f399492b);
        r101 = r101 + 1;
        goto L16
    L19:
        return new b(r100, r105, r113);
    }

    public static com.obric.oui.color.b[] a(com.obric.oui.color.b[] r100, com.obric.oui.color.b r101) {
        com.obric.oui.color.b[] r102 = (com.obric.oui.color.b[]) Arrays.copyOf(r100, r100.length + 1);
        r102[r100.length] = r101;
        return r102;
    }

    public b(int[][] r100, com.obric.oui.color.b[][] r101, com.obric.oui.color.b[] r102) {
        if (r100.length != r101.length) goto L11;
        if (r100.length == 0) goto L9;
        this.f504116a = r100;
        this.f504117b = r101;
        this.f504118c = r102;
        return;
    L9:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    L11:
        throw new IllegalArgumentException("stateSpecs.size(" + r100.length + ") must equal configs.size(" + r101.length + ")");
    }

    public static b c(com.obric.oui.color.b[] r100, com.obric.oui.color.b[] r101, com.obric.oui.color.b r110) {
        com.obric.oui.color.b r102 = f504115e[0];
        return d(r100, r101, r110, r102, r102, r102);
    }

    public static b d(com.obric.oui.color.b[] r210, com.obric.oui.color.b[] r211, com.obric.oui.color.b r212, com.obric.oui.color.b r213, com.obric.oui.color.b r214, com.obric.oui.color.b r215) {
        com.obric.oui.color.b r100 = new com.obric.oui.color.b(0, r212.f399492b);
        com.obric.oui.color.b[] r101 = a(r210, r100);
        com.obric.oui.color.b[] r102 = a(r211, r100);
        com.obric.oui.color.b[] r103 = a(r210, r214);
        com.obric.oui.color.b[] r104 = a(r210, r215);
        com.obric.oui.color.b[] r105 = a(r210, r212);
        com.obric.oui.color.b[] r106 = a(r210, r213);
        return new b(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new com.obric.oui.color.b[][]{r104, r104, r103, r103, r105, r106, r104, r103, r102, r101}, r210);
    }
}
