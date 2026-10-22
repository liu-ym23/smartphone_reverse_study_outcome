package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.entry.IronListHeaderEntryView;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class ListHeaderJumpDispatcher$dispatchEntryJump$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef $btmModel;
    final /* synthetic */ Context $context;
    final /* synthetic */ ECPromotionEntry $entry;
    final /* synthetic */ PageFinder $pageFinder;
    final /* synthetic */ Map $params;
    final /* synthetic */ boolean $showDisclaimer;
    final /* synthetic */ IronListHeaderEntryView $view;
    final /* synthetic */ i $viewModel;

    public ListHeaderJumpDispatcher$dispatchEntryJump$1(Context r1, boolean r2, Ref.ObjectRef r3, PageFinder r4, ECPromotionEntry r5, i r6, IronListHeaderEntryView r7, Map r8) {
        this.$context = r1;
        this.$showDisclaimer = r2;
        this.$btmModel = r3;
        this.$pageFinder = r4;
        this.$entry = r5;
        this.$viewModel = r6;
        this.$view = r7;
        this.$params = r8;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m779invoke() {
        int r0 = ListHeaderJumpDispatcher.a;
        Context r1 = this.$context;
        boolean r2 = this.$showDisclaimer;
        final Function0<Unit> r3 = new AnonymousClass1(this);
        if (r2 == false) goto L5;
        hh2.f.b().b(r1, new ListHeaderJumpDispatcher$checkLawHint$1(r3));
        return;
    L5:
        r3.invoke();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m779invoke();
        return Unit.INSTANCE;
    }
}
