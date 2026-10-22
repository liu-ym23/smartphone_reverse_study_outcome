package com.larus.image.loader;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.utils.y0;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class ResourceUrlExpireHandleUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ResourceUrlExpireHandleUtil f350961a = null;

    static {
        f350961a = new ResourceUrlExpireHandleUtil();
    }

    public ResourceUrlExpireHandleUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r110, Continuation<? super String> r210) {
        String r100 = r110;
        if ((r210 instanceof ResourceUrlExpireHandleUtil$getRenewUrl$1) == false) goto L7;
        ResourceUrlExpireHandleUtil$getRenewUrl$1 r101 = (ResourceUrlExpireHandleUtil$getRenewUrl$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ResourceUrlExpireHandleUtil$getRenewUrl$1 r111 = r101;
        Object r103 = r111.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r111.label;
        boolean r112 = false;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        r100 = (String) r111.L$0;
        ResultKt.throwOnFailure(r103);
        Object r106 = r103;
    L42:
        y r107 = (y) ((com.larus.network.http.a) r106).f360135b;
        if (r107 == null) goto L49;
        List<f> r108 = r107.a();
        if (r108 == null) goto L49;
        f r109 = (f) CollectionsKt.firstOrNull(r108);
        if (r109 == null) goto L49;
        String r113 = r109.a();
    L50:
        if (r113 != null) goto L52;
    L55:
        boolean r114 = true;
    L56:
        if (r114 == false) goto L58;
    L75:
        return r100;
    L58:
        if (y0.e(r113) == false) goto L75;
        ImageUrlStorage.f350955a.getClass();
        if (r100 != null) goto L62;
    L65:
        boolean r115 = true;
    L66:
        if (r115 == true) goto L74;
        if (r113 != null) goto L69;
    L70:
        r112 = true;
    L71:
        if (r112 == true) goto L74;
        BuildersKt.launch$default((CoroutineScope) ImageUrlStorage.f350958d.getValue(), null, null, new ImageUrlStorage$addDirectly$1(r100, r113, null), 3, null);
        goto L74
    L69:
        if (r113.length() != 0) goto L71;
    L74:
        return r113;
    L62:
        if (r100.length() == 0) goto L65;
        r115 = false;
        goto L66
    L52:
        if (r113.length() == 0) goto L55;
        r114 = false;
    L49:
        r113 = null;
        goto L50
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (String) r111.L$0;
        ResultKt.throwOnFailure(r103);
    L27:
        String r116 = (String) r103;
        if (r116 != null) goto L30;
    L33:
        boolean r117 = true;
    L34:
        if (r117 == true) goto L39;
        boolean r118 = b0.f350967a;
        if (b0.c(y0.j(r116)) == false) goto L38;
        ImageUrlStorage.f350955a.getClass();
        ImageUrlStorage.g(r100);
        goto L39
    L38:
        return r116;
    L39:
        JSONObject r119 = new JSONObject();
        r119.put("url", r100);
        r111.L$0 = r100;
        r111.label = 2;
        r106 = HttpExtKt.k(ServiceType.BASIC_TEC, y.class, "/alice/upload/refresh_file_url", r119, null, null, false, null, null, null, r111, 1008);
        if (r106 != r104) goto L42;
        return r104;
    L30:
        if (r116.length() == 0) goto L33;
        r117 = false;
        goto L34
    L16:
        ResultKt.throwOnFailure(r103);
        if (b0.c(y0.i(r110)) == true) goto L20;
        return r100;
    L20:
        if ((o.a() & 8) == 0) goto L22;
        boolean r120 = true;
    L23:
        if (r120 == true) goto L39;
        ImageUrlStorage r121 = ImageUrlStorage.f350955a;
        r111.L$0 = r100;
        r111.label = 1;
        r121.getClass();
        r103 = ImageUrlStorage.c(r100, r111);
        if (r103 != r104) goto L27;
        return r104;
    L22:
        r120 = false;
    L7:
        r101 = new ResourceUrlExpireHandleUtil$getRenewUrl$1(this, r210);
        goto L8
    }
}
