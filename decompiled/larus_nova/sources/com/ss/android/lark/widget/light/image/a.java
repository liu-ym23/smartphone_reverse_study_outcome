package com.ss.android.lark.widget.light.image;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageGalleryUtil f446076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f446077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Rect> f446078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f446079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f446080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f446081f;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.light.image.a$a, reason: collision with other inner class name */
    public static final class C5395a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f446082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f446083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f446084c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f446085d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f446082a, r101.f446082a) == true) goto L12;
            return false;
        L12:
            if (this.f446083b == r101.f446083b) goto L15;
            return false;
        L15:
            if (this.f446084c == r101.f446084c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f446085d, r101.f446085d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f446082a.hashCode() * 31) + this.f446083b) * 31) + this.f446084c) * 31) + this.f446085d.hashCode();
        }

        public final String toString() {
            return "ImageData(key=" + this.f446082a + ", width=" + this.f446083b + ", height=" + this.f446084c + ", desc=" + this.f446085d + ')';
        }

        public b(String r100, int r101, int r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r103, SocialConstants.PARAM_APP_DESC);
            this.f446082a = r100;
            this.f446083b = r101;
            this.f446084c = r102;
            this.f446085d = r103;
        }
    }

    public interface c {
        void a(LKUIRoundedImageView2 r100, b r101);

        boolean b(LKUIRoundedImageView2 r100, b r101);
    }

    static {
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f446076a = new ImageGalleryUtil(r100);
        this.f446077b = new ArrayList();
        this.f446078c = new ArrayList();
        this.f446079d = new ArrayList();
    }

    public final void setData(List<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "datas");
        ((ArrayList) this.f446077b).clear();
        ArrayList r101 = (ArrayList) this.f446077b;
        r101.addAll(r100);
        ((ArrayList) this.f446078c).clear();
        List<Rect> r102 = this.f446078c;
        List<b> r103 = r100;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        b r106 = (b) r105.next();
        r104.add(new Rect(0, 0, r106.f446083b, r106.f446084c));
        goto L4
    L6:
        ((ArrayList) r102).addAll(r104);
        ((ArrayList) this.f446079d).clear();
        List<String> r107 = this.f446079d;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r109 = r103.iterator();
    L8:
        if (r109.hasNext() == false) goto L10;
        r108.add(((b) r109.next()).f446085d);
        goto L8
    L10:
        ((ArrayList) r107).addAll(r108);
        removeAllViews();
        this.f446080e = true;
        requestLayout();
    }

    public final void setOnItemViewClickListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f446081f = r100;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r210, int r211) {
        if (this.f446080e == true) goto L6;
    L7:
        a r100 = this;
        Size r101 = null;
    L84:
        if (r101 == null) goto L86;
        int r102 = View.MeasureSpec.makeMeasureSpec(r101.getWidth(), 1073741824);
    L87:
        super.onMeasure(r102, r211);
        return;
    L86:
        r102 = r210;
        goto L87
    L6:
        if (((ArrayList) this.f446077b).isEmpty() == true) goto L7;
        int r103 = View.MeasureSpec.getSize(r210);
        ImageGalleryUtil r110 = this.f446076a;
        List<Rect> r104 = this.f446078c;
        List<String> r105 = this.f446079d;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r104, "inputRect");
        Intrinsics.checkNotNullParameter(r105, "captionList");
        ArrayList r111 = (ArrayList) r104;
        if (r111.isEmpty() == false) goto L11;
        ImageGalleryUtil.b r106 = null;
    L70:
        if (r106 != null) goto L72;
        hac.b r107 = hac.b.f484427a;
        hac.c.a("ImageGalleryLayout", "calcImageViews: failed, images is empty");
        r101 = null;
        r100 = this;
        goto L84
    L72:
        Set r108 = CollectionsKt.toSet(r106.f446064c);
        Iterator<T> r109 = r106.f446062a.iterator();
        int r112 = 0;
    L74:
        if (r109.hasNext() == false) goto L83;
        Object r113 = r109.next();
        int r114 = r112 + 1;
        if (r112 >= 0) goto L78;
        CollectionsKt.throwIndexOverflow();
    L78:
        Rect r115 = (Rect) r113;
        b r116 = (b) ListProtector.get(this.f446077b, r112);
        boolean r117 = r108.contains(Integer.valueOf(r112));
        ImageGalleryItemView r118 = new ImageGalleryItemView(getContext(), null, 6, 0);
        r118.f446039a.setLayoutParams(new FrameLayout.LayoutParams(r115.width(), r115.height()));
        r118.setCaption(r116.f446085d);
        r118.setLongImageTextVisible(r117);
        LKUIRoundedImageView2 r119 = r118.f446039a;
        r119.setClickable(false);
        r119.setScaleType(ImageView.ScaleType.FIT_XY);
        r119.setOnClickListener(new com.ss.android.lark.widget.light.image.b(this, r119, r116));
        r119.setOnLongClickListener(new com.ss.android.lark.widget.light.image.c(this, r119, r116));
        ConcurrentHashMap<String, ImageGalleryLoaderAdapter.a> r120 = ImageGalleryLoaderAdapter.f446042a;
        Context r121 = getContext();
        int r122 = r115.width();
        int r123 = r115.height();
        String r124 = r116.f446082a;
        d r125 = new d(r116, r119);
        Intrinsics.checkNotNullParameter(r121, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r124, "key");
        Intrinsics.checkNotNullParameter(r125, PickerReporterConstants.KEY.TARGET);
        String r126 = r124 + "/_" + r122 + "/_" + r123;
        ImageGalleryLoaderAdapter.a r127 = ImageGalleryLoaderAdapter.f446042a.get(r126);
        if (r127 == null) goto L81;
        r127.f446045b.add(r125);
    L82:
        ViewGroup.MarginLayoutParams r128 = new ViewGroup.MarginLayoutParams(-2, -2);
        r128.leftMargin = r115.left;
        r128.topMargin = r115.top;
        r118.setLayoutParams(r128);
        addView(r118);
        r112 = r114;
        goto L74
    L81:
        ImageGalleryLoaderAdapter.a r129 = new ImageGalleryLoaderAdapter.a(r126);
        r129.f446045b.add(r125);
        ImageLoader.with(r121).sourceExecutor((GlideExecutor) ImageGalleryLoaderAdapter.f446043b.getValue()).load(new EncryptImage(r124)).override(r122, r123).into(r129);
        goto L82
    L83:
        r100 = this;
        r100.f446080e = false;
        r101 = r106.f446065d;
        goto L84
    L11:
        r110.f446061p = r105;
        double r130 = 1.0d;
        if (r111.size() != 1) goto L17;
        Rect r131 = (Rect) ListProtector.get(r111, 0);
        r110.d(r131.width(), r131.height(), 0, r110.f446059n, r110.f446057l, r110.f446047b);
        Rect r132 = (Rect) ListProtector.get(r110.f446054i, 0);
        int r133 = r132.width();
        r132.height();
        int r134 = r103 - ((0 - r110.f446059n) * r110.f446048c);
        if (r133 <= r134) goto L16;
        int r135 = MathKt.roundToInt(((((double) r134) * 1.0d) / ((double) r131.width())) * ((double) r131.height()));
        int r136 = r132.left;
        int r137 = r132.top;
        r132.set(r136, r137, r134 + r136, r135 + r137);
    L16:
        r110.f446056k.put(Integer.valueOf(r110.f446057l), 0);
        Size r138 = new Size(r103, (r110.b(r110.f446057l + 1) - r110.f446049d) + r110.f446048c);
    L69:
        r106 = new ImageGalleryUtil.b(r110.f446054i, r110.f446056k, r110.f446055j, r138);
        goto L70
    L17:
        r110.f446056k.put(Integer.valueOf(r110.f446057l), Integer.valueOf(r110.f446059n));
        int r139 = r111.size();
        int r140 = 0;
    L18:
        if (r140 >= r139) goto L68;
        Rect r141 = (Rect) ListProtector.get(r111, r140);
        Size r142 = new Size(r141.width(), r141.height());
        int r143 = r140;
        int r144 = r139;
        r110.d(r142.getWidth(), r142.getHeight(), r140, r110.f446059n, r110.f446057l, r110.f446058m);
        int r145 = r110.f446059n;
        int r146 = r143 + 1;
        int r147 = 0;
    L20:
        if (r145 >= r146) goto L22;
        r147 = r147 + RangesKt.coerceAtLeast(((Rect) ListProtector.get(r110.f446054i, r145)).width(), r110.f446050e);
        r145 = r145 + 1;
        goto L20
    L22:
        int r148 = r103 - ((r143 - r110.f446059n) * r110.f446048c);
        if (r147 <= r148) goto L57;
        double r149 = (((double) r148) * r130) / ((double) r147);
        LinkedHashMap r150 = new LinkedHashMap();
        int r151 = r110.f446059n;
    L25:
        if (r151 >= r146) goto L53;
        Rect r152 = (Rect) ListProtector.get(r110.f446054i, r151);
        double r153 = ((double) r152.width()) * r149;
        double r154 = ((double) r152.height()) * r149;
        int r155 = r110.f446059n;
        double r156 = r149;
        int r157 = 0;
    L27:
        if (r155 >= r151) goto L33;
        Rect r158 = (Rect) r150.get(Integer.valueOf(r155));
        if (r158 == null) goto L32;
        r157 = r157 + (RangesKt.coerceAtLeast(r158.width(), r110.f446050e) + r110.f446048c);
    L32:
        r155 = r155 + 1;
        r111 = r111;
        goto L27
    L33:
        ArrayList r212 = r111;
        r150.put(Integer.valueOf(r151), new Rect(r157, r152.top, r157 + MathKt.roundToInt(r153), r152.top + MathKt.roundToInt(r154)));
        double r159 = r110.f446050e;
        if (r154 < r159) goto L39;
        if (r153 < r159) goto L39;
        r151 = r151 + 1;
        r130 = 1.0d;
        r149 = r156;
        r111 = r212;
    L39:
        if (r154 < r159) goto L43;
        if (r153 < r159) goto L43;
    L45:
        int r160 = r146;
    L46:
        double r161 = 1.0d;
    L54:
        r110.e(r150, r110.f446059n, r160);
        if (r110.f446059n > r143) goto L58;
        r110.f446058m = ((Rect) ListProtector.get(r110.f446054i, r143)).height();
    L58:
        int r162 = r110.f446059n;
        if (r162 > r143) goto L67;
        int r163 = 0;
    L62:
        if (r162 >= r160) goto L65;
        r163 = r163 + RangesKt.coerceAtLeast(((Rect) ListProtector.get(r110.f446054i, r162)).width(), r110.f446050e);
        r162 = r162 + 1;
        goto L62
    L65:
        if (r163 != (r103 - ((r143 - r110.f446059n) * r110.f446048c))) goto L67;
        int r164 = r110.f446057l + 1;
        r110.f446057l = r164;
        r110.f446059n = r160;
        r110.f446058m = r110.f446047b;
        r110.f446056k.put(Integer.valueOf(r164), Integer.valueOf(r110.f446059n));
    L67:
        r130 = r161;
        r140 = r160;
        r139 = r144;
        r111 = r212;
    L43:
        if ((r143 - r110.f446059n) > 0) goto L47;
        r110.e(r150, r143, r146);
        r110.f446059n = r146;
        r110.c();
        goto L45
    L47:
        r150.clear();
        r110.f446059n = r143;
        r110.c();
        if (((ArrayList) r110.f446054i).size() < r146) goto L50;
        ListProtector.remove(r110.f446054i, r143);
    L50:
        r160 = r146;
        r110.d(r142.getWidth(), r142.getHeight(), r143, r110.f446059n, r110.f446057l, r110.f446058m);
        Rect r165 = (Rect) ListProtector.get(r110.f446054i, r143);
        int r166 = r165.width();
        r165.height();
        int r167 = r103 - ((r143 - r110.f446059n) * r110.f446048c);
        if (r166 <= r167) goto L46;
        r161 = 1.0d;
        int r168 = MathKt.roundToInt(((((double) r167) * 1.0d) / ((double) r142.getWidth())) * ((double) r142.getHeight()));
        int r169 = r165.left;
        int r170 = r165.top;
        r165.set(r169, r170, r167 + r169, r168 + r170);
        r110.f446059n = r160;
        r110.c();
        goto L54
    L53:
        r212 = r111;
        r161 = r130;
        r160 = r146;
        goto L54
    L57:
        r212 = r111;
        r161 = r130;
        r160 = r146;
        goto L58
    L68:
        r138 = new Size(r103, r110.b(r110.f446057l + 1) - r110.a(4.0f));
        goto L69
    }
}
