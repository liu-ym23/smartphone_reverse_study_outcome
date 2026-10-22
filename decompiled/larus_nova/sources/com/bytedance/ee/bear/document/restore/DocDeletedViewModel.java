package com.bytedance.ee.bear.document.restore;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.restore.api.RestoreFileResult;
import com.bytedance.ee.bear.domain.BearUrl;
import com.lynx.serval.svg.SVGRenderEngine;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013J\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0013J\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011J\b\u0010\u001d\u001a\u00020\u0011H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/restore/DocDeletedViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "url", "", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "canRestore", "Landroidx/lifecycle/MutableLiveData;", "", SVGRenderEngine.RESTORE, "Lcom/bytedance/ee/util/Result;", "Lcom/bytedance/ee/bear/document/restore/api/RestoreFileResult;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "init", "", "getCanRestore", "Landroidx/lifecycle/LiveData;", "getRestore", "restoreApi", "Lcom/bytedance/ee/bear/document/restore/api/RestoreApi;", "getRestoreApi", "()Lcom/bytedance/ee/bear/document/restore/api/RestoreApi;", "restoreApi$delegate", "Lkotlin/Lazy;", "checkFileCanRestore", "restoreFile", "onCleared", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocDeletedViewModel f221440a;

        public b(DocDeletedViewModel r100) {
            this.f221440a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MutableLiveData r101 = DocDeletedViewModel.access$getCanRestore$p(this.f221440a);
            r101.setValue((Boolean) r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocDeletedViewModel f221441a;

        public c(DocDeletedViewModel r100) {
            this.f221441a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e(DocDeletedViewModel.TAG, "checkFileCanRestore err. ", (Throwable) r100, false);
            DocDeletedViewModel.access$getCanRestore$p(this.f221441a).setValue(Boolean.FALSE);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocDeletedViewModel f221442a;

        public d(DocDeletedViewModel r100) {
            this.f221442a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            wwc.c r101 = (wwc.c) r100;
            DocDeletedViewModel.access$getRestore$p(this.f221442a).setValue(new cu5.b.C5590b(null));
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocDeletedViewModel f221443a;

        public e(DocDeletedViewModel r100) {
            this.f221443a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            RestoreFileResult r101 = (RestoreFileResult) r100;
            MutableLiveData r102 = DocDeletedViewModel.access$getRestore$p(this.f221443a);
            if (r101.isSuccess() == false) goto L5;
            tt5.a.h(DocDeletedViewModel.TAG, "restoreFile success. ");
            Object r103 = new cu5.b.c(r101);
        L9:
            r102.setValue(r103);
            return;
        L5:
            Throwable r104 = r101.exception;
            if (r104 != null) goto L8;
            r104 = new Throwable();
        L8:
            tt5.a.e(DocDeletedViewModel.TAG, "restoreFile server fail. ", r104, false);
            r103 = new cu5.b.a(r104, r101);
            goto L9
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocDeletedViewModel f221444a;

        public f(DocDeletedViewModel r100) {
            this.f221444a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e(DocDeletedViewModel.TAG, "restoreFile err. ", r101, false);
            MutableLiveData r102 = DocDeletedViewModel.access$getRestore$p(this.f221444a);
            Intrinsics.checkNotNull(r101);
            r102.setValue(new cu5.b.a(r101, null));
        }
    }

    static {
        Companion = new a();
    }

    private final com.bytedance.ee.bear.document.restore.api.a getRestoreApi() {
        return (com.bytedance.ee.bear.document.restore.api.a) this.restoreApi$delegate.getValue();
    }

    public final void checkFileCanRestore() {
        BearUrl r100 = this.bearUrl;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f222560a;
    L7:
        if (TextUtils.equals(r102, sbb.e.f541314y.getType()) == false) goto L9;
        return;
    L9:
        com.bytedance.ee.bear.document.restore.api.a r103 = getRestoreApi();
        if (r103 != null) goto L12;
        return;
    L12:
        StringBuilder r104 = new StringBuilder("checkFileCanRestore. docToken: ");
        BearUrl r105 = this.bearUrl;
        if (r105 == null) goto L15;
        r101 = r105.f222561b;
    L15:
        r104.append(du5.b.g(r101));
        tt5.a.h(TAG, r104.toString());
        this.disposable.add(r103.a().subscribe(new b(this), new c(this)));
        return;
    L5:
        r102 = null;
        goto L7
    }

    public DocDeletedViewModel() {
        this.canRestore = new MutableLiveData();
        this.restore = new MutableLiveData();
        this.disposable = new CompositeDisposable();
        this.restoreApi$delegate = LazyKt.lazy(new DocDeletedViewModel$restoreApi$2(this));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.disposable.clear();
    }

    public final void restoreFile() {
        com.bytedance.ee.bear.document.restore.api.a r100 = getRestoreApi();
        if (r100 != null) goto L5;
        return;
    L5:
        StringBuilder r101 = new StringBuilder("restoreFile. docToken: ");
        BearUrl r102 = this.bearUrl;
        if (r102 == null) goto L8;
        String r103 = r102.f222561b;
    L9:
        r101.append(du5.b.g(r103));
        tt5.a.h(TAG, r101.toString());
        this.disposable.add(r100.b().doOnSubscribe(new d(this)).subscribe(new e(this), new f(this)));
        return;
    L8:
        r103 = null;
        goto L9
    }

    public final LiveData<Boolean> getCanRestore() {
        return this.canRestore;
    }

    public final LiveData<cu5.b<RestoreFileResult>> getRestore() {
        return this.restore;
    }

    public static final /* synthetic */ BearUrl access$getBearUrl$p(DocDeletedViewModel r100) {
        return r100.bearUrl;
    }

    public static final /* synthetic */ MutableLiveData access$getCanRestore$p(DocDeletedViewModel r100) {
        return r100.canRestore;
    }

    public static final /* synthetic */ MutableLiveData access$getRestore$p(DocDeletedViewModel r100) {
        return r100.restore;
    }

    public final void init(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.url = r100;
        this.bearUrl = p.a().Z(r100);
    }
}
