package yc2;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.LiveProfileManageDialogV2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showProfileManageDialog")
public final class f extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lyc2/f$a;", "", "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/base/model/user/User;", "setUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", "", "vertical", "Z", "b", "()Z", "setVertical", "(Z)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("user")
        private User user;

        @SerializedName("vertical")
        private boolean vertical;

        public a() {
        }

        public final User a() {
            return this.user;
        }

        public final boolean b() {
            return this.vertical;
        }
    }

    public f() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r110, CallContext r111) {
        a r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r101 = r111.getContext();
        int r102 = ita.i.f495747a;
        if (NetworkUtils.isNetworkAvailable(r101) == true) goto L5;
        f2.b(R.string.ttlive_core_network_unavailable, 0);
        terminate();
    L5:
        User r103 = r100.a();
        Room r104 = ((IRoomService) k.n(IRoomService.class)).getCurrentRoom();
        IUser r105 = ((IUserService) k.n(IUserService.class)).user().b();
        Context r106 = r111.getContext();
        o0.a r107 = o0.f58946a;
        String r108 = r105.getIdString();
        if (r103 == null) goto L8;
        String r109 = r103.getIdStr();
    L9:
        r107.getClass();
        LiveProfileManageDialogV2 r112 = new LiveProfileManageDialogV2(r106, r104, r103, o0.a.a(r108, r109), r100.b(), false, null, null, false, null, 992);
        if (DialogLancet.shouldBlockDialogShow(r112) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r112);
    L15:
        return Unit.INSTANCE;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        DialogLancet.beforeDialogShow(r112);
        r112.show();
        DialogLancet.afterDialogShow(r112);
        goto L15
    L8:
        r109 = null;
        goto L9
    }
}
