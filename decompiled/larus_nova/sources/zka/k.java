package zka;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class k extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<List<String>, Unit> f572723a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Function1<List<String>, Unit> r101 = this.f572723a;
        String[] r102 = r100.getData().getStringArray("result");
        if (r102 == null) goto L6;
        List<String> r103 = ArraysKt.toList(r102);
        if (r103 == null) goto L6;
    L7:
        r101.invoke(r103);
        return;
    L6:
        r103 = CollectionsKt.emptyList();
        goto L7
    }

    public k(f r100, Looper r101) {
        this.f572723a = r100;
        super(r101);
    }
}
