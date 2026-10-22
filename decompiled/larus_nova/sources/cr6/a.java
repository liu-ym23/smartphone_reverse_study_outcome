package cr6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcr6/a;", "", "", "fmpLynxAsyncLoad", "I", "getFmpLynxAsyncLoad", "()I", "iconAsyncLoad", "getIconAsyncLoad", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("enable_fmp_lynx_async_load")
    private final int fmpLynxAsyncLoad;

    @SerializedName("enable_icon_async_load")
    private final int iconAsyncLoad;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.fmpLynxAsyncLoad == r101.fmpLynxAsyncLoad) goto L12;
        return false;
    L12:
        if (this.iconAsyncLoad == r101.iconAsyncLoad) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.fmpLynxAsyncLoad * 31) + this.iconAsyncLoad;
    }

    public final String toString() {
        return "SimpleConfig(fmpLynxAsyncLoad=" + this.fmpLynxAsyncLoad + ", iconAsyncLoad=" + this.iconAsyncLoad + ')';
    }

    public a() {
        this.fmpLynxAsyncLoad = 0;
        this.iconAsyncLoad = 0;
    }
}
