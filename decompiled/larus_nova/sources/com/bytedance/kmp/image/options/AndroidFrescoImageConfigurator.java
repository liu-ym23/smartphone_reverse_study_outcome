package com.bytedance.kmp.image.options;

import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class AndroidFrescoImageConfigurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<? super GenericDraweeHierarchy, Unit> f252133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super PipelineDraweeControllerBuilder, Unit> f252134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super ImageRequestBuilder, Unit> f252135c;

    public AndroidFrescoImageConfigurator() {
        this.f252133a = AndroidFrescoImageConfigurator$onHierarchyBuild$1.INSTANCE;
        this.f252134b = AndroidFrescoImageConfigurator$onControllerBuild$1.INSTANCE;
        this.f252135c = AndroidFrescoImageConfigurator$onRequestBuild$1.INSTANCE;
    }
}
