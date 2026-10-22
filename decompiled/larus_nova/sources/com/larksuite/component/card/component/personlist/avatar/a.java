package com.larksuite.component.card.component.personlist.avatar;

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
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends ImageSpan implements com.larksuite.component.card.component.personlist.avatar.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f283475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f283476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f283477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f283478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f283479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f283480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f283481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f283482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f283483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f283484j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f283485k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AvatarImage f283486l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f283487m;

    /* JADX INFO: renamed from: com.larksuite.component.card.component.personlist.avatar.a$a, reason: collision with other inner class name */
    public static final class C3898a extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f283488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable f283489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Path f283490c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RectF f283491d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Paint f283492e;

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

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Drawable r101 = this.f283488a;
            if ((r101 instanceof BitmapDrawable) == true) goto L5;
            return;
        L5:
            Bitmap r102 = ((BitmapDrawable) r101).getBitmap();
            if (r102 != null) goto L8;
        L12:
            this.f283489b.draw(r100);
            return;
        L8:
            if (r102.isRecycled() == true) goto L12;
            int r103 = r100.getSaveCount();
            r100.save();
            this.f283490c.reset();
            this.f283490c.addOval(this.f283491d, Path.Direction.CW);
            r100.clipPath(this.f283490c);
            r100.drawBitmap(r102, null, this.f283491d, this.f283492e);
            r100.restoreToCount(r103);
        }

        public C3898a(Drawable r100, Drawable r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "srcDrawable");
            Intrinsics.checkNotNullParameter(r101, "placeHolder");
            this.f283488a = r100;
            this.f283489b = r101;
            this.f283490c = new Path();
            this.f283491d = new RectF(0.0f, 0.0f, r102, r102);
            this.f283492e = new Paint(2);
        }
    }

    public static final class b {
    }

    public final class c extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f283493a;

        public c(a r100) {
            this.f283493a = r100;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            super.onLoadFailed(r100);
            this.f283493a.f283487m = true;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Drawable r101 = (Drawable) r100;
            super.onResourceReady(r101);
            if (r101 == null) goto L5;
            a r102 = this.f283493a;
            C3898a r103 = new C3898a(r101, r102.f283476b, r102.f283477c);
            int r104 = this.f283493a.f283477c;
            r103.setBounds(0, 0, r104, r104);
            com.ss.android.lark.image.utils.e.b(this.f283493a, "mDrawable", r103);
            com.ss.android.lark.image.utils.e.b(this.f283493a, "mDrawableRef", null);
        L5:
            this.f283493a.f283487m = true;
            Lazy<SimpleUserLoader> r105 = SimpleUserLoader.f283460d;
            SimpleUserLoader r106 = SimpleUserLoader.a.a();
            String r107 = this.f283493a.f283482h;
            r106.getClass();
            Intrinsics.checkNotNullParameter(r107, "avatarKey");
            ArrayList r108 = (ArrayList) ((LinkedHashMap) r106.f283462b).get(r107);
            if (r108 == null) goto L13;
            Iterator r109 = r108.iterator();
        L9:
            if (r109.hasNext() == false) goto L19;
            com.larksuite.component.card.component.personlist.avatar.b r110 = (com.larksuite.component.card.component.personlist.avatar.b) ((WeakReference) r109.next()).get();
            if (r110 == null) goto L9;
            r110.a();
            goto L9
        L19:
            return;
        }
    }

    static {
    }

    public final void b() {
        if (TextUtils.isEmpty(this.f283482h) == false) goto L6;
        return;
    L6:
        if (this.f283486l != null) goto L8;
        String r100 = this.f283482h;
        String r101 = this.f283483i;
        int r102 = this.f283477c;
        this.f283486l = AvatarImage.Builder.obtain(r100, r101, r102, r102).build();
    L8:
        AvatarImage r103 = this.f283486l;
        if (r103 == null) goto L12;
        ImageLoader.with(this.f283475a).load(r103).placeholder(this.f283476b).asDrawable().into(new c(this));
        return;
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        if (this.f283482h.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        return super.getDrawable();
    L10:
        if (this.f283487m == true) goto L13;
        b();
    L13:
        return super.getDrawable();
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.larksuite.component.card.component.personlist.avatar.c
    public final void a(String r100, wy7.c r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "simpleUser");
        if (Intrinsics.areEqual(r100, this.f283483i) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.f283482h) == false) goto L11;
        String r102 = r101.f561885a;
        if (r102 == null) goto L12;
        this.f283482h = r102;
        b();
        return;
    L12:
        return;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Rect r105 = getDrawable().getBounds();
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = r106.bottom;
        int r108 = r106.top;
        int r109 = r107 - r108;
        int r110 = r106.ascent;
        int r111 = r108 - r110;
        int r112 = r107 - r106.descent;
        int r113 = r110 + (r109 / 2);
        int r114 = (r105.bottom - r105.top) / 2;
        int r115 = (r113 - r114) - this.f283481g;
        r104.ascent = r115;
        r104.top = r115 + r111;
        int r116 = r113 + r114;
        r104.descent = r116;
        r104.bottom = r116 + r112;
    L6:
        return (this.f283479e + r105.right) + this.f283480f;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r210, Paint r211) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "text");
        Intrinsics.checkNotNullParameter(r211, "paint");
        Drawable r100 = getDrawable();
        r110.save();
        Paint.FontMetricsInt r101 = r211.getFontMetricsInt();
        int r102 = r101.descent;
        int r103 = (r102 + r116) - ((r102 - r101.ascent) / 2);
        r110.translate(r114 + this.f283479e, r103 - ((r100.getBounds().bottom - r100.getBounds().top) / 2));
        r100.draw(r110);
        r110.restore();
        if (this.f283484j == false) goto L14;
        if (r112 < 0) goto L15;
        if (r113 < 0) goto L16;
        if (r112 <= r113) goto L8;
        return;
    L8:
        if (r113 > r111.length()) goto L18;
        r110.save();
        int r104 = this.f283478d;
        if (r104 <= 0) goto L12;
        r211.setTextSize(r104);
    L12:
        float r105 = ((r100.getBounds().right - r100.getBounds().left) / 2) - (r211.measureText(r111.subSequence(r112, r113).toString()) / 2);
        Paint.FontMetricsInt r106 = r211.getFontMetricsInt();
        int r117 = r106.descent;
        r110.translate(this.f283479e + r105, (r103 - r116) - (r117 - ((r117 - r106.ascent) / 2)));
        r211.setColor(this.f283485k);
        r110.drawText(r111, r112, r113, r114, r116, r211);
        r110.restore();
        return;
    L18:
        return;
    L16:
        return;
    L15:
        return;
    }

    public a(Context r100, Drawable r101, int r102, int r103, int r104, int r105, int r106, String r107, String r110, boolean r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "placeHolder");
        Intrinsics.checkNotNullParameter(r107, "avatarKey");
        super(r101);
        this.f283475a = r100;
        this.f283476b = r101;
        this.f283477c = r102;
        this.f283478d = r103;
        this.f283479e = r104;
        this.f283480f = r105;
        this.f283481g = r106;
        this.f283482h = r107;
        this.f283483i = r110;
        this.f283484j = r111;
        this.f283485k = r112;
        r101.setBounds(0, 0, r102, r102);
    }
}
