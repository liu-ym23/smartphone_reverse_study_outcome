package sw2;

import android.os.Process;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.common.utility.concurrent.SimpleThreadFactory;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.Npth;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.alog.middleware.ALogService;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f543700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f543701b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<e> f543702c = null;

    /* JADX INFO: renamed from: sw2.a$a, reason: collision with other inner class name */
    public static final class C7664a implements ICrashCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7664a f543703a = null;

        static {
            f543703a = new C7664a();
        }

        public C7664a() {
        }

        @Override // com.bytedance.crash.ICrashCallback
        public final void onCrash(CrashType r100, String r101, Thread r102) {
            Spm.Companion.getClass();
            Spm r103 = Spm.a.a("a100.b1000").result(101);
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            Spm r104 = r103.aliasAppend(r101);
            Long r105 = null;
            if (r102 == null) goto L8;
            String r106 = r102.getName();
        L9:
            Spm r107 = r104.addArg("thread", r106);
            if (r102 == null) goto L12;
            r105 = Long.valueOf(r102.getId());
        L12:
            vw2.a.a(r107.addArg(CrashHianalyticsData.THREAD_ID, r105), "crash");
            return;
        L8:
            r106 = null;
            goto L9
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f543704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Spm f543705b;

        public b(String r100, Spm r101) {
            this.f543704a = r100;
            this.f543705b = r101;
        }

        public final void a() {
            String r100 = this.f543704a;     // Catch: Exception -> L56
            if (r100 != null) goto L6;
        L9:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L12;
            String r102 = "ttlive_logger";
        L13:
            String r103 = this.f543705b.log();     // Catch: Exception -> L56
            Iterator<e> r104 = a.f543702c.iterator();     // Catch: Exception -> L56
        L15:
            if (r104.hasNext() == false) goto L17;
            e r105 = r104.next();     // Catch: Exception -> L56
            String r106 = this.f543704a;     // Catch: Exception -> L56
            r105.a();     // Catch: Exception -> L56
            goto L15
        L17:
            int r107 = this.f543705b.priority();     // Catch: Exception -> L56
            int r108 = xw2.a.f565221a;     // Catch: Exception -> L56
            if (r107 != 200) goto L25;
            int r109 = ww2.a.f561626a;     // Catch: Exception -> L56
            Intrinsics.checkNotNullParameter(r102, "tag");     // Catch: Exception -> L56
            if (r103 != null) goto L23;
            r103 = "";
        L23:
            Intrinsics.checkNotNullParameter(r102, "tag");     // Catch: Exception -> L56
            Intrinsics.checkNotNullParameter(r103, "msg");     // Catch: Exception -> L56
            ALogService.vSafely(r102, r103);     // Catch: Exception -> L56
            return;
        L25:
            if (r107 != 400) goto L31;
            int r110 = ww2.a.f561626a;     // Catch: Exception -> L56
            Intrinsics.checkNotNullParameter(r102, "tag");     // Catch: Exception -> L56
            if (r103 != null) goto L29;
            r103 = "";
        L29:
            Intrinsics.checkNotNullParameter(r102, "tag");     // Catch: Exception -> L56
            Intrinsics.checkNotNullParameter(r103, "msg");     // Catch: Exception -> L56
            ALogService.iSafely(r102, r103);     // Catch: Exception -> L56
            return;
        L31:
            if (r107 != 300) goto L37;
            int r111 = ww2.a.f561626a;     // Catch: Exception -> L56
            Intrinsics.checkNotNullParameter(r102, "tag");     // Catch: Exception -> L56
            if (r103 != null) goto L35;
            r103 = "";
        L35:
            Intrinsics.checkNotNullParameter(r102, "tag");     // Catch: Exception -> L56
            Intrinsics.checkNotNullParameter(r103, "msg");     // Catch: Exception -> L56
            ALogService.dSafely(r102, r103);     // Catch: Exception -> L56
            return;
        L37:
            if (r107 != 500) goto L40;
            ww2.a.a(r102, r103);     // Catch: Exception -> L56
            return;
        L40:
            if (r107 != 600) goto L46;
            int r112 = ww2.a.f561626a;     // Catch: Exception -> L56
            Intrinsics.checkNotNullParameter(r102, "tag");     // Catch: Exception -> L56
            if (r103 != null) goto L44;
            r103 = "";
        L44:
            Intrinsics.checkNotNullParameter(r102, "tag");     // Catch: Exception -> L56
            Intrinsics.checkNotNullParameter(r103, "msg");     // Catch: Exception -> L56
            ALogService.eSafely(r102, r103);     // Catch: Exception -> L56
            return;
        L46:
            if (this.f543705b.result() != 200) goto L48;
        L51:
            int r113 = ww2.a.f561626a;     // Catch: Exception -> L56
            Intrinsics.checkNotNullParameter(r102, "tag");     // Catch: Exception -> L56
            if (r103 != null) goto L54;
            r103 = "";
        L54:
            Intrinsics.checkNotNullParameter(r102, "tag");     // Catch: Exception -> L56
            Intrinsics.checkNotNullParameter(r103, "msg");     // Catch: Exception -> L56
            ALogService.iSafely(r102, r103);     // Catch: Exception -> L56
            return;
        L48:
            if (this.f543705b.result() == 0) goto L51;
            ww2.a.a(r102, r103);     // Catch: Exception -> L56
            return;
        L12:
            r102 = "ttlive_logger_" + this.f543704a;     // Catch: Exception -> L56
            goto L13
        L6:
            if (r100.length() == 0) goto L9;
            r101 = false;
        L56:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
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
        f543700a = new ArrayList();
        f543701b = PThreadExecutorsUtils.newSingleThreadExecutor(new SimpleThreadFactory("logsdk_gson"));
        f543702c = new CopyOnWriteArrayList();
    }

    @JvmStatic
    public static final void a() {
        Npth.registerCrashCallback(C7664a.f543703a, CrashType.ALL);
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.b5000").addArg("pid", Integer.valueOf(Process.myPid())).addArg(SocialConstants.PARAM_APP_DESC, "查询当前进程id"), "runtime");
    }

    @JvmStatic
    public static final void b(Spm r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "spm");
        Iterator<String> r102 = f543700a.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(r102.next(), r100.getSpm()) == false) goto L4;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        f543701b.submit(new b(r101, r100));
        return;
    L8:
        r103 = false;
        goto L9
    }
}
