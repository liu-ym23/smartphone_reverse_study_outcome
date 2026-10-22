package j7c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.adapterhelper.TaskBaseQuickAdapter;
import com.ss.android.lark.todo.impl.adapterhelper.loadmodule.PageLoadingStatus;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f497663a;

    public d(b r100) {
        this.f497663a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b r101 = this.f497663a;
        if (r101.f497661e != PageLoadingStatus.LOADING_NEXT_FAIL) goto L12;
        r101.f497661e = PageLoadingStatus.LOADING_NEXT;
        RecyclerView r102 = r101.f497657a.f441368f;
        if (r102 == null) goto L7;
        r102.post(new c(r101));
    L10:
        Log.i("PageLoadMoreModule", "fail click refresh load. position=" + this.f497663a.f497657a.f441366d.size());
        TaskBaseQuickAdapter r103 = this.f497663a.f497657a;
        r103.notifyItemChanged(r103.f441366d.size());
        return;
    L7:
        a r104 = r101.f497658b;
        if (r104 == null) goto L10;
        r104.onLoadMore();
        goto L10
    }
}
