package gi4;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import com.larus.nova.R;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class r<DATA> extends com.bytedance.creativex.mediaimport.view.internal.base.p<DATA> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ti4.l<DATA> f481378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final fi4.c<DATA> f481379l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f481380m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f481381n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f481382o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f481383p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f481384q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f481385r;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f481386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f481387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f481388c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f481389d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f481390e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f481391f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f481392g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f481393h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f481394i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Function2<? super String, ? super Integer, String> f481395j;

        public a() {
            this(null);
        }

        public a(Object r100) {
            int r101 = v19.c.b(R.attr.larus_flow_media_import_ic_media_selected, null, R.drawable.larus_flow_media_import_ic_media_selected);
            this.f481386a = R.string.larus_album_select_btn;
            this.f481387b = R.string.larus_album_select_btn;
            this.f481388c = false;
            this.f481389d = false;
            this.f481390e = r101;
            this.f481391f = R.drawable.larus_tools_media_import_bg_image_select;
            this.f481392g = 0;
            this.f481393h = 0;
            this.f481394i = false;
            this.f481395j = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.creativex.mediaimport.view.internal.base.p
    public final void d() {
        if (this.f481381n.f481394i == false) goto L25;
        ti4.m<DATA> r100 = this.f203860c;
        if (r100 == null) goto L13;
        LiveData<List<DATA>> r101 = r100.getSelectedMaterials();
        if (r101 == null) goto L13;
        List<DATA> r102 = r101.getValue();
        if (r102 == null) goto L13;
        if (r102.isEmpty() == true) goto L13;
        boolean r103 = true;
    L15:
        if ((!r103) == false) goto L25;
        fi4.c<DATA> r104 = this.f481379l;
        if (r104 == null) goto L27;
        MutableLiveData r105 = r104.a();
        if (r105 == null) goto L28;
        Pair r106 = (Pair) r105.getValue();
        if (r106 == null) goto L29;
        Object r107 = r106.component1();
        ti4.m<DATA> r108 = this.f203860c;
        if (r108 == null) goto L30;
        r108.selectSingle((DATA) r107);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L13:
        r103 = false;
    L25:
        super.d();
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.p
    public final void c() {
        super.c();
        ViewGroup r100 = b();
        Intrinsics.checkNotNullParameter(r100, "content");
        View r101 = r100.findViewById(R.id.select_layout);
        r101.setOnClickListener(new n(this));
        this.f481382o = r101;
        ViewGroup r102 = b();
        Intrinsics.checkNotNullParameter(r102, "content");
        this.f481384q = (TextView) r102.findViewById(R.id.index_txt);
        ViewGroup r103 = b();
        Intrinsics.checkNotNullParameter(r103, "content");
        this.f481383p = (TextView) r103.findViewById(R.id.tip_txt);
        ViewGroup r104 = b();
        Intrinsics.checkNotNullParameter(r104, "content");
        this.f481385r = r104.findViewById(R.id.preview_top_mask_with_docker);
        a r105 = this.f481381n;
        int r106 = r105.f481392g;
        if (r106 == 0) goto L8;
        View r107 = this.f203867j;
        if (r107 == null) goto L8;
        r107.setBackgroundResource(r106);
    L8:
        if (r105.f481393h == 0) goto L12;
        ColorStateList r108 = ContextCompat.getColorStateList(b().getContext(), r105.f481393h);
        TextView r109 = this.f203866i;
        if (r109 == null) goto L12;
        r109.setTextColor(r108);
    L12:
        LifecycleOwner r110 = this.f203859b;
        ti4.l<DATA> r111 = this.f481378k;
        if (r111 == null) goto L15;
        r111.c().observe(r110, new o(this));
    L15:
        ti4.m<DATA> r112 = this.f203860c;
        if (r112 == null) goto L21;
        LiveData<List<DATA>> r113 = r112.getSelectedMaterials();
        if (r113 == null) goto L22;
        r113.observe(r110, new p(this));
        return;
    L22:
        return;
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.p
    public final TextView e(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        TextView r101 = super.e(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        if (this.f481381n.f481394i == false) goto L9;
        r101.setSelected(true);
        r101.setAlpha(1.0f);
        return r101;
    L9:
        return r101;
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.p
    public final ViewGroup f(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_tools_media_import_preview_selector_view, r100, true);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) r101;
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.p
    public final String a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "confirmText");
        Function2<? super String, ? super Integer, String> r102 = this.f481381n.f481395j;
        if (r102 == null) goto L7;
        String r103 = r102.invoke(r100, Integer.valueOf(r101));
        if (r103 == null) goto L7;
        return r103;
    L7:
        return super.a(r100, r101);
    }

    public final void g(boolean r100, MaterialSelectedState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        TextView r102 = this.f481383p;
        float r103 = 0.34f;
        if (r102 == null) goto L8;
        if (r100 == false) goto L6;
        float r104 = 1.0f;
    L7:
        r102.setAlpha(r104);
        goto L8
    L6:
        r104 = 0.34f;
    L8:
        TextView r105 = this.f481384q;
        if (r105 == null) goto L14;
        if (r100 == false) goto L12;
        r103 = 1.0f;
    L12:
        r105.setAlpha(r103);
        return;
    }

    public r(ViewGroup r100, LifecycleOwner r101, ti4.m r102, yi4.g r110, fi4.c r111, boolean r112, boolean r113, String r114, com.bytedance.creativex.mediaimport.preview.internal.main.q r115) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r114, "confirmText");
        super(r100, r101, r102, r113, r114);
        this.f481378k = r110;
        this.f481379l = r111;
        this.f481380m = r112;
        a r103 = new a(null);
        this.f481381n = r103;
        r115.invoke(r103);
    }
}
