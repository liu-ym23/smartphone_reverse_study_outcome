package com.larksuite.component.dynamicresources;

import java.io.Serializable;

/* JADX INFO: loaded from: classes24.dex */
public interface DynamicResourcesFacade$ChangeResourcesExecutor extends Serializable {

    public interface a<T> {
        void run();
    }

    public interface b<T> {
        T run();
    }

    <T> void execute(b<T> r100, a<T> r101);
}
