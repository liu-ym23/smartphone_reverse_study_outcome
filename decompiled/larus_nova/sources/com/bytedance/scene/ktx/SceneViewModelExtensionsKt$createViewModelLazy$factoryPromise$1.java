package com.bytedance.scene.ktx;

import android.app.Activity;
import android.app.Application;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.scene.Scene;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "VM", "Landroidx/lifecycle/ViewModel;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class SceneViewModelExtensionsKt$createViewModelLazy$factoryPromise$1 extends Lambda implements Function0<ViewModelProvider.AndroidViewModelFactory> {
    final /* synthetic */ Scene $this_createViewModelLazy;

    public SceneViewModelExtensionsKt$createViewModelLazy$factoryPromise$1(Scene r100) {
        this.$this_createViewModelLazy = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelProvider.AndroidViewModelFactory invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.AndroidViewModelFactory invoke() {
        Activity r100 = this.$this_createViewModelLazy.getActivity();
        if (r100 == null) goto L9;
        Application r101 = r100.getApplication();
        if (r101 == null) goto L9;
        return ViewModelProvider.AndroidViewModelFactory.getInstance(r101);
    L9:
        throw new IllegalStateException("ViewModel can be accessed only when Scene is attached");
    }
}
