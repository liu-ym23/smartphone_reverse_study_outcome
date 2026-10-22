package com.ss.android.download.api.common;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001Jb\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001a\b\u0003\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t2\u0012\b\u0003\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\b\b\u0003\u0010\r\u001a\u00020\u000eH'¨\u0006\u000f"}, d2 = {"Lcom/ss/android/download/api/common/DefaultNetApi;", "", "doPostBody", "Lcom/bytedance/retrofit2/Call;", "", "url", ContainerPosition.BODY, "Lcom/bytedance/retrofit2/mime/TypedOutput;", "queryMap", "", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "addCommonParam", "", "download-api_release"}, k = 1, mv = {1, 1, 16})
public interface DefaultNetApi {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Call doPostBody$default(DefaultNetApi r100, String r101, TypedOutput r102, Map r110, List r111, boolean r112, int r113, Object r114) {
            if (r114 != null) goto L18;
            if ((r113 & 4) == 0) goto L6;
            Map r103 = null;
        L8:
            if ((r113 & 8) == 0) goto L10;
            List r104 = null;
        L12:
            if ((r113 & 16) == 0) goto L14;
            boolean r105 = true;
        L16:
            return r100.doPostBody(r101, r102, r103, r104, r105);
        L14:
            r105 = r112;
            goto L16
        L10:
            r104 = r111;
            goto L12
        L6:
            r103 = r110;
            goto L8
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doPostBody");
        }
    }

    @POST
    Call<String> doPostBody(@Url String r100, @Body TypedOutput r101, @QueryMap(encode = true) Map<String, String> r102, @HeaderList List<Header> r103, @AddCommonParam boolean r104);
}
