package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.im.internal.jni.bean.OmniConversationSortType;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class b0<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OmniConversationSortType f345330a;

    public b0(OmniConversationSortType r100) {
        this.f345330a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(p.b((wc9.e) r100, this.f345330a)), Long.valueOf(p.b((wc9.e) r101, this.f345330a)));
    }
}
