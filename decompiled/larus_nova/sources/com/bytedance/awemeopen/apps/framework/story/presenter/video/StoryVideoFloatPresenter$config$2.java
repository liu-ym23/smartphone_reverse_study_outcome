package com.bytedance.awemeopen.apps.framework.story.presenter.video;

import android.util.Log;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class StoryVideoFloatPresenter$config$2 extends Lambda implements Function1<Throwable, Unit> {
    public static final StoryVideoFloatPresenter$config$2 INSTANCE = null;

    static {
        INSTANCE = new StoryVideoFloatPresenter$config$2();
    }

    public StoryVideoFloatPresenter$config$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        AoLogger.b("StoryVideoFloatPresenter", new Object[]{Log.getStackTraceString(r100)});
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
