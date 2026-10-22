package qbc;

import com.ss.android.lark.chat.export.entity.message.Content;
import java.util.Collection;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements qxa.a<Unit, Collection<? extends gya.a<? extends Content>>> {
    public d() {
    }

    @Override // qxa.a
    public final Object a(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        return CollectionsKt.listOf(new c());
    }
}
