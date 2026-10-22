package fd5;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.thumbnail.LeftCrop;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements b {
    public final Document a;
    public final Context b;
    public final boolean c;

    @Override // fd5.b
    public final void a(AppCompatImageView r13, AppCompatImageView r14) {
        boolean r0 = false;
        r13.setVisibility(0);
        r14.setVisibility(8);
        if (TextUtils.isEmpty(this.a.q) == false) goto L46;
        if (TextUtils.isEmpty(this.a.V0) == false) goto L46;
        r13.setVisibility(8);
        r14.setVisibility(0);
        if (kac.a.a() == false) goto L17;
        int r15 = com.bytedance.ee.util.ui.n.c(35.0f);
        ViewGroup.LayoutParams r1 = r14.getLayoutParams();
        if (r1 != null) goto L12;
        r1 = new ViewGroup.LayoutParams(-2, -2);
    L12:
        r1.width = com.bytedance.ee.util.ui.n.d(30);
        r1.height = com.bytedance.ee.util.ui.n.d(30);
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        r2.topMargin = r15;
        r14.setLayoutParams(r2);
        goto L17
    L15:
        r14.setLayoutParams(r1);
    L17:
        if (m.a() == false) goto L19;
    L20:
        r0 = true;
    L22:
        if (this.a.getType() != sbb.e.l.b) goto L28;
        Document r16 = this.a;
        if (r0 == false) goto L26;
        int r17 = rbb.b.e(r16.F);
    L40:
        r14.setImageResource(r17);
        StringBuilder r18 = new StringBuilder("thumbnail is empty : ");
        if (TextUtils.isEmpty(this.a.q) == false) goto L43;
        String r19 = "true";
    L44:
        r18.append(r19);
        r18.append(", type = ");
        r18.append(this.a.getType());
        tt5.a.h("DocumentGridItemIconStrategy", r18.toString());
        return;
    L43:
        r19 = "false";
        goto L44
    L26:
        r17 = ua5.a.h(r16.F);
        goto L40
    L28:
        if (this.a.getType() != sbb.e.n.b) goto L34;
        Document r110 = this.a;
        if (r0 == false) goto L32;
        r17 = ua5.a.l(r110.y1, r110.a);
        goto L40
    L32:
        r17 = ua5.a.j(r110.y1, r110.a);
        goto L40
    L34:
        if (this.a.getType() != sbb.e.f.b) goto L36;
        r17 = rbb.b.g();
        goto L40
    L36:
        int r111 = this.a.getType();
        if (r0 == false) goto L39;
        r17 = rbb.b.c(r111, null);
        goto L40
    L39:
        r17 = ua5.a.i(r111);
        goto L40
    L19:
        if (kac.a.a() == false) goto L22;
    L46:
        if (this.a.getType() == sbb.e.l.b) goto L48;
    L51:
        Document r3 = this.a;
        String r4 = r3.q;
        String r5 = r3.V0;
        int r6 = r3.getType();
        Document r7 = this.a;
        ThumbGlideUrl r112 = new ThumbGlideUrl(r4, r5, r6, r7.h1, r7.b1, r7.g1, ThumbGlideUrl.SOURCE_SPACE_LIST, false, r13);
        r112.setIsConnect(Boolean.valueOf(this.c));
        r112.setExtra(this.a.O);
        Glide.with(this.b).asBitmap().load(r112).skipMemoryCache(r112.needUpdate(r112.getUrl())).diskCacheStrategy(DiskCacheStrategy.NONE).transform(new LeftCrop()).placeholder(2131243712).into(r13);
        return;
    L48:
        if (((ya5.b) org.koin.java.a.a(ya5.b.class)).a() == true) goto L51;
        r13.setImageResource(2131243712);
    }

    public a(Document r1, Context r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
