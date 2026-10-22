package com.larksuite.component.ui.tag;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.TypedValue;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class TagsDrawable extends Drawable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f284391j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f284392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f284393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f284394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f284395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f284396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f284397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f284398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<d> f284399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<d, Rect> f284400i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f284401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f284402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f284403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f284404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f284405e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f284406f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<d> f284407g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ArrayList<HashSet<Integer>> f284408h;

        public final int hashCode() {
            return ((((((((((0 + Float.floatToIntBits(this.f284402b)) * 31) + Float.floatToIntBits(this.f284403c)) * 31) + Float.floatToIntBits(this.f284404d)) * 31) + Float.floatToIntBits(this.f284405e)) * 31) + this.f284407g.hashCode()) * 31) + Float.floatToIntBits(this.f284406f);
        }

        public final Context getContext() {
            return this.f284401a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f284401a = r100;
            int r101 = TagsDrawable.f284391j;
            this.f284402b = b.a(r100, 12.0f);
            this.f284403c = b.a(r100, 4.0f);
            this.f284404d = b.a(r100, 18.0f);
            this.f284405e = b.a(r100, 4.0f);
            this.f284406f = b.a(r100, 12.0f);
            this.f284407g = new ArrayList(2);
            this.f284408h = new ArrayList();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larksuite.component.ui.tag.TagsDrawable.Builder");
            a r102 = (a) r100;
            if (this.f284402b != r102.f284402b) goto L15;
            boolean r103 = true;
        L16:
            if (r103 == true) goto L19;
            return false;
        L19:
            if (this.f284403c != r102.f284403c) goto L21;
            boolean r104 = true;
        L22:
            if (r104 == true) goto L25;
            return false;
        L25:
            if (this.f284404d != r102.f284404d) goto L27;
            boolean r105 = true;
        L28:
            if (r105 == true) goto L31;
            return false;
        L31:
            if (this.f284405e != r102.f284405e) goto L33;
            boolean r106 = true;
        L34:
            if (r106 == true) goto L37;
            return false;
        L37:
            if (Intrinsics.areEqual(this.f284407g, r102.f284407g) == true) goto L40;
            return false;
        L40:
            if (this.f284406f != r102.f284406f) goto L42;
            boolean r107 = true;
        L43:
            if (r107 == true) goto L45;
            return false;
        L45:
            return true;
        L42:
            r107 = false;
            goto L43
        L33:
            r106 = false;
            goto L34
        L27:
            r105 = false;
            goto L28
        L21:
            r104 = false;
            goto L22
        L15:
            r103 = false;
            goto L16
        L8:
            r101 = null;
            goto L10
        }
    }

    public static final class b {
        public static float a(Context r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Resources r102 = r100.getResources();
            return TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
        }
    }

    public static final class c extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f284409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f284410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f284411c;

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return this.f284409a.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicHeight() {
            return this.f284411c;
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicWidth() {
            return this.f284410b;
        }

        public c(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
            this.f284409a = r100;
            this.f284410b = r100.getIntrinsicWidth();
            this.f284411c = r100.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            r100.save();
            r100.scale(this.f284410b / this.f284409a.getIntrinsicWidth(), this.f284411c / this.f284409a.getIntrinsicHeight(), getBounds().left, getBounds().top);
            this.f284409a.draw(r100);
            r100.restore();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int r100) {
            this.f284409a.setAlpha(r100);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter r100) {
            this.f284409a.setColorFilter(r100);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setBounds(int r100, int r101, int r102, int r103) {
            super.setBounds(r100, r101, r102, r103);
            Drawable r104 = this.f284409a;
            r104.setBounds(r100, r101, r104.getIntrinsicWidth() + r100, this.f284409a.getIntrinsicHeight() + r101);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f284412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f284413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f284414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Drawable f284415d;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Context f284416a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f284417b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f284418c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f284419d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Drawable f284420e;

            public final Context getContext() {
                return this.f284416a;
            }

            public a(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                this.f284416a = r100;
                this.f284417b = -1;
                this.f284418c = 10;
                this.f284419d = -1;
            }
        }

        public final int hashCode() {
            int r100 = ((((this.f284413b * 31) + 0) * 31) + this.f284414c) * 31;
            Drawable r101 = this.f284415d;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return ((r100 + r102) * 31) + 0;
        L5:
            r102 = 0;
            goto L7
        }

        public d(a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            this.f284412a = r100.f284417b;
            this.f284413b = r100.f284418c;
            this.f284414c = r100.f284419d;
            this.f284415d = r100.f284420e;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(d.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larksuite.component.ui.tag.TagsDrawable.TagModel");
            d r102 = (d) r100;
            if (this.f284413b == r102.f284413b) goto L15;
            return false;
        L15:
            r102.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L19;
            return false;
        L19:
            if (this.f284414c == r102.f284414c) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.f284415d, r102.f284415d) == true) goto L24;
            return false;
        L24:
            r102.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L27;
            return false;
        L27:
            return true;
        L8:
            r101 = null;
            goto L10
        }
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public final int hashCode() {
        return this.f284392a.hashCode();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return getBounds().width();
    }

    public TagsDrawable(a r110) {
        this.f284392a = r110;
        Lazy r100 = LazyKt.lazy(new TagsDrawable$textPaint$2(this));
        this.f284398g = r100;
        this.f284400i = new HashMap(2);
        float r101 = r110.f284402b;
        this.f284393b = r101;
        this.f284394c = r110.f284403c;
        this.f284395d = r110.f284404d;
        this.f284396e = r110.f284405e;
        this.f284397f = r110.f284406f;
        List<d> r111 = r110.f284407g;
        this.f284399h = r111;
        ((TextPaint) r100.getValue()).setTextSize(r101);
        if (r111 == null) goto L18;
        Iterator r112 = ((ArrayList) r111).iterator();
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r112.hasNext() == false) goto L19;
        d r105 = (d) r112.next();
        if (this.f284400i.containsKey(r105) == true) goto L6;
        Rect r106 = new Rect(r104, 0, 0, 0);
        r105.getClass();
        Drawable r107 = r105.f284415d;
        if (r107 == null) goto L17;
        float r108 = this.f284395d;
        if ((r107 instanceof c) == false) goto L16;
        c r109 = (c) r107;
        float r113 = this.f284397f;
        float r114 = r113 / r109.f284409a.getIntrinsicHeight();
        r109.f284411c = (int) r113;
        r109.f284410b = (int) (r109.f284409a.getIntrinsicWidth() * r114);
    L16:
        int r115 = r107.getIntrinsicWidth();
        int r116 = r107.getIntrinsicHeight();
        float r117 = r115;
        float r118 = Math.max(r117, 0.0f);
        float r119 = r116;
        float r120 = Math.max(r119, r108);
        int r121 = r106.left;
        int r122 = r106.top;
        r106.set(r121, r122, ((int) r118) + r121, ((int) r120) + r122);
        float r123 = r118 - r117;
        float r124 = 2;
        int r125 = (int) (r123 / r124);
        int r126 = (int) ((r120 - r119) / r124);
        r107.setBounds(r106.left + r125, r106.top + r126, r106.right - r125, r106.bottom - r126);
    L17:
        this.f284400i.put(r105, r106);
        int r127 = r106.right;
        int r128 = (int) (r127 + this.f284396e);
        r103 = Math.max(r103, r106.bottom);
        r102 = r127;
        r104 = r128;
    L19:
        setBounds(0, 0, r102, r103);
        invalidateSelf();
        return;
    L18:
        r102 = 0;
        r103 = 0;
        goto L19
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        List<d> r101 = this.f284399h;
        if (r101 == null) goto L15;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L26;
        d r103 = (d) r102.next();
        if (this.f284400i.get(r103) == null) goto L6;
        r103.getClass();
        Drawable r104 = r103.f284415d;
        if ((r104 instanceof UDTagsDrawable) == true) goto L12;
        if (r104 == null) goto L6;
        r104.draw(r100);
        goto L6
    L12:
        r100.save();
        r100.translate(((UDTagsDrawable) r103.f284415d).getBounds().left, 0.0f);
        ((UDTagsDrawable) r103.f284415d).draw(r100);
        r100.restore();
        goto L6
    L26:
        return;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(TagsDrawable.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larksuite.component.ui.tag.TagsDrawable");
        TagsDrawable r102 = (TagsDrawable) r100;
        if (this.f284393b != r102.f284393b) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L19;
        return false;
    L19:
        if (this.f284394c != r102.f284394c) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == true) goto L25;
        return false;
    L25:
        if (this.f284395d != r102.f284395d) goto L27;
        boolean r105 = true;
    L28:
        if (r105 == true) goto L31;
        return false;
    L31:
        if (this.f284396e != r102.f284396e) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == true) goto L37;
        return false;
    L37:
        if (Intrinsics.areEqual(this.f284399h, r102.f284399h) == true) goto L39;
        return false;
    L39:
        return true;
    L33:
        r106 = false;
        goto L34
    L27:
        r105 = false;
        goto L28
    L21:
        r104 = false;
        goto L22
    L15:
        r103 = false;
        goto L16
    L8:
        r101 = null;
        goto L10
    }
}
