package hc5;

import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import gc5.t;
import java.util.ArrayList;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends zd5.a {
    @Override // zd5.a, zd5.f
    public final List<FilterType> G6() {
        ArrayList r0 = new ArrayList();
        r0.add(FilterType.AI_NOTE_ALL);
        r0.add(FilterType.AI_NOTE_MEETING_NOTE);
        r0.add(FilterType.AI_NOTE_RECORD_NOTE);
        if (t.c() == false) goto L6;
        r0.add(FilterType.AI_NOTE_WEEKLY_RECAP);
    L6:
        if (t.b() == false) goto L8;
        r0.add(FilterType.AI_NOTE_MONTHLY_SUMMARY);
    L8:
        return r0;
    }

    @Override // zd5.f
    public final List<q> x7() {
        ArrayList r0 = new ArrayList();
        RecentSort r1 = RecentSort.MODIFIED;
        r0.add(new q(r1.getResId(), r1.getRank(), r1.getAsc(), r1.getReportSort(), Integer.valueOf(FilterType.WIKI.getResId())));
        RecentSort r2 = RecentSort.CREATED;
        r0.add(new q(r2.getResId(), r2.getRank(), r2.getAsc(), r2.getReportSort()));
        RecentSort r3 = RecentSort.OPENED;
        r0.add(new q(r3.getResId(), r3.getRank(), r3.getAsc(), r3.getReportSort()));
        return r0;
    }

    public b(boolean r1) {
        super(r1);
    }
}
