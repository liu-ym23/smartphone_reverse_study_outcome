package vh1;

import androidx.activity.result.ActivityResultCaller;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class v1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.room.b f554940a;

    @Override // java.lang.Runnable
    public final void run() {
        ActivityResultCaller r100 = this.f554940a.f510501h;     // Catch: Throwable -> L6
        if ((r100 instanceof com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.c) == false) goto L9;
        ((com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.c) r100).Ea().Di();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public v1(com.bytedance.android.livesdk.room.b r100) {
        this.f554940a = r100;
    }
}
