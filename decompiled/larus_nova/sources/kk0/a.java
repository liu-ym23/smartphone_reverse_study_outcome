package kk0;

import android.content.Context;
import android.graphics.PointF;
import android.view.ViewGroup;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f503737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f503738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f503739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f503740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC6565a f503741e;

    /* JADX INFO: renamed from: kk0.a$a, reason: collision with other inner class name */
    public interface InterfaceC6565a {
        PointF x(String r100);
    }

    public a(Context r100, DataCenter r101, ViewGroup r102, HSImageView r103, InterfaceC6565a r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "callback");
        this.f503737a = r100;
        this.f503738b = r101;
        this.f503739c = r102;
        this.f503740d = r103;
        this.f503741e = r104;
    }
}
