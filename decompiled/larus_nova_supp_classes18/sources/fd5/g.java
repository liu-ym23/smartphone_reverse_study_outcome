package fd5;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.listitem.ListIconTransformation;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends i {
    public final boolean d;

    @Override // fd5.i
    public final void a() {
        String r1 = k.c(this.b);
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.mobile.list_video_thumbnail_enable", false) == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L16;
        int r6 = rbb.b.e(r1);
    L20:
        if (this.d == false) goto L22;
    L60:
        this.c.setImageResource(r6);
        return;
    L22:
        if (((ya5.b) org.koin.java.a.a(ya5.b.class)).a() == false) goto L60;
        if (TextUtils.isEmpty(this.b.H) == true) goto L31;
        Document r7 = this.b;
        String r8 = r7.q;
        String r9 = r7.H;
        if (r7.getType() != sbb.e.n.b) goto L29;
        int r10 = this.b.y1;
    L30:
        int r11 = r10;
        Document r12 = this.b;
        ThumbGlideUrl r13 = new ThumbGlideUrl(r8, r9, r11, r12.K, r12.I, r12.J, ThumbGlideUrl.SOURCE_SPACE_LIST_ICON, true, this.c);
    L39:
        if (TextUtils.isEmpty(this.b.H) == true) goto L41;
        String r3 = this.b.H;
    L47:
        if (r13 != null) goto L49;
    L58:
        this.c.setImageResource(r6);
        return;
    L49:
        if (TextUtils.isEmpty(r3) == true) goto L58;
        r13.setSubType(r1);
        r13.setExtra(this.b.O);
        if (r13.isFileIconUseDefault() == false) goto L55;
        this.c.setImageResource(r6);
        return;
    L55:
        if (TextUtils.equals(String.valueOf(this.c.getTag(2131363734)), r3) == false) goto L63;
        Glide.with(this.a).asBitmap().load(r13).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(r6).transform(new Transformation[]{new ListIconTransformation(), new CenterCrop(), new RoundedCorners(com.bytedance.ee.util.ui.n.d(6))}).error(r6).into(this.c);
        return;
    L63:
        return;
    L41:
        if (r2 == true) goto L43;
        r3 = "";
        goto L47
    L43:
        if (TextUtils.isEmpty(this.b.V0) == true) goto L45;
        r3 = this.b.V0;
        goto L47
    L45:
        r3 = this.b.q;
        goto L47
    L29:
        r10 = this.b.getType();
        goto L30
    L31:
        if (r2 == true) goto L33;
        r13 = null;
        goto L39
    L33:
        Document r14 = this.b;
        String r15 = r14.q;
        String r16 = r14.V0;
        if (r14.getType() != sbb.e.n.b) goto L36;
        int r17 = this.b.y1;
    L37:
        int r18 = r17;
        Document r19 = this.b;
        r13 = new ThumbGlideUrl(r15, r16, r18, r19.h1, r19.b1, r19.g1, ThumbGlideUrl.SOURCE_SPACE_LIST_ICON, false, this.c);
        goto L39
    L36:
        r17 = this.b.getType();
        goto L37
    L16:
        if (m.a() == false) goto L18;
        r6 = rbb.b.e(r1);
        goto L20
    L18:
        r6 = ua5.a.h(r1);
        goto L20
    L10:
        if (kac.a.a() == false) goto L12;
        r5 = true;
        goto L13
    L5:
        if (k.b(this.b, new f(this)) == false) goto L7;
        r2 = true;
        goto L8
    }

    public g(Context r1, Document r2, boolean r3, ImageView r4) {
        super(r1, r2, r4);
        this.d = r3;
    }
}
