package hec;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f484905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f484906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f484907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f484908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f484909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f484910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f484911g;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        int r101 = this.f484905a;
        if (r101 == (-1)) goto L5;
        r100.setTextSize(r101);
    L5:
        int r102 = this.f484906b;
        if (r102 == 0) goto L8;
        r100.setColor(r102);
    L8:
        int r103 = this.f484907c;
        if (r103 == 0) goto L12;
        r100.bgColor = r103;
    L12:
        if (this.f484909e == false) goto L14;
        r100.setTextSkewX(-0.25f);
    L14:
        r100.setFakeBoldText(this.f484908d);
        r100.setUnderlineText(this.f484910f);
        r100.setStrikeThruText(this.f484911g);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        int r101 = this.f484905a;
        if (r101 == (-1)) goto L6;
        r100.setTextSize(r101);
        return;
    }

    public a(int r100, int r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        this.f484905a = -1;
        this.f484906b = r100;
        this.f484907c = r101;
        this.f484908d = r102;
        this.f484909e = r103;
        this.f484910f = r104;
        this.f484911g = r105;
    }
}
