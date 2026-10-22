package com.obric.assistant.settings.voiceprint;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class v implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricVoicePrintManagementMainFragment f392482a;

    public /* synthetic */ v(ObricVoicePrintManagementMainFragment r100) {
        this.f392482a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        ObricVoicePrintManagementMainFragment r101 = this.f392482a;
        if (((Boolean) r100).booleanValue() == false) goto L6;
        CoroutineScope r102 = ObricVoicePrintManagementMainFragment.f392425l;
        r101.ca0();
    L6:
        return Unit.INSTANCE;
    }
}
