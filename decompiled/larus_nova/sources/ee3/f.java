package ee3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f472279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f472280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f472281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f472282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View.OnClickListener f472283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f472284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f472285g;

    public static final class a {
    }

    public interface b {
        void a(int r100);
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f472286a;

        public c(f r100) {
            this.f472286a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f472286a.d();
            b r101 = this.f472286a.f472282d;
            if (r101 == null) goto L6;
            r101.a(0);
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f472287a;

        public d(f r100) {
            this.f472287a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f472287a.c();
            b r101 = this.f472287a.f472282d;
            if (r101 == null) goto L6;
            r101.a(1);
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f472288a;

        public e(f r100) {
            this.f472288a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f472288a.f472283e;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    static {
    }

    public f() {
    }

    public final void c() {
        this.f472285g = 1;
        TextView r100 = this.f472280b;
        if (r100 == null) goto L5;
        r100.setSelected(true);
    L5:
        TextView r101 = this.f472279a;
        if (r101 == null) goto L9;
        r101.setSelected(false);
        return;
    }

    public final void d() {
        this.f472285g = 0;
        TextView r100 = this.f472279a;
        if (r100 == null) goto L5;
        r100.setSelected(true);
    L5:
        TextView r101 = this.f472280b;
        if (r101 == null) goto L9;
        r101.setSelected(false);
        return;
    }

    public static ColorStateList b(Context r100) {
        int[] r101 = {-1, r100.getResources().getColor(R.color.shopping_color_80FFFFFF)};
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, r101);
    }

    public final void a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        View r101 = th.a.c(r100.getContext(), R.layout.ec_commerce_anchor_v3_video_image_gallery_layout, r100, false);
        if (r101 == null) goto L47;
        FrameLayout r102 = (FrameLayout) r101;
        this.f472281c = r102;
        r100.addView(r102);
        Integer r103 = this.f472284f;
        TextView r104 = null;
        if (r103 == null) goto L10;
        int r105 = r103.intValue();
        FrameLayout r106 = this.f472281c;
        if (r106 == null) goto L9;
        r106.setVisibility(r105);
    L9:
        this.f472284f = null;
    L10:
        FrameLayout r107 = this.f472281c;
        if (r107 == null) goto L13;
        TextView r108 = (TextView) r107.findViewById(R.id.tv_indicator_video);
    L14:
        this.f472279a = r108;
        FrameLayout r109 = this.f472281c;
        if (r109 == null) goto L17;
        TextView r110 = (TextView) r109.findViewById(R.id.tv_indicator_image);
    L18:
        this.f472280b = r110;
        FrameLayout r111 = this.f472281c;
        if (r111 == null) goto L23;
        TextView r112 = (TextView) r111.findViewById(R.id.tv_indicator_video);
        if (r112 == null) goto L23;
        r112.setTextColor(b(r112.getContext()));
        r112.setOnClickListener(new c(this));
        Unit r113 = Unit.INSTANCE;
    L24:
        this.f472279a = r112;
        FrameLayout r114 = this.f472281c;
        if (r114 == null) goto L29;
        TextView r115 = (TextView) r114.findViewById(R.id.tv_indicator_image);
        if (r115 == null) goto L29;
        r115.setTextColor(b(r115.getContext()));
        r115.setOnClickListener(new d(this));
        Unit r116 = Unit.INSTANCE;
        r104 = r115;
    L29:
        this.f472280b = r104;
        FrameLayout r117 = this.f472281c;
        if (r117 == null) goto L34;
        View r118 = r117.findViewById(R.id.iv_close);
        if (r118 == null) goto L34;
        r118.setOnClickListener(new e(this));
    L34:
        Integer r119 = this.f472285g;
        if (r119 != null) goto L38;
    L40:
        if (r119 != null) goto L43;
        return;
    L43:
        if (r119.intValue() != 0) goto L49;
        d();
        return;
    L49:
        return;
    L38:
        if (r119.intValue() != 1) goto L40;
        c();
        return;
    L23:
        r112 = null;
        goto L24
    L17:
        r110 = null;
        goto L18
    L13:
        r108 = null;
        goto L14
    L47:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }
}
