package i82;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.VSMsgBoardSkinViewHolder;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f488602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f488603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VSMsgBoardDress f488604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ VSMsgBoardSkinViewHolder f488605d;

    public h(g r100, boolean r101, VSMsgBoardDress r102, VSMsgBoardSkinViewHolder r103) {
        this.f488602a = r100;
        this.f488603b = r101;
        this.f488604c = r102;
        this.f488605d = r103;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 != 0) goto L5;
        r100.setAlpha(0.8f);
    L21:
        return true;
    L5:
        if (r102 != 1) goto L7;
        r100.setAlpha(1.0f);
        if ((r101.getEventTime() - r101.getDownTime()) >= ViewConfiguration.getLongPressTimeout()) goto L21;
        if (this.f488603b == true) goto L15;
        this.f488602a.f488596c = String.valueOf(this.f488604c.getDressId());
    L15:
        i r103 = this.f488602a.f488601h;
        if (r103 == null) goto L18;
        r103.j(this.f488604c);
    L18:
        this.f488602a.f513439a.notifyDataSetChanged();
        this.f488602a.j(300, this.f488605d, this.f488604c);
        return true;
    L7:
        if (r102 != 3) goto L21;
        r100.setAlpha(1.0f);
        goto L21
    }
}
