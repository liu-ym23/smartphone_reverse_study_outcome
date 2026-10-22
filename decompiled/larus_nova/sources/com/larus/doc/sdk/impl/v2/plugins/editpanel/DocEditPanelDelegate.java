package com.larus.doc.sdk.impl.v2.plugins.editpanel;

import android.content.Context;
import com.larus.doc.sdk.impl.service.ServiceManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import g45.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ym9.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/editpanel/DocEditPanelDelegate;", "Lcom/larus/office/base/plugins/editpanel/BaseEditPanelDelegate;", "<init>", "()V", "getPanelName", "", "getPanelHeight", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocEditPanelDelegate extends a {
    public static final Companion Companion = null;
    private static final String JS_PANEL_CHAT_INPUT = "chat_input";
    private static final String TAG = "DocEditPanelDelegate";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/editpanel/DocEditPanelDelegate$Companion;", "", "<init>", "()V", "TAG", "", "JS_PANEL_CHAT_INPUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // g45.a
    public String getPanelName() {
        return JS_PANEL_CHAT_INPUT;
    }

    @Override // ym9.a, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(d r100, g45.a r101) {
    }

    @Override // ym9.a, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(d r100, g45.a r101) {
    }

    public DocEditPanelDelegate() {
    }

    @Override // g45.a
    public int getPanelHeight(Context r100) {
        ServiceManager r101 = ServiceManager.INSTANCE;
        String r102 = getDocLogicKeyInternal();
        if (r102 != null) goto L6;
        r102 = "default_doc_logic_key";
    L6:
        return r101.getChatService(r102).getChatInputHeight();
    }
}
