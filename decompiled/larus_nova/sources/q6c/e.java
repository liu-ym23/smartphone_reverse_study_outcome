package q6c;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.TCStyle;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r6c.a;

/* JADX INFO: loaded from: classes38.dex */
public class e<P extends Props, U extends View, D extends r6c.a> extends b<D> implements s6c.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final P f531880e;

    public View a(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        return null;
    }

    public void b() {
    }

    public s6c.b.a d(s6c.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        return r100;
    }

    public void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // s6c.b
    public final void f() {
    }

    @Override // s6c.b
    public final void g() {
    }

    public boolean j() {
        return this instanceof com.ss.android.lark.chat.preview.components.a;
    }

    public void update(U r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // q6c.c
    public final s6c.a c() {
        String r100 = this.f531876b;
        String r101 = i();
        TCStyle r102 = this.f531877c;
        if (r102 == null) goto L5;
        TCStyle r103 = r102.clone();
    L6:
        s6c.d r104 = new s6c.d(r100, r101, this, r103, this.f531880e.clone());
        AbstractCollection r105 = this.f531878d;
        if (r105 == null) goto L13;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L10:
        if (r107.hasNext() == false) goto L12;
        r106.add(((a) r107.next()).c());
        goto L10
    L12:
        ArrayList<s6c.a> r108 = new ArrayList(r106);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r104.f540888i = r108;
    L13:
        r104.f540887h = j();
        r104.f540882c = this;
        return r104;
    L5:
        r103 = null;
        goto L6
    }

    @Override // s6c.b
    public final void h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f531880e.applyToView(r100);
        update(r100);
    }

    public e(P r100, TCStyle r101, D r102) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        Intrinsics.checkNotNullParameter(r102, "dependency");
        super(r102, r101);
        this.f531880e = r100;
        AbstractCollection r103 = this.f531878d;
        if (r103 == null) goto L6;
        r103.isEmpty();
        return;
    }
}
