package com.obric.assistant.tipoff;

import com.larus.nova.R;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricFeedbackReasonConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<FeedbackReason> f393435a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<FeedbackReason> f393436b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<FeedbackReason> f393437c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<FeedbackReason> f393438d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<FeedbackReason> f393439e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<Integer, String> f393440f = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/tipoff/ObricFeedbackReasonConfig$FeedbackReason;", "", "id", "", "textRes", "trackLabel", "", "<init>", "(Ljava/lang/String;IIILjava/lang/String;)V", "getId", "()I", "getTextRes", "getTrackLabel", "()Ljava/lang/String;", "TASK_TIME_LONG", "TASK_UN_COMPLETED", "TASK_ERROR_OPERATION", "TASK_ASK_TOO_MUCH", "TASK_UI_RELATED", "TASK_OTHER", "SEARCH_NO_RESULT", "SEARCH_INCOMPLETE_RESULT", "SEARCH_WRONG_ANSWER", "SEARCH_OTHER", "MEMORY_CONTENT_WRONG", "MEMORY_CONTENT_MISSING", "MEMORY_CONTENT_REDUNDANT", "MEMORY_CATEGORY_ERROR", "MEMORY_NOT_UPDATED", "MEMORY_NOT_DELETED", "MEMORY_OTHER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedbackReason extends Enum<FeedbackReason> {
        public static final FeedbackReason MEMORY_CATEGORY_ERROR = null;
        public static final FeedbackReason MEMORY_CONTENT_MISSING = null;
        public static final FeedbackReason MEMORY_CONTENT_REDUNDANT = null;
        public static final FeedbackReason MEMORY_CONTENT_WRONG = null;
        public static final FeedbackReason MEMORY_NOT_DELETED = null;
        public static final FeedbackReason MEMORY_NOT_UPDATED = null;
        public static final FeedbackReason MEMORY_OTHER = null;
        public static final FeedbackReason SEARCH_INCOMPLETE_RESULT = null;
        public static final FeedbackReason SEARCH_NO_RESULT = null;
        public static final FeedbackReason SEARCH_OTHER = null;
        public static final FeedbackReason SEARCH_WRONG_ANSWER = null;
        public static final FeedbackReason TASK_ASK_TOO_MUCH = null;
        public static final FeedbackReason TASK_ERROR_OPERATION = null;
        public static final FeedbackReason TASK_OTHER = null;
        public static final FeedbackReason TASK_TIME_LONG = null;
        public static final FeedbackReason TASK_UI_RELATED = null;
        public static final FeedbackReason TASK_UN_COMPLETED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeedbackReason[] f393441a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f393442b = null;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f393443id;
        private final int textRes;
        private final String trackLabel;

        public static EnumEntries<FeedbackReason> getEntries() {
            return f393442b;
        }

        static {
            FeedbackReason r100 = new FeedbackReason("TASK_TIME_LONG", 0, 101, R.string.obric_task_feedback_reason_time_long, null, 4, null);
            TASK_TIME_LONG = r100;
            String r110 = null;
            int r111 = 4;
            DefaultConstructorMarker r112 = null;
            FeedbackReason r101 = new FeedbackReason("TASK_UN_COMPLETED", 1, 102, R.string.obric_task_feedback_reason_un_completed, r110, r111, r112);
            TASK_UN_COMPLETED = r101;
            String r210 = null;
            int r211 = 4;
            DefaultConstructorMarker r212 = null;
            FeedbackReason r102 = new FeedbackReason("TASK_ERROR_OPERATION", 2, 103, R.string.obric_task_feedback_reason_error_operation, r210, r211, r212);
            TASK_ERROR_OPERATION = r102;
            FeedbackReason r103 = new FeedbackReason("TASK_ASK_TOO_MUCH", 3, 104, R.string.obric_task_feedback_reason_ask_too_much, r110, r111, r112);
            TASK_ASK_TOO_MUCH = r103;
            FeedbackReason r104 = new FeedbackReason("TASK_UI_RELATED", 4, 105, R.string.obric_task_feedback_reason_ui_related, r210, r211, r212);
            TASK_UI_RELATED = r104;
            FeedbackReason r105 = new FeedbackReason("TASK_OTHER", 5, 106, R.string.obric_task_feedback_reason_other, r110, r111, r112);
            TASK_OTHER = r105;
            FeedbackReason r106 = new FeedbackReason("SEARCH_NO_RESULT", 6, 107, R.string.obric_search_feedback_reason_not_found, CommodityText.NO_RESULT);
            SEARCH_NO_RESULT = r106;
            FeedbackReason r107 = new FeedbackReason("SEARCH_INCOMPLETE_RESULT", 7, 108, R.string.obric_search_feedback_reason_incomplete, "incomplete_result");
            SEARCH_INCOMPLETE_RESULT = r107;
            FeedbackReason r108 = new FeedbackReason("SEARCH_WRONG_ANSWER", 8, 109, R.string.obric_search_feedback_reason_wrong_reply, "wrong_answer");
            SEARCH_WRONG_ANSWER = r108;
            FeedbackReason r113 = new FeedbackReason("SEARCH_OTHER", 9, 110, R.string.obric_task_feedback_reason_other, "other");
            SEARCH_OTHER = r113;
            FeedbackReason r109 = new FeedbackReason("MEMORY_CONTENT_WRONG", 10, 111, R.string.obric_memory_feedback_reason_wrong_content, "content_wrong");
            MEMORY_CONTENT_WRONG = r109;
            FeedbackReason r114 = new FeedbackReason("MEMORY_CONTENT_MISSING", 11, 112, R.string.obric_memory_feedback_reason_missing_content, "content_missing");
            MEMORY_CONTENT_MISSING = r114;
            FeedbackReason r115 = new FeedbackReason("MEMORY_CONTENT_REDUNDANT", 12, 113, R.string.obric_memory_feedback_reason_redundant_content, "content_redundant");
            MEMORY_CONTENT_REDUNDANT = r115;
            FeedbackReason r116 = new FeedbackReason("MEMORY_CATEGORY_ERROR", 13, 114, R.string.obric_memory_feedback_reason_wrong_category, "category_error");
            MEMORY_CATEGORY_ERROR = r116;
            FeedbackReason r117 = new FeedbackReason("MEMORY_NOT_UPDATED", 14, 115, R.string.obric_memory_feedback_reason_not_updated, "not_updated");
            MEMORY_NOT_UPDATED = r117;
            FeedbackReason r118 = new FeedbackReason("MEMORY_NOT_DELETED", 15, 115, R.string.obric_memory_feedback_reason_not_deleted, "not_updated");
            MEMORY_NOT_DELETED = r118;
            FeedbackReason r213 = new FeedbackReason("MEMORY_OTHER", 16, 116, R.string.obric_task_feedback_reason_other, "other");
            MEMORY_OTHER = r213;
            FeedbackReason[] r119 = {r100, r101, r102, r103, r104, r105, r106, r107, r108, r113, r109, r114, r115, r116, r117, r118, r213};
            f393441a = r119;
            f393442b = EnumEntriesKt.enumEntries(r119);
        }

        public static FeedbackReason[] values() {
            return (FeedbackReason[]) f393441a.clone();
        }

        public final int getId() {
            return this.f393443id;
        }

        public final int getTextRes() {
            return this.textRes;
        }

        public final String getTrackLabel() {
            return this.trackLabel;
        }

        public static FeedbackReason valueOf(String r100) {
            return (FeedbackReason) r27.a.a(FeedbackReason.class, r100);
        }

        public FeedbackReason(String r100, int r101, int r102, int r103, String r104) {
            super(r100, r101);
            this.f393443id = r102;
            this.textRes = r103;
            this.trackLabel = r104;
        }

        public /* synthetic */ FeedbackReason(String r100, int r101, int r102, int r110, String r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 4) == 0) goto L5;
            r111 = null;
        L5:
            this(r100, r101, r102, r110, r111);
        }
    }

    static {
        f393435a = CollectionsKt.listOf(new FeedbackReason[]{FeedbackReason.TASK_TIME_LONG, FeedbackReason.TASK_UN_COMPLETED, FeedbackReason.TASK_ERROR_OPERATION, FeedbackReason.TASK_ASK_TOO_MUCH, FeedbackReason.TASK_UI_RELATED, FeedbackReason.TASK_OTHER});
        List<FeedbackReason> r100 = CollectionsKt.listOf(new FeedbackReason[]{FeedbackReason.SEARCH_NO_RESULT, FeedbackReason.SEARCH_INCOMPLETE_RESULT, FeedbackReason.SEARCH_WRONG_ANSWER, FeedbackReason.SEARCH_OTHER});
        f393436b = r100;
        List<FeedbackReason> r101 = CollectionsKt.listOf(new FeedbackReason[]{FeedbackReason.MEMORY_CONTENT_WRONG, FeedbackReason.MEMORY_CONTENT_MISSING, FeedbackReason.MEMORY_CONTENT_REDUNDANT, FeedbackReason.MEMORY_CATEGORY_ERROR});
        f393437c = r101;
        List<FeedbackReason> r102 = r101;
        FeedbackReason r103 = FeedbackReason.MEMORY_OTHER;
        List<FeedbackReason> r104 = CollectionsKt.plus(r102, CollectionsKt.listOf(new FeedbackReason[]{FeedbackReason.MEMORY_NOT_UPDATED, r103}));
        f393438d = r104;
        List<FeedbackReason> r105 = CollectionsKt.plus(r102, CollectionsKt.listOf(new FeedbackReason[]{FeedbackReason.MEMORY_NOT_DELETED, r103}));
        f393439e = r105;
        List r106 = CollectionsKt.flatten(CollectionsKt.listOf(new List[]{r100, r104, r105}));
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L4:
        if (r108.hasNext() == false) goto L11;
        FeedbackReason r109 = (FeedbackReason) r108.next();
        String r110 = r109.getTrackLabel();
        if (r110 == null) goto L8;
        Pair r111 = TuplesKt.to(Integer.valueOf(r109.getId()), r110);
    L9:
        if (r111 == null) goto L4;
        r107.add(r111);
        goto L4
    L8:
        r111 = null;
        goto L9
    L11:
        f393440f = MapsKt.toMap(r107);
    }
}
