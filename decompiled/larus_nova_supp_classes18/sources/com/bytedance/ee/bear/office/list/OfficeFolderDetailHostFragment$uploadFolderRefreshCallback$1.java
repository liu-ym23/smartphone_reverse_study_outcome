package com.bytedance.ee.bear.office.list;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class OfficeFolderDetailHostFragment$uploadFolderRefreshCallback$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public OfficeFolderDetailHostFragment$uploadFolderRefreshCallback$1(Object r8) {
        super(0, r8, OfficeFolderDetailHostFragment.class, "refreshCurrentListAfterSelectorResult", "refreshCurrentListAfterSelectorResult()Z", 0);
    }

    public final Boolean invoke() {
        OfficeFolderDetailHostFragment r0 = (OfficeFolderDetailHostFragment) ((CallableReference) this).receiver;
        int r1 = OfficeFolderDetailHostFragment.t;
        return Boolean.valueOf(r0.ba0());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m363invoke() {
        return invoke();
    }
}
