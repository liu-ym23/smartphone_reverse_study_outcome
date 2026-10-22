package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.BattleSeasonPKResultMessage.GetGradeInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IGetGradeInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/k4;", "Lpy/k;", "gradeImg", "Lpy/k;", "getGradeImg", "()Lpy/k;", "setGradeImg", "(Lpy/k;)V", "startImg", "getStartImg", "setStartImg", "", "getGradeDesc$delegate", "Ljava/lang/Object;", "getGetGradeDesc", "()Ljava/lang/String;", "getGradeDesc", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGetGradeInfoFlexImpl extends FlexModelBase<k4> implements k4, vh7.h {

    @SerializedName("get_grade_desc")
    protected String _$$getGradeDesc;

    @SerializedName("grade_img")
    protected py.k gradeImg;

    @SerializedName("start_img")
    protected py.k startImg;

    public IGetGradeInfoFlexImpl() {
        super(k4.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public IGetGradeInfoFlexImpl(am3.g r6) {
        super(k4.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$getGradeDesc = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.gradeImg = vh7.f.a(r6, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.startImg = vh7.f.a(r6, py.k.class);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.k4
    public final String getGetGradeDesc() {
        return this._$$getGradeDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.k4
    public py.k getGradeImg() {
        return this.gradeImg;
    }

    @Override // com.bytedance.android.livesdk.link.model.k4
    public py.k getStartImg() {
        return this.startImg;
    }

    public void setGradeImg(py.k r1) {
        this.gradeImg = r1;
    }

    public void setStartImg(py.k r1) {
        this.startImg = r1;
    }
}
