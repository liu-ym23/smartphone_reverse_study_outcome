package gec;

import android.graphics.Paint;
import android.text.TextUtils;
import android.text.style.LineHeightSpan;
import nec.d;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C6017a f481033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f481034b;

    /* JADX INFO: renamed from: gec.a$a, reason: collision with other inner class name */
    public static class C6017a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f481035a;

        public C6017a() {
        }
    }

    public a(C6017a r100) {
        this.f481034b = true;
        this.f481033a = r100;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        String r106 = r100.subSequence(r101, r102).toString();
        if (TextUtils.isEmpty(r106) == false) goto L5;
        return;
    L5:
        if (r101 == 0) goto L7;
    L9:
        boolean r107 = d.a(r106);
        if (r107 == false) goto L12;
    L14:
        this.f481034b = r107;
        float r108 = this.f481033a.f481035a / 2.0f;
        r105.top = (int) (r105.top - r108);
        r105.ascent = (int) (r105.ascent - r108);
        r105.descent = (int) (r105.descent + r108);
        r105.bottom = (int) (r105.bottom + r108);
        return;
    L12:
        if (this.f481034b == true) goto L14;
        return;
    L7:
        if (r102 != r100.length()) goto L9;
    }
}
