package com.bytedance.anniex.bd.utils;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001Jh\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00042\u0016\b\u0001\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\u0010\b\u0001\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0001H'Jt\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00042\u0016\b\u0001\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\u0010\b\u0001\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u0013"}, d2 = {"Lcom/bytedance/anniex/bd/utils/ISLNetworkAPI;", "", "doGetForString", "Lcom/bytedance/retrofit2/Call;", "", "addCommonParam", "", "maxLength", "", "relativePath", "queryMap", "", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "extraInfo", "doPostForString", "body", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "bd-anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface ISLNetworkAPI {
    @GET
    Call<String> doGetForString(@AddCommonParam boolean r1, @MaxLength int r2, @Url String r3, @QueryMap(encode = true) Map<String, String> r4, @HeaderList List<Header> r5, @ExtraInfo Object r6);

    @POST
    Call<String> doPostForString(@AddCommonParam boolean r1, @MaxLength int r2, @Url String r3, @QueryMap Map<String, String> r4, @HeaderList List<Header> r5, @Body TypedOutput r6, @ExtraInfo Object r7);
}
