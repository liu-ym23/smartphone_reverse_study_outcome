package com.bytedance.jedi.model.cache;

import com.bytedance.jedi.model.traceable.ITraceable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a2\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0003 \u0005*\u0018\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u00042 \u0010\u0006\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u00030\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "K", "", "V", "kotlin.jvm.PlatformType", "it", "Lcom/bytedance/jedi/model/traceable/ITraceable;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class IListCache$Companion$DataSourceImpl$observeAll$2 extends Lambda implements Function1<ITraceable<Pair<Object, ? extends List<Object>>>, Pair<Object, ? extends List<Object>>> {
    public static final IListCache$Companion$DataSourceImpl$observeAll$2 INSTANCE = null;

    static {
        INSTANCE = new IListCache$Companion$DataSourceImpl$observeAll$2();
    }

    public IListCache$Companion$DataSourceImpl$observeAll$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<Object, List<Object>> invoke2(ITraceable<Pair<Object, List<Object>>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.payload();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Pair<Object, ? extends List<Object>> invoke(ITraceable<Pair<Object, ? extends List<Object>>> r100) {
        return invoke2(r100);
    }
}
