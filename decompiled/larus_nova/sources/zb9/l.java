package zb9;

import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes29.dex */
public interface l<ITEM> {
    Comparator<i<ITEM>> a(GroupSortPolicy r100);

    i<ITEM> b(i<ITEM> r100, i<ITEM> r101);

    Object c(i<ITEM> r100);

    List<i<ITEM>> d(List<i<ITEM>> r100, List<i<ITEM>> r101, GroupSortPolicy r102);

    List<i<ITEM>> e(List<i<ITEM>> r100, List<i<ITEM>> r101);
}
