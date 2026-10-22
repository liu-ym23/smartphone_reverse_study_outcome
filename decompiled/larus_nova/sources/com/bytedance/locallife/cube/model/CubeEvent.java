package com.bytedance.locallife.cube.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/locallife/cube/model/CubeEvent;", "", "name", "", "params", "Lorg/json/JSONObject;", "priority", "", "(Ljava/lang/String;Lorg/json/JSONObject;I)V", "getName", "()Ljava/lang/String;", "getParams", "()Lorg/json/JSONObject;", "getPriority", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CubeEvent {
    private final String name;
    private final JSONObject params;
    private final int priority;

    public static /* synthetic */ CubeEvent copy$default(CubeEvent r100, String r101, JSONObject r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.params;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.priority;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.name;
    }

    public final JSONObject component2() {
        return this.params;
    }

    public final int component3() {
        return this.priority;
    }

    public final CubeEvent copy(String r100, JSONObject r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new CubeEvent(r100, r101, r102);
    }

    public String toString() {
        return "CubeEvent(name=" + this.name + ", params=" + this.params + ", priority=" + this.priority + ')';
    }

    public int hashCode() {
        int r100 = this.name.hashCode() * 31;
        JSONObject r101 = this.params;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) * 31) + this.priority;
    L5:
        r102 = 0;
        goto L7
    }

    public final String getName() {
        return this.name;
    }

    public final JSONObject getParams() {
        return this.params;
    }

    public final int getPriority() {
        return this.priority;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(CubeEvent.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.locallife.cube.model.CubeEvent");
        CubeEvent r102 = (CubeEvent) r100;
        if (Intrinsics.areEqual(this.name, r102.name) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.params, r102.params) == true) goto L19;
        return false;
    L19:
        if (this.priority == r102.priority) goto L21;
        return false;
    L21:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public CubeEvent(String r100, JSONObject r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.name = r100;
        this.params = r101;
        this.priority = r102;
    }

    public /* synthetic */ CubeEvent(String r100, JSONObject r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = -1;
    L5:
        this(r100, r101, r102);
    }
}
