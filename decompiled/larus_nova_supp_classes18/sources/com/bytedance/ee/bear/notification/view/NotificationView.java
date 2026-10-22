package com.bytedance.ee.bear.notification.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.notice.UDNotice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NotificationView extends UDNotice {
    public b A;
    public com.bytedance.ee.bear.notification.view.a B;
    public String y;
    public a z;

    public interface a {
    }

    public interface b {
    }

    public List<String> getLinkUrls() {
        com.bytedance.ee.bear.notification.view.a r0 = this.B;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (hu5.a.d(r0.b) == true) goto L20;
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((ArrayList) this.B.b).iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        com.bytedance.ee.bear.notification.view.a.C0130a r3 = (com.bytedance.ee.bear.notification.view.a.C0130a) r2.next();
        if (TextUtils.isEmpty(r3.a) == true) goto L8;
        r1.add(r3.a);
        goto L8
    L12:
        return r1;
    L20:
        return null;
    }

    public String getNotificationId() {
        return this.y;
    }

    public NotificationView(Context r2) {
        this(r2, null);
    }

    public void setNoticeIcon(int r1) {
        setIcon(r1);
    }

    public void setOnCloseListener(a r1) {
        this.z = r1;
    }

    public void setOnLinkClickListener(b r1) {
        this.A = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int r2) {
        if (TextUtils.isEmpty(this.y) == false) goto L5;
        r2 = 8;
    L5:
        super/*android.view.ViewGroup*/.setVisibility(r2);
    }

    public NotificationView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public NotificationView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setIconColorful(true);
        setIcon(2131253863);
        setIconButton(2131254121);
        setIconButtonListener(new ek5.a(this));
        setVisibility(8);
    }
}
