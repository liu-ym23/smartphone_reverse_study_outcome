package com.bytedance.ee.bear.middleground.record.executor;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/middleground/record/executor/PrivacyResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "allowReadListSetting", "", "allowShowCollaboration", "<init>", "(ZZ)V", "getAllowReadListSetting", "()Z", "getAllowShowCollaboration", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "middleground-record-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrivacyResult implements NonProguard {
    private final boolean allowReadListSetting;
    private final boolean allowShowCollaboration;

    public static /* synthetic */ PrivacyResult copy$default(PrivacyResult r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.allowReadListSetting;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.allowShowCollaboration;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.allowReadListSetting;
    }

    public final boolean component2() {
        return this.allowShowCollaboration;
    }

    public final PrivacyResult copy(boolean r100, boolean r101) {
        return new PrivacyResult(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PrivacyResult) == true) goto L8;
        return false;
    L8:
        PrivacyResult r101 = (PrivacyResult) r100;
        if (this.allowReadListSetting == r101.allowReadListSetting) goto L12;
        return false;
    L12:
        if (this.allowShowCollaboration == r101.allowShowCollaboration) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.allowReadListSetting == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.allowShowCollaboration == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "PrivacyResult(allowReadListSetting=" + this.allowReadListSetting + ", allowShowCollaboration=" + this.allowShowCollaboration + ')';
    }

    public final boolean getAllowReadListSetting() {
        return this.allowReadListSetting;
    }

    public final boolean getAllowShowCollaboration() {
        return this.allowShowCollaboration;
    }

    public PrivacyResult(boolean r100, boolean r101) {
        this.allowReadListSetting = r100;
        this.allowShowCollaboration = r101;
    }
}
