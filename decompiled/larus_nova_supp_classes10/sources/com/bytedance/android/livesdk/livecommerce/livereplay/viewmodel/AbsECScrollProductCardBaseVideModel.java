package com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.bytedance.android.ec.core.arch.viewmodel.QStateViewModel;
import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.livereplay.repository.NetState;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005BO\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010'\u001a\u00020\n\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u00100\u001a\u00020+\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010<\u001a\u000202\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\bI\u0010JJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\bH&J\u0011\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001J\t\u0010\u0010\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00100\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b0\u0010-\u001a\u0004\b1\u0010/R\u0017\u00103\u001a\u0002028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u00108\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0017\u0010<\u001a\u0002028\u0006¢\u0006\f\n\u0004\b<\u00104\u001a\u0004\b=\u00106R\u0017\u0010?\u001a\u00020>8\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\"\u0010H\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010E0D0C8&X¦\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/AbsECScrollProductCardBaseVideModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/QStateViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/b;", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/repository/b;", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/replayrepository/a;", "Lnl2/c;", "Landroid/content/Context;", "context", "", "reportPageInfoForDebug", "Lorg/json/JSONObject;", "getEntranceInfos", "clickProductCard", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "doClear", "remove", "Lil/a;", "historyMap", "Lil/a;", "getHistoryMap", "()Lil/a;", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/repository/a;", "repository$delegate", "Lkotlin/Lazy;", "getRepository", "()Lcom/bytedance/android/livesdk/livecommerce/livereplay/repository/a;", "repository", "Lml/b;", "roomInfo", "Lml/b;", "getRoomInfo", "()Lml/b;", "Lml/a;", "btmInfo", "Lml/a;", "getBtmInfo", "()Lml/a;", "entranceInfo", "Lorg/json/JSONObject;", "getEntranceInfo", "()Lorg/json/JSONObject;", "", "pageSize", "I", "getPageSize", "()I", "funType", "getFunType", "", "ecomSceneId", "Ljava/lang/String;", "getEcomSceneId", "()Ljava/lang/String;", "Lxk/a;", "params", "Lxk/a;", "getParams", "()Lxk/a;", "replayId", "getReplayId", "", "replayStartTime", "J", "getReplayStartTime", "()J", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lni2/a;", "getPagedList", "()Landroidx/lifecycle/LiveData;", "pagedList", "<init>", "(Lml/b;Lml/a;Lorg/json/JSONObject;IILjava/lang/String;Lxk/a;Ljava/lang/String;J)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsECScrollProductCardBaseVideModel extends QStateViewModel<b> implements com.bytedance.android.livesdk.livecommerce.livereplay.repository.b, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a, nl2.c {
    private final /* synthetic */ nl2.a $$delegate_0;
    private final ml.a btmInfo;
    private final String ecomSceneId;
    private final JSONObject entranceInfo;
    private final int funType;
    private final il.a historyMap;
    private final int pageSize;
    private final xk.a params;
    private final String replayId;
    private final long replayStartTime;
    private final Lazy repository$delegate;
    private final ml.b roomInfo;

    @Override // nl2.c
    public Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.$$delegate_0.add(r2);
        return r2;
    }

    public abstract void clickProductCard();

    public abstract JSONObject getEntranceInfos();

    public abstract LiveData<PagedList<ni2.a>> getPagedList();

    public final com.bytedance.android.livesdk.livecommerce.livereplay.repository.a getRepository() {
        return (com.bytedance.android.livesdk.livecommerce.livereplay.repository.a) this.repository$delegate.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.repository.b, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a
    public abstract /* synthetic */ void onInvalidated();

    public abstract void reportPageInfoForDebug(Context r1);

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a
    public void selectFirstCard(ECUIPromotion r1, ExplainPlaybackVideoInfo r2, ECReplayVideo r3, List<ExplainReplaySubTitle> r4) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.repository.b, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a
    public abstract /* synthetic */ void setNetworkState(NetState r1);

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.repository.b
    public abstract /* synthetic */ void setPageTimestamp(List<Long> r1);

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.repository.b
    public abstract /* synthetic */ void setTotalCount(int r1);

    public void doClear() {
        CompositeDisposable r0 = this.$$delegate_0.a;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public final ml.a getBtmInfo() {
        return this.btmInfo;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final JSONObject getEntranceInfo() {
        return this.entranceInfo;
    }

    public final int getFunType() {
        return this.funType;
    }

    public final il.a getHistoryMap() {
        return this.historyMap;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final xk.a getParams() {
        return this.params;
    }

    public final String getReplayId() {
        return this.replayId;
    }

    public final long getReplayStartTime() {
        return this.replayStartTime;
    }

    public final ml.b getRoomInfo() {
        return this.roomInfo;
    }

    public void remove(Disposable r3) {
        Intrinsics.checkNotNullParameter(r3, "disposable");
        nl2.a r1 = this.$$delegate_0;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "disposable");
        CompositeDisposable r0 = r1.a;
        if (r0 == null) goto L6;
        r0.remove(r3);
        return;
    }

    public AbsECScrollProductCardBaseVideModel(ml.b r3, ml.a r4, JSONObject r5, int r6, int r7, String r8, xk.a r9, String r10, long r11) {
        Intrinsics.checkNotNullParameter(r3, "roomInfo");
        Intrinsics.checkNotNullParameter(r4, "btmInfo");
        Intrinsics.checkNotNullParameter(r5, "entranceInfo");
        Intrinsics.checkNotNullParameter(r8, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "replayId");
        super(new b(0));
        this.$$delegate_0 = new nl2.a();
        this.roomInfo = r3;
        this.btmInfo = r4;
        this.entranceInfo = r5;
        this.pageSize = r6;
        this.funType = r7;
        this.ecomSceneId = r8;
        this.params = r9;
        this.replayId = r10;
        this.replayStartTime = r11;
        this.historyMap = new il.a();
        this.repository$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new AbsECScrollProductCardBaseVideModel$repository$2(this));
    }
}
