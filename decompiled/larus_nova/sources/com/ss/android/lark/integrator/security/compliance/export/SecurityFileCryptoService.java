package com.ss.android.lark.integrator.security.compliance.export;

import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.utils.LarkContext;
import com.ss.lark.android.encryption.utils.PreCheckUtilKt;
import e0c.k;
import java.io.File;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKUserScope
public final class SecurityFileCryptoService implements com.ss.android.lark.integrator.security.compliance.export.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f428070e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f428071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jkc.c f428072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f428073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Long> f428074d;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f428075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f428076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f428077c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f428075a, r101.f428075a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f428076b, r101.f428076b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f428077c, r101.f428077c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f428075a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f428076b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f428077c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "NativePathResult(path=" + this.f428075a + ", errorCode=" + this.f428076b + ", failureReason=" + this.f428077c + ')';
        }

        public b(String r100, Integer r101, String r102) {
            this.f428075a = r100;
            this.f428076b = r101;
            this.f428077c = r102;
        }
    }

    public static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f428078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f428079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f428080c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f428081d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f428078a, r101.f428078a) == true) goto L12;
            return false;
        L12:
            if (this.f428079b == r101.f428079b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f428080c, r101.f428080c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f428081d, r101.f428081d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f428078a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            if (this.f428079b == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            Integer r106 = this.f428080c;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r105 + r107) * 31;
            String r109 = this.f428081d;
            if (r109 == null) goto L19;
            r101 = r109.hashCode();
        L19:
            return r108 + r101;
        L13:
            r107 = r106.hashCode();
            goto L14
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "OperationResult(value=" + this.f428078a + ", result=" + this.f428079b + ", errorCode=" + this.f428080c + ", failureReason=" + this.f428081d + ')';
        }

        public c(T r100, boolean r101, Integer r102, String r103) {
            this.f428078a = r100;
            this.f428079b = r101;
            this.f428080c = r102;
            this.f428081d = r103;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.c
    public final String A0() {
        r4c.b.f536117a.getClass();
        return r4c.b.a(R.string.Lark_DoubaoWork_FileEncryptionShareBlocked_Toast, "defaultShareBlockTips");
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.c
    public final boolean B4() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Integer.valueOf(this.f428072b.o1()));     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L10;
        Log.e("SecurityFileCryptoService", "[isEncryptionEnabled] query failed, userId=" + this.f428071a, r102);
    L10:
        if (Result.m9455isFailureimpl(r101) == false) goto L12;
        r101 = null;
    L12:
        Integer r103 = (Integer) r101;
        if (r103 == null) goto L23;
        int r104 = r103.intValue();
        if (r104 != (-1)) goto L18;
        Log.i("SecurityFileCryptoService", "[isEncryptionEnabled] status=error, treated as disabled, userId=" + this.f428071a);
    L18:
        if (r104 != 1) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.c
    public final String H0() {
        r4c.b.f536117a.getClass();
        return r4c.b.a(R.string.Lark_DoubaoWork_FileCannotSaveLocally_Toast, "defaultBlockTips");
    }

    public static boolean c(String r100) {
        if ((!StringsKt.isBlank(r100)) == true) goto L5;
    L9:
        return false;
    L5:
        if (StringsKt.contains$default(r100, 0, false, 2, null) == true) goto L9;
        if (new PolarisFileWrapper(r100).isAbsolute() == false) goto L9;
        return true;
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.c
    public final boolean C(final File r110) {
        Intrinsics.checkNotNullParameter(r110, "file");
        Function0<c<Boolean>> r100 = new SecurityFileCryptoService$encryptFile$1(r110, this);
        long r101 = this.f428074d.invoke().longValue();
        c<Boolean> r111 = r100.invoke();     // Catch: Exception -> L6
        d(r111.f428079b, r101, r111.f428080c, r111.f428081d);     // Catch: Exception -> L6
        return r111.f428078a.booleanValue();
    L6:
        e = move-exception;
        d(false, r101, null, null);
        throw e;
    }

    @Inject
    public SecurityFileCryptoService(String r100, jkc.c r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "cipherManager");
        boolean r102 = ((jdb.e) k.a(LarkContext.getApplication(), jdb.e.class)).B0(r100, "doubao_file_encryption_enabled");
        this.f428071a = r100;
        this.f428072b = r101;
        if (r102 == false) goto L7;
        this.f428073c = f.f428091a;
        this.f428074d = SecurityFileCryptoService$clock$1.INSTANCE;
        return;
    L7:
        throw new IllegalStateException("doubao_file_encryption_enabled is disabled".toString());
    }

    public static final boolean a(SecurityFileCryptoService r100, String r101, String r102) {
        r100.getClass();
        if (c(r101) == true) goto L6;
        Log.e("SecurityFileCryptoService", "[" + r102 + "] returned invalid path");
    L8:
        return false;
    L6:
        if (new PolarisFileWrapper(r101).isFile() == true) goto L23;
        Log.e("SecurityFileCryptoService", "[" + r102 + "] returned non-regular file");
        goto L8
    L23:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(PreCheckUtilKt.a(r101, null)));     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L16;
        Log.e("SecurityFileCryptoService", "[" + r102 + "] file header check failed, error=" + r105.getClass().getSimpleName());
    L16:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L19;
        r104 = r106;
    L19:
        boolean r107 = ((Boolean) r104).booleanValue();
        if (r107 == true) goto L26;
        Log.e("SecurityFileCryptoService", "[" + r102 + "] returned plaintext or invalid file header");
        return r107;
    L26:
        return r107;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static final b b(SecurityFileCryptoService r100, Pair r101, String r102) {
        r100.getClass();
        Integer r103 = (Integer) r101.first;
        if (r103 != null) goto L6;
    L7:
        Log.e("SecurityFileCryptoService", "[" + r102 + "] failed, code=" + r101.first);
        return new b(null, (Integer) r101.first, null);
    L6:
        if (r103.intValue() != 0) goto L7;
        String r104 = (String) r101.second;
        if (r104 != null) goto L11;
    L13:
        r104 = null;
    L14:
        if (r104 != null) goto L17;
        Log.e("SecurityFileCryptoService", "[" + r102 + "] failed, native returned empty path");
        return new b(null, null, "native_empty_path");
    L17:
        return new b(r104, null, null);
    L11:
        if ((!Intrinsics.areEqual(r104, "")) == false) goto L13;
        goto L13
    }

    public final void d(boolean r100, long r101, Integer r110, String r111) {
        e r102 = new e(r100, Math.max(0, this.f428074d.invoke().longValue() - r101), r110, r111);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        this.f428073c.a(r102);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
