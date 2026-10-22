package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BattleStarActivityGrade")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0013\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/y2;", "", "grade$delegate", "Ljava/lang/Object;", "getGrade", "()Ljava/lang/String;", "grade", "", "level$delegate", "getLevel", "()J", "level", "starCount$delegate", "getStarCount", "starCount", "targetStarCount$delegate", "getTargetStarCount", "targetStarCount", "Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeMedalFlexImpl;", "gradeMedal$delegate", "getGradeMedal", "()Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeMedalFlexImpl;", "gradeMedal", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleStarActivityGradeFlexImpl extends FlexModelBase<y2> implements y2, vh7.h {

    @SerializedName("grade")
    protected String _$$grade;

    @SerializedName("star_activity_grade_medal")
    protected IBattleStarActivityGradeMedalFlexImpl _$$gradeMedal;

    @SerializedName("level")
    protected long _$$level;

    @SerializedName("star_count")
    protected long _$$starCount;

    @SerializedName("target_star_count")
    protected long _$$targetStarCount;

    public IBattleStarActivityGradeFlexImpl() {
        super(y2.class);
        this._$$grade = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.y2
    public /* bridge */ /* synthetic */ a3 getGradeMedal() {
        return getGradeMedal();
    }

    @Override // com.bytedance.android.livesdk.link.model.y2
    public final String getGrade() {
        return this._$$grade;
    }

    @Override // com.bytedance.android.livesdk.link.model.y2
    public final long getLevel() {
        return this._$$level;
    }

    @Override // com.bytedance.android.livesdk.link.model.y2
    public final long getStarCount() {
        return this._$$starCount;
    }

    @Override // com.bytedance.android.livesdk.link.model.y2
    public final long getTargetStarCount() {
        return this._$$targetStarCount;
    }

    @Override // com.bytedance.android.livesdk.link.model.y2
    public final IBattleStarActivityGradeMedalFlexImpl getGradeMedal() {
        return this._$$gradeMedal;
    }

    public IBattleStarActivityGradeFlexImpl(am3.g r6) {
        super(y2.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$grade = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$level = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$starCount = r6.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this._$$targetStarCount = r6.j();
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this._$$gradeMedal = new IBattleStarActivityGradeMedalFlexImpl(r6);
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$grade != null) goto L43;
        this._$$grade = "";
        return;
    }
}
