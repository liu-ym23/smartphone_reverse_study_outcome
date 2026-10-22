package com.ss.android.lark.passport.auth;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IPassportAuthHeaderServiceKt$appendCookies$extra$1 extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, CharSequence> {
    public static final IPassportAuthHeaderServiceKt$appendCookies$extra$1 INSTANCE = null;

    static {
        INSTANCE = new IPassportAuthHeaderServiceKt$appendCookies$extra$1();
    }

    public IPassportAuthHeaderServiceKt$appendCookies$extra$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Map.Entry<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.getKey() + com.alipay.sdk.m.n.a.f25612h + r100.getValue();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends String> r100) {
        return invoke2(r100);
    }
}
