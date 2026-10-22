package du9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/provider/chat/MessageModifyConfig;", "", "style", "", "historyMsgEditable", "", "offlineMsgEditable", "<init>", "(IZZ)V", "getStyle", "()I", "getHistoryMsgEditable", "()Z", "getOfflineMsgEditable", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o1 {

    @SerializedName("history_msg_editable")
    private final boolean historyMsgEditable;

    @SerializedName("offline_msg_editable")
    private final boolean offlineMsgEditable;

    @SerializedName("style")
    private final int style;

    public o1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o1) == true) goto L8;
        return false;
    L8:
        o1 r101 = (o1) r100;
        if (this.style == r101.style) goto L12;
        return false;
    L12:
        if (this.historyMsgEditable == r101.historyMsgEditable) goto L15;
        return false;
    L15:
        if (this.offlineMsgEditable == r101.offlineMsgEditable) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.style * 31;
        int r101 = 1231;
        if (this.historyMsgEditable == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.offlineMsgEditable == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MessageModifyConfig(style=" + this.style + ", historyMsgEditable=" + this.historyMsgEditable + ", offlineMsgEditable=" + this.offlineMsgEditable + ')';
    }

    public final boolean a() {
        return this.historyMsgEditable;
    }

    public final boolean b() {
        return this.offlineMsgEditable;
    }

    public final int c() {
        return this.style;
    }

    public o1(int r100) {
        this.style = 1;
        this.historyMsgEditable = true;
        this.offlineMsgEditable = false;
    }
}
