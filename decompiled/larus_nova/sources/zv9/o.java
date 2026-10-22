package zv9;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/settings/provider/security/STFCItem;", "", "apiId", "", VideoThumbInfo.KEY_INTERVAL, "count2Mark", "mark2Report", "checkBackground", "", "<init>", "(IIIIZ)V", "getApiId", "()I", "getInterval", "getCount2Mark", "getMark2Report", "getCheckBackground", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o {

    @SerializedName("api_id")
    private final int apiId;

    @SerializedName("check_background")
    private final boolean checkBackground;

    @SerializedName("count2mark")
    private final int count2Mark;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final int interval;

    @SerializedName("mark2report")
    private final int mark2Report;

    public o() {
        this(0, 0, 0, 0, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.apiId == r101.apiId) goto L12;
        return false;
    L12:
        if (this.interval == r101.interval) goto L15;
        return false;
    L15:
        if (this.count2Mark == r101.count2Mark) goto L18;
        return false;
    L18:
        if (this.mark2Report == r101.mark2Report) goto L21;
        return false;
    L21:
        if (this.checkBackground == r101.checkBackground) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.apiId * 31) + this.interval) * 31) + this.count2Mark) * 31) + this.mark2Report) * 31;
        if (this.checkBackground == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "STFCItem(apiId=" + this.apiId + ", interval=" + this.interval + ", count2Mark=" + this.count2Mark + ", mark2Report=" + this.mark2Report + ", checkBackground=" + this.checkBackground + ')';
    }

    public final int a() {
        return this.apiId;
    }

    public final boolean b() {
        return this.checkBackground;
    }

    public final int c() {
        return this.count2Mark;
    }

    public final int d() {
        return this.interval;
    }

    public final int e() {
        return this.mark2Report;
    }

    public /* synthetic */ o(int r100, int r101, int r102, int r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        int r103 = 0;
    L7:
        if ((r111 & 2) == 0) goto L9;
        int r104 = Integer.MAX_VALUE;
    L11:
        if ((r111 & 4) == 0) goto L13;
        int r105 = Integer.MAX_VALUE;
    L15:
        if ((r111 & 8) == 0) goto L17;
        int r106 = Integer.MAX_VALUE;
    L18:
        this(r103, r104, r105, r106, false);
        return;
    L17:
        r106 = r110;
        goto L18
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }

    public o(int r100, int r101, int r102, int r103, boolean r104) {
        this.apiId = r100;
        this.interval = r101;
        this.count2Mark = r102;
        this.mark2Report = r103;
        this.checkBackground = r104;
    }
}
