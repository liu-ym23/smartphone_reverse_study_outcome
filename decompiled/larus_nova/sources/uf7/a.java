package uf7;

import com.bytedance.supervisor.token.AtomicInfoDef;
import com.bytedance.supervisor.token.Token;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import of7.b;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f549952a = 0;

    static {
    }

    public static void a(Token r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        rf7.a.a(r100, new b(CollectionsKt.listOf(AtomicInfoDef.MEDIA_SCANNER_SCAN_FILE)));
    }
}
