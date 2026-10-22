package xi2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lxi2/f0;", "", "", SubInfo.KEY_FORMAT, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setFormat", "(Ljava/lang/String;)V", "color", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setColor", "", "fontSize", "I", "b", "()I", "setFontSize", "(I)V", "linkUrl", "d", "setLinkUrl", "schemaParamsType", "e", "setSchemaParamsType", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f0 {

    @SerializedName("color")
    private String color;

    @SerializedName("font_size")
    private int fontSize;

    @SerializedName(SubInfo.KEY_FORMAT)
    private String format;

    @SerializedName("link_url")
    private String linkUrl;

    @SerializedName("schema_params_type")
    private String schemaParamsType;

    public f0() {
    }

    public final String a() {
        return this.color;
    }

    public final int b() {
        return this.fontSize;
    }

    public final String c() {
        return this.format;
    }

    public final String d() {
        return this.linkUrl;
    }

    public final String e() {
        return this.schemaParamsType;
    }
}
