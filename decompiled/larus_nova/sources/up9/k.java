package up9;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaListBinding;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k extends f0 {
    public k(MediaTab r100, MediaGalleryUIConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "curMediaTab");
        Intrinsics.checkNotNullParameter(r101, "uiConfig");
        super(r100, r101);
    }

    @Override // up9.f0, up9.g0.a
    public final void b(LifecycleOwner r100, BottomSheetViewModel r101, final LarusFragmentMediaListBinding r102) {
        Intrinsics.checkNotNullParameter(r100, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "binding");
        if (r101 == null) goto L8;
        MutableLiveData<Integer> r103 = r101.getBottomSheetOnStateChanged();
        if (r103 == null) goto L9;
        r103.observe(r100, new h0(new j(r102)));
        return;
    L9:
        return;
    }
}
