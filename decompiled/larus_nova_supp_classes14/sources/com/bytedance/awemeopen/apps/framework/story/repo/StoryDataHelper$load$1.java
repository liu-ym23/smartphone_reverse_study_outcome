package com.bytedance.awemeopen.apps.framework.story.repo;

import com.bytedance.awemeopen.domain.base.repo.e;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class StoryDataHelper$load$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ v54.b $callback;
    final /* synthetic */ boolean $canRetry;
    final /* synthetic */ long $cursor;
    final /* synthetic */ boolean $isLoadMore;
    final /* synthetic */ boolean $needLive;
    final /* synthetic */ Long $roomId;
    final /* synthetic */ b this$0;

    public StoryDataHelper$load$1(Long r1, b r2, long r3, boolean r5, v54.b r6, boolean r7, boolean r8) {
        this.$roomId = r1;
        this.this$0 = r2;
        this.$cursor = r3;
        this.$needLive = r5;
        this.$canRetry = r7;
        this.$isLoadMore = r8;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1578invoke() {
        String r0 = c.a;
        final e r9 = c.a(this.$roomId, this.this$0.b, 10, this.$cursor, this.$needLive);
        final b r10 = this.this$0;
        final v54.b r11 = null;
        final boolean r12 = this.$canRetry;
        final boolean r13 = this.$needLive;
        final boolean r14 = this.$isLoadMore;
        AoPool.g(new AnonymousClass1(r9, r10, r11, r12, r13, r14));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1578invoke();
        return Unit.INSTANCE;
    }
}
