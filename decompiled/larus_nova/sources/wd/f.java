package wd;

import com.bytedance.android.ec.adapter.api.handler.viewinterface.ECExternalViewGroupAction;
import com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.StartLivePromotionButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes43.dex */
public interface f {
    void a(StartLivePromotionButton r100);

    void addListener(Function3<? super f, ? super e, ? super ECExternalViewGroupAction, Unit> r100);

    void b(StartLivePromotionButton r100);

    void removeListener(Function3<? super f, ? super e, ? super ECExternalViewGroupAction, Unit> r100);
}
