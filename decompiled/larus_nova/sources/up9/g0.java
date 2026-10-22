package up9;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaListBinding;
import com.larus.photopicker.v2.impl.j2;
import com.larus.photopicker.v2.impl.ui.ClickType;
import com.larus.photopicker.v2.impl.ui.MediaListAdapterV2;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;

/* JADX INFO: loaded from: classes31.dex */
public interface g0 extends j0 {

    public interface a {
        void a(Context r100, MediaListAdapterV2 r101);

        void b(LifecycleOwner r100, BottomSheetViewModel r101, LarusFragmentMediaListBinding r102);

        vp9.m c(Context r100, b r101);
    }

    public interface b {
        void a(op9.d r100, int r101, ClickType r102);
    }

    a c();

    MediaListAdapterV2 n(Context r100, int r101, int r102, j2 r103);

    void onDestroyView();
}
