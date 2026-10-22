package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.PkActivePush.Matcher")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPkActivePushMatcherFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/s7;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "", "userId$delegate", "Ljava/lang/Object;", "getUserId", "()Ljava/lang/String;", "userId", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTagFlexImpl;", "tagList$delegate", "getTagList", "()Ljava/util/List;", "tagList", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPkActivePushMatcherFlexImpl extends FlexModelBase<s7> implements s7, vh7.h {

    @SerializedName("tags")
    protected List<IBattleRivalTagFlexImpl> _$$tagList;

    @SerializedName("open_user_id")
    protected String _$$userId;

    @SerializedName("room")
    protected IRoom room;

    public IPkActivePushMatcherFlexImpl() {
        super(s7.class);
        this._$$userId = "";
        this._$$tagList = $defaultValue_tagList$();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoom, java.lang.Object] */
    public IPkActivePushMatcherFlexImpl(am3.g r6) {
        super(s7.class);
        this._$$tagList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 2) goto L8;
        this.room = vh7.f.a(r6, IRoom.class);
        goto L3
    L8:
        if (r2 != 3) goto L10;
        this._$$tagList.add(new IBattleRivalTagFlexImpl(r6));
        goto L3
    L10:
        if (r2 != 5000) goto L11;
        this._$$userId = am3.h.c(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$userId != null) goto L19;
        this._$$userId = "";
    L19:
        if (this._$$tagList.isEmpty() == false) goto L34;
        this._$$tagList = $defaultValue_tagList$();
        return;
    }

    public final List<IBattleRivalTagFlexImpl> $defaultValue_tagList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.s7
    public IRoom getRoom() {
        return this.room;
    }

    @Override // com.bytedance.android.livesdk.link.model.s7
    public final List<IBattleRivalTagFlexImpl> getTagList() {
        return this._$$tagList;
    }

    @Override // com.bytedance.android.livesdk.link.model.s7
    public final String getUserId() {
        return this._$$userId;
    }

    public void setRoom(IRoom r1) {
        this.room = r1;
    }
}
