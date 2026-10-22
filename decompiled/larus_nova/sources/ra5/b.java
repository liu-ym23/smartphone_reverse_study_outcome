package ra5;

import com.bytedance.ee.bear.contract.y;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.ss.android.lark.doc.IDocCallback;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends com.bytedance.ee.bear.basesdk.apiimpl.b {
    public b() {
    }

    public final void a(DocCallbackImpl r100) {
        if (eu5.g.j() == false) goto L6;
        y.f217209a = IDocCallback.Stub.asInterface(r100);
        return;
    }
}
