package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/platform/model/AppPreloadViewConfig;", "", "isNitaEnable", "", "isPreLoadChatPageEnable", "isPreLoadMainTabViewEnable", "<init>", "(ZZZ)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("is_nita_enable")
    private final boolean isNitaEnable;

    @SerializedName("is_preload_chat_page_enable")
    private final boolean isPreLoadChatPageEnable;

    @SerializedName("is_preload_main_tab_view_enable")
    private final boolean isPreLoadMainTabViewEnable;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.isNitaEnable == r101.isNitaEnable) goto L12;
        return false;
    L12:
        if (this.isPreLoadChatPageEnable == r101.isPreLoadChatPageEnable) goto L15;
        return false;
    L15:
        if (this.isPreLoadMainTabViewEnable == r101.isPreLoadMainTabViewEnable) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.isNitaEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isPreLoadChatPageEnable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.isPreLoadMainTabViewEnable == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppPreloadViewConfig(isNitaEnable=" + this.isNitaEnable + ", isPreLoadChatPageEnable=" + this.isPreLoadChatPageEnable + ", isPreLoadMainTabViewEnable=" + this.isPreLoadMainTabViewEnable + ')';
    }

    public final boolean a() {
        return this.isNitaEnable;
    }

    public final boolean b() {
        return this.isPreLoadChatPageEnable;
    }

    public final boolean c() {
        return this.isPreLoadMainTabViewEnable;
    }

    public k(int r100) {
        this.isNitaEnable = true;
        this.isPreLoadChatPageEnable = false;
        this.isPreLoadMainTabViewEnable = true;
    }
}
