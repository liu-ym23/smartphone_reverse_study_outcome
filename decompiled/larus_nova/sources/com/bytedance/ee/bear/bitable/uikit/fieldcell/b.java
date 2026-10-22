package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class b<M extends h0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public iv4.b f216158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutilCellLayout f216159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f216160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f216161d;

    public static final class a extends ColorDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f216162a;

        public a(int r100) {
            super(r100);
            this.f216162a = new Paint(1);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public final void draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            this.f216162a.setColor(getColor());
            RectF r101 = new RectF();
            r101.set(getBounds());
            r100.drawRoundRect(r101, getBounds().height() / 2, getBounds().height() / 2, this.f216162a);
        }
    }

    public abstract View c(Context r100, ViewGroup r101);

    public iv4.a d() {
        return null;
    }

    public abstract void f(View r100, M r101);

    public abstract String getType();

    public b(iv4.b r100) {
        this.f216158a = r100;
        this.f216161d = true;
    }

    public Drawable e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new a(ResourcesCompat.getColor(r100.getResources(), R.color.udtoken_tag_neutral_bg_normal, r100.getTheme()));
    }

    public void g(List<? extends M> r110) {
        MutilCellLayout r100 = this.f216159b;
        if (r100 == null) goto L33;
        List<? extends M> r101 = r110;
        int r102 = 0;
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L14;
        r100.removeAllViews();
        return;
    L14:
        int r104 = r110.size();
        int r105 = r100.getChildCount();
        if (r104 <= r105) goto L23;
        int r106 = r104 - r105;
        int r107 = 0;
    L17:
        if (r107 >= r106) goto L25;
        View r108 = c(r100.getContext(), r100);
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 != null) goto L21;
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-2, -2);
    L22:
        r108.setLayoutParams(r111);
        r100.addView(r108);
        r107 = r107 + 1;
        goto L17
    L21:
        r111 = new LinearLayout.LayoutParams(r109);
    L25:
        if (r102 >= r104) goto L41;
        if (r102 < r110.size()) goto L29;
    L31:
        tt5.a.h("NATIVE_VIEW_TAG", "error path. index:" + r102 + ", newCount:" + r104 + ", oldCount:" + r105);
    L32:
        r102 = r102 + 1;
        goto L25
    L29:
        if (r102 >= r100.getChildCount()) goto L31;
        f(r100.getChildAt(r102), (h0) ListProtector.get(r110, r102));
        goto L32
    L41:
        return;
    L23:
        if (r104 >= r105) goto L25;
        r100.removeViews(r104, r105 - r104);
        goto L25
    L7:
        if (r101.isEmpty() == true) goto L10;
        r103 = false;
        goto L11
    }

    public void a(TextView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        if (this.f216161d == true) goto L5;
        return;
    L5:
        iv4.b r102 = this.f216158a;
        if (r102 == null) goto L12;
        r102.a(r100);
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setMaxLines(r102.f495940c);
        Intrinsics.checkNotNullParameter(r100, "view");
        Integer r103 = r102.c(r100.getContext());
        if (r103 == null) goto L10;
        r100.setTextColor(r103.intValue());
    L10:
        r102.b(r100, r101);
        return;
    }

    public View b(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f216160c = r101;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        MutilCellLayout r102 = new MutilCellLayout(r100);
        r102.setMutilCellLabelStyleProvider(new com.bytedance.ee.bear.bitable.uikit.fieldcell.a(this, r100));
        iv4.a r103 = d();
        if (r103 == null) goto L5;
        int r104 = r103.f495936a;
        int r105 = r103.f495937b;
        r102.f216150d = r104;
        r102.f216149c = r105;
    L5:
        this.f216159b = r102;
        return r102;
    }
}
