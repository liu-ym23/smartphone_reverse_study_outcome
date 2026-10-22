package ra5;

import com.bytedance.ee.bear.contract.y;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.ss.android.lark.doc.IDocCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends com.bytedance.ee.bear.basesdk.apiimpl.b {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(DocCallbackImpl r2) {
        if (eu5.g.j() == false) goto L6;
        y.a = IDocCallback.Stub.asInterface(r2);
        return;
    }
}
