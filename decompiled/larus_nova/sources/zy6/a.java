package zy6;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<FragmentActivity> f573945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PoiBundle f573946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PoiDetail f573947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f573948d;

    public final FragmentActivity getActivity() {
        return this.f573945a.get();
    }

    public a(WeakReference<FragmentActivity> r100, PoiBundle r101, PoiDetail r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "activityWr");
        this.f573945a = r100;
        this.f573946b = r101;
        this.f573947c = r102;
    }
}
