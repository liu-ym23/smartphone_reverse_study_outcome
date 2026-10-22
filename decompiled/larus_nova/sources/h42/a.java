package h42;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.interactivity.pin.business.im.api.ImHighlightRequest;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f483769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f483770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f483771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f483772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final User f483773f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f483768a, r101.f483768a) == true) goto L8;
        return false;
    L8:
        if (this.f483769b == r101.f483769b) goto L10;
        return false;
    L10:
        if (this.f483770c == r101.f483770c) goto L12;
        return false;
    L12:
        if (this.f483771d == r101.f483771d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f483772e, r101.f483772e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f483773f, r101.f483773f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f483768a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f483769b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f483770c;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f483771d;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        Map<String, String> r109 = this.f483772e;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (r108 + r110) * 31;
        User r112 = this.f483773f;
        if (r112 == null) goto L14;
        r101 = r112.hashCode();
    L14:
        return r111 + r101;
    L9:
        r110 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ImPinContent(scene=" + this.f483768a + ", msgId=" + this.f483769b + ", commenterId=" + this.f483770c + ", showArea=" + this.f483771d + ", buriedPoint=" + this.f483772e + ", user=" + this.f483773f + ")";
    }

    public a(long r100, long r101, long r102, Map r103, User r110) {
        Intrinsics.checkNotNullParameter(ImHighlightRequest.SCENE, "scene");
        this.f483768a = ImHighlightRequest.SCENE;
        this.f483769b = r100;
        this.f483770c = r101;
        this.f483771d = r102;
        this.f483772e = r103;
        this.f483773f = r110;
    }
}
