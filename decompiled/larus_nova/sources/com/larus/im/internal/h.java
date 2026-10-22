package com.larus.im.internal;

import com.larus.im.constant.CompensateScene;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.protocol.bean.PullSingleChainDownlinkBody;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f348640d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<TokenHolder, MessageEntity, Continuation<? super Unit>, Object> f348641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<CompensateScene, Unit> f348642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function4<String, Long, PullSingleChainDownlinkBody, Continuation<? super Unit>, Object> f348643c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f348641a, r101.f348641a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f348642b, r101.f348642b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f348643c, r101.f348643c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f348641a.hashCode() * 31) + this.f348642b.hashCode()) * 31) + this.f348643c.hashCode();
    }

    public final String toString() {
        return "IMCoreMechanism(launchChunk=" + this.f348641a + ", fetchRecentConv=" + this.f348642b + ", fetchMessage=" + this.f348643c + ')';
    }

    public h(Function3 r100, i r101, Function4 r102) {
        Intrinsics.checkNotNullParameter(r100, "launchChunk");
        Intrinsics.checkNotNullParameter(r101, "fetchRecentConv");
        Intrinsics.checkNotNullParameter(r102, "fetchMessage");
        this.f348641a = r100;
        this.f348642b = r101;
        this.f348643c = r102;
    }
}
