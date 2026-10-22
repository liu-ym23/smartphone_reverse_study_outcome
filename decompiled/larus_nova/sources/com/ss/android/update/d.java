package com.ss.android.update;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.SignUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.platform.model.upload.ResourceUploadError;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.constants.DownloadConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import ita.k;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import yhc.b0;
import yhc.c0;
import yhc.f0;
import yhc.g0;
import yhc.i;
import yhc.i0;
import yhc.k0;
import yhc.l;
import yhc.l0;
import yhc.n;
import yhc.o;
import yhc.p;
import yhc.q;
import yhc.u;
import yhc.v;
import yhc.y;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements i {
    public static d B0;
    public String A;
    public long A0;
    public String B;
    public boolean C;
    public int D;
    public long E;
    public int F;
    public String G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public volatile boolean f455251J;
    public final yhc.a K;
    public h L;
    public int M;
    public volatile boolean N;
    public final yhc.a O;
    public int P;
    public String Q;
    public int R;
    public int S;
    public int T;
    public String U;
    public String V;
    public volatile boolean W;
    public int X;
    public int Y;
    public String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f455252a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f455253a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f455254b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f455255b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NotificationCompat.Builder f455256c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f455257c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f455258d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public String f455259d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f455260e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public f f455261e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f455262f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final g f455263f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f455264g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final List<OnUpdateStatusChangedListener> f455265g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f455266h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public l f455267h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f455268i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public yhc.h f455269i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f455270j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public String f455271j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f455272k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f455273k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f455274l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public String f455275l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f455276m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f455277m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f455278n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final IUpdateConfig f455279n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f455280o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final com.ss.android.update.b f455281o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f455282p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final v f455283p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f455284q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final ExecutorService f455285q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f455286r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public volatile int f455287r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f455288s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final AppCommonContext f455289s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f455290t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public com.ss.android.update.e f455291t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f455292u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f455293u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f455294v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public u f455295v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f455296w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public yhc.g f455297w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f455298x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public l f455299x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f455300y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f455301y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f455302z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public String f455303z0;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f455304a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v17 */
        /* JADX WARN: Type inference failed for: r6v18, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r6v19 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public final void handleMessage(Message r110) {
            d r100 = this.f455304a;
            r100.getClass();
            int r101 = 0;
            boolean r102 = false;
            char r103 = 0;
            r103 = 0;
            r103 = 0;
            int r111 = 1;
            PendingIntent r104 = null;
            String r105 = null;
            r105 = null;
            yhc.h r106 = null;
            yhc.h r107 = null;
            switch(r110.what) {
                case 1: goto L308;
                case 2: goto L306;
                case 3: goto L314;
                case 4: goto L310;
                case 5: goto L207;
                case 6: goto L122;
                case 7: goto L92;
                case 8: goto L38;
                case 9: goto L28;
                case 10: goto L25;
                case 11: goto L24;
                case 12: goto L23;
                case 13: goto L316;
                case 14: goto L342;
                case 15: goto L15;
                case 16: goto L13;
                case 17: goto L6;
                default: goto L342;
            };
        L15:
            ThreadPlus.submitRunnable(new b0(r100, r110.arg1, r110.arg2));
            return;
        L23:
            r100.f455254b.cancel(R.id.ssl_notify_download_fail);     // Catch: Exception -> L302
        L318:
            return;
        L24:
            r100.f455254b.cancel(R.id.ssl_notify_update_avail);     // Catch: Exception -> L302
            goto L318
        L25:
            r100.f455254b.cancel(R.id.ssl_notify_download_ok);     // Catch: Exception -> L302
            goto L318
        L38:
            Object r108 = r110.obj;
            if ((r108 instanceof com.ss.android.update.b.a) == false) goto L41;
            com.ss.android.update.b.a r109 = (com.ss.android.update.b.a) r108;
        L43:
            if (r110.arg1 != 1) goto L45;
            ?? r112 = 1;
        L47:
            if (r110.arg2 != 1) goto L49;
            boolean r113 = true;
        L50:
            if (r109 != null) goto L52;
            r109 = new com.ss.android.update.b.a();
        L52:
            JSONObject r114 = new JSONObject();
            if (r100.f() == true) goto L55;
            r105 = "canDownloadApk = false";
        L61:
            if (TextUtils.isEmpty(r105) == false) goto L84;
            com.ss.android.update.b r115 = r100.f455281o0;
            String r116 = r100.f455274l;
            if (r112 == 0) goto L65;
            String r117 = "predownload.apk.part";
        L68:
            String r118 = r100.f455262f + File.separator;
            int r119 = r100.f455280o;
            r115.f455245b = false;
            r115.f455247d = new WeakReference(r100);
            r115.f455248e = r109;
            AppTaskBuilder r120 = new AppTaskBuilder(r115.f455244a, r116).saveName(r117).savePath(r118).taskKey(r116 + ":" + r118 + ":" + r117).needWifi(false).showNotification(false).needReuseFirstConnection(true).needDefaultHttpServiceBackUp(true).ignoreInterceptor(true).mainThreadListener(new com.ss.android.update.a(r115, r112, r116, r119));
            com.ss.android.update.b.a r121 = r115.f455248e;
            if (r121 != null) goto L71;
        L73:
            int r122 = AppDownloader.getInstance().addDownloadTask(r120);
            r115.f455246c = r122;
            if (r122 != 0) goto L80;
            i r123 = r115.f455247d.get();
            if (r123 == 0) goto L78;
            r123.a(false, r112);
        L78:
            com.ss.android.update.c.e("does not support, mid == 0");
            com.ss.android.update.c.d(r116, r119, r112, "unSupport", "mid == 0");
        L80:
            if (Logger.debug() == false) goto L82;
            Logger.d("UpdateDownloadHelper", "id " + r115.f455246c);
        L82:
            if (r112 != 0) goto L351;
            r100.f455260e.sendEmptyMessage(3);
            return;
        L351:
            return;
        L71:
            if (r121.f455249a == false) goto L73;
            r120.retryCount(3);
            goto L73
        L65:
            if (r113 == false) goto L67;
            r117 = "update_alpha.apk.part";
            goto L68
        L67:
            r117 = "update.apk.part";
            goto L68
        L84:
            r100.f455251J = false;
            if (r109.f455249a == true) goto L88;
            l0.a(r114, "errorMsg", r105);
            l0.a(r114, "url", r100.f455274l);
            l0.a(r114, TeaEventTrack.ACTION_DRAMA_PRE, Integer.valueOf(r112));
            l0.a(r114, ResourceUploadError.CANCELED, 0);
            l0.a(r114, "success", 0);
            yhc.b.a("app_update_download", r114);
            com.ss.android.update.c.e(r105);
            com.ss.android.update.c.d(r100.f455274l, r100.f455280o, r112, "fail", r105);
            return;
        L88:
            if (d.x().f455281o0.f455248e != null) goto L90;
            d.x().f455281o0.f455248e = r109;
        L90:
            com.ss.android.update.c.d(r100.f455274l, r100.f455280o, r112, "fail", r105);
            return;
        L55:
            PolarisFileWrapper r124 = new PolarisFileWrapper(r100.f455262f);
            if (r124.isDirectory() == true) goto L61;
            if (r124.mkdirs() == true) goto L61;
            r105 = "can not mkdir files dir: " + r100.f455262f;
            Logger.e("UpdateHelper", r105);
            goto L61
        L49:
            r113 = false;
            goto L50
        L45:
            r112 = 0;
            goto L47
        L41:
            r109 = null;
            goto L43
        L207:
            int r125 = r110.arg1;
            if (r125 < 0) goto L212;
            r101 = r125;
        L212:
            if (r101 <= 99) goto L214;
            r101 = 99;
        L214:
            r100.f455254b.notify(R.id.ssl_notify_downloading, r100.B(r101));
            return;
        L306:
            r100.f455254b.cancel(R.id.ssl_notify_download_ok);     // Catch: Exception -> L237
            r100.f455254b.cancel(R.id.ssl_notify_download_fail);     // Catch: Exception -> L237
        L239:
            if (r100.f() == false) goto L372;
            AppCommonContext r126 = r100.f455289s0;
            if (r126 == null) goto L244;
            String r127 = r126.getStringAppName();
        L245:
            String r128 = String.format(r100.f455258d.getString(R.string.ssl_notify_avail_ticker), new Object[]{r127, r100.z()});
            String r129 = String.format(r100.f455258d.getString(R.string.ssl_notify_avail_fmt), new Object[]{r100.z()});
            Intent r130 = new Intent();
            if (TextUtils.isEmpty(null) == false) goto L248;
            r130.setClassName(r100.f455258d, UpdateProgressActivity.class.getName());
        L252:
            r130.putExtra("from_update_avail", true);
            r130.addFlags(536870912);
            int r131 = Build.VERSION.SDK_INT;
            if (r131 < 23) goto L255;
            int r132 = 67108864;
        L256:
            PendingIntent r133 = PendingIntent.getActivity(r100.f455258d, 0, r130, r132);
            v r134 = r100.f455283p0;
            if (r134 != null) goto L259;
        L261:
            r104 = r133;
        L262:
            NotificationCompat.Builder r135 = new NotificationCompat.Builder(r100.f455258d);
            if (r131 < 26) goto L265;
            r135.setChannelId("update_channel_01");
            r135.setVibrate(new long[]{0});
        L265:
            v r136 = r100.f455283p0;
            if (r136 == null) goto L268;
            int r137 = r136.f567737a;
        L269:
            r135.setSmallIcon(r137).setTicker(r128).setWhen(System.currentTimeMillis()).setContentTitle(r127).setContentText(r129).setContentIntent(r104).setAutoCancel(true);
            r100.f455254b.notify(R.id.ssl_notify_update_avail, r135.build());
            return;
        L268:
            r137 = R.drawable.status_icon_l;
            goto L269
        L259:
            if (r134.f567743g == false) goto L261;
        L255:
            r132 = 0;
            goto L256
        L248:
            if (Logger.debug() == false) goto L250;
            Logger.d("UpdateHelper", "iUpdateActivity.getClass().getName() null");
        L250:
            r130.setClassName(r100.f455258d, null);
            goto L252
        L244:
            r127 = "";
            goto L245
        L372:
            return;
        L308:
            r100.f455254b.cancel(R.id.ssl_notify_downloading);     // Catch: Exception -> L272
            r100.f455254b.cancel(R.id.ssl_notify_update_avail);     // Catch: Exception -> L272
            r100.f455254b.cancel(R.id.ssl_notify_download_fail);     // Catch: Exception -> L272
        L273:
            PolarisFileWrapper r138 = new PolarisFileWrapper(r100.f455264g);
            if (r138.exists() == true) goto L276;
        L294:
            com.ss.android.update.c.d(r100.f455274l, r100.f455280o, false, "install_fail", "notifyDownloadReady");
        L296:
            if (r100.f455261e0 != null) goto L298;
            return;
        L298:
            if (Logger.debug() == false) goto L300;
            Logger.d("UpdateHelper", "from MSG_UPDATE_READY");
        L300:
            r100.q();
            return;
        L276:
            if (r138.isFile() == false) goto L294;
            AppCommonContext r139 = r100.f455289s0;
            if (r139 == null) goto L281;
            String r140 = r139.getStringAppName();
        L282:
            String r141 = String.format(r100.f455258d.getString(R.string.ssl_notify_ready_ticker), new Object[]{r140, r100.z()});
            String r142 = String.format(r100.f455258d.getString(R.string.ssl_notify_ready_fmt), new Object[]{r100.z()});
            Intent r143 = r100.y(r100.f455258d, r138);
            int r144 = Build.VERSION.SDK_INT;
            if (r144 < 23) goto L285;
            int r145 = 67108864;
        L286:
            PendingIntent r146 = PendingIntent.getActivity(r100.f455258d, 0, r143, r145);
            NotificationCompat.Builder r147 = new NotificationCompat.Builder(r100.f455258d);
            if (r144 < 26) goto L289;
            r147.setChannelId("update_channel_01");
            r147.setVibrate(new long[]{0});
        L289:
            v r148 = r100.f455283p0;
            if (r148 == null) goto L292;
            int r149 = r148.f567737a;
        L293:
            r147.setSmallIcon(r149);
            r147.setTicker(r141);
            r147.setWhen(System.currentTimeMillis());
            r147.setContentTitle(r140).setContentText(r142);
            r147.setContentIntent(r146);
            r147.setAutoCancel(true);
            r100.f455254b.notify(R.id.ssl_notify_download_ok, r147.build());
            r100.L(r100.f455258d, r138);
            goto L296
        L292:
            r149 = R.drawable.status_icon_l;
            goto L293
        L285:
            r145 = 0;
            goto L286
        L281:
            r140 = "";
            goto L282
        L310:
            r100.f455254b.cancel(R.id.ssl_notify_downloading);     // Catch: Exception -> L217
            r100.f455254b.cancel(R.id.ssl_notify_download_ok);     // Catch: Exception -> L217
            r100.f455254b.cancel(R.id.ssl_notify_update_avail);     // Catch: Exception -> L217
        L219:
            if (r100.f() == false) goto L371;
            AppCommonContext r150 = r100.f455289s0;
            if (r150 == null) goto L224;
            String r151 = r150.getStringAppName();
        L225:
            String r152 = r100.f455258d.getString(R.string.ssl_download_fail);
            int r153 = Build.VERSION.SDK_INT;
            if (r153 < 23) goto L228;
            int r154 = 67108864;
        L229:
            PendingIntent r155 = PendingIntent.getActivity(r100.f455258d, 0, new Intent(), r154);
            NotificationCompat.Builder r156 = new NotificationCompat.Builder(r100.f455258d);
            if (r153 < 26) goto L232;
            r156.setChannelId("update_channel_01");
            r156.setVibrate(new long[]{0});
        L232:
            r156.setSmallIcon(android.R.drawable.stat_notify_error).setChannelId("update_channel_01").setTicker(r152).setWhen(System.currentTimeMillis()).setContentTitle(r151).setContentText(r152).setContentIntent(r155).setAutoCancel(true);
            r100.f455254b.notify(R.id.ssl_notify_download_fail, r156.build());
            return;
        L228:
            r154 = 0;
            goto L229
        L224:
            r151 = "";
            goto L225
        L371:
            return;
        L314:
            r100.f455254b.cancel(R.id.ssl_notify_downloading);     // Catch: Exception -> L303
            r100.f455254b.cancel(R.id.ssl_notify_download_fail);     // Catch: Exception -> L303
            r100.f455254b.cancel(R.id.ssl_notify_download_ok);     // Catch: Exception -> L303
            r100.f455254b.cancel(R.id.ssl_notify_update_avail);     // Catch: Exception -> L303
        L234:
            r100.f455254b.notify(R.id.ssl_notify_downloading, r100.B(0));
            return;
        L316:
            r100.f455254b.cancel(R.id.ssl_notify_downloading);     // Catch: Exception -> L18
        L20:
            if (Logger.debug() == false) goto L22;
            Logger.d("UpdateHelper", "from MSG_CANCEL_PROGRESS");
        L22:
            r100.q();
            return;
        L342:
            return;
        L6:
            if (r100.W == false) goto L8;
            com.ss.android.update.c.a(6, "other dialog showing", null);
            return;
        L8:
            p r157 = p.b.f567725a;
            if (r157.b(r100.f455280o) == false) goto L11;
            com.ss.android.update.c.a(6, "ignore version:" + r100.f455280o, null);
            return;
        L11:
            r157.a();
            com.ss.android.update.c.a(6, "condition not match2", null);
            return;
        L13:
            if (p.b.f567725a.b(r100.f455280o) == true) goto L346;
            ThreadPlus.submitRunnable(new c0(r100));
            return;
        L346:
            return;
        L28:
            if (r100.f455251J == false) goto L30;
            r100.f455251J = false;
        L30:
            JSONObject r158 = new JSONObject();
            l0.a(r158, "errorMsg", "has not get positive result from update checking");
            l0.a(r158, "url", r100.f455274l);
            if (r110.arg1 != 1) goto L33;
            int r159 = 1;
        L34:
            l0.a(r158, TeaEventTrack.ACTION_DRAMA_PRE, Integer.valueOf(r159));
            l0.a(r158, ResourceUploadError.CANCELED, 0);
            l0.a(r158, "success", 0);
            yhc.b.a("app_update_download", r158);
            String r160 = r100.f455274l;
            int r161 = r100.f455280o;
            if (r110.arg1 != 1) goto L37;
            r102 = true;
        L37:
            com.ss.android.update.c.d(r160, r161, r102, "fail", "has not get positive result from update checking");
            return;
        L33:
            r159 = 0;
            goto L34
        L92:
            if (Logger.debug() == false) goto L94;
            Logger.d("UpdateHelper", "from MSG_CHECK_UPDATE_FAIL");
        L94:
            r100.q();
            List<OnUpdateStatusChangedListener> r162 = r100.f455265g0;
            monitor-enter(r162);
            Iterator r163 = ((ArrayList) r100.f455265g0).iterator();     // Catch: Throwable -> L118
        L98:
            if (r163.hasNext() == false) goto L105;
            OnUpdateStatusChangedListener r164 = (OnUpdateStatusChangedListener) r163.next();     // Catch: Throwable -> L118
            if (r164 == null) goto L98;
            if (r100.Q() == true) goto L103;
            r164.c(-2);     // Catch: Throwable -> L118
            goto L98
        L103:
            r164.c(-1);     // Catch: Throwable -> L118
            goto L98
        L105:
            monitor-exit(r162);     // Catch: Throwable -> L118
            if (r100.f455287r0 == 1) goto L109;
            return;
        L109:
            if (r100.f455291t0 != null) goto L111;
            r100.f455291t0 = new com.ss.android.update.e();
        L111:
            com.ss.android.update.e r165 = r100.f455291t0;
            yhc.h r166 = r100.f455269i0;
            if (r166 == null) goto L114;
            r106 = r166;
        L114:
            r165.getClass();
            r165.f455331j = new WeakReference(r106);
            if (r100.Q() == false) goto L117;
            r100.f455291t0.b(-1);
            return;
        L117:
            r100.f455291t0.b(-2);
            return;
        L118:
            th = move-exception;
            throw th;
        L122:
            if (r110.arg1 != 1) goto L124;
            boolean r167 = true;
        L126:
            if (r100.f455287r0 == (-2)) goto L138;
            if (r100.f455287r0 == 2) goto L138;
            if (r100.f455287r0 == (-1)) goto L135;
            if (r100.f455287r0 == 1) goto L135;
        L140:
            if (r167 == true) goto L142;
        L144:
            if (r103 == 0) goto L158;
            List<OnUpdateStatusChangedListener> r168 = r100.f455265g0;
            monitor-enter(r168);
            Iterator r169 = ((ArrayList) r100.f455265g0).iterator();     // Catch: Throwable -> L155
        L149:
            if (r169.hasNext() == false) goto L153;
            OnUpdateStatusChangedListener r170 = (OnUpdateStatusChangedListener) r169.next();     // Catch: Throwable -> L155
            if (r170 == null) goto L149;
            r170.c(1);     // Catch: Throwable -> L155
            goto L149
        L153:
            monitor-exit(r168);     // Catch: Throwable -> L155
        L168:
            if (r100.f455291t0 != null) goto L170;
            r100.f455291t0 = new com.ss.android.update.e();
        L170:
            com.ss.android.update.e r171 = r100.f455291t0;
            yhc.h r172 = r100.f455269i0;
            if (r172 == null) goto L173;
            r107 = r172;
        L173:
            r171.getClass();
            r171.f455331j = new WeakReference(r107);
            if (r100.f455287r0 != 2) goto L198;
            com.ss.android.update.e r173 = r100.f455291t0;
            IUpdateConfig r174 = f0.f567692a;
            r173.f455323b = r174;
            i0 r175 = r174.getUpdateConfig().a();
            if (r175 == null) goto L367;
            yhc.d r176 = r173.f455323b.getUpdateConfig().f567742f;
            if (r176 == null) goto L196;
            WeakReference<Activity> r177 = r176.getCurrentActivity();
            if (r177 == null) goto L368;
            Activity r178 = r177.get();
            if (r178 != null) goto L186;
            return;
        L186:
            if (r178.isFinishing() == false) goto L189;
            return;
        L189:
            if (r173.f455322a.isCurrentVersionOut() == true) goto L192;
            return;
        L192:
            if (Logger.debug() == false) goto L194;
            Logger.i("UpdateShowServiceImpl", "tryShowBigDialog");
        L194:
            r173.f455332k.postDelayed(new g0(r173, r178, r175, r167), r173.f455322a.getLatency() * 1000);
            return;
        L368:
            return;
        L196:
            throw new IllegalArgumentException("iCurrentActivityCallback can not null");
        L367:
            return;
        L198:
            if (r100.f455287r0 != 1) goto L360;
            com.ss.android.update.e r179 = r100.f455291t0;
            if (r100.Q() == true) goto L203;
            r111 = -2;
        L203:
            r179.b(r111);
            return;
        L360:
            return;
        L155:
            th = move-exception;
            throw th;
        L158:
            List<OnUpdateStatusChangedListener> r180 = r100.f455265g0;
            monitor-enter(r180);
            Iterator r181 = ((ArrayList) r100.f455265g0).iterator();     // Catch: Throwable -> L204
        L162:
            if (r181.hasNext() == false) goto L166;
            OnUpdateStatusChangedListener r182 = (OnUpdateStatusChangedListener) r181.next();     // Catch: Throwable -> L204
            if (r182 == null) goto L162;
            r182.c(-2);     // Catch: Throwable -> L204
            goto L162
        L166:
            monitor-exit(r180);     // Catch: Throwable -> L204
        L204:
            th = move-exception;
            throw th;
        L142:
            if (r100.f455283p0.f567744h == false) goto L144;
            p.b.f567725a.a();
        L135:
            if (r100.Q() == false) goto L140;
        L139:
            r103 = 1;
        L138:
            if (r100.O() == false) goto L140;
        L124:
            r167 = false;
        }

        public a(d r100, Looper r101) {
            this.f455304a = r100;
            super(r101);
        }
    }

    /* JADX INFO: loaded from: classes40.dex */
    public class b extends eta.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f455305g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ d f455306h;

        @Override // java.lang.Runnable
        public final void run() {
            this.f455306h.t(this.f455305g);     // Catch: Throwable -> L4 Exception -> L6
        L16:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }

        public b(d r100, boolean r101) {
            this.f455306h = r100;
            this.f455305g = r101;
        }
    }

    /* JADX INFO: loaded from: classes40.dex */
    public class c extends ThreadPlus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f455307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f455308b;

        public final void a() {
        L10:
            e = move-exception;
            e.printStackTrace();
            return;
        L3:
            if (this.f455308b.f455301y0 == false) goto L8;
            Message r100 = Message.obtain();     // Catch: Exception -> L10
            r100.what = 8;     // Catch: Exception -> L10
            r100.arg1 = 0;     // Catch: Exception -> L10
            if (this.f455307a == false) goto L7;
            r100.arg2 = 1;     // Catch: Exception -> L10
        L7:
            this.f455308b.f455260e.sendMessage(r100);     // Catch: Exception -> L10
            return;
        L8:
            Message r101 = Message.obtain();     // Catch: Exception -> L10
            r101.what = 9;     // Catch: Exception -> L10
            r101.arg1 = 0;     // Catch: Exception -> L10
            this.f455308b.f455260e.sendMessage(r101);     // Catch: Exception -> L10
        }

        @Override // com.bytedance.common.utility.concurrent.ThreadPlus, java.lang.Runnable
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

        public c(d r100, boolean r101) {
            this.f455308b = r100;
            this.f455307a = r101;
            super("StartDownload-Thread");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.update.d$d, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes40.dex */
    public class C5456d extends ThreadPlus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f455309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f455310b;

        public final void a() {
            com.ss.android.update.b.a r100 = new com.ss.android.update.b.a();     // Catch: Exception -> L7
            r100.f455249a = this.f455309a;     // Catch: Exception -> L7
            d r101 = this.f455310b;     // Catch: Exception -> L7
            if (r101.f455301y0 == false) goto L5;
            Message r102 = Message.obtain();     // Catch: Exception -> L7
            r102.what = 8;     // Catch: Exception -> L7
            r102.arg1 = 1;     // Catch: Exception -> L7
            r102.obj = r100;     // Catch: Exception -> L7
            this.f455310b.f455260e.sendMessage(r102);     // Catch: Exception -> L7
        L10:
            return;
        L5:
            r101.N = false;     // Catch: Exception -> L7
            Message r103 = Message.obtain();     // Catch: Exception -> L7
            r103.what = 9;     // Catch: Exception -> L7
            r103.arg1 = 1;     // Catch: Exception -> L7
            r103.obj = r100;     // Catch: Exception -> L7
            this.f455310b.f455260e.sendMessage(r103);     // Catch: Exception -> L7
        L7:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.bytedance.common.utility.concurrent.ThreadPlus, java.lang.Runnable
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

        public C5456d(d r100, boolean r101) {
            this.f455310b = r100;
            this.f455309a = r101;
            super("StartDownload-Thread");
        }
    }

    /* JADX INFO: loaded from: classes40.dex */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f455311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f455312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.update.b.a f455313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f455314d;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v9 */
        public final void a() {
            d r100 = this.f455314d;
            boolean r101 = this.f455311a;
            boolean r102 = this.f455312b;
            com.ss.android.update.b.a r103 = this.f455313c;
            r100.getClass();
            JSONObject r104 = new JSONObject();
            boolean r105 = r101;
            if (r101 == false) goto L34;
            if (r102 == true) goto L9;
            PolarisFileWrapper r106 = new PolarisFileWrapper(r100.f455264g);
            r106.delete();
            PolarisFileWrapper r107 = new PolarisFileWrapper(r100.f455266h);
            if (r107.isFile() == true) goto L13;
            r107.delete();
            String r108 = r100.f455266h + " is not a file.";
            ?? r109 = r101;
        L35:
            if (r109 != 0) goto L37;
        L43:
            boolean r110 = r100.f455281o0.f455245b;
            yhc.a r111 = r100.K;
            monitor-enter(r111);
            if (r102 == false) goto L52;
            r100.N = false;     // Catch: Throwable -> L78
            if (r109 == 0) goto L58;
            if (r103 == null) goto L58;
            if (r103.f455249a == false) goto L58;
            r100.f455260e.sendEmptyMessage(16);     // Catch: Throwable -> L78
        L58:
            List<OnUpdateStatusChangedListener> r112 = r100.f455265g0;     // Catch: Throwable -> L78
            monitor-enter(r112);     // Catch: Throwable -> L78
            Iterator r113 = ((ArrayList) r100.f455265g0).iterator();     // Catch: Throwable -> L75
        L62:
            if (r113.hasNext() == false) goto L66;
            OnUpdateStatusChangedListener r114 = (OnUpdateStatusChangedListener) r113.next();     // Catch: Throwable -> L75
            if (r114 == 0) goto L62;
            r114.a(r109, r102);     // Catch: Throwable -> L75
            goto L62
        L66:
            monitor-exit(r112);     // Catch: Throwable -> L75
            monitor-exit(r111);     // Catch: Throwable -> L78
            l0.a(r104, "errorMsg", r108);
            l0.a(r104, "url", r100.f455274l);
            l0.a(r104, TeaEventTrack.ACTION_DRAMA_PRE, Integer.valueOf(r102 ? 1 : 0));
            l0.a(r104, ResourceUploadError.CANCELED, Integer.valueOf(r110 ? 1 : 0));
            l0.a(r104, "success", Integer.valueOf(r109));
            yhc.b.a("app_update_download", r104);
            if (r109 == 0) goto L71;
        L73:
            r100.f455281o0.f455248e = null;
            return;
        L71:
            if (TextUtils.isEmpty(r108) == true) goto L73;
            com.ss.android.update.c.e(r108);
            com.ss.android.update.c.d(r100.f455274l, r100.f455280o, r102, "fail", r108);
            goto L73
        L75:
            th = move-exception;
            throw th;     // Catch: Throwable -> L78
        L52:
            r100.f455251J = false;     // Catch: Throwable -> L78
            if (r109 == 0) goto L55;
            r100.f455260e.sendEmptyMessage(1);     // Catch: Throwable -> L78
            goto L58
        L55:
            if (r110 == false) goto L57;
            r100.f455260e.sendEmptyMessage(13);     // Catch: Throwable -> L78
            goto L58
        L57:
            r100.f455260e.sendEmptyMessage(4);     // Catch: Throwable -> L78
        L78:
            th = move-exception;
            throw th;
        L37:
            if (r102 == false) goto L39;
            String r115 = r100.f455268i;
        L41:
            if (new PolarisFileWrapper(r115).isFile() == true) goto L43;
            r109 = 0;
            goto L43
        L39:
            r115 = r100.f455264g;
        L13:
            if (SignUtils.checkSignature(r100.f455258d, r107.getPath()) == true) goto L25;
            l0.a(r104, "wrong_apk", Boolean.TRUE);
            Context r116 = r100.f455258d;
            String r117 = r116.getPackageManager().getPackageArchiveInfo(r107.getPath(), 64).packageName;     // Catch: Throwable -> L17
        L20:
            if (TextUtils.isEmpty(r117) == true) goto L23;
            l0.a(r104, "apk_package", r117);
        L23:
            if (r100.f455252a == false) goto L25;
            r107.delete();
            Logger.e("UpdateHelper", "sign check error");
            r108 = "sign check error";
            r109 = r101;
        L17:
            th = move-exception;
            Logger.w("UpdateHelper", "failed to get package signatures: " + th);
            r117 = null;
        L25:
            boolean r118 = r101;
            if (r107.renameTo(r106) == false) goto L28;
            r118 = true;
        L28:
            if (r118 == false) goto L30;
            String r119 = DigestUtils.md5Hex(r106);
            SharedPreferences.Editor r120 = r100.f455258d.getSharedPreferences("update_info", 0).edit();
            r120.putString("md5_" + r106.getAbsolutePath(), r119);
            r120.apply();
        L31:
            r105 = r118;
            if (StringUtils.isEmpty(r119) == true) goto L34;
            l0.a(r104, "md5", r119);
            r105 = r118;
            goto L34
        L30:
            r119 = null;
            goto L31
        L9:
            r106 = new PolarisFileWrapper(r100.f455268i);
            r106.delete();
            r107 = new PolarisFileWrapper(r100.f455270j);
            if (r107.isFile() == true) goto L13;
            r107.delete();
            r108 = r100.f455270j + " is not a file.";
            r109 = r101;
        L34:
            r108 = null;
            r109 = r105;
            goto L35
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

        public e(d r100, boolean r101, boolean r102, com.ss.android.update.b.a r103) {
            this.f455314d = r100;
            this.f455311a = r101;
            this.f455312b = r102;
            this.f455313c = r103;
        }
    }

    /* JADX INFO: loaded from: classes40.dex */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f455315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f455316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f455317c;

        public final void a() {
            ThreadMethodProxy.setName(ThreadMethodProxy.currentThread(), "DownloadCountDownLatchThread");
            this.f455315a.await();     // Catch: InterruptedException -> L11
            if (this.f455316b.get() == true) goto L16;
            int r100 = q.f567726a;     // Catch: InterruptedException -> L11
            d r101 = this.f455317c;     // Catch: InterruptedException -> L11
            Context r102 = r101.f455258d;     // Catch: InterruptedException -> L11
            String r103 = r101.B;     // Catch: InterruptedException -> L11
            DownloadInfo r104 = AppDownloader.getInstance().getAppDownloadInfo(r102, r103);     // Catch: InterruptedException -> L11
            if (r104 != null) goto L8;
            return;
        L8:
            if (r104.getStatus() != (-3)) goto L18;
            AppDownloader.startInstall(r102, r104.getId());     // Catch: InterruptedException -> L11
            return;
        L18:
            return;
        L16:
            return;
        L11:
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

        public f(d r100, CountDownLatch r101) {
            this.f455317c = r100;
            this.f455316b = new AtomicBoolean(false);
            this.f455315a = r101;
        }
    }

    public class g extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f455318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f455319b;

        public g(d r100) {
            this.f455319b = r100;
            this.f455318a = false;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFirstSuccess(DownloadInfo r100) {
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L3:
            if (this.f455318a == true) goto L12;
            this.f455318a = true;     // Catch: Exception -> L7
            this.f455319b.q();     // Catch: Exception -> L7
            return;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L3:
            if (this.f455318a == true) goto L12;
            this.f455318a = true;     // Catch: Exception -> L7
            this.f455319b.q();     // Catch: Exception -> L7
            return;
        }
    }

    /* JADX INFO: loaded from: classes40.dex */
    public class h extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public volatile boolean f455320v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ d f455321w;

        public final void l() {
        L31:
            Thread.sleep(1500);     // Catch: Exception -> L29
        L4:
            yhc.a r100 = this.f455321w.K;
            monitor-enter(r100);
        L26:
            th = move-exception;
            throw th;
        L7:
            if (this.f455320v == true) goto L8;
            if (Logger.debug() == false) goto L14;
            Logger.d("UpdateHelper", "mUpdating " + this.f455321w.f455251J);     // Catch: Throwable -> L26
        L14:
            if (this.f455321w.f455251J == false) goto L15;
            d r101 = this.f455321w;     // Catch: Throwable -> L26
            yhc.a r102 = r101.K;     // Catch: Throwable -> L26
            int r103 = r102.f567681a;     // Catch: Throwable -> L26
            int r104 = r102.f567682b;     // Catch: Throwable -> L26
            if (r104 <= 0) goto L22;
            long r105 = (((long) r103) * 100) / ((long) r104);     // Catch: Throwable -> L26
            if (r105 <= 99) goto L23;
            r105 = 99;
        L23:
            Message r106 = r101.f455260e.obtainMessage(5);     // Catch: Throwable -> L26
            r106.arg1 = (int) r105;     // Catch: Throwable -> L26
            this.f455321w.f455260e.sendMessage(r106);     // Catch: Throwable -> L26
            monitor-exit(r100);     // Catch: Throwable -> L26
            goto L31
        L22:
            r105 = 1;
            goto L23
        L15:
            monitor-exit(r100);     // Catch: Throwable -> L26
            return;
        L8:
            monitor-exit(r100);     // Catch: Throwable -> L26
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public h(d r100) {
            this.f455321w = r100;
            super("UpdateHelper$UpdateNotifyThread");
            this.f455320v = false;
        }
    }

    public final Intent A() {
    L11:
        e = move-exception;
        Logger.d("UpdateHelper", e.getMessage(), e);
        return null;
    L4:
        if (TextUtils.isEmpty(this.f455271j0) == false) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(this.f455273k0) == false) goto L9;
        return null;
    L9:
        Intent r100 = new Intent();     // Catch: Exception -> L11
        r100.setPackage(this.f455271j0);     // Catch: Exception -> L11
        r100.setData(UriProtector.parse(this.f455273k0));     // Catch: Exception -> L11
        r100.addFlags(268435456);     // Catch: Exception -> L11
        return r100;
    }

    public final synchronized int C() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.f455272k = true;     // Catch: Throwable -> L9
    L6:
        int r100 = this.f455293u0;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final synchronized int D() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.f455272k = true;     // Catch: Throwable -> L9
    L6:
        int r100 = this.S;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final synchronized int F() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.f455272k = true;     // Catch: Throwable -> L9
    L6:
        int r100 = this.X;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final synchronized String G() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.f455272k = true;     // Catch: Throwable -> L9
    L6:
        String r100 = this.f455292u;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final synchronized String H() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.f455272k = true;     // Catch: Throwable -> L9
    L6:
        String r100 = this.U;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final synchronized PolarisFileWrapper I() {
        monitor-enter(this);
        PolarisFileWrapper r100 = J(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized String K() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.f455272k = true;     // Catch: Throwable -> L9
    L6:
        String r100 = this.f455286r;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final synchronized boolean N() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L6;
        U();     // Catch: Throwable -> L13
        this.f455272k = true;     // Catch: Throwable -> L13
    L6:
        if (this.P != 0) goto L11;
        monitor-exit(this);
        return false;
    L11:
        monitor-exit(this);
        return true;
    }

    public final synchronized boolean O() {
        monitor-enter(this);
        boolean r100 = true;
        if (this.f455272k == true) goto L7;
        U();     // Catch: Throwable -> L16
        this.f455272k = true;     // Catch: Throwable -> L16
    L7:
        if (this.T != 1) goto L10;
        monitor-exit(this);
        return true;
    L10:
        if (this.f455276m < this.f455278n) goto L14;
        r100 = false;
    L14:
        monitor-exit(this);
        return r100;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean P() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.f455272k = true;     // Catch: Throwable -> L9
    L6:
        boolean r100 = this.f455294v;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final synchronized boolean Q() {
        monitor-enter(this);
        boolean r100 = true;
        if (this.f455272k == true) goto L6;
        U();     // Catch: Throwable -> L11
        this.f455272k = true;     // Catch: Throwable -> L11
    L6:
        if (this.f455276m < this.f455280o) goto L9;
        r100 = false;
    L9:
        monitor-exit(this);
        return r100;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean R() {
        monitor-enter(this);
        boolean r100 = true;
        if (this.f455272k == true) goto L8;
        U();     // Catch: Throwable -> L31
        this.f455272k = true;     // Catch: Throwable -> L31
    L8:
        if (this.H == this.f455280o) goto L11;
        monitor-exit(this);
        return false;
    L11:
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L31
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.f455264g);     // Catch: Throwable -> L31
        if (r102.exists() == true) goto L14;
    L20:
        PolarisFileWrapper r103 = new PolarisFileWrapper(this.f455268i);     // Catch: Throwable -> L31
        if (r103.exists() == true) goto L23;
    L28:
        r100 = false;
    L29:
        monitor-exit(this);
        return r100;
    L23:
        if (r103.isFile() == false) goto L28;
        if ((r101 - r103.lastModified()) >= 604800000) goto L28;
    L14:
        if (r102.isFile() == false) goto L20;
        if ((r101 - r102.lastModified()) >= 86400000) goto L20;
        monitor-exit(this);
        return false;
    L31:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean T() {
        monitor-enter(this);
        boolean r100 = this.f455251J;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean V() {
        monitor-enter(this);
        boolean r100 = true;
        if (this.f455272k == true) goto L7;
        U();     // Catch: Throwable -> L14
        this.f455272k = true;     // Catch: Throwable -> L14
    L7:
        if (this.C == false) goto L11;
        if (this.f455283p0.f567755s == false) goto L11;
    L12:
        monitor-exit(this);
        return r100;
    L11:
        r100 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean f() {
        monitor-enter(this);
        boolean r100 = true;
        if (this.f455272k == true) goto L6;
        U();     // Catch: Throwable -> L13
        this.f455272k = true;     // Catch: Throwable -> L13
    L6:
        int r101 = this.f455276m;     // Catch: Throwable -> L13
        if (r101 < this.f455280o) goto L11;
        if (r101 < this.f455278n) goto L11;
        r100 = false;
    L11:
        monitor-exit(this);
        return r100;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void r() {
        monitor-enter(this);
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f455266h);     // Catch: Throwable -> L10
        if (r100.exists() == false) goto L6;
        r100.delete();     // Catch: Throwable -> L10
    L6:
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f455264g);     // Catch: Throwable -> L10
        if (r101.exists() == false) goto L12;
        r101.delete();     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void s() {
        monitor-enter(this);
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f455270j);     // Catch: Throwable -> L10
        if (r100.exists() == false) goto L6;
        r100.delete();     // Catch: Throwable -> L10
    L6:
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f455268i);     // Catch: Throwable -> L10
        if (r101.exists() == false) goto L12;
        r101.delete();     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized String u() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.f455272k = true;     // Catch: Throwable -> L9
    L6:
        String r100 = this.f455290t;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final synchronized boolean v() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L7;
        U();     // Catch: Throwable -> L14
        this.f455272k = true;     // Catch: Throwable -> L14
    L7:
        if (k() == false) goto L11;
        monitor-exit(this);
        return false;
    L11:
        boolean r100 = this.f455296w;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r100;
    }

    public final synchronized String w() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.f455272k = true;     // Catch: Throwable -> L9
    L6:
        String r100 = this.f455300y;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final synchronized String z() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L7;
        U();     // Catch: Throwable -> L14
        this.f455272k = true;     // Catch: Throwable -> L14
    L7:
        if (TextUtils.isEmpty(this.f455284q) == true) goto L11;
        String r100 = this.f455284q;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r100;
    L11:
        String r101 = this.f455282p;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r101;
    }

    public static d x() {
        if (B0 != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (B0 != null) goto L9;
        B0 = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return B0;
    }

    public final void U() {
        AppCommonContext r100 = this.f455289s0;
        if (r100 == null) goto L6;
        this.f455276m = r100.getUpdateVersionCode();
    L6:
        if (this.f455276m >= 1) goto L8;
        this.f455276m = 1;
    L8:
        SharedPreferences r101 = this.f455258d.getSharedPreferences("update_info", 0);
        this.f455278n = r101.getInt("tip_version_code", 0);
        this.f455280o = r101.getInt("real_version_code", 0);
        this.f455282p = r101.getString("tip_version_name", "");
        this.f455284q = r101.getString(EventConstants.ExtraJson.REAL_VERSION_NAME, "");
        this.f455286r = r101.getString("whats_new", "");
        this.f455288s = r101.getLong("last_check_time", 0);
        this.f455292u = r101.getString("title", "");
        this.f455274l = r101.getString("download_url", "");
        this.f455294v = r101.getBoolean(DownloadConstants.KEY_FORCE_UPDATE, false);
        this.f455290t = r101.getString("already_download_tips", "");
        this.C = r101.getBoolean("pre_download", false);
        this.D = r101.getInt("interval_since_notify_update", 2);
        this.E = r101.getLong("pre_download_max_wait_seconds", -1);
        this.F = r101.getInt("latency", 0);
        this.f455293u0 = r101.getInt("official", 0);
        this.G = r101.getString("download_etag", "");
        this.H = r101.getInt("download_version", 0);
        this.I = r101.getInt(TTDelegateActivity.DOWNLOAD_SIZE, -1);
        this.M = r101.getInt("pre_download_size", -1);
        this.f455296w = r101.getBoolean("bind_download_data", false);
        this.f455298x = r101.getBoolean("hint_checked", false);
        this.f455300y = r101.getString("hint_text", "");
        this.f455302z = r101.getString("name", "");
        this.A = r101.getString("package", "");
        this.B = r101.getString("bind_app_download_url", "");
        this.f455275l0 = r101.getString("market_update_intent_tips", "");
        this.f455273k0 = r101.getString("market_update_intent_url", "");
        this.f455271j0 = r101.getString("market_update_package", "");
        this.f455277m0 = r101.getBoolean("market_update_enable", false);
        this.P = r101.getInt("enable_client_strategy", 0);
        this.Q = r101.getString("distribute_id", "");
        this.R = r101.getInt("artifact_id", 0);
        this.S = r101.getInt("package_type", 0);
        this.T = r101.getInt("popup_type", -1);
        this.U = r101.getString("update_button_text", "");
        this.V = r101.getString("md5", "");
        this.X = r101.getInt("release_rule_id", 0);
        this.Y = r101.getInt("strategy_id", 0);
        this.Z = r101.getString("channel", "");
        this.A0 = r101.getLong("last_any_dialog_show_time", 0);
    }

    public final void W() {
        yhc.a r100 = this.K;
        monitor-enter(r100);
        h r101 = this.L;     // Catch: Throwable -> L13
        if (r101 == null) goto L7;
        r101.f455320v = true;     // Catch: Throwable -> L13
    L7:
        com.ss.android.update.b r102 = this.f455281o0;     // Catch: Throwable -> L13
        if (r102 == null) goto L19;
        r102.f455245b = true;     // Catch: Throwable -> L13
        r102.f455248e = null;     // Catch: Throwable -> L13
        Downloader.getInstance(r102.f455244a).cancel(r102.f455246c);     // Catch: Throwable -> L13
    L19:
        this.f455254b.cancel(R.id.ssl_notify_downloading);     // Catch: Exception -> L16 Throwable -> L13
        this.f455254b.cancel(R.id.ssl_notify_download_fail);     // Catch: Exception -> L16 Throwable -> L13
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void a0() {
        SharedPreferences.Editor r100 = this.f455258d.getSharedPreferences("update_info", 0).edit();
        r100.putInt("tip_version_code", this.f455278n);
        r100.putInt("real_version_code", this.f455280o);
        r100.putString("tip_version_name", this.f455282p);
        r100.putString(EventConstants.ExtraJson.REAL_VERSION_NAME, this.f455284q);
        r100.putString("title", this.f455292u);
        r100.putString("download_url", this.f455274l);
        r100.putString("whats_new", this.f455286r);
        r100.putLong("last_check_time", this.f455288s);
        r100.putBoolean(DownloadConstants.KEY_FORCE_UPDATE, this.f455294v);
        r100.putString("already_download_tips", this.f455290t);
        r100.putBoolean("pre_download", this.C);
        r100.putInt("interval_since_notify_update", this.D);
        r100.putLong("pre_download_max_wait_seconds", this.E);
        r100.putInt("latency", this.F);
        r100.putInt("official", this.f455293u0);
        r100.putBoolean("bind_download_data", this.f455296w);
        r100.putBoolean("hint_checked", this.f455298x);
        r100.putString("hint_text", this.f455300y);
        r100.putString("name", this.f455302z);
        r100.putString("package", this.A);
        r100.putString("bind_app_download_url", this.B);
        r100.putString("market_update_package", this.f455271j0);
        r100.putString("market_update_intent_tips", this.f455275l0);
        r100.putString("market_update_intent_url", this.f455273k0);
        r100.putBoolean("market_update_enable", this.f455277m0);
        r100.putInt("enable_client_strategy", this.P);
        r100.putString("distribute_id", this.Q);
        r100.putInt("artifact_id", this.R);
        r100.putInt("package_type", this.S);
        r100.putInt("popup_type", this.T);
        r100.putString("update_button_text", this.U);
        r100.putString("md5", this.V);
        r100.putInt("release_rule_id", this.X);
        r100.putInt("strategy_id", this.Y);
        r100.putString("channel", this.Z);
        SharedPrefsEditorCompat.apply(r100);
    }

    public final void f0() {
        if (TextUtils.isEmpty(this.B) == true) goto L45;
        if (TextUtils.isEmpty(this.f455302z) == true) goto L45;
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L8
        r100.put("label", "detail_ad");     // Catch: Exception -> L8
        r100.put("ext_json", null);     // Catch: Exception -> L8
    L11:
        if (com.ss.android.common.app.permission.d.f407995b != null) goto L13;
        com.ss.android.common.app.permission.d.f407995b = new com.ss.android.common.app.permission.d();
    L13:
        com.ss.android.common.app.permission.d r101 = com.ss.android.common.app.permission.d.f407995b;
        Context r102 = this.f455258d;
        monitor-enter(r101);
        if (r102 != null) goto L51;
        monitor-exit(r101);
        boolean r103 = false;
    L39:
        if (r103 == false) goto L52;
        int r104 = q.f567726a;
        String r105 = this.B;
        String r106 = this.f455302z;
        Context r107 = this.f455258d;
        g r108 = this.f455263f0;
        AppTaskBuilder r109 = new AppTaskBuilder(r107, r105).name(r106).showNotification(true).needWifi(false).mainThreadListener(r108);
        AppDownloader.getInstance().addDownloadTask(r109);
        return;
    L52:
        return;
    L51:
    L41:
        th = move-exception;
        throw th;
    L20:
        if (DeviceUtils.isMiui() == false) goto L32;
        if (com.ss.android.common.app.permission.b.a(r102) == true) goto L24;
    L28:
        r103 = false;
    L29:
        monitor-exit(r101);
        goto L39
    L24:
        if (com.ss.android.common.app.permission.c.a(r102) != 0) goto L26;
    L27:
        r103 = true;
        goto L29
    L26:
        if (((HashSet) r101.f407997a).contains("android.permission.WRITE_EXTERNAL_STORAGE") == true) goto L28;
    L32:
        if (com.ss.android.common.app.permission.c.a(r102) != 0) goto L34;
    L37:
        r103 = true;
    L38:
        monitor-exit(r101);
        goto L39
    L34:
        if (((HashSet) r101.f407997a).contains("android.permission.WRITE_EXTERNAL_STORAGE") == false) goto L37;
        r103 = false;
    L8:
        e = move-exception;
        e.printStackTrace();
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.d("UpdateHelper", "from startBindAppDownload has no Permission");
    L47:
        q();
    }

    public final boolean g() {
        if (this.f455277m0 == true) goto L6;
        return false;
    L6:
        if (this.f455294v == false) goto L9;
        return false;
    L9:
        if (this.C == false) goto L12;
        return false;
    L12:
        if (v() == false) goto L14;
        return false;
    L14:
        Intent r100 = A();
        if (r100 == null) goto L30;
        List<ResolveInfo> r101 = this.f455258d.getPackageManager().queryIntentActivities(r100, 65536);     // Catch: Throwable -> L22
        if (r101 == null) goto L27;
        if (r101.size() <= 0) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    L22:
        th = move-exception;
        Logger.d("UpdateHelper", th.getMessage(), th);
        return false;
    L30:
        return false;
    }

    public final void h() {
        yhc.a r100 = this.K;
        monitor-enter(r100);
        h r101 = this.L;     // Catch: Throwable -> L12
        if (r101 == null) goto L7;
        r101.f455320v = true;     // Catch: Throwable -> L12
    L7:
        com.ss.android.update.b r102 = this.f455281o0;     // Catch: Throwable -> L12
        if (r102 == null) goto L10;
        r102.f455245b = true;     // Catch: Throwable -> L12
        r102.f455248e = null;     // Catch: Throwable -> L12
        Downloader.getInstance(r102.f455244a).cancel(r102.f455246c);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void i() {
        this.f455260e.sendEmptyMessage(11);
    }

    public final void j() {
        this.f455260e.sendEmptyMessage(10);
    }

    public final boolean k() {
        int r100 = q.f567726a;
        Context r101 = this.f455258d;
        String r102 = this.B;
        DownloadInfo r103 = AppDownloader.getInstance().getAppDownloadInfo(r101, r102);
        if (r103 != null) goto L6;
    L4:
        boolean r104 = false;
    L20:
        if (StringUtils.isEmpty(this.A) == true) goto L25;
        if (k.h(this.f455258d, this.A) == false) goto L25;
        return false;
    L25:
        return r104;
    L6:
        if (TextUtils.isEmpty(r103.getSavePath()) == true) goto L4;
        if (TextUtils.isEmpty(r103.getName()) == true) goto L4;
        if (AppDownloadUtils.isApkInstalled(r101, r103.getSavePath(), r103.getName()) == true) goto L4;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r103.getSavePath(), r103.getName());
        if (r103.getStatus() != (-3)) goto L4;
        if (r105.exists() == false) goto L4;
        r104 = true;
        goto L20
    }

    public final boolean l() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f455268i);
        if (r100.isFile() == true) goto L5;
    L6:
        r100 = new PolarisFileWrapper(this.f455264g);
        if (r100.isFile() == true) goto L9;
    L25:
        com.ss.android.update.c.a(6, "downloaded file not exist", null);
        Logger.w("UpdateHelper", "checkBgDownloadApkValid: downloaded file not exist");
        return false;
    L9:
        if (r100.exists() == false) goto L25;
    L10:
        String r101 = DigestUtils.md5Hex(r100);
        if (TextUtils.isEmpty(r101) == false) goto L13;
    L23:
        com.ss.android.update.c.a(6, "md5 not match", null);
        Logger.w("UpdateHelper", "checkBgDownloadApkValid: md5 not match");
        return false;
    L13:
        if (TextUtils.isEmpty(this.V) == true) goto L23;
        if (r101.equalsIgnoreCase(this.V) == false) goto L23;
        if (SignUtils.checkSignature(this.f455258d, r100.getPath()) == true) goto L21;
        com.ss.android.update.c.a(6, "signature not match", null);
        Logger.w("UpdateHelper", "checkBgDownloadApkValid: signature not match");
        return false;
    L21:
        return true;
    L5:
        if (r100.exists() == true) goto L10;
        goto L6
    }

    public final void q() {
        f r100 = this.f455261e0;
        if (r100 == null) goto L11;
        CountDownLatch r101 = r100.f455315a;
        if (r101 == null) goto L13;
        r101.countDown();
        if (Logger.debug() == false) goto L12;
        Logger.d("UpdateHelper", "countDown current count = " + r100.f455315a.getCount());
        return;
    L12:
        return;
    L13:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r3v17, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v18, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x022d -> B:69:0x0244). Please report as a decompilation issue!!! */
    public d() {
        this.f455252a = true;
        yhc.a r100 = null;
        r100 = null;
        yhc.a r101 = null;
        r100 = null;
        this.f455258d = null;
        this.f455272k = false;
        ?? r102 = "";
        this.f455274l = "";
        this.f455276m = 0;
        this.f455278n = 0;
        this.f455280o = 0;
        this.f455282p = "";
        this.f455284q = "";
        this.f455286r = "";
        this.f455288s = 0;
        this.f455290t = "";
        this.f455292u = "";
        this.f455294v = false;
        this.f455296w = false;
        this.f455298x = false;
        this.f455300y = "";
        this.f455302z = "";
        this.A = "";
        this.B = "";
        this.C = false;
        this.D = 2;
        this.E = -1;
        this.F = 0;
        this.G = "";
        this.H = 0;
        this.I = 0;
        this.f455251J = false;
        this.L = null;
        this.M = 0;
        this.N = false;
        this.P = 0;
        this.Q = "";
        this.R = 0;
        this.S = 0;
        this.T = -1;
        this.U = "";
        this.V = "";
        this.W = false;
        this.X = 0;
        this.Y = 0;
        this.Z = "";
        this.f455253a0 = 0;
        this.f455255b0 = 0;
        this.f455257c0 = 0;
        this.f455259d0 = "";
        this.f455261e0 = null;
        this.f455263f0 = new g(this);
        this.f455265g0 = new ArrayList();
        this.f455271j0 = "";
        this.f455273k0 = "";
        this.f455275l0 = "";
        this.f455277m0 = false;
        this.f455287r0 = 2;
        int r103 = 3;
        this.f455295v0 = null;
        this.f455297w0 = null;
        this.f455299x0 = null;
        this.f455301y0 = false;
        this.f455303z0 = "";
        this.A0 = 0;
        IUpdateConfig r104 = f0.f567692a;
        this.f455279n0 = r104;
        AppCommonContext r105 = f0.f567694c;
        this.f455289s0 = r105;
        if (r104 == null) goto L5;
        v r106 = r104.getUpdateConfig();
        this.f455283p0 = r106;
        r106.getClass();
    L5:
        this.f455283p0.getClass();
        this.f455285q0 = PThreadExecutorsUtils.newFixedThreadPool(2, new DefaultThreadFactory("/UpdateHelper"));
        if (r105 == null) goto L8;
        this.f455258d = r105.getContext().getApplicationContext();
    L12:
        SharedPreferences r107 = this.f455258d.getSharedPreferences("update_info", 0);
        this.f455253a0 = r107.getInt("persistent_release_rule_id", 0);
        this.f455255b0 = r107.getInt("persistent_strategy_id", 0);
        this.f455259d0 = r107.getString("persistent_channel", "");
        this.f455257c0 = r107.getInt("persistent_tip_version_code", 0);
        Context r108 = this.f455258d;
        this.f455281o0 = new com.ss.android.update.b(r108);
        NotificationManager r109 = (NotificationManager) r108.getSystemService("notification");
        this.f455254b = r109;
        if (Build.VERSION.SDK_INT < 26) goto L25;
        v r110 = this.f455283p0;
        if (r110 != null) goto L17;
    L19:
        if (r110 != null) goto L21;
    L23:
        String r111 = "update_channel_name";
    L24:
        NotificationChannel r112 = new NotificationChannel("update_channel_01", r111, r103);
        r112.enableVibration(false);
        r112.setSound(null, null);
        r109.createNotificationChannel(r112);
        goto L25
    L21:
        if (TextUtils.isEmpty(null) == true) goto L23;
        this.f455283p0.getClass();
        r111 = null;
        goto L24
    L17:
        if (r110.f567754r == false) goto L19;
        r103 = 0;
    L25:
        this.f455260e = new a(this, Looper.getMainLooper());
        ?? r113 = this.f455258d;
        v r114 = this.f455283p0;
        ?? r115 = r102;
        ?? r116 = r113;
        if (r114 == null) goto L83;
        r115 = r102;
        r116 = r113;
        if (TextUtils.isEmpty(r114.f567753q) == true) goto L83;
        PolarisFileWrapper r117 = new PolarisFileWrapper(r114.f567753q);     // Catch: Exception -> L38
        if (r117.exists() == true) goto L32;
    L34:
        r115 = r102;
        r116 = r113;
        if (r117.mkdirs() == false) goto L83;
        String r118 = r117.getAbsolutePath();     // Catch: Exception -> L38
    L69:
        this.f455262f = r118;
        ?? r119 = new StringBuilder();
        r119.append(r118);
        r113 = File.separator;
        r119.append(r113);
        r119.append("update.apk");
        this.f455264g = r119.toString();
        this.f455266h = r118 + r113 + "update.apk.part";
        this.f455268i = r118 + r113 + "predownload.apk";
        r102 = new StringBuilder();
        r102.append(r118);
        r102.append(r113);
        r102.append("predownload.apk.part");
        this.f455270j = r102.toString();
        yhc.a r120 = new yhc.a();
        this.K = r120;
        r120.f567683c = 0;
        r120.f567681a = 0;
        r120.f567682b = 0;
        r101 = new yhc.a();
        this.O = r101;
        r101.f567683c = 0;
        r101.f567681a = 0;
        r101.f567682b = 0;
        this.f455254b.cancel(R.id.ssl_notify_downloading);     // Catch: Exception -> L76
        return;
    L86:
        return;
    L32:
        if (r117.isDirectory() == false) goto L34;
        r118 = r117.getAbsolutePath();     // Catch: Exception -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
        r100 = r101;
        r115 = r102;
        r116 = r113;
    L83:
        r118 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + r116.getPackageName() + "/files";     // Catch: Exception -> L42
    L64:
        if (r118.isEmpty() == true) goto L69;
        PolarisFileWrapper r121 = new PolarisFileWrapper(r118, "update");
        if (r121.exists() == true) goto L68;
        r121.mkdirs();
    L68:
        r118 = r121.getPath();
        goto L69
    L85:
        r118 = r121.getPath();
    L42:
        e = move-exception;
        e.printStackTrace();
        ?? r122 = Environment.getExternalStorageState();     // Catch: Throwable -> L46
    L47:
        ?? r123 = r100;
        if ("mounted".equals(r122) == false) goto L55;
        PolarisFileWrapper r124 = new PolarisFileWrapper(new PolarisFileWrapper(new PolarisFileWrapper(new PolarisFileWrapper(Environment.getExternalStorageDirectory(), "Android"), "data"), r116.getPackageName()), "cache");
        if (r124.exists() == true) goto L54;
        r123 = r100;
        if (r124.mkdirs() == false) goto L55;
    L54:
        r123 = r124;
    L55:
        if (r123 != 0) goto L57;
        r123 = r116.getCacheDir();
    L57:
        if (r123 != 0) goto L60;
        r123 = new PolarisFileWrapper("/data/data/" + r116.getPackageName() + "/cache/");
    L60:
        if (r123.exists() == true) goto L62;
        r123.mkdirs();
    L62:
        r118 = r123.getPath();
    L46:
        r122 = r115;
        goto L47
    L8:
        AppCommonContext r125 = this.f455283p0.f567738b;
        if (r125 == null) goto L75;
        if (r125 == null) goto L73;
        this.f455289s0 = r125;
        this.f455258d = r125.getContext().getApplicationContext();
        goto L12
    L73:
        throw new IllegalArgumentException("appContext can not null");
    L75:
        throw new IllegalArgumentException("appContext can not null");
    }

    public static String X(String r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() == 0) goto L14;
        String[] r101 = r100.split("\\\\n");
        StringBuilder r102 = new StringBuilder();
        int r103 = r101.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L10;
        r102.append(r101[r104].trim());
        r102.append("\n");
        r104 = r104 + 1;
        goto L7
    L10:
        return r102.toString();
    L14:
        return "";
    }

    public final Notification B(int r110) {
        AppCommonContext r100 = this.f455289s0;
        if (r100 == null) goto L5;
        String r101 = r100.getStringAppName();
    L6:
        String r102 = String.format(this.f455258d.getString(R.string.ssl_notify_download_fmt), new Object[]{r101, z()});
        String r103 = "" + r110 + GXTemplateKey.GAIAX_PE;
        Intent r104 = new Intent();
        PendingIntent r105 = null;
        if (TextUtils.isEmpty(null) == false) goto L9;
        r104.setClassName(this.f455258d, UpdateProgressActivity.class.getName());
    L13:
        r104.addFlags(536870912);
        if (Build.VERSION.SDK_INT < 23) goto L16;
        int r106 = 67108864;
    L17:
        PendingIntent r107 = PendingIntent.getActivity(this.f455258d, 0, r104, r106);
        v r108 = this.f455283p0;
        if (r108 != null) goto L20;
    L22:
        r105 = r107;
    L24:
        if (r110 == 0) goto L30;
        NotificationCompat.Builder r109 = this.f455256c;
        if (r109 == null) goto L30;
        r109.setContentTitle(r102).setContentInfo(r103).setProgress(100, r110, false);
        return r109.build();
    L30:
        NotificationCompat.Builder r111 = new NotificationCompat.Builder(this.f455258d);
        this.f455256c = r111;
        r111.setChannelId("update_channel_01");
        NotificationCompat.Builder r112 = this.f455256c;
        r112.setSmallIcon(android.R.drawable.stat_sys_download).setTicker(r101).setWhen(System.currentTimeMillis()).setOngoing(true).setContentIntent(r105);
        r112.setContentTitle(r102).setContentInfo(r103).setProgress(100, r110, false);
        return r112.build();
    L20:
        if (r108.f567743g == false) goto L22;
    L16:
        r106 = 0;
        goto L17
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("UpdateHelper", "iUpdateActivity.getClass().getName() null");
    L11:
        r104.setClassName(this.f455258d, null);
        goto L13
    L5:
        r101 = "";
        goto L6
    }

    public final void E(yhc.a r100) {
        yhc.a r101 = this.K;
        monitor-enter(r101);
        yhc.a r102 = this.K;     // Catch: Throwable -> L7
        r100.f567683c = r102.f567683c;     // Catch: Throwable -> L7
        r100.f567681a = r102.f567681a;     // Catch: Throwable -> L7
        r100.f567682b = r102.f567682b;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized PolarisFileWrapper J(boolean r110) {
        monitor-enter(this);
        d0(r110);     // Catch: Throwable -> L44
        if (this.f455272k == true) goto L47;
        U();     // Catch: Throwable -> L44
        this.f455272k = true;     // Catch: Throwable -> L44
    L47:
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L40
        SharedPreferences r101 = this.f455258d.getSharedPreferences("update_info", 0);     // Catch: Throwable -> L40
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.f455264g);     // Catch: Throwable -> L40
        if (r102.exists() == false) goto L22;
        String r103 = r101.getString("md5_" + r102.getAbsolutePath(), null);     // Catch: Throwable -> L40
        Logger.i("UpdateHelper", "realVersion:" + this.f455284q + ",downloadVersion:" + this.H + ",md5" + this.V + ",fileMd5:" + r103);     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r103) == false) goto L13;
    L21:
        r102.delete();     // Catch: Throwable -> L40
        goto L22
    L13:
        if (TextUtils.isEmpty(this.V) == true) goto L21;
        if (r103.equals(this.V) == false) goto L21;
        if (this.H != this.f455280o) goto L21;
        if ((r100 - r102.lastModified()) >= 86400000) goto L21;
    L23:
        PolarisFileWrapper r104 = new PolarisFileWrapper(this.f455268i);     // Catch: Throwable -> L40
        if (r104.exists() == false) goto L38;
        String r105 = r101.getString("md5_" + r104.getAbsolutePath(), null);     // Catch: Throwable -> L40
        Logger.i("UpdateHelper", "realVersion:" + this.f455284q + ",downloadVersion:" + this.H + ",md5" + this.V + ",preFileMd5:" + r105);     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r105) == false) goto L28;
    L37:
        r104.delete();     // Catch: Throwable -> L40
    L28:
        if (TextUtils.isEmpty(this.V) == true) goto L37;
        if (r105.equals(this.V) == false) goto L37;
        if (this.H != this.f455280o) goto L37;
        if ((r100 - r104.lastModified()) >= 604800000) goto L37;
        if (r102 != null) goto L38;
        r102 = r104;
    L38:
        monitor-exit(this);
        return r102;
    L22:
        r102 = null;
    L40:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L44
        return null;
    L44:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final boolean M(boolean r410) {
        if (this.f455283p0.f567751o == true) goto L5;
        return false;
    L5:
        JSONObject r100 = new JSONObject();
        p r101 = p.b.f567725a;     // Catch: Throwable -> L27
        if (r101.f() == true) goto L13;
        com.ss.android.update.c.d(this.f455274l, this.f455280o, false, "ping_fail", "ping_fail");     // Catch: Throwable -> L27
        this.f455301y0 = false;     // Catch: Throwable -> L27
        if (this.f455258d == null) goto L12;
        yhc.b.a("app_update_check", r100);
    L12:
        return false;
    L13:
        StringBuilder r102 = new StringBuilder("https://ichannel.snssdk.com/check_version/v7/");     // Catch: Throwable -> L27
        Context r103 = this.f455258d;     // Catch: Throwable -> L27
        if (r103 != null) goto L16;
    L18:
        Context r104 = this.f455258d;     // Catch: Throwable -> L27
        if (r104 == null) goto L29;
        v r110 = this.f455283p0;     // Catch: Throwable -> L27
        if (r110 == null) goto L29;
        if (r110.f567749m == false) goto L29;
        if (TextUtils.isEmpty(r104.getPackageName()) == true) goto L29;
        r102.append("&package_name=");     // Catch: Throwable -> L27
        r102.append(this.f455258d.getPackageName());     // Catch: Throwable -> L27
    L29:
        v r105 = this.f455283p0;     // Catch: Throwable -> L27
        String r106 = k0.b();     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r106) == true) goto L32;
        r102.append("&cpu_abi=");     // Catch: Throwable -> L27
        r102.append(r106);     // Catch: Throwable -> L27
    L32:
        r102.append("&app_extra=");     // Catch: Throwable -> L27
        r102.append(this.f455303z0);     // Catch: Throwable -> L27
        if (r410 == false) goto L35;
        String r107 = "1";
    L36:
        r102.append("&call_type=");     // Catch: Throwable -> L27
        r102.append(r107);     // Catch: Throwable -> L27
        v r108 = this.f455283p0;     // Catch: Throwable -> L27
        if (r108 != null) goto L39;
    L41:
        String r109 = "0";
    L42:
        r102.append("&package_type=");     // Catch: Throwable -> L27
        r102.append(r109);     // Catch: Throwable -> L27
        com.ss.android.update.c.q(Integer.parseInt(r109));     // Catch: Throwable -> L27
        if (r101.e() == false) goto L45;
        String r111 = "1";
    L46:
        r102.append("&inhouse_network=");     // Catch: Throwable -> L27
        r102.append(r111);     // Catch: Throwable -> L27
        r101.getClass();     // Catch: Throwable -> L27
        String r112 = p.c();     // Catch: Throwable -> L27
        r102.append("&inhouse_network_attr=");     // Catch: Throwable -> L27
        r102.append(r112);     // Catch: Throwable -> L27
        r101.getClass();     // Catch: Throwable -> L27
        r102.append("&enable_intranet_guide=0&is_local_installed=");     // Catch: Throwable -> L27
        com.ss.android.update.c.n(Integer.parseInt("0"));     // Catch: Throwable -> L27
        r101.getClass();     // Catch: Throwable -> L27
        if (p.d() == false) goto L49;
        String r113 = "1";
    L50:
        r102.append(r113);     // Catch: Throwable -> L27
        com.ss.android.update.c.o(Integer.parseInt(r113));     // Catch: Throwable -> L27
        if (r101.f567722e == false) goto L53;
        String r114 = "1";
    L54:
        r102.append("&enable_normal_popup=");     // Catch: Throwable -> L27
        r102.append(r114);     // Catch: Throwable -> L27
        com.ss.android.update.c.p(Integer.parseInt(r114));     // Catch: Throwable -> L27
        String r115 = "";
        AppCommonContext r116 = this.f455289s0;     // Catch: Throwable -> L27
        if (r116 == null) goto L57;
        this.f455276m = r116.getUpdateVersionCode();     // Catch: Throwable -> L27
        r115 = this.f455289s0.getChannel();     // Catch: Throwable -> L27
    L57:
        SharedPreferences r117 = this.f455258d.getSharedPreferences("update_info", 0);     // Catch: Throwable -> L27
        int r118 = r117.getInt("tip_version_code", 0);     // Catch: Throwable -> L27
        this.f455278n = r118;     // Catch: Throwable -> L27
        if (r118 != this.f455276m) goto L61;
        this.f455253a0 = r117.getInt("release_rule_id", 0);     // Catch: Throwable -> L27
        this.f455255b0 = r117.getInt("strategy_id", 0);     // Catch: Throwable -> L27
        this.f455257c0 = this.f455278n;     // Catch: Throwable -> L27
        this.f455259d0 = r117.getString("channel", "");     // Catch: Throwable -> L27
        r117.edit().putInt("persistent_release_rule_id", this.f455253a0).putInt("persistent_strategy_id", this.f455255b0).putInt("persistent_tip_version_code", this.f455257c0).putString("persistent_channel", this.f455259d0).apply();     // Catch: Throwable -> L27
    L61:
        if (this.f455257c0 == this.f455276m) goto L63;
    L66:
        r102.append("&release_rule_id=0&strategy_id=0");     // Catch: Throwable -> L27
    L67:
        v r119 = this.f455283p0;     // Catch: Throwable -> L27
        if (r119 != null) goto L70;
    L72:
        String r120 = r102.toString();     // Catch: Throwable -> L27
        l0.a(r100, "request", r120);     // Catch: Throwable -> L27
        Pair<String, String> r121 = n.a();     // Catch: Throwable -> L27
        if (r121 == null) goto L75;
        ArrayList r122 = new ArrayList();     // Catch: Throwable -> L27
        r122.add(new eua.a((String) r121.first, (String) r121.second));     // Catch: Throwable -> L27
    L76:
        String r123 = ita.i.a(8192, r120, r122);     // Catch: Throwable -> L27
        if (StringUtils.isEmpty(r123) == false) goto L83;
        com.ss.android.update.c.b(0);     // Catch: Throwable -> L27
        com.ss.android.update.c.d(this.f455274l, this.f455280o, false, "check_fail", r100.toString());     // Catch: Throwable -> L27
        this.f455301y0 = false;     // Catch: Throwable -> L27
        if (this.f455258d == null) goto L82;
        yhc.b.a("app_update_check", r100);
    L82:
        return false;
    L83:
        l0.a(r100, "respone", r123);     // Catch: Throwable -> L27
        JSONObject r124 = new JSONObject(r123);     // Catch: Throwable -> L27
        if ("success".equals(r124.getString("message")) == true) goto L91;
        com.ss.android.update.c.b(1);     // Catch: Throwable -> L27
        com.ss.android.update.c.d(this.f455274l, this.f455280o, false, "check_fail", r100.toString());     // Catch: Throwable -> L27
        this.f455301y0 = false;     // Catch: Throwable -> L27
        if (this.f455258d == null) goto L89;
        yhc.b.a("app_update_check", r100);
    L89:
        return false;
    L91:
        com.ss.android.update.c.b(-1);     // Catch: Throwable -> L27
        JSONObject r125 = r124.getJSONObject("data");     // Catch: Throwable -> L27
        int r126 = r125.optInt("tip_version_code", -1);     // Catch: Throwable -> L27
        String r127 = r125.optString("tip_version_name");     // Catch: Throwable -> L27
        String r128 = r125.optString(EventConstants.ExtraJson.REAL_VERSION_NAME);     // Catch: Throwable -> L27
        int r129 = r125.optInt("real_version_code", -1);     // Catch: Throwable -> L27
        String r130 = r125.optString("download_url");     // Catch: Throwable -> L27
        String r131 = r125.optString("whats_new", "");     // Catch: Throwable -> L27
        String r132 = r125.optString("title", "");     // Catch: Throwable -> L27
        if (r125.optInt(DownloadConstants.KEY_FORCE_UPDATE, 0) != 1) goto L94;
        boolean r133 = true;
    L95:
        String r134 = r125.optString("already_download_tips", "");     // Catch: Throwable -> L27
        if (r125.optInt("pre_download", 0) != 1) goto L98;
        boolean r135 = true;
    L99:
        int r136 = r125.optInt("interval_since_notify_update", 2);     // Catch: Throwable -> L27
        boolean r137 = r135;
        long r138 = r125.optLong("pre_download_max_wait_seconds", -1);     // Catch: Throwable -> L27
        int r139 = r125.optInt("latency", 0);     // Catch: Throwable -> L27
        int r140 = r125.optInt("official", 0);     // Catch: Throwable -> L27
        int r141 = r125.optInt("enable_client_strategy", 0);     // Catch: Throwable -> L27
        String r142 = r125.optString("distribute_id", "");     // Catch: Throwable -> L27
        int r143 = r125.optInt("artifact_id", 0);     // Catch: Throwable -> L27
        int r144 = r125.optInt("package_type", 0);     // Catch: Throwable -> L27
        int r145 = r125.optInt("popup_type", -1);     // Catch: Throwable -> L27
        String r146 = r125.optString("update_button_text", "");     // Catch: Throwable -> L27
        String r147 = r125.optString("md5", "");     // Catch: Throwable -> L27
        int r148 = r125.optInt("release_rule_id", 0);     // Catch: Throwable -> L27
        int r149 = r125.optInt("strategy_id", 0);     // Catch: Throwable -> L27
        String r150 = r125.optString("channel", "");     // Catch: Throwable -> L27
        String r310 = "";
        String r311 = "";
        String r312 = "";
        JSONObject r151 = r125.optJSONObject("market_update");     // Catch: Throwable -> L118
        String r313 = r150;
        int r314 = r149;
        if (r125.optInt("market_update_enable", 0) <= 0) goto L107;
        boolean r152 = true;
    L108:
        if (r151 != null) goto L198;
    L113:
        String r153 = r310;
        String r315 = r312;
        boolean r316 = r152;
        String r154 = r311;
    L122:
        String r317 = "";
        String r318 = "";
        String r319 = "";
        String r320 = "";
        boolean r321 = r125.has("bind_download_data");     // Catch: Throwable -> L27 Exception -> L147
        JSONObject r155 = r125.optJSONObject("bind_download_data");     // Catch: Throwable -> L27 Exception -> L145
        if (r155 != null) goto L127;
        String r411 = r154;
        String r156 = "";
        String r157 = "";
        String r322 = "";
        String r412 = "";
        boolean r158 = true;
    L144:
        String r323 = r153;
        boolean r159 = r321;
        if (r126 > 0) goto L154;
    L160:
        monitor-enter(this);     // Catch: Throwable -> L27
    L171:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L162:
        if (this.f455272k == true) goto L164;
        U();     // Catch: Throwable -> L171
        this.f455272k = true;     // Catch: Throwable -> L171
    L164:
        this.f455278n = r126;     // Catch: Throwable -> L171
        this.f455280o = r129;     // Catch: Throwable -> L171
        this.f455282p = r127;     // Catch: Throwable -> L171
        this.f455284q = r128;     // Catch: Throwable -> L171
        this.f455274l = r130;     // Catch: Throwable -> L171
        this.f455286r = r131;     // Catch: Throwable -> L171
        this.f455288s = System.currentTimeMillis();     // Catch: Throwable -> L171
        this.f455292u = r132;     // Catch: Throwable -> L171
        this.f455294v = r133;     // Catch: Throwable -> L171
        this.f455290t = r134;     // Catch: Throwable -> L171
        this.C = r137;     // Catch: Throwable -> L171
        this.D = r136;     // Catch: Throwable -> L171
        this.E = r138;     // Catch: Throwable -> L171
        this.F = r139;     // Catch: Throwable -> L171
        this.f455293u0 = r140;     // Catch: Throwable -> L171
        this.f455296w = r159;     // Catch: Throwable -> L171
        this.f455298x = r158;     // Catch: Throwable -> L171
        this.f455300y = r156;     // Catch: Throwable -> L171
        this.f455302z = r157;     // Catch: Throwable -> L171
        this.A = r322;     // Catch: Throwable -> L171
        this.B = r412;     // Catch: Throwable -> L171
        this.f455271j0 = r323;     // Catch: Throwable -> L171
        this.f455273k0 = r411;     // Catch: Throwable -> L171
        this.f455275l0 = r315;     // Catch: Throwable -> L171
        this.f455277m0 = r316;     // Catch: Throwable -> L171
        this.P = r141;     // Catch: Throwable -> L171
        this.Q = r142;     // Catch: Throwable -> L171
        this.R = r143;     // Catch: Throwable -> L171
        this.S = r144;     // Catch: Throwable -> L171
        this.T = r145;     // Catch: Throwable -> L171
        this.U = r146;     // Catch: Throwable -> L171
        this.V = r147;     // Catch: Throwable -> L171
        this.X = r148;     // Catch: Throwable -> L171
        this.Y = r314;     // Catch: Throwable -> L171
        this.Z = r313;     // Catch: Throwable -> L171
        a0();     // Catch: Throwable -> L171
        monitor-exit(this);     // Catch: Throwable -> L171
        Logger.i("UpdateHelper", "update info: latest version " + this.f455278n + " " + this.f455280o + ", now " + this.f455276m);     // Catch: Throwable -> L27
        boolean r160 = S(r410);     // Catch: Throwable -> L27
        if (this.f455258d == null) goto L170;
        yhc.b.a("app_update_check", r100);
    L170:
        return r160;
    L154:
        if (URLUtil.isValidUrl(r130) == true) goto L160;
        l0.a(r100, "errorMsg", "url is not valid:" + r130);     // Catch: Throwable -> L27
        com.ss.android.update.c.d(this.f455274l, this.f455280o, false, "check_fail", r100.toString());     // Catch: Throwable -> L27
        this.f455301y0 = false;     // Catch: Throwable -> L27
        if (this.f455258d == null) goto L159;
        yhc.b.a("app_update_check", r100);
    L159:
        return false;
    L127:
        r411 = r154;
        if (r155.optInt("hint_checked", 1) != 1) goto L131;
        boolean r161 = true;
    L133:
        boolean r413 = r161;
        r317 = r155.optString("hint_text", "");     // Catch: Throwable -> L27 Exception -> L136
        r318 = r155.optString("name", "");     // Catch: Throwable -> L27 Exception -> L136
        r319 = r155.optString("package", "");     // Catch: Throwable -> L27 Exception -> L136
        r320 = r155.optString("bind_app_download_url");     // Catch: Throwable -> L27 Exception -> L136
    L151:
        r156 = r317;
        r157 = r318;
        r322 = r319;
        r412 = r320;
        r158 = r413;
    L136:
        e = e;
        boolean r162 = r413;
    L150:
        r413 = r162;
        Logger.d("UpdateHelper", e.getMessage(), e);     // Catch: Throwable -> L27
        goto L151
    L131:
        r161 = false;
    L141:
        e = e;
    L149:
        r162 = true;
    L145:
        e = e;
        r411 = r154;
    L147:
        e = e;
        r411 = r154;
        r321 = false;
        goto L149
    L198:
        r310 = r151.optString("market_update_package");     // Catch: Throwable -> L111
        r311 = r151.optString("market_update_intent_url");     // Catch: Throwable -> L111
        r312 = r151.optString("market_update_intent_tips");     // Catch: Throwable -> L111
    L111:
        th = th;
    L121:
        boolean r324 = r152;
        Logger.d("UpdateHelper", th.getMessage(), th);     // Catch: Throwable -> L27
        r153 = r310;
        r154 = r311;
        r315 = "";
        r316 = r324;
        goto L122
    L107:
        r152 = false;
    L114:
        th = th;
    L120:
        r152 = false;
    L118:
        th = th;
        r313 = r150;
        r314 = r149;
        goto L120
    L98:
        r135 = false;
        goto L99
    L94:
        r133 = false;
        goto L95
    L75:
        r122 = null;
        goto L76
    L70:
        if (StringUtils.isEmpty(r119.f567750n) == true) goto L72;
        r102.append(this.f455283p0.f567750n);     // Catch: Throwable -> L27
        goto L72
    L63:
        if (r115.equals(this.f455259d0) == false) goto L66;
        r102.append("&release_rule_id=");     // Catch: Throwable -> L27
        r102.append(this.f455253a0);     // Catch: Throwable -> L27
        r102.append("&strategy_id=");     // Catch: Throwable -> L27
        r102.append(this.f455255b0);     // Catch: Throwable -> L27
        goto L67
    L53:
        r114 = "0";
        goto L54
    L49:
        r113 = "0";
        goto L50
    L45:
        r111 = "0";
        goto L46
    L39:
        if (r108.f567744h == false) goto L41;
        r109 = "1";
        goto L42
    L35:
        r107 = "0";
        goto L36
    L16:
        if (r103.getApplicationInfo() == null) goto L18;
        r102.append("?target_sdk_version=");     // Catch: Throwable -> L27
        r102.append(String.valueOf(this.f455258d.getApplicationInfo().targetSdkVersion));     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Logger.w("UpdateHelper", "check update error: " + th);     // Catch: Throwable -> L184
        int r163 = q.f567726a;     // Catch: Throwable -> L184
        int r164 = q.a(this.f455258d, th);     // Catch: Throwable -> L184
        if (18 == r164) goto L177;
        l0.a(r100, "errorCode", Integer.valueOf(r164));     // Catch: Throwable -> L184
    L178:
        com.ss.android.update.c.d(r100.optString("request"), this.f455280o, false, "check_fail", r100.toString());     // Catch: Throwable -> L184
        if (this.f455258d == null) goto L182;
        yhc.b.a("app_update_check", r100);
    L182:
        this.f455301y0 = false;
        return false;
    L177:
        l0.a(r100, "errorMsg", th.getMessage());     // Catch: Throwable -> L184
    L184:
        th = move-exception;
        if (this.f455258d == null) goto L188;
        yhc.b.a("app_update_check", r100);
    L188:
        throw th;
    }

    public final boolean S(boolean r110) {
        int r100 = this.T;
        if (r100 == 2) goto L6;
        if (r100 == 0) goto L6;
    L15:
        if (this.T == 1) goto L17;
    L22:
        int r101 = this.T;
        if (r101 == 0) goto L73;
        if (r101 == 1) goto L73;
        if (r101 != 2) goto L32;
        if (p.b.f567725a.f567722e == true) goto L32;
        com.ss.android.update.c.k(UpdateService.REASON_NO_NORMAL_GUIDE);
        this.f455301y0 = false;
        return false;
    L32:
        if (StringUtils.isEmpty(this.f455274l) == false) goto L36;
        com.ss.android.update.c.k("reason_no_updating_url_from_server");
        this.f455301y0 = false;
        return false;
    L36:
        if (this.f455283p0.f567744h == false) goto L46;
        if (this.S == 1) goto L42;
        com.ss.android.update.c.k("reason_local_package_should_not_upgrade_to_other_package");
        this.f455301y0 = false;
        return false;
    L42:
        if (p.b.f567725a.e() == true) goto L46;
        com.ss.android.update.c.k("reason_local_package_should_not_work_out_of_house");
        this.f455301y0 = false;
        return false;
    L46:
        if (this.f455272k == true) goto L57;
        monitor-enter(this);
    L53:
        th = move-exception;
        throw th;
    L49:
        if (this.f455272k == true) goto L51;
        U();     // Catch: Throwable -> L53
        this.f455272k = true;     // Catch: Throwable -> L53
    L51:
        monitor-exit(this);     // Catch: Throwable -> L53
    L57:
        if (this.f455294v == true) goto L63;
        if (r110 == false) goto L63;
        long r102 = System.currentTimeMillis();
        long r103 = this.f455283p0.f567748l;
        if ((r102 - this.A0) >= r103) goto L63;
        boolean r111 = true;
    L64:
        if (r111 == false) goto L68;
        com.ss.android.update.c.k(UpdateService.REASON_LOCAL_LIMIT_BLOCK_DIALOG);
        this.f455301y0 = false;
        return false;
    L68:
        if (O() == true) goto L71;
        com.ss.android.update.c.k(UpdateService.REASON_CHECK_VERSION_CODE_FAIL);
        this.f455301y0 = false;
        return false;
    L71:
        this.f455301y0 = true;
        return true;
    L63:
        r111 = false;
    L73:
        p.b.f567725a.getClass();
        com.ss.android.update.c.k(UpdateService.REASON_NO_LOCAL_GUIDE);
        this.f455301y0 = false;
        return false;
    L17:
        if (TextUtils.isEmpty(this.f455292u) == false) goto L19;
    L20:
        com.ss.android.update.c.k(UpdateService.REASON_LACK_INFORMATION_NORMAL);
        this.f455301y0 = false;
        return false;
    L19:
        if (TextUtils.isEmpty(this.f455286r) == false) goto L22;
    L6:
        if (TextUtils.isEmpty(this.f455292u) == false) goto L8;
    L75:
        com.ss.android.update.c.k(UpdateService.REASON_LACK_INFORMATION_NORMAL);
        this.f455301y0 = false;
        return false;
    L8:
        if (this.f455280o == (-1)) goto L75;
        if (this.f455278n == (-1)) goto L75;
        if (TextUtils.isEmpty(this.f455286r) == false) goto L15;
        goto L75
    }

    public final void Y(OnUpdateStatusChangedListener r100) {
        monitor-enter(this);
        List<OnUpdateStatusChangedListener> r101 = this.f455265g0;     // Catch: Throwable -> L12
        monitor-enter(r101);     // Catch: Throwable -> L12
        ((ArrayList) this.f455265g0).remove(r100);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // yhc.i
    public final void b(boolean r100) {
        List<OnUpdateStatusChangedListener> r101 = this.f455265g0;
        monitor-enter(r101);
        Iterator r102 = ((ArrayList) this.f455265g0).iterator();     // Catch: Throwable -> L13
    L6:
        if (r102.hasNext() == false) goto L10;
        OnUpdateStatusChangedListener r103 = (OnUpdateStatusChangedListener) r102.next();     // Catch: Throwable -> L13
        if (r103 == null) goto L6;
        r103.b(r100);     // Catch: Throwable -> L13
        goto L6
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L13
        h r104 = new h(this);
        this.L = r104;
        ThreadMethodProxy.start(r104);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void c0(boolean r100) {
        if (this.f455272k == true) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f455272k == true) goto L8;
        U();     // Catch: Throwable -> L10
        this.f455272k = true;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        if (this.f455294v == true) goto L21;
        if (r100 == false) goto L22;
        this.A0 = System.currentTimeMillis();
        SharedPreferences.Editor r101 = this.f455258d.getSharedPreferences("update_info", 0).edit();
        r101.putLong("last_any_dialog_show_time", this.A0);
        SharedPrefsEditorCompat.apply(r101);
        return;
    L22:
        return;
    }

    public final void d0(boolean r100) {
        if (r100 == false) goto L4;
        this.f455252a = false;
        StringBuilder r101 = new StringBuilder();
        r101.append(this.f455262f);
        String r102 = File.separator;
        r101.append(r102);
        r101.append("update_alpha.apk");
        this.f455264g = r101.toString();
        this.f455266h = this.f455262f + r102 + "update_alpha.apk.part";
        return;
    L4:
        StringBuilder r103 = new StringBuilder();
        r103.append(this.f455262f);
        String r104 = File.separator;
        r103.append(r104);
        r103.append("update.apk");
        this.f455264g = r103.toString();
        this.f455266h = this.f455262f + r104 + "update.apk.part";
        if (this.f455252a == true) goto L9;
        this.f455252a = true;
        return;
    }

    public final void e0(boolean r100) {
        this.W = true;
        com.ss.android.update.c.l(0);
        Z(1, r100);
    }

    public final void h0(boolean r100) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L7;
        U();     // Catch: Throwable -> L17
        this.f455272k = true;     // Catch: Throwable -> L17
    L7:
        if (this.f455251J == false) goto L11;
        com.ss.android.update.c.d(this.f455274l, this.f455280o, false, "start_download", "mUpdating");     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L11:
        d0(r100);     // Catch: Throwable -> L17
        yhc.a r101 = this.K;     // Catch: Throwable -> L17
        r101.f567683c = 1;     // Catch: Throwable -> L17
        r101.f567681a = 0;     // Catch: Throwable -> L17
        r101.f567682b = 0;     // Catch: Throwable -> L17
        this.f455251J = true;     // Catch: Throwable -> L17
        r();     // Catch: Throwable -> L17
        int r102 = this.H;     // Catch: Throwable -> L17
        int r103 = this.f455280o;     // Catch: Throwable -> L17
        if (r102 == r103) goto L14;
        this.H = r103;     // Catch: Throwable -> L17
        b0(r103, false);     // Catch: Throwable -> L17
    L14:
        monitor-exit(this);     // Catch: Throwable -> L17
        new c(this, r100).start();
    }

    public final void i0(boolean r100) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f455272k == true) goto L7;
        U();     // Catch: Throwable -> L16
        this.f455272k = true;     // Catch: Throwable -> L16
    L7:
        if (this.N == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L10:
        yhc.a r101 = this.O;     // Catch: Throwable -> L16
        r101.f567681a = 0;     // Catch: Throwable -> L16
        r101.f567682b = 0;     // Catch: Throwable -> L16
        this.N = true;     // Catch: Throwable -> L16
        s();     // Catch: Throwable -> L16
        int r102 = this.H;     // Catch: Throwable -> L16
        int r103 = this.f455280o;     // Catch: Throwable -> L16
        if (r102 == r103) goto L13;
        this.H = r103;     // Catch: Throwable -> L16
        b0(r103, true);     // Catch: Throwable -> L16
    L13:
        monitor-exit(this);     // Catch: Throwable -> L16
        new C5456d(this, r100).start();
    }

    public final void j0(Context r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.startActivity(A());     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Logger.d("UpdateHelper", th.getMessage(), th);
    }

    public final void m(boolean r100) {
        Z(3, r100);
        p.b.f567725a.getClass();
        if (p.d() == false) goto L5;
        int r101 = 4;
    L6:
        com.ss.android.update.c.l(2);
        String r102 = this.f455274l;
        int r103 = this.f455280o;
        if (r100 == false) goto L9;
        String r104 = "auto";
    L10:
        com.ss.android.update.c.m("test_invitation_popup_close", r102, r103, r104, r101, this.f455294v);
        this.W = false;
        return;
    L9:
        r104 = "trigger";
        goto L10
    L5:
        r101 = 3;
        goto L6
    }

    public final void n(boolean r100) {
        Z(3, r100);
        com.ss.android.update.c.l(2);
        String r101 = this.f455274l;
        int r102 = this.f455280o;
        if (r100 == false) goto L5;
        String r103 = "auto";
    L6:
        com.ss.android.update.c.m("test_invitation_popup_close", r101, r102, r103, -1, this.f455294v);
        this.W = false;
        return;
    L5:
        r103 = "trigger";
        goto L6
    }

    public final void o(boolean r100) {
        Z(2, r100);
        p.b.f567725a.getClass();
        if (p.d() == false) goto L5;
        int r101 = 4;
    L6:
        com.ss.android.update.c.l(1);
        String r102 = this.f455274l;
        int r103 = this.f455280o;
        if (r100 == false) goto L9;
        String r104 = "auto";
    L10:
        com.ss.android.update.c.m("test_invitation_popup_click", r102, r103, r104, r101, this.f455294v);
        this.W = false;
        return;
    L9:
        r104 = "trigger";
        goto L10
    L5:
        r101 = 3;
        goto L6
    }

    public final void p(boolean r100) {
        Z(2, r100);
        com.ss.android.update.c.l(1);
        String r101 = this.f455274l;
        int r102 = this.f455280o;
        if (r100 == false) goto L5;
        String r103 = "auto";
    L6:
        com.ss.android.update.c.m("test_invitation_popup_click", r101, r102, r103, -1, this.f455294v);
        this.W = false;
        return;
    L5:
        r103 = "trigger";
        goto L6
    }

    public final void t(boolean r100) {
        if (M(r100) == false) goto L13;
        boolean r101 = false;
        if (this.T != 1) goto L12;
        p r102 = p.b.f567725a;
        r102.getClass();
        if (p.d() == false) goto L9;
        r101 = r102.e();
    L9:
        if (r101 == false) goto L11;
        Message r103 = Message.obtain();
        r103.what = 14;
        r103.arg1 = r100 ? 1 : 0;
        this.f455260e.sendMessageDelayed(r103, Math.max(this.F, 10));
    L15:
        if (com.ss.android.update.c.j() == false) goto L26;
        JSONObject r104 = new JSONObject();
        r104.put("scene_id", 1);     // Catch: JSONException -> L20
        r104.put("_event_v3", 1);     // Catch: JSONException -> L20
        r104.put("is_local_app", com.ss.android.update.c.g());     // Catch: JSONException -> L20
        r104.put("is_monkey", com.ss.android.update.c.f());     // Catch: JSONException -> L20
    L22:
        yhc.b.a("local_test_before_check_update", r104);
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L26:
        return;
    L11:
        com.ss.android.update.c.k("reason_local_package_not_installed");
        goto L15
    L12:
        p r105 = p.b.f567725a;
        r105.a();
        r105.f567721d.b("show_alpha_dialog_bg_download_check", 0);
        r105.b(this.f455280o);
        Message r106 = Message.obtain();
        r106.what = 6;
        r106.arg1 = r100 ? 1 : 0;
        this.f455260e.sendMessage(r106);
        goto L15
    L13:
        this.f455260e.sendEmptyMessage(7);
        goto L15
    }

    public final void L(Context r100, PolarisFileWrapper r101) {
        if (r100 != null) goto L31;
        com.ss.android.update.c.d(this.f455274l, this.f455280o, false, "install_fail", "context == null || file == null");
        return;
    L31:
        yhc.g r102 = this.f455297w0;     // Catch: Exception -> L15
        if ((r102 instanceof o) == true) goto L7;
        l r103 = this.f455299x0;     // Catch: Exception -> L15
        if ((r103 instanceof y) == true) goto L12;
    L30:
    L33:
        v r104 = this.f455283p0;     // Catch: Exception -> L25
        if (r104 == null) goto L22;
        yhc.c r105 = r104.f567752p;     // Catch: Exception -> L25
        if (r105 == null) goto L22;
        r105.a(r101);     // Catch: Exception -> L25
    L23:
        com.ss.android.update.c.i(1, null);     // Catch: Exception -> L25
        return;
    L22:
        r100.startActivity(y(r100, r101));     // Catch: Exception -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        com.ss.android.update.c.d(this.f455274l, this.f455280o, false, "install_fail", Log.getStackTraceString(e));
        com.ss.android.update.c.i(2, Log.getStackTraceString(e));
        return;
    L12:
        if (r103.d() == false) goto L30;
        ((y) this.f455299x0).h();     // Catch: Exception -> L15
        goto L30
    L7:
        if (r102.c() == false) goto L30;
        ((o) this.f455297w0).h();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L33
    }

    public final void Z(int r100, boolean r101) {
        Message r102 = Message.obtain();
        r102.what = 15;
        r102.arg1 = r100;
        r102.arg2 = r101 ? 1 : 0;
        this.f455260e.sendMessage(r102);
    }

    @Override // yhc.i
    public final void a(boolean r100, boolean r101) {
        Logger.e("UpdateHelper", "downloadResult isSuccess:" + r100 + ",pre:" + r101);
        com.ss.android.update.b.a r102 = this.f455281o0.f455248e;
        if (r102 != null) goto L6;
        r102 = new com.ss.android.update.b.a();
    L6:
        yhc.a r103 = this.K;
        monitor-enter(r103);
        if (r101 == false) goto L20;
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L17
        this.f455285q0.execute(new e(this, r100, r101, r102));
        return;
    L17:
        th = move-exception;
        throw th;
    L20:
        yhc.a r104 = this.K;     // Catch: Throwable -> L17
        if (r100 == false) goto L12;
        int r105 = 3;
    L13:
        r104.f567683c = r105;     // Catch: Throwable -> L17
        goto L14
    L12:
        r105 = 2;
        goto L13
    }

    public final synchronized void b0(int r100, boolean r101) {
        monitor-enter(this);
        this.H = r100;     // Catch: Throwable -> L15
        if (r101 == false) goto L7;
        this.M = -1;     // Catch: Throwable -> L15
    L8:
        this.G = "";     // Catch: Throwable -> L15
        SharedPreferences.Editor r102 = this.f455258d.getSharedPreferences("update_info", 0).edit();     // Catch: Throwable -> L15
        r102.putInt("download_version", this.H);     // Catch: Throwable -> L15
        if (r101 == false) goto L11;
        r102.putInt("pre_download_size", this.M);     // Catch: Throwable -> L15
    L12:
        r102.putString("download_etag", this.G);     // Catch: Throwable -> L15
        SharedPrefsEditorCompat.apply(r102);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L11:
        r102.putInt(TTDelegateActivity.DOWNLOAD_SIZE, this.I);     // Catch: Throwable -> L15
        goto L12
    L7:
        this.I = -1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // yhc.i
    public final synchronized void e(int r100, boolean r101) {
        monitor-enter(this);
        List<OnUpdateStatusChangedListener> r102 = this.f455265g0;     // Catch: Throwable -> L26
        monitor-enter(r102);     // Catch: Throwable -> L26
        Iterator r103 = ((ArrayList) this.f455265g0).iterator();     // Catch: Throwable -> L23
    L8:
        if (r103.hasNext() == false) goto L12;
        OnUpdateStatusChangedListener r104 = (OnUpdateStatusChangedListener) r103.next();     // Catch: Throwable -> L23
        if (r104 == null) goto L8;
        r104.e(r100, r101);     // Catch: Throwable -> L23
        goto L8
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L23
        if (r101 == false) goto L15;
        this.M = r100;     // Catch: Throwable -> L26
    L16:
        this.G = "";     // Catch: Throwable -> L26
        SharedPreferences.Editor r105 = this.f455258d.getSharedPreferences("update_info", 0).edit();     // Catch: Throwable -> L26
        if (r101 == false) goto L19;
        r105.putInt("pre_download_size", this.M);     // Catch: Throwable -> L26
    L20:
        r105.putString("download_etag", this.G);     // Catch: Throwable -> L26
        SharedPrefsEditorCompat.apply(r105);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L19:
        r105.putInt(TTDelegateActivity.DOWNLOAD_SIZE, this.I);     // Catch: Throwable -> L26
        goto L20
    L15:
        this.I = r100;     // Catch: Throwable -> L26
        goto L16
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public final Intent y(Context r100, PolarisFileWrapper r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 24) goto L13;
        v r103 = this.f455283p0;
        if (r103 != null) goto L7;
        String r104 = "com.ss.android.uri.key";
    L12:
        Uri r105 = FileProvider.getUriForFile(r100, r104, r101);
    L14:
        Intent r106 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r106.setDataAndType(r105, "application/vnd.android.package-archive");
        if (r102 < 24) goto L17;
        int r107 = 268435457;
    L18:
        r106.addFlags(r107);
        return r106;
    L17:
        r107 = 268435456;
        goto L18
    L7:
        if (TextUtils.isEmpty(r103.f567739c) == true) goto L10;
        r104 = r103.f567739c;
        goto L12
    L10:
        throw new IllegalArgumentException("formalAuthority can not empty");
    L13:
        r105 = Uri.fromFile(r101);
        goto L14
    }

    @Override // yhc.i
    public final void d(int r100, int r101, boolean r102) {
        yhc.a r103 = this.K;
        monitor-enter(r103);
        if (r102 == false) goto L25;
    L6:
        List<OnUpdateStatusChangedListener> r104 = this.f455265g0;     // Catch: Throwable -> L20
        monitor-enter(r104);     // Catch: Throwable -> L20
        Iterator r105 = ((ArrayList) this.f455265g0).iterator();     // Catch: Throwable -> L17
    L10:
        if (r105.hasNext() == false) goto L14;
        OnUpdateStatusChangedListener r106 = (OnUpdateStatusChangedListener) r105.next();     // Catch: Throwable -> L17
        if (r106 == null) goto L10;
        r106.d(r100, r101, r102);     // Catch: Throwable -> L17
        goto L10
    L14:
        monitor-exit(r104);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L20
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L25:
        yhc.a r107 = this.K;     // Catch: Throwable -> L20
        r107.f567681a = r100;     // Catch: Throwable -> L20
        r107.f567682b = r101;     // Catch: Throwable -> L20
        goto L6
    }

    public final void g0(int r100, int r101, OnUpdateStatusChangedListener r102, boolean r103) {
        monitor-enter(this);
        this.f455287r0 = r100;     // Catch: Throwable -> L20
        List<OnUpdateStatusChangedListener> r104 = this.f455265g0;     // Catch: Throwable -> L20
        monitor-enter(r104);     // Catch: Throwable -> L20
        ((ArrayList) this.f455265g0).add(r102);     // Catch: Throwable -> L17
        monitor-exit(r104);     // Catch: Throwable -> L17
    L8:
        if (this.f455272k == true) goto L11;
        U();     // Catch: Throwable -> L20
        this.f455272k = true;     // Catch: Throwable -> L20
    L11:
        if (this.f455251J == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L20
        new b(this, r103).c();
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}
