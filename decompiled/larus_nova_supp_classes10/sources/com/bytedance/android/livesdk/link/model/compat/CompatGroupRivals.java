package com.bytedance.android.livesdk.link.model.compat;

import am3.g;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b*\u0010+R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0097D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00138\u0016X\u0097D¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u00138\u0016X\u0097D¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0007R\u001a\u0010$\u001a\u00020#8\u0016X\u0097D¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/compat/CompatGroupRivals;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IGroupRivals;", "", "groupType", "I", "getGroupType", "()I", "", "Lcom/bytedance/android/livesdk/link/model/m2;", "rivals", "Ljava/util/List;", "getRivals", "()Ljava/util/List;", "setRivals", "(Ljava/util/List;)V", "sortRivals", "getSortRivals", "setSortRivals", "", "imprId", "Ljava/lang/String;", "getImprId", "()Ljava/lang/String;", "groupName", "getGroupName", "Lcom/bytedance/android/live/base/model/message/a5;", "groupInfo", "Lcom/bytedance/android/live/base/model/message/a5;", "getGroupInfo", "()Lcom/bytedance/android/live/base/model/message/a5;", "detailType", "getDetailType", "status", "getStatus", "", "hasSelectButton", "Z", "getHasSelectButton", "()Z", "selectType", "getSelectType", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CompatGroupRivals extends FlexModelBase<IGroupRivals> implements IGroupRivals, h {

    @SerializedName("detail_type")
    protected String detailType;

    @SerializedName("group_info")
    protected a5 groupInfo;

    @SerializedName("group_name")
    protected String groupName;

    @SerializedName("group_rivals_type")
    protected int groupType;

    @SerializedName("has_select_button")
    protected boolean hasSelectButton;

    @SerializedName("impr_id")
    protected String imprId;

    @SerializedName("rivals")
    protected List<? extends m2> rivals;

    @SerializedName("recommend_select_type")
    protected int selectType;
    private List<? extends m2> sortRivals;

    @SerializedName("recommend_status")
    protected int status;

    public CompatGroupRivals() {
        super(IGroupRivals.class);
        this.imprId = "";
        this.groupName = "";
        this.detailType = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.IGroupRivals
    public String getDetailType() {
        return this.detailType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IGroupRivals
    public a5 getGroupInfo() {
        return this.groupInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.IGroupRivals
    public String getGroupName() {
        return this.groupName;
    }

    @Override // com.bytedance.android.livesdk.link.model.IGroupRivals
    public int getGroupType() {
        return this.groupType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IGroupRivals
    public boolean getHasSelectButton() {
        return this.hasSelectButton;
    }

    @Override // com.bytedance.android.livesdk.link.model.IGroupRivals
    public String getImprId() {
        return this.imprId;
    }

    @Override // com.bytedance.android.livesdk.link.model.IGroupRivals
    public List<m2> getRivals() {
        return this.rivals;
    }

    @Override // com.bytedance.android.livesdk.link.model.IGroupRivals
    public int getSelectType() {
        return this.selectType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IGroupRivals
    public List<m2> getSortRivals() {
        return this.sortRivals;
    }

    @Override // com.bytedance.android.livesdk.link.model.IGroupRivals
    public int getStatus() {
        return this.status;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public CompatGroupRivals(g r5) {
        super(IGroupRivals.class);
        this.rivals = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L17;
        g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        this.groupInfo = f.a(r5, a5.class);
        goto L3
    L9:
        this.selectType = r5.i();
        goto L3
    L10:
        this.hasSelectButton = am3.h.a(r5);
        goto L3
    L11:
        this.status = r5.i();
        goto L3
    L12:
        this.detailType = am3.h.c(r5);
        goto L3
    L13:
        this.groupName = am3.h.c(r5);
        goto L3
    L14:
        this.imprId = am3.h.c(r5);
        goto L3
    L15:
        this.rivals.add(f.a(r5, m2.class));
        goto L3
    L16:
        this.groupType = r5.i();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L17:
        r5.d(r0);
        setThreadSafe(true);
        if (this.imprId != null) goto L21;
        this.imprId = "";
    L21:
        if (this.groupName != null) goto L24;
        this.groupName = "";
    L24:
        if (this.detailType != null) goto L49;
        this.detailType = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.IGroupRivals
    public void setRivals(List<? extends m2> r1) {
        this.rivals = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.IGroupRivals
    public void setSortRivals(List<? extends m2> r1) {
        this.sortRivals = r1;
    }
}
