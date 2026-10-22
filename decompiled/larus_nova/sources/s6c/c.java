package s6c;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.TCStyle;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class c<P extends Props> extends a {
    @Override // s6c.a
    public final View d() {
        return null;
    }

    @Override // s6c.a
    public final void n(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // s6c.a
    public final a b() {
        c r100 = new c(this.f540880a, this.f540881b, this.f540884e, this.f540883d);
        r100.k(this.f540894o);
        r100.j(this.f540893n);
        r100.f540886g = this.f540886g;
        r100.f540887h = this.f540887h;
        r100.f540891l = this.f540891l;
        h();
        b.a r101 = this.f540889j;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f540889j = r101;
        b.a r102 = this.f540890k;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f540890k = r102;
        ArrayList<a> r103 = this.f540888i;
        ArrayList<a> r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(((a) r105.next()).b());
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r100.f540888i = r104;
        return r100;
    }

    @Override // s6c.a
    public final boolean g(a r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        if (Intrinsics.areEqual(this.f540884e, r100.f540884e) == true) goto L6;
        this.f540884e.setDataChange(true);
        return true;
    L6:
        this.f540884e.setDataChange(false);
        return false;
    }

    public c(String r100, String r110, P r111, TCStyle r112) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r110, "viewTypeIdentity");
        Intrinsics.checkNotNullParameter(r111, SlcElement.KEY_PROPS);
        super(r100, r110, null, r112, r111, true);
    }
}
