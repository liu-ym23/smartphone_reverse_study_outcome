package teb;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import java.util.HashSet;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashSet f545653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f545654b;

    public final void a() {
        FeedListAdapter r100 = this.f545654b.f545657b.get();
        HashSet r101 = this.f545653a;
        RecyclerView r102 = r100.f421280a;
        if (r102 == null) goto L19;
        LinearLayoutManager r103 = (LinearLayoutManager) r102.getLayoutManager();
        int r104 = r103.findFirstVisibleItemPosition() - 2;
        int r105 = r103.findLastVisibleItemPosition() + 3;
        if (r104 >= 0) goto L9;
        r104 = 0;
    L9:
        if (r105 <= r100.getItemCount()) goto L11;
        r105 = r100.getItemCount();
    L11:
        if (r104 >= r105) goto L25;
        UIFeedCard r106 = r100.getItem(r104);
        if (r106 == null) goto L18;
        if (r101.contains(r106.getId()) == false) goto L18;
        r100.notifyItemChanged(r104);
    L18:
        r104 = r104 + 1;
        goto L11
    L25:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(f r100, HashSet r101) {
        this.f545654b = r100;
        this.f545653a = r101;
    }
}
