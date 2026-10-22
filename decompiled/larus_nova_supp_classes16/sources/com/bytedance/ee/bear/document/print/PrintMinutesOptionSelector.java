package com.bytedance.ee.bear.document.print;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.document.export.dialog.SelectDownloadDialogFragment;
import com.bytedance.ee.bear.document.quota.ShowQuotaBannerPlugin;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiStyle;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class PrintMinutesOptionSelector {
    public static final /* synthetic */ int e = 0;
    public final FragmentActivity a;
    public long b;
    public boolean c;
    public SelectDownloadDialogFragment d;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final PermissionResponse b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            PermissionResponse r2 = this.b;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "PermissionResult(allow=" + this.a + ", response=" + this.b + ')';
        }

        public b(boolean r1, PermissionResponse r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements SelectDownloadDialogFragment.d {
        public final /* synthetic */ PrintMinutesOptionSelector a;
        public final /* synthetic */ long b;
        public final /* synthetic */ oj5.c c;
        public final /* synthetic */ Function0<Unit> d;
        public final /* synthetic */ Function0<Unit> e;
        public final /* synthetic */ Function1<String, Unit> f;

        /* JADX WARN: Multi-variable type inference failed */
        public c(PrintMinutesOptionSelector r1, long r2, oj5.c r4, Function0<Unit> r5, Function0<Unit> r6, Function1<? super String, Unit> r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        @Override // com.bytedance.ee.bear.document.export.dialog.SelectDownloadDialogFragment.d
        public final void a(SelectDownloadDialogFragment.b r5, int r6) {
            Intrinsics.checkNotNullParameter(r5, "option");
            if (this.a.f(this.b) == true) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r5.a, "transcript") == false) goto L14;
            b r7 = PrintMinutesOptionSelector.b(this.a, this.c);
            if (r7.a == true) goto L14;
            PrintMinutesOptionSelector.a(this.a, this.c, r7);
            PrintMinutesOptionSelector r8 = this.a;
            long r2 = this.b;
            Function0<Unit> r9 = this.d;
            if (r8.g(r2) == false) goto L34;
            r8.d = null;
            r9.invoke();
            return;
        L34:
            return;
        L14:
            PrintMinutesOptionSelector r10 = this.a;
            String r11 = r5.a;
            r10.getClass();
            if (Intrinsics.areEqual(r11, "summary") == false) goto L18;
            String r12 = "vc_summary_tab";
        L32:
            String r13 = new JSONObject().put("tab_type", r12).put("time_zone_offset", (-TimeZone.getDefault().getOffset(System.currentTimeMillis())) / ShowQuotaBannerPlugin.NEED_SHOW_CREATE_TIME_INTERVAL).toString();     // Catch: JSONException -> L22
        L25:
            if (r13 != null) goto L27;
            this.a.d(this.b, this.e);
            return;
        L27:
            PrintMinutesOptionSelector r14 = this.a;
            long r3 = this.b;
            Function1<String, Unit> r0 = this.f;
            if (r14.g(r3) == false) goto L36;
            r14.d = null;
            r0.invoke(r13);
            return;
        L36:
            return;
        L22:
            e = move-exception;
            tt5.a.e("PrintMinutesOptionSelector", "build print minutes passback failed, tabType=".concat(r12), e, false);
        L24:
            r13 = null;
            goto L25
        L18:
            if (Intrinsics.areEqual(r11, "transcript") == false) goto L24;
            r12 = "vc_transcript_tab";
            goto L32
        }
    }

    public static final class d implements SelectDownloadDialogFragment.c {
        public final /* synthetic */ PrintMinutesOptionSelector a;
        public final /* synthetic */ long b;
        public final /* synthetic */ oj5.c c;
        public final /* synthetic */ Function0<Unit> d;

        public d(PrintMinutesOptionSelector r1, long r2, oj5.c r4, Function0<Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        @Override // com.bytedance.ee.bear.document.export.dialog.SelectDownloadDialogFragment.c
        public final void a(SelectDownloadDialogFragment.b r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "option");
            if (this.a.f(this.b) == true) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r3.a, "transcript") == false) goto L8;
            PrintMinutesOptionSelector r5 = this.a;
            oj5.c r6 = this.c;
            PrintMinutesOptionSelector.a(r5, r6, PrintMinutesOptionSelector.b(r5, r6));
        L8:
            PrintMinutesOptionSelector r7 = this.a;
            long r0 = this.b;
            Function0<Unit> r8 = this.d;
            if (r7.g(r0) == false) goto L13;
            r7.d = null;
            r8.invoke();
            return;
        }
    }

    static {
    }

    public final void c() {
        SelectDownloadDialogFragment r0 = this.d;
        this.d = null;
        if (r0 == null) goto L15;
        r0.h = null;
        r0.i = null;
        r0.j = null;
        if (r0.isAdded() == false) goto L16;
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L17:
        return;
    L16:
        return;
    }

    public PrintMinutesOptionSelector(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
    }

    public static b i(oj5.c r13) {
        String r4 = r13.N();
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L18;
        int r0 = f35.b.a;
        PermissionResponse r14 = f35.b.e(r4, sbb.e.q, r13.a(), "EXPORT", BizDomain.FileBizDomainCCM, r13.c().a, r13.t(), FileBizDomain.FileBizDomainMeetingMinutes, "MeetingMinutes");
        return new b(r14.getAllow(), r14);
    L18:
        return new b(((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).e("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, 28, r4, r13.t(), r13.a(), 28, false, FileBizDomain.FileBizDomainMeetingMinutes, null, "MeetingMinutes").a, null);
    L12:
        return new b(false, null);
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r1 = false;
        goto L10
    }

    public final boolean f(long r4) {
        if (this.b != r4) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean g(long r1) {
        if (f(r1) == true) goto L5;
        return false;
    L5:
        if (this.c == true) goto L11;
        this.c = true;
        return true;
    L11:
        return false;
    }

    public static final b b(PrintMinutesOptionSelector r1, oj5.c r2) {
        r1.getClass();
        return i(r2);
    L5:
        th = move-exception;
        tt5.a.d("PrintMinutesOptionSelector", "validate transcript print permission failed: ".concat(th.getClass().getSimpleName()));
        return new b(false, null);
    }

    public final void d(long r1, Function0<Unit> r3) {
        if (g(r1) == true) goto L5;
        return;
    L5:
        c();
        r3.invoke();
    }

    public final void e(oj5.c r9, b r10) {
        if (r10.a == false) goto L5;
        return;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L16;
        PermissionResponse r11 = r10.b;
        if (r11 != null) goto L11;
        return;
    L11:
        if (r11.getDenySource().getDenyType() != DenyType.DLP_SENSATIVE) goto L14;
        r11.setUiStyle(new UiStyle(this.a.getString(2131889218)));
    L14:
        r11.getCallback().a(this.a, r11);
        return;
    L16:
        String r3 = r9.N();
        if (r3 != null) goto L19;
    L22:
        boolean r12 = true;
    L23:
        if (r12 == false) goto L25;
        return;
    L25:
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).b(FileBizDomain.FileBizDomainCCM, r3, r9.t(), r9.a(), 28, FileBizDomain.FileBizDomainMeetingMinutes);
        return;
    L19:
        if (StringsKt.isBlank(r3) == true) goto L22;
        r12 = false;
        goto L23
    }

    public static final void a(PrintMinutesOptionSelector r0, oj5.c r1, b r2) {
        r0.getClass();
        r0.e(r1, r2);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.d("PrintMinutesOptionSelector", "handle transcript print permission denied failed: ".concat(th.getClass().getSimpleName()));
    }

    public final void h(final long r16, oj5.c r18, boolean r19, Function1<? super String, Unit> r20, final Function0<Unit> r21, Function0<Unit> r22) {
        if (f(r16) == true) goto L6;
        return;
    L6:
        if (this.a.isFinishing() == false) goto L8;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == true) goto L16;
        d(r16, r22);
        return;
    L16:
        List r2 = CollectionsKt.listOf(new SelectDownloadDialogFragment.b[]{new SelectDownloadDialogFragment.b("summary", this.a.getString(2131889786), true), new SelectDownloadDialogFragment.b("transcript", this.a.getString(2131889788), r19)});
        int r3 = SelectDownloadDialogFragment.n;
        SelectDownloadDialogFragment r13 = SelectDownloadDialogFragment.a.a(this.a.getString(2131889787), r2);
        r13.h = new c(this, r16, r18, r21, r22, r20);
        r13.i = new d(this, r16, r18, r21);
        r13.j = new PrintMinutesOptionSelector$showOptions$3(this, r16, r21);
        this.d = r13;
        FragmentManager r4 = this.a.getSupportFragmentManager();     // Catch: RuntimeException -> L26
        String r0 = "PrintMinutesOptionDialog_" + r16;     // Catch: RuntimeException -> L26
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: RuntimeException -> L26
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, r0, r5);     // Catch: RuntimeException -> L26
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r13, r5) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L21:
        r13.showNow(r4, r0);     // Catch: RuntimeException -> L26
    L23:
        if (r13.isAdded() == true) goto L34;
        d(r16, r22);     // Catch: RuntimeException -> L26
        return;
    L34:
        return;
    L26:
        e = move-exception;
        tt5.a.k("PrintMinutesOptionSelector", "show print minutes options failed: ".concat(e.getClass().getSimpleName()));
        d(r16, r22);
        return;
    L8:
        if (this.a.isDestroyed() == true) goto L12;
        if (this.a.getSupportFragmentManager().isStateSaved() == true) goto L12;
        r1 = true;
        goto L13
    }
}
