package d40;

import com.bytedance.apm.constant.UploadTypeInf;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f466803a;

    public b(a.b r100) {
        this.f466803a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        a.b r102 = this.f466803a;
        r102.f466800a.a(r102.f466801b, r102.f466802c, UploadTypeInf.TIMER);
    }
}
