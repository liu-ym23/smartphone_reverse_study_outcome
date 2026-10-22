package hd9;

import com.larus.im.internal.database.entity.MessageEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f484619a = null;

    public static final class a implements i {
        public a() {
        }

        @Override // hd9.i
        public final void a(Throwable r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "e");
        }
    }

    static {
        f484619a = new b();
    }

    public b() {
    }

    @Override // hd9.l
    public final String a(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "messageEntity");
        return "";
    }

    @Override // hd9.l
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dbName");
    }

    @Override // hd9.l
    public final k f() {
        return null;
    }

    @Override // hd9.l
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dbName");
    }

    @Override // hd9.l
    public final String c() {
        if (com.larus.im.internal.delegate.c.f348197a.k() == false) goto L5;
        return "im_database_";
    L5:
        return "imsdk_";
    }

    @Override // hd9.l
    public final i d() {
        return new a();
    }

    @Override // hd9.l
    public final m e() {
        return c.f484620a;
    }
}
