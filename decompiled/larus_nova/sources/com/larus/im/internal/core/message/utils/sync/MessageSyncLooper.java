package com.larus.im.internal.core.message.utils.sync;

import android.os.SystemClock;
import androidx.collection.LruCache;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.internal.core.message.MessageHandler;
import com.larus.im.internal.core.message.concat.MessageConcatHelper;
import com.larus.im.internal.core.message.concat.g;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.protocol.bean.FetchChunkMessageDownlinkBody;
import com.larus.im.internal.tracking.v;
import com.larus.im.internal.tracking.w;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes29.dex */
public final class MessageSyncLooper extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MessageEntity f347886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f347887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f347888j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f347889k;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.im.internal.core.message.utils.sync.c
    public final Object f(Continuation<? super Unit> r110) {
        if ((r110 instanceof MessageSyncLooper$syncNow$1) == false) goto L7;
        MessageSyncLooper$syncNow$1 r100 = (MessageSyncLooper$syncNow$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MessageSyncLooper$syncNow$1 r102 = r100;
        Object r111 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r105 = r102.I$0;
        ResultKt.throwOnFailure(r111);
    L26:
        LruCache<String, v.a> r112 = v.f350494a;
        String r113 = this.f347889k;
        Intrinsics.checkNotNullParameter(r113, RemoteMessageConst.MSGID);
        v.a r114 = v.f350494a.get(r113);
        if (r114 == null) goto L29;
        r114.f350504j += SystemClock.elapsedRealtime() - r114.f350501g;
    L29:
        vt7.b<com.larus.im.internal.network.chunk.cache.a.C4363a> r115 = com.larus.im.internal.network.chunk.cache.a.f349088a;
        com.larus.im.internal.network.chunk.cache.a.f(this.f347900a, r105);
        this.f347888j = r105;
    L31:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r106 = r102.I$0;
        MessageSyncLooper r107 = (MessageSyncLooper) r102.L$0;
        ResultKt.throwOnFailure(r111);
        int r116 = r106;
    L22:
        r107.f347886h = (MessageEntity) r111;
        LruCache<String, v.a> r117 = v.f350494a;
        v.b(this.f347889k);
        MessageHandler r108 = MessageHandler.f347752a;
        MessageEntity r118 = this.f347886h;
        LinkedHashMap r109 = new LinkedHashMap();
        com.larus.im.bean.message.a.G0(r109);
        Unit r119 = Unit.INSTANCE;
        r102.L$0 = null;
        r102.I$0 = r116;
        r102.label = 2;
        if (MessageHandler.r(r108, r118, false, false, null, true, null, r109, r102, 222) != r103) goto L25;
        return r103;
    L25:
        r105 = r116;
        goto L26
    L16:
        ResultKt.throwOnFailure(r111);
        int r120 = this.f347887i;
        if (r120 <= this.f347888j) goto L31;
        int r121 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("MessageSyncLooper", "looper(" + this.f347889k + "): syncNow seqNum = " + r120);
        g r122 = this.f347904e;
        MessageEntity r123 = this.f347886h;
        r102.L$0 = this;
        r102.I$0 = r120;
        r102.label = 1;
        ((MessageConcatHelper) r122.f347789a.getValue()).getClass();
        if (r123 != r103) goto L21;
        return r103;
    L21:
        r107 = this;
        r116 = r120;
        r111 = r123;
    L7:
        r100 = new MessageSyncLooper$syncNow$1(this, r110);
        goto L8
    }

    @Override // com.larus.im.internal.core.message.utils.sync.c
    public final Unit d(int r100, FetchChunkMessageDownlinkBody r101) {
        if (r101 == null) goto L4;
        int r102 = r101.seqNo;
    L5:
        if (r102 < 0) goto L8;
        this.f347887i = r102;
    L8:
        return Unit.INSTANCE;
    L4:
        r102 = -1;
        goto L5
    }

    @Override // com.larus.im.internal.core.message.utils.sync.c
    public final Object g(int r100, Continuation<? super Unit> r101) {
        Object r102 = MessageHandler.f347752a.z(this.f347889k, r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public MessageSyncLooper(MessageEntity r100, String r101, CoroutineDispatcher r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "dispatcher");
        super(r101, r102);
        this.f347886h = r100;
        String r103 = r100.getMessageId();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        this.f347889k = r103;
    }

    @Override // com.larus.im.internal.core.message.utils.sync.c
    public final Object c(MessageEntity r100, List<Integer> r101, Continuation<? super Unit> r110) {
        if ((r110 instanceof MessageSyncLooper$concatMessage$1) == false) goto L7;
        MessageSyncLooper$concatMessage$1 r102 = (MessageSyncLooper$concatMessage$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        MessageSyncLooper$concatMessage$1 r104 = r102;
        Object r111 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        MessageSyncLooper r107 = (MessageSyncLooper) r104.L$0;
        ResultKt.throwOnFailure(r111);
    L18:
        r107.f347886h = (MessageEntity) r111;
        w r108 = w.f350508a;
        MessageEntity r109 = this.f347886h;
        r108.getClass();
        w.a(r109);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        w.f350508a.getClass();
        w.b("single", r100);
        g r112 = this.f347904e;
        MessageEntity r113 = this.f347886h;
        r104.L$0 = this;
        r104.label = 1;
        r111 = r112.b(r100, r113, r101, true, r104);
        if (r111 != r105) goto L17;
        return r105;
    L17:
        r107 = this;
    L7:
        r102 = new MessageSyncLooper$concatMessage$1(this, r110);
        goto L8
    }
}
