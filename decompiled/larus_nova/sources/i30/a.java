package i30;

import android.app.Activity;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.google.gson.annotations.SerializedName;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends g<C6221a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SettingKey<Boolean> f488080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f488081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f488082c;

    /* JADX INFO: renamed from: i30.a$a, reason: collision with other inner class name */
    public static class C6221a {

        @SerializedName("enter_live_source")
        public String enterLiveSource;

        @SerializedName("room_id")
        public long roomId;

        @SerializedName("user_id")
        public String userId;

        public C6221a() {
        }
    }

    public a(Activity r100, DataCenter r101) {
        Boolean r102 = Boolean.TRUE;
        SettingKey<Boolean> r103 = new SettingKey("live_fix_gotolive_jsb_ctx_mml", "修复GotoLiveMethod context内测泄露", r102, r102);
        this.f488080a = r103;
        if (r103.getValue().booleanValue() == true) goto L5;
        this.f488081b = r100;
    L5:
        this.f488082c = r101;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(C6221a r100, CallContext r101) throws Exception {
        C6221a r102 = r100;
        if (this.f488080a.getValue().booleanValue() == true) goto L5;
        ((IRoomService) k.f(IRoomService.class)).gotoLiveByProfile(this.f488081b, this.f488082c, r102.enterLiveSource, r102.userId, r102.roomId);
        return null;
    L5:
        Activity r103 = ContextUtil.contextToActivity(r101.getContext());
        if (r103 == null) goto L11;
        ((IRoomService) k.f(IRoomService.class)).gotoLiveByProfile(r103, this.f488082c, r102.enterLiveSource, r102.userId, r102.roomId);
        return null;
    L11:
        return null;
    }
}
