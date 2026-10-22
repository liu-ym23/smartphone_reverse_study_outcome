package com.bytedance.ee.bear.document.synced.block.references.doc;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.synced.block.references.entity.DocReferencesResult;
import com.bytedance.ee.bear.document.synced.block.references.entity.ReferencesParams;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final /* synthetic */ SyncedSourceReferencesViewModel a;

        public b(SyncedSourceReferencesViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            DocReferencesResult r11 = (DocReferencesResult) r10;
            tt5.a.h(SyncedSourceReferencesViewModel.TAG, "loadDocumentReference success " + r11);
            if (r11.getReferences() != null) goto L5;
            r11.setReferences(new ArrayList());
        L5:
            DocReferencesResult.Host r0 = r11.getHost();
            String r4 = null;
            if (r0 == null) goto L18;
            SyncedSourceReferencesViewModel r5 = this.a;
            if (TextUtils.isEmpty(r0.getUrl()) == true) goto L17;
            DocReferencesResult.References r6 = new DocReferencesResult.References();
            r6.setUrl(r0.getUrl());
            r6.setTitle(r0.getTitle());
            if (SyncedSourceReferencesViewModel.access$isCurrentDoc(r5, r0.getUrl()) == false) goto L12;
            String r7 = LarkContext.getApplication().getString(2131889295);
        L13:
            r6.setTagSecond(r7);
            r6.setPermitted(r0.getPermitted());
            ArrayList<DocReferencesResult.References> r1 = r11.getReferences();
            if (r1 == null) goto L16;
            ListProtector.add(r1, 0, r6);
        L16:
            tt5.a.h(SyncedSourceReferencesViewModel.TAG, "add hostRef done");
            goto L18
        L12:
            r7 = null;
            goto L13
        L17:
            tt5.a.k(SyncedSourceReferencesViewModel.TAG, "host url empty");
        L18:
            DocReferencesResult.Parent r2 = r11.getParent();
            if (r2 == null) goto L30;
            SyncedSourceReferencesViewModel r8 = this.a;
            if (TextUtils.isEmpty(r2.getUrl()) == true) goto L29;
            DocReferencesResult.References r9 = new DocReferencesResult.References();
            r9.setUrl(r2.getUrl());
            r9.setTitle(r2.getTitle());
            r9.setTagFirst(LarkContext.getApplication().getString(2131889299));
            if (SyncedSourceReferencesViewModel.access$isCurrentDoc(r8, r2.getUrl()) == false) goto L25;
            r4 = LarkContext.getApplication().getString(2131889295);
        L25:
            r9.setTagSecond(r4);
            r9.setPermitted(r2.getPermitted());
            ArrayList<DocReferencesResult.References> r3 = r11.getReferences();
            if (r3 == null) goto L28;
            ListProtector.add(r3, 0, r9);
        L28:
            tt5.a.h(SyncedSourceReferencesViewModel.TAG, "add parentRef done");
            goto L30
        L29:
            tt5.a.k(SyncedSourceReferencesViewModel.TAG, "parent url empty");
        L30:
            this.a.getLiveInitLoadData().setValue(r11);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ SyncedSourceReferencesViewModel a;

        public c(SyncedSourceReferencesViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.f(SyncedSourceReferencesViewModel.TAG, r4, false);
            this.a.getLiveInitError().setValue(r4);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ SyncedSourceReferencesViewModel a;

        public d(SyncedSourceReferencesViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            DocReferencesResult r4 = (DocReferencesResult) r3;
            tt5.a.h(SyncedSourceReferencesViewModel.TAG, "loadDocumentReferenceMore success " + r4);
            this.a.getLiveLoadMoreData().setValue(r4);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ SyncedSourceReferencesViewModel a;

        public e(SyncedSourceReferencesViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e(SyncedSourceReferencesViewModel.TAG, "loadDocumentReferenceMore error", r5, false);
            this.a.getLiveLoadMoreError().setValue(r5);
        }
    }

    static {
        Companion = new a();
    }

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

    private final boolean isCurrentDoc(String r6) {
        if (this.bearUrl != null) goto L5;
        return false;
    L5:
        if (r6 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        return false;
    L13:
        if (this.isSyncLink == true) goto L32;
        BearUrl r7 = this.spacekitUrlHelper.Z(r6);
        BearUrl r3 = this.bearUrl;
        String r4 = null;
        if (r3 == null) goto L18;
        String r5 = r3.a;
    L20:
        if (Intrinsics.areEqual(r5, r7.a) == false) goto L30;
        BearUrl r8 = this.bearUrl;
        if (r8 == null) goto L25;
        r4 = r8.b;
    L25:
        if (Intrinsics.areEqual(r4, r7.b) == false) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L18:
        r5 = null;
        goto L20
    L32:
        return false;
    L7:
        if (r6.length() == 0) goto L10;
        r2 = false;
        goto L11
    }

    public final void loadDocumentReference(ReferencesParams r10) {
        Intrinsics.checkNotNullParameter(r10, "param");
        this.param = r10;
        b45.a r1 = this.repository;
        boolean r2 = this.isSyncLink;
        String r4 = r10.getResourceToken();
        Integer r5 = r10.getResourceType();
        String r6 = r10.getDocxSyncedBlockHostToken();
        Integer r7 = r10.getDocxSyncedBlockHostType();
        Integer r11 = r10.getLimit();
        if (r11 == null) goto L5;
        int r8 = r11.intValue();
    L6:
        Disposable r12 = r1.a(r2, "", r4, r5, r6, r7, r8).subscribe(new b(this), new c(this));
        this.disposables.add(r12);
        return;
    L5:
        r8 = 20;
        goto L6
    }

    public final void loadDocumentReferenceMore(String r10) {
        Intrinsics.checkNotNullParameter(r10, "breakPoint");
        ReferencesParams r0 = this.param;
        if (r0 != null) goto L5;
        return;
    L5:
        b45.a r1 = this.repository;
        boolean r2 = this.isSyncLink;
        String r4 = r0.getResourceToken();
        Integer r5 = r0.getResourceType();
        String r6 = r0.getDocxSyncedBlockHostToken();
        Integer r7 = r0.getDocxSyncedBlockHostType();
        Integer r3 = r0.getLimit();
        if (r3 == null) goto L8;
        int r8 = r3.intValue();
    L9:
        Disposable r11 = r1.a(r2, r10, r4, r5, r6, r7, r8).subscribe(new d(this), new e(this));
        this.disposables.add(r11);
        return;
    L8:
        r8 = 20;
        goto L9
    }

    public final void setBearUrl(BearUrl r1) {
        this.bearUrl = r1;
    }

    public final void setNoPermissionCount(int r1) {
        this.noPermissionCount = r1;
    }

    public final void setParam(ReferencesParams r1) {
        this.param = r1;
    }

    public final void setSyncLink(boolean r1) {
        this.isSyncLink = r1;
    }

    @Inject
    public SyncedSourceReferencesViewModel(NetService r2, t45.c r3) {
        Intrinsics.checkNotNullParameter(r2, "userNetService");
        Intrinsics.checkNotNullParameter(r3, "spacekitUrlHelper");
        this.userNetService = r2;
        this.spacekitUrlHelper = r3;
        this.repository = new b45.a(r2);
        this.disposables = new CompositeDisposable();
        this.liveInitLoadData = new MutableLiveData();
        this.liveLoadMoreData = new MutableLiveData();
        this.liveInitError = new MutableLiveData();
        this.liveLoadMoreError = new MutableLiveData();
    }

    public static final /* synthetic */ boolean access$isCurrentDoc(SyncedSourceReferencesViewModel r0, String r1) {
        return r0.isCurrentDoc(r1);
    }
}
