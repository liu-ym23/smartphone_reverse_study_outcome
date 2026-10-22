package com.ss.android.lark.chameleonv2.lkapi.app;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Internal$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "locale", "", "name", "paths", "Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Internal$Paths;", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Internal$Paths;Ljava/lang/String;)V", "getLocale", "()Ljava/lang/String;", "getName", "getPaths", "()Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Internal$Paths;", "getVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IApp$Internal$Property implements NonProguard {
    private final String locale;
    private final String name;
    private final IApp$Internal$Paths paths;
    private final String version;

    public static /* synthetic */ IApp$Internal$Property copy$default(IApp$Internal$Property r100, String r101, String r102, IApp$Internal$Paths r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.locale;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.name;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.paths;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.version;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.locale;
    }

    public final String component2() {
        return this.name;
    }

    public final IApp$Internal$Paths component3() {
        return this.paths;
    }

    public final String component4() {
        return this.version;
    }

    public final IApp$Internal$Property copy(String r100, String r101, IApp$Internal$Paths r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "locale");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "paths");
        Intrinsics.checkNotNullParameter(r103, "version");
        return new IApp$Internal$Property(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IApp$Internal$Property) == true) goto L8;
        return false;
    L8:
        IApp$Internal$Property r101 = (IApp$Internal$Property) r100;
        if (Intrinsics.areEqual(this.locale, r101.locale) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.paths, r101.paths) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.locale.hashCode() * 31) + this.name.hashCode()) * 31) + this.paths.hashCode()) * 31) + this.version.hashCode();
    }

    public String toString() {
        return "Property(locale=" + this.locale + ", name=" + this.name + ", paths=" + this.paths + ", version=" + this.version + ')';
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getName() {
        return this.name;
    }

    public final IApp$Internal$Paths getPaths() {
        return this.paths;
    }

    public final String getVersion() {
        return this.version;
    }

    public IApp$Internal$Property(String r100, String r101, IApp$Internal$Paths r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "locale");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "paths");
        Intrinsics.checkNotNullParameter(r103, "version");
        this.locale = r100;
        this.name = r101;
        this.paths = r102;
        this.version = r103;
    }
}
