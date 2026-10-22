package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import android.text.TextPaint;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class KmpMessagePayloadCell$onBindView$highlightedSubtitle$1 extends FunctionReferenceImpl implements Function1<String, Float> {
    public KmpMessagePayloadCell$onBindView$highlightedSubtitle$1(Object r100) {
        super(1, r100, TextPaint.class, "measureText", "measureText(Ljava/lang/String;)F", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Float invoke2(String r100) {
        return Float.valueOf(((TextPaint) this.receiver).measureText(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Float invoke(String r100) {
        return invoke2(r100);
    }
}
