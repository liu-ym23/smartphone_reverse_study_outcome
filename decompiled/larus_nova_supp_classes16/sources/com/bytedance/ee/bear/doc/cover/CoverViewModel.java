package com.bytedance.ee.bear.doc.cover;

import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.doc.cover.selectcover.local.LocalImageItem;
import com.bytedance.ee.bear.doc.cover.selectcover.official.OfficialCoverData;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u000256B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010#J\u0016\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(J&\u0010)\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0006\u0010-\u001a\u00020\u001fJ\u0010\u0010.\u001a\u00020#2\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0006J\u001e\u00101\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u00102\u001a\u00020!2\u0006\u0010+\u001a\u00020,J\b\u00103\u001a\u00020\u001fH\u0014J\u0006\u00104\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/CoverViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "selectCoverActive", "Landroidx/lifecycle/MutableLiveData;", "", "getSelectCoverActive", "()Landroidx/lifecycle/MutableLiveData;", "delegate", "Lcom/bytedance/ee/bear/doc/cover/CoverViewModel$Delegate;", "getDelegate", "()Lcom/bytedance/ee/bear/doc/cover/CoverViewModel$Delegate;", "setDelegate", "(Lcom/bytedance/ee/bear/doc/cover/CoverViewModel$Delegate;)V", "coverSeriesList", "", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$CoverSeries;", "getCoverSeriesList", "currentCoverData", "Lcom/bytedance/ee/bear/doc/cover/CurrentCoverData;", "getCurrentCoverData", "isVCFollowMode", "isRemoteLoading", "()Z", "setRemoteLoading", "(Z)V", "isEnterAnimationShowing", "mFetchCoverDisposable", "Lio/reactivex/disposables/Disposable;", "selectOfficialCover", "", "entrance", "", "token", "", "mimeType", "selectLocalImage", "source", "image", "Lcom/bytedance/ee/bear/doc/cover/selectcover/local/LocalImageItem;", "randomCover", "documentType", "fetchCoverListener", "Lcom/bytedance/ee/bear/doc/cover/CoverViewModel$IFetchCoverListener;", "deleteCover", "getSeriesName", "setVCFollowMode", "VCFollowMode", "fetchOfficialCoverData", "docType", "onCleared", "isCoverDataNotExist", "Delegate", "IFetchCoverListener", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoverViewModel extends ViewModel {
    private final MutableLiveData<List<OfficialCoverData.CoverSeries>> coverSeriesList;
    private final MutableLiveData<CurrentCoverData> currentCoverData;
    private a delegate;
    private final MutableLiveData<Boolean> isEnterAnimationShowing;
    private boolean isRemoteLoading;
    private boolean isVCFollowMode;
    private Disposable mFetchCoverDisposable;
    private final MutableLiveData<Boolean> selectCoverActive;

    public interface a {
        void a();

        void b(String r1, LocalImageItem r2);

        void c(int r1, String r2, String r3, String r4, String r5);
    }

    public interface b {
        void onFailure(Throwable r1);

        void onSuccess();
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CoverViewModel a;
        public final /* synthetic */ b b;

        public c(CoverViewModel r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r2) {
            OfficialCoverData r3 = (OfficialCoverData) r2;
            r3.handlePrioritize();
            MutableLiveData<List<OfficialCoverData.CoverSeries>> r0 = this.a.getCoverSeriesList();
            OfficialCoverData.Data r4 = (OfficialCoverData.Data) r3.data;
            if (r4 == null) goto L5;
            List<OfficialCoverData.CoverSeries> r5 = r4.getCoverSeriesList();
        L6:
            r0.setValue(r5);
            this.a.setRemoteLoading(false);
            this.b.onSuccess();
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ CoverViewModel a;
        public final /* synthetic */ b b;

        public d(CoverViewModel r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            this.a.setRemoteLoading(false);
            b r0 = this.b;
            Intrinsics.checkNotNull(r4);
            r0.onFailure(r4);
        }
    }

    public final void deleteCover() {
        a r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final boolean isCoverDataNotExist() {
        List r0 = (List) this.coverSeriesList.getValue();
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.isEmpty() == true) goto L8;
        return false;
    }

    public void onCleared() {
        Disposable r0 = this.mFetchCoverDisposable;
        if (r0 == null) goto L10;
        Intrinsics.checkNotNull(r0);
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.mFetchCoverDisposable;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    L11:
        return;
    }

    public CoverViewModel() {
        this.selectCoverActive = new MutableLiveData();
        this.coverSeriesList = new MutableLiveData();
        this.currentCoverData = new MutableLiveData();
        this.isEnterAnimationShowing = new MutableLiveData();
    }

    public final MutableLiveData<List<OfficialCoverData.CoverSeries>> getCoverSeriesList() {
        return this.coverSeriesList;
    }

    public final MutableLiveData<CurrentCoverData> getCurrentCoverData() {
        return this.currentCoverData;
    }

    public final a getDelegate() {
        return this.delegate;
    }

    public final MutableLiveData<Boolean> getSelectCoverActive() {
        return this.selectCoverActive;
    }

    public final MutableLiveData<Boolean> isEnterAnimationShowing() {
        return this.isEnterAnimationShowing;
    }

    public final boolean isRemoteLoading() {
        return this.isRemoteLoading;
    }

    public final boolean isVCFollowMode() {
        return this.isVCFollowMode;
    }

    private final String getSeriesName(String r6) {
        List r0 = (List) this.coverSeriesList.getValue();
        if (r0 == null) goto L28;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L31;
        OfficialCoverData.CoverSeries r2 = (OfficialCoverData.CoverSeries) r1.next();
        List<OfficialCoverData.CoverItem> r3 = r2.getCandidateCovers();
        if (r3 == null) goto L6;
        Iterator<T> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L6;
        if (TextUtils.equals(r6, ((OfficialCoverData.CoverItem) r4.next()).getToken()) == false) goto L11;
        OfficialCoverData.Series r7 = r2.getSeries();
        if (r7 == null) goto L29;
        String r8 = r7.getSeriesId();
        if (r8 != null) goto L20;
        return "";
    L20:
        return r8;
    L29:
        return "";
    L31:
        return "";
    L28:
        return "";
    }

    public final void randomCover(int r8) {
        ArrayList r0 = new ArrayList();
        List r1 = (List) this.coverSeriesList.getValue();
        if (r1 == null) goto L14;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L14;
        List<OfficialCoverData.CoverItem> r3 = ((OfficialCoverData.CoverSeries) r2.next()).getCandidateCovers();
        if (r3 == null) goto L6;
        Iterator<T> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L6;
        r0.add((OfficialCoverData.CoverItem) r4.next());
    L14:
        if ((!r0.isEmpty()) == false) goto L26;
        OfficialCoverData.CoverItem r5 = (OfficialCoverData.CoverItem) CollectionsKt.random(r0, Random.Default);
        String r6 = r5.getToken();
        if (r6 == null) goto L27;
        a r7 = this.delegate;
        if (r7 == null) goto L28;
        r7.c(r8, CoverConstants$CoverSource.RANDOM, r6, getSeriesName(r6), r5.getMimeType());
        return;
    L28:
        return;
    L27:
        return;
    }

    public final void setDelegate(a r1) {
        this.delegate = r1;
    }

    public final void setRemoteLoading(boolean r1) {
        this.isRemoteLoading = r1;
    }

    public final void setVCFollowMode(boolean r1) {
        this.isVCFollowMode = r1;
    }

    public final void selectLocalImage(String r2, LocalImageItem r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "image");
        a r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }

    public final void fetchOfficialCoverData(String r4, int r5, b r6) {
        Intrinsics.checkNotNullParameter(r4, "token");
        Intrinsics.checkNotNullParameter(r6, "fetchCoverListener");
        this.isRemoteLoading = true;
        int r0 = my4.c.a;
        NetService r1 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Uri.Builder r2 = UriProtector.parse("/space/api/doc.v2/cover/candidates/").buildUpon();
        r2.appendQueryParameter("obj_token", r4);
        r2.appendQueryParameter("obj_type", String.valueOf(r5));
        NetService.f r7 = new NetService.f(r2.build().toString());
        r7.c = 2;
        this.mFetchCoverDisposable = r1.Vc(my4.b.a).a(r7).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).observeOn(fo5.d.d()).subscribe(new c(this, r6), new d(this, r6));
    }

    public final void selectOfficialCover(int r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "token");
        a r1 = this.delegate;
        if (r1 == null) goto L6;
        r1.c(r8, CoverConstants$CoverSource.GALLERY, r9, getSeriesName(r9), r10);
        return;
    }

    public final void randomCover(int r2, String r3, int r4, b r5) {
        Intrinsics.checkNotNullParameter(r3, "token");
        Intrinsics.checkNotNullParameter(r5, "fetchCoverListener");
        if (isCoverDataNotExist() == true) goto L5;
    L7:
        randomCover(r2);
        return;
    L5:
        if (this.isRemoteLoading == true) goto L7;
        fetchOfficialCoverData(r3, r4, r5);
    }
}
