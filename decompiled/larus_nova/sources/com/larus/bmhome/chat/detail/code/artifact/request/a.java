package com.larus.bmhome.chat.detail.code.artifact.request;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.detail.code.CodeBlockDetailFragment;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.f;
import com.larus.network.http.y;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f302720a;

    public a() {
        this.f302720a = "/samantha/code/get_artifact";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(a r100, long r110, Integer r111, Continuation r112) {
        r100.getClass();
        if ((r112 instanceof CodeArtifactRenderHelper$fetchArtifact$1) == false) goto L7;
        CodeArtifactRenderHelper$fetchArtifact$1 r101 = (CodeArtifactRenderHelper$fetchArtifact$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        CodeArtifactRenderHelper$fetchArtifact$1 r103 = r101;
        Object r113 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L22:
        com.larus.network.http.a r114 = (com.larus.network.http.a) r113;
        Object r115 = null;
        if ((r114 instanceof y) == false) goto L61;
        GetArtifactData r106 = (GetArtifactData) ((y) r114).f360135b;
        if (r106 == null) goto L74;
        List<CodeNodeContent> r107 = r106.getNodes();
        if (r107 == null) goto L74;
        List<CodeNodeContent> r116 = r107;
        Iterator<T> r117 = r116.iterator();
    L30:
        if (r117.hasNext() == false) goto L42;
        Object r118 = r117.next();
        CodeNodeContent r108 = (CodeNodeContent) r118;
        if (r108 == null) goto L34;
        boolean r109 = Intrinsics.areEqual(r108.isEntry(), Boolean.TRUE);
    L35:
        if (r109 == true) goto L37;
    L39:
        boolean r119 = false;
    L40:
        if (r119 == false) goto L30;
    L43:
        CodeNodeContent r120 = (CodeNodeContent) r118;
        if (r120 != null) goto L58;
        Iterator<T> r121 = r116.iterator();
    L47:
        if (r121.hasNext() == false) goto L55;
        Object r122 = r121.next();
        CodeNodeContent r123 = (CodeNodeContent) r122;
        if (r123 == null) goto L51;
        String r124 = r123.getLanguage();
    L53:
        if (Intrinsics.areEqual(r124, "html") == false) goto L47;
        r115 = r122;
        goto L55
    L51:
        r124 = null;
    L55:
        r115 = (CodeNodeContent) r115;
        if (r115 != null) goto L74;
        r115 = (CodeNodeContent) CollectionsKt.firstOrNull(r107);
        goto L74
    L58:
        r115 = r120;
        goto L74
    L37:
        if (Intrinsics.areEqual(r108.getLanguage(), "html") == false) goto L39;
        r119 = true;
        goto L40
    L34:
        r109 = false;
        goto L35
    L42:
        r118 = null;
    L74:
        return new Pair(r115, Boxing.boxBoolean(true));
    L61:
        if ((r114 instanceof f) == false) goto L63;
        Pair r125 = new Pair(null, Boxing.boxBoolean(true));
    L65:
        return r125;
    L63:
        r125 = new Pair(null, Boxing.boxBoolean(false));
        goto L65
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        String r126 = r100.f302720a;
        Pair[] r127 = new Pair[2];
        r127[0] = TuplesKt.to("code_id", String.valueOf(r110));
        if (r111 == null) goto L18;
        String r128 = r111.toString();
        if (r128 == null) goto L18;
    L19:
        r127[1] = TuplesKt.to("version", r128);
        Map r129 = MapsKt.mapOf(r127);
        r103.label = 1;
        r113 = HttpExtKt.h(ServiceType.BASIC_SERVICE, GetArtifactData.class, r126, r129, r103, 240);
        if (r113 != r104) goto L22;
        return r104;
    L18:
        r128 = "";
    L7:
        r101 = new CodeArtifactRenderHelper$fetchArtifact$1(r100, r112);
        goto L8
    }

    public final void b(LifecycleCoroutineScope r110, long r111, Integer r112, CodeBlockDetailFragment.d r113) {
        Intrinsics.checkNotNullParameter(r110, "scope");
        Intrinsics.checkNotNullParameter(r113, "listener");
        r113.b();
        BuildersKt.launch$default(r110, null, null, new CodeArtifactRenderHelper$requestArtifact$1(this, r111, r112, r113, null), 3, null);
    }
}
