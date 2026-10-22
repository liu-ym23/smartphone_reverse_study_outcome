package com.lynx.basedevtool.logbox;

import a5a.l;
import a5a.m;
import a5a.n;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes32.dex */
public class LogBoxProxy {
    private static final String TAG = "LogBoxProxy";
    private WeakReference<Context> mActivity;
    private String mErrNamespace;
    private Map<LogBoxLogLevel, List<String>> mLogs;
    private WeakReference<a5a.a> mProvider;

    public class a implements com.lynx.basedevtool.logbox.a.InterfaceC4542a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f380477a;

        public a(String r100) {
            this.f380477a = r100;
        }

        @Override // com.lynx.basedevtool.logbox.a.InterfaceC4542a
        public final void a(Context r100, a5a.c r101) {
            String r102 = this.f380477a;
            if (r100 != null) goto L5;
            r101.f1867b.b(r101.f1866a, Boolean.FALSE);
            return;
        L5:
            AssetManager r103 = r100.getAssets();
            if (r103 != null) goto L9;
            r101.f1867b.b(r101.f1866a, Boolean.FALSE);
            return;
        L9:
            if (TextUtils.isEmpty(r102) == false) goto L51;
            r101.f1867b.b(r101.f1866a, Boolean.FALSE);
            return;
        L51:
            InputStream r104 = r103.open(r102);     // Catch: IOException -> L39
            BufferedReader r105 = new BufferedReader(new InputStreamReader(r104, StandardCharsets.UTF_8));     // Catch: Throwable -> L30
            StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L22
            char[] r107 = new char[8192];     // Catch: Throwable -> L22
        L14:
            int r108 = r105.read(r107, 0, 8192);     // Catch: Throwable -> L22
            if (r108 <= 0) goto L17;
            r106.append(r107, 0, r108);     // Catch: Throwable -> L22
            goto L14
        L17:
            String r109 = r106.toString();     // Catch: Throwable -> L22
            r101.f1867b.f1861b.a(r109);     // Catch: Throwable -> L22
            r101.f1867b.b(r101.f1866a, Boolean.TRUE);     // Catch: Throwable -> L22
            r105.close();     // Catch: Throwable -> L30
            if (r104 == null) goto L58;
            r104.close();     // Catch: IOException -> L39
            return;
        L58:
            return;
        L22:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            r105.close();     // Catch: Throwable -> L27
        L29:
            throw th;     // Catch: Throwable -> L30
        L27:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            if (r104 != null) goto L46;
        L38:
            throw th;     // Catch: IOException -> L39
        L46:
            r104.close();     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L39
        L39:
            e = move-exception;
            e.getMessage();
            r101.f1867b.b(r101.f1866a, Boolean.FALSE);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f380478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LogBoxLogLevel f380479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LogBoxProxy f380480c;

        @Override // java.lang.Runnable
        public final void run() {
            LogBoxProxy.access$000(this.f380480c, this.f380478a, this.f380479b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(LogBoxProxy r100, String r101, LogBoxLogLevel r102) {
            this.f380480c = r100;
            this.f380478a = r101;
            this.f380479b = r102;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LogBoxLogLevel f380481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LogBoxProxy f380482b;

        public final void a() {
            List r100 = (List) LogBoxProxy.access$100(this.f380482b).get(this.f380481a);
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isEmpty() == true) goto L13;
            Iterator r101 = r100.iterator();
        L9:
            if (r101.hasNext() == false) goto L14;
            String r102 = (String) r101.next();
            n.a.f1906a.a(r102, this.f380481a, (Context) LogBoxProxy.access$200(this.f380482b).get(), this.f380482b);
            goto L9
        L14:
            return;
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

        public c(LogBoxProxy r100, LogBoxLogLevel r101) {
            this.f380482b = r100;
            this.f380481a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LogBoxProxy f380483a;

        public final void a() {
            n r100 = n.a.f1906a;
            Context r101 = (Context) LogBoxProxy.access$200(this.f380483a).get();
            LogBoxProxy r102 = this.f380483a;
            if (r101 != null) goto L5;
            r100.getClass();
            l r103 = null;
        L6:
            if (r103 == null) goto L32;
            if (r102 == null) goto L33;
            Iterator r104 = ((HashMap) r103.f1885b).entrySet().iterator();
        L11:
            if (r104.hasNext() == false) goto L17;
            Map.Entry r105 = (Map.Entry) r104.next();
            if (((l.a) r105.getValue()).b(r102) == false) goto L11;
            m r106 = r103.f1886c;
            if (r106 == null) goto L11;
            LogBoxLogLevel r107 = (LogBoxLogLevel) r105.getKey();
            Map<LogBoxLogLevel, Boolean> r108 = r106.f1895d;
            HashMap r109 = (HashMap) r108;
            r109.put(r107, Boolean.TRUE);
            goto L11
        L17:
            a5a.b r110 = r103.f1887d;
            if (r110 != null) goto L20;
        L22:
            r103.e();
        L23:
            r102.clearAllLogs();
            return;
        L20:
            if (r110.isShowing() == false) goto L22;
            r103.f1887d.b();
            l.a(r103.f1887d);
            goto L23
        L33:
            return;
        L32:
            return;
        L5:
            r103 = r100.f1905a.get(r101);
            goto L6
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

        public d(LogBoxProxy r100) {
            this.f380483a = r100;
        }
    }

    private void showCacheLogMessage() {
        showCacheLogMessageByLogLevel(LogBoxLogLevel.Warn);
        showCacheLogMessageByLogLevel(LogBoxLogLevel.Error);
    }

    public void clearAllLogs() {
        Iterator<List<String>> r100 = this.mLogs.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().clear();
        goto L4
    }

    public String getEntryUrlForLogSrc() {
        a5a.a r100 = this.mProvider.get();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getEntryUrlForLogSrc();
    }

    public Map<String, Object> getLogSources() {
        a5a.a r100 = this.mProvider.get();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getLogSources();
    }

    public void reset() {
        d r100 = new d(this);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100.run();
        return;
    L8:
        b5a.c.a(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public String getErrorNamespace() {
        return this.mErrNamespace;
    }

    public static /* synthetic */ Map access$100(LogBoxProxy r100) {
        return r100.mLogs;
    }

    public static /* synthetic */ WeakReference access$200(LogBoxProxy r100) {
        return r100.mActivity;
    }

    private Context findActivityByContext(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        if ((r100 instanceof Activity) == true) goto L9;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L6
    L9:
        return r100;
    L11:
        return null;
    }

    private void showCacheLogMessageByLogLevel(LogBoxLogLevel r100) {
        c r101 = new c(this, r100);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r101.run();
        return;
    L8:
        b5a.c.a(r101);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void attachContext(Context r100) {
        WeakReference<Context> r101 = this.mActivity;
        if (r101 != null) goto L5;
    L6:
        Context r102 = findActivityByContext(r100);
        if (r102 != null) goto L9;
        return;
    L9:
        this.mActivity = new WeakReference(r102);
        showCacheLogMessage();
        return;
    L5:
        if (r101.get() == null) goto L6;
    }

    public void clearLogsWithLevel(LogBoxLogLevel r100) {
        List<String> r101 = this.mLogs.get(r100);
        if (r101 == null) goto L6;
        r101.clear();
        return;
    }

    public String getLastLog(LogBoxLogLevel r100) {
        List<String> r101 = this.mLogs.get(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        if (r101.isEmpty() == false) goto L9;
        return "";
    L9:
        return (String) ListProtector.get(r101, r101.size() - 1);
    }

    public int getLogCount(LogBoxLogLevel r100) {
        List<String> r101 = this.mLogs.get(r100);
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.size();
    }

    public List<String> getLogMessages(LogBoxLogLevel r100) {
        List<String> r101 = this.mLogs.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return new ArrayList();
    }

    public String getLogSourceWithFileName(String r100) {
        a5a.a r101 = this.mProvider.get();
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101.getLogSourceWithFileName(r100);
    }

    public void registerErrorParser(String r100) {
        com.lynx.basedevtool.logbox.a r101 = com.lynx.basedevtool.logbox.a.b.f380485a;
        String r102 = this.mErrNamespace;
        a r103 = new a(r100);
        r101.getClass();
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return;
    L5:
        if (((HashMap) r101.f380484a).get(r102) != null) goto L19;
        Map<String, com.lynx.basedevtool.logbox.a.InterfaceC4542a> r104 = r101.f380484a;
        monitor-enter(r104);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (((HashMap) r101.f380484a).get(r102) != null) goto L11;
        ((HashMap) r101.f380484a).put(r102, r103);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r104);     // Catch: Throwable -> L13
        return;
    }

    private void onNewLog(String r100, LogBoxLogLevel r101) {
        Objects.toString(r101);
        List<String> r102 = this.mLogs.get(r101);
        if (r102 != null) goto L5;
        return;
    L5:
        r102.add(r100);
        WeakReference<Context> r103 = this.mActivity;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.get() == null) goto L13;
        n.a.f1906a.a(r100, r101, this.mActivity.get(), this);
        return;
    }

    public void showLogMessage(String r100, LogBoxLogLevel r101) {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        onNewLog(r100, r101);
        return;
    L8:
        b5a.c.a(new b(this, r100, r101));
        return;
    L5:
        r102 = false;
        goto L6
    }

    public LogBoxProxy(Context r100, String r101, a5a.a r102) {
        this.mProvider = new WeakReference(r102);
        this.mActivity = new WeakReference(null);
        HashMap r103 = new HashMap();
        this.mLogs = r103;
        r103.put(LogBoxLogLevel.Error, new ArrayList());
        this.mLogs.put(LogBoxLogLevel.Warn, new ArrayList());
        if (r101 != null) goto L6;
        r101 = "__unknown__";
    L6:
        this.mErrNamespace = r101;
        attachContext(r100);
    }

    public static /* synthetic */ void access$000(LogBoxProxy r100, String r101, LogBoxLogLevel r102) {
        r100.onNewLog(r101, r102);
    }
}
