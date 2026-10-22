package slb;

import com.ss.android.lark.inline.ai.api.Templates;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f542534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f542535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f542536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f542537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Templates f542538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f542539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<j> f542540g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final transient k f542541h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f542542i;

    public j() {
        this(null, null, 0, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f542534a, r101.f542534a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f542535b, r101.f542535b) == true) goto L15;
        return false;
    L15:
        if (this.f542536c == r101.f542536c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f542537d, r101.f542537d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f542538e, r101.f542538e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f542539f, r101.f542539f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f542540g, r101.f542540g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f542541h, r101.f542541h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f542542i, r101.f542542i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f542534a.hashCode() * 31) + this.f542535b.hashCode()) * 31) + this.f542536c) * 31) + this.f542537d.hashCode()) * 31;
        Templates r101 = this.f542538e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f542539f.hashCode()) * 31;
        ArrayList<j> r105 = this.f542540g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        k r108 = this.f542541h;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((r107 + r102) * 31) + this.f542542i.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "Prompt(id='" + this.f542534a + "', type='" + this.f542535b + "', icon=" + this.f542536c + ", text='" + this.f542537d + "', templates=" + this.f542538e + ", extraMap=" + this.f542539f + ", children=" + this.f542540g + ", callback=" + this.f542541h + ", localId = " + this.f542542i + ')';
    }

    public final String getType() {
        return this.f542535b;
    }

    public j(String r100, String r101, int r102, String r103, Templates r104, Map r110, ArrayList r111, k r112, String r113, int r114) {
        if ((r114 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r114 & 2) == 0) goto L8;
        r101 = "";
    L8:
        boolean r105 = false;
        if ((r114 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r114 & 8) == 0) goto L15;
        r103 = "";
    L15:
        if ((r114 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r114 & 32) == 0) goto L21;
        r110 = new LinkedHashMap();
    L21:
        if ((r114 & 64) == 0) goto L24;
        r111 = null;
    L24:
        if ((r114 & 128) == 0) goto L27;
        r112 = null;
    L27:
        if ((r114 & 256) == 0) goto L29;
        r113 = "";
    L29:
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r103, "text");
        Intrinsics.checkNotNullParameter(r110, "extraMap");
        Intrinsics.checkNotNullParameter(r113, "localId");
        this.f542534a = r100;
        this.f542535b = r101;
        this.f542536c = r102;
        this.f542537d = r103;
        this.f542538e = r104;
        this.f542539f = r110;
        this.f542540g = r111;
        this.f542541h = r112;
        this.f542542i = r113;
        if (r113.length() != 0) goto L32;
        boolean r106 = true;
    L33:
        if (r106 == true) goto L35;
        return;
    L35:
        if (r100.length() <= 0) goto L37;
        r105 = true;
    L37:
        if (r105 == false) goto L41;
        this.f542542i = r100;
        return;
    L41:
        return;
    L32:
        r106 = false;
        goto L33
    }
}
