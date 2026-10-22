package f6b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends u3b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f475727b;

    public static final class a {
    }

    static {
    }

    @Override // u3b.a
    public final String a() {
        return "ChatDestinationPreLoad_" + this.f475726a;
    }

    public b(String r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        this.f475726a = r100;
        this.f475727b = r101;
    }
}
