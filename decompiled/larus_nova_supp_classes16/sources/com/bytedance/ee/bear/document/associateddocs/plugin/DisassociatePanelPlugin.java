package com.bytedance.ee.bear.document.associateddocs.plugin;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.event.IEventPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0006\u0010\u0015\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/plugin/DisassociatePanelPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "creator", "Lcom/bytedance/ee/bear/document/dialog/RightTopMoreDialogCreator;", "mOnDeleteListener", "Lcom/bytedance/ee/bear/document/event/IEventPlugin$OnDeleteListener;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToUIContainer", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "showDisassociateMoreDialog", "disassociateExitingDoc", "DisassociatePanelHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DisassociatePanelPlugin extends DocumentPluginV2 {
    private final r05.b creator;
    private final IEventPlugin.a mOnDeleteListener;

    public final class a implements i<Unit> {
        public final /* synthetic */ DisassociatePanelPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(DisassociatePanelPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            Unit r3 = (Unit) r1;
            DisassociatePanelPlugin.access$showDisassociateMoreDialog(this.a);
        }
    }

    public static final class b implements IEventPlugin.a {
        public final /* synthetic */ DisassociatePanelPlugin a;

        public static final class a implements Runnable {
            public final /* synthetic */ DisassociatePanelPlugin a;

            public a(DisassociatePanelPlugin r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DisassociatePanelPlugin.access$getCreator$p(this.a).a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(DisassociatePanelPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.event.IEventPlugin.a
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            j.c(new a(this.a));
        }
    }

    public static final class c implements r05.a.InterfaceC0278a {
        public final /* synthetic */ DisassociatePanelPlugin a;

        @Override // r05.a.InterfaceC0278a
        public final void onClick() {
            this.a.disassociateExitingDoc();
        }

        public c(DisassociatePanelPlugin r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DisassociatePanelPlugin() {
        this.creator = new r05.b();
        this.mOnDeleteListener = new b(this);
    }

    private final void showDisassociateMoreDialog() {
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L6;
        int r1 = r05.a.a;
        r05.a.b.a(getContext(), r0.getToken(), r0.getDocumentTypeValue(), new c(this));
        return;
    }

    public final void disassociateExitingDoc() {
        PluginHost r0 = getHost();
        if (r0 == null) goto L5;
        e05.a r1 = (e05.a) r0.getHostAbility(e05.a.class);
    L6:
        if (r1 == null) goto L9;
        r1.disassociateExitingDoc();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ r05.b access$getCreator$p(DisassociatePanelPlugin r0) {
        return r0.creator;
    }

    public static final /* synthetic */ void access$showDisassociateMoreDialog(DisassociatePanelPlugin r0) {
        r0.showDisassociateMoreDialog();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put("biz.associateapp.showDisassociateMoreDialog", new a(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        IEventPlugin r3 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r3 == null) goto L6;
        r3.addDeleteListener(this.mOnDeleteListener);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r3, t r4) {
        IEventPlugin r0 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r0 == null) goto L5;
        r0.removeDeleteListener(this.mOnDeleteListener);
    L5:
        super.onDetachFromUIContainer(r3, r4);
    }
}
