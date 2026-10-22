package l8a;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public final class c extends IterativeBoxBlurPostProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<LynxContext> f508071a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f508072a;

        @Override // java.lang.Runnable
        public final void run() {
            WeakReference<LynxContext> r100 = this.f508072a.f508071a;     // Catch: Throwable -> L8
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.get() == null) goto L15;
            LynxError r101 = new LynxError(220301, "blur-radius/drop-shadow is not supported in this app and it will crash in lower versions", "Please remove blur-radius/drop-shadow props in image/filter-image.", "error", -3);     // Catch: Throwable -> L8
            this.f508072a.f508071a.get().handleLynxError(r101);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(c r100) {
            this.f508072a = r100;
        }
    }

    @Override // com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor, com.facebook.imagepipeline.request.BasePostprocessor
    public final void process(Bitmap r100) {
        super.process(r100);     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        UIThreadUtils.runOnUiThread(new a(this));
    }

    public c(int r100, LynxContext r101) {
        super(r100);
        this.f508071a = new WeakReference(r101);
    }
}
