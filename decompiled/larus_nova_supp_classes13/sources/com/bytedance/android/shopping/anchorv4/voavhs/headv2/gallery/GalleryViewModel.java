package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bI\u0010JJ+\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0003*\u00020\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0016J\u0016\u0010\u001f\u001a\u00020\u00062\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cJ%\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00162\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0004\b!\u0010\"J\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0016R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048\u0006¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010'R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048\u0006¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010'R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048\u0006¢\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b-\u0010'R%\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c0\u00048\u0006¢\u0006\f\n\u0004\b.\u0010&\u001a\u0004\b/\u0010'R#\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00048\u0006¢\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b1\u0010'R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048\u0006¢\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b3\u0010'R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048\u0006¢\u0006\f\n\u0004\b4\u0010&\u001a\u0004\b5\u0010'R&\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0010060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010&R&\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010&RE\u0010:\u001a0\u0012,\u0012*\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0010\u0018\u000106\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0018\u000106090\u00048\u0006¢\u0006\f\n\u0004\b:\u0010&\u001a\u0004\b;\u0010'R$\u0010<\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bB\u0010D\"\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006K"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/GalleryViewModel;", "Landroidx/lifecycle/ViewModel;", "", "T", "Landroidx/lifecycle/LiveData;", "v", "", "set", "(Landroidx/lifecycle/LiveData;Ljava/lang/Object;)V", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/ShowDependsOn;", "depend", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/State;", "state", "setShowDependsState", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/AnchorContainer;", "container", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/j;", "data", "setAnchorContainerState", "", "isExpanded", "setMoreVideoExpanded", "", "height", "setBottomBarHeight", "setMoreVideoHeight", "position", "setSelectedPosition", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/s;", "items", "setFullThumbList", "tabStart", "setThumbList", "(Ljava/lang/Integer;Ljava/util/List;)V", "setCurPlayingVideoPosition", "setEnterAnimStatus", "isMoreVideoExpanded", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "bottomBarHeight", "getBottomBarHeight", "moreVideoHeight", "getMoreVideoHeight", "selectedPosition", "getSelectedPosition", "fullThumbList", "getFullThumbList", "thumbList", "getThumbList", "curPlayingVideoPosition", "getCurPlayingVideoPosition", "enterAnimStatus", "getEnterAnimStatus", "", "anchorContainerState", "showDependsOnState", "Lkotlin/Pair;", "pendantContainerState", "getPendantContainerState", "videoManualMuteState", "Ljava/lang/Boolean;", "getVideoManualMuteState", "()Ljava/lang/Boolean;", "setVideoManualMuteState", "(Ljava/lang/Boolean;)V", "isFirstBind", "Z", "()Z", "setFirstBind", "(Z)V", "thumbListTabStart", "Ljava/lang/Integer;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryViewModel extends ViewModel {
    private final LiveData<Map<AnchorContainer, j>> anchorContainerState;
    private final LiveData<Integer> bottomBarHeight;
    private final LiveData<Integer> curPlayingVideoPosition;
    private final LiveData<Integer> enterAnimStatus;
    private final LiveData<List<s>> fullThumbList;
    private boolean isFirstBind;
    private final LiveData<Boolean> isMoreVideoExpanded;
    private final LiveData<Integer> moreVideoHeight;
    private final LiveData<Pair<Map<AnchorContainer, j>, Map<ShowDependsOn, State>>> pendantContainerState;
    private final LiveData<Integer> selectedPosition;
    private final LiveData<Map<ShowDependsOn, State>> showDependsOnState;
    private final LiveData<List<s>> thumbList;
    private Integer thumbListTabStart;
    private Boolean videoManualMuteState;

    public GalleryViewModel() {
        this.isMoreVideoExpanded = new MutableLiveData(Boolean.FALSE);
        this.bottomBarHeight = new MutableLiveData(0);
        this.moreVideoHeight = new MutableLiveData(0);
        this.selectedPosition = new MutableLiveData(-1);
        this.fullThumbList = new MutableLiveData(CollectionsKt.emptyList());
        this.thumbList = new MutableLiveData(CollectionsKt.emptyList());
        this.curPlayingVideoPosition = new MutableLiveData(-1);
        this.enterAnimStatus = new MutableLiveData(0);
        MutableLiveData r0 = new MutableLiveData(MapsKt.emptyMap());
        this.anchorContainerState = r0;
        MutableLiveData r1 = new MutableLiveData(MapsKt.emptyMap());
        this.showDependsOnState = r1;
        int r2 = f0.a;
        GalleryViewModel$pendantContainerState$1 r3 = GalleryViewModel$pendantContainerState$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "liveDataA");
        Intrinsics.checkNotNullParameter(r1, "liveDataB");
        Intrinsics.checkNotNullParameter(r3, "combine");
        MediatorLiveData r4 = new MediatorLiveData();
        r4.addSource(r0, new d0(r4, r3, r1));
        r4.addSource(r1, new e0(r4, r3, r0));
        this.pendantContainerState = r4;
        this.isFirstBind = true;
    }

    public final LiveData<Integer> getBottomBarHeight() {
        return this.bottomBarHeight;
    }

    public final LiveData<Integer> getCurPlayingVideoPosition() {
        return this.curPlayingVideoPosition;
    }

    public final LiveData<Integer> getEnterAnimStatus() {
        return this.enterAnimStatus;
    }

    public final LiveData<List<s>> getFullThumbList() {
        return this.fullThumbList;
    }

    public final LiveData<Integer> getMoreVideoHeight() {
        return this.moreVideoHeight;
    }

    public final LiveData<Pair<Map<AnchorContainer, j>, Map<ShowDependsOn, State>>> getPendantContainerState() {
        return this.pendantContainerState;
    }

    public final LiveData<Integer> getSelectedPosition() {
        return this.selectedPosition;
    }

    public final LiveData<List<s>> getThumbList() {
        return this.thumbList;
    }

    public final Boolean getVideoManualMuteState() {
        return this.videoManualMuteState;
    }

    public final boolean isFirstBind() {
        return this.isFirstBind;
    }

    public final LiveData<Boolean> isMoreVideoExpanded() {
        return this.isMoreVideoExpanded;
    }

    public final void setBottomBarHeight(int r2) {
        set(this.bottomBarHeight, Integer.valueOf(r2));
    }

    public final void setCurPlayingVideoPosition(int r2) {
        set(this.curPlayingVideoPosition, Integer.valueOf(r2));
    }

    public final void setEnterAnimStatus(int r2) {
        set(this.enterAnimStatus, Integer.valueOf(r2));
    }

    public final void setFirstBind(boolean r1) {
        this.isFirstBind = r1;
    }

    public final void setFullThumbList(List<s> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        set(this.fullThumbList, r2);
    }

    public final void setMoreVideoExpanded(boolean r2) {
        set(this.isMoreVideoExpanded, Boolean.valueOf(r2));
    }

    public final void setMoreVideoHeight(int r2) {
        set(this.moreVideoHeight, Integer.valueOf(r2));
    }

    public final void setSelectedPosition(int r2) {
        set(this.selectedPosition, Integer.valueOf(r2));
    }

    public final void setVideoManualMuteState(Boolean r1) {
        this.videoManualMuteState = r1;
    }

    private final <T> void set(LiveData<T> r2, T r3) {
        if ((r2 instanceof MutableLiveData) == true) goto L5;
        r2 = null;
    L5:
        MutableLiveData r4 = (MutableLiveData) r2;
        if (r4 == null) goto L9;
        r4.setValue(r3);
        return;
    }

    public final void setAnchorContainerState(AnchorContainer r3, j r4) {
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "data");
        Map r0 = (Map) this.anchorContainerState.getValue();
        if (r0 != null) goto L5;
        r0 = MapsKt.emptyMap();
    L5:
        set(this.anchorContainerState, MapsKt.plus(r0, TuplesKt.to(r3, r4)));
    }

    public final void setShowDependsState(ShowDependsOn r3, State r4) {
        Intrinsics.checkNotNullParameter(r3, "depend");
        Intrinsics.checkNotNullParameter(r4, "state");
        Map r0 = (Map) this.showDependsOnState.getValue();
        if (r0 != null) goto L5;
        r0 = MapsKt.emptyMap();
    L5:
        set(this.showDependsOnState, MapsKt.plus(r0, TuplesKt.to(r3, r4)));
    }

    public final void setThumbList(Integer r2, List<s> r3) {
        Intrinsics.checkNotNullParameter(r3, "items");
        if (Intrinsics.areEqual(this.thumbListTabStart, r2) == false) goto L5;
        return;
    L5:
        this.thumbListTabStart = r2;
        set(this.thumbList, r3);
    }
}
