package ay3;

import android.animation.AnimatorSet;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.base.view.xtoast.XToast;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends Handler {
    public static c b;
    public final Queue<XToast> a;

    public final void a() {
        if (this.a.isEmpty() == false) goto L5;
        return;
    L5:
        XToast r0 = (XToast) ((LinkedList) this.a).peek();
        View r1 = r0.c;
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L14;
        Message r3 = Message.obtain();
        r3.what = 291;
        r3.obj = r0;
        sendMessage(r3);
        return;
    L14:
        return;
    L8:
        if (r1.getParent() == null) goto L10;
        r2 = true;
        goto L11
    }

    public c(Looper r1) {
        super(r1);
        this.a = new LinkedList();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r6) {
        XToast r0 = (XToast) r6.obj;
        int r7 = r6.what;
        boolean r1 = true;
        if (r7 == 291) goto L21;
        if (r7 != 1110) goto L6;
        View r8 = r0.c;
        if (r8 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == true) goto L18;
        ((LinkedList) this.a).remove(r0);
        return;
    L18:
        if (((LinkedList) this.a).contains(r0) == false) goto L35;
        AnimatorSet r9 = r0.f;
        r9.addListener(new b(this, r0));
        r9.start();
        ((LinkedList) this.a).poll();
        return;
    L35:
        return;
    L12:
        if (r8.getParent() == null) goto L14;
    L6:
        if (r7 != 1929) goto L34;
        a();
        return;
    L34:
        return;
    L21:
        View r10 = r0.c;
        if (r10 != null) goto L24;
    L26:
        r1 = false;
    L27:
        if (r1 == true) goto L36;
        r0.b.addView(r0.c);
        r0.e.start();
        Message r11 = Message.obtain();
        r11.what = 1110;
        r11.obj = r0;
        sendMessageDelayed(r11, r0.h);
        return;
    L36:
        return;
    L24:
        if (r10.getParent() == null) goto L26;
        goto L26
    }
}
