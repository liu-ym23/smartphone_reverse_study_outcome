package to1;

import com.bytedance.android.live.base.model.message.h1;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f546897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActivityTopBannerViewIntent.a f546898b;

    public e(a r100, ActivityTopBannerViewIntent.a r101) {
        this.f546897a = r100;
        this.f546898b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        a r102 = this.f546897a;
        h1 r103 = this.f546898b.f115104a;
        r102.getClass();
        BannerInRoomCollection.BannerInfo r104 = new BannerInRoomCollection.BannerInfo();
        String r105 = r103.getH5Url();
        String r106 = "";
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r104.setH5Url(r105);
        String r107 = r103.getLynxUrl();
        if (r107 == null) goto L9;
        r106 = r107;
    L9:
        r104.lynxUrl = r106;
        r104.setContainerType(r103.getContainerType());
        r104.setBannerList(null);
        String r108 = r104.getUrl();
        boolean r109 = false;
        if (r108 != null) goto L12;
    L15:
        boolean r110 = true;
    L16:
        if (r110 == false) goto L24;
        String r111 = r104.lynxUrl;
        if (r111 != null) goto L20;
    L21:
        r109 = true;
    L22:
        if (r109 == false) goto L24;
        r104 = null;
        goto L24
    L20:
        if (r111.length() != 0) goto L22;
    L24:
        if (r104 == null) goto L26;
        r104.isLoadMessageBanner = true;
        r104.loadMessageBannerJson = r101;
        this.f546897a.b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.h(r104, this.f546898b.f115104a.getOperationType()));
        return;
    L26:
        this.f546897a.b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("H5_roomStatusChange", r101));
        return;
    L12:
        if (r108.length() == 0) goto L15;
        r110 = false;
        goto L16
    }
}
