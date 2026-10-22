package com.bytedance.ee.bear.bitable.uikit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/NativeAction;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "nativeAction", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getNativeAction", "()Ljava/lang/String;", "setNativeAction", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NativeAction extends Action {
    private String nativeAction;

    @Override // com.bytedance.ee.bear.bitable.uikit.Action
    public String getNativeAction() {
        return this.nativeAction;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.Action
    public void setNativeAction(String r100) {
        this.nativeAction = r100;
    }

    public NativeAction(String r100, String r101) {
        Action.Companion.getClass();
        super(r101, Action.access$getTYEP_NATIVE_PROXY_ACTION$cp());
        this.nativeAction = r100;
    }

    public /* synthetic */ NativeAction(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, r101);
    }
}
