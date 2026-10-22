package z6a;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Float> f570560a;

    public c(List<Float> r100) {
        this.f570560a = r100;
    }

    public final float a(int r100, float r101, float r102, float r103) {
        float r104 = r103 - r102;
        switch(r100) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L13;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        r101 = 0.0f;
        goto L13
    L5:
        r101 = ((((-((Float) ListProtector.get(this.f570560a, 0)).floatValue()) - ((Float) ListProtector.get(this.f570560a, 1)).floatValue()) + r102) + r103) * 0.5f;
        goto L13
    L6:
        r101 = (r101 * ((Float) ListProtector.get(this.f570560a, 3)).floatValue()) / 100.0f;
        goto L13
    L7:
        r101 = r103 - ((Float) ListProtector.get(this.f570560a, 1)).floatValue();
        goto L13
    L8:
        r101 = ((r103 + r102) + ((Float) ListProtector.get(this.f570560a, 2)).floatValue()) * 0.5f;
        goto L13
    L9:
        r101 = r102 - ((Float) ListProtector.get(this.f570560a, 0)).floatValue();
        goto L13
    L10:
        r101 = r104 * 0.1f;
        goto L13
    L11:
        r101 = (-r104) * 0.1f;
    L13:
        return (-r101) + r102;
    }
}
