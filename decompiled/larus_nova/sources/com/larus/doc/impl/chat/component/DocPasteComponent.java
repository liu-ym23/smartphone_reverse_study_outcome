package com.larus.doc.impl.chat.component;

import com.larus.common.apphost.AppHost;
import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.larus.home.impl.sdk.i1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.ui.arch.component.external.api.Component;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import n39.l;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u00012\u00020\u0002:\u0001\u0007B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/doc/impl/chat/component/DocPasteComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/doc/impl/chat/ability/IDocPasteAbility;", "<init>", "()V", "pasteToDoc", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPasteComponent extends Component implements g39.b {

    public static final class a {
    }

    static {
    }

    @Override // g39.b
    public final void G10() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L17
        IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L17
        if (r101 == null) goto L7;
        r101.d0();     // Catch: Throwable -> L17
        i1 r102 = i1.f346188a;
        boolean r103 = r102.h(AppHost.f326268a.getApplication(), "bpea-ai-document");     // Catch: Throwable -> L17
    L8:
        if (r103 == false) goto L15;
        IDocSdkBaseService r104 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);     // Catch: Throwable -> L17
        if (r104 == null) goto L12;
        l r105 = r104.getPartialRewriteService();     // Catch: Throwable -> L17
    L13:
        if (r105 == null) goto L15;
        r105.handleActionBarPaste();     // Catch: Throwable -> L17
        goto L15
    L12:
        r105 = null;
    L15:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L7:
        r103 = false;
    L17:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public DocPasteComponent() {
    }
}
