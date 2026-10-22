package com.ss.android.lark.biz.im.api.extension.list.footer;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/biz/im/api/extension/list/footer/DefaultRefreshContentView;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class DefaultRefreshFooter$loadingView$2 extends Lambda implements Function0<DefaultRefreshContentView> {
    final /* synthetic */ Context $context;

    public DefaultRefreshFooter$loadingView$2(Context r100) {
        this.$context = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DefaultRefreshContentView invoke() {
        return new DefaultRefreshContentView(this.$context, null, 0, 14);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ DefaultRefreshContentView invoke() {
        return invoke();
    }
}
