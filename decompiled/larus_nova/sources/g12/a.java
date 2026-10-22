package g12;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdk.gift.model.b2;
import com.bytedance.android.livesdk.gift.model.i;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.e;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lg12/a;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/gift/model/l1;", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends e<l1>, l1 {
    @Override // com.bytedance.android.livesdk.gift.model.l1, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.gift.model.l1, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "bg_img")
    /* synthetic */ k getBgImg();

    @FieldName(name = "bg_img_v2")
    /* synthetic */ k getBgImgV2();

    @FieldName(name = "buff_gift_describe_img")
    /* synthetic */ k getBuffDescribeImg();

    @FieldName(name = "buff_diamond_count")
    /* synthetic */ long getBuffDiamondCount();

    @FieldName(name = "buff_gift_id")
    /* synthetic */ long getBuffGiftId();

    @FieldName(name = "buff_level")
    /* synthetic */ int getBuffLevel();

    @FieldName(name = "default_chose_action")
    /* synthetic */ long getDefaultChose();

    @FieldName(name = "default_gift_text")
    /* synthetic */ Map<Integer, b2> getDefaultGiftTextMap();

    @FieldName(name = "gift_icon_asset_img")
    /* synthetic */ k getDynamicGiftIcon();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "buff_lock_info")
    /* synthetic */ i getLockInfo();

    @FieldName(name = "lock_toast")
    /* synthetic */ String getLockToast();

    @FieldName(name = "tab_chose_action")
    /* synthetic */ Map<Integer, Long> getPageTypeToDefaultChoseActionMap();

    @FieldName(name = ILoadStallMonitor.START_TIME)
    /* synthetic */ long getStartTime();

    @FieldName(name = "sweep_light_img")
    /* synthetic */ k getSweepLightImg();

    @FieldName(name = "text")
    /* synthetic */ String getText();

    @FieldName(name = "text_color")
    /* synthetic */ String getTextColor();

    @FieldName(name = "bg_img#setter")
    /* synthetic */ void setBgImg(k r100);

    @FieldName(name = "bg_img_v2#setter")
    /* synthetic */ void setBgImgV2(k r100);

    @FieldName(name = "buff_gift_describe_img#setter")
    /* synthetic */ void setBuffDescribeImg(k r100);

    @FieldName(name = "buff_diamond_count#setter")
    /* synthetic */ void setBuffDiamondCount(long r100);

    @FieldName(name = "buff_gift_id#setter")
    /* synthetic */ void setBuffGiftId(long r100);

    @FieldName(name = "buff_level#setter")
    /* synthetic */ void setBuffLevel(int r100);

    @FieldName(name = "default_chose_action#setter")
    /* synthetic */ void setDefaultChose(long r100);

    @FieldName(name = "buff_lock_info#setter")
    /* synthetic */ void setLockInfo(i r100);

    @FieldName(name = "lock_toast#setter")
    /* synthetic */ void setLockToast(String r100);

    @FieldName(name = "start_time#setter")
    /* synthetic */ void setStartTime(long r100);

    @FieldName(name = "sweep_light_img#setter")
    /* synthetic */ void setSweepLightImg(k r100);

    @FieldName(name = "text#setter")
    /* synthetic */ void setText(String r100);

    @FieldName(name = "text_color#setter")
    /* synthetic */ void setTextColor(String r100);
}
