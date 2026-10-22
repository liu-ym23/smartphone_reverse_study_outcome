package com.obric.livecard.api.exception;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/livecard/api/exception/IslandNotInitializedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IslandNotInitializedException extends RuntimeException {
    public IslandNotInitializedException() {
        super("This method must be called only after ILiveCard.inst.init has been invoked");
    }
}
