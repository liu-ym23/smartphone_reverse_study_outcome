package io.ktor.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/serialization/JsonConvertException;", "Lio/ktor/serialization/ContentConvertException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ktor-serialization"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JsonConvertException extends ContentConvertException {
    public JsonConvertException(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100, r101);
    }

    public /* synthetic */ JsonConvertException(String r100, Throwable r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
