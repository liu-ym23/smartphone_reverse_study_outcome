package com.bytedance.caijing.sdk.infra.base.api.smart;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\bHÆ\u0003JC\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R \u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/smart/CJPaySmartConfig;", "Ljava/io/Serializable;", "scene", "", "systemPrompt", "inferenceParams", "", "timeout", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;J)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySmartConfig implements Serializable {
    public Map<String, String> inferenceParams;
    public String scene;
    public String systemPrompt;
    public long timeout;

    public CJPaySmartConfig() {
        this(null, null, null, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJPaySmartConfig copy$default(CJPaySmartConfig r100, String r101, String r102, Map r103, long r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.scene;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.systemPrompt;
    L8:
        String r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.inferenceParams;
    L11:
        Map r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.timeout;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.scene;
    }

    public final String component2() {
        return this.systemPrompt;
    }

    public final Map<String, String> component3() {
        return this.inferenceParams;
    }

    public final long component4() {
        return this.timeout;
    }

    public final CJPaySmartConfig copy(String r100, String r101, Map<String, String> r110, long r111) {
        return new CJPaySmartConfig(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPaySmartConfig) == true) goto L8;
        return false;
    L8:
        CJPaySmartConfig r101 = (CJPaySmartConfig) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.systemPrompt, r101.systemPrompt) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inferenceParams, r101.inferenceParams) == true) goto L18;
        return false;
    L18:
        if (this.timeout == r101.timeout) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.scene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.systemPrompt;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.inferenceParams;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        long r109 = this.timeout;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CJPaySmartConfig(scene=" + this.scene + ", systemPrompt=" + this.systemPrompt + ", inferenceParams=" + this.inferenceParams + ", timeout=" + this.timeout + ')';
    }

    public CJPaySmartConfig(String r100, String r101, Map<String, String> r102, long r103) {
        this.scene = r100;
        this.systemPrompt = r101;
        this.inferenceParams = r102;
        this.timeout = r103;
    }

    public /* synthetic */ CJPaySmartConfig(String r100, String r101, Map r102, long r103, int r104, DefaultConstructorMarker r105) {
        Map r106 = null;
        if ((r104 & 1) == 0) goto L5;
        String r107 = null;
    L7:
        if ((r104 & 2) == 0) goto L9;
        String r108 = null;
    L11:
        if ((r104 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r104 & 8) == 0) goto L17;
        r103 = 5000;
    L17:
        this(r107, r108, r106, r103);
        return;
    L9:
        r108 = r101;
        goto L11
    L5:
        r107 = r100;
        goto L7
    }
}
