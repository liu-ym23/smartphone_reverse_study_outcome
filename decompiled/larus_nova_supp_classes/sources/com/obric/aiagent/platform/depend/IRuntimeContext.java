package com.obric.aiagent.platform.depend;

import android.os.Process;
import android.util.EventsUtils;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000 \b2\u00020\u0001:\u0002\b\tJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/platform/depend/IRuntimeContext;", XmlPullParser.NO_NAMESPACE, "isMainProcess", XmlPullParser.NO_NAMESPACE, "getProcessId", XmlPullParser.NO_NAMESPACE, "getProcessName", XmlPullParser.NO_NAMESPACE, "Companion", "Default", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IRuntimeContext {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0004\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/platform/depend/IRuntimeContext$Companion;", "Lcom/obric/aiagent/platform/depend/IRuntimeContext;", "<init>", "()V", "impl", "getImpl", "()Lcom/obric/aiagent/platform/depend/IRuntimeContext;", "impl$delegate", "Lkotlin/Lazy;", "isMainProcess", XmlPullParser.NO_NAMESPACE, "getProcessId", XmlPullParser.NO_NAMESPACE, "getProcessName", XmlPullParser.NO_NAMESPACE, "platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion implements IRuntimeContext {
        public static final /* synthetic */ Companion b = null;
        public static final Lazy<IRuntimeContext> c = null;

        private Companion() {
        }

        static {
            b = new Companion();
            c = LazyKt.lazy(new a());
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public final boolean a() {
            return c.getValue().a();
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public final String b() {
            return c.getValue().b();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/platform/depend/IRuntimeContext$Default;", "Lcom/obric/aiagent/platform/depend/IRuntimeContext;", "<init>", "()V", "isMainProcess", XmlPullParser.NO_NAMESPACE, "getProcessId", XmlPullParser.NO_NAMESPACE, "getProcessName", XmlPullParser.NO_NAMESPACE, "platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Default implements IRuntimeContext {
        public static final Default b = null;

        static {
            b = new Default();
        }

        private Default() {
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public final String b() {
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L34
            BufferedReader r2 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + Process.myPid() + "/cmdline"));     // Catch: Throwable -> L34
            String r0 = r2.readLine();     // Catch: Throwable -> L29
            Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L29
            if (r0.length() <= 0) goto L7;
            boolean r3 = true;
        L8:
            if (r3 == false) goto L27;
            Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L29
            int r4 = r0.length() - 1;     // Catch: Throwable -> L29
            int r5 = 0;
            boolean r6 = false;
        L10:
            if (r5 > r4) goto L25;
            if (r6 == true) goto L13;
            int r7 = r5;
        L15:
            if (Intrinsics.compare(r0.charAt(r7), 32) > 0) goto L17;
            boolean r8 = true;
        L18:
            if (r6 == false) goto L19;
            if (r8 == false) goto L25;
            r4 = r4 - 1;     // Catch: Throwable -> L29
            goto L10
        L19:
            if (r8 == false) goto L20;
            r5 = r5 + 1;     // Catch: Throwable -> L29
            goto L10
        L20:
            r6 = true;
            goto L10
        L17:
            r8 = false;
            goto L18
        L13:
            r7 = r4;
        L25:
            r0 = r0.subSequence(r5, r4 + 1).toString();     // Catch: Throwable -> L29
        L27:
            CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L34
            Object r9 = Result.m49constructorimpl(r0);     // Catch: Throwable -> L34
        L36:
            Throwable r10 = Result.m52exceptionOrNullimpl(r9);
            if (r10 == null) goto L41;
            r10.printStackTrace();
            r9 = XmlPullParser.NO_NAMESPACE;
        L41:
            return (String) r9;
        L7:
            r3 = false;
        L29:
            th = move-exception;
            throw th;     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L34
            throw th;     // Catch: Throwable -> L34
        L34:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r9 = Result.m49constructorimpl(ResultKt.createFailure(th));
            goto L36
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public final boolean a() {
            String r0 = b();
            if (StringsKt.contains$default(r0, ":", false, 2, null) == false) goto L6;
            return false;
        L6:
            return Intrinsics.areEqual(r0, IAppContext.a.getPackageName());
        }
    }

    static {
        a = Companion.b;
    }

    boolean a();

    String b();
}
