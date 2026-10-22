package sr9;

import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.chat.layout.holder.progressloading.ImageLoadingDrawPartType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class x implements ISketchLoadingController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f543270a = null;

    static {
        f543270a = new x();
    }

    public x() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController
    public final void a(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
    }

    @Override // com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController
    public final void b(boolean r100, ImageLoadingDrawPartType r101, int r102) {
    }

    @Override // com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
    }

    @Override // com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController
    public final void hide() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController
    public final void setProgress(int r100) {
    }

    @Override // com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController
    public final Boolean isVisible() {
        return Boolean.FALSE;
    }
}
