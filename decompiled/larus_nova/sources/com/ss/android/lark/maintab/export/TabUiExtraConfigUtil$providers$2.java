package com.ss.android.lark.maintab.export;

import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/maintab/export/expand/ITabUiExtraConfigProvider;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class TabUiExtraConfigUtil$providers$2 extends Lambda implements Function0<List<? extends xqb.a>> {
    public static final TabUiExtraConfigUtil$providers$2 INSTANCE = null;

    static {
        INSTANCE = new TabUiExtraConfigUtil$providers$2();
    }

    public TabUiExtraConfigUtil$providers$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends xqb.a> invoke2() {
        return SequencesKt.toList(SequencesKt.asSequence(PluginServiceLoader.loadAll(xqb.a.class)));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends xqb.a> invoke() {
        return invoke2();
    }
}
