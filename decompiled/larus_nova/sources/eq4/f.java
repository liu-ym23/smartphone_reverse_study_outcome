package eq4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.larus.nova.R;
import db5.j;

/* JADX INFO: loaded from: classes15.dex */
public final class f extends db5.i<e> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f473488e;

    @Override // db5.i
    public final db5.g d(db5.a r110) {
        e r111 = (e) r110;
        SpannableStringBuilder r100 = new SpannableStringBuilder(r111.f467804a);
        int r101 = 0;
    L3:
        h[] r102 = r111.f473487e;
        if (r101 >= r102.length) goto L24;
        h r103 = r102[r101];
        r100.replace(r103.f473489a, r103.f473490b, "<doc.at.~#_%=`>" + r103.b());
        int r104 = 15 - (r103.f473491c.getName().length() - r103.b().length());
        r103.f473490b = r103.f473490b + r104;
        Context r105 = this.f467820a;
        Drawable r106 = r105.getResources().getDrawable(R.drawable.ud_icon_image_outlined);
        r106.setTint(this.f467820a.getResources().getColor(R.color.primary_fill_default));
        un5.d r107 = new un5.d(r105, r106, 0, "");
        int r108 = r103.f473489a;
        r100.setSpan(r107, r108, r108 + 15, 33);
        r100.setSpan(new i(this.f467820a, r103.f473491c, r103.f473492d, this.f473488e), r103.f473489a, r103.f473490b, 33);
        r101 = r101 + 1;
        int r109 = r101;
    L6:
        h[] r112 = r111.f473487e;
        if (r109 >= r112.length) goto L9;
        h r113 = r112[r109];
        r113.f473489a += r104;
        r113.f473490b += r104;
        r109 = r109 + 1;
        goto L6
    L9:
        bo4.a[] r114 = r111.f467805b;
        int r115 = 0;
    L11:
        if (r115 >= r114.length) goto L16;
        bo4.a r116 = r111.f467805b[r115];
        int r117 = r116.f19811a;
        if (r117 <= r103.f473489a) goto L15;
        r116.f19811a = r117 + r104;
        r116.f19812b += r104;
    L15:
        r115 = r115 + 1;
        goto L11
    L16:
        j[] r118 = r111.f467806c;
        int r119 = 0;
    L18:
        if (r119 >= r118.length) goto L3;
        j r120 = r111.f467806c[r119];
        int r121 = r120.f467826a;
        if (r121 <= r103.f473489a) goto L22;
        r120.f467826a = r121 + r104;
        r120.f467827b += r104;
    L22:
        r119 = r119 + 1;
        goto L18
    L24:
        return new db5.g(r100);
    }

    public f(TextView r100, a r101) {
        super(r100, r101, null);
        this.f473488e = r101;
    }
}
