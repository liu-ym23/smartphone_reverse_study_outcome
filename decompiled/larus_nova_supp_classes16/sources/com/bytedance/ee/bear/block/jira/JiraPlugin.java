package com.bytedance.ee.bear.block.jira;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/JiraPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "jiraViewModel", "Lcom/bytedance/ee/bear/block/jira/JiraViewModel;", "jarLinkInterceptor", "Landroid/webkit/WebViewClient;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "Companion", "JiraActionHandler", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JiraPlugin extends DocumentPlugin {
    private static final String BIZ_BITABLE_LAUNCH_ACTIONSHEET = "biz.bitable.launchActionSheet";
    public static final a Companion = null;
    private static final String TAG = "JiraPlugin";
    private static com.bytedance.ee.bear.block.jira.c publicJiraConfig;
    private WebViewClient jarLinkInterceptor;
    private JiraViewModel jiraViewModel;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean a(String r6, Activity r7) {
            Intrinsics.checkNotNullParameter(r7, "activity");
            com.bytedance.ee.bear.block.jira.c r0 = JiraPlugin.access$getPublicJiraConfig$cp();
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.b == true) goto L7;
            return false;
        L7:
            if (TextUtils.isEmpty(r6) == true) goto L78;
            Uri r8 = UriProtector.parse(r6);
            if (TextUtils.isEmpty(r8.getHost()) == true) goto L79;
            a r1 = JiraPlugin.Companion;
            Intrinsics.checkNotNull(r8);
            r1.getClass();
            String r2 = r8.getHost();
            com.bytedance.ee.bear.block.jira.c r3 = JiraPlugin.access$getPublicJiraConfig$cp();
            if (r3 == null) goto L49;
            List<String> r4 = r3.d;
            if ((r4 instanceof Collection) == true) goto L15;
        L17:
            Iterator r5 = ((ArrayList) r4).iterator();
        L19:
            if (r5.hasNext() == false) goto L28;
            String r9 = (String) r5.next();
            if (r2 != null) goto L23;
        L25:
            boolean r10 = false;
        L26:
            if (r10 == false) goto L19;
            boolean r11 = true;
        L29:
            if (r11 == true) goto L48;
            List<String> r12 = r3.c;
            if ((r12 instanceof Collection) == true) goto L33;
        L35:
            Iterator r13 = ((ArrayList) r12).iterator();
        L37:
            if (r13.hasNext() == false) goto L46;
            String r14 = (String) r13.next();
            if (r2 != null) goto L41;
        L43:
            boolean r16 = false;
        L44:
            if (r16 == false) goto L37;
            boolean r17 = true;
        L47:
            if (r17 == false) goto L49;
        L41:
            if (StringsKt.equals(r2, r14, true) != true) goto L43;
            r16 = true;
        L46:
            r17 = false;
            goto L47
        L33:
            if (((ArrayList) r12).isEmpty() == false) goto L35;
        L48:
            boolean r18 = true;
        L50:
            if (r18 == false) goto L61;
            com.bytedance.ee.bear.block.jira.c r19 = JiraPlugin.access$getPublicJiraConfig$cp();
            if (r19 == null) goto L54;
            String r20 = r19.a;
        L55:
            Intent r21 = new Intent();
            r21.setPackage(r20);
            r21.setAction("android.intent.action.VIEW");
            r21.setData(r8);
            if (r21.resolveActivity(r7.getPackageManager()) == null) goto L58;
            r7.startActivity(r21);
            boolean r22 = true;
        L59:
            if (r22 == false) goto L61;
            boolean r23 = true;
        L62:
            if (r23 == true) goto L64;
            JiraPlugin.Companion.getClass();
            return false;
        L64:
            return true;
        L58:
            r22 = false;
            goto L59
        L54:
            r20 = null;
        L61:
            r23 = false;
            goto L62
        L23:
            if (StringsKt.endsWith(r2, r9, true) != true) goto L25;
            r10 = true;
        L28:
            r11 = false;
            goto L29
        L15:
            if (((ArrayList) r4).isEmpty() == false) goto L17;
        L49:
            r18 = false;
            goto L50
        L79:
            return false;
        L78:
            return false;
        }
    }

    public final class b implements i<JiraActionData> {
        public final /* synthetic */ JiraPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(JiraPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            JiraActionData r7 = (JiraActionData) r5;
            tt5.a.h(JiraPlugin.TAG, "launch actionSheet: data = " + r7);
            JiraViewModel r0 = null;
            if (r7 != null) goto L5;
        L17:
            JiraViewModel r8 = JiraPlugin.access$getJiraViewModel$p(this.a);
            if (r8 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        L21:
            r0.setActive(false);
            return;
        L20:
            r0 = r8;
            goto L21
        L5:
            if (r7.isEmpty() == true) goto L17;
            JiraViewModel r2 = JiraPlugin.access$getJiraViewModel$p(this.a);
            if (r2 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
            r2 = null;
        L9:
            r2.setActive(true);
            JiraViewModel r3 = JiraPlugin.access$getJiraViewModel$p(this.a);
            if (r3 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
            r3 = null;
        L12:
            r3.setJiraActionData(r7);
            JiraViewModel r9 = JiraPlugin.access$getJiraViewModel$p(this.a);
            if (r9 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        L16:
            r0.setDelegate(new com.bytedance.ee.bear.block.jira.d(r6));
            return;
        L15:
            r0 = r9;
            goto L16
        }
    }

    public static final class c extends WebViewClient {
        public final /* synthetic */ JiraPlugin a;

        public c(JiraPlugin r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r2, String r3) {
            a r4 = JiraPlugin.Companion;
            FragmentActivity r0 = JiraPlugin.access$getActivity(this.a);
            r4.getClass();
            return a.a(r3, r0);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ JiraPlugin a;

        public d(JiraPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Boolean r6 = (Boolean) r5;
            DialogFragment r0 = JiraPlugin.access$getActivity(this.a).getSupportFragmentManager().findFragmentByTag("JiraActionFragment");
            Fragment r3 = null;
            if ((r0 instanceof DialogFragment) == false) goto L5;
            DialogFragment r1 = r0;
        L7:
            if (Intrinsics.areEqual(Boolean.TRUE, r6) == false) goto L18;
            if (r1 != null) goto L17;
            Fragment r7 = (JiraActionFragment) ((DialogFragment) JiraPlugin.access$instantiateFragment(this.a, JiraActionFragment.class));
            FragmentManager r2 = JiraPlugin.access$getActivity(this.a).getSupportFragmentManager();
            if ((r7 instanceof Fragment) == false) goto L12;
            r3 = r7;
        L12:
            LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "JiraActionFragment", r4);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r3, r4) == true) goto L35;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
        L16:
            r7.show(r2, "JiraActionFragment");
            return;
        L35:
            return;
        L17:
            tt5.a.k(JiraPlugin.TAG, "showJiraActionFragment, fragment exist");
            return;
        L18:
            if (r1 == null) goto L33;
            r1.dismissAllowingStateLoss();     // Catch: Exception -> L21
            return;
        L21:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r8 = DialogFragmentLancet.sLastShowStack;
            if (r8 == null) goto L34;
            com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L34:
            return;
        L33:
            return;
        L5:
            r1 = null;
            goto L7
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final boolean interceptJiraUrl(String r1, Activity r2) {
        Companion.getClass();
        return a.a(r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public JiraPlugin() {
        this.jarLinkInterceptor = new c(this);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.block.jira.c access$getPublicJiraConfig$cp() {
        return publicJiraConfig;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(JiraPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ JiraViewModel access$getJiraViewModel$p(JiraPlugin r0) {
        return r0.jiraViewModel;
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        JiraViewModel r1 = null;
        JiraViewModel r4 = (JiraViewModel) q.c(r3, JiraViewModel.class, null);
        this.jiraViewModel = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
    L6:
        r1.getActive().observe(getLifecycleOwner(), new d(this));
        return;
    L5:
        r1 = r4;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ Fragment access$instantiateFragment(JiraPlugin r0, Class r1) {
        return r0.instantiateFragment(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        publicJiraConfig = (com.bytedance.ee.bear.block.jira.c) PublicJiraConfig$value$1.INSTANCE.invoke();
        getWeb().addWebViewClientDelegate(this.jarLinkInterceptor);
        bindBridgeHandler(BIZ_BITABLE_LAUNCH_ACTIONSHEET, new b(this));
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        getWeb().removeWebViewClientDelegate(this.jarLinkInterceptor);
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
}
