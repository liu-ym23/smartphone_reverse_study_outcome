package e7;

import com.amap.api.col.s.ce;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR$\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\b¨\u0006/"}, d2 = {"Le7/t0;", "", "", "schema", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "", "width", "Ljava/lang/Integer;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/Integer;", "setWidth", "(Ljava/lang/Integer;)V", "height", "b", "setHeight", "timeout", "h", "setTimeout", "Lcom/google/gson/JsonObject;", BaseHybridComponent.INITIAL_PROPS_QUERY_KEY, "Lcom/google/gson/JsonObject;", "c", "()Lcom/google/gson/JsonObject;", "setInitialProps", "(Lcom/google/gson/JsonObject;)V", "", "saveToAlbum", "Ljava/lang/Boolean;", "f", "()Ljava/lang/Boolean;", "setSaveToAlbum", "(Ljava/lang/Boolean;)V", "filename", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setFilename", GearStrategyConsts.EV_QUALITY, "e", "setQuality", "measureSpec", "d", "setMeasureSpec", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class t0 {

    @SerializedName("filename")
    private String filename;

    @SerializedName("height")
    private Integer height;

    @SerializedName(BaseHybridComponent.INITIAL_PROPS_QUERY_KEY)
    private JsonObject initialProps;

    @SerializedName("measureSpec")
    private String measureSpec;

    @SerializedName(GearStrategyConsts.EV_QUALITY)
    private Integer quality;

    @SerializedName("saveToAlbum")
    private Boolean saveToAlbum;

    @SerializedName("schema")
    private String schema;

    @SerializedName("timeout")
    private Integer timeout;

    @SerializedName("width")
    private Integer width;

    public t0() {
    }

    public final String a() {
        return this.filename;
    }

    public final Integer b() {
        return this.height;
    }

    public final JsonObject c() {
        return this.initialProps;
    }

    public final String d() {
        return this.measureSpec;
    }

    public final Integer e() {
        return this.quality;
    }

    public final Boolean f() {
        return this.saveToAlbum;
    }

    public final String g() {
        return this.schema;
    }

    public final Integer h() {
        return this.timeout;
    }

    public final Integer i() {
        return this.width;
    }
}
