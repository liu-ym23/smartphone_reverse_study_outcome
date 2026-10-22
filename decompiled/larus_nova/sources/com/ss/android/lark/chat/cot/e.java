package com.ss.android.lark.chat.cot;

import com.ss.android.lark.chat.entity.message.CotEventType;
import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class e<T> implements Comparator {
    public e() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((CotEventType) ((Map.Entry) r100).getKey()).name(), ((CotEventType) ((Map.Entry) r101).getKey()).name());
    }
}
