package com.ivy.ivykit.plugin.impl.bullet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'¨\u0006\u000b"}, d2 = {"Lcom/ivy/ivykit/plugin/impl/bullet/IBulletNetworkApi;", "", "doPost", "Lcom/bytedance/retrofit2/Call;", "", "url", "fieldMap", "", "header", "", "Lcom/bytedance/retrofit2/client/Header;", "ivy_plugin_impl_bullet_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IBulletNetworkApi {
    @FormUrlEncoded
    @POST
    Call<String> doPost(@Url String r100, @FieldMap Map<String, String> r101, @HeaderList List<Header> r102);
}
