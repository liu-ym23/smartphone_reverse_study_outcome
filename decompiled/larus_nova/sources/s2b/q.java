package s2b;

import android.view.View;
import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final class q implements g2b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f540408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a1 f540409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.a f540410c;

    @Override // g2b.c
    public final int b() {
        com.ss.android.lark.chat.chatwindow.chat.a r100 = this.f540410c;
        if (r100 != null) goto L5;
        return -1;
    L5:
        int r101 = r100.getItemCount() - 1;
    L6:
        if (r101 < 0) goto L23;
        y6b.c<?> r102 = this.f540410c.getItem(r101);
        a1 r103 = this.f540409b;
        if (r103 == null) goto L10;
        int r104 = r103.c(r102);
    L11:
        int r105 = this.f540408a;
        if (r104 == r105) goto L13;
        MessageFoldDetail r106 = r102.G;
        if (r106 == null) goto L22;
        if (r105 < r106.getRootMessagePosition()) goto L22;
        if (this.f540408a > r102.G.getLastMessagePosition()) goto L22;
        Log.i("MsgPosFinder", "getTargetItemPosition: find target position " + this.f540408a + " in fold interval , return position " + r104);
        return r101;
    L22:
        r101 = r101 - 1;
        goto L6
    L13:
        return r101;
    L10:
        r104 = r102.f566499n;
        goto L11
    L23:
        return -1;
    }

    @Override // g2b.c
    public final View a(View r100) {
        return com.ss.android.lark.chat.utils.p.a(r100);
    }

    public q(com.ss.android.lark.chat.chatwindow.chat.a r100, int r101) {
        this.f540408a = r101;
        this.f540410c = r100;
    }
}
