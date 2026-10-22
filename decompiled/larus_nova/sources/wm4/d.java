package wm4;

import android.widget.ImageView;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.VideoImage;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements vm4.a {
    @Inject
    public d() {
    }

    @Override // vm4.a
    public final void a(ImageView r100, int r101, FileEntry r102) {
        Intrinsics.checkNotNullParameter(r100, "iconView");
        Intrinsics.checkNotNullParameter(r102, "fileEntry");
        if ((!StringsKt.isBlank(r102.f206015c)) == false) goto L5;
        Object r103 = new VideoImage(r102.f206015c);
    L6:
        ImageLoader.with(r100.getContext()).load(r103).placeholder(kac.a.b(R.drawable.icon_file_video_rectangle)).override(r101, r101).into(r100);
        return;
    L5:
        r103 = r102.f206014b;
        goto L6
    }
}
