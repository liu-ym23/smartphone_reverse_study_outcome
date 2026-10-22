package com.bytedance.ee.bear.bitable.uikit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/NativeAction;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "nativeAction", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getNativeAction", "()Ljava/lang/String;", "setNativeAction", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NativeAction extends Action {
    private String nativeAction;

    @Override // com.bytedance.ee.bear.bitable.uikit.Action
    public String getNativeAction() {
        return this.nativeAction;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.Action
    public void setNativeAction(String r1) {
        this.nativeAction = r1;
    }

    public NativeAction(String r2, String r3) {
        Action.Companion.getClass();
        super(r3, Action.access$getTYEP_NATIVE_PROXY_ACTION$cp());
        this.nativeAction = r2;
    }

    public /* synthetic */ NativeAction(String r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1, r2);
    }
}
