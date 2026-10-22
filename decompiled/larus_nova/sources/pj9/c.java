package pj9;

import com.larus.livetutor.impl.tutor.fragment.LiveTutorBigImageViewerFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes30.dex */
public final class c implements j19.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTutorBigImageViewerFragment f529512a;

    @Override // j19.f
    public final void onDismiss() {
        Function0<Unit> r100 = this.f529512a.f356560i;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public c(LiveTutorBigImageViewerFragment r100) {
        this.f529512a = r100;
    }
}
