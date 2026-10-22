package wm4;

import android.widget.ImageView;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements vm4.a {
    @Inject
    public b() {
    }

    @Override // vm4.a
    public final void a(ImageView r100, int r101, FileEntry r102) {
        Intrinsics.checkNotNullParameter(r100, "iconView");
        Intrinsics.checkNotNullParameter(r102, "fileEntry");
        r100.setImageResource(c.a(r102.f206013a));
    }
}
