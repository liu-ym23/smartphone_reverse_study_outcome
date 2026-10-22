package gc5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.sort.FilterType;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes18.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f480849a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f480850a = null;

        static {
            int[] r100 = new int[FilterType.values().length];
            r100[FilterType.AI_NOTE_MEETING_NOTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[FilterType.AI_NOTE_WEEKLY_RECAP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[FilterType.AI_NOTE_MONTHLY_SUMMARY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[FilterType.AI_NOTE_RECORD_NOTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f480850a = r100;
        }
    }

    static {
    }

    @JvmStatic
    public static final boolean b() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.space.ai.notes.monthly.report");
        tt5.a.h("AINoteUtils", "isAiNotesMonthlyReportEnabled: " + r100);
        return r100;
    }

    @JvmStatic
    public static final boolean c() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.space.ai.notes.weekly.report");
        tt5.a.h("AINoteUtils", "isAiNotesWeeklyReportEnabled: " + r100);
        return r100;
    }

    @JvmStatic
    public static final FilterType a(FolderSortStrategy r100) {
        if (r100 == null) goto L4;
        FilterType.a r101 = FilterType.Companion;
        int r102 = r100.getType();
        String r103 = r100.f227682c;
        String r104 = r100.f227683d;
        r101.getClass();
        return FilterType.a.a(r102, r103, r104);
    L4:
        return FilterType.AI_NOTE_ALL;
    }
}
