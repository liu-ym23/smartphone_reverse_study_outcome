package vh1;

import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class s0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q1 f554924a;

    public /* synthetic */ s0(q1 r100) {
        this.f554924a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f554924a.onEvent((HorizontalPlayEvent) r100);
    }
}
