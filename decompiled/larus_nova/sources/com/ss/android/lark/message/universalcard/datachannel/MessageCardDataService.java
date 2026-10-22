package com.ss.android.lark.message.universalcard.datachannel;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizType;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardEntityAddedNotify;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.CardRenderData;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.framework.thread.ThreadUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.message.p;
import com.ss.android.lark.sdk.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class MessageCardDataService implements com.ss.android.lark.message.universalcard.datachannel.a, g.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<Boolean> f432235c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<g.b> f432236d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UniversalCardSubscriptionManager f432237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, CardRenderData> f432238b;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
        f432235c = LazyKt.lazy(MessageCardDataService$Companion$streamingCardMergeEnable$2.INSTANCE);
        f432236d = new ArrayList();
    }

    @Override // com.ss.android.lark.message.universalcard.datachannel.a
    public final void onDestroy() {
        Log.i("MessageCardDataService", MapMonitorConst.EVENT_DESTROY);
        if (f432235c.getValue().booleanValue() == true) goto L8;
        Log.i("MessageCardDataService", "unRegisterPushListener");
        ArrayList r100 = (ArrayList) f432236d;
        r100.remove(this);
        if (r100.isEmpty() == false) goto L8;
        Log.i("MessageCardDataService", "unRegisterPushListener to sdk");
        g.e.f439875a.c(Command.PUSH_UNIVERSAL_CARD_ENTITY_ADDED);
    L8:
        UniversalCardSubscriptionManager r101 = this.f432237a;
        if (r101.f432250d == false) goto L11;
        Log.e("UniversalCardSubscriptionManager", "destroy, already destroyed");
    L12:
        this.f432238b.clear();
        return;
    L11:
        Log.i("UniversalCardSubscriptionManager", "start destroy");
        r101.f432250d = true;
        r101.f432249c.offer(new UniversalCardSubscriptionManager.DestroyTask(r101));
        r101.f432247a.quitSafely();
        goto L12
    }

    public MessageCardDataService() {
        this.f432237a = new UniversalCardSubscriptionManager();
        this.f432238b = new HashMap();
        if (f432235c.getValue().booleanValue() == true) goto L13;
        Log.i("MessageCardDataService", "registerPushListener");
        ArrayList r100 = (ArrayList) f432236d;
        if (r100.isEmpty() == false) goto L9;
        Log.i("MessageCardDataService", "registerPushListener to sdk");
        g.e.f439875a.b(Command.PUSH_UNIVERSAL_CARD_ENTITY_ADDED, d.f432268a);
    L9:
        if (r100.contains(this) == true) goto L12;
        r100.add(this);
        return;
    L12:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, com.larksuite.component.card.protocol.CardData] */
    @Override // com.ss.android.lark.sdk.g.b
    public final void a(byte[] r100) {
        if (r100 == null) goto L15;
        UniversalCardEntityAddedNotify r101 = UniversalCardEntityAddedNotify.ADAPTER.decode(r100);
        if (r101 == null) goto L13;
        List<UniversalCardEntityAddedNotify.UniversalCardEntityInfo> r102 = r101.universal_card_entity_infos;
        if (r102 == null) goto L16;
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L17;
        UniversalCardEntityAddedNotify.UniversalCardEntityInfo r104 = (UniversalCardEntityAddedNotify.UniversalCardEntityInfo) r103.next();
        Log.i("MessageCardDataService", "onPushEntity card_id=" + r104.entity.card_id);
        UniversalCardEntity r105 = r104.entity;
        Ref.ObjectRef r106 = new Ref.ObjectRef();
        CardDataUtils.f283938a.getClass();
        r106.element = CardDataUtils.b(r105);
        ThreadUtils.runOnUIThread(new c(r106, this));
        goto L11
    L17:
        return;
    L16:
        return;
    L13:
        return;
    }

    @Override // com.ss.android.lark.message.universalcard.datachannel.a
    public final CardRenderData d(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return null;
    L12:
        return this.f432238b.get(r100);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public final void g(CardRenderData r110, boolean r111) {
        CardRenderData.LinkType r100 = r110.component1();
        CardData r101 = r110.component3();
        String r102 = r101.getUniversalCardID();
        if (r102 == null) goto L79;
        boolean r103 = false;
        boolean r104 = true;
        if (r102.length() <= 0) goto L7;
        boolean r105 = true;
    L8:
        Object r106 = null;
        if (r105 == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L79;
        String r107 = r101.getUniversalCardVersion();
        if (r107 == null) goto L19;
        Long r108 = StringsKt.toLongOrNull(r107);
        if (r108 == null) goto L19;
    L24:
        long r109 = r108.longValue();
        CardRenderData r112 = this.f432238b.get(r102);
        StringBuilder r113 = new StringBuilder("UpdateCardRenderData ");
        r113.append(r110.getBizID());
        r113.append(" cache: ");
        if (r112 == null) goto L29;
        CardData r114 = r112.getCardData();
        if (r114 == null) goto L29;
        String r115 = r114.getUniversalCardVersion();
    L30:
        r113.append(r115);
        r113.append(", new: ");
        r113.append(r101.getUniversalCardVersion());
        r113.append(", source: ");
        r113.append(r100);
        Log.i("MessageCardDataService", r113.toString());
        if (r112 != null) goto L33;
        this.f432238b.put(r102, r110);
    L56:
        if (r111 == false) goto L76;
        if (r104 == false) goto L85;
        CardRenderData r116 = this.f432238b.get(r102);
        if (r116 == null) goto L62;
        r110 = r116;
    L62:
        UniversalCardSubscriptionManager r117 = this.f432237a;
        r117.getClass();
        Iterator r118 = new HashMap(r117.f432251e).values().iterator();
    L64:
        if (r118.hasNext() == false) goto L68;
        Object r119 = r118.next();
        if (Intrinsics.areEqual(((UniversalCardSubscriptionManager.b) r119).f432262a, r102) == false) goto L64;
        r106 = r119;
    L68:
        UniversalCardSubscriptionManager.b r120 = (UniversalCardSubscriptionManager.b) r106;
        if (r120 == null) goto L86;
        Map<b, String> r121 = r120.f432264c;
        if (r121 == null) goto L87;
        Iterator<Map.Entry<b, String>> r122 = r121.entrySet().iterator();
    L74:
        if (r122.hasNext() == false) goto L88;
        r122.next().getKey().a(r110);
        goto L74
    L88:
        return;
    L87:
        return;
    L86:
        return;
    L85:
        return;
    L76:
        return;
    L33:
        String r123 = r112.getCardData().getUniversalCardVersion();
        if (r123 == null) goto L37;
        Long r124 = StringsKt.toLongOrNull(r123);
        if (r124 == null) goto L37;
    L41:
        if (r124 != null) goto L45;
        Log.e("MessageCardDataService", "UpdateCardRenderData " + r110.getBizID() + " cardDataVersion or dataVersion is null");
        return;
    L45:
        if (r109 < r124.longValue()) goto L48;
        this.f432238b.put(r102, r110);
    L48:
        if (r110.getLinkType() != CardRenderData.LinkType.MESSAGE) goto L53;
        CardRenderData r125 = this.f432238b.get(r102);
        if (r125 == null) goto L53;
        r125.setCardContext(r110.getCardContext());
        r125.setCardConfig(r110.getCardConfig());
    L53:
        if (r109 <= r124.longValue()) goto L55;
        r103 = true;
    L55:
        r104 = r103;
    L37:
        String r126 = r112.getCardData().getVersion();
        if (r126 == null) goto L40;
        r124 = StringsKt.toLongOrNull(r126);
        goto L41
    L40:
        r124 = null;
    L29:
        r115 = null;
    L19:
        String r127 = r101.getVersion();
        if (r127 == null) goto L22;
        r108 = StringsKt.toLongOrNull(r127);
    L23:
        if (r108 != null) goto L24;
        Log.i("MessageCardDataService", "UpdateCardRenderData " + r110.getBizID() + " universalCardVersion is null");
        return;
    L22:
        r108 = null;
        goto L23
    L7:
        r105 = false;
    L79:
        Log.i("MessageCardDataService", "UpdateCardRenderData " + r110.getBizID() + " universalCardID is empty");
    }

    @Override // com.ss.android.lark.message.universalcard.datachannel.a
    public final void b(String r100, String r110, p r111) {
        Intrinsics.checkNotNullParameter(r111, "subscriber");
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        Log.e("MessageCardDataService", "subscribeCardRenderData messageID is null");
        return;
    L13:
        if (r110 != null) goto L15;
    L18:
        if (r101 == false) goto L21;
        Log.e("MessageCardDataService", "subscribeCardRenderData universalCardID is null");
        return;
    L21:
        CardRenderData r103 = this.f432238b.get(r110);
        if (r103 != null) goto L26;
        Log.e("MessageCardDataService", "subscribeCardRenderData render data is null");
        return;
    L26:
        if (r103.getCardData().isStreamingMode() == false) goto L32;
        UniversalCardSubscriptionManager r104 = this.f432237a;
        int r105 = UniversalCardBizType.BIZ_TYPE_MESSAGE_CARD.getValue();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "bizID");
        Intrinsics.checkNotNullParameter(r110, "universalCardID");
        Intrinsics.checkNotNullParameter(r111, "subscriber");
        if (r104.f432250d == false) goto L30;
        Log.e("UniversalCardSubscriptionManager", "subscribeCardRenderData, already destroyed");
        return;
    L30:
        UniversalCardSubscriptionManager.SubscriptionTask r106 = new UniversalCardSubscriptionManager.SubscriptionTask(r104, r100, r105, r110, r111);
        r104.f432249c.offer(r106);
        return;
    L32:
        return;
    L15:
        if (r110.length() == 0) goto L18;
        r101 = false;
        goto L18
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    @Override // com.ss.android.lark.message.universalcard.datachannel.a
    public final void e(String r100, String r101, p r102) {
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        boolean r103 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L13;
        Log.w("MessageCardDataService", "unsubscribeCardRenderData messageID is null");
        return;
    L13:
        if (r101 != null) goto L15;
    L18:
        if (r103 == false) goto L22;
        Log.w("MessageCardDataService", "unsubscribeCardRenderData universalCardID is null");
        return;
    L22:
        if (this.f432238b.get(r101) != null) goto L25;
        Log.w("MessageCardDataService", "unsubscribeCardRenderData render data is null");
        return;
    L25:
        UniversalCardSubscriptionManager r105 = this.f432237a;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "bizID");
        Intrinsics.checkNotNullParameter(r101, "universalCardID");
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        if (r105.f432250d == false) goto L28;
        Log.e("UniversalCardSubscriptionManager", "unsubscribeCardRenderData, already destroyed");
        return;
    L28:
        UniversalCardSubscriptionManager.UnSubscriptionTask r106 = new UniversalCardSubscriptionManager.UnSubscriptionTask(r105, r100, r101, r102);
        r105.f432249c.offer(r106);
        return;
    L15:
        if (r101.length() == 0) goto L18;
        r103 = false;
        goto L18
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L10
    }

    @Override // com.ss.android.lark.message.universalcard.datachannel.a
    public final void c(String r100, CardData r101, CardContext r110, CardConfig r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276353c);
        Intrinsics.checkNotNullParameter(r101, "cardData");
        Intrinsics.checkNotNullParameter(r110, "cardContext");
        Intrinsics.checkNotNullParameter(r111, "cardConfig");
        g(new CardRenderData(CardRenderData.LinkType.MESSAGE, r100, r101, r110, r111), r112);
    }
}
