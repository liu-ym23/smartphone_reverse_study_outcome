package qw2;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f534968a;

    public b(d r100) {
        this.f534968a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f534968a.a(1.0f);
        this.f534968a.f534979i.a(1.0f);
        ALogger.i("ZoomHelper", "ratio:1.0");
    }
}
