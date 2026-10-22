package kr8;

import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes26.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f505892a = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            FLogger.f375446a.e("Music Edit Error", "sql execute err! msg=" + r101);
        }
    }

    static {
        f505892a = new a(CoroutineExceptionHandler.Key);
    }
}
