package g92;

import com.bytedance.android.livesdk.interactivity.api.comment.event.DefaultLandingPanel;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JsonObject f480501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OpenInputSource f480502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f480503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f480504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Object, Object> f480505e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f480502b, r101.f480502b) == true) goto L8;
        return false;
    L8:
        if (this.f480503c == r101.f480503c) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f480504d, r101.f480504d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f480505e, r101.f480505e) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        OpenInputSource r100 = this.f480502b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f480503c;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f480504d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Map<Object, Object> r108 = this.f480505e;
        if (r108 == null) goto L14;
        r101 = r108.hashCode();
    L14:
        return r107 + r101;
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PrepareInputParam(openInputSource=" + this.f480502b + ", triggerTime=" + this.f480503c + ", defaultLandingPanel=" + this.f480504d + ", extraMap=" + this.f480505e + ")";
    }

    public f() {
        this(OpenInputSource.Unknow, System.currentTimeMillis(), DefaultLandingPanel.Default.getPanel(), null);
    }

    public f(OpenInputSource r100, long r101, String r102, Map<Object, ? extends Object> r103) {
        this.f480502b = r100;
        this.f480503c = r101;
        this.f480504d = r102;
        this.f480505e = r103;
    }
}
