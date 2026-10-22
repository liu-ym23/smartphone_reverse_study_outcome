package com.ss.android.lark.widget.linked_emojicon.widget;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/widget/linked_emojicon/widget/CustomTypefaceSpan;", "Landroid/text/style/TypefaceSpan;", "family", "", "newType", "Landroid/graphics/Typeface;", "<init>", "(Ljava/lang/String;Landroid/graphics/Typeface;)V", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "updateMeasureState", "paint", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomTypefaceSpan extends TypefaceSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f446389b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f446390a;

    public static final class a {
        public a() {
        }

        public static final void a(Paint r100, Typeface r101) {
            int r102 = CustomTypefaceSpan.f446389b;
            Typeface r103 = r100.getTypeface();
            if (r103 == null) goto L5;
            int r104 = r103.getStyle();
        L6:
            int r105 = r104 & (~r101.getStyle());
            if ((r105 & 1) == 0) goto L10;
            r100.setFakeBoldText(true);
        L10:
            if ((r105 & 2) == 0) goto L12;
            r100.setTextSkewX(-0.25f);
        L12:
            r100.setTypeface(r101);
            return;
        L5:
            r104 = 0;
            goto L6
        }
    }

    static {
        new a();
    }

    public CustomTypefaceSpan(Typeface r100) {
        Intrinsics.checkNotNullParameter(r100, "newType");
        super(null);
        this.f446390a = r100;
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        a.a(r100, this.f446390a);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        a.a(r100, this.f446390a);
    }
}
