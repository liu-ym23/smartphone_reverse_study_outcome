package zn1;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.livesdk.chatroom.tetris.service.HybridBottomPanelManagerWidget;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridBottomPanelManagerWidget f572908a;

    public b(HybridBottomPanelManagerWidget r100) {
        this.f572908a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        Intrinsics.checkNotNullParameter(r101, "json");
        HybridDialog r102 = this.f572908a.f111841a;
        if (r102 == null) goto L6;
        r102.sendJsEvent("H5_roomStatusChange", r101);
        return;
    }
}
