package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001?R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\"\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020#8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\u0006\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010,\u001a\u00020#8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b*\u0010%R\u001c\u00101\u001a\u0004\u0018\u00010-8&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0006\u001a\u0004\b.\u0010/R\u001a\u00106\u001a\u0002028&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0006\u001a\u0004\b3\u00104R\u001a\u00109\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0006\u001a\u0004\b7\u0010 R\u001c\u0010>\u001a\u0004\u0018\u00010:8&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0006\u001a\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleUserInfo;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/link/model/k0;", "getUserInfo", "()Lcom/bytedance/android/livesdk/link/model/k0;", "getUserInfo$annotations", "()V", "userInfo", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTagList", "()Ljava/util/List;", "getTagList$annotations", "tagList", "Lcom/bytedance/android/livesdk/link/model/x0;", "getBattleConsecutiveRecordInfo", "()Lcom/bytedance/android/livesdk/link/model/x0;", "getBattleConsecutiveRecordInfo$annotations", "battleConsecutiveRecordInfo", "Lcom/bytedance/android/livesdk/link/model/y2;", "getGrade", "()Lcom/bytedance/android/livesdk/link/model/y2;", "getGrade$annotations", "grade", "Lcom/bytedance/android/livesdk/link/model/z2;", "getGradeChange", "()Lcom/bytedance/android/livesdk/link/model/z2;", "getGradeChange$annotations", "gradeChange", "", "getTeamCoachScore", "()Ljava/lang/String;", "getTeamCoachScore$annotations", "teamCoachScore", "", "getPkRole", "()I", "setPkRole", "(I)V", "getPkRole$annotations", "pkRole", "getPkResult", "getPkResult$annotations", "pkResult", "Lcom/bytedance/android/livesdk/link/model/n0;", "getActivityUser", "()Lcom/bytedance/android/livesdk/link/model/n0;", "getActivityUser$annotations", "activityUser", "", "getMultiPkTeamId", "()J", "getMultiPkTeamId$annotations", "multiPkTeamId", "getDecText", "getDecText$annotations", "decText", "Lcom/bytedance/android/livesdk/link/model/y9;", "getUserImgFlipInfo", "()Lcom/bytedance/android/livesdk/link/model/y9;", "getUserImgFlipInfo$annotations", "userImgFlipInfo", "PKResult", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBattleUserInfo extends vh7.c<IBattleUserInfo> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleUserInfo$PKResult;", "", "PKUnCompute", "PKVictory", "PKFail", "PKTie", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum PKResult extends Enum<PKResult> {
        public static final PKResult PKFail = null;
        public static final PKResult PKTie = null;
        public static final PKResult PKUnCompute = null;
        public static final PKResult PKVictory = null;
        public static final /* synthetic */ PKResult[] a = null;

        static {
            PKResult r1 = new PKResult("PKUnCompute", 0);
            PKUnCompute = r1;
            PKResult r2 = new PKResult("PKVictory", 1);
            PKVictory = r2;
            PKResult r3 = new PKResult("PKFail", 2);
            PKFail = r3;
            PKResult r4 = new PKResult("PKTie", 3);
            PKTie = r4;
            a = new PKResult[]{r1, r2, r3, r4};
        }

        public static PKResult valueOf(String r1) {
            return (PKResult) r27.a.a(PKResult.class, r1);
        }

        public static PKResult[] values() {
            return (PKResult[]) a.clone();
        }

        public PKResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "activity_user")
    n0 getActivityUser();

    @FieldName(name = "consecutive_record")
    x0 getBattleConsecutiveRecordInfo();

    @FieldName(name = "battle_start_desc_text")
    String getDecText();

    @FieldName(name = "grade")
    y2 getGrade();

    @FieldName(name = "grade_change")
    z2 getGradeChange();

    @FieldName(name = "multi_pk_team_id")
    long getMultiPkTeamId();

    @FieldName(name = "pk_result")
    int getPkResult();

    @FieldName(name = "pk_role")
    int getPkRole();

    @FieldName(name = "tags")
    List<IBattleRivalTag> getTagList();

    @FieldName(name = "team_coach_score")
    String getTeamCoachScore();

    @FieldName(name = "user_img_flip_info")
    y9 getUserImgFlipInfo();

    @FieldName(name = "user")
    k0 getUserInfo();

    @FieldName(name = "pk_role#setter")
    void setPkRole(int r1);
}
