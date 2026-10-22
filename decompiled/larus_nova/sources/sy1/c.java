package sy1;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f543862a;

    public c(View r100) {
        this.f543862a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        if (this.f543862a.getVisibility() == 0) goto L5;
        return;
    L5:
        if (this.f543862a.getTranslationY() == 0.0f) goto L9;
        UtilityKotlinExtentionsKt.t(this.f543862a);
        return;
    }
}
