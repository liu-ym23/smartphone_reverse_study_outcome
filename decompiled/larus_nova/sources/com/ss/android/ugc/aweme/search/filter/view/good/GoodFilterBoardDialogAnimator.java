package com.ss.android.ugc.aweme.search.filter.view.good;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/good/GoodFilterBoardDialogAnimator;", "", "Hide", "Show", "Lcom/ss/android/ugc/aweme/search/filter/view/good/GoodFilterBoardDialogAnimator$Hide;", "Lcom/ss/android/ugc/aweme/search/filter/view/good/GoodFilterBoardDialogAnimator$Show;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class GoodFilterBoardDialogAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Animator f453225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Animator f453226b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/good/GoodFilterBoardDialogAnimator$Hide;", "Lcom/ss/android/ugc/aweme/search/filter/view/good/GoodFilterBoardDialogAnimator;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Hide extends GoodFilterBoardDialogAnimator {
        public Hide(Animator r100, Animator r101) {
            Intrinsics.checkNotNullParameter(r100, "panelAnimator");
            Intrinsics.checkNotNullParameter(r101, "windowLayerAnimator");
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/good/GoodFilterBoardDialogAnimator$Show;", "Lcom/ss/android/ugc/aweme/search/filter/view/good/GoodFilterBoardDialogAnimator;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Show extends GoodFilterBoardDialogAnimator {
        public Show(Animator r100, Animator r101) {
            Intrinsics.checkNotNullParameter(r100, "panelAnimator");
            Intrinsics.checkNotNullParameter(r101, "windowLayerAnimator");
            super(r100, r101);
        }
    }

    public GoodFilterBoardDialogAnimator(Animator r100, Animator r101) {
        this.f453225a = r100;
        this.f453226b = r101;
    }
}
