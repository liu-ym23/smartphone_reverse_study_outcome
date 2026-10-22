package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0014\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\u0018R$\u0010$\u001a\u0004\u0018\u00010\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\u0006\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010(\u001a\u0004\u0018\u00010\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\u0006\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R$\u0010-\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b,\u0010\u0006\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010+R$\u00101\u001a\u0004\u0018\u00010\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\u0006\u001a\u0004\b.\u0010 \"\u0004\b/\u0010\"¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/x2;", "Lvh7/c;", "", "getStartAnimationUrl", "()Ljava/lang/String;", "getStartAnimationUrl$annotations", "()V", "startAnimationUrl", "getWinAnimationUrl", "getWinAnimationUrl$annotations", "winAnimationUrl", "getLoseAnimationUrl", "getLoseAnimationUrl$annotations", "loseAnimationUrl", "getDrawAnimationUrl", "getDrawAnimationUrl$annotations", "drawAnimationUrl", "", "isShowEnterUserInfo", "()Z", "isShowEnterUserInfo$annotations", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getRoomBgTopImage", "()Lpy/k;", "getRoomBgTopImage$annotations", "roomBgTopImage", "getRoomBgBottomImage", "getRoomBgBottomImage$annotations", "roomBgBottomImage", "", "getEnterUserInfoPosition", "()Ljava/lang/Long;", "setEnterUserInfoPosition", "(Ljava/lang/Long;)V", "getEnterUserInfoPosition$annotations", "enterUserInfoPosition", "getEnterShowTimeMs", "setEnterShowTimeMs", "getEnterShowTimeMs$annotations", "enterShowTimeMs", "getSponsorAnimationUrl", "setSponsorAnimationUrl", "(Ljava/lang/String;)V", "getSponsorAnimationUrl$annotations", "sponsorAnimationUrl", "getSponsorAnimationShowTimeMs", "setSponsorAnimationShowTimeMs", "getSponsorAnimationShowTimeMs$annotations", "sponsorAnimationShowTimeMs", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface x2 extends vh7.c<x2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "draw_animation_url")
    String getDrawAnimationUrl();

    @FieldName(name = "enter_show_time_ms")
    Long getEnterShowTimeMs();

    @FieldName(name = "enter_user_info_position")
    Long getEnterUserInfoPosition();

    @FieldName(name = "lose_animation_url")
    String getLoseAnimationUrl();

    @FieldName(name = "room_bg_bottom_image")
    py.k getRoomBgBottomImage();

    @FieldName(name = "room_bg_top_image")
    py.k getRoomBgTopImage();

    @FieldName(name = "sponsor_animation_show_time_ms")
    Long getSponsorAnimationShowTimeMs();

    @FieldName(name = "sponsor_animation_url")
    String getSponsorAnimationUrl();

    @FieldName(name = "start_animation_url")
    String getStartAnimationUrl();

    @FieldName(name = "win_animation_url")
    String getWinAnimationUrl();

    @FieldName(name = "is_show_enter_user_info")
    boolean isShowEnterUserInfo();

    @FieldName(name = "enter_show_time_ms#setter")
    void setEnterShowTimeMs(Long r1);

    @FieldName(name = "enter_user_info_position#setter")
    void setEnterUserInfoPosition(Long r1);

    @FieldName(name = "sponsor_animation_show_time_ms#setter")
    void setSponsorAnimationShowTimeMs(Long r1);

    @FieldName(name = "sponsor_animation_url#setter")
    void setSponsorAnimationUrl(String r1);
}
