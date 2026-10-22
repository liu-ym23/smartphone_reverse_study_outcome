package com.bytedance.ee.bear.document.synced.block.references.doc;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.synced.block.references.entity.DocReferencesResult;
import com.bytedance.ee.bear.document.synced.block.references.entity.ReferencesParams;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u00103\u001a\u0002042\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u000e\u00108\u001a\u0002042\u0006\u00109\u001a\u000207J\b\u0010:\u001a\u000204H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006<"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceReferencesViewModel;", "Landroidx/lifecycle/ViewModel;", "userNetService", "Lcom/bytedance/ee/bear/contract/NetService;", "spacekitUrlHelper", "Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;", "<init>", "(Lcom/bytedance/ee/bear/contract/NetService;Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;)V", "getUserNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "getSpacekitUrlHelper", "()Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;", "repository", "Lcom/bytedance/ee/bear/document/synced/block/references/repository/SyncedSourceReferencesRepository;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "liveInitLoadData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult;", "getLiveInitLoadData", "()Landroidx/lifecycle/MutableLiveData;", "liveLoadMoreData", "getLiveLoadMoreData", "liveInitError", "", "getLiveInitError", "liveLoadMoreError", "getLiveLoadMoreError", "param", "Lcom/bytedance/ee/bear/document/synced/block/references/entity/ReferencesParams;", "getParam", "()Lcom/bytedance/ee/bear/document/synced/block/references/entity/ReferencesParams;", "setParam", "(Lcom/bytedance/ee/bear/document/synced/block/references/entity/ReferencesParams;)V", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "getBearUrl", "()Lcom/bytedance/ee/bear/domain/BearUrl;", "setBearUrl", "(Lcom/bytedance/ee/bear/domain/BearUrl;)V", "isSyncLink", "", "()Z", "setSyncLink", "(Z)V", "noPermissionCount", "", "getNoPermissionCount", "()I", "setNoPermissionCount", "(I)V", "loadDocumentReference", "", "isCurrentDoc", "url", "", "loadDocumentReferenceMore", "breakPoint", "onCleared", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncedSourceReferencesViewModel extends ViewModel {
    public static final a Companion = null;
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final String TAG = "SyncedSourceReferencesViewModel";
    private BearUrl bearUrl;
    private final CompositeDisposable disposables;
    private boolean isSyncLink;
    private final MutableLiveData<Throwable> liveInitError;
    private final MutableLiveData<DocReferencesResult> liveInitLoadData;
    private final MutableLiveData<DocReferencesResult> liveLoadMoreData;
    private final MutableLiveData<Throwable> liveLoadMoreError;
    private int noPermissionCount;
    private ReferencesParams param;
    private final b45.a repository;
    private final t45.c spacekitUrlHelper;
    private final NetService userNetService;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncedSourceReferencesViewModel f221946a;

        public b(SyncedSourceReferencesViewModel r100) {
            this.f221946a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            DocReferencesResult r111 = (DocReferencesResult) r110;
            tt5.a.h(SyncedSourceReferencesViewModel.TAG, "loadDocumentReference success " + r111);
            if (r111.getReferences() != null) goto L5;
            r111.setReferences(new ArrayList());
        L5:
            DocReferencesResult.Host r100 = r111.getHost();
            String r101 = null;
            if (r100 == null) goto L18;
            SyncedSourceReferencesViewModel r102 = this.f221946a;
            if (TextUtils.isEmpty(r100.getUrl()) == true) goto L17;
            DocReferencesResult.References r103 = new DocReferencesResult.References();
            r103.setUrl(r100.getUrl());
            r103.setTitle(r100.getTitle());
            if (SyncedSourceReferencesViewModel.access$isCurrentDoc(r102, r100.getUrl()) == false) goto L12;
            String r104 = LarkContext.getApplication().getString(R.string.LarkCCM_Docs_SyncBlock_Current_Tag);
        L13:
            r103.setTagSecond(r104);
            r103.setPermitted(r100.getPermitted());
            ArrayList<DocReferencesResult.References> r105 = r111.getReferences();
            if (r105 == null) goto L16;
            ListProtector.add(r105, 0, r103);
        L16:
            tt5.a.h(SyncedSourceReferencesViewModel.TAG, "add hostRef done");
            goto L18
        L12:
            r104 = null;
            goto L13
        L17:
            tt5.a.k(SyncedSourceReferencesViewModel.TAG, "host url empty");
        L18:
            DocReferencesResult.Parent r106 = r111.getParent();
            if (r106 == null) goto L30;
            SyncedSourceReferencesViewModel r107 = this.f221946a;
            if (TextUtils.isEmpty(r106.getUrl()) == true) goto L29;
            DocReferencesResult.References r108 = new DocReferencesResult.References();
            r108.setUrl(r106.getUrl());
            r108.setTitle(r106.getTitle());
            r108.setTagFirst(LarkContext.getApplication().getString(R.string.LarkCCM_Docs_SyncBlock_Origin_Tag));
            if (SyncedSourceReferencesViewModel.access$isCurrentDoc(r107, r106.getUrl()) == false) goto L25;
            r101 = LarkContext.getApplication().getString(R.string.LarkCCM_Docs_SyncBlock_Current_Tag);
        L25:
            r108.setTagSecond(r101);
            r108.setPermitted(r106.getPermitted());
            ArrayList<DocReferencesResult.References> r109 = r111.getReferences();
            if (r109 == null) goto L28;
            ListProtector.add(r109, 0, r108);
        L28:
            tt5.a.h(SyncedSourceReferencesViewModel.TAG, "add parentRef done");
            goto L30
        L29:
            tt5.a.k(SyncedSourceReferencesViewModel.TAG, "parent url empty");
        L30:
            this.f221946a.getLiveInitLoadData().setValue(r111);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncedSourceReferencesViewModel f221947a;

        public c(SyncedSourceReferencesViewModel r100) {
            this.f221947a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.f(SyncedSourceReferencesViewModel.TAG, r101, false);
            this.f221947a.getLiveInitError().setValue(r101);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncedSourceReferencesViewModel f221948a;

        public d(SyncedSourceReferencesViewModel r100) {
            this.f221948a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DocReferencesResult r101 = (DocReferencesResult) r100;
            tt5.a.h(SyncedSourceReferencesViewModel.TAG, "loadDocumentReferenceMore success " + r101);
            this.f221948a.getLiveLoadMoreData().setValue(r101);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncedSourceReferencesViewModel f221949a;

        public e(SyncedSourceReferencesViewModel r100) {
            this.f221949a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e(SyncedSourceReferencesViewModel.TAG, "loadDocumentReferenceMore error", r101, false);
            this.f221949a.getLiveLoadMoreError().setValue(r101);
        }
    }

    static {
        Companion = new a();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.disposables.clear();
    }

    public final BearUrl getBearUrl() {
        return this.bearUrl;
    }

    public final MutableLiveData<Throwable> getLiveInitError() {
        return this.liveInitError;
    }

    public final MutableLiveData<DocReferencesResult> getLiveInitLoadData() {
        return this.liveInitLoadData;
    }

    public final MutableLiveData<DocReferencesResult> getLiveLoadMoreData() {
        return this.liveLoadMoreData;
    }

    public final MutableLiveData<Throwable> getLiveLoadMoreError() {
        return this.liveLoadMoreError;
    }

    public final int getNoPermissionCount() {
        return this.noPermissionCount;
    }

    public final ReferencesParams getParam() {
        return this.param;
    }

    public final t45.c getSpacekitUrlHelper() {
        return this.spacekitUrlHelper;
    }

    public final NetService getUserNetService() {
        return this.userNetService;
    }

    public final boolean isSyncLink() {
        return this.isSyncLink;
    }

    private final boolean isCurrentDoc(String r100) {
        if (this.bearUrl != null) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L13;
        return false;
    L13:
        if (this.isSyncLink == true) goto L32;
        BearUrl r102 = this.spacekitUrlHelper.Z(r100);
        BearUrl r103 = this.bearUrl;
        String r104 = null;
        if (r103 == null) goto L18;
        String r105 = r103.f222560a;
    L20:
        if (Intrinsics.areEqual(r105, r102.f222560a) == false) goto L30;
        BearUrl r106 = this.bearUrl;
        if (r106 == null) goto L25;
        r104 = r106.f222561b;
    L25:
        if (Intrinsics.areEqual(r104, r102.f222561b) == false) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L18:
        r105 = null;
        goto L20
    L32:
        return false;
    L7:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    }

    public final void loadDocumentReference(ReferencesParams r110) {
        Intrinsics.checkNotNullParameter(r110, "param");
        this.param = r110;
        b45.a r100 = this.repository;
        boolean r101 = this.isSyncLink;
        String r102 = r110.getResourceToken();
        Integer r103 = r110.getResourceType();
        String r104 = r110.getDocxSyncedBlockHostToken();
        Integer r105 = r110.getDocxSyncedBlockHostType();
        Integer r111 = r110.getLimit();
        if (r111 == null) goto L5;
        int r106 = r111.intValue();
    L6:
        Disposable r112 = r100.a(r101, "", r102, r103, r104, r105, r106).subscribe(new b(this), new c(this));
        this.disposables.add(r112);
        return;
    L5:
        r106 = 20;
        goto L6
    }

    public final void loadDocumentReferenceMore(String r110) {
        Intrinsics.checkNotNullParameter(r110, "breakPoint");
        ReferencesParams r100 = this.param;
        if (r100 != null) goto L5;
        return;
    L5:
        b45.a r101 = this.repository;
        boolean r102 = this.isSyncLink;
        String r103 = r100.getResourceToken();
        Integer r104 = r100.getResourceType();
        String r105 = r100.getDocxSyncedBlockHostToken();
        Integer r106 = r100.getDocxSyncedBlockHostType();
        Integer r107 = r100.getLimit();
        if (r107 == null) goto L8;
        int r108 = r107.intValue();
    L9:
        Disposable r111 = r101.a(r102, r110, r103, r104, r105, r106, r108).subscribe(new d(this), new e(this));
        this.disposables.add(r111);
        return;
    L8:
        r108 = 20;
        goto L9
    }

    public final void setBearUrl(BearUrl r100) {
        this.bearUrl = r100;
    }

    public final void setNoPermissionCount(int r100) {
        this.noPermissionCount = r100;
    }

    public final void setParam(ReferencesParams r100) {
        this.param = r100;
    }

    public final void setSyncLink(boolean r100) {
        this.isSyncLink = r100;
    }

    @Inject
    public SyncedSourceReferencesViewModel(NetService r100, t45.c r101) {
        Intrinsics.checkNotNullParameter(r100, "userNetService");
        Intrinsics.checkNotNullParameter(r101, "spacekitUrlHelper");
        this.userNetService = r100;
        this.spacekitUrlHelper = r101;
        this.repository = new b45.a(r100);
        this.disposables = new CompositeDisposable();
        this.liveInitLoadData = new MutableLiveData();
        this.liveLoadMoreData = new MutableLiveData();
        this.liveInitError = new MutableLiveData();
        this.liveLoadMoreError = new MutableLiveData();
    }

    public static final /* synthetic */ boolean access$isCurrentDoc(SyncedSourceReferencesViewModel r100, String r101) {
        return r100.isCurrentDoc(r101);
    }
}
