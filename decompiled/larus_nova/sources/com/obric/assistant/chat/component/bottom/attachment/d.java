package com.obric.assistant.chat.component.bottom.attachment;

import com.larus.platform.model.action.SuggestedActionScene;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class d implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConfigAttachmentPanelComponent f386700a;

    public /* synthetic */ d(ConfigAttachmentPanelComponent r100) {
        this.f386700a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        ConfigAttachmentPanelComponent r101 = this.f386700a;
        int r102 = ConfigAttachmentPanelComponent.A;
        Intrinsics.checkNotNullParameter((SuggestedActionScene) r100, "it");
        return Boolean.valueOf(!r101.L2());
    }
}
