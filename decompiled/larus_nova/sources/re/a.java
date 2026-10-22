package re;

import com.bytedance.android.livesdkapi.commerce.param.ILivePromotionActionListener;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomFunctionHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements be.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f537393a;

    public a(b r100) {
        this.f537393a = r100;
    }

    @Override // be.b
    public final void onClickPromotion(String r100, String r101, String r102, JSONObject r103) {
        IBaseLiveRoomFunctionHandler r104 = this.f537393a.f537394a;
        if ((r104 instanceof ILiveRoomFunctionHandler) == false) goto L10;
        if (r104 == null) goto L8;
        ((ILivePromotionActionListener) ((ILiveRoomFunctionHandler) r104).getLogger(ILivePromotionActionListener.class)).onClickPromotion(r100, r101, r102, r103);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.room.handler.ILiveRoomFunctionHandler");
    L10:
        throw new Exception("realHandler must be ILiveRoomFunctionHandler");
    }
}
