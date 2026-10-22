package g78;

import com.larus.audio.flow.client.FlowAsrClientImpl;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f480316a;

    public /* synthetic */ m(Function0 r100) {
        this.f480316a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r100 = this.f480316a;
        int r101 = FlowAsrClientImpl.E;
        r100.invoke();
    }
}
