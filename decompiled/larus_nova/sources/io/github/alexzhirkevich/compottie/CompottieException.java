package io.github.alexzhirkevich.compottie;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/github/alexzhirkevich/compottie/CompottieException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "compottie_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CompottieException extends Exception {
    public static final int $stable = 8;

    public CompottieException(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        super(r100, r101);
    }

    public /* synthetic */ CompottieException(String r100, Throwable r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
