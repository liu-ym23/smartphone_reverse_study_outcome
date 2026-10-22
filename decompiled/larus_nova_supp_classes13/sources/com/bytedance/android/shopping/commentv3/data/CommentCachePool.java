package com.bytedance.android.shopping.commentv3.data;

import com.bytedance.android.shopping.commentv3.action.handler.tracker.EntranceType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentGroup;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentGroupList;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentResponse;
import com.bytedance.android.shopping.commentv3.data.interfaces.ICommentFetchApi;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import ic3.e;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CommentCachePool {
    public final Lazy a;
    public CommentResponse b;
    public final Map<String, a> c;
    public boolean d;
    public boolean e;
    public String f;
    public fc3.a g;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/CommentCachePool$RequestStatus;", "", "", "status", "I", "getStatus", "()I", "STATUS_DEFAULT", "STATUS_REQUESTING", "STATUS_READY", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RequestStatus extends Enum<RequestStatus> {
        public static final RequestStatus STATUS_DEFAULT = null;
        public static final RequestStatus STATUS_READY = null;
        public static final RequestStatus STATUS_REQUESTING = null;
        public static final /* synthetic */ RequestStatus[] a = null;
        private final int status;

        static {
            RequestStatus r1 = new RequestStatus("STATUS_DEFAULT", 0, -1);
            STATUS_DEFAULT = r1;
            RequestStatus r2 = new RequestStatus("STATUS_REQUESTING", 1, 0);
            STATUS_REQUESTING = r2;
            RequestStatus r3 = new RequestStatus("STATUS_READY", 2, 1);
            STATUS_READY = r3;
            a = new RequestStatus[]{r1, r2, r3};
        }

        public static RequestStatus valueOf(String r1) {
            return (RequestStatus) r27.a.a(RequestStatus.class, r1);
        }

        public static RequestStatus[] values() {
            return (RequestStatus[]) a.clone();
        }

        public final int getStatus() {
            return this.status;
        }

        public RequestStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.status = r3;
        }
    }

    public static final class a {
        public int a;
        public CommentResponse b;
        public Function2<? super Boolean, ? super CommentResponse, Unit> c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            CommentResponse r1 = this.b;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            Function2<? super Boolean, ? super CommentResponse, Unit> r5 = this.c;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "CommentRspCache(requestStatus=" + this.a + ", response=" + this.b + ", waitingCallback=" + this.c + ")";
        }

        public a() {
            this(RequestStatus.STATUS_DEFAULT.getStatus(), null, null);
        }

        public a(int r1, CommentResponse r2, Function2<? super Boolean, ? super CommentResponse, Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CommentCachePool a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public c(CommentCachePool r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            CommentResponse r6 = (CommentResponse) r5;
            this.a.d(this.b);
            if (r6 != null) goto L5;
        L7:
            boolean r0 = false;
        L8:
            CommentCachePool.a(this.a, r0, this.c, r6, null);
            return;
        L5:
            if (r6.getStatusCode() != 0) goto L7;
            r0 = true;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ CommentCachePool a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public d(CommentCachePool r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            this.a.d(this.b);
            dm.a.b r0 = dm.a.a("CommentCachePool");
            StringBuilder r1 = new StringBuilder("fetch, ");
            if (r6 == null) goto L5;
            String r3 = r6.getMessage();
        L6:
            r1.append(r3);
            r0.b(r1.toString(), r6);
            CommentCachePool.a(this.a, false, this.c, null, r6);
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
    }

    public CommentCachePool() {
        this.a = LazyKt.lazy(CommentCachePool$disposables$2.INSTANCE);
        this.c = new LinkedHashMap();
        this.f = "";
    }

    public final void d(boolean r3) {
        if (r3 == false) goto L8;
        if (this.d == true) goto L11;
        com.bytedance.android.shopping.monitor.d.f(this.f).e("same_comments_api_duration");
        this.d = true;
        return;
    L11:
        return;
    L8:
        if (this.e == true) goto L13;
        com.bytedance.android.shopping.monitor.d.f(this.f).e("comments_api_duration");
        this.e = true;
        return;
    }

    public final void e(boolean r4) {
        dm.a.a("CommentCachePool").i("monitorApiDurationStart, isSimilarRequest:" + r4);
        if (r4 == false) goto L8;
        if (this.d == true) goto L11;
        com.bytedance.android.shopping.monitor.d.f(this.f).b("same_comments_api_duration");
        return;
    L11:
        return;
    L8:
        if (this.e == true) goto L13;
        com.bytedance.android.shopping.monitor.d.f(this.f).b("comments_api_duration");
        return;
    }

    public static String c(Map r10, boolean r11, List r12) {
        LinkedHashMap r13 = (LinkedHashMap) r10;
        boolean r2 = false;
        List r0 = CollectionsKt.mutableListOf(new Object[]{r13.get("cursor"), r13.get(PdpOpenThirdParam.KEY_PRODUCT_ID), r13.get("need_page"), r13.get("sort_type"), r13.get("first_filter")});
        Object r4 = r13.get("second_filter");
        if ((r4 instanceof String) == true) goto L5;
        r4 = null;
    L5:
        String r5 = (String) r4;
        if (r5 != null) goto L8;
    L9:
        r2 = true;
    L10:
        if (r2 == true) goto L12;
        r0.add(r13.get("second_filter"));
    L14:
        if (r11 == false) goto L16;
        StringBuilder r14 = new StringBuilder();
        r14.append(r13.get("shop_id"));
        r14.append('_');
        String r15 = r14.toString();
    L18:
        return CollectionsKt.joinToString$default(r0, "_", r15, null, 0, null, CommentCachePool$genRspCacheKey$1.INSTANCE, 28, null);
    L16:
        StringBuilder r16 = new StringBuilder();
        r16.append(r12);
        r16.append('_');
        r16.append(r13.get("is_similar_data"));
        r16.append('_');
        r15 = r16.toString();
        goto L18
    L12:
        r0.add(r13.get("tag_id"));
        r0.add(r13.get("tag_version"));
        r0.add(r13.get("stat_id"));
        goto L14
    L8:
        if (r5.length() != 0) goto L10;
        goto L9
    }

    public static final void a(CommentCachePool r9, boolean r10, String r11, CommentResponse r12, Throwable r13) {
        r9.getClass();
        dm.a.a("CommentCachePool").i("handleResponse, cacheKey: " + r11 + ", success: " + r10);
        int r0 = e.a;
        fc3.a r1 = r9.g;
        if (r13 == null) goto L5;
        EventName r2 = EventName.ERROR;
    L6:
        String r3 = r2.getEvent();
        String r4 = EntranceType.FETCH_COMMENT_LIST.getType();
        Pair[] r5 = new Pair[1];
        StringBuilder r6 = new StringBuilder("class:CommentCachePool, method:handleResponse, info: success:");
        r6.append(r10);
        r6.append(", cacheKey:");
        r6.append(r11);
        r6.append(", throwable: ");
        if (r13 == null) goto L9;
        String r14 = r13.getMessage();
    L10:
        r6.append(r14);
        r5[0] = TuplesKt.to("message", r6.toString());
        e.a.a(r1, r3, r4, MapsKt.mutableMapOf(r5), null, null, 240);
        a r15 = (a) ((LinkedHashMap) r9.c).get(r11);
        if (r15 == null) goto L25;
        r15.a = RequestStatus.STATUS_READY.getStatus();
        if (r10 == false) goto L15;
        CommentResponse r7 = r12;
    L16:
        r15.b = r7;
        Function2<? super Boolean, ? super CommentResponse, Unit> r8 = r15.c;
        if (r8 == null) goto L23;
        Boolean r16 = Boolean.valueOf(r10);
        if (r10 == true) goto L22;
        r12 = null;
    L22:
        Unit r17 = (Unit) r8.invoke(r16, r12);
    L23:
        r15.c = null;
        r9.c.put(r11, r15);
        return;
    L15:
        r7 = null;
        goto L16
    L25:
        return;
    L9:
        r14 = null;
        goto L10
    L5:
        r2 = EventName.STATE;
        goto L6
    }

    public final void b(Map<String, Object> r23, List<String> r24, List<String> r25, boolean r26, boolean r27, boolean r28, int r29, Function2<? super Boolean, ? super CommentResponse, Unit> r30) {
        Intrinsics.checkNotNullParameter(r23, "requestMap");
        dm.a.a("CommentCachePool").i("fetch, isPreload: " + r28 + ", isSimilar: " + r26);
        CommentResponse r9 = this.b;
        if (r9 == null) goto L26;
        CommentGroupList r10 = r9.getGroups();
        if (r10 == null) goto L7;
        List<CommentGroup> r11 = r10.getListGroups();
    L8:
        List<CommentGroup> r12 = r11;
        if (r12 != null) goto L11;
    L14:
        boolean r13 = true;
    L15:
        if (r13 == true) goto L26;
        CommentResponse r14 = this.b;
        if (r14 == null) goto L24;
        CommentGroupList r15 = r14.getGroups();
        if (r15 == null) goto L24;
        List<CommentGroup> r16 = r15.getListGroups();
        if (r16 == null) goto L24;
        int r17 = r16.size();
    L25:
        com.bytedance.android.shopping.monitor.d.f(this.f).i("preload_comments_size", String.valueOf(r17));
        boolean r18 = true;
    L27:
        if (r28 == true) goto L33;
        if (r18 == false) goto L33;
        dm.a.a("CommentCachePool").i("use first frame data");
        e(r26);
        d(r26);
        com.bytedance.android.shopping.monitor.d.f(this.f).i("use_preload_data", "1");
        if (r30 == null) goto L32;
        Unit r19 = (Unit) r30.invoke(Boolean.TRUE, this.b);
    L32:
        this.b = null;
    L33:
        int r110 = e.a;
        fc3.a r111 = this.g;
        EventName r112 = EventName.STATE;
        String r113 = r112.getEvent();
        EntranceType r21 = EntranceType.FETCH_COMMENT_LIST;
        e.a.a(r111, r113, r21.getType(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class:CommentCachePool, method:fetch, info: isPreload:" + r28 + ", isSimilar:" + r26 + ", firstFrameDataReady: " + r18)}), null, null, 240);
        String r5 = c(r23, r27, r24);
        a r114 = (a) ((LinkedHashMap) this.c).get(r5);
        if (r114 != null) goto L36;
    L38:
        boolean r115 = false;
    L39:
        dm.a.a("CommentCachePool").i("fetch, cacheKey: " + r5 + ", hitCache: " + r115);
        int r20 = 0;
        e.a.a(this.g, r112.getEvent(), r21.getType(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class:CommentCachePool, method:fetch, info: cacheKey:" + r5 + ", hitCache:" + r115)}), null, null, 240);
        if (r115 == false) goto L48;
        if (r30 == null) goto L111;
        Boolean r1 = Boolean.TRUE;
        a r2 = (a) ((LinkedHashMap) this.c).get(r5);
        if (r2 == null) goto L45;
        CommentResponse r116 = r2.b;
    L46:
        Unit r3 = (Unit) r30.invoke(r1, r116);
        return;
    L45:
        r116 = null;
        goto L46
    L111:
        return;
    L48:
        a r8 = (a) ((LinkedHashMap) this.c).get(r5);
        if (r8 != null) goto L51;
    L53:
        boolean r117 = false;
    L54:
        if (r117 == false) goto L59;
        a r4 = (a) ((LinkedHashMap) this.c).get(r5);
        if (r4 == null) goto L112;
        r4.c = r30;
        return;
    L112:
        return;
    L59:
        e(r26);
        Disposable r118 = null;
        this.c.put(r5, new a(RequestStatus.STATUS_REQUESTING.getStatus(), null, r30));
        if (r29 != DataType.FUSION.getType()) goto L102;
        Object r6 = ((LinkedHashMap) r23).get("cursor");
        if ((r6 instanceof Long) == true) goto L64;
        r6 = null;
    L64:
        Long r7 = (Long) r6;
        if (r7 == null) goto L102;
        long r119 = r7.longValue();
        long r120 = 50;
        if (r119 <= r120) goto L69;
        long r121 = r119 - r120;
    L70:
        LinkedHashMap r22 = new LinkedHashMap();
        r22.putAll(r23);
        r22.put("cursor", Long.valueOf(r121));
        a r31 = (a) ((LinkedHashMap) this.c).get(c(r22, r27, r24));
        if (r31 != null) goto L74;
        r22.put("need_page", 1);
        r31 = (a) ((LinkedHashMap) this.c).get(c(r22, r27, r24));
    L74:
        if (r31 == null) goto L100;
        CommentResponse r32 = r31.b;
        if (r32 == null) goto L100;
        Map<String, Object> r122 = r32.getGlobal();
        if (r122 == null) goto L80;
        Object r123 = r122.get("fusion_product_offset");
    L82:
        if ((r123 instanceof Double) == true) goto L84;
        r123 = null;
    L84:
        Double r124 = (Double) r123;
        if (r124 == null) goto L87;
        int r125 = (int) r124.doubleValue();
    L88:
        Map<String, Object> r33 = r32.getGlobal();
        if (r33 == null) goto L91;
        Object r34 = r33.get("fusion_similar_offset");
    L93:
        if ((r34 instanceof Double) == true) goto L95;
        r34 = null;
    L95:
        Double r35 = (Double) r34;
        if (r35 == null) goto L98;
        int r36 = (int) r35.doubleValue();
    L99:
        r20 = r125;
    L101:
        r23.put("fusion_similar_offset", Integer.valueOf(r36));
        r23.put("fusion_product_offset", Integer.valueOf(r20));
        goto L102
    L98:
        r36 = 0;
        goto L99
    L91:
        r34 = null;
        goto L93
    L87:
        r125 = 0;
        goto L88
    L80:
        r123 = null;
    L100:
        r36 = 0;
        goto L101
    L69:
        r121 = 0;
    L102:
        int r37 = jc3.a.a;
        Intrinsics.checkNotNullParameter(r23, "requestMap");
        if (r27 == false) goto L105;
        ICommentFetchApi.a.getClass();
        Observable r38 = ICommentFetchApi.a.a.fetchShopComment(r23).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    L106:
        if (r38 == null) goto L108;
        r118 = r38.subscribe(new c(this, r26, r5), new d(this, r26, r5));
    L108:
        if (r118 == null) goto L113;
        ((CompositeDisposable) this.a.getValue()).add(r118);
        return;
    L113:
        return;
    L105:
        ICommentFetchApi.a.getClass();
        r38 = ICommentFetchApi.a.a.fetchProductComment(r23, r24, r25).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        goto L106
    L51:
        if (r8.a != RequestStatus.STATUS_REQUESTING.getStatus()) goto L53;
        r117 = true;
        goto L54
    L36:
        if (r114.a != RequestStatus.STATUS_READY.getStatus()) goto L38;
        r115 = true;
    L24:
        r17 = 0;
        goto L25
    L11:
        if (r12.isEmpty() == true) goto L14;
        r13 = false;
        goto L15
    L7:
        r11 = null;
    L26:
        com.bytedance.android.shopping.monitor.d.f(this.f).i("preload_comments_size", "-1");
        r18 = false;
        goto L27
    }
}
