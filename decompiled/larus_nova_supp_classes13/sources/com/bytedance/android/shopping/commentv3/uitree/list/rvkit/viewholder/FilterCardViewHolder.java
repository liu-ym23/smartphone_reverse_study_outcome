package com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder;

import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentSliceComponent;
import com.bytedance.android.shopping.commentv3.view.CommentSliceView;
import com.bytedance.android.shopping.commentv3.view.FilterCardSliceView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mc3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/viewholder/FilterCardViewHolder;", "Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/viewholder/BaseSliceViewHolder;", "Lcom/bytedance/android/shopping/commentv3/view/FilterCardSliceView;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterCardViewHolder extends BaseSliceViewHolder<FilterCardSliceView> {
    public boolean j;
    public int k;
    public int l;
    public final a m;
    public Function1<? super Integer, Unit> n;

    public static final class a {
        public boolean a;

        public a() {
            this.a = true;
        }
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.BaseSliceViewHolder
    public final Map<String, Object> T3() {
        LinkedHashMap r0 = new LinkedHashMap();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("need_fold", Integer.valueOf(this.j ? 1 : 0));
        r1.put("is_fold", Integer.valueOf(this.m.a ? 1 : 0));
        Unit r2 = Unit.INSTANCE;
        r0.put("na_data", r1);
        com.bytedance.android.shopping.commentv3.data.b r3 = this.c;
        if (r3 == null) goto L9;
        d r4 = r3.e;
        if (r4 == null) goto L9;
        mc3.a r5 = r4.b;
        if (r5 == null) goto L9;
        r0.put("selected_tab", r5.e());
    L9:
        com.bytedance.android.shopping.commentv3.data.b r6 = this.c;
        String r7 = null;
        if (r6 == null) goto L21;
        d r8 = r6.e;
        if (r8 == null) goto L21;
        mc3.a r9 = r8.b;
        if (r9 == null) goto L21;
        Object r10 = r9.a.get("selected_first");
        if ((r10 instanceof Map) == true) goto L18;
        r10 = null;
    L18:
        Map r11 = (Map) r10;
        if (r11 == null) goto L21;
        r0.put("selected_first", r11);
    L21:
        com.bytedance.android.shopping.commentv3.data.b r12 = this.c;
        if (r12 == null) goto L33;
        d r13 = r12.e;
        if (r13 == null) goto L33;
        mc3.a r14 = r13.b;
        if (r14 == null) goto L33;
        Object r15 = r14.a.get("selected_second");
        if ((r15 instanceof Map) == true) goto L30;
        r15 = null;
    L30:
        Map r16 = (Map) r15;
        if (r16 == null) goto L33;
        r0.put("selected_second", r16);
    L33:
        com.bytedance.android.shopping.commentv3.data.b r17 = this.c;
        if (r17 == null) goto L40;
        d r18 = r17.e;
        if (r18 == null) goto L40;
        mc3.a r19 = r18.b;
        if (r19 == null) goto L40;
        r7 = r19.d();
    L40:
        if (r7 != null) goto L42;
        r7 = "";
    L42:
        r0.put("second_filter", r7);
        return r0;
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.BaseSliceViewHolder
    public final Map<String, fc3.b> U3(IAction r14) {
        Intrinsics.checkNotNullParameter(r14, "action");
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = ActionType.FILTER_EXPAND.getType();
        Intrinsics.checkNotNullParameter(r14, "$this$hasAction");
        Intrinsics.checkNotNullParameter(r1, "actionType");
        Map r3 = null;
        Object r4 = null;
        if (Intrinsics.areEqual(r14.getType(), r1) == true) goto L17;
        List r2 = r14.getActions();
        if (r2 == null) goto L15;
        Iterator r5 = r2.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((IAction) r6).getType(), r1) == false) goto L9;
    L14:
        IAction r7 = (IAction) r6;
    L16:
        if (r7 != null) goto L17;
        boolean r8 = false;
    L19:
        if (r8 == false) goto L33;
        String r9 = ActionType.FILTER_EXPAND.getType();
        Intrinsics.checkNotNullParameter(r14, "$this$getFields");
        if ((r14 instanceof SlcCommonAction) == false) goto L29;
        Object r15 = ((SlcCommonAction) r14).getData().get("fields");
        if ((r15 instanceof Map) == false) goto L27;
        r4 = r15;
    L27:
        r3 = (Map) r4;
    L29:
        if (r3 == null) goto L31;
        long r10 = nc3.a.c(r3, "anim_time", 200);
    L32:
        r0.put(r9, new hc3.b(r10, this.l, this.k, this.m, new FilterCardViewHolder$getActionParmas$1(this), this.n, this.a));
        goto L33
    L31:
        r10 = 200;
    L33:
        return r0;
    L13:
        r6 = null;
        goto L14
    L15:
        r7 = null;
    L17:
        r8 = true;
        goto L19
    }

    public FilterCardViewHolder(CommentSliceView r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2, r3);
        this.m = new a();
    }

    public final void Z3(final CommentSliceComponent r2, Function1<? super Integer, Unit> r3, FetchFrom r4) {
        Intrinsics.checkNotNullParameter(r2, "component");
        this.n = r3;
        W3(r2.getTemplate());
        if (r4 != null) goto L5;
    L7:
        FilterCardSliceView r5 = (FilterCardSliceView) this.a;
        if (r5 == null) goto L12;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L12;
        r6.height = -2;
        ((FilterCardSliceView) this.a).setLayoutParams(r6);
    L12:
        Map<String, Object> r7 = r2.getStyle();
        int r8 = 124;
        if (r7 == null) goto L15;
        r8 = nc3.a.b(r7, "fold_height", 124);
    L15:
        this.l = Y3(r8);
        FilterCardSliceView.a r9 = new FilterCardSliceView.a(null);
        r9.a = this.l;
        r9.b = new FilterCardViewHolder$resetParams$$inlined$apply$lambda$1(this, r2);
        r9.c = new FilterCardViewHolder$resetParams$$inlined$apply$lambda$2(this, r2);
        FilterCardSliceView r10 = (FilterCardSliceView) this.a;
        if (r10 == null) goto L18;
        r10.setConfigParams(r9);
    L18:
        X3(r2);
        FilterCardSliceView r11 = (FilterCardSliceView) this.a;
        if (r11 == null) goto L22;
        r11.post(new b(this));
        return;
    L22:
        return;
    L5:
        if (r4.getFrom() != FetchFrom.SKU_SWITCH.getFrom()) goto L7;
        this.m.a = true;
        goto L7
    }
}
