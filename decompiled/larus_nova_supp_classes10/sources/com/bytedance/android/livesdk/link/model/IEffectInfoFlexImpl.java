package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.AnchorEffect.EffectInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b3\u00104R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001f\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR/\u0010'\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010+R\u001b\u0010/\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010+R\u001b\u00102\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0019\u001a\u0004\b1\u0010+¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IEffectInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/f4;", "Lpy/k;", "barIcon", "Lpy/k;", "getBarIcon", "()Lpy/k;", "setBarIcon", "(Lpy/k;)V", "barMinIcon", "getBarMinIcon", "setBarMinIcon", "barAuraIcon", "getBarAuraIcon", "setBarAuraIcon", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "effectSender", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getEffectSender", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setEffectSender", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "effectType$delegate", "Ljava/lang/Object;", "getEffectType", "()I", "effectType", "effectSource$delegate", "getEffectSource", "effectSource", "", "<set-?>", "effectName$delegate", "getEffectName", "()Ljava/lang/String;", "setEffectName", "(Ljava/lang/String;)V", "effectName", "", "startTime$delegate", "getStartTime", "()J", "startTime", "endTime$delegate", "getEndTime", "endTime", "insertTime$delegate", "getInsertTime", "insertTime", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IEffectInfoFlexImpl extends FlexModelBase<f4> implements f4, vh7.h {

    @SerializedName("name")
    protected String _$$effectName;

    @SerializedName("source")
    protected int _$$effectSource;

    @SerializedName(LocationMonitorConst.TYPE)
    protected int _$$effectType;

    @SerializedName("end_time")
    protected long _$$endTime;

    @SerializedName("insert_time")
    protected long _$$insertTime;

    @SerializedName("start_time")
    protected long _$$startTime;

    @SerializedName("bar_aura_url")
    protected py.k barAuraIcon;

    @SerializedName("bar_icon")
    protected py.k barIcon;

    @SerializedName("bar_min_icon")
    protected py.k barMinIcon;

    @SerializedName("sender")
    protected IBaseUser effectSender;

    public final int $defaultValue_effectSource$() {
        return 0;
    }

    public final int $defaultValue_effectType$() {
        return 0;
    }

    public IEffectInfoFlexImpl() {
        super(f4.class);
        this._$$effectType = $defaultValue_effectType$();
        this._$$effectSource = $defaultValue_effectSource$();
        this.effectSender = (IBaseUser) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IBaseUser.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.f4
    public String getString() {
        StringBuilder r0 = new StringBuilder("effectType = ");
        r0.append(getEffectType());
        r0.append(", effectSource = ");
        r0.append(getEffectSource());
        r0.append(", effectName = ");
        r0.append(getEffectName());
        r0.append(", barIcon = ");
        py.k r1 = getBarIcon();
        String r3 = null;
        if (r1 == null) goto L7;
        List r2 = r1.getUrls();
        if (r2 == null) goto L7;
        String r4 = (String) ListProtector.get(r2, 0);
    L8:
        r0.append(r4);
        r0.append(", barMinIcon = ");
        py.k r5 = getBarMinIcon();
        if (r5 == null) goto L13;
        List r6 = r5.getUrls();
        if (r6 == null) goto L13;
        String r7 = (String) ListProtector.get(r6, 0);
    L14:
        r0.append(r7);
        r0.append(", barAuraIcon = ");
        py.k r8 = getBarAuraIcon();
        if (r8 == null) goto L19;
        List r9 = r8.getUrls();
        if (r9 == null) goto L19;
        r3 = (String) ListProtector.get(r9, 0);
    L19:
        r0.append(r3);
        r0.append(", startTime = ");
        r0.append(getStartTime());
        r0.append(", endTime = ");
        r0.append(getEndTime());
        return r0.toString();
    L13:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.link.model.f4, com.bytedance.android.livesdk.link.model.g4
    public py.k getBarAuraIcon() {
        return this.barAuraIcon;
    }

    @Override // com.bytedance.android.livesdk.link.model.f4, com.bytedance.android.livesdk.link.model.g4
    public py.k getBarIcon() {
        return this.barIcon;
    }

    @Override // com.bytedance.android.livesdk.link.model.f4, com.bytedance.android.livesdk.link.model.g4
    public py.k getBarMinIcon() {
        return this.barMinIcon;
    }

    @Override // com.bytedance.android.livesdk.link.model.f4, com.bytedance.android.livesdk.link.model.g4
    public final String getEffectName() {
        return this._$$effectName;
    }

    @Override // com.bytedance.android.livesdk.link.model.f4
    public IBaseUser getEffectSender() {
        return this.effectSender;
    }

    @Override // com.bytedance.android.livesdk.link.model.f4, com.bytedance.android.livesdk.link.model.g4
    public final int getEffectSource() {
        return this._$$effectSource;
    }

    @Override // com.bytedance.android.livesdk.link.model.f4, com.bytedance.android.livesdk.link.model.g4
    public final int getEffectType() {
        return this._$$effectType;
    }

    @Override // com.bytedance.android.livesdk.link.model.f4, com.bytedance.android.livesdk.link.model.g4
    public final long getEndTime() {
        return this._$$endTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.f4
    public final long getInsertTime() {
        return this._$$insertTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.f4, com.bytedance.android.livesdk.link.model.g4
    public final long getStartTime() {
        return this._$$startTime;
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object, py.k] */
    public IEffectInfoFlexImpl(am3.g r6) {
        super(f4.class);
        int r0 = 0;
        setThreadSafe(false);
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L18;
        am3.g.a r4 = decodeExtensionFields(r3, r6);
        switch(r3) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        this._$$insertTime = r6.j();
        r0 = r0 | 16;
        goto L3
    L9:
        this._$$endTime = r6.j();
        r0 = r0 | 8;
        goto L3
    L10:
        this._$$startTime = r6.j();
        r0 = r0 | 4;
        goto L3
    L11:
        this.effectSender = vh7.f.a(r6, IBaseUser.class);
        goto L3
    L12:
        this.barAuraIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L13:
        this.barMinIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L14:
        this.barIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L15:
        this._$$effectName = am3.h.c(r6);
        goto L3
    L16:
        this._$$effectSource = r6.i();
        r0 = r0 | 2;
        goto L3
    L17:
        this._$$effectType = r6.i();
        r0 = r0 | 1;
        goto L3
    L7:
        am3.h.d(r4, r6);
        goto L3
    L18:
        r6.d(r1);
        setThreadSafe(true);
        if ((r0 & 1) != 0) goto L22;
        this._$$effectType = $defaultValue_effectType$();
    L22:
        if ((r0 & 2) != 0) goto L25;
        this._$$effectSource = $defaultValue_effectSource$();
    L25:
        if (this.effectSender != null) goto L52;
        this.effectSender = (IBaseUser) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IBaseUser.class);
        return;
    }

    public void setBarAuraIcon(py.k r1) {
        this.barAuraIcon = r1;
    }

    public void setBarIcon(py.k r1) {
        this.barIcon = r1;
    }

    public void setBarMinIcon(py.k r1) {
        this.barMinIcon = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.f4
    public final void setEffectName(String r1) {
        this._$$effectName = r1;
    }

    public void setEffectSender(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.effectSender = r2;
    }
}
