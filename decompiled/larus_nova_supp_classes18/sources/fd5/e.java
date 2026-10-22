package fd5;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.g0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final Context a;
    public final Document b;
    public i c;
    public final boolean d;
    public final ImageView e;
    public final boolean f;
    public final IconShape g;

    public final void a(ce5.a r13) {
        String r0 = this.b.F2;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L11:
        boolean r2 = true;
    L12:
        Boolean r3 = Boolean.valueOf(r2);
        if (TextUtils.isEmpty(this.b.H) == true) goto L16;
        String r4 = this.b.H;
    L28:
        if (r3.booleanValue() == true) goto L30;
    L52:
        Document r5 = this.b;
        if (FolderVersion.isShareFolder(r5.L1, r5.P1) == false) goto L55;
    L58:
        Boolean r6 = Boolean.valueOf(r1);
        obb.a r11 = new obb.a(Boolean.FALSE, r6, null);
        r11.b(IconScene.HOME_PAGE);
        if (r13 == null) goto L61;
        r11.g = r13.b;
    L61:
        Document r14 = this.b;
        String r7 = r14.F2;
        if (r7 != null) goto L64;
        String r9 = "";
    L65:
        int r15 = r14.getType();
        sbb.e r8 = sbb.e.n;
        if (r15 != r8.b) goto L68;
        int r16 = this.b.y1;
    L69:
        int r10 = r16;
        if (this.b.getType() != r8.b) goto L72;
        String r17 = this.b.G1;
    L73:
        String r12 = r17;
        IconShape r18 = this.g;
        if (r18 == null) goto L77;
    L75:
        IconShape r19 = r18;
        if (r12 == null) goto L82;
        boolean r110 = mbb.c.a;
        mbb.c.d(this.e, r12, r10, r9, r19, r11);
        return;
    L82:
        String r111 = this.b.p;
        if (r111 == null) goto L90;
        boolean r20 = mbb.c.a;
        mbb.c.f(this.e, r111, r9, r19, r11);
        return;
    L90:
        return;
    L77:
        if (m.a() == false) goto L79;
        r18 = IconShape.SQUARE;
        goto L75
    L79:
        r18 = IconShape.CIRCLE;
        goto L75
    L72:
        r17 = this.b.d;
        goto L73
    L68:
        r16 = this.b.getType();
        goto L69
    L64:
        r9 = r7;
        goto L65
    L55:
        if (NodeType.isShortcut(this.b.M1) == true) goto L58;
        r1 = false;
        goto L58
    L30:
        if (this.d == true) goto L52;
        if (TextUtils.isEmpty(r4) == true) goto L52;
        this.e.setTag(2131363734, r4);
        if (sbb.e.f.b != this.b.getType()) goto L37;
        this.c = new h(this.a, this.b, this.e);
    L51:
        this.c.a();
        return;
    L37:
        if (sbb.e.l.b != this.b.getType()) goto L39;
    L50:
        this.c = new g(this.a, this.b, this.d, this.e);
        goto L51
    L39:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.mobile.list_video_thumbnail_enable", false) == true) goto L41;
    L43:
        r1 = false;
    L44:
        if (r1 == true) goto L50;
        if (sbb.e.n.b != this.b.getType()) goto L49;
        this.c = new j(this.a, this.b, this.e);
        goto L51
    L49:
        this.c = new c(this.a, this.b, this.e, this.f);
        goto L51
    L41:
        if (k.b(this.b, new d(this)) == false) goto L43;
    L16:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.mobile.list_video_thumbnail_enable", false) == true) goto L18;
    L20:
        boolean r21 = false;
    L21:
        if (r21 == true) goto L23;
        r4 = "";
        goto L28
    L23:
        if (TextUtils.isEmpty(this.b.V0) == true) goto L25;
        r4 = this.b.V0;
        goto L28
    L25:
        r4 = this.b.q;
        goto L28
    L18:
        if (k.b(this.b, new d(this)) == false) goto L20;
        r21 = true;
        goto L21
    L5:
        if (TextUtils.isEmpty(r0) == true) goto L11;
        r2 = TextUtils.isEmpty(JSONObjectProtectorUtils.getString(new JSONObject(r0), "key"));     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public e(g0 r2, boolean r3) {
        this.a = r2.getContext();
        this.b = r2.b;
        String r0 = r2.c;
        this.d = r2.d;
        this.e = r2.f;
        this.f = r3;
    }

    public e(g0 r1, boolean r2, IconShape r3) {
        this(r1, r2);
        this.g = r3;
    }
}
