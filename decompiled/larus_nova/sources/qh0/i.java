package qh0;

import android.app.Activity;
import com.bytedance.android.live.liveinteract.utils.e0;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes46.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f532924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f532925b;

    public i(Activity r100, h r101) {
        this.f532924a = r100;
        this.f532925b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        SimpleDateFormat r102 = e0.f78759a;
        Activity r103 = this.f532924a;
        if (this.f532925b.f532920c != 1) goto L5;
        String r104 = "video_live_link";
    L6:
        e0.c(r103, r101, r104);
        return;
    L5:
        r104 = "radio_live_link";
        goto L6
    }
}
