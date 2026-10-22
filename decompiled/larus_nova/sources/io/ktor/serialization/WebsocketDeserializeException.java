package io.ktor.serialization;

import io.ktor.websocket.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lio/ktor/serialization/WebsocketDeserializeException;", "Lio/ktor/serialization/WebsocketContentConvertException;", "Lio/ktor/websocket/c;", "frame", "Lio/ktor/websocket/c;", "getFrame", "()Lio/ktor/websocket/c;", "", "message", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Lio/ktor/websocket/c;)V", "ktor-serialization"}, k = 1, mv = {1, 8, 0})
public final class WebsocketDeserializeException extends WebsocketContentConvertException {
    private final c frame;

    public final c getFrame() {
        return this.frame;
    }

    public WebsocketDeserializeException(String r100, Throwable r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r102, "frame");
        super(r100, r101);
        this.frame = r102;
    }

    public /* synthetic */ WebsocketDeserializeException(String r100, Throwable r101, c r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, r102);
    }
}
