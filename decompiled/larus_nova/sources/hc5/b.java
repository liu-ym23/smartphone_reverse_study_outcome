package hc5;

import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import gc5.t;
import java.util.ArrayList;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends zd5.a {
    @Override // zd5.a, zd5.f
    public final List<FilterType> G6() {
        ArrayList r100 = new ArrayList();
        r100.add(FilterType.AI_NOTE_ALL);
        r100.add(FilterType.AI_NOTE_MEETING_NOTE);
        r100.add(FilterType.AI_NOTE_RECORD_NOTE);
        if (t.c() == false) goto L6;
        r100.add(FilterType.AI_NOTE_WEEKLY_RECAP);
    L6:
        if (t.b() == false) goto L8;
        r100.add(FilterType.AI_NOTE_MONTHLY_SUMMARY);
    L8:
        return r100;
    }

    @Override // zd5.f
    public final List<q> x7() {
        ArrayList r100 = new ArrayList();
        RecentSort r101 = RecentSort.MODIFIED;
        r100.add(new q(r101.getResId(), r101.getRank(), r101.getAsc(), r101.getReportSort(), Integer.valueOf(FilterType.WIKI.getResId())));
        RecentSort r102 = RecentSort.CREATED;
        r100.add(new q(r102.getResId(), r102.getRank(), r102.getAsc(), r102.getReportSort()));
        RecentSort r103 = RecentSort.OPENED;
        r100.add(new q(r103.getResId(), r103.getRank(), r103.getAsc(), r103.getReportSort()));
        return r100;
    }

    public b(boolean r100) {
        super(r100);
    }
}
