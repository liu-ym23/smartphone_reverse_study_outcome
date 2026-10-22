package wa;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import com.bytedance.android.anniex.scene.next.f;

/* JADX INFO: loaded from: classes43.dex */
public abstract class c implements b<f, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PredictElementType f558798a;

    public c() {
        this.f558798a = PredictElementType.SceneRepeat;
    }

    @Override // wa.b
    public final PredictElementType b() {
        return this.f558798a;
    }
}
