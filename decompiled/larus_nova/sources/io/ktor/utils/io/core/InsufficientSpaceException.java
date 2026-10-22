package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0005\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u000f\u0012\b\b\u0002\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/utils/io/core/InsufficientSpaceException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "size", "", "availableSpace", "(II)V", "name", "", "(Ljava/lang/String;II)V", "", "(JJ)V", "message", "(Ljava/lang/String;)V", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InsufficientSpaceException extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public InsufficientSpaceException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public InsufficientSpaceException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
    }

    public InsufficientSpaceException(int r100, int r101) {
        this("Not enough free space to write " + r100 + " bytes, available " + r101 + " bytes.");
    }

    public InsufficientSpaceException(long r100, long r101) {
        this("Not enough free space to write " + r100 + " bytes, available " + r101 + " bytes.");
    }

    public InsufficientSpaceException(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this("Not enough free space to write " + r100 + " of " + r101 + " bytes, available " + r102 + " bytes.");
    }

    public /* synthetic */ InsufficientSpaceException(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "Not enough free space";
    L5:
        this(r100);
    }
}
