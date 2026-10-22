package com.ss.android.lark.chameleonv2.lkapi.resource;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0006\u0012\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b`\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J%\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0003J%\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b`\u0006HÆ\u0003J_\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00062$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b`\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$KaConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "featureSwitch", "", "i18n", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "resource", "", "<init>", "(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getFeatureSwitch", "()Ljava/lang/String;", "getI18n", "()Ljava/util/HashMap;", "getResource", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IResource$Internal$KaConfig implements NonProguard {
    private final String featureSwitch;
    private final HashMap<String, String> i18n;
    private final HashMap<String, Boolean> resource;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IResource$Internal$KaConfig copy$default(IResource$Internal$KaConfig r100, String r101, HashMap r102, HashMap r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.featureSwitch;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.i18n;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.resource;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.featureSwitch;
    }

    public final HashMap<String, String> component2() {
        return this.i18n;
    }

    public final HashMap<String, Boolean> component3() {
        return this.resource;
    }

    public final IResource$Internal$KaConfig copy(String r100, HashMap<String, String> r101, HashMap<String, Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "featureSwitch");
        Intrinsics.checkNotNullParameter(r101, "i18n");
        Intrinsics.checkNotNullParameter(r102, "resource");
        return new IResource$Internal$KaConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IResource$Internal$KaConfig) == true) goto L8;
        return false;
    L8:
        IResource$Internal$KaConfig r101 = (IResource$Internal$KaConfig) r100;
        if (Intrinsics.areEqual(this.featureSwitch, r101.featureSwitch) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.i18n, r101.i18n) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.resource, r101.resource) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.featureSwitch.hashCode() * 31) + this.i18n.hashCode()) * 31) + this.resource.hashCode();
    }

    public String toString() {
        return "KaConfig(featureSwitch=" + this.featureSwitch + ", i18n=" + this.i18n + ", resource=" + this.resource + ')';
    }

    public final String getFeatureSwitch() {
        return this.featureSwitch;
    }

    public final HashMap<String, String> getI18n() {
        return this.i18n;
    }

    public final HashMap<String, Boolean> getResource() {
        return this.resource;
    }

    public IResource$Internal$KaConfig(String r100, HashMap<String, String> r101, HashMap<String, Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "featureSwitch");
        Intrinsics.checkNotNullParameter(r101, "i18n");
        Intrinsics.checkNotNullParameter(r102, "resource");
        this.featureSwitch = r100;
        this.i18n = r101;
        this.resource = r102;
    }
}
