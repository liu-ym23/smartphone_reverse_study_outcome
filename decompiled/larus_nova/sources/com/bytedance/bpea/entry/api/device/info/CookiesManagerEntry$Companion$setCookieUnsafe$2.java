package com.bytedance.bpea.entry.api.device.info;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class CookiesManagerEntry$Companion$setCookieUnsafe$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ValueCallback $callback;
    final /* synthetic */ CookieManager $this_setCookieUnsafe;
    final /* synthetic */ String $url;
    final /* synthetic */ String $value;

    public CookiesManagerEntry$Companion$setCookieUnsafe$2(CookieManager r100, String r101, String r102, ValueCallback r103) {
        this.$this_setCookieUnsafe = r100;
        this.$url = r101;
        this.$value = r102;
        this.$callback = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$this_setCookieUnsafe.setCookie(this.$url, this.$value, this.$callback);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
