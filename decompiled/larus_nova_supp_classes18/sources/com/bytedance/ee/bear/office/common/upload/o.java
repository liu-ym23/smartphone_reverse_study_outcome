package com.bytedance.ee.bear.office.common.upload;

import android.webkit.MimeTypeMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelection;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.File;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {
    public final FragmentActivity a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeUploadActionType.values().length];
            r0[OfficeUploadActionType.MEDIA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[OfficeUploadActionType.FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ o a;
        public final /* synthetic */ FileSelectConfig b;
        public final /* synthetic */ Function0<Unit> c;

        public c(o r1, FileSelectConfig r2, Function0<Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public o(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
    }

    public static String b(String r3) {
        String r4 = StringsKt.substringAfterLast(r3, '.', "").toLowerCase(Locale.ROOT);
        if (StringsKt.isBlank(r4) == false) goto L5;
        return null;
    L5:
        String r0 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r4);
        if (r0 != null) goto L26;
        int r1 = r4.hashCode();
        if (r1 == 108308) goto L22;
        if (r1 == 3198679) goto L18;
        if (r1 == 3198682) goto L15;
        return null;
    L15:
        if (r4.equals("heif") == true) goto L28;
        return null;
    L28:
        return "image/".concat(r4);
    L18:
        if (r4.equals("heic") == true) goto L28;
        return null;
    L22:
        if (r4.equals("mov") == false) goto L32;
        return "video/quicktime";
    L32:
        return null;
    L26:
        return r0;
    }

    public static String d(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return "empty";
    L12:
        return "hash=" + r3.hashCode() + ", length=" + r3.length() + ", ext=" + StringsKt.substringAfterLast(r3, '.', "");
    L4:
        if (StringsKt.isBlank(r3) == true) goto L7;
        r0 = false;
        goto L8
    }

    public final void c(FileSelectConfig r4, Function0<Unit> r5) {
        FragmentManager r0 = this.a.getSupportFragmentManager();
        Fragment r2 = r0.findFragmentByTag("OfficeUploadFileSelector");
        if (r2 != null) goto L5;
    L26:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        int r6 = com.bytedance.ee.bear.fileselector.d.a;     // Catch: Throwable -> L10
        Object r7 = Result.constructor-impl(com.bytedance.ee.bear.fileselector.d.a.b(this.a, r4));     // Catch: Throwable -> L10
    L12:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L16;
        tt5.a.l("OfficeUploadFileSelector", "file selector fragment instantiate failed", r8);
        r7 = null;
    L16:
        Fragment r9 = (Fragment) r7;
        if (r9 != null) goto L20;
        tt5.a.k("OfficeUploadFileSelector", "file selector fragment invalid");
        r5.invoke();
        return;
    L20:
        FragmentTransaction r10 = r0.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "OfficeUploadFileSelector", 0) == true) goto L24;
        r10 = r10.add(r9, "OfficeUploadFileSelector");
    L24:
        r10.commitAllowingStateLoss();
        tt5.a.h("OfficeUploadFileSelector", "file selector fragment committed");
        return;
    L10:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L5:
        if (r2.isAdded() == false) goto L26;
        tt5.a.h("OfficeUploadFileSelector", "dismiss existing file selector before reopen");
        int r12 = com.bytedance.ee.bear.fileselector.d.a;
        com.bytedance.ee.bear.fileselector.d.a.a(r0, "OfficeUploadFileSelector");
        com.bytedance.ee.util.ui.j.c(new c(this, r4, r5));
    }

    public static final OfficeSpaceUploadSelection a(o r7, String r8, boolean r9, String r10) {
        r7.getClass();
        Long r11 = null;
        if (r9 == false) goto L10;
        String r0 = StringsKt.substringAfterLast$default(r8, '/', null, 2, null);
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L15;
    L16:
        String r4 = r0;
        if (r9 == true) goto L25;
        File r1 = new PolarisFileWrapper(r8);
        if (r1.exists() == true) goto L23;
        r1 = null;
    L23:
        if (r1 == null) goto L25;
        r11 = Long.valueOf(r1.length());
    L25:
        Long r6 = r11;
        if (r10 != null) goto L28;
        r10 = b(r4);
    L28:
        String r5 = r10;
        tt5.a.h("OfficeUploadFileSelector", "build selection, pointer=" + d(r8) + ", isFileUseUri=" + r9 + ", nameLength=" + r4.length() + ", size=" + r6 + ", mime=" + r5);
        return new OfficeSpaceUploadSelection(r8, r9, r4, r5, r6);
    L15:
        r0 = "";
        goto L16
    L10:
        r0 = new PolarisFileWrapper(r8).getName();
        Intrinsics.checkNotNull(r0);
        if ((!StringsKt.isBlank(r0)) == true) goto L14;
        r0 = null;
    L14:
        if (r0 != null) goto L16;
        goto L15
    }
}
