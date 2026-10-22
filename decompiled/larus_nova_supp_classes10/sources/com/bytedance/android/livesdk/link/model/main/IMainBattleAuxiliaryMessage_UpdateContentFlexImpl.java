package com.bytedance.android.livesdk.link.model.main;

import am3.g;
import com.bytedance.android.livesdk.link.model.IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.BattleAuxiliaryMessage.UpdateContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fR'\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/main/IMainBattleAuxiliaryMessage_UpdateContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/main/b$c;", "", "", "Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl;", "auxiliaryScoreInfo$delegate", "Ljava/lang/Object;", "getAuxiliaryScoreInfo", "()Ljava/util/Map;", "auxiliaryScoreInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IMainBattleAuxiliaryMessage_UpdateContentFlexImpl extends FlexModelBase<b.c> implements b.c, h {

    @SerializedName("auxiliary_score_infos")
    protected Map<Long, IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl> _$$auxiliaryScoreInfo;

    public IMainBattleAuxiliaryMessage_UpdateContentFlexImpl() {
        super(b.c.class);
        this._$$auxiliaryScoreInfo = $defaultValue_auxiliaryScoreInfo$();
    }

    public final Map<Long, IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl> $defaultValue_auxiliaryScoreInfo$() {
        return d.b();
    }

    @Override // com.bytedance.android.livesdk.link.model.main.b.c
    public final Map<Long, IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl> getAuxiliaryScoreInfo() {
        return this._$$auxiliaryScoreInfo;
    }

    public IMainBattleAuxiliaryMessage_UpdateContentFlexImpl(g r11) {
        super(b.c.class);
        this._$$auxiliaryScoreInfo = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L25;
        g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 92) goto L7;
        long r6 = r11.c();
        Long r3 = null;
        IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl r7 = null;
    L9:
        int r8 = r11.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r3 = Long.valueOf(r11.j());
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = new IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl(r11);
        goto L9
    L14:
        am3.h.e(r11);
        goto L9
    L17:
        r11.d(r6);
        Map<Long, IBattleAuxiliaryMessage_AuxiliaryScoreInfoFlexImpl> r4 = this._$$auxiliaryScoreInfo;
        if (r3 == null) goto L24;
        if (r7 == null) goto L22;
        r4.put(r3, r7);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r5, r11);
        goto L3
    L25:
        r11.d(r0);
        setThreadSafe(true);
        if (this._$$auxiliaryScoreInfo != null) goto L46;
        this._$$auxiliaryScoreInfo = $defaultValue_auxiliaryScoreInfo$();
        return;
    }
}
