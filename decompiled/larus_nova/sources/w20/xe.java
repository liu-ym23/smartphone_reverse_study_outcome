package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0013\fB\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lw20/xe;", "", "Lcom/google/gson/JsonObject;", "uploadParams", "Lcom/google/gson/JsonObject;", "f", "()Lcom/google/gson/JsonObject;", "setUploadParams", "(Lcom/google/gson/JsonObject;)V", "", "editContent", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setEditContent", "(Ljava/lang/String;)V", "", "addimageDirectly", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "setAddimageDirectly", "(Ljava/lang/Boolean;)V", "imageURLPrefix", "c", "setImageURLPrefix", "", "pageHeight", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "setPageHeight", "(Ljava/lang/Integer;)V", "Lw20/xe$a;", "imageXInfo", "Lw20/xe$a;", "d", "()Lw20/xe$a;", "setImageXInfo", "(Lw20/xe$a;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class xe {

    @SerializedName("addimageDirectly")
    private Boolean addimageDirectly;

    @SerializedName("editContent")
    private String editContent;

    @SerializedName("imageURLPrefix")
    private String imageURLPrefix;

    @SerializedName("imageXInfo")
    private a imageXInfo;

    @SerializedName("pageHeight")
    private Integer pageHeight;

    @SerializedName("uploadParams")
    private JsonObject uploadParams;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lw20/xe$a;", "", "", "serviceId", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setServiceId", "(Ljava/lang/String;)V", "hostName", "c", "setHostName", "accessKeyId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAccessKeyId", "secretAccessKey", "d", "setSecretAccessKey", "sessionToken", "f", "setSessionToken", "getUrlAPI", "b", "setGetUrlAPI", "Lw20/xe$b;", "uploadConfig", "Lw20/xe$b;", com.amap.api.col.s.ce.f26391f, "()Lw20/xe$b;", "setUploadConfig", "(Lw20/xe$b;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("accessKeyId")
        private String accessKeyId;

        @SerializedName("getUrlAPI")
        private String getUrlAPI;

        @SerializedName("hostName")
        private String hostName;

        @SerializedName("secretAccessKey")
        private String secretAccessKey;

        @SerializedName("serviceId")
        private String serviceId;

        @SerializedName("sessionToken")
        private String sessionToken;

        @SerializedName("uploadConfig")
        private b uploadConfig;

        public a() {
        }

        public final String a() {
            return this.accessKeyId;
        }

        public final String b() {
            return this.getUrlAPI;
        }

        public final String c() {
            return this.hostName;
        }

        public final String d() {
            return this.secretAccessKey;
        }

        public final String e() {
            return this.serviceId;
        }

        public final String f() {
            return this.sessionToken;
        }

        public final b g() {
            return this.uploadConfig;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lw20/xe$b;", "", "", "sliceSize", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setSliceSize", "(Ljava/lang/Integer;)V", "socketNum", "b", "setSocketNum", "", "traceId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setTraceId", "(Ljava/lang/String;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("sliceSize")
        private Integer sliceSize;

        @SerializedName("socketNum")
        private Integer socketNum;

        @SerializedName("traceId")
        private String traceId;

        public b() {
        }

        public final Integer a() {
            return this.sliceSize;
        }

        public final Integer b() {
            return this.socketNum;
        }

        public final String c() {
            return this.traceId;
        }
    }

    public xe() {
    }

    public final Boolean a() {
        return this.addimageDirectly;
    }

    public final String b() {
        return this.editContent;
    }

    public final String c() {
        return this.imageURLPrefix;
    }

    public final a d() {
        return this.imageXInfo;
    }

    public final Integer e() {
        return this.pageHeight;
    }

    public final JsonObject f() {
        return this.uploadParams;
    }
}
