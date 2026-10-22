package com.obric.matrix.platform.sdk.ones.picolinks;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.ResponseBody;
import com.obric.matrix.proto.StartPicoLinksResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/proto/Response;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PicoLinksHook$invokeStartPicoLinks$1 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ com.obric.matrix.platform.sdk.ones.picolinks.a $callback;
    final /* synthetic */ Ref.ObjectRef<Response> $response;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f397004a = null;

        static {
            int[] r100 = new int[StartPicoLinksResponse.Phase.values().length];
            r100[StartPicoLinksResponse.Phase.URL_REDIRECT.ordinal()] = 1;
            r100[StartPicoLinksResponse.Phase.ASYNC_CALLBACK.ordinal()] = 2;
            f397004a = r100;
        }
    }

    public PicoLinksHook$invokeStartPicoLinks$1(Ref.ObjectRef<Response> r100, com.obric.matrix.platform.sdk.ones.picolinks.a r101) {
        this.$response = r100;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Response r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.$response.element = r100;
        ResponseBody r101 = r100.body;
        if (r101 == null) goto L15;
        StartPicoLinksResponse r102 = r101.startPicoLinksResponse;
        if (r102 == null) goto L16;
        StartPicoLinksResponse.Phase r103 = r102.phase;
        if (r103 != null) goto L9;
        int r104 = -1;
    L11:
        if (r104 != 1) goto L17;
        String r105 = r102.phaseData.get("redirectUrl");
        return;
    L17:
        return;
    L9:
        r104 = a.f397004a[r103.ordinal()];
        goto L11
    L16:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Response r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
