package g12;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.m2;
import com.bytedance.android.livesdk.gift.model.y1;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lg12/b;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/gift/model/m2;", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift$annotations", "()V", PbRequest.SwitchType.GIFT, "", "getClientGiftSource", "()J", "getClientGiftSource$annotations", "clientGiftSource", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends e<m2>, m2 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.gift.model.m2, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "client_gift_source")
    long getClientGiftSource();

    /* synthetic */ long getComboCount();

    /* synthetic */ long getConsumeDiamonds();

    /* synthetic */ String getDescribe();

    /* synthetic */ a5 getDisplayText();

    /* synthetic */ long getFanTicketCount();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = PbRequest.SwitchType.GIFT)
    h1 getGift();

    /* synthetic */ int getGiftCnt();

    /* synthetic */ long getGiftId();

    /* synthetic */ List<y1> getGifts();

    /* synthetic */ long getGroupCount();

    /* synthetic */ long getGroupId();

    /* synthetic */ long getLeftDiamonds();

    /* synthetic */ String getLogId();

    /* synthetic */ String getMsgId();

    /* synthetic */ long getPropId();

    /* synthetic */ long getPropType();

    /* synthetic */ List<l2> getProps();

    /* synthetic */ long getRepeatCount();

    /* synthetic */ String getTraceId();

    /* synthetic */ long isAwemeFreeGift();

    /* synthetic */ void setConsumeDiamonds(long r100);

    /* synthetic */ void setDescribe(String r100);

    /* synthetic */ void setDisplayText(a5 r100);

    /* synthetic */ void setGiftCnt(int r100);

    /* synthetic */ void setGiftId(long r100);

    /* synthetic */ void setGroupId(long r100);

    /* synthetic */ void setLogId(String r100);

    /* synthetic */ void setMsgId(String r100);

    /* synthetic */ void setPropId(long r100);
}
