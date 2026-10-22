package com.larus.bmhome.chat.adapter;

import ic8.v;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes25.dex */
public interface i<DATA extends ic8.v> {
    List<DATA> getMessageList();

    Object k1(com.larus.bmhome.social.page.datasource.event.c<DATA> r100, Continuation<? super Unit> r101);

    void p1(com.larus.bmhome.social.page.datasource.diff.c<DATA> r100);

    void r1(com.larus.bmhome.social.page.datasource.diff.c<DATA> r100);
}
