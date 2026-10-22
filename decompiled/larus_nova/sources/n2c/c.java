package n2c;

import android.os.Bundle;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import com.ss.android.lark.reaction.widget.detailwindow.pager.ReactionListFragment;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ReactionDetailViewModel> f516839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f516840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f516841c;

    public final List<o2c.a> a() {
        ArrayList r100 = new ArrayList();
        Iterator<ReactionDetailViewModel> r101 = this.f516839a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ReactionDetailViewModel r102 = r101.next();
        String r103 = r102.getReactionKey();
        boolean r104 = this.f516841c;
        int r105 = ReactionListFragment.f439239n;
        r100.add(new o2c.a(ReactionListFragment.S90(r102, r104, UIHelper.dp2px(56.0f)), r103, r102.getTotalCount()));
        goto L4
    L6:
        return r100;
    }

    public c(Bundle r100) {
        if (r100 == null) goto L6;
        this.f516839a = (List) r100.getSerializable("reaction_info_list");
        this.f516840b = r100.getString("reaction_opened_type");
        this.f516841c = r100.getBoolean("key_need_loading");
        return;
    }
}
