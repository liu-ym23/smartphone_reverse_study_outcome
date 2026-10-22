package n3c;

import com.google.gson.JsonObject;
import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import com.ss.android.lark.security.compliance.infra.network.manager.RequestManager;
import com.ss.android.lark.security.compliance.infra.network.service.NetworkErrorResultException;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.g f517021a;

    public static final class a implements com.ss.android.lark.security.compliance.infra.network.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f517022a;

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final Type b() {
            return JsonObject.class;
        }

        public a(ObservableEmitter r100) {
            this.f517022a = r100;
        }

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final void a(NetworkErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, "networkErrorResult");
            if (this.f517022a.isDisposed() == true) goto L6;
            this.f517022a.onError(new NetworkErrorResultException(r100));
            return;
        }

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final void c(com.ss.android.lark.security.compliance.infra.network.h<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            if (this.f517022a.isDisposed() == true) goto L6;
            this.f517022a.onNext(r100);
            this.f517022a.onComplete();
            return;
        }
    }

    public g(com.ss.android.lark.security.compliance.infra.network.a r100) {
        this.f517021a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<com.ss.android.lark.security.compliance.infra.network.h<T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        com.ss.android.lark.security.compliance.infra.network.f r101 = RequestManager.f440449a;
        RequestManager.a(this.f517021a, new a(r100));
    }
}
