package fp0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f478220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MiniAppEntranceCell f478221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f478222c;

    public a(Function2 r100, MiniAppEntranceCell r101, int r102) {
        this.f478220a = r100;
        this.f478221b = r101;
        this.f478222c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f478220a.invoke(this.f478221b, Integer.valueOf(this.f478222c));
    }
}
