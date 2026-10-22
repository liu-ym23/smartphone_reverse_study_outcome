package com.ss.office.sdk.kmp.core.ffi;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ukc.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/office/sdk/kmp/core/internal/KmpOfficeSDKGlobalApi;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeSDKLifeCycleFFI$globalApi$2 extends Lambda implements Function0<a> {
    public static final OfficeSDKLifeCycleFFI$globalApi$2 INSTANCE = null;

    static {
        INSTANCE = new OfficeSDKLifeCycleFFI$globalApi$2();
    }

    public OfficeSDKLifeCycleFFI$globalApi$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final a invoke2() {
        return new a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke2();
    }
}
