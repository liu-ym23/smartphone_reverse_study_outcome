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
@ProtoMessage("webcast.data.BattleUserInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b@\u0010AR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010!R+\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020#8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010-\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010'R\u001d\u00102\u001a\u0004\u0018\u00010.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0005\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0005\u001a\u0004\b5\u00106R\u001b\u0010:\u001a\u00020\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0005\u001a\u0004\b9\u0010!R\u001d\u0010?\u001a\u0004\u0018\u00010;8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0005\u001a\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleUserInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IBattleUserInfo;", "Lcom/bytedance/android/livesdk/link/model/IBaseUserInfoFlexImpl;", "userInfo$delegate", "Ljava/lang/Object;", "getUserInfo", "()Lcom/bytedance/android/livesdk/link/model/IBaseUserInfoFlexImpl;", "userInfo", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTagFlexImpl;", "tagList$delegate", "getTagList", "()Ljava/util/List;", "tagList", "Lcom/bytedance/android/livesdk/link/model/IBattleConsecutiveRecordInfoFlexImpl;", "battleConsecutiveRecordInfo$delegate", "getBattleConsecutiveRecordInfo", "()Lcom/bytedance/android/livesdk/link/model/IBattleConsecutiveRecordInfoFlexImpl;", "battleConsecutiveRecordInfo", "Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeFlexImpl;", "grade$delegate", "getGrade", "()Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeFlexImpl;", "grade", "Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeChangeFlexImpl;", "gradeChange$delegate", "getGradeChange", "()Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeChangeFlexImpl;", "gradeChange", "", "teamCoachScore$delegate", "getTeamCoachScore", "()Ljava/lang/String;", "teamCoachScore", "", "<set-?>", "pkRole$delegate", "getPkRole", "()I", "setPkRole", "(I)V", "pkRole", "pkResult$delegate", "getPkResult", "pkResult", "Lcom/bytedance/android/livesdk/link/model/IBattleActivityUserFlexImpl;", "activityUser$delegate", "getActivityUser", "()Lcom/bytedance/android/livesdk/link/model/IBattleActivityUserFlexImpl;", "activityUser", "", "multiPkTeamId$delegate", "getMultiPkTeamId", "()J", "multiPkTeamId", "decText$delegate", "getDecText", "decText", "Lcom/bytedance/android/livesdk/link/model/IUserImgFlipInfoFlexImpl;", "userImgFlipInfo$delegate", "getUserImgFlipInfo", "()Lcom/bytedance/android/livesdk/link/model/IUserImgFlipInfoFlexImpl;", "userImgFlipInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleUserInfoFlexImpl extends FlexModelBase<IBattleUserInfo> implements IBattleUserInfo, vh7.h {

    @SerializedName("activity_user")
    protected IBattleActivityUserFlexImpl _$$activityUser;

    @SerializedName("consecutive_record")
    protected IBattleConsecutiveRecordInfoFlexImpl _$$battleConsecutiveRecordInfo;

    @SerializedName("battle_start_desc_text")
    protected String _$$decText;

    @SerializedName("grade")
    protected IBattleStarActivityGradeFlexImpl _$$grade;

    @SerializedName("grade_change")
    protected IBattleStarActivityGradeChangeFlexImpl _$$gradeChange;

    @SerializedName("multi_pk_team_id")
    protected long _$$multiPkTeamId;

    @SerializedName("pk_result")
    protected int _$$pkResult;

    @SerializedName("pk_role")
    protected int _$$pkRole;

    @SerializedName("tags")
    protected List<IBattleRivalTagFlexImpl> _$$tagList;

    @SerializedName("team_coach_score")
    protected String _$$teamCoachScore;

    @SerializedName("user_img_flip_info")
    protected IUserImgFlipInfoFlexImpl _$$userImgFlipInfo;

    @SerializedName("user")
    protected IBaseUserInfoFlexImpl _$$userInfo;

    public IBattleUserInfoFlexImpl() {
        super(IBattleUserInfo.class);
        this._$$teamCoachScore = "";
        this._$$decText = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public /* bridge */ /* synthetic */ n0 getActivityUser() {
        return getActivityUser();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public /* bridge */ /* synthetic */ x0 getBattleConsecutiveRecordInfo() {
        return getBattleConsecutiveRecordInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public /* bridge */ /* synthetic */ y2 getGrade() {
        return getGrade();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public /* bridge */ /* synthetic */ z2 getGradeChange() {
        return getGradeChange();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public /* bridge */ /* synthetic */ y9 getUserImgFlipInfo() {
        return getUserImgFlipInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public /* bridge */ /* synthetic */ k0 getUserInfo() {
        return getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final String getDecText() {
        return this._$$decText;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final long getMultiPkTeamId() {
        return this._$$multiPkTeamId;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final int getPkResult() {
        return this._$$pkResult;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final int getPkRole() {
        return this._$$pkRole;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final List<IBattleRivalTagFlexImpl> getTagList() {
        return this._$$tagList;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final String getTeamCoachScore() {
        return this._$$teamCoachScore;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final IBattleActivityUserFlexImpl getActivityUser() {
        return this._$$activityUser;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final IBattleConsecutiveRecordInfoFlexImpl getBattleConsecutiveRecordInfo() {
        return this._$$battleConsecutiveRecordInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final IBattleStarActivityGradeFlexImpl getGrade() {
        return this._$$grade;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final IBattleStarActivityGradeChangeFlexImpl getGradeChange() {
        return this._$$gradeChange;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final IUserImgFlipInfoFlexImpl getUserImgFlipInfo() {
        return this._$$userImgFlipInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final IBaseUserInfoFlexImpl getUserInfo() {
        return this._$$userInfo;
    }

    public IBattleUserInfoFlexImpl(am3.g r5) {
        super(IBattleUserInfo.class);
        this._$$tagList = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L20;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        this._$$userImgFlipInfo = new IUserImgFlipInfoFlexImpl(r5);
        goto L3
    L9:
        this._$$decText = am3.h.c(r5);
        goto L3
    L10:
        this._$$multiPkTeamId = r5.j();
        goto L3
    L11:
        this._$$activityUser = new IBattleActivityUserFlexImpl(r5);
        goto L3
    L12:
        this._$$pkResult = r5.i();
        goto L3
    L13:
        this._$$pkRole = r5.i();
        goto L3
    L14:
        this._$$teamCoachScore = am3.h.c(r5);
        goto L3
    L15:
        this._$$gradeChange = new IBattleStarActivityGradeChangeFlexImpl(r5);
        goto L3
    L16:
        this._$$grade = new IBattleStarActivityGradeFlexImpl(r5);
        goto L3
    L17:
        this._$$battleConsecutiveRecordInfo = new IBattleConsecutiveRecordInfoFlexImpl(r5);
        goto L3
    L18:
        this._$$tagList.add(new IBattleRivalTagFlexImpl(r5));
        goto L3
    L19:
        this._$$userInfo = new IBaseUserInfoFlexImpl(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L20:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$teamCoachScore != null) goto L24;
        this._$$teamCoachScore = "";
    L24:
        if (this._$$decText != null) goto L55;
        this._$$decText = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleUserInfo
    public final void setPkRole(int r1) {
        this._$$pkRole = r1;
    }
}
