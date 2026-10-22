package kgb;

import com.ss.android.lark.chat.export.entity.message.Content;
import java.util.Collection;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ngb.b;
import ngb.c;
import ngb.d;
import ngb.e;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements qxa.a<Unit, Collection<? extends gya.a<? extends Content>>> {
    public a() {
    }

    @Override // qxa.a
    public final Object a(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        return CollectionsKt.listOf(new gya.a[]{new ngb.a(), new b(), new e(), new c(), new d()});
    }
}
