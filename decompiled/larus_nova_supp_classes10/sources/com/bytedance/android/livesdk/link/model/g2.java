package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/g2;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/link/model/x0;", "getBattleConsecutiveRecordInfo", "()Lcom/bytedance/android/livesdk/link/model/x0;", "getBattleConsecutiveRecordInfo$annotations", "()V", "battleConsecutiveRecordInfo", "", "Lcom/bytedance/android/livesdk/link/model/f2;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getBattleRecordList", "()Ljava/util/List;", "getBattleRecordList$annotations", "battleRecordList", "", "getNoRecordTip", "()Ljava/lang/String;", "getNoRecordTip$annotations", "noRecordTip", "", "getOffset", "()Ljava/lang/Long;", "getOffset$annotations", LayoutSizeLargeModeConfig.TYPE_SIZE_DP, "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g2 extends vh7.c<g2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "consecutive_record")
    x0 getBattleConsecutiveRecordInfo();

    @FieldName(name = "records")
    List<f2> getBattleRecordList();

    @FieldName(name = "no_record_tip")
    String getNoRecordTip();

    @FieldName(name = LayoutSizeLargeModeConfig.TYPE_SIZE_DP)
    Long getOffset();
}
