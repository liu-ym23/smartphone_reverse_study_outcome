package svb;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import kotlin.Unit;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes37.dex */
public final class b extends MviRepository<Unit, Object, c> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f543684j;

    public static final class a implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543685a;

        @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c
        public final i1<Unit> b() {
            return this.f543685a.g();
        }

        @Override // fvb.a
        public final void onDestroy() {
            this.f543685a.i();
        }

        public a(b r100) {
            this.f543685a = r100;
        }
    }

    public b() {
        this.f543684j = new a(this);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final /* bridge */ /* synthetic */ Unit a() {
        return Unit.INSTANCE;
    }
}
