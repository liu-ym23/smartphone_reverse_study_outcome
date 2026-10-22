package com.bytedance.cukaie.closet.internal;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class KevaSpStore$keva$2 extends Lambda implements Function0<Keva> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $repoName;

    public KevaSpStore$keva$2(Context r100, String r101) {
        this.$context = r100;
        this.$repoName = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Keva invoke() {
        return Keva.getRepoFromSp(this.$context, this.$repoName, 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Keva invoke() {
        return invoke();
    }
}
