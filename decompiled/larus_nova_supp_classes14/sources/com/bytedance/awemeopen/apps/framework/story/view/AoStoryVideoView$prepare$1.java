package com.bytedance.awemeopen.apps.framework.story.view;

import com.bytedance.awemeopen.infra.base.player.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AoStoryVideoView$prepare$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ j $request;
    final /* synthetic */ AoStoryVideoView this$0;

    public AoStoryVideoView$prepare$1(AoStoryVideoView r1, j r2) {
        this.this$0 = r1;
        this.$request = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1582invoke() {
        AoStoryVideoView.b(this.this$0).e(this.$request);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1582invoke();
        return Unit.INSTANCE;
    }
}
