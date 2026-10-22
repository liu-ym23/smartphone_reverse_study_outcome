package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR$\u0010\"\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\b¨\u0006-"}, d2 = {"Lw20/jd;", "", "", "eventType", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setEventType", "(Ljava/lang/String;)V", "businessType", "b", "setBusinessType", "productId", "h", "setProductId", "roomId", RXScreenCaptureService.KEY_INDEX, "setRoomId", "anchorId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAnchorId", "Lcom/google/gson/JsonObject;", "index", "Lcom/google/gson/JsonObject;", "f", "()Lcom/google/gson/JsonObject;", "setIndex", "(Lcom/google/gson/JsonObject;)V", "metric", com.amap.api.col.s.ce.f26391f, "setMetric", "category", "c", "setCategory", "extra", "e", "setExtra", "step", com.amap.api.col.s.ce.f26395j, "setStep", "traceId", com.amap.api.col.s.ce.f26396k, "setTraceId", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class jd {

    @SerializedName("anchorId")
    private String anchorId;

    @SerializedName("businessType")
    private String businessType;

    @SerializedName("category")
    private JsonObject category;

    @SerializedName("eventType")
    private String eventType;

    @SerializedName("extra")
    private JsonObject extra;

    @SerializedName("index")
    private JsonObject index;

    @SerializedName("metric")
    private JsonObject metric;

    @SerializedName("productId")
    private String productId;

    @SerializedName("roomId")
    private String roomId;

    @SerializedName("step")
    private String step;

    @SerializedName("traceId")
    private String traceId;

    public jd() {
    }

    public final String a() {
        return this.anchorId;
    }

    public final String b() {
        return this.businessType;
    }

    public final JsonObject c() {
        return this.category;
    }

    public final String d() {
        return this.eventType;
    }

    public final JsonObject e() {
        return this.extra;
    }

    public final JsonObject f() {
        return this.index;
    }

    public final JsonObject g() {
        return this.metric;
    }

    public final String h() {
        return this.productId;
    }

    public final String i() {
        return this.roomId;
    }

    public final String j() {
        return this.step;
    }

    public final String k() {
        return this.traceId;
    }
}
