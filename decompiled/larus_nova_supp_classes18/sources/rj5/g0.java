package rj5;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.more.itemv2.ShortcutItemV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class g0 implements Runnable {
    public final /* synthetic */ ShortcutItemV2.a a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ g0(ShortcutItemV2.a r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ShortcutItemV2.a r0 = this.a;
        if (this.b == false) goto L5;
        String r1 = ShortcutItemV2.access$000(r0.b).getString(2131888018);
    L6:
        Toast.showSuccessText(ShortcutItemV2.access$000(r0.b), r1, 0);
        r0.b.getHost().a();
        return;
    L5:
        r1 = ShortcutItemV2.access$000(r0.b).getString(2131888028);
        goto L6
    }
}
