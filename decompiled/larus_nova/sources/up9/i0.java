package up9;

import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaSelectorBinding;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;

/* JADX INFO: loaded from: classes31.dex */
public interface i0 extends j0 {
    void f(LarusFragmentMediaSelectorBinding r100);

    void g(LifecycleOwner r100, LarusFragmentMediaSelectorBinding r101, BottomSheetViewModel r102, MediaGalleryLiveDataViewModel r103);

    void h(ViewPager2 r100);

    void j(ViewPager2 r100, boolean r101, boolean r102);

    void onDestroyView();
}
