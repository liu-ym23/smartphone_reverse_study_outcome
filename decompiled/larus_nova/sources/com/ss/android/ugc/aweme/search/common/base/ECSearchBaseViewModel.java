package com.ss.android.ugc.aweme.search.common.base;

import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import com.ss.android.ugc.aweme.search.common.utils.DisposableScope;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\t\u0010\u0005\u001a\u00020\u0003H\u0096\u0001R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/base/ECSearchBaseViewModel;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "", "", "onCleared", "clearDisposable", "Lcom/ss/android/ugc/aweme/search/common/utils/DisposableScope;", "disposableContext", "Lcom/ss/android/ugc/aweme/search/common/utils/DisposableScope;", "<init>", "(Lcom/ss/android/ugc/aweme/search/common/utils/DisposableScope;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECSearchBaseViewModel extends QViewModel {
    private final DisposableScope disposableContext;

    /* JADX WARN: Multi-variable type inference failed */
    public ECSearchBaseViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public void clearDisposable() {
        ((CompositeDisposable) this.disposableContext.f452250a.getValue()).clear();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        clearDisposable();
    }

    public ECSearchBaseViewModel(DisposableScope r100) {
        Intrinsics.checkNotNullParameter(r100, "disposableContext");
        this.disposableContext = r100;
    }

    public /* synthetic */ ECSearchBaseViewModel(DisposableScope r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new DisposableScope();
    L5:
        this(r100);
    }
}
