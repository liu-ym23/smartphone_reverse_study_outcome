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
import com.huawei.hms.support.api.entity.common.CommonConstant;
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

/* JADX INFO: loaded from: classes16.dex */
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
        public static boolean a(String r100, Activity r101) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            com.bytedance.ee.bear.block.jira.c r102 = JiraPlugin.access$getPublicJiraConfig$cp();
            if (r102 != null) goto L5;
            return false;
        L5:
            if (r102.f216591b == true) goto L7;
            return false;
        L7:
            if (TextUtils.isEmpty(r100) == true) goto L78;
            Uri r103 = UriProtector.parse(r100);
            if (TextUtils.isEmpty(r103.getHost()) == true) goto L79;
            a r104 = JiraPlugin.Companion;
            Intrinsics.checkNotNull(r103);
            r104.getClass();
            String r105 = r103.getHost();
            com.bytedance.ee.bear.block.jira.c r106 = JiraPlugin.access$getPublicJiraConfig$cp();
            if (r106 == null) goto L49;
            List<String> r107 = r106.f216593d;
            if ((r107 instanceof Collection) == true) goto L15;
        L17:
            Iterator r108 = ((ArrayList) r107).iterator();
        L19:
            if (r108.hasNext() == false) goto L28;
            String r109 = (String) r108.next();
            if (r105 != null) goto L23;
        L25:
            boolean r110 = false;
        L26:
            if (r110 == false) goto L19;
            boolean r111 = true;
        L29:
            if (r111 == true) goto L48;
            List<String> r112 = r106.f216592c;
            if ((r112 instanceof Collection) == true) goto L33;
        L35:
            Iterator r113 = ((ArrayList) r112).iterator();
        L37:
            if (r113.hasNext() == false) goto L46;
            String r114 = (String) r113.next();
            if (r105 != null) goto L41;
        L43:
            boolean r115 = false;
        L44:
            if (r115 == false) goto L37;
            boolean r116 = true;
        L47:
            if (r116 == false) goto L49;
        L41:
            if (StringsKt.equals(r105, r114, true) != true) goto L43;
            r115 = true;
        L46:
            r116 = false;
            goto L47
        L33:
            if (((ArrayList) r112).isEmpty() == false) goto L35;
        L48:
            boolean r117 = true;
        L50:
            if (r117 == false) goto L61;
            com.bytedance.ee.bear.block.jira.c r118 = JiraPlugin.access$getPublicJiraConfig$cp();
            if (r118 == null) goto L54;
            String r119 = r118.f216590a;
        L55:
            Intent r120 = new Intent();
            r120.setPackage(r119);
            r120.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            r120.setData(r103);
            if (r120.resolveActivity(r101.getPackageManager()) == null) goto L58;
            r101.startActivity(r120);
            boolean r121 = true;
        L59:
            if (r121 == false) goto L61;
            boolean r122 = true;
        L62:
            if (r122 == true) goto L64;
            JiraPlugin.Companion.getClass();
            return false;
        L64:
            return true;
        L58:
            r121 = false;
            goto L59
        L54:
            r119 = null;
        L61:
            r122 = false;
            goto L62
        L23:
            if (StringsKt.endsWith(r105, r109, true) != true) goto L25;
            r110 = true;
        L28:
            r111 = false;
            goto L29
        L15:
            if (((ArrayList) r107).isEmpty() == false) goto L17;
        L49:
            r117 = false;
            goto L50
        L79:
            return false;
        L78:
            return false;
        }
    }

    public final class b implements i<JiraActionData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JiraPlugin f216584a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(JiraPlugin r100) {
            this.f216584a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            JiraActionData r102 = (JiraActionData) r100;
            tt5.a.h(JiraPlugin.TAG, "launch actionSheet: data = " + r102);
            JiraViewModel r103 = null;
            if (r102 != null) goto L5;
        L17:
            JiraViewModel r104 = JiraPlugin.access$getJiraViewModel$p(this.f216584a);
            if (r104 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        L21:
            r103.setActive(false);
            return;
        L20:
            r103 = r104;
            goto L21
        L5:
            if (r102.isEmpty() == true) goto L17;
            JiraViewModel r105 = JiraPlugin.access$getJiraViewModel$p(this.f216584a);
            if (r105 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
            r105 = null;
        L9:
            r105.setActive(true);
            JiraViewModel r106 = JiraPlugin.access$getJiraViewModel$p(this.f216584a);
            if (r106 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
            r106 = null;
        L12:
            r106.setJiraActionData(r102);
            JiraViewModel r107 = JiraPlugin.access$getJiraViewModel$p(this.f216584a);
            if (r107 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        L16:
            r103.setDelegate(new com.bytedance.ee.bear.block.jira.d(r101));
            return;
        L15:
            r103 = r107;
            goto L16
        }
    }

    public static final class c extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JiraPlugin f216585a;

        public c(JiraPlugin r100) {
            this.f216585a = r100;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
            a r102 = JiraPlugin.Companion;
            FragmentActivity r103 = JiraPlugin.access$getActivity(this.f216585a);
            r102.getClass();
            return a.a(r101, r103);
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JiraPlugin f216586a;

        public d(JiraPlugin r100) {
            this.f216586a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            Fragment r102 = JiraPlugin.access$getActivity(this.f216586a).getSupportFragmentManager().findFragmentByTag("JiraActionFragment");
            JiraActionFragment r103 = null;
            if ((r102 instanceof DialogFragment) == false) goto L5;
            DialogFragment r104 = (DialogFragment) r102;
        L7:
            if (Intrinsics.areEqual(Boolean.TRUE, r101) == false) goto L18;
            if (r104 != null) goto L17;
            JiraActionFragment r105 = (JiraActionFragment) ((DialogFragment) JiraPlugin.access$instantiateFragment(this.f216586a, JiraActionFragment.class));
            FragmentManager r106 = JiraPlugin.access$getActivity(this.f216586a).getSupportFragmentManager();
            if ((r105 instanceof Fragment) == false) goto L12;
            r103 = r105;
        L12:
            LandscapeRestrictionOperation r107 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, "JiraActionFragment", r107);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r106, r103, r107) == true) goto L35;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
        L16:
            r105.show(r106, "JiraActionFragment");
            return;
        L35:
            return;
        L17:
            tt5.a.k(JiraPlugin.TAG, "showJiraActionFragment, fragment exist");
            return;
        L18:
            if (r104 == null) goto L33;
            r104.dismissAllowingStateLoss();     // Catch: Exception -> L21
            return;
        L21:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r108 = DialogFragmentLancet.sLastShowStack;
            if (r108 == null) goto L34;
            com.bytedance.crash.d.d(r108, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L34:
            return;
        L33:
            return;
        L5:
            r104 = null;
            goto L7
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final boolean interceptJiraUrl(String r100, Activity r101) {
        Companion.getClass();
        return a.a(r100, r101);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public JiraPlugin() {
        this.jarLinkInterceptor = new c(this);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.block.jira.c access$getPublicJiraConfig$cp() {
        return publicJiraConfig;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(JiraPlugin r100) {
        return r100.getActivity();
    }

    public static final /* synthetic */ JiraViewModel access$getJiraViewModel$p(JiraPlugin r100) {
        return r100.jiraViewModel;
    }

    public void onAttachToHost(DocumentPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onAttachToHost(r100);
        JiraViewModel r101 = null;
        JiraViewModel r102 = (JiraViewModel) q.c(r100, JiraViewModel.class, null);
        this.jiraViewModel = r102;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
    L6:
        r101.getActive().observe(getLifecycleOwner(), new d(this));
        return;
    L5:
        r101 = r102;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    public static final /* synthetic */ Fragment access$instantiateFragment(JiraPlugin r100, Class r101) {
        return r100.instantiateFragment(r101);
    }

    public void onAttachToUIContainer(DocumentPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        publicJiraConfig = PublicJiraConfig$value$1.INSTANCE.invoke();
        getWeb().addWebViewClientDelegate(this.jarLinkInterceptor);
        bindBridgeHandler(BIZ_BITABLE_LAUNCH_ACTIONSHEET, new b(this));
    }

    public void onDetachFromUIContainer(DocumentPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        getWeb().removeWebViewClientDelegate(this.jarLinkInterceptor);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }
}
