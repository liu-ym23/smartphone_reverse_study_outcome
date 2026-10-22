package com.larus.camera.impl.entity;

import com.larus.bmhome.chat.bean.SuggestActionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import px8.e;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0013"}, d2 = {"Lcom/larus/camera/impl/entity/ResultTabPresentationType;", "", "controlType", "Lcom/larus/camera/impl/entity/ResultBottomControlType;", "suggestType", "Lcom/larus/camera/impl/entity/ResultSuggestType;", "<init>", "(Ljava/lang/String;ILcom/larus/camera/impl/entity/ResultBottomControlType;Lcom/larus/camera/impl/entity/ResultSuggestType;)V", "getControlType", "()Lcom/larus/camera/impl/entity/ResultBottomControlType;", "getSuggestType", "()Lcom/larus/camera/impl/entity/ResultSuggestType;", "QUESTION_LEGACY", "QUESTION", "MULTI_QUESTION", "HOMEWORK_CORRECTION", SuggestActionType.PHOTO, "toBottomState", "Lcom/larus/camera/impl/entity/ResultBottomState;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResultTabPresentationType extends Enum<ResultTabPresentationType> {
    public static final ResultTabPresentationType HOMEWORK_CORRECTION = null;
    public static final ResultTabPresentationType MULTI_QUESTION = null;
    public static final ResultTabPresentationType PHOTO = null;
    public static final ResultTabPresentationType QUESTION = null;
    public static final ResultTabPresentationType QUESTION_LEGACY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultTabPresentationType[] f321712a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321713b = null;
    private final ResultBottomControlType controlType;
    private final ResultSuggestType suggestType;

    public static EnumEntries<ResultTabPresentationType> getEntries() {
        return f321713b;
    }

    static {
        ResultTabPresentationType r100 = new ResultTabPresentationType("QUESTION_LEGACY", 0, ResultBottomControlType.CONFIRM, ResultSuggestType.NONE);
        QUESTION_LEGACY = r100;
        ResultBottomControlType r101 = ResultBottomControlType.INPUT;
        ResultTabPresentationType r102 = new ResultTabPresentationType("QUESTION", 1, r101, ResultSuggestType.EDU_SINGLE_QUESTION);
        QUESTION = r102;
        ResultTabPresentationType r103 = new ResultTabPresentationType("MULTI_QUESTION", 2, r101, ResultSuggestType.EDU_MULTI_QUESTION);
        MULTI_QUESTION = r103;
        ResultTabPresentationType r104 = new ResultTabPresentationType("HOMEWORK_CORRECTION", 3, r101, ResultSuggestType.HOMEWORK_CORRECTION);
        HOMEWORK_CORRECTION = r104;
        ResultTabPresentationType r105 = new ResultTabPresentationType(SuggestActionType.PHOTO, 4, r101, ResultSuggestType.PHOTO);
        PHOTO = r105;
        ResultTabPresentationType[] r106 = {r100, r102, r103, r104, r105};
        f321712a = r106;
        f321713b = EnumEntriesKt.enumEntries(r106);
    }

    public static ResultTabPresentationType[] values() {
        return (ResultTabPresentationType[]) f321712a.clone();
    }

    public final e toBottomState() {
        return new e(this.controlType, this.suggestType);
    }

    public final ResultBottomControlType getControlType() {
        return this.controlType;
    }

    public final ResultSuggestType getSuggestType() {
        return this.suggestType;
    }

    public static ResultTabPresentationType valueOf(String r100) {
        return (ResultTabPresentationType) a.a(ResultTabPresentationType.class, r100);
    }

    public ResultTabPresentationType(String r100, int r101, ResultBottomControlType r102, ResultSuggestType r103) {
        super(r100, r101);
        this.controlType = r102;
        this.suggestType = r103;
    }
}
