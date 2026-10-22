package vtb;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.bundle.ChatType;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import idb.f;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f557289a = null;

    public static class a {
        public final Map<String, C8041a> A;
        public Long B;
        public String C;
        public int D;
        public boolean E;
        public final SourceType F;
        public ChatType G;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f557290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f557291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f557292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f557293d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f557294e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f557295f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Long f557296g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Long f557297h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Long f557298i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Long f557299j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Long f557300k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Long f557301l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f557302m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f557303n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f557304o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f557305p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f557306q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public List<Long> f557307r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public long f557308s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public long f557309t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public long f557310u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f557311v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public long f557312w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public long f557313x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f557314y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final Map<Integer, Long> f557315z;

        /* JADX INFO: renamed from: vtb.c$a$a, reason: collision with other inner class name */
        public static class C8041a {
            public Integer getType() {
                return null;
            }
        }

        public final Map<String, Object> a() {
            HashMap r100 = new HashMap();
            r100.put("source_type", Integer.valueOf(this.F.index));
            r100.put("chat_type", Integer.valueOf(this.G.index));
            r100.put("is_external", Integer.valueOf(this.E ? 1 : 0));
            int r101 = 1;
            if (this.G != ChatType.MEETING) goto L5;
            int r102 = 1;
        L6:
            r100.put("is_meeting", Integer.valueOf(r102));
            if (this.G == ChatType.EDU_CHAT) goto L10;
            r101 = 0;
        L10:
            r100.put("is_edu", Integer.valueOf(r101));
            Map<String, a> r103 = c.f557289a;
            if (f.a().isCurrentEnable("openplatform.universal_card.enter_chat_monitor") == false) goto L17;
            Iterator r104 = ((HashMap) this.A).values().iterator();
            if (r104.hasNext() == true) goto L15;
            r100.put("rendered_card_size", 0);
            goto L17
        L15:
            ((C8041a) r104.next()).getClass();
            throw null;
        L17:
            return r100;
        L5:
            r102 = 0;
            goto L6
        }

        public final Map<String, Object> b() {
            HashMap r100 = new HashMap();
            r100.put("chatter_count", Integer.valueOf(this.D));
            String r101 = this.f557305p;
            String r102 = "";
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            r100.put("feed_id", r101);
            List<Long> r103 = this.f557307r;
            if (r103 == null) goto L8;
            r102 = Arrays.toString(r103.toArray());
        L8:
            r100.put("net_costs", r102);
            return r100;
        }

        public final String toString() {
            return "PerfLoadChat{startTime=" + this.f557290a + ", endTime=" + this.f557291b + ", duration=" + this.B + ", key='" + this.C + "', sourceType='" + this.F.value + "', chatType='" + this.G.value + "', loading='0', renderTime='" + this.f557311v + '\'' + this.f557312w + '\'' + this.f557313x + "'}";
        }

        public a(SourceType r100) {
            this.f557290a = 0L;
            this.f557291b = 0L;
            this.f557292c = 0L;
            this.f557293d = 0L;
            this.f557294e = 0L;
            this.f557295f = 0L;
            this.f557296g = 0L;
            this.f557297h = 0L;
            this.f557298i = 0L;
            this.f557299j = 0L;
            this.f557300k = 0L;
            this.f557301l = 0L;
            this.f557302m = false;
            this.f557303n = false;
            this.f557306q = 0;
            this.f557307r = null;
            this.f557308s = 0;
            this.f557309t = 0;
            this.f557310u = 0;
            this.f557311v = false;
            this.f557312w = 0;
            this.f557313x = 0;
            this.f557315z = new HashMap();
            this.A = new HashMap();
            this.B = 0L;
            this.C = null;
            this.D = 0;
            this.E = false;
            this.F = SourceType.FEED;
            this.G = ChatType.GROUP;
            this.f557290a = Long.valueOf(System.currentTimeMillis());
            this.F = r100;
        }
    }

    static {
        f557289a = new ConcurrentHashMap();
    }

    public static void a(String r110, SourceType r111) {
        if (r111 == null) goto L6;
        a r100 = new a(r111);
        r100.C = r110;
        ((ConcurrentHashMap) f557289a).put(r110, r100);
        r100.f557314y = AppreciableKit.getInstance().start(Biz.Messenger, Scene.Chat, Event.enter_chat, "chatWindow", false, null, null, null, null);
        Log.d("PerfEnterChatMonitor", "start: " + r110 + HTTP.URL_DEFAULT + r111);
        int r112 = vtb.a.f557287a;
        PerfLog.start("open_chat", "");
        PerfLog.start("first_window", "");
        return;
    }
}
