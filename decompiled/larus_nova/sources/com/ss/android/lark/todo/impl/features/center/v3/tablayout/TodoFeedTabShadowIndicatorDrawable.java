package com.ss.android.lark.todo.impl.features.center.v3.tablayout;

import android.app.Application;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoFeedTabShadowIndicatorDrawable extends ShapeDrawable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f441743e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f441744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f441745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f441746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f441747d;

    public static final class a {
    }

    public static class b {
        public b() {
        }

        public void a(Canvas r100, RectF r101, float r102, Paint r103) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Intrinsics.checkNotNullParameter(r101, "shadowRect");
            Intrinsics.checkNotNullParameter(r103, "paint");
        }
    }

    public static class c extends b {
        public c() {
        }

        @Override // com.ss.android.lark.todo.impl.features.center.v3.tablayout.TodoFeedTabShadowIndicatorDrawable.b
        public final void a(Canvas r100, RectF r101, float r102, Paint r103) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Intrinsics.checkNotNullParameter(r101, "shadowRect");
            Intrinsics.checkNotNullParameter(r103, "paint");
            r100.drawRoundRect(r101, r102, r102, r103);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        b r100 = new b();
    L6:
        f441743e = r100;
        return;
    L5:
        r100 = new c();
        goto L6
    }

    public TodoFeedTabShadowIndicatorDrawable() {
        Application r100 = LarkContext.getApplication();
        this.f441744a = r100;
        float r101 = UIUtils.sp2px(r100, 18);
        this.f441745b = r101;
        this.f441746c = new RectF();
        this.f441747d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TodoFeedTabShadowIndicatorDrawable$shadowPaint$2(this));
        setShape(new RoundRectShape(new float[]{r101, r101, r101, r101, r101, r101, r101, r101}, null, null));
    }

    public final Application getContext() {
        return this.f441744a;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        f441743e.a(r100, this.f441746c, this.f441745b, (Paint) this.f441747d.getValue());
        super.draw(r100);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        this.f441746c.set(r100);
    }
}
