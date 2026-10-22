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
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.TabRivals")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010$R#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rRG\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRivalsWithTabFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/s2;", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalFlexImpl;", "rivals$delegate", "Ljava/lang/Object;", "getRivals", "()Ljava/util/List;", "rivals", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTabFlexImpl;", "tab$delegate", "getTab", "()Lcom/bytedance/android/livesdk/link/model/IBattleRivalTabFlexImpl;", "tab", "", "", "Lcom/bytedance/android/livesdk/link/model/IGroupRivals;", "<set-?>", "groupRivals$delegate", "getGroupRivals", "()Ljava/util/Map;", "setGroupRivals", "(Ljava/util/Map;)V", "groupRivals", "", "defaultGroup$delegate", "getDefaultGroup", "()I", "defaultGroup", "", "subRecommendTitle$delegate", "getSubRecommendTitle", "()Ljava/lang/String;", "subRecommendTitle", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleRivalsWithTabFlexImpl extends FlexModelBase<s2> implements s2, vh7.h {

    @SerializedName("default_group")
    protected int _$$defaultGroup;

    @SerializedName("group_rivals")
    protected Map<Long, ? extends IGroupRivals> _$$groupRivals;

    @SerializedName("rivals")
    protected List<IBattleRivalFlexImpl> _$$rivals;

    @SerializedName("sub_recommend_title")
    protected String _$$subRecommendTitle;

    @SerializedName("tab")
    protected IBattleRivalTabFlexImpl _$$tab;

    public IBattleRivalsWithTabFlexImpl() {
        super(s2.class);
        this._$$subRecommendTitle = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.s2
    public /* bridge */ /* synthetic */ q2 getTab() {
        return getTab();
    }

    @Override // com.bytedance.android.livesdk.link.model.s2
    public final int getDefaultGroup() {
        return this._$$defaultGroup;
    }

    @Override // com.bytedance.android.livesdk.link.model.s2
    public final Map<Long, IGroupRivals> getGroupRivals() {
        return this._$$groupRivals;
    }

    @Override // com.bytedance.android.livesdk.link.model.s2
    public final List<IBattleRivalFlexImpl> getRivals() {
        return this._$$rivals;
    }

    @Override // com.bytedance.android.livesdk.link.model.s2
    public final String getSubRecommendTitle() {
        return this._$$subRecommendTitle;
    }

    @Override // com.bytedance.android.livesdk.link.model.s2
    public final IBattleRivalTabFlexImpl getTab() {
        return this._$$tab;
    }

    public IBattleRivalsWithTabFlexImpl(am3.g r12) {
        super(s2.class);
        this._$$rivals = new ArrayList();
        this._$$groupRivals = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L36;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L8;
        this._$$rivals.add(new IBattleRivalFlexImpl(r12));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$tab = new IBattleRivalTabFlexImpl(r12);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        long r7 = r12.c();
        Long r3 = null;
        Object r6 = null;
    L19:
        int r9 = r12.f();
        if (r9 == (-1)) goto L26;
        if (r9 != 1) goto L22;
        r3 = Long.valueOf(r12.j());
        goto L19
    L22:
        if (r9 != 2) goto L23;
        r6 = vh7.f.a(r12, IGroupRivals.class);
        goto L19
    L23:
        am3.h.e(r12);
        goto L19
    L26:
        r12.d(r7);
        Map<Long, ? extends IGroupRivals> r4 = this._$$groupRivals;
        if (r3 == null) goto L33;
        if (r6 == null) goto L31;
        r4.put(r3, r6);
        goto L3
    L31:
        throw new IllegalStateException("Value must not be null");
    L33:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r2 != 4) goto L14;
        this._$$defaultGroup = r12.i();
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this._$$subRecommendTitle = am3.h.c(r12);
        goto L3
    L15:
        am3.h.d(r5, r12);
        goto L3
    L36:
        r12.d(r0);
        setThreadSafe(true);
        if (this._$$subRecommendTitle != null) goto L69;
        this._$$subRecommendTitle = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.s2
    public final void setGroupRivals(Map<Long, ? extends IGroupRivals> r1) {
        this._$$groupRivals = r1;
    }
}
