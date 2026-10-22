package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.LinkmicUIConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkmicUIConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/t6;", "Lpy/k;", "roomBgFullImage", "Lpy/k;", "getRoomBgFullImage", "()Lpy/k;", "setRoomBgFullImage", "(Lpy/k;)V", "roomBgTopImage", "getRoomBgTopImage", "setRoomBgTopImage", "roomBgBottomImage", "getRoomBgBottomImage", "setRoomBgBottomImage", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicUIConfigFlexImpl extends FlexModelBase<t6> implements t6, vh7.h {

    @SerializedName("room_bg_bottom_image")
    protected py.k roomBgBottomImage;

    @SerializedName("room_bg_full_image")
    protected py.k roomBgFullImage;

    @SerializedName("room_bg_top_image")
    protected py.k roomBgTopImage;

    public ILinkmicUIConfigFlexImpl() {
        super(t6.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public ILinkmicUIConfigFlexImpl(am3.g r6) {
        super(t6.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.roomBgFullImage = vh7.f.a(r6, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.roomBgTopImage = vh7.f.a(r6, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.roomBgBottomImage = vh7.f.a(r6, py.k.class);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.t6
    public py.k getRoomBgBottomImage() {
        return this.roomBgBottomImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.t6
    public py.k getRoomBgFullImage() {
        return this.roomBgFullImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.t6
    public py.k getRoomBgTopImage() {
        return this.roomBgTopImage;
    }

    public void setRoomBgBottomImage(py.k r1) {
        this.roomBgBottomImage = r1;
    }

    public void setRoomBgFullImage(py.k r1) {
        this.roomBgFullImage = r1;
    }

    public void setRoomBgTopImage(py.k r1) {
        this.roomBgTopImage = r1;
    }
}
