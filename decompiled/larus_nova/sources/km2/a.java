package km2;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdk.gift.model.a2;
import com.bytedance.android.livesdk.message.model.r7;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lkm2/a;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/message/model/r7;", "", "", "getUpdateGiftIds", "()Ljava/util/List;", "getUpdateGiftIds$annotations", "()V", "updateGiftIds", "getUpdateAssetIds", "getUpdateAssetIds$annotations", "updateAssetIds", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface a extends e<r7>, r7 {

    /* JADX INFO: renamed from: km2.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C6572a {
    }

    @Override // com.bytedance.android.livesdk.message.model.r7, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.message.model.r7, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    /* synthetic */ m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    /* synthetic */ a2 getGiftSortStrategy();

    @FieldName(name = "update_asset_ids")
    List<Long> getUpdateAssetIds();

    @FieldName(name = "update_gift_ids")
    List<Long> getUpdateGiftIds();

    /* synthetic */ int getUpdateType();

    /* synthetic */ void setCommonData(m0 r100);
}
