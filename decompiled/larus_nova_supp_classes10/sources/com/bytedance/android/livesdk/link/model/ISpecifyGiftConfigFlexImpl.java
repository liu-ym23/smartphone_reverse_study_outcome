package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.SpecifyGiftConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\r0\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012RC\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ISpecifyGiftConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/h9;", "", "<set-?>", "setUid$delegate", "Ljava/lang/Object;", "getSetUid", "()Ljava/lang/String;", "setSetUid", "(Ljava/lang/String;)V", "setUid", "", "", "giftIds$delegate", "getGiftIds", "()Ljava/util/List;", "setGiftIds", "(Ljava/util/List;)V", "giftIds", "", "Lcom/bytedance/android/livesdk/link/model/i9;", "giftMap$delegate", "getGiftMap", "()Ljava/util/Map;", "setGiftMap", "(Ljava/util/Map;)V", "giftMap", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ISpecifyGiftConfigFlexImpl extends FlexModelBase<h9> implements h9, vh7.h {

    @SerializedName("gift_ids")
    protected List<Long> _$$giftIds;

    @SerializedName("gift_map")
    protected Map<Long, ? extends i9> _$$giftMap;

    @SerializedName("set_open_uid")
    protected String _$$setUid;

    public ISpecifyGiftConfigFlexImpl() {
        super(h9.class);
        this._$$giftIds = $defaultValue_giftIds$();
        this._$$giftMap = $defaultValue_giftMap$();
    }

    public final List<Long> $defaultValue_giftIds$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final Map<Long, i9> $defaultValue_giftMap$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.link.model.h9
    public final List<Long> getGiftIds() {
        return this._$$giftIds;
    }

    @Override // com.bytedance.android.livesdk.link.model.h9
    public final Map<Long, i9> getGiftMap() {
        return this._$$giftMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.h9
    public final String getSetUid() {
        return this._$$setUid;
    }

    public ISpecifyGiftConfigFlexImpl(am3.g r12) {
        super(h9.class);
        this._$$giftIds = new ArrayList();
        this._$$giftMap = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L30;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L8;
        this._$$giftIds.add(Long.valueOf(r12.j()));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        long r7 = r12.c();
        Long r3 = null;
        Object r6 = null;
    L14:
        int r9 = r12.f();
        if (r9 == (-1)) goto L21;
        if (r9 != 1) goto L17;
        r3 = Long.valueOf(r12.j());
        goto L14
    L17:
        if (r9 != 2) goto L18;
        r6 = vh7.f.a(r12, i9.class);
        goto L14
    L18:
        am3.h.e(r12);
        goto L14
    L21:
        r12.d(r7);
        Map<Long, ? extends i9> r4 = this._$$giftMap;
        if (r3 == null) goto L28;
        if (r6 == null) goto L26;
        r4.put(r3, r6);
        goto L3
    L26:
        throw new IllegalStateException("Value must not be null");
    L28:
        throw new IllegalStateException("Key must not be null");
    L10:
        if (r2 != 5000) goto L11;
        this._$$setUid = am3.h.c(r12);
        goto L3
    L11:
        am3.h.d(r5, r12);
        goto L3
    L30:
        r12.d(r0);
        setThreadSafe(true);
        if (this._$$giftIds.isEmpty() == false) goto L34;
        this._$$giftIds = $defaultValue_giftIds$();
    L34:
        if (this._$$giftMap != null) goto L60;
        this._$$giftMap = $defaultValue_giftMap$();
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.h9
    public final void setGiftIds(List<Long> r1) {
        this._$$giftIds = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.h9
    public final void setGiftMap(Map<Long, ? extends i9> r1) {
        this._$$giftMap = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.h9
    public final void setSetUid(String r1) {
        this._$$setUid = r1;
    }
}
