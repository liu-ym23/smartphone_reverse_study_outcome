package com.larus.avlink.env.diary.feedback.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackToastType;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "SUCCESS", "FAILURE", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DiaryFeedbackToastType extends Enum<DiaryFeedbackToastType> {
    public static final DiaryFeedbackToastType FAILURE = null;
    public static final DiaryFeedbackToastType NORMAL = null;
    public static final DiaryFeedbackToastType SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DiaryFeedbackToastType[] f292060a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f292061b = null;

    public static EnumEntries<DiaryFeedbackToastType> getEntries() {
        return f292061b;
    }

    static {
        DiaryFeedbackToastType r100 = new DiaryFeedbackToastType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        DiaryFeedbackToastType r101 = new DiaryFeedbackToastType("SUCCESS", 1);
        SUCCESS = r101;
        DiaryFeedbackToastType r102 = new DiaryFeedbackToastType("FAILURE", 2);
        FAILURE = r102;
        DiaryFeedbackToastType[] r103 = {r100, r101, r102};
        f292060a = r103;
        f292061b = EnumEntriesKt.enumEntries(r103);
    }

    public static DiaryFeedbackToastType[] values() {
        return (DiaryFeedbackToastType[]) f292060a.clone();
    }

    public static DiaryFeedbackToastType valueOf(String r100) {
        return (DiaryFeedbackToastType) a.a(DiaryFeedbackToastType.class, r100);
    }

    public DiaryFeedbackToastType(String r100, int r101) {
        super(r100, r101);
    }
}
