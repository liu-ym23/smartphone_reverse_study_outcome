package uj;

import com.bytedance.android.ec.hybrid.card.data.MallLynxGroupLevel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Luj/c;", "", "", "", "lynxLoopAsync", "Ljava/util/List;", "c", "()Ljava/util/List;", "mallEnableShareLevel", "Ljava/lang/String;", "getMallEnableShareLevel", "()Ljava/lang/String;", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("mall_enable_lynx_loop_async")
    private final List<String> lynxLoopAsync;

    @SerializedName("mall_enable_share_level")
    private final String mallEnableShareLevel;

    public c() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.lynxLoopAsync, r101.lynxLoopAsync) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.mallEnableShareLevel, r101.mallEnableShareLevel) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.lynxLoopAsync;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.mallEnableShareLevel;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LynxShareGroupConfig(lynxLoopAsync=" + this.lynxLoopAsync + ", mallEnableShareLevel=" + this.mallEnableShareLevel + ")";
    }

    public final boolean a() {
        return !Intrinsics.areEqual(this.mallEnableShareLevel, MallLynxGroupLevel.NONE.getValue());
    }

    public final boolean b() {
        return Intrinsics.areEqual(this.mallEnableShareLevel, MallLynxGroupLevel.SHARE_DATA_WHITEBOARD.getValue());
    }

    public final List<String> c() {
        return this.lynxLoopAsync;
    }

    public c(Object r100) {
        String r101 = MallLynxGroupLevel.SHARE_DATA.getValue();
        this.lynxLoopAsync = null;
        this.mallEnableShareLevel = r101;
    }
}
