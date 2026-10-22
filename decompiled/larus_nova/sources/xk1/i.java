package xk1;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import fq1.t;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes7.dex */
public final class i implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static i f564144n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile LinkedHashMap<String, tp1.a> f564145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, ArrayList<WeakReference<sp1.a>>> f564146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xk1.b f564147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, tp1.a> f564148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f564149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f564150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f564151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f564152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public lm3.d f564153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public NetworkUtils.NetworkType f564154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f564155k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TokenCert f564156l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f564157m;

    public class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f564158a;

        public a(i r100) {
            this.f564158a = r100;
        }

        public final void a(String r100) {
            i r101 = this.f564158a;
            if (r101.f564145a == null) goto L17;
            HashMap<String, tp1.a> r102 = r101.f564148d;
            if (r102 == null) goto L25;
            tp1.a r103 = r102.get(r100);
            r101.f564148d.remove(r100);
            if (r103 == null) goto L23;
            tp1.b r104 = r103.f547013n;
            r104.f547018a = 0;
            r104.f547020c = 0;
            r101.f564145a.remove(r103.f547000a);
            ArrayList<WeakReference<sp1.a>> r105 = r101.f564146b.get(r100);
            if (r105 == null) goto L24;
            Iterator<WeakReference<sp1.a>> r106 = r105.iterator();
        L13:
            if (r106.hasNext() == false) goto L26;
            sp1.a r107 = r106.next().get();
            if (r107 == null) goto L13;
            r107.onCancel();
            goto L13
        L26:
            return;
        L24:
            return;
        L23:
            return;
        L25:
            return;
        }

        public final void c(String r100) {
            i r101 = this.f564158a;
            if (r101.f564145a == null) goto L22;
            tp1.a r102 = r101.f564145a.get(r100);
            if (r102 == null) goto L15;
            r102.f547013n.f547020c = 2;
            ArrayList<WeakReference<sp1.a>> r103 = r101.f564146b.get(r100);
            if (r103 == null) goto L21;
            Iterator r104 = new ArrayList(r103).iterator();
        L11:
            if (r104.hasNext() == false) goto L23;
            sp1.a r105 = (sp1.a) ((WeakReference) r104.next()).get();
            if (r105 == null) goto L11;
            r105.b(r102);
            goto L11
        L23:
            return;
        L21:
            return;
        L15:
            return;
        }

        public final void d(String r100) {
            i r101 = this.f564158a;
            if (r101.f564145a == null) goto L22;
            tp1.a r102 = r101.f564145a.get(r100);
            if (r102 == null) goto L15;
            r102.f547013n.f547020c = 3;
            ArrayList<WeakReference<sp1.a>> r103 = r101.f564146b.get(r100);
            if (r103 == null) goto L21;
            Iterator r104 = new ArrayList(r103).iterator();
        L11:
            if (r104.hasNext() == false) goto L23;
            sp1.a r105 = (sp1.a) ((WeakReference) r104.next()).get();
            if (r105 == null) goto L11;
            r105.d(r102);
            goto L11
        L23:
            return;
        L21:
            return;
        L15:
            return;
        }

        public final void b(String r100, long r101) {
            i r102 = this.f564158a;
            if (r102.f564145a == null) goto L25;
            tp1.a r103 = r102.f564145a.get(r100);
            if (r103 == null) goto L18;
            tp1.b r104 = r103.f547013n;
            r104.f547020c = 5;
            if (r101 <= 0) goto L10;
            r104.f547019b = r101;
        L10:
            r103.update();
            ArrayList<WeakReference<sp1.a>> r105 = r102.f564146b.get(r100);
            if (r105 == null) goto L24;
            Iterator r106 = new ArrayList(r105).iterator();
        L14:
            if (r106.hasNext() == false) goto L26;
            sp1.a r107 = (sp1.a) ((WeakReference) r106.next()).get();
            if (r107 == null) goto L14;
            r107.a(r103);
            goto L14
        L26:
            return;
        L24:
            return;
        L18:
            return;
        }
    }

    public class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f564159a;

        public b(i r100) {
            this.f564159a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101.getAction()) == false) goto L75;
            NetworkUtils.NetworkType r102 = NetworkUtils.b(jc1.a.b(), this.f564159a.f564156l);
            final i r103 = this.f564159a;
            if (r103.f564154j != r102) goto L8;
            return;
        L8:
            if (r103.f564145a != null) goto L11;
        L57:
            this.f564159a.f564154j = r102;
            return;
        L11:
            if (NetworkUtils.f(jc1.a.b()) == true) goto L13;
            r103.j();
            goto L57
        L13:
            if (NetworkUtils.g(jc1.a.b()) == false) goto L16;
            k r104 = new k(r103);
            r103.d();
            r104.run();
            goto L57
        L16:
            if (r103.f564152h == false) goto L18;
            k r105 = new k(r103);
            r103.d();
            r105.run();
            goto L57
        L18:
            Iterator r106 = ((LinkedHashMap) r103.f564147c.f564128b).entrySet().iterator();
        L19:
            boolean r107 = false;
            if (r106.hasNext() == false) goto L29;
            o r108 = (o) ((Map.Entry) r106.next()).getValue();
            if (r108 == null) goto L19;
            int r109 = r108.f564175e;
            if (r109 == 1) goto L28;
            if (r109 == 3) goto L28;
            if (r109 != 6) goto L19;
        L28:
            boolean r110 = true;
        L30:
            if (r110 == false) goto L57;
            r103.j();
            Iterator r111 = ((LinkedHashMap) r103.f564147c.f564128b).entrySet().iterator();
        L33:
            if (r111.hasNext() == false) goto L40;
            o r112 = (o) ((Map.Entry) r111.next()).getValue();
            if (r112 == null) goto L33;
            int r113 = r112.f564175e;
            if (r113 == 7) goto L39;
            if (r113 != 6) goto L33;
        L39:
            r107 = true;
        L40:
            if (r107 == false) goto L57;
            WeakReference<Activity> r114 = com.bytedance.android.live.core.utils.a.f66107a;
            if (r114 == null) goto L57;
            Activity r115 = r114.get();
            if (r115 == null) goto L57;
            if (r115.isFinishing() == true) goto L57;
            lm3.d r116 = r103.f564153i;
            if (r116 != null) goto L53;
        L55:
            r103.f564153i = d.a(r115, new g(r103), new h(r103));
            goto L57
        L53:
            if (r116.isShowing() == false) goto L55;
            i.b(r103.f564153i);
            goto L55
        L29:
            r110 = false;
            goto L30
        }
    }

    public static i f() {
        if (f564144n != null) goto L6;
        f564144n = new i();
    L6:
        return f564144n;
    }

    public final void j() {
        xk1.b r100 = this.f564147c;
        r100.getClass();
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((LinkedHashMap) r100.f564128b).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        o r103 = (o) ((Map.Entry) r102.next()).getValue();
        if (r103 == null) goto L4;
        int r104 = r103.f564175e;
        if (r104 == 1) goto L10;
        if (r104 != 3) goto L4;
        r103.c(6);
        p r105 = r100.f564131e;
        if (r105 == null) goto L4;
        String r106 = r103.a();
        ((a) r105).f564158a.h(r106, 12);
        goto L4
    L10:
        r101.add(r103);
        goto L4
    L16:
        Iterator r107 = r101.iterator();
    L18:
        if (r107.hasNext() == false) goto L23;
        o r108 = (o) r107.next();
        r108.c(6);
        p r109 = r100.f564131e;
        if (r109 == null) goto L22;
        String r110 = r108.a();
        ((a) r109).f564158a.h(r110, 12);
    L22:
        r100.f564130d[r108.f564171a] = null;
        goto L18
    }

    public i() {
        this.f564146b = new LinkedHashMap();
        this.f564148d = new HashMap();
        new ArrayList();
        this.f564152h = false;
        this.f564155k = new Object();
        this.f564156l = TokenCert.with("bpea-vs_download_network");
        String r100 = "";
        this.f564157m = "";
        Application r101 = jc1.a.b();
        if (TextUtils.isEmpty(com.bytedance.android.livesdk.chatroom.replay.cache.b.f108138b) == false) goto L5;
    L44:
        com.bytedance.android.livesdk.chatroom.replay.cache.b.f108137a = System.currentTimeMillis();     // Catch: Throwable -> L9
        com.bytedance.android.livesdk.chatroom.replay.cache.b.f108138b = Environment.getExternalStorageState();     // Catch: Throwable -> L9
        String r102 = com.bytedance.android.livesdk.chatroom.replay.cache.b.f108138b;     // Catch: Throwable -> L9
    L10:
        PolarisFileWrapper r103 = null;
        if ("mounted".equals(r102) == false) goto L32;
        File r104 = r101.getExternalFilesDir(null);
        if (r104 == null) goto L23;
        r100 = r104.getAbsolutePath();
        if (TextUtils.isEmpty(r100) == true) goto L23;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r100);
        if (r105.exists() == true) goto L23;
        r105.mkdirs();     // Catch: Throwable -> L22
    L23:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r100);
        if (r106.exists() == false) goto L27;
    L30:
        r103 = r106;
        goto L32
    L27:
        if (r106.mkdirs() == true) goto L40;
        Logger.w("DownloadManager", "Unable to create external cache directory");
        goto L32
    L40:
        new PolarisFileWrapper(r106, ".nomedia").createNewFile();     // Catch: IOException -> L31
    L31:
        Logger.e("DownloadManager", "Can't create \".nomedia\" file in application external cache directory");
    L32:
        if (r103 == null) goto L34;
        this.f564149e = r103.getAbsolutePath();
        this.f564150f = r103.getAbsolutePath() + "/vs_video_offline/";
        this.f564151g = r103.getAbsolutePath() + "/vs_video_offline_covers/";
    L34:
        xk1.b r107 = new xk1.b();
        this.f564147c = r107;
        r107.f564131e = new a(this);
        this.f564154j = NetworkUtils.b(jc1.a.b(), this.f564156l);
        IntentFilter r108 = new IntentFilter();
        r108.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        a(jc1.a.b(), new b(this), r108);     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        ALogger.e("DownloadManager", th);
        return;
    L9:
        r102 = "";
        goto L10
    L5:
        if ((System.currentTimeMillis() - com.bytedance.android.livesdk.chatroom.replay.cache.b.f108137a) >= 5000) goto L44;
        r102 = com.bytedance.android.livesdk.chatroom.replay.cache.b.f108138b;
        goto L10
    }

    public final void d() {
        String r100 = t.a().getCurrentUserId();
        ALogger.e("DownloadManager", "checkInitDB userId:" + r100 + ",lastCheckInitUid:" + this.f564157m);
        if (this.f564157m.equals(r100) == true) goto L6;
        this.f564145a = null;
    L6:
        if (this.f564145a == null) goto L8;
        return;
    L8:
        this.f564157m = r100;
        Object r101 = this.f564155k;
        monitor-enter(r101);
    L35:
        th = move-exception;
        throw th;
    L11:
        if (this.f564145a != null) goto L33;
        LinkedHashMap<String, tp1.a> r102 = new LinkedHashMap();     // Catch: Throwable -> L35
        List<tp1.a> r103 = tp1.a.b();     // Catch: Throwable -> L35
        if (r103 == null) goto L30;
        ArrayList r104 = (ArrayList) r103;     // Catch: Throwable -> L35
        if (r104.size() == 0) goto L30;
        Iterator r105 = r104.iterator();     // Catch: Throwable -> L35
    L19:
        if (r105.hasNext() == false) goto L29;
        tp1.a r106 = (tp1.a) r105.next();     // Catch: Throwable -> L35
        tp1.b r107 = r106.f547013n;     // Catch: Throwable -> L35
        if (r107.f547020c != 1) goto L23;
        r107.f547020c = 2;     // Catch: Throwable -> L35
    L23:
        String r108 = g(r106.f547000a);     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r108) == true) goto L28;
        if (new PolarisFileWrapper(r108).exists() == false) goto L28;
        r102.put(r106.f547000a, r106);     // Catch: Throwable -> L35
    L28:
        tp1.a.delete("video_id=?", new String[]{r106.f547000a});     // Catch: Throwable -> L35
        goto L19
    L29:
        this.f564145a = r102;     // Catch: Throwable -> L35
    L30:
        this.f564145a = r102;     // Catch: Throwable -> L35
        monitor-exit(r101);     // Catch: Throwable -> L35
        return;
    L33:
        monitor-exit(r101);     // Catch: Throwable -> L35
    }

    public static void b(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final String e(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        String r101 = this.f564150f;
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return "";
    L11:
        return r101 + r100;
    }

    public final String g(String r100) {
        String r101 = e(r100);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        xf2.c r102 = xf2.c.f563442a;
        boolean r103 = false;
        if (TextUtils.isEmpty(r101) == true) goto L14;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);
        if (r104.isFile() == false) goto L14;
        if (r104.exists() == false) goto L14;
        r103 = true;
    L14:
        if (r103 == false) goto L16;
        return r101;
    L16:
        return r101 + ".temp";
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100.what != 110) goto L16;
        ArrayList r101 = (ArrayList) r100.obj;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f564149e != null) goto L13;
        if (r101.size() <= 0) goto L17;
        this.f564147c.a(r101, false);
        return;
    L17:
        return;
    L13:
        if (r101.size() <= 0) goto L19;
        this.f564147c.a(r101, true);
        return;
    L19:
        return;
    }

    public final void h(String r100, int r101) {
        if (this.f564145a != null) goto L5;
        return;
    L5:
        tp1.a r102 = this.f564145a.get(r100);
        if (r102 == null) goto L15;
        tp1.b r103 = r102.f547013n;
        r103.f547021d = r101;
        r103.f547020c = 6;
        r102.update();
        ArrayList<WeakReference<sp1.a>> r104 = this.f564146b.get(r100);
        if (r104 == null) goto L21;
        Iterator r105 = new ArrayList(r104).iterator();
    L11:
        if (r105.hasNext() == false) goto L22;
        sp1.a r106 = (sp1.a) ((WeakReference) r105.next()).get();
        if (r106 == null) goto L11;
        r106.e(r102, r101);
        goto L11
    L22:
        return;
    L21:
        return;
    }

    public final void i(String r100, sp1.a r101) {
        if (TextUtils.isEmpty(r100) == true) goto L19;
        if (r101 == null) goto L20;
        ArrayList<WeakReference<sp1.a>> r102 = this.f564146b.get(r100);
        if (r102 != null) goto L8;
        r102 = new ArrayList();
        this.f564146b.put(r100, r102);
    L8:
        Iterator<WeakReference<sp1.a>> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        if (r103.next().get() != r101) goto L10;
        return;
    L14:
        r102.add(new WeakReference(r101));
        return;
    L20:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Application r100, b r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    public final void c(tp1.a[] r100, boolean r101, sp1.a r110) {
        if (this.f564145a != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L46;
        ArrayList r102 = new ArrayList();
        int r103 = r100.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L39;
        tp1.a r105 = r100[r104];
        if (r105 == null) goto L37;
        if (r105.f547000a == null) goto L37;
        if (this.f564145a.containsKey(r105.f547000a) == false) goto L19;
        tp1.a r106 = this.f564145a.get(r105.f547000a);
        VideoRef r107 = r105.f547009j;
        if (r107 == null) goto L18;
        r106.f547009j = r107;
    L18:
        r105 = r106;
    L29:
        if (r110 == null) goto L36;
        ArrayList<WeakReference<sp1.a>> r108 = this.f564146b.get(r105.f547000a);
        if (r108 != null) goto L34;
        r108 = new ArrayList();
        this.f564146b.put(r105.f547000a, r108);
    L34:
        if (r108.contains(r110) == true) goto L36;
        r108.add(new WeakReference(r110));
    L36:
        r102.add(r105);
        goto L37
    L19:
        VideoRef r109 = r105.f547009j;
        if (r109 == null) goto L28;
        VideoInfo r111 = q.a(r105.f547007h, r109);
        if (r111 != null) goto L24;
        String r112 = null;
    L26:
        if (TextUtils.isEmpty(r112) == true) goto L28;
        r105.f547013n.f547023f = r112;
        goto L28
    L24:
        r112 = r111.getValueStr(5);
    L28:
        this.f564145a.put(r105.f547000a, r105);
        r105.insert();
    L37:
        r104 = r104 + 1;
        goto L7
    L39:
        if (r102.size() <= 0) goto L47;
        this.f564147c.a(r102, r101);
        return;
    L47:
        return;
    }
}
