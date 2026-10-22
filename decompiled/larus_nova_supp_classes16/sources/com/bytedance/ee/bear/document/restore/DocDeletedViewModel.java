package com.bytedance.ee.bear.document.restore;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.restore.api.RestoreFileResult;
import com.bytedance.ee.bear.domain.BearUrl;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013J\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0013J\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011J\b\u0010\u001d\u001a\u00020\u0011H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/restore/DocDeletedViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "url", "", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "canRestore", "Landroidx/lifecycle/MutableLiveData;", "", "restore", "Lcom/bytedance/ee/util/Result;", "Lcom/bytedance/ee/bear/document/restore/api/RestoreFileResult;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "init", "", "getCanRestore", "Landroidx/lifecycle/LiveData;", "getRestore", "restoreApi", "Lcom/bytedance/ee/bear/document/restore/api/RestoreApi;", "getRestoreApi", "()Lcom/bytedance/ee/bear/document/restore/api/RestoreApi;", "restoreApi$delegate", "Lkotlin/Lazy;", "checkFileCanRestore", "restoreFile", "onCleared", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocDeletedViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DocDeletedViewModel";
    private BearUrl bearUrl;
    private final MutableLiveData<Boolean> canRestore;
    private final CompositeDisposable disposable;
    private final MutableLiveData<cu5.b<RestoreFileResult>> restore;
    private final Lazy restoreApi$delegate;
    private String url;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DocDeletedViewModel a;

        public b(DocDeletedViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData r0 = DocDeletedViewModel.access$getCanRestore$p(this.a);
            r0.setValue((Boolean) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DocDeletedViewModel a;

        public c(DocDeletedViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e(DocDeletedViewModel.TAG, "checkFileCanRestore err. ", (Throwable) r4, false);
            DocDeletedViewModel.access$getCanRestore$p(this.a).setValue(Boolean.FALSE);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ DocDeletedViewModel a;

        public d(DocDeletedViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            wwc.c r4 = (wwc.c) r3;
            DocDeletedViewModel.access$getRestore$p(this.a).setValue(new cu5.b.b(null));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ DocDeletedViewModel a;

        public e(DocDeletedViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            RestoreFileResult r7 = (RestoreFileResult) r6;
            MutableLiveData r0 = DocDeletedViewModel.access$getRestore$p(this.a);
            if (r7.isSuccess() == false) goto L5;
            tt5.a.h(DocDeletedViewModel.TAG, "restoreFile success. ");
            cu5.b.c r1 = new cu5.b.c(r7);
        L9:
            r0.setValue(r1);
            return;
        L5:
            Throwable r2 = r7.exception;
            if (r2 != null) goto L8;
            r2 = new Throwable();
        L8:
            tt5.a.e(DocDeletedViewModel.TAG, "restoreFile server fail. ", r2, false);
            r1 = new cu5.b.a(r2, r7);
            goto L9
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ DocDeletedViewModel a;

        public f(DocDeletedViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e(DocDeletedViewModel.TAG, "restoreFile err. ", r5, false);
            MutableLiveData r0 = DocDeletedViewModel.access$getRestore$p(this.a);
            Intrinsics.checkNotNull(r5);
            r0.setValue(new cu5.b.a(r5, null));
        }
    }

    static {
        Companion = new a();
    }

    private final com.bytedance.ee.bear.document.restore.api.a getRestoreApi() {
        return (com.bytedance.ee.bear.document.restore.api.a) this.restoreApi$delegate.getValue();
    }

    public final void checkFileCanRestore() {
        BearUrl r0 = this.bearUrl;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L7:
        if (TextUtils.equals(r2, sbb.e.y.getType()) == false) goto L9;
        return;
    L9:
        com.bytedance.ee.bear.document.restore.api.a r3 = getRestoreApi();
        if (r3 != null) goto L12;
        return;
    L12:
        StringBuilder r4 = new StringBuilder("checkFileCanRestore. docToken: ");
        BearUrl r5 = this.bearUrl;
        if (r5 == null) goto L15;
        r1 = r5.b;
    L15:
        r4.append(du5.b.g(r1));
        tt5.a.h(TAG, r4.toString());
        this.disposable.add(r3.a().subscribe(new b(this), new c(this)));
        return;
    L5:
        r2 = null;
        goto L7
    }

    public DocDeletedViewModel() {
        this.canRestore = new MutableLiveData();
        this.restore = new MutableLiveData();
        this.disposable = new CompositeDisposable();
        this.restoreApi$delegate = LazyKt.lazy(new DocDeletedViewModel$restoreApi$2(this));
    }

    public void onCleared() {
        super.onCleared();
        this.disposable.clear();
    }

    public final void restoreFile() {
        com.bytedance.ee.bear.document.restore.api.a r0 = getRestoreApi();
        if (r0 != null) goto L5;
        return;
    L5:
        StringBuilder r1 = new StringBuilder("restoreFile. docToken: ");
        BearUrl r2 = this.bearUrl;
        if (r2 == null) goto L8;
        String r3 = r2.b;
    L9:
        r1.append(du5.b.g(r3));
        tt5.a.h(TAG, r1.toString());
        this.disposable.add(r0.b().doOnSubscribe(new d(this)).subscribe(new e(this), new f(this)));
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final LiveData<Boolean> getCanRestore() {
        return this.canRestore;
    }

    public final LiveData<cu5.b<RestoreFileResult>> getRestore() {
        return this.restore;
    }

    public static final /* synthetic */ BearUrl access$getBearUrl$p(DocDeletedViewModel r0) {
        return r0.bearUrl;
    }

    public static final /* synthetic */ MutableLiveData access$getCanRestore$p(DocDeletedViewModel r0) {
        return r0.canRestore;
    }

    public static final /* synthetic */ MutableLiveData access$getRestore$p(DocDeletedViewModel r0) {
        return r0.restore;
    }

    public final void init(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.url = r2;
        this.bearUrl = p.a().Z(r2);
    }
}
