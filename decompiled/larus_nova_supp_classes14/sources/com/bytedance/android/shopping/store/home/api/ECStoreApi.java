package com.bytedance.android.shopping.store.home.api;

import com.bytedance.android.chunkstreamprediction.network.b;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.ec.store.repository.dto.StoreV2ProductListResponseDTO;
import com.bytedance.android.shopping.store.home.entity.ECFansClubResponse;
import com.bytedance.android.shopping.store.home.entity.ECShopBlockInfoDTO;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeActivityResponse;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeInfoResponse;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ShopCommitIMResponse;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopProductListBffResponseDTO;
import com.bytedance.android.shopping.store.hybridproduct.dto.ShopCouponResponseDTO;
import com.bytedance.android.shopping.store.hybridproduct.dto.SubscribeProductRes;
import com.bytedance.android.shopping.store.moments.dto.ECStoreMomentResponse;
import com.bytedance.android.shopping.store.moments.dto.ECStoreRefreshResponse;
import com.bytedance.android.shopping.store.repository.dto.StoreModuleDetailDTO;
import com.bytedance.android.shopping.store.repository.dto.StoreV3DeleteCommitDTO;
import com.bytedance.android.shopping.store.repository.dto.StoreV3FollowCommitDTO;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dj3.j;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0087\u0001Jf\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\u0002H'Jj\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00022\u0016\b\u0003\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0002H'Jh\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00022\u0014\b\u0001\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0002H'JË\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\t2\u0016\b\u0001\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0016\b\u0001\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\u00022\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u001e\u0010\u001fJÇ\u0001\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\t2\u0014\b\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0014\b\u0001\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\u00022\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b \u0010\u001fJÍ\u0001\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!0\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\t2\u0014\b\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0014\b\u0001\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\u00022\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\"\u0010\u001fJ\u0091\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\f2\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u0014\b\u0001\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010(\u001a\u00020\u00022\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b+\u0010,Je\u00101\u001a\b\u0012\u0004\u0012\u0002000\f2\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0016\u001a\u00020\tH'¢\u0006\u0004\b1\u00102JC\u00107\u001a\b\u0012\u0004\u0012\u0002060\f2\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u00104\u001a\u0004\u0018\u0001032\n\b\u0001\u00105\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b7\u00108J.\u0010:\u001a\b\u0012\u0004\u0012\u0002090\f2\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010'\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002H'J9\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\f2\n\b\u0001\u0010;\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010<\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010>\u001a\u0004\u0018\u00010=H'¢\u0006\u0004\b@\u0010AJd\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\f2\b\b\u0001\u0010B\u001a\u00020\u00022(\b\u0001\u0010E\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010Cj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001`D2\n\b\u0003\u0010F\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010G\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u0002H'JÅ\u0001\u0010S\u001a\b\u0012\u0004\u0012\u00020H0\f2\b\b\u0001\u0010B\u001a\u00020\u00022\n\b\u0001\u0010J\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010K\u001a\u0004\u0018\u0001032\n\b\u0001\u0010L\u001a\u0004\u0018\u0001032\n\b\u0001\u0010M\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010N\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u00104\u001a\u0004\u0018\u0001032\b\b\u0001\u00105\u001a\u0002032\n\b\u0001\u0010O\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010P\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010Q\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010R\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\bS\u0010TJ¢\u0001\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\f2\b\b\u0001\u0010U\u001a\u00020\t2\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010V\u001a\u00020\u00022\n\b\u0001\u0010W\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010X\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010Y\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010Z\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010[\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\\\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u0002H'J$\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\f2\u0014\b\u0001\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H'JC\u0010d\u001a\b\u0012\u0004\u0012\u00020c0\f2\b\b\u0001\u0010B\u001a\u00020\u00022\n\b\u0001\u0010a\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010b\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\bd\u0010eJ\u0018\u0010g\u001a\b\u0012\u0004\u0012\u00020f0\f2\b\b\u0001\u0010B\u001a\u00020\u0002H'JJ\u0010m\u001a\b\u0012\u0004\u0012\u00020l0\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010h\u001a\u0002032\b\b\u0001\u0010B\u001a\u00020\u00022\b\b\u0001\u0010i\u001a\u00020\t2\b\b\u0001\u0010j\u001a\u00020\u00022\b\b\u0001\u0010k\u001a\u00020\u0002H'J$\u0010o\u001a\b\u0012\u0004\u0012\u00020n0\f2\b\b\u0001\u0010B\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002H'J.\u0010p\u001a\b\u0012\u0004\u0012\u0002000\f2\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u0002H'J\"\u0010t\u001a\b\u0012\u0004\u0012\u00020s0\f2\b\b\u0001\u0010q\u001a\u00020\u00022\b\b\u0001\u0010r\u001a\u00020\u0002H'J^\u0010w\u001a\b\u0012\u0004\u0012\u00020v0\f2\b\b\u0001\u0010u\u001a\u00020\u00022\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00022\u0016\b\u0003\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0002H'J\u0018\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J<\u0010|\u001a\b\u0012\u0004\u0012\u00020{0\f2\b\b\u0001\u0010y\u001a\u00020\u00022\n\b\u0001\u0010z\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0002H'J<\u0010}\u001a\b\u0012\u0004\u0012\u00020{0\f2\b\b\u0001\u0010y\u001a\u00020\u00022\n\b\u0001\u0010z\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0002H'J\u0019\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020{0\f2\b\b\u0001\u0010\u007f\u001a\u00020~H'JH\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\f2\t\b\u0001\u0010\u0081\u0001\u001a\u00020\u00022\n\b\u0001\u0010\u0083\u0001\u001a\u00030\u0082\u00012\b\b\u0001\u0010'\u001a\u00020\u00022\t\b\u0001\u0010\u0084\u0001\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002H'¨\u0006\u0088\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/home/api/ECStoreApi;", "", "", "path", "secShopId", "", "homeConfigParam", "passThroughApi", "extra", "", "preloadRequest", "clientExperimentList", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreHomeInfoResponse;", "getHomeInfo", "bizParam", "extraParams", "clientParams", "localSlcTemplateVersions", "Lcom/bytedance/android/shopping/store/home/entity/ECShopHeadInfoBlock;", "getHomeBlock", "getHomeBlockByPost", "flagSupportNestedTab", "tabRenderConfig", "tabSourceConfig", "searchParams", "hitStaticUiChange", "shuffleProductIds", "localDecorationChannels", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreHomeTabResponseTabkit;", "getHomeTabBFF", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getHomeTabBFFByPost", "Lcom/bytedance/android/chunkstreamprediction/network/b;", "getHomeTabBFFByPostChunk", "activityConfig", "extraSchema", "customIds", "customIdType", "scene", "passThroughInfo", "storage", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreHomeActivityResponse;", "getHomeActivityByPost", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "activateTabType", "preStoreSourcePage", "preStoreGroupType", "Lcom/bytedance/android/shopping/store/hybrid/entity/ECStorePreloadInfoResponse;", "getPreloadInfo", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/Observable;", "", "cursor", "size", "Lcom/bytedance/android/shopping/store/moments/dto/ECStoreMomentResponse;", "getMoments", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/store/moments/dto/ECStoreRefreshResponse;", "refreshTab", "AuthorID", "Scene", "", "NeedFansClubSwitch", "Lcom/bytedance/android/shopping/store/home/entity/ECFansClubResponse;", "getFansClubInfo", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "secAuthorId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "productConfig", "pageParams", "querySource", "Lcom/bytedance/android/ec/store/repository/dto/StoreV2ProductListResponseDTO;", "getProductListByPost", "materialId", "goodsType", "sortType", "sort", "keyWord", "tmpId", "token", "entrances", "filterProductIds", "getProductListSearchExpByPost", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "request_tab_type", "filterParams", "paginationParams", "clientState", "unexposedIds", "clickProducts", "hybridParams", "sceneParams", "Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopProductListBffResponseDTO;", "getProductListBFFByPost", "params", "getProductListBFFByFieldMap", "giftIds", "giftType", "Lcom/bytedance/android/shopping/store/repository/dto/StoreV3FollowCommitDTO;", "doFollowCommit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/store/repository/dto/StoreV3DeleteCommitDTO;", "deleteFollowCommit", "authorID", "liveSceneId", "entranceInfo", "roomID", "Lcom/bytedance/android/ec/model/response/ECCurrentPromotion;", "getStorePopData", "Lcom/bytedance/android/shopping/store/repository/dto/StoreModuleDetailDTO;", "getStoreModuleDetail", "getShopPreloadFrameInfo", "cardType", "bizParams", "Lcom/bytedance/android/shopping/store/home/entity/ShopCommitIMResponse;", "getImCardInfo", "blockCode", "Lcom/bytedance/android/shopping/store/home/entity/ECShopBlockInfoDTO;", "getBlockInfo", "getEntranceLocations", "couponItemLists", "couponBizTypeList", "Lcom/bytedance/android/shopping/store/hybridproduct/dto/ShopCouponResponseDTO;", "applyCoupon", "applyCouponForMiddleFloat", "Lokhttp3/RequestBody;", "applyResourceParamList", "applyCouponForMiddleFloatFromMarket", "shopId", "Ldj3/j;", "productInfo", "appointmentId", "Lcom/bytedance/android/shopping/store/hybridproduct/dto/SubscribeProductRes;", "subscribeProduct", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ECStoreApi {
    public static final a a = null;

    public static final class a {
        public static final ECStoreApi a = null;
        public static final ECStoreApi b = null;
        public static final ECStoreApi c = null;
        public static final /* synthetic */ a d = null;

        public a() {
        }

        static {
            d = new a();
            n r0 = n.a;
            a = (ECStoreApi) r0.create(gn.a.a(), ECStoreApi.class);
            Gson r1 = new GsonBuilder().registerTypeAdapterFactory(new TabToStoreTabAdapterFactory()).setLenient().create();
            b = (ECStoreApi) r0.create(gn.a.b(), ECStoreApi.class);
            c = (ECStoreApi) r0.a(gn.a.b(), ECStoreApi.class, null, r1);
        }
    }

    static {
        a = a.d;
    }

    @POST("/shop/coupon/apply/")
    Observable<ShopCouponResponseDTO> applyCoupon(@Query("coupon_item_list") String r1, @Query("coupon_biz_type_list") String r2, @Query("pass_through_api") String r3, @Query("scene") String r4);

    @FormUrlEncoded
    @POST("/shop/coupon/apply/")
    Observable<ShopCouponResponseDTO> applyCouponForMiddleFloat(@Field("coupon_item_list") String r1, @Field("coupon_biz_type_list") String r2, @Field("pass_through_api") String r3, @Field("scene") String r4);

    @POST("https://growth5-normal-lf.ecombdapi.com/growth/marketing_express/mapply_resource_data")
    Observable<ShopCouponResponseDTO> applyCouponForMiddleFloatFromMarket(@Body RequestBody r1);

    @FormUrlEncoded
    @POST("/aweme/v2/shop/follow/delete")
    Observable<StoreV3DeleteCommitDTO> deleteFollowCommit(@Field("sec_author_id") String r1);

    @FormUrlEncoded
    @POST("/aweme/v2/shop/follow/commit")
    Observable<StoreV3FollowCommitDTO> doFollowCommit(@Field("sec_author_id") String r1, @Field("gift_ids") String r2, @Field("gift_type") Integer r3, @Field("pass_through_api") String r4);

    @GET("/sws/block/")
    Observable<ECShopBlockInfoDTO> getBlockInfo(@Query("block_code") String r1, @Query("biz_param") String r2, @Query("pass_through_api") String r3, @Query("client_experiment_list") String r4, @QueryMap Map<String, String> r5, @Query("client_params") String r6);

    @GET("{path}")
    Observable<String> getEntranceLocations(@Path(encode = false, value = "path") String r1);

    @GET("/ecom/fansclub/entrance/")
    Observable<ECFansClubResponse> getFansClubInfo(@Query("author_id") String r1, @Query("scene") Integer r2, @Query("need_switch") Boolean r3);

    @FormUrlEncoded
    @POST("/shop/home/activity/")
    Observable<ECStoreHomeActivityResponse> getHomeActivityByPost(@Field("sec_shop_id") String r1, @FieldMap Map<String, String> r2, @Field("pass_through_api") String r3, @Field("extra_schema") String r4, @Field("custom_ids") String r5, @Field("custom_id_type") Integer r6, @Field("scene") String r7, @Field("client_experiment_list") String r8, @Field("pass_through_marketing_info") String r9, @Field("storage") String r10);

    @GET("{path}")
    Observable<ECShopHeadInfoBlock> getHomeBlock(@Path(encode = false, value = "path") String r1, @Query("biz_param") String r2, @Query("pass_through_api") String r3, @Query("client_experiment_list") String r4, @QueryMap Map<String, String> r5, @Query("client_params") String r6, @Query("client_slice_templates") String r7);

    @FormUrlEncoded
    @POST("{path}")
    Observable<ECShopHeadInfoBlock> getHomeBlockByPost(@Path(encode = false, value = "path") String r1, @Field("biz_param") String r2, @Field("pass_through_api") String r3, @Field("client_experiment_list") String r4, @FieldMap Map<String, String> r5, @Field("client_params") String r6, @Field("client_slice_templates") String r7);

    @GET("{path}")
    Observable<ECStoreHomeInfoResponse> getHomeInfo(@Path(encode = false, value = "path") String r1, @Query("sec_shop_id") String r2, @QueryMap Map<String, String> r3, @Query("pass_through_api") String r4, @Query("ext_param") String r5, @Query("preload_request") int r6, @Query("client_experiment_list") String r7);

    @GET("{path}")
    Observable<ECStoreHomeTabResponseTabkit> getHomeTabBFF(@Path(encode = false, value = "path") String r1, @Query("sec_shop_id") String r2, @Query("hit_bottom_tab_test") int r3, @QueryMap Map<String, String> r4, @QueryMap Map<String, String> r5, @Query("pass_through_api") String r6, @Query("search_params") String r7, @Query("hit_static_ui_change") Integer r8, @Query("shuffle_product_ids") String r9, @Query("preload_request") int r10, @Query("client_experiment_list") String r11, @Query("local_decoration_channels") String r12, @Query("client_params") String r13, @Query("client_slice_templates") String r14);

    @FormUrlEncoded
    @POST("{path}")
    Observable<ECStoreHomeTabResponseTabkit> getHomeTabBFFByPost(@Path(encode = false, value = "path") String r1, @Field("sec_shop_id") String r2, @Field("hit_bottom_tab_test") int r3, @FieldMap Map<String, String> r4, @FieldMap Map<String, String> r5, @Field("pass_through_api") String r6, @Field("search_params") String r7, @Field("hit_static_ui_change") Integer r8, @Field("shuffle_product_ids") String r9, @Field("preload_request") int r10, @Field("client_experiment_list") String r11, @Field("local_decoration_channels") String r12, @Field("client_params") String r13, @Field("client_slice_templates") String r14);

    @FormUrlEncoded
    @POST("{path}")
    @Streaming
    Observable<b<ECStoreHomeTabResponseTabkit>> getHomeTabBFFByPostChunk(@Path(encode = false, value = "path") String r1, @Field("sec_shop_id") String r2, @Field("hit_bottom_tab_test") int r3, @FieldMap Map<String, String> r4, @FieldMap Map<String, String> r5, @Field("pass_through_api") String r6, @Field("search_params") String r7, @Field("hit_static_ui_change") Integer r8, @Field("shuffle_product_ids") String r9, @Field("preload_request") int r10, @Field("client_experiment_list") String r11, @Field("local_decoration_channels") String r12, @Field("client_params") String r13, @Field("client_slice_templates") String r14);

    @GET("/ecom/im/cardmsg")
    Observable<ShopCommitIMResponse> getImCardInfo(@Query("card_type") String r1, @Query("biz_params") String r2);

    @GET("/shop/moments/")
    Observable<ECStoreMomentResponse> getMoments(@Query("sec_shop_id") String r1, @Query("cursor") Long r2, @Query("size") Integer r3, @Query("search_params") String r4);

    @GET("/shop/preload/info/")
    Observable<ECStorePreloadInfoResponse> getPreloadInfo(@Query("sec_shop_id") String r1, @Query("activate_tab_type") Integer r2, @Query("pass_through_api") String r3, @Query("entrance_location") String r4, @Query("pre_store_source_page") String r5, @Query("pre_store_group_type") String r6, @Query("hit_bottom_tab_test") int r7);

    @FormUrlEncoded
    @POST("/aweme/v1/store/product/bff/")
    Observable<ECShopProductListBffResponseDTO> getProductListBFFByFieldMap(@FieldMap Map<String, String> r1);

    @FormUrlEncoded
    @POST("/aweme/v1/store/product/bff/")
    Observable<ECShopProductListBffResponseDTO> getProductListBFFByPost(@Field("request_tab_type") int r1, @Field("sec_shop_id") String r2, @Field("filter_params") String r3, @Field("pagination_params") String r4, @Field("passthrough_api") String r5, @Field("client_state") String r6, @Field("unexposed_ids") String r7, @Field("click_products") String r8, @Field("hybrid_params") String r9, @Field("scene") String r10, @Field("scene_biz_params") String r11, @Field("client_slice_templates") String r12, @Field("client_experiment_list") String r13);

    @FormUrlEncoded
    @POST("/aweme/v1/store/product/list/")
    Observable<StoreV2ProductListResponseDTO> getProductListByPost(@Field("sec_shop_id") String r1, @FieldMap HashMap<String, Object> r2, @Field("page_params") String r3, @Field("query_source") String r4, @Field("client_experiment_list") String r5);

    @FormUrlEncoded
    @GET("/aweme/v1/store/product/list/")
    Observable<StoreV2ProductListResponseDTO> getProductListSearchExpByPost(@Field("sec_shop_id") String r1, @Field("material_id") String r2, @Field("goods_type") Long r3, @Field("sort_type") Long r4, @Field("sort") Integer r5, @Field("key_word") String r6, @Field("cursor") Long r7, @Field("size") long r8, @Field("tmp_id") String r10, @Field("token") String r11, @Field("entrances") String r12, @Field("pass_through_api") String r13, @Field("custom_ids") String r14, @Field("custom_id_type") Integer r15, @Field("filter_product_ids") String r16);

    @GET("/shop/preload/frame/info/")
    Observable<ECStorePreloadInfoResponse> getShopPreloadFrameInfo(@Query("sec_shop_id") String r1, @Query("pass_through_api") String r2, @Query("client_experiment_list") String r3);

    @GET("/aweme/v1/store/module/detail/")
    Observable<StoreModuleDetailDTO> getStoreModuleDetail(@Query("sec_shop_id") String r1, @Query("pass_through_api") String r2);

    @GET("{path}")
    Observable<ECCurrentPromotion> getStorePopData(@Path(encode = false, value = "path") String r1, @Query("author_id") long r2, @Query("sec_author_id") String r4, @Query("live_scene_id") int r5, @Query("entrance_info") String r6, @Query("room_id") String r7);

    @POST("/shop/refresh/")
    Observable<ECStoreRefreshResponse> refreshTab(@Query("sec_shop_id") String r1, @Query("scene") String r2, @Query("pass_through_api") String r3);

    @POST("/aweme/v2/shop/appointment/create/")
    Observable<SubscribeProductRes> subscribeProduct(@Query("shop_id") String r1, @Body j r2, @Query("source") String r3, @Query("appointment_id") String r4, @Query("pass_through_api") String r5);
}
