package com.bytedance.ee.bear.lark.entityword;

import android.R;
import android.graphics.RectF;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.lark.dependency.j;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EntityWordsPlugin extends DocumentPluginV2 {
    private static final String DISMISS_ENTITY_WORD_CARD = "biz.util.dismissEnterpriseTopic";
    private static final String SHOW_ENTITY_WORD_CARD = "biz.util.showEnterpriseTopic";
    private static final String TAG = "EntityWordsPlugin";
    private m callBack;
    private IGetDataCallback<String> getDataCallback;
    private boolean isOpenWindow;

    public class a implements i<Void> {
        public final /* synthetic */ EntityWordsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(EntityWordsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            tt5.a.h(EntityWordsPlugin.TAG, "DismissEntityWordsHandler  : ");
            ((j) org.koin.java.a.a(j.class)).a();
            EntityWordsPlugin.access$502(this.a, false);
        }
    }

    public class b implements i<EntityWordsData> {
        public final /* synthetic */ EntityWordsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(EntityWordsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r9, m r10) {
            EntityWordsData r11 = (EntityWordsData) r9;
            tt5.a.h(EntityWordsPlugin.TAG, "ShowEntityWordsHandler data : " + r11);
            EntityWordsPlugin.access$202(this.a, r10);
            if (r11 == null) goto L5;
            ((j) org.koin.java.a.a(j.class)).b(new wb5.a(r11.getQuery(), r11.getAbbrId(), new RectF(), EntityWordsPlugin.access$300(this.a).findViewById(R.id.content), r11.getClientArgs()), EntityWordsPlugin.access$400(this.a));
            EntityWordsPlugin.access$502(this.a, true);
            return;
        L5:
            tt5.a.d(EntityWordsPlugin.TAG, "ShowEntityWordsHandler data : null");
            EntityWordsPlugin.access$502(this.a, false);
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public EntityWordsPlugin() {
    }

    public static /* synthetic */ m access$200(EntityWordsPlugin r0) {
        return r0.callBack;
    }

    public static /* synthetic */ FragmentActivity access$300(EntityWordsPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ IGetDataCallback access$400(EntityWordsPlugin r0) {
        return r0.getDataCallback;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put(SHOW_ENTITY_WORD_CARD, new b(this));
        r3.put(DISMISS_ENTITY_WORD_CARD, new a(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r1) {
        super.onAttachToHost(r1);
        this.getDataCallback = new AnonymousClass1(this);
    }

    public static /* synthetic */ m access$202(EntityWordsPlugin r0, m r1) {
        r0.callBack = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$502(EntityWordsPlugin r0, boolean r1) {
        r0.isOpenWindow = r1;
        return r1;
    }
}
