package com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.i;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EntranceType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentSliceComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentTemplate;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.SliceUpdateEvent;
import com.bytedance.android.shopping.commentv3.view.CommentSliceView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import ic3.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/viewholder/BaseSliceViewHolder;", "Lcom/bytedance/android/shopping/commentv3/view/CommentSliceView;", "SliceCardView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseSliceViewHolder<SliceCardView extends CommentSliceView> extends RecyclerView.ViewHolder {
    public final SliceCardView a;
    public final SlcRenderContext b;
    public final com.bytedance.android.shopping.commentv3.data.b c;
    public CommentSliceComponent d;
    public Function0<Integer> e;
    public int f;
    public CommentTemplate g;
    public final String h;
    public final c i;

    public Map<String, Object> T3() {
        return null;
    }

    public Map<String, fc3.b> U3(IAction r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return null;
    }

    public final String V3() {
        CommentSliceComponent r0 = this.d;
        if (r0 == null) goto L6;
        String r1 = r0.getSliceId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "default_id";
    }

    public final void W3(CommentTemplate r12) {
        if (r12 == null) goto L5;
        String r1 = r12.getUrl();
    L6:
        if (r12 == null) goto L8;
        String r2 = r12.getName();
    L9:
        if (r1 == null) goto L24;
        if (r2 != null) goto L12;
        return;
    L12:
        if (this.b != null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(this.g, r12) == true) goto L28;
        dm.a.b r3 = dm.a.a;
        dm.a.a(this.h).i("initSlcTemplate, sliceId: ".concat(V3()));
        int r4 = e.a;
        com.bytedance.android.shopping.commentv3.data.b r5 = this.c;
        if (r5 == null) goto L19;
        fc3.a r6 = r5.b;
    L20:
        e.a.a(r6, EventName.STATE.getEvent(), EntranceType.SLICE_BIND_DATA.getType(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class: " + this.h + ", method: initSlcTemplate, sliceId: " + V3())}), null, null, 240);
        this.g = r12;
        SliceCardView r13 = this.a;
        if (r13 == null) goto L27;
        a r7 = new a(this);
        SlcRenderContext r8 = this.b;
        Intrinsics.checkNotNullParameter(r7, "actionHandler");
        Intrinsics.checkNotNullParameter(r1, "url");
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r8, "slcRenderContext");
        i r9 = new i(r1, r2, "");
        KProperty[] r10 = SlcRenderContext.n0;
        r r0 = r8.c(r9, null);
        r0.b(r7);
        r13.removeAllViews();
        r13.addView(r0.c, new ViewGroup.LayoutParams(-1, -1));
        r13.f = r0;
        return;
    L27:
        return;
    L19:
        r6 = null;
        goto L20
    L28:
        return;
    L24:
        return;
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final void X3(CommentSliceComponent r11) {
        if (r11 == null) goto L4;
        this.d = r11;
    L4:
        SliceCardView r0 = this.a;
        fc3.a r2 = null;
        if (r0 == null) goto L16;
        if (r11 == null) goto L8;
        Map<String, ? extends Object> r12 = r11.getStyle();
    L9:
        Function0<Integer> r3 = this.e;
        if (r3 == null) goto L14;
        Integer r4 = (Integer) r3.invoke();
        if (r4 == null) goto L14;
        int r5 = r4.intValue();
    L15:
        r0.b(r12, r5, this.f);
    L14:
        r5 = 0;
        goto L15
    L8:
        r12 = null;
    L16:
        dm.a.b r13 = dm.a.a;
        dm.a.a(this.h).i("innerBindData, sliceId: ".concat(V3()));
        int r14 = e.a;
        com.bytedance.android.shopping.commentv3.data.b r15 = this.c;
        if (r15 == null) goto L19;
        r2 = r15.b;
    L19:
        e.a.a(r2, EventName.STATE.getEvent(), EntranceType.SLICE_BIND_DATA.getType(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class: " + this.h + ", method: innerBindData, sliceId: " + V3())}), null, null, 240);
        SliceCardView r16 = this.a;
        if (r16 == null) goto L35;
        LinkedHashMap r1 = new LinkedHashMap();
        CommentSliceComponent r6 = this.d;
        if (r6 == null) goto L26;
        Map<String, Object> r7 = r6.getData();
        if (r7 == null) goto L26;
        r1.putAll(r7);
    L26:
        Map<String, Object> r8 = T3();
        if (r8 == null) goto L29;
        r1.putAll(r8);
    L29:
        Map r9 = SliceRender.a(r1);
        String r10 = V3();
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "uniqueNodeId");
        r r17 = r16.f;
        if (r17 == null) goto L32;
        r17.a(r9, r10);
    L32:
        r r18 = r16.f;
        if (r18 == null) goto L35;
        SliceUpdateEvent.e.update(r10, r18);
    L35:
        SliceCardView r19 = this.a;
        if (r19 == null) goto L39;
        ExtensionsKt.visible(r19);
        return;
    }

    public final int Y3(int r2) {
        SliceCardView r0 = this.a;
        if (r0 == null) goto L6;
        return r0.c(r2);
    L6:
        return com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseSliceViewHolder(CommentSliceView r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.i = r3;
        this.a = r2;
        com.bytedance.android.shopping.commentv3.data.b r4 = null;
        if (r3 == null) goto L5;
        SlcRenderContext r0 = r3.c;
    L6:
        this.b = r0;
        if (r3 == null) goto L9;
        r4 = r3.e;
    L9:
        this.c = r4;
        this.h = "BaseSliceViewHolder";
        return;
    L5:
        r0 = null;
        goto L6
    }
}
