package com.larus.uaigc.helper;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.larus.bmhome.resource.access.ResourceInputType;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourceRemoteResolver;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/larus/uaigc/helper/CreationImageRemoteResolver;", "Lcom/larus/bmhome/resource/access/ResourceRemoteResolver;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "supports", "", "scene", "Lcom/larus/bmhome/resource/access/ResourceAccessScene;", "resourceInputType", "Lcom/larus/bmhome/resource/access/ResourceInputType;", "mediaType", "Lcom/larus/bmhome/resource/access/ResourceMediaType;", JSEventListener.ACTION_RESOLVE, "Lcom/larus/bmhome/resource/access/NodeResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/bmhome/resource/access/ResourceContext;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remoteResolveAttributes", "", "state", "Lcom/larus/uaigc/helper/CreationImageRemoteResolver$CreationRemoteResolveState;", "CreationRemoteResolveState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationImageRemoteResolver implements ResourceRemoteResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f372943a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/uaigc/helper/CreationImageRemoteResolver$CreationRemoteResolveState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DIRECT", "FALLBACK", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CreationRemoteResolveState extends Enum<CreationRemoteResolveState> {
        public static final CreationRemoteResolveState DIRECT = null;
        public static final CreationRemoteResolveState FAILED = null;
        public static final CreationRemoteResolveState FALLBACK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CreationRemoteResolveState[] f372944a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f372945b = null;
        private final String value;

        public static EnumEntries<CreationRemoteResolveState> getEntries() {
            return f372945b;
        }

        static {
            CreationRemoteResolveState r100 = new CreationRemoteResolveState("DIRECT", 0, "direct");
            DIRECT = r100;
            CreationRemoteResolveState r101 = new CreationRemoteResolveState("FALLBACK", 1, "fallback");
            FALLBACK = r101;
            CreationRemoteResolveState r102 = new CreationRemoteResolveState("FAILED", 2, "failed");
            FAILED = r102;
            CreationRemoteResolveState[] r103 = {r100, r101, r102};
            f372944a = r103;
            f372945b = EnumEntriesKt.enumEntries(r103);
        }

        public static CreationRemoteResolveState[] values() {
            return (CreationRemoteResolveState[]) f372944a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static CreationRemoteResolveState valueOf(String r100) {
            return (CreationRemoteResolveState) r27.a.a(CreationRemoteResolveState.class, r100);
        }

        public CreationRemoteResolveState(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    public CreationImageRemoteResolver() {
        this.f372943a = "creation_image_remote_resolver";
    }

    @Override // com.larus.bmhome.resource.access.ResourceRemoteResolver
    public final String getKey() {
        return this.f372943a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.resource.access.ResourceRemoteResolver
    public final Object a(com.larus.bmhome.resource.access.h0 r210, Continuation<? super com.larus.bmhome.resource.access.g> r211) {
        com.larus.bmhome.resource.access.h0 r100 = r210;
        if ((r211 instanceof CreationImageRemoteResolver$resolve$1) == false) goto L7;
        CreationImageRemoteResolver$resolve$1 r101 = (CreationImageRemoteResolver$resolve$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        CreationImageRemoteResolver r106 = (CreationImageRemoteResolver) r101.L$2;
        com.larus.bmhome.resource.access.j0.c r107 = (com.larus.bmhome.resource.access.j0.c) r101.L$1;
        com.larus.bmhome.resource.access.h0 r108 = (com.larus.bmhome.resource.access.h0) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L14
        CreationImageRemoteResolver r109 = r106;
        r100 = r108;
        Object r110 = r103;
    L29:
        com.larus.uaigc.api.s r111 = (com.larus.uaigc.api.s) ((com.larus.network.http.a) r110).f360135b;     // Catch: Throwable -> L14
        if (r111 == null) goto L34;
        List<com.larus.uaigc.api.q> r112 = r111.a();     // Catch: Throwable -> L14
        if (r112 == null) goto L34;
        com.larus.uaigc.api.q r113 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r112);     // Catch: Throwable -> L14
    L35:
        if (r113 == null) goto L37;
        String r114 = r113.c();     // Catch: Throwable -> L14
    L39:
        if (r114 != null) goto L41;
    L44:
        boolean r115 = true;
    L45:
        if (r115 == true) goto L77;
        if (r113 == null) goto L48;
        boolean r116 = Intrinsics.areEqual(r113.a(), Boxing.boxBoolean(true));     // Catch: Throwable -> L14
    L49:
        if (r116 == true) goto L77;
        com.larus.bmhome.resource.access.j0.d r117 = new com.larus.bmhome.resource.access.j0.d(r114);     // Catch: Throwable -> L14
        com.larus.uaigc.api.p r118 = r113.b();     // Catch: Throwable -> L14
        if (r118 == null) goto L56;
        com.larus.uaigc.api.n r119 = r118.a();     // Catch: Throwable -> L14
        if (r119 == null) goto L56;
        com.larus.uaigc.api.m r120 = r119.a();     // Catch: Throwable -> L14
    L57:
        ResourceMediaType r121 = r100.f313671a.f313764c;     // Catch: Throwable -> L14
        Pair[] r122 = new Pair[3];     // Catch: Throwable -> L14
        r122[0] = TuplesKt.to("remote_url", r107.f313695b);     // Catch: Throwable -> L14
        if (r120 == null) goto L63;
        Long r123 = r120.b();     // Catch: Throwable -> L14
        if (r123 == null) goto L63;
        String r124 = r123.toString();     // Catch: Throwable -> L14
    L64:
        String r125 = "";
        if (r124 != null) goto L67;
        r124 = "";
    L67:
        r122[1] = TuplesKt.to("width", r124);     // Catch: Throwable -> L14
        if (r120 == null) goto L72;
        Long r126 = r120.a();     // Catch: Throwable -> L14
        if (r126 == null) goto L72;
        String r127 = r126.toString();     // Catch: Throwable -> L14
    L73:
        if (r127 == null) goto L76;
        r125 = r127;
    L76:
        r122[2] = TuplesKt.to("height", r125);     // Catch: Throwable -> L14
        com.larus.bmhome.resource.access.f0 r212 = new com.larus.bmhome.resource.access.f0(r121, r117, r114, null, null, MapsKt.mapOf(r122), 24);     // Catch: Throwable -> L14
        CreationRemoteResolveState r128 = CreationRemoteResolveState.DIRECT;     // Catch: Throwable -> L14
        r109.getClass();     // Catch: Throwable -> L14
        com.larus.bmhome.resource.access.g.a r129 = new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(r117, null, null, null, null, r212, MapsKt.mapOf(TuplesKt.to("remote_resolve", r128.getValue())), 30));     // Catch: Throwable -> L14
    L82:
        Object r130 = Result.m9449constructorimpl(r129);     // Catch: Throwable -> L14
    L87:
        Throwable r131 = Result.m9452exceptionOrNullimpl(r130);
        if (r131 == null) goto L96;
        FLogger.f375446a.e("CreationImageRemoteResolver", "[resolve] failed, url=" + r107.f313695b, r131);
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, MapsKt.mapOf(TuplesKt.to("remote_resolve", CreationRemoteResolveState.FAILED.getValue())), 63));
    L96:
        return r130;
    L72:
        r127 = null;
    L63:
        r124 = null;
    L56:
        r120 = null;
        goto L57
    L48:
        r116 = false;
    L77:
        FLogger r132 = FLogger.f375446a;     // Catch: Throwable -> L14
        StringBuilder r133 = new StringBuilder("[resolve] fallback, url=");     // Catch: Throwable -> L14
        r133.append(r107.f313695b);     // Catch: Throwable -> L14
        r133.append(", needRePush=");     // Catch: Throwable -> L14
        if (r113 == null) goto L80;
        Boolean r134 = r113.a();     // Catch: Throwable -> L14
    L81:
        r133.append(r134);     // Catch: Throwable -> L14
        r132.i("CreationImageRemoteResolver", r133.toString());     // Catch: Throwable -> L14
        CreationRemoteResolveState r135 = CreationRemoteResolveState.FALLBACK;     // Catch: Throwable -> L14
        r109.getClass();     // Catch: Throwable -> L14
        r129 = new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, MapsKt.mapOf(TuplesKt.to("remote_resolve", r135.getValue())), 63));     // Catch: Throwable -> L14
        goto L82
    L80:
        r134 = null;
        goto L81
    L41:
        if (StringsKt.isBlank(r114) == true) goto L44;
        r115 = false;
        goto L45
    L37:
        r114 = null;
    L34:
        r113 = null;
    L14:
        th = th;
        com.larus.bmhome.resource.access.j0.c r136 = r107;
    L86:
        Result.Companion r137 = Result.Companion;
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r107 = r136;
        goto L87
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        com.larus.bmhome.resource.access.j0 r138 = r100.f313673c;
        if ((r138 instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L21;
        r136 = (com.larus.bmhome.resource.access.j0.c) r138;
    L22:
        if (r136 == null) goto L24;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L85
        List r140 = CollectionsKt.listOf(r136.f313695b);     // Catch: Throwable -> L85
        r101.L$0 = r100;     // Catch: Throwable -> L85
        r101.L$1 = r136;     // Catch: Throwable -> L85
        r101.L$2 = this;     // Catch: Throwable -> L85
        r101.label = 1;     // Catch: Throwable -> L85
        r110 = com.larus.uaigc.api.o.a(r140, true, r101);     // Catch: Throwable -> L85
        if (r110 != r104) goto L28;
        return r104;
    L28:
        r107 = r136;
        r109 = this;
    L85:
        th = th;
        goto L86
    L24:
        return com.larus.bmhome.resource.access.g.e.f313653a;
    L21:
        r136 = null;
    L7:
        r101 = new CreationImageRemoteResolver$resolve$1(this, r211);
        goto L8
    }

    @Override // com.larus.bmhome.resource.access.ResourceRemoteResolver
    public final boolean b(com.larus.bmhome.resource.access.x r100, ResourceInputType r101, ResourceMediaType r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "resourceInputType");
        Intrinsics.checkNotNullParameter(r102, "mediaType");
        com.larus.bmhome.resource.access.x r103 = com.larus.uaigc.service.f.f373957a;
        if (SetsKt.setOf(new com.larus.bmhome.resource.access.x[]{com.larus.uaigc.service.f.f373957a, com.larus.uaigc.service.f.f373958b}).contains(r100) == true) goto L5;
        return false;
    L5:
        if (r101 == ResourceInputType.REMOTE_URL) goto L7;
        return false;
    L7:
        if (r102 != ResourceMediaType.IMAGE) goto L12;
        return true;
    L12:
        return false;
    }
}
