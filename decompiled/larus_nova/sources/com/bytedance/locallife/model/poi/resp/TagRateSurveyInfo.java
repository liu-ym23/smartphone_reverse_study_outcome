package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u001d\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\u000b\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/TagRateSurveyInfo;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/locallife/model/poi/resp/PoiLynxStruct;", "component2", "surveyPosition", "surveyQuestion", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getSurveyPosition", "()I", "Lcom/bytedance/locallife/model/poi/resp/PoiLynxStruct;", "getSurveyQuestion", "()Lcom/bytedance/locallife/model/poi/resp/PoiLynxStruct;", "<init>", "(ILcom/bytedance/locallife/model/poi/resp/PoiLynxStruct;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class TagRateSurveyInfo implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("survey_position")
    private final int surveyPosition;

    @SerializedName("survey_question")
    private final PoiLynxStruct surveyQuestion;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TagRateSurveyInfo() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TagRateSurveyInfo copy$default(TagRateSurveyInfo r100, int r101, PoiLynxStruct r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.surveyPosition;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.surveyQuestion;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.surveyPosition;
    }

    public final PoiLynxStruct component2() {
        return this.surveyQuestion;
    }

    public final TagRateSurveyInfo copy(int r100, PoiLynxStruct r101) {
        return new TagRateSurveyInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TagRateSurveyInfo) == true) goto L8;
        return false;
    L8:
        TagRateSurveyInfo r101 = (TagRateSurveyInfo) r100;
        if (this.surveyPosition == r101.surveyPosition) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.surveyQuestion, r101.surveyQuestion) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.surveyPosition * 31;
        PoiLynxStruct r101 = this.surveyQuestion;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "TagRateSurveyInfo(surveyPosition=" + this.surveyPosition + ", surveyQuestion=" + this.surveyQuestion + ')';
    }

    public final int getSurveyPosition() {
        return this.surveyPosition;
    }

    public final PoiLynxStruct getSurveyQuestion() {
        return this.surveyQuestion;
    }

    public TagRateSurveyInfo(int r100, PoiLynxStruct r101) {
        this.surveyPosition = r100;
        this.surveyQuestion = r101;
    }

    public /* synthetic */ TagRateSurveyInfo(int r100, PoiLynxStruct r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
