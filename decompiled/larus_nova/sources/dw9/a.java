package dw9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/provider/showcase/SidebarCaseConfig;", "", "enableCase", "", "caseSize", "", "conversationCaseShowStyle", "sidebarCaseShowStyle", "<init>", "(ZIII)V", "getEnableCase", "()Z", "getCaseSize", "()I", "getConversationCaseShowStyle", "getSidebarCaseShowStyle", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("conversation_page_case_size")
    private final int caseSize;

    @SerializedName("conversation_page_case_show_style")
    private final int conversationCaseShowStyle;

    @SerializedName("enable_case")
    private final boolean enableCase;

    @SerializedName("side_bar_case_show_style")
    private final int sidebarCaseShowStyle;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.enableCase == r101.enableCase) goto L12;
        return false;
    L12:
        if (this.caseSize == r101.caseSize) goto L15;
        return false;
    L15:
        if (this.conversationCaseShowStyle == r101.conversationCaseShowStyle) goto L18;
        return false;
    L18:
        if (this.sidebarCaseShowStyle == r101.sidebarCaseShowStyle) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.enableCase == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((r100 * 31) + this.caseSize) * 31) + this.conversationCaseShowStyle) * 31) + this.sidebarCaseShowStyle;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "SidebarCaseConfig(enableCase=" + this.enableCase + ", caseSize=" + this.caseSize + ", conversationCaseShowStyle=" + this.conversationCaseShowStyle + ", sidebarCaseShowStyle=" + this.sidebarCaseShowStyle + ')';
    }

    public final int a() {
        return this.caseSize;
    }

    public final int b() {
        return this.conversationCaseShowStyle;
    }

    public final boolean c() {
        return this.enableCase;
    }

    public final int d() {
        return this.sidebarCaseShowStyle;
    }

    public a(int r100) {
        this.enableCase = false;
        this.caseSize = 0;
        this.conversationCaseShowStyle = 0;
        this.sidebarCaseShowStyle = 0;
    }
}
