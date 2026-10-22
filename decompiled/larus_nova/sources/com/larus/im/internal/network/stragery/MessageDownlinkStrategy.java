package com.larus.im.internal.network.stragery;

import com.larus.im.internal.network.channel.g;
import com.larus.im.internal.network.channel.i;
import com.larus.im.internal.protocol.bean.DownlinkMessage;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class MessageDownlinkStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f349533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Job f349534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vt7.b<Function1<DownlinkMessage, Unit>> f349535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f349536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f349537e;

    public final void a() {
        Job r100 = this.f349534b;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f349534b = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MessageDownlinkStrategy$pendingFetchChain$1(this, null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.im.internal.network.stragery.b] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.im.internal.network.stragery.c] */
    public MessageDownlinkStrategy(i r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "wsChannel");
        Intrinsics.checkNotNullParameter(r101, "apiChannel");
        this.f349533a = r100;
        this.f349535c = new vt7.b();
        this.f349536d = new b(this);
        this.f349537e = new c(this);
    }
}
