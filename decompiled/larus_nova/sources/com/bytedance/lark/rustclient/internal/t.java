package com.bytedance.lark.rustclient.internal;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Packet;
import com.bytedance.larksuite.wire.CommandScope;
import com.ss.android.lark.log.Log;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class t implements com.bytedance.lark.sdk.refactor.i, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f254018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<com.bytedance.lark.sdk.refactor.i> f254019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<b, com.bytedance.lark.sdk.refactor.i> f254020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Deque<Pair<Long, com.bytedance.lark.sdk.refactor.q>> f254021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<Long, com.bytedance.lark.sdk.refactor.b> f254022e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f254023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Pair<Long, Long> f254024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Long f254025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Long f254026d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f254023a, r101.f254023a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f254024b, r101.f254024b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f254023a.hashCode() * 31;
            Pair<Long, Long> r101 = this.f254024b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "UserContainerIdentity(userId=" + this.f254023a + ", componentIds=" + this.f254024b + ')';
        }

        public b(String r100, Pair<Long, Long> r101) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            this.f254023a = r100;
            this.f254024b = r101;
            Long r102 = null;
            if (r101 == null) goto L5;
            Long r103 = r101.getFirst();
        L6:
            this.f254025c = r103;
            if (r101 == null) goto L9;
            r102 = r101.getSecond();
        L9:
            this.f254026d = r102;
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f254027a = null;

        static {
            int[] r100 = new int[CommandScope.values().length];
            r100[CommandScope.GlobalScope.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CommandScope.UserScope.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f254027a = r100;
        }
    }

    static {
    }

    public final Set<com.bytedance.lark.sdk.refactor.i> h() {
        Map<b, com.bytedance.lark.sdk.refactor.i> r100 = this.f254020c;
        monitor-enter(r100);
        Set<com.bytedance.lark.sdk.refactor.i> r101 = CollectionsKt.toSet(((ConcurrentHashMap) this.f254020c).values());     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public t(k r100) {
        Intrinsics.checkNotNullParameter(r100, "definition");
        this.f254018a = r100;
        this.f254019b = new CopyOnWriteArraySet();
        this.f254020c = new ConcurrentHashMap();
        this.f254021d = new LinkedList();
        this.f254022e = new LinkedHashMap();
    }

    @Override // com.bytedance.lark.rustclient.internal.m
    public final void b(j r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        Set<com.bytedance.lark.sdk.refactor.i> r101 = this.f254019b;
        monitor-enter(r101);
        ((CopyOnWriteArraySet) this.f254019b).add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.lark.sdk.refactor.i
    public final boolean d(long r100) {
        Set<com.bytedance.lark.sdk.refactor.i> r101 = this.f254019b;
        monitor-enter(r101);
        Iterator r102 = ((CopyOnWriteArraySet) this.f254019b).iterator();     // Catch: Throwable -> L32
    L5:
        Object r103 = null;
        if (r102.hasNext() == false) goto L10;
        Object r104 = r102.next();     // Catch: Throwable -> L32
        if (((com.bytedance.lark.sdk.refactor.i) r104).d(r100) == false) goto L5;
    L11:
        com.bytedance.lark.sdk.refactor.i r105 = (com.bytedance.lark.sdk.refactor.i) r104;     // Catch: Throwable -> L32
        monitor-exit(r101);
        Map<b, com.bytedance.lark.sdk.refactor.i> r106 = this.f254020c;
        monitor-enter(r106);
        Iterator<T> r107 = h().iterator();     // Catch: Throwable -> L29
    L17:
        if (r107.hasNext() == false) goto L21;
        Object r108 = r107.next();     // Catch: Throwable -> L29
        if (((com.bytedance.lark.sdk.refactor.i) r108).d(r100) == false) goto L17;
        r103 = r108;
    L21:
        com.bytedance.lark.sdk.refactor.i r109 = (com.bytedance.lark.sdk.refactor.i) r103;     // Catch: Throwable -> L29
        monitor-exit(r106);
        if (r105 != null) goto L27;
        if (r109 != null) goto L27;
        return false;
    L27:
        return true;
    L29:
        th = move-exception;
        throw th;
    L10:
        r104 = null;
    L32:
        th = move-exception;
        throw th;
    }

    public final void f(com.bytedance.lark.sdk.refactor.q r100) {
        Deque<Pair<Long, com.bytedance.lark.sdk.refactor.q>> r101 = this.f254021d;
        monitor-enter(r101);
        Deque<Pair<Long, com.bytedance.lark.sdk.refactor.q>> r102 = this.f254021d;     // Catch: Throwable -> L10
        LinkedList r103 = (LinkedList) r102;     // Catch: Throwable -> L10
        r103.addLast(new Pair(r100.f254278b.user_container_id, r100));     // Catch: Throwable -> L10
        if (((LinkedList) this.f254021d).size() <= 1000) goto L7;
        ((LinkedList) this.f254021d).removeFirst();     // Catch: Throwable -> L10
    L7:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.util.ArrayList, java.util.List] */
    public final void g(l r100) {
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        LinkedHashMap<Long, com.bytedance.lark.sdk.refactor.b> r102 = this.f254022e;
        monitor-enter(r102);
        Collection<com.bytedance.lark.sdk.refactor.b> r103 = this.f254022e.values();     // Catch: Throwable -> L21
        ?? r104 = new ArrayList();     // Catch: Throwable -> L21
        Iterator<T> r105 = r103.iterator();     // Catch: Throwable -> L21
    L6:
        if (r105.hasNext() == false) goto L10;
        Object r106 = r105.next();     // Catch: Throwable -> L21
        if (r100.d(((com.bytedance.lark.sdk.refactor.b) r106).f254244a) == false) goto L6;
        r104.add(r106);     // Catch: Throwable -> L21
        goto L6
    L10:
        r101.element = r104;     // Catch: Throwable -> L21
        Iterator r107 = r104.iterator();     // Catch: Throwable -> L21
    L12:
        if (r107.hasNext() == false) goto L14;
        com.bytedance.lark.sdk.refactor.b r108 = (com.bytedance.lark.sdk.refactor.b) r107.next();     // Catch: Throwable -> L21
        this.f254022e.remove(Long.valueOf(r108.f254244a));     // Catch: Throwable -> L21
        goto L12
    L14:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r102);
        Iterator r110 = ((List) r101.element).iterator();
    L18:
        if (r110.hasNext() == false) goto L20;
        r100.y((com.bytedance.lark.sdk.refactor.b) r110.next());
        goto L18
    L20:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.lark.sdk.refactor.h
    public final void v(com.bytedance.lark.sdk.refactor.q r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        if (r110.f254278b.task_id.longValue() > 0) goto L87;
        Set<com.bytedance.lark.sdk.refactor.i> r100 = this.f254019b;
        monitor-enter(r100);
        Set r101 = CollectionsKt.toSet(this.f254019b);     // Catch: Throwable -> L84
        monitor-exit(r100);
        Iterator r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L12;
        ((com.bytedance.lark.sdk.refactor.i) r102.next()).v(r110);
        goto L10
    L12:
        int r103 = c.f254027a[e.a(r110.f254278b.cmd).ordinal()];
        int r104 = 1;
        if (r103 != 1) goto L15;
        Iterator<T> r105 = h().iterator();
    L82:
        if (r105.hasNext() == false) goto L108;
        ((com.bytedance.lark.sdk.refactor.i) r105.next()).v(r110);
        goto L82
    L108:
        return;
    L15:
        if (r103 != 2) goto L79;
        long r106 = r110.f254278b.user_container_id.longValue();
        String r107 = r110.f254278b.user_id;
        Iterator r108 = ((ConcurrentHashMap) this.f254020c).entrySet().iterator();
    L17:
        Object r109 = null;
        if (r108.hasNext() == false) goto L34;
        Object r111 = r108.next();
        b r112 = (b) ((Map.Entry) r111).getKey();
        Long r113 = r112.f254025c;
        if (r113 != null) goto L23;
    L24:
        Long r114 = r112.f254026d;
        if (r114 != null) goto L28;
    L30:
        boolean r115 = false;
    L32:
        if (r115 == false) goto L17;
    L35:
        Map.Entry r116 = (Map.Entry) r111;
        if (r116 != null) goto L49;
        Iterator r117 = ((ConcurrentHashMap) this.f254020c).entrySet().iterator();
    L39:
        if (r117.hasNext() == false) goto L48;
        Object r118 = r117.next();
        Map.Entry r119 = (Map.Entry) r118;
        if (Intrinsics.areEqual(((b) r119.getKey()).f254023a, r107) == true) goto L43;
    L45:
        boolean r120 = false;
    L46:
        if (r120 == false) goto L39;
        r109 = r118;
        goto L48
    L43:
        if (((b) r119.getKey()).f254024b != null) goto L45;
        r120 = true;
    L48:
        r116 = (Map.Entry) r109;
    L49:
        if (r116 == null) goto L55;
        com.bytedance.lark.sdk.refactor.i r121 = (com.bytedance.lark.sdk.refactor.i) r116.getValue();
        if (r121 == null) goto L55;
        List r122 = CollectionsKt.listOf(r121);
        if (r122 == null) goto L55;
    L56:
        List r123 = r122;
        if ((!r123.isEmpty()) == false) goto L62;
        Iterator r124 = r123.iterator();
    L60:
        if (r124.hasNext() == false) goto L107;
        ((com.bytedance.lark.sdk.refactor.i) r124.next()).v(r110);
        goto L60
    L107:
        return;
    L62:
        k r125 = this.f254018a;
        Intrinsics.checkNotNullParameter(r125, "<this>");
        Intrinsics.checkNotNullParameter(r110, "pushData");
        JSONObject r126 = new JSONObject();
    L75:
        e = move-exception;
        Log.e("sdk", "logPushMiss: error occurs: " + e.getMessage(), e);
    L77:
        r125.c(r126);
        Log.i("RustReceiverRegistry", "add push cache uid=" + r110.f254278b.user_id + ", cmd=" + r110.f254278b.cmd + ",containerId = " + r110.f254278b.user_container_id);
        f(r110);
        return;
    L64:
        if (Intrinsics.areEqual(r110.f254278b.cmd, Command.PASS_THROUGH_PUSH) == false) goto L66;
        String r127 = "passthrough_push_miss_c";
    L67:
        r126.put("scenario", r127);     // Catch: JSONException -> L75
        r126.put("command", r110.f254278b.cmd.getValue());     // Catch: JSONException -> L75
        r126.put("sdk_user_id", r125.a(r110.f254278b.user_id));     // Catch: JSONException -> L75
        r126.put("context_id", r110.f254278b.context_id);     // Catch: JSONException -> L75
        r126.put("utc_time_stamp", Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());     // Catch: JSONException -> L75
        if (r110.f254278b.is_err.booleanValue() == true) goto L71;
        r104 = 0;
    L71:
        r126.put("is_error", r104);     // Catch: JSONException -> L75
        com.bytedance.lark.sdk.refactor.q.a r128 = r110.f254279c;     // Catch: JSONException -> L75
        if (r128 == null) goto L77;
        r126.put("server_command", r128.f254280a.getValue());     // Catch: JSONException -> L75
        goto L77
    L66:
        r127 = "push_miss_c";
    L55:
        r122 = CollectionsKt.emptyList();
        goto L56
    L28:
        if (r114.longValue() != r106) goto L30;
    L31:
        r115 = true;
        goto L32
    L23:
        if (r113.longValue() == r106) goto L31;
    L34:
        r111 = null;
        goto L35
    L79:
        throw new NoWhenBranchMatchedException();
    L84:
        th = move-exception;
        throw th;
    L87:
        long r129 = r110.f254278b.task_id.longValue();
        boolean r130 = r110.f254278b.is_err.booleanValue();
        byte[] r131 = r110.f254278b.payload.toByteArray();
        Packet r132 = r110.f254278b;
        y(new com.bytedance.lark.sdk.refactor.b(r129, r130, r131, r132.user_id, r132.verify_user_id.booleanValue(), false, r110.f254278b.stream_status, 32));
    }

    @Override // com.bytedance.lark.sdk.refactor.h
    public final void y(com.bytedance.lark.sdk.refactor.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Set<com.bytedance.lark.sdk.refactor.i> r101 = this.f254019b;
        monitor-enter(r101);
        Iterator r102 = ((CopyOnWriteArraySet) this.f254019b).iterator();     // Catch: Throwable -> L53
    L5:
        Object r103 = null;
        if (r102.hasNext() == false) goto L10;
        Object r104 = r102.next();     // Catch: Throwable -> L53
        if (((com.bytedance.lark.sdk.refactor.i) r104).d(r100.f254244a) == false) goto L5;
    L11:
        com.bytedance.lark.sdk.refactor.i r105 = (com.bytedance.lark.sdk.refactor.i) r104;     // Catch: Throwable -> L53
        monitor-exit(r101);
        Map<b, com.bytedance.lark.sdk.refactor.i> r106 = this.f254020c;
        monitor-enter(r106);
        Iterator<T> r107 = h().iterator();     // Catch: Throwable -> L50
    L17:
        if (r107.hasNext() == false) goto L21;
        Object r108 = r107.next();     // Catch: Throwable -> L50
        if (((com.bytedance.lark.sdk.refactor.i) r108).d(r100.f254244a) == false) goto L17;
        r103 = r108;
    L21:
        com.bytedance.lark.sdk.refactor.i r109 = (com.bytedance.lark.sdk.refactor.i) r103;     // Catch: Throwable -> L50
        monitor-exit(r106);
        if (r105 == null) goto L25;
        r105.y(r100);
        return;
    L25:
        if (r109 == null) goto L28;
        r109.y(r100);
        return;
    L28:
        if (r100.f254249f == true) goto L71;
        k r110 = this.f254018a;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r100, "data");
        JSONObject r111 = new JSONObject();
        r111.put("scenario", "invoke_async_miss_c");     // Catch: JSONException -> L36
        r111.put("command", r100.f254244a);     // Catch: JSONException -> L36
        r111.put("sdk_user_id", r110.a(r100.f254247d));     // Catch: JSONException -> L36
        r111.put("utc_time_stamp", Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());     // Catch: JSONException -> L36
        if (r100.f254245b == false) goto L33;
        int r112 = 1;
    L34:
        r111.put("is_error", r112);     // Catch: JSONException -> L36
    L38:
        r110.c(r111);
        LinkedHashMap<Long, com.bytedance.lark.sdk.refactor.b> r113 = this.f254022e;
        monitor-enter(r113);
        this.f254022e.put(Long.valueOf(r100.f254244a), r100);     // Catch: Throwable -> L46
        if (this.f254022e.size() <= 1000) goto L43;
        LinkedHashMap<Long, com.bytedance.lark.sdk.refactor.b> r114 = this.f254022e;     // Catch: Throwable -> L46
        r114.remove(CollectionsKt.first(r114.keySet()));     // Catch: Throwable -> L46
    L43:
        Log.i("RustReceiverRegistry", "add async callback cache taskId = " + r100.f254244a);     // Catch: Throwable -> L46
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L46
        monitor-exit(r113);
        return;
    L46:
        th = move-exception;
        throw th;
    L33:
        r112 = 0;
    L36:
        e = move-exception;
        Log.e("sdk", "logAsyncCallbackMiss: error occurs: " + e.getMessage(), e);
        goto L38
    L71:
        return;
    L50:
        th = move-exception;
        throw th;
    L10:
        r104 = null;
    L53:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.lark.rustclient.internal.m
    public final void a(String r100, Pair<Long, Long> r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Map<b, com.bytedance.lark.sdk.refactor.i> r102 = this.f254020c;
        monitor-enter(r102);
        Map<b, com.bytedance.lark.sdk.refactor.i> r103 = this.f254020c;     // Catch: Throwable -> L7
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;     // Catch: Throwable -> L7
        r104.remove(new b(r100, r101));     // Catch: Throwable -> L7
        Map<b, com.bytedance.lark.sdk.refactor.i> r105 = this.f254020c;     // Catch: Throwable -> L7
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;     // Catch: Throwable -> L7
        com.bytedance.lark.sdk.refactor.i r107 = (com.bytedance.lark.sdk.refactor.i) r106.remove(new b(r100, null));     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.ArrayList, java.util.Collection] */
    @Override // com.bytedance.lark.rustclient.internal.m
    public final void c(String r110, Pair r111, l r112) {
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r112, SocialConstants.PARAM_RECEIVER);
        if (((com.bytedance.lark.sdk.refactor.i) ((ConcurrentHashMap) this.f254020c).put(new b(r110, r111), r112)) != null) goto L31;
        if (r111 == null) goto L40;
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        Deque<Pair<Long, com.bytedance.lark.sdk.refactor.q>> r100 = this.f254021d;
        monitor-enter(r100);
        Deque<Pair<Long, com.bytedance.lark.sdk.refactor.q>> r101 = this.f254021d;     // Catch: Throwable -> L28
        ?? r102 = new ArrayList();     // Catch: Throwable -> L28
        Iterator<T> r103 = r101.iterator();     // Catch: Throwable -> L28
    L8:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L18;
        Object r105 = r103.next();     // Catch: Throwable -> L28
        Pair r106 = (Pair) r105;     // Catch: Throwable -> L28
        if (((Number) r106.getFirst()).longValue() != ((Number) r111.getFirst()).longValue()) goto L13;
    L16:
        if (r104 == false) goto L8;
        r102.add(r105);     // Catch: Throwable -> L28
        goto L8
    L13:
        if (((Number) r106.getFirst()).longValue() == ((Number) r111.getSecond()).longValue()) goto L16;
        r104 = false;
        goto L16
    L18:
        r113.element = r102;     // Catch: Throwable -> L28
        this.f254021d.removeAll(r102);     // Catch: Throwable -> L28
        monitor-exit(r100);
        T r107 = r113.element;
        if (((List) r107) == null) goto L27;
        Iterator r108 = ((Iterable) r107).iterator();
    L24:
        if (r108.hasNext() == false) goto L26;
        r112.v((com.bytedance.lark.sdk.refactor.q) ((Pair) r108.next()).getSecond());
        goto L24
    L26:
        Log.i("RustReceiverRegistry", "flush push cache data container id= " + ((Number) r111.getFirst()).longValue() + " , cacheSize = " + ((List) r113.element).size());
        w.d(this.f254018a, String.valueOf(((Number) r111.getFirst()).longValue()), ((List) r113.element).size(), true);
    L27:
        g(r112);
        return;
    L28:
        th = move-exception;
        throw th;
    L40:
        return;
    }
}
