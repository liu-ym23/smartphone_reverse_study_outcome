package com.larus.im.internal.core.message.utils.sync;

import ae9.e;
import android.os.SystemClock;
import androidx.collection.LruCache;
import be9.d;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.internal.core.message.MessageHandler;
import com.larus.im.internal.core.message.concat.MessageConcatHelper;
import com.larus.im.internal.core.message.concat.g;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.k;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.network.chunk.cache.SseHeaderCache;
import com.larus.im.internal.protocol.bean.FetchChunkMessageDownlinkBody;
import com.larus.im.internal.stream.PendingHandler;
import com.larus.im.internal.tracking.v;
import com.larus.im.internal.tracking.w;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes29.dex */
public final class MultiMessageSyncLooper extends c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f347890o = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final me9.b f347891h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final vt7.a<String, MessageEntity> f347892i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final vt7.b<String> f347893j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile int f347894k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile int f347895l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutexImpl f347896m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Set<String> f347897n;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.im.internal.core.message.utils.sync.c
    public final Unit b(String r100) {
        this.f347893j.add(r100);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00e4 -> B:39:0x00e8). Please report as a decompilation issue!!! */
    @Override // com.larus.im.internal.core.message.utils.sync.c
    public final Object f(Continuation<? super Unit> r110) {
        if ((r110 instanceof MultiMessageSyncLooper$syncNow$1) == false) goto L7;
        MultiMessageSyncLooper$syncNow$1 r100 = (MultiMessageSyncLooper$syncNow$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L18;
        if (r103 != 3) goto L17;
        int r104 = r100.I$0;
        MessageEntity r105 = (MessageEntity) r100.L$2;
        Iterator r106 = (Iterator) r100.L$1;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L43
        int r112 = r104;
        Iterator r108 = r106;
        MessageEntity r109 = r105;
        MultiMessageSyncLooper r113 = this;
    L39:
        vt7.a<String, MessageEntity> r114 = r113.f347892i;     // Catch: Throwable -> L43
        String r115 = r109.getMessageId();     // Catch: Throwable -> L43
        if (r115 != null) goto L42;
        r115 = "";
    L42:
        r114.put(r115, r109);     // Catch: Throwable -> L43
    L30:
        if (r108.hasNext() == false) goto L46;
        MessageEntity r116 = (MessageEntity) r108.next();     // Catch: Throwable -> L43
        g r117 = r113.f347904e;     // Catch: Throwable -> L43
        r100.L$0 = r107;     // Catch: Throwable -> L43
        r100.L$1 = r108;     // Catch: Throwable -> L43
        r100.L$2 = null;     // Catch: Throwable -> L43
        r100.I$0 = r112;     // Catch: Throwable -> L43
        r100.label = 2;     // Catch: Throwable -> L43
        ((MessageConcatHelper) r117.f347789a.getValue()).getClass();     // Catch: Throwable -> L43
        if (r116 != r102) goto L34;
        return r102;
    L34:
        Iterator r118 = r108;
        int r119 = r112;
        r111 = r116;
        Iterator r120 = r118;
    L35:
        MessageEntity r121 = (MessageEntity) r111;     // Catch: Throwable -> L43
        r100.L$0 = r107;     // Catch: Throwable -> L43
        r100.L$1 = r120;     // Catch: Throwable -> L43
        r100.L$2 = r121;     // Catch: Throwable -> L43
        r100.I$0 = r119;     // Catch: Throwable -> L43
        r100.label = 3;     // Catch: Throwable -> L43
        if (r113.h(r121, r119, r100) != r102) goto L38;
        return r102;
    L38:
        Iterator r122 = r120;
        r109 = r121;
        r112 = r119;
        r108 = r122;
    L46:
        vt7.b<com.larus.im.internal.network.chunk.cache.a.C4363a> r123 = com.larus.im.internal.network.chunk.cache.a.f349088a;     // Catch: Throwable -> L43
        com.larus.im.internal.network.chunk.cache.a.f(r113.f347900a, r112);     // Catch: Throwable -> L43
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L43
        r107.unlock(null);
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r119 = r100.I$0;
        Iterator r125 = (Iterator) r100.L$1;
        r107 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L43
        r120 = r125;
        r113 = this;
        goto L35
    L21:
        kotlinx.coroutines.sync.a r126 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r111);
        r107 = r126;
    L26:
        r112 = this.f347895l;     // Catch: Throwable -> L43
        if (r112 <= this.f347894k) goto L45;
        int r127 = com.larus.im.internal.network.chunk.a.f349081a;     // Catch: Throwable -> L43
        com.larus.im.internal.utils.b.c("MultiMessageSyncLooper", "looper(" + r112 + "): syncNow seqNum = " + r112);     // Catch: Throwable -> L43
        r108 = this.f347892i.values().iterator();     // Catch: Throwable -> L43
        r113 = this;
        goto L30
    L45:
        r113 = this;
        goto L46
    L22:
        ResultKt.throwOnFailure(r111);
        MutexImpl r128 = this.f347896m;
        r100.L$0 = r128;
        r100.label = 1;
        if (r128.a(null, r100) != r102) goto L25;
        return r102;
    L25:
        r107 = r128;
    L43:
        th = move-exception;
        r107.unlock(null);
        throw th;
    L7:
        r100 = new MultiMessageSyncLooper$syncNow$1(this, r110);
        goto L8
    }

    @Override // com.larus.im.internal.core.message.utils.sync.c
    public final Unit d(int r100, FetchChunkMessageDownlinkBody r101) {
        this.f347895l = r100;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [int] */
    /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v4, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [int] */
    /* JADX WARN: Type inference failed for: r12v9 */
    @Override // com.larus.im.internal.core.message.utils.sync.c
    public final Object g(int r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof MultiMessageSyncLooper$updateStatus$1) == false) goto L7;
        MultiMessageSyncLooper$updateStatus$1 r100 = (MultiMessageSyncLooper$updateStatus$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 != 2) goto L16;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L44
        r110 = r113;
    L41:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L44
        r110.unlock(null);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r115 = r100.I$0;
        kotlinx.coroutines.sync.a r104 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
        ?? r116 = r115;
        kotlinx.coroutines.sync.a r117 = r104;
    L22:
        vt7.b<String> r105 = this.f347893j;     // Catch: Throwable -> L44
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L44
        Iterator<String> r107 = r105.iterator();     // Catch: Throwable -> L44
    L24:
        if (r107.hasNext() == false) goto L34;
        String r108 = r107.next();     // Catch: Throwable -> L44
        String r109 = r108;     // Catch: Throwable -> L44
        if (r109 != null) goto L28;
    L31:
        boolean r118 = true;
    L32:
        if (r118 == true) goto L24;
        r106.add(r108);     // Catch: Throwable -> L44
        goto L24
    L28:
        if (r109.length() == 0) goto L31;
        r118 = false;
        goto L32
    L34:
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));     // Catch: Throwable -> L44
        Iterator r120 = r106.iterator();     // Catch: Throwable -> L44
    L36:
        if (r120.hasNext() == false) goto L38;
        r119.add(TuplesKt.to((String) r120.next(), Boxing.boxInt(r116)));     // Catch: Throwable -> L44
        goto L36
    L38:
        MessageHandler r121 = MessageHandler.f347752a;     // Catch: Throwable -> L44
        r100.L$0 = r117;     // Catch: Throwable -> L44
        r100.label = 2;     // Catch: Throwable -> L44
        r121.getClass();     // Catch: Throwable -> L44
        r110 = r117;
        if (MessageHandler.k(r119, r100) != r102) goto L41;
        return r102;
    L18:
        ResultKt.throwOnFailure(r112);
        MutexImpl r122 = this.f347896m;
        r100.L$0 = r122;
        r100.I$0 = r110;
        r100.label = 1;
        if (r122.a(null, r100) != r102) goto L21;
        return r102;
    L21:
        r116 = r110;
        r117 = r122;
    L44:
        th = move-exception;
        r110.unlock(null);
        throw th;
    L7:
        r100 = new MultiMessageSyncLooper$updateStatus$1(this, r111);
        goto L8
    }

    public final Object i(String r100, Continuation<? super MessageEntity> r101) {
        if ((r101 instanceof MultiMessageSyncLooper$fallbackQuery$1) == false) goto L7;
        MultiMessageSyncLooper$fallbackQuery$1 r102 = (MultiMessageSyncLooper$fallbackQuery$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        ResultKt.throwOnFailure(r104);
    L32:
        return r104;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        MessageEntity r107 = (MessageEntity) r102.L$0;
        ResultKt.throwOnFailure(r104);
        return r107;
    L17:
        ResultKt.throwOnFailure(r104);
    L23:
        MessageEntity r108 = (MessageEntity) r104;
        if (r108 == null) goto L33;
        SseHeaderCache r109 = SseHeaderCache.f349082a;
        String r110 = this.f347900a;
        r102.L$0 = r108;
        r102.label = 2;
        if (r109.b(r108, r110, r102) != r105) goto L34;
        return r105;
    L34:
        return r108;
    L33:
        return r108;
    L18:
        ResultKt.throwOnFailure(r104);
        if ((this.f347891h instanceof me9.b.c) == false) goto L29;
        d r111 = e.a();
        r102.label = 1;
        r104 = r111.a(r100, r102);
        if (r104 != r105) goto L23;
        return r105;
    L29:
        SseHeaderCache r112 = SseHeaderCache.f349082a;
        String r113 = this.f347900a;
        r102.label = 3;
        r104 = r112.a(r100, r113, r102);
        if (r104 != r105) goto L32;
        return r105;
    L7:
        r102 = new MultiMessageSyncLooper$fallbackQuery$1(this, r101);
        goto L8
    }

    public MultiMessageSyncLooper(String r100, CoroutineDispatcher r101, me9.b r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "dispatcher");
        Intrinsics.checkNotNullParameter(r102, "launchMode");
        super(r100, r101);
        this.f347891h = r102;
        this.f347892i = new vt7.a();
        this.f347893j = new vt7.b();
        this.f347894k = y0.e().f348580l;
        this.f347895l = y0.e().f348580l;
        this.f347896m = kotlinx.coroutines.sync.b.a();
        this.f347897n = new LinkedHashSet();
    }

    @Override // com.larus.im.internal.core.message.utils.sync.c
    public final Object c(MessageEntity r100, List<Integer> r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof MultiMessageSyncLooper$concatMessage$1) == false) goto L7;
        MultiMessageSyncLooper$concatMessage$1 r101 = (MultiMessageSyncLooper$concatMessage$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        MultiMessageSyncLooper$concatMessage$1 r103 = r101;
        Object r112 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        String r106 = (String) r103.L$0;
        ResultKt.throwOnFailure(r112);
    L39:
        MessageEntity r113 = (MessageEntity) r112;
        w.f350508a.getClass();
        w.a(r113);
        this.f347892i.put(r106, r113);
        this.f347893j.add(r106);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r107 = (String) r103.L$2;
        r110 = (List) r103.L$1;
        MessageEntity r108 = (MessageEntity) r103.L$0;
        ResultKt.throwOnFailure(r112);
        String r114 = r107;
        r100 = r108;
        Object r109 = r112;
    L31:
        MessageEntity r115 = (MessageEntity) r109;
    L32:
        MessageEntity r116 = r100;
        r106 = r114;
        MessageEntity r117 = r115;
        if (k.h(r116) == false) goto L36;
        if (r110 != null) goto L36;
        r110 = CollectionsKt.emptyList();
    L36:
        w.f350508a.getClass();
        w.b(PriorityModule.SCENE_MULTI, r116);
        g r118 = this.f347904e;
        r103.L$0 = r106;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.label = 2;
        r112 = r118.b(r116, r117, r110, true, r103);
        if (r112 != r104) goto L39;
        return r104;
    L16:
        ResultKt.throwOnFailure(r112);
        r114 = r100.getMessageId();
        if (r114 != null) goto L19;
    L22:
        boolean r119 = true;
    L23:
        if (r119 == false) goto L26;
        int r120 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.a("MultiMessageSyncLooper", "try append chunk failed, token(" + this.f347900a + ").");
        return Unit.INSTANCE;
    L26:
        r115 = this.f347892i.get(r114);
        if (r115 != null) goto L32;
        r103.L$0 = r100;
        r103.L$1 = r110;
        r103.L$2 = r114;
        r103.label = 1;
        r109 = i(r114, r103);
        if (r109 != r104) goto L31;
        return r104;
    L19:
        if (StringsKt.isBlank(r114) == true) goto L22;
        r119 = false;
    L7:
        r101 = new MultiMessageSyncLooper$concatMessage$1(this, r111);
        goto L8
    }

    public final Object h(MessageEntity r510, int r511, Continuation<? super Unit> r610) {
        if ((r610 instanceof MultiMessageSyncLooper$doSync$1) == false) goto L7;
        MultiMessageSyncLooper$doSync$1 r100 = (MultiMessageSyncLooper$doSync$1) r610;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MultiMessageSyncLooper$doSync$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        int r104 = r110.I$0;
        ResultKt.throwOnFailure(r102);
        MultiMessageSyncLooper r105 = this;
    L54:
        r105.f347894k = r104;
    L56:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r104 = r110.I$0;
        MessageEntity r106 = (MessageEntity) r110.L$0;
        ResultKt.throwOnFailure(r102);
        MessageEntity r107 = r106;
        Object r112 = r111;
        MultiMessageSyncLooper$doSync$1 r113 = r110;
    L43:
        LruCache<String, v.a> r108 = v.f350494a;
        String r109 = r107.getMessageId();
        if (r109 != null) goto L46;
        r109 = "";
    L46:
        Intrinsics.checkNotNullParameter(r109, RemoteMessageConst.MSGID);
        v.a r114 = v.f350494a.get(r109);
        if (r114 == null) goto L49;
        r114.f350504j += SystemClock.elapsedRealtime() - r114.f350501g;
    L49:
        r105 = this;
        if (r105.f347897n.remove(r107.getLocalMessageId()) == false) goto L54;
        d r115 = e.a();
        String r116 = r107.getLocalMessageId() + PendingHandler.f350087d;
        r113.L$0 = null;
        r113.I$0 = r104;
        r113.label = 3;
        if (((MessageDaoSource) r115).g(r116, r113) != r112) goto L54;
        return r112;
    L17:
        MessageEntity r117 = (MessageEntity) r110.L$0;
        ResultKt.throwOnFailure(r102);
        MessageEntity r118 = r117;
    L35:
        int r119 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("MultiMessageSyncLooper", "is pending msg, id = " + r118.getMessageId() + ' ');
        goto L56
    L18:
        ResultKt.throwOnFailure(r102);
        PendingHandler r120 = PendingHandler.f350084a;
        String r121 = r510.getMessageId();
        if (r121 != null) goto L21;
        r121 = "";
    L21:
        Intrinsics.checkNotNullParameter(r121, RemoteMessageConst.MSGID);
        Iterator<PendingHandler.a> r122 = PendingHandler.f350089f.iterator();
    L23:
        if (r122.hasNext() == false) goto L27;
        PendingHandler.a r123 = r122.next();
        if (Intrinsics.areEqual(r123.f350092a.messageId, r121) == false) goto L23;
    L28:
        if (r123 == null) goto L30;
        boolean r124 = true;
    L31:
        if (r124 == false) goto L36;
        this.f347897n.add(r510.getLocalMessageId());
        d r512 = e.a();
        StringBuilder r125 = new StringBuilder();
        r125.append(r510.getConversationId());
        String r126 = PendingHandler.f350087d;
        r125.append(r126);
        String r210 = r125.toString();
        r118 = r510;
        MessageEntity r127 = MessageEntity.copy$default(r510, r510.getLocalMessageId() + r126, r510.getMessageId() + r126, null, null, null, 0, 0, 0, false, 0, 0, null, null, null, 0, false, null, null, null, null, null, null, r210, null, null, 0, null, false, null, 0, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, -4194308, UnixStat.PERM_MASK, null);
        r110.L$0 = r118;
        r110.label = 1;
        if (((MessageDaoSource) r512).a0(r127, r110) != r111) goto L35;
        return r111;
    L36:
        r107 = r510;
        r112 = r111;
        r113 = r110;
        LruCache<String, v.a> r128 = v.f350494a;
        String r129 = r510.getMessageId();
        if (r129 != null) goto L39;
        r129 = "";
    L39:
        v.b(r129);
        MessageHandler r130 = MessageHandler.f347752a;
        LinkedHashMap r131 = new LinkedHashMap();
        com.larus.im.bean.message.a.G0(r131);
        Unit r132 = Unit.INSTANCE;
        r113.L$0 = r107;
        r113.I$0 = r511;
        r113.label = 2;
        if (MessageHandler.r(r130, r510, false, false, null, true, null, r131, r113, 222) != r112) goto L42;
        return r112;
    L42:
        r104 = r511;
        goto L43
    L30:
        r124 = false;
        goto L31
    L27:
        r123 = null;
    L7:
        r100 = new MultiMessageSyncLooper$doSync$1(this, r610);
        goto L8
    }

    @Override // com.larus.im.internal.core.message.utils.sync.c
    public final Object a(MessageEntity r100, FetchChunkMessageDownlinkBody r110, int r111, ContinuationImpl r112) {
        Object r101 = BuildersKt.withContext(this.f347901b, new MultiMessageSyncLooper$append$2(this, r100, r110, r111, null), r112);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }
}
