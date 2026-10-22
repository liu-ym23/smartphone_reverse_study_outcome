package com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.v0;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.utils.e;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f412652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f412653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.c f412654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f412655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f412656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f412657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f412658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f412659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f412660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f412661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f412662k;

    public static final class a extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f412663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable f412664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Path f412665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RectF f412666d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Paint f412667e;

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
            Drawable r101 = this.f412663a;
            if ((r101 instanceof BitmapDrawable) == true) goto L5;
            return;
        L5:
            Bitmap r102 = ((BitmapDrawable) r101).getBitmap();
            if (r102 != null) goto L8;
        L12:
            this.f412664b.draw(r100);
            return;
        L8:
            if (r102.isRecycled() == true) goto L12;
            int r103 = r100.getSaveCount();
            r100.save();
            this.f412665c.reset();
            this.f412665c.addOval(this.f412666d, Path.Direction.CW);
            r100.clipPath(this.f412665c);
            r100.drawBitmap(r102, null, this.f412666d, this.f412667e);
            r100.restoreToCount(r103);
        }

        public a(Drawable r100, Drawable r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "srcDrawable");
            Intrinsics.checkNotNullParameter(r101, "placeHolder");
            this.f412663a = r100;
            this.f412664b = r101;
            this.f412665c = new Path();
            this.f412666d = new RectF(0.0f, 0.0f, r102, r102);
            this.f412667e = new Paint(2);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.b$b, reason: collision with other inner class name */
    public static final class C4802b {
    }

    public final class c extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f412668a;

        public c(b r100) {
            this.f412668a = r100;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            super.onLoadFailed(r100);
            this.f412668a.f412662k = true;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Drawable r101 = (Drawable) r100;
            super.onResourceReady(r101);
            if (r101 == null) goto L5;
            b r102 = this.f412668a;
            a r103 = new a(r101, r102.f412653b, r102.f412656e);
            int r104 = this.f412668a.a();
            b r105 = this.f412668a;
            r103.setBounds(0, r104, r105.f412656e, r105.a() + this.f412668a.f412656e);
            e.b(this.f412668a, "mDrawable", r103);
            e.b(this.f412668a, "mDrawableRef", null);
        L5:
            b r106 = this.f412668a;
            r106.f412662k = true;
            r106.f412654c.a();
        }
    }

    static {
    }

    public final int a() {
        return ((Number) this.f412659h.getValue()).intValue();
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        if (this.f412662k == true) goto L6;
        ImageLoader.with(this.f412652a).load((AvatarImage) this.f412661j.getValue()).asDrawable().into(new c(this));
    L6:
        return super.getDrawable();
    }

    public b(Context r100, Drawable r101, v0 r102, int r103, int r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "placeHolder");
        Intrinsics.checkNotNullParameter(r102, "onAvatarReadyListener");
        Intrinsics.checkNotNullParameter(r105, "avatarKey");
        Intrinsics.checkNotNullParameter(r106, "entityId");
        super(r101);
        this.f412652a = r100;
        this.f412653b = r101;
        this.f412654c = r102;
        this.f412655d = r103;
        this.f412656e = r104;
        this.f412657f = r105;
        this.f412658g = r106;
        this.f412659h = LazyKt.lazy(new GroupAvatarSpan$top$2(this));
        this.f412660i = UIHelper.dp2px(1.0f);
        r101.setBounds(0, a(), r104, a() + r104);
        this.f412661j = LazyKt.lazy(new GroupAvatarSpan$avatarImage$2(this));
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Drawable r109 = getDrawable();
        r100.save();
        r100.translate(r104, ((r105 + ((r107 - r105) / 2)) - (r109.getBounds().height() / 2.0f)) + this.f412660i);
        r109.draw(r100);
        r100.restore();
    }
}
