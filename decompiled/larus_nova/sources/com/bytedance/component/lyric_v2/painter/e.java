package com.bytedance.component.lyric_v2.painter;

import android.graphics.Paint;
import android.graphics.Rect;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Pair<String, Integer>, Float> f203080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Float> f203081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Pair<Paint, String>, Rect> f203082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Paint, Paint.FontMetrics> f203083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint.FontMetrics f203084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f203085f;

    public e() {
        this.f203080a = new LinkedHashMap();
        this.f203081b = new LinkedHashMap();
        this.f203082c = new LinkedHashMap();
        this.f203083d = new LinkedHashMap();
        this.f203084e = new Paint.FontMetrics();
        this.f203085f = new Rect();
    }

    public final Paint.FontMetrics a(Paint r100) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Paint.FontMetrics r101 = (Paint.FontMetrics) ((LinkedHashMap) this.f203083d).get(r100);
        if (r101 != null) goto L6;
        r100.getFontMetrics(this.f203084e);
        Paint.FontMetrics r102 = new Paint.FontMetrics();
        Paint.FontMetrics r103 = this.f203084e;
        r102.ascent = r103.ascent;
        r102.descent = r103.descent;
        r102.leading = r103.leading;
        r102.top = r103.top;
        r102.bottom = r103.bottom;
        this.f203083d.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public final Rect b(Paint r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        Pair<Paint, String> r102 = new Pair(r100, r101);
        Rect r103 = (Rect) ((LinkedHashMap) this.f203082c).get(r102);
        if (r103 != null) goto L6;
        Rect r104 = this.f203085f;
        r100.getTextBounds(r101, 0, r101.length(), r104);
        Rect r105 = new Rect(r104);
        this.f203082c.put(r102, r105);
        return r104;
    L6:
        return r103;
    }
}
