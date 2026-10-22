package com.bytedance.ee.bear.templates.category;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback;
import com.bytedance.ee.bear.templates.dto.BinderPageControl;
import com.bytedance.ee.bear.templates.scene.BaseSceneFragment;
import com.bytedance.ee.bear.templates.scene.c;
import com.bytedance.ee.bear.templates.scene.d;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0016H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/templates/category/CategoryFragment;", "Lcom/bytedance/ee/bear/templates/scene/BaseSceneFragment;", "<init>", "()V", "categoryId", "", "getCategoryId", "()J", "setCategoryId", "(J)V", "onAttach", "", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "getIModel", "Lcom/bytedance/ee/bear/templates/scene/ISceneModel;", "getIView", "Lcom/bytedance/ee/bear/templates/scene/ISceneView;", "rootView", "getIPresenter", "Lcom/bytedance/ee/bear/templates/scene/BaseScenePresenter;", "model", "Companion", "MyPageControl", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CategoryFragment extends BaseSceneFragment {
    public static final /* synthetic */ int f = 0;
    public long e;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/templates/category/CategoryFragment$MyPageControl;", "Lcom/bytedance/ee/bear/templates/dto/BinderPageControl$Stub;", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "close", "", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MyPageControl extends BinderPageControl.Stub {
        private final WeakReference<Activity> activityRef;

        @Override // com.bytedance.ee.bear.templates.dto.BinderPageControl.Stub, com.bytedance.ee.bear.templates.dto.BinderPageControl
        public void close() {
            Activity r0 = this.activityRef.get();
            if (com.bytedance.ee.util.ui.b.a(r0) == false) goto L7;
            tt5.a.h("CategoryFragment", "BinderPageControl finish");
            if (r0 == null) goto L9;
            r0.finish();
            return;
        L9:
            return;
        L7:
            tt5.a.h("CategoryFragment", "BinderPageControl activity not active");
        }

        public MyPageControl(WeakReference<Activity> r2) {
            Intrinsics.checkNotNullParameter(r2, "activityRef");
            this.activityRef = r2;
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CategoryFragment a;

        public b(CategoryFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            FragmentActivity r2 = this.a.getActivity();
            if (r2 == null) goto L6;
            r2.onBackPressed();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.scene.BaseSceneFragment
    public final c S90() {
        long r1 = this.e;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L10;
        Intent r2 = r0.getIntent();
        if (r2 == null) goto L10;
        Bundle r3 = r2.getBundleExtra("key_template_select_callback_bundle");
        Context r4 = BadParcelableCrashOptimizer.getContext();
        if (r3 == null) goto L12;
        if (r4 == null) goto L12;
        r3.setClassLoader(r4.getClassLoader());
    L12:
        return new CategoryModel(r1, r3, 200, new CategoryFragment$getIModel$1(this));
    L10:
        r3 = null;
        goto L12
    }

    public CategoryFragment() {
        this.e = -1;
    }

    @Override // com.bytedance.ee.bear.templates.scene.BaseSceneFragment
    public final d U90(View r5) {
        Intrinsics.checkNotNullParameter(r5, "rootView");
        return new com.bytedance.ee.bear.templates.category.a(requireActivity(), this, r5, String.valueOf(this.e));
    }

    public final void onAttach(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super.onAttach(r4);
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L12;
        Intent r6 = r5.getIntent();
        if (r6 == null) goto L12;
        Bundle r7 = r6.getBundleExtra("key_template_select_callback_bundle");
        Context r0 = BadParcelableCrashOptimizer.getContext();
        if (r7 == null) goto L10;
        if (r0 == null) goto L10;
        r7.setClassLoader(r0.getClassLoader());
    L10:
        if (r7 == null) goto L12;
        IBinder r8 = r7.getBinder("key_template_select_callback");
    L14:
        if ((r8 instanceof BinderISelectTemplateCallback.Stub) == false) goto L16;
        ((BinderISelectTemplateCallback.Stub) r8).onPageView(0, new MyPageControl(new WeakReference(getActivity())));
        return;
    L16:
        tt5.a.k("CategoryFragment", "callback instance error");
        return;
    L12:
        r8 = null;
        goto L14
    }

    @Override // com.bytedance.ee.bear.templates.scene.BaseSceneFragment
    public final com.bytedance.ee.bear.templates.scene.a T90(c r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        return new com.bytedance.ee.bear.templates.scene.a(this, r2, r3);
    }

    @Override // com.bytedance.ee.bear.templates.scene.BaseSceneFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        BaseTitleBar r4 = (BaseTitleBar) r2.findViewById(2131388775);
        r4.setLeftClickListener(new b(this));
        r4.setTitle(2131887880);
    }
}
