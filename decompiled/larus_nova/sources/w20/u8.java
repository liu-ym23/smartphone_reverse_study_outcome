package w20;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lw20/u8;", "", "Lw20/u8$a;", "openPlatformInteractInfo", "Lw20/u8$a;", "getOpenPlatformInteractInfo", "()Lw20/u8$a;", "setOpenPlatformInteractInfo", "(Lw20/u8$a;)V", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "dataType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDataType", "playmode", "b", "setPlaymode", "", "source", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "<init>", "()V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u8 {

    @SerializedName("dataType")
    private Integer dataType;

    @SerializedName("openPlatformInteractInfo")
    private a openPlatformInteractInfo;

    @SerializedName("playmode")
    private Integer playmode;

    @SerializedName("source")
    private String source;

    @SerializedName("type")
    private Integer type;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lw20/u8$a;", "", "", com.heytap.mcssdk.constant.b.f276371u, "Ljava/lang/String;", "getAppID", "()Ljava/lang/String;", "setAppID", "(Ljava/lang/String;)V", "", "interactType", "Ljava/lang/Integer;", "getInteractType", "()Ljava/lang/Integer;", "setInteractType", "(Ljava/lang/Integer;)V", "", "interactiveScreenCast", "Ljava/lang/Boolean;", "getInteractiveScreenCast", "()Ljava/lang/Boolean;", "setInteractiveScreenCast", "(Ljava/lang/Boolean;)V", "<init>", "()V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName(com.heytap.mcssdk.constant.b.f276371u)
        private String appID;

        @SerializedName("interactType")
        private Integer interactType;

        @SerializedName("interactiveScreenCast")
        private Boolean interactiveScreenCast;

        public a() {
        }
    }

    public u8() {
    }

    public final Integer a() {
        return this.dataType;
    }

    public final Integer b() {
        return this.playmode;
    }

    public final String c() {
        return this.source;
    }

    public final Integer getType() {
        return this.type;
    }
}
