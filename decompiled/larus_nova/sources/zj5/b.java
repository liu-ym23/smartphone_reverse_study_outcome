package zj5;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.widgets.TemplateTagView;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larus.nova.R;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;
import sbb.g;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f572476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f572477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f572478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f572479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f572480i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f572481j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f572482k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View.OnClickListener f572483l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f572484m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f572485n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f572486o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f572487p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f572488q;

    public static final class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f572489c;

        public a(b r100) {
            this.f572489c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            View.OnClickListener r101 = this.f572489c.f572483l;
            if (r101 == null) goto L6;
            r101.onClick(null);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return R.layout.more_header_v2;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r110) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        super.a(r110);
        ((TextView) r110.findViewById(R.id.title)).setText(this.f572476e);
        c r100 = this.f572478g;
        if (r100 != null) goto L5;
    L14:
        ((LKUIRoundedImageView) r110.findViewById(R.id.icon)).setImageResource(this.f572477f);
    L15:
        AppCompatImageView r101 = (AppCompatImageView) r110.findViewById(R.id.footer);
        if (this.f572479h == false) goto L18;
        int r102 = 0;
    L19:
        r101.setVisibility(r102);
        ((TextView) r110.findViewById(R.id.info)).setText(this.f572480i);
        if (this.f572484m == true) goto L22;
    L41:
        View r103 = r110.findViewById(R.id.divider);
        if (r103 == null) goto L44;
        r103.setVisibility(8);
    L44:
        AppCompatImageView r104 = (AppCompatImageView) r110.findViewById(R.id.fresh_icon);
        if (r104 == null) goto L47;
        r104.setVisibility(8);
    L47:
        TextView r105 = (TextView) r110.findViewById(R.id.state_desc);
        if (r105 == null) goto L50;
        r105.setVisibility(8);
    L50:
        ((TextView) r110.findViewById(R.id.info)).setMaxWidth(Integer.MAX_VALUE);
        TextView r106 = (TextView) r110.findViewById(R.id.state_desc);
        if (r106 == null) goto L54;
        r106.setText("");
    L54:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.docx.mobile.update_time_on_more") == true) goto L56;
    L63:
        ((LinearLayoutCompat) r110.findViewById(R.id.info_last_modified_container)).setVisibility(8);
    L64:
        ((FrameLayout) r110.findViewById(R.id.close)).setOnClickListener(new a(this));
        TemplateTagView r107 = (TemplateTagView) r110.findViewById(R.id.templateTagView);
        if (r107 != null) goto L69;
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, -2);
        r108.gravity = 17;
        TemplateTagView r109 = new TemplateTagView(r110.getContext());
        r109.setId(R.id.templateTagView);
        ((LinearLayoutCompat) r110.findViewById(R.id.title_container)).addView(r109, r108);
        r107 = r109;
    L69:
        if (this.f572482k == false) goto L71;
        r107.setVisibility(0);
        return;
    L71:
        r107.setVisibility(8);
        return;
    L56:
        if (TextUtils.isEmpty(this.f572481j) == true) goto L63;
        ((LinearLayoutCompat) r110.findViewById(R.id.info_last_modified_container)).setVisibility(0);
        ((TextView) r110.findViewById(R.id.info_last_modified)).setText(this.f572481j);
        if (this.f572484m == true) goto L60;
    L62:
        ((TextView) r110.findViewById(R.id.info_last_modified)).setMaxWidth(Integer.MAX_VALUE);
        goto L64
    L60:
        if (this.f572485n == (-1)) goto L62;
        ((TextView) r110.findViewById(R.id.info_last_modified)).setMaxWidth(n.d(this.f572488q));
        goto L64
    L22:
        if (this.f572485n == (-1)) goto L41;
        View r111 = r110.findViewById(R.id.divider);
        if (r111 == null) goto L26;
        r111.setVisibility(0);
    L26:
        AppCompatImageView r112 = (AppCompatImageView) r110.findViewById(R.id.fresh_icon);
        if (r112 == null) goto L29;
        r112.setVisibility(0);
    L29:
        TextView r113 = (TextView) r110.findViewById(R.id.state_desc);
        if (r113 == null) goto L32;
        r113.setVisibility(0);
    L32:
        AppCompatImageView r114 = (AppCompatImageView) r110.findViewById(R.id.fresh_icon);
        if (r114 == null) goto L35;
        r114.setImageResource(this.f572485n);
    L35:
        TextView r115 = (TextView) r110.findViewById(R.id.state_desc);
        if (r115 == null) goto L38;
        r115.setText(this.f572486o);
    L38:
        ((TextView) r110.findViewById(R.id.info)).setMaxWidth(n.d(this.f572488q));
        if (this.f572487p == (-1)) goto L54;
        l.c((ImageView) r110.findViewById(R.id.fresh_icon), this.f572487p);
        goto L54
    L18:
        r102 = 8;
        goto L19
    L5:
        if (TextUtils.isEmpty(r100.getUrl()) == true) goto L14;
        obb.a r116 = new obb.a(Boolean.valueOf(this.f572478g.E()), Boolean.valueOf(this.f572478g.isShareFolder()), null);
        r116.b(IconScene.DOCUMENT);
        if (kac.a.a() == false) goto L9;
        IconShape r117 = IconShape.SQUARE;
    L10:
        IconShape r118 = r117;
        LKUIRoundedImageView r119 = (LKUIRoundedImageView) r110.findViewById(R.id.icon);
        String r120 = this.f572478g.f();
        if (g.b(this.f572478g.getType()) == false) goto L13;
        mbb.c.d(r119, this.f572478g.getToken(), this.f572478g.getType(), r120, r118, r116);
        goto L15
    L13:
        mbb.c.e(r119, this.f572478g.getUrl(), r118, r116);
        goto L15
    L9:
        r117 = IconShape.CIRCLE;
        goto L10
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(k r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        if ((r100 instanceof b) == false) goto L17;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f234901a, r101.f234901a) == false) goto L17;
        if (Intrinsics.areEqual(this.f572476e, r101.f572476e) == false) goto L17;
        if (this.f572477f != r101.f572477f) goto L17;
        if (Intrinsics.areEqual(this.f572480i, r101.f572480i) == false) goto L17;
        if (Intrinsics.areEqual(this.f572481j, r101.f572481j) == false) goto L17;
        if (this.f572482k != r101.f572482k) goto L17;
        return true;
    L17:
        return false;
    }

    public b(String r100, int r101, c r102, boolean r103, String r104, String r105, boolean r106, zj5.a.b r110, boolean r111, int r112, String r113, int r114) {
        Intrinsics.checkNotNullParameter("more_header", "id");
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r104, "description");
        Intrinsics.checkNotNullParameter(r105, "lastModifiedTime");
        Intrinsics.checkNotNullParameter(r113, "stateDesc");
        super("more_header");
        this.f572476e = r100;
        this.f572477f = r101;
        this.f572478g = r102;
        this.f572479h = r103;
        this.f572480i = r104;
        this.f572481j = r105;
        this.f572482k = r106;
        this.f572483l = r110;
        this.f572484m = r111;
        this.f572485n = r112;
        this.f572486o = r113;
        this.f572487p = r114;
        this.f572488q = 200;
    }
}
