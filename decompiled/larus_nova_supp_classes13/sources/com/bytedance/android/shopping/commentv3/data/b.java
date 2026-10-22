package com.bytedance.android.shopping.commentv3.data;

import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import com.bytedance.android.shopping.commentv3.audio.f;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.l;
import fc3.c;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mc3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public CommentParams a;
    public fc3.a b;
    public f c;
    public gc3.a d;
    public final d e;
    public final Map<String, String> f;
    public Map<String, String> g;
    public final CommentDataCenter h;
    public boolean i;
    public boolean j;

    public final int a() {
        CommentParams r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getDataType();
    }

    public final boolean b() {
        CommentDataCenter r0 = this.h;
        int r1 = r0.w.a();
        if (r1 != DataType.PRODUCT.getType()) goto L6;
        return r0.d;
    L6:
        if (r1 != DataType.SIMILAR.getType()) goto L9;
        return r0.e;
    L9:
        if (r1 != DataType.MIX.getType()) goto L18;
        if (r0.d == false) goto L13;
    L16:
        return true;
    L13:
        if (r0.d() == true) goto L15;
    L20:
        return false;
    L15:
        if (r0.e == false) goto L20;
    L18:
        if (r1 != DataType.FUSION.getType()) goto L20;
        return r0.f;
    }

    public final boolean c() {
        if (nc3.a.b(this.e.d.a, "multi_pic_mode", MultiPicMode.LIST.getMode()) != MultiPicMode.PIC.getMode()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        return false;
    L8:
        if (this.e.b.b() == false) goto L10;
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final void d() {
        CommentDataCenter r0 = this.h;
        r0.getClass();
        FetchFrom r5 = FetchFrom.LOAD_MORE;
        FetchFrom.monitorInteractionStart$default(r5, false, 1, null);
        r0.a(false, r0.w.e.b.f(), r0.w.e.b.c(), r5, null);
    }

    public b() {
        this.e = new d();
        this.f = new LinkedHashMap();
        this.h = new CommentDataCenter(this);
        boolean r0 = true;
        this.i = true;
        String r1 = y53.a.a;
        long r2 = q.a.getLong(y53.a.a, 0);
        if (System.currentTimeMillis() > r2) goto L6;
        r0 = false;
    L6:
        this.j = r0;
        new LinkedHashMap();
    }

    public final void e(FetchFrom r17, Boolean r18) {
        Intrinsics.checkNotNullParameter(r17, "from");
        if (r17 != FetchFrom.INIT) goto L38;
        mc3.a.C0218a r2 = mc3.a.b;
        CommentParams r10 = this.a;
        r2.getClass();
        if (r10 == null) goto L15;
        Map r3 = r10.getExtraParams();
        if (r3 == null) goto L15;
        if (r3.containsKey("first_filter") == false) goto L12;
    L14:
        String r4 = mc3.a.C0218a.c(r10, "first_filter");
        String r11 = mc3.a.C0218a.c(r10, "second_filter");
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("first_filter", r4);
        r12.put("second_filter", r11);
    L16:
        if (r12 == null) goto L20;
        int r5 = l.e;
        SlcCommonAction r6 = l.a.a(r12);
        fc3.a r7 = this.b;
        if (r7 == null) goto L42;
        r7.a(new c(r6, null, null, 14));
    L42:
        CommentDataCenter r8 = this.h;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r17, "from");
        r8.c = 0;
        r8.a = 0;
        r8.b = 0;
        r8.d = true;
        r8.e = true;
        r8.f = true;
        r8.m.postValue(null);
        r8.a(true, r8.w.e.b.f(), r8.w.e.b.c(), r17, r18);
        return;
    L20:
        mc3.a.C0218a.b();
        CommentParams r9 = this.a;
        if (r9 == null) goto L33;
        StatTagItem r13 = r9.getEnterClickTagItem();
        if (r13 == null) goto L33;
        CommentParams r14 = this.a;
        if (r14 == null) goto L27;
        long r15 = r14.getPassedTagVersion();
    L28:
        long r16 = r13.getId();
        String r19 = r13.getTagName();
        long r110 = r13.getSentiment();
        if (r13.isStat() == false) goto L31;
        TabTypeEnum r20 = TabTypeEnum.TAB;
    L32:
        int r21 = r20.getType();
        Intrinsics.checkNotNullParameter(r19, "name");
        LinkedHashMap r22 = new LinkedHashMap();
        r22.put("id", String.valueOf(r16));
        r22.put("name", r19);
        r22.put("sentiment", Long.valueOf(r110));
        r22.put("tag_type", Integer.valueOf(r21));
        r22.put("tag_version", Long.valueOf(r15));
        Unit r23 = Unit.INSTANCE;
        Map r24 = MapsKt.mapOf(TuplesKt.to("selected_tab", r22));
    L34:
        int r25 = l.e;
        SlcCommonAction r26 = l.a.a(r24);
        fc3.a r27 = this.b;
        if (r27 == null) goto L42;
        r27.a(new c(r26, null, null, 14));
        goto L42
    L31:
        r20 = TabTypeEnum.TAG;
        goto L32
    L27:
        r15 = 0;
    L33:
        r24 = mc3.a.C0218a.b();
        goto L34
    L12:
        if (r3.containsKey("second_filter") == true) goto L14;
    L15:
        r12 = null;
        goto L16
    L38:
        if (r17 != FetchFrom.SKU_SWITCH) goto L42;
        mc3.a.b.getClass();
        LinkedHashMap r28 = new LinkedHashMap();
        r28.putAll(mc3.a.C0218a.b());
        r28.put("selected_first", "");
        r28.put("selected_second", "");
        r28.put("first_filter", "");
        r28.put("second_filter", "");
        r28.put("sort_type", Integer.valueOf(SortType.DEFAULT.getType()));
        int r29 = l.e;
        SlcCommonAction r30 = l.a.a(r28);
        fc3.a r31 = this.b;
        if (r31 == null) goto L42;
        r31.a(new c(r30, null, null, 14));
        goto L42
    }
}
