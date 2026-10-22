package yd3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000b¨\u0006#"}, d2 = {"Lyd3/r;", "Lyd3/l;", "", "id", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "", "name", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "logo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "f", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "brand", "c", "", "isLive", "Ljava/lang/Boolean;", "i", "()Ljava/lang/Boolean;", "liveIcon", "e", "", "recTag", "Ljava/util/List;", "h", "()Ljava/util/List;", "link", "d", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r extends l {

    @SerializedName("brand")
    private final ECUrlModel brand;

    @SerializedName("id")
    private final Integer id;

    @SerializedName("is_live")
    private final Boolean isLive;

    @SerializedName("link")
    private final String link;

    @SerializedName("live_icon")
    private final ECUrlModel liveIcon;

    @SerializedName("logo")
    private final ECUrlModel logo;

    @SerializedName("name")
    private final String name;

    @SerializedName("rec_tag")
    private final List<String> recTag;

    public r() {
    }

    public final ECUrlModel c() {
        return this.brand;
    }

    public final String d() {
        return this.link;
    }

    public final ECUrlModel e() {
        return this.liveIcon;
    }

    public final ECUrlModel f() {
        return this.logo;
    }

    public final String g() {
        return this.name;
    }

    public final List<String> h() {
        return this.recTag;
    }

    public final Boolean i() {
        return this.isLive;
    }
}
