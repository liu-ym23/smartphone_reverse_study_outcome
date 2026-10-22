package hmc;

import com.ss.ugc.live.sdk.msg.network.g;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWFetchResponse;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f486055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UMGWFetchResponse f486056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f486057c;

    public a(g r100, UMGWFetchResponse r101, List<b> r102) {
        Intrinsics.checkNotNullParameter(r100, "httpResponse");
        Intrinsics.checkNotNullParameter(r101, "originResponse");
        Intrinsics.checkNotNullParameter(r102, "decodePackets");
        this.f486055a = r100;
        this.f486056b = r101;
        this.f486057c = r102;
    }
}
