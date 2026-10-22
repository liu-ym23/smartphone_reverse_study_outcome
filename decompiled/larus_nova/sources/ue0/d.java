package ue0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.feed.datamerge.j;
import com.bytedance.android.live.liveinteract.feed.datamerge.k;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.multianchor.model.h;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.config.bb0;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfo;
import com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfoMainKt;
import com.bytedance.android.livesdkapi.depend.message.crossroom.UserInfo;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.service.MessageHub;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import vlc.l;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends com.bytedance.android.live.liveinteract.feed.datamerge.a implements l, OnWRDSDataUpdateListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ILinkPlayerInfoBridge> f549780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ILinkPlayerInfoBridge> f549781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<LinkmicPositionItem> f549782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f549783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ylc.c f549784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<j> f549785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IPreviewMultiLinkOuterConfigProvider f549786h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
        this.f549786h.printALogger("LivePreviewMultiLinkOnlineUserListHandler", hashCode(), "attach: MessageHub = " + c().getMessageHub(), true);
        MessageHub r100 = c().getMessageHub();
        if (r100 == null) goto L5;
        r100.addMessageListener(MessageType.LINKER.getKey(), this);
    L5:
        MessageHub r101 = c().getMessageHub();
        if (r101 == null) goto L8;
        r101.addMessageListener(MessageType.LINK_MIC.getKey(), this);
    L8:
        MessageHub r102 = c().getMessageHub();
        if (r102 == null) goto L11;
        r102.addWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, this, true);
    L11:
        IRoom r103 = this.f549786h.getRoom();
        LinkAnchorApi r104 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r105 = r103.getId();
        long r106 = d5.c(r103.getAnchorId());
        String r107 = r103.getAnchorId();
        if (r107 != null) goto L14;
        r107 = "";
    L14:
        this.f549783e.add(r104.getLinkListV2(r105, r106, r107, true, r103.isOfficialChannelRoom()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), new f(this)));
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
        this.f549786h.printALogger("LivePreviewMultiLinkOnlineUserListHandler", hashCode(), "detach: MessageHub = " + c().getMessageHub(), true);
        MessageHub r100 = c().getMessageHub();
        if (r100 == null) goto L5;
        r100.removeMessageListener(MessageType.LINKER.getKey(), this);
    L5:
        MessageHub r101 = c().getMessageHub();
        if (r101 == null) goto L8;
        r101.removeMessageListener(MessageType.LINK_MIC.getKey(), this);
    L8:
        MessageHub r102 = c().getMessageHub();
        if (r102 == null) goto L11;
        r102.removeWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, this);
    L11:
        this.f549783e.clear();
    }

    @Override // com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener
    public final ylc.c getDataSyncListener() {
        return this.f549784f;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.a, com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final j.a a(List<ch0.e> r110) {
        Intrinsics.checkNotNullParameter(r110, "oldMergeDataList");
        List<ch0.e> r111 = r110;
        LinkedHashMap r100 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r111, 10)), 16));
        Iterator<T> r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L6;
        Object r101 = r112.next();
        r100.put(((ch0.e) r101).f23724a.getInteractId(), r101);
        goto L4
    L6:
        List<ILinkPlayerInfoBridge> r113 = this.f549781c;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r114 = ((ArrayList) r113).iterator();
        boolean r103 = false;
        ch0.e r104 = null;
    L8:
        if (r114.hasNext() == false) goto L26;
        ILinkPlayerInfoBridge r105 = (ILinkPlayerInfoBridge) r114.next();
        ch0.e r106 = (ch0.e) r100.get(r105.getInteractId());
        boolean r115 = true;
        if (r106 != null) goto L12;
        ch0.e r107 = new ch0.e(r105);
    L16:
        IBaseUser r108 = r107.f23724a.getUser();
        if (r108 == null) goto L19;
        String r109 = r108.getIdString();
    L21:
        if (Intrinsics.areEqual(r109, gh0.a.c()) == false) goto L24;
        if (r107 == r106) goto L24;
        r104 = r107;
    L24:
        r102.add(r107);
        r103 = r115;
        goto L8
    L19:
        r109 = null;
        goto L21
    L12:
        if (r106.b(r105) == false) goto L14;
        r115 = r103;
        r107 = r106;
        goto L16
    L14:
        r107 = ch0.e.a(r106, r105, null, null, null, 14);
        goto L16
    L26:
        return new j.a(r103, r102, r104);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.a, com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final j.a b(List<ch0.e> r110) {
        Intrinsics.checkNotNullParameter(r110, "oldMergeDataList");
        List<ch0.e> r111 = r110;
        LinkedHashMap r100 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r111, 10)), 16));
        Iterator<T> r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L6;
        Object r101 = r112.next();
        r100.put(((ch0.e) r101).f23724a.getInteractId(), r101);
        goto L4
    L6:
        List<ILinkPlayerInfoBridge> r113 = this.f549780b;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r114 = ((ArrayList) r113).iterator();
        boolean r103 = false;
        ch0.e r104 = null;
    L8:
        if (r114.hasNext() == false) goto L26;
        ILinkPlayerInfoBridge r105 = (ILinkPlayerInfoBridge) r114.next();
        ch0.e r106 = (ch0.e) r100.get(r105.getInteractId());
        boolean r115 = true;
        if (r106 != null) goto L12;
        ch0.e r107 = new ch0.e(r105);
    L16:
        IBaseUser r108 = r107.f23724a.getUser();
        if (r108 == null) goto L19;
        String r109 = r108.getIdString();
    L21:
        if (Intrinsics.areEqual(r109, gh0.a.c()) == false) goto L24;
        if (r107 == r106) goto L24;
        r104 = r107;
    L24:
        r102.add(r107);
        r103 = r115;
        goto L8
    L19:
        r109 = null;
        goto L21
    L12:
        if (r106.b(r105) == false) goto L14;
        r115 = r103;
        r107 = r106;
        goto L16
    L14:
        r107 = ch0.e.a(r106, r105, null, null, null, 14);
        goto L16
    L26:
        return new j.a(r103, r102, r104);
    }

    public final void e(List<? extends LinkmicPositionItem> r100) {
        boolean r101 = !gh0.a.e(this.f549782d, r100);
        IPreviewMultiLinkOuterConfigProvider r102 = this.f549786h;
        int r103 = hashCode();
        StringBuilder r104 = new StringBuilder("onLockListChanged: hasModified = ");
        r104.append(r101);
        r104.append(", oldList = ");
        List<LinkmicPositionItem> r105 = this.f549782d;
        Integer r106 = null;
        if (r105 == null) goto L5;
        Integer r107 = Integer.valueOf(r105.size());
    L6:
        r104.append(r107);
        r104.append(", newList = ");
        if (r100 == null) goto L9;
        r106 = Integer.valueOf(r100.size());
    L9:
        r104.append(r106);
        r102.printALogger("LivePreviewMultiLinkOnlineUserListHandler", r103, r104.toString(), true);
        if (r101 == false) goto L25;
        if (r100 == null) goto L18;
        List<? extends LinkmicPositionItem> r108 = r100;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L14:
        if (r110.hasNext() == false) goto L16;
        r109.add(h.a((LinkmicPositionItem) r110.next()));
        goto L14
    L16:
        List<LinkmicPositionItem> r111 = CollectionsKt.toMutableList(r109);
        if (r111 == null) goto L18;
    L19:
        this.f549782d = r111;
        k r112 = c();
        List<LinkmicPositionItem> r113 = this.f549782d;
        if (r113 != null) goto L22;
        r113 = CollectionsKt.emptyList();
    L22:
        r112.p(r113);
        return;
    L18:
        r111 = new ArrayList();
        goto L19
    L25:
        return;
    L5:
        r107 = null;
        goto L6
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (this.f549786h.getFeedLiveType() == 5) goto L6;
        return;
    L6:
        if ((r100 instanceof h1) == false) goto L20;
        h1 r101 = (h1) r100;
        if (r101.getMType() != 12) goto L21;
        ILinkerUpdateUserContent r102 = r101.getMUpdateUser();
        ClientUIInfo r103 = null;
        if (r102 == null) goto L14;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r104 = r102.getMLinkUsers();
        if (r104 == null) goto L14;
        ArrayList<ILinkPlayerInfoBridge> r105 = je0.d.f0(r104, false);
    L15:
        ILinkerUpdateUserContent r106 = r101.getMUpdateUser();
        if (r106 == null) goto L18;
        r103 = r106.getClientUiInfo();
    L18:
        f(r105, r103);
        return;
    L14:
        r105 = null;
        goto L15
    L21:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener
    public final void setDataSyncListener(ylc.c r100) {
        this.f549784f = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends j> r100, IPreviewMultiLinkOuterConfigProvider r101) {
        Intrinsics.checkNotNullParameter(r100, "childHandlers");
        Intrinsics.checkNotNullParameter(r101, "configProvider");
        this.f549785g = r100;
        this.f549786h = r101;
        this.f549780b = new ArrayList();
        this.f549781c = new ArrayList();
        this.f549782d = new ArrayList();
        this.f549783e = new CompositeDisposable();
    }

    public final void f(List<ILinkPlayerInfoBridge> r100, ClientUIInfo r101) {
        boolean r102 = !gh0.a.f(this.f549780b, r100);
        IPreviewMultiLinkOuterConfigProvider r103 = this.f549786h;
        int r104 = hashCode();
        StringBuilder r105 = new StringBuilder("onOnlineListChanged: hasModified = ");
        r105.append(r102);
        r105.append(", oldList = ");
        r105.append(((ArrayList) this.f549780b).size());
        r105.append(", newList = ");
        if (r100 == null) goto L5;
        Integer r106 = Integer.valueOf(r100.size());
    L6:
        r105.append(r106);
        r103.printALogger("LivePreviewMultiLinkOnlineUserListHandler", r104, r105.toString(), true);
        if (r102 == false) goto L58;
        ((ArrayList) this.f549780b).clear();
        if (r100 == null) goto L33;
        ((ArrayList) this.f549780b).addAll(r100);
        Iterator<T> r107 = r100.iterator();
    L12:
        if (r107.hasNext() == false) goto L32;
        ILinkPlayerInfoBridge r108 = (ILinkPlayerInfoBridge) r107.next();
        if (bb0.f119854a.getValue().booleanValue() == false) goto L12;
        if (r108 == null) goto L12;
        int r109 = Integer.MIN_VALUE;
        r108.setClientUIPosition(Integer.MIN_VALUE);
        if (r101 == null) goto L12;
        CrossRoomLinkmicUIInfo r110 = r101.getCrossRoomLinkmic();
        if (r110 == null) goto L12;
        Map<String, UserInfo> r111 = CrossRoomLinkmicUIInfoMainKt.getUserInfoString(r110);
        if (r111 == null) goto L31;
        IBaseUser r112 = r108.getUser();
        if (r112 == null) goto L27;
        String r113 = r112.getIdString();
    L28:
        UserInfo r114 = r111.get(r113);
        if (r114 == null) goto L31;
        r109 = (int) r114.getClientPosition();
        goto L31
    L27:
        r113 = null;
    L31:
        r108.setClientUIPosition(r109);
        goto L12
    L32:
        c().a(r100);
    L33:
        j.a r115 = b(c().o());
        boolean r116 = r115.f72975a;
        Iterator<j> r117 = this.f549785g.iterator();
    L35:
        if (r117.hasNext() == false) goto L39;
        r115 = r117.next().b(r115.f72976b);
        if (r115.f72975a == false) goto L35;
        r116 = true;
        goto L35
    L39:
        if (r116 == false) goto L59;
        r115.f72975a = true;
        c().t(r115);
        return;
    L59:
        return;
    L58:
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener
    public final void onWRDSDataUpdate(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "syncKey");
        if (((Boolean) vm2.d.f556019y2.getValue(null, vm2.d.f555776a[178(0xb2, float:2.5E-43)])).booleanValue() == false) goto L8;
        if (this.f549786h.getRoom().isOfficialChannelRoom() == false) goto L8;
        return;
    L8:
        if ((r101 instanceof IRoomLinkMicSyncData) == true) goto L10;
        r101 = null;
    L10:
        IRoomLinkMicSyncData r102 = (IRoomLinkMicSyncData) r101;
        if (r102 == null) goto L17;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r103 = r102.getMLinkUsers();
        if (r103 == null) goto L15;
        f(je0.d.f0(r103, false), r102.getClientUIInfo());
    L15:
        e(r102.getLockedPositions());
        return;
    }
}
