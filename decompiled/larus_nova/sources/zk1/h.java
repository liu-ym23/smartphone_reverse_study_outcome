package zk1;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.chatroom.replay.cache.ui.ReplayListCacheWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.q;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.util.y;
import com.bytedance.android.livesdkapi.depend.model.live.episode.DefinitionInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IDefinitionInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoRef;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mq1.p;
import mq1.t;

/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IDefinitionInfo f572580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<IDefinitionInfo> f572581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, IDefinitionInfo> f572582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f572583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f572584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<a> f572585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, a> f572586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, sp1.a> f572587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<String, tp1.a> f572588i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView.Adapter<RecyclerView.ViewHolder> f572589j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ReplayListCacheWidget f572590k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f572591l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f572592m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public yk1.a f572593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f572594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f572595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f572596d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<Object> f572597e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f572598f;

        /* JADX INFO: renamed from: zk1.h$a$a, reason: collision with other inner class name */
        public static final class C8472a {
        }

        static {
        }

        public a() {
            this.f572594b = new c();
            this.f572596d = 1;
            this.f572597e = new ArrayList();
        }
    }

    public interface b {
        void a();

        void onError();

        void onSuccess();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f572599a;

        public c() {
        }
    }

    public final void b() {
        if (this.f572592m == true) goto L19;
        t r100 = s.e();
        if (r100 == null) goto L28;
        ReplayListCacheWidget r101 = this.f572590k;
        if (r101 == null) goto L9;
        DataCenter r102 = r101.dataCenter;
    L10:
        p r103 = r100.a(r102);
        if (r103 == null) goto L29;
        Observable<List<EpisodeGroup>> r104 = r103.getPlayList();
        if (r104 == null) goto L30;
        Observable<List<EpisodeGroup>> r105 = r104.subscribeOn(Schedulers.io());
        if (r105 == null) goto L31;
        Observable<List<EpisodeGroup>> r106 = r105.observeOn(AndroidSchedulers.mainThread());
        if (r106 == null) goto L32;
        r106.subscribe(new i(this), new j(this));
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L9:
        r102 = null;
        goto L10
    L28:
        return;
    L19:
        Map<String, VideoRef> r107 = wk1.b.f560072a;
        List r108 = wk1.b.c();
        if (r108 == null) goto L25;
        Iterator r109 = ((ArrayList) r108).iterator();
    L23:
        if (r109.hasNext() == false) goto L25;
        tp1.a r110 = (tp1.a) r109.next();
        List<String> r111 = zk1.a.f572567a;
        Intrinsics.checkNotNullParameter(r110, "cacheInfo");
        a r112 = new a();
        yk1.a r113 = new yk1.a();
        r113.f568119a = r110;
        r113.f568120b = s.b().getLocalPlayProgress(r110.f547011l);
        r112.f572593a = r113;
        r112.f572596d = 1;
        r112.f572595c = r110.f547003d;
        ((ArrayList) this.f572585f).add(r112);
        this.f572586g.put(r110.f547000a, r112);
        i(r110);
    L25:
        h();
    }

    public final void c() {
        Iterator r100 = ((ArrayList) this.f572585f).iterator();
    L4:
        if (r100.hasNext() == false) goto L41;
        a r101 = (a) r100.next();
        yk1.a r102 = r101.f572593a;
        DataCenter r103 = null;
        if (r102 == null) goto L10;
        tp1.a r104 = r102.f568119a;
        if (r104 == null) goto L10;
        String r105 = r104.f547007h;
    L11:
        if (r102 == null) goto L17;
        tp1.a r106 = r102.f568119a;
        if (r106 == null) goto L17;
        tp1.b r107 = r106.f547013n;
        if (r107 == null) goto L17;
        Integer r108 = Integer.valueOf(r107.f547020c);
    L18:
        yk1.a r109 = r101.f572593a;
        if (r109 == null) goto L23;
        tp1.a r110 = r109.f568119a;
        if (r110 == null) goto L23;
        Long r111 = Long.valueOf(r110.f547011l);
    L24:
        HashMap r112 = new HashMap();
        r112.put("is_vs", "1");
        r112.put("vs_downloadlist_episode_id", String.valueOf(r111));
        if (r108 == null) goto L27;
        int r113 = r108.intValue();
    L28:
        r112.put("vs_download_status", com.bytedance.android.livesdk.chatroom.replay.cache.c.a(r113));
        if (r105 != null) goto L31;
        r105 = "";
    L31:
        r112.put("vs_downloadlist_screen_clarity", r105);
        ReplayListCacheWidget r114 = this.f572590k;
        if (r114 == null) goto L34;
        DataCenter r115 = r114.dataCenter;
    L36:
        if (r115 != null) goto L37;
        com.bytedance.android.livesdk.chatroom.replay.cache.c.c("vs_video_download_status_show", r112);
        goto L4
    L37:
        if (r114 == null) goto L39;
        r103 = r114.dataCenter;
    L39:
        com.bytedance.android.livesdk.chatroom.replay.cache.c.b(r103, "vs_video_download_status_show", r112);
        goto L4
    L34:
        r115 = null;
        goto L36
    L27:
        r113 = 0;
    L23:
        r111 = null;
    L17:
        r108 = null;
    L10:
        r105 = null;
        goto L11
    }

    public final void h() {
        if (((ArrayList) this.f572585f).isEmpty() == false) goto L8;
        b r100 = this.f572591l;
        if (r100 == null) goto L122;
        r100.a();
        return;
    L122:
        return;
    L8:
        if (this.f572592m == false) goto L27;
        c();
        HashMap r101 = new HashMap();
        Iterator r102 = ((ArrayList) this.f572585f).iterator();
    L11:
        if (r102.hasNext() == false) goto L23;
        a r103 = (a) r102.next();
        yk1.a r104 = r103.f572593a;
        if (r104 == null) goto L11;
        tp1.a r105 = r104.f568119a;
        if (r105 == null) goto L11;
        String r106 = r105.f547004e;
        if (r106 == null) goto L11;
        List r107 = (List) r101.get(r106);
        if (r107 != null) goto L22;
        r107 = new ArrayList();
        r101.put(r106, r107);
    L22:
        r107.add(r103);
        goto L11
    L23:
        ((ArrayList) this.f572585f).clear();
        Iterator r108 = r101.entrySet().iterator();
    L25:
        if (r108.hasNext() == false) goto L79;
        Map.Entry r109 = (Map.Entry) r108.next();
        String r110 = (String) r109.getKey();
        List r111 = (List) r109.getValue();
        String r112 = ((a) ListProtector.get(r111, 0)).f572595c;
        a r113 = new a();
        r113.f572595c = r112;
        r113.f572596d = 3;
        ((ArrayList) this.f572585f).add(r113);
        ((ArrayList) this.f572585f).addAll(r111);
    L79:
        b r114 = this.f572591l;
        if (r114 == null) goto L82;
        r114.onSuccess();
    L82:
        RecyclerView.Adapter<RecyclerView.ViewHolder> r115 = this.f572589j;
        if (r115 == null) goto L124;
        r115.notifyDataSetChanged();
        return;
    L124:
        return;
    L27:
        List<String> r116 = zk1.a.f572567a;
        Iterator r117 = ((ArrayList) this.f572585f).iterator();
    L28:
        boolean r118 = true;
        if (r117.hasNext() == false) goto L46;
        yk1.a r119 = ((a) r117.next()).f572593a;
        if (r119 == null) goto L28;
        List<IDefinitionInfo> r120 = r119.f568119a.f547008i;
        HashMap<String, IDefinitionInfo> r121 = this.f572582c;
        Intrinsics.checkNotNullParameter(r121, "map");
        List<IDefinitionInfo> r122 = r120;
        if (r122 != null) goto L35;
    L38:
        if (r118 == true) goto L28;
        Iterator<IDefinitionInfo> r123 = r120.iterator();
    L42:
        if (r123.hasNext() == false) goto L28;
        IDefinitionInfo r124 = r123.next();
        String r125 = r124.getKey();
        if (r125 == null) goto L42;
        r121.put(r125, r124);
        goto L42
    L35:
        if (r122.isEmpty() == true) goto L38;
        r118 = false;
        goto L38
    L46:
        Iterator<String> r126 = r116.iterator();
    L48:
        if (r126.hasNext() == false) goto L52;
        IDefinitionInfo r127 = this.f572582c.get(r126.next());
        if (r127 == null) goto L48;
        ((ArrayList) this.f572581b).add(r127);
        goto L48
    L52:
        Context r128 = this.f572583d;
        IDefinitionInfo r129 = null;
        if (r128 == null) goto L55;
        Intrinsics.checkNotNullParameter(r128, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r130 = SharedPrefHelper.c(r128.getApplicationContext(), "vs_cache_local_data").f249252a.getString("vs_definition_key", null);
        String r131 = SharedPrefHelper.c(r128.getApplicationContext(), "vs_cache_local_data").f249252a.getString("vs_definition_text", null);
        DefinitionInfo r132 = new DefinitionInfo();
        r132.setKey(r130);
        r132.setText(r131);
        this.f572580a = r132;
    L55:
        IDefinitionInfo r133 = this.f572580a;
        if (r133 == null) goto L58;
        String r134 = r133.getKey();
    L59:
        if (r134 == null) goto L61;
    L70:
        Iterator r135 = ((ArrayList) this.f572585f).iterator();
    L72:
        if (r135.hasNext() == false) goto L78;
        yk1.a r136 = ((a) r135.next()).f572593a;
        if (r136 == null) goto L72;
        tp1.a r137 = r136.f568119a;
        if (r137.f547013n.f547020c != 0) goto L72;
        List<String> r138 = zk1.a.f572567a;
        r137.f547007h = zk1.a.e(this.f572580a, r137);
        tp1.a r139 = r136.f568119a;
        r139.f547013n.f547019b = zk1.a.f(r139.f547007h, r139);
        goto L72
    L78:
        c();
        a r140 = new a();
        r140.f572596d = 0;
        ListProtector.add(this.f572585f, 0, r140);
        a r141 = new a();
        r141.f572596d = 2;
        ((ArrayList) this.f572585f).add(r141);
        goto L79
    L61:
        if ((!((ArrayList) this.f572581b).isEmpty()) == false) goto L69;
        Iterator<String> r142 = zk1.a.f572568b.iterator();
    L64:
        if (r142.hasNext() == false) goto L68;
        r129 = this.f572582c.get(r142.next());
        if (r129 == null) goto L64;
    L68:
        r129 = (IDefinitionInfo) ListProtector.get(this.f572581b, 0);
    L69:
        this.f572580a = r129;
        goto L70
    L58:
        r134 = null;
        goto L59
    }

    public h(boolean r100) {
        this.f572592m = r100;
        this.f572581b = new ArrayList();
        this.f572582c = new HashMap();
        this.f572585f = new ArrayList();
        this.f572586g = new HashMap();
        this.f572587h = new HashMap();
        this.f572588i = new HashMap();
    }

    public final void a(String r100) {
        a r101 = this.f572586g.get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        ((ArrayList) r101.f572597e).clear();
        r101.f572598f = 0;
    }

    public final void f(int r100) {
        RecyclerView.Adapter<RecyclerView.ViewHolder> r101 = this.f572589j;
        if (r101 == null) goto L5;
        r101.notifyItemRemoved(r100);
    L5:
        RecyclerView.Adapter<RecyclerView.ViewHolder> r102 = this.f572589j;
        if (r102 == null) goto L9;
        r102.notifyItemRangeChanged(r100, ((ArrayList) this.f572585f).size());
        return;
    }

    public final void g(int r100) {
        if (r100 < ((ArrayList) this.f572585f).size()) goto L5;
        return;
    L5:
        yk1.a r101 = ((a) ListProtector.get(this.f572585f, r100)).f572593a;
        if (r101 == null) goto L8;
        this.f572588i.remove(r101.f568119a.f547000a);
        this.f572587h.remove(r101.f568119a.f547000a);
        wk1.b.f560073b.a(r101.f568119a.f547000a);
        tp1.b r102 = r101.f568119a.f547013n;
        r102.f547020c = 0;
        r102.f547018a = 0;
    L8:
        RecyclerView.Adapter<RecyclerView.ViewHolder> r103 = this.f572589j;
        if (r103 == null) goto L12;
        r103.notifyItemChanged(r100);
        return;
    }

    public final void i(tp1.a r100) {
        Map<String, VideoRef> r101 = wk1.b.f560072a;
        String r102 = r100.f547000a;
        sp1.a r103 = this.f572587h.get(r102);
        if (r103 != null) goto L7;
        r103 = new k(this);
        String r104 = r100.f547000a;
        if (r104 == null) goto L7;
        this.f572587h.put(r104, r103);
    L7:
        Intrinsics.checkNotNullParameter(r102, "videoId");
        Intrinsics.checkNotNullParameter(r103, "iDownloaderListener");
        LivePluginSPIManager.f85856e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new wk1.a(r102, r103)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("VSCacheDataManager");
        if (this.f572588i.get(r100.f547000a) != null) goto L11;
        tp1.a r105 = new tp1.a();
        zk1.a.a(r100, r105);
        this.f572588i.put(r100.f547000a, r105);
        return;
    }

    public final void j(tp1.a r100) {
        boolean r101 = false;
        if (r100.f547015p != EpisodeMod.EpisodeStageType.RECORD) goto L7;
        y.b("该节目暂时无法下载", 0);
        return;
    L7:
        if (r100.f547013n.f547020c != 0) goto L41;
        String r102 = r100.f547007h;
        IDefinitionInfo r103 = this.f572580a;
        String r104 = null;
        if (r103 == null) goto L11;
        String r105 = r103.getKey();
    L13:
        if ((!Intrinsics.areEqual(r102, r105)) == false) goto L25;
        Context r106 = this.f572583d;
        if (r106 == null) goto L25;
        IDefinitionInfo r107 = this.f572582c.get(r100.f547007h);
        if (r107 == null) goto L20;
        String r108 = r107.getText();
        if (r108 == null) goto L20;
    L21:
        StringCompanionObject r109 = StringCompanionObject.INSTANCE;
        String r110 = r106.getString(R.string.ttlive_vs_cache_definition);
        Object[] r111 = new Object[2];
        IDefinitionInfo r112 = this.f572580a;
        if (r112 == null) goto L24;
        r104 = r112.getText();
    L24:
        r111[0] = r104;
        r111[1] = r108;
        y.b(String.format(r110, Arrays.copyOf(r111, 2)), 0);
    L20:
        r108 = r100.f547007h;
    L25:
        ReplayListCacheWidget r113 = this.f572590k;
        if (r113 == null) goto L34;
        DataCenter r114 = r113.dataCenter;
        if (r114 == null) goto L34;
        Episode r115 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r114);
        if (r115 == null) goto L34;
        if (r115.notReportPV != true) goto L34;
        r101 = true;
    L34:
        HashMap r116 = new HashMap();
        String r117 = r100.f547010k;
        if (r117 != null) goto L37;
        r117 = "";
    L37:
        r116.put("item_id", r117);
        r116.put("download_delta", "1");
        r116.put("source", "0");
        r116.put("stats_channel", "download");
        mq1.c r118 = q.a();
        if (r118 == null) goto L40;
        r118.g(r116, r101);
    L40:
        e("download", r100);
    L42:
        Map<String, VideoRef> r119 = wk1.b.f560072a;
        sp1.a r120 = this.f572587h.get(r100.f547000a);
        if (r120 != null) goto L47;
        r120 = new k(this);
        String r121 = r100.f547000a;
        if (r121 == null) goto L47;
        this.f572587h.put(r121, r120);
    L47:
        Intrinsics.checkNotNullParameter(r100, "cacheInfo");
        Intrinsics.checkNotNullParameter(r120, "iDownloaderListener");
        LivePluginSPIManager.f85856e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new wk1.c(r100, r120)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("VSCacheDataManager");
        return;
    L11:
        r105 = null;
        goto L13
    L41:
        e("continue_download_click", r100);
        goto L42
    }

    public final void k(tp1.a r100) {
        if (r100.f547015p != EpisodeMod.EpisodeStageType.RECORD) goto L6;
        y.b("该节目暂时无法下载", 0);
        return;
    L6:
        e("download_pause", r100);
        Map<String, VideoRef> r101 = wk1.b.f560072a;
        String r102 = r100.f547000a;
        Intrinsics.checkNotNullParameter(r102, "videoId");
        LivePluginSPIManager.f85856e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new wk1.d(r102)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("VSCacheDataManager");
    }

    public static void l(h r100, tp1.a r101) {
        tp1.a r102 = r100.f572588i.get(r101.f547000a);
        if (r102 != null) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(r102, r101)) == false) goto L8;
        zk1.a.b(r101.f547013n, r102.f547013n);
    L8:
        a r103 = r100.f572586g.get(r101.f547000a);
        if (r103 == null) goto L27;
        yk1.a r104 = r103.f572593a;
        if (r104 == null) goto L22;
        zk1.a.b(r101.f547013n, r104.f568119a.f547013n);
        if (r103.f572598f <= 1) goto L18;
        int r105 = ((ArrayList) r100.f572585f).indexOf(r103);
        List<Object> r106 = r103.f572597e;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r107 = r100.f572589j;
        if (r107 == null) goto L23;
        r107.notifyItemChanged(r105, r106);
        return;
    L23:
        return;
    L18:
        int r108 = ((ArrayList) r100.f572585f).indexOf(r103);
        RecyclerView.Adapter<RecyclerView.ViewHolder> r109 = r100.f572589j;
        if (r109 == null) goto L25;
        r109.notifyItemChanged(r108, null);
        return;
    L25:
        return;
    L22:
        return;
    }

    public final void d(String r100, String r101) {
        HashMap r102 = new HashMap();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.put("vs_download_screen_clarity", r101);
        ReplayListCacheWidget r103 = this.f572590k;
        DataCenter r104 = null;
        if (r103 == null) goto L8;
        DataCenter r105 = r103.dataCenter;
    L9:
        if (r105 == null) goto L13;
        if (r103 == null) goto L12;
        r104 = r103.dataCenter;
    L12:
        com.bytedance.android.livesdk.chatroom.replay.cache.c.b(r104, r100, r102);
        return;
    L13:
        com.bytedance.android.livesdk.chatroom.replay.cache.c.c(r100, r102);
        return;
    L8:
        r105 = null;
        goto L9
    }

    public final void e(String r100, tp1.a r101) {
        HashMap r102 = new HashMap();
        r102.put("download_method", "click_download_icon");
        String r103 = r101.f547007h;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.put("vs_download_screen_clarity", r103);
        r102.put("vs_download_episode_id", String.valueOf(r101.f547011l));
        r102.put("download_vs_ep_group_id", r101.f547004e);
        ReplayListCacheWidget r104 = this.f572590k;
        DataCenter r105 = null;
        if (r104 == null) goto L8;
        DataCenter r106 = r104.dataCenter;
    L9:
        if (r106 == null) goto L13;
        if (r104 == null) goto L12;
        r105 = r104.dataCenter;
    L12:
        com.bytedance.android.livesdk.chatroom.replay.cache.c.b(r105, r100, r102);
        return;
    L13:
        com.bytedance.android.livesdk.chatroom.replay.cache.c.c(r100, r102);
        return;
    L8:
        r106 = null;
        goto L9
    }
}
