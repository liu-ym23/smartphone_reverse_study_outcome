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
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.widgets.OpenLoadingView;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.pb.security_event.ContainerType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.LarkContext;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final FragmentActivity a;
    public final a b;
    public final d c;
    public com.bytedance.ee.bear.document.export.net.exportV2.a d;
    public Disposable e;
    public MinutesExportExecutorImpl f;
    public Dialog g;
    public final PluginHost h;
    public OpenLoadingView i;
    public long j;
    public String k;
    public int l;
    public String m;

    public static final class a {
        public final int a;
        public final int b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;
        public final String h;
        public final boolean i;
        public final String j;
        public final boolean k;
        public final boolean l;
        public final boolean m;
        public final String n;
        public final IDocUserPermission o;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.export.e$a$a, reason: collision with other inner class name */
        public static final class C0073a {
            public int a;
            public int b;
            public String c;
            public String d;
            public String e;
            public String f;
            public String g;
            public String h;
            public boolean i;
            public String j;
            public boolean k;
            public boolean l;
            public boolean m;
            public String n;
            public IDocUserPermission o;

            public C0073a() {
            }
        }

        public int getType() {
            return this.a;
        }

        public a(C0073a r3) {
            this.a = r3.a;
            this.b = r3.b;
            String r0 = r3.c;
            String r1 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            this.c = r0;
            String r2 = r3.d;
            if (r2 != null) goto L8;
            r2 = "";
        L8:
            this.d = r2;
            String r4 = r3.e;
            if (r4 != null) goto L11;
            r4 = "";
        L11:
            this.e = r4;
            String r5 = r3.f;
            if (r5 != null) goto L14;
            r5 = "";
        L14:
            this.f = r5;
            String r6 = r3.g;
            if (r6 != null) goto L17;
            r6 = "";
        L17:
            this.g = r6;
            String r7 = r3.h;
            if (r7 != null) goto L20;
            r7 = "";
        L20:
            this.h = r7;
            this.i = r3.i;
            String r8 = r3.j;
            if (r8 == null) goto L24;
            r1 = r8;
        L24:
            this.j = r1;
            this.k = r3.k;
            this.l = r3.l;
            this.m = r3.m;
            this.n = r3.n;
            this.o = r3.o;
        }
    }

    public static final class b {
        public final boolean a;
        public final boolean b;
        public final boolean c;

        public b(boolean r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c {
        public final boolean a;
        public final PermissionResponse b;

        public c(boolean r1, PermissionResponse r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface d {
        void a(String r1);

        void b(String r1);

        void c(String r1);

        void d(String r1);

        void e(String r1, String r2, String r3);

        void f(String r1);
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.export.e$e, reason: collision with other inner class name */
    public static class C0074e implements d {
        public C0074e() {
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void a(String r1) {
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void b(String r1) {
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void c(String r1) {
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void d(String r1) {
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void e(String r1, String r2, String r3) {
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void f(String r1) {
        }
    }

    public static boolean m() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r1 = LarkContext.getApplication();
        r0.getClass();
        if (((dn4.a) k.b(((v) k.a(r1, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("vc_record_notes_view_three_in_one") == false) goto L5;
    L8:
        boolean r2 = true;
    L9:
        tt5.a.h("DocumentExportAction", "isVcRecordNotesViewThreeInOneEnable: " + r2);
        return r2;
    L5:
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final boolean e() {
        if (this.a.isFinishing() == false) goto L5;
    L9:
        return false;
    L5:
        if (this.a.isDestroyed() == true) goto L9;
        if (this.a.getSupportFragmentManager().isStateSaved() == true) goto L9;
        return true;
    }

    public final String i() {
        if (TextUtils.isEmpty(this.b.e) == true) goto L7;
        return this.b.e;
    L7:
        return ((rc5.a) org.koin.java.a.a(rc5.a.class)).getDocumentDefaultName(this.a, this.b.getType());
    }

    public final String j() {
        return sbb.e.d(this.b.getType()).getType();
    }

    public final void l() {
        Dialog r0 = this.g;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        this.g = null;
        this.i = null;
    }

    public final boolean p() {
        boolean r1 = false;
        if (this.a.isFinishing() == false) goto L5;
    L75:
        tt5.a.k("DocumentExportAction", "open fail, activity or supportFragmentManager invalid");
        return false;
    L5:
        if (this.a.isDestroyed() == true) goto L75;
        if (this.a.getSupportFragmentManager().isStateSaved() == true) goto L75;
        if (CipherManager.d() != 1) goto L14;
        FragmentActivity r0 = this.a;
        Toast.showText(r0, r0.getString(2131887290), 1, true);
        CipherManager.h();
        return false;
    L14:
        if (this.b.getType() == 2) goto L23;
        a r2 = this.b;
        if (r2.b == 2) goto L23;
        if (r2.getType() == 22) goto L23;
        if (this.b.b == 22) goto L23;
        boolean r3 = false;
    L24:
        if (r3 == false) goto L50;
        if (this.b.l == true) goto L28;
    L46:
        u(null);
        return true;
    L28:
        if (m() == false) goto L46;
        if (e() == true) goto L32;
        tt5.a.h("DocumentExportAction", "skip showing three in one download dialog, activity state invalid");
        return true;
    L32:
        String r10 = this.b.n;
        HashMap r11 = new HashMap();
        ArrayList r4 = new ArrayList();
        r4.add("transcript");
        if (this.b.m == false) goto L36;
        r4.add("audio");
    L36:
        if (TextUtils.isEmpty(r10) == false) goto L42;
        tt5.a.k("DocumentExportAction", "show three in one download dialog with empty minutes token");
        Iterator r5 = r4.iterator();
    L39:
        if (r5.hasNext() == false) goto L41;
        r11.put((String) r5.next(), new b(false, false, true));
        goto L39
    L41:
        v(r11);
        return true;
    L42:
        int r12 = r4.size();
        int[] r13 = {0};
        Iterator r14 = r4.iterator();
    L44:
        if (r14.hasNext() == false) goto L81;
        String r16 = (String) r14.next();
        com.bytedance.ee.bear.document.export.d r6 = new com.bytedance.ee.bear.document.export.d(this, r11, r13, r12, r16, r10);
        tt5.a.h("DocumentExportAction", "start minutes action/state validate, optionId = " + r16 + ", token = " + du5.b.k(r10));
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).i0().a().b(r10, 28, "EXPORT", new t(r16, r10, r6));
        goto L44
    L81:
        return true;
    L50:
        if (this.b.getType() != 3) goto L52;
    L55:
        boolean r7 = true;
    L56:
        if (r7 == false) goto L65;
        ((SheetExportViewModel) ViewModelProviders.of(this.a).get(SheetExportViewModel.class)).setDelegate(new com.bytedance.ee.bear.document.export.b(this));
        DialogFragment r8 = Fragment.instantiate(this.a, SheetExportDialogFragment.class.getName());
        Bundle r9 = new Bundle();
        IDocUserPermission r17 = this.b.o;
        if (r17 == null) goto L61;
        r1 = f35.b.h(r17);
    L61:
        r9.putBoolean(ExportMoreItemV2.HAS_PERCEIVE_CONTRAL, r1);
        r8.setArguments(r9);
        a(r8, this.a.getSupportFragmentManager(), SheetExportDialogFragment.class.getName());
        return true;
    L65:
        if (this.b.getType() != 30) goto L67;
    L70:
        boolean r18 = true;
    L71:
        if (r18 == false) goto L73;
        ((SlidesExportViewModel) ViewModelProviders.of(this.a).get(SlidesExportViewModel.class)).setDelegate(new com.bytedance.ee.bear.document.export.c(this));
        a(Fragment.instantiate(this.a, SlidesExportDialogFragment.class.getName()), this.a.getSupportFragmentManager(), SlidesExportDialogFragment.class.getName());
        return true;
    L73:
        tt5.a.k("DocumentExportAction", "open fail, unsupported type = " + this.b.getType() + ", realType = " + this.b.b);
        return false;
    L67:
        if (this.b.b == 30) goto L70;
        r18 = false;
        goto L71
    L52:
        if (this.b.b == 3) goto L55;
        r7 = false;
    L23:
        r3 = true;
        goto L24
    }

    public final Single<Boolean> q() {
        PluginHost r0 = this.h;
        if ((r0 instanceof WebPluginHost) == true) goto L5;
        final vv4.k r1 = null;
    L6:
        if (r1 != null) goto L10;
        tt5.a.h("DocumentExportAction", "query comment state from JSB skipped, document web unavailable");
        return r();
    L10:
        return Single.create(new o(r1)).timeout(3, TimeUnit.SECONDS).onErrorResumeNext(new p(this));
    L5:
        r1 = ((WebPluginHost) r0).getWeb();
        goto L6
    }

    public final Single<Boolean> r() {
        new tj5.k();
        a r0 = this.b;
        return tj5.k.a(r0.b, r0.d).map(new f()).firstOrError().timeout(3, TimeUnit.SECONDS).doOnError(new g()).onErrorReturnItem(Boolean.TRUE);
    }

    public static void g(a r5) {
        com.bytedance.ee.bear.middleground_permission_export.model.c r0 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.c.class);
        sbb.e r1 = sbb.e.d(r5.b);
        String r2 = r5.d;
        boolean r3 = r5.i;
        if (r3 == false) goto L5;
        ContainerType r4 = ContainerType.Wiki;
    L6:
        if (r3 == false) goto L8;
        String r6 = r5.j;
    L9:
        r0.e(r1, r2, r4, r6);
        return;
    L8:
        r6 = "";
        goto L9
    L5:
        r4 = ContainerType.ContainerTypeUnknown;
        goto L6
    }

    public static void h(a r3) {
        ((zk5.a) org.koin.java.a.a(zk5.a.class)).a(r3.getType(), r3.d, "download");
    }

    public final void k(String r11) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r0 = jg5.e.a.a.g();
        c r1 = x(r11);
        if (r1.a == false) goto L5;
        return;
    L5:
        String r5 = this.b.n;
        if (r0 == false) goto L14;
        PermissionResponse r2 = r1.b;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.getCallback() == null) goto L18;
        tt5.a.h("DocumentExportAction", "handle disabled minutes download by permission platform, optionId = " + r11);
        r1.b.getCallback().a(this.a, r1.b);
        return;
    L18:
        return;
    L14:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        tt5.a.h("DocumentExportAction", "handle disabled minutes download by security dialog, optionId = " + r11);
        gj5.b r3 = (gj5.b) org.koin.java.a.a(gj5.b.class);
        FileBizDomain r4 = FileBizDomain.FileBizDomainCCM;
        a r12 = this.b;
        r3.b(r4, r5, r12.f, r12.g, 28, FileBizDomain.FileBizDomainMeetingMinutes);
        return;
    }

    public final void o(String r3) {
        this.j = SystemClock.elapsedRealtime();
        this.k = r3;
        this.l = 0;
        this.m = null;
    }

    public final void s(String r4) {
        this.c.d(r4);
        t(DiagramData$RESULT.FAIL, r4, 0, "Cancelled");
    }

    public final void u(String r7) {
        DocExportViewModel r0 = (DocExportViewModel) ViewModelProviders.of(this.a).get(DocExportViewModel.class);
        r0.setDelegate(new com.bytedance.ee.bear.document.export.a(this, r0, r7));
        boolean r1 = false;
        if (this.b.l == true) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L22;
        DialogFragment r3 = (DialogFragment) Fragment.instantiate(this.a, DocExportChooseDialogFragment.class.getName());
        IDocUserPermission r4 = this.b.o;
        if (r4 == null) goto L15;
        r1 = f35.b.h(r4);
    L15:
        if ("vc_summary_tab".equals(r7) == false) goto L18;
        String r5 = "summary";
    L21:
        int r6 = DocExportChooseDialogFragment.z;
        Bundle r8 = new Bundle();
        r8.putBoolean(ExportMoreItemV2.HAS_PERCEIVE_CONTRAL, r1);
        r8.putString("arg_export_scene", r7);
        r8.putString("arg_audio_minutes_export_target", r5);
        r3.setArguments(r8);
        String r9 = DocExportChooseDialogFragment.class.getName();
    L27:
        a(r3, this.a.getSupportFragmentManager(), r9);
        return;
    L18:
        if ("vc_transcript_tab".equals(r7) == false) goto L20;
        r5 = "transcript";
        goto L21
    L20:
        r5 = null;
        goto L21
    L22:
        r3 = Fragment.instantiate(this.a, DocExportDialogFragment.class.getName());
        IDocUserPermission r10 = this.b.o;
        if (r10 == null) goto L26;
        r1 = f35.b.h(r10);
    L26:
        int r11 = DocExportDialogFragment.s;
        Bundle r12 = new Bundle();
        r12.putBoolean(ExportMoreItemV2.HAS_PERCEIVE_CONTRAL, r1);
        r12.putString("arg_export_scene", r7);
        r3.setArguments(r12);
        r9 = DocExportDialogFragment.class.getName();
        goto L27
    L5:
        if (m() == false) goto L7;
        r2 = true;
        goto L9
    }

    public final void v(Map<String, b> r12) {
        if (e() == true) goto L6;
        tt5.a.h("DocumentExportAction", "skip showing three in one download dialog after action/state, activity state invalid");
        return;
    L6:
        FragmentActivity r0 = this.a;
        String r1 = r0.getString(2131889785);
        ArrayList r2 = new ArrayList();
        String r4 = this.a.getString(2131889782);
        Intrinsics.checkNotNullParameter("summary", "id");
        Intrinsics.checkNotNullParameter(r4, "title");
        boolean r7 = true;
        r2.add(new SelectDownloadDialogFragment.b("summary", r4, true));
        b r5 = r12.get("transcript");
        String r8 = this.a.getString(2131889784);
        if (r5 != null) goto L9;
    L18:
        boolean r6 = false;
    L19:
        r2.add(new SelectDownloadDialogFragment.b("transcript", r8, r6));
        if (this.b.m == false) goto L35;
        b r13 = r12.get("audio");
        String r9 = this.a.getString(2131889783);
        if (r13 != null) goto L24;
    L33:
        r7 = false;
    L34:
        r2.add(new SelectDownloadDialogFragment.b("audio", r9, r7));
        goto L35
    L24:
        if (r13.b == true) goto L26;
    L30:
        boolean r14 = false;
    L31:
        if (r14 == false) goto L33;
    L26:
        if (r13.a == false) goto L30;
        if (r13.c == true) goto L30;
        r14 = true;
    L35:
        SelectDownloadDialogFragment.d r16 = new i(this);
        SelectDownloadDialogFragment.c r3 = new j(this);
        int r10 = SelectDownloadDialogFragment.n;
        Intrinsics.checkNotNullParameter(r1, "title");
        Intrinsics.checkNotNullParameter(r2, "options");
        if (r0.getSupportFragmentManager().isStateSaved() == true) goto L47;
        SelectDownloadDialogFragment r11 = SelectDownloadDialogFragment.a.a(r1, r2);
        r11.h = r16;
        r11.i = r3;
        FragmentManager r17 = r0.getSupportFragmentManager();
        LandscapeRestrictionOperation r18 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r11, "SelectDownloadDialog", r18);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r17, r11, r18) == true) goto L48;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
    L42:
        r11.show(r17, "SelectDownloadDialog");
        return;
    L48:
        return;
    L47:
        return;
    L9:
        if (r5.b == true) goto L11;
    L15:
        boolean r19 = false;
    L16:
        if (r19 == false) goto L18;
        r6 = true;
        goto L19
    L11:
        if (r5.a == false) goto L15;
        if (r5.c == true) goto L15;
        r19 = true;
        goto L16
    }

    public final c x(String r18) {
        String r2 = this.b.n;
        boolean r12 = false;
        if (TextUtils.isEmpty(r2) == false) goto L6;
        tt5.a.k("DocumentExportAction", "minutes download permission hidden, token is empty, optionId = " + r18);
        return new c(false, null);
    L6:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r3 = jg5.e.a.a.g();
        a r4 = this.b;
        IDocUserPermission r8 = r4.o;
        if (r3 == false) goto L23;
        if (r8 != null) goto L11;
        tt5.a.k("DocumentExportAction", "minutes download permission disabled, userPermission is null, optionId = " + r18);
        return new c(false, null);
    L11:
        int r1 = f35.b.a;
        PermissionResponse r5 = f35.b.e(r2, sbb.e.q, r4.g, "EXPORT", BizDomain.FileBizDomainCCM, r8, r4.f, FileBizDomain.FileBizDomainMeetingMinutes, "MeetingMinutes");
        PermissionResponse.Companion.getClass();
        boolean r6 = !PermissionResponse.a.e(r5);
        if (r6 == false) goto L14;
    L16:
        boolean r7 = false;
    L18:
        if (r6 == true) goto L22;
        if (r7 == true) goto L22;
        r12 = true;
    L22:
        return new c(r12, r5);
    L14:
        if (((ph5.c) org.koin.java.a.a(ph5.c.class)).e(r5) == true) goto L16;
        r7 = true;
        goto L18
    L23:
        gj5.b r9 = (gj5.b) org.koin.java.a.a(gj5.b.class);
        FileBizDomain r10 = FileBizDomain.FileBizDomainCCM;
        a r11 = this.b;
        boolean r13 = r9.e("CCM_EXPORT", r10, 28, r2, r11.f, r11.g, 28, false, FileBizDomain.FileBizDomainMeetingMinutes, null, "MeetingMinutes").a;
        if (r13 == true) goto L27;
        tt5.a.h("DocumentExportAction", "minutes download permission disabled by security policy, optionId = " + r18 + ", token = " + du5.b.k(r2));
    L27:
        return new c(r13, null);
    }

    public static void b(e r3, String r4) {
        r3.c.c(r4);
        r3.t(DiagramData$RESULT.FAIL, r4, r3.l, r3.m);
    }

    public static void d(e r3, String r4) {
        r3.c.b(r4);
        r3.t(DiagramData$RESULT.SUCCESS, r4, 0, null);
    }

    public final String n(n r4, String r5) {
        if (this.b.getType() == 22) goto L8;
        if (this.b.b == 22) goto L8;
        return r5;
    L8:
        if (r4 == n.c) goto L13;
        if (r4 == n.e) goto L13;
        return r5;
    L13:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.sheet.new_chart_style") == false) goto L15;
        String r6 = "2";
    L25:
    L22:
        e = move-exception;
        tt5.a.e("DocumentExportAction", "makeExportPassbackIfNeeded: build payload failed", e, false);
        return r5;
    L17:
        if (TextUtils.isEmpty(r5) == false) goto L19;
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L22
    L20:
        r0.put("chart_sve", r6);     // Catch: JSONException -> L22
        return r0.toString();
    L19:
        r0 = new JSONObject(r5);     // Catch: JSONException -> L22
        goto L20
    L15:
        r6 = DiagramData$RESULT.SUCCESS;
        goto L25
    }

    public static void a(DialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static void c(e r0, int r1, Throwable r2) {
        r0.l = r1;
        if (r2 == null) goto L5;
        String r3 = r2.getMessage();
    L6:
        r0.m = r3;
        if (TextUtils.isEmpty(r3) == false) goto L11;
        if (r2 == null) goto L12;
        r0.m = r2.getClass().getSimpleName();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public e(FragmentActivity r2, a r3, PluginHost r4, d r5) {
        this.l = 0;
        this.a = r2;
        this.h = r4;
        this.b = r3;
        this.c = r5;
        this.d = new com.bytedance.ee.bear.document.export.net.exportV2.a(r2, i());
    }

    public final void f(boolean r7, final n r8, final rw4.a r9, final String r10) {
        if (this.a.isFinishing() == false) goto L5;
    L19:
        tt5.a.k("DocumentExportAction", "continue export after comment check failed, activity state invalid");
        r9.onDismiss();
        return;
    L5:
        if (this.a.isDestroyed() == true) goto L19;
        if (this.a.getSupportFragmentManager().isStateSaved() == true) goto L19;
        if (r7 == false) goto L17;
        UDDialog r11 = new UDActionPanelBuilder(this.a).title(2131889063).items(Arrays.asList(new String[]{this.a.getString(2131889064), this.a.getString(2131889065)})).itemClickListener(new l(this, r8, r10, r9)).addActionButton(2131391775, 2131889062, new m(this, r9, r8)).onCancelListener(new g15.n(r9)).build();
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r11);
    L15:
        this.c.a(r8.a);
        return;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L14:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        goto L15
    L17:
        w(r8, j(), this.b.d, n(r8, r10), r9);
        this.c.f(r8.a);
    }

    public final void t(String r16, String r17, int r18, String r19) {
        if (TextUtils.isEmpty(this.k) == false) goto L5;
        String r2 = r17;
    L7:
        if (this.j <= 0) goto L9;
        long r10 = Math.max(0, SystemClock.elapsedRealtime() - this.j);
    L10:
        boolean r8 = DiagramData$RESULT.SUCCESS.equals(r16);
        if ("word".equals(r2) == false) goto L15;
        DocumentExportType r3 = DocumentExportType.WORD;
    L13:
        DocumentExportType r9 = r3;
        if (DiagramData$RESULT.SUCCESS.equals(r16) == false) goto L43;
        String r13 = null;
    L47:
        rw4.c r4 = new rw4.c(r8, r9, r10, r18, r13, sbb.e.d(this.b.b));
        int r0 = w.a;
        Intrinsics.checkNotNullParameter(r4, TipCallBackData.RESULT);
        ((rw4.d) LarkContext.spiByDwarf(rw4.d.class)).Z(r4);     // Catch: Throwable -> L50
    L52:
        this.j = 0;
        this.k = null;
        this.l = 0;
        this.m = null;
        return;
    L50:
        th = move-exception;
        tt5.a.e("DocumentExportResultDispatcher", "dispatch export result failed", th, false);
        goto L52
    L43:
        if (TextUtils.isEmpty(r19) == false) goto L45;
        String r1 = "Export failed";
    L46:
        r13 = r1;
        goto L47
    L45:
        r1 = r19;
        goto L46
    L15:
        if ("excel".equals(r2) == false) goto L18;
        r3 = DocumentExportType.EXCEL;
        goto L13
    L18:
        if ("pptx".equals(r2) == false) goto L21;
        r3 = DocumentExportType.PPTX;
        goto L13
    L21:
        if ("pdf".equals(r2) == false) goto L24;
        r3 = DocumentExportType.PDF;
        goto L13
    L24:
        if ("markdown".equals(r2) == false) goto L27;
        r3 = DocumentExportType.MARKDOWN;
        goto L13
    L27:
        if ("txt".equals(r2) == false) goto L30;
        r3 = DocumentExportType.TXT;
        goto L13
    L30:
        if ("jpg_long".equals(r2) == false) goto L33;
        r3 = DocumentExportType.JPG_LONG;
        goto L13
    L33:
        if ("image".equals(r2) == false) goto L36;
        r3 = DocumentExportType.IMAGE;
        goto L13
    L36:
        if ("audio".equals(r2) == false) goto L38;
        r3 = DocumentExportType.AUDIO;
        goto L13
    L38:
        r3 = DocumentExportType.UNKNOWN;
        goto L13
    L9:
        r10 = 0;
        goto L10
    L5:
        r2 = this.k;
        goto L7
    }

    public final void w(n r9, String r10, String r11, String r12, rw4.a r13) {
        if (this.d != null) goto L6;
        this.d = new com.bytedance.ee.bear.document.export.net.exportV2.a(this.a, i());
    L6:
        if (r9 != n.c) goto L8;
    L29:
        String r0 = "word";
    L30:
        o(r0);
        this.d.a(r9, r10, r11, en4.a.h(), r12, new g15.v(this, r13));
        return;
    L8:
        if (r9 == n.e) goto L29;
        if (r9 != n.g) goto L14;
        r0 = "excel";
        goto L30
    L14:
        if (r9 != n.h) goto L17;
        r0 = "pptx";
        goto L30
    L17:
        if (r9 != n.d) goto L19;
    L28:
        r0 = "pdf";
        goto L30
    L19:
        if (r9 == n.f) goto L28;
        if (r9 != n.j) goto L25;
        r0 = "markdown";
        goto L30
    L25:
        if (r9 != n.i) goto L27;
        r0 = "txt";
        goto L30
    L27:
        r0 = "unknown";
        goto L30
    }
}
