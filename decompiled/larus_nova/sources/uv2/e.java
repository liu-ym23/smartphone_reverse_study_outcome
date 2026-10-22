package uv2;

import com.bytedance.android.livesdk.widget.ui.subscribe.SubscribeSelectPanel;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes11.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscribeSelectPanel f551807a;

    public e(SubscribeSelectPanel r100) {
        this.f551807a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        MultiTypeAdapter r102 = this.f551807a.f162197e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("multiAdapter");
    L5:
        r102.notifyDataSetChanged();
    }
}
