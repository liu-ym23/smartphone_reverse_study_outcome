package vh7;

import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import vh7.c;

/* JADX INFO: loaded from: classes22.dex */
public interface c<SELF extends c<SELF>> {

    public interface a<SELF extends c<SELF>> extends c<SELF> {
        @Override // vh7.c
        /* synthetic */ <R extends e<SELF>> R castTo(Class<R> r100);

        @Override // vh7.c
        /* synthetic */ <R extends e<SELF>> R castToOrNull(Class<R> r100);

        FlexModelDelegate<SELF> getDelegate();
    }

    <R extends e<SELF>> R castTo(Class<R> r100);

    <R extends e<SELF>> R castToOrNull(Class<R> r100);
}
