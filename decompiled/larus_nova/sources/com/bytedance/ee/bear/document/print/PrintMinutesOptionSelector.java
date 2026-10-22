package com.bytedance.ee.bear.document.print;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.document.export.dialog.SelectDownloadDialogFragment;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiStyle;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.List;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class PrintMinutesOptionSelector {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f221126e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f221127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f221128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f221129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SelectDownloadDialogFragment f221130d;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f221131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PermissionResponse f221132b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f221131a == r101.f221131a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f221132b, r101.f221132b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f221131a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            PermissionResponse r102 = this.f221132b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "PermissionResult(allow=" + this.f221131a + ", response=" + this.f221132b + ')';
        }

        public b(boolean r100, PermissionResponse r101) {
            this.f221131a = r100;
            this.f221132b = r101;
        }
    }

    public static final class c implements SelectDownloadDialogFragment.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrintMinutesOptionSelector f221133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f221134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ oj5.c f221135c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f221136d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f221137e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function1<String, Unit> f221138f;

        /* JADX WARN: Multi-variable type inference failed */
        public c(PrintMinutesOptionSelector r100, long r101, oj5.c r102, Function0<Unit> r103, Function0<Unit> r104, Function1<? super String, Unit> r105) {
            this.f221133a = r100;
            this.f221134b = r101;
            this.f221135c = r102;
            this.f221136d = r103;
            this.f221137e = r104;
            this.f221138f = r105;
        }

        @Override // com.bytedance.ee.bear.document.export.dialog.SelectDownloadDialogFragment.d
        public final void a(SelectDownloadDialogFragment.b r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "option");
            if (this.f221133a.f(this.f221134b) == true) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r100.f219731a, "transcript") == false) goto L14;
            b r102 = PrintMinutesOptionSelector.b(this.f221133a, this.f221135c);
            if (r102.f221131a == true) goto L14;
            PrintMinutesOptionSelector.a(this.f221133a, this.f221135c, r102);
            PrintMinutesOptionSelector r103 = this.f221133a;
            long r104 = this.f221134b;
            Function0<Unit> r105 = this.f221136d;
            if (r103.g(r104) == false) goto L34;
            r103.f221130d = null;
            r105.invoke();
            return;
        L34:
            return;
        L14:
            PrintMinutesOptionSelector r106 = this.f221133a;
            String r107 = r100.f219731a;
            r106.getClass();
            if (Intrinsics.areEqual(r107, "summary") == false) goto L18;
            String r108 = "vc_summary_tab";
        L32:
            String r109 = new JSONObject().put("tab_type", r108).put("time_zone_offset", (-TimeZone.getDefault().getOffset(System.currentTimeMillis())) / 60000).toString();     // Catch: JSONException -> L22
        L25:
            if (r109 != null) goto L27;
            this.f221133a.d(this.f221134b, this.f221137e);
            return;
        L27:
            PrintMinutesOptionSelector r110 = this.f221133a;
            long r111 = this.f221134b;
            Function1<String, Unit> r112 = this.f221138f;
            if (r110.g(r111) == false) goto L36;
            r110.f221130d = null;
            r112.invoke(r109);
            return;
        L36:
            return;
        L22:
            e = move-exception;
            tt5.a.e("PrintMinutesOptionSelector", "build print minutes passback failed, tabType=".concat(r108), e, false);
        L24:
            r109 = null;
            goto L25
        L18:
            if (Intrinsics.areEqual(r107, "transcript") == false) goto L24;
            r108 = "vc_transcript_tab";
            goto L32
        }
    }

    public static final class d implements SelectDownloadDialogFragment.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrintMinutesOptionSelector f221139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f221140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ oj5.c f221141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f221142d;

        public d(PrintMinutesOptionSelector r100, long r101, oj5.c r102, Function0<Unit> r103) {
            this.f221139a = r100;
            this.f221140b = r101;
            this.f221141c = r102;
            this.f221142d = r103;
        }

        @Override // com.bytedance.ee.bear.document.export.dialog.SelectDownloadDialogFragment.c
        public final void a(SelectDownloadDialogFragment.b r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "option");
            if (this.f221139a.f(this.f221140b) == true) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r100.f219731a, "transcript") == false) goto L8;
            PrintMinutesOptionSelector r102 = this.f221139a;
            oj5.c r103 = this.f221141c;
            PrintMinutesOptionSelector.a(r102, r103, PrintMinutesOptionSelector.b(r102, r103));
        L8:
            PrintMinutesOptionSelector r104 = this.f221139a;
            long r105 = this.f221140b;
            Function0<Unit> r106 = this.f221142d;
            if (r104.g(r105) == false) goto L13;
            r104.f221130d = null;
            r106.invoke();
            return;
        }
    }

    static {
    }

    public final void c() {
        SelectDownloadDialogFragment r100 = this.f221130d;
        this.f221130d = null;
        if (r100 == null) goto L15;
        r100.f219725h = null;
        r100.f219726i = null;
        r100.f219727j = null;
        if (r100.isAdded() == false) goto L16;
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L17;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L17:
        return;
    L16:
        return;
    }

    public PrintMinutesOptionSelector(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f221127a = r100;
    }

    public static b i(oj5.c r110) {
        String r100 = r110.N();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == true) goto L12;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L18;
        int r102 = f35.b.f475390a;
        PermissionResponse r111 = f35.b.e(r100, sbb.e.f541306q, r110.a(), "EXPORT", BizDomain.FileBizDomainCCM, r110.c().f234419a, r110.t(), FileBizDomain.FileBizDomainMeetingMinutes, "MeetingMinutes");
        return new b(r111.getAllow(), r111);
    L18:
        return new b(((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).e("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, 28, r100, r110.t(), r110.a(), 28, false, FileBizDomain.FileBizDomainMeetingMinutes, null, "MeetingMinutes").f481503a, null);
    L12:
        return new b(false, null);
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L10
    }

    public final boolean f(long r100) {
        if (this.f221128b != r100) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean g(long r100) {
        if (f(r100) == true) goto L5;
        return false;
    L5:
        if (this.f221129c == true) goto L11;
        this.f221129c = true;
        return true;
    L11:
        return false;
    }

    public static final b b(PrintMinutesOptionSelector r100, oj5.c r101) {
        r100.getClass();
        return i(r101);
    L5:
        th = move-exception;
        tt5.a.d("PrintMinutesOptionSelector", "validate transcript print permission failed: ".concat(th.getClass().getSimpleName()));
        return new b(false, null);
    }

    public final void d(long r100, Function0<Unit> r101) {
        if (g(r100) == true) goto L5;
        return;
    L5:
        c();
        r101.invoke();
    }

    public final void e(oj5.c r100, b r110) {
        if (r110.f221131a == false) goto L5;
        return;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L16;
        PermissionResponse r101 = r110.f221132b;
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.getDenySource().getDenyType() != DenyType.DLP_SENSATIVE) goto L14;
        r101.setUiStyle(new UiStyle(this.f221127a.getString(R.string.LarkCCM_Docs_Print_SensitiveInfoPolicy_Toast)));
    L14:
        r101.getCallback().a(this.f221127a, r101);
        return;
    L16:
        String r102 = r100.N();
        if (r102 != null) goto L19;
    L22:
        boolean r111 = true;
    L23:
        if (r111 == false) goto L25;
        return;
    L25:
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).b(FileBizDomain.FileBizDomainCCM, r102, r100.t(), r100.a(), 28, FileBizDomain.FileBizDomainMeetingMinutes);
        return;
    L19:
        if (StringsKt.isBlank(r102) == true) goto L22;
        r111 = false;
        goto L23
    }

    public static final void a(PrintMinutesOptionSelector r100, oj5.c r101, b r102) {
        r100.getClass();
        r100.e(r101, r102);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.d("PrintMinutesOptionSelector", "handle transcript print permission denied failed: ".concat(th.getClass().getSimpleName()));
    }

    public final void h(final long r110, oj5.c r111, boolean r112, Function1<? super String, Unit> r210, final Function0<Unit> r211, Function0<Unit> r212) {
        if (f(r110) == true) goto L6;
        return;
    L6:
        if (this.f221127a.isFinishing() == false) goto L8;
    L12:
        boolean r100 = false;
    L13:
        if (r100 == true) goto L16;
        d(r110, r212);
        return;
    L16:
        List r101 = CollectionsKt.listOf(new SelectDownloadDialogFragment.b[]{new SelectDownloadDialogFragment.b("summary", this.f221127a.getString(R.string.LarkCCM_VC_Docs_PrintNotes_Notes_Option), true), new SelectDownloadDialogFragment.b("transcript", this.f221127a.getString(R.string.LarkCCM_VC_Docs_PrintNotes_Transcript_Option), r112)});
        int r102 = SelectDownloadDialogFragment.f219724n;
        SelectDownloadDialogFragment r113 = SelectDownloadDialogFragment.a.a(this.f221127a.getString(R.string.LarkCCM_VC_Docs_PrintNotes_Title), r101);
        r113.f219725h = new c(this, r110, r111, r211, r212, r210);
        r113.f219726i = new d(this, r110, r111, r211);
        r113.f219727j = new PrintMinutesOptionSelector$showOptions$3(this, r110, r211);
        this.f221130d = r113;
        FragmentManager r103 = this.f221127a.getSupportFragmentManager();     // Catch: RuntimeException -> L26
        String r104 = "PrintMinutesOptionDialog_" + r110;     // Catch: RuntimeException -> L26
        LandscapeRestrictionOperation r105 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: RuntimeException -> L26
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r113, r104, r105);     // Catch: RuntimeException -> L26
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r103, r113, r105) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L21:
        r113.showNow(r103, r104);     // Catch: RuntimeException -> L26
    L23:
        if (r113.isAdded() == true) goto L34;
        d(r110, r212);     // Catch: RuntimeException -> L26
        return;
    L34:
        return;
    L26:
        e = move-exception;
        tt5.a.k("PrintMinutesOptionSelector", "show print minutes options failed: ".concat(e.getClass().getSimpleName()));
        d(r110, r212);
        return;
    L8:
        if (this.f221127a.isDestroyed() == true) goto L12;
        if (this.f221127a.getSupportFragmentManager().isStateSaved() == true) goto L12;
        r100 = true;
        goto L13
    }
}
