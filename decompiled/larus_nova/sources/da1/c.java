package da1;

import com.bytedance.android.live.base.model.live.RoomViewStats;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.live.room.api.IPlatformAudienceRankService;
import com.bytedance.android.live.room.api.rank.IAudienceWidget;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.message.model.lk;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdk.s7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kc0.j;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r52.b4;
import vh7.f;
import vlc.l;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends da1.a implements l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f467655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f467656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f467657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n<IAudienceWidget> f467658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f467659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f467660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f467661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f467662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f467663m;

    public static final class a {
    }

    public static final class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f467664a;

        public b(c r100) {
            this.f467664a = r100;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r110) {
            c r100 = this.f467664a;
            if (r100.f531633a == 0) goto L75;
            if (r110 != null) goto L7;
            return;
        L7:
            if (r100.f467655e == true) goto L9;
            return;
        L9:
            if (b4.f536156a.getValue().b() == false) goto L88;
            String r101 = r110.getMessageMethod();
            if (r101 == null) goto L89;
            int r102 = r101.hashCode();
            int r103 = 0;
            mk r104 = null;
            if (r102 == 654092662) goto L46;
            if (r102 == 955576685) goto L20;
            return;
        L20:
            if (r101.equals("WebcastRoomRankMessage") == false) goto L77;
            c r105 = this.f467664a;
            if ((r110 instanceof lk) == true) goto L24;
            r110 = null;
        L24:
            lk r111 = (lk) r110;
            if (r105.f531633a == 0) goto L78;
            if (r111 == null) goto L91;
            ArrayList r106 = new ArrayList();
            List<lk.b> r112 = r111.getRanks();
            if (r112 != null) goto L31;
        L42:
            IAudienceWidget r113 = (IAudienceWidget) r105.f531633a;
            if (r113 == null) goto L79;
            r113.ii(r106);
            return;
        L79:
            return;
        L31:
            if ((!r112.isEmpty()) == true) goto L34;
            r112 = null;
        L34:
            if (r112 == null) goto L42;
            Iterator<T> r114 = r112.iterator();
        L37:
            if (r114.hasNext() == false) goto L42;
            Object r107 = r114.next();
            int r108 = r103 + 1;
            if (r103 >= 0) goto L41;
            CollectionsKt.throwIndexOverflow();
        L41:
            lk.b r109 = (lk.b) r107;
            r106.add(new x71.a(r109.getUser(), r108, r109.getProfileHidden(), null));
            r103 = r108;
            goto L37
        L91:
            return;
        L78:
            return;
        L77:
            return;
        L46:
            if (r101.equals("WebcastRoomStatsMessage") == false) goto L81;
            c r115 = this.f467664a;
            if ((r110 instanceof mk) == true) goto L50;
            r110 = null;
        L50:
            mk r116 = (mk) r110;
            if (r116 != null) goto L53;
            r115.getClass();
            return;
        L53:
            if (r115.f531633a != 0) goto L55;
            return;
        L55:
            if (r116.getDisplayVersion() < r115.f467661k) goto L92;
            ALogger.i("LiveWatchPresenterKt", "handleNewCountMessage  RoomStatsMessage : " + r116.getDisplayMiddle());
            if (r116.getDisplayVersion() <= r115.f467661k) goto L61;
            r115.f467661k = r116.getDisplayVersion();
            r115.h0(r116);
            return;
        L61:
            if (r116.getIncremental() == true) goto L63;
            r115.h0(r116);
            return;
        L63:
            if (r116.getDisplayValue() <= r115.f467660j) goto L65;
            r103 = 1;
        L65:
            if (r103 == 0) goto L67;
            r104 = r116;
        L67:
            if (r104 == null) goto L84;
            r115.f467660j = r104.getDisplayValue();
            r115.h0(r104);
            return;
        L84:
            return;
        L92:
            return;
        L81:
            return;
        L89:
            return;
        L88:
            return;
        }
    }

    static {
    }

    public c() {
        this.f467659i = new CompositeDisposable();
        this.f467663m = new b(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n, q46.b
    public final void detachView() {
        super.detachView();
        this.f467656f = 0;
        this.f467657g = 0;
        vlc.d r100 = this.f107665d;
        if (r100 == null) goto L5;
        r100.removeMessageListener(this);
    L5:
        n<IAudienceWidget> r101 = this.f467658h;
        if (r101 == null) goto L8;
        r101.detachView();
    L8:
        this.f467659i.dispose();
        this.f467660j = 0;
        this.f467661k = 0;
        this.f467662l = false;
        this.f467658h = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n
    public final /* bridge */ /* synthetic */ void c0(IWidget r100) {
        g0((IAudienceWidget) r100);
    }

    public final void g0(IAudienceWidget r100) {
        super.c0(r100);
        vlc.d r101 = this.f107665d;
        if (r101 == null) goto L6;
        r101.addMessageListener("WebcastRoomRankMessage", this);
        r101.addMessageListener("WebcastRoomStatsMessage", this);
    L6:
        if (this.f467655e == true) goto L8;
    L27:
        IPlatformAudienceRankService r102 = (IPlatformAudienceRankService) k.f(IPlatformAudienceRankService.class);
        if (r102 == null) goto L30;
        n<IAudienceWidget> r103 = r102.getPlatformWatchUserPresenter();
    L31:
        this.f467658h = r103;
        if (r103 == null) goto L35;
        r103.c0(r100);
        return;
    L35:
        return;
    L30:
        r103 = null;
        goto L31
    L8:
        if (b4.f536156a.getValue().b() == false) goto L27;
        MiddlewareRoomContext.a r104 = MiddlewareRoomContext.Companion;
        MiddlewareRoomContext r105 = MiddlewareRoomContext.a.c(r104, this.f107664c, 0, 2);
        if (r105 == null) goto L14;
        Disposable r106 = o0.c(r105, CollectionsKt.mutableListOf(new String[]{"WebcastRoomRankMessage", "WebcastRoomStatsMessage"}), this.f467663m);
        if (r106 == null) goto L14;
        this.f467659i.add(r106);
    L14:
        MiddlewareRoomContext r107 = MiddlewareRoomContext.a.c(r104, this.f107664c, 0, 2);
        if (r107 == null) goto L27;
        com.bytedance.live.datacontext.n<dh1.a> r108 = r107.getRtcRoomInfo();
        if (r108 == null) goto L27;
        dh1.a r109 = r108.getValue();
        if (r109 == null) goto L21;
        long r110 = r109.f468579a;
    L23:
        if (r110 <= 0) goto L25;
        boolean r111 = true;
    L26:
        this.f467662l = r111;
        this.f467659i.add(r108.a().subscribe(new e(this)));
        goto L27
    L25:
        r111 = false;
        goto L26
    L21:
        r110 = 0;
        goto L23
    }

    public final void h0(mk r100) {
        IAudienceWidget r101 = (IAudienceWidget) this.f531633a;
        if (r101 == null) goto L6;
        r101.sn(r100.is_hidden(), r100.getDisplayValue(), r100.getDisplayMiddle(), r100.getDisplayLong());
        return;
    }

    public final void i0(mk r100) {
        DataCenter r101 = this.f107664c;
        if (r101 == null) goto L13;
        IRoom r102 = a0.n(r101);
        if (r102 == null) goto L13;
        long r103 = r102.getRoomId();
        IRoomContextService r104 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r104 == null) goto L13;
        r r105 = r104.getRoomExpService(this.f107664c, r103);
        if (r105 == null) goto L13;
        com.bytedance.live.datacontext.n<mk> r106 = r105.u();
        if (r106 == null) goto L13;
        r106.setValue(r100);
    L13:
        DataCenter r107 = this.f107664c;
        if (r107 == null) goto L16;
        r107.put("data_member_count", Integer.valueOf((int) r100.getTotal()));
    L16:
        boolean r108 = h.f91037a;
        ((j) h.d(j.class)).updateAudienceMemberCount(r100.getTotal());
        int r109 = com.bytedance.android.live.room.util.b.f100384a;
        DataCenter r110 = this.f107664c;
        long r111 = r100.getTotal();
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        w71.a r112 = z51.a.b(r110);
        if (r112 == null) goto L20;
        r112.updateRoomPCU(r111);
    L20:
        if (s7.f157861a.getValue().booleanValue() == false) goto L26;
        IPlatformAudienceRankService r113 = (IPlatformAudienceRankService) k.f(IPlatformAudienceRankService.class);
        if (r113 != null) goto L24;
    L25:
        h0(r100);
    L31:
        DataCenter r114 = this.f107664c;
        if (r114 == null) goto L41;
        IRoom r115 = a0.n(r114);
        if (r115 == null) goto L42;
        long r116 = r115.getRoomId();
        IRoomContextService r117 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r117 == null) goto L43;
        r r118 = r117.getRoomExpService(this.f107664c, r116);
        if (r118 == null) goto L44;
        r118.F(r100.getTotal());
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L24:
        if (r113.interceptAudienceCountRefresh() == true) goto L31;
    L26:
        IPlatformAudienceRankService r119 = (IPlatformAudienceRankService) k.f(IPlatformAudienceRankService.class);
        if (r119 != null) goto L29;
    L30:
        h0(r100);
        goto L31
    L29:
        if (r119.interceptAudienceCountRefresh() == true) goto L31;
        goto L30
    }

    public final void j0(mk r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f531633a != 0) goto L6;
        return;
    L6:
        if (r100.getDisplayVersion() >= this.f467657g) goto L9;
        return;
    L9:
        if (this.f467662l == true) goto L11;
    L15:
        ALogger.i("LiveWatchPresenterKt", "handleNewCountMessage  RoomStatsMessage : " + r100.getDisplayMiddle());
        if (r100.getDisplayVersion() <= this.f467657g) goto L19;
        this.f467657g = r100.getDisplayVersion();
        i0(r100);
        return;
    L19:
        if (r100.getIncremental() == true) goto L21;
        i0(r100);
        return;
    L21:
        if (r100.getDisplayValue() <= this.f467656f) goto L23;
        boolean r101 = true;
    L24:
        if (r101 == true) goto L27;
        r100 = null;
    L27:
        if (r100 == null) goto L34;
        this.f467656f = r100.getDisplayValue();
        i0(r100);
        return;
    L34:
        return;
    L23:
        r101 = false;
        goto L24
    L11:
        if (this.f467655e == false) goto L15;
        if (b4.f536156a.getValue().b() == false) goto L15;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (this.f531633a == 0) goto L32;
        if (r100 == null) goto L36;
        String r101 = r100.getMessageMethod();
        if (r101 == null) goto L37;
        int r102 = r101.hashCode();
        Long r103 = null;
        if (r102 == 654092662) goto L26;
        if (r102 == 955576685) goto L15;
        return;
    L15:
        if (r101.equals("WebcastRoomRankMessage") == true) goto L17;
        return;
    L17:
        if ((r100 instanceof lk) == true) goto L19;
        r100 = null;
    L19:
        lk r104 = (lk) r100;
        DataCenter r105 = this.f107664c;
        if (r105 == null) goto L24;
        IRoom r106 = a0.n(r105);
        if (r106 == null) goto L24;
        r103 = Long.valueOf(r106.getRoomId());
    L24:
        l0(r104, r103);
        return;
    L26:
        if (r101.equals("WebcastRoomStatsMessage") == true) goto L28;
        return;
    L28:
        if ((r100 instanceof mk) == true) goto L30;
        r100 = null;
    L30:
        j0((mk) r100);
        return;
    L37:
        return;
    L36:
        return;
    }

    public final void k0(RoomViewStats r100, Long r101) {
        if (r101 == null) goto L25;
        r101.longValue();
        IRoomContextService r102 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r102 == null) goto L10;
        r r103 = r102.getRoomExpService(this.f107664c, r101.longValue());
        if (r103 == null) goto L10;
        com.bytedance.live.datacontext.n<mk> r104 = r103.u();
        if (r104 == null) goto L10;
        mk r105 = r104.getValue();
    L11:
        if (r105 == null) goto L13;
        j0(r105);
        ALogger.i("LiveWatchPresenterKt", "  handleEnterData   RoomStatsMessage : " + r105.getDisplayMiddle());
    L15:
        IRoomContextService r106 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r106 == null) goto L26;
        r r107 = r106.getRoomExpService(this.f107664c, r101.longValue());
        if (r107 == null) goto L27;
        com.bytedance.live.datacontext.n<lk> r108 = r107.p();
        if (r108 == null) goto L28;
        lk r109 = r108.getValue();
        if (r109 == null) goto L29;
        l0(r109, r101);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L13:
        if (r100 == null) goto L15;
        mk r110 = (mk) f.c(mk.class);
        r110.set_hidden(r100.isHidden());
        r110.setDisplayVersion(r100.getDisplayVersion());
        r110.setDisplayMiddle(r100.getDisplayMiddle());
        r110.setDisplayLong(r100.getDisplayLong());
        r110.setIncremental(r100.getIncremental());
        j0(r110);
    L10:
        r105 = null;
        goto L11
    }

    public final void l0(lk r100, Long r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f531633a != 0) goto L7;
        return;
    L7:
        if (this.f467662l == true) goto L9;
    L13:
        ArrayList r102 = new ArrayList();
        List<lk.b> r103 = r100.getRanks();
        if (r103 != null) goto L16;
    L27:
        if (r101 == null) goto L35;
        long r104 = r101.longValue();
        IRoomContextService r105 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r105 == null) goto L35;
        r r106 = r105.getRoomExpService(this.f107664c, r104);
        if (r106 == null) goto L35;
        com.bytedance.live.datacontext.n<lk> r107 = r106.p();
        if (r107 == null) goto L35;
        r107.setValue(r100);
    L35:
        IAudienceWidget r108 = (IAudienceWidget) this.f531633a;
        if (r108 == null) goto L43;
        r108.ii(r102);
        return;
    L43:
        return;
    L16:
        if ((!r103.isEmpty()) == true) goto L19;
        r103 = null;
    L19:
        if (r103 == null) goto L27;
        Iterator<T> r109 = r103.iterator();
        int r110 = 0;
    L22:
        if (r109.hasNext() == false) goto L27;
        Object r111 = r109.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        lk.b r113 = (lk.b) r111;
        r102.add(new x71.a(r113.getUser(), r112, r113.getProfileHidden(), r113.getScoreStr()));
        r110 = r112;
        goto L22
    L9:
        if (this.f467655e == false) goto L13;
        if (b4.f536156a.getValue().b() == false) goto L13;
    }
}
