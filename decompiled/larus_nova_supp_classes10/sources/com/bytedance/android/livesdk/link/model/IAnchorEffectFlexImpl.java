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
@ProtoMessage("webcast.data.AnchorEffect")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR)\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorEffectFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/j;", "", "Lcom/bytedance/android/livesdk/link/model/IEffectInfoFlexImpl;", "effectList$delegate", "Ljava/lang/Object;", "getEffectList", "()Ljava/util/List;", "effectList", "", "", "Lcom/bytedance/android/livesdk/link/model/IAnchorEffect_EffectInfoListFlexImpl;", "effectMap$delegate", "getEffectMap", "()Ljava/util/Map;", "effectMap", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorEffectFlexImpl extends FlexModelBase<j> implements j, vh7.h {

    @SerializedName("effect_list")
    protected List<IEffectInfoFlexImpl> _$$effectList;

    @SerializedName("effect_map")
    protected Map<Long, IAnchorEffect_EffectInfoListFlexImpl> _$$effectMap;

    public IAnchorEffectFlexImpl() {
        super(j.class);
        this._$$effectList = $defaultValue_effectList$();
    }

    public final List<IEffectInfoFlexImpl> $defaultValue_effectList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.j
    public final List<IEffectInfoFlexImpl> getEffectList() {
        return this._$$effectList;
    }

    @Override // com.bytedance.android.livesdk.link.model.j
    public final Map<Long, IAnchorEffect_EffectInfoListFlexImpl> getEffectMap() {
        return this._$$effectMap;
    }

    public IAnchorEffectFlexImpl(am3.g r12) {
        super(j.class);
        this._$$effectList = new ArrayList();
        this._$$effectMap = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L27;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L8;
        this._$$effectList.add(new IEffectInfoFlexImpl(r12));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        long r7 = r12.c();
        Long r3 = null;
        IAnchorEffect_EffectInfoListFlexImpl r6 = null;
    L11:
        int r9 = r12.f();
        if (r9 == (-1)) goto L18;
        if (r9 != 1) goto L14;
        r3 = Long.valueOf(r12.j());
        goto L11
    L14:
        if (r9 != 2) goto L15;
        r6 = new IAnchorEffect_EffectInfoListFlexImpl(r12);
        goto L11
    L15:
        am3.h.e(r12);
        goto L11
    L18:
        r12.d(r7);
        Map<Long, IAnchorEffect_EffectInfoListFlexImpl> r4 = this._$$effectMap;
        if (r3 == null) goto L25;
        if (r6 == null) goto L23;
        r4.put(r3, r6);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.d(r5, r12);
        goto L3
    L27:
        r12.d(r0);
        setThreadSafe(true);
        if (this._$$effectList.isEmpty() == false) goto L51;
        this._$$effectList = $defaultValue_effectList$();
        return;
    }
}
