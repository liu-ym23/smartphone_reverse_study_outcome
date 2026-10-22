package com.obric.sva.sdk.network;

import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a@\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007\u001aX\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007\u001aX\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"TAG", "", "streamByGet", "Lcom/bytedance/retrofit2/SsResponse;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "url", "addCommonParams", "", "maxLength", "", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "streamByPostJson", ContainerPosition.BODY, "", "", "streamByPostForm", "convertParams", "Lcom/obric/sva/sdk/network/Params;", "libs_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class NetworkProxyKt {
    private static final String TAG = "NetworkProxy";

    public static final Params convertParams(String r100) throws UrlConvertException {
        LinkedHashMap r101 = new LinkedHashMap();     // Catch: Exception -> L8
        Pair<String, String> r102 = UrlUtils.parseUrl(r100, r101);     // Catch: Exception -> L8
        if (r102 == null) goto L7;
        return new Params((String) r102.first, (String) r102.second, r101);
    L7:
        throw new UrlConvertException(r100);     // Catch: Exception -> L8
    L9:
        throw new UrlConvertException(r100);
    }

    public static final SsResponse<TypedInput> streamByGet(String r100, boolean r101, int r102, List<Header> r110) throws Exception {
        Params r103 = convertParams(r100);     // Catch: Exception -> L8
        Call<TypedInput> r104 = ((INetworkProxyApi) RetrofitUtils.createSsService(r103.getBaseUrl(), INetworkProxyApi.class)).get(r101, r102, r103.getRelativePath(), r103.getQueryMap(), r110);     // Catch: Exception -> L8
        if (r104 == null) goto L6;
        return r104.execute();
    L6:
        return null;
    L8:
        e = move-exception;
        LogUtils.e(TAG, "streamByGet error:" + e.getMessage(), new Object[0]);
        throw e;
    }

    public static final SsResponse<TypedInput> streamByPostForm(String r100, boolean r101, int r110, Map<String, ? extends Object> r111, List<Header> r112) throws Exception {
        Params r102 = convertParams(r100);     // Catch: Exception -> L8
        Call<TypedInput> r103 = ((INetworkProxyApi) RetrofitUtils.createSsService(r102.getBaseUrl(), INetworkProxyApi.class)).postByForm(r101, r110, r102.getRelativePath(), r102.getQueryMap(), r111, r112);     // Catch: Exception -> L8
        if (r103 == null) goto L6;
        return r103.execute();
    L6:
        return null;
    L8:
        e = move-exception;
        LogUtils.e(TAG, "streamByPostForm error:" + e.getMessage(), new Object[0]);
        throw e;
    }

    public static final SsResponse<TypedInput> streamByPostJson(String r100, boolean r101, int r110, Map<String, ? extends Object> r111, List<Header> r112) throws Exception {
        Params r102 = convertParams(r100);     // Catch: Exception -> L8
        Call<TypedInput> r103 = ((INetworkProxyApi) RetrofitUtils.createSsService(r102.getBaseUrl(), INetworkProxyApi.class)).postByJson(r101, r110, r102.getRelativePath(), r102.getQueryMap(), r111, r112);     // Catch: Exception -> L8
        if (r103 == null) goto L6;
        return r103.execute();
    L6:
        return null;
    L8:
        e = move-exception;
        LogUtils.e(TAG, "streamByPostJson error:" + e.getMessage(), new Object[0]);
        throw e;
    }

    public static /* synthetic */ SsResponse streamByGet$default(String r100, boolean r101, int r102, List r103, int r104, Object r105) throws Exception {
        if ((r104 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = -1;
    L9:
        if ((r104 & 8) == 0) goto L12;
        r103 = null;
    L12:
        return streamByGet(r100, r101, r102, r103);
    }

    public static /* synthetic */ SsResponse streamByPostForm$default(String r100, boolean r101, int r102, Map r103, List r104, int r105, Object r106) throws Exception {
        if ((r105 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = -1;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L15;
        r104 = CollectionsKt.emptyList();
    L15:
        return streamByPostForm(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ SsResponse streamByPostJson$default(String r100, boolean r101, int r102, Map r103, List r104, int r105, Object r106) throws Exception {
        if ((r105 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = -1;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L15;
        r104 = null;
    L15:
        return streamByPostJson(r100, r101, r102, r103, r104);
    }
}
