package ypa;

import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import vpa.c;
import vpa.d;

/* JADX INFO: loaded from: classes34.dex */
public abstract class b extends RelativeLayout implements vpa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f568729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wpa.b f568730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vpa.a f568731c;

    @Override // vpa.a
    public final boolean a() {
        vpa.a r100 = this.f568731c;
        if (r100 == null) goto L8;
        if (r100 == this) goto L8;
        if (r100.a() == false) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // vpa.a
    public wpa.b getSpinnerStyle() {
        wpa.b r100 = this.f568730b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        vpa.a r101 = this.f568731c;
        if (r101 == null) goto L10;
        if (r101 == this) goto L10;
        return r101.getSpinnerStyle();
    L10:
        View r102 = this.f568729a;
        if (r102 == null) goto L30;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof SmartRefreshLayout.LayoutParams) == false) goto L17;
        wpa.b r104 = ((SmartRefreshLayout.LayoutParams) r103).f405837b;
        this.f568730b = r104;
        if (r104 == null) goto L17;
        return r104;
    L17:
        if (r103 == null) goto L30;
        int r105 = r103.height;
        if (r105 != 0) goto L21;
    L22:
        wpa.b[] r106 = wpa.b.f560646g;
        int r107 = 0;
    L24:
        if (r107 >= 5) goto L30;
        wpa.b r108 = r106[r107];
        if (r108.f560648b == true) goto L27;
        r107 = r107 + 1;
        goto L24
    L27:
        this.f568730b = r108;
        return r108;
    L21:
        if (r105 == (-1)) goto L22;
    L30:
        wpa.b r109 = wpa.b.f560642c;
        this.f568730b = r109;
        return r109;
    }

    @Override // vpa.a
    public View getView() {
        View r100 = this.f568729a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(View r100) {
        if ((r100 instanceof vpa.a) == false) goto L5;
        vpa.a r101 = (vpa.a) r100;
    L6:
        super(r100.getContext(), null, 0);
        this.f568729a = r100;
        this.f568731c = r101;
        if ((this instanceof vpa.b) == false) goto L14;
        if ((r101 instanceof c) == false) goto L14;
        if (r101.getSpinnerStyle() != wpa.b.f560645f) goto L14;
        r101.getView().setScaleY(-1.0f);
        return;
    L14:
        if ((this instanceof c) == true) goto L16;
        return;
    L16:
        if ((r101 instanceof vpa.b) == true) goto L18;
        return;
    L18:
        if (r101.getSpinnerStyle() != wpa.b.f560645f) goto L24;
        r101.getView().setScaleY(-1.0f);
        return;
    L24:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean c(boolean r100) {
        vpa.a r101 = this.f568731c;
        if ((r101 instanceof vpa.b) == true) goto L5;
    L7:
        return false;
    L5:
        if (((vpa.b) r101).c(r100) == false) goto L7;
        return true;
    }

    public final boolean equals(Object r100) {
        if (super.equals(r100) == false) goto L5;
        return true;
    L5:
        if ((r100 instanceof vpa.a) == true) goto L7;
        return false;
    L7:
        if (getView() == ((vpa.a) r100).getView()) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // vpa.a
    public void setPrimaryColors(int... r100) {
        vpa.a r101 = this.f568731c;
        if (r101 == null) goto L7;
        if (r101 == this) goto L8;
        r101.setPrimaryColors(r100);
        return;
    L8:
        return;
    }

    @Override // vpa.a
    public final int i(d r100, boolean r101) {
        vpa.a r102 = this.f568731c;
        if (r102 == null) goto L7;
        if (r102 != this) goto L6;
        return 0;
    L6:
        return r102.i(r100, r101);
    L7:
        return 0;
    }

    @Override // vpa.a
    public final void d(float r100, int r101, int r102) {
        vpa.a r103 = this.f568731c;
        if (r103 == null) goto L7;
        if (r103 == this) goto L8;
        r103.d(r100, r101, r102);
        return;
    L8:
        return;
    }

    @Override // vpa.a
    public final void e(SmartRefreshLayout.i r100, int r101, int r102) {
        vpa.a r103 = this.f568731c;
        if (r103 == null) goto L6;
        if (r103 == this) goto L6;
        r103.e(r100, r101, r102);
        return;
    L6:
        View r104 = this.f568729a;
        if (r104 == null) goto L22;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof SmartRefreshLayout.LayoutParams) == false) goto L23;
        int r106 = ((SmartRefreshLayout.LayoutParams) r105).f405836a;
        SmartRefreshLayout r107 = r100.f405857a;
        if (r107.P1 != null) goto L15;
        if (r106 == 0) goto L15;
        r107.P1 = new Paint();
    L15:
        if (equals(r100.f405857a.H1) == false) goto L18;
        r100.f405857a.f405803g2 = r106;
        return;
    L18:
        if (equals(r100.f405857a.L1) == false) goto L25;
        r100.f405857a.f405806h2 = r106;
        return;
    L25:
        return;
    L23:
        return;
    }

    @Override // vpa.a
    public final void f(d r100, int r101, int r102) {
        vpa.a r103 = this.f568731c;
        if (r103 == null) goto L7;
        if (r103 == this) goto L8;
        r103.f(r100, r101, r102);
        return;
    L8:
        return;
    }

    @Override // vpa.a
    public final void g(d r100, int r101, int r102) {
        vpa.a r103 = this.f568731c;
        if (r103 == null) goto L7;
        if (r103 == this) goto L8;
        r103.g(r100, r101, r102);
        return;
    L8:
        return;
    }

    @Override // xpa.g
    public final void h(d r100, RefreshState r101, RefreshState r102) {
        vpa.a r103 = this.f568731c;
        if (r103 == null) goto L29;
        if (r103 != this) goto L6;
        return;
    L6:
        if ((this instanceof vpa.b) == false) goto L16;
        if ((r103 instanceof c) == false) goto L16;
        if (r101.isFooter == false) goto L13;
        r101 = r101.toHeader();
    L13:
        if (r102.isFooter == false) goto L25;
        r102 = r102.toHeader();
    L25:
        vpa.a r104 = this.f568731c;
        if (r104 == null) goto L31;
        r104.h(r100, r101, r102);
        return;
    L31:
        return;
    L16:
        if ((this instanceof c) == false) goto L25;
        if ((r103 instanceof vpa.b) == false) goto L25;
        if (r101.isHeader == false) goto L23;
        r101 = r101.toFooter();
    L23:
        if (r102.isHeader == false) goto L25;
        r102 = r102.toFooter();
        goto L25
    }

    @Override // vpa.a
    public final void b(boolean r100, float r101, int r102, int r110, int r111) {
        vpa.a r103 = this.f568731c;
        if (r103 == null) goto L7;
        if (r103 == this) goto L8;
        r103.b(r100, r101, r102, r110, r111);
        return;
    L8:
        return;
    }
}
