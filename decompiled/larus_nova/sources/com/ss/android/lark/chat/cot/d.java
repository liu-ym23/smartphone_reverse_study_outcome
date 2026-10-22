package com.ss.android.lark.chat.cot;

import com.ss.android.lark.chat.entity.message.CotEvent;
import com.ss.android.lark.chat.entity.message.CotEventType;
import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Grouping<CotEvent, CotEventType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f414799a;

    @Override // kotlin.collections.Grouping
    public final Iterator<CotEvent> sourceIterator() {
        return this.f414799a.iterator();
    }

    public d(Iterable r100) {
        this.f414799a = r100;
    }

    @Override // kotlin.collections.Grouping
    public final CotEventType keyOf(CotEvent r100) {
        return r100.getEventType();
    }
}
