package com.bytedance.ee.bear.scaleimageview.areacomment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.util.ui.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 F2\u00020\u0001:\u0005FGHIJB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0014J\b\u0010#\u001a\u00020!H\u0014J\u000e\u0010$\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010%\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\u00132\b\u0010(\u001a\u0004\u0018\u00010\u0015J*\u0010)\u001a\u00020!2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0015J\u0018\u0010-\u001a\u0004\u0018\u00010\u001b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u001bH\u0002J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001bH\u0002J\u0016\u00105\u001a\u00020\u001b2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001b0+H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00104\u001a\u00020\u001bH\u0002J\u0012\u00109\u001a\u0004\u0018\u0001082\u0006\u00104\u001a\u00020\u001bH\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001bH\u0002J\u0012\u0010=\u001a\u0004\u0018\u00010\u001b2\b\u0010>\u001a\u0004\u0018\u00010\u0015J\u0006\u0010?\u001a\u00020!J\u0018\u0010@\u001a\u00020!2\u0006\u00104\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020BH\u0002J\u001a\u0010C\u001a\u00020!2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u00104\u001a\u00020\u001bH\u0002J\u0012\u0010D\u001a\u0004\u0018\u00010E2\u0006\u00104\u001a\u00020\u001bH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentAreaMarkLayout;", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentRectLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mLabelBgPaint", "Landroid/graphics/Paint;", "mLabelTextPaint", "Landroid/text/TextPaint;", "deleteIcon", "Landroid/graphics/drawable/Drawable;", "imageUUID", "", "getImageUUID", "()Ljava/lang/String;", "setImageUUID", "(Ljava/lang/String;)V", "mHighlightTarget", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentRectF;", "areaMarkRectLayoutListener", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentAreaMarkLayout$OnAreaMarkRectLayoutListener;", "mAreaMarkMode", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentAreaMarkLayout$AreaMarkMode;", "init", "", "onAttachedToWindow", "onDetachedFromWindow", "setAreaMarkMode", "setCommentAreaMarkClickListener", "setLayout", "drawable", "createText", "updateComment", "commentRectFList", "", "highLightRectFUuid", "getTouchCommentRectF", "x", "", "y", "handleDeleteIconClick", "targetRect", "enterHighlightMode", "rectF", "findBestMatchRect", "rects", "getDeleteIconRect", "Landroid/graphics/RectF;", "getLabelRect", "removeAreaRect", "", "target", "highlightRectF", "areaUUID", "hideHighlightRectF", "drawDeleteIcon", "canvas", "Landroid/graphics/Canvas;", "drawTopLeftLabel", "computeNameLabelLayout", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentAreaMarkLayout$NameLabelLayout;", "Companion", "AreaMarkMode", "OnAreaMarkRectLayoutListener", "LayoutDrawDelegate", "NameLabelLayout", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentAreaMarkLayout extends CommentRectLayout {
    public AreaMarkMode H0;
    public final Paint T;
    public final TextPaint U;
    public Drawable V;
    public String W;
    public CommentRectF k0;
    public d p0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentAreaMarkLayout$AreaMarkMode;", "", "<init>", "(Ljava/lang/String;I)V", "EDIT", "READ", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AreaMarkMode extends Enum<AreaMarkMode> {
        public static final AreaMarkMode EDIT = null;
        public static final AreaMarkMode READ = null;
        public static final /* synthetic */ AreaMarkMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AreaMarkMode> getEntries() {
            return b;
        }

        static {
            AreaMarkMode r0 = new AreaMarkMode("EDIT", 0);
            EDIT = r0;
            AreaMarkMode r1 = new AreaMarkMode("READ", 1);
            READ = r1;
            AreaMarkMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static AreaMarkMode[] values() {
            return (AreaMarkMode[]) a.clone();
        }

        public static AreaMarkMode valueOf(String r1) {
            return (AreaMarkMode) r27.a.a(AreaMarkMode.class, r1);
        }

        public AreaMarkMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public final class b extends CommentRectLayout.b {
        public final /* synthetic */ CommentAreaMarkLayout b;

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.b, android.view.View
        public final void onDraw(Canvas r9) {
            Intrinsics.checkNotNullParameter(r9, "canvas");
            tt5.a.h("CommentAreaMarkLayout", "onDraw...,uuid = " + this.b.getImageUUID() + ", mCommentRectVisible = " + this.b.n + ", hostWholeRectF = " + this.b.getHostWholeRectF() + ", commentTargetRectList size = " + ((ArrayList) this.b.b).size());
            if (Intrinsics.areEqual(this.b.getHostWholeRectF(), new RectF(0.0f, 0.0f, 0.0f, 0.0f)) == false) goto L5;
            return;
        L5:
            CommentAreaMarkLayout r0 = this.b;
            boolean r2 = true;
            if (r0.n == false) goto L44;
            r0.e.setColor(getResources().getColor(2131102365));
            this.b.e.setAlpha(255);
            Iterator r1 = ((ArrayList) this.b.b).iterator();
        L9:
            if (r1.hasNext() == false) goto L14;
            RectF r3 = (CommentRectF) r1.next();
            CommentAreaMarkLayout r4 = this.b;
            if (r3 == r4.k0) goto L9;
            r9.drawRect(r3, r4.e);
            goto L9
        L14:
            Iterator r5 = ((ArrayList) this.b.b).iterator();
        L16:
            if (r5.hasNext() == false) goto L21;
            CommentRectF r6 = (CommentRectF) r5.next();
            CommentAreaMarkLayout r7 = this.b;
            if (r6 == r7.k0) goto L16;
            Intrinsics.checkNotNull(r6);
            CommentAreaMarkLayout.y(r7, r9, r6);
            goto L16
        L21:
            CommentAreaMarkLayout r8 = this.b;
            CommentRectF r10 = r8.k0;
            if (r10 == null) goto L24;
            r9.drawRect(r10, r8.e);
            CommentAreaMarkLayout.y(r8, r9, r10);
        L24:
            CommentAreaMarkLayout r11 = this.b;
            if (r11.H0 != AreaMarkMode.EDIT) goto L44;
            CommentRectF r12 = r11.k0;
            if (r12 == null) goto L44;
            d r13 = r11.p0;
            if (r13 != null) goto L31;
        L33:
            boolean r14 = false;
        L34:
            if (r14 == false) goto L44;
            if (r11.V == null) goto L44;
            RectF r15 = r11.B(r12);
            Drawable r16 = r11.V;
            if (r16 == null) goto L41;
            r16.setBounds((int) r15.left, (int) r15.top, (int) r15.right, (int) r15.bottom);
        L41:
            Drawable r17 = r11.V;
            if (r17 == null) goto L44;
            r17.draw(r9);
            goto L44
        L31:
            if (r13.a(r12) != true) goto L33;
            r14 = true;
        L44:
            CommentAreaMarkLayout r18 = this.b;
            if (r18.o == true) goto L47;
            return;
        L47:
            if (r18.y.getVisibility() == 0) goto L50;
            r2 = false;
        L50:
            if (r2 == false) goto L64;
            RectF r19 = new RectF(this.b.z);
            CommentAreaMarkLayout r20 = this.b;
            r20.h(r9, r19, r20.y.getSidePadding() + this.b.y.getTouchSideSize());
            return;
        }

        public b(CommentAreaMarkLayout r1, Context r2) {
            this.b = r1;
            super(r1, r2);
        }
    }

    public static final class c {
        public final RectF a;
        public final float[] b;
        public final CharSequence c;
        public final float d;
        public final float e;
        public final boolean f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r6.e) == 0) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((this.a.hashCode() * 31) + Arrays.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31;
            if (this.f == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "NameLabelLayout(rect=" + this.a + ", radii=" + Arrays.toString(this.b) + ", text=" + this.c + ", textX=" + this.d + ", baselineY=" + this.e + ", flipped=" + this.f + ')';
        }

        public c(RectF r2, float[] r3, CharSequence r4, float r5, float r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "rect");
            Intrinsics.checkNotNullParameter(r3, "radii");
            Intrinsics.checkNotNullParameter(r4, "text");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public interface d {
        boolean a(CommentRectF r1);

        void b(CommentRectF r1);

        void c(CommentRectF r1);
    }

    static {
    }

    private final void p() {
        setWillNotDraw(false);
        this.V = AppCompatResources.getDrawable(getContext(), 2131237963);
        this.T.setColor(getResources().getColor(2131102365));
        this.T.setAntiAlias(true);
        this.T.setStyle(Paint.Style.FILL);
        this.U.setColor(-16777216);
        this.U.setAntiAlias(true);
        this.U.setTextSize(n.G(10));
        this.U.setTextAlign(Paint.Align.LEFT);
        this.U.setFakeBoldText(false);
        this.U.setStyle(Paint.Style.FILL);
        this.U.setSubpixelText(true);
        View r1 = this.J;
        CommentRectLayout.b r3 = new b(this, getContext());
        r3.setEnabled(false);
        if (r1 == null) goto L5;
        int r0 = indexOfChild(r1);
        removeView(r1);
        addView(r3, r0);
    L6:
        setCommentRectLayoutDrawDelegate(r3);
        return;
    L5:
        addView(r3, 1);
        goto L6
    }

    public final String getImageUUID() {
        return this.W;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public CommentAreaMarkLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.T = new Paint();
        this.U = new TextPaint();
        this.H0 = AreaMarkMode.READ;
        p();
    }

    public final void A(CommentRectF r2) {
        this.k0 = r2;
        CommentRectLayout.b r0 = this.J;
        if (r0 == null) goto L5;
        r0.invalidate();
    L5:
        d r1 = this.p0;
        if (r1 == null) goto L9;
        r1.b(r2);
        return;
    }

    public final RectF B(CommentRectF r7) {
        int r0 = CommentRectLayout.Q;
        float r1 = r0;
        float r2 = r1 / 2.0f;
        float r3 = ((RectF) r7).right - r2;
        float r8 = ((RectF) r7).bottom - r2;
        float r4 = r3 + r1;
        float r5 = r1 + r8;
        RectF r6 = getHostWholeRectF();
        float r9 = r6.right;
        if (r4 <= r9) goto L5;
        float r10 = r4 - r9;
        r3 = r3 - r10;
        r4 = r4 - r10;
    L5:
        float r11 = r6.bottom;
        if (r5 <= r11) goto L9;
        float r12 = r5 - r11;
        r8 = r8 - r12;
        r5 = r5 - r12;
    L9:
        return new RectF(r3, r8, r4, r5);
    }

    public final void setAreaMarkMode(AreaMarkMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mAreaMarkMode");
        this.H0 = r2;
    }

    public final void setCommentAreaMarkClickListener(d r2) {
        Intrinsics.checkNotNullParameter(r2, "areaMarkRectLayoutListener");
        this.p0 = r2;
    }

    public final void setImageUUID(String r1) {
        this.W = r1;
    }

    public final c z(CommentRectF r20) {
        String r4 = r20.f;
        if (TextUtils.isEmpty(r4) == false) goto L6;
        tt5.a.k("CommentAreaMarkLayout", "computeNameLabelLayout() called with: text is empty");
        return null;
    L6:
        float r3 = n.d(6);
        float r6 = n.d(1);
        float r7 = n.d(16);
        Paint.FontMetrics r8 = this.U.getFontMetrics();
        float r9 = r8.bottom;
        float r10 = r8.top;
        float r11 = r7 + (2 * r6);
        float r12 = ((r11 - (r9 - r10)) / 2.0f) - r10;
        float r13 = this.U.measureText(r4, 0, r4.length()) + (2.0f * r3);
        float r14 = this.e.getStrokeWidth() * 0.5f;
        float r15 = (float) Math.floor((((RectF) r20).left - r14) + 0.5f);
        float r16 = (float) Math.floor((((RectF) r20).top + r14) + 0.5f);
        float r17 = r16 - r11;
        float r18 = r13 + r15;
        if (r17 >= getHostWholeRectF().top) goto L9;
        boolean r19 = true;
    L10:
        if (r19 == true) goto L12;
        Triple r1 = new Triple(Float.valueOf(r17), Float.valueOf(r16), Float.valueOf(r18));
    L13:
        float r2 = ((Number) r1.component1()).floatValue();
        RectF r21 = new RectF(r15, r2, ((Number) r1.component3()).floatValue(), ((Number) r1.component2()).floatValue());
        float r22 = n.d(4);
        if (r19 == true) goto L16;
        float[] r110 = {r22, r22, r22, r22, 0.0f, 0.0f, 0.0f, 0.0f};
    L17:
        Intrinsics.checkNotNull(r4);
        return new c(r21, r110, r4, r15 + r3, r12 + r2, r19);
    L16:
        r110 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r22, r22, 0.0f, 0.0f};
        goto L17
    L12:
        float r5 = (float) Math.floor((((RectF) r20).top - r14) + 0.5f);
        r1 = new Triple(Float.valueOf(r5), Float.valueOf(r11 + r5), Float.valueOf(r18));
        goto L13
    L9:
        r19 = false;
        goto L10
    }

    public CommentAreaMarkLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.T = new Paint();
        this.U = new TextPaint();
        this.H0 = AreaMarkMode.READ;
        p();
    }

    public CommentAreaMarkLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.T = new Paint();
        this.U = new TextPaint();
        this.H0 = AreaMarkMode.READ;
        p();
    }

    public static final void y(CommentAreaMarkLayout r9, Canvas r10, CommentRectF r11) {
        if (r10 != null) goto L4;
        r9.getClass();
        tt5.a.k("CommentAreaMarkLayout", "drawTopLeftLabel() called with: canvas is null");
        return;
    L4:
        c r12 = r9.z(r11);
        if (r12 == null) goto L10;
        Path r0 = new Path();
        r0.addRoundRect(r12.a, r12.b, Path.Direction.CW);
        int r1 = r9.getResources().getColor(2131102365);
        r9.T.setColor(r1);
        r9.T.setAlpha(255);
        r10.drawPath(r0, r9.T);
        CharSequence r3 = r12.c;
        r10.drawText(r3, 0, r3.length(), r12.d, r12.e, r9.U);
        return;
    }
}
