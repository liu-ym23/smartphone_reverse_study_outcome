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
@ProtoMessage("webcast.data.ActivityPKConf")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bD\u0010ER$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R$\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001b\u0010&\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*R\u001b\u0010.\u001a\u00020'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010#\u001a\u0004\b-\u0010*R\u001b\u00101\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010#\u001a\u0004\b0\u0010%R\u001b\u00104\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010#\u001a\u0004\b3\u0010%R\u001b\u00107\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010#\u001a\u0004\b6\u0010%R\u001b\u0010:\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010#\u001a\u0004\b9\u0010%R\u001b\u0010=\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010#\u001a\u0004\b<\u0010%R\u001b\u0010@\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010#\u001a\u0004\b?\u0010%R\u001b\u0010C\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bA\u0010#\u001a\u0004\bB\u0010%¨\u0006F"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleActivityPKConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/m0;", "Lcom/bytedance/android/live/base/model/message/a5;", "displayTabText", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayTabText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayTabText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "", "Lpy/k;", "tabImageList", "Ljava/util/List;", "getTabImageList", "()Ljava/util/List;", "setTabImageList", "(Ljava/util/List;)V", "randomButtonImage", "Lpy/k;", "getRandomButtonImage", "()Lpy/k;", "setRandomButtonImage", "(Lpy/k;)V", "inviteButtonImage", "getInviteButtonImage", "setInviteButtonImage", "backgroundImageList", "getBackgroundImageList", "setBackgroundImageList", "topRightImage", "getTopRightImage", "setTopRightImage", "", "activityName$delegate", "Ljava/lang/Object;", "getActivityName", "()Ljava/lang/String;", "activityName", "", "startTime$delegate", "getStartTime", "()J", "startTime", "endTime$delegate", "getEndTime", "endTime", "searchTabText$delegate", "getSearchTabText", "searchTabText", "rulePageUrl$delegate", "getRulePageUrl", "rulePageUrl", "randomButtonText$delegate", "getRandomButtonText", "randomButtonText", "inviteButtonText$delegate", "getInviteButtonText", "inviteButtonText", "topRightUrl$delegate", "getTopRightUrl", "topRightUrl", "historyPageUrl$delegate", "getHistoryPageUrl", "historyPageUrl", "step$delegate", "getStep", "step", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleActivityPKConfigFlexImpl extends FlexModelBase<m0> implements m0, vh7.h {

    @SerializedName("activity_name")
    protected String _$$activityName;

    @SerializedName("end_time")
    protected long _$$endTime;

    @SerializedName("history_page_url")
    protected String _$$historyPageUrl;

    @SerializedName("invite_battle_button_text")
    protected String _$$inviteButtonText;

    @SerializedName("random_battle_button_text")
    protected String _$$randomButtonText;

    @SerializedName("rule_page_url")
    protected String _$$rulePageUrl;

    @SerializedName("search_tab_text")
    protected String _$$searchTabText;

    @SerializedName("start_time")
    protected long _$$startTime;

    @SerializedName("step")
    protected String _$$step;

    @SerializedName("top_right_image_tab_url")
    protected String _$$topRightUrl;

    @SerializedName("back_ground_images")
    protected List<? extends py.k> backgroundImageList;

    @SerializedName("display_tab_text")
    protected com.bytedance.android.live.base.model.message.a5 displayTabText;

    @SerializedName("invite_battle_button_image")
    protected py.k inviteButtonImage;

    @SerializedName("random_battle_button_image")
    protected py.k randomButtonImage;

    @SerializedName("display_tab_images")
    protected List<? extends py.k> tabImageList;

    @SerializedName("top_right_image")
    protected py.k topRightImage;

    public IBattleActivityPKConfigFlexImpl() {
        super(m0.class);
        this._$$activityName = "";
        this._$$searchTabText = "";
        this._$$rulePageUrl = "";
        this._$$randomButtonText = "";
        this._$$inviteButtonText = "";
        this._$$topRightUrl = "";
        this._$$historyPageUrl = "";
        this._$$step = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public final String getActivityName() {
        return this._$$activityName;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public List<py.k> getBackgroundImageList() {
        return this.backgroundImageList;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public com.bytedance.android.live.base.model.message.a5 getDisplayTabText() {
        return this.displayTabText;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public final long getEndTime() {
        return this._$$endTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public final String getHistoryPageUrl() {
        return this._$$historyPageUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public py.k getInviteButtonImage() {
        return this.inviteButtonImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public final String getInviteButtonText() {
        return this._$$inviteButtonText;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public py.k getRandomButtonImage() {
        return this.randomButtonImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public final String getRandomButtonText() {
        return this._$$randomButtonText;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public final String getRulePageUrl() {
        return this._$$rulePageUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public final String getSearchTabText() {
        return this._$$searchTabText;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public final long getStartTime() {
        return this._$$startTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public final String getStep() {
        return this._$$step;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public List<py.k> getTabImageList() {
        return this.tabImageList;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public py.k getTopRightImage() {
        return this.topRightImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.m0
    public final String getTopRightUrl() {
        return this._$$topRightUrl;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public IBattleActivityPKConfigFlexImpl(am3.g r5) {
        super(m0.class);
        this.tabImageList = new ArrayList();
        this.backgroundImageList = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L25;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L9;
            case 16: goto L8;
            default: goto L7;
        };
    L8:
        this._$$step = am3.h.c(r5);
        goto L3
    L9:
        this._$$historyPageUrl = am3.h.c(r5);
        goto L3
    L10:
        this._$$topRightUrl = am3.h.c(r5);
        goto L3
    L11:
        this.topRightImage = vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        List<? extends py.k> r4 = this.backgroundImageList;
    L20:
        r4.add(vh7.f.a(r5, py.k.class));
        goto L3
    L13:
        this._$$inviteButtonText = am3.h.c(r5);
        goto L3
    L14:
        this.inviteButtonImage = vh7.f.a(r5, py.k.class);
        goto L3
    L15:
        this._$$randomButtonText = am3.h.c(r5);
        goto L3
    L16:
        this.randomButtonImage = vh7.f.a(r5, py.k.class);
        goto L3
    L17:
        this._$$rulePageUrl = am3.h.c(r5);
        goto L3
    L18:
        this._$$searchTabText = am3.h.c(r5);
        goto L3
    L19:
        r4 = this.tabImageList;
        goto L20
    L21:
        this.displayTabText = vh7.f.a(r5, com.bytedance.android.live.base.model.message.a5.class);
        goto L3
    L22:
        this._$$endTime = r5.j();
        goto L3
    L23:
        this._$$startTime = r5.j();
        goto L3
    L24:
        this._$$activityName = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L25:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$activityName != null) goto L29;
        this._$$activityName = "";
    L29:
        if (this._$$searchTabText != null) goto L32;
        this._$$searchTabText = "";
    L32:
        if (this._$$rulePageUrl != null) goto L35;
        this._$$rulePageUrl = "";
    L35:
        if (this._$$randomButtonText != null) goto L38;
        this._$$randomButtonText = "";
    L38:
        if (this._$$inviteButtonText != null) goto L41;
        this._$$inviteButtonText = "";
    L41:
        if (this._$$topRightUrl != null) goto L44;
        this._$$topRightUrl = "";
    L44:
        if (this._$$historyPageUrl != null) goto L47;
        this._$$historyPageUrl = "";
    L47:
        if (this._$$step != null) goto L85;
        this._$$step = "";
        return;
    }

    public void setBackgroundImageList(List<? extends py.k> r1) {
        this.backgroundImageList = r1;
    }

    public void setDisplayTabText(com.bytedance.android.live.base.model.message.a5 r1) {
        this.displayTabText = r1;
    }

    public void setInviteButtonImage(py.k r1) {
        this.inviteButtonImage = r1;
    }

    public void setRandomButtonImage(py.k r1) {
        this.randomButtonImage = r1;
    }

    public void setTabImageList(List<? extends py.k> r1) {
        this.tabImageList = r1;
    }

    public void setTopRightImage(py.k r1) {
        this.topRightImage = r1;
    }
}
