package com.bytedance.ee.bear.document.associateddocs.bean;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedCcmPluginInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "visible", "", "referenceExist", "<init>", "(ZLjava/lang/Boolean;)V", "getVisible", "()Z", "getReferenceExist", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(ZLjava/lang/Boolean;)Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedCcmPluginInfo;", "equals", "other", "", "hashCode", "", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedCcmPluginInfo implements NonProguard {

    @SerializedName("reference_exist")
    private final Boolean referenceExist;
    private final boolean visible;

    public AssociatedCcmPluginInfo() {
        Boolean r0 = null;
        boolean r2 = false;
        this(r2, r0, 3, r0);
    }

    public static /* synthetic */ AssociatedCcmPluginInfo copy$default(AssociatedCcmPluginInfo r0, boolean r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.visible;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.referenceExist;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.visible;
    }

    public final Boolean component2() {
        return this.referenceExist;
    }

    public final AssociatedCcmPluginInfo copy(boolean r2, Boolean r3) {
        return new AssociatedCcmPluginInfo(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AssociatedCcmPluginInfo) == true) goto L8;
        return false;
    L8:
        AssociatedCcmPluginInfo r6 = (AssociatedCcmPluginInfo) r5;
        if (this.visible == r6.visible) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.referenceExist, r6.referenceExist) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.visible == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        Boolean r2 = this.referenceExist;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "AssociatedCcmPluginInfo(visible=" + this.visible + ", referenceExist=" + this.referenceExist + ')';
    }

    public final Boolean getReferenceExist() {
        return this.referenceExist;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public AssociatedCcmPluginInfo(boolean r1, Boolean r2) {
        this.visible = r1;
        this.referenceExist = r2;
    }

    public /* synthetic */ AssociatedCcmPluginInfo(boolean r1, Boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = Boolean.FALSE;
    L8:
        this(r1, r2);
    }
}
