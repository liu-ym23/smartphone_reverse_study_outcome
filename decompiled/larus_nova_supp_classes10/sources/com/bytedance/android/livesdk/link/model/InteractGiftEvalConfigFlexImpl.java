package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.InteractGiftEvalConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\n¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/link/model/InteractGiftEvalConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/ea;", "", "<set-?>", "giftId$delegate", "Ljava/lang/Object;", "getGiftId", "()J", "setGiftId", "(J)V", "giftId", "Lpy/k;", "giftIcon$delegate", "getGiftIcon", "()Lpy/k;", "setGiftIcon", "(Lpy/k;)V", "giftIcon", "", "giftName$delegate", "getGiftName", "()Ljava/lang/String;", "setGiftName", "(Ljava/lang/String;)V", "giftName", "score$delegate", "getScore", "setScore", "score", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractGiftEvalConfigFlexImpl extends FlexModelBase<ea> implements ea, vh7.h {

    @SerializedName("gift_icon")
    protected py.k _$$giftIcon;

    @SerializedName("gift_id")
    protected long _$$giftId;

    @SerializedName("gift_name")
    protected String _$$giftName;

    @SerializedName("score")
    protected long _$$score;

    public InteractGiftEvalConfigFlexImpl() {
        super(ea.class);
        this._$$giftIcon = $defaultValue_giftIcon$();
        this._$$giftName = "";
    }

    public final py.k $defaultValue_giftIcon$() {
        return (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.ea
    public final py.k getGiftIcon() {
        return this._$$giftIcon;
    }

    @Override // com.bytedance.android.livesdk.link.model.ea
    public final long getGiftId() {
        return this._$$giftId;
    }

    @Override // com.bytedance.android.livesdk.link.model.ea
    public final String getGiftName() {
        return this._$$giftName;
    }

    @Override // com.bytedance.android.livesdk.link.model.ea
    public final long getScore() {
        return this._$$score;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public InteractGiftEvalConfigFlexImpl(am3.g r6) {
        super(ea.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$giftId = r6.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$giftIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$giftName = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$score = r6.j();
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$giftIcon != null) goto L22;
        this._$$giftIcon = $defaultValue_giftIcon$();
    L22:
        if (this._$$giftName != null) goto L40;
        this._$$giftName = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.ea
    public final void setGiftIcon(py.k r1) {
        this._$$giftIcon = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ea
    public final void setGiftId(long r1) {
        this._$$giftId = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ea
    public final void setGiftName(String r1) {
        this._$$giftName = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.ea
    public final void setScore(long r1) {
        this._$$score = r1;
    }
}
