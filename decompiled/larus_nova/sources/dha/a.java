package dha;

import com.obric.assistant.state.api.v2.core.bean.ObricState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {
    public static final boolean a(ObricState r100, ObricState r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L6;
    L14:
        return false;
    L6:
        if (r100.getCurrentIslandState() != r101.getCurrentIslandState()) goto L14;
        if (Intrinsics.areEqual(r100.getConversationId(), r101.getConversationId()) == false) goto L14;
        if (r100.getScene() != r101.getScene()) goto L14;
        if (Intrinsics.areEqual(r100.getExt(), r101.getExt()) == false) goto L14;
        return true;
    }
}
