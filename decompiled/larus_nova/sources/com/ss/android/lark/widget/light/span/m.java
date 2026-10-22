package com.ss.android.lark.widget.light.span;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import androidx.exifinterface.media.ExifInterface;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.PersonInfo;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
public final class m extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PersonInfo f446252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f446253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f446254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AvatarImage f446255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f446256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f446257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f446258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f446259i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f446260j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f446261k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f446262l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f446263m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f446264n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f446265o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f446266p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f446267q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f446268r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f446269s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f446270t;

    public static final class a extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f446271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable f446272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Path f446273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RectF f446274d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Paint f446275e;

        @Override // android.graphics.drawable.Drawable
        @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.TRANSLUCENT", imports = {"android.graphics.PixelFormat"}))
        public final int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int r100) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter r100) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Drawable r101 = this.f446271a;
            if ((r101 instanceof BitmapDrawable) == true) goto L5;
            return;
        L5:
            Bitmap r102 = ((BitmapDrawable) r101).getBitmap();
            if (r102 != null) goto L8;
        L12:
            this.f446272b.draw(r100);
            return;
        L8:
            if (r102.isRecycled() == true) goto L12;
            int r103 = r100.getSaveCount();
            r100.save();
            this.f446273c.reset();
            this.f446273c.addOval(this.f446274d, Path.Direction.CW);
            r100.clipPath(this.f446273c);
            r100.drawBitmap(r102, null, this.f446274d, this.f446275e);
            r100.restoreToCount(r103);
        }

        public a(Drawable r100, Drawable r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "srcDrawable");
            Intrinsics.checkNotNullParameter(r101, "placeHolder");
            this.f446271a = r100;
            this.f446272b = r101;
            this.f446273c = new Path();
            this.f446274d = new RectF(0.0f, 0.0f, r102, r102);
            this.f446275e = new Paint(2);
        }
    }

    public final class b extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f446276a;

        public b(m r100) {
            this.f446276a = r100;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            super.onLoadFailed(r100);
            this.f446276a.f446268r = true;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Drawable r101 = (Drawable) r100;
            super.onResourceReady(r101);
            if (r101 == null) goto L5;
            m r102 = this.f446276a;
            a r103 = new a(r101, r102.f446253c, r102.f446257g);
            int r104 = this.f446276a.f446257g;
            r103.setBounds(0, 0, r104, r104);
            com.ss.android.lark.image.utils.e.b(this.f446276a, "mDrawable", r103);
            com.ss.android.lark.image.utils.e.b(this.f446276a, "mDrawableRef", null);
        L5:
            this.f446276a.f446268r = true;
        }
    }

    public final void a() {
        String r100 = this.f446254d;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        if (this.f446258h == true) goto L14;
        return;
    L14:
        if (this.f446255e != null) goto L16;
        String r102 = this.f446254d;
        String r103 = this.f446256f;
        int r104 = this.f446257g;
        this.f446255e = AvatarImage.Builder.obtain(r102, r103, r104, r104).build();
    L16:
        AvatarImage r105 = this.f446255e;
        if (r105 == null) goto L21;
        ImageLoader.with(this.f446251a).load(r105).placeholder(this.f446253c).asDrawable().into(new b(this));
        return;
    L21:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        String r100 = this.f446254d;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L19;
        if (this.f446258h == false) goto L19;
        if (this.f446268r == true) goto L17;
        a();
    L17:
        return super.getDrawable();
    L19:
        return super.getDrawable();
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final Context getContext() {
        return this.f446251a;
    }

    public final void b(Paint r100) {
        int r101 = this.f446252b.textColor;
        if (r101 == 0) goto L5;
        r100.setColor(r101);
    L5:
        int r102 = this.f446252b.textSize;
        if (r102 <= (-1)) goto L9;
        r100.setTextSize(r102);
    L9:
        if (this.f446252b.isItalic == false) goto L12;
        r100.setTextSkewX(-0.25f);
    L12:
        if (this.f446252b.isBold == false) goto L15;
        r100.setFakeBoldText(true);
    L15:
        if (this.f446252b.isUnderlineText == false) goto L18;
        r100.setUnderlineText(true);
    L18:
        if (this.f446252b.isStrikeThruText == false) goto L21;
        r100.setStrikeThruText(true);
        return;
    }

    public m(Context r100, PersonInfo r101, Drawable r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "personInfo");
        Intrinsics.checkNotNullParameter(r102, "placeHolder");
        super(r102);
        this.f446251a = r100;
        this.f446252b = r101;
        this.f446253c = r102;
        this.f446254d = r101.getAvatarKey();
        this.f446256f = r101.getUserId();
        int r103 = UIHelper.dp2px(r101.getAvatarSize());
        this.f446257g = r103;
        boolean r104 = r101.getShowAvatar();
        this.f446258h = r104;
        boolean r105 = r101.getShowName();
        this.f446259i = r105;
        this.f446260j = r101.getStyleType();
        this.f446261k = UIHelper.dp2px(r101.getContainerPadding()[1].intValue());
        this.f446262l = UIHelper.dp2px(r101.getContainerPadding()[3].intValue());
        int r106 = UIHelper.dp2px(r101.getLineHeight());
        this.f446263m = r106;
        this.f446264n = r106;
        if (r104 == false) goto L6;
        if (r105 == false) goto L6;
        int r107 = UIHelper.dp2px(4.0f);
    L7:
        this.f446265o = r107;
        this.f446266p = UIHelper.dp2px(4.0f);
        this.f446267q = UIHelper.dp2px(2.0f);
        UIHelper.dp2px(1.0f);
        a();
        getDrawable().setBounds(0, 0, r103, r103);
        return;
    L6:
        r107 = 0;
        goto L7
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        b(r100);
        boolean r105 = false;
        if (this.f446259i == false) goto L5;
        int r106 = (int) r100.measureText(r101, r102, r103);
    L7:
        if (this.f446258h == false) goto L9;
        int r107 = this.f446257g;
    L10:
        int r108 = (((r106 + this.f446262l) + this.f446261k) + r107) + this.f446265o;
        if (this.f446252b.isItalic == false) goto L13;
        r108 = r108 + this.f446266p;
    L13:
        float r109 = this.f446269s;
        if (r109 != 0.0f) goto L16;
        r105 = true;
    L16:
        if (r105 == false) goto L18;
        return r108;
    L18:
        if (r108 <= r109) goto L22;
        this.f446270t = true;
        return MathKt.roundToInt(r109);
    L22:
        return r108;
    L9:
        r107 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L7
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r210, int r211, int r212, int r213, Paint r214) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r214, "paint");
        b(r214);
        Paint.FontMetricsInt r100 = r214.getFontMetricsInt();
        Rect r101 = new Rect();
        r214.getTextBounds(ExifInterface.GPS_DIRECTION_TRUE, 0, 1, r101);
        int r102 = r101.top;
        int r103 = (r212 + r102) + ((r101.bottom - r102) / 2);
        if (Intrinsics.areEqual(this.f446260j, PersonInfo.TYPE_CAPSULE) == false) goto L19;
        if (this.f446259i == false) goto L19;
        Paint r104 = new Paint();
        r104.setColor(UIHelper.getColor(R.color.udtoken_tag_neutral_bg_normal));
        if (this.f446270t == false) goto L9;
        float r105 = this.f446269s;
    L10:
        float r106 = r210 + r105;
        if (this.f446252b.isItalic == false) goto L13;
        float r107 = r210 + this.f446266p;
    L14:
        int r108 = this.f446263m;
        int r109 = (r108 / 2) + r103;
        if (r109 <= r213) goto L17;
        r109 = r213;
    L17:
        RectF r114 = new RectF(new Rect((int) r107, r109 - r108, (int) r106, r109));
        int r115 = this.f446264n;
        r110.drawRoundRect(r114, r115, r115, r104);
        goto L19
    L13:
        r107 = r210;
        goto L14
    L9:
        r105 = getSize(r214, r111, r112, r113, r100);
    L19:
        if (this.f446258h == false) goto L24;
        r110.save();
        float r116 = r103 - (this.f446257g / 2);
        float r117 = r210 + this.f446262l;
        if (this.f446252b.isItalic == false) goto L23;
        r117 = r117 + this.f446266p;
    L23:
        r110.translate(r117, r116);
        getDrawable().draw(r110);
        r110.restore();
    L24:
        if (r111 != null) goto L26;
        return;
    L26:
        if (this.f446259i == false) goto L48;
        r110.save();
        if (this.f446258h == false) goto L30;
        int r118 = (this.f446262l + this.f446257g) + this.f446265o;
    L32:
        if (this.f446252b.isItalic == false) goto L34;
        r118 = r118 + this.f446267q;
    L34:
        r110.translate(r118, 0.0f);
        if (this.f446270t == false) goto L44;
        TextPaint r119 = new TextPaint();
        b(r119);
        if (this.f446258h == false) goto L39;
        float r120 = ((this.f446269s - this.f446262l) - this.f446261k) - this.f446257g;
        int r121 = this.f446265o;
    L40:
        float r122 = r120 - r121;
        if (this.f446252b.isItalic == false) goto L43;
        r122 = r122 - this.f446266p;
    L43:
        CharSequence r123 = TextUtils.ellipsize(r111.subSequence(r112, r113).toString(), r119, r122, TextUtils.TruncateAt.END);
        r110.drawText(r123, 0, r123.length(), r210, r212, r214);
    L45:
        r110.restore();
        return;
    L39:
        r120 = this.f446269s - this.f446262l;
        r121 = this.f446261k;
        goto L40
    L44:
        r110.drawText(r111, r112, r113, r210, r212, r214);
        goto L45
    L30:
        r118 = this.f446262l;
        goto L32
    }
}
