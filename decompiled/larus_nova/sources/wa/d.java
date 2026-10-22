package wa;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import com.bytedance.android.anniex.scene.next.g;

/* JADX INFO: loaded from: classes43.dex */
public abstract class d implements b<g, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PredictElementType f558799a;

    public d() {
        this.f558799a = PredictElementType.SceneId;
    }

    @Override // wa.b
    public final PredictElementType b() {
        return this.f558799a;
    }
}
