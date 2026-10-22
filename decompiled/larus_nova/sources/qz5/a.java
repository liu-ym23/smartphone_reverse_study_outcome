package qz5;

import java.util.Arrays;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f535345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f535346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f535347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f535348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f535349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f535350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f535351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f535352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f535353i;

    public a() {
        throw null;
    }

    public final String toString() {
        return "SensitiveApiConfig(id=" + this.f535345a + ", abstractOfApi=" + this.f535346b + ", resourceName=" + this.f535347c + ", resourceId=" + this.f535348d + ", permissions=" + Arrays.toString(this.f535349e) + ", permissionMode=" + this.f535350f + ", isCustomApi=" + this.f535351g + ", dataTypes=" + this.f535352h + ", invokeType=" + this.f535353i + ")";
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f535345a * 31) + this.f535346b.hashCode()) * 31) + this.f535347c.hashCode()) * 31) + this.f535348d.hashCode()) * 31) + Arrays.hashCode(this.f535349e)) * 31) + this.f535350f) * 31;
        if (this.f535351g == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f535352h.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L39;
        a r102 = (a) r100;
        if (this.f535345a == r102.f535345a) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.f535346b, r102.f535346b)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.f535347c, r102.f535347c)) == false) goto L23;
        return false;
    L23:
        if ((!Intrinsics.areEqual(this.f535348d, r102.f535348d)) == false) goto L26;
        return false;
    L26:
        if (Arrays.equals(this.f535349e, r102.f535349e) == true) goto L29;
        return false;
    L29:
        if (this.f535350f == r102.f535350f) goto L32;
        return false;
    L32:
        if (this.f535351g == r102.f535351g) goto L35;
        return false;
    L35:
        if ((!Intrinsics.areEqual(this.f535352h, r102.f535352h)) == false) goto L37;
        return false;
    L37:
        return true;
    L39:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.sdk.config.SensitiveApiConfig");
    L8:
        r101 = null;
        goto L10
    }

    public a(int r100, String r101, String r102, String r103, String[] r104, int r105, List r106, String r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r111 & 4) == 0) goto L9;
        r102 = "";
    L9:
        if ((r111 & 8) == 0) goto L12;
        r103 = "";
    L12:
        if ((r111 & 16) == 0) goto L15;
        r104 = new String[0];
    L15:
        if ((r111 & 32) == 0) goto L18;
        r105 = 0;
    L18:
        if ((r111 & 128) == 0) goto L21;
        r106 = CollectionsKt.emptyList();
    L21:
        if ((r111 & 256) == 0) goto L23;
        r110 = "before";
    L23:
        this.f535345a = r100;
        this.f535346b = r101;
        this.f535347c = r102;
        this.f535348d = r103;
        this.f535349e = r104;
        this.f535350f = r105;
        this.f535351g = false;
        this.f535352h = r106;
        this.f535353i = r110;
    }
}
