package com.larus.bmhome.chat.component.cloud;

import com.larus.network.http.d;
import com.larus.network.http.e;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import pd8.a;
import va8.o;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/component/cloud/CloudTestInputComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "<init>", "()V", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "Lkotlin/Lazy;", "onParentViewCreated", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloudTestInputComponent extends ComponentFeature {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f300573h;

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        FLogger r100 = FLogger.f375446a;
        String r101 = d.f360140a;
        StringBuilder r102 = new StringBuilder("disableInputText = ");
        e r103 = d.f360147h;
        if (r103 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r103.f360154e);
    L6:
        r102.append(r104);
        r100.i("CloudTest", r102.toString());
        e r105 = d.f360147h;
        boolean r106 = false;
        if (r105 != null) goto L9;
    L11:
        if (r106 == false) goto L16;
        o r107 = (o) this.f300573h.getValue();
        if (r107 == null) goto L17;
        r107.setVisibility(8);
        return;
    L17:
        return;
    L16:
        return;
    L9:
        if (r105.f360154e != true) goto L11;
        r106 = true;
        goto L11
    L5:
        r104 = null;
        goto L6
    }

    public CloudTestInputComponent() {
        this.f300573h = LazyKt.lazy(new a(this));
    }
}
