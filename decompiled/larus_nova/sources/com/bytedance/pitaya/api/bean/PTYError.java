package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYError;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "domain", "", "code", "", "subCode", "summary", "stacks", "", "(Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)V", "getCode", "()I", "getDomain", "()Ljava/lang/String;", "getStacks", "()Ljava/util/List;", "getSubCode", "getSummary", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PTYError implements ReflectionCall {
    private final int code;
    private final String domain;
    private final List<String> stacks;
    private final int subCode;
    private final String summary;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PTYError copy$default(PTYError r100, String r101, int r102, int r103, String r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.domain;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.code;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.subCode;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.summary;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.stacks;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.domain;
    }

    public final int component2() {
        return this.code;
    }

    public final int component3() {
        return this.subCode;
    }

    public final String component4() {
        return this.summary;
    }

    public final List<String> component5() {
        return this.stacks;
    }

    public final PTYError copy(String r100, int r101, int r110, String r111, List<String> r112) {
        return new PTYError(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PTYError) == true) goto L8;
        return false;
    L8:
        PTYError r101 = (PTYError) r100;
        if (Intrinsics.areEqual(this.domain, r101.domain) == true) goto L12;
        return false;
    L12:
        if (this.code == r101.code) goto L15;
        return false;
    L15:
        if (this.subCode == r101.subCode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.summary, r101.summary) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.stacks, r101.stacks) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.domain;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.code) * 31) + this.subCode) * 31;
        String r104 = this.summary;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.stacks;
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

    public String toString() {
        return "PTYError(domain=" + this.domain + ", code=" + this.code + ", subCode=" + this.subCode + ", summary=" + this.summary + ", stacks=" + this.stacks + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final List<String> getStacks() {
        return this.stacks;
    }

    public final int getSubCode() {
        return this.subCode;
    }

    public final String getSummary() {
        return this.summary;
    }

    public PTYError(String r100, int r101, int r102, String r103, List<String> r104) {
        this.domain = r100;
        this.code = r101;
        this.subCode = r102;
        this.summary = r103;
        this.stacks = r104;
    }
}
