package com.bytedance.ee.bear.middleground.record.executor;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/middleground/record/executor/PrivacyResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "allowReadListSetting", "", "allowShowCollaboration", "<init>", "(ZZ)V", "getAllowReadListSetting", "()Z", "getAllowShowCollaboration", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "middleground-record-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrivacyResult implements NonProguard {
    private final boolean allowReadListSetting;
    private final boolean allowShowCollaboration;

    public static /* synthetic */ PrivacyResult copy$default(PrivacyResult r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.allowReadListSetting;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.allowShowCollaboration;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.allowReadListSetting;
    }

    public final boolean component2() {
        return this.allowShowCollaboration;
    }

    public final PrivacyResult copy(boolean r2, boolean r3) {
        return new PrivacyResult(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PrivacyResult) == true) goto L8;
        return false;
    L8:
        PrivacyResult r6 = (PrivacyResult) r5;
        if (this.allowReadListSetting == r6.allowReadListSetting) goto L12;
        return false;
    L12:
        if (this.allowShowCollaboration == r6.allowShowCollaboration) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.allowReadListSetting == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.allowShowCollaboration == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
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

    public PrivacyResult(boolean r1, boolean r2) {
        this.allowReadListSetting = r1;
        this.allowShowCollaboration = r2;
    }
}
