package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkMicInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/j5;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkMicInfo;", "", "getInteractId", "()J", "getInteractId$annotations", "()V", "interactId", "", "getRtcInfo", "()Ljava/lang/String;", "getRtcInfo$annotations", "rtcInfo", "getInteractIdStr", "getInteractIdStr$annotations", "interactIdStr", "getVendor", "getVendor$annotations", "vendor", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j5 extends vh7.e<ILinkMicInfo>, ILinkMicInfo {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "link_mic_id")
    long getInteractId();

    @FieldName(name = "linkmic_id_str")
    String getInteractIdStr();

    @FieldName(name = "rtc_ext_info")
    String getRtcInfo();

    @FieldName(name = "vendor")
    long getVendor();
}
