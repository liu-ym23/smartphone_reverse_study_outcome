package com.obric.assistant.chat.component.bottom.core;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/chat/component/bottom/core/ObricCoreInputExComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/chat/input/IObricCoreInputAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "setEnabled", "", "enabled", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricCoreInputExComponent extends ComponentFeature implements paa.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f386740h;

    public ObricCoreInputExComponent() {
        this.f386740h = LazyKt.lazy(new t(this));
    }

    @Override // paa.b
    public final void setEnabled(boolean r100) {
        ICoreInputAbility r101 = (ICoreInputAbility) this.f386740h.getValue();
        if (r101 == null) goto L6;
        r101.setEnabled(true);
        return;
    }
}
