package zj5;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.widgets.TemplateTagView;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;
import sbb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends k {
    public final String e;
    public final int f;
    public final c g;
    public final boolean h;
    public final String i;
    public final String j;
    public final boolean k;
    public final View.OnClickListener l;
    public final boolean m;
    public final int n;
    public final String o;
    public final int p;
    public final int q;

    public static final class a extends t {
        public final /* synthetic */ b c;

        public a(b r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            View.OnClickListener r3 = this.c.l;
            if (r3 == null) goto L6;
            r3.onClick(null);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return 2131563669;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "itemView");
        super.a(r10);
        ((TextView) r10.findViewById(2131388772)).setText(this.e);
        c r0 = this.g;
        if (r0 != null) goto L5;
    L14:
        r10.findViewById(2131374718).setImageResource(this.f);
    L15:
        AppCompatImageView r1 = r10.findViewById(2131373139);
        if (this.h == false) goto L18;
        int r2 = 0;
    L19:
        r1.setVisibility(r2);
        ((TextView) r10.findViewById(2131375279)).setText(this.i);
        if (this.m == true) goto L22;
    L41:
        View r3 = r10.findViewById(2131369197);
        if (r3 == null) goto L44;
        r3.setVisibility(8);
    L44:
        AppCompatImageView r4 = r10.findViewById(2131373312);
        if (r4 == null) goto L47;
        r4.setVisibility(8);
    L47:
        TextView r5 = (TextView) r10.findViewById(2131387260);
        if (r5 == null) goto L50;
        r5.setVisibility(8);
    L50:
        ((TextView) r10.findViewById(2131375279)).setMaxWidth(Integer.MAX_VALUE);
        TextView r6 = (TextView) r10.findViewById(2131387260);
        if (r6 == null) goto L54;
        r6.setText("");
    L54:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.mobile.update_time_on_more") == true) goto L56;
    L63:
        r10.findViewById(2131375287).setVisibility(8);
    L64:
        ((FrameLayout) r10.findViewById(2131366972)).setOnClickListener(new a(this));
        AppCompatTextView r7 = (TemplateTagView) r10.findViewById(2131388320);
        if (r7 != null) goto L69;
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, -2);
        r8.gravity = 17;
        AppCompatTextView r9 = new TemplateTagView(r10.getContext());
        r9.setId(2131388320);
        r10.findViewById(2131388843).addView(r9, r8);
        r7 = r9;
    L69:
        if (this.k == false) goto L71;
        r7.setVisibility(0);
        return;
    L71:
        r7.setVisibility(8);
        return;
    L56:
        if (TextUtils.isEmpty(this.j) == true) goto L63;
        r10.findViewById(2131375287).setVisibility(0);
        ((TextView) r10.findViewById(2131375286)).setText(this.j);
        if (this.m == true) goto L60;
    L62:
        ((TextView) r10.findViewById(2131375286)).setMaxWidth(Integer.MAX_VALUE);
        goto L64
    L60:
        if (this.n == (-1)) goto L62;
        ((TextView) r10.findViewById(2131375286)).setMaxWidth(n.d(this.q));
        goto L64
    L22:
        if (this.n == (-1)) goto L41;
        View r11 = r10.findViewById(2131369197);
        if (r11 == null) goto L26;
        r11.setVisibility(0);
    L26:
        AppCompatImageView r12 = r10.findViewById(2131373312);
        if (r12 == null) goto L29;
        r12.setVisibility(0);
    L29:
        TextView r13 = (TextView) r10.findViewById(2131387260);
        if (r13 == null) goto L32;
        r13.setVisibility(0);
    L32:
        AppCompatImageView r14 = r10.findViewById(2131373312);
        if (r14 == null) goto L35;
        r14.setImageResource(this.n);
    L35:
        TextView r15 = (TextView) r10.findViewById(2131387260);
        if (r15 == null) goto L38;
        r15.setText(this.o);
    L38:
        ((TextView) r10.findViewById(2131375279)).setMaxWidth(n.d(this.q));
        if (this.p == (-1)) goto L54;
        l.c((ImageView) r10.findViewById(2131373312), this.p);
        goto L54
    L18:
        r2 = 8;
        goto L19
    L5:
        if (TextUtils.isEmpty(r0.getUrl()) == true) goto L14;
        obb.a r16 = new obb.a(Boolean.valueOf(this.g.E()), Boolean.valueOf(this.g.isShareFolder()), null);
        r16.b(IconScene.DOCUMENT);
        if (kac.a.a() == false) goto L9;
        IconShape r17 = IconShape.SQUARE;
    L10:
        IconShape r18 = r17;
        LKUIRoundedImageView r19 = r10.findViewById(2131374718);
        String r20 = this.g.f();
        if (g.b(this.g.getType()) == false) goto L13;
        mbb.c.d(r19, this.g.getToken(), this.g.getType(), r20, r18, r16);
        goto L15
    L13:
        mbb.c.e(r19, this.g.getUrl(), r18, r16);
        goto L15
    L9:
        r17 = IconShape.CIRCLE;
        goto L10
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(k r3) {
        Intrinsics.checkNotNullParameter(r3, "obj");
        if ((r3 instanceof b) == false) goto L17;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == false) goto L17;
        if (Intrinsics.areEqual(this.e, r4.e) == false) goto L17;
        if (this.f != r4.f) goto L17;
        if (Intrinsics.areEqual(this.i, r4.i) == false) goto L17;
        if (Intrinsics.areEqual(this.j, r4.j) == false) goto L17;
        if (this.k != r4.k) goto L17;
        return true;
    L17:
        return false;
    }

    public b(String r3, int r4, c r5, boolean r6, String r7, String r8, boolean r9, zj5.a.b r10, boolean r11, int r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter("more_header", ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r7, "description");
        Intrinsics.checkNotNullParameter(r8, "lastModifiedTime");
        Intrinsics.checkNotNullParameter(r13, "stateDesc");
        super("more_header");
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = r12;
        this.o = r13;
        this.p = r14;
        this.q = 200;
    }
}
