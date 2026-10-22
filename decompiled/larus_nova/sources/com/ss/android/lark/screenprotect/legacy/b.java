package com.ss.android.lark.screenprotect.legacy;

import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import com.ss.android.lark.security.compliance.infra.network.g;
import com.ss.android.lark.security.compliance.infra.network.h;
import com.ss.android.lark.security.compliance.infra.network.manager.RequestManager;
import com.ss.android.lark.security.compliance.infra.network.service.NetworkErrorResultException;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f439790a;

    public static final class a implements com.ss.android.lark.security.compliance.infra.network.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f439791a;

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final Type b() {
            return com.ss.android.lark.security.compliance.infra.network.a.class;
        }

        public a(ObservableEmitter r100) {
            this.f439791a = r100;
        }

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final void a(NetworkErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, "networkErrorResult");
            if (this.f439791a.isDisposed() == true) goto L6;
            this.f439791a.onError(new NetworkErrorResultException(r100));
            return;
        }

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final void c(h<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            if (this.f439791a.isDisposed() == true) goto L6;
            this.f439791a.onNext(r100);
            this.f439791a.onComplete();
            return;
        }
    }

    public b(com.ss.android.lark.security.compliance.infra.network.a r100) {
        this.f439790a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<h<T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        com.ss.android.lark.security.compliance.infra.network.f r101 = RequestManager.f440449a;
        RequestManager.a(this.f439790a, new a(r100));
    }
}
