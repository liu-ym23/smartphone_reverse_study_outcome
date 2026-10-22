package dn1;

import com.bytedance.android.livesdk.chatroom.event.ToolbarClearScreenEvent;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.PreviewCleanScreenUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f469281a = null;

    static {
        f469281a = new a();
    }

    public a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        PreviewCleanScreenUtils r100 = PreviewCleanScreenUtils.INSTANCE;     // Catch: Throwable -> L6
        if (r100.isPreviewCleanScreenEnter() == false) goto L9;
        r100.setPreviewCleanScreenEnter(false);     // Catch: Throwable -> L6
        r100.setIgnoreExitBtnAnimFrequencyLimit(true);     // Catch: Throwable -> L6
        xs2.b.a().post(new ToolbarClearScreenEvent(true, ClearScreenHelper.c()));     // Catch: Throwable -> L6
        ClearScreenLogUtils.f119492a.getClass();     // Catch: Throwable -> L6
        ClearScreenLogUtils.Companion.d(null, "preview_enter", null);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
