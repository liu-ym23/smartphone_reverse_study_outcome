package ie8;

import com.larus.im.bean.message.Message;
import ei9.f;
import kc8.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f489498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f489499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f489500c;

    public int a() {
        return this.f489499b;
    }

    public a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f489498a = r100;
        this.f489499b = 1;
    }
}
