package zn1;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.livesdk.chatroom.tetris.service.HybridBottomPanelManagerWidget;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridBottomPanelManagerWidget f572911a;

    public e(HybridBottomPanelManagerWidget r100) {
        this.f572911a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        if (r101 == null) goto L8;
        HybridDialog r102 = this.f572911a.f111841a;
        if (r102 == null) goto L9;
        r102.sendJsEvent("H5_roomStatusChange", r101);
        return;
    L9:
        return;
    }
}
