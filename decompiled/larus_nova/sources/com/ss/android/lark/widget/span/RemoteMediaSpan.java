package com.ss.android.lark.widget.span;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.utils.UIHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public final class RemoteMediaSpan extends n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f448600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f448601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f448602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f448603j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BorderProperty f448604k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f448605l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f448606m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public v.b f448607n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final v.a f448608o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f448609p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f448610q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ByteString f448611r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f448612s;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
        public static final int BOTTOM_LEFT = 1;
        public static final int BOTTOM_RIGHT = 2;
        public static final int CENTER = 0;
    }

    public class a extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RemoteMediaSpan f448613a;

        public a(RemoteMediaSpan r100) {
            this.f448613a = r100;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            super.onLoadFailed(r100);
            RemoteMediaSpan r101 = this.f448613a;
            r101.getClass();
            GradientDrawable r102 = new GradientDrawable();
            r102.setShape(0);
            BorderProperty r103 = r101.f448604k;
            if (r103 == null) goto L5;
            r102.setStroke(r103.getBorderWidthPx(), r101.f448604k.getBorderColor());
            r102.setCornerRadius(r101.f448604k.getBorderRadiusPx());
        L5:
            r102.setColor(UIUtils.getColor(r101.f448600g, R.color.ud_N200));
            r102.setSize(r101.f448602i, r101.f448603j);
            RemoteMediaSpan r104 = this.f448613a;
            r102.setBounds(0, 0, r104.f448602i, r104.f448603j);
            RemoteMediaSpan r105 = this.f448613a;
            Bitmap r106 = Bitmap.createBitmap(r105.f448602i, r105.f448603j, Bitmap.Config.ARGB_8888);
            r102.draw(new Canvas(r106));
            Bitmap r107 = scc.a.c(r106, BitmapFactory.decodeResource(this.f448613a.f448600g.getResources(), R.drawable.ic_richtext_media_play), 0);
            RemoteMediaSpan r108 = this.f448613a;
            if (r108.f448612s == false) goto L8;
            r107 = scc.a.a(r107, UIUtils.getString(r108.f448600g, R.string.Lark_IM_FileExpiredByAdmin_Label), -1, -1);
        L8:
            BitmapDrawable r109 = new BitmapDrawable(this.f448613a.f448600g.getResources(), r107);
            RemoteMediaSpan r110 = this.f448613a;
            Drawable r111 = l.a(r109, r110.f448602i, r110.f448603j, r110.f448604k);
            RemoteMediaSpan r112 = this.f448613a;
            r111.setBounds(0, 0, r112.f448602i, r112.f448603j);
            RemoteMediaSpan r113 = this.f448613a;
            r113.getClass();
            Intrinsics.checkNotNullParameter(r111, "drawable");
            r113.f448712e = r111;
            RemoteMediaSpan r114 = this.f448613a;
            r114.f448609p = true;
            v.b r115 = r114.f448607n;
            if (r115 == null) goto L12;
            r115.onLoadFailed();
            return;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Drawable r101 = (Drawable) r100;
            super.onResourceReady(r101);
            Bitmap r102 = scc.a.c(((BitmapDrawable) r101).getBitmap(), BitmapFactory.decodeResource(this.f448613a.f448600g.getResources(), R.drawable.ic_richtext_media_play), 0);
            RemoteMediaSpan r103 = this.f448613a;
            if (r103.f448612s == false) goto L5;
            Bitmap r104 = scc.a.a(r102, UIUtils.getString(r103.f448600g, R.string.Lark_IM_FileExpiredByAdmin_Label), -1, -1);
        L6:
            BorderProperty r105 = this.f448613a.f448604k;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            RemoteMediaSpan r107 = this.f448613a;
            r107.f448604k = new BorderProperty(UIHelper.getColor(R.color.line_border_card), UIHelper.dp2px(0.5f), r106);
            BitmapDrawable r108 = new BitmapDrawable(this.f448613a.f448600g.getResources(), r104);
            RemoteMediaSpan r109 = this.f448613a;
            Drawable r110 = l.a(r108, r109.f448602i, r109.f448603j, r109.f448604k);
            RemoteMediaSpan r111 = this.f448613a;
            r110.setBounds(0, 0, r111.f448602i, r111.f448603j);
            RemoteMediaSpan r112 = this.f448613a;
            r112.getClass();
            Intrinsics.checkNotNullParameter(r110, "drawable");
            r112.f448712e = r110;
            RemoteMediaSpan r113 = this.f448613a;
            r113.f448609p = true;
            v.b r114 = r113.f448607n;
            if (r114 == null) goto L14;
            r114.a();
            return;
        L14:
            return;
        L9:
            r106 = r105.getBorderRadiusPx();
            goto L10
        L5:
            r104 = scc.a.b(r102, r103.f448606m, 2);
            goto L6
        }
    }

    public static class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static x f448614g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f448615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f448616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public BorderProperty f448617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f448618d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public v.a f448619e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f448620f;

        public b() {
        }

        /* JADX WARN: Type inference failed for: r1v5, types: [com.ss.android.lark.widget.span.x] */
        public final RemoteMediaSpan a(Context r110, String r111, String r112, String r113, ByteString r210, boolean r211) {
            if (this.f448618d != null) goto L9;
            GradientDrawable r100 = new GradientDrawable();
            r100.setShape(0);
            r100.setColor(UIHelper.getColor(R.color.bg_body_overlay));
            BorderProperty r101 = this.f448617c;
            if (r101 == null) goto L7;
            r100.setStroke(r101.getBorderWidthPx(), this.f448617c.getBorderColor());
            r100.setCornerRadius(this.f448617c.getBorderRadiusPx());
        L7:
            r100.setSize(this.f448615a, this.f448616b);
            r100.setBounds(0, 0, this.f448615a, this.f448616b);
            this.f448618d = r100;
        L9:
            if (this.f448619e != null) goto L15;
            if (f448614g != null) goto L13;
            f448614g = new x();
        L13:
            this.f448619e = f448614g;
        L15:
            return new RemoteMediaSpan(r110, r111, r112, this.f448615a, this.f448616b, this.f448617c, this.f448620f, this.f448618d, this.f448619e, r113, r210, r211);
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f448601h, Integer.valueOf(this.f448602i), Integer.valueOf(this.f448603j), this.f448604k, this.f448606m});
    }

    @Override // com.ss.android.lark.widget.span.n
    public final Drawable a() {
        if (this.f448609p == true) goto L8;
        Context r100 = this.f448600g;
        if (r100 == null) goto L8;
        this.f448608o.a(r100, this.f448601h, this.f448602i, this.f448603j, null, this.f448605l, this.f448611r, this.f448610q, 0, null, new a(this));
    L8:
        return super.a();
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof RemoteMediaSpan) == true) goto L8;
        return false;
    L8:
        RemoteMediaSpan r101 = (RemoteMediaSpan) r100;
        if (TextUtils.equals(this.f448601h, r101.f448601h) == true) goto L11;
    L19:
        return false;
    L11:
        if (TextUtils.equals(this.f448606m, r101.f448606m) == false) goto L19;
        if (this.f448602i != r101.f448602i) goto L19;
        if (this.f448603j != r101.f448603j) goto L19;
        if (this.f448604k.equals(r101.f448604k) == false) goto L19;
        return true;
    }

    public RemoteMediaSpan(Context r100, String r101, String r102, int r103, int r104, BorderProperty r105, String r106, Drawable r107, v.a r108, String r110, ByteString r111, boolean r112) {
        super(r107);
        this.f448600g = r100;
        this.f448601h = r101;
        this.f448606m = r102;
        this.f448602i = r103;
        this.f448603j = r104;
        this.f448604k = r105;
        this.f448605l = r106;
        this.f448607n = null;
        this.f448608o = r108;
        this.f448610q = r110;
        this.f448611r = r111;
        this.f448612s = r112;
    }
}
