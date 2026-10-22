package s64;

import com.bytedance.awemeopen.servicesapi.ui.host.ext.UIComponentExtensionType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f540800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f540801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f540802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UIComponentExtensionType f540803e;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f540799a, r101.f540799a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f540800b, r101.f540800b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f540801c, r101.f540801c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f540802d, r101.f540802d) == true) goto L21;
        return false;
    L21:
        if (this.f540803e == r101.f540803e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f540799a.hashCode() * 31;
        String r101 = this.f540800b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        JSONObject r105 = this.f540801c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((((r104 + r102) * 31) + this.f540802d.hashCode()) * 31) + this.f540803e.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UIComponentInitData(awemeId=" + this.f540799a + ", authorOpenId=" + this.f540800b + ", hostCommonParams=" + this.f540801c + ", photoList=" + this.f540802d + ", extensionType=" + this.f540803e + ')';
    }

    public b(String r100, String r101, JSONObject r102, List r103) {
        UIComponentExtensionType r104 = UIComponentExtensionType.PHOTO_DETAIL_LONG_PRESS;
        Intrinsics.checkNotNullParameter(r100, "awemeId");
        Intrinsics.checkNotNullParameter(r103, "photoList");
        Intrinsics.checkNotNullParameter(r104, "extensionType");
        this.f540799a = r100;
        this.f540800b = r101;
        this.f540801c = r102;
        this.f540802d = r103;
        this.f540803e = r104;
    }
}
