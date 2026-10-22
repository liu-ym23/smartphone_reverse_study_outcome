package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.AnchorLayoutInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/IAnchorLayoutInfoBridgeFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/h;", "", "uiLayout$delegate", "Ljava/lang/Object;", "getUiLayout", "()I", "uiLayout", "range$delegate", "getRange", "range", "", "isOrientation$delegate", "isOrientation", "()Z", "", "", "Lcom/bytedance/android/livesdk/link/model/bridge/IAnchorLayoutDetailBridgeFlexImpl;", "layoutDetails$delegate", "getLayoutDetails", "()Ljava/util/Map;", "layoutDetails", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorLayoutInfoBridgeFlexImpl extends FlexModelBase<h> implements h, vh7.h {

    @SerializedName("big_anchor_is_orientation")
    protected boolean _$$isOrientation;

    @SerializedName("layout_details")
    protected Map<String, IAnchorLayoutDetailBridgeFlexImpl> _$$layoutDetails;

    @SerializedName("range")
    protected int _$$range;

    @SerializedName("ui_layout")
    protected int _$$uiLayout;

    public IAnchorLayoutInfoBridgeFlexImpl() {
        super(h.class);
        this._$$isOrientation = false;
        this._$$layoutDetails = $defaultValue_layoutDetails$();
    }

    public final Map<String, IAnchorLayoutDetailBridgeFlexImpl> $defaultValue_layoutDetails$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h
    public final Map<String, IAnchorLayoutDetailBridgeFlexImpl> getLayoutDetails() {
        return this._$$layoutDetails;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h
    public final int getRange() {
        return this._$$range;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h
    public final int getUiLayout() {
        return this._$$uiLayout;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h
    public final boolean isOrientation() {
        return this._$$isOrientation;
    }

    public IAnchorLayoutInfoBridgeFlexImpl(am3.g r13) {
        super(h.class);
        this._$$layoutDetails = new HashMap();
        setThreadSafe(false);
        long r1 = r13.c();
        int r3 = 0;
    L3:
        int r4 = r13.f();
        if (r4 == (-1)) goto L33;
        am3.g.a r7 = decodeExtensionFields(r4, r13);
        if (r4 != 1) goto L8;
        this._$$uiLayout = r13.i();
        r3 = r3 | 1;
        goto L3
    L8:
        if (r4 != 2) goto L10;
        this._$$range = r13.i();
        r3 = r3 | 2;
        goto L3
    L10:
        if (r4 != 5) goto L12;
        long r9 = r13.c();
        String r5 = null;
        IAnchorLayoutDetailBridgeFlexImpl r8 = null;
    L16:
        int r11 = r13.f();
        if (r11 == (-1)) goto L23;
        if (r11 != 1) goto L19;
        r5 = am3.h.c(r13);
        goto L16
    L19:
        if (r11 != 2) goto L20;
        r8 = new IAnchorLayoutDetailBridgeFlexImpl(r13);
        goto L16
    L20:
        am3.h.e(r13);
        goto L16
    L23:
        r13.d(r9);
        Map<String, IAnchorLayoutDetailBridgeFlexImpl> r6 = this._$$layoutDetails;
        if (r5 == null) goto L30;
        if (r8 == null) goto L28;
        r6.put(r5, r8);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r4 != 6) goto L13;
        this._$$isOrientation = am3.h.a(r13);
        r3 = r3 | 4;
        goto L3
    L13:
        am3.h.d(r7, r13);
        goto L3
    L33:
        r13.d(r1);
        setThreadSafe(true);
        if ((r3 & 4) != 0) goto L37;
        this._$$isOrientation = false;
    L37:
        if (this._$$layoutDetails != null) goto L66;
        this._$$layoutDetails = $defaultValue_layoutDetails$();
        return;
    }
}
