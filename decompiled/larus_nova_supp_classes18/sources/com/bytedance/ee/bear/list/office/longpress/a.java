package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements com.bytedance.ee.bear.more.office.e {
    public static final a a = null;
    public static final b0 b = null;
    public static final b c = null;
    public static final g0 d = null;
    public static final h e = null;
    public static final m f = null;
    public static final c0 g = null;
    public static final s h = null;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.office.longpress.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0025a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeLongPressLarkAction.values().length];
            r0[OfficeLongPressLarkAction.MOVE_TO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[OfficeLongPressLarkAction.ADD_SHORTCUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[OfficeLongPressLarkAction.SECRET_SETTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[OfficeLongPressLarkAction.DOWNLOAD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[OfficeLongPressLarkAction.EXPORT_AS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[OfficeLongPressLarkAction.RENAME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[OfficeLongPressLarkAction.MAKE_COPY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = b0.a;
        c = b.a;
        d = g0.a;
        e = h.a;
        f = m.a;
        g = c0.a;
        h = s.a;
    }

    @Override // com.bytedance.ee.bear.more.office.e
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "actionId");
        b.getClass();
        b0.h(r3);
        c.getClass();
        Intrinsics.checkNotNullParameter(r3, "actionId");
        CompositeDisposable r0 = b.b.remove(r3);
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        CompositeDisposable r1 = b.c.remove(r3);
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        b.d.remove(r3);
        d.getClass();
        g0.p(r3);
        e.getClass();
        h.l(r3);
        f.getClass();
        m.g(r3);
        g.getClass();
        c0.f(r3);
        h.getClass();
        s.n(r3);
    }

    @Override // com.bytedance.ee.bear.more.office.e
    public final com.bytedance.ee.bear.more.office.d b(com.bytedance.ee.bear.more.office.c r7) {
        Intrinsics.checkNotNullParameter(r7, "request");
        Context r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L31
        switch(C0025a.a[r7.b.ordinal()]) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L30;
        };     // Catch: Throwable -> L31
    L6:
        h.getClass();     // Catch: Throwable -> L31
        Object r0 = s.c(r7);     // Catch: Throwable -> L31
    L28:
        Object r1 = Result.constructor-impl(r0);     // Catch: Throwable -> L31
    L33:
        Throwable r4 = Result.exceptionOrNull-impl(r1);
        if (r4 == null) goto L36;
        tt5.a.e("DefaultOfficeLongPressLarkActionService", "execute failed. action=" + r7.b, r4, false);
    L36:
        Throwable r5 = Result.exceptionOrNull-impl(r1);
        if (r5 == null) goto L51;
        a.getClass();
        Context r6 = r7.getActivity();
        if (r6 == null) goto L42;
        r2 = r6;
    L45:
        if (r2 == null) goto L48;
        String r8 = r2.getString(2131887802);
        if (r8 == null) goto L48;
    L49:
        r1 = new com.bytedance.ee.bear.more.office.d.c(r8, r5);
    L48:
        r8 = com.bytedance.ee.bear.more.office.f.a();
        goto L49
    L42:
        Fragment r9 = r7.e;
        if (r9 == null) goto L45;
        r2 = r9.getContext();
    L51:
        return (com.bytedance.ee.bear.more.office.d) r1;
    L7:
        g.getClass();     // Catch: Throwable -> L31
        r0 = c0.b(r7);     // Catch: Throwable -> L31
        goto L28
    L8:
        f.getClass();     // Catch: Throwable -> L31
        Intrinsics.checkNotNullParameter(r7, "request");     // Catch: Throwable -> L31
        oj5.c r10 = r7.g;     // Catch: Throwable -> L31
        if ((r10 instanceof oj5.a) == false) goto L11;
        oj5.a r11 = (oj5.a) r10;     // Catch: Throwable -> L31
    L13:
        if (r7.getActivity() == null) goto L23;
        if (r11 == null) goto L23;
        if ((r11.i.a instanceof DefaultDocUserPermission) == true) goto L18;
    L20:
        boolean r12 = false;
    L21:
        if (r12 == false) goto L23;
        m.d(r7);     // Catch: Throwable -> L31
        r0 = com.bytedance.ee.bear.more.office.d.f.a;     // Catch: Throwable -> L31
        goto L28
    L18:
        if (q.a(r11) == false) goto L20;
        r12 = true;
    L23:
        r0 = m.c(r7);     // Catch: Throwable -> L31
        goto L28
    L11:
        r11 = null;
        goto L13
    L24:
        e.getClass();     // Catch: Throwable -> L31
        r0 = h.c(r7);     // Catch: Throwable -> L31
        goto L28
    L25:
        d.getClass();     // Catch: Throwable -> L31
        r0 = g0.h(r7);     // Catch: Throwable -> L31
        goto L28
    L26:
        c.getClass();     // Catch: Throwable -> L31
        r0 = b.b(r7);     // Catch: Throwable -> L31
        goto L28
    L27:
        b.getClass();     // Catch: Throwable -> L31
        r0 = b0.b(r7);     // Catch: Throwable -> L31
        goto L28
    L30:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    }

    @Override // com.bytedance.ee.bear.more.office.e
    public final com.bytedance.ee.bear.more.office.a c(com.bytedance.ee.bear.more.office.c r4, com.bytedance.ee.bear.office.list.adapter.p r5) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        switch(C0025a.a[r4.b.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L15;
        };     // Catch: Throwable -> L16
    L6:
        h.getClass();     // Catch: Throwable -> L16
        com.bytedance.ee.bear.more.office.a r6 = s.f(r4, r5);     // Catch: Throwable -> L16
    L13:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L16
    L18:
        Throwable r1 = Result.exceptionOrNull-impl(r7);
        if (r1 == null) goto L21;
        tt5.a.e("DefaultOfficeLongPressLarkActionService", "getAvailability failed. action=" + r4.b, r1, false);
    L21:
        com.bytedance.ee.bear.more.office.a.C0116a r8 = new com.bytedance.ee.bear.more.office.a.C0116a(null, null, 3);
        if (Result.isFailure-impl(r7) == false) goto L25;
        r7 = r8;
    L25:
        return (com.bytedance.ee.bear.more.office.a) r7;
    L7:
        g.getClass();     // Catch: Throwable -> L16
        r6 = c0.d(r4, r5);     // Catch: Throwable -> L16
        goto L13
    L8:
        f.getClass();     // Catch: Throwable -> L16
        r6 = m.e(r4, r5);     // Catch: Throwable -> L16
        goto L13
    L9:
        e.getClass();     // Catch: Throwable -> L16
        r6 = h.e(r4, r5);     // Catch: Throwable -> L16
        goto L13
    L10:
        d.getClass();     // Catch: Throwable -> L16
        r6 = g0.j(r4, r5);     // Catch: Throwable -> L16
        goto L13
    L11:
        c.getClass();     // Catch: Throwable -> L16
        r6 = b.d(r4, r5);     // Catch: Throwable -> L16
        goto L13
    L12:
        b.getClass();     // Catch: Throwable -> L16
        r6 = b0.c(r4, r5);     // Catch: Throwable -> L16
        goto L13
    L15:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
