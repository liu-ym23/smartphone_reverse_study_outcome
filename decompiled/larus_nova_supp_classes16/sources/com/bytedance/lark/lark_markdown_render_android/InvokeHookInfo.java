package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JB\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/InvokeHookInfo;", "", "moduleName", "", "libraryId", "", "libId", "", "instance", "methodName", "(Ljava/lang/String;JILjava/lang/Long;Ljava/lang/String;)V", "getInstance", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLibId", "()I", "getLibraryId", "()J", "getMethodName", "()Ljava/lang/String;", "getModuleName", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;JILjava/lang/Long;Ljava/lang/String;)Lcom/bytedance/lark/lark_markdown_render_android/InvokeHookInfo;", "equals", "", "other", "hashCode", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InvokeHookInfo {
    private final Long instance;
    private final int libId;
    private final long libraryId;
    private final String methodName;
    private final String moduleName;

    public static /* synthetic */ InvokeHookInfo copy$default(InvokeHookInfo r4, String r5, long r6, int r8, Long r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.moduleName;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.libraryId;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.libId;
    L11:
        int r13 = r8;
        if ((r11 & 8) == 0) goto L14;
        r9 = r4.instance;
    L14:
        Long r2 = r9;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.methodName;
    L17:
        String r7 = r5;
        return r4.copy(r7, r0, r13, r2, r10);
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

    public final InvokeHookInfo copy(String r9, long r10, int r12, Long r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "moduleName");
        Intrinsics.checkNotNullParameter(r14, "methodName");
        return new InvokeHookInfo(r9, r10, r12, r13, r14);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof InvokeHookInfo) == true) goto L8;
        return false;
    L8:
        InvokeHookInfo r9 = (InvokeHookInfo) r8;
        if (Intrinsics.areEqual(this.moduleName, r9.moduleName) == true) goto L12;
        return false;
    L12:
        if (this.libraryId == r9.libraryId) goto L15;
        return false;
    L15:
        if (this.libId == r9.libId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.instance, r9.instance) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.methodName, r9.methodName) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.moduleName.hashCode() * 31;
        long r1 = this.libraryId;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.libId) * 31;
        Long r3 = this.instance;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return ((r2 + r4) * 31) + this.methodName.hashCode();
    L5:
        r4 = r3.hashCode();
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

    public InvokeHookInfo(String r2, long r3, int r5, Long r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "moduleName");
        Intrinsics.checkNotNullParameter(r7, "methodName");
        this.moduleName = r2;
        this.libraryId = r3;
        this.libId = r5;
        this.instance = r6;
        this.methodName = r7;
    }
}
