package com.ss.android.lark.chameleonv2.lkapi.manifest;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$AllManifest;", "Lcom/bytedance/ee/util/io/NonProguard;", "globalManifest", "Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalManifest;", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalManifest;)V", "getGlobalManifest", "()Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalManifest;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IManifest$AllManifest implements NonProguard {
    private final IManifest$GlobalManifest globalManifest;

    public static /* synthetic */ IManifest$AllManifest copy$default(IManifest$AllManifest r100, IManifest$GlobalManifest r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.globalManifest;
    L6:
        return r100.copy(r101);
    }

    public final IManifest$GlobalManifest component1() {
        return this.globalManifest;
    }

    public final IManifest$AllManifest copy(IManifest$GlobalManifest r100) {
        Intrinsics.checkNotNullParameter(r100, "globalManifest");
        return new IManifest$AllManifest(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IManifest$AllManifest) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.globalManifest, ((IManifest$AllManifest) r100).globalManifest) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.globalManifest.hashCode();
    }

    public String toString() {
        return "AllManifest(globalManifest=" + this.globalManifest + ')';
    }

    public final IManifest$GlobalManifest getGlobalManifest() {
        return this.globalManifest;
    }

    public IManifest$AllManifest(IManifest$GlobalManifest r100) {
        Intrinsics.checkNotNullParameter(r100, "globalManifest");
        this.globalManifest = r100;
    }
}
