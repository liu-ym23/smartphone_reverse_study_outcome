package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lhe3/a;", "", "Lhe3/b;", "baseInfo", "Lhe3/b;", "a", "()Lhe3/b;", "Lhe3/d;", "liveInfo", "Lhe3/d;", "getLiveInfo", "()Lhe3/d;", "Lhe3/c;", "linkInfo", "Lhe3/c;", "getLinkInfo", "()Lhe3/c;", "Lhe3/e;", "relationInfo", "Lhe3/e;", "getRelationInfo", "()Lhe3/e;", "Lhe3/u0;", "custom", "Lhe3/u0;", "getCustom", "()Lhe3/u0;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("base_info")
    private final b baseInfo;

    @SerializedName("custom")
    private final u0 custom;

    @SerializedName("link_info")
    private final c linkInfo;

    @SerializedName("live_info")
    private final d liveInfo;

    @SerializedName("relation_info")
    private final e relationInfo;

    public a() {
    }

    public final b a() {
        return this.baseInfo;
    }
}
