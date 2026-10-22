package com.ss.android.lark.chameleonv2.lkapi.log;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/log/ILog$Internal$LogRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "level", "", "logModule", "", "message", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getLevel", "()I", "getLogModule", "()Ljava/lang/String;", "getMessage", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ILog$Internal$LogRequest implements NonProguard {
    private final int level;
    private final String logModule;
    private final String message;

    public static /* synthetic */ ILog$Internal$LogRequest copy$default(ILog$Internal$LogRequest r100, int r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.level;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.logModule;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.message;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.level;
    }

    public final String component2() {
        return this.logModule;
    }

    public final String component3() {
        return this.message;
    }

    public final ILog$Internal$LogRequest copy(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "message");
        return new ILog$Internal$LogRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ILog$Internal$LogRequest) == true) goto L8;
        return false;
    L8:
        ILog$Internal$LogRequest r101 = (ILog$Internal$LogRequest) r100;
        if (this.level == r101.level) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logModule, r101.logModule) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.level * 31;
        String r101 = this.logModule;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.message.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "LogRequest(level=" + this.level + ", logModule=" + this.logModule + ", message=" + this.message + ')';
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getLogModule() {
        return this.logModule;
    }

    public final String getMessage() {
        return this.message;
    }

    public ILog$Internal$LogRequest(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "message");
        this.level = r100;
        this.logModule = r101;
        this.message = r102;
    }
}
