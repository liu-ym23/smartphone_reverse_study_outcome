package hq9;

import android.util.EventsUtils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/FirstInstallOptConfig;", XmlPullParser.NO_NAMESPACE, "closeFirstStartEventDelay", XmlPullParser.NO_NAMESPACE, "closeFirstStartAsyncInit", "denyFirstStartAsyncTasksName", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "<init>", "(ZZLjava/util/List;)V", "getCloseFirstStartEventDelay", "()Z", "getCloseFirstStartAsyncInit", "getDenyFirstStartAsyncTasksName", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", XmlPullParser.NO_NAMESPACE, "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class e1 {

    @SerializedName("close_first_start_async_init")
    private final boolean closeFirstStartAsyncInit;

    @SerializedName("close_first_start_life_delay")
    private final boolean closeFirstStartEventDelay;

    @SerializedName("deny_first_start_async_tasks_name")
    private final List<String> denyFirstStartAsyncTasksName;

    public e1() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r6 = (e1) r5;
        if (this.closeFirstStartEventDelay == r6.closeFirstStartEventDelay) goto L12;
        return false;
    L12:
        if (this.closeFirstStartAsyncInit == r6.closeFirstStartAsyncInit) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.denyFirstStartAsyncTasksName, r6.denyFirstStartAsyncTasksName) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.closeFirstStartEventDelay == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.closeFirstStartAsyncInit == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        List<String> r4 = this.denyFirstStartAsyncTasksName;
        if (r4 != null) goto L13;
        int r5 = 0;
    L15:
        return r3 + r5;
    L13:
        r5 = r4.hashCode();
        goto L15
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "FirstInstallOptConfig(closeFirstStartEventDelay=" + this.closeFirstStartEventDelay + ", closeFirstStartAsyncInit=" + this.closeFirstStartAsyncInit + ", denyFirstStartAsyncTasksName=" + this.denyFirstStartAsyncTasksName + ')';
    }

    public final boolean a() {
        return this.closeFirstStartAsyncInit;
    }

    public final boolean b() {
        return this.closeFirstStartEventDelay;
    }

    public final List<String> c() {
        return this.denyFirstStartAsyncTasksName;
    }

    public e1(Object r2) {
        ArrayList r3 = new ArrayList();
        this.closeFirstStartEventDelay = false;
        this.closeFirstStartAsyncInit = true;
        this.denyFirstStartAsyncTasksName = r3;
    }
}
