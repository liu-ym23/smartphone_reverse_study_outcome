package com.ss.android.lark.chameleonv2.lkapi.manifest;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0016\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J<\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ManifestUpdateDetail;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "data", "moduleType", "Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ModuleType;", "needVerifyUserId", "", "userId", "", "<init>", "(Ljava/io/Serializable;Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ModuleType;ZLjava/lang/String;)V", "getData", "()Ljava/io/Serializable;", "Ljava/io/Serializable;", "getModuleType", "()Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ModuleType;", "getNeedVerifyUserId", "()Z", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/io/Serializable;Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ModuleType;ZLjava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ManifestUpdateDetail;", "equals", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IManifest$Ipc$ManifestUpdateDetail<T extends Serializable> implements NonProguard {
    private final T data;
    private final IManifest$Ipc$ModuleType moduleType;
    private final boolean needVerifyUserId;
    private final String userId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IManifest$Ipc$ManifestUpdateDetail copy$default(IManifest$Ipc$ManifestUpdateDetail r100, Serializable r101, IManifest$Ipc$ModuleType r102, boolean r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.moduleType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.needVerifyUserId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.userId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final T component1() {
        return this.data;
    }

    public final IManifest$Ipc$ModuleType component2() {
        return this.moduleType;
    }

    public final boolean component3() {
        return this.needVerifyUserId;
    }

    public final String component4() {
        return this.userId;
    }

    public final IManifest$Ipc$ManifestUpdateDetail<T> copy(T r100, IManifest$Ipc$ModuleType r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "moduleType");
        Intrinsics.checkNotNullParameter(r103, "userId");
        return new IManifest$Ipc$ManifestUpdateDetail(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IManifest$Ipc$ManifestUpdateDetail) == true) goto L8;
        return false;
    L8:
        IManifest$Ipc$ManifestUpdateDetail r101 = (IManifest$Ipc$ManifestUpdateDetail) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (this.moduleType == r101.moduleType) goto L15;
        return false;
    L15:
        if (this.needVerifyUserId == r101.needVerifyUserId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.data.hashCode() * 31) + this.moduleType.hashCode()) * 31;
        if (this.needVerifyUserId == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.userId.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "ManifestUpdateDetail(data=" + this.data + ", moduleType=" + this.moduleType + ", needVerifyUserId=" + this.needVerifyUserId + ", userId=" + this.userId + ')';
    }

    public final T getData() {
        return this.data;
    }

    public final IManifest$Ipc$ModuleType getModuleType() {
        return this.moduleType;
    }

    public final boolean getNeedVerifyUserId() {
        return this.needVerifyUserId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public IManifest$Ipc$ManifestUpdateDetail(T r100, IManifest$Ipc$ModuleType r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "moduleType");
        Intrinsics.checkNotNullParameter(r103, "userId");
        this.data = r100;
        this.moduleType = r101;
        this.needVerifyUserId = r102;
        this.userId = r103;
    }
}
