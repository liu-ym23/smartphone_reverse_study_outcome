package ij9;

import com.larus.livetutor.api.idl.StartCallRequest;
import com.larus.livetutor.impl.rtc.handler.m;
import com.larus.livetutor.impl.rtc.handler.v;
import com.larus.livetutor.impl.rtc.handler.w;
import com.larus.livetutor.impl.rtc.k0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f490146a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f490147a = null;

        static {
            f490147a = new a();
        }

        public a() {
        }
    }

    static {
        f490146a = a.f490147a;
    }

    m a();

    void b(StartCallRequest r100, CoroutineScope r101, k0 r102);

    v c();

    w d();
}
