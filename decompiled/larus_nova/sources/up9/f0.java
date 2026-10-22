package up9;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.nova.R;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaListBinding;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.photopicker.v2.impl.ui.MediaListAdapterV2;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
public class f0 implements g0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaGalleryUIConfig f551096a;

    @Override // up9.g0.a
    public void b(LifecycleOwner r100, BottomSheetViewModel r101, LarusFragmentMediaListBinding r102) {
        Intrinsics.checkNotNullParameter(r100, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "binding");
    }

    public f0(MediaTab r100, MediaGalleryUIConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "curMediaTab");
        Intrinsics.checkNotNullParameter(r101, "uiConfig");
        this.f551096a = r101;
    }

    @Override // up9.g0.a
    public final void a(Context r100, MediaListAdapterV2 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "adapter");
        boolean r102 = kp9.b.f505530a.c(r100, this.f551096a.f364490g);
        r101.f364633g = r102;
        r101.A2(r102);
    }

    @Override // up9.g0.a
    public final vp9.m c(Context r100, g0.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "selectionState");
        RoundingParams r102 = RoundingParams.fromCornersRadius(0.0f);
        r102.setBorder(ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_transparent_1, r100, R.color.larus_neutral_transparent_1)), i5.b());
        Intrinsics.checkNotNull(r102);
        return new vp9.m(r102, -1, r101 instanceof k0 ? 1 : 0, this.f551096a.f364508y);
    }
}
