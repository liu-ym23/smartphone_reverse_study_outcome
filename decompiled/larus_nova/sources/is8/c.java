package is8;

import com.larus.bmhome.upload.sdk.api.model.UploadScene;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UploadScene f495646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f495648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f495649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f495650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f495651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f495652h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f495653i;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f495645a, r101.f495645a) == true) goto L12;
        return false;
    L12:
        if (this.f495646b == r101.f495646b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495647c, r101.f495647c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495648d, r101.f495648d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495649e, r101.f495649e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f495650f, r101.f495650f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f495651g, r101.f495651g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f495652h, r101.f495652h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f495653i, r101.f495653i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f495645a.hashCode() * 31) + this.f495646b.hashCode()) * 31;
        String r101 = this.f495647c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f495648d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f495649e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f495650f.hashCode()) * 31;
        String r111 = this.f495651g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f495652h;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return ((r113 + r102) * 31) + this.f495653i.hashCode();
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UploadBizContext(bizScene=" + this.f495645a + ", uploadScene=" + this.f495646b + ", conversationId=" + this.f495647c + ", botId=" + this.f495648d + ", localMessageId=" + this.f495649e + ", fileIdentifier=" + this.f495650f + ", enterMethod=" + this.f495651g + ", clickFrom=" + this.f495652h + ", ext=" + this.f495653i + ')';
    }

    public c(String r100, UploadScene r101, String r102) {
        Map<String, String> r103 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r100, "bizScene");
        Intrinsics.checkNotNullParameter(r101, "uploadScene");
        Intrinsics.checkNotNullParameter(r102, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r103, "ext");
        this.f495645a = r100;
        this.f495646b = r101;
        this.f495647c = null;
        this.f495648d = null;
        this.f495649e = null;
        this.f495650f = r102;
        this.f495651g = null;
        this.f495652h = null;
        this.f495653i = r103;
    }
}
