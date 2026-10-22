package com.bytedance.awemeopen.apps.framework.story.view.digg;

import android.util.Log;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class StoryDiggView$config$2 extends Lambda implements Function1<Throwable, Unit> {
    public static final StoryDiggView$config$2 INSTANCE = null;

    static {
        INSTANCE = new StoryDiggView$config$2();
    }

    public StoryDiggView$config$2() {
        super(1);
    }

    public final void invoke(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        AoLogger.b("STORY_DIGG_VIEW", new Object[]{Log.getStackTraceString(r3)});
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }
}
