package com.bytedance.ee.bear.templates.category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.templates.bean.SelectTemplateConfig;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.bytedance.ee.bear.templates.preview.single.common.CustomTemplateCreator;
import com.bytedance.ee.bear.templates.scene.BaseSceneView;
import com.bytedance.ee.bear.templates.scene.TopicDataResult;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BaseSceneView {
    public final MutableLiveData<Boolean> j;
    public BinderISelectTemplateCallback.Stub k;
    public SelectTemplateConfig l;
    public CustomTemplateCreator m;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.category.a$a, reason: collision with other inner class name */
    public static final class C0183a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            tt5.a.h("CategoryView", "livePreviewActive=" + this.a.j);
            if (Intrinsics.areEqual((Boolean) r3, Boolean.FALSE) == false) goto L6;
            this.a.getActivity().finish();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.scene.BaseSceneView
    public final void destroy() {
        this.j.removeObservers(this.b);
    }

    @Override // com.bytedance.ee.bear.templates.scene.BaseSceneView
    public final void create() {
        super.create();
        Intent r0 = getActivity().getIntent();
        if (r0 == null) goto L8;
        Bundle r1 = r0.getBundleExtra("key_template_select_callback_bundle");
        Context r2 = BadParcelableCrashOptimizer.getContext();
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        r1.setClassLoader(r2.getClassLoader());
    L9:
        if (r1 == null) goto L15;
        IBinder r3 = r1.getBinder("key_template_select_callback");
        if ((r3 instanceof BinderISelectTemplateCallback.Stub) == false) goto L13;
        this.k = (BinderISelectTemplateCallback.Stub) r3;
    L14:
        this.l = (SelectTemplateConfig) r1.getParcelable("key_template_select_template_config");
        this.m = new CustomTemplateCreator(this.k, this.l);
        goto L15
    L13:
        tt5.a.k("CategoryView", "cb=" + r3);
    L15:
        this.j.observe(this.b, new b(this));
        return;
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.templates.scene.BaseSceneView, com.bytedance.ee.bear.templates.scene.d
    public final void a7(TopicDataResult r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        super.a7(r2);
    }

    @Override // com.bytedance.ee.bear.templates.scene.BaseSceneView, com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void h(int r8, TemplateV4 r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, ThumbGlideUrl.SOURCE_TEMPLATE);
        if (j.a.a.getNetworkState().a() == true) goto L6;
        Toast.showFailureText(getActivity(), 2131887937);
        return;
    L6:
        SelectTemplateConfig r0 = this.l;
        if (r0 == null) goto L11;
        boolean r1 = true;
        if (r0.d != true) goto L11;
    L13:
        if (r1 == false) goto L15;
        tt5.a.h("CategoryView", "enablePreviewDetail true");
        super.h(r8, r9, r10);
        return;
    L15:
        tt5.a.h("CategoryView", "enablePreviewDetail false");
        CustomTemplateCreator r11 = this.m;
        if (r11 == null) goto L20;
        r11.a(new Item(r9.getObjToken(), r9.getName(), r9.getObjType(), 0, r8, r9.getId()), null, this.j);
        return;
    L20:
        return;
    L11:
        r1 = false;
        goto L13
    }

    public a(FragmentActivity r2, LifecycleOwner r3, View r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Intrinsics.checkNotNullParameter(r5, "topicId");
        super(r2, r3, r4, r5);
        this.j = new MutableLiveData();
    }
}
