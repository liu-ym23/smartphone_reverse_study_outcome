package l65;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNDestroyData;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamInvoke;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamSendEvent;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends com.bytedance.ee.bear.doc.follow.impl.d {
    public final String b;
    public final String c;
    public final py4.e d;

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final void k() {
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final String m() {
        return "CCMFollow_DriveAttachmentFollowAdapter";
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final void n(RNDestroyData r1) {
    }

    @Override // py4.j
    public final py4.e c() {
        return this.d;
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final void o(RNParamInvoke r2) {
        onCallVCFollow("javascript:lark.biz.vcfollow.invoke", r2);
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final void q(RNParamSendEvent r2) {
        onCallVCFollow("javascript:lark.biz.vcfollow.sendEvent", r2);
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final void r(RNParamRegisterEventHandler r2) {
        onCallVCFollow("javascript:lark.biz.vcfollow.unRegisterEventHandler", r2);
    }

    public c(String r2, String r3) {
        this.d = new py4.e();
        this.b = r2;
        this.c = r3;
    }

    @Override // py4.b
    public final void onCallVCFollow(String r2, NonProguard r3) {
        this.a.onCallVCFollow(r2, r3);
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final void p(RNParamRegisterEventHandler r2, ry4.a r3) {
        onCallVCFollow("javascript:lark.biz.vcfollow.registerEventHandler", r2, r3);
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.d
    public final String l(String r3, String r4, String r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.c);
        r0.append(OfflineDoc.DASH_DELIMITER);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        r3 = this.b;
    L5:
        r0.append(r3);
        String r6 = r0.toString();
        int r1 = py4.e.d;
        return py4.e.a.a(r6, r4, r5);
    }

    @Override // py4.b
    public final void onCallVCFollow(String r2, NonProguard r3, ry4.a r4) {
        this.a.onCallVCFollow(r2, r3, r4);
    }
}
