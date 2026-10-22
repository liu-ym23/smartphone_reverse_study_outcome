package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final enum ListAddBiConsumer extends Enum<ListAddBiConsumer> implements BiFunction<List, Object, List> {
    public static final ListAddBiConsumer INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListAddBiConsumer[] f495043a = null;

    static {
        ListAddBiConsumer r100 = new ListAddBiConsumer();
        INSTANCE = r100;
        f495043a = new ListAddBiConsumer[]{r100};
    }

    public ListAddBiConsumer() {
        super("INSTANCE", 0);
    }

    public static ListAddBiConsumer[] values() {
        return (ListAddBiConsumer[]) f495043a.clone();
    }

    public static <T> BiFunction<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    public static ListAddBiConsumer valueOf(String r100) {
        return (ListAddBiConsumer) r27.a.a(ListAddBiConsumer.class, r100);
    }

    @Override // io.reactivex.functions.BiFunction
    public /* bridge */ /* synthetic */ List apply(List r100, Object r101) throws Exception {
        return apply2(r100, r101);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public List apply2(List r100, Object r101) throws Exception {
        r100.add(r101);
        return r100;
    }
}
