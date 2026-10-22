package nz;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.broadcast.api.BubblePosition;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemBubbleInfo;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes45.dex */
public interface h {
    CompositeDisposable a(Context r100, View r101, ItemBubbleInfo r102, BubblePosition r103);

    CompositeDisposable b(Context r100, View r101, String r102);
}
