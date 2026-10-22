package com.bytedance.jedi.model.cache;

import com.bytedance.jedi.model.datasource.IDataSource;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/bytedance/jedi/model/datasource/IDataSource;", "K", "", "V", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AbstractListCache$dataSource$2 extends Lambda implements Function0<IDataSource<Object, List<Object>>> {
    final /* synthetic */ AbstractListCache<Object, Object> this$0;

    public AbstractListCache$dataSource$2(AbstractListCache<Object, Object> r100) {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final IDataSource<Object, List<Object>> invoke() {
        Intrinsics.checkNotNullParameter(null, "<this>");
        new IListCache$Companion$DataSourceImpl();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ IDataSource<Object, List<Object>> invoke() {
        return invoke();
    }
}
