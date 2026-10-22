package com.bytedance.bdturing.livedetect;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.camera.ImageDataWrapper;
import com.bytedance.bdturing.livedetect.pty.TuringPTYManager;
import com.bytedance.bdturing.setting.e;
import com.bytedance.bdturing.verify.ITuringVerifyService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ec4.j;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jc4.i;
import jc4.m;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import qb4.c0;
import qb4.f;
import vb4.d;

/* JADX INFO: loaded from: classes3.dex */
public class LiveDetectService implements ITuringVerifyService {
    public static final int BITMAP_COMPRESS_QUALITY = 95;
    private static final String CAMERA_PERMISSION_KEY = "camera_permission_key";
    private static final String PERMISSION_STATE_NOT_REQUESTED = "0";
    private static final String PERMISSION_STATE_REQUESTED = "1";
    private static final long PTY_INIT_DELAY = 5000;
    private static final String SP_FILE_NAME = "turing_live_detect_cfg";
    private static volatile LiveDetectService sInstance;
    private boolean isOnVerify;
    private final List<d> mByteNNLoadCallBackList;
    private f mCallback;
    private jc4.a mRequest;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f201818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveDetectService f201819b;

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.f201819b.useByteNN() == false) goto L7;
            com.bytedance.bdturing.livedetect.a r100 = com.bytedance.bdturing.livedetect.a.f();     // Catch: Throwable -> L9
            if (r100.g() == true) goto L14;
            r100.e("init", null);     // Catch: Throwable -> L9
        L14:
            return;
        L7:
            TuringPTYManager.b().d(this.f201818a, null, qb4.b.class.getName());     // Catch: Throwable -> L9
            goto L14
        }

        public a(LiveDetectService r100, Context r101) {
            this.f201819b = r100;
            this.f201818a = r101;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class b implements ec4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xb4.b f201820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveDetectService f201821b;

        @Override // ec4.c
        public final void a(xb4.a r100) {
            if (r100.f563110a != 200) goto L5;
            boolean r101 = true;
        L6:
            String r102 = r100.f563112c;
            jc4.a r103 = LiveDetectService.access$000(this.f201821b);
            JSONObject r104 = new JSONObject();     // Catch: Exception -> L13
            r104.put("key", "turing_live_create_session");     // Catch: Exception -> L13
            if (r101 == false) goto L10;
            int r105 = 0;
        L11:
            r104.put("result", r105);     // Catch: Exception -> L13
            r104.put("custom", r102);     // Catch: Exception -> L13
            EventReport.w("turing_verify_sdk", r104, r103);     // Catch: Exception -> L13
        L15:
            xb4.b r106 = this.f201820a;
            if (r106 == null) goto L21;
            r106.a(r100.f563110a, r100.f563111b, new String[]{r100.f563112c});
            return;
        L21:
            return;
        L10:
            r105 = 1;
        L13:
            e = move-exception;
            e.printStackTrace();
            goto L15
        L5:
            r101 = false;
            goto L6
        }

        @Override // ec4.c
        public final void onError(Throwable r100) {
            xb4.b r101 = this.f201820a;
            if (r101 == null) goto L6;
            r101.onError(r100);
            return;
        }

        public b(LiveDetectService r100, xb4.b r101) {
            this.f201821b = r100;
            this.f201820a = r101;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class c implements ec4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xb4.b f201822a;

        public c(xb4.b r100) {
            this.f201822a = r100;
        }

        @Override // ec4.c
        public final void a(xb4.a r100) {
            xb4.b r101 = this.f201822a;
            if (r101 == null) goto L6;
            r101.a(r100.f563110a, r100.f563111b, new String[]{r100.f563112c, r100.f563113d});
            return;
        }

        @Override // ec4.c
        public final void onError(Throwable r100) {
            xb4.b r101 = this.f201822a;
            if (r101 == null) goto L6;
            r101.onError(r100);
            return;
        }
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public synchronized boolean isOnVerify() {
        monitor-enter(this);
        boolean r100 = this.isOnVerify;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService, ic4.a
    public boolean isProcess(int r100) {
        if (16 != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public boolean isSenseless() {
        return false;
    }

    public static LiveDetectService getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(LiveDetectService.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LiveDetectService();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LiveDetectService.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public boolean byteNNDispatchEnable() {
        e r100 = e.f202077a;
        String r101 = e.f("live_dispatch_enable");
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        return false;
    L5:
        if ("1".equals(r101) == false) goto L7;
        return true;
    }

    public boolean detectPageShowing() {
        BdTuringConfig r100 = qb4.b.c.f532315a.f532302a;
        if (r100 == null) goto L5;
        Activity r101 = r100.getTopActivity();
    L6:
        if (r101 != null) goto L8;
    L12:
        return false;
    L8:
        if ((r101 instanceof TuringLivePTYActivity) == false) goto L10;
    L11:
        return true;
    L10:
        if ((r101 instanceof TuringLiveByteNNActivity) == false) goto L12;
    L5:
        r101 = null;
        goto L6
    }

    public boolean isByteNNLoad() {
        BdTuringConfig r100 = qb4.b.c.f532315a.f532302a;
        if (r100 == null) goto L5;
        vb4.c r101 = r100.getByteNNDepend();
    L6:
        if (r101 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r101 = null;
        goto L6
    }

    public boolean isRequestCameraPermissionFirstTime() {
        BdTuringConfig r100 = qb4.b.c.f532315a.f532302a;
        if (r100 == null) goto L5;
        Context r101 = r100.getApplicationContext();
    L7:
        if (r101 != null) goto L9;
    L14:
        String r102 = "0";
    L16:
        return "0".equals(r102);
    L9:
        if (TextUtils.isEmpty(SP_FILE_NAME) == true) goto L14;
        if (TextUtils.isEmpty(CAMERA_PERMISSION_KEY) == true) goto L14;
        r102 = r101.getSharedPreferences(SP_FILE_NAME, 0).getString(CAMERA_PERMISSION_KEY, "0");
        goto L16
    L5:
        r101 = null;
        goto L7
    }

    public void updatePermissionState() {
        BdTuringConfig r100 = qb4.b.c.f532315a.f532302a;
        if (r100 == null) goto L5;
        Context r101 = r100.getApplicationContext();
    L6:
        if (r101 == null) goto L9;
        hc4.e.a(r101, CAMERA_PERMISSION_KEY);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public boolean useByteNN() {
        e r100 = e.f202077a;
        String r101 = e.f("use_bytenn");
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        return false;
    L5:
        if ("1".equals(r101) == false) goto L7;
        return true;
    }

    private LiveDetectService() {
        this.mByteNNLoadCallBackList = new ArrayList();
    }

    public Pair<Boolean, String> liveDetectState() {
        if (useByteNN() == false) goto L12;
        boolean r100 = com.bytedance.bdturing.livedetect.a.f().g();
        boolean r101 = isByteNNLoad();
        if (r100 == false) goto L8;
        if (r101 == false) goto L8;
        boolean r102 = true;
    L10:
        return new Pair(Boolean.valueOf(r102), "modelFileReady:" + r100 + ";byteNNSoReady=" + r101);
    L8:
        r102 = false;
        goto L10
    L12:
        return new Pair(Boolean.valueOf(TuringPTYManager.b().f()), "");
    }

    public jc4.a getRequest() {
        return this.mRequest;
    }

    public static /* synthetic */ jc4.a access$000(LiveDetectService r100) {
        return r100.mRequest;
    }

    private void addByteNNCallBack(d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mByteNNLoadCallBackList.contains(r100) == true) goto L8;
        this.mByteNNLoadCallBackList.add(r100);
        return;
    }

    private boolean loadModelFileNNInNeed(String r100) {
        boolean r101 = com.bytedance.bdturing.livedetect.a.f().g();
        if (r101 == true) goto L5;
        com.bytedance.bdturing.livedetect.a.f().e(r100, null);
    L5:
        return r101;
    }

    public void init(Context r100) {
        com.bytedance.bdturing.livedetect.a r101 = com.bytedance.bdturing.livedetect.a.f();
        r101.getClass();
        if (r100 == null) goto L5;
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.getFilesDir());
        String r103 = File.separator;
        r102.append(r103);
        r102.append("BdTuring");
        r102.append(r103);
        r102.append("face_model");
        r101.f201893b = r102.toString();
    L5:
        c0.a.f532328a.b(new a(this, r100), 5000);
    }

    public void removeByteNNCallBack(d r100) {
        this.mByteNNLoadCallBackList.remove(r100);
    }

    public synchronized void setOnVerify(boolean r100) {
        monitor-enter(this);
        EventReport.e(r100, "LiveDetectService", this.mRequest);     // Catch: Throwable -> L6
        this.isOnVerify = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private String buildVerifyData(String r110, com.bytedance.bdturing.livedetect.pty.c... r111) {
        if (r111 != null) goto L5;
        return "";
    L5:
        if (r111.length != 0) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(r110) == true) goto L45;
        JSONArray r100 = new JSONArray();     // Catch: Exception -> L35
        int r101 = 0;
    L11:
        if (r101 >= r111.length) goto L33;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L35
        com.bytedance.bdturing.livedetect.pty.c r103 = r111[r101];     // Catch: Exception -> L35
        ImageDataWrapper r104 = r103.f201926d;     // Catch: Exception -> L35
        byte[] r105 = r104.rgbBytes;     // Catch: Exception -> L35
        if (r105 != null) goto L15;
    L25:
        Bitmap r106 = r104.bitmap;     // Catch: Exception -> L35
        Intrinsics.checkNotNullParameter(r106, SimplayerImageStrategy.RESULT_BITMAP);     // Catch: Exception -> L35
        ByteArrayOutputStream r107 = new ByteArrayOutputStream();     // Catch: Exception -> L35
        r106.compress(Bitmap.CompressFormat.JPEG, 95, r107);     // Catch: Exception -> L35
        byte[] r108 = r107.toByteArray();     // Catch: Exception -> L35
        r107.close();     // Catch: Exception -> L35
        String r109 = Base64.encodeToString(r108, 2);     // Catch: Exception -> L35
    L26:
        r102.put("image", r109);     // Catch: Exception -> L35
        JSONArray r112 = new JSONArray();     // Catch: Exception -> L35
        if (r103.f201925c == null) goto L32;
        int r113 = 0;
    L30:
        if (r113 >= r103.f201925c.size()) goto L32;
        r112.put(ListProtector.get(r103.f201925c, r113));     // Catch: Exception -> L35
        r113 = r113 + 1;     // Catch: Exception -> L35
    L32:
        r102.put("roi", r112);     // Catch: Exception -> L35
        r100.put(r102);     // Catch: Exception -> L35
        r101 = r101 + 1;     // Catch: Exception -> L35
        goto L11
    L15:
        if (r105.length <= 0) goto L25;
        if (r105 != null) goto L18;
    L24:
        r109 = null;
        goto L26
    L18:
        if (r105.length != 0) goto L20;
        boolean r114 = true;
    L22:
        if ((!r114) == false) goto L24;
        r109 = Base64.encodeToString(r105, 2);     // Catch: Exception -> L35
        goto L26
    L20:
        r114 = false;
        goto L22
    L33:
        JSONObject r115 = new JSONObject();     // Catch: Exception -> L35
        r115.put("images", r100);     // Catch: Exception -> L35
        return hc4.b.a(r115.toString(), r110);
    L35:
        e = move-exception;
        e.printStackTrace();
        return "";
    L45:
        return "";
    }

    private boolean initPTYInNeed(Context r100, String r101) {
        TuringPTYManager.b().d(r100, null, r101);
        final TuringPTYManager r102 = TuringPTYManager.b();
        if (r102.f201914f.get() == true) goto L11;
        final long r103 = System.currentTimeMillis();
        if (r102.f() == false) goto L11;
        if (r102.f201912d.get() == true) goto L11;
        r102.f201914f.set(true);
        ThreadMethodProxy.start(new TuringPTYManager.AnonymousClass9(r102, r103));
    L11:
        boolean r104 = TuringPTYManager.b().f();
        EventReport.n(r104, r101);
        return r104;
    }

    public void createSession(String r100, xb4.b r101) {
        String r102 = vb4.e.c() + "auth/live/get";
        HashMap r103 = new HashMap();
        r103.put("detail", r100);
        HashMap r104 = new HashMap();
        r104.put("Content-Type", "application/json; charset=utf-8");
        new j(r102, r103, null, r104).c(new b(this, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        if (r101 == null) goto L12;
        r101.onError(e);
        return;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService, ic4.a
    public boolean execute(jc4.a r100, f r101) {
        EventReport.V(r100);
        if ((r100 instanceof m) == false) goto L5;
        boolean r102 = r100.f498096g;
        jc4.a r103 = ((m) r100).f498122o;
    L7:
        if (r103 != null) goto L9;
    L24:
        JSONObject r104 = new JSONObject();
        hc4.d.b(r104, "errorMsg", "request type is not LiveDetectRequest!");
        r101.onFail(996, r104);
        return true;
    L9:
        if ((r103 instanceof i) == false) goto L24;
        if (isOnVerify() == false) goto L15;
        r101.onFail(998, null);
        bc4.b.a().d(r100);
        EventReport.S(r100, "LiveDetectService");
        return true;
    L15:
        Activity r105 = r100.getActivity();
        if (r105 != null) goto L19;
        EventReport.A(r100, "activity_is_null");
        r101.onFail(1, null);
        return true;
    L19:
        this.mRequest = r100;
        this.mCallback = r101;
        if (r102 == true) goto L22;
        TuringLiveDetectGuideActivity.startActivity(r105, ((i) r103).f498116n);
        EventReport.startActivity(true, TuringLiveDetectGuideActivity.class.getName(), r100);
    L23:
        return true;
    L22:
        turn2DetectPage(r100, r105, ((i) r103).f498116n);
        goto L23
    L5:
        r102 = false;
        r103 = null;
        goto L7
    }

    public void loadByteNNInNeed(String r100, d r101) {
        if (isByteNNLoad() == false) goto L7;
        if (r101 == null) goto L16;
        r101.onSuccess("");
        return;
    L16:
        return;
    L7:
        BdTuringConfig r102 = qb4.b.c.f532315a.f532302a;
        if (r102 == null) goto L10;
        vb4.c r103 = r102.getByteNNDepend();
    L11:
        if (r103 == null) goto L13;
        addByteNNCallBack(r101);
        EventReport.d(r100, true, GXTemplateKey.GAIAX_TRACK + "", System.currentTimeMillis() - System.currentTimeMillis());
        access$100(this, true, "", 0);
        return;
    L13:
        if (r101 == null) goto L18;
        r101.a("ByteNN_Depend is null", -1);
        return;
    L18:
        return;
    L10:
        r103 = null;
        goto L11
    }

    public void onResult(int r100, JSONObject r101) {
        setOnVerify(false);
        EventReport.N(r100, this.mRequest);
        f r102 = this.mCallback;
        if (r102 == null) goto L9;
        if (r100 != 0) goto L6;
        r102.onSuccess(r100, r101);
    L7:
        this.mCallback = null;
        return;
    L6:
        r102.onFail(r100, r101);
        goto L7
    }

    public boolean preInit(Context r100, String r101) {
        if (useByteNN() == true) goto L7;
        return initPTYInNeed(r100, r101);
    L7:
        return loadModelFileNNInNeed(r101);
    }

    private void dispatchByteNNLoadResult(boolean r100, String r101, int r102) {
        Iterator<d> r103 = this.mByteNNLoadCallBackList.iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        d r104 = r103.next();
        if (r104 == null) goto L4;
        if (r100 == false) goto L9;
        r104.onSuccess(r101);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L9:
        r104.a(r101, r102);     // Catch: Exception -> L11
        goto L4
    L13:
        this.mByteNNLoadCallBackList.clear();
    }

    public void turn2DetectPage(jc4.a r100, Activity r101, String r102) {
        if (getInstance().useByteNN() == false) goto L5;
        TuringLiveByteNNActivity.startActivity(r101, r102);
        EventReport.startActivity(true, TuringLiveByteNNActivity.class.getName(), r100);
        return;
    L5:
        TuringLivePTYActivity.startActivity(r101, r102);
        EventReport.startActivity(true, TuringLivePTYActivity.class.getName(), r100);
    }

    public static /* synthetic */ void access$100(LiveDetectService r100, boolean r101, String r102, int r103) {
        r100.dispatchByteNNLoadResult(r101, r102, r103);
    }

    public void verify(String r100, String r101, String r102, com.bytedance.bdturing.livedetect.pty.c r103, xb4.b r104) {
        String r105 = vb4.e.c() + "auth/live/verify";
        HashMap r106 = new HashMap();
        r106.put("detail", r100);
        r106.put("ticket", r101);
        HashMap r107 = new HashMap();
        r107.put("data", buildVerifyData(r102, new com.bytedance.bdturing.livedetect.pty.c[]{r103}));
        HashMap r108 = new HashMap();
        r108.put("Content-Type", "application/json; charset=utf-8");
        new j(r105, r106, r107, r108).c(new c(r104));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        if (r104 == null) goto L12;
        r104.onError(e);
        return;
    }
}
