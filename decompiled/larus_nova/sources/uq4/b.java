package uq4;

import com.bytedance.ee.bear.bitable.cardview.viewsetting.CardViewSettingFragment$initSelectFieldList$settingFieldListAdapter$1;
import com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter.SelectFieldViewHolder;
import com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter.ViewSettingSelectFieldListAdapter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f551287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f551288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewSettingSelectFieldListAdapter<SelectFieldViewHolder> f551289c;

    public b(int r100, int r101, CardViewSettingFragment$initSelectFieldList$settingFieldListAdapter$1 r102) {
        this.f551287a = r100;
        this.f551288b = r101;
        this.f551289c = r102;
    }

    public final void a() {
        int r100 = this.f551287a;
        if (r100 != this.f551288b) goto L5;
        return;
    L5:
        if (r100 < ((ArrayList) this.f551289c.f209246d).size()) goto L7;
        return;
    L7:
        if (this.f551288b >= ((ArrayList) this.f551289c.f209246d).size()) goto L12;
        Collections.swap(this.f551289c.f209246d, this.f551287a, this.f551288b);
        this.f551289c.notifyItemMoved(this.f551287a, this.f551288b);
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
}
