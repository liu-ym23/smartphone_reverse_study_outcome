package com.larus.im.internal.stream;

import androidx.collection.LruCache;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class StreamChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StreamChannel f350095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, Boolean> f350096b = null;

    public StreamChannel() {
    }

    static {
        f350095a = new StreamChannel();
        f350096b = new LruCache(3);
    }

    public static Object c(Message r100, Continuation r101) {
        return OmniDatabaseExtKt.e(new StreamChannel$interrupt$2(r100, null), r101);
    }

    public static Object a(Message r100, boolean r101, boolean r102, Continuation r103) {
        Object r104 = OmniDatabaseExtKt.e(new StreamChannel$cancel$2(r100, r102, r101, null), r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r104;
    L6:
        return Unit.INSTANCE;
    }

    public static Object d(Message r100, Message r101, boolean r102, Continuation r103) {
        Object r104 = OmniDatabaseExtKt.e(new StreamChannel$start$2(r100, r101, r102, null), r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r104;
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object b(StreamChannel r100, Message r101, boolean r102, Continuation r103, int r104) {
        boolean r105 = false;
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r105 = true;
    L8:
        r100.getClass();
        return a(r101, r102, r105, r103);
    }
}
