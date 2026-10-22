package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView;
import com.bytedance.ee.util.ui.j;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements WikiHorizontalScrollView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f241677a;

    public b(a r100) {
        this.f241677a = r100;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiHorizontalScrollView.a
    public final void onScrollChanged() {
        a r100 = this.f241677a;
        RecyclerView r101 = r100.f241673c;
        if (r101 == null) goto L14;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        View r104 = r101.getChildAt(r103);
        if ((r104 instanceof WikItemRootView) == false) goto L9;
    L10:
        WikiHorizontalScrollView r105 = r100.f241672b;
        if (r105 == null) goto L13;
        r104.setScrollX(-r105.getScrollX());
    L13:
        r103 = r103 + 1;
        goto L5
    L9:
        if ((r104 instanceof WikItemLeafView) == true) goto L13;
    L14:
        RecyclerView r106 = this.f241677a.f241673c;
        if (r106 == null) goto L32;
        int r107 = r106.getChildCount();
        int r108 = 0;
    L17:
        if (r108 >= r107) goto L32;
        View r109 = r106.getChildAt(r108);
        if ((r109 instanceof WikItemLeafView) == false) goto L21;
        WikItemLeafView r110 = (WikItemLeafView) r109;
    L22:
        if (r110 != null) goto L24;
    L26:
        boolean r111 = false;
    L27:
        if (r111 == false) goto L31;
        int r112 = r106.getChildAdapterPosition(r110);
        RecyclerView.Adapter r113 = r106.getAdapter();
        if (r113 == null) goto L31;
        r113.notifyItemChanged(r112);
    L31:
        r108 = r108 + 1;
        goto L17
    L24:
        if (r110.f242239r != true) goto L26;
        r111 = true;
        goto L27
    L21:
        r110 = null;
    L32:
        RecyclerView r114 = this.f241677a.f241673c;
        if (r114 == null) goto L46;
        int r115 = r114.getChildCount();
        int r116 = 0;
    L35:
        if (r116 >= r115) goto L46;
        View r117 = r114.getChildAt(r116).findViewById(R.id.swipe_menu_layout);
        if (r117 != null) goto L39;
    L41:
        boolean r118 = false;
    L42:
        if (r118 == true) goto L45;
        if (r117 == null) goto L45;
        r117.setScrollX(0);
    L45:
        r116 = r116 + 1;
        goto L35
    L39:
        if (r117.getScrollX() != 0) goto L41;
        r118 = true;
    L46:
        a r119 = this.f241677a;
        j.e(r119.f241675e);
        j.d(r119.f241675e, 300);
    }
}
