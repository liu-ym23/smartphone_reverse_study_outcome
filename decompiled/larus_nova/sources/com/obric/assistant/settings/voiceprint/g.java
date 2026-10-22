package com.obric.assistant.settings.voiceprint;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class g implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricVoicePrintManagementMainFragment f392448a;

    public /* synthetic */ g(ObricVoicePrintManagementMainFragment r100) {
        this.f392448a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        ObricVoicePrintManagementMainFragment r101 = this.f392448a;
        boolean r102 = ((Boolean) r100).booleanValue();
        CoroutineScope r103 = ObricVoicePrintManagementMainFragment.f392425l;
        if (r102 == false) goto L6;
        r101.ca0();
    L6:
        return Unit.INSTANCE;
    }
}
