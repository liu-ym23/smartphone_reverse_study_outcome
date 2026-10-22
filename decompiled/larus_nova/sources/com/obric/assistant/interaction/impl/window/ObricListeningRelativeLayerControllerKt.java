package com.obric.assistant.interaction.impl.window;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"shouldAllowListeningMainDraw", "", "expectsRelativeLayer", "expectedGeneration", "", "linkedGeneration", "(ZILjava/lang/Integer;)Z", "isExactLinkedSurface", "currentGeneration", "targetGeneration", "(ILjava/lang/Integer;I)Z", "impl_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ObricListeningRelativeLayerControllerKt {
    public static final boolean isExactLinkedSurface(int r100, Integer r101, int r102) {
        if (r100 != r102) goto L8;
        if (r101 == null) goto L8;
        if (r101.intValue() != r102) goto L8;
        return true;
    L8:
        return false;
    }

    public static final boolean shouldAllowListeningMainDraw(boolean r100, int r101, Integer r102) {
        if (r100 == false) goto L10;
        if (r101 < 0) goto L9;
        if (r102 == null) goto L9;
        if (r102.intValue() == r101) goto L10;
    L9:
        return false;
    L10:
        return true;
    }
}
