package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/localfileblock/remote/PcRemoteFileException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "kind", "Lcom/larus/bmhome/chat/standarduikit/localfileblock/remote/PcRemoteFileError;", "code", "", "<init>", "(Lcom/larus/bmhome/chat/standarduikit/localfileblock/remote/PcRemoteFileError;Ljava/lang/Integer;)V", "getKind", "()Lcom/larus/bmhome/chat/standarduikit/localfileblock/remote/PcRemoteFileError;", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcRemoteFileException extends Exception {
    private final Integer code;
    private final PcRemoteFileError kind;

    public final Integer getCode() {
        return this.code;
    }

    public final PcRemoteFileError getKind() {
        return this.kind;
    }

    public PcRemoteFileException(PcRemoteFileError r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.name());
        r102.append(':');
        if (r101 == null) goto L5;
        int r103 = r101.intValue();
    L6:
        r102.append(r103);
        super(r102.toString());
        this.kind = r100;
        this.code = r101;
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public /* synthetic */ PcRemoteFileException(PcRemoteFileError r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
