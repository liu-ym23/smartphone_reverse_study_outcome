package com.ss.android.lark.chameleonv2.lkapi.app;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$LarkletConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "data", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mainUrl", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "getData", "()Ljava/util/ArrayList;", "getMainUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IApp$LarkletConfig implements NonProguard {
    private final ArrayList<String> data;
    private final String mainUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IApp$LarkletConfig copy$default(IApp$LarkletConfig r100, ArrayList r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.mainUrl;
    L9:
        return r100.copy(r101, r102);
    }

    public final ArrayList<String> component1() {
        return this.data;
    }

    public final String component2() {
        return this.mainUrl;
    }

    public final IApp$LarkletConfig copy(ArrayList<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "mainUrl");
        return new IApp$LarkletConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IApp$LarkletConfig) == true) goto L8;
        return false;
    L8:
        IApp$LarkletConfig r101 = (IApp$LarkletConfig) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mainUrl, r101.mainUrl) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.mainUrl.hashCode();
    }

    public String toString() {
        return "LarkletConfig(data=" + this.data + ", mainUrl=" + this.mainUrl + ')';
    }

    public final ArrayList<String> getData() {
        return this.data;
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public IApp$LarkletConfig(ArrayList<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "mainUrl");
        this.data = r100;
        this.mainUrl = r101;
    }
}
