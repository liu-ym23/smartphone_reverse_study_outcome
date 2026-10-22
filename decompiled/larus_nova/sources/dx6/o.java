package dx6;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Ldx6/o;", "Ldx6/c;", "", "title", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "unitText", "h", "pricePrefixText", "e", "priceText", "f", "", "Ldx6/j;", "contentVOList", "Ljava/util/List;", "d", "()Ljava/util/List;", "<init>", "()V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class o extends c {

    @SerializedName("contentVOList")
    private final List<j> contentVOList;

    @SerializedName("pricePrefixText")
    private final String pricePrefixText;

    @SerializedName("priceText")
    private final String priceText;

    @SerializedName("title")
    private final String title;

    @SerializedName("unitText")
    private final String unitText;

    public o() {
    }

    public final List<j> d() {
        return this.contentVOList;
    }

    public final String e() {
        return this.pricePrefixText;
    }

    public final String f() {
        return this.priceText;
    }

    public final String g() {
        return this.title;
    }

    public final String h() {
        return this.unitText;
    }
}
