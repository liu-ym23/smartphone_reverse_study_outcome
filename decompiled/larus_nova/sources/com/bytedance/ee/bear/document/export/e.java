package com.bytedance.ee.bear.document.export;

import android.app.Application;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.export.DocumentExportType;
import com.bytedance.ee.bear.document.export.dialog.DocExportChooseDialogFragment;
import com.bytedance.ee.bear.document.export.dialog.DocExportDialogFragment;
import com.bytedance.ee.bear.document.export.dialog.SelectDownloadDialogFragment;
import com.bytedance.ee.bear.document.export.dialog.SheetExportDialogFragment;
import com.bytedance.ee.bear.document.export.dialog.SlidesExportDialogFragment;
import com.bytedance.ee.bear.document.export.more.ExportMoreItemV2;
import com.bytedance.ee.bear.document.export.net.exportV2.MinutesExportExecutorImpl;
import com.bytedance.ee.bear.document.export.viewmodel.DocExportViewModel;
import com.bytedance.ee.bear.document.export.viewmodel.SheetExportViewModel;
import com.bytedance.ee.bear.document.export.viewmodel.SlidesExportViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.widgets.OpenLoadingView;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.pb.security_event.ContainerType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.lark.android.encryption.CipherManager;
import e0c.k;
import g15.f;
import g15.g;
import g15.i;
import g15.j;
import g15.l;
import g15.m;
import g15.o;
import g15.p;
import g15.t;
import g15.w;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import rw4.n;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f219740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f219741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f219742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ee.bear.document.export.net.exportV2.a f219743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f219744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MinutesExportExecutorImpl f219745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Dialog f219746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PluginHost f219747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OpenLoadingView f219748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f219749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f219750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f219751l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f219752m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f219753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f219754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f219755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f219756d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f219757e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f219758f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f219759g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f219760h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f219761i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f219762j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f219763k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f219764l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f219765m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f219766n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final IDocUserPermission f219767o;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.export.e$a$a, reason: collision with other inner class name */
        public static final class C3129a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f219768a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f219769b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f219770c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f219771d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f219772e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public String f219773f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public String f219774g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f219775h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public boolean f219776i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public String f219777j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public boolean f219778k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public boolean f219779l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public boolean f219780m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public String f219781n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public IDocUserPermission f219782o;

            public C3129a() {
            }
        }

        public int getType() {
            return this.f219753a;
        }

        public a(C3129a r100) {
            this.f219753a = r100.f219768a;
            this.f219754b = r100.f219769b;
            String r101 = r100.f219770c;
            String r102 = "";
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            this.f219755c = r101;
            String r103 = r100.f219771d;
            if (r103 != null) goto L8;
            r103 = "";
        L8:
            this.f219756d = r103;
            String r104 = r100.f219772e;
            if (r104 != null) goto L11;
            r104 = "";
        L11:
            this.f219757e = r104;
            String r105 = r100.f219773f;
            if (r105 != null) goto L14;
            r105 = "";
        L14:
            this.f219758f = r105;
            String r106 = r100.f219774g;
            if (r106 != null) goto L17;
            r106 = "";
        L17:
            this.f219759g = r106;
            String r107 = r100.f219775h;
            if (r107 != null) goto L20;
            r107 = "";
        L20:
            this.f219760h = r107;
            this.f219761i = r100.f219776i;
            String r108 = r100.f219777j;
            if (r108 == null) goto L24;
            r102 = r108;
        L24:
            this.f219762j = r102;
            this.f219763k = r100.f219778k;
            this.f219764l = r100.f219779l;
            this.f219765m = r100.f219780m;
            this.f219766n = r100.f219781n;
            this.f219767o = r100.f219782o;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f219783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f219784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f219785c;

        public b(boolean r100, boolean r101, boolean r102) {
            this.f219783a = r100;
            this.f219784b = r101;
            this.f219785c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f219786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PermissionResponse f219787b;

        public c(boolean r100, PermissionResponse r101) {
            this.f219786a = r100;
            this.f219787b = r101;
        }
    }

    public interface d {
        void a(String r100);

        void b(String r100);

        void c(String r100);

        void d(String r100);

        void e(String r100, String r101, String r102);

        void f(String r100);
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.export.e$e, reason: collision with other inner class name */
    public static class C3130e implements d {
        public C3130e() {
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void a(String r100) {
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void b(String r100) {
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void c(String r100) {
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void d(String r100) {
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void e(String r100, String r101, String r102) {
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void f(String r100) {
        }
    }

    public static boolean m() {
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        Application r101 = LarkContext.getApplication();
        r100.getClass();
        if (((dn4.a) k.b(((v) k.a(r101, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r101, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("vc_record_notes_view_three_in_one") == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        tt5.a.h("DocumentExportAction", "isVcRecordNotesViewThreeInOneEnable: " + r102);
        return r102;
    L5:
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final boolean e() {
        if (this.f219740a.isFinishing() == false) goto L5;
    L9:
        return false;
    L5:
        if (this.f219740a.isDestroyed() == true) goto L9;
        if (this.f219740a.getSupportFragmentManager().isStateSaved() == true) goto L9;
        return true;
    }

    public final String i() {
        if (TextUtils.isEmpty(this.f219741b.f219757e) == true) goto L7;
        return this.f219741b.f219757e;
    L7:
        return ((rc5.a) org.koin.java.a.a(rc5.a.class)).getDocumentDefaultName(this.f219740a, this.f219741b.getType());
    }

    public final String j() {
        return sbb.e.d(this.f219741b.getType()).getType();
    }

    public final void l() {
        Dialog r100 = this.f219746g;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
    L21:
        this.f219746g = null;
        this.f219748i = null;
    }

    public final boolean p() {
        boolean r100 = false;
        if (this.f219740a.isFinishing() == false) goto L5;
    L75:
        tt5.a.k("DocumentExportAction", "open fail, activity or supportFragmentManager invalid");
        return false;
    L5:
        if (this.f219740a.isDestroyed() == true) goto L75;
        if (this.f219740a.getSupportFragmentManager().isStateSaved() == true) goto L75;
        if (CipherManager.d() != 1) goto L14;
        FragmentActivity r101 = this.f219740a;
        Toast.showText(r101, r101.getString(R.string.CreationMobile_ECM_SecuritySettingKAToast), 1, true);
        CipherManager.h();
        return false;
    L14:
        if (this.f219741b.getType() == 2) goto L23;
        a r102 = this.f219741b;
        if (r102.f219754b == 2) goto L23;
        if (r102.getType() == 22) goto L23;
        if (this.f219741b.f219754b == 22) goto L23;
        boolean r103 = false;
    L24:
        if (r103 == false) goto L50;
        if (this.f219741b.f219764l == true) goto L28;
    L46:
        u(null);
        return true;
    L28:
        if (m() == false) goto L46;
        if (e() == true) goto L32;
        tt5.a.h("DocumentExportAction", "skip showing three in one download dialog, activity state invalid");
        return true;
    L32:
        String r110 = this.f219741b.f219766n;
        HashMap r111 = new HashMap();
        ArrayList r104 = new ArrayList();
        r104.add("transcript");
        if (this.f219741b.f219765m == false) goto L36;
        r104.add("audio");
    L36:
        if (TextUtils.isEmpty(r110) == false) goto L42;
        tt5.a.k("DocumentExportAction", "show three in one download dialog with empty minutes token");
        Iterator r105 = r104.iterator();
    L39:
        if (r105.hasNext() == false) goto L41;
        r111.put((String) r105.next(), new b(false, false, true));
        goto L39
    L41:
        v(r111);
        return true;
    L42:
        int r112 = r104.size();
        int[] r113 = {0};
        Iterator r114 = r104.iterator();
    L44:
        if (r114.hasNext() == false) goto L81;
        String r115 = (String) r114.next();
        com.bytedance.ee.bear.document.export.d r106 = new com.bytedance.ee.bear.document.export.d(this, r111, r113, r112, r115, r110);
        tt5.a.h("DocumentExportAction", "start minutes action/state validate, optionId = " + r115 + ", token = " + du5.b.k(r110));
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).i0().a().b(r110, 28, "EXPORT", new t(r115, r110, r106));
        goto L44
    L81:
        return true;
    L50:
        if (this.f219741b.getType() != 3) goto L52;
    L55:
        boolean r107 = true;
    L56:
        if (r107 == false) goto L65;
        ((SheetExportViewModel) ViewModelProviders.of(this.f219740a).get(SheetExportViewModel.class)).setDelegate(new com.bytedance.ee.bear.document.export.b(this));
        DialogFragment r108 = (DialogFragment) Fragment.instantiate(this.f219740a, SheetExportDialogFragment.class.getName());
        Bundle r109 = new Bundle();
        IDocUserPermission r116 = this.f219741b.f219767o;
        if (r116 == null) goto L61;
        r100 = f35.b.h(r116);
    L61:
        r109.putBoolean(ExportMoreItemV2.HAS_PERCEIVE_CONTRAL, r100);
        r108.setArguments(r109);
        a(r108, this.f219740a.getSupportFragmentManager(), SheetExportDialogFragment.class.getName());
        return true;
    L65:
        if (this.f219741b.getType() != 30) goto L67;
    L70:
        boolean r117 = true;
    L71:
        if (r117 == false) goto L73;
        ((SlidesExportViewModel) ViewModelProviders.of(this.f219740a).get(SlidesExportViewModel.class)).setDelegate(new com.bytedance.ee.bear.document.export.c(this));
        a((DialogFragment) Fragment.instantiate(this.f219740a, SlidesExportDialogFragment.class.getName()), this.f219740a.getSupportFragmentManager(), SlidesExportDialogFragment.class.getName());
        return true;
    L73:
        tt5.a.k("DocumentExportAction", "open fail, unsupported type = " + this.f219741b.getType() + ", realType = " + this.f219741b.f219754b);
        return false;
    L67:
        if (this.f219741b.f219754b == 30) goto L70;
        r117 = false;
        goto L71
    L52:
        if (this.f219741b.f219754b == 3) goto L55;
        r107 = false;
    L23:
        r103 = true;
        goto L24
    }

    public final Single<Boolean> q() {
        PluginHost r100 = this.f219747h;
        if ((r100 instanceof WebPluginHost) == true) goto L5;
        final vv4.k r101 = null;
    L6:
        if (r101 != null) goto L10;
        tt5.a.h("DocumentExportAction", "query comment state from JSB skipped, document web unavailable");
        return r();
    L10:
        return Single.create(new o(r101)).timeout(3, TimeUnit.SECONDS).onErrorResumeNext(new p(this));
    L5:
        r101 = ((WebPluginHost) r100).getWeb();
        goto L6
    }

    public final Single<Boolean> r() {
        new tj5.k();
        a r100 = this.f219741b;
        return tj5.k.a(r100.f219754b, r100.f219756d).map(new f()).firstOrError().timeout(3, TimeUnit.SECONDS).doOnError(new g()).onErrorReturnItem(Boolean.TRUE);
    }

    public static void g(a r100) {
        com.bytedance.ee.bear.middleground_permission_export.model.c r101 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.c.class);
        sbb.e r102 = sbb.e.d(r100.f219754b);
        String r103 = r100.f219756d;
        boolean r104 = r100.f219761i;
        if (r104 == false) goto L5;
        ContainerType r105 = ContainerType.Wiki;
    L6:
        if (r104 == false) goto L8;
        String r106 = r100.f219762j;
    L9:
        r101.e(r102, r103, r105, r106);
        return;
    L8:
        r106 = "";
        goto L9
    L5:
        r105 = ContainerType.ContainerTypeUnknown;
        goto L6
    }

    public static void h(a r100) {
        ((zk5.a) org.koin.java.a.a(zk5.a.class)).a(r100.getType(), r100.f219756d, "download");
    }

    public final void k(String r110) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r100 = jg5.e.a.f499003a.g();
        c r101 = x(r110);
        if (r101.f219786a == false) goto L5;
        return;
    L5:
        String r102 = this.f219741b.f219766n;
        if (r100 == false) goto L14;
        PermissionResponse r103 = r101.f219787b;
        if (r103 != null) goto L10;
        return;
    L10:
        if (r103.getCallback() == null) goto L18;
        tt5.a.h("DocumentExportAction", "handle disabled minutes download by permission platform, optionId = " + r110);
        r101.f219787b.getCallback().a(this.f219740a, r101.f219787b);
        return;
    L18:
        return;
    L14:
        if (TextUtils.isEmpty(r102) == true) goto L19;
        tt5.a.h("DocumentExportAction", "handle disabled minutes download by security dialog, optionId = " + r110);
        gj5.b r104 = (gj5.b) org.koin.java.a.a(gj5.b.class);
        FileBizDomain r105 = FileBizDomain.FileBizDomainCCM;
        a r111 = this.f219741b;
        r104.b(r105, r102, r111.f219758f, r111.f219759g, 28, FileBizDomain.FileBizDomainMeetingMinutes);
        return;
    }

    public final void o(String r100) {
        this.f219749j = SystemClock.elapsedRealtime();
        this.f219750k = r100;
        this.f219751l = 0;
        this.f219752m = null;
    }

    public final void s(String r100) {
        this.f219742c.d(r100);
        t("0", r100, 0, "Cancelled");
    }

    public final void u(String r100) {
        DocExportViewModel r101 = (DocExportViewModel) ViewModelProviders.of(this.f219740a).get(DocExportViewModel.class);
        r101.setDelegate(new com.bytedance.ee.bear.document.export.a(this, r101, r100));
        boolean r102 = false;
        if (this.f219741b.f219764l == true) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L22;
        DialogFragment r104 = (DialogFragment) Fragment.instantiate(this.f219740a, DocExportChooseDialogFragment.class.getName());
        IDocUserPermission r105 = this.f219741b.f219767o;
        if (r105 == null) goto L15;
        r102 = f35.b.h(r105);
    L15:
        if ("vc_summary_tab".equals(r100) == false) goto L18;
        String r106 = "summary";
    L21:
        int r107 = DocExportChooseDialogFragment.f219709z;
        Bundle r108 = new Bundle();
        r108.putBoolean(ExportMoreItemV2.HAS_PERCEIVE_CONTRAL, r102);
        r108.putString("arg_export_scene", r100);
        r108.putString("arg_audio_minutes_export_target", r106);
        r104.setArguments(r108);
        String r109 = DocExportChooseDialogFragment.class.getName();
    L27:
        a(r104, this.f219740a.getSupportFragmentManager(), r109);
        return;
    L18:
        if ("vc_transcript_tab".equals(r100) == false) goto L20;
        r106 = "transcript";
        goto L21
    L20:
        r106 = null;
        goto L21
    L22:
        r104 = (DialogFragment) Fragment.instantiate(this.f219740a, DocExportDialogFragment.class.getName());
        IDocUserPermission r110 = this.f219741b.f219767o;
        if (r110 == null) goto L26;
        r102 = f35.b.h(r110);
    L26:
        int r111 = DocExportDialogFragment.f219720s;
        Bundle r112 = new Bundle();
        r112.putBoolean(ExportMoreItemV2.HAS_PERCEIVE_CONTRAL, r102);
        r112.putString("arg_export_scene", r100);
        r104.setArguments(r112);
        r109 = DocExportDialogFragment.class.getName();
        goto L27
    L5:
        if (m() == false) goto L7;
        r103 = true;
        goto L9
    }

    public final void v(Map<String, b> r110) {
        if (e() == true) goto L6;
        tt5.a.h("DocumentExportAction", "skip showing three in one download dialog after action/state, activity state invalid");
        return;
    L6:
        FragmentActivity r100 = this.f219740a;
        String r101 = r100.getString(R.string.LarkCCM_VC_AINotesIntegration_SelectDownload_Title);
        ArrayList r102 = new ArrayList();
        String r103 = this.f219740a.getString(R.string.LarkCCM_VC_AINotesIntegration_DownloadAINotes_Button);
        Intrinsics.checkNotNullParameter("summary", "id");
        Intrinsics.checkNotNullParameter(r103, "title");
        boolean r104 = true;
        r102.add(new SelectDownloadDialogFragment.b("summary", r103, true));
        b r105 = r110.get("transcript");
        String r106 = this.f219740a.getString(R.string.LarkCCM_VC_AINotesIntegration_DownloadTranscript_Button);
        if (r105 != null) goto L9;
    L18:
        boolean r107 = false;
    L19:
        r102.add(new SelectDownloadDialogFragment.b("transcript", r106, r107));
        if (this.f219741b.f219765m == false) goto L35;
        b r111 = r110.get("audio");
        String r108 = this.f219740a.getString(R.string.LarkCCM_VC_AINotesIntegration_DownloadAudio_Button);
        if (r111 != null) goto L24;
    L33:
        r104 = false;
    L34:
        r102.add(new SelectDownloadDialogFragment.b("audio", r108, r104));
        goto L35
    L24:
        if (r111.f219784b == true) goto L26;
    L30:
        boolean r112 = false;
    L31:
        if (r112 == false) goto L33;
    L26:
        if (r111.f219783a == false) goto L30;
        if (r111.f219785c == true) goto L30;
        r112 = true;
    L35:
        SelectDownloadDialogFragment.d r113 = new i(this);
        SelectDownloadDialogFragment.c r109 = new j(this);
        int r114 = SelectDownloadDialogFragment.f219724n;
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "options");
        if (r100.getSupportFragmentManager().isStateSaved() == true) goto L47;
        SelectDownloadDialogFragment r115 = SelectDownloadDialogFragment.a.a(r101, r102);
        r115.f219725h = r113;
        r115.f219726i = r109;
        FragmentManager r116 = r100.getSupportFragmentManager();
        LandscapeRestrictionOperation r117 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r115, "SelectDownloadDialog", r117);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r116, r115, r117) == true) goto L48;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
    L42:
        r115.show(r116, "SelectDownloadDialog");
        return;
    L48:
        return;
    L47:
        return;
    L9:
        if (r105.f219784b == true) goto L11;
    L15:
        boolean r118 = false;
    L16:
        if (r118 == false) goto L18;
        r107 = true;
        goto L19
    L11:
        if (r105.f219783a == false) goto L15;
        if (r105.f219785c == true) goto L15;
        r118 = true;
        goto L16
    }

    public final c x(String r110) {
        String r100 = this.f219741b.f219766n;
        boolean r111 = false;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        tt5.a.k("DocumentExportAction", "minutes download permission hidden, token is empty, optionId = " + r110);
        return new c(false, null);
    L6:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r101 = jg5.e.a.f499003a.g();
        a r102 = this.f219741b;
        IDocUserPermission r103 = r102.f219767o;
        if (r101 == false) goto L23;
        if (r103 != null) goto L11;
        tt5.a.k("DocumentExportAction", "minutes download permission disabled, userPermission is null, optionId = " + r110);
        return new c(false, null);
    L11:
        int r104 = f35.b.f475390a;
        PermissionResponse r105 = f35.b.e(r100, sbb.e.f541306q, r102.f219759g, "EXPORT", BizDomain.FileBizDomainCCM, r103, r102.f219758f, FileBizDomain.FileBizDomainMeetingMinutes, "MeetingMinutes");
        PermissionResponse.Companion.getClass();
        boolean r106 = !PermissionResponse.a.e(r105);
        if (r106 == false) goto L14;
    L16:
        boolean r107 = false;
    L18:
        if (r106 == true) goto L22;
        if (r107 == true) goto L22;
        r111 = true;
    L22:
        return new c(r111, r105);
    L14:
        if (((ph5.c) org.koin.java.a.a(ph5.c.class)).e(r105) == true) goto L16;
        r107 = true;
        goto L18
    L23:
        gj5.b r108 = (gj5.b) org.koin.java.a.a(gj5.b.class);
        FileBizDomain r109 = FileBizDomain.FileBizDomainCCM;
        a r112 = this.f219741b;
        boolean r113 = r108.e("CCM_EXPORT", r109, 28, r100, r112.f219758f, r112.f219759g, 28, false, FileBizDomain.FileBizDomainMeetingMinutes, null, "MeetingMinutes").f481503a;
        if (r113 == true) goto L27;
        tt5.a.h("DocumentExportAction", "minutes download permission disabled by security policy, optionId = " + r110 + ", token = " + du5.b.k(r100));
    L27:
        return new c(r113, null);
    }

    public static void b(e r100, String r101) {
        r100.f219742c.c(r101);
        r100.t("0", r101, r100.f219751l, r100.f219752m);
    }

    public static void d(e r100, String r101) {
        r100.f219742c.b(r101);
        r100.t("1", r101, 0, null);
    }

    public final String n(n r100, String r101) {
        if (this.f219741b.getType() == 22) goto L8;
        if (this.f219741b.f219754b == 22) goto L8;
        return r101;
    L8:
        if (r100 == n.f539701c) goto L13;
        if (r100 == n.f539703e) goto L13;
        return r101;
    L13:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.sheet.new_chart_style") == false) goto L15;
        String r102 = "2";
    L25:
    L22:
        e = move-exception;
        tt5.a.e("DocumentExportAction", "makeExportPassbackIfNeeded: build payload failed", e, false);
        return r101;
    L17:
        if (TextUtils.isEmpty(r101) == false) goto L19;
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L22
    L20:
        r103.put("chart_sve", r102);     // Catch: JSONException -> L22
        return r103.toString();
    L19:
        r103 = new JSONObject(r101);     // Catch: JSONException -> L22
        goto L20
    L15:
        r102 = "1";
        goto L25
    }

    public static void a(DialogFragment r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        DialogFragment r103 = r100;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r102, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r100.show(r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static void c(e r100, int r101, Throwable r102) {
        r100.f219751l = r101;
        if (r102 == null) goto L5;
        String r103 = r102.getMessage();
    L6:
        r100.f219752m = r103;
        if (TextUtils.isEmpty(r103) == false) goto L11;
        if (r102 == null) goto L12;
        r100.f219752m = r102.getClass().getSimpleName();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public e(FragmentActivity r100, a r101, PluginHost r102, d r103) {
        this.f219751l = 0;
        this.f219740a = r100;
        this.f219747h = r102;
        this.f219741b = r101;
        this.f219742c = r103;
        this.f219743d = new com.bytedance.ee.bear.document.export.net.exportV2.a(r100, i());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(boolean r100, final n r101, final rw4.a r102, final String r110) {
        if (this.f219740a.isFinishing() == false) goto L5;
    L19:
        tt5.a.k("DocumentExportAction", "continue export after comment check failed, activity state invalid");
        r102.onDismiss();
        return;
    L5:
        if (this.f219740a.isDestroyed() == true) goto L19;
        if (this.f219740a.getSupportFragmentManager().isStateSaved() == true) goto L19;
        if (r100 == false) goto L17;
        UDDialog r103 = ((UDActionPanelBuilder) ((UDActionPanelBuilder) ((UDActionPanelBuilder) new UDActionPanelBuilder(this.f219740a).title(R.string.LarkCCM_Docs_Export_Scope_Options)).items(Arrays.asList(new String[]{this.f219740a.getString(R.string.LarkCCM_Docs_Export_Scope_TextCmt_Options), this.f219740a.getString(R.string.LarkCCM_Docs_Export_Scope_Text_Options)})).itemClickListener(new l(this, r101, r110, r102)).addActionButton(R.id.ud_dialog_btn_cancel, R.string.LarkCCM_Docs_Export_Cancel_Button, new m(this, r102, r101))).onCancelListener(new g15.n(r102))).build();
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r103);
    L15:
        this.f219742c.a(r101.f539709a);
        return;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L14:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        goto L15
    L17:
        w(r101, j(), this.f219741b.f219756d, n(r101, r110), r102);
        this.f219742c.f(r101.f539709a);
    }

    public final void t(String r110, String r111, int r112, String r113) {
        if (TextUtils.isEmpty(this.f219750k) == false) goto L5;
        String r100 = r111;
    L7:
        if (this.f219749j <= 0) goto L9;
        long r114 = Math.max(0, SystemClock.elapsedRealtime() - this.f219749j);
    L10:
        boolean r101 = "1".equals(r110);
        if (EffectConfiguration.KEY_SEARCH_WORD.equals(r100) == false) goto L15;
        DocumentExportType r102 = DocumentExportType.WORD;
    L13:
        DocumentExportType r103 = r102;
        if ("1".equals(r110) == false) goto L43;
        String r115 = null;
    L47:
        rw4.c r104 = new rw4.c(r101, r103, r114, r112, r115, sbb.e.d(this.f219741b.f219754b));
        int r105 = w.f479612a;
        Intrinsics.checkNotNullParameter(r104, "result");
        ((rw4.d) LarkContext.spiByDwarf(rw4.d.class)).Z(r104);     // Catch: Throwable -> L50
    L52:
        this.f219749j = 0;
        this.f219750k = null;
        this.f219751l = 0;
        this.f219752m = null;
        return;
    L50:
        th = move-exception;
        tt5.a.e("DocumentExportResultDispatcher", "dispatch export result failed", th, false);
        goto L52
    L43:
        if (TextUtils.isEmpty(r113) == false) goto L45;
        String r106 = "Export failed";
    L46:
        r115 = r106;
        goto L47
    L45:
        r106 = r113;
        goto L46
    L15:
        if ("excel".equals(r100) == false) goto L18;
        r102 = DocumentExportType.EXCEL;
        goto L13
    L18:
        if (ExportFileExtension.PPTX.equals(r100) == false) goto L21;
        r102 = DocumentExportType.PPTX;
        goto L13
    L21:
        if (ExportFileExtension.PDF.equals(r100) == false) goto L24;
        r102 = DocumentExportType.PDF;
        goto L13
    L24:
        if ("markdown".equals(r100) == false) goto L27;
        r102 = DocumentExportType.MARKDOWN;
        goto L13
    L27:
        if ("txt".equals(r100) == false) goto L30;
        r102 = DocumentExportType.TXT;
        goto L13
    L30:
        if ("jpg_long".equals(r100) == false) goto L33;
        r102 = DocumentExportType.JPG_LONG;
        goto L13
    L33:
        if ("image".equals(r100) == false) goto L36;
        r102 = DocumentExportType.IMAGE;
        goto L13
    L36:
        if ("audio".equals(r100) == false) goto L38;
        r102 = DocumentExportType.AUDIO;
        goto L13
    L38:
        r102 = DocumentExportType.UNKNOWN;
        goto L13
    L9:
        r114 = 0;
        goto L10
    L5:
        r100 = this.f219750k;
        goto L7
    }

    public final void w(n r100, String r110, String r111, String r112, rw4.a r113) {
        if (this.f219743d != null) goto L6;
        this.f219743d = new com.bytedance.ee.bear.document.export.net.exportV2.a(this.f219740a, i());
    L6:
        if (r100 != n.f539701c) goto L8;
    L29:
        String r101 = EffectConfiguration.KEY_SEARCH_WORD;
    L30:
        o(r101);
        this.f219743d.a(r100, r110, r111, en4.a.h(), r112, new g15.v(this, r113));
        return;
    L8:
        if (r100 == n.f539703e) goto L29;
        if (r100 != n.f539705g) goto L14;
        r101 = "excel";
        goto L30
    L14:
        if (r100 != n.f539706h) goto L17;
        r101 = ExportFileExtension.PPTX;
        goto L30
    L17:
        if (r100 != n.f539702d) goto L19;
    L28:
        r101 = ExportFileExtension.PDF;
        goto L30
    L19:
        if (r100 == n.f539704f) goto L28;
        if (r100 != n.f539708j) goto L25;
        r101 = "markdown";
        goto L30
    L25:
        if (r100 != n.f539707i) goto L27;
        r101 = "txt";
        goto L30
    L27:
        r101 = "unknown";
        goto L30
    }
}
