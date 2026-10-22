package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004R.\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010!\u001a\u00020 8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010&\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0006\u001a\u0004\b$\u0010\u0004R\"\u0010,\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b)\u0010*R6\u0010/\u001a\u001e\u0012\b\u0012\u00060'j\u0002`(\u0018\u00010\u0016j\u000e\u0012\b\u0012\u00060'j\u0002`(\u0018\u0001`\u00188&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0006\u001a\u0004\b-\u0010\u001a¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/n0;", "Lvh7/c;", "", "getActivityName", "()Ljava/lang/String;", "getActivityName$annotations", "()V", "activityName", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getDisplayTabText", "()Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayTabText$annotations", "displayTabText", "", "getUserId", "()J", "getUserId$annotations", "userId", "getUserIdStr", "getUserIdStr$annotations", "userIdStr", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLabelList", "()Ljava/util/List;", "getLabelList$annotations", "labelList", "getSubTabText", "getSubTabText$annotations", "subTabText", "", "isValid", "()Z", "isValid$annotations", "getReasonMessage", "getReasonMessage$annotations", "reasonMessage", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getButtonImage", "()Lpy/k;", "getButtonImage$annotations", "buttonImage", "getBackgroundList", "getBackgroundList$annotations", "backgroundList", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n0 extends vh7.c<n0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "activity_name")
    String getActivityName();

    @FieldName(name = "back_ground_images")
    List<py.k> getBackgroundList();

    @FieldName(name = "button_image")
    py.k getButtonImage();

    @FieldName(name = "display_tab_text")
    com.bytedance.android.live.base.model.message.a5 getDisplayTabText();

    @FieldName(name = "labels")
    List<IBattleRivalTag> getLabelList();

    @FieldName(name = "message")
    String getReasonMessage();

    @FieldName(name = "sub_tab_text")
    String getSubTabText();

    @FieldName(name = "user_id")
    long getUserId();

    @FieldName(name = "user_id_str")
    String getUserIdStr();

    @FieldName(name = LocationMonitorConst.IS_VALID)
    boolean isValid();
}
