package qr1;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f534516a;

    public b(i r100) {
        this.f534516a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = Boolean.TRUE;
        if (r101.equals((Boolean) r100) == false) goto L9;
        this.f534516a.c(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "first frame ready"));
        this.f534516a.d("point_finish_first_frame_time", String.valueOf(System.currentTimeMillis()));
        this.f534516a.a("player_status", "success");
        long r102 = this.f534516a.f();
        if (r102 <= 0) goto L7;
        this.f534516a.e("start_to_first_frame_cost", System.currentTimeMillis() - r102);
    L7:
        i r103 = this.f534516a;
        r103.f534528f.f534542c = true;
        r103.h(0, "");
        return;
    }
}
