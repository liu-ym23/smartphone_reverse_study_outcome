package io.ktor.util.cio;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/util/cio/ChannelReadException;", "Lio/ktor/util/cio/ChannelIOException;", "message", "", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChannelReadException extends ChannelIOException {
    public ChannelReadException(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        super(r100, r101);
    }

    public /* synthetic */ ChannelReadException(String r100, Throwable r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L5;
        r100 = "Cannot read from a channel";
    L5:
        this(r100, r101);
    }
}
