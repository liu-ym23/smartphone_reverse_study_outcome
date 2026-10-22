package zv9;

import android.util.EventsUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/settings/provider/security/STFCItem;", XmlPullParser.NO_NAMESPACE, "apiId", XmlPullParser.NO_NAMESPACE, "interval", "count2Mark", "mark2Report", "checkBackground", XmlPullParser.NO_NAMESPACE, "<init>", "(IIIIZ)V", "getApiId", "()I", "getInterval", "getCount2Mark", "getMark2Report", "getCheckBackground", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", XmlPullParser.NO_NAMESPACE, "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class o {

    @SerializedName("api_id")
    private final int apiId;

    @SerializedName("check_background")
    private final boolean checkBackground;

    @SerializedName("count2mark")
    private final int count2Mark;

    @SerializedName("interval")
    private final int interval;

    @SerializedName("mark2report")
    private final int mark2Report;

    public o() {
        this(0, 0, 0, 0, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
        if (this.apiId == r6.apiId) goto L12;
        return false;
    L12:
        if (this.interval == r6.interval) goto L15;
        return false;
    L15:
        if (this.count2Mark == r6.count2Mark) goto L18;
        return false;
    L18:
        if (this.mark2Report == r6.mark2Report) goto L21;
        return false;
    L21:
        if (this.checkBackground == r6.checkBackground) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.apiId * 31) + this.interval) * 31) + this.count2Mark) * 31) + this.mark2Report) * 31;
        if (this.checkBackground == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
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

    public /* synthetic */ o(int r7, int r8, int r9, int r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        int r1 = 0;
    L7:
        if ((r11 & 2) == 0) goto L9;
        int r2 = Integer.MAX_VALUE;
    L11:
        if ((r11 & 4) == 0) goto L13;
        int r3 = Integer.MAX_VALUE;
    L15:
        if ((r11 & 8) == 0) goto L17;
        int r4 = Integer.MAX_VALUE;
    L18:
        this(r1, r2, r3, r4, false);
        return;
    L17:
        r4 = r10;
        goto L18
    L13:
        r3 = r9;
        goto L15
    L9:
        r2 = r8;
        goto L11
    L5:
        r1 = r7;
        goto L7
    }

    public o(int r1, int r2, int r3, int r4, boolean r5) {
        this.apiId = r1;
        this.interval = r2;
        this.count2Mark = r3;
        this.mark2Report = r4;
        this.checkBackground = r5;
    }
}
