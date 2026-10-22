package v5b;

import com.ss.android.lark.chat.export.entity.message.Content;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a<T extends Content> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f553338a;

    public a(T r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f553338a = r100;
    }

    public String c(c<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        return r100.g();
    }

    public boolean d(a<?> r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        T r101 = this.f553338a;
        if (r101 != null) goto L8;
        return false;
    L8:
        return r101.isContentSame(r100.f553338a);
    }
}
