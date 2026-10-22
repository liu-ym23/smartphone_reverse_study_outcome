package z6a;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* JADX INFO: loaded from: classes32.dex */
public final class g extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f570568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f570569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f570570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f570571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f570572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f570573f;

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f570568a), Integer.valueOf(this.f570569b)});
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (g.class != r100.getClass()) goto L17;
        g r101 = (g) r100;
        if (this.f570568a == r101.f570568a) goto L13;
    L15:
        return false;
    L13:
        if (this.f570569b != r101.f570569b) goto L15;
        return true;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        com.lynx.tasm.behavior.shadow.text.b.n(r100, this.f570570c, this.f570568a, this.f570569b, this.f570571d, this.f570572e, this.f570573f);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        com.lynx.tasm.behavior.shadow.text.b.n(r100, this.f570570c, this.f570568a, this.f570569b, this.f570571d, this.f570572e, this.f570573f);
    }

    public g(int r100, int r101, String r102, String r103, String r104, boolean r105) {
        this.f570568a = r100;
        this.f570569b = r101;
        this.f570570c = r102;
        this.f570571d = r103;
        this.f570572e = r104;
        this.f570573f = r105;
    }
}
