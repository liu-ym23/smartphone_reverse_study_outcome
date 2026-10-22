package i82;

import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.VSMsgBoardBadgeViewHolder;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f488585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VSMsgBoardBadgeViewHolder f488586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VSMsgBoardDress f488587c;

    public b(a r100, VSMsgBoardBadgeViewHolder r101, VSMsgBoardDress r102) {
        this.f488585a = r100;
        this.f488586b = r101;
        this.f488587c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f488586b.getAdapterPosition() == (-1)) goto L9;
        a.j(this.f488585a, 10, this.f488586b, this.f488587c);     // Catch: Throwable -> L6
        return;
    }
}
