package op8;

import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.preview.AttachmentSnapshot;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f524750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<AttachmentSnapshot> f524751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SuggestedAction f524752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f524753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f524754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f524755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f524756g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f524750a, r101.f524750a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f524751b, r101.f524751b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f524752c, r101.f524752c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f524753d, r101.f524753d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f524754e, r101.f524754e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f524755f, r101.f524755f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f524756g, r101.f524756g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f524750a.hashCode() * 31) + this.f524751b.hashCode()) * 31;
        SuggestedAction r101 = this.f524752c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f524753d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, String> r108 = this.f524754e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Map<String, String> r111 = this.f524755f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Map<String, String> r114 = this.f524756g;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
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
        return "AlbumGroupInputSnapshot(text=" + this.f524750a + ", attachments=" + this.f524751b + ", suggestedAction=" + this.f524752c + ", scene=" + this.f524753d + ", messageExt=" + this.f524754e + ", fileForceTraceMap=" + this.f524755f + ", textForceTraceMap=" + this.f524756g + ')';
    }

    public /* synthetic */ b(String r100, List r110) {
        this(r100, r110, null, null, null, null, null);
    }

    public b(String r100, List<AttachmentSnapshot> r101, SuggestedAction r102, String r103, Map<String, String> r104, Map<String, String> r105, Map<String, String> r106) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "attachments");
        this.f524750a = r100;
        this.f524751b = r101;
        this.f524752c = r102;
        this.f524753d = r103;
        this.f524754e = r104;
        this.f524755f = r105;
        this.f524756g = r106;
    }
}
