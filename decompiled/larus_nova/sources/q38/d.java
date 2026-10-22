package q38;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.google.gson.annotations.SerializedName;
import com.larus.account.base.model.NeutralAgeGatePage;
import com.larus.account.base.model.NeutralAgeGateStyle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/larus/account/base/model/AgeGateCheckResponse;", "", "decision", "", "type", DocumentType.MINUTES_NAME, "style", "page", "isMinorEnabled", "", "<init>", "(IIIIIZ)V", "getDecision", "()I", "getType", "getMinutes", "getStyle", "getPage", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("decision")
    private final int decision;

    @SerializedName("is_minor_enabled")
    private final boolean isMinorEnabled;

    @SerializedName("cold_down_remain_minutes")
    private final int minutes;

    @SerializedName("page")
    private final int page;

    @SerializedName("style")
    private final int style;

    @SerializedName("type")
    private final int type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.decision == r101.decision) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (this.minutes == r101.minutes) goto L18;
        return false;
    L18:
        if (this.style == r101.style) goto L21;
        return false;
    L21:
        if (this.page == r101.page) goto L24;
        return false;
    L24:
        if (this.isMinorEnabled == r101.isMinorEnabled) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.decision * 31) + this.type) * 31) + this.minutes) * 31) + this.style) * 31) + this.page) * 31;
        if (this.isMinorEnabled == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "AgeGateCheckResponse(decision=" + this.decision + ", type=" + this.type + ", minutes=" + this.minutes + ", style=" + this.style + ", page=" + this.page + ", isMinorEnabled=" + this.isMinorEnabled + ')';
    }

    public d() {
        int r100 = NeutralAgeGateStyle.DIALOG.getStyle();
        int r101 = NeutralAgeGatePage.DEFAULT.getPage();
        this.decision = 2;
        this.type = 1;
        this.minutes = 0;
        this.style = r100;
        this.page = r101;
        this.isMinorEnabled = false;
    }

    public final int a() {
        return this.decision;
    }

    public final int b() {
        return this.minutes;
    }

    public final int c() {
        return this.page;
    }

    public final int d() {
        return this.style;
    }

    public final boolean e() {
        return this.isMinorEnabled;
    }

    public final int getType() {
        return this.type;
    }
}
