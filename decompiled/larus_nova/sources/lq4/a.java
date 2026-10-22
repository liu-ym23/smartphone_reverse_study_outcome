package lq4;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.view.stage.step.StageDataStepAdapter;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StageDataStepAdapter f510296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f510297b;

    public a(StageDataStepAdapter r100, int r101) {
        this.f510296a = r100;
        this.f510297b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f510296a.f208764a.h(this.f510297b);
    }
}
