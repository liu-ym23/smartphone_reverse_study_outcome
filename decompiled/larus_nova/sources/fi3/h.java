package fi3;

import com.bytedance.android.ec.core.utils.a2;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f477265c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f477267b;

    public static final class a {
        public static h a(Map r100) {
            Object r101 = null;
            if (r100 == null) goto L5;
            Object r102 = r100.get(ReportCardMonitorPlugin.EVENT_NAME);
        L7:
            if ((r102 instanceof String) == true) goto L9;
            r102 = null;
        L9:
            String r103 = a2.d((String) r102);
            if (r103 != null) goto L13;
            return null;
        L13:
            if (r100 == null) goto L15;
            Object r104 = r100.get("event_params");
        L17:
            if ((r104 instanceof Map) == false) goto L20;
            r101 = r104;
        L20:
            Map r105 = (Map) r101;
            if (r105 != null) goto L24;
            r105 = MapsKt.emptyMap();
        L24:
            return new h(r103, r105);
        L15:
            r104 = null;
            goto L17
        L5:
            r102 = null;
            goto L7
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f477266a, r101.f477266a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f477267b, r101.f477267b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f477266a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f477267b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DialogActionParams(eventName=" + this.f477266a + ", eventParams=" + this.f477267b + ")";
    }

    public h(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "eventParams");
        this.f477266a = r100;
        this.f477267b = r101;
    }
}
