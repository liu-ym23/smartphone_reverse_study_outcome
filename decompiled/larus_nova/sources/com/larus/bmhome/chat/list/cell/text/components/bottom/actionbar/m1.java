package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import com.larus.im.bean.bot.AnswerAction;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class m1<T> implements Comparator {
    public m1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((AnswerAction) r100).getPosition(), ((AnswerAction) r101).getPosition());
    }
}
