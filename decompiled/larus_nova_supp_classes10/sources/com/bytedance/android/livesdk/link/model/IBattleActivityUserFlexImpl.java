package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.ActivityUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b4\u00105R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001cR#\u0010)\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u0015R\u001b\u0010,\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010\u001cR\u001b\u0010/\u001a\u00020-8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u00100R\u001b\u00103\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u001a\u001a\u0004\b2\u0010\u001c¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleActivityUserFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/n0;", "Lcom/bytedance/android/live/base/model/message/a5;", "displayTabText", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayTabText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayTabText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "Lpy/k;", "buttonImage", "Lpy/k;", "getButtonImage", "()Lpy/k;", "setButtonImage", "(Lpy/k;)V", "", "backgroundList", "Ljava/util/List;", "getBackgroundList", "()Ljava/util/List;", "setBackgroundList", "(Ljava/util/List;)V", "", "activityName$delegate", "Ljava/lang/Object;", "getActivityName", "()Ljava/lang/String;", "activityName", "", "userId$delegate", "getUserId", "()J", "userId", "userIdStr$delegate", "getUserIdStr", "userIdStr", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTagFlexImpl;", "labelList$delegate", "getLabelList", "labelList", "subTabText$delegate", "getSubTabText", "subTabText", "", "isValid$delegate", "isValid", "()Z", "reasonMessage$delegate", "getReasonMessage", "reasonMessage", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleActivityUserFlexImpl extends FlexModelBase<n0> implements n0, vh7.h {

    @SerializedName("activity_name")
    protected String _$$activityName;

    @SerializedName(LocationMonitorConst.IS_VALID)
    protected boolean _$$isValid;

    @SerializedName("labels")
    protected List<IBattleRivalTagFlexImpl> _$$labelList;

    @SerializedName("message")
    protected String _$$reasonMessage;

    @SerializedName("sub_tab_text")
    protected String _$$subTabText;

    @SerializedName("user_id")
    protected long _$$userId;

    @SerializedName("user_id_str")
    protected String _$$userIdStr;

    @SerializedName("back_ground_images")
    protected List<? extends py.k> backgroundList;

    @SerializedName("button_image")
    protected py.k buttonImage;

    @SerializedName("display_tab_text")
    protected com.bytedance.android.live.base.model.message.a5 displayTabText;

    public IBattleActivityUserFlexImpl() {
        super(n0.class);
        this._$$activityName = "";
        this._$$userIdStr = "";
        this._$$subTabText = "";
        this._$$isValid = false;
        this._$$reasonMessage = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.n0
    public final String getActivityName() {
        return this._$$activityName;
    }

    @Override // com.bytedance.android.livesdk.link.model.n0
    public List<py.k> getBackgroundList() {
        return this.backgroundList;
    }

    @Override // com.bytedance.android.livesdk.link.model.n0
    public py.k getButtonImage() {
        return this.buttonImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.n0
    public com.bytedance.android.live.base.model.message.a5 getDisplayTabText() {
        return this.displayTabText;
    }

    @Override // com.bytedance.android.livesdk.link.model.n0
    public final List<IBattleRivalTagFlexImpl> getLabelList() {
        return this._$$labelList;
    }

    @Override // com.bytedance.android.livesdk.link.model.n0
    public final String getReasonMessage() {
        return this._$$reasonMessage;
    }

    @Override // com.bytedance.android.livesdk.link.model.n0
    public final String getSubTabText() {
        return this._$$subTabText;
    }

    @Override // com.bytedance.android.livesdk.link.model.n0
    public final long getUserId() {
        return this._$$userId;
    }

    @Override // com.bytedance.android.livesdk.link.model.n0
    public final String getUserIdStr() {
        return this._$$userIdStr;
    }

    @Override // com.bytedance.android.livesdk.link.model.n0
    public final boolean isValid() {
        return this._$$isValid;
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public IBattleActivityUserFlexImpl(am3.g r7) {
        super(n0.class);
        this._$$labelList = new ArrayList();
        this.backgroundList = new ArrayList();
        setThreadSafe(false);
        long r1 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L19;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        List r6 = this.backgroundList;
        Object r8 = vh7.f.a(r7, py.k.class);
    L14:
        r6.add(r8);
        goto L3
    L9:
        this.buttonImage = vh7.f.a(r7, py.k.class);
        goto L3
    L10:
        this._$$reasonMessage = am3.h.c(r7);
        goto L3
    L11:
        this._$$isValid = am3.h.a(r7);
        r3 = r3 | 2;
        goto L3
    L12:
        this._$$subTabText = am3.h.c(r7);
        goto L3
    L13:
        r6 = this._$$labelList;
        r8 = new IBattleRivalTagFlexImpl(r7);
        goto L14
    L15:
        this._$$userIdStr = am3.h.c(r7);
        goto L3
    L16:
        this._$$userId = r7.j();
        r3 = r3 | 1;
        goto L3
    L17:
        this.displayTabText = vh7.f.a(r7, com.bytedance.android.live.base.model.message.a5.class);
        goto L3
    L18:
        this._$$activityName = am3.h.c(r7);
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L19:
        r7.d(r1);
        setThreadSafe(true);
        if (this._$$activityName != null) goto L23;
        this._$$activityName = "";
    L23:
        if (this._$$userIdStr != null) goto L26;
        this._$$userIdStr = "";
    L26:
        if (this._$$subTabText != null) goto L29;
        this._$$subTabText = "";
    L29:
        if ((r3 & 2) != 0) goto L32;
        this._$$isValid = false;
    L32:
        if (this._$$reasonMessage != null) goto L58;
        this._$$reasonMessage = "";
        return;
    }

    public void setBackgroundList(List<? extends py.k> r1) {
        this.backgroundList = r1;
    }

    public void setButtonImage(py.k r1) {
        this.buttonImage = r1;
    }

    public void setDisplayTabText(com.bytedance.android.live.base.model.message.a5 r1) {
        this.displayTabText = r1;
    }
}
