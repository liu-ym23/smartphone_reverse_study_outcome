package com.bytedance.ies.sve_list;

import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_core.e;
import com.bytedance.ies.sve_core.f;
import com.bytedance.ies.sve_core.i;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.q;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_core.s;
import com.bytedance.ies.sve_core.u;
import com.bytedance.ies.sve_list.a;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/sve_list/ListWidget;", "Lcom/bytedance/ies/sve_list/a;", "Item", "Lcom/bytedance/ies/sve_core/PureWidget;", "Lcom/bytedance/ies/sve_list/b;", "sve-view_release"}, k = 1, mv = {1, 4, 0})
public class ListWidget<Item extends a> extends PureWidget<b<Item>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f248709c = 0;

    @Override // com.bytedance.ies.sve_core.PureWidget, com.bytedance.ies.sve_core.q
    public final List<q<?>> Zo() {
        return null;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.sve_list;
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public final void Gq() {
        super.Gq();
        throw null;
    }

    @Override // com.bytedance.ies.sve_core.q
    public final void wj(p r100) {
        r.a.c(this, (b) r100, ListWidget$onUpdate$1.INSTANCE, new ListWidget$onUpdate$2(this));
    }

    @Override // com.bytedance.ies.sve_core.PureWidget, com.bytedance.ies.sve_core.r
    public final <S extends s> r<b<Item>> Yk(final u<S> r100, final Function1<? super i, ? extends com.bytedance.ies.sve_core.a> r101, Function2<? super S, ? super b<Item>, ? extends b<Item>> r102) {
        new ListWidget$connectStore$childConnectFunc$1(this, r100, r101);
        throw null;
    }

    @Override // com.bytedance.ies.sve_core.PureWidget
    public final <S extends s, C extends e> r<b<Item>> zq(final u<S> r100, final f<C> r101, final Function1<? super i, ? extends com.bytedance.ies.sve_core.a> r102, Function3<? super S, ? super C, ? super b<Item>, ? extends b<Item>> r103) {
        super.zq(r100, r101, r102, r103);
        new ListWidget$connectStoreWithConstant$childConnectFunc$1(this, r100, r101, r102);
        throw null;
    }
}
