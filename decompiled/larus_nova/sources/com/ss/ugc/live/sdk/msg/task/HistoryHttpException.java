package com.ss.ugc.live.sdk.msg.task;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.i;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/ss/ugc/live/sdk/msg/task/HistoryHttpException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lvlc/i;", "listener", "Lvlc/i;", "getListener", "()Lvlc/i;", "", "cause", "<init>", "(Lvlc/i;Ljava/lang/Throwable;)V", "message_release"}, k = 1, mv = {1, 4, 0})
public final class HistoryHttpException extends Exception {
    private final i listener;

    public final i getListener() {
        return this.listener;
    }

    public HistoryHttpException(i r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Intrinsics.checkNotNullParameter(r101, "cause");
        super(r101);
        this.listener = r100;
    }
}
