package z21;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IRoom f569770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Unit> f569771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public mx0.a f569772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Unit> f569773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f569774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f569775f;

    public final Context getContext() {
        return this.f569774e;
    }

    public a(Context r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        this.f569774e = r100;
        this.f569775f = r101;
        this.f569771b = new MutableLiveData();
        this.f569773d = new MutableLiveData();
    }
}
