package s6c;

import android.graphics.RectF;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.nova.R;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.tangram.engine.TangramNative;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends a {
    @Override // s6c.a
    public final a b() {
        String r100 = this.f540880a;
        String r101 = this.f540881b;
        b r102 = this.f540882c;
        TCStyle r103 = this.f540883d;
        if (r103 == null) goto L5;
        TCStyle r104 = r103.clone();
    L6:
        d r105 = new d(r100, r101, r102, r104, this.f540884e.clone());
        r105.f540885f = this.f540885f;
        r105.k(this.f540894o);
        r105.j(this.f540893n);
        r105.f540886g = this.f540886g;
        r105.f540887h = this.f540887h;
        r105.f540891l = this.f540891l;
        h();
        b.a r106 = this.f540889j;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f540889j = r106;
        b.a r107 = this.f540890k;
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r105.f540890k = r107;
        ArrayList<a> r108 = this.f540888i;
        ArrayList<a> r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L8:
        if (r110.hasNext() == false) goto L10;
        r109.add(((a) r110.next()).b());
        goto L8
    L10:
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r105.f540888i = r109;
        return r105;
    L5:
        r104 = null;
        goto L6
    }

    @Override // s6c.a
    public final View d() {
        b r100 = this.f540882c;
        if (r100 == null) goto L5;
        View r101 = r100.a(a());
    L6:
        if (r101 == null) goto L8;
        r101.setTag(R.id.virtual_node_id, this.f540880a);
    L8:
        if (r101 == null) goto L11;
        r101.setTag(R.id.view_class_name, this.f540881b);
    L11:
        if (this.f540886g == true) goto L14;
        return r101;
    L14:
        throw new IllegalStateException("render virtual node: createView is hidden!");
    L5:
        r101 = null;
        goto L6
    }

    @Override // s6c.a
    public final long c(int r100) {
        long r101 = TangramNative.newTLNodeNative();
        m(r101);
        if (this.f540887h == false) goto L5;
        TangramNative.setLayoutFunc(r101, this.f540880a);
        TangramNative.hashMap.put(this.f540880a, this);
    L5:
        return r101;
    }

    @Override // s6c.a
    public final boolean g(a r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        TCStyle r101 = this.f540883d;
        if (r101 == null) goto L5;
        r101.setDataChange(!Intrinsics.areEqual(r101, r100.f540883d));
    L5:
        Props r102 = this.f540884e;
        r102.setDataChange(!Intrinsics.areEqual(r102, r100.f540884e));
        TCStyle r103 = this.f540883d;
        if (r103 == null) goto L8;
        boolean r104 = r103.isDataChange();
    L9:
        if (r104 == false) goto L11;
        return true;
    L11:
        if (this.f540884e.isDataChange() == true) goto L16;
        return false;
    L16:
        return true;
    L8:
        r104 = false;
        goto L9
    }

    @Override // s6c.a
    public final void n(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L25;
        Intrinsics.checkNotNullParameter(r100, "view");
        b r101 = this.f540882c;
        boolean r102 = true;
        if (r101 == null) goto L7;
        r101.e(r100);
        boolean r103 = true;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        if (this.f540886g == false) goto L13;
        r100.setVisibility(8);
        return;
    L13:
        b r104 = this.f540882c;
        if (r104 == null) goto L16;
        r104.g();
    L17:
        if (r102 == false) goto L19;
        RectF r105 = a();
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(e.a(r100.getContext(), r105.width()), e.a(r100.getContext(), r105.height()));
        r106.leftMargin = e.a(r100.getContext(), r105.left);
        r106.topMargin = e.a(r100.getContext(), r105.top);
        r100.setLayoutParams(r106);
    L19:
        b r107 = this.f540882c;
        if (r107 == null) goto L22;
        r107.h(r100);
    L22:
        r100.setVisibility(0);
        return;
    L16:
        r102 = false;
        goto L17
    L7:
        r103 = false;
        goto L8
    L25:
        throw new IllegalStateException("render virtual node: updateView is not on main thread!");
    }

    public d(String r100, String r110, b r111, TCStyle r112, Props r113) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r110, "viewTypeIdentity");
        Intrinsics.checkNotNullParameter(r113, SlcElement.KEY_PROPS);
        super(r100, r110, r111, r112, r113, false);
    }
}
