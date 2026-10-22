package com.ss.android.lark.chameleonv2.lkapi.manifest;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J%\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tHÆ\u0003JI\u0010\u0012\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$InternalBaseProperty;", "Lcom/bytedance/ee/util/io/NonProguard;", "methods", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "methodInfos", "Ljava/util/HashMap;", "Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$MethodInfo;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/ArrayList;Ljava/util/HashMap;)V", "getMethods", "()Ljava/util/ArrayList;", "getMethodInfos", "()Ljava/util/HashMap;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IManifest$InternalBaseProperty implements NonProguard {
    private final HashMap<String, IManifest$MethodInfo> methodInfos;
    private final ArrayList<String> methods;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IManifest$InternalBaseProperty copy$default(IManifest$InternalBaseProperty r100, ArrayList r101, HashMap r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.methods;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.methodInfos;
    L9:
        return r100.copy(r101, r102);
    }

    public final ArrayList<String> component1() {
        return this.methods;
    }

    public final HashMap<String, IManifest$MethodInfo> component2() {
        return this.methodInfos;
    }

    public final IManifest$InternalBaseProperty copy(ArrayList<String> r100, HashMap<String, IManifest$MethodInfo> r101) {
        Intrinsics.checkNotNullParameter(r100, "methods");
        Intrinsics.checkNotNullParameter(r101, "methodInfos");
        return new IManifest$InternalBaseProperty(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IManifest$InternalBaseProperty) == true) goto L8;
        return false;
    L8:
        IManifest$InternalBaseProperty r101 = (IManifest$InternalBaseProperty) r100;
        if (Intrinsics.areEqual(this.methods, r101.methods) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.methodInfos, r101.methodInfos) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.methods.hashCode() * 31) + this.methodInfos.hashCode();
    }

    public String toString() {
        return "InternalBaseProperty(methods=" + this.methods + ", methodInfos=" + this.methodInfos + ')';
    }

    public final HashMap<String, IManifest$MethodInfo> getMethodInfos() {
        return this.methodInfos;
    }

    public final ArrayList<String> getMethods() {
        return this.methods;
    }

    public IManifest$InternalBaseProperty(ArrayList<String> r100, HashMap<String, IManifest$MethodInfo> r101) {
        Intrinsics.checkNotNullParameter(r100, "methods");
        Intrinsics.checkNotNullParameter(r101, "methodInfos");
        this.methods = r100;
        this.methodInfos = r101;
    }
}
