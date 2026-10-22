package com.ss.android.ugc.aweme.live.alphaplayer.render;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/live/alphaplayer/render/LayerRenderException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "alpha_player_release"}, k = 1, mv = {1, 1, 16})
public final class LayerRenderException extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public LayerRenderException() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public LayerRenderException(String r100, Throwable r101) {
        super(r100, r101);
    }

    public /* synthetic */ LayerRenderException(String r100, Throwable r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
