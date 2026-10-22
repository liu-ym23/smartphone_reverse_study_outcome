package com.larus.im.internal.database.slowtask;

import com.larus.im.internal.core.message.utils.e;
import com.larus.im.internal.database.delegate.DbIndexDaoSource;
import com.larus.im.internal.database.slowtask.index.AbsDBIndexOperator;
import com.larus.im.internal.delegate.c1;
import com.larus.im.internal.delegate.y0;
import com.ss.android.lark.url.card.UrlCardProperty;
import gd9.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
public final class DBTableIndexTask implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f348144a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f348145b = null;

    public static final class a {
        public a() {
        }
    }

    public DBTableIndexTask() {
    }

    @Override // com.larus.im.internal.database.slowtask.c
    public final String getName() {
        return "DBTableIndexTask";
    }

    static {
        new a();
        f348144a = CollectionsKt.mutableListOf(new String[]{"idx_", "midx_", "MessageTable_"});
        f348145b = CollectionsKt.mutableListOf(new String[]{"im_conversation", "im_bot", "im_participant", UrlCardProperty.URL_PREVIEW_BUSINESS_HOST});
    }

    @Override // com.larus.im.internal.database.slowtask.c
    public final boolean enable() {
        Lazy r100 = y0.f348459a;
        y0.l r101 = y0.f348469k;
        if (r101 != null) goto L12;
        Object r102 = y0.f348470l;
        monitor-enter(r102);
        y0.l r103 = y0.f348469k;     // Catch: Throwable -> L18
        if (r103 != null) goto L10;
        r103 = y0.m();     // Catch: Throwable -> L18
        y0.f348469k = r103;     // Catch: Throwable -> L18
    L10:
        monitor-exit(r102);
        r101 = r103;
    L18:
        th = move-exception;
        throw th;
    L12:
        y0.m r104 = r101.f348563a;
        if (r104 == null) goto L15;
        boolean r105 = r104.f348566a;
    L17:
        return !r105;
    L15:
        r105 = false;
        goto L17
    }

    @Override // com.larus.im.internal.database.slowtask.c
    public final Object a(String r100, Continuation<? super Unit> r101) {
        be9.c.f18787a.getClass();
        com.larus.im.internal.database.slowtask.index.a r102 = new com.larus.im.internal.database.slowtask.index.a(new DbIndexDaoSource());
        if (((y0.h) e.f347863c.getValue()).f348518a == false) goto L9;
        Object r103 = c(r102, r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r103;
    L8:
        return Unit.INSTANCE;
    L9:
        Object r104 = b(r102, r101);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r104;
    L13:
        return Unit.INSTANCE;
    }

    public final Object b(com.larus.im.internal.database.slowtask.index.a r110, Continuation r111) {
        if ((r111 instanceof DBTableIndexTask$clearIndex$1) == false) goto L7;
        DBTableIndexTask$clearIndex$1 r100 = (DBTableIndexTask$clearIndex$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r104 = r100.J$0;
        ResultKt.throwOnFailure(r112);
    L27:
        int r113 = ((Number) r112).intValue();
        c1 r114 = c1.f348202a;
        z.a.c("DB_INDEX_" + com.larus.im.internal.delegate.b.f348193b.getUserId(), "");
        long r105 = r104;
    L29:
        long r106 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r105;
        if (r113 <= 0) goto L32;
        ce9.a.b("clear", r113, 0, r106);
    L32:
        com.larus.im.internal.delegate.a.f348188b.i("DBTableIndexTask", "clearIndex, count:" + r113 + ",costTime:" + r106);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r105 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        c1 r115 = c1.f348202a;
        if (z.a.b("DB_INDEX_" + com.larus.im.internal.delegate.b.f348193b.getUserId(), "").length() <= 0) goto L17;
        boolean r116 = true;
    L18:
        if (r116 == false) goto L28;
        Map<String, ? extends List<String>> r117 = new LinkedHashMap();
        Iterator<T> r107 = f348145b.iterator();
    L21:
        if (r107.hasNext() == false) goto L23;
        r117.put((String) r107.next(), f348144a);
        goto L21
    L23:
        r100.J$0 = r105;
        r100.label = 1;
        r112 = r110.c(r117, r100);
        if (r112 != r102) goto L26;
        return r102;
    L26:
        r104 = r105;
        goto L27
    L28:
        r113 = 0;
        goto L29
    L17:
        r116 = false;
    L7:
        r100 = new DBTableIndexTask$clearIndex$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0162 -> B:45:0x0164). Please report as a decompilation issue!!! */
    public final Object c(com.larus.im.internal.database.slowtask.index.a r210, Continuation r211) {
        if ((r211 instanceof DBTableIndexTask$operateIndex$1) == false) goto L7;
        DBTableIndexTask$operateIndex$1 r100 = (DBTableIndexTask$operateIndex$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = "DB_INDEX_";
        String r106 = "DBTableIndexTask";
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r107 = r100.I$1;
        int r108 = r100.I$0;
        long r109 = r100.J$0;
        Iterator r110 = (Iterator) r100.L$6;
        Iterable r111 = (Iterable) r100.L$5;
        List r112 = (List) r100.L$4;
        DBTableIndexTask r113 = (DBTableIndexTask) r100.L$3;
        Ref.IntRef r114 = (Ref.IntRef) r100.L$2;
        Ref.IntRef r115 = (Ref.IntRef) r100.L$1;
        AbsDBIndexOperator r116 = (AbsDBIndexOperator) r100.L$0;
        ResultKt.throwOnFailure(r102);
        AbsDBIndexOperator r117 = r116;
        String r118 = "DB_INDEX_";
        ?? r119 = r112;
    L45:
        AbsDBIndexOperator r212 = r117;
        DBTableIndexTask$operateIndex$1 r120 = r100;
        if ((com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r109) <= ((y0.h) e.f347863c.getValue()).f348520c) goto L49;
    L54:
        long r121 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r109;
        int r122 = r115.element;
        if (r122 <= 0) goto L57;
    L58:
        int r123 = ce9.a.f23485a;
        ce9.a.b("addOrDelete", r122, r114.element, r121);
    L59:
        com.larus.im.internal.delegate.a.f348188b.i(r106, "operateIndex, deleteCount:" + r115.element + ",createCount:" + r114.element + ",costTime:" + r121);
        return Unit.INSTANCE;
    L57:
        if (r114.element <= 0) goto L59;
    L49:
        if (r107 != (r119.size() - 1)) goto L51;
        String r124 = r119.toString();
        c1 r125 = c1.f348202a;
        String r126 = r118;
        z.a.c(r126 + com.larus.im.internal.delegate.b.f348193b.getUserId(), r124);
    L52:
        r117 = r212;
        r100 = r120;
        r105 = r126;
        r107 = r108;
        ?? r127 = r119;
    L33:
        if (r110.hasNext() == false) goto L54;
        Object r128 = r110.next();
        r108 = r107 + 1;
        if (r107 >= 0) goto L37;
        CollectionsKt.throwIndexOverflow();
    L37:
        Pair r129 = (Pair) r128;
        String r213 = r106;
        y0.j r130 = (y0.j) r129.getSecond();
        r118 = r105;
        if (r130.f348530a == true) goto L40;
        r115.element++;
    L41:
        String r131 = (String) r129.getFirst();
        r100.L$0 = r117;
        r100.L$1 = r115;
        r100.L$2 = r114;
        r100.L$3 = r113;
        r100.L$4 = r127;
        r100.L$5 = r111;
        r100.L$6 = r110;
        r100.J$0 = r109;
        r100.I$0 = r108;
        r100.I$1 = r107;
        r100.label = 1;
        if (r113.d(r130, r117, r131, r100) != r103) goto L44;
        return r103;
    L44:
        r106 = r213;
        r119 = r127;
        goto L45
    L40:
        r114.element++;
        goto L41
    L51:
        r126 = r118;
        goto L52
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        long r132 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        Ref.IntRef r133 = new Ref.IntRef();
        Ref.IntRef r134 = new Ref.IntRef();
        ArrayList r135 = new ArrayList();
        List<y0.i> r136 = ((y0.h) e.f347863c.getValue()).a();
        if (r136 == null) goto L28;
        Iterator r137 = r136.iterator();
    L18:
        if (r137.hasNext() == false) goto L28;
        y0.i r138 = (y0.i) r137.next();
        List<y0.j> r139 = r138.a();
        if (r139 == null) goto L18;
        Iterator r140 = r139.iterator();
    L23:
        if (r140.hasNext() == false) goto L18;
        y0.j r141 = (y0.j) r140.next();
        String r142 = r138.f348525a;
        if (r142 != null) goto L27;
        r142 = "";
    L27:
        r135.add(TuplesKt.to(r142, r141));
    L28:
        com.larus.im.internal.delegate.a.f348188b.i("DBTableIndexTask", "getNeedOperateIndices, remoteList:" + r135);
        String r143 = r135.toString();
        c1 r144 = c1.f348202a;
        if (Intrinsics.areEqual(r143, z.a.b("DB_INDEX_" + com.larus.im.internal.delegate.b.f348193b.getUserId(), "")) == false) goto L31;
        r135 = new ArrayList();
    L31:
        r113 = this;
        r114 = r134;
        r111 = r135;
        r127 = r111;
        r110 = r135.iterator();
        r109 = r132;
        r107 = 0;
        r115 = r133;
        r117 = r210;
    L7:
        r100 = new DBTableIndexTask$operateIndex$1(this, r211);
        goto L8
    }

    public final Object d(y0.j r110, AbsDBIndexOperator r111, String r112, Continuation<? super Unit> r210) {
        if ((r210 instanceof DBTableIndexTask$operateItem$1) == false) goto L7;
        DBTableIndexTask$operateItem$1 r100 = (DBTableIndexTask$operateItem$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L19;
        if (r104 == 1) goto L18;
        if (r104 == 2) goto L17;
        if (r104 == 3) goto L17;
        if (r104 == 4) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        boolean r105 = r100.Z$0;
        long r106 = r100.J$0;
        String r107 = (String) r100.L$1;
        y0.j r108 = (y0.j) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L51:
        y0.j r113 = r108;
        long r114 = r106;
    L53:
        long r109 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r114;
        com.larus.im.internal.delegate.a.f348188b.i("DBTableIndexTask", "operateItem, isExists:" + r105 + ",enable:" + r113.f348530a + ",item:" + r107 + ",itemCostTime:" + r109);
        return Unit.INSTANCE;
    L18:
        long r115 = r100.J$0;
        String r116 = (String) r100.L$3;
        String r117 = (String) r100.L$2;
        AbsDBIndexOperator r118 = (AbsDBIndexOperator) r100.L$1;
        r113 = (y0.j) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r114 = r115;
        r107 = r116;
    L26:
        r105 = ((Boolean) r102).booleanValue();
        if (r105 == true) goto L29;
    L33:
        if (r105 == false) goto L35;
    L52:
        Unit r119 = Unit.INSTANCE;
        goto L53
    L35:
        if (r113.f348530a == false) goto L52;
        if (((Boolean) e.f347864d.getValue()).booleanValue() == true) goto L52;
        List<String> r120 = r113.a();
        if (r120 != null) goto L41;
        r120 = new ArrayList();
    L41:
        int r121 = r120.size();
        if (r121 <= 1) goto L46;
        r100.L$0 = r113;
        r100.L$1 = r107;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.J$0 = r114;
        r100.Z$0 = r105;
        r100.label = 3;
        if (r118.a(r107, r117, r120, r100) != r103) goto L50;
        return r103;
    L50:
        r108 = r113;
        r106 = r114;
        goto L51
    L46:
        if (r121 != 1) goto L52;
        String r122 = (String) CollectionsKt.first(r120);
        r100.L$0 = r113;
        r100.L$1 = r107;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.J$0 = r114;
        r100.Z$0 = r105;
        r100.label = 4;
        if (r118.b(r107, r117, r122, r100) != r103) goto L50;
        return r103;
    L29:
        if (r113.f348530a == true) goto L33;
        r100.L$0 = r113;
        r100.L$1 = r107;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.J$0 = r114;
        r100.Z$0 = r105;
        r100.label = 2;
        if (r118.d(r107, r100) != r103) goto L50;
        return r103;
    L19:
        ResultKt.throwOnFailure(r102);
        String r123 = r110.f348531b;
        if (r123 != null) goto L22;
        r123 = "";
    L22:
        long r124 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = r112;
        r100.L$3 = r123;
        r100.J$0 = r124;
        r100.label = 1;
        Object r125 = r111.g(r123, r100);
        if (r125 != r103) goto L25;
        return r103;
    L25:
        r114 = r124;
        r118 = r111;
        r107 = r123;
        r117 = r112;
        r102 = r125;
        r113 = r110;
    L7:
        r100 = new DBTableIndexTask$operateItem$1(this, r210);
        goto L8
    }
}
