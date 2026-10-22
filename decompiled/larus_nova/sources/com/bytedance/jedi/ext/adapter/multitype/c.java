package com.bytedance.jedi.ext.adapter.multitype;

import com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public interface c<VH extends MultiTypeViewHolder<?>> {

    public static final class a {
        public static /* synthetic */ void a(ViewHolderFactoryManager r100, Function1 r101, Function1 r102, int r103) {
            if ((r103 & 1) == 0) goto L5;
            r101 = ViewHolderFactoryRegistry$register$1.INSTANCE;
        L5:
            r100.f(r101, null, r102);
        }
    }
}
