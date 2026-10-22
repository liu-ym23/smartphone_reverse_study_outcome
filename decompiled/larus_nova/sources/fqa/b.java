package fqa;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.e;
import cqa.f;
import cqa.h;

/* JADX INFO: loaded from: classes34.dex */
public abstract class b extends RelativeLayout implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f478466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public dqa.b f478467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f478468c;

    public boolean a() {
        f r100 = this.f478468c;
        if (r100 == null) goto L8;
        if (r100 == this) goto L8;
        if (r100.a() == false) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // cqa.f
    public dqa.b getSpinnerStyle() {
        dqa.b r100 = this.f478467b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        f r101 = this.f478468c;
        if (r101 == null) goto L10;
        if (r101 == this) goto L10;
        return r101.getSpinnerStyle();
    L10:
        View r102 = this.f478466a;
        if (r102 == null) goto L30;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof SmartRefreshLayout.LayoutParams) == false) goto L17;
        dqa.b r104 = ((SmartRefreshLayout.LayoutParams) r103).f405904b;
        this.f478467b = r104;
        if (r104 == null) goto L17;
        return r104;
    L17:
        if (r103 == null) goto L30;
        int r105 = r103.height;
        if (r105 != 0) goto L21;
    L22:
        dqa.b[] r106 = dqa.b.f469721h;
        int r107 = 0;
    L24:
        if (r107 >= 5) goto L30;
        dqa.b r108 = r106[r107];
        if (r108.f469724c == true) goto L27;
        r107 = r107 + 1;
        goto L24
    L27:
        this.f478467b = r108;
        return r108;
    L21:
        if (r105 == (-1)) goto L22;
    L30:
        dqa.b r109 = dqa.b.f469717d;
        this.f478467b = r109;
        return r109;
    }

    @Override // cqa.f
    public View getView() {
        View r100 = this.f478466a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(View r100) {
        if ((r100 instanceof f) == false) goto L5;
        f r101 = (f) r100;
    L6:
        super(r100.getContext(), null, 0);
        this.f478466a = r100;
        this.f478468c = r101;
        if ((this instanceof eqa.b) == false) goto L14;
        if ((r101 instanceof e) == false) goto L14;
        if (r101.getSpinnerStyle() != dqa.b.f469720g) goto L14;
        r101.getView().setScaleY(-1.0f);
        return;
    L14:
        if ((this instanceof eqa.c) == false) goto L22;
        f r102 = this.f478468c;
        if ((r102 instanceof cqa.d) == true) goto L18;
        return;
    L18:
        if (r102.getSpinnerStyle() != dqa.b.f469720g) goto L24;
        r101.getView().setScaleY(-1.0f);
        return;
    L24:
        return;
    L22:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public boolean c(boolean r100) {
        f r101 = this.f478468c;
        if ((r101 instanceof cqa.d) == true) goto L5;
    L7:
        return false;
    L5:
        if (((cqa.d) r101).c(r100) == false) goto L7;
        return true;
    }

    public boolean equals(Object r100) {
        if (super.equals(r100) == false) goto L5;
        return true;
    L5:
        if ((r100 instanceof f) == true) goto L7;
        return false;
    L7:
        if (getView() == ((f) r100).getView()) goto L13;
        return false;
    L13:
        return true;
    }

    public void setPrimaryColors(int... r100) {
        f r101 = this.f478468c;
        if (r101 == null) goto L7;
        if (r101 == this) goto L8;
        r101.setPrimaryColors(r100);
        return;
    L8:
        return;
    }

    public int j(SmartRefreshLayout r100, boolean r101) {
        f r102 = this.f478468c;
        if (r102 == null) goto L7;
        if (r102 != this) goto L6;
        return 0;
    L6:
        return r102.j(r100, r101);
    L7:
        return 0;
    }

    public b(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public void d(float r100, int r101, int r102) {
        f r103 = this.f478468c;
        if (r103 == null) goto L7;
        if (r103 == this) goto L8;
        r103.d(r100, r101, r102);
        return;
    L8:
        return;
    }

    public void e(h r100, RefreshState r101, RefreshState r102) {
        f r103 = this.f478468c;
        if (r103 == null) goto L29;
        if (r103 != this) goto L6;
        return;
    L6:
        if ((this instanceof eqa.b) == false) goto L16;
        if ((r103 instanceof e) == false) goto L16;
        if (r101.isFooter == false) goto L13;
        r101 = r101.toHeader();
    L13:
        if (r102.isFooter == false) goto L25;
        r102 = r102.toHeader();
    L25:
        f r104 = this.f478468c;
        if (r104 == null) goto L31;
        r104.e(r100, r101, r102);
        return;
    L31:
        return;
    L16:
        if ((this instanceof eqa.c) == false) goto L25;
        if ((r103 instanceof cqa.d) == false) goto L25;
        if (r101.isHeader == false) goto L23;
        r101 = r101.toFooter();
    L23:
        if (r102.isHeader == false) goto L25;
        r102 = r102.toFooter();
        goto L25
    }

    public void f(h r100, int r101, int r102) {
        f r103 = this.f478468c;
        if (r103 == null) goto L7;
        if (r103 == this) goto L8;
        r103.f(r100, r101, r102);
        return;
    L8:
        return;
    }

    public void g(SmartRefreshLayout.j r100, int r101, int r102) {
        f r103 = this.f478468c;
        if (r103 == null) goto L6;
        if (r103 == this) goto L6;
        r103.g(r100, r101, r102);
        return;
    L6:
        View r104 = this.f478466a;
        if (r104 == null) goto L13;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof SmartRefreshLayout.LayoutParams) == false) goto L14;
        r100.c(this, ((SmartRefreshLayout.LayoutParams) r105).f405903a);
        return;
    L14:
        return;
    }

    public void i(h r100, int r101, int r102) {
        f r103 = this.f478468c;
        if (r103 == null) goto L7;
        if (r103 == this) goto L8;
        r103.i(r100, r101, r102);
        return;
    L8:
        return;
    }

    public void b(boolean r100, float r101, int r102, int r110, int r111) {
        f r103 = this.f478468c;
        if (r103 == null) goto L7;
        if (r103 == this) goto L8;
        r103.b(r100, r101, r102, r110, r111);
        return;
    L8:
        return;
    }
}
