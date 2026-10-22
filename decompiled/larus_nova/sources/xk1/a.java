package xk1;

import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes7.dex */
public class a implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f564125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f564126b;

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100.what != 110) goto L12;
        o r101 = this.f564126b;
        if (r101 == null) goto L13;
        tp1.a r102 = r101.f564172b;
        if (r102 == null) goto L14;
        tp1.b r103 = r102.f547013n;
        System.currentTimeMillis();
        r103.getClass();
        this.f564126b.c(5);
        p r104 = this.f564125a;
        if (r104 == null) goto L15;
        i.a r105 = (i.a) r104;
        r105.b(this.f564126b.a(), ((Long) r100.obj).longValue());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public a(o r100, p r101) {
        new WeakHandler(Looper.getMainLooper(), this);
        this.f564125a = r101;
        this.f564126b = r100;
    }
}
