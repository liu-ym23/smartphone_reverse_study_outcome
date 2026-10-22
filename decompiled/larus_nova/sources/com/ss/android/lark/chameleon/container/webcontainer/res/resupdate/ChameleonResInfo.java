package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0010J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResInfo;", "", "revision", "", "version", "(Ljava/lang/String;Ljava/lang/String;)V", "getRevision", "()Ljava/lang/String;", "setRevision", "(Ljava/lang/String;)V", "getVersion", "setVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isEmpty", "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonResInfo {
    private String revision;
    private String version;

    /* JADX WARN: Multi-variable type inference failed */
    public ChameleonResInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ChameleonResInfo copy$default(ChameleonResInfo r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.revision;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.version;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.revision;
    }

    public final String component2() {
        return this.version;
    }

    public final ChameleonResInfo copy(String r100, String r101) {
        return new ChameleonResInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChameleonResInfo) == true) goto L8;
        return false;
    L8:
        ChameleonResInfo r101 = (ChameleonResInfo) r100;
        if (Intrinsics.areEqual(this.revision, r101.revision) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.revision;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.version;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ChameleonResInfo(revision=" + this.revision + ", version=" + this.version + ')';
    }

    public final boolean isEmpty() {
        if (TextUtils.isEmpty(this.revision) == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.version) == false) goto L7;
        return true;
    }

    public final String getRevision() {
        return this.revision;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setRevision(String r100) {
        this.revision = r100;
    }

    public final void setVersion(String r100) {
        this.version = r100;
    }

    public ChameleonResInfo(String r100, String r101) {
        this.revision = r100;
        this.version = r101;
    }

    public /* synthetic */ ChameleonResInfo(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
