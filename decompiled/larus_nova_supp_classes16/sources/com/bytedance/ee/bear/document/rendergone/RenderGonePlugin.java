package com.bytedance.ee.bear.document.rendergone;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentFragment;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.ai.creationai.CreationAIPlugin;
import com.bytedance.ee.bear.document.ai.inlineai.InlineAIPlugin;
import com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin;
import com.bytedance.ee.bear.document.ai.myai.MyAIPlugin;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.concurrent.CopyOnWriteArrayList;
import p35.e;
import p35.f;
import p35.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RenderGonePlugin extends DocumentPlugin {
    private static final String TAG = "RenderGonePlugin";
    private final f mRenderGoneListener;
    private final MutableLiveData<Boolean> renderGone;

    public class a implements f {
        public final /* synthetic */ RenderGonePlugin a;

        public a(RenderGonePlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p35.f
        public final void a(boolean r1, int r2) {
            tt5.a.h(RenderGonePlugin.TAG, "onRenderProcessGone====== : ");
            if (e.a == true) goto L5;
        L6:
            RenderGonePlugin.access$000(this.a).postValue(Boolean.TRUE);
            return;
        L5:
            if (((DocumentPluginHost) this.a.getHost()).c().isResumed() == false) goto L6;
        }
    }

    public static /* synthetic */ void c(RenderGonePlugin r0, Boolean r1) {
        r0.lambda$onAttachToUIContainer$0(r1);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void replaceDocumentFragment() {
        tt5.a.h(TAG, "replaceDocumentFragment()...");
        InlineAIPlugin r0 = (InlineAIPlugin) findPlugin(InlineAIPlugin.class);
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        KnowledgeAIPlugin r1 = (KnowledgeAIPlugin) findPlugin(KnowledgeAIPlugin.class);
        if (r1 == null) goto L8;
        r1.destroy();
    L8:
        CreationAIPlugin r2 = (CreationAIPlugin) findPlugin(CreationAIPlugin.class);
        if (r2 == null) goto L11;
        r2.destroy();
    L11:
        MyAIPlugin r3 = (MyAIPlugin) findPlugin(MyAIPlugin.class);
        if (r3 == null) goto L14;
        r3.destroy();
    L14:
        WebFragment r4 = ((DocumentPluginHost) getHost()).c();
        String r5 = getDocViewModel().getOriginUrl();
        if (r4 != null) goto L17;
    L23:
        tt5.a.k(TAG, "the documentFragment or its origin url is null");
        return;
    L17:
        if (TextUtils.isEmpty(r5) == true) goto L23;
        FragmentManager r6 = r4.getFragmentManager();
        if (r6 == null) goto L25;
        BaseFragment r7 = DocumentFragment.ka0(r5, r4.getArguments());
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_rendergone_RenderGonePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r6.beginTransaction(), r4.getId(), r7).commitAllowingStateLoss();
        return;
    }

    public RenderGonePlugin() {
        this.mRenderGoneListener = new a(this);
        this.renderGone = new MutableLiveData(Boolean.FALSE);
    }

    public static /* synthetic */ MutableLiveData access$000(RenderGonePlugin r0) {
        return r0.renderGone;
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$0(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L6;
        replaceDocumentFragment();
        return;
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        this.renderGone.observe(getLifecycleOwner(), new g(this));
        e.a(this.mRenderGoneListener);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        f r3 = this.mRenderGoneListener;
        if (r3 != null) goto L5;
        boolean r4 = e.a;
    L6:
        this.renderGone.removeObservers(getLifecycleOwner());
        return;
    L5:
        ((CopyOnWriteArrayList) e.j).remove(r3);
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_document_rendergone_RenderGonePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.replace(r3, r4);
    }
}
