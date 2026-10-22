package com.obric.assistant.settings.autogui;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl", f = "ObricAutoGuiSettingsImpl.kt", i = {0}, l = {TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK}, m = "fetchCloudAppPolicy", n = {"accountScope"}, s = {"L$0"})
public final class ObricAutoGuiSettingsImpl$fetchCloudAppPolicy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$fetchCloudAppPolicy$1(ObricAutoGuiSettingsImpl r100, Continuation<? super ObricAutoGuiSettingsImpl$fetchCloudAppPolicy$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ObricAutoGuiSettingsImpl r101 = this.this$0;
        Set<String> r102 = ObricAutoGuiSettingsImpl.f391829i;
        return r101.o(null, this);
    }
}
