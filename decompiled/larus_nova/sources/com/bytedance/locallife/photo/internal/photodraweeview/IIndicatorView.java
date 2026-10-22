package com.bytedance.locallife.photo.internal.photodraweeview;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.locallife.photo.internal.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.locallife.photo.internal.photodraweeview.transition.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\u001c\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\u001c\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/photo/internal/photodraweeview/IIndicatorView;", "Lcom/bytedance/locallife/photo/internal/photodraweeview/transition/a;", "", "position", "", "onPageSelected", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "", "byScroll", "Lcom/bytedance/locallife/photo/internal/photodraweeview/transition/TransitionPagerAdapter;", "adapter", "onDataChanged", "onAttach", "onDetach", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public interface IIndicatorView extends a {
    void onAttach(int r100, TransitionPagerAdapter<?> r101);

    void onDataChanged(TransitionPagerAdapter<?> r100);

    void onDetach(int r100, TransitionPagerAdapter<?> r101);

    void onPageSelected(int r100);

    void onPageSelected(int r100, boolean r101);

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.transition.a
    /* synthetic */ void onTransitionBegin(int r100);

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.transition.a
    /* synthetic */ void onTransitionChanged(int r100, float r101);

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.transition.a
    /* synthetic */ void onTransitionEnd(int r100);
}
