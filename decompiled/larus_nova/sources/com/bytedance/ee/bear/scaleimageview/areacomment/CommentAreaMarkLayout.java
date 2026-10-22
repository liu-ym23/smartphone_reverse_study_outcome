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
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 F2\u00020\u0001:\u0005FGHIJB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0014J\b\u0010#\u001a\u00020!H\u0014J\u000e\u0010$\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010%\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\u00132\b\u0010(\u001a\u0004\u0018\u00010\u0015J*\u0010)\u001a\u00020!2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0015J\u0018\u0010-\u001a\u0004\u0018\u00010\u001b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u001bH\u0002J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001bH\u0002J\u0016\u00105\u001a\u00020\u001b2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001b0+H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00104\u001a\u00020\u001bH\u0002J\u0012\u00109\u001a\u0004\u0018\u0001082\u0006\u00104\u001a\u00020\u001bH\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001bH\u0002J\u0012\u0010=\u001a\u0004\u0018\u00010\u001b2\b\u0010>\u001a\u0004\u0018\u00010\u0015J\u0006\u0010?\u001a\u00020!J\u0018\u0010@\u001a\u00020!2\u0006\u00104\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020BH\u0002J\u001a\u0010C\u001a\u00020!2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u00104\u001a\u00020\u001bH\u0002J\u0012\u0010D\u001a\u0004\u0018\u00010E2\u0006\u00104\u001a\u00020\u001bH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentAreaMarkLayout;", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentRectLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mLabelBgPaint", "Landroid/graphics/Paint;", "mLabelTextPaint", "Landroid/text/TextPaint;", "deleteIcon", "Landroid/graphics/drawable/Drawable;", "imageUUID", "", "getImageUUID", "()Ljava/lang/String;", "setImageUUID", "(Ljava/lang/String;)V", "mHighlightTarget", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentRectF;", "areaMarkRectLayoutListener", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentAreaMarkLayout$OnAreaMarkRectLayoutListener;", "mAreaMarkMode", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentAreaMarkLayout$AreaMarkMode;", "init", "", "onAttachedToWindow", "onDetachedFromWindow", "setAreaMarkMode", "setCommentAreaMarkClickListener", "setLayout", "drawable", "createText", "updateComment", "commentRectFList", "", "highLightRectFUuid", "getTouchCommentRectF", "x", "", "y", "handleDeleteIconClick", "targetRect", "enterHighlightMode", "rectF", "findBestMatchRect", "rects", "getDeleteIconRect", "Landroid/graphics/RectF;", "getLabelRect", "removeAreaRect", "", PickerReporterConstants.KEY.TARGET, "highlightRectF", "areaUUID", "hideHighlightRectF", "drawDeleteIcon", "canvas", "Landroid/graphics/Canvas;", "drawTopLeftLabel", "computeNameLabelLayout", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentAreaMarkLayout$NameLabelLayout;", "Companion", "AreaMarkMode", "OnAreaMarkRectLayoutListener", "LayoutDrawDelegate", "NameLabelLayout", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentAreaMarkLayout extends CommentRectLayout {
    public AreaMarkMode H0;
    public final Paint T;
    public final TextPaint U;
    public Drawable V;
    public String W;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public CommentRectF f236763k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public d f236764p0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentAreaMarkLayout$AreaMarkMode;", "", "<init>", "(Ljava/lang/String;I)V", "EDIT", "READ", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AreaMarkMode extends Enum<AreaMarkMode> {
        public static final AreaMarkMode EDIT = null;
        public static final AreaMarkMode READ = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AreaMarkMode[] f236765a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f236766b = null;

        public static EnumEntries<AreaMarkMode> getEntries() {
            return f236766b;
        }

        static {
            AreaMarkMode r100 = new AreaMarkMode("EDIT", 0);
            EDIT = r100;
            AreaMarkMode r101 = new AreaMarkMode("READ", 1);
            READ = r101;
            AreaMarkMode[] r102 = {r100, r101};
            f236765a = r102;
            f236766b = EnumEntriesKt.enumEntries(r102);
        }

        public static AreaMarkMode[] values() {
            return (AreaMarkMode[]) f236765a.clone();
        }

        public static AreaMarkMode valueOf(String r100) {
            return (AreaMarkMode) r27.a.a(AreaMarkMode.class, r100);
        }

        public AreaMarkMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public final class b extends CommentRectLayout.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommentAreaMarkLayout f236767b;

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.b, android.view.View
        public final void onDraw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            tt5.a.h("CommentAreaMarkLayout", "onDraw...,uuid = " + this.f236767b.getImageUUID() + ", mCommentRectVisible = " + this.f236767b.f236798n + ", hostWholeRectF = " + this.f236767b.getHostWholeRectF() + ", commentTargetRectList size = " + ((ArrayList) this.f236767b.f236786b).size());
            if (Intrinsics.areEqual(this.f236767b.getHostWholeRectF(), new RectF(0.0f, 0.0f, 0.0f, 0.0f)) == false) goto L5;
            return;
        L5:
            CommentAreaMarkLayout r101 = this.f236767b;
            boolean r102 = true;
            if (r101.f236798n == false) goto L44;
            r101.f236789e.setColor(getResources().getColor(R.color.gradient_yellow_0));
            this.f236767b.f236789e.setAlpha(255);
            Iterator r103 = ((ArrayList) this.f236767b.f236786b).iterator();
        L9:
            if (r103.hasNext() == false) goto L14;
            RectF r104 = (CommentRectF) r103.next();
            CommentAreaMarkLayout r105 = this.f236767b;
            if (r104 == r105.f236763k0) goto L9;
            r100.drawRect(r104, r105.f236789e);
            goto L9
        L14:
            Iterator r106 = ((ArrayList) this.f236767b.f236786b).iterator();
        L16:
            if (r106.hasNext() == false) goto L21;
            CommentRectF r107 = (CommentRectF) r106.next();
            CommentAreaMarkLayout r108 = this.f236767b;
            if (r107 == r108.f236763k0) goto L16;
            Intrinsics.checkNotNull(r107);
            CommentAreaMarkLayout.y(r108, r100, r107);
            goto L16
        L21:
            CommentAreaMarkLayout r109 = this.f236767b;
            CommentRectF r110 = r109.f236763k0;
            if (r110 == null) goto L24;
            r100.drawRect(r110, r109.f236789e);
            CommentAreaMarkLayout.y(r109, r100, r110);
        L24:
            CommentAreaMarkLayout r111 = this.f236767b;
            if (r111.H0 != AreaMarkMode.EDIT) goto L44;
            CommentRectF r112 = r111.f236763k0;
            if (r112 == null) goto L44;
            d r113 = r111.f236764p0;
            if (r113 != null) goto L31;
        L33:
            boolean r114 = false;
        L34:
            if (r114 == false) goto L44;
            if (r111.V == null) goto L44;
            RectF r115 = r111.B(r112);
            Drawable r116 = r111.V;
            if (r116 == null) goto L41;
            r116.setBounds((int) r115.left, (int) r115.top, (int) r115.right, (int) r115.bottom);
        L41:
            Drawable r117 = r111.V;
            if (r117 == null) goto L44;
            r117.draw(r100);
            goto L44
        L31:
            if (r113.a(r112) != true) goto L33;
            r114 = true;
        L44:
            CommentAreaMarkLayout r118 = this.f236767b;
            if (r118.f236799o == true) goto L47;
            return;
        L47:
            if (r118.f236809y.getVisibility() == 0) goto L50;
            r102 = false;
        L50:
            if (r102 == false) goto L64;
            RectF r119 = new RectF(this.f236767b.f236810z);
            CommentAreaMarkLayout r120 = this.f236767b;
            r120.h(r100, r119, r120.f236809y.getSidePadding() + this.f236767b.f236809y.getTouchSideSize());
            return;
        }

        public b(CommentAreaMarkLayout r100, Context r101) {
            this.f236767b = r100;
            super(r100, r101);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f236768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f236769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CharSequence f236770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f236771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f236772e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f236773f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f236768a, r101.f236768a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f236769b, r101.f236769b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f236770c, r101.f236770c) == true) goto L18;
            return false;
        L18:
            if (Float.compare(this.f236771d, r101.f236771d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.f236772e, r101.f236772e) == 0) goto L24;
            return false;
        L24:
            if (this.f236773f == r101.f236773f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((this.f236768a.hashCode() * 31) + Arrays.hashCode(this.f236769b)) * 31) + this.f236770c.hashCode()) * 31) + Float.floatToIntBits(this.f236771d)) * 31) + Float.floatToIntBits(this.f236772e)) * 31;
            if (this.f236773f == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "NameLabelLayout(rect=" + this.f236768a + ", radii=" + Arrays.toString(this.f236769b) + ", text=" + this.f236770c + ", textX=" + this.f236771d + ", baselineY=" + this.f236772e + ", flipped=" + this.f236773f + ')';
        }

        public c(RectF r100, float[] r101, CharSequence r102, float r103, float r104, boolean r105) {
            Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
            Intrinsics.checkNotNullParameter(r101, "radii");
            Intrinsics.checkNotNullParameter(r102, "text");
            this.f236768a = r100;
            this.f236769b = r101;
            this.f236770c = r102;
            this.f236771d = r103;
            this.f236772e = r104;
            this.f236773f = r105;
        }
    }

    public interface d {
        boolean a(CommentRectF r100);

        void b(CommentRectF r100);

        void c(CommentRectF r100);
    }

    static {
    }

    private final void p() {
        setWillNotDraw(false);
        this.V = AppCompatResources.getDrawable(getContext(), R.drawable.icon_image_area_mark_delete);
        this.T.setColor(getResources().getColor(R.color.gradient_yellow_0));
        this.T.setAntiAlias(true);
        this.T.setStyle(Paint.Style.FILL);
        this.U.setColor(-16777216);
        this.U.setAntiAlias(true);
        this.U.setTextSize(n.G(10));
        this.U.setTextAlign(Paint.Align.LEFT);
        this.U.setFakeBoldText(false);
        this.U.setStyle(Paint.Style.FILL);
        this.U.setSubpixelText(true);
        View r100 = this.f236784J;
        CommentRectLayout.b r101 = new b(this, getContext());
        r101.setEnabled(false);
        if (r100 == null) goto L5;
        int r102 = indexOfChild(r100);
        removeView(r100);
        addView(r101, r102);
    L6:
        setCommentRectLayoutDrawDelegate(r101);
        return;
    L5:
        addView(r101, 1);
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

    public CommentAreaMarkLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.T = new Paint();
        this.U = new TextPaint();
        this.H0 = AreaMarkMode.READ;
        p();
    }

    public final void A(CommentRectF r100) {
        this.f236763k0 = r100;
        CommentRectLayout.b r101 = this.f236784J;
        if (r101 == null) goto L5;
        r101.invalidate();
    L5:
        d r102 = this.f236764p0;
        if (r102 == null) goto L9;
        r102.b(r100);
        return;
    }

    public final RectF B(CommentRectF r100) {
        int r101 = CommentRectLayout.Q;
        float r102 = r101;
        float r103 = r102 / 2.0f;
        float r104 = ((RectF) r100).right - r103;
        float r105 = ((RectF) r100).bottom - r103;
        float r106 = r104 + r102;
        float r107 = r102 + r105;
        RectF r108 = getHostWholeRectF();
        float r109 = r108.right;
        if (r106 <= r109) goto L5;
        float r110 = r106 - r109;
        r104 = r104 - r110;
        r106 = r106 - r110;
    L5:
        float r111 = r108.bottom;
        if (r107 <= r111) goto L9;
        float r112 = r107 - r111;
        r105 = r105 - r112;
        r107 = r107 - r112;
    L9:
        return new RectF(r104, r105, r106, r107);
    }

    public final void setAreaMarkMode(AreaMarkMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mAreaMarkMode");
        this.H0 = r100;
    }

    public final void setCommentAreaMarkClickListener(d r100) {
        Intrinsics.checkNotNullParameter(r100, "areaMarkRectLayoutListener");
        this.f236764p0 = r100;
    }

    public final void setImageUUID(String r100) {
        this.W = r100;
    }

    public final c z(CommentRectF r210) {
        String r100 = r210.f236779f;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        tt5.a.k("CommentAreaMarkLayout", "computeNameLabelLayout() called with: text is empty");
        return null;
    L6:
        float r101 = n.d(6);
        float r102 = n.d(1);
        float r103 = n.d(16);
        Paint.FontMetrics r104 = this.U.getFontMetrics();
        float r105 = r104.bottom;
        float r106 = r104.top;
        float r107 = r103 + (2 * r102);
        float r108 = ((r107 - (r105 - r106)) / 2.0f) - r106;
        float r109 = this.U.measureText(r100, 0, r100.length()) + (2.0f * r101);
        float r110 = this.f236789e.getStrokeWidth() * 0.5f;
        float r111 = (float) Math.floor((((RectF) r210).left - r110) + 0.5f);
        float r112 = (float) Math.floor((((RectF) r210).top + r110) + 0.5f);
        float r113 = r112 - r107;
        float r114 = r109 + r111;
        if (r113 >= getHostWholeRectF().top) goto L9;
        boolean r115 = true;
    L10:
        if (r115 == true) goto L12;
        Triple r116 = new Triple(Float.valueOf(r113), Float.valueOf(r112), Float.valueOf(r114));
    L13:
        float r117 = ((Number) r116.component1()).floatValue();
        RectF r118 = new RectF(r111, r117, ((Number) r116.component3()).floatValue(), ((Number) r116.component2()).floatValue());
        float r119 = n.d(4);
        if (r115 == true) goto L16;
        float[] r120 = {r119, r119, r119, r119, 0.0f, 0.0f, 0.0f, 0.0f};
    L17:
        Intrinsics.checkNotNull(r100);
        return new c(r118, r120, r100, r111 + r101, r108 + r117, r115);
    L16:
        r120 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r119, r119, 0.0f, 0.0f};
        goto L17
    L12:
        float r121 = (float) Math.floor((((RectF) r210).top - r110) + 0.5f);
        r116 = new Triple(Float.valueOf(r121), Float.valueOf(r107 + r121), Float.valueOf(r114));
        goto L13
    L9:
        r115 = false;
        goto L10
    }

    public CommentAreaMarkLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.T = new Paint();
        this.U = new TextPaint();
        this.H0 = AreaMarkMode.READ;
        p();
    }

    public CommentAreaMarkLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.T = new Paint();
        this.U = new TextPaint();
        this.H0 = AreaMarkMode.READ;
        p();
    }

    public static final void y(CommentAreaMarkLayout r100, Canvas r110, CommentRectF r111) {
        if (r110 != null) goto L4;
        r100.getClass();
        tt5.a.k("CommentAreaMarkLayout", "drawTopLeftLabel() called with: canvas is null");
        return;
    L4:
        c r112 = r100.z(r111);
        if (r112 == null) goto L10;
        Path r101 = new Path();
        r101.addRoundRect(r112.f236768a, r112.f236769b, Path.Direction.CW);
        int r102 = r100.getResources().getColor(R.color.gradient_yellow_0);
        r100.T.setColor(r102);
        r100.T.setAlpha(255);
        r110.drawPath(r101, r100.T);
        CharSequence r103 = r112.f236770c;
        r110.drawText(r103, 0, r103.length(), r112.f236771d, r112.f236772e, r100.U);
        return;
    }
}
