package com.ss.android.ugc.aweme.search.vision.result.panel;

import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.utils.ScreenUtils;
import com.ss.android.ugc.aweme.search.vision.model.decouple.BottomSheetContentState;
import com.ss.android.ugc.aweme.search.vision.model.decouple.SameProductQueryDataHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b/\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\"\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\"\u0010\u001d\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\"\u0010 \u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020,0&8\u0006¢\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010+¨\u00062"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/PhotoSearchBottomPanelViewModel;", "Landroidx/lifecycle/ViewModel;", "", "", "getBottomSheetTop", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/view/MotionEvent;", "event", "", "isPointAtIndicatorRectF", "status", "", "updateBottomStatus", "bottomStatus", "I", "getBottomStatus", "()I", "setBottomStatus", "(I)V", "draweeViewHeight", "getDraweeViewHeight", "setDraweeViewHeight", "bottomHeight", "getBottomHeight", "setBottomHeight", "initialPanelTop", "getInitialPanelTop", "setInitialPanelTop", "initialPanelHeight", "getInitialPanelHeight", "setInitialPanelHeight", "viewHeight", "getViewHeight", "setViewHeight", "Landroid/graphics/RectF;", "indicatorRect", "Landroid/graphics/RectF;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/ugc/aweme/search/vision/model/decouple/BottomSheetContentState;", "updateBottomSheetStateLiveData", "Landroidx/lifecycle/MutableLiveData;", "getUpdateBottomSheetStateLiveData", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/ugc/aweme/search/vision/model/decouple/SameProductQueryDataHolder;", "sameProductQueryDataLiveData", "getSameProductQueryDataLiveData", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchBottomPanelViewModel extends ViewModel {
    public static final Companion Companion = null;
    private int bottomHeight;
    private int bottomStatus;
    private int draweeViewHeight;
    private RectF indicatorRect;
    private int initialPanelHeight;
    private int initialPanelTop;
    private final MutableLiveData<SameProductQueryDataHolder> sameProductQueryDataLiveData;
    private final MutableLiveData<BottomSheetContentState> updateBottomSheetStateLiveData;
    private int viewHeight;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/PhotoSearchBottomPanelViewModel$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        public static PhotoSearchBottomPanelViewModel a(FragmentActivity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            return (PhotoSearchBottomPanelViewModel) ViewModelProviders.of(r100).get(PhotoSearchBottomPanelViewModel.class);
        }
    }

    static {
        Companion = new Companion(0);
    }

    private final int getBottomSheetTop() {
        BottomSheetContentState r100 = new BottomSheetContentState();
        this.updateBottomSheetStateLiveData.setValue(r100);
        return r100.f453653a;
    }

    public PhotoSearchBottomPanelViewModel() {
        this.bottomStatus = 3;
        this.initialPanelTop = -1;
        this.initialPanelHeight = -1;
        this.viewHeight = -1;
        this.updateBottomSheetStateLiveData = new MutableLiveData();
        this.sameProductQueryDataLiveData = new MutableLiveData();
    }

    public final int getBottomHeight() {
        return this.bottomHeight;
    }

    public final int getBottomStatus() {
        return this.bottomStatus;
    }

    public final int getDraweeViewHeight() {
        return this.draweeViewHeight;
    }

    public final int getInitialPanelHeight() {
        return this.initialPanelHeight;
    }

    public final int getInitialPanelTop() {
        return this.initialPanelTop;
    }

    public final MutableLiveData<SameProductQueryDataHolder> getSameProductQueryDataLiveData() {
        return this.sameProductQueryDataLiveData;
    }

    public final MutableLiveData<BottomSheetContentState> getUpdateBottomSheetStateLiveData() {
        return this.updateBottomSheetStateLiveData;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    public final void setBottomHeight(int r100) {
        this.bottomHeight = r100;
    }

    public final void setBottomStatus(int r100) {
        this.bottomStatus = r100;
    }

    public final void setDraweeViewHeight(int r100) {
        this.draweeViewHeight = r100;
    }

    public final void setInitialPanelHeight(int r100) {
        this.initialPanelHeight = r100;
    }

    public final void setInitialPanelTop(int r100) {
        this.initialPanelTop = r100;
    }

    public final void setViewHeight(int r100) {
        this.viewHeight = r100;
    }

    public void updateBottomStatus(int r100) {
        this.bottomStatus = r100;
    }

    public final boolean isPointAtIndicatorRectF(Context r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = getBottomSheetTop();
        RectF r103 = this.indicatorRect;
        if (r103 != null) goto L5;
        r103 = new RectF(0.0f, r102, ScreenUtils.b(r100), r102 + this.draweeViewHeight);
    L5:
        this.indicatorRect = r103;
        return r103.contains(r101.getRawX(), r101.getRawY());
    }
}
