package mm5;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.share.newshare.e0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f514476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f514477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View.OnClickListener f514478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View.OnClickListener f514479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f514480f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f514481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f514482b;

        public a(f r100, View r101) {
            this.f514481a = r100;
            this.f514482b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (TextUtils.isEmpty(this.f514481a.f514480f) == true) goto L6;
            Toast.showFailureText(this.f514482b.getContext(), this.f514481a.f514480f);
            return;
        L6:
            View.OnClickListener r101 = this.f514481a.f514478d;
            if (r101 == null) goto L10;
            r101.onClick(null);
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f514483a;

        public b(View.OnClickListener r100) {
            this.f514483a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f514483a.onClick(null);
        }
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ViewGroup.LayoutParams r101 = new ViewGroup.LayoutParams(-1, -2);
        this.f514476b.setLayoutParams(r101);
        return this.f514476b;
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final boolean d(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        if ((r100 instanceof f) == false) goto L13;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f237211a, r101.f237211a) == false) goto L13;
        if (Intrinsics.areEqual(this.f514476b, r101.f514476b) == false) goto L13;
        if (this.f514477c != r101.f514477c) goto L13;
        if (Intrinsics.areEqual(this.f514479e, r101.f514479e) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.bytedance.ee.bear.share.newshare.e0
    public final void a(View r100, List<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r100, "itemView");
        if (this.f514477c == true) goto L6;
        r100.setAlpha(0.3f);
        r100.setOnClickListener(new a(this, r100));
        return;
    L6:
        r100.setAlpha(1.0f);
        r100.setEnabled(true);
        r100.setOnClickListener(null);
        View.OnClickListener r102 = this.f514479e;
        if (r102 == null) goto L10;
        r100.setOnClickListener(new b(r102));
        return;
    }

    public f(String r100, View r101, boolean r102, View.OnClickListener r103, View.OnClickListener r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "view");
        super(r100);
        this.f514476b = r101;
        this.f514477c = r102;
        this.f514478d = r103;
        this.f514479e = r104;
        this.f514480f = r105;
    }
}
