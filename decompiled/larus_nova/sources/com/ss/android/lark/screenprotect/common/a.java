package com.ss.android.lark.screenprotect.common;

import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import com.ss.android.lark.security.compliance.infra.network.g;
import com.ss.android.lark.security.compliance.infra.network.h;
import com.ss.android.lark.security.compliance.infra.network.service.NetworkErrorResultException;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.userscpoe.a f439779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f439780b;

    /* JADX INFO: renamed from: com.ss.android.lark.screenprotect.common.a$a, reason: collision with other inner class name */
    public static final class C5280a implements com.ss.android.lark.security.compliance.infra.network.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f439781a;

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final Type b() {
            return com.ss.android.lark.security.compliance.infra.network.a.class;
        }

        public C5280a(ObservableEmitter r100) {
            this.f439781a = r100;
        }

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final void a(NetworkErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, "networkErrorResult");
            if (this.f439781a.isDisposed() == true) goto L6;
            this.f439781a.onError(new NetworkErrorResultException(r100));
            return;
        }

        @Override // com.ss.android.lark.security.compliance.infra.network.d
        public final void c(h<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            if (this.f439781a.isDisposed() == true) goto L6;
            this.f439781a.onNext(r100);
            this.f439781a.onComplete();
            return;
        }
    }

    public a(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r100, com.ss.android.lark.security.compliance.infra.network.a r101) {
        this.f439779a = r100;
        this.f439780b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<h<T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f439779a.a(this.f439780b, new C5280a(r100));
    }
}
