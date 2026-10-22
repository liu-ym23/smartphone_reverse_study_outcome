package lh3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Llh3/i;", "", "", "title", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "desc", "c", "agreeDesc", "a", "confirm", "b", "later", "d", "", "Llh3/d;", "laws", "Ljava/util/List;", "e", "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("agree_desc")
    private final String agreeDesc;

    @SerializedName("confirm")
    private final String confirm;

    @SerializedName("desc")
    private final String desc;

    @SerializedName("later")
    private final String later;

    @SerializedName("laws")
    private final List<d> laws;

    @SerializedName("main_title")
    private final String title;

    public i() {
        this.title = null;
        this.desc = null;
        this.agreeDesc = null;
        this.confirm = null;
        this.later = null;
        this.laws = null;
    }

    public final String a() {
        return this.agreeDesc;
    }

    public final String b() {
        return this.confirm;
    }

    public final String c() {
        return this.desc;
    }

    public final String d() {
        return this.later;
    }

    public final List<d> e() {
        return this.laws;
    }

    public final String f() {
        return this.title;
    }
}
