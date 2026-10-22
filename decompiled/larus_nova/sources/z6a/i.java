package z6a;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* JADX INFO: loaded from: classes32.dex */
public final class i extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f570584a;

    public final int hashCode() {
        Typeface r100 = this.f570584a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public i(Typeface r100) {
        this.f570584a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (i.class == r100.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.f570584a, ((i) r100).f570584a);
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Typeface r101 = this.f570584a;
        if (r101 == null) goto L6;
        r100.setTypeface(r101);
        return;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Typeface r101 = this.f570584a;
        if (r101 == null) goto L6;
        r100.setTypeface(r101);
        return;
    }
}
