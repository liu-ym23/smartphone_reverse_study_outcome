package n8b;

import com.ss.android.lark.conditional.access.network.model.response.BindDeviceWebData;
import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import com.ss.android.lark.security.compliance.infra.network.service.NetworkErrorResultException;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.userscpoe.a f518371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.g f518372b;

    public static final class a implements com.ss.android.lark.security.compliance.infra.network.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f518373a;

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final Type b() {
            return BindDeviceWebData.class;
        }

        public a(ObservableEmitter r100) {
            this.f518373a = r100;
        }

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final void a(NetworkErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, "networkErrorResult");
            if (this.f518373a.isDisposed() == true) goto L6;
            this.f518373a.onError(new NetworkErrorResultException(r100));
            return;
        }

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final void c(com.ss.android.lark.security.compliance.infra.network.h<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            if (this.f518373a.isDisposed() == true) goto L6;
            this.f518373a.onNext(r100);
            this.f518373a.onComplete();
            return;
        }
    }

    public c(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r100, com.ss.android.lark.security.compliance.infra.network.a r101) {
        this.f518371a = r100;
        this.f518372b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<com.ss.android.lark.security.compliance.infra.network.h<T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f518371a.a(this.f518372b, new a(r100));
    }
}
