package com.bytedance.ee.bear.templates.scene;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/templates/scene/SceneFragment;", "Lcom/bytedance/ee/bear/templates/scene/BaseSceneFragment;", "<init>", "()V", "topicId", "", "getTopicId", "()Ljava/lang/String;", "setTopicId", "(Ljava/lang/String;)V", "getIModel", "Lcom/bytedance/ee/bear/templates/scene/SceneModel;", "getIView", "Lcom/bytedance/ee/bear/templates/scene/ISceneView;", "rootView", "Landroid/view/View;", "getIPresenter", "Lcom/bytedance/ee/bear/templates/scene/BaseScenePresenter;", "model", "Lcom/bytedance/ee/bear/templates/scene/ISceneModel;", "view", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SceneFragment extends BaseSceneFragment {
    public static final /* synthetic */ int f = 0;
    public String e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.scene.BaseSceneFragment
    public final c S90() {
        return new SceneModel(requireActivity());
    }

    public SceneFragment() {
        this.e = "";
    }

    @Override // com.bytedance.ee.bear.templates.scene.BaseSceneFragment
    public final d U90(View r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        return new BaseSceneView(requireActivity(), this, r4, this.e);
    }

    @Override // com.bytedance.ee.bear.templates.scene.BaseSceneFragment
    public final com.bytedance.ee.bear.templates.scene.a T90(c r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        return new com.bytedance.ee.bear.templates.scene.a(this, r2, r3);
    }
}
