package com.ss.android.lark.blueprint;

import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larus.nova.R;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class a<Data> implements q<Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f410630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m<Data> f410631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f410632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, ViewGroup> f410633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f410634e;

    /* JADX INFO: renamed from: com.ss.android.lark.blueprint.a$a, reason: collision with other inner class name */
    public static final class C4771a {
    }

    static {
    }

    public abstract Map<v, Integer> t();

    public abstract View u(ViewGroup r100);

    @Override // com.ss.android.lark.blueprint.q
    public abstract /* synthetic */ void update(Data r100);

    public void v() {
    }

    public final View r() {
        View r100 = this.f410632c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(RootDescription.ROOT_ELEMENT);
        return null;
    }

    public static int w(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.getChildCount();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (r100.getChildAt(r102).getVisibility() != 0) goto L7;
        r103 = r103 + 1;
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        return r103;
    }

    @Override // com.ss.android.lark.blueprint.q
    public final k a(IMMessageKeys$Blocks r100) {
        Intrinsics.checkNotNullParameter(r100, "blockKey");
        Iterator<T> r101 = t().keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        k<?> r102 = f(r100, (v) r101.next());
        if (r102 == null) goto L4;
        return r102;
    L8:
        return null;
    }

    @Override // com.ss.android.lark.blueprint.q
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (this.f410632c != null) goto L6;
        this.f410632c = u(r100);
        v();
    L6:
        return r();
    }

    @Override // com.ss.android.lark.blueprint.q
    public void l(Data r100) {
        Iterator<v> r101 = t().keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L18;
        ViewGroup r102 = s(r101.next());
        if (r102 == null) goto L4;
        int r103 = r102.getChildCount();
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r105 >= r103) goto L13;
        if (r102.getChildAt(r105).getVisibility() == 0) goto L11;
        r105 = r105 + 1;
        goto L8
    L11:
        boolean r106 = true;
    L14:
        if (r106 == true) goto L17;
        r104 = 8;
    L17:
        r102.setVisibility(r104);
        goto L4
    L13:
        r106 = false;
        goto L14
    }

    public final ViewGroup s(v r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Integer r101 = t().get(r100);
        if (r101 == null) goto L12;
        int r102 = r101.intValue();
        if (this.f410633d.containsKey(Integer.valueOf(r102)) == false) goto L8;
        Map<Integer, ViewGroup> r103 = this.f410633d;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        return (ViewGroup) r104.get(Integer.valueOf(r102));
    L8:
        ViewGroup r105 = (ViewGroup) r().findViewById(r102);
        if (r105 == null) goto L11;
        Integer r106 = Integer.valueOf(r102);
        this.f410633d.put(r106, r105);
    L11:
        return r105;
    L12:
        return null;
    }

    public a(g r100, BlueprintCell r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        this.f410630a = r100;
        this.f410631b = r101;
        this.f410633d = new LinkedHashMap();
        this.f410634e = LazyKt.lazy(LazyThreadSafetyMode.NONE, new AbsLayout$inflater$2(this));
    }

    public static k q(ViewGroup r100, j r101) {
        if (r100.getChildCount() != 0) goto L5;
        return null;
    L5:
        int r102 = r100.getChildCount();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L14;
        View r104 = r100.getChildAt(r103);
        Intrinsics.checkNotNull(r104);
        if (Intrinsics.areEqual(yza.a.a(r104), r101) == true) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Object r105 = r104.getTag(R.id.blueprint_block_view);
        if ((r105 instanceof k) == true) goto L12;
        return null;
    L12:
        return (k) r105;
    L14:
        return null;
    }

    @Override // com.ss.android.lark.blueprint.q
    public final k<?> f(j r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "blockKey");
        Intrinsics.checkNotNullParameter(r101, "slotId");
        ViewGroup r102 = s(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return q(r102, r100);
    }

    @Override // com.ss.android.lark.blueprint.q
    public final k<?> o(j r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "blockKey");
        Intrinsics.checkNotNullParameter(r101, "slotId");
        ViewGroup r102 = s(r101);
        if (r102 == null) goto L15;
        k<?> r103 = q(r102, r100);
        if (r103 == null) goto L19;
        r102.removeView(r103.getView());
        int r104 = r102.getChildCount();
        boolean r105 = false;
        int r106 = 0;
    L7:
        if (r106 >= r104) goto L12;
        if (r102.getChildAt(r106).getVisibility() == 0) goto L10;
        r106 = r106 + 1;
        goto L7
    L10:
        r105 = true;
    L12:
        if (r105 == true) goto L14;
        r102.setVisibility(8);
    L14:
        return r103;
    L19:
        return null;
    L15:
        return null;
    }

    @Override // com.ss.android.lark.blueprint.q
    public final <ViewType extends View, BlockViewType extends k<ViewType>> BlockViewType c(j r100, v r101, Function1<? super BlueprintLayoutInflater, ? extends BlockViewType> r102) {
        Intrinsics.checkNotNullParameter(r100, "blockKey");
        Intrinsics.checkNotNullParameter(r101, "slotId");
        Intrinsics.checkNotNullParameter(r102, "create");
        BlockViewType r103 = (BlockViewType) f(r100, r101);
        if ((r103 instanceof k) == true) goto L6;
        r103 = null;
    L6:
        if (r103 != null) goto L26;
        BlockViewType r104 = r102.invoke((BlueprintLayoutInflater) this.f410634e.getValue());
        Intrinsics.checkNotNullParameter(r100, "blockKey");
        Intrinsics.checkNotNullParameter(r101, "slotId");
        Intrinsics.checkNotNullParameter(r104, "blockView");
        ViewGroup r105 = s(r101);
        if (r105 == null) goto L25;
        int r106 = 0;
        r105.setVisibility(0);
        if (q(r105, r100) != null) goto L25;
        View r107 = r104.getView();
        r107.setTag(R.id.blueprint_block_view, r104);
        r107.setTag(R.id.blueprint_block_key, r100);
        int r108 = -1;
        if (r105.getChildCount() == 0) goto L24;
        int r109 = this.f410631b.g(r100);
        int r110 = r105.getChildCount();
    L16:
        if (r106 >= r110) goto L24;
        View r111 = r105.getChildAt(r106);
        Intrinsics.checkNotNull(r111);
        j r112 = yza.a.a(r111);
        if (r112 == null) goto L20;
        int r113 = this.f410631b.g(r112);
    L21:
        if (r113 > r109) goto L22;
        r106 = r106 + 1;
        goto L16
    L22:
        r108 = r106;
        goto L24
    L20:
        r113 = -1;
    L24:
        r105.addView(r107, r108);
    L25:
        return r104;
    L26:
        return r103;
    }
}
