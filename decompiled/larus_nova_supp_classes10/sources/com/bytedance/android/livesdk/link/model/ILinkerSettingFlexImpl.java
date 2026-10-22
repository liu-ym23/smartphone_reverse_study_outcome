package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.LinkerSetting")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0013\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0013\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001b\u0010\u0016\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\fR\u001b\u0010\u0019\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerSettingFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/m6;", "", "ownerUserId$delegate", "Ljava/lang/Object;", "getOwnerUserId", "()Ljava/lang/String;", "ownerUserId", "", "maxLimit$delegate", "getMaxLimit", "()J", "maxLimit", "linkType$delegate", "getLinkType", "linkType", "scene$delegate", "getScene", "scene", "ownerRoomId$delegate", "getOwnerRoomId", "ownerRoomId", "vendor$delegate", "getVendor", "vendor", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkerSettingFlexImpl extends FlexModelBase<m6> implements m6, vh7.h {

    @SerializedName("link_type")
    protected long _$$linkType;

    @SerializedName("max_member_limit")
    protected long _$$maxLimit;

    @SerializedName("owner_room_id")
    protected long _$$ownerRoomId;

    @SerializedName("owner_open_id")
    protected String _$$ownerUserId;

    @SerializedName("scene")
    protected long _$$scene;

    @SerializedName("vendor")
    protected long _$$vendor;

    public ILinkerSettingFlexImpl() {
        super(m6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.m6
    public final long getLinkType() {
        return this._$$linkType;
    }

    @Override // com.bytedance.android.livesdk.link.model.m6
    public final long getMaxLimit() {
        return this._$$maxLimit;
    }

    @Override // com.bytedance.android.livesdk.link.model.m6
    public final long getOwnerRoomId() {
        return this._$$ownerRoomId;
    }

    @Override // com.bytedance.android.livesdk.link.model.m6
    public final String getOwnerUserId() {
        return this._$$ownerUserId;
    }

    @Override // com.bytedance.android.livesdk.link.model.m6
    public final long getScene() {
        return this._$$scene;
    }

    @Override // com.bytedance.android.livesdk.link.model.m6
    public final long getVendor() {
        return this._$$vendor;
    }

    public ILinkerSettingFlexImpl(am3.g r6) {
        super(m6.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L24;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$maxLimit = r6.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$linkType = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$scene = r6.j();
        goto L3
    L12:
        if (r2 != 5) goto L14;
        this._$$ownerRoomId = r6.j();
        goto L3
    L14:
        if (r2 != 6) goto L16;
        this._$$vendor = r6.j();
        goto L3
    L16:
        if (r2 != 5000) goto L17;
        this._$$ownerUserId = am3.h.c(r6);
        goto L3
    L17:
        am3.h.d(r3, r6);
        goto L3
    L24:
        r6.d(r0);
        setThreadSafe(true);
    }
}
