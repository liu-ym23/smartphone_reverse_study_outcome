package com.ss.android.lark.chameleonv2.lkapi.env;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Internal$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "isLarkAPITestEnabled", "", "reportAPIStatInterval", "", "<init>", "(ZI)V", "()Z", "getReportAPIStatInterval", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IEnv$Internal$Property implements NonProguard {
    private final boolean isLarkAPITestEnabled;
    private final int reportAPIStatInterval;

    public static /* synthetic */ IEnv$Internal$Property copy$default(IEnv$Internal$Property r100, boolean r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isLarkAPITestEnabled;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.reportAPIStatInterval;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.isLarkAPITestEnabled;
    }

    public final int component2() {
        return this.reportAPIStatInterval;
    }

    public final IEnv$Internal$Property copy(boolean r100, int r101) {
        return new IEnv$Internal$Property(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IEnv$Internal$Property) == true) goto L8;
        return false;
    L8:
        IEnv$Internal$Property r101 = (IEnv$Internal$Property) r100;
        if (this.isLarkAPITestEnabled == r101.isLarkAPITestEnabled) goto L12;
        return false;
    L12:
        if (this.reportAPIStatInterval == r101.reportAPIStatInterval) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.isLarkAPITestEnabled == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.reportAPIStatInterval;
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "Property(isLarkAPITestEnabled=" + this.isLarkAPITestEnabled + ", reportAPIStatInterval=" + this.reportAPIStatInterval + ')';
    }

    public final int getReportAPIStatInterval() {
        return this.reportAPIStatInterval;
    }

    @JSONField(name = "isLarkAPITestEnabled")
    public final boolean isLarkAPITestEnabled() {
        return this.isLarkAPITestEnabled;
    }

    public IEnv$Internal$Property(boolean r100, int r101) {
        this.isLarkAPITestEnabled = r100;
        this.reportAPIStatInterval = r101;
    }
}
