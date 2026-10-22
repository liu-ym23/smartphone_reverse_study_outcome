package com.bytedance.locallife.pdp.container.view.lynx;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public interface LynxLoader {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/pdp/container/view/lynx/LynxLoader$LoadTimeoutException;", "", "()V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class LoadTimeoutException extends Throwable {
        public LoadTimeoutException() {
            super("timeoutForLoad");
        }
    }

    public interface a {
        Map<String, Object> a(String r100);

        Map<String, String> b();

        Map<String, Object> c();
    }

    public interface b {
        void a(i r100);

        void b(i r100, String r101, Map<String, ? extends Object> r102);

        void c(i r100);

        void d(Throwable r100);
    }

    public interface c {
        void a();
    }

    void cancel();
}
