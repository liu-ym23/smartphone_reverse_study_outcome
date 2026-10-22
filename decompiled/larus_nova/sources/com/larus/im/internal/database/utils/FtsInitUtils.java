package com.larus.im.internal.database.utils;

import com.larus.im.internal.core.message.MessageHandler;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.delegate.c1;
import com.larus.im.internal.delegate.d1;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import gd9.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import ouc.e0;

/* JADX INFO: loaded from: classes4.dex */
public final class FtsInitUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FtsInitUtils f348148a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f348149b = null;

    public static final class a implements c0 {
        public a() {
        }

        @Override // gd9.c0
        public final void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "uid");
            Intrinsics.checkNotNullParameter(r101, "secUid");
        }

        @Override // gd9.c0
        public final void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "uid");
            Intrinsics.checkNotNullParameter(r101, "secUid");
            com.larus.im.internal.delegate.a.f348188b.i("FtsInitUtils", "start deal user data");
            FtsInitUtils r102 = FtsInitUtils.f348148a;
            FtsInitUtils.d(r100);
        }
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            com.larus.im.internal.delegate.a.f348188b.e("FtsInitUtils", "err! msg=" + r101);
        }
    }

    public FtsInitUtils() {
    }

    static {
        f348148a = new FtsInitUtils();
        b r100 = new b(CoroutineExceptionHandler.Key);
        f348149b = CoroutineScopeKt.CoroutineScope(com.flow.kmp.common.thread.c.a("flow-im#fts-thread").plus(r100).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        com.larus.im.internal.delegate.b.f348193b.f(new a());
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        com.larus.im.internal.delegate.a.f348188b.i("FtsInitUtils", "start move user data  isLogin=" + com.larus.im.internal.delegate.b.f348193b.isLogin());
        BuildersKt.launch$default(f348149b, null, null, new FtsInitUtils$startMigrate$1(r100, null), 3, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00ab -> B:22:0x00b1). Please report as a decompilation issue!!! */
    public static final Object a(FtsInitUtils r210, String r211, Continuation r212) {
        String r100 = r211;
        r210.getClass();
        if ((r212 instanceof FtsInitUtils$startMigrateMessage$1) == false) goto L7;
        FtsInitUtils$startMigrateMessage$1 r101 = (FtsInitUtils$startMigrateMessage$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
        FtsInitUtils r103 = r210;
    L8:
        Object r104 = r101.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r101.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        long r110 = r101.J$2;
        long r111 = r101.J$1;
        long r112 = r101.J$0;
        int r107 = r101.I$1;
        int r108 = r101.I$0;
        String r109 = (String) r101.L$1;
        String r113 = (String) r101.L$0;
        ResultKt.throwOnFailure(r104);
    L22:
        List r114 = (List) r104;
        long r213 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r110;
        if (r114 == null) goto L37;
        Iterator r115 = r114.iterator();
        if (r115.hasNext() == true) goto L27;
        Long r116 = null;
        FtsInitUtils$startMigrateMessage$1 r214 = r101;
    L35:
        if (r116 == null) goto L38;
        long r117 = r116.longValue();
    L40:
        if (r117 != r111) goto L45;
        if (r114 == null) goto L43;
        int r118 = r114.size();
    L44:
        r108 = r108 + r118;
    L46:
        if (r114 == null) goto L48;
        int r119 = r114.size();
    L49:
        int r120 = r107 + r119;
        if (r117 > 0) goto L58;
        c1.f348202a.i("generate_message_fts_" + r113, true, "fts_move_repo_name");
        if (r114 == null) goto L54;
        int r121 = r114.size();
    L55:
        c(r121, r120, r213, com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r112, true);
        return Unit.INSTANCE;
    L54:
        r121 = -1;
        goto L55
    L58:
        if (r114 == null) goto L60;
        int r122 = r114.size();
    L61:
        c(r122, r120, r213, com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r112, false);
        c1.f348202a.b(r109, r117, "fts_move_repo_name");
        r101 = r214;
        int r123 = r120;
        r100 = r113;
        r111 = r117;
    L18:
        r110 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        r101.L$0 = r100;
        r101.L$1 = r109;
        r101.I$0 = r108;
        r101.I$1 = r123;
        r101.J$0 = r112;
        r101.J$1 = r111;
        r101.J$2 = r110;
        r101.label = 1;
        Object r124 = r103.b(r111, r108, r101);
        if (r124 == r105) goto L66;
        r113 = r100;
        r107 = r123;
        r104 = r124;
        goto L22
    L66:
        return r105;
    L60:
        r122 = -1;
        goto L61
    L48:
        r119 = 0;
        goto L49
    L43:
        r118 = 1;
        goto L44
    L45:
        r108 = 0;
    L38:
        r117 = -1;
        goto L40
    L27:
        Long r125 = Boxing.boxLong(((MessageEntity) r115.next()).getCreateTime());
    L29:
        if (r115.hasNext() == false) goto L34;
        FtsInitUtils$startMigrateMessage$1 r215 = r101;
        Long r126 = Boxing.boxLong(((MessageEntity) r115.next()).getCreateTime());
        if (r125.compareTo(r126) <= 0) goto L33;
        r125 = r126;
    L33:
        r101 = r215;
        goto L29
    L34:
        r214 = r101;
        r116 = r125;
        goto L35
    L37:
        r214 = r101;
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (c1.f348202a.h("generate_message_fts_" + r100, "fts_move_repo_name") == true) goto L65;
        String r127 = "fts_move_message_local_index_".concat(r100);
        r112 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        r111 = Long.MAX_VALUE;
        r108 = 0;
        r109 = r127;
        r123 = 0;
        goto L18
    L65:
        return Unit.INSTANCE;
    L7:
        r103 = r210;
        r101 = new FtsInitUtils$startMigrateMessage$1(r103, r212);
        goto L8
    }

    public final Object b(long r610, int r611, Continuation<? super List<MessageEntity>> r612) {
        if ((r612 instanceof FtsInitUtils$migrateMessage$1) == false) goto L7;
        FtsInitUtils$migrateMessage$1 r100 = (FtsInitUtils$migrateMessage$1) r612;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        FtsInitUtils$migrateMessage$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r110 = true;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        List r106 = (List) r102.L$0;
        ResultKt.throwOnFailure(r103);
        return r106;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L19:
        List r107 = (List) r103;
        if (r107 == null) goto L38;
        List r108 = r107;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r111 = r108.iterator();
    L23:
        if (r111.hasNext() == false) goto L37;
        MessageEntity r112 = (MessageEntity) r111.next();
        int r113 = h.f348163a;
        String r114 = r112.getMessageId();
        if (r114 != null) goto L27;
        String r310 = "";
    L28:
        int r311 = k.e(r112);
        String r115 = r112.getContent();
        if (r115 != null) goto L31;
        String r312 = "";
    L32:
        String r116 = r112.getThinkingContent();
        if (r116 != null) goto L35;
        String r313 = "";
    L36:
        r109.add(MessageEntity.copy$default(r112, null, null, null, null, null, 0, 0, 0, false, 0, 0, null, null, null, 0, false, null, null, null, null, h.a("migrateMessage", r310, r311, r312, r313, k.b(r112)), null, null, null, null, 0, null, false, null, 0, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, -1048577, UnixStat.PERM_MASK, null));
        goto L23
    L35:
        r313 = r116;
        goto L36
    L31:
        r312 = r115;
        goto L32
    L27:
        r310 = r114;
        goto L28
    L37:
        ArrayList r117 = r109;
    L39:
        if (r117 != null) goto L41;
    L44:
        if (r110 == true) goto L50;
        MessageHandler r118 = MessageHandler.f347752a;
        r102.L$0 = r117;
        r102.label = 2;
        if (MessageHandler.s(r118, r117, false, false, false, null, r102, 48) != r104) goto L49;
        return r104;
    L49:
        return r117;
    L50:
        return null;
    L41:
        if (r117.isEmpty() == true) goto L44;
        r110 = false;
        goto L44
    L38:
        r117 = null;
        goto L39
    L16:
        ResultKt.throwOnFailure(r103);
        be9.d r119 = ae9.e.a();
        r102.label = 1;
        r103 = ((MessageDaoSource) r119).J(r610, 30, r611, r102);
        if (r103 != r104) goto L19;
        return r104;
    L7:
        r100 = new FtsInitUtils$migrateMessage$1(this, r612);
        goto L8
    }

    public static void c(int r100, int r101, long r102, long r103, boolean r110) {
        d1 r104 = d1.f348206b;
        e0 r105 = new e0();
        ouc.j.c(r105, "search_type", "message");
        ouc.j.b(r105, "count", Integer.valueOf(r100));
        ouc.j.b(r105, com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, Integer.valueOf(r101));
        ouc.j.b(r105, ChameleonOpenTracker.ParamKey.COST, Long.valueOf(r102));
        ouc.j.b(r105, "total_cost", Long.valueOf(r103));
        ouc.j.a(r105, "is_migrate_complete", Boolean.valueOf(r110));
        Unit r106 = Unit.INSTANCE;
        r104.a("chat_message_search_migrate_cost", r105.a());
    }
}
