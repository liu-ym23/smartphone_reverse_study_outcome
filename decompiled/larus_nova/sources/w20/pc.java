package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b+\u0010,R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lw20/pc;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Lw20/pc$a;", "single_privilege_detail", "Lw20/pc$a;", "e", "()Lw20/pc$a;", "setSingle_privilege_detail", "(Lw20/pc$a;)V", "", "detail_url", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setDetail_url", "(Ljava/lang/String;)V", "video_start_index", "f", "setVideo_start_index", "", "need_ban_record", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setNeed_ban_record", "(Ljava/lang/Boolean;)V", "need_history_start", "d", "setNeed_history_start", "Lcom/google/gson/JsonObject;", "extra_map", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "setExtra_map", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class pc {

    @SerializedName("detail_url")
    private String detail_url;

    @SerializedName("extra_map")
    private JsonObject extra_map;

    @SerializedName("need_ban_record")
    private Boolean need_ban_record;

    @SerializedName("need_history_start")
    private Boolean need_history_start;

    @SerializedName("single_privilege_detail")
    private a single_privilege_detail;

    @SerializedName("type")
    private Integer type;

    @SerializedName("video_start_index")
    private Integer video_start_index;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lw20/pc$a;", "", "", "detail_title", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setDetail_title", "(Ljava/lang/String;)V", "", "detail_video", "Ljava/util/List;", "c", "()Ljava/util/List;", "setDetail_video", "(Ljava/util/List;)V", "detail_text", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDetail_text", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("detail_text")
        private String detail_text;

        @SerializedName("detail_title")
        private String detail_title;

        @SerializedName("detail_video")
        private List<String> detail_video;

        public a() {
        }

        public final String a() {
            return this.detail_text;
        }

        public final String b() {
            return this.detail_title;
        }

        public final List<String> c() {
            return this.detail_video;
        }
    }

    public pc() {
    }

    public final String a() {
        return this.detail_url;
    }

    public final JsonObject b() {
        return this.extra_map;
    }

    public final Boolean c() {
        return this.need_ban_record;
    }

    public final Boolean d() {
        return this.need_history_start;
    }

    public final a e() {
        return this.single_privilege_detail;
    }

    public final Integer f() {
        return this.video_start_index;
    }

    public final Integer getType() {
        return this.type;
    }
}
