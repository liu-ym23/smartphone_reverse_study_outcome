package com.ss.android.lark.chameleon;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0000J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chameleon/HostConfig;", "Ljava/io/Serializable;", "hostType", "", "bizDomainAlias", "constHosts", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getHostType", "()Ljava/lang/String;", "setHostType", "(Ljava/lang/String;)V", "getBizDomainAlias", "setBizDomainAlias", "getConstHosts", "()Ljava/util/ArrayList;", "setConstHosts", "(Ljava/util/ArrayList;)V", "copy", "toString", "component1", "component2", "component3", "equals", "", "other", "", "hashCode", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HostConfig implements Serializable {
    private String bizDomainAlias;
    private ArrayList<String> constHosts;
    private String hostType;

    public HostConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostConfig copy$default(HostConfig r100, String r101, String r102, ArrayList r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.hostType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.bizDomainAlias;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.constHosts;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.hostType;
    }

    public final String component2() {
        return this.bizDomainAlias;
    }

    public final ArrayList<String> component3() {
        return this.constHosts;
    }

    public final HostConfig copy(String r100, String r101, ArrayList<String> r102) {
        return new HostConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HostConfig) == true) goto L8;
        return false;
    L8:
        HostConfig r101 = (HostConfig) r100;
        if (Intrinsics.areEqual(this.hostType, r101.hostType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizDomainAlias, r101.bizDomainAlias) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.constHosts, r101.constHosts) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.hostType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bizDomainAlias;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ArrayList<String> r107 = this.constHosts;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final HostConfig copy() {
        String r100 = this.hostType;
        String r101 = this.bizDomainAlias;
        ArrayList<String> r102 = this.constHosts;
        if (r102 == null) goto L5;
        ArrayList r103 = new ArrayList(r102);
    L7:
        return new HostConfig(r100, r101, r103);
    L5:
        r103 = null;
        goto L7
    }

    public String toString() {
        return "HostConfig(hostType=" + this.hostType + ", bizDomainAlias=" + this.bizDomainAlias + ", constHosts=" + this.constHosts + ')';
    }

    public final String getBizDomainAlias() {
        return this.bizDomainAlias;
    }

    public final ArrayList<String> getConstHosts() {
        return this.constHosts;
    }

    public final String getHostType() {
        return this.hostType;
    }

    public final void setBizDomainAlias(String r100) {
        this.bizDomainAlias = r100;
    }

    public final void setConstHosts(ArrayList<String> r100) {
        this.constHosts = r100;
    }

    public final void setHostType(String r100) {
        this.hostType = r100;
    }

    public HostConfig(String r100, String r101, ArrayList<String> r102) {
        this.hostType = r100;
        this.bizDomainAlias = r101;
        this.constHosts = r102;
    }

    public /* synthetic */ HostConfig(String r100, String r101, ArrayList r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
