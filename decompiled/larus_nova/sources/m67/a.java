package m67;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.common.process.cross.ICrossProcessAbilityInitListener;
import com.bytedance.common.process.cross.IMethodObserver;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.push.utils.f;
import com.bytedance.push.utils.k;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Observable implements IMethodObserver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C6775a f512286f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f512287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f512288h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f512289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ProcessEnum> f512290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProcessEnum f512291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f512292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f512293e;

    /* JADX INFO: renamed from: m67.a$a, reason: collision with other inner class name */
    public static class C6775a extends k<a> {
        public C6775a() {
        }

        @Override // com.bytedance.push.utils.k
        public final a create(Object[] r100) {
            return new a();
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f512294a;

        /* JADX INFO: renamed from: m67.a$b$a, reason: collision with other inner class name */
        public class C6776a implements ICrossProcessAbilityInitListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f512295a;

            @Override // com.bytedance.common.process.cross.ICrossProcessAbilityInitListener
            public final void initFinished() {
                ArrayList r100 = new ArrayList();
                r100.add("get_cur_app_status");
                CrossProcessHelper r101 = CrossProcessHelper.getInstance();
                ProcessEnum r102 = ProcessEnum.MAIN;
                this.f512295a.f512294a.getClass();
                String r103 = r101.callMethod(r102, "onAppStatusChanged", r100);
                f.g("AppStatusObserverForChildProcess", "success connection with main process,cur is in background:" + r103 + " mIsInBackGround:" + a.f512287g);
                if (TextUtils.isEmpty(r103) == false) goto L5;
                return;
            L5:
                if (Boolean.parseBoolean(r103) == false) goto L7;
                return;
            L7:
                if (a.f512287g == false) goto L12;
                this.f512295a.f512294a.c();
                return;
            }

            public C6776a(b r100) {
                this.f512295a = r100;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            CrossProcessHelper.getInstance().addTargetProcessAbilityInitListener(ProcessEnum.MAIN, new C6776a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100) {
            this.f512294a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f512296a;

        @Override // java.lang.Runnable
        public final void run() {
            CrossProcessHelper.getInstance().registerMethodObserver(this.f512296a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(a r100) {
            this.f512296a = r100;
        }
    }

    @Override // com.bytedance.common.process.cross.IMethodObserver
    public final String getMethodName() {
        return "onAppStatusChanged";
    }

    static {
        f512286f = new C6775a();
        f512287g = true;
    }

    public static a a() {
        return f512286f.get(new Object[0]);
    }

    public static boolean d() {
        if (f512288h == true) goto L7;
        return !com.ss.android.pushmanager.setting.a.b().d();
    L7:
        return f512287g;
    }

    public final void b() {
        f.g("AppStatusObserverForChildProcess", "onEnterBackground on " + this.f512291c + " process");
        f512288h = true;
        f512287g = true;
        SystemClock.uptimeMillis();
        System.currentTimeMillis();
        if (this.f512291c != ProcessEnum.MAIN) goto L6;
        TTExecutors.getCPUThreadPool().submit(new m67.b(this, "app_exit"));
    L6:
        setChanged();
        notifyObservers(Boolean.valueOf(f512287g));
    }

    public final void c() {
        f.g("AppStatusObserverForChildProcess", "onEnterForeground on " + this.f512291c + " process,mIsInBackGround:" + f512287g + " countObservers:" + countObservers());
        if (f512287g == true) goto L5;
        return;
    L5:
        if (this.f512293e != 0) goto L7;
        this.f512293e = System.currentTimeMillis();
    L7:
        f512288h = true;
        if (f512287g == false) goto L10;
        this.f512292d = System.currentTimeMillis();
    L10:
        f512287g = false;
        this.f512289a = true;
        if (this.f512291c != ProcessEnum.MAIN) goto L14;
        TTExecutors.getCPUThreadPool().submit(new m67.b(this, "app_entrance"));
    L14:
        setChanged();
        notifyObservers(Boolean.valueOf(f512287g));
    }

    public a() {
        f.g("AppStatusObserverForChildProcess", "on AppStatusObserverForChildProcess init");
        ProcessEnum r100 = ToolUtils.getCurProcess(AppProvider.getApp());
        this.f512291c = r100;
        ArrayList r101 = new ArrayList();
        this.f512290b = r101;
        r101.add(ProcessEnum.PUSH);
        r101.add(ProcessEnum.SMP);
        if (r101.contains(r100) == false) goto L6;
        PushThreadHandlerManager.inst().postRunnable(new b(this));
    L6:
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mEnableLazy == true) goto L9;
        PushThreadHandlerManager.inst().postRunnable(new c(this));
        return;
    }

    @Override // com.bytedance.common.process.cross.IMethodObserver
    public final String onMethodCall(ProcessEnum r100, List r101) {
        if (r101 == null) goto L15;
        String r102 = (String) ListProtector.get(r101, 0);
        if (this.f512291c == ProcessEnum.MAIN) goto L12;
        if (TextUtils.equals("app_entrance", r102) == false) goto L9;
        c();
        return null;
    L9:
        if (TextUtils.equals("app_exit", r102) == false) goto L18;
        b();
        return null;
    L18:
        return null;
    L12:
        if (TextUtils.equals("get_cur_app_status", r102) == true) goto L14;
        return null;
    L14:
        return String.valueOf(d());
    L15:
        return null;
    }
}
