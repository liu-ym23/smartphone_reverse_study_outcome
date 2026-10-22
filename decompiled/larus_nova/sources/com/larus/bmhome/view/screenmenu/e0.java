package com.larus.bmhome.view.screenmenu;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes26.dex */
public interface e0 {
    void a(k0 r100, com.larus.bmhome.chat.manager.k r101);

    void b(k0 r100, Function0<Unit> r101);

    void c(k0 r100, Function0<Unit> r101);

    void setOnCopyWorkingDirectoryPathListener(Function0<Unit> r100);

    void setOnHideListener(Function0<Unit> r100);

    void setOnPinListener(Function0<Unit> r100);

    void setOnRefreshListener(Function0<Unit> r100);

    void setOnRemoveFromProjectListener(Function0<Unit> r100);

    void setOnShareMessageListener(Function0<Unit> r100);

    void setOnUnpinListener(Function0<Unit> r100);
}
