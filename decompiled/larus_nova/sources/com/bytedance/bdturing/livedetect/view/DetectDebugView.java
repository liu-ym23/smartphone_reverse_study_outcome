package com.bytedance.bdturing.livedetect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class DetectDebugView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f201934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f201935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<List<PointF>> f201936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<RectF> f201937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f201938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f201939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f201940g;

    public DetectDebugView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        List<List<PointF>> r100 = this.f201936c;
        int r101 = 0;
        if (r100 != null) goto L5;
    L14:
        List<RectF> r102 = this.f201937d;
        if (r102 != null) goto L17;
        return;
    L17:
        if (r102.size() > 0) goto L19;
        return;
    L19:
        if (r101 >= this.f201937d.size()) goto L26;
        RectF r103 = (RectF) ListProtector.get(this.f201937d, r101);
        float r104 = r103.left;
        float r105 = this.f201938e;
        float r106 = r104 * r105;
        float r107 = r103.top;
        float r108 = this.f201939f;
        r110.drawRect(r106, r107 * r108, r103.right * r105, r103.bottom * r108, this.f201934a);
        r101 = r101 + 1;
        goto L19
    L26:
        return;
    L5:
        if (r100.size() <= 0) goto L14;
        int r109 = 0;
    L8:
        if (r109 >= this.f201936c.size()) goto L14;
        List r111 = (List) ListProtector.get(this.f201936c, r109);
        int r112 = 0;
    L11:
        if (r112 >= r111.size()) goto L13;
        PointF r113 = (PointF) ListProtector.get(r111, r112);
        r110.drawCircle(r113.x * this.f201938e, r113.y * this.f201939f, this.f201940g, this.f201935b);
        r112 = r112 + 1;
        goto L11
    L13:
        r109 = r109 + 1;
        goto L8
    }

    public DetectDebugView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DetectDebugView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        Paint r103 = new Paint();
        this.f201934a = r103;
        r103.setAntiAlias(true);
        this.f201934a.setStyle(Paint.Style.STROKE);
        this.f201934a.setColor(FakePickerAvatarCreator.GREEN);
        this.f201934a.setStrokeWidth(3.0f);
        Paint r104 = new Paint();
        this.f201935b = r104;
        r104.setStyle(Paint.Style.FILL);
        this.f201935b.setColor(-65536);
        this.f201935b.setAntiAlias(true);
        this.f201940g = 3.0f;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f201938e == r100) goto L5;
    L6:
        this.f201938e = r100;
        this.f201939f = r101;
        return;
    L5:
        if (this.f201939f != r101) goto L6;
    }
}
