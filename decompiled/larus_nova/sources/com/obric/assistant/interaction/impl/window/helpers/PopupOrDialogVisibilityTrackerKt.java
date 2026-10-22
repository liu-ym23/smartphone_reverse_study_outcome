package com.obric.assistant.interaction.impl.window.helpers;

import androidx.fragment.app.FragmentActivity;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"getMainBotVContext", "Lcom/larus/ui/arch/context/external/VContext;", "Landroidx/fragment/app/FragmentActivity;", "impl_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PopupOrDialogVisibilityTrackerKt {
    public static final t1a.b getMainBotVContext(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ObricChatContextServiceDelegate r101 = ObricChatContextServiceDelegate.f386558b;
        if (r101.c(r100) == true) goto L7;
        return null;
    L7:
        return r101.b(r100);
    }
}
