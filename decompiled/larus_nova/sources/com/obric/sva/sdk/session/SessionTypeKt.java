package com.obric.sva.sdk.session;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"str", "", "Lcom/obric/sva/sdk/session/SessionType;", "libs_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SessionTypeKt {
    public static final String str(SessionType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return "[" + r100.getTag() + "]==>";
    }
}
