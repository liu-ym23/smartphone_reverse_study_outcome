package yd3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lyd3/f;", "Lyd3/l;", "Lyd3/t;", "title", "Lyd3/t;", "f", "()Lyd3/t;", "subTitle", "d", "Lyd3/g;", "link", "Lyd3/g;", "c", "()Lyd3/g;", "Lyd3/s;", "timeInfo", "Lyd3/s;", "e", "()Lyd3/s;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f extends l {

    @SerializedName("link_info")
    private final g link;

    @SerializedName("subtitle")
    private final t subTitle;

    @SerializedName("time_info")
    private final s timeInfo;

    @SerializedName("title")
    private final t title;

    public f() {
    }

    public final g c() {
        return this.link;
    }

    public final t d() {
        return this.subTitle;
    }

    public final s e() {
        return this.timeInfo;
    }

    public final t f() {
        return this.title;
    }
}
