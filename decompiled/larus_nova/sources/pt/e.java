package pt;

import com.bytedance.android.gamecp.base.network.exception.ApiServerException;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.ss.alog.middleware.ALogService;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f530625a;

    public e(Function0 r100) {
        this.f530625a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Function0 r102 = this.f530625a;
        if (r102 == null) goto L5;
        Unit r103 = (Unit) r102.invoke();
    L5:
        if (r101 == null) goto L10;
        int r104 = a.f530616a;
        if ((r101 instanceof ApiServerException) == false) goto L9;
        ToastUtil.b(((ApiServerException) r101).getPrompt(), 0);
    L9:
        ALogService.statcktraceSafely(6, "ImageXUtil", r101.getStackTrace());
    L10:
        hv.b r105 = hv.d.f487273a;
    }
}
