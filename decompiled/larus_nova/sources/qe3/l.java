package qe3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000b¨\u0006\""}, d2 = {"Lqe3/l;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "tagIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "header", "getHeader", "", "endTime", "Ljava/lang/Long;", "getEndTime", "()Ljava/lang/Long;", "text", "getText", "extra", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "uiType", "getUiType", "uiRawData", "getUiRawData", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("content")
    private final String content;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("header")
    private final String header;

    @SerializedName("icon")
    private final ECUrlModel tagIcon;

    @SerializedName("text")
    private final String text;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("ui_raw_data")
    private final String uiRawData;

    @SerializedName("ui_type")
    private final Integer uiType;

    public l() {
    }

    public final String a() {
        return this.extra;
    }

    public final ECUrlModel b() {
        return this.tagIcon;
    }

    public final Integer getType() {
        return this.type;
    }
}
