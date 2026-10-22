package com.bytedance.bpea.entry.api.device.info;

import android.webkit.CookieManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class CookiesManagerEntry$Companion$getCookieUnsafe$1 extends Lambda implements Function0<String> {
    final /* synthetic */ CookieManager $this_getCookieUnsafe;
    final /* synthetic */ String $url;

    public CookiesManagerEntry$Companion$getCookieUnsafe$1(CookieManager r100, String r101) {
        this.$this_getCookieUnsafe = r100;
        this.$url = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return this.$this_getCookieUnsafe.getCookie(this.$url);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
