package com.bytedance.ee.bear.document.reloadwebview;

import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentFragment;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.y0;
import e0c.k;
import java.util.HashMap;
import kotlin.Unit;
import org.json.JSONObject;
import s45.l;
import sbb.e;
import t45.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ReloadWebviewPlugin extends DocumentPlugin {
    private static final String TAG = "ReloadWebviewPlugin";
    private static final long TIME_OUT = 5000;
    private String mUrl;
    private final b runnable;

    public class a implements Observer<DocumentInfo> {
        public final /* synthetic */ DocumentPluginHost a;
        public final /* synthetic */ ReloadWebviewPlugin b;

        /* JADX WARN: Multi-variable type inference failed */
        public final void onChanged(Object r8) {
            DocumentInfo r9 = (DocumentInfo) r8;
            if (r9 != null) goto L6;
            tt5.a.k(ReloadWebviewPlugin.TAG, "liveDocInfoData observer receive null result");
            return;
        L6:
            if (y0.a(ReloadWebviewPlugin.access$100(this.b), r9.getDocMetaInfo().getUrl()) == false) goto L8;
            tt5.a.k(ReloadWebviewPlugin.TAG, " mUrl == documentInfo.getDocMetaInfo().getUrl()");
            return;
        L8:
            ReloadWebviewPlugin.access$102(this.b, r9.getDocMetaInfo().getUrl());
            String r1 = ReloadWebviewPlugin.access$200(this.b).getOriginUrl();
            String r10 = r9.getDocMetaInfo().getUrl();
            if (TextUtils.isEmpty(r1) == false) goto L11;
        L47:
            tt5.a.k(ReloadWebviewPlugin.TAG, "originUrl metaUrl null");
            return;
        L11:
            if (TextUtils.isEmpty(r10) == true) goto L47;
            c r2 = (c) k.a(LarkContext.getApplication(), c.class);
            l r3 = r2.m8(r1);
            l r11 = r2.m8(r10);
            if (TextUtils.isEmpty(r3.d) == false) goto L16;
        L46:
            tt5.a.h(ReloadWebviewPlugin.TAG, "originHost metaHost empty");
            return;
        L16:
            if (TextUtils.isEmpty(r11.d) == true) goto L46;
            tt5.a.h(ReloadWebviewPlugin.TAG, "originHost : " + r3.c + "  originNoGeoHost : " + r3.d + "  metaHost : " + r11.d + "  metaHostNoGeoHost : " + r11.d);
            if (y0.a(r3.d, r11.d) == false) goto L21;
            ((s45.c) ((DocumentPluginHost) this.b.getHost()).getUserComponent().a(s45.c.class)).R8(r3.d);
            return;
        L21:
            if (ReloadWebviewPlugin.access$300(this.b).isCommonTemplatePreview() == false) goto L23;
            tt5.a.h(ReloadWebviewPlugin.TAG, "  isCommonTemplatePreview ===  ");
            return;
        L23:
            ((s45.c) ((DocumentPluginHost) this.b.getHost()).getUserComponent().a(s45.c.class)).h7(r3.d, r11.d);
            WebFragment r4 = ((DocumentPluginHost) this.b.getHost()).c();
            String r12 = r1.replaceFirst(r3.c, r11.c);
            if (r4 != null) goto L26;
        L44:
            tt5.a.k(ReloadWebviewPlugin.TAG, "the documentFragment or its origin url is null");
            return;
        L26:
            if (TextUtils.isEmpty(r12) == true) goto L44;
            FragmentManager r0 = r4.getFragmentManager();
            if (r0 != null) goto L31;
            return;
        L31:
            if (fx4.a.g(r2.Z(r12)) == false) goto L39;
            String r5 = ReloadWebviewPlugin.access$400(this.b).getDocumentType();
            e r6 = e.i;
            if (TextUtils.equals(r5, r6.getType()) == false) goto L39;
            BaseFragment r13 = DocumentFragment.la0(r6.getType(), r12, r4.getArguments(), this.a.getUserComponent().b());
            FragmentTransaction r7 = r0.beginTransaction();
            int r14 = r4.getId();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r14) == true) goto L38;
            r7 = r7.replace(r14, r13);
        L38:
            r7.commitAllowingStateLoss();
            return;
        L39:
            BaseFragment r16 = DocumentFragment.ka0(r12, r4.getArguments());
            FragmentTransaction r17 = r0.beginTransaction();
            int r18 = r4.getId();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r17, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r18) == true) goto L43;
            r17 = r17.replace(r18, r16);
        L43:
            r17.commitAllowingStateLoss();
        }

        public a(ReloadWebviewPlugin r1, DocumentPluginHost r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static class b implements Runnable {
        public static void a() {
        L7:
            th = move-exception;
            boolean r5 = s1.n;
            tt5.a.j("DocReport", th);
        L24:
            tt5.a.h("DocReport", "reportStorageResult startCount: " + s1.I + ", succCount: " + s1.J + ", failCount: " + s1.K);     // Catch: Throwable -> L19
            if (s1.I == 0) goto L13;
        L17:
            d r1 = (d) org.koin.java.a.c(d.class, null, null, 6);     // Catch: Throwable -> L19
            JSONObject r4 = new JSONObject();     // Catch: Throwable -> L19
            r4.put("start_count", s1.I);     // Catch: Throwable -> L19
            r4.put("succ_count", s1.J);     // Catch: Throwable -> L19
            r4.put("fail_count", s1.K);     // Catch: Throwable -> L19
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L19
            r1.u("ccm_mobile_offline_data_storage_result", r4);     // Catch: Throwable -> L19
            s1.I = 0;     // Catch: Throwable -> L19
            s1.J = 0;     // Catch: Throwable -> L19
            s1.K = 0;     // Catch: Throwable -> L19
            return;
        L13:
            if (s1.J != 0) goto L17;
            if (s1.K != 0) goto L17;
            return;
        L19:
            th = move-exception;
            boolean r2 = s1.n;
            tt5.a.j("DocReport", th);
            return;
        L4:
            if (s1.F <= 0) goto L24;
            tt5.a.h("DocReport", "reportTokenError count: " + s1.F + ", isCovered: " + s1.G);     // Catch: Throwable -> L7
            d r3 = (d) org.koin.java.a.c(d.class, null, null, 6);     // Catch: Throwable -> L7
            JSONObject r7 = new JSONObject();     // Catch: Throwable -> L7
            r7.put("count", s1.F);     // Catch: Throwable -> L7
            r7.put("isCovered", s1.G);     // Catch: Throwable -> L7
            r7.put("key", s1.H);     // Catch: Throwable -> L7
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L7
            r3.u("dev_performance_doc_token_inconsistency", r7);     // Catch: Throwable -> L7
            s1.F = 0;     // Catch: Throwable -> L7
            s1.G = false;     // Catch: Throwable -> L7
            goto L24
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b() {
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public ReloadWebviewPlugin() {
        this.runnable = new b();
    }

    public static /* synthetic */ String access$100(ReloadWebviewPlugin r0) {
        return r0.mUrl;
    }

    public static /* synthetic */ DocViewModel access$200(ReloadWebviewPlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$300(ReloadWebviewPlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$400(ReloadWebviewPlugin r0) {
        return r0.getDocViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(DocumentPluginHost r4) {
        super.onAttachToHost(r4);
        l35.k.b++;
        l35.k.c++;
        l35.k.d = false;
        tt5.a.h(TAG, "onAttachToHost web sNeedClearDoneCount=" + l35.k.c);
        if ((getWeb() instanceof z4) == false) goto L5;
        ((z4) getWeb()).v();
    L5:
        j.e(this.runnable);
        ((w05.b) ((DocumentPluginHost) getHost()).getHostAbility(w05.b.class)).getDocumentInfoProvider().j().observe(getLifecycleOwner(), new a(this, r4));
    }

    public void onDetachFromHost(DocumentPluginHost r3) {
        super.onDetachFromHost(r3);
        l35.k.b--;
        l35.k.d = false;
        l35.k r4 = l35.k.a.a;
        r4.a();
        r4.getClass();
        tt5.a.h("ReloadManager", "checkReleaseResource()... sReferenceCount = " + l35.k.b);
        if (l35.k.b != 0) goto L5;
        ((ArrayMap) k35.a.C0243a.a.a).clear();
        ((HashMap) d25.d.b).clear();
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).H();
    L5:
        j.d(this.runnable, TIME_OUT);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ String access$102(ReloadWebviewPlugin r0, String r1) {
        r0.mUrl = r1;
        return r1;
    }
}
