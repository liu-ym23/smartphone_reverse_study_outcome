package com.bytedance.kmp.livesdk.gift.platform.resourcemanager;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class GiftResourceManager$onProgress$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $progress;
    final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e $request;
    final /* synthetic */ GiftResourceManager this$0;

    public GiftResourceManager$onProgress$1(GiftResourceManager r100, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r101, int r102) {
        this.this$0 = r100;
        this.$request = r101;
        this.$progress = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map<Long, f> r100 = this.this$0.f252388b;
        ConcurrentHashMap r101 = (ConcurrentHashMap) r100;
        f r102 = (f) r101.get(Long.valueOf(this.$request.f129099i));
        if (r102 == null) goto L10;
        List<c> r103 = r102.b();
        if (r103 == null) goto L12;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        ((c) r104.next()).onProgress(this.$progress);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
