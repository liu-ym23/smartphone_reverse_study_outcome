package com.larksuite.component.card.datachannel;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.bytedance.lark.pb.openplatform.v1.GetUniversalCardEntityByBizParamRequest;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizParam;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizType;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardEntityAddedNotify;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.component.card.service.f;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.g;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0016\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fJ\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/card/datachannel/UniversalCardDataService;", "Ljava/io/Serializable;", "bizType", "Lcom/bytedance/lark/pb/openplatform/v1/UniversalCardBizType;", "<init>", "(Lcom/bytedance/lark/pb/openplatform/v1/UniversalCardBizType;)V", "getBizType", "()Lcom/bytedance/lark/pb/openplatform/v1/UniversalCardBizType;", "setBizType", "memoryCardEntityCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/lark/pb/basic/v1/UniversalCardEntity;", "bizCardEntityObserverMap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larksuite/component/card/datachannel/UniversalCardDataObserver;", "onPushEntity", "", "request", "", "getCardEntity", "bizId", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/larksuite/component/card/datachannel/GetCardEntityResponse;", "getCardEntityFromNativeCache", "addObserver", "observer", "removeObserver", MapMonitorConst.EVENT_DESTROY, "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniversalCardDataService implements Serializable {
    public static final b Companion = null;
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<UniversalCardDataObserver>> bizCardEntityObserverMap;
    private UniversalCardBizType bizType;
    private final ConcurrentHashMap<String, UniversalCardEntity> memoryCardEntityCache;

    public static final class a implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UniversalCardDataService f283708a;

        public a(UniversalCardDataService r100) {
            this.f283708a = r100;
        }

        @Override // com.ss.android.lark.sdk.g.b
        public final void a(byte[] r100) {
            UniversalCardDataService.access$onPushEntity(this.f283708a, r100);
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public final void destroy() {
        Log.i("UniversalCardDataService", "destroy " + this.bizType);
        g.e.f439875a.c(Command.PUSH_UNIVERSAL_CARD_ENTITY_ADDED);
        this.memoryCardEntityCache.clear();
        this.bizCardEntityObserverMap.clear();
    }

    public final UniversalCardBizType getBizType() {
        return this.bizType;
    }

    public UniversalCardDataService(UniversalCardBizType r100) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        this.bizType = r100;
        this.memoryCardEntityCache = new ConcurrentHashMap();
        this.bizCardEntityObserverMap = new ConcurrentHashMap();
        g.e.f439875a.b(Command.PUSH_UNIVERSAL_CARD_ENTITY_ADDED, new a(this));
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMemoryCardEntityCache$p(UniversalCardDataService r100) {
        return r100.memoryCardEntityCache;
    }

    public final UniversalCardEntity getCardEntityFromNativeCache(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        return this.memoryCardEntityCache.get(r100);
    }

    public final void setBizType(UniversalCardBizType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bizType = r100;
    }

    public static final void access$onPushEntity(UniversalCardDataService r100, byte[] r101) {
        r100.getClass();
        if (r101 == null) goto L36;
        Iterator<UniversalCardEntityAddedNotify.UniversalCardEntityInfo> r102 = UniversalCardEntityAddedNotify.ADAPTER.decode(r101).universal_card_entity_infos.iterator();
    L7:
        if (r102.hasNext() == false) goto L37;
        UniversalCardEntityAddedNotify.UniversalCardEntityInfo r103 = r102.next();
        UniversalCardBizParam r104 = r103.biz_param;
        String r105 = null;
        if (r104 == null) goto L11;
        String r106 = r104.biz_id;
    L12:
        if (r106 == null) goto L7;
        Log.i("UniversalCardDataService", "push card data bizId: " + r106 + ", version: " + r103.entity.version);
        if (r100.memoryCardEntityCache.get(r106) == null) goto L21;
        String r107 = r103.entity.version;
        UniversalCardEntity r108 = r100.memoryCardEntityCache.get(r106);
        if (r108 == null) goto L19;
        r105 = r108.version;
    L19:
        if (Intrinsics.areEqual(r107, r105) == false) goto L21;
        Log.i("UniversalCardDataService", "push version is same cache version");
        return;
    L21:
        r100.memoryCardEntityCache.put(r106, r103.entity);
        CopyOnWriteArrayList<UniversalCardDataObserver> r109 = r100.bizCardEntityObserverMap.get(r106);
        if (r109 == null) goto L7;
        Iterator<UniversalCardDataObserver> r110 = r109.iterator();
    L25:
        if (r110.hasNext() == false) goto L7;
        r110.next().notify(r106, r103.entity);
        goto L25
    L11:
        r106 = null;
        goto L12
    L37:
        return;
    }

    public final void addObserver(String r100, UniversalCardDataObserver r101) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, "observer");
        if (this.bizCardEntityObserverMap.get(r100) != null) goto L5;
        this.bizCardEntityObserverMap.put(r100, new CopyOnWriteArrayList());
    L5:
        CopyOnWriteArrayList<UniversalCardDataObserver> r102 = this.bizCardEntityObserverMap.get(r100);
        if (r102 == null) goto L9;
        r102.add(r101);
        return;
    }

    public final void getCardEntity(final String r100, final IGetDataCallback<com.larksuite.component.card.datachannel.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        Log.i("UniversalCardDataService", "get card entity bizId is empty");
    L5:
        UniversalCardEntity r102 = getCardEntityFromNativeCache(r100);
        if (r102 == null) goto L8;
        r101.onSuccess(new com.larksuite.component.card.datachannel.a(r102, true));
        return;
    L8:
        IGetDataCallback<UniversalCardEntity> r103 = new UniversalCardDataService$getCardEntity$2$requestCallback$1(this, r100, r101);
        int r104 = com.larksuite.component.card.service.g.f283937a;
        UniversalCardBizType r105 = this.bizType;
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r105, "bizType");
        Intrinsics.checkNotNullParameter(r103, "callback");
        UniversalCardBizParam.Builder r106 = new UniversalCardBizParam.Builder().biz_id(r100).biz_type(Integer.valueOf(r105.getValue()));
        GetUniversalCardEntityByBizParamRequest.Builder r107 = new GetUniversalCardEntityByBizParamRequest.Builder().biz_param(r106.build()).strategy(GetUniversalCardEntityByBizParamRequest.Strategy.force_net);
        SdkSender.asynSendRequestNonWrap(Command.GET_UNIVERSAL_CARD_BY_BIZ_PARAM, r107, r103, f.f283936a);
    }

    public final void removeObserver(String r100, UniversalCardDataObserver r101) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, "observer");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        CopyOnWriteArrayList<UniversalCardDataObserver> r102 = this.bizCardEntityObserverMap.get(r100);
        boolean r103 = false;
        if (r102 != null) goto L8;
    L10:
        if (r103 == false) goto L15;
        CopyOnWriteArrayList<UniversalCardDataObserver> r104 = this.bizCardEntityObserverMap.get(r100);
        if (r104 == null) goto L16;
        r104.remove(r101);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        if (r102.contains(r101) != true) goto L10;
        r103 = true;
        goto L10
    }
}
