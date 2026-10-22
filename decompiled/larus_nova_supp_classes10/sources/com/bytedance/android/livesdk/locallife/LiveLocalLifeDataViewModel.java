package com.bytedance.android.livesdk.locallife;

import am2.x;
import android.graphics.Rect;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLifeInfoHandler;
import com.bytedance.android.livehostapi.business.depend.locallife.ShortTermState;
import com.bytedance.android.livehostapi.business.depend.locallife.ShortTermStateListener;
import com.bytedance.android.livehostapi.business.depend.locallife.params.LiveLifeEnterParams;
import com.bytedance.android.livehostapi.business.depend.locallife.params.LiveLifeParamsHandler;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.chatroom.room.r0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLifeGrouponInfo;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 b2\u00020\u0001:\u0001cB\u0007¢\u0006\u0004\b`\u0010aJ4\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J*\u0010\r\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006J\u001c\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\tJ\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\tJ&\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\tJ\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eR!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R'\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u00104R$\u00105\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R'\u00109\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010$\u001a\u0004\b8\u0010+R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010A\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010G\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010B\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR*\u0010L\u001a\u00020J2\u0006\u0010K\u001a\u00020J8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001e0R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR$\u0010U\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010B\u001a\u0004\bV\u0010D\"\u0004\bW\u0010FR$\u0010X\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010B\u001a\u0004\bY\u0010D\"\u0004\bZ\u0010FR\u001d\u0010_\u001a\u0004\u0018\u00010[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010$\u001a\u0004\b]\u0010^¨\u0006d"}, d2 = {"Lcom/bytedance/android/livesdk/locallife/LiveLocalLifeDataViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livehostapi/business/depend/locallife/params/LiveLifeEnterParams;", "liveLifeEnterParams", "Landroid/os/Bundle;", "enterExtra", "", "isAd", "isLife", "", "enterType", "", "refreshLogInfoV2", "refreshLogInfo", "Lcom/bytedance/android/livesdk/chatroom/room/RoomSession;", "session", "setData", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "uniqueKey", "setRoom", "getRoom", "refreshData", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "setPreviewData", "removeEnterActionParams", "exitRoom", "lifeShareId", "setLifeShareId", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ShortTermStateListener;", "listener", "addShortTermStateListener", "removeShortTermStateListener", "Landroidx/lifecycle/MutableLiveData;", "data$delegate", "Lkotlin/Lazy;", "getData", "()Landroidx/lifecycle/MutableLiveData;", "data", "", "multiRoomData$delegate", "getMultiRoomData", "()Ljava/util/Map;", "multiRoomData", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ILiveLifeInfoHandler;", "liveLifeInfoHandler", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ILiveLifeInfoHandler;", "getLiveLifeInfoHandler", "()Lcom/bytedance/android/livehostapi/business/depend/locallife/ILiveLifeInfoHandler;", "setLiveLifeInfoHandler", "(Lcom/bytedance/android/livehostapi/business/depend/locallife/ILiveLifeInfoHandler;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "sessionMap", "Ljava/util/Map;", "roomMap$delegate", "getRoomMap", "roomMap", "", "firstRoomId", "Ljava/lang/Long;", "getFirstRoomId", "()Ljava/lang/Long;", "setFirstRoomId", "(Ljava/lang/Long;)V", "enterSaleChannel", "Ljava/lang/String;", "getEnterSaleChannel", "()Ljava/lang/String;", "setEnterSaleChannel", "(Ljava/lang/String;)V", "currentEnvParams", "getCurrentEnvParams", "setCurrentEnvParams", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ShortTermState;", "value", "shortTermState", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ShortTermState;", "getShortTermState", "()Lcom/bytedance/android/livehostapi/business/depend/locallife/ShortTermState;", "setShortTermState", "(Lcom/bytedance/android/livehostapi/business/depend/locallife/ShortTermState;)V", "", "shortTermStatelisteners", "Ljava/util/List;", "enterFromMerge", "getEnterFromMerge", "setEnterFromMerge", "enterMethod", "getEnterMethod", "setEnterMethod", "Lcom/bytedance/android/livehostapi/business/IHostLiveLocalLife;", "liveLocalLifeService$delegate", "getLiveLocalLifeService", "()Lcom/bytedance/android/livehostapi/business/IHostLiveLocalLife;", "liveLocalLifeService", "<init>", "()V", "Companion", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeDataViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = null;
    private static final String TYPE_NEW_ENTER_PARAM = null;
    private static final String TYPE_OLD_ENTER_PARAM = null;
    private String currentEnvParams;
    private final Lazy data$delegate;
    private String enterFromMerge;
    private String enterMethod;
    private String enterSaleChannel;
    private Long firstRoomId;
    private ILiveLifeInfoHandler liveLifeInfoHandler;
    private final Lazy liveLocalLifeService$delegate;
    private final Lazy multiRoomData$delegate;
    private Room room;
    private final Lazy roomMap$delegate;
    private Map<String, RoomSession> sessionMap;
    private ShortTermState shortTermState;
    private final List<ShortTermStateListener> shortTermStatelisteners;

    public static final class a {
        public a() {
        }
    }

    private final IHostLiveLocalLife getLiveLocalLifeService() {
        return (IHostLiveLocalLife) this.liveLocalLifeService$delegate.getValue();
    }

    private final Map<String, Room> getRoomMap() {
        return (Map) this.roomMap$delegate.getValue();
    }

    public final MutableLiveData<Bundle> getData() {
        return (MutableLiveData) this.data$delegate.getValue();
    }

    public final Map<String, Bundle> getMultiRoomData() {
        return (Map) this.multiRoomData$delegate.getValue();
    }

    static {
        Companion = new a();
        TAG = "LiveLocalLifeDataViewModel";
        TYPE_NEW_ENTER_PARAM = "新进房";
        TYPE_OLD_ENTER_PARAM = "老进房";
    }

    public LiveLocalLifeDataViewModel() {
        this.data$delegate = LazyKt.lazy(LiveLocalLifeDataViewModel$data$2.INSTANCE);
        this.multiRoomData$delegate = LazyKt.lazy(LiveLocalLifeDataViewModel$multiRoomData$2.INSTANCE);
        this.roomMap$delegate = LazyKt.lazy(LiveLocalLifeDataViewModel$roomMap$2.INSTANCE);
        this.shortTermState = new ShortTermState(0, new Rect());
        this.shortTermStatelisteners = new ArrayList();
        this.liveLocalLifeService$delegate = LazyKt.lazy(LiveLocalLifeDataViewModel$liveLocalLifeService$2.INSTANCE);
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ String access$getTYPE_NEW_ENTER_PARAM$cp() {
        return TYPE_NEW_ENTER_PARAM;
    }

    public static final /* synthetic */ String access$getTYPE_OLD_ENTER_PARAM$cp() {
        return TYPE_OLD_ENTER_PARAM;
    }

    public final String getCurrentEnvParams() {
        return this.currentEnvParams;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEnterSaleChannel() {
        return this.enterSaleChannel;
    }

    public final Long getFirstRoomId() {
        return this.firstRoomId;
    }

    public final ILiveLifeInfoHandler getLiveLifeInfoHandler() {
        return this.liveLifeInfoHandler;
    }

    public final ShortTermState getShortTermState() {
        return this.shortTermState;
    }

    public final void addShortTermStateListener(ShortTermStateListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.shortTermStatelisteners.contains(r2) == true) goto L6;
        this.shortTermStatelisteners.add(r2);
        return;
    }

    public final void exitRoom(String r3) {
        Map<String, RoomSession> r0 = this.sessionMap;
        if (r0 == null) goto L5;
        RoomSession r1 = (RoomSession) TypeIntrinsics.asMutableMap(r0).remove(r3);
    L5:
        IHostLiveLocalLife r2 = getLiveLocalLifeService();
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.isLiveLifeMemoryLeakExperimentHit() != true) goto L15;
        Map<String, Room> r4 = getRoomMap();
        if (r4 == null) goto L13;
        TypeIntrinsics.asMutableMap(r4).remove(r3);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public final Room getRoom(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        Room r3 = getRoomMap().get(r2);
        if (r3 == null) goto L14;
        return r3;
    L14:
        return this.room;
    L10:
        return this.room;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void removeEnterActionParams(String r5) {
        boolean r0 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        Bundle r3 = (Bundle) getData().getValue();
    L12:
        if (r3 != null) goto L14;
        return;
    L14:
        r3.remove("locallife_live_enter_action_params");
        if (r5 != null) goto L17;
    L18:
        r0 = true;
    L19:
        if (r0 == false) goto L21;
        getData().setValue(r3);
    L22:
        IHostLiveLocalLife r1 = k.f(IHostLiveLocalLife.class);
        if (r1 != null) goto L25;
        return;
    L25:
        if (r1.getLiveLifeIconButtonOptEnable() != true) goto L36;
        Map<String, RoomSession> r4 = this.sessionMap;
        if (r4 == null) goto L31;
        RoomSession r6 = r4.get(r5);
        if (r6 == null) goto L31;
        DataCenter r7 = r6.getDataCenter();
    L32:
        if (r7 == null) goto L37;
        r7.put("data_enter_locallife_live_params", null);
        return;
    L37:
        return;
    L31:
        r7 = null;
        goto L32
    L36:
        return;
    L21:
        getMultiRoomData().put(r5, r3);
        goto L22
    L17:
        if (r5.length() != 0) goto L19;
    L11:
        r3 = getMultiRoomData().get(r5);
        goto L12
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void removeShortTermStateListener(ShortTermStateListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.shortTermStatelisteners.remove(r2);
    }

    public final void setCurrentEnvParams(String r1) {
        this.currentEnvParams = r1;
    }

    public final void setEnterFromMerge(String r1) {
        this.enterFromMerge = r1;
    }

    public final void setEnterMethod(String r1) {
        this.enterMethod = r1;
    }

    public final void setEnterSaleChannel(String r1) {
        this.enterSaleChannel = r1;
    }

    public final void setFirstRoomId(Long r1) {
        this.firstRoomId = r1;
    }

    public final void setLifeShareId(String r2) {
        Room r0 = this.room;
        if (r0 == null) goto L6;
        r0.lifeShareId = r2;
        return;
    }

    public final void setLiveLifeInfoHandler(ILiveLifeInfoHandler r1) {
        this.liveLifeInfoHandler = r1;
    }

    public final void setShortTermState(ShortTermState r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        this.shortTermState = r3;
        Iterator<T> r0 = this.shortTermStatelisteners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ShortTermStateListener) r0.next()).onChange(r3);
        goto L4
    }

    public final void setData(RoomSession r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r26, "session");
        Room r0 = r26.w;
        if (r0 == null) goto L20;
        DataCenter r1 = r26.getDataCenter();
        if (r1 == null) goto L8;
        String r2 = z.d(r1, Long.valueOf(r0.id));
        if (r2 == null) goto L8;
    L9:
        getRoomMap().put(r2, r0);
        IHostLiveLocalLife r3 = getLiveLocalLifeService();
        if (r3 != null) goto L12;
    L19:
        Unit r4 = Unit.INSTANCE;
        String r5 = r2;
    L21:
        this.room = r0;
        DataCenter r6 = r26.getDataCenter();
        if (r6 == null) goto L24;
        Bundle r7 = (Bundle) r6.get("data_enter_live_life_params", new Bundle());
    L25:
        LiveLifeEnterParams r8 = LiveLifeParamsHandler.INSTANCE.getLiveLifeEnterParams("", r5, r7);
        if (this.firstRoomId != null) goto L32;
        Room r9 = this.room;
        if (r9 == null) goto L30;
        Long r10 = Long.valueOf(r9.getRoomId());
    L31:
        this.firstRoomId = r10;
        goto L32
    L30:
        r10 = null;
    L32:
        Bundle r11 = new Bundle();
        r0 r12 = r26.getEnterInfo();
        r11.putString("enter_method", r12.f);
        r11.putString("action_type", r12.a);
        r11.putString("request_id", r12.j);
        r11.putString("click_method", r12.g);
        Bundle r13 = r26.getEnterInfo().E;
        if (r13 == null) goto L35;
        String r14 = r13.getString("live_recommend_info", "");
    L36:
        r11.putString("live_recommend_info", r14);
        Room r15 = this.room;
        if (r15 == null) goto L42;
        RoomLifeGrouponInfo r16 = r15.lifeGrouponInfo;
        if (r16 == null) goto L42;
        String r17 = r16.getLifeLivePackComponentConfig();
        if (r17 == null) goto L42;
    L43:
        r11.putString("life_live_pack_component_config", r17);
        r11.putString("room_id", String.valueOf(r26.getRoomId()));
        Room r18 = r26.w;
        if (r18 == null) goto L46;
        String r19 = r18.getOwnerUserIdString();
    L47:
        r11.putString("anchor_id", String.valueOf(r19));
        String r20 = r26.getExtra().getString("live.intent.extra.ENTER_AWEME_ID");
        if (r20 != null) goto L50;
    L53:
        boolean r21 = true;
    L55:
        if (r21 == false) goto L75;
        Bundle r22 = r26.getEnterInfo().E;
        if (r22 == null) goto L59;
        String r23 = r22.getString("live.intent.extra.EXTRA_PARAMS", "");
    L60:
        if (r23 != null) goto L62;
    L65:
        boolean r110 = true;
    L66:
        if (r110 == false) goto L281;
        o r24 = u.l().c(x.class);
        if (r24 == null) goto L75;
        String r25 = r24.getMap().get("video_id");
    L76:
        r11.putString("video_id", r25);
        if (r26.getScreenOrientation() != 1) goto L79;
        String r28 = BDLocationException.ERROR_TIMEOUT;
    L80:
        r11.putString("screen_type", r28);
        DataCenter r29 = r26.getDataCenter();
        if (r29 == null) goto L83;
        Boolean r30 = (Boolean) r29.get("data_is_portrait", Boolean.TRUE);
    L84:
        r11.putBoolean("is_portrait", Intrinsics.areEqual(r30, Boolean.TRUE));
        DataCenter r31 = r26.getDataCenter();
        if (r31 == null) goto L89;
        Boolean r32 = (Boolean) r31.get("data_is_anchor", Boolean.FALSE);
        if (r32 == null) goto L89;
        boolean r33 = r32.booleanValue();
    L90:
        r11.putBoolean("is_anchor", r33);
        DataCenter r34 = r26.getDataCenter();
        if (r34 == null) goto L94;
        String r35 = (String) r34.get("data_enter_locallife_live_params", "");
        if (r35 == null) goto L94;
    L95:
        IHostLiveLocalLife r111 = getLiveLocalLifeService();
        if (r111 == null) goto L278;
        String r112 = r5;
        r111.addDebugData(r112, TYPE_OLD_ENTER_PARAM, "get_params", null, r35);
        Unit r113 = Unit.INSTANCE;
    L278:
        if (Intrinsics.areEqual(r26.getEnterInfo().a, "click") == false) goto L106;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r35) == false) goto L106;
        this.enterSaleChannel = new JSONObject(r35).optString("sale_channel");     // Catch: JSONException -> L104
    L106:
        if (Intrinsics.areEqual(r26.getEnterInfo().a, "draw") == false) goto L115;
        if (r35.length() != 0) goto L110;
        boolean r36 = true;
    L111:
        if (r36 == false) goto L113;
        JSONObject r37 = new JSONObject();     // Catch: JSONException -> L104
    L114:
        r37.put("sale_channel", this.enterSaleChannel);     // Catch: JSONException -> L104
        r35 = r37.toString();     // Catch: JSONException -> L104
        goto L115
    L113:
        r37 = new JSONObject(r35);     // Catch: JSONException -> L104
        goto L114
    L110:
        r36 = false;
    L115:
        IHostLiveLocalLife r114 = getLiveLocalLifeService();
        if (r114 == null) goto L118;
        String r115 = r5;
        r114.addDebugData(r115, TYPE_OLD_ENTER_PARAM, "set_params", null, r35);
        Unit r38 = Unit.INSTANCE;
    L118:
        r11.putString("data_enter_locallife_live_params", r35);
        r11.putString("locallife_live_enter_action_params", r35);
        if (r8 == null) goto L121;
        Map r39 = r8.getLogInfo();
    L122:
        if (r39 != null) goto L124;
    L127:
        boolean r40 = true;
    L128:
        if (r40 == true) goto L136;
        Bundle r41 = r26.getEnterInfo().E;
        Room r42 = this.room;
        if (r42 == null) goto L134;
        RoomSpecificSceneTypeInfo r43 = r42.getSceneTypeInfo();
        if (r43 == null) goto L134;
        boolean r44 = r43.isLife();
    L135:
        boolean r45 = r44;
        LiveLifeEnterParams r46 = r8;
        refreshLogInfoV2(r8, r41, r27, r45, r26.getEnterInfo().a);
    L137:
        DataCenter r47 = r26.getDataCenter();
        if (r47 == null) goto L141;
        String r48 = (String) r47.get("data_enter_locallife_live_env_params", "");
        if (r48 == null) goto L141;
    L142:
        this.currentEnvParams = r48;
        IHostLiveLocalLife r116 = getLiveLocalLifeService();
        if (r116 == null) goto L145;
        String r117 = r5;
        r116.addDebugData(r117, TYPE_OLD_ENTER_PARAM, "get_env_params", null, this.currentEnvParams);
        Unit r49 = Unit.INSTANCE;
    L145:
        Bundle r50 = r26.getEnterInfo().E;
        Room r51 = this.room;
        if (r51 == null) goto L150;
        RoomSpecificSceneTypeInfo r52 = r51.getSceneTypeInfo();
        if (r52 == null) goto L150;
        boolean r53 = r52.isLife();
    L151:
        refreshLogInfo(r50, r27, r53, r26.getEnterInfo().a);
        IHostLiveLocalLife r118 = getLiveLocalLifeService();
        if (r118 == null) goto L154;
        String r119 = r5;
        r118.addDebugData(r119, TYPE_OLD_ENTER_PARAM, "set_env_params", null, this.currentEnvParams);
        Unit r54 = Unit.INSTANCE;
    L154:
        r11.putString("data_enter_locallife_live_env_params", this.currentEnvParams);
        this.enterFromMerge = r26.getEnterInfo().d;
        this.enterMethod = r26.getEnterInfo().f;
        r11.putString("im_tracker_extra", r26.getExtra().getString("im_tracker_extra"));
        DataCenter r55 = r26.getDataCenter();
        if (r55 == null) goto L158;
        String r56 = (String) r55.get("log_enter_params", r22);
        if (r56 == null) goto L158;
    L159:
        r11.putString("log_enter_params", r56);
        r11.putString("log_pb", r26.getEnterInfo().k);
        if (r26.getExtra().containsKey("is_life") == false) goto L162;
        r11.putString("is_life", String.valueOf(r26.getExtra().getInt("is_life")));
    L168:
        if (r26.getExtra().containsKey("feed_resp_from") == false) goto L170;
        r11.putString("feed_resp_from", r26.getExtra().getString("feed_resp_from"));
    L170:
        DataCenter r57 = r26.getDataCenter();
        if (r57 == null) goto L175;
        Boolean r58 = (Boolean) r57.get("data_current_is_preview", Boolean.FALSE);
        if (r58 == null) goto L175;
        boolean r59 = r58.booleanValue();
    L176:
        r11.putBoolean("data_current_is_preview", r59);
        if (r46 != null) goto L279;
    L182:
        if (r46 != null) goto L184;
    L283:
        Bundle r60 = r26.getEnterInfo().E;     // Catch: Exception -> L270
        if (r60 == null) goto L221;
        String r61 = r60.getString("live.intent.extra.EXTRA_PARAMS", r22);     // Catch: Exception -> L270
        if (r61 == null) goto L221;
        Bundle r62 = r26.getEnterInfo().E;     // Catch: Exception -> L270
        if (r62 == null) goto L220;
        String r63 = r62.getString("life_extra_info");     // Catch: Exception -> L270
        if (r63 == null) goto L220;
        if (r61.length() != 0) goto L199;
        boolean r64 = true;
    L200:
        if (r64 == false) goto L202;
        JSONObject r65 = new JSONObject();     // Catch: Exception -> L270
        r65.put("life_extra_info", r63);     // Catch: Exception -> L270
        r61 = r65.toString();     // Catch: Exception -> L270
    L219:
        Unit r66 = Unit.INSTANCE;     // Catch: Exception -> L270
        goto L220
    L202:
        JSONObject r67 = new JSONObject(r61);     // Catch: Exception -> L270
        String r68 = r67.optString("life_extra_info", r22);     // Catch: Exception -> L270
        if (r68 != null) goto L205;
    L208:
        boolean r69 = true;
    L209:
        if (r69 == false) goto L211;
        r67.put("life_extra_info", r63);     // Catch: Exception -> L270
    L218:
        r61 = r67.toString();     // Catch: Exception -> L270
        goto L219
    L211:
        JSONObject r70 = new JSONObject(r63);     // Catch: Exception -> L270
        JSONObject r71 = new JSONObject(r68);     // Catch: Exception -> L270
        Iterator<String> r72 = r70.keys();     // Catch: Exception -> L270
    L213:
        if (r72.hasNext() == false) goto L217;
        String r73 = r72.next();     // Catch: Exception -> L270
        if (r71.has(r73) == true) goto L213;
        r71.put(r73, r70.get(r73));     // Catch: Exception -> L270
        goto L213
    L217:
        r67.put("life_extra_info", r71.toString());     // Catch: Exception -> L270
        goto L218
    L205:
        if (r68.length() == 0) goto L208;
        r69 = false;
        goto L209
    L199:
        r64 = false;
    L220:
        r11.putString("extra_params", r61);     // Catch: Exception -> L270
        Unit r74 = Unit.INSTANCE;     // Catch: Exception -> L270
    L221:
        String r75 = r26.getEnterInfo().u.getString("life_reflux_info");     // Catch: Exception -> L270
        if (r75 == null) goto L224;
        r11.putString("life_reflux_info", r75);     // Catch: Exception -> L270
        Unit r76 = Unit.INSTANCE;     // Catch: Exception -> L270
    L224:
        String r77 = r26.getEnterInfo().u.getString("life_share_reflux_info");     // Catch: Exception -> L270
        if (r77 == null) goto L227;
        r11.putString("life_share_reflux_info", r77);     // Catch: Exception -> L270
        Unit r78 = Unit.INSTANCE;     // Catch: Exception -> L270
    L227:
        String r79 = r26.getExtra().getString("search_params", r22);     // Catch: Exception -> L270
        if (r79 != null) goto L230;
    L233:
        boolean r120 = true;
    L235:
        if (r120 == false) goto L240;
        Bundle r80 = m0.a(r26.getExtra());     // Catch: Exception -> L270
        if (r80 == null) goto L239;
        String r81 = r80.getString("search_id", r22);     // Catch: Exception -> L270
        String r82 = r80.getString("extra_search_result_id", r22);     // Catch: Exception -> L270
        Unit r83 = Unit.INSTANCE;     // Catch: Exception -> L270
    L242:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r81) == false) goto L245;
        r11.putString("search_id", r81);     // Catch: Exception -> L270
    L245:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r82) == false) goto L247;
        r11.putString("search_result_id", r82);     // Catch: Exception -> L270
    L247:
        Bundle r85 = r26.getExtra().getBundle("live.intent.extra.EXTRA_COMMON_LOG");     // Catch: Exception -> L270
        if (r85 == null) goto L254;
        String r86 = r85.getString("delivery_status_start", r22);     // Catch: Exception -> L270
        if (r86 == null) goto L254;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r86) == false) goto L254;
        r11.putString("delivery_status_start", r86);     // Catch: Exception -> L270
    L254:
        IHostLiveLocalLife r87 = getLiveLocalLifeService();     // Catch: Exception -> L270
        if (r87 == null) goto L271;
        if (r87.shouldResetEnterFromMerge() != true) goto L271;
        Map<String, String> r88 = u.l().c(x.class).getMap();     // Catch: Exception -> L270
        if (r88.containsKey("enter_from_ad_type") == false) goto L265;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r88.get("enter_from_ad_type")) == false) goto L265;
        r11.putString("enter_from_merge", r88.get("enter_from_ad_type"));     // Catch: Exception -> L270
    L265:
        if (r88.containsKey("enter_from_merge") == false) goto L271;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r88.get("enter_from_merge")) == false) goto L271;
        r11.putString("enter_from_merge", r88.get("enter_from_merge"));     // Catch: Exception -> L270
        goto L271
    L239:
        r82 = r22;
        r81 = r82;
        goto L242
    L240:
        JSONObject r89 = new JSONObject(r79);     // Catch: Exception -> L270
        r81 = r89.optString("search_id", r22);     // Catch: Exception -> L270
        String r90 = r89.optString("search_result_id", r22);     // Catch: Exception -> L270
        r11.putString("search_params", r79);     // Catch: Exception -> L270
        r82 = r90;
        goto L242
    L230:
        if (r79.length() == 0) goto L233;
        r120 = false;
    L271:
        MutableLiveData<Bundle> r91 = getData();
        Map<String, Bundle> r92 = getMultiRoomData();
        DataCenter r93 = r26.getDataCenter();
        if (r93 == null) goto L275;
        String r94 = z.d(r93, Long.valueOf(r26.getRoomId()));
        if (r94 == null) goto L275;
    L276:
        r92.put(r94, r11);
        Unit r95 = Unit.INSTANCE;
        r91.setValue(r11);
        return;
    L275:
        r94 = r22;
        goto L276
    L184:
        if (r46.isEmpty() == true) goto L283;
        IHostLiveLocalLife r121 = getLiveLocalLifeService();
        if (r121 == null) goto L283;
        String r122 = r5;
        r121.addDebugData(r122, TYPE_NEW_ENTER_PARAM, "set_merge_param", null, r46);
        Unit r96 = Unit.INSTANCE;
        goto L283
    L279:
        String r97 = GsonHelper.get().toJson(r46);     // Catch: Exception -> L180
    L181:
        r11.putString("life_enter_params", r97);
        Unit r98 = Unit.INSTANCE;
    L180:
        r97 = r22;
    L175:
        r59 = false;
        goto L176
    L162:
        Room r99 = this.room;
        if (r99 == null) goto L165;
        String r100 = r99.isLifeCart();
    L166:
        r11.putString("is_life", r100);
        goto L168
    L165:
        r100 = null;
    L158:
        r56 = r22;
    L150:
        r53 = false;
    L141:
        r48 = r22;
    L134:
        r44 = false;
        goto L135
    L136:
        r46 = r8;
        goto L137
    L124:
        if (r39.isEmpty() == true) goto L127;
        r40 = false;
        goto L128
    L121:
        r39 = null;
    L94:
        r35 = "";
    L89:
        r33 = false;
        goto L90
    L83:
        r30 = null;
        goto L84
    L79:
        r28 = "1";
        goto L80
    L281:
        r25 = new JSONObject(r23).optString("group_id", "");     // Catch: Exception -> L70
    L62:
        if (r23.length() == 0) goto L65;
        r110 = false;
        goto L66
    L59:
        r23 = null;
    L75:
        r25 = r20;
        goto L76
    L50:
        if (r20.length() == 0) goto L53;
        r21 = false;
        goto L55
    L46:
        r19 = null;
    L42:
        r17 = "";
        goto L43
    L35:
        r14 = null;
        goto L36
    L24:
        r7 = null;
        goto L25
    L12:
        if (r3.getLiveLifeIconButtonOptEnable() != true) goto L19;
        if (this.sessionMap != null) goto L16;
        this.sessionMap = new LinkedHashMap();
    L16:
        Map<String, RoomSession> r101 = this.sessionMap;
        if (r101 == null) goto L19;
        RoomSession r102 = r101.put(r2, r26);
    L8:
        r2 = "";
        goto L9
    L20:
        r5 = "";
        r0 = null;
        goto L21
    }

    public final void setPreviewData(DataCenter r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "uniqueKey");
        Room r0 = z.o(r6);
        getRoomMap().put(r7, r0);
        Unit r1 = Unit.INSTANCE;
        this.room = r0;
        Bundle r2 = new Bundle();
        Room r3 = this.room;
        String r4 = null;
        if (r3 == null) goto L5;
        Long r5 = Long.valueOf(r3.getRoomId());
    L6:
        r2.putString("room_id", String.valueOf(r5));
        Room r8 = this.room;
        if (r8 == null) goto L9;
        String r9 = r8.getOwnerUserIdString();
    L10:
        r2.putString("anchor_id", String.valueOf(r9));
        Boolean r10 = Boolean.TRUE;
        r2.putBoolean("is_portrait", Intrinsics.areEqual((Boolean) r6.get("data_is_portrait", r10), r10));
        Room r11 = this.room;
        if (r11 == null) goto L13;
        r4 = r11.isLifeCart();
    L13:
        r2.putString("is_life", r4);
        Boolean r12 = (Boolean) r6.get("data_is_anchor", Boolean.FALSE);
        if (r12 == null) goto L16;
        boolean r13 = r12.booleanValue();
    L17:
        r2.putBoolean("is_anchor", r13);
        Bundle r14 = (Bundle) r6.get("data_preview_outer_merge_data", new Bundle());
        r2.putString("enter_method", r14.getString("enter_method"));
        r2.putString("action_type", r14.getString("action_type"));
        r2.putString("video_id", r14.getString("video_id"));
        r2.putString("request_id", r14.getString("request_id"));
        r2.putString("enter_from_merge", r14.getString("enter_from_merge"));
        getMultiRoomData().put(r7, r2);
        return;
    L16:
        r13 = false;
        goto L17
    L9:
        r9 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final void setRoom(Room r2, String r3) {
        this.room = r2;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r3) == false) goto L10;
        if (r2 == null) goto L11;
        Map<String, Room> r0 = getRoomMap();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.put(r3, r2);
        return;
    L11:
        return;
    }

    public static /* synthetic */ Room getRoom$default(LiveLocalLifeDataViewModel r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "";
    L6:
        return r0.getRoom(r1);
    }

    private final void refreshLogInfo(Bundle r9, boolean r10, boolean r11, String r12) {
        String r0 = this.currentEnvParams;
        Intrinsics.checkNotNullParameter(r12, "enterType");
        c[] r1 = new c[3];
        Long r3 = null;
        if (r9 == null) goto L5;
        String r13 = r9.getString("live_recommend_info");
    L6:
        Long r4 = this.firstRoomId;
        Room r5 = this.room;
        if (r5 == null) goto L9;
        r3 = Long.valueOf(r5.getRoomId());
    L9:
        i r2 = new i(r13, Intrinsics.areEqual(r4, r3));
        boolean r14 = false;
        r1[0] = r2;
        r1[1] = new e(r10, r11);
        r1[2] = new com.bytedance.android.livesdk.locallife.a(this.enterFromMerge, r12);
        List r15 = CollectionsKt.listOf(r1);
        Intrinsics.checkNotNullParameter(r15, "interceptors");
        JSONObject r6 = new JSONObject(r0);     // Catch: Exception -> L32
        JSONObject r7 = r6.optJSONObject("log_info");     // Catch: Exception -> L32
        if (r7 != null) goto L13;
        r7 = new JSONObject();     // Catch: Exception -> L32
    L13:
        JSONObject r8 = r7.optJSONObject("life_extra_info");     // Catch: Exception -> L32
        if (r8 != null) goto L16;
        r8 = new JSONObject();     // Catch: Exception -> L32
    L16:
        Iterator r16 = r15.iterator();     // Catch: Exception -> L32
    L18:
        if (r16.hasNext() == false) goto L21;
        ((c) r16.next()).a(r8);     // Catch: Exception -> L32
        goto L18
    L21:
        if (r7.optString("is_from_nearby_outer_feed").length() <= 0) goto L23;
        boolean r17 = true;
    L24:
        if (r17 == true) goto L26;
    L30:
        r6.put("log_info", r7.put("life_extra_info", r8));     // Catch: Exception -> L32
        r0 = r6.toString();     // Catch: Exception -> L32
    L35:
        this.currentEnvParams = r0;
        if (r0 != null) goto L38;
    L39:
        r14 = true;
    L40:
        if (r14 == true) goto L46;
        u.l().c(x.class).c("locallife_live_env_params", this.currentEnvParams);
        return;
    L46:
        return;
    L38:
        if (r0.length() != 0) goto L40;
    L26:
        if (Intrinsics.areEqual(r12, "click") == false) goto L28;
        String r18 = "1";
    L29:
        r8.put("is_from_nearby_outer_feed", r18);     // Catch: Exception -> L32
        goto L30
    L28:
        r18 = BDLocationException.ERROR_TIMEOUT;
        goto L29
    L23:
        r17 = false;
    L33:
        if (r0 != null) goto L35;
        r0 = "";
        goto L35
    L5:
        r13 = null;
        goto L6
    }

    public final void refreshData(Bundle r11, boolean r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "enterExtra");
        Intrinsics.checkNotNullParameter(r14, "enterType");
        Bundle r0 = r11.getBundle("live.intent.extra.live_life_param");
        LiveLifeEnterParams r5 = LiveLifeParamsHandler.INSTANCE.getLiveLifeEnterParams("show_", "temp", r0);
        if (r5 == null) goto L5;
        Map r1 = r5.getLogInfo();
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
        refreshLogInfoV2(r5, r11, r12, r13, r14);
    L15:
        String r4 = this.currentEnvParams;
        if (r4 != null) goto L18;
    L19:
        r2 = true;
    L20:
        if (r2 == true) goto L25;
        refreshLogInfo(r11, r12, r13, r14);
        Bundle r15 = (Bundle) getData().getValue();
        if (r15 == null) goto L26;
        r15.putString("data_enter_locallife_live_env_params", this.currentEnvParams);
        return;
    L26:
        return;
    L25:
        return;
    L18:
        if (r4.length() != 0) goto L20;
    L9:
        if (r1.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    private final void refreshLogInfoV2(LiveLifeEnterParams r7, Bundle r8, boolean r9, boolean r10, String r11) {
        if (r7 != null) goto L4;
        return;
    L4:
        Intrinsics.checkNotNullParameter(r7, "liveLifeEnterParams");
        Intrinsics.checkNotNullParameter(r11, "enterType");
        d[] r0 = new d[3];
        Object r2 = null;
        if (r8 == null) goto L7;
        String r12 = r8.getString("live_recommend_info");
    L8:
        Long r3 = this.firstRoomId;
        Room r4 = this.room;
        if (r4 == null) goto L11;
        Long r5 = Long.valueOf(r4.getRoomId());
    L12:
        j r1 = new j(r12, Intrinsics.areEqual(r3, r5));
        boolean r13 = false;
        r0[0] = r1;
        r0[1] = new f(r9, r10);
        r0[2] = new b(this.enterFromMerge, r11);
        List r14 = CollectionsKt.listOf(r0);
        Intrinsics.checkNotNullParameter(r14, "interceptors");
        Map r6 = r7.getLogInfo();
        if (r6 == null) goto L15;
        Object r15 = r6.get("life_extra_info");
    L17:
        if (TypeIntrinsics.isMutableMap(r15) == true) goto L19;
        r15 = null;
    L19:
        Map<String, Object> r16 = (Map) r15;
        if (r16 == null) goto L25;
        Iterator r17 = r14.iterator();
    L23:
        if (r17.hasNext() == false) goto L25;
        ((d) r17.next()).handle(r16);
    L25:
        if (r6 == null) goto L39;
        Object r18 = r6.get("is_from_nearby_outer_feed");
        if (r18 == null) goto L39;
        if ((r18 instanceof String) == false) goto L33;
        r2 = r18;
    L33:
        if (((String) r2) == null) goto L39;
        if (Intrinsics.areEqual(r11, "click") == false) goto L37;
        String r19 = "1";
    L38:
        r6.put("is_from_nearby_outer_feed", r19);
        goto L39
    L37:
        r19 = BDLocationException.ERROR_TIMEOUT;
    L39:
        Map r20 = r7.getLogInfo();
        if (r20 != null) goto L42;
    L43:
        r13 = true;
    L44:
        if (r13 == true) goto L55;
        o r21 = u.l().c(x.class);
        Iterator r22 = r20.entrySet().iterator();
    L47:
        if (r22.hasNext() == false) goto L64;
        Map.Entry r23 = (Map.Entry) r22.next();
        String r110 = (String) r23.getKey();
        Object r24 = r23.getValue();
        if ((r24 instanceof String) == true) goto L50;
        String r25 = GsonHelper.get().toJson(r24);     // Catch: Exception -> L53
    L54:
        r21.c(r110, r25);
    L53:
        r25 = "";
        goto L54
    L50:
        r21.c(r110, (String) r24);
        goto L47
    L64:
        return;
    L55:
        return;
    L42:
        if (r20.isEmpty() == false) goto L44;
    L15:
        r15 = null;
        goto L17
    L11:
        r5 = null;
        goto L12
    L7:
        r12 = null;
        goto L8
    }

    public static /* synthetic */ void setRoom$default(LiveLocalLifeDataViewModel r0, Room r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        r0.setRoom(r1, r2);
    }
}
