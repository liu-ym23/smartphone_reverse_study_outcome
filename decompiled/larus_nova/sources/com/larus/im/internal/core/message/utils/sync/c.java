package com.larus.im.internal.core.message.utils.sync;

import com.larus.im.bean.message.MessageStatusLocal;
import com.larus.im.internal.core.message.concat.g;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.protocol.bean.FetchChunkMessageDownlinkBody;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes29.dex */
public abstract class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<Long> f347898f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy<Boolean> f347899g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f347900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineDispatcher f347901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f347902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f347903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f347904e;

    public static final class a {
        public static boolean a() {
            return c.f347899g.getValue().booleanValue();
        }

        public a() {
        }
    }

    public abstract Object c(MessageEntity r100, List<Integer> r101, Continuation<? super Unit> r102);

    public abstract Unit d(int r100, FetchChunkMessageDownlinkBody r101);

    public abstract Object f(Continuation<? super Unit> r100);

    public abstract Object g(@MessageStatusLocal int r100, Continuation<? super Unit> r101);

    static {
        new a();
        f347898f = LazyKt.lazy(new com.larus.im.internal.core.message.utils.sync.a());
        f347899g = LazyKt.lazy(new b());
    }

    public Unit b(String r100) {
        return Unit.INSTANCE;
    }

    public c(String r100, CoroutineDispatcher r101) {
        Intrinsics.checkNotNullParameter(r100, "chunkToken");
        Intrinsics.checkNotNullParameter(r101, "dispatcher");
        this.f347900a = r100;
        this.f347901b = r101;
        this.f347903d = CoroutineScopeKt.CoroutineScope(r101);
        this.f347904e = new g();
    }

    public final Object e(@MessageStatusLocal Integer r100, ContinuationImpl r101) {
        Object r102 = BuildersKt.withContext(this.f347901b, new AbsMessageSyncLooper$stop$2(this, r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public Object a(MessageEntity r100, FetchChunkMessageDownlinkBody r110, int r111, ContinuationImpl r112) {
        Object r101 = BuildersKt.withContext(this.f347901b, new AbsMessageSyncLooper$append$2(this, r100, r110, r111, null), r112);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }
}
