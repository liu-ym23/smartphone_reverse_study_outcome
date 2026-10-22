package com.bytedance.android.shopping.mall.homepage;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.hybrid.list.prebind.ECHybridRecyclerViewPreBindHelper;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFragment$handleMemoryOperations$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JsonObject $operations;
    final /* synthetic */ ECMallFragment this$0;

    public ECMallFragment$handleMemoryOperations$1(ECMallFragment r1, JsonObject r2) {
        this.this$0 = r1;
        this.$operations = r2;
        super(0);
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.bytedance.android.shopping.api.mall.a, java.util.Iterator] */
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1163invoke() {
        ECMallFeed r0 = this.this$0.f;
        if (r0 == null) goto L140;
        JsonObject r1 = this.$operations;
        Intrinsics.checkNotNullParameter(r1, "operations");
        JsonElement r3 = r1.get("list");
        Boolean r5 = null;
        if ((r3 instanceof JsonObject) == true) goto L7;
        r3 = null;
    L7:
        JsonObject r4 = (JsonObject) r3;
        boolean r6 = false;
        if (r4 == null) goto L93;
        JsonElement r8 = r4.get("release_pool");
        if ((r8 instanceof JsonPrimitive) == true) goto L12;
        r8 = null;
    L12:
        JsonPrimitive r9 = (JsonPrimitive) r8;
        if (r9 != null) goto L15;
    L17:
        boolean r10 = false;
    L18:
        if (r10 == false) goto L51;
        ECHybridListEngine r11 = r0.J;
        if (r11 == null) goto L24;
        ECHybridRecyclerView r12 = r11.b;
        if (r12 == null) goto L24;
        RecyclerView.RecycledViewPool r13 = r12.getRecycledViewPool();
    L25:
        if (r13 == null) goto L27;
        r13.clear();
    L27:
        ECHybridListEngine r14 = r0.J;
        if (r14 == null) goto L46;
        ECHybridListAdapter r15 = r14.a;
        if (r15 == null) goto L46;
        Iterator r16 = r15.e.values().iterator();
    L33:
        if (r16.hasNext() == false) goto L38;
        Iterator r17 = ((Stack) r16.next()).iterator();
    L36:
        if (r17.hasNext() == false) goto L33;
        ((ECLynxCardHolder) r17.next()).onRelease();
        goto L36
    L38:
        r15.e.clear();
        Iterator r18 = r15.f.values().iterator();
    L40:
        if (r18.hasNext() == false) goto L45;
        Iterator r19 = ((Stack) r18.next()).iterator();
    L43:
        if (r19.hasNext() == false) goto L40;
        ((BaseViewHolder) r19.next()).onRelease();
        goto L43
    L45:
        r15.f.clear();
        Lazy r20 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.d.b, "ECHybridListAdapter#clearAllPreloads");
    L46:
        Lazy r21 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.k.d r22 = com.bytedance.android.ec.hybrid.log.mall.k.d.b;
        StringBuilder r110 = new StringBuilder("ECMallFeed#handleMemoryOperations, releasePool, target = ");
        if (r13 == null) goto L49;
        int r23 = r13.hashCode();
    L50:
        r110.append(r23);
        ECMallLogUtil.c(r22, r110.toString());
        goto L51
    L49:
        r23 = 0;
    L24:
        r13 = null;
    L51:
        JsonElement r24 = r4.get("disable_prebind");
        if ((r24 instanceof JsonPrimitive) == true) goto L54;
        r24 = null;
    L54:
        JsonPrimitive r25 = (JsonPrimitive) r24;
        if (r25 == null) goto L57;
        Boolean r26 = Boolean.valueOf(r25.getAsBoolean());
    L58:
        if (r26 == null) goto L72;
        ECHybridRecyclerViewPreBindHelper r27 = r0.K0;
        if (r27 == null) goto L63;
        r27.j = !r26.booleanValue();
    L63:
        if (r26.booleanValue() == false) goto L67;
        ECHybridRecyclerViewPreBindHelper r28 = r0.K0;
        if (r28 == null) goto L67;
        r28.a(true);
    L67:
        Lazy r29 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.k.d r30 = com.bytedance.android.ec.hybrid.log.mall.k.d.b;
        StringBuilder r111 = new StringBuilder("ECMallFeed#handleMemoryOperations, disablePrebind, ");
        r111.append(r26);
        r111.append(", target = ");
        ECHybridRecyclerViewPreBindHelper r31 = r0.K0;
        if (r31 == null) goto L70;
        int r32 = r31.hashCode();
    L71:
        r111.append(r32);
        ECMallLogUtil.c(r30, r111.toString());
        goto L72
    L70:
        r32 = 0;
    L72:
        JsonElement r7 = r4.get("disable_prefetch");
        if ((r7 instanceof JsonPrimitive) == true) goto L75;
        r7 = null;
    L75:
        JsonPrimitive r33 = (JsonPrimitive) r7;
        if (r33 == null) goto L78;
        Boolean r34 = Boolean.valueOf(r33.getAsBoolean());
    L79:
        if (r34 == null) goto L93;
        ECHybridListEngine r35 = r0.J;
        if (r35 == null) goto L85;
        ECHybridRecyclerView r36 = r35.b;
        if (r36 == null) goto L85;
        VirtualLayoutManager r37 = r36.getLayoutManager();
    L86:
        if (r37 == null) goto L88;
        r37.setItemPrefetchEnabled(!r34.booleanValue());
    L88:
        Lazy r38 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.k.d r39 = com.bytedance.android.ec.hybrid.log.mall.k.d.b;
        StringBuilder r112 = new StringBuilder("ECMallFeed#handleMemoryOperations, disablePrefetch, ");
        r112.append(r34);
        r112.append(", target = ");
        if (r37 == null) goto L91;
        int r40 = r37.hashCode();
    L92:
        r112.append(r40);
        ECMallLogUtil.c(r39, r112.toString());
        goto L93
    L91:
        r40 = 0;
    L85:
        r37 = null;
        goto L86
    L78:
        r34 = null;
        goto L79
    L57:
        r26 = null;
        goto L58
    L15:
        if (r9.getAsBoolean() != true) goto L17;
        r10 = true;
    L93:
        JsonElement r2 = r1.get("data");
        if ((r2 instanceof JsonObject) == true) goto L96;
        r2 = null;
    L96:
        JsonObject r41 = (JsonObject) r2;
        if (r41 == null) goto L141;
        ECMallFavoriteSectionHelper r42 = r0.V;
        r42.getClass();
        Intrinsics.checkNotNullParameter(r41, "operations");
        JsonElement r43 = r41.get("release_tabs");
        if ((r43 instanceof JsonPrimitive) == true) goto L101;
        r43 = null;
    L101:
        JsonPrimitive r44 = (JsonPrimitive) r43;
        if (r44 != null) goto L104;
    L106:
        if (r6 == false) goto L119;
        ArrayList r45 = new ArrayList();
        SparseArray<List<com.bytedance.android.ec.hybrid.list.entity.i>> r46 = r42.h;
        Intrinsics.checkNotNullParameter(r46, "$this$keyIterator");
        ?? r47 = new com.bytedance.android.shopping.api.mall.a(r46);
    L109:
        if (r47.hasNext() == false) goto L114;
        int r48 = ((Number) r47.next()).intValue();
        if (r48 == r42.y) goto L109;
        if (r48 == 0) goto L109;
        r45.add(Integer.valueOf(r48));
        goto L109
    L114:
        Iterator r49 = r45.iterator();
    L116:
        if (r49.hasNext() == false) goto L118;
        int r50 = ((Number) r49.next()).intValue();
        r42.y(r50);
        r42.o.remove(Integer.valueOf(r50));
        goto L116
    L118:
        Lazy r51 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.d.b, "ECMallFavoriteSectionHelper#handleMemoryOperations, releaseTabs, tabs = " + r45);
    L119:
        JsonElement r52 = r41.get("disable_image_file_cache");
        if ((r52 instanceof JsonPrimitive) == true) goto L122;
        r52 = null;
    L122:
        JsonPrimitive r53 = (JsonPrimitive) r52;
        if (r53 == null) goto L125;
        r5 = Boolean.valueOf(r53.getAsBoolean());
    L125:
        if (r5 == null) goto L142;
        com.bytedance.android.ec.hybrid.list.util.o r54 = com.bytedance.android.ec.hybrid.list.util.o.g;
        com.bytedance.android.ec.hybrid.list.util.o.e = !r5.booleanValue();
        Lazy r55 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.d.b, "ECMallFeed#handleMemoryOperations, disableImageFileCache, " + r5 + ", target = " + r54.hashCode());
        return;
    L142:
        return;
    L104:
        if (r44.getAsBoolean() != true) goto L106;
        r6 = true;
        goto L106
    L141:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1163invoke();
        return Unit.INSTANCE;
    }
}
