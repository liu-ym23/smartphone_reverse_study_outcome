package com.obric.capabilitykit.common;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/capabilitykit/common/Parameter;", "", "name", "", SocialConstants.PARAM_APP_DESC, "is_required", "", "type", "", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "getDesc", "()Ljava/lang/String;", "()Z", "getName", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Parameter {
    private final String desc;
    private final boolean is_required;
    private final String name;
    private final int type;

    public Parameter(String r100, String r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        this.name = r100;
        this.desc = r101;
        this.is_required = r102;
        this.type = r103;
    }

    public /* synthetic */ Parameter(String r100, String r101, boolean r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = 1;
    L8:
        this(r100, r101, r102, r103);
    }

    public static /* synthetic */ Parameter copy$default(Parameter r100, String r101, String r102, boolean r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.desc;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.is_required;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.type;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.desc;
    }

    public final boolean component3() {
        return this.is_required;
    }

    public final int component4() {
        return this.type;
    }

    public final Parameter copy(String r100, String r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        return new Parameter(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Parameter) == true) goto L8;
        return false;
    L8:
        Parameter r101 = (Parameter) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L15;
        return false;
    L15:
        if (this.is_required == r101.is_required) goto L18;
        return false;
    L18:
        if (this.type == r101.type) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        int r100 = ((this.name.hashCode() * 31) + this.desc.hashCode()) * 31;
        boolean r101 = this.is_required;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return ((r100 + r102) * 31) + this.type;
    }

    public final boolean is_required() {
        return this.is_required;
    }

    public String toString() {
        return "Parameter(name=" + this.name + ", desc=" + this.desc + ", is_required=" + this.is_required + ", type=" + this.type + ')';
    }
}
