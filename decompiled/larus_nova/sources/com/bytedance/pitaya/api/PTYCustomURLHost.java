package com.bytedance.pitaya.api;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/pitaya/api/PTYCustomURLHost;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "urlHost", "", "authURLHost", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthURLHost", "()Ljava/lang/String;", "getUrlHost", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PTYCustomURLHost implements ReflectionCall {
    private final String authURLHost;
    private final String urlHost;

    public static /* synthetic */ PTYCustomURLHost copy$default(PTYCustomURLHost r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.urlHost;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.authURLHost;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.urlHost;
    }

    public final String component2() {
        return this.authURLHost;
    }

    public final PTYCustomURLHost copy(String r100, String r101) {
        return new PTYCustomURLHost(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PTYCustomURLHost) == true) goto L8;
        return false;
    L8:
        PTYCustomURLHost r101 = (PTYCustomURLHost) r100;
        if (Intrinsics.areEqual(this.urlHost, r101.urlHost) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.authURLHost, r101.authURLHost) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.urlHost;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.authURLHost;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PTYCustomURLHost(urlHost=" + this.urlHost + ", authURLHost=" + this.authURLHost + ')';
    }

    public final String getAuthURLHost() {
        return this.authURLHost;
    }

    public final String getUrlHost() {
        return this.urlHost;
    }

    public PTYCustomURLHost(String r100, String r101) {
        this.urlHost = r100;
        this.authURLHost = r101;
    }
}
