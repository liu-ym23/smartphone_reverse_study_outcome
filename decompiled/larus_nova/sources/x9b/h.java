package x9b;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class h extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f563010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f563011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f563012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f563013d;

    public h() {
    }

    public final void a(TextPaint r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f563010a == false) goto L8;
        r100.setFakeBoldText(true);
    L8:
        if (this.f563011b == false) goto L11;
        r100.setTextSkewX(-0.25f);
    L11:
        if (this.f563012c == false) goto L14;
        r100.setUnderlineText(true);
    L14:
        if (this.f563013d == false) goto L17;
        r100.setStrikeThruText(true);
        return;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        a(r100);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "textPaint");
        a(r100);
    }
}
