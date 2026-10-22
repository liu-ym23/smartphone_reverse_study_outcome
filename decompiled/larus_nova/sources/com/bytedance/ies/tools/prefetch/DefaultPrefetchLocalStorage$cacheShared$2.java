package com.bytedance.ies.tools.prefetch;

import android.content.SharedPreferences;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class DefaultPrefetchLocalStorage$cacheShared$2 extends Lambda implements Function0<SharedPreferences> {
    final /* synthetic */ String $spKey;
    final /* synthetic */ e this$0;

    public DefaultPrefetchLocalStorage$cacheShared$2(e r100, String r101) {
        this.this$0 = r100;
        this.$spKey = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SharedPreferences invoke() {
        e r100 = this.this$0;
        KProperty[] r101 = e.f248811a;
        r100.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SharedPreferences invoke() {
        return invoke();
    }
}
