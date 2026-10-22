package kc6;

import com.bytedance.kmp.livesdk.gift.platform.aio.model.GiftExtraObserveResponseSerializableObjectImpl;
import com.bytedance.revenue.platform.api.core.JsonOrBytesJvm;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(GiftExtraObserveResponseSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00000\u0001j\b\u0012\u0004\u0012\u00020\u0000`\u0002¨\u0006\u0003"}, d2 = {"Lkc6/q;", "Lvh7/j;", "Lcom/bytedance/live/kmp/core/AioModel;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q extends vh7.j<q> {

    @JsonAdapter(GiftExtraObserveResponseSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "extra#setter")
    void M1(com.bytedance.android.livesdk.gift.model.g0 r100);

    @FieldName(name = "extra")
    com.bytedance.android.livesdk.gift.model.g0 getExtra();

    @FieldName(name = "extra_object#setter")
    void m(JsonOrBytesJvm r100);
}
