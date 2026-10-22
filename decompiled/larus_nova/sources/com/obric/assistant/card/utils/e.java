package com.obric.assistant.card.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f386550a = 0;

    public static final class a extends DynamicDrawableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f386551a;

        @Override // android.text.style.DynamicDrawableSpan
        public final Drawable getDrawable() {
            return this.f386551a;
        }

        public a(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, "mDrawable");
            this.f386551a = r100;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Intrinsics.checkNotNullParameter(r101, "text");
            Intrinsics.checkNotNullParameter(r108, "paint");
            r100.save();
            r100.translate(r104, (r105 + ((r107 - r105) / 2)) - (this.f386551a.getBounds().height() / 2));
            this.f386551a.draw(r100);
            r100.restore();
        }
    }

    public static final class b extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f386552a;

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Intrinsics.checkNotNullParameter(r101, "text");
            Intrinsics.checkNotNullParameter(r108, "paint");
        }

        public b(int r100) {
            this.f386552a = r100;
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            Intrinsics.checkNotNullParameter(r101, "text");
            return this.f386552a;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [T, android.graphics.drawable.ColorDrawable] */
    public static CharSequence a(Context r110, List r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "textList");
        SpannableStringBuilder r100 = new SpannableStringBuilder();
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        ArrayList r102 = new ArrayList();
        Iterator r112 = r111.iterator();
    L3:
        boolean r103 = false;
        if (r112.hasNext() == false) goto L10;
        Object r104 = r112.next();
        if (((String) r104).length() <= 0) goto L8;
        r103 = true;
    L8:
        if (r103 == false) goto L3;
        r102.add(r104);
        goto L3
    L10:
        Iterator r113 = r102.iterator();
        int r105 = 0;
    L12:
        if (r113.hasNext() == false) goto L23;
        Object r106 = r113.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        r100.append((String) r106);
        if (r105 >= (r102.size() - 1)) goto L22;
        if (r101.element != 0) goto L21;
        ?? r108 = new ColorDrawable(ContextCompat.getColor(r110, R.color.neutral_transparent_2));
        r108.setBounds(0, 0, r110.getResources().getDimensionPixelSize(R.dimen.dp_0_5), r110.getResources().getDimensionPixelSize(R.dimen.dp_10));
        r101.element = r108;
    L21:
        r100.append("X");
        r100.setSpan(new b(r110.getResources().getDimensionPixelSize(R.dimen.dp_8)), r100.length() - 1, r100.length(), 33);
        r100.append("X");
        T r109 = r101.element;
        Intrinsics.checkNotNull(r109);
        r100.setSpan(new a((Drawable) r109), r100.length() - 1, r100.length(), 33);
        r100.append("X");
        r100.setSpan(new b(r110.getResources().getDimensionPixelSize(R.dimen.dp_8)), r100.length() - 1, r100.length(), 33);
    L22:
        r105 = r107;
        goto L12
    L23:
        return r100;
    }
}
