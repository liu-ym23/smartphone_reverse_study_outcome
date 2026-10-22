package com.bytedance.android.ui.ec.widget.photodraweeview;

import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\u0014\u0010\b\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&J\u001c\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "onAttach", "", "position", "", "adapter", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;", "onDataChanged", "onDetach", "onPageSelected", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IIndicatorView extends TransitionListener {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onAttach(IIndicatorView r0, int r1, TransitionPagerAdapter<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "adapter");
        }

        public static void onDetach(IIndicatorView r0, int r1, TransitionPagerAdapter<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "adapter");
        }
    }

    void onAttach(int r1, TransitionPagerAdapter<?> r2);

    void onDataChanged(TransitionPagerAdapter<?> r1);

    void onDetach(int r1, TransitionPagerAdapter<?> r2);

    void onPageSelected(int r1);
}
