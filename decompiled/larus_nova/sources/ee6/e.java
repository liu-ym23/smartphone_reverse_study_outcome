package ee6;

import android.app.Application;
import com.bytedance.common.utility.tools.SafelyLibraryLoader;
import com.lynx.tasm.INativeLibraryLoader;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements INativeLibraryLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f472291a;

    public e(Application r100) {
        this.f472291a = r100;
    }

    @Override // com.lynx.tasm.INativeLibraryLoader
    public final void loadLibrary(String r100) {
        SafelyLibraryLoader.loadLibrary(this.f472291a, r100);
    }
}
