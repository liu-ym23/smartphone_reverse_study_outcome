package com.obric.aiagent.platform.depend;

import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000 \b2\u00020\u0001:\u0002\b\tJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/platform/depend/IRuntimeContext;", "", "isMainProcess", "", "getProcessId", "", "getProcessName", "", "Companion", "Default", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IRuntimeContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f384990a = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0004\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/platform/depend/IRuntimeContext$Companion;", "Lcom/obric/aiagent/platform/depend/IRuntimeContext;", "<init>", "()V", "impl", "getImpl", "()Lcom/obric/aiagent/platform/depend/IRuntimeContext;", "impl$delegate", "Lkotlin/Lazy;", "isMainProcess", "", "getProcessId", "", "getProcessName", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IRuntimeContext {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f384991b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IRuntimeContext> f384992c = null;

        private Companion() {
        }

        static {
            f384991b = new Companion();
            f384992c = LazyKt.lazy(new a());
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public final boolean a() {
            return f384992c.getValue().a();
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public final String b() {
            return f384992c.getValue().b();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/platform/depend/IRuntimeContext$Default;", "Lcom/obric/aiagent/platform/depend/IRuntimeContext;", "<init>", "()V", "isMainProcess", "", "getProcessId", "", "getProcessName", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Default implements IRuntimeContext {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Default f384993b = null;

        static {
            f384993b = new Default();
        }

        private Default() {
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public final String b() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L34
            BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + Process.myPid() + "/cmdline"));     // Catch: Throwable -> L34
            String r102 = r101.readLine();     // Catch: Throwable -> L29
            Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L29
            if (r102.length() <= 0) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == false) goto L27;
            Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L29
            int r104 = r102.length() - 1;     // Catch: Throwable -> L29
            int r105 = 0;
            boolean r106 = false;
        L10:
            if (r105 > r104) goto L25;
            if (r106 == true) goto L13;
            int r107 = r105;
        L15:
            if (Intrinsics.compare(r102.charAt(r107), 32) > 0) goto L17;
            boolean r108 = true;
        L18:
            if (r106 == false) goto L19;
            if (r108 == false) goto L25;
            r104 = r104 - 1;     // Catch: Throwable -> L29
            goto L10
        L19:
            if (r108 == false) goto L20;
            r105 = r105 + 1;     // Catch: Throwable -> L29
            goto L10
        L20:
            r106 = true;
            goto L10
        L17:
            r108 = false;
            goto L18
        L13:
            r107 = r104;
        L25:
            r102 = r102.subSequence(r105, r104 + 1).toString();     // Catch: Throwable -> L29
        L27:
            CloseableKt.closeFinally(r101, null);     // Catch: Throwable -> L34
            Object r109 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L34
        L36:
            Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
            if (r110 == null) goto L41;
            r110.printStackTrace();
            r109 = "";
        L41:
            return (String) r109;
        L7:
            r103 = false;
        L29:
            th = move-exception;
            throw th;     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            CloseableKt.closeFinally(r101, th);     // Catch: Throwable -> L34
            throw th;     // Catch: Throwable -> L34
        L34:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L36
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public final boolean a() {
            String r100 = b();
            if (StringsKt.contains$default(r100, ":", false, 2, null) == false) goto L6;
            return false;
        L6:
            return Intrinsics.areEqual(r100, IAppContext.f384977a.getPackageName());
        }
    }

    static {
        f384990a = Companion.f384991b;
    }

    boolean a();

    String b();
}
