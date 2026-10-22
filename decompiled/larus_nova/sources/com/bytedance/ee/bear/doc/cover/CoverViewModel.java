package com.bytedance.ee.bear.doc.cover;

import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.doc.cover.selectcover.local.LocalImageItem;
import com.bytedance.ee.bear.doc.cover.selectcover.official.OfficialCoverData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u000256B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010#J\u0016\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(J&\u0010)\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0006\u0010-\u001a\u00020\u001fJ\u0010\u0010.\u001a\u00020#2\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0006J\u001e\u00101\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u00102\u001a\u00020!2\u0006\u0010+\u001a\u00020,J\b\u00103\u001a\u00020\u001fH\u0014J\u0006\u00104\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/CoverViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "selectCoverActive", "Landroidx/lifecycle/MutableLiveData;", "", "getSelectCoverActive", "()Landroidx/lifecycle/MutableLiveData;", "delegate", "Lcom/bytedance/ee/bear/doc/cover/CoverViewModel$Delegate;", "getDelegate", "()Lcom/bytedance/ee/bear/doc/cover/CoverViewModel$Delegate;", "setDelegate", "(Lcom/bytedance/ee/bear/doc/cover/CoverViewModel$Delegate;)V", "coverSeriesList", "", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverData$CoverSeries;", "getCoverSeriesList", "currentCoverData", "Lcom/bytedance/ee/bear/doc/cover/CurrentCoverData;", "getCurrentCoverData", "isVCFollowMode", "isRemoteLoading", "()Z", "setRemoteLoading", "(Z)V", "isEnterAnimationShowing", "mFetchCoverDisposable", "Lio/reactivex/disposables/Disposable;", "selectOfficialCover", "", SoloKtvContext.SOLO_PAGE_ENTRANCE, "", "token", "", DBDefinition.MIME_TYPE, "selectLocalImage", "source", "image", "Lcom/bytedance/ee/bear/doc/cover/selectcover/local/LocalImageItem;", "randomCover", "documentType", "fetchCoverListener", "Lcom/bytedance/ee/bear/doc/cover/CoverViewModel$IFetchCoverListener;", "deleteCover", "getSeriesName", "setVCFollowMode", "VCFollowMode", "fetchOfficialCoverData", "docType", "onCleared", "isCoverDataNotExist", "Delegate", "IFetchCoverListener", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        void b(String r100, LocalImageItem r101);

        void c(int r100, String r101, String r102, String r103, String r104);
    }

    public interface b {
        void onFailure(Throwable r100);

        void onSuccess();
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoverViewModel f217797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f217798b;

        public c(CoverViewModel r100, b r101) {
            this.f217797a = r100;
            this.f217798b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            OfficialCoverData r101 = (OfficialCoverData) r100;
            r101.handlePrioritize();
            MutableLiveData<List<OfficialCoverData.CoverSeries>> r102 = this.f217797a.getCoverSeriesList();
            OfficialCoverData.Data r103 = (OfficialCoverData.Data) r101.data;
            if (r103 == null) goto L5;
            List<OfficialCoverData.CoverSeries> r104 = r103.getCoverSeriesList();
        L6:
            r102.setValue(r104);
            this.f217797a.setRemoteLoading(false);
            this.f217798b.onSuccess();
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoverViewModel f217799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f217800b;

        public d(CoverViewModel r100, b r101) {
            this.f217799a = r100;
            this.f217800b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f217799a.setRemoteLoading(false);
            b r102 = this.f217800b;
            Intrinsics.checkNotNull(r101);
            r102.onFailure(r101);
        }
    }

    public final void deleteCover() {
        a r100 = this.delegate;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public final boolean isCoverDataNotExist() {
        List<OfficialCoverData.CoverSeries> r100 = this.coverSeriesList.getValue();
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isEmpty() == true) goto L8;
        return false;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable r100 = this.mFetchCoverDisposable;
        if (r100 == null) goto L10;
        Intrinsics.checkNotNull(r100);
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.mFetchCoverDisposable;
        if (r101 == null) goto L12;
        r101.dispose();
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

    private final String getSeriesName(String r100) {
        List<OfficialCoverData.CoverSeries> r101 = this.coverSeriesList.getValue();
        if (r101 == null) goto L28;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L31;
        OfficialCoverData.CoverSeries r103 = (OfficialCoverData.CoverSeries) r102.next();
        List<OfficialCoverData.CoverItem> r104 = r103.getCandidateCovers();
        if (r104 == null) goto L6;
        Iterator<T> r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L6;
        if (TextUtils.equals(r100, ((OfficialCoverData.CoverItem) r105.next()).getToken()) == false) goto L11;
        OfficialCoverData.Series r106 = r103.getSeries();
        if (r106 == null) goto L29;
        String r107 = r106.getSeriesId();
        if (r107 != null) goto L20;
        return "";
    L20:
        return r107;
    L29:
        return "";
    L31:
        return "";
    L28:
        return "";
    }

    public final void randomCover(int r100) {
        ArrayList r101 = new ArrayList();
        List<OfficialCoverData.CoverSeries> r102 = this.coverSeriesList.getValue();
        if (r102 == null) goto L14;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L14;
        List<OfficialCoverData.CoverItem> r104 = ((OfficialCoverData.CoverSeries) r103.next()).getCandidateCovers();
        if (r104 == null) goto L6;
        Iterator<T> r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L6;
        r101.add((OfficialCoverData.CoverItem) r105.next());
    L14:
        if ((!r101.isEmpty()) == false) goto L26;
        OfficialCoverData.CoverItem r106 = (OfficialCoverData.CoverItem) CollectionsKt.random(r101, Random.Default);
        String r107 = r106.getToken();
        if (r107 == null) goto L27;
        a r108 = this.delegate;
        if (r108 == null) goto L28;
        r108.c(r100, "random", r107, getSeriesName(r107), r106.getMimeType());
        return;
    L28:
        return;
    L27:
        return;
    }

    public final void setDelegate(a r100) {
        this.delegate = r100;
    }

    public final void setRemoteLoading(boolean r100) {
        this.isRemoteLoading = r100;
    }

    public final void setVCFollowMode(boolean r100) {
        this.isVCFollowMode = r100;
    }

    public final void selectLocalImage(String r100, LocalImageItem r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "image");
        a r102 = this.delegate;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    public final void fetchOfficialCoverData(String r100, int r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "fetchCoverListener");
        this.isRemoteLoading = true;
        int r103 = my4.c.f516371a;
        NetService r104 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Uri.Builder r105 = UriProtector.parse("/space/api/doc.v2/cover/candidates/").buildUpon();
        r105.appendQueryParameter("obj_token", r100);
        r105.appendQueryParameter("obj_type", String.valueOf(r101));
        NetService.f r106 = new NetService.f(r105.build().toString());
        r106.f216906c = 2;
        this.mFetchCoverDisposable = r104.Vc(my4.b.f516370a).a(r106).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).observeOn(fo5.d.d()).subscribe(new c(this, r102), new d(this, r102));
    }

    public final void selectOfficialCover(int r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r101, "token");
        a r102 = this.delegate;
        if (r102 == null) goto L6;
        r102.c(r100, "gallery", r101, getSeriesName(r101), r110);
        return;
    }

    public final void randomCover(int r100, String r101, int r102, b r103) {
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r103, "fetchCoverListener");
        if (isCoverDataNotExist() == true) goto L5;
    L7:
        randomCover(r100);
        return;
    L5:
        if (this.isRemoteLoading == true) goto L7;
        fetchOfficialCoverData(r101, r102, r103);
    }
}
