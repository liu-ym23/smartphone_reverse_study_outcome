package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.BorderProperty;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f416168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f416169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f416170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f416171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f416172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f416173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f416174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f416175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Drawable f416176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ThemeColor f416177j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f416178k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public InterfaceC4870a f416179l;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.preview.components.view.a$a, reason: collision with other inner class name */
    public interface InterfaceC4870a {
        void a();

        void onLoadFailed();
    }

    public static final class b extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<a> f416180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f416181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f416182c;

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, "errorDrawable");
            super.onLoadFailed(r100);
            a r101 = this.f416180a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            r100.setBounds(0, 0, this.f416181b, this.f416182c);
            com.ss.android.lark.image.utils.e.b(r101, "mDrawable", r100);
            com.ss.android.lark.image.utils.e.b(r101, "mDrawableRef", null);
            if (r101.f416178k == true) goto L10;
            InterfaceC4870a r102 = r101.f416179l;
            if (r102 == null) goto L10;
            r102.onLoadFailed();
        L10:
            r101.f416178k = true;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r110) {
            Drawable r111 = (Drawable) r110;
            Intrinsics.checkNotNullParameter(r111, "resource");
            super.onResourceReady(r111);
            a r100 = this.f416180a.get();
            if (r100 == null) goto L28;
            a r101 = this.f416180a.get();
            if (r101 == null) goto L14;
            ThemeColor r102 = r101.f416177j;
            if (r102 == null) goto L14;
            r111.mutate();
            a r103 = this.f416180a.get();
            if (r103 == null) goto L12;
            Context r104 = r103.getContext();
        L13:
            Intrinsics.checkNotNull(r104);
            r111.setTint(com.ss.android.lark.export.entity.preview.a.a(r102, r104, null));
            goto L14
        L12:
            r104 = null;
        L14:
            a r105 = this.f416180a.get();
            if (r105 == null) goto L23;
            Context r106 = r105.getContext();
            if (r106 == null) goto L23;
            Resources r107 = r106.getResources();
            if (r107 == null) goto L23;
            if ((r111 instanceof BitmapDrawable) == false) goto L23;
            r111 = new e(r107, (BitmapDrawable) r111, new BorderProperty(0, 0, UIHelper.dp2px(2.0f)), this.f416181b, this.f416182c);
        L23:
            r111.setBounds(0, 0, this.f416181b, this.f416182c);
            com.ss.android.lark.image.utils.e.b(r100, "mDrawable", r111);
            com.ss.android.lark.image.utils.e.b(r100, "mDrawableRef", null);
            r100.f416178k = true;
            InterfaceC4870a r112 = r100.f416179l;
            if (r112 == null) goto L27;
            r112.a();
            return;
        L27:
            return;
        }

        public b(WeakReference<a> r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "drawableSpanRef");
            this.f416180a = r100;
            this.f416181b = r101;
            this.f416182c = r102;
        }
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        if (TextUtils.isEmpty(this.f416169b) == false) goto L11;
        if (TextUtils.isEmpty(this.f416170c) == false) goto L11;
        if (TextUtils.isEmpty(this.f416171d) == false) goto L11;
        return super.getDrawable();
    L11:
        if (this.f416178k == true) goto L57;
        String r100 = this.f416171d;
        boolean r101 = true;
        if (r100 != null) goto L15;
    L18:
        boolean r102 = true;
    L19:
        if (r102 == true) goto L31;
        int r103 = edb.a.f472252a;
        int r104 = edb.a.a(this.f416171d);
        if (r104 == 0) goto L57;
        Drawable r105 = this.f416168a.getResources().getDrawable(r104, null);
        if (r105 != null) goto L25;
    L27:
        Intrinsics.checkNotNull(r105);
        r105.setBounds(0, 0, this.f416172e, this.f416173f);
        com.ss.android.lark.image.utils.e.b(this, "mDrawable", r105);
        com.ss.android.lark.image.utils.e.b(this, "mDrawableRef", null);
        InterfaceC4870a r106 = this.f416179l;
        if (r106 == null) goto L30;
        r106.a();
    L30:
        this.f416178k = true;
        goto L57
    L25:
        if (this.f416177j == null) goto L27;
        r105.mutate();
        ThemeColor r107 = this.f416177j;
        Intrinsics.checkNotNull(r107);
        r105.setTint(com.ss.android.lark.export.entity.preview.a.a(r107, this.f416168a, null));
        goto L27
    L31:
        IRequestCreator r108 = ImageLoader.with(this.f416168a);
        String r109 = this.f416169b;
        if (r109 != null) goto L34;
    L37:
        boolean r110 = true;
    L38:
        if (r110 == false) goto L52;
        String r111 = this.f416170c;
        if (r111 != null) goto L42;
    L45:
        if (r101 == true) goto L47;
        IRequestCreator r112 = r108.load(this.f416170c).diskCacheStrategy(DiskCacheStrategy.RESULT);
        g6b.a.InterfaceC5990a r113 = g6b.a.f480178a;
        if (r113 == null) goto L51;
        r113.c();
    L51:
        r112.isAsync(false).placeholder(this.f416176i).centerCrop().dontAnimate(false).override(this.f416172e, this.f416173f).into(new b(new WeakReference(this), this.f416172e, this.f416173f));
        goto L57
    L47:
        return super.getDrawable();
    L42:
        if (r111.length() == 0) goto L45;
        r101 = false;
        goto L45
    L52:
        String r114 = this.f416169b;
        Intrinsics.checkNotNull(r114);
        IRequestCreator r115 = r108.load(new EncryptImage(r114));
        g6b.a.InterfaceC5990a r116 = g6b.a.f480178a;
        if (r116 == null) goto L55;
        r116.c();
    L55:
        r115.isAsync(false).placeholder(this.f416176i).centerCrop().dontAnimate(false).override(this.f416172e, this.f416173f).into(new b(new WeakReference(this), this.f416172e, this.f416173f));
        goto L57
    L34:
        if (r109.length() == 0) goto L37;
        r110 = false;
        goto L38
    L15:
        if (r100.length() == 0) goto L18;
        r102 = false;
    L57:
        return super.getDrawable();
    }

    public final Context getContext() {
        return this.f416168a;
    }

    public /* synthetic */ a(Context r100, int r101, int r110, int r111, Drawable r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Rect r105 = getDrawable().getBounds();
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = r106.bottom - r106.top;
        int r108 = (r105.bottom - r105.top) / 2;
        int r109 = r107 / 4;
        int r110 = r108 - r109;
        int r111 = -(r108 + r109);
        r104.ascent = r111;
        r104.top = r111;
        r104.bottom = r110;
        r104.descent = r110;
    L6:
        return (this.f416174g + this.f416172e) + this.f416175h;
    }

    public a(Context r100, int r101, int r102, int r103, Drawable r104, ThemeColor r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "placeHolder");
        super(r104);
        this.f416168a = r100;
        this.f416169b = null;
        this.f416170c = null;
        this.f416171d = null;
        this.f416172e = r101;
        this.f416173f = r102;
        this.f416174g = r103;
        this.f416175h = 0;
        this.f416176i = r104;
        this.f416177j = r105;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        float r109 = this.f416174g + r104;
        Paint.FontMetricsInt r110 = r108.getFontMetricsInt();
        int r111 = r107 - r105;
        int r112 = r110.bottom - r110.top;
        if (r111 <= r112) goto L5;
        int r113 = (r111 - r112) / 2;
    L6:
        int r114 = (r105 + r113) + ((r111 - getDrawable().getBounds().height()) / 2);
        r100.save();
        r100.translate(r109, r114);
        getDrawable().draw(r100);
        r100.restore();
        return;
    L5:
        r113 = 0;
        goto L6
    }
}
