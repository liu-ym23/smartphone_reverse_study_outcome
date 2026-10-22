package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.BattleGetPanelListResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b/\u00100R#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017R;\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00032\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\u001eR+\u0010&\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020 8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R+\u0010+\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010*R#\u0010.\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0006\u001a\u0004\b-\u0010\b¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleGetPanelListResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/j1;", "", "Lcom/bytedance/android/livesdk/link/model/IBattlePanelFlexImpl;", "list$delegate", "Ljava/lang/Object;", "getList", "()Ljava/util/List;", "list", "", "pkCheckState$delegate", "getPkCheckState", "()I", "pkCheckState", "", "selfDataSwitch$delegate", "getSelfDataSwitch", "()Z", "selfDataSwitch", "Lcom/bytedance/android/livesdk/link/model/IBattleGetPanelAutoMatchInfoFlexImpl;", "autoMatchInfo$delegate", "getAutoMatchInfo", "()Lcom/bytedance/android/livesdk/link/model/IBattleGetPanelAutoMatchInfoFlexImpl;", "autoMatchInfo", "Lcom/bytedance/android/livesdk/link/model/p7;", "<set-?>", "tabList$delegate", "getTabList", "setTabList", "(Ljava/util/List;)V", "tabList", "", "customEntranceTag$delegate", "getCustomEntranceTag", "()Ljava/lang/String;", "setCustomEntranceTag", "(Ljava/lang/String;)V", "customEntranceTag", "selectTabType$delegate", "getSelectTabType", "setSelectTabType", "(I)V", "selectTabType", "cannotPkAnchorIds$delegate", "getCannotPkAnchorIds", "cannotPkAnchorIds", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleGetPanelListResponseFlexImpl extends FlexModelBase<j1> implements j1, vh7.h {

    @SerializedName("match_info")
    protected IBattleGetPanelAutoMatchInfoFlexImpl _$$autoMatchInfo;

    @SerializedName("can_not_pass_anchor_open_ids")
    protected List<String> _$$cannotPkAnchorIds;

    @SerializedName("custom_entrance_tag")
    protected String _$$customEntranceTag;

    @SerializedName("list")
    protected List<IBattlePanelFlexImpl> _$$list;

    @SerializedName("anchor_pk_check")
    protected int _$$pkCheckState;

    @SerializedName("select_tab_type")
    protected int _$$selectTabType;

    @SerializedName("self_data_switch")
    protected boolean _$$selfDataSwitch;

    @SerializedName("tab_list")
    protected List<? extends p7> _$$tabList;

    public IBattleGetPanelListResponseFlexImpl() {
        super(j1.class);
        this._$$selfDataSwitch = false;
        this._$$customEntranceTag = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.j1
    public /* bridge */ /* synthetic */ h1 getAutoMatchInfo() {
        return getAutoMatchInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.j1
    public final List<String> getCannotPkAnchorIds() {
        return this._$$cannotPkAnchorIds;
    }

    @Override // com.bytedance.android.livesdk.link.model.j1
    public final String getCustomEntranceTag() {
        return this._$$customEntranceTag;
    }

    @Override // com.bytedance.android.livesdk.link.model.j1
    public final List<IBattlePanelFlexImpl> getList() {
        return this._$$list;
    }

    @Override // com.bytedance.android.livesdk.link.model.j1
    public final int getPkCheckState() {
        return this._$$pkCheckState;
    }

    @Override // com.bytedance.android.livesdk.link.model.j1
    public final int getSelectTabType() {
        return this._$$selectTabType;
    }

    @Override // com.bytedance.android.livesdk.link.model.j1
    public final boolean getSelfDataSwitch() {
        return this._$$selfDataSwitch;
    }

    @Override // com.bytedance.android.livesdk.link.model.j1
    public final List<p7> getTabList() {
        return this._$$tabList;
    }

    @Override // com.bytedance.android.livesdk.link.model.j1
    public final IBattleGetPanelAutoMatchInfoFlexImpl getAutoMatchInfo() {
        return this._$$autoMatchInfo;
    }

    public IBattleGetPanelListResponseFlexImpl(am3.g r9) {
        super(j1.class);
        this._$$list = new ArrayList();
        this._$$tabList = new ArrayList();
        this._$$cannotPkAnchorIds = new ArrayList();
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L23;
        am3.g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 == 1) goto L21;
        if (r4 != 2) goto L9;
        this._$$selfDataSwitch = am3.h.a(r9);
        r3 = r3 | 2;
        goto L3
    L9:
        if (r4 != 3) goto L11;
        this._$$pkCheckState = r9.i();
        r3 = r3 | 1;
        goto L3
    L11:
        if (r4 == 5000) goto L18;
        switch(r4) {
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            default: goto L13;
        };
    L14:
        this._$$customEntranceTag = am3.h.c(r9);
        goto L3
    L15:
        this._$$selectTabType = r9.i();
        r3 = r3 | 4;
        goto L3
    L16:
        List r6 = this._$$tabList;
        Object r7 = vh7.f.a(r9, p7.class);
    L22:
        r6.add(r7);
        goto L3
    L17:
        this._$$autoMatchInfo = new IBattleGetPanelAutoMatchInfoFlexImpl(r9);
        goto L3
    L13:
        am3.h.d(r5, r9);
        goto L3
    L18:
        r6 = this._$$cannotPkAnchorIds;
        r7 = am3.h.c(r9);
        goto L22
    L21:
        r6 = this._$$list;
        r7 = new IBattlePanelFlexImpl(r9);
        goto L22
    L23:
        r9.d(r1);
        setThreadSafe(true);
        if ((r3 & 2) != 0) goto L27;
        this._$$selfDataSwitch = false;
    L27:
        if (this._$$customEntranceTag != null) goto L50;
        this._$$customEntranceTag = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.j1
    public final void setCustomEntranceTag(String r1) {
        this._$$customEntranceTag = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.j1
    public final void setSelectTabType(int r1) {
        this._$$selectTabType = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.j1
    public final void setTabList(List<? extends p7> r1) {
        this._$$tabList = r1;
    }
}
