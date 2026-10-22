package com.ss.android.lark.widget.span;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.TextUtils;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.transformation.BorderTransformation;
import com.ss.android.lark.widget.transformation.FullWidthImageTransformation;
import com.ss.android.lark.widget.transformation.LargeImageTransformation;
import com.ss.android.lark.widget.transformation.WhiteBgTransformation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jp.wasabeef.glide.transformations.CropTransformation;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public final class v extends n {
    public final boolean A;
    public final int B;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f448783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f448784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f448785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f448786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f448787k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f448788l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f448789m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f448790n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final BorderProperty f448791o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f448792p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f448793q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ByteString f448794r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f448795s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ByteString f448796t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f448797u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a f448798v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f448799w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f448800x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f448801y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f448802z;

    public interface a {
        void a(Context r100, String r101, int r102, int r103, ByteString r104, String r105, ByteString r106, String r107, int r108, List r110, SimpleTarget r111);
    }

    public interface b {
        void a();

        void onLoadFailed();
    }

    public static class c {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static w f448803u;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f448804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f448805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f448806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f448807d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f448808e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f448809f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public BorderProperty f448810g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Drawable f448811h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public b f448812i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public a f448813j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f448814k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public ByteString f448815l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Boolean f448816m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public ByteString f448817n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f448818o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f448819p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f448820q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f448821r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f448822s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f448823t;

        public c() {
            this.f448816m = Boolean.TRUE;
            this.f448819p = 0;
            this.f448821r = 0;
            this.f448822s = false;
            this.f448823t = false;
        }

        /* JADX WARN: Type inference failed for: r1v5, types: [com.ss.android.lark.widget.span.w] */
        public final v a(Context r210, String r211) {
            if (this.f448811h != null) goto L16;
            GradientDrawable r100 = new GradientDrawable();
            r100.setShape(0);
            r100.setColor(UIUtils.getColor(r210, R.color.bg_body_overlay));
            BorderProperty r101 = this.f448810g;
            if (r101 == null) goto L7;
            r100.setStroke(r101.getBorderWidthPx(), this.f448810g.getBorderColor());
            r100.setCornerRadius(this.f448810g.getBorderRadiusPx());
        L7:
            int r102 = this.f448806c;
            if (r102 == 0) goto L12;
            int r103 = this.f448807d;
            if (r103 == 0) goto L12;
            r100.setSize(r102, r103);
            r100.setBounds(0, 0, this.f448806c, this.f448807d);
        L13:
            this.f448811h = r100;
        L12:
            r100.setSize(this.f448804a, this.f448805b);
            r100.setBounds(0, 0, this.f448804a, this.f448805b);
        L16:
            if (this.f448813j != null) goto L22;
            if (f448803u != null) goto L20;
            f448803u = new w();
        L20:
            this.f448813j = f448803u;
        L22:
            return new v(r210, r211, this.f448804a, this.f448805b, this.f448806c, this.f448807d, this.f448808e, this.f448809f, this.f448810g, this.f448814k, this.f448816m.booleanValue(), this.f448815l, this.f448818o, this.f448817n, this.f448811h, this.f448813j, this.f448812i, this.f448820q, this.f448821r, this.f448822s, this.f448823t, this.f448819p);
        }
    }

    public class d extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f448824a;

        public d(v r100) {
            this.f448824a = r100;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            super.onLoadFailed(r100);
            v r101 = this.f448824a;
            int r102 = r101.f448787k;
            if (r102 != 0) goto L5;
        L7:
            int r103 = r101.f448785i;
        L8:
            if (r102 == 0) goto L12;
            int r104 = r101.f448788l;
            if (r104 == 0) goto L12;
        L14:
            if (xbc.a.a().isMessageNoTraceDelete(this.f448824a.f448792p) == false) goto L19;
            int r105 = a0.f448627a;
            String r106 = UIHelper.getString(R.string.Lark_IM_ThreadDeletedImageGone_Placeholder);
            TextLayoutBuilder r107 = new TextLayoutBuilder();
            r107.h(r106);
            r107.i(UIHelper.getColor(R.color.text_placeholder));
            r107.j(UIHelper.dp2px(12.0f));
            r107.f(r103 - (UIHelper.dp2px(5.0f) * 2));
            r107.c(Layout.Alignment.ALIGN_CENTER);
            Layout r108 = r107.a();
            Bitmap r109 = Bitmap.createBitmap(r103, r104, Bitmap.Config.ARGB_8888);
            Canvas r110 = new Canvas(r109);
            int r111 = com.ss.android.lark.widget.light.layout.e.b(r108);
            float r112 = (r104 - com.ss.android.lark.widget.light.layout.e.a(r108)) / 2.0f;
            r110.save();
            r110.translate((r103 - r111) / 2.0f, r112);
            if (r108 == null) goto L18;
            r108.draw(r110);
        L18:
            r110.restore();
            Drawable r113 = new BitmapDrawable(UIHelper.getContext().getResources(), r109);
        L20:
            Drawable r114 = l.a(r113, r103, r104, this.f448824a.f448791o);
            r114.setBounds(0, 0, r103, r104);
            v r115 = this.f448824a;
            if (r115.f448793q == true) goto L23;
        L25:
            v r116 = this.f448824a;
            r116.f448799w = true;
            b r117 = r116.f448797u;
            if (r117 == null) goto L29;
            r117.onLoadFailed();
            return;
        L29:
            return;
        L23:
            if (r115.f448794r != null) goto L25;
            Intrinsics.checkNotNullParameter(r114, "drawable");
            r115.f448712e = r114;
            goto L25
        L19:
            r113 = UIHelper.getDrawable(R.drawable.ic_richtext_failed);
        L12:
            r104 = r101.f448786j;
            goto L14
        L5:
            if (r101.f448788l == 0) goto L7;
            r103 = r102;
            goto L8
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r110) {
            Drawable r111 = (Drawable) r110;
            super.onResourceReady(r111);
            v r100 = this.f448824a;
            int r101 = r100.f448787k;
            if (r101 != 0) goto L5;
        L7:
            int r102 = r100.f448785i;
        L8:
            if (r101 == 0) goto L12;
            int r103 = r100.f448788l;
            if (r103 == 0) goto L12;
        L13:
            boolean r104 = r111 instanceof GifDrawable;
            if (r104 == false) goto L16;
        L23:
            if (r104 == false) goto L25;
            Bitmap r112 = ((GifDrawable) r111).getFirstFrame();
        L26:
            v r105 = this.f448824a;
            if (r105.A == false) goto L29;
            String r106 = UIUtils.getString(r105.f448783g, R.string.Lark_IM_FileExpiredByAdmin_Label);
            v r107 = this.f448824a;
            Bitmap r108 = scc.a.a(r112, r106, r107.f448787k, r107.f448788l);
        L30:
            if (r108 != null) goto L32;
            Application r109 = scc.a.f541411a;
            Intrinsics.checkNotNullParameter(r112, "srcBitmap");
            r108 = scc.a.c(r112, scc.a.d(null, null, UIHelper.getString(R.string.Lark_IM_GIF_Tag), 0, 0, false, false, 120), 2);
        L32:
            r111 = new BitmapDrawable(this.f448824a.f448783g.getResources(), r108);
        L33:
            Drawable r113 = l.a(r111, r102, r103, this.f448824a.f448791o);
            r113.setBounds(0, 0, r102, r103);
            v r114 = this.f448824a;
            r114.getClass();
            Intrinsics.checkNotNullParameter(r113, "drawable");
            r114.f448712e = r113;
            v r115 = this.f448824a;
            r115.f448799w = true;
            b r116 = r115.f448797u;
            if (r116 == null) goto L37;
            r116.a();
            return;
        L37:
            return;
        L29:
            r108 = null;
            goto L30
        L25:
            r112 = ((WebpDrawable) r111).getFirstFrame();
            goto L26
        L16:
            if ((r111 instanceof WebpDrawable) == true) goto L23;
            if (r100.A == false) goto L33;
            Bitmap r117 = ((BitmapDrawable) r111).getBitmap();
            String r118 = UIUtils.getString(this.f448824a.f448783g, R.string.Lark_IM_FileExpiredByAdmin_Label);
            v r119 = this.f448824a;
            Bitmap r120 = scc.a.a(r117, r118, r119.f448787k, r119.f448788l);
            if (r120 == null) goto L33;
            r111 = new BitmapDrawable(this.f448824a.f448783g.getResources(), r120);
        L12:
            r103 = r100.f448786j;
            goto L13
        L5:
            if (r100.f448788l == 0) goto L7;
            r102 = r101;
            goto L8
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f448784h, Integer.valueOf(this.f448785i), Integer.valueOf(this.f448786j), this.f448791o});
    }

    @Override // com.ss.android.lark.widget.span.n
    public final Drawable a() {
        if (this.f448799w == true) goto L32;
        if (this.f448783g == null) goto L32;
        ArrayList r110 = new ArrayList();
        if (this.f448787k != 0) goto L9;
    L30:
        this.f448798v.a(this.f448783g, this.f448784h, this.f448785i, this.f448786j, this.f448794r, this.f448792p, this.f448796t, this.f448795s, this.B, r110, new d(this));
        goto L32
    L9:
        if (this.f448788l == 0) goto L30;
        if (this.f448789m == false) goto L16;
        r110.add(new CropTransformation(this.f448787k, this.f448788l, CropTransformation.CropType.TOP));
        if (this.f448802z == false) goto L15;
        r110.add(new FullWidthImageTransformation());
        goto L16
    L15:
        r110.add(new LargeImageTransformation());
    L16:
        r110.add(new WhiteBgTransformation());
        BorderProperty r100 = this.f448791o;
        if (r100 != null) goto L19;
        int r111 = 0;
    L20:
        int r101 = this.f448787k;
        int r112 = this.f448785i;
        if (r101 <= r112) goto L23;
    L26:
        boolean r210 = true;
    L28:
        if (this.f448800x == false) goto L30;
        r110.add(new BorderTransformation(this.f448784h, r112, this.f448786j, r101, this.f448788l, r111, r210, this.f448790n, UIHelper.getColor(R.color.line_border_card)));
        goto L30
    L23:
        if (this.f448788l > this.f448786j) goto L26;
        r210 = false;
        goto L28
    L19:
        r111 = r100.getBorderRadiusPx();
    L32:
        return super.a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (TextUtils.equals(this.f448784h, r101.f448784h) == true) goto L11;
    L15:
        return false;
    L11:
        if (this.f448785i != r101.f448785i) goto L15;
        if (this.f448786j != r101.f448786j) goto L15;
        return true;
    }

    public v(Context r100, String r101, int r102, int r103, int r104, int r105, boolean r106, int r110, BorderProperty r111, String r112, boolean r113, ByteString r114, String r115, ByteString r116, Drawable r117, a r118, b r119, boolean r210, int r211, boolean r212, boolean r213, int r214) {
        super(r117);
        this.f448783g = r100;
        this.f448784h = r101;
        this.f448785i = r102;
        this.f448786j = r103;
        this.f448787k = r104;
        this.f448788l = r105;
        this.f448789m = r106;
        this.f448790n = r110;
        this.f448791o = r111;
        this.f448792p = r112;
        this.f448793q = r113;
        this.f448794r = r114;
        this.f448798v = r118;
        this.f448797u = r119;
        this.f448796t = r116;
        this.f448795s = r115;
        this.f448800x = r210;
        this.f448801y = r211;
        this.f448802z = r212;
        this.A = r213;
        this.B = r214;
    }
}
