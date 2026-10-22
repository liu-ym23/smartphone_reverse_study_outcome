package com.bytedance.ee.bear.document.actionpanel;

import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeActionPanelPlugin extends DocumentPluginV3 {
    private static final String ACTION_ID = "actionId";
    private static final int ACTION_STYLE_BLUE = 3;
    private static final int ACTION_STYLE_CANCEL = 1;
    private static final int ACTION_STYLE_DEFAULT = 0;
    private static final int ACTION_STYLE_DESTRUCTIVE = 2;
    private static final String TAG = "OfficeActionPanelPlugin";

    public class a implements View.OnClickListener {
        public final /* synthetic */ ActionPanelData.Data a;
        public final /* synthetic */ m b;
        public final /* synthetic */ OfficeActionPanelPlugin c;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            OfficeActionPanelPlugin.access$200(this.c, this.a.getActionId(), this.b);
        }

        public a(OfficeActionPanelPlugin r1, ActionPanelData.Data r2, m r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b implements i<ActionPanelData> {
        public final /* synthetic */ OfficeActionPanelPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeActionPanelPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            OfficeActionPanelPlugin r0 = this.a;
            OfficeActionPanelPlugin.access$000(r0, (ActionPanelData) r2, r3);
        }
    }

    public static /* synthetic */ void a(OfficeActionPanelPlugin r0, ActionPanelData.Data r1, m r2, View r3) {
        r0.lambda$showActionPanel$0(r1, r2, r3);
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeActionPanelPlugin() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.util.showActionSheet", new b(this));
    }

    private void executeCallback(String r3, m r4) {
        if (r4 == null) goto L5;
        JSONObject r0 = new JSONObject();
        r0.put(ACTION_ID, r3);
        r4.b(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showActionPanel(ActionPanelData r13, final m r14) {
        if (r13 != null) goto L6;
        tt5.a.k(TAG, "ActionPanelData is null.");
        return;
    L6:
        List<ActionPanelData.Data> r1 = r13.getData();
        if (hu5.a.d(r1) == false) goto L10;
        tt5.a.k(TAG, "panels is empty.");
        tt5.a.k(TAG, r13.toString());
        return;
    L10:
        com.bytedance.ee.bear.widgets.a r3 = new com.bytedance.ee.bear.widgets.a(getActivity());
        if (TextUtils.isEmpty(r13.getTitle()) == true) goto L13;
        r3.k(r13.getTitle());
    L13:
        tt5.a.h(TAG, "panelItems size is " + r1.size());
        Iterator<ActionPanelData.Data> r16 = r1.iterator();
    L15:
        if (r16.hasNext() == false) goto L32;
        final ActionPanelData.Data r2 = r16.next();
        String r4 = r2.getTitle();
        if (TextUtils.isEmpty(r4) == true) goto L18;
        int r6 = -1;
        if (1 == r2.getActionStyle()) goto L21;
        if (r2.isClickable() == true) goto L24;
        r3.d(r4);
        goto L15
    L24:
        View.OnClickListener r5 = new xz4.b(this, r2, r14);
        if (2 != r2.getActionStyle()) goto L28;
        r6 = getActivity().getResources().getColor(2131102093);
    L30:
        cp5.b r7 = new cp5.b();
        r7.a = r4;
        r7.d = false;
        r7.e = null;
        r7.f = r5;
        r7.c = false;
        r7.b = r6;
        r7.g = true;
        r7.h = 1.0f;
        r7.i = true;
        r3.f(r7);
        goto L15
    L28:
        if (3 != r2.getActionStyle()) goto L30;
        r6 = getActivity().getResources().getColor(2131105548);
        goto L30
    L21:
        a r8 = new a(this, r2, r14);
        cp5.b r9 = new cp5.b();
        r9.a = r4;
        r9.d = false;
        r9.e = null;
        r9.f = r8;
        r9.c = false;
        r9.b = -1;
        r9.g = true;
        r9.h = 1.0f;
        r9.i = true;
        r3.c(r9);
        goto L15
    L18:
        tt5.a.k(TAG, "Title is null, " + r2.toString());
        goto L15
    L32:
        r3.q();
    }

    public static /* synthetic */ void access$000(OfficeActionPanelPlugin r0, ActionPanelData r1, m r2) {
        r0.showActionPanel(r1, r2);
    }

    public static /* synthetic */ void access$200(OfficeActionPanelPlugin r0, String r1, m r2) {
        r0.executeCallback(r1, r2);
    }

    private /* synthetic */ void lambda$showActionPanel$0(ActionPanelData.Data r1, m r2, View r3) {
        executeCallback(r1.getActionId(), r2);
    }
}
