package ix8;

import com.larus.camera.api.vlm.VLMIntentScene;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<VLMIntentScene> f496411a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f496411a, ((h) r100).f496411a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f496411a.hashCode();
    }

    public final String toString() {
        return "VLMIntentSceneResolveResult(scenes=" + this.f496411a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends VLMIntentScene> r100) {
        Intrinsics.checkNotNullParameter(r100, InvRouter.SCENES);
        this.f496411a = r100;
    }
}
