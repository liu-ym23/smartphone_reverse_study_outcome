package oic;

import android.graphics.Rect;
import com.ss.android.videoshop.mediaview.SimpleMediaView;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements nic.a {
    public a() {
    }

    @Override // nic.a
    public final void b(SimpleMediaView r100) {
    }

    @Override // nic.a
    public final void c(SimpleMediaView r100) {
        if (r100.i() == true) goto L6;
        fjc.d.b(r100.getPlayEntity(), "scroll_out");
        r100.m();
        ajc.b.c("DefaultAttachListener", "detachCurrent release simpleMediaView:" + hashCode());
        return;
    }

    @Override // nic.a
    public final void a(SimpleMediaView r100, boolean r101) {
        ajc.b.c("DefaultAttachListener", "onScrollVisibilityChange visible:" + r101 + " simpleMediaView:" + hashCode());
        if (r101 == false) goto L5;
        return;
    L5:
        if (r100.i() == true) goto L9;
        Rect r102 = new Rect();
        r100.getGlobalVisibleRect(r102);
        ajc.b.a("DefaultAttachListener", "onScrollVisibilityChange release simpleMediaView show:" + r100.isShown() + " globalrect:" + r102.toShortString());
        fjc.d.b(r100.getPlayEntity(), "scroll_out");
        r100.m();
        return;
    }
}
