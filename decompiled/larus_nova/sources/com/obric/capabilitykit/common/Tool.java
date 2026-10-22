package com.obric.capabilitykit.common;

import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/Tool;", "", "name", "", SocialConstants.PARAM_APP_DESC, "register2cloud", "", "params", "", "Lcom/obric/capabilitykit/common/Parameter;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getDesc", "()Ljava/lang/String;", "getName", "getParams", "()Ljava/util/List;", "getRegister2cloud", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Tool {
    private final String desc;
    private final String name;
    private final List<Parameter> params;
    private final boolean register2cloud;

    public Tool(String r100, String r101, boolean r102, List<Parameter> r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r103, "params");
        this.name = r100;
        this.desc = r101;
        this.register2cloud = r102;
        this.params = r103;
    }

    public /* synthetic */ Tool(String r100, String r101, boolean r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = new ArrayList();
    L8:
        this(r100, r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tool copy$default(Tool r100, String r101, String r102, boolean r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.desc;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.register2cloud;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.params;
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
        return this.register2cloud;
    }

    public final List<Parameter> component4() {
        return this.params;
    }

    public final Tool copy(String r100, String r101, boolean r102, List<Parameter> r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r103, "params");
        return new Tool(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Tool) == true) goto L8;
        return false;
    L8:
        Tool r101 = (Tool) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L15;
        return false;
    L15:
        if (this.register2cloud == r101.register2cloud) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L20;
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

    public final List<Parameter> getParams() {
        return this.params;
    }

    public final boolean getRegister2cloud() {
        return this.register2cloud;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int r100 = ((this.name.hashCode() * 31) + this.desc.hashCode()) * 31;
        boolean r101 = this.register2cloud;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return ((r100 + r102) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "Tool(name=" + this.name + ", desc=" + this.desc + ", register2cloud=" + this.register2cloud + ", params=" + this.params + ')';
    }
}
