package com.ss.office.sdk.kmp.core;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tkc.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/office/sdk/kmp/core/channel/IOfficeSDKArkTsChannel;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeSDKCore$channel$2 extends Lambda implements Function0<a> {
    public static final OfficeSDKCore$channel$2 INSTANCE = null;

    static {
        INSTANCE = new OfficeSDKCore$channel$2();
    }

    public OfficeSDKCore$channel$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final a invoke2() {
        throw new UnsupportedOperationException("OfficeSDK KMP facade is ohos-only; Android hosts should use the Android OfficeSDK directly.");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        invoke2();
        return null;
    }
}
