package com.bytedance.ies.sve_list;

import com.bytedance.ies.sve_core.PureViewImplDelegate;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_core.e;
import com.bytedance.ies.sve_core.f;
import com.bytedance.ies.sve_core.i;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_core.s;
import com.bytedance.ies.sve_core.u;
import com.bytedance.ies.sve_list.a;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/sve_list/RecyclerViewItemWidget;", "Lcom/bytedance/ies/sve_list/a;", "P", "Lcom/bytedance/ies/sve_core/PureWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "sve-view_release"}, k = 1, mv = {1, 4, 0})
public abstract class RecyclerViewItemWidget<P extends com.bytedance.ies.sve_list.a> extends PureWidget<P> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f248714i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Function0<Object>> f248715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Function0<Object>> f248716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f248717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public P f248718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SVEAdapter<? super P, ?> f248719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<RecyclerViewItemWidget<P>, Object> f248720h;

    public static final class a {
    }

    static {
    }

    public RecyclerViewItemWidget() {
        this(null, null);
    }

    public boolean Qq() {
        return true;
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public void Fq() {
        super.Fq();
        Function1<RecyclerViewItemWidget<P>, Object> r100 = this.f248720h;
        if (r100 == null) goto L5;
        r100.invoke(this);
    L5:
        Objects.toString(this.f248718f);
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public void Gq() {
        super.Gq();
        PureViewImplDelegate r100 = this.f248681b;
        ((LinkedHashMap) r100.f248679k).clear();
        ((LinkedHashMap) r100.f248678j).clear();
        ((ArrayList) r100.f248675g).clear();
        Objects.toString(this.f248718f);
    }

    public void Pq(P r100) {
        super.wq(r100);
        this.f248718f = r100;
        if ((!Intrinsics.areEqual(this.f248717e, r100.getId())) == false) goto L16;
        r100.getId();
        this.f248717e = r100.getId();
        PureViewImplDelegate r101 = this.f248681b;
        ((LinkedHashMap) r101.f248679k).clear();
        ((LinkedHashMap) r101.f248678j).clear();
        ((ArrayList) r101.f248675g).clear();
        Iterator r102 = ((ArrayList) this.f248716d).iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        ((Function0) r102.next()).invoke();
        goto L6
    L8:
        Iterator r103 = ((ArrayList) this.f248715c).iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        ((Function0) r103.next()).invoke();
        goto L10
    L12:
        Aq(new RecyclerViewItemWidget$afterUpdate$3(this));
        return;
    }

    public void Rq(P r100) {
        Objects.toString(r100);
        wj(r100);
        Pq(r100);
        String r101 = this.f248717e;
        if (r101 == null) goto L27;
        SVEAdapter<? super P, ?> r102 = this.f248719g;
        if (r102 == null) goto L28;
        Collection r103 = r102.f248721a;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = ((ArrayList) r103).iterator();
        int r106 = 0;
    L8:
        if (r105.hasNext() == false) goto L20;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        com.bytedance.ies.sve_list.a r109 = (com.bytedance.ies.sve_list.a) r107;
        if (Intrinsics.areEqual(r109.getId(), r101) == false) goto L19;
        if ((!Intrinsics.areEqual(r109, r100)) == false) goto L29;
        if (r109.b(r100) == true) goto L30;
        r109 = r100;
        goto L19
    L30:
        return;
    L29:
        return;
    L19:
        r104.add(r109);
        r106 = r108;
        goto L8
    L20:
        ((ArrayList) r102.f248721a).clear();
        ((ArrayList) r102.f248721a).addAll(r104);
        return;
    L28:
        return;
    }

    @Override // com.bytedance.ies.sve_core.PureWidget, com.bytedance.ies.sve_core.q
    public /* bridge */ /* synthetic */ void rm(p r100) {
        Rq((com.bytedance.ies.sve_list.a) r100);
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public /* bridge */ /* synthetic */ void wq(p r100) {
        Pq((com.bytedance.ies.sve_list.a) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerViewItemWidget(SVEAdapter<? super P, ?> r100, Function1<? super RecyclerViewItemWidget<P>, ? extends Object> r101) {
        super(null);
        this.f248719g = r100;
        this.f248720h = r101;
        this.f248715c = new ArrayList();
        this.f248716d = new ArrayList();
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public final r<P> Bq(PureWidget<?> r100, int r101) {
        throw new IllegalStateException("recyclerViewItemWidget中不支持该方法，请使用重载函数传入contentView");
    }

    @Override // com.bytedance.ies.sve_core.PureWidget, com.bytedance.ies.sve_core.r
    public final <S extends s> r<P> Yk(final u<S> r100, final Function1<? super i, ? extends com.bytedance.ies.sve_core.a> r101, final Function2<? super S, ? super P, ? extends P> r102) {
        Function r103 = new RecyclerViewItemWidget$connectStore$childConnectFunc$1(this, r100, r101, r102);
        ((ArrayList) this.f248715c).add(r103);
        return this;
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public final <S extends s, C extends e> r<P> zq(final u<S> r100, final f<C> r101, final Function1<? super i, ? extends com.bytedance.ies.sve_core.a> r110, final Function3<? super S, ? super C, ? super P, ? extends P> r111) {
        Function r102 = new RecyclerViewItemWidget$connectStoreWithConstant$childConnectFunc$1(this, r100, r101, r110, r111);
        ((ArrayList) this.f248715c).add(r102);
        return this;
    }

    public static final /* synthetic */ PureViewImplDelegate Nq(RecyclerViewItemWidget r100, u r101, f r102, Function1 r103, Function3 r104) {
        return (PureViewImplDelegate) super.zq(r101, r102, r103, r104);
    }
}
