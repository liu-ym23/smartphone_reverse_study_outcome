package w20;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lw20/jc;", "", "", "", "images", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "descriptionList", "getDescriptionList", "setDescriptionList", "", "loop", "Ljava/lang/Boolean;", "getLoop", "()Ljava/lang/Boolean;", "setLoop", "(Ljava/lang/Boolean;)V", "needDownload", "getNeedDownload", "setNeedDownload", "showCloseButton", "getShowCloseButton", "setShowCloseButton", "", "index", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class jc {

    @SerializedName("descriptionList")
    private List<String> descriptionList;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("index")
    private Integer index;

    @SerializedName("loop")
    private Boolean loop;

    @SerializedName("needDownload")
    private Boolean needDownload;

    @SerializedName("showCloseButton")
    private Boolean showCloseButton;

    public jc() {
    }

    public final List<String> a() {
        return this.images;
    }

    public final Integer b() {
        return this.index;
    }
}
