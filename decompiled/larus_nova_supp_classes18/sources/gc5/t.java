package gc5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.sort.FilterType;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FilterType.values().length];
            r0[FilterType.AI_NOTE_MEETING_NOTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[FilterType.AI_NOTE_WEEKLY_RECAP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[FilterType.AI_NOTE_MONTHLY_SUMMARY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[FilterType.AI_NOTE_RECORD_NOTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final boolean b() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.space.ai.notes.monthly.report");
        tt5.a.h("AINoteUtils", "isAiNotesMonthlyReportEnabled: " + r0);
        return r0;
    }

    @JvmStatic
    public static final boolean c() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.space.ai.notes.weekly.report");
        tt5.a.h("AINoteUtils", "isAiNotesWeeklyReportEnabled: " + r0);
        return r0;
    }

    @JvmStatic
    public static final FilterType a(FolderSortStrategy r3) {
        if (r3 == null) goto L4;
        FilterType.a r0 = FilterType.Companion;
        int r1 = r3.getType();
        String r2 = r3.c;
        String r4 = r3.d;
        r0.getClass();
        return FilterType.a.a(r1, r2, r4);
    L4:
        return FilterType.AI_NOTE_ALL;
    }
}
