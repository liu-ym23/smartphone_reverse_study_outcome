package com.larus.bmhome.interactionpanel;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainConversationInteractionPanelHostComponent f312449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f312450b;

    public /* synthetic */ z(MainConversationInteractionPanelHostComponent r100, String r101) {
        this.f312449a = r100;
        this.f312450b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainConversationInteractionPanelHostComponent r100 = this.f312449a;
        String r101 = this.f312450b;
        int r102 = MainConversationInteractionPanelHostComponent.f312292u;
        r100.getClass();
        com.larus.bmhome.chat.component.cvs.y r103 = (com.larus.bmhome.chat.component.cvs.y) s1a.d.a(r100).getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r103 == null) goto L5;
        String r104 = r103.Y1();
    L6:
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        if (StringsKt.isBlank(r104) == false) goto L12;
        FLogger.f375446a.d("InteractionPanelHost", "[" + r101 + "] skip bind, empty conversationId");
        return;
    L12:
        if (Intrinsics.areEqual(r100.f312297q, r104) == true) goto L14;
    L16:
        Job r105 = r100.f312296p;
        if (r105 == null) goto L19;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L19:
        r100.Y2().a(r100.f312298r, "conversation_scope_changed");
        r100.pC();
        r100.f312298r = null;
        r100.f312297q = r104;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.f312296p = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(r100, r100)), null, null, new MainConversationInteractionPanelHostComponent$bindConversationScope$1$1(r100, r104, null), 3, null);
        return;
    L14:
        if (r100.f312296p == null) goto L16;
        return;
    L5:
        r104 = null;
        goto L6
    }
}
