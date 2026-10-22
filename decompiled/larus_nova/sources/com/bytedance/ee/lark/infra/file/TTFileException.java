package com.bytedance.ee.lark.infra.file;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/lark/infra/file/TTFileException;", "Ljava/lang/RuntimeException;", "ttFileError", "Lcom/bytedance/ee/lark/infra/file/TTFileError;", "ttFile", "Lcom/bytedance/ee/lark/infra/file/TTFile;", "cause", "", "<init>", "(Lcom/bytedance/ee/lark/infra/file/TTFileError;Lcom/bytedance/ee/lark/infra/file/TTFile;Ljava/lang/Throwable;)V", "getTtFileError", "()Lcom/bytedance/ee/lark/infra/file/TTFileError;", "getTtFile", "()Lcom/bytedance/ee/lark/infra/file/TTFile;", "toString", "", "eco-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TTFileException extends RuntimeException {
    private final TTFile ttFile;
    private final TTFileError ttFileError;

    public TTFileException(TTFileError r100) {
        Intrinsics.checkNotNullParameter(r100, "ttFileError");
        this(r100, null, null, 6, null);
    }

    public TTFileException(TTFileError r100, TTFile r101) {
        Intrinsics.checkNotNullParameter(r100, "ttFileError");
        this(r100, r101, null, 4, null);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "TTFileException(ttFileError=" + this.ttFileError + ", ttFile=" + this.ttFile + ')';
    }

    public final TTFile getTtFile() {
        return this.ttFile;
    }

    public final TTFileError getTtFileError() {
        return this.ttFileError;
    }

    public TTFileException(TTFileError r100, TTFile r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "ttFileError");
        super(r102);
        this.ttFileError = r100;
        this.ttFile = r101;
    }

    public /* synthetic */ TTFileException(TTFileError r100, TTFile r101, Throwable r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
