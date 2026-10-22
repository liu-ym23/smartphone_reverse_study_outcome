package zv9;

import android.util.EventsUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/larus/settings/provider/security/ShortTermFrequencyControl;", XmlPullParser.NO_NAMESPACE, "enable", XmlPullParser.NO_NAMESPACE, "readInterval", XmlPullParser.NO_NAMESPACE, "writeInterval", "configList", XmlPullParser.NO_NAMESPACE, "Lcom/larus/settings/provider/security/STFCItem;", "<init>", "(ZIILjava/util/List;)V", "getEnable", "()Z", "getReadInterval", "()I", "getWriteInterval", "getConfigList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", XmlPullParser.NO_NAMESPACE, "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class r {

    @SerializedName("config_list")
    private final List<o> configList;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("read_interval")
    private final int readInterval;

    @SerializedName("write_interval")
    private final int writeInterval;

    public r() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (this.readInterval == r6.readInterval) goto L15;
        return false;
    L15:
        if (this.writeInterval == r6.writeInterval) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.configList, r6.configList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.readInterval) * 31) + this.writeInterval) * 31;
        List<o> r2 = this.configList;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShortTermFrequencyControl(enable=" + this.enable + ", readInterval=" + this.readInterval + ", writeInterval=" + this.writeInterval + ", configList=" + this.configList + ')';
    }

    public final List<o> a() {
        return this.configList;
    }

    public final boolean b() {
        return this.enable;
    }

    public final int c() {
        return this.readInterval;
    }

    public final int d() {
        return this.writeInterval;
    }

    public r(Object r2) {
        List<o> r3 = s.a;
        this.enable = true;
        this.readInterval = 20;
        this.writeInterval = 10;
        this.configList = r3;
    }
}
