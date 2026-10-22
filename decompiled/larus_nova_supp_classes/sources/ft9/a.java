package ft9;

import android.util.EventsUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0000H\u0016J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/settings/HotPatchConfig;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "requestInterval", XmlPullParser.NO_NAMESPACE, "<init>", "(J)V", "getRequestInterval", "()J", "create", "component1", "copy", "equals", XmlPullParser.NO_NAMESPACE, "other", XmlPullParser.NO_NAMESPACE, "hashCode", XmlPullParser.NO_NAMESPACE, "toString", XmlPullParser.NO_NAMESPACE, "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class a {

    @SerializedName("request_interval")
    private final long requestInterval;

    public a() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.requestInterval == ((a) r8).requestInterval) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        long r0 = this.requestInterval;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final String toString() {
        return "HotPatchConfig(requestInterval=" + this.requestInterval + ')';
    }

    public final long a() {
        return this.requestInterval;
    }

    public a(int r3) {
        this.requestInterval = 600000;
    }
}
