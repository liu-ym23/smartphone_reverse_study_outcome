package com.bytedance.ee.bear.list.office.longpress;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.rename.core.OfficeRenameCore;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c0 {
    public static final c0 a = null;
    public static final ConcurrentHashMap<String, Dialog> b = null;
    public static final ConcurrentHashMap<String, Function0<Unit>> c = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> d = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> e = null;

    public static final class a {
        public static final /* synthetic */ int d = 0;
        public final String a;
        public final String b;
        public final int c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.list.office.longpress.c0$a$a, reason: collision with other inner class name */
        public static final class C0029a {
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "RenameNameSpec(editableName=" + this.a + ", originSuffix=" + this.b + ')';
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "editableName");
            Intrinsics.checkNotNullParameter(r3, "originSuffix");
            this.a = r2;
            this.b = r3;
            this.c = r2.length();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c b;
        public final /* synthetic */ oj5.a c;

        public b(FragmentActivity r1, com.bytedance.ee.bear.more.office.c r2, oj5.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            DocPermission r5 = (DocPermission) r4;
            c0 r0 = c0.a;
            FragmentActivity r1 = this.a;
            if (r1.isFinishing() == false) goto L5;
        L7:
            boolean r2 = false;
        L9:
            if (r2 == true) goto L11;
            tt5.a.h("OfficeRenameActionExecutor", "drop rename permission result because activity inactive. actionId=" + this.b.a);
            Toast.cancelLoading();
            c0.f(this.b.a);
            return;
        L11:
            tt5.a.h("OfficeRenameActionExecutor", "fetch rename permission success. actionId=" + this.b.a + ", type=" + this.c.getType());
            oj5.a r3 = this.c;
            Intrinsics.checkNotNull(r5);
            r3.getClass();
            Intrinsics.checkNotNullParameter(r5, "docPermission");
            r3.i = r5;
            Toast.cancelLoading();
            CompositeDisposable r6 = c0.d.remove(this.b.a);
            if (r6 == null) goto L14;
            r6.clear();
        L14:
            FragmentActivity r7 = this.a;
            com.bytedance.ee.bear.more.office.c r8 = this.b;
            com.bytedance.ee.bear.more.office.a r9 = c0.d(r8, null);
            if ((r9 instanceof com.bytedance.ee.bear.more.office.a.C0116a) == false) goto L18;
            c0.f(r8.a);
            com.bytedance.ee.bear.more.office.d r10 = new com.bytedance.ee.bear.more.office.d.b(((com.bytedance.ee.bear.more.office.a.C0116a) r9).a);
        L27:
            c0.e(r7, r10);
            return;
        L18:
            if (Intrinsics.areEqual(r9, com.bytedance.ee.bear.more.office.a.b.a) == false) goto L20;
            c0.f(r8.a);
            r10 = com.bytedance.ee.bear.more.office.d.e.a;
            goto L27
        L20:
            String r11 = r8.f.a;
            if (r11 != null) goto L24;
            r11 = "";
        L24:
            if (StringsKt.isBlank(r11) == false) goto L26;
            c0.f(r8.a);
            r10 = new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c());
            goto L27
        L26:
            c0.h(r7, r8, r11);
            r10 = com.bytedance.ee.bear.more.office.d.C0117d.a;
            goto L27
        L5:
            if (r1.isDestroyed() == true) goto L7;
            r2 = true;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
        public final /* synthetic */ FragmentActivity b;

        public c(com.bytedance.ee.bear.more.office.c r1, FragmentActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            tt5.a.e("OfficeRenameActionExecutor", "fetch rename permission failed. actionId=" + this.a.a, (Throwable) r4, false);
            Toast.cancelLoading();
            Toast.showFailureText(this.b, 2131887802);
            c0 r5 = c0.a;
            c0.f(this.a.a);
        }
    }

    public static final class d implements gp5.a.InterfaceC0236a {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c b;
        public final /* synthetic */ String c;
        public final /* synthetic */ a d;

        @Override // gp5.a.InterfaceC0236a
        public final void a(String r14) {
            Intrinsics.checkNotNullParameter(r14, "text");
            c0 r0 = c0.a;
            final FragmentActivity r1 = this.a;
            final com.bytedance.ee.bear.more.office.c r2 = this.b;
            String r3 = this.c;
            a r4 = this.d;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r14, "input");
            String r15 = StringsKt.trim(r14).toString();
            boolean r5 = true;
            if (r4.b.length() != 0) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L9;
        L7:
            String r11 = r15;
            if (StringsKt.isBlank(r11) == false) goto L19;
            Toast.showFailureText(r1, r1.getString(2131887764), 0);
            r5 = false;
        L24:
            if (r5 == false) goto L44;
            Dialog r16 = c0.b.remove(this.b.a);
            if (r16 == null) goto L48;
            Handler r7 = DialogLancet.resolveDialogHandler(r16);
            if (r7 != null) goto L30;
        L32:
            DialogLancet.beforeDialogDismiss(r16);
            r16.dismiss();     // Catch: Throwable -> L35 Exception -> L37
        L41:
            DialogLancet.afterDialogDismiss(r16);
            return;
        L35:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r16);
            throw th;
        L37:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L35
            Throwable r8 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L35
            if (r8 == null) goto L41;
            com.bytedance.crash.d.d(r8, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L35
            goto L41
        L30:
            if (Looper.myLooper() == r7.getLooper()) goto L32;
            r7.post(DialogLancet.createDismissRunnable(r16));
            return;
        L48:
            return;
        L44:
            return;
        L19:
            if (Intrinsics.areEqual(r11, r3) == true) goto L24;
            String r12 = r1.getString(2131887969);
            int r17 = OfficeRenameCore.a;
            Function0<Unit> r18 = OfficeRenameCore.d(new com.bytedance.ee.bear.list.rename.core.b(r2.a, r2.f, r2.g, r11, r12), new OfficeRenameActionExecutor$handleConfirm$canceler$1(r1, r2));
            if (r18 == null) goto L24;
            c0.c.put(r2.a, r18);
            goto L24
        L9:
            if (StringsKt.endsWith(r15, r4.b, true) == false) goto L11;
            r15 = StringsKt.dropLast(r15, r4.b.length());
        L11:
            String r19 = StringsKt.trimEnd(r15).toString();
            if (StringsKt.isBlank(r19) == false) goto L14;
            r15 = "";
            goto L7
        L14:
            r15 = r19 + r4.b;
            goto L7
        L5:
            r6 = false;
            goto L6
        }

        public d(FragmentActivity r1, com.bytedance.ee.bear.more.office.c r2, String r3, a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class e implements gp5.a.InterfaceC0236a {
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;

        public e(com.bytedance.ee.bear.more.office.c r1) {
            this.a = r1;
        }

        @Override // gp5.a.InterfaceC0236a
        public final void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "text");
            Dialog r5 = c0.b.remove(this.a.a);
            if (r5 == null) goto L21;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
            goto L18
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r5));
            return;
        }
    }

    public c0() {
    }

    static {
        a = new c0();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
    }

    public static void a(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static com.bytedance.ee.bear.more.office.d b(com.bytedance.ee.bear.more.office.c r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        FragmentActivity r0 = r4.getActivity();
        if (r0 == null) goto L5;
        Document r1 = r4.f;
        oj5.c r2 = r4.g;
        if ((r2 instanceof oj5.a) == true) goto L9;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L17;
        c(r0, r4);
        return com.bytedance.ee.bear.more.office.d.f.a;
    L17:
        com.bytedance.ee.bear.more.office.a r5 = d(r4, null);
        if ((r5 instanceof com.bytedance.ee.bear.more.office.a.C0116a) == false) goto L29;
        com.bytedance.ee.bear.more.office.a.C0116a r6 = (com.bytedance.ee.bear.more.office.a.C0116a) r5;
        OfficeLongPressDisabledDispatchReason r7 = r6.b;
        if (r7 != OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY) goto L22;
    L26:
        c(r0, r4);
        return com.bytedance.ee.bear.more.office.d.f.a;
    L22:
        if (r7 == OfficeLongPressDisabledDispatchReason.PREFETCH_FAILED_RETRY) goto L26;
        return new com.bytedance.ee.bear.more.office.d.b(r6.a);
    L29:
        if (Intrinsics.areEqual(r5, com.bytedance.ee.bear.more.office.a.b.a) == true) goto L31;
        String r8 = r4.f.a;
        if (r8 != null) goto L36;
        r8 = "";
    L36:
        if (StringsKt.isBlank(r8) == true) goto L38;
        h(r0, r4, r8);
        return com.bytedance.ee.bear.more.office.d.C0117d.a;
    L38:
        return new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c());
    L31:
        return com.bytedance.ee.bear.more.office.d.e.a;
    L9:
        if (OfficeRenameCore.b(r1) == false) goto L13;
        if ((((oj5.a) r2).i.a instanceof DefaultDocUserPermission) == false) goto L13;
        r3 = true;
        goto L14
    L5:
        return new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c());
    }

    public static void f(String r1) {
        Intrinsics.checkNotNullParameter(r1, "actionId");
        Dialog r0 = b.remove(r1);
        if (r0 == null) goto L5;
        a(r0);
    L5:
        Function0<Unit> r2 = c.remove(r1);
        if (r2 == null) goto L8;
        r2.invoke();
    L8:
        CompositeDisposable r3 = d.remove(r1);
        if (r3 == null) goto L11;
        r3.clear();
    L11:
        CompositeDisposable r4 = e.remove(r1);
        if (r4 == null) goto L15;
        r4.clear();
        return;
    }

    public static void c(FragmentActivity r5, com.bytedance.ee.bear.more.office.c r6) {
        oj5.c r0 = r6.g;
        if ((r0 instanceof oj5.a) == false) goto L5;
        oj5.a r1 = (oj5.a) r0;
    L6:
        if (r1 != null) goto L9;
        e(r5, new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c()));
        return;
    L9:
        ConcurrentHashMap<String, CompositeDisposable> r2 = d;
        String r3 = r6.a;
        CompositeDisposable r4 = r2.get(r3);
        if (r4 != null) goto L15;
        r4 = new CompositeDisposable();
        CompositeDisposable r7 = r2.putIfAbsent(r3, r4);
        if (r7 == null) goto L15;
        r4 = r7;
    L15:
        CompositeDisposable r8 = r4;
        Toast.showLoading(r5, r5.getString(2131887769));
        jg5.j r9 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r10 = g(r6.f, r1);
        if (OfficeRenameCore.b(r6.f) == false) goto L18;
        int r11 = 12;
    L19:
        r8.add(r9.a(r10, r11).subscribe(new b(r5, r6, r1), new c(r6, r5)));
        return;
    L18:
        r11 = r1.getType();
        goto L19
    L5:
        r1 = null;
        goto L6
    }

    public static com.bytedance.ee.bear.more.office.a d(com.bytedance.ee.bear.more.office.c r10, com.bytedance.ee.bear.more.office.b r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Context r0 = r10.getActivity();
        if (r0 != null) goto L10;
        Fragment r1 = r10.e;
        if (r1 == null) goto L8;
        r0 = r1.getContext();
        goto L10
    L8:
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        int r3 = OfficeRenameCore.a;
        com.bytedance.ee.bear.list.rename.core.a r4 = OfficeRenameCore.a(r0, r10.f, r10.g);
        com.bytedance.ee.bear.list.rename.core.a.c r5 = com.bytedance.ee.bear.list.rename.core.a.c.a;
        if (Intrinsics.areEqual(r4, r5) == false) goto L40;
        oj5.c r6 = r10.g;
        if ((r6 instanceof oj5.a) == false) goto L18;
        oj5.a r7 = (oj5.a) r6;
    L19:
        if (r7 == null) goto L40;
        if (OfficeRenameCore.b(r10.f) == true) goto L24;
    L26:
        boolean r8 = false;
    L27:
        if (r8 == false) goto L40;
        ConcurrentHashMap<String, CompositeDisposable> r9 = e;
        if (r9.containsKey(r10.a) == true) goto L40;
        CompositeDisposable r12 = new CompositeDisposable();
        if (r9.putIfAbsent(r10.a, r12) != null) goto L40;
        jg5.j r13 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r14 = g(r10.f, r7);
        if (OfficeRenameCore.b(r10.f) == false) goto L37;
        int r15 = 12;
    L38:
        r12.add(r13.a(r14, r15).subscribe(new e0(r10, r7, r11), new f0(r10, r11)));
        goto L40
    L37:
        r15 = r7.getType();
        goto L38
    L24:
        if ((r7.i.a instanceof DefaultDocUserPermission) == false) goto L26;
        r8 = true;
        goto L27
    L18:
        r7 = null;
    L40:
        if (Intrinsics.areEqual(r4, com.bytedance.ee.bear.list.rename.core.a.d.a) == false) goto L43;
        return com.bytedance.ee.bear.more.office.a.d.a;
    L43:
        if (Intrinsics.areEqual(r4, com.bytedance.ee.bear.list.rename.core.a.b.a) == false) goto L46;
        return com.bytedance.ee.bear.more.office.a.b.a;
    L46:
        if (Intrinsics.areEqual(r4, r5) == false) goto L49;
        return new com.bytedance.ee.bear.more.office.a.C0116a(r0.getString(2131892995), OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY);
    L49:
        if ((r4 instanceof com.bytedance.ee.bear.list.rename.core.a.C0033a) == false) goto L53;
        return new com.bytedance.ee.bear.more.office.a.C0116a(((com.bytedance.ee.bear.list.rename.core.a.C0033a) r4).a, null, 2);
    L53:
        throw new NoWhenBranchMatchedException();
    L12:
        return new com.bytedance.ee.bear.more.office.a.C0116a(com.bytedance.ee.bear.more.office.f.c(), null, 2);
    }

    public static void e(Context r1, com.bytedance.ee.bear.more.office.d r2) {
        if (Intrinsics.areEqual(r2, com.bytedance.ee.bear.more.office.d.C0117d.a) == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r2, com.bytedance.ee.bear.more.office.d.a.a) == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r2, com.bytedance.ee.bear.more.office.d.f.a) == false) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r2, com.bytedance.ee.bear.more.office.d.e.a) == false) goto L12;
        Toast.showFailureText(r1, com.bytedance.ee.bear.more.office.f.c());
        return;
    L12:
        if ((r2 instanceof com.bytedance.ee.bear.more.office.d.b) == false) goto L15;
        Toast.showFailureText(r1, ((com.bytedance.ee.bear.more.office.d.b) r2).a);
        return;
    L15:
        if ((r2 instanceof com.bytedance.ee.bear.more.office.d.c) == false) goto L18;
        Toast.showFailureText(r1, ((com.bytedance.ee.bear.more.office.d.c) r2).a);
        return;
    L18:
        throw new NoWhenBranchMatchedException();
    }

    public static String g(Document r5, oj5.a r6) {
        boolean r1 = false;
        String r4 = "";
        if (r5.getType() != 16) goto L36;
        if (r5.y1 != 12) goto L36;
        String r0 = r5.G1;
        if (r0 != null) goto L10;
        r0 = "";
    L10:
        if (r0.length() != 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L18;
        r0 = r6.o;
        if (r0 != null) goto L18;
        r0 = "";
    L18:
        if (r0.length() != 0) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == false) goto L26;
        r0 = r6.c;
        if (r0 != null) goto L26;
        r0 = "";
    L26:
        if (r0.length() != 0) goto L28;
        r1 = true;
    L28:
        if (r1 == false) goto L59;
        String r7 = r5.d;
        if (r7 == null) goto L34;
        r4 = r7;
    L34:
        return r4;
    L59:
        return r0;
    L20:
        r3 = false;
        goto L21
    L12:
        r2 = false;
    L36:
        if (OfficeRenameCore.b(r5) == false) goto L58;
        String r8 = r6.c;
        if (r8 != null) goto L41;
        r8 = "";
    L41:
        if (r8.length() != 0) goto L43;
        boolean r9 = true;
    L44:
        if (r9 == false) goto L49;
        r8 = r5.G1;
        if (r8 != null) goto L49;
        r8 = "";
    L49:
        if (r8.length() != 0) goto L51;
        r1 = true;
    L51:
        if (r1 == false) goto L60;
        String r10 = r5.d;
        if (r10 == null) goto L61;
        r4 = r10;
    L61:
        return r4;
    L60:
        return r8;
    L43:
        r9 = false;
        goto L44
    L58:
        return r6.c;
    }

    public static void h(FragmentActivity r5, com.bytedance.ee.bear.more.office.c r6, String r7) {
        int r0 = a.d;
        int r1 = OfficeRenameCore.a;
        boolean r2 = OfficeRenameCore.b(r6.f);
        Intrinsics.checkNotNullParameter(r7, "originName");
        if (r2 == true) goto L5;
        a r3 = new a(r7, "");
    L17:
        gp5.a r4 = (gp5.a) new gp5.a(r5).title(2131887814);
        r4.e(r3.a);
        r4.m = r3.c;
        r4.f(2131887764);
        r4.o = true;
        gp5.a r8 = (gp5.a) r4.autoDismiss(false);
        r8.a(2131887719);
        d r9 = new d(r5, r6, r7, r3);
        Intrinsics.checkNotNullParameter(r9, "value");
        r8.r = r9;
        r8.c();
        e r10 = new e(r6);
        Intrinsics.checkNotNullParameter(r10, "value");
        r8.s = r10;
        Dialog r11 = r8.show();
        oj5.c r12 = r6.g;
        SpaceEditText r13 = r8.g();
        if (r13 != null) goto L21;
    L24:
        b.put(r6.a, r11);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).s(r11);
        return;
    L21:
        if (((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).b() == true) goto L24;
        r13.setInterceptor(new d0(r12, r5));
        goto L24
    L5:
        String r14 = com.bytedance.ee.util.io.a.b(r7);
        Intrinsics.checkNotNull(r14);
        if (r14.length() != 0) goto L8;
        boolean r15 = true;
    L9:
        if (r15 == false) goto L11;
    L16:
        r3 = new a(r7, "");
        goto L17
    L11:
        if (Intrinsics.areEqual(r14, ".") == true) goto L16;
        if (Intrinsics.areEqual(r14, r7) == true) goto L16;
        r3 = new a(r7.substring(0, r7.length() - r14.length()), r14);
        goto L17
    L8:
        r15 = false;
        goto L9
    }
}
