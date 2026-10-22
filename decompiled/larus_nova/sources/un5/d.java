package un5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends ImageSpan implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f550775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f550776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f550777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f550778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f550779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f550780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f550781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f550782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f550783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f550784j;

    public interface a {
    }

    @Override // un5.i
    public final boolean E() {
        return false;
    }

    @Override // un5.i
    public final /* synthetic */ int F() {
        throw null;
    }

    public final void a() {
        if (TextUtils.isEmpty(this.f550782h) == false) goto L5;
        return;
    L5:
        Boolean r100 = Boolean.FALSE;
        obb.a r101 = new obb.a(r100, r100, null);
        r101.b(IconScene.DOCUMENT);
        int r102 = this.f550780f;
        if (r102 == (-1)) goto L9;
        r101.f522633d = Integer.valueOf(r102);
    L12:
        boolean r103 = mbb.c.f512807a;
        mbb.c.a(this.f550777c, this.f550776b, this.f550782h, IconShape.SQUARE_OUTLINE, r101).subscribe(new b(this), new c());
        return;
    L9:
        if (this.f550778d == false) goto L11;
        r101.f522633d = Integer.valueOf(R.color.lkui_N400);
        goto L12
    L11:
        r101.f522633d = Integer.valueOf(R.color.colorful_blue);
        goto L12
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        Drawable r100 = this.f550781g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return super.getDrawable();
    }

    public Context getContext() {
        return this.f550775a;
    }

    public int getType() {
        return this.f550776b;
    }

    public d(Context r100) {
        super(r100, R.drawable.ic_icon_attachment_outlined);
        ColorMatrix r101 = new ColorMatrix();
        this.f550779e = -1;
        this.f550780f = -1;
        this.f550775a = r100;
        this.f550776b = 0;
        this.f550777c = "";
        r101.setSaturation(0.0f);
    }

    public d(Context r100, int r101, int r102, String r103) {
        super(r100.getDrawable(r101));
        ColorMatrix r104 = new ColorMatrix();
        this.f550779e = -1;
        this.f550780f = -1;
        getDrawable().setBounds(0, 0, n.d(14), n.d(14));
        this.f550775a = r100;
        this.f550776b = r102;
        this.f550777c = r103;
        r104.setSaturation(0.0f);
    }

    public d(Context r100, Drawable r101, int r102, String r103) {
        super(r101);
        ColorMatrix r104 = new ColorMatrix();
        this.f550779e = -1;
        this.f550780f = -1;
        r101.setBounds(0, 0, n.d(14), n.d(14));
        this.f550775a = r100;
        this.f550776b = r102;
        this.f550777c = r103;
        r104.setSaturation(0.0f);
    }

    public d(Context r100, TextView r101, String r110, int r111, String r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Rect r105 = getDrawable().getBounds();
        if (r104 == null) goto L9;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        if (kac.a.a() == false) goto L7;
        int r107 = (r106.ascent + r106.descent) / 2;
        int r108 = r105.height() / 2;
        int r109 = Math.min(r106.ascent, r107 - r108);
        r104.ascent = r109;
        r104.top = r109;
        int r110 = Math.max(r106.descent, r107 + r108);
        r104.descent = r110;
        r104.bottom = r110;
        goto L9
    L7:
        int r111 = r106.bottom - r106.top;
        int r112 = (r105.bottom - r105.top) / 2;
        int r113 = r111 / 4;
        int r114 = r112 - r113;
        int r115 = -(r112 + r113);
        r104.ascent = r115;
        r104.top = r115;
        r104.bottom = r114;
        r104.descent = r114;
    L9:
        return r105.right + this.f550775a.getResources().getDimensionPixelSize(R.dimen.doc_file_prefix_space);
    }

    public d(Context r100, TextView r101, String r102, int r103, String r104, a r105) {
        super(AppCompatResources.getDrawable(r100, ua5.a.i(r103)));
        ColorMatrix r106 = new ColorMatrix();
        this.f550779e = -1;
        this.f550780f = -1;
        this.f550775a = r100;
        this.f550784j = r105;
        this.f550776b = r103;
        this.f550777c = r104;
        r106.setSaturation(0.0f);
        this.f550782h = r102;
        this.f550783i = r101;
        a();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r110) {
        Drawable r108 = getDrawable();
        r100.save();
        if (this.f550781g == null) goto L5;
    L11:
        r100.saveLayer(null, r110, 31);
        if (kac.a.a() == false) goto L14;
        Paint.FontMetricsInt r109 = r110.getFontMetricsInt();
        int r111 = (r106 + ((r109.ascent + r109.descent) / 2)) - (r108.getBounds().height() / 2);
    L15:
        r100.translate(r104 + (this.f550775a.getResources().getDimensionPixelSize(R.dimen.doc_file_prefix_space) / 2), r111);
        r108.draw(r100);
        r100.restore();
        return;
    L14:
        r111 = (((r107 - r105) - r108.getBounds().bottom) / 2) + r105;
        goto L15
    L5:
        if (this.f550779e == (-1)) goto L8;
        r110.setColorFilter(new PorterDuffColorFilter(this.f550779e, PorterDuff.Mode.SRC_IN));
        goto L11
    L8:
        if (this.f550778d == false) goto L10;
        r110.setColorFilter(new PorterDuffColorFilter(this.f550775a.getResources().getColor(R.color.lkui_N400), PorterDuff.Mode.SRC_IN));
        goto L11
    L10:
        r110.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(this.f550775a, R.color.text_link_normal), PorterDuff.Mode.SRC_IN));
        goto L11
    }
}
