package te6;

import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.tool.v1.OnlineScenario;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f545581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InitSDKRequest.EnvV2 f545582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f545583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DomainSettings f545584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OnlineScenario f545585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f545586g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f545580a, r101.f545580a) == true) goto L12;
        return false;
    L12:
        if (this.f545581b == r101.f545581b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f545582c, r101.f545582c) == true) goto L18;
        return false;
    L18:
        if (this.f545583d == r101.f545583d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f545584e, r101.f545584e) == true) goto L24;
        return false;
    L24:
        if (this.f545585f == r101.f545585f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f545586g, r101.f545586g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f545580a.hashCode() * 31;
        int r101 = 1231;
        if (this.f545581b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        InitSDKRequest.EnvV2 r104 = this.f545582c;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        if (this.f545583d == true) goto L14;
        r101 = 1237;
    L14:
        int r108 = (r107 + r101) * 31;
        DomainSettings r109 = this.f545584e;
        if (r109 == null) goto L19;
        r105 = r109.hashCode();
    L19:
        return ((((r108 + r105) * 31) + this.f545585f.hashCode()) * 31) + this.f545586g.hashCode();
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "OnlineResponseEvent(uid=" + this.f545580a + ", isForeground=" + this.f545581b + ", env=" + this.f545582c + ", isSuccess=" + this.f545583d + ", domainSettings=" + this.f545584e + ", onlineScenario=" + this.f545585f + ", settings=" + this.f545586g + ')';
    }

    public c(String r100, boolean r101, InitSDKRequest.EnvV2 r102, boolean r103, DomainSettings r104, OnlineScenario r105, Map<String, String> r106) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r105, "onlineScenario");
        Intrinsics.checkNotNullParameter(r106, "settings");
        this.f545580a = r100;
        this.f545581b = r101;
        this.f545582c = r102;
        this.f545583d = r103;
        this.f545584e = r104;
        this.f545585f = r105;
        this.f545586g = r106;
    }
}
