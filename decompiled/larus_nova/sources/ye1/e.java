package ye1;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.backupsei.core.BackupSeiIndicator;
import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.bytedance.android.livesdk.message.model.BackupSeiModel;
import com.bytedance.android.livesdkapi.backupsei.IBackupSeiGuestManager;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei.LiveBackupSeiExperimentUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import vlc.l;
import ze1.h;
import ze1.i;
import ze1.j;
import ze1.k;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements IBackupSeiGuestManager, h.b, ze1.a.b, ze1.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze1.a f567371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f567372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ze1.b f567373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final af1.b f567374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BackupSeiIndicator f567375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f567376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f567377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f567378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f567379i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IRoom f567380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ILivePlayerClient f567381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final af1.c f567382l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ye1.c f567383m;

    public static final class a {
    }

    public static final class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f567384a;

        public b(e r100) {
            this.f567384a = r100;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r110) {
            if ((r110 instanceof BackupSeiMessage) == false) goto L104;
            int r100 = af1.a.f3135a;
            this.f567384a.getClass();
            StringBuilder r101 = new StringBuilder("receiveBackupSeiMessage, msgId = ");
            BackupSeiMessage r111 = (BackupSeiMessage) r110;
            r101.append(r111.getMessageId());
            r101.append(", streamId = ");
            r101.append(r111.getStreamId());
            r101.append(", source = ");
            r101.append(r111.getSource());
            r101.append(", backupSeiListStr = ");
            r101.append(r111.getBackupSeiListStr());
            af1.a.b("BackupSeiGuest", r101.toString());
            this.f567384a.f567374d.getClass();
            Intrinsics.checkNotNullParameter(r111, "msg");
            ze1.a r102 = this.f567384a.f567371a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r111, "backupSeiMsg");
            r102.f571508b++;
            if ((System.currentTimeMillis() - r102.f571507a) <= ze1.a.f571505d) goto L7;
            boolean r103 = true;
        L9:
            if (r102.f571508b <= ze1.a.f571506e) goto L11;
            boolean r104 = true;
        L12:
            if (r103 == false) goto L16;
            if (r104 == false) goto L16;
            r102.f571509c.c(false);
        L16:
            if (this.f567384a.f567376f == true) goto L105;
            String r105 = r111.getBackupSeiListStr();
            if (r105 == null) goto L106;
            h r106 = this.f567384a.f567372b;
            r106.getClass();
            Intrinsics.checkNotNullParameter(r111, "msg");
            Intrinsics.checkNotNullParameter(r105, "backupSeiListStr");
            List<BackupSeiModel> r107 = new ArrayList();
            r107 = (List) GsonHelper.getDefault().fromJson(r105, new j().getType());     // Catch: Exception -> L22
        L24:
            BackupSeiModel r108 = (BackupSeiModel) CollectionsKt.firstOrNull(r107);
            long r109 = 0;
            if (r108 == null) goto L27;
            long r112 = r108.getPts();
        L28:
            BackupSeiModel r113 = (BackupSeiModel) CollectionsKt.firstOrNull(r107);
            if (r113 == null) goto L31;
            r109 = r113.getPts();
        L31:
            List<BackupSeiModel> r114 = r107;
            Iterator r115 = r114.iterator();
        L33:
            if (r115.hasNext() == false) goto L41;
            BackupSeiModel r116 = (BackupSeiModel) r115.next();
            if (r116.getPts() <= r112) goto L38;
            r112 = r116.getPts();
        L38:
            if (r116.getPts() >= r109) goto L33;
            r109 = r116.getPts();
            goto L33
        L41:
            if ((r112 - r109) <= 3000) goto L43;
            boolean r117 = false;
        L44:
            if (r117 == false) goto L85;
            List r118 = CollectionsKt.sortedWith(r114, new i());
            Iterator r119 = r118.iterator();
        L47:
            if (r119.hasNext() == false) goto L52;
            BackupSeiModel r120 = (BackupSeiModel) r119.next();
            String r121 = r111.getSource();
            if (r121 != null) goto L51;
            r121 = "unknown";
        L51:
            r120.setBackupFromSource(r121);
            goto L47
        L52:
            BackupSeiModel r122 = (BackupSeiModel) CollectionsKt.lastOrNull(r106.f571528b);
            BackupSeiModel r123 = (BackupSeiModel) CollectionsKt.firstOrNull(r118);
            if (r122 == null) goto L58;
            if (r123 == null) goto L58;
            if ((r122.getPts() - r123.getPts()) <= 1000) goto L58;
            ((ArrayList) r106.f571528b).clear();
            int r124 = af1.a.f3135a;
            af1.a.a("BackupSeiReceiver", r106.hashCode(), "clearBackupSeiIfNewPtsException, lastPts = " + r122.getPts() + ", nextPts = " + r123.getPts(), true);
        L58:
            ((ArrayList) r106.f571528b).addAll(r118);
            CollectionsKt.sortedWith(r106.f571528b, new k());
            ArrayList r125 = (ArrayList) r106.f571528b;
            ListIterator r126 = r125.listIterator(r125.size());
        L59:
            int r127 = -1;
            if (r126.hasPrevious() == false) goto L67;
            if ((r106.f571529c - ((BackupSeiModel) r126.previous()).getPts()) <= 1000) goto L64;
            boolean r128 = true;
        L65:
            if (r128 == false) goto L59;
            int r129 = r126.nextIndex();
        L69:
            if (r129 <= 0) goto L72;
            ((ArrayList) r106.f571528b).subList(0, r129).clear();
            int r130 = af1.a.f3135a;
            af1.a.a("BackupSeiReceiver", r106.hashCode(), "clearBackupSeiIfTimeout, timeoutItemFirstIndex = " + r129 + ", currBackupSeiListSize = " + ((ArrayList) r106.f571528b).size(), true);
        L72:
            if (r106.f571527a.getEnableBackupSeiCdnPtsInvalidOpt() == false) goto L85;
            Iterator r131 = ((ArrayList) r106.f571528b).iterator();
            int r132 = 0;
        L75:
            if (r131.hasNext() == false) goto L83;
            if ((((BackupSeiModel) r131.next()).getPts() - r106.f571529c) <= r106.f571527a.getBackupSeiCdnPtsInternalMaxMS()) goto L79;
            boolean r133 = true;
        L80:
            if (r133 == true) goto L81;
            r132 = r132 + 1;
            goto L75
        L81:
            r127 = r132;
            goto L83
        L79:
            r133 = false;
        L83:
            if (r127 < 0) goto L85;
            int r134 = ((ArrayList) r106.f571528b).size();
            ((ArrayList) r106.f571528b).subList(r127, r134 - 1).clear();
            int r135 = af1.a.f3135a;
            af1.a.a("BackupSeiReceiver", r106.hashCode(), "clearBackupSeiIfTimeout, timeoutItemLastIndex = " + r127 + ", currBackupSeiListSize = " + ((ArrayList) r106.f571528b).size(), true);
            goto L85
        L64:
            r128 = false;
            goto L65
        L67:
            r129 = -1;
        L85:
            r106.f571530d.b(r111, r106.f571528b, r107);
            return;
        L43:
            r117 = true;
            goto L44
        L27:
            r112 = 0;
        L22:
            e = move-exception;
            e.toString();
            goto L24
        L106:
            return;
        L105:
            return;
        L11:
            r104 = false;
            goto L12
        L7:
            r103 = false;
            goto L9
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f567385a;

        public c(e r100) {
            this.f567385a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            Long r100 = (Long) r110;
            int r101 = af1.a.f3135a;
            this.f567385a.getClass();
            af1.a.b("BackupSeiGuest", "receiveCDN_PTS: " + r100);
            this.f567385a.f567374d.f3136a = r100.longValue();
            ze1.a r102 = this.f567385a.f567371a;
            r100.longValue();
            r102.getClass();
            this.f567385a.f567372b.f571529c = r100.longValue();
            ze1.b r103 = this.f567385a.f567373c;
            long r104 = r100.longValue();
            if (r103.f571512c == true) goto L92;
            BackupSeiModel r105 = (BackupSeiModel) CollectionsKt.lastOrNull(r103.f571513d);
            if (r105 != null) goto L9;
            return;
        L9:
            if ((r105.getPts() - r104) >= 0) goto L52;
            jj0.a r106 = r103.f571511b;
            BackupSeiModel r107 = (BackupSeiModel) CollectionsKt.lastOrNull(r106.f499275a.b());
            if (r107 == null) goto L94;
            long r108 = r107.getPts() - r104;
            if (r108 < 0) goto L16;
            return;
        L16:
            if (Math.abs(r108) >= jj0.a.f499274b) goto L90;
            Iterator<BackupSeiModel> r109 = r106.f499275a.b().iterator();
            int r111 = 0;
        L19:
            if (r109.hasNext() == false) goto L27;
            if (Math.abs(r109.next().getPts() - r104) >= jj0.a.f499274b) goto L23;
            boolean r112 = true;
        L24:
            if (r112 == true) goto L28;
            r111 = r111 + 1;
        L28:
            List<BackupSeiModel> r113 = r106.f499275a.b().subList(r111, r106.f499275a.b().size());
            LinkedHashMap r114 = new LinkedHashMap();
            Iterator<T> r115 = r113.iterator();
        L30:
            if (r115.hasNext() == false) goto L43;
            BackupSeiModel r116 = (BackupSeiModel) r115.next();
            List<String> r117 = r116.getSeiKeyList();
            if (r117 == null) goto L30;
            Iterator<T> r118 = r117.iterator();
        L35:
            if (r118.hasNext() == false) goto L30;
            String r119 = (String) r118.next();
            BackupSeiModel r120 = (BackupSeiModel) r114.get(r119);
            if (r120 == null) goto L39;
            long r121 = r120.getPts();
        L41:
            if (r121 >= r116.getPts()) goto L35;
            r114.put(r119, r116);
            goto L35
        L39:
            r121 = 0;
            goto L41
        L43:
            List r122 = MapsKt.toList(r114);
            ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
            Iterator<T> r124 = r122.iterator();
        L45:
            if (r124.hasNext() == false) goto L47;
            r123.add((BackupSeiModel) ((Pair) r124.next()).getSecond());
            goto L45
        L47:
            Iterator<T> r125 = CollectionsKt.sortedWith(r123, new jj0.b()).iterator();
        L49:
            if (r125.hasNext() == false) goto L51;
            BackupSeiModel r126 = (BackupSeiModel) r125.next();
            r106.f499275a.a(r126, r104, r126.getPts() - r104);
            goto L49
        L51:
            r113.clear();
            return;
        L23:
            r112 = false;
            goto L24
        L27:
            r111 = -1;
            goto L28
        L90:
            return;
        L94:
            return;
        L52:
            jj0.c r127 = r103.f571510a;
            Iterator<T> r128 = r127.f499276a.b().iterator();
        L54:
            if (r128.hasNext() == false) goto L61;
            T r129 = r128.next();
            if (Math.abs(((BackupSeiModel) r129).getPts() - r104) >= 50) goto L58;
            boolean r130 = true;
        L59:
            if (r130 == false) goto L54;
        L62:
            BackupSeiModel r131 = r129;
            if (r131 == null) goto L65;
            r127.f499276a.a(r131, r104, r131.getPts() - r104);
        L65:
            List<BackupSeiModel> r132 = r127.f499276a.b();
            if (r132 == null) goto L70;
            TypeIntrinsics.asMutableCollection(r132).remove(r131);
            return;
        L70:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        L58:
            r130 = false;
            goto L59
        L61:
            r129 = (T) null;
            goto L62
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f567386a;

        public d(e r100) {
            this.f567386a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r210) {
            String r100 = (String) r210;
            int r101 = af1.a.f3135a;
            this.f567386a.getClass();
            af1.a.b("BackupSeiGuest", "receiveCDN_SEI: " + r100);
            if (LiveBackupSeiExperimentUtils.INSTANCE.isEnableMockCdnSeiException(this.f567386a.f567380j, false) == true) goto L26;
            af1.b r102 = this.f567386a.f567374d;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, "cdnSei");
            if (StringsKt.contains$default(r100, "recent_frame_info", false, 2, null) == false) goto L22;
            LiveSeiUtil.f71508i.getClass();
            JSONObject r103 = LiveSeiUtil.c(r100).optJSONObject("recent_frame_info");
            if (r103 == null) goto L9;
            long r104 = r103.optLong("video_pts");
        L11:
            if (r104 <= 0) goto L22;
            if (r102.f3136a <= 0) goto L22;
            if (r104 <= 0) goto L22;
            if ((System.currentTimeMillis() - r102.f3139d) <= 15000) goto L22;
            long r105 = r102.f3136a;
            long r110 = r105 - r104;
            JSONObject r111 = new JSONObject();
            r111.put("sei_pts_diff", r110);
            r111.put("cdn_pts", r105);
            r111.put("sei_pts", r104);
            r102.a(r111);
            if (Math.abs(r110) <= 10000) goto L20;
            int r112 = -1;
        L21:
            nd0.c.o(nd0.c.f518746a, LinkMonitorData.CdnPtsDiff, r111, r112, null, false, 24);
            int r106 = rd0.a.f537202a;
            rd0.a.b(MultiTraceData$TraceBusiness.BackupSei, MultiTraceData$TraceEvent.BackupSei, "cdn_pts_diff", 0, null, r111, 88);
            r102.f3139d = System.currentTimeMillis();
            goto L22
        L20:
            r112 = 0;
            goto L21
        L9:
            r104 = -1;
        L22:
            ze1.a r107 = this.f567386a.f567371a;
            r107.getClass();
            Intrinsics.checkNotNullParameter(r100, "cdnSei");
            LiveSeiUtil.f71508i.getClass();
            if (LiveSeiUtil.e(r100) == true) goto L25;
            af1.a.a("BackupSeiChecker", r107.hashCode(), "call receiveCDNSei error, cdnSei is not json type! cdnSei = ".concat(r100), true);
            goto L26
        L25:
            r107.f571507a = System.currentTimeMillis();
            r107.f571508b = 0;
            r107.f571509c.c(true);
        L26:
            e r108 = this.f567386a;
            if (r108.f567376f == false) goto L30;
            Intrinsics.checkNotNullParameter(r100, "sei");
            r108.f567383m.onSei(r100, new ye1.a(false, "", 0, 0, 0, r108.f567380j));
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.backupsei.IBackupSeiGuestManager
    public final void attach() {
        int r100 = af1.a.f3135a;
        af1.a.a("BackupSeiGuest", hashCode(), "call attach", true);
        this.f567381k.getEventHub().getSeiUpdate().observeForever(this.f567377g);
        this.f567381k.getEventHub().getPtsUpdate().observeForever(this.f567378h);
        this.f567382l.a(MessageType.BACKUP_SEI_MESSAGE.getIntType(), this.f567379i);
        this.f567375e.getClass();
    }

    @Override // com.bytedance.android.livesdkapi.backupsei.IBackupSeiGuestManager
    public final void detach() {
        int r100 = af1.a.f3135a;
        af1.a.a("BackupSeiGuest", hashCode(), "call detach", true);
        this.f567381k.getEventHub().getSeiUpdate().removeObserver(this.f567377g);
        this.f567381k.getEventHub().getPtsUpdate().removeObserver(this.f567378h);
        this.f567382l.b(MessageType.BACKUP_SEI_MESSAGE.getIntType(), this.f567379i);
        af1.b r101 = this.f567374d;
        boolean r102 = r101.f3137b;
        r101.b(r102, r102, System.currentTimeMillis() - r101.f3138c);
        BackupSeiIndicator r103 = this.f567375e;
        r103.getClass();
        BackupSeiIndicator.FinishType r104 = BackupSeiIndicator.FinishType.LEAVE_ROOM;
        r103.a(r104);
        r103.b(r104);
    }

    @Override // ze1.a.b
    public final void c(boolean r100) {
        this.f567376f = r100;
        af1.b r101 = this.f567374d;
        boolean r102 = r101.f3137b;
        if (r102 == r100) goto L5;
        r101.b(r102, r100, System.currentTimeMillis() - r101.f3138c);
        r101.f3137b = r100;
        r101.f3138c = System.currentTimeMillis();
    L5:
        ze1.b r103 = this.f567373c;
        r103.f571512c = this.f567376f;
    }

    @Override // ze1.b.a
    public final void a(BackupSeiModel r210, long r211, long r212) {
        Intrinsics.checkNotNullParameter(r210, "seiModel");
        af1.a.b("BackupSeiGuest", "call dispatchBackupSei");
        af1.b r100 = this.f567374d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "seiModel");
        List<String> r101 = r210.getSeiKeyList();
        if (r101 == null) goto L10;
        if (r101.contains("app_data") != true) goto L10;
        if ((System.currentTimeMillis() - r100.f3140e) <= 15000) goto L10;
        long r102 = r210.getPts();
        JSONObject r110 = new JSONObject();
        r110.put("backup_pts_diff", r212);
        r110.put("backup_pts", r102);
        r110.put("cdn_pts", r211);
        r100.a(r110);
        nd0.c.o(nd0.c.f518746a, LinkMonitorData.BackupSeiConsumePtsDiff, r110, 0, null, false, 28);
        int r103 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.BackupSei, MultiTraceData$TraceEvent.BackupSei, "backup_sei_consume_diff", 0, null, r110, 88);
        r100.f3140e = System.currentTimeMillis();
    L10:
        BackupSeiIndicator r104 = this.f567375e;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r210, "seiModel");
        if (r210.getSeiIndex() <= r104.f104242d) goto L13;
        r104.f104243e++;
        r104.f104242d = r210.getSeiIndex();
    L13:
        r210.getSeiIndex();
        r210.getBackupSei();
        ye1.c r105 = this.f567383m;
        String r106 = r210.getBackupSei();
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        r105.onSei(r106, new ye1.a(true, r210.getBackupFromSource(), r210.getPts(), r211, r212, this.f567380j));
    }

    @Override // ze1.h.b
    public final void b(BackupSeiMessage r100, List<BackupSeiModel> r101, List<BackupSeiModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "totalBackupSeiList");
        Intrinsics.checkNotNullParameter(r102, "backupSeiListPerMsg");
        BackupSeiIndicator r103 = this.f567375e;
        String r104 = r100.getSource();
        r100.getStreamId();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "backupSeiList");
        if (r104 == null) goto L9;
        Iterator r105 = CollectionsKt.sortedWith(r102, new ze1.c()).iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        r103.c((BackupSeiModel) r105.next(), r104);
    L9:
        ze1.b r106 = this.f567373c;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r101, "list");
        r106.f571513d = r101;
    }

    public e(IRoom r100, int r101, ILivePlayerClient r102, af1.c r103, ye1.c r104) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r102, "livePlayerClient");
        Intrinsics.checkNotNullParameter(r103, "messageManager");
        Intrinsics.checkNotNullParameter(r104, "listener");
        this.f567380j = r100;
        this.f567381k = r102;
        this.f567382l = r103;
        this.f567383m = r104;
        this.f567371a = new ze1.a(this);
        this.f567372b = new h(this);
        this.f567373c = new ze1.b(this);
        this.f567374d = new af1.b(r102, r101);
        this.f567375e = new BackupSeiIndicator(r102, r101);
        this.f567376f = true;
        this.f567377g = new d(this);
        this.f567378h = new c(this);
        this.f567379i = new b(this);
    }
}
