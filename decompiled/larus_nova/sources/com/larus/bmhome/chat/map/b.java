package com.larus.bmhome.chat.map;

import android.text.TextUtils;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.utils.cache.DiskCache;
import com.larus.utils.o0;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Deprecated(message = "It is recommended to use the API in the image-loader module")
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f306879a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DiskCache f306880b = null;

    public b() {
    }

    static {
        f306879a = new b();
        f306880b = new DiskCache("custom-img-cache");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r110, String r111, Continuation r112) {
        if ((r112 instanceof ImageCacheLoader$requestNewUrl$1) == false) goto L7;
        ImageCacheLoader$requestNewUrl$1 r100 = (ImageCacheLoader$requestNewUrl$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ImageCacheLoader$requestNewUrl$1 r113 = r100;
        Object r102 = r113.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r113.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r105 = (String) r113.L$0;
        ResultKt.throwOnFailure(r102);
        String r114 = r105;
    L20:
        FileUrlsList r106 = (FileUrlsList) ((com.larus.network.http.a) r102).f360135b;
        if (r106 == null) goto L25;
        List<FileUrlsBean> r107 = r106.getFileUrls();
        if (r107 == null) goto L25;
        FileUrlsBean r108 = (FileUrlsBean) CollectionsKt.firstOrNull(r107);
    L26:
        if (r108 != null) goto L28;
    L33:
        return r114;
    L28:
        if (TextUtils.isEmpty(r108.getMainUrl()) == true) goto L33;
        String r109 = r108.getMainUrl();
        if (r109 != null) goto L34;
        return "";
    L34:
        return r109;
    L25:
        r108 = null;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        Map r115 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uris", new JSONArray().put(r110)), TuplesKt.to("type", "image")});
        if (o0.d(null) == false) goto L17;
        r115.put(SubInfo.KEY_FORMAT, null);
    L17:
        JSONObject r116 = new JSONObject(r115);
        r114 = r111;
        r113.L$0 = r114;
        r113.label = 1;
        r102 = HttpExtKt.k(ServiceType.UGC, FileUrlsList.class, "/alice/message/get_file_url", r116, null, null, false, null, null, null, r113, 1008);
        if (r102 != r103) goto L20;
        return r103;
    L7:
        r100 = new ImageCacheLoader$requestNewUrl$1(this, r112);
        goto L8
    }
}
