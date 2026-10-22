package rd7;

import android.content.ContentResolver;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes22.dex */
public final class d<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f537299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentResolver f537300b;

    public d(a.b r100, ContentResolver r101) {
        this.f537299a = r100;
        this.f537300b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final CalendarErrorCode call() {
        int r100 = com.bytedance.sdk.xbridge.cn.calendar.reducer.a.f269859a;
        return com.bytedance.sdk.xbridge.cn.calendar.reducer.a.c(this.f537299a, this.f537300b);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
