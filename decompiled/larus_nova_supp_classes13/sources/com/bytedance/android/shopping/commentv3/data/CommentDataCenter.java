package com.bytedance.android.shopping.commentv3.data;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import com.bytedance.android.shopping.anchorv3.commentv2.model.CommentTabTypeEnum;
import com.bytedance.android.shopping.commentv3.audio.StopReason;
import com.bytedance.android.shopping.commentv3.audio.f;
import com.bytedance.android.shopping.commentv3.audio.y;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentGroup;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentSliceComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.ICommentComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.SubTitle;
import com.bytedance.android.shopping.commentv3.data.interfaces.ToastData;
import com.bytedance.android.shopping.commentv3.utils.InteractionPerfMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kc3.c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p53.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CommentDataCenter {
    public long a;
    public long b;
    public long c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public long i;
    public String j;
    public Map<String, String> k;
    public Map<String, String> l;
    public final MutableLiveData<lc3.a> m;
    public final List<CommentGroup> n;
    public final List<ICommentComponent> o;
    public final List<ICommentComponent> p;
    public CommentCachePool q;
    public final c<lc3.b> r;
    public final MutableLiveData<e> s;
    public final MutableLiveData<ToastData> t;
    public final MutableLiveData<SubTitle> u;
    public String v;
    public final b w;

    public final List<?> c() {
        Iterator<T> r0 = this.n.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((CommentGroup) r1).getSliceId(), GroupType.TAB.getType()) == false) goto L3;
    L9:
        CommentGroup r3 = (CommentGroup) r1;
        if (r3 == null) goto L27;
        List<CommentSliceComponent> r4 = r3.getSlices();
        if (r4 == null) goto L27;
        Iterator<T> r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L25;
        Object r6 = r5.next();
        CommentSliceComponent r7 = (CommentSliceComponent) r6;
        if (Intrinsics.areEqual(r7.getComponentType(), ComponentType.TAB_FILTER.getType()) == false) goto L19;
    L22:
        boolean r8 = true;
    L23:
        if (r8 == false) goto L15;
    L26:
        CommentSliceComponent r9 = (CommentSliceComponent) r6;
    L28:
        if (r9 == null) goto L30;
        Map<String, Object> r10 = r9.getData();
    L31:
        if (r10 == null) goto L34;
        Object r11 = r10.get("tabs");
        if (r11 == null) goto L34;
    L38:
        if ((r11 instanceof List) == false) goto L42;
        r2 = r11;
    L42:
        return (List) r2;
    L34:
        if (r10 == null) goto L36;
        r11 = r10.get("first_tabs");
        goto L38
    L36:
        r11 = null;
        goto L38
    L30:
        r10 = null;
        goto L31
    L19:
        if (Intrinsics.areEqual(r7.getComponentType(), ComponentType.COMMENT_FILTER_FIRST.getType()) == true) goto L22;
        r8 = false;
        goto L23
    L25:
        r6 = null;
    L27:
        r9 = null;
        goto L28
    L8:
        r1 = null;
        goto L9
    }

    public final boolean d() {
        mc3.a r0 = this.w.e.b;
        if (r0.c() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean r2 = this.w.f.isEmpty();
        if (this.w.e.c.a() != SortType.DEFAULT) goto L11;
        boolean r4 = true;
    L12:
        if (r1 == false) goto L16;
        if (r2 == false) goto L16;
        if (r4 == false) goto L16;
        return true;
    L16:
        return false;
    L11:
        r4 = false;
        goto L12
    L5:
        if (r0.f() != StatIdEnum.ALL.getId()) goto L7;
        r1 = true;
        goto L8
    }

    public CommentDataCenter(b r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.w = r2;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.m = new MutableLiveData();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new c();
        this.s = new MutableLiveData();
        this.t = new MutableLiveData();
        this.u = new MutableLiveData();
        this.v = "";
    }

    public final void e(lc3.b r10) {
        if (r10 == null) goto L22;
        FetchFrom r1 = r10.d;
        if (r1 == FetchFrom.LOAD_MORE) goto L21;
        b r2 = this.w;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "from");
        int r3 = a.a[r1.ordinal()];
        if (r3 != 1) goto L9;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L21;
        f r5 = r2.c;
        if (r5 == null) goto L21;
        f.a.a(r5, null, StopReason.LIST_REFRESH, new y(true, 6), null, 9);
        goto L21
    L9:
        if (r3 == 2) goto L15;
        if (r3 == 3) goto L15;
        if (r3 == 4) goto L15;
        r4 = true;
    L21:
        this.r.f(r10, true);
        return;
    L22:
        lc3.b r11 = this.r.d();
        if (r11 == null) goto L26;
        List r12 = r11.a;
        if (r12 == null) goto L26;
    L27:
        lc3.b r6 = this.r.d();
        if (r6 == null) goto L31;
        List r7 = r6.b;
        if (r7 == null) goto L31;
    L32:
        lc3.b r8 = this.r.d();
        if (r8 == null) goto L36;
        FetchFrom r9 = r8.d;
        if (r9 == null) goto L36;
    L37:
        lc3.b r13 = new lc3.b(r12, r7, true, r9);
        this.r.f(r13, true);
        return;
    L36:
        r9 = FetchFrom.OTHER;
    L31:
        r7 = new ArrayList();
    L26:
        r12 = new ArrayList();
        goto L27
    }

    public final void a(boolean r10, long r11, boolean r13, FetchFrom r14, Boolean r15) {
        int r0 = this.w.a();
        if (r0 != DataType.PRODUCT.getType()) goto L8;
        if (this.d == false) goto L28;
        b(r10, r11, r13, r14, false, r15);
        return;
    L28:
        return;
    L8:
        if (r0 != DataType.SIMILAR.getType()) goto L13;
        if (this.e == false) goto L30;
        b(r10, r11, r13, r14, true, r15);
        return;
    L30:
        return;
    L13:
        if (r0 != DataType.MIX.getType()) goto L23;
        if (this.d == false) goto L18;
        b(r10, r11, r13, r14, false, r15);
        return;
    L18:
        if (d() == true) goto L20;
        return;
    L20:
        if (this.e == false) goto L34;
        b(r10, r11, r13, r14, true, r15);
        return;
    L34:
        return;
    L23:
        if (r0 == DataType.FUSION.getType()) goto L25;
        return;
    L25:
        if (this.f == false) goto L37;
        b(r10, r11, r13, r14, this.w.e.e.a(), r15);
        return;
    }

    public final void b(final boolean r32, long r33, boolean r35, final FetchFrom r36, final boolean r37, Boolean r38) {
        InteractionPerfMonitor.a r0 = InteractionPerfMonitor.j;
        String r1 = r36.getPerfMobKey();
        r0.getClass();
        final InteractionPerfMonitor r3 = InteractionPerfMonitor.a.a(r1);
        if (r37 == false) goto L5;
        r3.f = System.currentTimeMillis();
    L7:
        if (r38 == null) goto L10;
        boolean r2 = r38.booleanValue();
    L14:
        final boolean r6 = r2;
    L15:
        if (r37 == false) goto L17;
        long r4 = this.b;
    L18:
        final long r7 = r4;
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("product_total_count", Long.valueOf(this.c));
        r5.put("meaningless_count", Long.valueOf(this.i));
        long r9 = 0;
        if (this.w.a() != DataType.MIX.getType()) goto L27;
        if (r37 == false) goto L27;
        if (r7 != 0) goto L27;
        String r8 = this.j;
        if (r8 == null) goto L27;
        r5.put("nps_info", r8);
    L27:
        if (r7 > 0) goto L29;
    L53:
        CommentParams r10 = this.w.a;
        if (r10 == null) goto L61;
        StatTagItem r11 = r10.getEnterClickTagItem();
        if (r11 == null) goto L61;
        if (r11.getId() != r33) goto L61;
        boolean r12 = false;
    L63:
        if (this.w.a() == DataType.FUSION.getType()) goto L65;
    L67:
        boolean r13 = false;
    L68:
        if (r12 == true) goto L72;
        if (r13 == true) goto L72;
        boolean r14 = false;
    L73:
        CommentParams r15 = this.w.a;
        if (r15 == null) goto L79;
        String r16 = r15.getTopCommentTypes();
        if (r16 == null) goto L79;
        if (r14 == true) goto L79;
        r5.put("top_comment_types", r16);
    L79:
        if (r37 == false) goto L84;
        if (this.h == true) goto L85;
    L87:
        long r17 = 50;
    L86:
        final long r29 = r17;
        int r18 = jc3.a.a;
        CommentParams r19 = this.w.a;
        if (r19 == null) goto L92;
        String r20 = r19.getExtraStr(r5);
        if (r20 == null) goto L92;
    L93:
        String r21 = r20;
        int r22 = this.w.e.c.a().getType();
        if (this.w.e.b.c() == true) goto L97;
        r9 = nc3.a.c(this.w.e.b.e(), "tag_version", CommentTabTypeEnum.STAT.getType());
    L97:
        long r24 = r9;
        b r23 = this.w;
        r23.getClass();
        Intrinsics.checkNotNullParameter(r36, "from");
        if (r36 == FetchFrom.INIT) goto L100;
    L106:
        String r25 = PreviousPageEnum.COMMENT_PAGE.getPage();
    L107:
        Map<String, Object> r110 = jc3.a.a(r19, r29, r33, r35, r7, r21, r37, r22, r6 ? 1 : 0, r24, r25, this.w.e.b.a(), this.w.e.b.d());
        boolean r111 = !o53.b.a();
        List<String> r112 = CollectionsKt.toMutableList(((LinkedHashMap) this.w.f).values());
        CommentCachePool r113 = this.q;
        if (r113 == null) goto L119;
        if (r14 == true) goto L116;
        if (r37 == true) goto L116;
        CommentParams r26 = this.w.a;
        if (r26 == null) goto L116;
        List<String> r27 = r26.getTopCommentIds();
    L117:
        r113.b(r110, r112, r27, r37, r111, false, this.w.a(), new CommentDataCenter$fetchReal$2(this, r37, r3, r32, r36, r6, r7, r29));
        return;
    L116:
        r27 = null;
        goto L117
    L119:
        return;
    L100:
        if (r23.i == false) goto L106;
        CommentParams r28 = r23.a;
        if (r28 == null) goto L106;
        if (r28.isFromProductDetail() != true) goto L106;
        r23.i = false;
        r25 = PreviousPageEnum.PRODUCT_DETAIL.getPage();
    L92:
        r20 = "";
    L85:
        r17 = 20;
        goto L86
    L84:
        if (this.g == false) goto L87;
    L72:
        r14 = true;
        goto L73
    L65:
        if (this.w.e.e.a() == true) goto L67;
        r13 = true;
    L61:
        r12 = true;
        goto L63
    L29:
        if (r37 == false) goto L41;
        Map<String, String> r114 = this.l;
        if (r114 != null) goto L33;
    L36:
        boolean r115 = true;
    L37:
        if (r115 == true) goto L41;
        Map<String, String> r116 = this.l;
        if (r116 == null) goto L53;
        r5.put("leeway_params", r116);
        goto L53
    L33:
        if (r114.isEmpty() == true) goto L36;
        r115 = false;
    L41:
        if (r37 == true) goto L53;
        Map<String, String> r117 = this.k;
        if (r117 != null) goto L45;
    L48:
        boolean r118 = true;
    L49:
        if (r118 == true) goto L53;
        Map<String, String> r119 = this.k;
        if (r119 == null) goto L53;
        r5.put("leeway_params", r119);
        goto L53
    L45:
        if (r117.isEmpty() == true) goto L48;
        r118 = false;
        goto L49
    L17:
        r4 = this.a;
        goto L18
    L10:
        if (this.w.a() != DataType.MIX.getType()) goto L13;
        if (r37 == false) goto L13;
        r6 = false;
    L13:
        r2 = r36.needFetchTab();
        goto L14
    L5:
        r3.d = System.currentTimeMillis();
        goto L7
    }
}
