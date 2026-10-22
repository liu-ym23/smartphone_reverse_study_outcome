package i82;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f488592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VSMsgBoardDress f488593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f488594c;

    public e(f r100, VSMsgBoardDress r101, View r102) {
        this.f488592a = r100;
        this.f488593b = r101;
        this.f488594c = r102;
    }

    public final void a() {
        CopyOnWriteArrayList<String> r100 = this.f488592a.f488595b;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<String> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L13;
        String r102 = r101.next();
        if (String.valueOf(this.f488593b.getDressId()).equals(r102) == false) goto L9;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L28;
        CopyOnWriteArrayList<String> r104 = this.f488592a.f488595b;
        VSMsgBoardDress r105 = this.f488593b;
        if (r105 == null) goto L18;
        Long r106 = Long.valueOf(r105.getDressId());
    L19:
        r104.add(String.valueOf(r106.longValue()));
        f r107 = this.f488592a;     // Catch: Exception -> L22
        View r108 = this.f488594c;     // Catch: Exception -> L22
        VSMsgBoardDress r109 = this.f488593b;     // Catch: Exception -> L22
        r107.h(r109);     // Catch: Exception -> L22
        r107.i(r108, r109);     // Catch: Exception -> L22
        return;
    L29:
        return;
    L18:
        r106 = null;
        goto L19
    L28:
        return;
    L13:
        r103 = false;
        goto L14
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
