package com.ss.android.common.applog;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.tool.BtmDebugTool;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.util.BlockHelper;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.AppLogNetworkStatusMonitor;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.pitaya.api.PitayaProxy;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.network.NetQualityManager;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.obric.sva.sdk.applog.InteractorAppLogLogger;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class AppLog {
    public static f A0 = null;
    public static volatile JSONObject B0 = null;
    public static boolean C0 = false;
    public static eta.b D0 = null;
    public static volatile boolean E0 = false;
    public static volatile long F0 = 0;
    public static final ConcurrentHashMap<String, String> G0 = null;
    public static final Bundle H0 = null;
    public static boolean I0 = false;
    public static final SimpleDateFormat J0 = null;
    public static final SimpleDateFormat K0 = null;
    public static boolean L = false;
    public static final Object L0 = null;
    public static volatile String M = null;
    public static final ThreadLocal<Boolean> M0 = null;
    public static volatile String N = null;
    public static volatile boolean N0 = false;
    public static long O = -1;
    public static volatile boolean O0;
    public static volatile boolean P;
    public static int P0;
    public static boolean Q;
    public static long Q0;
    public static volatile m R;
    public static final long R0 = 0;
    public static volatile iqa.a S;
    public static volatile boolean S0;
    public static volatile AtomicInteger T;
    public static volatile IBDAccountCallback T0;
    public static volatile gx3.c U;
    public static volatile boolean V;
    public static volatile boolean W;
    public static volatile boolean X;
    public static volatile long Y;
    public static volatile int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static volatile long f407998a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static volatile int f407999b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static volatile boolean f408000c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static volatile com.bytedance.applog.m f408001d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static volatile boolean f408002e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final AtomicLong f408003f0 = null;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static n f408004g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final boolean f408005h0 = false;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final boolean f408006i0 = false;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final boolean f408007j0 = false;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final boolean f408008k0 = false;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final boolean f408009l0 = false;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static boolean f408010m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static volatile boolean f408011n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final String[] f408012o0 = null;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static m0 f408013p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static volatile int f408014q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final Object f408015r0 = null;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static volatile AppLog f408016s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final AtomicLong f408017t0 = null;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static volatile long f408018u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static volatile int f408019v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static volatile int f408020w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static volatile int f408021x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static String f408022y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final List<g> f408023z0 = null;
    public final LinkedList<h> A;
    public long B;
    public volatile long C;
    public volatile long D;
    public volatile boolean E;
    public final ConcurrentHashMap<String, String> F;
    public final ConcurrentHashMap<String, String> G;
    public final ConcurrentHashMap<String, String> H;
    public final AtomicLong I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final AtomicLong f408024J;
    public volatile long K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f408025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f408026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f408027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f408028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppLogNetworkStatusMonitor f408029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f408030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedList<c> f408031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedList<u> f408032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile x f408033i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f408034j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f408035k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f408036l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JSONObject f408037m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f408038n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashSet<Integer> f408039o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f408040p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f408041q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public z f408042r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f408043s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f408044t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile long f408045u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f408046v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f408047w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public JSONObject f408048x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicInteger f408049y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AtomicInteger f408050z;

    /* JADX INFO: loaded from: classes6.dex */
    public static final enum ActionQueueType extends Enum<ActionQueueType> {
        public static final ActionQueueType API_SAMPLE = null;
        public static final ActionQueueType CLEAR_WHEN_SWITCH_CHILD_MODE = null;
        public static final ActionQueueType CONFIG_UPDATE = null;
        public static final ActionQueueType CUSTOMER_HEADER_UPDATE = null;
        public static final ActionQueueType DELAY_START_LOG_REAPER = null;
        public static final ActionQueueType DEVICE_ID_UPDATE = null;
        public static final ActionQueueType EVENT = null;
        public static final ActionQueueType FLUSH_EVENT = null;
        public static final ActionQueueType IMAGE_SAMPLE = null;
        public static final ActionQueueType PAGE_END = null;
        public static final ActionQueueType PAGE_START = null;
        public static final ActionQueueType RESET_WHEN_SWITCH_CHILD_MODE = null;
        public static final ActionQueueType SAVE_ANR_TAG = null;
        public static final ActionQueueType SAVE_DNS_REPORT = null;
        public static final ActionQueueType SAVE_MISC_LOG = null;
        public static final ActionQueueType UA_UPDATE = null;
        public static final ActionQueueType UPDATE_APP_LANGUAGE_REGION = null;
        public static final ActionQueueType UPDATE_GOOGLE_AID = null;
        public static final ActionQueueType UPDATE_USER_UNIQUE_ID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionQueueType[] f408051a = null;
        final int nativeInt;

        static {
            ActionQueueType r100 = new ActionQueueType("PAGE_START", 0, 0);
            PAGE_START = r100;
            ActionQueueType r101 = new ActionQueueType("PAGE_END", 1, 1);
            PAGE_END = r101;
            ActionQueueType r102 = new ActionQueueType(AlarmSessionType.EVENT, 2, 2);
            EVENT = r102;
            ActionQueueType r103 = new ActionQueueType("IMAGE_SAMPLE", 3, 3);
            IMAGE_SAMPLE = r103;
            ActionQueueType r104 = new ActionQueueType("CONFIG_UPDATE", 4, 4);
            CONFIG_UPDATE = r104;
            ActionQueueType r105 = new ActionQueueType("API_SAMPLE", 5, 5);
            API_SAMPLE = r105;
            ActionQueueType r110 = new ActionQueueType("UA_UPDATE", 6, 6);
            UA_UPDATE = r110;
            ActionQueueType r111 = new ActionQueueType("SAVE_ANR_TAG", 7, 7);
            SAVE_ANR_TAG = r111;
            ActionQueueType r112 = new ActionQueueType("SAVE_DNS_REPORT", 8, 8);
            SAVE_DNS_REPORT = r112;
            ActionQueueType r113 = new ActionQueueType("SAVE_MISC_LOG", 9, 9);
            SAVE_MISC_LOG = r113;
            ActionQueueType r114 = new ActionQueueType("DEVICE_ID_UPDATE", 10, 10);
            DEVICE_ID_UPDATE = r114;
            ActionQueueType r115 = new ActionQueueType("CUSTOMER_HEADER_UPDATE", 11, 11);
            CUSTOMER_HEADER_UPDATE = r115;
            ActionQueueType r106 = new ActionQueueType("UPDATE_GOOGLE_AID", 12, 12);
            UPDATE_GOOGLE_AID = r106;
            ActionQueueType r107 = new ActionQueueType("UPDATE_APP_LANGUAGE_REGION", 13, 13);
            UPDATE_APP_LANGUAGE_REGION = r107;
            ActionQueueType r108 = new ActionQueueType("CLEAR_WHEN_SWITCH_CHILD_MODE", 14, 14);
            CLEAR_WHEN_SWITCH_CHILD_MODE = r108;
            ActionQueueType r109 = new ActionQueueType("RESET_WHEN_SWITCH_CHILD_MODE", 15, 15);
            RESET_WHEN_SWITCH_CHILD_MODE = r109;
            ActionQueueType r116 = new ActionQueueType("FLUSH_EVENT", 16, 16);
            FLUSH_EVENT = r116;
            ActionQueueType r117 = new ActionQueueType("UPDATE_USER_UNIQUE_ID", 17, 17);
            UPDATE_USER_UNIQUE_ID = r117;
            ActionQueueType r118 = new ActionQueueType("DELAY_START_LOG_REAPER", 18, 18);
            DELAY_START_LOG_REAPER = r118;
            f408051a = new ActionQueueType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
        }

        public static ActionQueueType[] values() {
            return (ActionQueueType[]) f408051a.clone();
        }

        public static ActionQueueType valueOf(String r100) {
            return (ActionQueueType) r27.a.a(ActionQueueType.class, r100);
        }

        public ActionQueueType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface ConfigUpdateListener {
        void onConfigUpdate();

        void onRemoteConfigUpdate(boolean r100);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ String f408052v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ boolean f408053w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final /* synthetic */ AppLog f408054x;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            this.f408054x.M(this.f408052v, this.f408053w);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AppLog r100, String r101, boolean r102, long r103) {
            this.f408054x = r100;
            this.f408052v = r101;
            this.f408053w = r102;
            super("plog/AppLog$2");
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f408055a = null;

        static {
            int[] r100 = new int[ActionQueueType.values().length];
            f408055a = r100;
            r100[ActionQueueType.EVENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L64:
            f408055a[ActionQueueType.SAVE_MISC_LOG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L48:
            f408055a[ActionQueueType.PAGE_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L60:
            f408055a[ActionQueueType.PAGE_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L66:
            f408055a[ActionQueueType.IMAGE_SAMPLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L50:
            f408055a[ActionQueueType.API_SAMPLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L54:
            f408055a[ActionQueueType.CONFIG_UPDATE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L78:
            f408055a[ActionQueueType.UA_UPDATE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L44:
            f408055a[ActionQueueType.SAVE_ANR_TAG.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L70:
            f408055a[ActionQueueType.SAVE_DNS_REPORT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L74:
            f408055a[ActionQueueType.CUSTOMER_HEADER_UPDATE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
        L56:
            f408055a[ActionQueueType.DEVICE_ID_UPDATE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
        L62:
            f408055a[ActionQueueType.UPDATE_GOOGLE_AID.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
        L46:
            f408055a[ActionQueueType.UPDATE_APP_LANGUAGE_REGION.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
        L52:
            f408055a[ActionQueueType.CLEAR_WHEN_SWITCH_CHILD_MODE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L37
        L76:
            f408055a[ActionQueueType.RESET_WHEN_SWITCH_CHILD_MODE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L38
        L42:
            f408055a[ActionQueueType.FLUSH_EVENT.ordinal()] = 17;     // Catch: NoSuchFieldError -> L39
        L68:
            f408055a[ActionQueueType.UPDATE_USER_UNIQUE_ID.ordinal()] = 18;     // Catch: NoSuchFieldError -> L40
        L72:
            f408055a[ActionQueueType.DELAY_START_LOG_REAPER.ordinal()] = 19;     // Catch: NoSuchFieldError -> L41
            return;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionQueueType f408056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f408057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f408058c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f408059d;

        public c(ActionQueueType r100) {
            this.f408056a = r100;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public class d extends PthreadThreadV2 implements jta.g.a {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f408060v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ AppLog f408061w;

        /* JADX INFO: loaded from: classes34.dex */
        public class a implements com.bytedance.applog.log.g.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f408062a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f408063b;

            @Override // com.bytedance.applog.log.g.b
            public final Object fetch() {
                JSONObject r100 = new JSONObject();
                r100.put("appId", String.valueOf(jta.g.c()));     // Catch: Throwable -> L5
                r100.put(com.bytedance.android.ec.core.event.a.KEY_DID, this.f408062a);     // Catch: Throwable -> L5
                r100.put("installId", this.f408063b);     // Catch: Throwable -> L5
            L4:
                return r100;
            }

            public a(String r100, String r101) {
                this.f408062a = r100;
                this.f408063b = r101;
            }
        }

        /* JADX INFO: loaded from: classes34.dex */
        public class b implements com.bytedance.applog.log.g.b {
            @Override // com.bytedance.applog.log.g.b
            public final Object fetch() {
                JSONObject r100 = new JSONObject();
                r100.put("appId", String.valueOf(jta.g.c()));     // Catch: Throwable -> L5
                r100.put(com.bytedance.android.ec.core.event.a.KEY_DID, AppLog.v());     // Catch: Throwable -> L5
                r100.put("installId", jta.g.e());     // Catch: Throwable -> L5
            L4:
                return r100;
            }

            public b() {
            }
        }

        public final void l() {
            jta.g.b(this);
            if (AppLog.d(this.f408061w) == true) goto L6;
            ita.j.c("AppLog can not setup LogReaper", null);
            return;
        L6:
            this.f408061w.k();
            this.f408061w.f();
        L7:
            LinkedList<c> r100 = this.f408061w.f408031g;
            monitor-enter(r100);
            boolean r101 = AppLog.L;     // Catch: Throwable -> L30
            if (this.f408061w.f408031g.isEmpty() == true) goto L33;
            c r102 = this.f408061w.f408031g.poll();     // Catch: Throwable -> L30
        L20:
            monitor-exit(r100);     // Catch: Throwable -> L30
            if (r102 == null) goto L25;
            this.f408061w.I(r102);
            this.f408060v = true;
        L27:
            this.f408061w.L(true, false, false);
            goto L7
        L25:
            if (this.f408060v == false) goto L27;
            this.f408060v = false;
            this.f408061w.f();
            goto L27
        L33:
            if (this.f408060v == false) goto L14;
            AppLog r103 = this.f408061w;     // Catch: InterruptedException -> L32 Throwable -> L30
            r103.f408031g.wait(r103.f408043s);     // Catch: InterruptedException -> L32 Throwable -> L30
            goto L15
        L14:
            this.f408061w.f408031g.wait();     // Catch: InterruptedException -> L32 Throwable -> L30
        L15:
            boolean r104 = AppLog.L;     // Catch: Throwable -> L30
            if (this.f408061w.f408031g.isEmpty() == true) goto L18;
            r102 = this.f408061w.f408031g.poll();     // Catch: Throwable -> L30
            goto L20
        L18:
            r102 = null;
        L30:
            th = move-exception;
            throw th;
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

        public d(AppLog r100) {
            this.f408061w = r100;
            super("ActionReaper");
            this.f408060v = false;
        }

        @Override // jta.g.a
        public final void onDidLoadLocally(boolean r100) {
            monitor-enter(AppLog.class);
            AppLog.N0 = true;     // Catch: Throwable -> L13
            if (AppLog.O0 == false) goto L8;
            AppLog.c(this.f408061w.f408036l);     // Catch: Throwable -> L13
        L8:
            monitor-exit(AppLog.class);     // Catch: Throwable -> L13
            if (com.bytedance.applog.log.m.b() == true) goto L18;
            com.bytedance.applog.log.m.c("local_did_load", new b());
            return;
        L18:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // jta.g.a
        public final void onDeviceRegistrationInfoChanged(String r100, String r101) {
            c r102 = new c(ActionQueueType.DEVICE_ID_UPDATE);
            JSONObject r103 = new JSONObject();
            r103.put("device_id", r100);     // Catch: JSONException -> L5
            r103.put("install_id", r101);     // Catch: JSONException -> L5
            r102.f408057b = r103;     // Catch: JSONException -> L5
        L7:
            this.f408061w.i(r102);
            this.f408061w.f408027c = true;
            if (com.bytedance.applog.log.m.b() == true) goto L13;
            com.bytedance.applog.log.m.c("device_register_end", new a(r100, r101));
            return;
        L13:
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        @Override // jta.g.a
        public final void onRemoteConfigUpdate(boolean r100, boolean r101) {
            AppLog r102 = this.f408061w;
            if (r102.f408027c == false) goto L6;
            r102.f408027c = false;
            return;
        L6:
            if (r100 == true) goto L8;
            return;
        L8:
            if (AppLog.E0 == false) goto L12;
            this.f408061w.L(false, true, r101);
            return;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f408064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f408065b;

        public e(String r100, int r101) {
            this.f408065b = r100;
            this.f408064a = r101;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface f {
        boolean getEncryptSwitch();

        boolean getEventV3Switch();

        boolean getRecoverySwitch();
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface g {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f408067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f408068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f408069d;

        public h(String r100, int r101, long r102, long r103) {
            this.f408066a = r100;
            this.f408067b = r101;
            this.f408068c = r102;
            this.f408069d = r103;
        }
    }

    public static class i implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SharedPreferences f408070a;

        /* JADX INFO: loaded from: classes34.dex */
        public class a implements com.bytedance.applog.log.g.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f408071a;

            @Override // com.bytedance.applog.log.g.b
            public final Object fetch() {
                JSONObject r100 = new JSONObject();
                r100.put("appId", jta.g.c());     // Catch: Throwable -> L13
                Context r101 = this.f408071a;     // Catch: Throwable -> L13
                r100.put("channel", jta.g.f500376j.getChannel(r101));     // Catch: Throwable -> L13
                JSONObject r102 = new JSONObject();     // Catch: Throwable -> L13
                r102.put("版本号", jta.g.f500376j.getVersionName());     // Catch: Throwable -> L13
                r102.put("接口加密", AppLog.t());     // Catch: Throwable -> L13
                r102.put("采集USER ID", AppLog.S0);     // Catch: Throwable -> L13
                boolean r103 = true;
                if ((AppLog.p() & 1) <= 0) goto L6;
                boolean r104 = true;
            L7:
                r102.put("事件采样", r104);     // Catch: Throwable -> L13
                if ((AppLog.p() & 2) > 0) goto L11;
                r103 = false;
            L11:
                r102.put("Tea还原采样", r103);     // Catch: Throwable -> L13
                r100.put("config", r102);     // Catch: Throwable -> L13
                goto L12
            L6:
                r104 = false;
            L12:
                return r100;
            }

            public a(Context r100) {
                this.f408071a = r100;
            }
        }

        /* JADX INFO: loaded from: classes34.dex */
        public class b implements com.bytedance.applog.log.g.b {
            @Override // com.bytedance.applog.log.g.b
            public final Object fetch() {
                JSONObject r100 = new JSONObject();
                boolean r101 = AppLog.L;     // Catch: Throwable -> L5
                r100.put("appId", String.valueOf(jta.g.c()));     // Catch: Throwable -> L5
            L4:
                return r100;
            }

            public b() {
            }
        }

        @Override // com.ss.android.common.applog.n
        public final void A() {
            AppLog.W = false;
            jta.g.f500372f = false;
        }

        @Override // com.ss.android.common.applog.n
        public final void B() {
            AppLog.V = true;
        }

        @Override // com.ss.android.common.applog.n
        public final void q() {
            AppLog.S0 = true;
        }

        @Override // com.ss.android.common.applog.n
        public final void r() {
            AppLog.f408002e0 = true;
        }

        @Override // com.ss.android.common.applog.n
        public final JSONObject C() {
            AppLog r100 = AppLog.f408016s0;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100.f408048x;
        }

        @Override // com.ss.android.common.applog.n
        public final int H() {
            SharedPreferences r100 = this.f408070a;
            if (r100 != null) goto L5;
            return 0;
        L5:
            return r100.getInt("content_encode_method", 0);
        }

        @Override // com.ss.android.common.applog.n
        public final String getCurrentSessionId() {
            AppLog r100 = AppLog.f408016s0;
            if (r100 == null) goto L8;
            z r101 = r100.f408042r;
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.f408241b;
        L8:
            return null;
        }

        @Override // com.ss.android.common.applog.n
        public final String getInstallId() {
            if (AppLog.f408016s0 != null) goto L5;
            return null;
        L5:
            return jta.g.e();
        }

        @Override // com.ss.android.common.applog.n
        public final String getServerDeviceId() {
            if (AppLog.f408016s0 != null) goto L5;
            return null;
        L5:
            return jta.g.d();
        }

        @Override // com.ss.android.common.applog.n
        public final String getUserId() {
            return String.valueOf(AppLog.f408017t0.get());
        }

        @Override // com.ss.android.common.applog.n
        public final String w() {
            boolean r100 = AppLog.L;
            return AppLog.M;
        }

        public i() {
        }

        @Override // com.ss.android.common.applog.n
        public final void D() {
            boolean r100 = AppLog.L;
        }

        @Override // com.ss.android.common.applog.n
        public final iqa.a E() {
            return AppLog.S;
        }

        @Override // com.ss.android.common.applog.n
        public final void G() {
            jta.g r100 = jta.g.f500367a;
        }

        @Override // com.ss.android.common.applog.n
        public final String getSessionKey() {
            return AppLog.f408022y0;
        }

        @Override // com.ss.android.common.applog.n
        public final com.bytedance.applog.m h() {
            return AppLog.f408001d0;
        }

        @Override // com.ss.android.common.applog.n
        public final void k() {
            jta.g r100 = jta.g.f500367a;
        }

        @Override // com.ss.android.common.applog.n
        public final JSONObject m() {
            return AppLog.B0;
        }

        @Override // com.ss.android.common.applog.n
        public final void p() {
            jta.g r100 = jta.g.f500367a;
        }

        @Override // com.ss.android.common.applog.n
        public final void a(String r100) {
            AppLog.M = r100;
        }

        @Override // com.ss.android.common.applog.n
        public final void b(eta.b r100) {
            AppLog.D0 = r100;
            jta.g.h(r100);
        }

        @Override // com.ss.android.common.applog.n
        public final void c(boolean r100) {
            AppLog.P = r100;
        }

        @Override // com.ss.android.common.applog.n
        public final void d(Bundle r100) {
            if (r100.size() <= 0) goto L20;
            AppLog r101 = AppLog.f408016s0;     // Catch: Throwable -> L21
            if (r101 != null) goto L22;
            Bundle r102 = AppLog.H0;     // Catch: Throwable -> L21
            monitor-enter(r102);     // Catch: Throwable -> L21
            r102.putAll(r100);     // Catch: Throwable -> L17
            monitor-exit(r102);     // Catch: Throwable -> L17
        L15:
            jta.g.f500376j.s(r100);     // Catch: Throwable -> L21
            return;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        L22:
            Bundle r103 = new Bundle();     // Catch: Throwable -> L9
            r103.putAll(r100);     // Catch: Throwable -> L9
            c r104 = new c(ActionQueueType.CUSTOMER_HEADER_UPDATE);     // Catch: Throwable -> L9
            r104.f408057b = r103;     // Catch: Throwable -> L9
            r101.i(r104);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L21
            goto L15
        L20:
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final AppLog e(Context r100) {
            AppLog.h(r100, kta.u.f506137a);
            Object r101 = AppLog.f408015r0;
            monitor-enter(r101);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (AppLog.f408016s0 != null) goto L9;
            AppLog.f408016s0 = new AppLog(r100, 0);     // Catch: Throwable -> L12
            if (Logger.debug() == false) goto L9;
            ita.j.b("Process AppLog = " + AppLog.f408016s0.toString() + " pid = " + Process.myPid(), null);     // Catch: Throwable -> L12
        L9:
            monitor-exit(r101);     // Catch: Throwable -> L12
            return AppLog.f408016s0;
        }

        @Override // com.ss.android.common.applog.n
        public final void f(boolean r100) {
            AppLog.f408011n0 = r100;
        }

        @Override // com.ss.android.common.applog.n
        public final void g(Map<String, String> r100) {
            Object r101 = AppLog.f408015r0;
            monitor-enter(r101);
            AppLog r102 = AppLog.f408016s0;     // Catch: Throwable -> L12
            monitor-exit(r101);     // Catch: Throwable -> L12
            if (r102 != null) goto L8;
            return;
        L8:
            jta.g.f500376j.x(r100, jta.g.f500369c);
            String r103 = String.valueOf(AppLog.f408017t0.get());
            if (r103 == null) goto L17;
            ((HashMap) r100).put("user_id", r103);
            return;
        L17:
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.ss.android.common.applog.n
        public final void j(boolean r100) {
            if (r100 == false) goto L4;
            AppLog.T.set(AppLog.T.get() | 1);
            return;
        L4:
            AppLog.T.set(AppLog.T.get() & (-2));
        }

        @Override // com.ss.android.common.applog.n
        public final void l(a0.a r100) {
            a0.f408075a = r100;
        }

        @Override // com.ss.android.common.applog.n
        public final void n(InteractorAppLogLogger r100) {
            ita.j.f495748a = r100;
        }

        @Override // com.ss.android.common.applog.n
        public final void o(com.obric.sva.sdk.applog.a r100) {
            AppLog.T0 = r100;
        }

        @Override // com.ss.android.common.applog.n
        public final void onPause(Context r110) {
            if ((r110 instanceof Activity) == false) goto L28;
            String r100 = r110.getClass().getName();
            int r101 = r110.hashCode();
            if (TextUtils.isEmpty(r100) == true) goto L29;
            AppLog r111 = e(r110);
            if (r111 != null) goto L10;
        L26:
            jta.g.f500376j.onPause();
            return;
        L10:
            if (r111.f408030f == false) goto L26;
            long r102 = System.currentTimeMillis();
            e r103 = r111.f408034j;
            if (r103 != null) goto L14;
        L15:
            if (r103 == null) goto L17;
            String r104 = r103.f408065b;
        L18:
            ita.j.g("AppLog unmatched onPause: " + r100 + " " + r104, null);
            r111.f408035k = r102 - 1010;
        L19:
            r111.f408034j = null;
            int r105 = (int) ((r102 - r111.f408035k) / 1000);
            if (r105 > 0) goto L22;
            r105 = 1;
        L22:
            r111.f408035k = r102;
            if (Logger.debug() == false) goto L25;
            ita.j.f("AppLog onPause " + r105 + " " + r100);
        L25:
            s r106 = new s();
            r106.f408221a = r100;
            r106.f408222b = r105;
            c r107 = new c(ActionQueueType.PAGE_END);
            r107.f408057b = r106;
            r107.f408058c = r102;
            r111.i(r107);
            goto L26
        L17:
            r104 = "(null)";
            goto L18
        L14:
            if (r103.f408064a == r101) goto L19;
        L29:
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final void onResume(Context r100) {
            if ((r100 instanceof Activity) == false) goto L20;
            String r101 = r100.getClass().getName();
            int r102 = r100.hashCode();
            if (TextUtils.isEmpty(r101) == true) goto L20;
            boolean r103 = AppLog.L;
            String.valueOf(System.currentTimeMillis());
            e r104 = new e(r101, r102);
            AppLog r105 = e(r100);
            if (r105 != null) goto L10;
        L18:
            jta.g.f500376j.onResume();
            goto L20
        L10:
            if (r105.f408030f == false) goto L18;
            if (r105.f408034j == null) goto L14;
            ita.j.g("AppLog onPause not call on " + r105.f408034j.f408065b, null);
        L14:
            long r106 = System.currentTimeMillis();
            r105.f408035k = r106;
            r105.f408034j = r104;
            if (Logger.debug() == false) goto L17;
            ita.j.f("AppLog onResume ".concat(r101));
        L17:
            c r107 = new c(ActionQueueType.PAGE_START);
            r107.f408058c = r106;
            r105.i(r107);
        L20:
            if (AppLog.f408010m0 == true) goto L23;
            AppLog.c(r100.getApplicationContext());
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final void registerHeaderCustomCallback(iqa.a r100) {
            AppLog.S = r100;
        }

        @Override // com.ss.android.common.applog.n
        public final void setAnonymous(boolean r100) {
            if (AppLog.E0 == true) goto L7;
            AppLog.L = r100;
            return;
        L7:
            throw new IllegalStateException("please call before init");
        }

        @Override // com.ss.android.common.applog.n
        public final void setSessionKey(String r100) {
            AppLog.f408022y0 = r100;
        }

        @Override // com.ss.android.common.applog.n
        public final void setUserId(long r100) {
            AppLog.f408017t0.set(r100);
        }

        @Override // com.ss.android.common.applog.n
        public final void t(String r100) {
            if (StringUtils.isEmpty(r100) == true) goto L8;
            String[] r101 = d0.f408092a;
            if (StringUtils.isEmpty(r100) == true) goto L9;
            d0.f408100i = r100;
            return;
        L9:
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final void u(f r100) {
            AppLog.A0 = r100;
        }

        @Override // com.ss.android.common.applog.n
        public final void v(String r100) {
            if (StringUtils.isEmpty(r100) == true) goto L8;
            String r101 = com.ss.android.common.applog.h.f408125e;
            if (StringUtils.isEmpty(r100) == true) goto L9;
            com.ss.android.common.applog.h.f408125e = r100;
            return;
        L9:
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final void x(String r100) {
            if (StringUtils.isEmpty(r100) == false) goto L5;
            return;
        L5:
            if (StringUtils.isEmpty(r100) == true) goto L9;
            kta.b.f506097a = r100;
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final boolean y(String r100) {
            return c0.f(r100);
        }

        @Override // com.ss.android.common.applog.n
        public final void z(m r100) {
            AppLog.R = r100;
        }

        @Override // com.ss.android.common.applog.n
        public final void i(String r100, JSONObject r101) {
            boolean r102 = AppLog.L;
            if (StringUtils.isEmpty(r100) == true) goto L36;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.length() <= 0) goto L39;
            AppLog r103 = AppLog.f408016s0;
            if (r103 == null) goto L38;
            com.ss.android.common.applog.e.a().b(StatsCountKeys.COLLECT_EVENT_COUNT, 1);
            if (AppLog.p() <= 0) goto L21;
            gx3.c r104 = AppLog.U;     // Catch: Exception -> L25
            if (r104 == null) goto L21;
            if (r104.a(AppLog.e(), "log_data", r101) == false) goto L21;
            com.ss.android.common.applog.e.a().b(StatsCountKeys.FILTER_DROP_EVENT_COUNT, 1);     // Catch: Exception -> L25
            return;
        L21:
            if (EventVerify.inst().isEnable() == false) goto L23;
            r101.put(FrescoMonitorConst.LOG_TYPE, r100);     // Catch: Exception -> L25
            JSONArray r105 = new JSONArray();     // Catch: Exception -> L25
            r105.put(r101);     // Catch: Exception -> L25
            EventVerify.inst().putEvent("log_data", r105);     // Catch: Exception -> L25
        L23:
            r101.put("event_id", AppLog.f408003f0.incrementAndGet());     // Catch: Exception -> L25
        L26:
            com.ss.android.common.applog.e.a().b(StatsCountKeys.ACCEPT_EVENT_COUNT, 1);
            if (com.bytedance.applog.log.m.b() == true) goto L33;
            long r106 = r101.optLong("event_id", 0);
            if (r106 <= 0) goto L33;
            com.bytedance.applog.log.m.c("event_receive", new ita.c(r101, r106, r100));
        L33:
            c r107 = new c(ActionQueueType.SAVE_MISC_LOG);
            r107.f408059d = r100;
            r107.f408057b = r101;
            r103.i(r107);
            return;
        L38:
            return;
        L39:
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final void F(Context r100, boolean r101, m0 r102) {
            if (AppLog.f408002e0 == false) goto L24;
            if (r102 == null) goto L22;
            AppLog.f408013p0 = r102;
            jta.g.f500376j.y(r102.f408196e, r102.f408195d);
            if (com.bytedance.applog.log.m.b() == true) goto L8;
            com.bytedance.applog.log.m.c("init_begin", new a(r100));
        L8:
            AppLog.E0 = true;
            if ((r100 instanceof Activity) == false) goto L12;
            AppLog.C0 = true;
        L12:
            if (AppLog.f408001d0 != null) goto L14;
            AppLog.f408001d0 = new com.ss.android.common.applog.i(r100);
        L14:
            e(r100);
            if (AppLog.I0 == true) goto L17;
            AppLog.I0 = true;
            com.ss.android.common.applog.d r103 = com.ss.android.common.applog.d.a();
            r103.getClass();
            new com.ss.android.common.applog.c(r103).start();
        L17:
            AppLog.f408010m0 = !r101;
            AppLog.P0 = 1;
            this.f408070a = r100.getSharedPreferences(kta.b.f506097a, 0);
            AppLog.f408004g0.p();
            ApplogServiceImpl.isServicePrepared = true;
            ApplogServiceImpl.handleCachedData();
            if (com.bytedance.applog.log.m.b() == true) goto L25;
            com.bytedance.applog.log.m.e(String.valueOf(jta.g.c()));
            com.bytedance.applog.log.m.c("start_end", new b());
            return;
        L25:
            return;
        L22:
            throw new IllegalArgumentException("urlConfig must not be null");
        L24:
            throw new IllegalArgumentException("Only support main process init!");
        }

        @Override // com.ss.android.common.applog.n
        public final void s(String r210, String r211, String r212, long r213, long r214, boolean r215, JSONObject r216) {
            JSONObject r100 = r216;
            AppLog r110 = AppLog.f408016s0;
            if (r110 != null) goto L19;
            com.ss.android.common.applog.d r101 = com.ss.android.common.applog.d.a();
            LinkedList<com.ss.android.common.applog.d.a> r111 = r101.f408084a;
            monitor-enter(r111);
        L15:
            th = move-exception;
            throw th;
        L7:
            if (r101.f408084a.size() <= 200) goto L11;
            com.ss.android.common.applog.d.a r102 = r101.f408084a.poll();     // Catch: Throwable -> L15
            a0.a(1, 1, null);     // Catch: Throwable -> L15
            if (r102 == null) goto L11;
            com.ss.android.common.applog.e.a().b(StatsCountKeys.CACHE_DROP_EVENT_COUNT, 1);     // Catch: Throwable -> L15
        L11:
            r101.f408084a.add(new com.ss.android.common.applog.d.a(r210, r211, r212, r213, r214, r215, r216));     // Catch: Throwable -> L15
            monitor-exit(r111);     // Catch: Throwable -> L15
            ita.j.g("AppLog null context when onEvent", null);
            return;
        L19:
            if (StringUtils.isEmpty(r210) == false) goto L21;
            int r103 = 1;
            int r104 = 0;
        L161:
            a0.a(r103, r104, null);
            return;
        L21:
            if (StringUtils.isEmpty(r211) == false) goto L24;
            r104 = 0;
            r103 = 1;
            goto L161
        L24:
            if (r110.f408030f == true) goto L26;
            a0.a(1, 3, null);
            return;
        L26:
            com.ss.android.common.applog.e.a().b(StatsCountKeys.COLLECT_EVENT_COUNT, 1);
            if (AppLog.u() == false) goto L53;
            if ("event_v3".equalsIgnoreCase(r210) == false) goto L41;
            ConcurrentHashMap<String, String> r112 = r110.G;     // Catch: Throwable -> L62
            if (r112 == null) goto L53;
            if (r112.size() <= 0) goto L53;
            if (StringUtils.isEmpty(r211) == true) goto L53;
            if (r110.G.containsKey(r211) == false) goto L53;
            ita.j.g("AppLog hit block event v3", null);     // Catch: Throwable -> L62
            com.ss.android.common.applog.e.a().b(StatsCountKeys.FILTER_DROP_EVENT_COUNT, 1);     // Catch: Throwable -> L62
            a0.a(1, 2, null);     // Catch: Throwable -> L62
            return;
        L41:
            ConcurrentHashMap<String, String> r113 = r110.F;     // Catch: Throwable -> L62
            if (r113 == null) goto L53;
            if (r113.size() <= 0) goto L53;
            if (StringUtils.isEmpty(r212) == true) goto L48;
            String r114 = r211 + r212;     // Catch: Throwable -> L62
        L50:
            if (r110.F.containsKey(r114) == false) goto L53;
            ita.j.g("AppLog hit block event v1", null);     // Catch: Throwable -> L62
            com.ss.android.common.applog.e.a().b(StatsCountKeys.FILTER_DROP_EVENT_COUNT, 1);     // Catch: Throwable -> L62
            a0.a(1, 2, null);     // Catch: Throwable -> L62
            return;
        L48:
            r114 = r211;
        L53:
            if (AppLog.p() <= 0) goto L63;
            if ("event_v3".equalsIgnoreCase(r210) == false) goto L63;
            gx3.c r105 = AppLog.U;     // Catch: Throwable -> L62
            if (r105 == null) goto L63;
            if (r105.a(AppLog.e(), r211, r100) == false) goto L63;
            com.ss.android.common.applog.e.a().b(StatsCountKeys.FILTER_DROP_EVENT_COUNT, 1);     // Catch: Throwable -> L62
            return;
        L63:
            q r115 = new q();
            r115.f408201a = AppLog.f408003f0.incrementAndGet();
            r115.f408202b = r210;
            r115.f408203c = r211;
            r115.f408204d = r212;
            r115.f408205e = r213;
            r115.f408206f = r214;
            NetworkUtils.NetworkType r106 = r110.f408029e.getNetworkType();
            if (r106 == null) goto L70;
            if (r100 != null) goto L167;
            r100 = new JSONObject();
        L167:
            r100.put("nt", r106.getValue());     // Catch: Exception -> L69
        L70:
            JSONObject r116 = r100;
            long r117 = AppLog.f408017t0.get();
            IBDAccountCallback r107 = AppLog.T0;
            if (AppLog.S0 == false) goto L79;
            if (r107 == null) goto L79;
            Pair<Integer, Long> r108 = r107.getOdinUserInfo();
            if (((Long) r108.second).longValue() <= 0) goto L77;
            r115.f408208h = ((Long) r108.second).longValue();
            r115.f408210j = 1;
            r115.f408211k = 1;
            r115.f408207g = ((Integer) r108.first).intValue();
            r115.f408209i = ((Long) r108.second).longValue();
        L80:
            if (r116 == null) goto L88;
            JSONObject r118 = r116;
            if (r118.has(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP) == true) goto L172;
        L89:
            r115.f408212l = System.currentTimeMillis();
        L90:
            if (r118 == null) goto L113;
            eta.b r109 = AppLog.D0;
            if (r109 != null) goto L94;
        L96:
            boolean r119 = false;
        L176:
            r115.f408214n = r118.toString();     // Catch: StackOverflowError -> L99 ConcurrentModificationException -> L105
        L99:
            e = move-exception;
            if (r119 == true) goto L104;
            ita.j.c("ext json toString stack overflow tag: " + r211 + ", label: " + r212, e);
            goto L113
        L104:
            throw new RuntimeException("ext json toString stack overflow tag: " + r211 + ", label: " + r212, e);
        L105:
            r115.f408214n = r118.toString();     // Catch: Throwable -> L107
        L107:
            th = move-exception;
            if (r119 == true) goto L112;
            ita.j.c("ext json exception tag: " + r211 + ", label: " + r212, th);
            goto L113
        L112:
            throw new RuntimeException("ext json exception tag: " + r211 + ", label: " + r212, th);
        L94:
            if ("local_test".equalsIgnoreCase(r109.getChannel()) == false) goto L96;
            r119 = true;
        L113:
            String r120 = r115.f408214n;
            if (r120 != null) goto L116;
        L118:
            boolean r121 = false;
        L119:
            r115.f408215o = r215;
            r115.f408216p = r121;
            if (Logger.debug() == false) goto L165;
            StringBuilder r122 = new StringBuilder("onEvent ");
            r122.append(r210);
            r122.append(" ");
            r122.append(r211);
            r122.append(" ");
            r122.append(r212);
            if (r213 != 0) goto L127;
            long r123 = r214;
            if (r123 != 0) goto L128;
            if (r118 != null) goto L128;
        L130:
            if (r123 != 0) goto L132;
            if (r118 != null) goto L132;
        L133:
            if (r118 == null) goto L135;
            r122.append(" ");
            r122.append(r118);
        L135:
            ita.j.f("AppLog " + r122);
        L132:
            r122.append(" ");
            r122.append(r123);
        L128:
            r122.append(" ");
            r122.append(r213);
            goto L130
        L127:
            r123 = r214;
        L165:
            if (EventVerify.inst().isEnable() == false) goto L143;
            q r124 = r115;
            EventVerify.inst().putEvent(r210, r211, r212, r213, r214, r115.f408208h, r115.f408212l, r118);     // Catch: Exception -> L163
        L144:
            String r125 = r124.f408202b;
            if ("event_v3".equalsIgnoreCase(r125) == false) goto L148;
            r125 = "EVENT_V3";
        L148:
            if (com.bytedance.applog.log.m.b() == true) goto L158;
            long r126 = r124.f408201a;
            if (r126 > 0) goto L155;
            r126 = 0;
        L155:
            if (r126 <= 0) goto L158;
            com.bytedance.applog.log.m.c("event_receive", new ita.d(r125, r126, r124));
        L158:
            com.ss.android.common.applog.e.a().b(StatsCountKeys.ACCEPT_EVENT_COUNT, 1);
            c r127 = new c(ActionQueueType.EVENT);
            r127.f408057b = r124;
            r110.i(r127);
            return;
        L143:
            r124 = r115;
            goto L144
        L116:
            if (r120.length() <= 50000) goto L118;
            r121 = false;
            a0.a(5, 0, new Object[]{r210, r211, r212, Integer.valueOf(r115.f408214n.length())});
            goto L119
        L172:
            r115.f408212l = JSONObjectProtectorUtils.getLong(r118, AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP);     // Catch: Throwable -> L85
        L87:
            r118.remove(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP);
        L85:
            th = move-exception;
            th.printStackTrace();
            r115.f408212l = System.currentTimeMillis();
            goto L87
        L88:
            r118 = r116;
            goto L89
        L77:
            if (AppLog.f408020w0 != 0) goto L80;
            r115.f408210j = AppLog.f408020w0;
            r115.f408211k = AppLog.f408021x0;
            r115.f408207g = AppLog.f408019v0;
            r115.f408209i = AppLog.f408018u0;
        L79:
            r115.f408208h = r117;
            goto L80
        }
    }

    public static boolean g(long r100) {
        if (r100 >= 10000) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 300000) goto L7;
        return true;
    }

    public final synchronized void k() {
        monitor-enter(this);
        B0 = new JSONObject(this.f408037m, com.ss.android.common.applog.f.f408122a);     // Catch: Throwable -> L5 JSONException -> L7
    L9:
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        ita.j.c("ensureHeaderCopy error", e);     // Catch: Throwable -> L5
        goto L9
    }

    static {
        T = new AtomicInteger(0);
        V = false;
        W = false;
        X = true;
        Y = 432000000;
        Z = 10;
        f407999b0 = -1;
        f408002e0 = true;
        f408003f0 = new AtomicLong(System.currentTimeMillis());
        f408004g0 = new i();
        f408005h0 = true;
        f408006i0 = true;
        f408007j0 = true;
        f408008k0 = true;
        f408009l0 = true;
        f408010m0 = false;
        f408011n0 = false;
        f408012o0 = new String[]{"klink_egdi", "appkey", "openudid", "sdk_version", "package", "channel", IGoogleService.ResponseKey.DISPLAY_NAME, "app_version", "version_code", "timezone", "access", "os", "os_version", "os_api", "device_model", "device_brand", "device_manufacturer", "language", "resolution", HardwareInfo.KEY_HW_DISPLAY_DENSITY, HardwareInfo.KEY_HW_DENSITY_DPI, Constants.OperatorKey.KEY_CARRIER, "mcc_mnc", "clientudid", "install_id", "device_id", "sig_hash", "aid", "push_sdk", "rom", "release_build", "update_version_code", "manifest_version_code", "app_version_minor", HardwareInfo.KEY_HW_CPU_ABI, "app_track", "not_request_sender", "rom_version", EffectConfiguration.KEY_REGION, "tz_name", "tz_offset", "sim_region", "custom", "google_aid", EffectConfiguration.KEY_APP_LANGUAGE, "app_region", "device_category", "ab_sdk_version", DyPayConstant.KEY_USER_UNIQUE_ID, "platform", "harmony_os_api", "harmony_os_version", "harmony_release_type", "cdid", "sys_region", "carrier_region", "timezone_offset", "timezone_name"};
        f408014q0 = 2000;
        f408015r0 = new Object();
        f408017t0 = new AtomicLong();
        f408018u0 = 0;
        f408019v0 = 0;
        f408020w0 = 0;
        f408021x0 = 0;
        f408022y0 = "";
        f408023z0 = new ArrayList(2);
        B0 = null;
        C0 = false;
        G0 = new ConcurrentHashMap();
        H0 = new Bundle();
        Locale r100 = Locale.US;
        J0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", r100);
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", r100).setTimeZone(TimeZone.getTimeZone("UTC+8"));
        new SimpleDateFormat("yyyy-MM-dd", r100);
        SimpleDateFormat r101 = new SimpleDateFormat("yyyy-MM-dd", r100);
        r101.setTimeZone(TimeZone.getTimeZone("UTC+8"));
        K0 = r101;
        L0 = new Object();
        M0 = new ThreadLocal();
        N0 = false;
        O0 = false;
        Q0 = 0;
        R0 = -1;
        S0 = false;
    }

    public static gx3.j e() {
        String r100 = String.valueOf(jta.g.c());
        String r101 = v();
        w();
        gx3.j r102 = new gx3.j(r100, r101);
        IBDAccountCallback r103 = T0;
        if (r103 == null) goto L10;
        Pair<Integer, Long> r104 = r103.getOdinUserInfo();
        if (((Long) r104.second).longValue() <= 0) goto L8;
        r102.f483102c = String.valueOf(r104.second);
        r102.f483103d = String.valueOf(r104.first);
    L11:
        return r102;
    L8:
        if (f408020w0 != 0) goto L11;
        r102.f483102c = String.valueOf(f408018u0);
        r102.f483103d = String.valueOf(f408019v0);
        goto L11
    L10:
        r102.f483102c = String.valueOf(f408017t0.get());
        goto L11
    }

    public static String getCurrentSessionId() {
        return f408004g0.getCurrentSessionId();
    }

    public static String n() {
        return f408004g0.w();
    }

    public static int p() {
        return T.get();
    }

    public static boolean q() {
        f r100 = A0;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.getEventV3Switch();
    }

    public static String r() {
        return f408004g0.getInstallId();
    }

    public static com.bytedance.applog.m s() {
        return f408004g0.h();
    }

    public static boolean t() {
        f r100 = A0;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.getEncryptSwitch();
    }

    public static boolean u() {
        f r100 = A0;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.getRecoverySwitch();
    }

    public static String v() {
        return f408004g0.getServerDeviceId();
    }

    public static String w() {
        f408004g0.D();
        return null;
    }

    public final void A() {
        if (f408011n0 == false) goto L19;
        ex3.c.a r100 = new ex3.c.a();
        r100.f474658a = String.valueOf(jta.g.c());
        r100.f474659b = jta.g.f500376j.getChannel(this.f408036l);
        r100.f474667j = "2.14.0";
        r100.f474668k = com.bytedance.bdinstall.n.d(this.f408036l);
        r100.f474669l = !com.bytedance.applog.log.m.b();
        r100.f474666i = false;
        eta.b r101 = D0;
        if (r101 == null) goto L7;
        r100.f474661d = r101.getAppName();
        r100.f474660c = D0.getVersion();
        r100.f474662e = D0.getUpdateVersionCode();
    L7:
        f r102 = A0;
        if (r102 == null) goto L10;
        r100.f474665h = r102.getRecoverySwitch();
    L10:
        ex3.e r103 = com.ss.android.common.applog.e.a();
        ex3.d.a r104 = new ex3.d.a();
        r104.f474678b = new ex3.c(r100);
        r104.f474679c = this.f408044t;
        r104.f474680d = new com.ss.android.common.applog.g();
        m0 r105 = f408013p0;
        if (r105 == null) goto L17;
        String[] r106 = r105.f408192a;
        if (r106 == null) goto L17;
        if (r106.length <= 0) goto L17;
        String r107 = r106[0];
    L18:
        r104.f474681e = r107;
        r104.f474677a = this.f408036l;
        r104.f474682f = qw3.a.f534987g.b(new Object[0]);
        r103.d(new ex3.d(r104));
        return;
    L17:
        r107 = null;
        goto L18
    L19:
        com.ss.android.common.applog.e.a().d(new ex3.d(new ex3.d.a()));
    }

    public final void G() {
        z r100 = this.f408042r;
        if (r100 != null) goto L5;
        return;
    L5:
        com.ss.android.common.applog.h r101 = com.ss.android.common.applog.h.d(this.f408036l);
        int r102 = 0;
        int r103 = this.f408049y.getAndSet(0);
        int r104 = this.f408050z.getAndSet(0);
        if (r100 != null) goto L8;
    L21:
        this.A.clear();
        return;
    L8:
        if (r100.f408240a <= 0) goto L21;
        if (r103 > 0) goto L12;
        if (r104 > 0) goto L12;
    L14:
        if (this.f408040p == true) goto L16;
        this.A.clear();
    L16:
        Iterator<h> r105 = this.A.iterator();
    L18:
        if (r105.hasNext() == false) goto L21;
        h r106 = r105.next();
        q r107 = new q();
        r107.f408202b = "image";
        r107.f408203c = "sample";
        r107.f408204d = r106.f408066a;
        r107.f408205e = r106.f408067b;
        r107.f408206f = r106.f408068c;
        r107.f408212l = r106.f408069d;
        r107.f408213m = r100.f408240a;
        r101.g(r107);
        r102 = r102 + 1;
        if (r102 < 5) goto L18;
    L12:
        q r108 = new q();
        r108.f408202b = "image";
        r108.f408203c = "stats";
        r108.f408205e = r103;
        r108.f408206f = r104;
        r108.f408212l = r100.f408246g;
        r108.f408213m = r100.f408240a;
        r101.g(r108);
        goto L14
    }

    public final void f() {
        z r100 = this.f408042r;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f408247h == true) goto L16;
        long r101 = System.currentTimeMillis();
        z r102 = this.f408042r;
        if (r102.f408249j == false) goto L10;
        return;
    L10:
        if ((r101 - r102.f408246g) < this.f408043s) goto L17;
        G();
        this.f408042r = null;
        w r103 = new w();
        r103.f408226a = r102;
        j(r103);
        return;
    L17:
        return;
    }

    public final void J() {
        long r100 = System.currentTimeMillis();
        if ((r100 - this.B) <= 60000) goto L12;
        this.B = r100;
        LinkedList<u> r101 = this.f408032h;
        monitor-enter(r101);
        this.f408032h.notify();     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean o() {
        return S0;
    }

    public AppLog(Context r100) {
        this.f408026b = false;
        this.f408027c = false;
        this.f408028d = 1;
        this.f408030f = false;
        this.f408031g = new LinkedList();
        this.f408032h = new LinkedList();
        this.f408033i = null;
        this.f408035k = 0;
        this.f408038n = false;
        this.f408039o = new HashSet();
        this.f408040p = false;
        this.f408041q = new AtomicBoolean();
        this.f408043s = 30000;
        this.f408044t = 60000;
        this.f408045u = 21600000;
        this.f408046v = 1;
        this.f408047w = 0;
        this.f408048x = null;
        this.f408049y = new AtomicInteger();
        this.f408050z = new AtomicInteger();
        this.A = new LinkedList();
        this.B = System.currentTimeMillis();
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = new ConcurrentHashMap();
        this.G = new ConcurrentHashMap();
        this.H = new ConcurrentHashMap();
        this.I = new AtomicLong();
        this.f408024J = new AtomicLong();
        Context r101 = r100.getApplicationContext();
        this.f408036l = r101;
        this.f408029e = new AppLogNetworkStatusMonitor(r101);
        this.f408037m = null;
    }

    public static void B(JSONObject r100) {
        boolean r101 = pta.d.h();
        if (r101 == false) goto L6;
        String r102 = "Harmony";
    L18:
        r100.put("platform", r102);     // Catch: JSONException -> L9
    L11:
        if (r101 == true) goto L20;
        return;
    L20:
        r100.put("harmony_os_api", i84.u.a("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L15
        r100.put("harmony_os_version", i84.u.a("hw_sc.build.platform.version"));     // Catch: Throwable -> L15
        r100.put("harmony_release_type", i84.u.a("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        ita.j.g("AppLog loadHarmonyInfo ", th);
        return;
    L9:
        e = move-exception;
        ita.j.c("AppLog loadHarmonyInfo ", e);
        goto L11
    L6:
        r102 = "Android";
        goto L18
    }

    public static void D(long r100) {
        List<g> r101 = f408023z0;
        if (r101 != null) goto L5;
        return;
    L5:
        monitor-enter(r101);
        Iterator r102 = ((ArrayList) r101).iterator();     // Catch: Throwable -> L12
    L8:
        if (r102.hasNext() == false) goto L10;
        ((g) r102.next()).a();     // Catch: Throwable -> L12
        goto L8
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void c(Context r100) {
        if (N0 == false) goto L5;
    L16:
        O0 = false;
        long r101 = System.currentTimeMillis();
        if ((r101 - Q0) >= 900000) goto L19;
        return;
    L19:
        if (NetworkUtils.isNetworkAvailable(r100) == false) goto L26;
        Q0 = r101;
        fta.a.b(r100, f408013p0.f408195d, P, Q);
        return;
    L26:
        return;
    L5:
        monitor-enter(AppLog.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (N0 == true) goto L11;
        O0 = true;     // Catch: Throwable -> L13
        monitor-exit(AppLog.class);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(AppLog.class);     // Catch: Throwable -> L13
        goto L16
    }

    public static boolean d(AppLog r110) {
        r110.getClass();
        Context r100 = r110.f408036l;     // Catch: Exception -> L9
        boolean r101 = r110.f408026b;     // Catch: Exception -> L9
        com.ss.android.common.applog.b r102 = new com.ss.android.common.applog.b();     // Catch: Exception -> L9
        boolean r103 = L;     // Catch: Exception -> L9
        boolean r104 = C0;     // Catch: Exception -> L9
        boolean r105 = P;     // Catch: Exception -> L9
        if (f408010m0 == true) goto L6;
        boolean r106 = true;
    L7:
        jta.f.a(r100, r101, r102, r103, r104, r105, r106);     // Catch: Exception -> L9
    L12:
        r110.f408030f = z(r110.f408037m, r110.f408036l);     // Catch: Exception -> L33
        r110.f408042r = com.ss.android.common.applog.h.d(r110.f408036l).f(0);     // Catch: Exception -> L33
        r110.A();     // Catch: Exception -> L33
        r110.C(r110.f408042r);     // Catch: Exception -> L33
        if (r110.f408042r == null) goto L42;
        ita.j.b("AppLog start with last session " + r110.f408042r.f408241b, null);     // Catch: Exception -> L33
        t r107 = new t();     // Catch: Exception -> L33
        r107.f408224a = r110.f408042r.f408240a;     // Catch: Exception -> L33
        r110.j(r107);     // Catch: Exception -> L33
    L42:
        Bundle r108 = new Bundle();     // Catch: Throwable -> L30
        Bundle r109 = H0;     // Catch: Throwable -> L30
        monitor-enter(r109);     // Catch: Throwable -> L30
        r108.putAll(r109);     // Catch: Throwable -> L27
        monitor-exit(r109);     // Catch: Throwable -> L27
    L20:
        if (r108.size() <= 0) goto L31;
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L30
        Iterator<String> r112 = r108.keySet().iterator();     // Catch: Throwable -> L30
    L23:
        if (r112.hasNext() == false) goto L25;
        String r113 = r112.next();     // Catch: Throwable -> L30
        r111.put(r113, r108.get(r113));     // Catch: Throwable -> L30
        goto L23
    L25:
        r110.f408037m.put("custom", r111);     // Catch: Throwable -> L30
    L31:
        r110.f408033i = new x(r110.f408036l, new JSONObject(r110.f408037m, com.ss.android.common.applog.f.f408122a), r110.f408032h, r110.f408041q, f408023z0, r110.f408042r, r110.F, r110.G);     // Catch: Exception -> L33
        x r114 = r110.f408033i;     // Catch: Exception -> L33
        long r115 = r110.f408044t;     // Catch: Exception -> L33
        r114.G = r115;     // Catch: Exception -> L33
        r114.F.set(r115);     // Catch: Exception -> L33
        r110.f408033i.H = r110.f408046v;     // Catch: Exception -> L33
        ThreadMethodProxy.start(r110.f408033i);     // Catch: Exception -> L33
        return true;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        com.ss.android.common.applog.e.a().b(StatsCountKeys.JSON_ERROR_COUNT, 1);     // Catch: Exception -> L33
        goto L31
    L6:
        r106 = false;
    L33:
        e = move-exception;
        if ((e instanceof SQLiteException) == false) goto L37;
        com.ss.android.common.applog.e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);
    L37:
        ita.j.c("failed to start LogReaper", e);
        return false;
    L9:
        e = move-exception;
        if (Logger.debug() == false) goto L12;
        throw e;     // Catch: Exception -> L33
    }

    public static String m(long r100) {
        return J0.format(new Date(r100));
    }

    public final void C(z r110) {
        this.A.clear();     // Catch: Exception -> L42
        int r100 = 0;
        SharedPreferences r101 = this.f408036l.getSharedPreferences(kta.b.f506097a, 0);     // Catch: Exception -> L42
        long r102 = r101.getLong("session_interval", 30000);     // Catch: Exception -> L42
        if (r102 >= 15000) goto L6;
    L8:
        this.f408044t = r101.getLong("batch_event_interval", 60000);     // Catch: Exception -> L42
        long r103 = R0;     // Catch: Exception -> L42
        if (g(r103) == true) goto L11;
    L13:
        this.f408046v = r101.getInt("send_launch_timely", 1);     // Catch: Exception -> L42
        this.f408045u = r101.getLong("fetch_interval", 21600000);     // Catch: Exception -> L42
        this.f408047w = r101.getInt("http_monitor_port", 0);     // Catch: Exception -> L42
        lta.h.f510726w = r101.getBoolean("device_register_throttle", false);     // Catch: Exception -> L42
        if (r110 != null) goto L16;
        return;
    L16:
        String r104 = r101.getString("stats_value", null);     // Catch: Exception -> L42
        if (StringUtils.isEmpty(r104) == false) goto L19;
        return;
    L19:
        JSONObject r105 = new JSONObject(r104);     // Catch: Exception -> L42
        String r106 = r105.optString("session_id", null);     // Catch: Exception -> L42
        if (r106 != null) goto L22;
        return;
    L22:
        if (r106.equals(r110.f408241b) == false) goto L49;
        int r111 = r105.optInt("cnt_success", 0);     // Catch: Exception -> L42
        int r107 = r105.optInt("cnt_failure", 0);     // Catch: Exception -> L42
        if (r111 <= 0) goto L27;
        this.f408049y.addAndGet(r111);     // Catch: Exception -> L42
    L27:
        if (r107 <= 0) goto L30;
        this.f408050z.addAndGet(r107);     // Catch: Exception -> L42
    L30:
        if (r105.isNull("samples") == false) goto L32;
        return;
    L32:
        JSONArray r112 = JSONObjectProtectorUtils.getJSONArray(r105, "samples");     // Catch: Exception -> L42
        int r108 = r112.length();     // Catch: Exception -> L42
        if (r108 <= 5) goto L35;
        r108 = 5;
    L35:
        if (r100 >= r108) goto L51;
        JSONObject r109 = JSONArrayProtectorUtils.getJSONObject(r112, r100);     // Catch: Exception -> L42
        String r113 = r109.optString("url", null);     // Catch: Exception -> L42
        int r114 = JSONObjectProtectorUtils.getInt(r109, "networktype");     // Catch: Exception -> L42
        long r115 = JSONObjectProtectorUtils.getLong(r109, "time");     // Catch: Exception -> L42
        long r116 = JSONObjectProtectorUtils.getLong(r109, "timestamp");     // Catch: Exception -> L42
        if (StringUtils.isEmpty(r113) == true) goto L40;
        h r117 = new h(r113, r114, r115, r116);     // Catch: Exception -> L42
        this.A.add(r117);     // Catch: Exception -> L42
    L40:
        r100 = r100 + 1;
        goto L35
    L51:
        return;
    L49:
        return;
    L11:
        if (this.f408044t == r103) goto L13;
        this.f408044t = r103;     // Catch: Exception -> L42
        goto L13
    L6:
        if (r102 > 300000) goto L8;
        this.f408043s = r102;     // Catch: Exception -> L42
    }

    public final void I(c r210) {
        if (W == false) goto L16;
        if (X == true) goto L16;
        ActionQueueType r100 = ActionQueueType.PAGE_START;
        ActionQueueType r101 = r210.f408056a;
        if (r100 != r101) goto L9;
        return;
    L9:
        if (ActionQueueType.PAGE_END != r101) goto L11;
        return;
    L11:
        if (ActionQueueType.EVENT != r101) goto L13;
        return;
    L13:
        if (ActionQueueType.SAVE_MISC_LOG != r101) goto L16;
        return;
    L16:
        if (this.f408030f == true) goto L18;
        return;
    L18:
        BlockHelper.tryBlock();
        char r102 = 0;
        boolean r103 = false;
        int r104 = 0;
        char r105 = 0;
        r102 = 0;
        r102 = 0;
        r102 = 0;
        r102 = 0;
        r102 = 0;
        r102 = 0;
        r102 = 0;
        r102 = 0;
        r102 = 0;
        boolean r106 = true;
        jta.n r107 = null;
        switch(b.f408055a[r210.f408056a.ordinal()]) {
            case 1: goto L248;
            case 2: goto L219;
            case 3: goto L213;
            case 4: goto L205;
            case 5: goto L199;
            case 6: goto L405;
            case 7: goto L192;
            case 8: goto L188;
            case 9: goto L405;
            case 10: goto L185;
            case 11: goto L164;
            case 12: goto L140;
            case 13: goto L125;
            case 14: goto L94;
            case 15: goto L57;
            case 16: goto L41;
            case 17: goto L39;
            case 18: goto L29;
            case 19: goto L22;
            default: goto L405;
        };
    L29:
        String r108 = (String) r210.f408057b;
        if (this.f408033i != null) goto L33;
        return;
    L33:
        if (TextUtils.isEmpty(r108) == false) goto L35;
        this.f408037m.remove(DyPayConstant.KEY_USER_UNIQUE_ID);     // Catch: Exception -> L332
    L36:
        this.f408033i.B(new JSONObject(this.f408037m, com.ss.android.common.applog.f.f408122a));     // Catch: Exception -> L332
        return;
    L35:
        this.f408037m.put(DyPayConstant.KEY_USER_UNIQUE_ID, r108);     // Catch: Exception -> L332
        goto L36
    L41:
        Object r109 = r210.f408057b;
        if ((r109 instanceof Pair) == false) goto L44;
        Pair r110 = (Pair) r109;
        r107 = (jta.n) r110.first;
        long r111 = ((Long) r110.second).longValue();
    L46:
        if (r210.f408058c > 0) goto L49;
        r106 = false;
    L49:
        fta.a.b(this.f408036l, f408013p0.f408195d, r106, false);
        jta.g r112 = jta.g.f500367a;
        if (jta.g.f500368b == false) goto L54;
        if (r112 == null) goto L54;
        jta.g.f500376j.m(r106, r111, r107);
    L55:
        N(this.f408036l, r106);
        return;
    L54:
        jta.g.f500376j.c(r106);
        goto L55
    L44:
        r111 = 0;
        goto L46
    L94:
        Object r113 = r210.f408057b;
        if ((r113 instanceof JSONObject) == false) goto L372;
        JSONObject r114 = (JSONObject) r113;
        String r115 = r114.optString(EffectConfiguration.KEY_APP_LANGUAGE, null);
        String r116 = r114.optString("app_region", null);
        if (StringUtils.isEmpty(r115) == false) goto L337;
    L107:
        boolean r117 = false;
    L108:
        if (r117 == false) goto L110;
    L122:
        r105 = 1;
    L123:
        if (r105 == 0) goto L373;
        jta.g.f500376j.g();
        ita.j.b("AppLog updateDeviceInfo call device_register", null);
        return;
    L373:
        return;
    L110:
        if (StringUtils.isEmpty(r116) == false) goto L339;
    L120:
        boolean r118 = false;
    L121:
        if (r118 == false) goto L123;
    L339:
        if (r116.equals(this.f408037m.optString("app_region", null)) == true) goto L120;
        this.f408037m.put("app_region", r116);     // Catch: Throwable -> L119
        if (this.f408033i == null) goto L117;
        this.f408033i.B(new JSONObject(this.f408037m, com.ss.android.common.applog.f.f408122a));     // Catch: Throwable -> L119
    L117:
        this.f408036l.getSharedPreferences(kta.b.f506097a, 0).edit().putString("app_region", r116).commit();     // Catch: Throwable -> L119
        r118 = true;
        goto L121
    L337:
        if (r115.equals(this.f408037m.optString(EffectConfiguration.KEY_APP_LANGUAGE, null)) == true) goto L107;
        this.f408037m.put(EffectConfiguration.KEY_APP_LANGUAGE, r115);     // Catch: Throwable -> L106
        if (this.f408033i == null) goto L104;
        this.f408033i.B(new JSONObject(this.f408037m, com.ss.android.common.applog.f.f408122a));     // Catch: Throwable -> L106
    L104:
        this.f408036l.getSharedPreferences(kta.b.f506097a, 0).edit().putString(EffectConfiguration.KEY_APP_LANGUAGE, r115).commit();     // Catch: Throwable -> L106
        r117 = true;
        goto L108
    L372:
        return;
    L125:
        Object r119 = r210.f408057b;
        if ((r119 instanceof String) == false) goto L375;
        String r120 = (String) r119;
        if (StringUtils.isEmpty(r120) == false) goto L131;
        return;
    L131:
        if (this.f408033i != null) goto L133;
        return;
    L133:
        if (r120.equals(this.f408037m.optString("google_aid", null)) == false) goto L135;
        return;
    L135:
        if (P == true) goto L139;
        this.f408037m.put("google_aid", r120);
        if (this.f408033i == null) goto L139;
        this.f408033i.B(new JSONObject(this.f408037m, com.ss.android.common.applog.f.f408122a));
    L139:
        this.f408036l.getSharedPreferences(kta.b.f506097a, 0).edit().putString("google_aid", r120).commit();
        return;
    L375:
        return;
    L140:
        Object r121 = r210.f408057b;
        if ((r121 instanceof JSONObject) == false) goto L379;
        JSONObject r122 = (JSONObject) r121;
        Objects.toString(r122);
        if (r122 == null) goto L409;
        boolean r123 = f408004g0.y(this.f408037m.optString("device_id", null));
        String r124 = r122.optString("device_id", null);
        String r125 = r122.optString("install_id", null);
        if (StringUtils.isEmpty(r124) == true) goto L152;
        this.f408037m.put("device_id", r124);     // Catch: JSONException -> L149
    L149:
        e = move-exception;
        e.printStackTrace();
    L152:
        if (StringUtils.isEmpty(r125) == true) goto L158;
        this.f408037m.put("install_id", r125);     // Catch: JSONException -> L155
    L155:
        e = move-exception;
        e.printStackTrace();
    L158:
        if (this.f408033i != null) goto L355;
    L163:
        k();
        L(true, true, r123);
        return;
    L355:
        this.f408033i.B(new JSONObject(this.f408037m, com.ss.android.common.applog.f.f408122a));     // Catch: JSONException -> L161
    L161:
        e = move-exception;
        e.printStackTrace();
        goto L163
    L409:
        return;
    L379:
        return;
    L164:
        Object r126 = r210.f408057b;
        if ((r126 instanceof Bundle) == false) goto L381;
        Bundle r127 = (Bundle) r126;
        if (r127 != null) goto L169;
        return;
    L169:
        if (r127.size() > 0) goto L172;
        return;
    L172:
        if (this.f408033i == null) goto L383;
        JSONObject r128 = this.f408037m.optJSONObject("custom");     // Catch: Exception -> L332
        if (r128 != null) goto L176;
        r128 = new JSONObject();     // Catch: Exception -> L332
    L176:
        Iterator<String> r129 = r127.keySet().iterator();     // Catch: Exception -> L332
    L178:
        if (r129.hasNext() == false) goto L180;
        String r130 = r129.next();     // Catch: Exception -> L332
        r128.put(r130, r127.get(r130));     // Catch: Exception -> L332
        goto L178
    L180:
        this.f408037m.put("custom", r128);     // Catch: Exception -> L332
        if (this.f408033i == null) goto L183;
        this.f408033i.B(new JSONObject(this.f408037m, com.ss.android.common.applog.f.f408122a));     // Catch: Exception -> L332
    L183:
        k();     // Catch: Exception -> L332
        return;
    L383:
        return;
    L381:
        return;
    L185:
        long r131 = r210.f408058c;
        if (r131 <= 0) goto L384;
        SharedPreferences.Editor r132 = this.f408036l.getSharedPreferences(kta.b.f506097a, 0).edit();
        r132.putLong("dns_report_time", r131);
        r132.commit();
        return;
    L384:
        return;
    L188:
        Object r133 = r210.f408057b;
        if ((r133 instanceof String) == false) goto L386;
        jta.g.f500376j.j(this.f408036l, (String) r133);
        return;
    L386:
        return;
    L199:
        Object r134 = r210.f408057b;
        if ((r134 instanceof h) == false) goto L390;
        h r135 = (h) r134;
        if (this.A.size() < 5) goto L204;
        this.A.removeFirst();
    L204:
        this.A.add(r135);
        return;
    L390:
        return;
    L205:
        long r136 = r210.f408058c;
        z r137 = this.f408042r;
        if (r137 != null) goto L208;
        String r138 = "";
    L209:
        gta.e r139 = gta.e.c(this.f408036l);
        r139.getClass();
        k0.d().b(new gta.f(r139, r136, r138));
        Object r140 = r210.f408057b;
        if ((r140 instanceof s) == false) goto L212;
        y((s) r140, r210.f408058c);
    L212:
        J();
        return;
    L208:
        r138 = r137.f408241b;
        goto L209
    L213:
        K(r210.f408058c, false);
        long r141 = r210.f408058c;
        z r142 = this.f408042r;
        if (r142 != null) goto L216;
        String r143 = "";
    L217:
        gta.e r144 = gta.e.c(this.f408036l);
        r144.getClass();
        k0.d().b(new gta.d(r144, r141, r143));
        J();
        return;
    L216:
        r143 = r142.f408241b;
        goto L217
    L248:
        Object r145 = r210.f408057b;
        if ((r145 instanceof q) == false) goto L402;
        q r146 = (q) r145;
        if (R == null) goto L253;
        m r147 = R;
        String r148 = r146.f408202b;
        String r149 = r146.f408203c;
        String r150 = r146.f408204d;
        long r151 = r146.f408205e;
        long r152 = r146.f408206f;
        boolean r153 = r146.f408215o;
        String r154 = r146.f408214n;
        ((e57.c) r147).getClass();
        PitayaProxy.a(r148, r149, r150, r151, r152, r153, r154);
    L253:
        K(r146.f408212l, true);
        if (this.f408042r != null) goto L257;
        a0.a(1, 4, null);
        return;
    L257:
        if ("event_v3".equalsIgnoreCase(r146.f408202b) == false) goto L259;
        r146.f408217q = this.I.getAndIncrement();
    L260:
        r146.f408213m = this.f408042r.f408240a;
        long r155 = System.currentTimeMillis();     // Catch: Throwable -> L307
        if (r146.f408216p == true) goto L308;
        if ((r155 - this.K) < 900000) goto L308;
        if ("event_v3".equalsIgnoreCase(r146.f408202b) == false) goto L308;
        ConcurrentHashMap<String, String> r156 = this.H;     // Catch: Throwable -> L307
        if (r156 == null) goto L308;
        if (r156.size() <= 0) goto L308;
        if (StringUtils.isEmpty(r146.f408203c) == true) goto L308;
        if (this.H.containsKey(r146.f408203c) == false) goto L308;
        if (StringUtils.isEmpty(r146.f408214n) == true) goto L308;
        JSONObject r157 = new JSONObject(r146.f408214n);     // Catch: Throwable -> L307
        if (r157.optInt("_event_v3", 0) != 1) goto L308;
        com.ss.android.common.applog.e.a().b(StatsCountKeys.REALTIME_EVENT_COUNT, 1);     // Catch: Throwable -> L307
        if (com.bytedance.applog.log.m.b() == true) goto L291;
        long r158 = r146.f408201a;     // Catch: Throwable -> L307
        if (r158 > 0) goto L288;
        r158 = 0;
    L288:
        if (r158 <= 0) goto L291;
        com.bytedance.applog.log.m.c("event_realtime_eid", new ita.f(r158));     // Catch: Throwable -> L307
    L291:
        JSONObject r159 = new JSONObject();     // Catch: Throwable -> L307
        JSONObject r160 = new JSONObject();     // Catch: Throwable -> L307
        if (r157.has("nt") == false) goto L294;
        r160.put("nt", r157.optInt("nt"));     // Catch: Throwable -> L307
    L294:
        long r161 = r146.f408208h;     // Catch: Throwable -> L307
        if (r161 <= 0) goto L297;
        r160.put("user_id", r161);     // Catch: Throwable -> L307
        r160.put("user_is_login", r146.f408210j);     // Catch: Throwable -> L307
        r160.put("user_type", r146.f408207g);     // Catch: Throwable -> L307
        r160.put("user_is_auth", r146.f408211k);     // Catch: Throwable -> L307
    L297:
        r157.remove("nt");     // Catch: Throwable -> L307
        r157.remove("_event_v3");     // Catch: Throwable -> L307
        r160.put("event", r146.f408203c);     // Catch: Throwable -> L307
        r160.put("params", r157);     // Catch: Throwable -> L307
        r160.put("session_id", Long.valueOf(r146.f408213m));     // Catch: Throwable -> L307
        r160.put(SheetInputData.InputData.DateType.DATETIME, m(r146.f408212l));     // Catch: Throwable -> L307
        r160.put("local_time_ms", r146.f408212l);     // Catch: Throwable -> L307
        JSONArray r162 = new JSONArray();     // Catch: Throwable -> L307
        r162.put(r160);     // Catch: Throwable -> L307
        r159.put("event_v3", r162);     // Catch: Throwable -> L307
        Object r163 = this.f408048x;     // Catch: Throwable -> L307
        if (r163 == null) goto L300;
        r159.put("time_sync", r163);     // Catch: Throwable -> L307
    L300:
        r159.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L307
        Context r164 = this.f408036l;     // Catch: Throwable -> L307
        JSONObject r165 = this.f408037m;     // Catch: Throwable -> L307
        String[] r166 = com.ss.android.common.applog.f.f408122a;     // Catch: Throwable -> L307
        String r167 = com.ss.android.common.applog.f.a(kta.n.c(r164));     // Catch: Throwable -> L307
        if (TextUtils.isEmpty(r167) == false) goto L345;
    L305:
        r165.optString("device_id");     // Catch: Throwable -> L307
        r159.put("header", r165);     // Catch: Throwable -> L307
        r159.put("_gen_time", System.currentTimeMillis());     // Catch: Throwable -> L307
        new com.ss.android.common.applog.a(this, r159.toString(), r146).start();     // Catch: Throwable -> L307
        r102 = 1;
        goto L308
    L345:
        JSONObject r168 = new JSONObject(r165, com.ss.android.common.applog.f.f408122a);     // Catch: JSONException -> L331 Throwable -> L307
        r168.put("oaid", r167);     // Catch: JSONException -> L330 Throwable -> L307
    L304:
        r165 = r168;
    L308:
        if (r102 != 0) goto L414;
        long r169 = com.ss.android.common.applog.h.d(this.f408036l).g(r146);
        if (r169 <= 0) goto L327;
        String r170 = r146.f408202b;
        if ("event_v3".equalsIgnoreCase(r170) == false) goto L316;
        r170 = "EVENT_V3";
    L316:
        if (com.bytedance.applog.log.m.b() == true) goto L326;
        long r171 = r146.f408201a;
        if (r171 > 0) goto L323;
        r171 = 0;
    L323:
        if (r171 <= 0) goto L326;
        com.bytedance.applog.log.m.c("event_save_db", new ita.a(r170, r171, r146));
    L326:
        J();
    L327:
        if (r169 >= 0) goto L404;
        com.ss.android.common.applog.e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);
        return;
    L404:
        return;
    L414:
        return;
    L259:
        r146.f408217q = this.f408024J.getAndIncrement();
        goto L260
    L402:
        return;
    L405:
        return;
    L22:
        if (this.f408033i != null) goto L24;
        return;
    L24:
        if (ThreadMethodProxy.isAlive(this.f408033i) == true) goto L365;
        ThreadMethodProxy.start(this.f408033i);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        ita.j.c("AppLog delay start LogReaper", th);
        return;
    L365:
        return;
    L39:
        if (this.f408042r == null) goto L368;
        w r172 = new w();
        r172.f408226a = this.f408042r;
        r172.f408230e = true;
        j(r172);
        return;
    L368:
        return;
    L57:
        if (r210.f408058c <= 0) goto L59;
        boolean r173 = true;
    L60:
        jta.g r174 = jta.g.f500367a;
        if (jta.g.f500368b == false) goto L65;
        if (r174 == null) goto L65;
        jta.g.f500376j.k(r173);
    L66:
        if (r173 == false) goto L68;
        this.f408037m.remove("openudid");
        this.f408037m.remove("google_aid");
        this.f408037m.remove("device_id");
        this.f408037m.remove("install_id");
    L68:
        N(this.f408036l, r173);
        com.ss.android.common.applog.h r175 = com.ss.android.common.applog.h.d(this.f408036l);
        monitor-enter(r175);
        SQLiteDatabase r176 = r175.f408134a;     // Catch: Throwable -> L91
        if (r176 != null) goto L73;
    L85:
        ita.j.g("AppLogdb not establish and open", null);     // Catch: Throwable -> L91
        monitor-exit(r175);
    L87:
        z r177 = this.f408042r;
        if (r177 == null) goto L90;
        r106 = r177.f408247h;
    L90:
        this.f408042r = null;
        K(System.currentTimeMillis(), r106);
        return;
    L73:
        if (r176.isOpen() == false) goto L85;
        String[] r178 = com.ss.android.common.applog.h.f408126f;     // Catch: Throwable -> L91
        int r179 = r178.length;     // Catch: Throwable -> L91
    L76:
        if (r104 >= r179) goto L83;
        String r180 = r178[r104];     // Catch: Throwable -> L91
        r175.f408134a.delete(r180, null, null);     // Catch: Throwable -> L80
    L82:
        r104 = r104 + 1;
    L80:
        th = move-exception;
        com.ss.android.common.applog.e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);     // Catch: Throwable -> L91
        ita.j.g("AppLogdelete table failed, " + r180, th);     // Catch: Throwable -> L91
        goto L82
    L83:
        monitor-exit(r175);
    L91:
        th = move-exception;
        throw th;
    L65:
        jta.g.f500376j.c(r173);
        goto L66
    L59:
        r173 = false;
        goto L60
    L192:
        if ((r210.f408057b instanceof JSONObject) == true) goto L335;
        return;
    L335:
        r103 = Boolean.valueOf(r210.f408059d).booleanValue();     // Catch: Exception -> L196
    L198:
        x((JSONObject) r210.f408057b, r103);
        return;
    L196:
        e = move-exception;
        e.printStackTrace();
        goto L198
    L219:
        if (StringUtils.isEmpty(r210.f408059d) == true) goto L394;
        Object r181 = r210.f408057b;
        if ((r181 instanceof JSONObject) == false) goto L395;
        JSONObject r182 = (JSONObject) r181;
        String r183 = r210.f408059d;
        z r184 = this.f408042r;
        if (r184 == null) goto L225;
        long r185 = r184.f408240a;
    L227:
        if (this.f408030f == true) goto L229;
        return;
    L229:
        if (r185 > 0) goto L231;
        return;
    L231:
        if (StringUtils.isEmpty(r183) == true) goto L398;
        if (r182 == null) goto L399;
        String r186 = r182.toString();
        long r187 = com.ss.android.common.applog.h.d(this.f408036l).j(r185, r183, r186, r182.optLong("event_id"));
        if (r186 == null) goto L239;
        if (r186.length() <= 50000) goto L239;
        a0.a(5, 0, new Object[]{"misc", r183, "", Integer.valueOf(r186.length())});
    L239:
        if (r187 >= 0) goto L242;
        com.ss.android.common.applog.e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);
        return;
    L242:
        if (com.bytedance.applog.log.m.b() == true) goto L412;
        long r188 = r182.optLong("event_id", 0);
        if (r188 <= 0) goto L413;
        com.bytedance.applog.log.m.c("event_save_db", new ita.b(r182, r188, r183));
        return;
    L413:
        return;
    L412:
        return;
    L399:
        return;
    L398:
        return;
    L225:
        r185 = 0;
        goto L227
    L395:
        return;
    L394:
        return;
    }

    public final void i(c r100) {
        LinkedList<c> r101 = this.f408031g;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.f408031g.size() < f408014q0) goto L14;
        c r102 = this.f408031g.poll();     // Catch: Throwable -> L17
        if (r102 == null) goto L14;
        int r103 = b.f408055a[r102.f408056a.ordinal()];     // Catch: Throwable -> L17
        if (r103 != 1) goto L11;
    L13:
        com.ss.android.common.applog.e.a().b(StatsCountKeys.CACHE_DROP_EVENT_COUNT, 1);     // Catch: Throwable -> L17
        goto L14
    L11:
        if (r103 == 2) goto L13;
    L14:
        this.f408031g.add(r100);     // Catch: Throwable -> L17
        this.f408031g.notify();     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
    }

    public final void j(u r100) {
        this.B = System.currentTimeMillis();
        LinkedList<u> r101 = this.f408032h;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f408032h.size() < f408014q0) goto L9;
        u r102 = this.f408032h.poll();     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        ita.j.c("log queue poll out: " + r102, null);     // Catch: Throwable -> L12
    L9:
        this.f408032h.add(r100);     // Catch: Throwable -> L12
        this.f408032h.notify();     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
    }

    public AppLog(Context r110, int r111) {
        boolean r112 = false;
        this.f408026b = false;
        this.f408027c = false;
        this.f408028d = 1;
        this.f408030f = false;
        this.f408031g = new LinkedList();
        this.f408032h = new LinkedList();
        this.f408033i = null;
        this.f408035k = 0;
        this.f408038n = false;
        HashSet<Integer> r100 = new HashSet();
        this.f408039o = r100;
        this.f408040p = false;
        this.f408041q = new AtomicBoolean();
        this.f408043s = 30000;
        this.f408044t = 60000;
        this.f408045u = 21600000;
        this.f408046v = 1;
        this.f408047w = 0;
        this.f408048x = null;
        this.f408049y = new AtomicInteger();
        this.f408050z = new AtomicInteger();
        this.A = new LinkedList();
        this.B = System.currentTimeMillis();
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = new ConcurrentHashMap();
        this.G = new ConcurrentHashMap();
        this.H = new ConcurrentHashMap();
        this.I = new AtomicLong();
        this.f408024J = new AtomicLong();
        jta.g.f500376j.A();
        Context r113 = r110.getApplicationContext();
        this.f408036l = r113;
        jta.g.f500369c = r113.getApplicationContext();
        this.f408037m = new JSONObject();
        eta.b r101 = D0;     // Catch: Exception -> L39
        if (r101 == null) goto L6;
        this.f408028d = r101.getVersionCode();     // Catch: Exception -> L39
    L6:
        long r102 = System.currentTimeMillis();     // Catch: Exception -> L39
        SharedPreferences r114 = r113.getSharedPreferences(kta.b.f506097a, 0);     // Catch: Exception -> L39
        int r103 = r114.getInt("app_log_last_config_version", 0);     // Catch: Exception -> L39
        this.f408025a = r103;     // Catch: Exception -> L39
        if (r103 != this.f408028d) goto L48;
        long r104 = r114.getLong("app_log_last_config_time", 0);     // Catch: Exception -> L39
        if (r104 > r102) goto L12;
        r102 = r104;
    L12:
        this.C = r102;     // Catch: Exception -> L39
    L48:
        String r105 = r114.getString("allow_push_list", null);     // Catch: Exception -> L23
        if (r105 == null) goto L25;
        Object r106 = f408015r0;     // Catch: Exception -> L23
        monitor-enter(r106);     // Catch: Exception -> L23
        H(r100, new JSONArray(r105));     // Catch: Throwable -> L20
        monitor-exit(r106);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Exception -> L23
    L25:
        this.f408040p = r114.getBoolean("allow_old_image_sample", false);     // Catch: Exception -> L39
        String r115 = r114.getString("real_time_events", null);     // Catch: Throwable -> L36
        if (StringUtils.isEmpty(r115) == true) goto L40;
        JSONArray r107 = new JSONArray(r115);     // Catch: Throwable -> L36
        if (r107.length() <= 0) goto L40;
        int r116 = r107.length();     // Catch: Throwable -> L36
        int r108 = 0;
    L31:
        if (r108 >= r116) goto L40;
        String r109 = JSONArrayProtectorUtils.getString(r107, r108);     // Catch: Throwable -> L36
        if (StringUtils.isEmpty(r109) == true) goto L35;
        this.H.put(r109, "timely");     // Catch: Throwable -> L36
    L35:
        r108 = r108 + 1;
    L36:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L39
    L23:
        e = move-exception;
        ita.j.c("AppLog load allow_push_list exception: ", e);     // Catch: Exception -> L39
    L40:
        this.I.set(0);
        this.f408024J.set(0);
        if (this.f408036l.getSharedPreferences(kta.b.f506097a, 0).getInt("forbid_report_phone_detail_info", 0) <= 0) goto L43;
        r112 = true;
    L43:
        this.f408026b = r112;
        if (p() <= 0) goto L46;
        U = gx3.d.c(this.f408036l, null);
    L46:
        this.f408030f = true;
        ThreadMethodProxy.start(new d(this));
        this.f408029e = new AppLogNetworkStatusMonitor(this.f408036l);
        com.bytedance.applog.log.m.e(String.valueOf(jta.g.c()));
    }

    public static void H(HashSet r100, JSONArray r101) throws JSONException {
        if (r100 == null) goto L9;
        r100.clear();
        int r102 = r101.length();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L13;
        int r104 = JSONArrayProtectorUtils.getInt(r101, r103);
        if (r104 <= 0) goto L8;
        r100.add(Integer.valueOf(r104));
    L8:
        r103 = r103 + 1;
        goto L4
    L13:
        return;
    }

    public static boolean b(AppLog r210, String r211) {
        r210.getClass();
        ita.j.b("AppLog app_log_config: " + r211, null);     // Catch: Throwable -> L32
        byte[] r100 = r211.getBytes("UTF-8");     // Catch: Throwable -> L32
        String[] r101 = f408013p0.f408194c;     // Catch: Throwable -> L32
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.length == 0) goto L49;
        int r110 = r101.length;     // Catch: Throwable -> L32
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L51;
        String r102 = d0.e(c0.b(r101[r111], true), d0.f408094c);     // Catch: Throwable -> L32
        byte[] r112 = (byte[]) r100.clone();     // Catch: Throwable -> L32
        ConcurrentHashMap<String, String> r113 = G0;     // Catch: Throwable -> L32
        com.ss.android.common.applog.e.a().b(StatsCountKeys.REPORT_REQUEST_COUNT, 1);     // Catch: Throwable -> L32
        if (r210.f408036l != null) goto L12;
    L16:
        String r103 = c0.e(s(), r102, r100, true, "application/octet-stream;tt-data=b", r113, false, true);     // Catch: Throwable -> L32
    L17:
        if (r103 != null) goto L19;
    L30:
        com.ss.android.common.applog.e.a().b(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT, 1);     // Catch: Throwable -> L32
        com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L32
        r111 = r111 + 1;
        goto L8
    L19:
        if (r103.length() == 0) goto L30;
        JSONObject r104 = new JSONObject(r103);     // Catch: Throwable -> L32
        if ("ss_app_log".equals(r104.optString("magic_tag")) == true) goto L24;
    L26:
        boolean r105 = false;
    L27:
        if (r105 == true) goto L50;
        com.ss.android.common.applog.e.a().b(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT, 1);     // Catch: Throwable -> L32
    L50:
        return r105;
    L24:
        if ("success".equals(r104.optString("message")) == false) goto L26;
        r105 = true;
        goto L27
    L12:
        if (t() == false) goto L16;
        r103 = c0.h(s(), r102, r112, r210.f408036l, false, null, r113, false, true);     // Catch: RuntimeException -> L15 Throwable -> L32
    L15:
        com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L32
        r103 = c0.e(s(), r102, r100, true, "application/octet-stream;tt-data=b", r113, false, true);     // Catch: Throwable -> L32
        goto L17
    L51:
        return false;
    L49:
        return false;
    L32:
        th = move-exception;
        com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);
        if ((th instanceof CommonHttpException) == false) goto L40;
        int r106 = th.getResponseCode();
        if (r106 < 500) goto L40;
        if (r106 >= 600) goto L40;
        r210.K = System.currentTimeMillis();
    L40:
        ita.j.c("AppLog updateConfig exception: ", th);
        return false;
    }

    public static void h(Context r100, String r101) {
        jta.g r102 = jta.g.f500367a;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (TextUtils.equals(r101, "local_test") == true) goto L7;
        return;
    L7:
        monitor-enter(jta.k.class);     // Catch: Exception -> L18
    L15:
        th = move-exception;
        throw th;     // Catch: Exception -> L18
    L9:
        if (ota.b.a(jta.k.class) != null) goto L13;
        jta.k r103 = (jta.k) jta.g.a().getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r100});     // Catch: Throwable -> L15
        ConcurrentHashMap<Class, Object> r104 = ota.b.f526696a;     // Catch: Throwable -> L15
        if (r104.containsKey(jta.k.class) == true) goto L13;
        r104.put(jta.k.class, r103);     // Catch: Throwable -> L15
    L13:
        monitor-exit(jta.k.class);     // Catch: Throwable -> L15
    }

    public static String[] l(JSONObject r100, boolean r101) {
        String[] r102 = null;
        if (r101 == true) goto L32;
        boolean r103 = false;
    L23:
        if (r103 == true) goto L25;
    L31:
        return r102;
    L25:
        if (t() == false) goto L31;
        r102 = nta.d.c();     // Catch: JSONException -> L20
        if (nta.d.d(r102) == false) goto L31;
        r100.put("key", r102[0]);     // Catch: JSONException -> L20
        r100.put(CJPayFingerprintSharedPrefUtils.KEY_IV, r102[1]);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        ita.j.c("AppLog fillKeyIvForEncryptResp", e);
        goto L31
    L32:
        if (S0 == false) goto L7;
        r100.put("uid_enable", 1);     // Catch: JSONException -> L20
        r103 = true;
    L9:
        if (p() <= 0) goto L23;
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L20
        r104.put("capability", p());     // Catch: JSONException -> L20
        gx3.c r105 = U;     // Catch: JSONException -> L20
        if (r105 != null) goto L13;
    L16:
        JSONObject r106 = r100.optJSONObject("options");     // Catch: JSONException -> L20
        if (r106 != null) goto L19;
        r106 = new JSONObject();     // Catch: JSONException -> L20
    L19:
        r106.put("event_sampling", r104);     // Catch: JSONException -> L20
        r100.put("options", r106);     // Catch: JSONException -> L20
        goto L23
    L13:
        if (r105.f483096b != p()) goto L15;
        r104.put("version", r105.f483095a);     // Catch: JSONException -> L20
    L15:
        r104.put("config_ids", r105.f483098d);     // Catch: JSONException -> L20
        goto L16
    L7:
        r103 = false;
        goto L9
    }

    public static boolean z(JSONObject r100, Context r101) {
        JSONArray r102 = new JSONArray();     // Catch: Exception -> L23
        if (f408005h0 == false) goto L6;
        r102.put(1);     // Catch: Exception -> L23
    L6:
        if (f408006i0 == false) goto L9;
        r102.put(2);     // Catch: Exception -> L23
    L9:
        if (f408007j0 == false) goto L12;
        r102.put(7);     // Catch: Exception -> L23
    L12:
        if (f408008k0 == false) goto L15;
        r102.put(8);     // Catch: Exception -> L23
    L15:
        if (f408009l0 == false) goto L17;
        r102.put(9);     // Catch: Exception -> L23
    L17:
        r100.put("push_sdk", r102);     // Catch: Exception -> L23
        w();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(null) == true) goto L20;
        r100.put(DyPayConstant.KEY_USER_UNIQUE_ID, null);     // Catch: Exception -> L23
    L20:
        B(r100);     // Catch: Exception -> L23
    L21:
        boolean r103 = P;
        return jta.g.f500376j.f(r101, r100, r103);
    }

    public final void K(long r110, boolean r111) {
        com.ss.android.common.applog.h r100 = com.ss.android.common.applog.h.d(this.f408036l);
        z r101 = this.f408042r;
        if (r101 != null) goto L5;
    L13:
        boolean r102 = true;
    L14:
        if (r102 == true) goto L18;
        if (r111 == true) goto L63;
        r101.f408249j = true;
        r101.f408246g = r110;
        return;
    L63:
        return;
    L18:
        G();
        z r103 = this.f408042r;
        z r104 = new z();
        r104.f408241b = UUID.randomUUID().toString();
        r104.f408242c = r110;
        AppLog r105 = f408016s0;
        if (r105 == null) goto L21;
        r105.I.set(0);
        r105.f408024J.set(0);
    L21:
        r104.f408243d = this.I.getAndIncrement();
        r104.f408246g = r104.f408242c;
        if (TextUtils.isEmpty(kta.u.f506139c) == false) goto L26;
        eta.b r106 = kta.u.f506138b;
        if (r106 == null) goto L26;
        kta.u.f506139c = r106.getVersion();
    L26:
        r104.f408244e = kta.u.f506139c;
        r104.f408245f = kta.u.e();
        r104.f408247h = r111;
        if (r111 == true) goto L29;
        r104.f408249j = true;
    L29:
        monitor-enter(r100);
        SQLiteDatabase r107 = r100.f408134a;     // Catch: Throwable -> L59
        if (r107 != null) goto L33;
    L38:
        ita.j.g("AppLog db not establish and open", null);     // Catch: Throwable -> L59
        monitor-exit(r100);
        long r108 = -1;
    L42:
        if (r108 <= 0) goto L44;
        r104.f408240a = r108;
        this.f408042r = r104;
        ita.j.e("AppLog start new session " + r104.f408241b);
        D(r108);
    L45:
        if (r103 == null) goto L47;
    L48:
        w r109 = new w();
        r109.f408226a = r103;
        if (P0 > 0) goto L51;
        P0 = 6;
    L51:
        z r112 = this.f408042r;
        if (r112 != null) goto L54;
    L56:
        j(r109);
    L57:
        p.b().a(String.valueOf(r108), r110, r111);
        return;
    L54:
        if (r112.f408247h == true) goto L56;
        r109.f408227b = r112;
        goto L56
    L47:
        if (this.f408042r == null) goto L57;
    L44:
        this.f408042r = null;
        goto L45
    L33:
        if (r107.isOpen() == false) goto L38;
        boolean r113 = r104.f408247h;     // Catch: Throwable -> L59
        ContentValues r114 = new ContentValues();     // Catch: Throwable -> L59
        r114.put("value", r104.f408241b);     // Catch: Throwable -> L59
        r114.put("timestamp", Long.valueOf(r104.f408242c));     // Catch: Throwable -> L59
        r114.put("duration", 0);     // Catch: Throwable -> L59
        r114.put("non_page", Integer.valueOf(r113 ? 1 : 0));     // Catch: Throwable -> L59
        r114.put("app_version", r104.f408244e);     // Catch: Throwable -> L59
        r114.put("version_code", Integer.valueOf(r104.f408245f));     // Catch: Throwable -> L59
        r114.put("event_index", Long.valueOf(r104.f408243d));     // Catch: Throwable -> L59
        r108 = r100.f408134a.insert(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, null, r114);     // Catch: Throwable -> L59
        monitor-exit(r100);
    L59:
        th = move-exception;
        throw th;
    L5:
        if (r101.f408249j == true) goto L9;
        if ((r110 - r101.f408246g) >= this.f408043s) goto L13;
    L9:
        if (r101.f408247h == false) goto L12;
        if (r111 == false) goto L13;
    L12:
        r102 = false;
        goto L14
    }

    public final void M(String r210, boolean r211) {
        M0.set(Boolean.TRUE);
        boolean r100 = true;
        JSONObject r101 = new JSONObject(r210);     // Catch: Throwable -> L60
        String[] r110 = l(r101, false);     // Catch: Throwable -> L60
        String r102 = r101.toString();     // Catch: Throwable -> L60
        ita.j.b("AppLog app_log_config: " + r102, null);     // Catch: Throwable -> L60
        byte[] r103 = r102.getBytes("UTF-8");     // Catch: Throwable -> L60
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L60
        if ((r104 - F0) >= 600000) goto L6;
        boolean r111 = true;
    L7:
        F0 = r104;     // Catch: Throwable -> L60
        com.ss.android.common.applog.e.a().b(StatsCountKeys.CONFIG_REQUEST_COUNT, 1);     // Catch: Throwable -> L60
        boolean r105 = false;
        int r112 = 0;
    L9:
        if (r112 >= 2) goto L49;
        byte[] r106 = (byte[]) r103.clone();     // Catch: Throwable -> L60
        m0 r107 = f408013p0;     // Catch: Throwable -> L60
        String r108 = r107.f408193b;     // Catch: Throwable -> L60
        if (r105 == false) goto L13;
        r108 = r107.f408198g;     // Catch: Throwable -> L60
    L13:
        String r109 = d0.e(c0.b(r108, true), d0.f408093b);     // Catch: Throwable -> L60
    L35:
        th = th;
        int r113 = r112;
    L37:
        com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L60
        if ((th instanceof CommonHttpException) == false) goto L46;
        int r114 = th.getResponseCode();     // Catch: Throwable -> L60
        if (r114 < 500) goto L46;
        if (r114 >= 600) goto L46;
        this.C = System.currentTimeMillis();     // Catch: Throwable -> L60
        this.f408025a = this.f408028d;     // Catch: Throwable -> L60
        SharedPreferences.Editor r115 = this.f408036l.getSharedPreferences(kta.b.f506097a, 0).edit();     // Catch: Throwable -> L60
        r115.putLong("app_log_last_config_time", this.C);     // Catch: Throwable -> L60
        r115.putInt("app_log_last_config_version", this.f408025a);     // Catch: Throwable -> L60
        r115.commit();     // Catch: Throwable -> L60
        throw th;     // Catch: Throwable -> L60
    L46:
        if (r113 > 0) goto L48;
        r112 = r113 + 1;     // Catch: Throwable -> L60
        r105 = true;
        goto L9
    L48:
        throw th;     // Catch: Throwable -> L60
    L83:
        if (this.f408036l == null) goto L29;
        if (t() == false) goto L29;
        goto L24
    L88:
        String r116 = c0.h(s(), r109, r106, this.f408036l, r111, r110, null, false, false);     // Catch: RuntimeException -> L78 Throwable -> L33
    L50:
        if (r116 != null) goto L52;
    L58:
        com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L60
        com.ss.android.common.applog.e.a().b(StatsCountKeys.CONFIG_REQUEST_FAILED_COUNT, 1);     // Catch: Throwable -> L60
    L62:
        r100 = false;
    L63:
        if (r100 == true) goto L65;
    L67:
        Object r117 = L0;
        monitor-enter(r117);
        this.E = false;     // Catch: Throwable -> L74
        r117.notifyAll();     // Catch: Exception -> L77 Throwable -> L74
    L71:
        monitor-exit(r117);     // Catch: Throwable -> L74
        M0.remove();
        return;
    L74:
        th = move-exception;
        throw th;
    L65:
        if (f407998a0 <= 0) goto L67;
        f407998a0 = 0;
        goto L67
    L52:
        if (r116.length() == 0) goto L58;
        ita.j.b("AppLog app_log_config response: " + r116, null);     // Catch: Throwable -> L60
        JSONObject r118 = new JSONObject(r116);     // Catch: Throwable -> L60
        if ("ss_app_log".equals(r118.optString("magic_tag")) == true) goto L57;
        com.ss.android.common.applog.e.a().b(StatsCountKeys.CONFIG_REQUEST_FAILED_COUNT, 1);     // Catch: Throwable -> L60
        goto L62
    L57:
        c r119 = new c(ActionQueueType.CONFIG_UPDATE);     // Catch: Throwable -> L60
        r119.f408057b = r118;     // Catch: Throwable -> L60
        r119.f408059d = String.valueOf(r211);     // Catch: Throwable -> L60
        i(r119);     // Catch: Throwable -> L60
    L24:
        com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L33
        if (r111 == false) goto L27;
        r109 = r109 + "&config_retry=b";     // Catch: Throwable -> L33
    L27:
        r116 = c0.e(null, r109, r103, true, "application/octet-stream;tt-data=b", null, false, false);     // Catch: Throwable -> L33
    L29:
        if (r111 == false) goto L31;
        r109 = r109 + "&config_retry=b";     // Catch: Throwable -> L33
    L31:
        r116 = c0.e(null, r109, r103, true, "application/octet-stream;tt-data=b", null, false, false);     // Catch: Throwable -> L33
    L33:
        th = th;
        goto L37
    L49:
        r116 = null;
        goto L50
    L6:
        r111 = false;
    L60:
        th = move-exception;
        com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);
        ita.j.c("AppLog updateConfig exception: ", th);
        goto L62
    }

    public final void N(Context r100, boolean r101) {
        kta.u.d(r100, this.f408037m, r101);
        if (this.f408033i == null) goto L11;
        JSONObject r102 = new JSONObject(this.f408037m, com.ss.android.common.applog.f.f408122a);     // Catch: JSONException -> L6
        this.f408033i.B(r102);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        ita.j.c("AppLog updateHeader", e);
        return;
    }

    public final void x(JSONObject r110, boolean r111) {
        if (r110 != null) goto L5;
        return;
    L5:
        this.C = System.currentTimeMillis();
        this.f408025a = this.f408028d;
        long r100 = r110.optLong("server_time");     // Catch: Exception -> L14
        if (r100 <= 0) goto L15;
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L14
        r101.put("server_time", r100);     // Catch: Exception -> L14
        r101.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L14
        this.f408048x = r101;     // Catch: Exception -> L14
        if (this.f408033i == null) goto L15;
        x r102 = this.f408033i;     // Catch: Exception -> L14
        JSONObject r103 = this.f408048x;     // Catch: Exception -> L14
        r102.I = r103;     // Catch: Exception -> L14
        if (com.bytedance.applog.log.m.b() == true) goto L15;
        com.bytedance.applog.log.m.c("server_time_sync", new y(r103));     // Catch: Exception -> L14
    L15:
        JSONObject r104 = r110.optJSONObject("config");
        if (r104 != null) goto L18;
        r104 = new JSONObject();
    L18:
        JSONObject r105 = r104;
        JSONArray r106 = r105.optJSONArray("allow_push_list");     // Catch: Exception -> L30
        if (r106 == null) goto L31;
        Object r107 = f408015r0;     // Catch: Exception -> L30
        monitor-enter(r107);     // Catch: Exception -> L30
        H(this.f408039o, r106);     // Catch: Throwable -> L27
        monitor-exit(r107);     // Catch: Throwable -> L27
        String r108 = r106.toString();     // Catch: Exception -> L30
    L33:
        if (r105.isNull("allow_old_image_sample") == true) goto L39;
        int r109 = r105.optInt("allow_old_image_sample", -1);
        if (r109 < 1) goto L38;
        boolean r112 = true;
    L42:
        if (r112 == this.f408040p) goto L44;
        this.f408040p = r112;
        boolean r113 = true;
    L45:
        long r114 = r105.optLong("session_interval", 0);
        if (r114 >= 15) goto L48;
    L52:
        boolean r115 = false;
    L53:
        long r116 = r105.optLong("batch_event_interval", 60) * 1000;
        if (g(r116) == true) goto L56;
    L65:
        long r117 = r105.optLong("fetch_interval", 21600) * 1000;
        if (r117 >= 1800000) goto L68;
    L69:
        r117 = 21600000;
    L71:
        if (r117 == this.f408045u) goto L73;
        this.f408045u = r117;
        r115 = true;
    L73:
        int r118 = r105.optInt("send_launch_timely");
        if (r118 == this.f408046v) goto L79;
        this.f408046v = r118;
        if (this.f408033i == null) goto L78;
        this.f408033i.H = this.f408046v;
    L78:
        r115 = true;
    L79:
        int r119 = r105.optInt("http_monitor_port");
        if (r119 > 0) goto L82;
    L84:
        boolean r120 = false;
    L86:
        if (r105.optInt("device_register_throttle", 0) == 0) goto L88;
        boolean r121 = true;
    L89:
        ita.j.b("AppLog get_deviceRegisterThrottle: " + r121, null);
        if (r121 == lta.h.f510726w) goto L92;
        ita.j.b("AppLog change_deviceRegisterThrottle: " + lta.h.f510726w, null);
        lta.h.f510726w = r121;
        boolean r122 = true;
    L93:
        int r123 = r105.optInt("forbid_report_phone_detail_info", -1);
        SharedPreferences.Editor r124 = this.f408036l.getSharedPreferences(kta.b.f506097a, 0).edit();
        if (r123 < 0) goto L102;
        r124.putInt("forbid_report_phone_detail_info", r123);
        if (r123 <= 0) goto L98;
        boolean r125 = true;
    L99:
        this.f408026b = r125;
        jta.g.f500376j.o(r125);
        kta.u.b(this.f408037m);
        k();
        if (this.f408033i == null) goto L102;
        this.f408033i.o();
        goto L102
    L98:
        r125 = false;
    L102:
        if (r115 == false) goto L104;
        r124.putLong("session_interval", this.f408043s);
        r124.putLong("batch_event_interval", this.f408044t);
        r124.putLong("fetch_interval", this.f408045u);
        r124.putInt("send_launch_timely", this.f408046v);
    L104:
        if (r108 == null) goto L106;
        r124.putString("allow_push_list", r108);
    L106:
        if (r113 == false) goto L108;
        r124.putBoolean("allow_old_image_sample", this.f408040p);
    L108:
        if (r120 == false) goto L110;
        r124.putInt("http_monitor_port", this.f408047w);
    L110:
        if (r122 == false) goto L112;
        ita.j.b("AppLog save_deviceRegisterThrottle: " + r121, null);
        r124.putBoolean("device_register_throttle", r121);
    L112:
        r124.putLong("app_log_last_config_time", this.C);
        r124.putInt("app_log_last_config_version", this.f408025a);
        JSONArray r126 = r105.optJSONArray("real_time_events");     // Catch: Throwable -> L126
        this.H.clear();     // Catch: Throwable -> L126
        if (r126 != null) goto L116;
    L124:
        r124.remove("real_time_events");     // Catch: Throwable -> L126
    L128:
        r124.putInt("content_encode_method", r105.optInt("content_encode_method", 0));
        r124.apply();
        if (r111 == true) goto L131;
        return;
    L131:
        if (this.f408038n == true) goto L144;
        this.f408038n = true;
        L(true, true, false);
        return;
    L144:
        return;
    L116:
        if (r126.length() <= 0) goto L124;
        int r127 = r126.length();     // Catch: Throwable -> L126
        int r128 = 0;
    L118:
        if (r128 >= r127) goto L123;
        String r129 = JSONArrayProtectorUtils.getString(r126, r128);     // Catch: Throwable -> L126
        if (StringUtils.isEmpty(r129) == true) goto L122;
        this.H.put(r129, "timely");     // Catch: Throwable -> L126
    L122:
        r128 = r128 + 1;     // Catch: Throwable -> L126
        goto L118
    L123:
        r124.putString("real_time_events", r126.toString());     // Catch: Throwable -> L126
    L126:
        th = move-exception;
        th.printStackTrace();
        goto L128
    L92:
        r122 = false;
        goto L93
    L88:
        r121 = false;
        goto L89
    L82:
        if (r119 == this.f408047w) goto L84;
        this.f408047w = r119;
        r120 = true;
        goto L86
    L68:
        if (r117 <= 172800000) goto L71;
    L56:
        if (r116 == this.f408044t) goto L65;
        this.f408044t = r116;
        if (this.f408033i == null) goto L64;
        x r130 = this.f408033i;
        long r131 = R0;
        if (g(r131) == true) goto L63;
        r131 = this.f408044t;
    L63:
        r130.G = r131;
        r130.F.set(r131);
    L64:
        r115 = true;
        goto L65
    L48:
        if (r114 > 300) goto L52;
        long r132 = r114 * 1000;
        if (r132 == this.f408043s) goto L52;
        this.f408043s = r132;
        r115 = true;
        goto L53
    L44:
        r113 = false;
        goto L45
    L38:
        if (r109 == 0) goto L39;
        r112 = r105.optBoolean("allow_old_image_sample", false);
    L39:
        r112 = false;
        goto L42
    L27:
        th = move-exception;
        throw th;     // Catch: Exception -> L30
    L31:
        r108 = null;
        goto L33
    }

    public final void y(s r100, long r101) {
        z r102 = this.f408042r;
        if (r102 != null) goto L7;
        ita.j.g("AppLog no session when onPause: " + r100.f408221a, null);
        return;
    L7:
        if (r102.f408247h == false) goto L10;
        ita.j.g("AppLog non-page session when onPause: " + r100.f408221a, null);
        return;
    L10:
        r102.f408249j = false;
        r102.f408246g = r101;
        r100.f408223c = r102.f408240a;
        com.ss.android.common.applog.h r103 = com.ss.android.common.applog.h.d(this.f408036l);
        monitor-enter(r103);
        SQLiteDatabase r104 = r103.f408134a;     // Catch: Throwable -> L39
        if (r104 != null) goto L15;
    L28:
        ita.j.g("AppLog db not establish and open", null);     // Catch: Throwable -> L39
        monitor-exit(r103);
    L43:
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L42
        int r106 = this.f408049y.get();     // Catch: Exception -> L42
        int r107 = this.f408050z.get();     // Catch: Exception -> L42
        r105.put("session_id", this.f408042r.f408241b);     // Catch: Exception -> L42
        r105.put("cnt_success", r106);     // Catch: Exception -> L42
        r105.put("cnt_failure", r107);     // Catch: Exception -> L42
        JSONArray r108 = new JSONArray();     // Catch: Exception -> L42
        Iterator<h> r109 = this.A.iterator();     // Catch: Exception -> L42
    L32:
        if (r109.hasNext() == false) goto L35;
        h r110 = r109.next();     // Catch: Exception -> L42
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L42
        r111.put("url", r110.f408066a);     // Catch: Exception -> L42
        r111.put("networktype", r110.f408067b);     // Catch: Exception -> L42
        r111.put("time", r110.f408068c);     // Catch: Exception -> L42
        r111.put("timestamp", r110.f408069d);     // Catch: Exception -> L42
        r108.put(r111);     // Catch: Exception -> L42
        goto L32
    L35:
        if (r108.length() <= 0) goto L37;
        r105.put("samples", r108);     // Catch: Exception -> L42
    L37:
        SharedPreferences.Editor r112 = this.f408036l.getSharedPreferences(kta.b.f506097a, 0).edit();     // Catch: Exception -> L42
        r112.putString("stats_value", r105.toString());     // Catch: Exception -> L42
        r112.commit();     // Catch: Exception -> L42
        return;
    L51:
        return;
    L15:
        if (r104.isOpen() == false) goto L28;
        ContentValues r113 = new ContentValues();     // Catch: Exception -> L19 Throwable -> L39
        r113.put("pausetime", Long.valueOf(r101));     // Catch: Exception -> L19 Throwable -> L39
        r103.f408134a.update(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, r113, "_id = ?", new String[]{String.valueOf(r100.f408223c)});     // Catch: Exception -> L19 Throwable -> L39
    L45:
        ContentValues r114 = new ContentValues();     // Catch: Exception -> L24 Throwable -> L39
        r114.put("name", r100.f408221a);     // Catch: Exception -> L24 Throwable -> L39
        r114.put("duration", Integer.valueOf(r100.f408222b));     // Catch: Exception -> L24 Throwable -> L39
        r114.put("session_id", Long.valueOf(r100.f408223c));     // Catch: Exception -> L24 Throwable -> L39
        r103.f408134a.insert("page", null, r114);     // Catch: Exception -> L24 Throwable -> L39
        monitor-exit(r103);
        goto L43
    L24:
        e = move-exception;
        ita.j.g("AppLog insert page exception: ", e);     // Catch: Throwable -> L39
        goto L43
    L19:
        e = move-exception;
        ita.j.g("AppLog update session pausetime exception: ", e);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    }

    public static void recordMiscLog(Context r100, String r101, JSONObject r102) {
        f408004g0.i(r101, r102);
    }

    public final void L(boolean r110, boolean r111, boolean r112) {
        if (this.E == false) goto L5;
        return;
    L5:
        JSONObject r100 = this.f408037m;
        if (r100 != null) goto L9;
        return;
    L9:
        if (f408004g0.y(r100.optString("device_id", null)) == false) goto L12;
        return;
    L12:
        if (StringUtils.isEmpty(this.f408037m.optString("install_id", null)) == false) goto L14;
        return;
    L14:
        long r101 = System.currentTimeMillis();
        long r102 = this.f408045u;
        if (this.f408025a != this.f408028d) goto L17;
        boolean r103 = true;
    L19:
        if (C0 == false) goto L21;
    L24:
        if (r103 == false) goto L26;
        long r113 = 180000;
    L27:
        if (r111 == true) goto L36;
        if ((r101 - this.C) >= r102) goto L32;
        return;
    L32:
        if ((r101 - this.D) >= r113) goto L60;
        ita.j.b("AppLog next query time : " + DateFormat.getDateTimeInstance().format(new Date(this.D + r113)), null);
        return;
    L60:
        long r104 = System.currentTimeMillis();     // Catch: Exception -> L59
        if (f407998a0 > 0) goto L44;
        f407998a0 = r104;     // Catch: Exception -> L59
    L44:
        if (NetworkUtils.isNetworkAvailable(this.f408036l) == true) goto L47;
        com.ss.android.common.applog.e.a().b(StatsCountKeys.NO_NETWORK_COUNT, 1);     // Catch: Exception -> L59
        return;
    L47:
        this.D = r101;     // Catch: Exception -> L59
        this.E = true;     // Catch: Exception -> L59
        JSONObject r105 = new JSONObject(this.f408037m, com.ss.android.common.applog.f.f408122a);     // Catch: Exception -> L59
        Context r106 = this.f408036l;     // Catch: Exception -> L59
        if (StringUtils.isEmpty(kta.u.f506147k) == false) goto L51;
        kta.u.f506147k = r106.getSharedPreferences(kta.b.f506097a, 0).getString(com.alipay.sdk.m.l.b.f25480b, null);     // Catch: Exception -> L59
    L51:
        String r107 = kta.u.f506147k;     // Catch: Exception -> L59
        if (StringUtils.isEmpty(r107) == true) goto L54;
        r105.put(com.alipay.sdk.m.l.b.f25480b, r107);     // Catch: Exception -> L59
    L54:
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L59
        r108.put("magic_tag", "ss_app_log");     // Catch: Exception -> L59
        r108.put("header", r105);     // Catch: Exception -> L59
        r108.put("_gen_time", System.currentTimeMillis());     // Catch: Exception -> L59
        String r109 = r108.toString();     // Catch: Exception -> L59
        if (r110 == false) goto L57;
        ThreadMethodProxy.start(new a(this, r109, r112, r104));     // Catch: Exception -> L59
        return;
    L57:
        M(r109, r112);     // Catch: Exception -> L59
        return;
    L62:
        return;
    L36:
        if (this.D <= this.C) goto L60;
        if ((r101 - this.D) >= r113) goto L60;
        return;
    L26:
        r113 = 60000;
        goto L27
    L21:
        if (this.f408035k >= 0) goto L24;
        if (r103 == false) goto L24;
        r102 = 2 * this.f408045u;
        goto L24
    L17:
        r103 = false;
        goto L19
    }

    public static void E(Context r100, String r101, String r102, String r103, long r104, long r105, JSONObject r106) {
        a(r100, r101, r102, r103, r104, r105, r106);
    }

    public static void a(Context r210, String r211, String r212, String r213, long r214, long r215, JSONObject r216) {
        com.bytedance.android.btm.api.model.j r100 = new com.bytedance.android.btm.api.model.j(r210, r211, r212, r213, r214, r215, false, r216, true);
        BtmSDK r101 = BtmSDK.INSTANCE;
        com.bytedance.android.btm.api.model.j r102 = r101.addBtmEventParam(r100);
        com.bytedance.android.btm.api.bst.b r103 = (com.bytedance.android.btm.api.bst.b) yc.b.a(com.bytedance.android.btm.api.bst.b.class);
        if (r103 == null) goto L5;
        r103.hookApplog(r102);
    L5:
        r101.getService().checkEventParam(r102);
        BtmDebugTool.f42073b.onEventIntercepted(r102);
        F(r210, r211, r212, r213, r214, r215, false, r102.f42064h);
    }

    public static void F(Context r110, String r111, String r112, String r113, long r114, long r115, boolean r116, JSONObject r210) {
        if (r210 != null) goto L21;
    L7:
        if (r210 != null) goto L10;
    L17:
        f408004g0.s(r111, r112, r113, r114, r115, r116, r210);
        return;
    L10:
        if (r210.has("ab_sdk_version") == true) goto L17;
        String r100 = n();
        if (TextUtils.isEmpty(r100) == true) goto L17;
        r210.put("ab_sdk_version", r100);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L21:
        r210.put("network_quality", NetQualityManager.f360092a.getValue());     // Catch: JSONException -> L6
        goto L7
    }
}
