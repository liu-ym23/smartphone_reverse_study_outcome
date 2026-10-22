package com.bytedance.android.shopping.anchorv4.voavhs.processflow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.android.shopping.extensions.a;
import com.bytedance.android.shopping.extensions.b;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/processflow/AnchorV4PathEffectFlowLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "items", "", "update", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4PathEffectFlowLayout extends ConstraintLayout {
    public final List<View> a;
    public final Paint b;
    public final int c;
    public final int d;
    public final int e;
    public final Path f;
    public List<TextWithOneIconElement> g;

    public AnchorV4PathEffectFlowLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4PathEffectFlowLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView] */
    public final void R5(List<TextWithOneIconElement> r15) {
        removeAllViews();
        ((ArrayList) this.a).clear();
        this.g = r15;
        View r0 = null;
        if (r15 == null) goto L8;
        Iterator<T> r16 = r15.iterator();
    L6:
        if (r16.hasNext() == false) goto L8;
        TextWithOneIconElement r2 = (TextWithOneIconElement) r16.next();
        SimpleDraweeView r3 = new SimpleDraweeView(getContext());
        ImageExtensionsKt.d(r3, r2.getIcon(), null);
        r3.setId(ViewCompat.generateViewId());
        ((ArrayList) this.a).add(r3);
        ?? r4 = new TextElementView(getContext(), null, 0, null, 30);
        r4.x(r2.getContent());
        r4.setId(ViewCompat.generateViewId());
        r4.setGravity(17);
        addView(r3);
        ConstraintLayout.LayoutParams r5 = new ConstraintLayout.LayoutParams(-2, -2);
        r5.startToStart = r3.getId();
        r5.endToEnd = r3.getId();
        r5.topToBottom = r3.getId();
        r5.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r5).topMargin = b.b(Integer.valueOf(r2.getSpace()));
        r5.verticalBias = 0.0f;
        Unit r6 = Unit.INSTANCE;
        addView(r4, r5);
    L8:
        ConstraintSet r17 = new ConstraintSet();
        r17.clone(this);
        ArrayList r7 = new ArrayList();
        Iterator r8 = ((ArrayList) this.a).iterator();
        int r9 = 0;
    L10:
        if (r8.hasNext() == false) goto L25;
        Object r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        View r12 = (View) r10;
        if (r9 != (getChildCount() - 1)) goto L17;
        boolean r13 = true;
    L18:
        if (r0 == null) goto L22;
        r17.connect(r12.getId(), 1, r0.getId(), 2);
        if (r13 == false) goto L23;
        r17.connect(r12.getId(), 2, 0, 2);
    L23:
        r7.add(Integer.valueOf(r12.getId()));
        r0 = r12;
        r9 = r11;
        goto L10
    L22:
        r17.connect(r12.getId(), 1, 0, 1);
        goto L23
    L17:
        r13 = false;
        goto L18
    L25:
        if (r7.size() < 2) goto L33;
        r17.createHorizontalChain(0, 1, 0, 2, CollectionsKt.toIntArray(r7), null, 1);
        r17.applyTo(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r14) {
        Intrinsics.checkNotNullParameter(r14, "canvas");
        super/*android.view.ViewGroup*/.onDraw(r14);
        Iterator r0 = ((ArrayList) this.a).iterator();
        float r1 = 0.0f;
        int r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L19;
        Object r4 = r0.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r6 = (View) r4;
        Rect r7 = new Rect();
        r6.getDrawingRect(r7);
        offsetDescendantRectToMyCoords(r6, r7);
        if (r3 != 0) goto L11;
        int r2 = r7.right;
    L18:
        r1 = r2;
        r3 = r5;
        goto L4
    L11:
        this.b.setColor(a.a("#16182333", 0));
        float r8 = this.e;
        float r10 = r1 + r8;
        float r9 = r7.left - r8;
        float r11 = r7.exactCenterY();
        Paint r12 = this.b;
        if (r14 == null) goto L14;
        r14.drawLine(r9 - this.d, r11, r10, r11, r12);
    L14:
        this.f.reset();
        this.f.moveTo(r9 - this.d, r11 - (this.c / 2.0f));
        this.f.lineTo(r9 - this.d, (this.c / 2.0f) + r11);
        this.f.lineTo(r9, r11);
        this.f.close();
        if (r14 == null) goto L17;
        r14.drawPath(this.f, r12);
    L17:
        r2 = r7.right;
        goto L18
    }

    public final void update(List<TextWithOneIconElement> r1) {
        this.g = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4PathEffectFlowLayout(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = new ArrayList();
        Paint r8 = new Paint();
        this.b = r8;
        DashPathEffect r9 = new DashPathEffect(new float[]{vf4.a.a(r5, 2.0f), vf4.a.a(r5, 2.0f)}, 1.0f);
        this.c = vf4.a.a(r5, 5.0f);
        this.d = vf4.a.a(r5, 4.0f);
        this.e = vf4.a.a(r5, 8.0f);
        this.f = new Path();
        r8.setStrokeWidth(vf4.a.a(r5, 1.0f));
        r8.setAntiAlias(true);
        r8.setPathEffect(r9);
        setClipChildren(false);
        setClipToPadding(false);
        setWillNotDraw(false);
    }

    public /* synthetic */ AnchorV4PathEffectFlowLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
