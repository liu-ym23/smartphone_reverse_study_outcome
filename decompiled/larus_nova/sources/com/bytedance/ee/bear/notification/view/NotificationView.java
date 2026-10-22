package com.bytedance.ee.bear.notification.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class NotificationView extends UDNotice {
    public b A;
    public com.bytedance.ee.bear.notification.view.a B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f235145y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f235146z;

    public interface a {
    }

    public interface b {
    }

    public List<String> getLinkUrls() {
        com.bytedance.ee.bear.notification.view.a r100 = this.B;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (hu5.a.d(r100.f235148b) == true) goto L20;
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((ArrayList) this.B.f235148b).iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        com.bytedance.ee.bear.notification.view.a.C3377a r103 = (com.bytedance.ee.bear.notification.view.a.C3377a) r102.next();
        if (TextUtils.isEmpty(r103.f235149a) == true) goto L8;
        r101.add(r103.f235149a);
        goto L8
    L12:
        return r101;
    L20:
        return null;
    }

    public String getNotificationId() {
        return this.f235145y;
    }

    public NotificationView(Context r100) {
        this(r100, null);
    }

    public void setNoticeIcon(int r100) {
        setIcon(r100);
    }

    public void setOnCloseListener(a r100) {
        this.f235146z = r100;
    }

    public void setOnLinkClickListener(b r100) {
        this.A = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        if (TextUtils.isEmpty(this.f235145y) == false) goto L5;
        r100 = 8;
    L5:
        super.setVisibility(r100);
    }

    public NotificationView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public NotificationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setIconColorful(true);
        setIcon(R.drawable.ud_icon_boards_colorful);
        setIconButton(R.drawable.ud_icon_close_filled);
        setIconButtonListener(new ek5.a(this));
        setVisibility(8);
    }
}
