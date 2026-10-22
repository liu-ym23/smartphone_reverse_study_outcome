package com.bytedance.lark.oggopus_rust_android;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JB\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/lark/oggopus_rust_android/InvokeHookInfo;", "", TextureRenderKeys.KEY_MODULE_NAME, "", "libraryId", "", "libId", "", "instance", "methodName", "(Ljava/lang/String;JILjava/lang/Long;Ljava/lang/String;)V", "getInstance", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLibId", "()I", "getLibraryId", "()J", "getMethodName", "()Ljava/lang/String;", "getModuleName", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;JILjava/lang/Long;Ljava/lang/String;)Lcom/bytedance/lark/oggopus_rust_android/InvokeHookInfo;", "equals", "", "other", "hashCode", "toString", "oggopus_rust_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InvokeHookInfo {
    private final Long instance;
    private final int libId;
    private final long libraryId;
    private final String methodName;
    private final String moduleName;

    public static /* synthetic */ InvokeHookInfo copy$default(InvokeHookInfo r100, String r101, long r102, int r103, Long r104, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.moduleName;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.libraryId;
    L8:
        long r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.libId;
    L11:
        int r113 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.instance;
    L14:
        Long r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.methodName;
    L17:
        String r107 = r101;
        return r100.copy(r107, r105, r113, r106, r110);
    }

    public final String component1() {
        return this.moduleName;
    }

    public final long component2() {
        return this.libraryId;
    }

    public final int component3() {
        return this.libId;
    }

    public final Long component4() {
        return this.instance;
    }

    public final String component5() {
        return this.methodName;
    }

    public final InvokeHookInfo copy(String r100, long r110, int r111, Long r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r113, "methodName");
        return new InvokeHookInfo(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InvokeHookInfo) == true) goto L8;
        return false;
    L8:
        InvokeHookInfo r101 = (InvokeHookInfo) r100;
        if (Intrinsics.areEqual(this.moduleName, r101.moduleName) == true) goto L12;
        return false;
    L12:
        if (this.libraryId == r101.libraryId) goto L15;
        return false;
    L15:
        if (this.libId == r101.libId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.instance, r101.instance) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.methodName, r101.methodName) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.moduleName.hashCode() * 31;
        long r101 = this.libraryId;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.libId) * 31;
        Long r103 = this.instance;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.methodName.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public String toString() {
        return "InvokeHookInfo(moduleName=" + this.moduleName + ", libraryId=" + this.libraryId + ", libId=" + this.libId + ", instance=" + this.instance + ", methodName=" + this.methodName + ')';
    }

    public final Long getInstance() {
        return this.instance;
    }

    public final int getLibId() {
        return this.libId;
    }

    public final long getLibraryId() {
        return this.libraryId;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public InvokeHookInfo(String r100, long r101, int r102, Long r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r104, "methodName");
        this.moduleName = r100;
        this.libraryId = r101;
        this.libId = r102;
        this.instance = r103;
        this.methodName = r104;
    }
}
