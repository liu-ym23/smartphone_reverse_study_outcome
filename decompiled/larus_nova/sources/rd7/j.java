package rd7;

import android.content.ContentResolver;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes22.dex */
public final class j<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f537314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentResolver f537315b;

    public j(a.b r100, ContentResolver r101) {
        this.f537314a = r100;
        this.f537315b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final CalendarErrorCode call() {
        int r100 = com.bytedance.sdk.xbridge.cn.calendar.reducer.d.f269862a;
        return com.bytedance.sdk.xbridge.cn.calendar.reducer.d.c(this.f537314a, this.f537315b);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
