package yi1;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f567891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f567892b;

    public k(j r100, long r101) {
        this.f567891a = r100;
        this.f567892b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        BaseResponse r111 = (BaseResponse) r110;
        long r100 = System.currentTimeMillis() - this.f567892b;
        j.b(this.f567891a, 3, 0, "audience_exit_jump", r100);
    }
}
