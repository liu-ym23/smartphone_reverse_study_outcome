package com.ss.android.ainote;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AINotesSession$purgeRemoteDeletedNotes$1$1 extends FunctionReferenceImpl implements Function1<Long, j.a> {
    public AINotesSession$purgeRemoteDeletedNotes$1$1(Object r100) {
        super(1, r100, j.class, "getNoteDraft", "getNoteDraft(J)Lcom/ss/android/ainote/AINoteDraftStore$AINoteDraft;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ j.a invoke(Long r100) {
        return invoke(r100.longValue());
    }

    public final j.a invoke(long r100) {
        return ((j) this.receiver).p(r100);
    }
}
