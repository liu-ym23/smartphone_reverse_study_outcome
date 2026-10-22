package com.ss.android.lark.chat.service.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.NetStatus;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.perf.ResourcePerfMonitor;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class MonitorMessageSendCallback implements com.ss.android.lark.im.sdk.service.o, m6b.p, u, n6b.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AtomicInteger f416398q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okb.b f416399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z1b.a f416400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f416401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Chat f416402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ChatChatter f416403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Biz f416404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Scene f416405g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f416406h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f416407i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile b f416408j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f416409k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f416410l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f416411m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, String> f416412n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, c> f416413o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<n6b.c<o6b.b>> f416414p;

    public @interface FromType {
        public static final int IMAGE = 1;
        public static final int MEDIA = 4;
        public static final int POST = 2;
        public static final int SHARE = 14;
        public static final int STICKER = 3;
        public static final int UNKNOWN = 0;
    }

    public @interface StateType {
        public static final int FAIL = 2;
        public static final int SENDING = 0;
        public static final int SUCCESS = 1;
    }

    public interface a {
    }

    public static class b implements okb.a.b, okb.a.InterfaceC7064a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<MonitorMessageSendCallback> f416415a;

        @Override // okb.a.b
        public final void a() {
            Log.i("MonitorMessageSendCallback", "onFrontToBackEvent");
            MonitorMessageSendCallback r100 = this.f416415a.get();
            if (r100 == null) goto L5;
            r100.f416407i = true;
        L5:
            ImSdkProxy.b().e(this);
        }

        @Override // okb.a.InterfaceC7064a
        public final void b() {
            MonitorMessageSendCallback r100 = this.f416415a.get();
        }

        public b(MonitorMessageSendCallback r100) {
            this.f416415a = new WeakReference(r100);
        }
    }

    public static class c {
        public float A;
        public String B;
        public long C;
        public long D;
        public long E;
        public long F;
        public int G;
        public Map<String, Object> H;
        public int I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f416416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f416417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f416418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f416419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f416420e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f416421f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Message.Type f416422g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f416423h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f416424i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f416425j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f416426k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f416427l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f416428m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f416429n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f416430o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f416431p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f416432q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f416433r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public long f416434s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f416435t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f416436u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Chat.Type f416437v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f416438w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f416439x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public long f416440y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public long f416441z;

        public final Map<String, Object> b() {
            HashMap r100 = new HashMap();
            r100.put("message_type", Integer.valueOf(this.f416422g.getNumber()));
            r100.put("chat_type", Integer.valueOf(this.f416437v.getNumber()));
            r100.put("is_crypto", Integer.valueOf(this.f416439x ? 1 : 0));
            r100.put("image_type", this.f416427l);
            r100.put("color_space", this.f416428m);
            r100.put("color_type", this.f416429n);
            r100.put("from_type", Integer.valueOf(this.I));
            r100.put("is_image_fallback_to_file", Boolean.valueOf(this.f416425j));
            r100.put("media_is_origin_type", Boolean.valueOf(this.f416426k));
            Message.Type r101 = this.f416422g;
            if (r101 != Message.Type.IMAGE) goto L5;
        L10:
            boolean r102 = true;
        L11:
            if (r102 == false) goto L13;
            r100.put("resource_multiple_number", Integer.valueOf(this.f416435t));
        L13:
            return r100;
        L5:
            if (r101 == Message.Type.FILE) goto L10;
            if (r101 == Message.Type.MEDIA) goto L10;
            r102 = false;
            goto L11
        }

        public final Map<String, Object> c() {
            HashMap r100 = new HashMap();
            r100.put("text_content_length", Long.valueOf(this.f416419d));
            r100.put("resource_content_length", Long.valueOf(this.f416420e));
            r100.put("file_size", Long.valueOf(this.f416420e));
            r100.put("chatter_count", Integer.valueOf(this.f416438w));
            String r101 = this.f416423h;
            String r102 = "";
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            r100.put(MusicAppletPage.KEY_MESSAGE_ID, r101);
            String r103 = this.f416424i;
            if (r103 == null) goto L9;
            r102 = r103;
        L9:
            r100.put("remote_message_id", r102);
            r100.put("resource_width", Long.valueOf(this.f416430o));
            r100.put("resource_height", Long.valueOf(this.f416431p));
            r100.put("resource_frames", 0L);
            r100.put("upload_content_length", Long.valueOf(this.f416432q));
            r100.put("upload_content_width", Long.valueOf(this.f416433r));
            r100.put("upload_content_height", Long.valueOf(this.f416434s));
            if (TextUtils.isEmpty(this.B) == true) goto L12;
            r100.put("compress_algorithm", this.B);
            r100.put("compress_ratio", Float.valueOf(this.A));
        L12:
            r100.put("choose_image_source", this.f416436u);
            return r100;
        }

        public c() {
            this.f416419d = 0;
            this.f416420e = 0;
            this.f416421f = false;
            this.f416422g = Message.Type.UNKNOWN;
            this.f416423h = "";
            this.f416424i = "";
            this.f416425j = true;
            this.f416426k = false;
            this.f416427l = "";
            this.f416428m = "SRGB";
            this.f416429n = "RGBA_8888";
            this.f416430o = 0;
            this.f416431p = 0;
            this.f416432q = 0;
            this.f416433r = 0;
            this.f416434s = 0;
            this.f416435t = 1;
            this.f416436u = "unknown";
            this.f416437v = Chat.Type.P2P;
            this.A = 1.0f;
            this.G = 0;
            this.I = 1;
        }

        public final Map<String, Object> a(boolean r100) {
            HashMap r101 = new HashMap();
            if (r100 == false) goto L5;
            r101.put("send_state", Integer.valueOf(this.G));
            r101.put("on_screen_cost", Long.valueOf(this.E));
            r101.put("total_cost", Long.valueOf(this.F));
            r101.put("upload_cost", 0L);
        L5:
            String r102 = this.f416418c;
            if (r102 != null) goto L8;
            r102 = "";
        L8:
            r101.put("context_id", r102);
            return r101;
        }

        public final Map<String, Object> d(boolean r100, boolean r101) {
            HashMap r102 = new HashMap();
            r102.put("sdk_create_msg_cost", Long.valueOf(this.f416440y));
            r102.put("CreateQuasiMessageRequest", Long.valueOf(this.f416440y));
            if (r100 == false) goto L5;
            r102.put("compress_cost", Long.valueOf(this.f416441z));
            r102.put("sdk_send_msg_cost", Long.valueOf(this.C));
            r102.put("net_cost", Long.valueOf(this.D));
        L5:
            if (r101 == true) goto L7;
        L9:
            return r102;
        L7:
            if (CollectionUtils.isEmpty(this.H) == true) goto L9;
            r102.putAll(this.H);
            goto L9
        }
    }

    @Override // n6b.b
    public final void i() {
        c r100 = q(null);
        if (r100 != null) goto L5;
        return;
    L5:
        r100.E = SystemClock.elapsedRealtime();
        PerfLog.start("quasi_message_on_screen_single", this.f416401c, null);
    }

    @Override // m6b.p
    public void onBeginSendMessage(Message r100) {
    }

    @Override // com.ss.android.lark.chat.service.impl.u
    public void onUpdateMediaCompressProgress(Message r100) {
    }

    static {
        f416398q = new AtomicInteger(NetStatus.EXCELLENT.getValue());
    }

    @Override // n6b.b
    public final void f() {
        PerfLog.end("sync_create_local_message", this.f416401c, null);
    }

    @Override // n6b.b
    public final void j() {
        PerfLog.start("sync_create_local_message", this.f416401c, null);
    }

    public MonitorMessageSendCallback() {
        this.f416399a = ImSdkProxy.c();
        this.f416400b = new z1b.a();
        this.f416401c = com.ss.android.lark.sdk.a.a();
        this.f416402d = null;
        this.f416403e = null;
        this.f416404f = Biz.Messenger;
        this.f416405g = Scene.Chat;
        this.f416406h = 1;
        this.f416407i = false;
        this.f416408j = null;
        this.f416409k = null;
        this.f416410l = 1;
        this.f416411m = "unknown";
        this.f416412n = new ConcurrentHashMap();
        this.f416413o = new ConcurrentHashMap();
        this.f416414p = new CopyOnWriteArrayList();
        this.f416408j = new b(this);
        ImSdkProxy.b().d(this.f416408j);
        ImSdkProxy.b().f(this.f416408j);
        boolean r100 = ImSdkProxy.b().b();
        Log.d("MonitorMessageSendCallback", "isInForeground:" + r100);
        this.f416407i = r100 ^ true;
    }

    @Override // n6b.b
    public final String e() {
        return this.f416401c;
    }

    @Override // n6b.a
    public final void b(long r100) {
        String r101 = FileUtils.h(r100);
        int r102 = t5c.a.f544651a;
        Intrinsics.checkNotNullParameter(r101, "fileSize");
        Statistics.sendEvent("im_send_file_confirmed", new JSONObject().put("file_size", r101));
    }

    @Override // n6b.b
    public final void c(String r100) {
        PerfLog.start("async_call_send_message", this.f416401c, null);
        c r101 = q(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.C = SystemClock.elapsedRealtime();
    }

    @Override // n6b.c
    public /* bridge */ /* synthetic */ void g(Object r100) {
        u((o6b.b) r100);
    }

    @Override // n6b.b
    public /* bridge */ /* synthetic */ void h(MessageInfo r100) {
        s(r100);
    }

    @Override // n6b.b
    public void l(String r100) {
        c r101 = q(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.f416440y = SystemClock.elapsedRealtime() - r101.f416440y;
        PerfLog.end("sync_create_quasi_message", this.f416401c, null);
        if (TextUtils.isEmpty(r100) == true) goto L11;
        String r102 = this.f416401c;
        SystemClock.elapsedRealtime();
        CopyOnWriteArrayList<mkb.a> r103 = mkb.d.f514353a;
        Intrinsics.checkNotNullParameter(r102, "contextId");
        Intrinsics.checkNotNullParameter(r100, "cId");
        Iterator<mkb.a> r104 = mkb.d.f514353a.iterator();
    L9:
        if (r104.hasNext() == false) goto L13;
        r104.next().e(r102, r100);
        goto L9
    L13:
        return;
    }

    @Override // com.ss.android.lark.im.sdk.service.o
    public final void m(n6b.c<o6b.b> r100) {
        ((CopyOnWriteArrayList) this.f416414p).remove(r100);
    }

    @Override // n6b.b
    public final void o(String r110) {
        c r111 = q(r110);
        if (r111 != null) goto L5;
        return;
    L5:
        r111.E = SystemClock.elapsedRealtime() - r111.E;
        PerfLog.end("quasi_message_on_screen_single", this.f416401c, null);
        AppreciableKit r100 = AppreciableKit.getInstance();
        String r101 = r111.f416416a;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r100.end(r101, r111.d(false, false), r111.a(false), r111.c(), r111.b());
    }

    public final void p(n6b.c<o6b.b> r100) {
        if (((CopyOnWriteArrayList) this.f416414p).contains(r100) == false) goto L5;
        return;
    L5:
        ((CopyOnWriteArrayList) this.f416414p).add(r100);
    }

    public final c q(String r100) {
        String r101 = "default";
        if (TextUtils.isEmpty(r100) == true) goto L10;
        String r102 = (String) ((ConcurrentHashMap) this.f416412n).get(r100);
        if (r102 == null) goto L10;
        r101 = r102;
    L10:
        return (c) ((ConcurrentHashMap) this.f416413o).get(r101);
    }

    public final void r(dcb.b r100) {
        if (r100 != null) goto L4;
    L6:
        String r101 = "default";
    L7:
        c r102 = (c) ((ConcurrentHashMap) this.f416413o).get(r101);
        if (r102 != null) goto L10;
        return;
    L10:
        r102.f416425j = false;
        if (r100 == null) goto L22;
        int[] r103 = r100.f467913c;
        int r104 = r103[0];
        int r105 = 80;
        if (r104 > 0) goto L15;
        r104 = 80;
    L15:
        r102.f416433r = r104;
        int r106 = r103[1];
        if (r106 <= 0) goto L19;
        r105 = r106;
    L19:
        r102.f416434s = r105;
        File r107 = r100.f467912b;
        if (r107 == null) goto L22;
        String[] r108 = FileUtils.f285888a;
        r102.f416432q = r107.length();
    L22:
        PerfLog.end("get_image_data_single", this.f416401c, null);
        return;
    L4:
        if (TextUtils.isEmpty(r100.f467911a) == true) goto L6;
        r101 = r100.f467911a;
        goto L7
    }

    public void s(MessageInfo r110) {
        Message r100 = r110.getMessage();
        Message.Type r101 = r100.getType();
        c r111 = q(r110.getcId());
        if (r111 != null) goto L5;
        return;
    L5:
        long r102 = 0;
        if (r101 != Message.Type.POST) goto L9;
        int r103 = ((PostContent) r100.getContent()).getText().length();
    L11:
        r102 = r103;
        long r104 = 0;
    L45:
        z1b.a r105 = this.f416400b;
        String r106 = r101.toString();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "messageType");
        r105.getDefaultParamsMap().put(r105.f569720a, Long.valueOf(SystemClock.elapsedRealtime()));
        r105.getDefaultParamsMap().put(r105.f569724e, r106);
        r105.getDefaultParamsMap().put(r105.f569725f, Long.valueOf(r102));
        Chat r107 = this.f416402d;
        if (r107 == null) goto L48;
        r111.f416437v = r107.getType();
        r111.f416438w = this.f416402d.getMemberCount();
        r111.f416439x = this.f416402d.isSecret();
    L48:
        r111.f416422g = r101;
        r111.f416419d = r102;
        r111.f416420e = r104;
        if (r100.getcId() == null) goto L51;
        String r108 = r100.getcId();
    L52:
        r111.f416423h = r108;
        return;
    L51:
        r108 = "";
        goto L52
    L9:
        if (r101 != Message.Type.TEXT) goto L13;
        r103 = ImSdkMessageUtils.a(r100).length();
        goto L11
    L13:
        if (r101 != Message.Type.IMAGE) goto L25;
        ImageSet r109 = ((ImageContent) r100.getContent()).getImageSet();
        if (r109 != null) goto L17;
    L23:
        r104 = 0;
        goto L45
    L17:
        if (r109.getOrigin() == null) goto L23;
        if (CollectionUtils.isNotEmpty(r109.getOrigin().getUrls()) == false) goto L23;
        String r112 = (String) ListProtector.get(r109.getOrigin().getUrls(), 0);
        VFSFiles r113 = VFSFiles.f444819b;
        r113.getClass();
        if (VFSFiles.b(true).i(r112).exists() == false) goto L23;
        r113.getClass();
        r104 = VFSFiles.b(true).i(r112).length();
        goto L45
    L25:
        if (r100.getType() != Message.Type.AUDIO) goto L30;
        AudioContent r114 = (AudioContent) r100.getContent();
        if (TextUtils.isEmpty(r114.getLocalFilePath()) == true) goto L35;
        VFSFiles.f444819b.getClass();
        r104 = VFSFiles.b(true).i(r114.getLocalFilePath()).length();
    L36:
        Log.d("MonitorMessageSendCallback", "getContentSize:" + r100.getType() + HTTP.URL_DEFAULT + r104);
        if (r100.getType() != Message.Type.MEDIA) goto L40;
        ((MediaContent) r100.getContent()).getMime();
    L43:
        if (r104 != 0) goto L45;
        r104 = r111.f416420e;
        goto L45
    L40:
        if (r100.getType() != Message.Type.FILE) goto L43;
        ((FileContent) r100.getContent()).getMime();
    L35:
        r104 = 0;
        goto L36
    L30:
        if (r100.getType() != Message.Type.FILE) goto L33;
        r104 = ((FileContent) r100.getContent()).getSize();
        goto L36
    L33:
        if (r100.getType() != Message.Type.MEDIA) goto L35;
        r104 = ((MediaContent) r100.getContent()).getSize();
        goto L36
    }

    public void u(o6b.b r110) {
        z1b.a r100 = this.f416400b;
        if (r100.getDefaultParamsMap().get(r100.f569720a) == null) goto L6;
        r100.getDefaultParamsMap().put(r100.f569723d, Integer.valueOf(r100.f569726g));
        r100.a();
    L6:
        Iterator r101 = ((CopyOnWriteArrayList) this.f416414p).iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((n6b.c) r101.next()).g(r110);
        goto L8
    L10:
        Message r102 = r110.f522226a;
        if (TextUtils.isEmpty(r102.getParentId()) == true) goto L13;
        Message r103 = ImSdkService.f().za(r102.getParentId());
    L14:
        Chat r104 = this.f416402d;
        ChatChatter r105 = this.f416403e;
        Map<String, String> r106 = com.ss.android.lark.im.sdk.statistics.b.f426135a;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.im.sdk.statistics.e(r104, r105, r102));
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.im.sdk.statistics.d(this.f416402d, this.f416403e, r102, r103));
        if (TextUtils.isEmpty(r102.getcId()) == false) goto L17;
    L22:
        c r107 = q(r102.getcId());
        if (r107 != null) goto L25;
        return;
    L25:
        r107.D = r110.f522228c;
        HashMap r108 = new HashMap();
        Trace r109 = r110.f522229d;
        if (r109 == null) goto L40;
        List<Trace.Span> r111 = r109.spans;
        if (r111 == null) goto L40;
        Iterator<Trace.Span> r112 = r111.iterator();
    L31:
        if (r112.hasNext() == false) goto L40;
        Trace.Span r113 = r112.next();
        if (TextUtils.isEmpty(r113.name) == true) goto L31;
        Long r114 = r113.duration_millis;
        if (r114 == null) goto L31;
        r108.put(r113.name, r114);
        if (CollectionUtils.isEmpty(r113.attributes) == true) goto L31;
        r108.putAll(r113.attributes);
    L40:
        r107.H = r108;
        r107.f416424i = r110.f522227b;
        t(r102.getType(), null, r102.getcId());
        if (r107.f416422g != Message.Type.MEDIA) goto L69;
        String r115 = r107.f416423h;
        if (r115 == null) goto L69;
        long r116 = r107.D;
        HashMap<String, MediaMessageReport> r117 = z0.f416597a;
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r115, "mgsId");     // Catch: Throwable -> L66
        HashMap<String, MediaMessageReport> r118 = z0.f416597a;     // Catch: Throwable -> L66
        MediaMessageReport r119 = r118.get(r115);     // Catch: Throwable -> L66
        if (r119 == null) goto L63;
        r119.setResult("success");     // Catch: Throwable -> L66
        r119.setSendDuration(r116);     // Catch: Throwable -> L66
        long r120 = 0;
        if (r119.isMergePreCompress() == 1) goto L51;
    L55:
        r119.setPreDuration(r120);     // Catch: Throwable -> L66
        if (r119.isCompressUpload() == 1) goto L58;
        r119.setUploadDuration((SystemClock.elapsedRealtime() - r119.getSendStart()) - r119.getSendDuration());     // Catch: Throwable -> L66
        r119.setTotalDuration(((r119.getPickDuration() + r119.getCompressDuration()) + r119.getUploadDuration()) + r119.getSendDuration());     // Catch: Throwable -> L66
    L62:
        r119.setCompressDuration(r119.getCompressDuration() + r119.getPreDuration());     // Catch: Throwable -> L66
        JSONObject r121 = z0.a(r119);     // Catch: Throwable -> L66
        Log.i("MediaMessageMonitor", "report media success msg: " + r121);     // Catch: Throwable -> L66
        Statistics.sendEvent("send_video_info_dev", r121);     // Catch: Throwable -> L66
        goto L63
    L58:
        if (r119.isCompressUploadSuccess() != 1) goto L60;
        r119.setTotalDuration(((r119.getPickDuration() + r119.getCompressUploadDuration()) + r119.getSendDuration()) - r119.getPreDuration());     // Catch: Throwable -> L66
        goto L62
    L60:
        r119.setUseCache(1);     // Catch: Throwable -> L66
        r119.setTotalDuration(r119.getPickDuration() + r119.getSendDuration());     // Catch: Throwable -> L66
        goto L62
    L51:
        if (r119.getPreStart() == 0) goto L55;
        if (r119.getPreMerged() <= r119.getPreStart()) goto L55;
        r120 = r119.getPreMerged() - r119.getPreStart();     // Catch: Throwable -> L66
    L63:
        r118.remove(r115);     // Catch: Throwable -> L66
        ResourcePerfMonitor.VIDEO_SEND.onEnd();     // Catch: Throwable -> L66
        monitor-exit(z0.class);
    L66:
        th = move-exception;
        throw th;
    L69:
        a r122 = this.f416409k;
        if (r122 == null) goto L75;
        String r123 = r110.f522227b;
        e2b.f r124 = (e2b.f) r122;
        ResourcePerfMonitor.IMAGE_SEND.onEnd();
        if (r123 != null) goto L74;
        r123 = "";
    L74:
        r124.f470859a.onSuccess(new com.ss.android.lark.image.uploader.entity.c(r123));
    L75:
        w(r102.getcId());
        return;
    L17:
        if (TextUtils.isEmpty(r102.getId()) == true) goto L22;
        String r125 = r102.getcId();
        String r126 = r110.f522227b;
        long r127 = SystemClock.elapsedRealtime();
        CopyOnWriteArrayList<mkb.a> r128 = mkb.d.f514353a;
        Intrinsics.checkNotNullParameter(r125, "cId");
        Intrinsics.checkNotNullParameter(r126, "serverId");
        Iterator<mkb.a> r129 = mkb.d.f514353a.iterator();
    L20:
        if (r129.hasNext() == false) goto L22;
        r129.next().a(r125, r126, r127);
        goto L20
    L13:
        r103 = null;
        goto L14
    }

    public final void w(String r100) {
        String r101 = "default";
        if (TextUtils.isEmpty(r100) == true) goto L10;
        String r102 = (String) ((ConcurrentHashMap) this.f416412n).get(r100);
        if (r102 == null) goto L10;
        r101 = r102;
    L10:
        if (TextUtils.isEmpty(r100) == true) goto L13;
        ((ConcurrentHashMap) this.f416412n).remove(r100);
    L13:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        ((ConcurrentHashMap) this.f416413o).remove(r101);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [com.ss.android.lark.chat.service.impl.k1, java.lang.Object] */
    @Override // n6b.c
    public void a(ErrorResult r110, final Message r111) {
        Log.e("MonitorMessageSendCallback", "send message failed:" + r111.toString() + ", error code is " + r110.getCode() + ", ");
        Iterator r100 = ((CopyOnWriteArrayList) this.f416414p).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((n6b.c) r100.next()).a(r110, r111);
        goto L4
    L6:
        String r101 = r111.getcId();
        Iterator<mkb.a> r102 = mkb.d.f514353a.iterator();
    L8:
        if (r102.hasNext() == false) goto L11;
        r102.next().f(r101);
        goto L8
    L11:
        if (TextUtils.isEmpty(r110.getDebugMsg()) == true) goto L14;
        Log.e("MonitorMessageSendCallback", "send message failed, debug message is " + r110.getDebugMsg());
    L14:
        if (TextUtils.isEmpty(r110.getServerRequestId()) == true) goto L16;
        Log.e("MonitorMessageSendCallback", "send message failed, request id is " + r110.getServerRequestId());
    L16:
        z1b.a r103 = this.f416400b;
        if (r103.getDefaultParamsMap().get(r103.f569720a) == null) goto L20;
        r103.getDefaultParamsMap().put(r103.f569723d, Integer.valueOf(r103.f569727h));
        r103.a();
    L20:
        t(r111.getType(), r110, r111.getcId());
        int r104 = r110.getErrorCode();
        if (r104 != 507) goto L23;
    L74:
        Log.i("MonitorMessageSendCallback", "handleUIMessageSendFail called, errorCode:" + r104);
    L75:
        String r105 = r110.getMessage();
        if (TextUtils.isEmpty(r105) == false) goto L78;
        r105 = r110.getDebugMsg();
    L78:
        c r106 = q(r111.getcId());
        if (r106 != null) goto L82;
        return;
    L82:
        if (r106.f416422g != Message.Type.MEDIA) goto L106;
        String r107 = r106.f416423h;
        if (r107 == null) goto L106;
        Integer r108 = Integer.valueOf(r110.getErrorCode());
        int r109 = r110.getStatus();
        HashMap<String, MediaMessageReport> r112 = z0.f416597a;
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r107, "mgsId");     // Catch: Throwable -> L103
        HashMap<String, MediaMessageReport> r113 = z0.f416597a;     // Catch: Throwable -> L103
        MediaMessageReport r114 = r113.get(r107);     // Catch: Throwable -> L103
        if (r114 == null) goto L100;
        r114.setResult("failed");     // Catch: Throwable -> L103
        r114.setErrorType("rust");     // Catch: Throwable -> L103
        if (r108 == null) goto L92;
        int r115 = r108.intValue();     // Catch: Throwable -> L103
    L93:
        r114.setErrorCode(r115);     // Catch: Throwable -> L103
        if (r105 != null) goto L96;
        r105 = "";
    L96:
        r114.setErrorMsg(r105);     // Catch: Throwable -> L103
        if (Intrinsics.areEqual("rust", "rust") == false) goto L99;
        r114.setErrorStatus(r109);     // Catch: Throwable -> L103
    L99:
        JSONObject r116 = z0.a(r114);     // Catch: Throwable -> L103
        Log.i("MediaMessageMonitor", "report media failed msg: " + r116);     // Catch: Throwable -> L103
        Statistics.sendEvent("send_video_info_dev", r116);     // Catch: Throwable -> L103
        goto L100
    L92:
        r115 = -1;
    L100:
        r113.remove(r107);     // Catch: Throwable -> L103
        ResourcePerfMonitor.VIDEO_SEND.onEnd();     // Catch: Throwable -> L103
        monitor-exit(z0.class);
    L103:
        th = move-exception;
        throw th;
    L106:
        a r117 = this.f416409k;
        if (r117 == null) goto L109;
        ResourcePerfMonitor.IMAGE_SEND.onEnd();
        ((e2b.f) r117).f470859a.onError(r110);
    L109:
        w(r111.getcId());
        return;
    L23:
        if (r104 == 5009) goto L74;
        if (r104 == 260008) goto L74;
        if (r104 == 260009) goto L74;
        if (r104 == 311120) goto L74;
        if (r104 != 260003) goto L38;
        c r118 = q(r111.getcId());
        if (r118 != null) goto L36;
    L37:
        Log.i("MonitorMessageSendCallback", "handleUIMessageSendFail called, errorCode:" + r104);
        goto L75
    L36:
        if (r118.f416421f == false) goto L37;
    L38:
        boolean r119 = com.ss.android.lark.chat.utils.n0.f416706a;
        boolean r120 = false;
        if (ImSdkProxy.c().isHitStorageQuotaLimit(r110.getErrorCode()) == true) goto L41;
        boolean r121 = false;
    L42:
        if (r121 == true) goto L75;
        if (r110.getErrorCode() == ImSdkProxy.c().getUnifiedStorageLimitErrorCode()) goto L47;
        boolean r122 = false;
    L48:
        if (r122 == true) goto L75;
        if (r110.getErrorCode() == 4029) goto L53;
        boolean r123 = false;
    L54:
        if (r123 == true) goto L75;
        if (com.ss.android.lark.chat.utils.n0.a(r110) == true) goto L75;
        Intrinsics.checkNotNullParameter(r110, "errorResult");
        switch(r110.getErrorCode()) {
            case 321000: goto L63;
            case 321001: goto L62;
            default: goto L65;
        };
    L62:
        Log.i("MessageUtils", "errorCode = " + r110.getErrorCode() + ", upload deny by file policy");
    L64:
        r120 = true;
        goto L65
    L63:
        UICallbackExecutor.execute(new com.ss.android.lark.chat.utils.m0(r110));
    L65:
        if (r120 == true) goto L75;
        if (r104 != 5664) goto L71;
        ?? r124 = new k1(this, r111);
        Intrinsics.checkNotNullParameter(r124, "reSendHandler");
        Log.i("MessageUtils", "handleMessageResourceHardLinkFailed");
        UICallbackExecutor.execute(new com.ss.android.lark.chat.utils.o0(r124));
        goto L75
    L71:
        if (ImSdkProxy.c().isInterceptSendCallback(r110.getErrorCode()) == true) goto L75;
        UICallbackExecutor.execute(new l1(r110));
        goto L75
    L53:
        UICallbackExecutor.execute(new com.ss.android.lark.chat.utils.p0(r110));
        r123 = true;
        goto L54
    L47:
        ImSdkProxy.c().showUnifiedStorageLimitCTADialog(ImSdkProxy.b().getTopActivity());
        r122 = true;
        goto L48
    L41:
        r121 = ImSdkProxy.c().showQuotaLimitDialog(ImSdkProxy.b().getTopActivity(), r110.getErrorCode());
        goto L42
    }

    @Override // n6b.b
    public void d(String r110, MessageParams<?, ?> r111) {
        c r100 = q(r110);
        if (r100 != null) goto L5;
        return;
    L5:
        r100.f416440y = SystemClock.elapsedRealtime();
        r100.f416421f = r111.f415254m;
        String r101 = null;
        PerfLog.start("sync_create_quasi_message", this.f416401c, null);
        if (TextUtils.isEmpty(r110) == false) goto L8;
        return;
    L8:
        if (r111.f415254m == false) goto L10;
        r101 = r111.f415249h;
    L10:
        String r112 = this.f416401c;
        long r102 = SystemClock.elapsedRealtime();
        CopyOnWriteArrayList<mkb.a> r103 = mkb.d.f514353a;
        Intrinsics.checkNotNullParameter(r112, "contextId");
        Intrinsics.checkNotNullParameter(r110, "cId");
        Iterator<mkb.a> r104 = mkb.d.f514353a.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        r104.next().d(r112, r110, r101, r102);
        goto L12
    }

    @Override // n6b.c
    public void k(jkb.e r100, Message r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f416414p).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((n6b.c) r102.next()).k(r100, r101);
        goto L4
    }

    @Override // n6b.a
    public final void n(long r100, long r101) {
        String r102 = UIHelper.mustacheFormat(com.ss.android.lark.chat.utils.t.f416735a, "max_single_size", FileUtils.h(r101));
        LKUIToast.show(ImSdk.f425890a.getContext(), r102);
        String r103 = FileUtils.h(r100);
        int r104 = t5c.a.f544651a;
        Intrinsics.checkNotNullParameter(r103, "fileSize");
        Statistics.sendEvent("im_send_file_rejected", new JSONObject().put("file_size", r103));
    }

    public final void t(Message.Type r210, ErrorResult r211, String r212) {
        c r100 = q(r212);
        if (r100 != null) goto L5;
        return;
    L5:
        r100.C = SystemClock.elapsedRealtime() - r100.C;
        r100.F = SystemClock.elapsedRealtime() - r100.F;
        if (r211 != null) goto L8;
        int r101 = 1;
    L9:
        r100.G = r101;
        PerfLog.end("async_call_send_message", this.f416401c, null);
        PerfLog.end("send_" + z1b.b.a(r210), this.f416401c, null);
        Log.d("MessageSendPerf", "sendEnd:" + ThreadMethodProxy.currentThread());
        c r102 = q(r212);
        if (r102 == null) goto L16;
        CopyOnWriteArrayList<mkb.b> r103 = mkb.c.f514352a;
        Intrinsics.checkNotNullParameter(r102, "reportData");
        Iterator<mkb.b> r104 = mkb.c.f514352a.iterator();
    L13:
        if (r104.hasNext() == false) goto L16;
        r104.next().a();
    L16:
        if (this.f416408j == null) goto L22;
        Log.d("MonitorMessageSendCallback", "removeLifecycleListener");
        b r105 = this.f416408j;
        if (r105 == null) goto L20;
        ImSdkProxy.b().e(r105);
    L20:
        this.f416408j = null;
    L22:
        if (r211 != null) goto L27;
        AppreciableKit r106 = AppreciableKit.getInstance();
        String r107 = r100.f416417b;
        if (r107 != null) goto L26;
        r107 = "";
    L26:
        r106.end(r107, r100.d(true, false), r100.a(false), r100.c(), r100.b());
    L28:
        HashMap r108 = new HashMap();
        r108.putAll(r100.d(true, true));
        r108.putAll(r100.b());
        r108.putAll(r100.c());
        r108.putAll(r100.a(true));
        r108.put("is_in_background", Boolean.valueOf(this.f416407i));
        r108.put(IOnekeyLoginService.ResponseConstants.NET_STATUS, Integer.valueOf(f416398q.get()));
        if (r100.f416435t > 1) goto L31;
    L56:
        Statistics.sendEvent("perf_send_msg_dev", new JSONObject(r108));
        return;
    L31:
        if (r100.f416422g != Message.Type.IMAGE) goto L56;
        if (r108.containsKey("fully_upload_image_network_time_consumption") == false) goto L38;
        if ((r108.get("fully_upload_image_network_time_consumption") instanceof Long) == false) goto L38;
        long r109 = ((Long) r108.get("fully_upload_image_network_time_consumption")).longValue();
    L44:
        if (r108.containsKey("message_waiting_to_be_sent") == true) goto L46;
    L48:
        long r110 = 0;
    L50:
        if (r110 <= 0) goto L56;
        if (r110 <= r109) goto L56;
        long r111 = r110 - r109;
        if (r111 >= r100.F) goto L56;
        Log.d("MonitorMessageSendCallback", "upload multiple res, messageWaitTime:" + r110 + "， uploadTime:" + r109 + ", totalCost:" + r100.F);
        long r112 = r100.F - r111;
        r100.F = r112;
        r108.put("total_cost", Long.valueOf(r112));
        goto L56
    L46:
        if ((r108.get("message_waiting_to_be_sent") instanceof Long) == false) goto L48;
        r110 = ((Long) r108.get("message_waiting_to_be_sent")).longValue();
    L38:
        if (r108.containsKey("partial_upload_info") == true) goto L40;
    L42:
        r109 = 0;
        goto L44
    L40:
        if ((r108.get("partial_upload_info") instanceof Long) == false) goto L42;
        r109 = ((Long) r108.get("partial_upload_info")).longValue();
        goto L44
    L27:
        ErrorParams r113 = new ErrorParams(this.f416404f, this.f416405g, Event.message_send, ErrorType.Network, ErrorLevel.Fatal, r211.getErrorCode(), null, "chatWindow", r211.getDebugMsg(), Boolean.TRUE, r100.a(false), r100.c(), r100.b());
        r113.setErrorStatus(r211.getStatus());
        AppreciableKit.getInstance().error(r113);
        goto L28
    L8:
        r101 = 2;
        goto L9
    }

    public final void v(String r110, String r111, Message.Type r112) {
        String r100 = null;
        PerfLog.start("send_" + z1b.b.a(r112), this.f416401c, null);
        Log.d("MessageSendPerf", "sendStart:" + ThreadMethodProxy.currentThread());
        if (TextUtils.isEmpty(r110) == true) goto L5;
        ((ConcurrentHashMap) this.f416412n).put(r110, r111);
    L5:
        c r113 = new c();
        r113.f416418c = this.f416401c;
        r113.F = SystemClock.elapsedRealtime();
        Chat r101 = this.f416402d;
        if (r101 != null) goto L8;
    L14:
        r113.f416422g = r112;
        r113.f416416a = AppreciableKit.getInstance().start(this.f416404f, this.f416405g, Event.message_on_screen, "chatWindow", false);
        r113.f416417b = AppreciableKit.getInstance().start(this.f416404f, this.f416405g, Event.message_send, "chatWindow", true);
        r113.I = this.f416406h;
        Chat r114 = this.f416402d;
        if (r114 == null) goto L17;
        r114.getId();
    L17:
        r113.f416435t = this.f416410l;
        r113.f416436u = this.f416411m;
        if (TextUtils.isEmpty(r111) == false) goto L20;
        r111 = "default";
    L20:
        ((ConcurrentHashMap) this.f416413o).put(r111, r113);
        CopyOnWriteArrayList<mkb.b> r115 = mkb.c.f514352a;
        Intrinsics.checkNotNullParameter(r113, "reportData");
        Iterator<mkb.b> r116 = mkb.c.f514352a.iterator();
    L22:
        if (r116.hasNext() == false) goto L24;
        r116.next().b();
        goto L22
    L24:
        String r117 = this.f416401c;
        Chat r118 = this.f416402d;
        if (r118 == null) goto L27;
        r100 = r118.getId();
    L27:
        Chat r119 = this.f416402d;
        if (r119 != null) goto L30;
    L32:
        int r120 = -1;
    L33:
        long r102 = SystemClock.elapsedRealtime();
        CopyOnWriteArrayList<mkb.a> r121 = mkb.d.f514353a;
        Intrinsics.checkNotNullParameter(r117, "contextId");
        Iterator<mkb.a> r122 = mkb.d.f514353a.iterator();
    L35:
        if (r122.hasNext() == false) goto L37;
        r122.next().c(r117, r100, r120, r102);
        goto L35
    L37:
        return;
    L30:
        if (r119.getType() == null) goto L32;
        r120 = this.f416402d.getType().getNumber();
        goto L33
    L8:
        if (r101.isSecret() == false) goto L11;
        this.f416405g = Scene.SecretChat;
        goto L14
    L11:
        if (this.f416402d.isThread() == false) goto L13;
        this.f416405g = Scene.Thread;
        goto L14
    L13:
        this.f416405g = Scene.Chat;
        goto L14
    }
}
