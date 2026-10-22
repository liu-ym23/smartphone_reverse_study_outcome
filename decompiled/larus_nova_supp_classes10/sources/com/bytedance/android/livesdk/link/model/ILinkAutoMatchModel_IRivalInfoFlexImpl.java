package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.BattleAutoMatchResult.RivalInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkAutoMatchModel_IRivalInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/r4$b;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "", "userId$delegate", "Ljava/lang/Object;", "getUserId", "()Ljava/lang/String;", "userId", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkAutoMatchModel_IRivalInfoFlexImpl extends FlexModelBase<r4.b> implements r4.b, vh7.h {

    @SerializedName("open_user_id")
    protected String _$$userId;

    @SerializedName("room")
    protected IRoom room;

    public ILinkAutoMatchModel_IRivalInfoFlexImpl() {
        super(r4.b.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoom, java.lang.Object] */
    public ILinkAutoMatchModel_IRivalInfoFlexImpl(am3.g r6) {
        super(r4.b.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 2) goto L8;
        this.room = vh7.f.a(r6, IRoom.class);
        goto L3
    L8:
        if (r2 != 5000) goto L9;
        this._$$userId = am3.h.c(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.r4.b
    public IRoom getRoom() {
        return this.room;
    }

    @Override // com.bytedance.android.livesdk.link.model.r4.b
    public final String getUserId() {
        return this._$$userId;
    }

    public void setRoom(IRoom r1) {
        this.room = r1;
    }
}
