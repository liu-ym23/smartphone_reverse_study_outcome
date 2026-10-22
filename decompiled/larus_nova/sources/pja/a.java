package pja;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AlphaVideoViewType f529528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f529529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f529530c;

    public final Context getContext() {
        return this.f529529b;
    }

    public a(Context r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        this.f529529b = r100;
        this.f529530c = r101;
        this.f529528a = AlphaVideoViewType.GL_SURFACE_VIEW;
    }
}
