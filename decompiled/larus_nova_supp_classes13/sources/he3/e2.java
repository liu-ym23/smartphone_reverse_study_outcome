package he3;

import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lhe3/e2;", "", "", "id", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "width", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "height", "d", "Lhe3/n2;", "addr", "Lhe3/n2;", "a", "()Lhe3/n2;", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedUrlModel;", "cover", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedUrlModel;", "b", "()Lcom/bytedance/android/shopping/infeed/data/idl/InFeedUrlModel;", "Lhe3/f2;", "extra", "Lhe3/f2;", "c", "()Lhe3/f2;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e2 {

    @SerializedName("addr")
    private final n2 addr;

    @SerializedName("cover")
    private final InFeedUrlModel cover;

    @SerializedName("extra")
    private final f2 extra;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("id")
    private final String id;

    @SerializedName("width")
    private final Integer width;

    public e2() {
    }

    public final n2 a() {
        return this.addr;
    }

    public final InFeedUrlModel b() {
        return this.cover;
    }

    public final f2 c() {
        return this.extra;
    }

    public final Integer d() {
        return this.height;
    }

    public final String e() {
        return this.id;
    }

    public final Integer f() {
        return this.width;
    }
}
