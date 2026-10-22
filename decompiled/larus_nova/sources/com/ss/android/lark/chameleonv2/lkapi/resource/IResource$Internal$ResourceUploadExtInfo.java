package com.ss.android.lark.chameleonv2.lkapi.resource;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$ResourceUploadExtInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "driveExtra", "", "", "<init>", "(Ljava/util/Map;)V", "getDriveExtra", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IResource$Internal$ResourceUploadExtInfo implements NonProguard {
    private final Map<String, String> driveExtra;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IResource$Internal$ResourceUploadExtInfo copy$default(IResource$Internal$ResourceUploadExtInfo r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.driveExtra;
    L6:
        return r100.copy(r101);
    }

    public final Map<String, String> component1() {
        return this.driveExtra;
    }

    public final IResource$Internal$ResourceUploadExtInfo copy(Map<String, String> r100) {
        return new IResource$Internal$ResourceUploadExtInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IResource$Internal$ResourceUploadExtInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.driveExtra, ((IResource$Internal$ResourceUploadExtInfo) r100).driveExtra) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Map<String, String> r100 = this.driveExtra;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "ResourceUploadExtInfo(driveExtra=" + this.driveExtra + ')';
    }

    public final Map<String, String> getDriveExtra() {
        return this.driveExtra;
    }

    public IResource$Internal$ResourceUploadExtInfo(Map<String, String> r100) {
        this.driveExtra = r100;
    }
}
