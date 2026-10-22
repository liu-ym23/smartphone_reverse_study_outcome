package com.larus.home.impl.main.side_bar.view.group.module;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class GroupModuleDeps$timeGroupArchiveHandler$2$1 extends FunctionReferenceImpl implements Function0<String> {
    public GroupModuleDeps$timeGroupArchiveHandler$2$1(Object r100) {
        super(0, r100, com.larus.home.impl.main.side_bar.view.b.class, "getCurrentPage", "getCurrentPage()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return ((com.larus.home.impl.main.side_bar.view.b) this.receiver).getCurrentPage();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
