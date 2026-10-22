package f77;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.utils.f;
import com.ss.android.message.AppProvider;
import com.ss.android.pushmanager.setting.b;
import v67.k;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f475773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f475774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IPushCommonConfiguration f475775c;

    public a() {
        this.f475773a = AppProvider.getApp();
        b.b().getClass();
        Boolean r100 = Boolean.valueOf(b.d().g());
        this.f475774b = r100;
        PushCommonConfiguration r101 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        if (r101 == null) goto L5;
        this.f475775c = r101.mIPushCommonConfiguration;
    L6:
        f.b("ProfileIdServiceImpl", "[ProfileIdServiceImpl]mAllowProfileId is " + r100 + " mIPushCommonConfiguration is " + this.f475775c);
        return;
    L5:
        this.f475775c = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String b(IPushAdapter r100) {
        if (this.f475774b.booleanValue() == true) goto L5;
    L20:
        return null;
    L5:
        if ((r100 instanceof com.bytedance.push.third.b) == false) goto L20;
        IPushCommonConfiguration r101 = this.f475775c;
        if (r101 == null) goto L20;
        String r102 = r101.getProfileId();
        if (TextUtils.isEmpty(r102) == true) goto L20;
        b.b().getClass();
        String r103 = b.c().T();
        if (TextUtils.isEmpty(r103) == false) goto L13;
    L17:
        f.b("ProfileIdServiceImpl", "setProfileId for " + r100);
        if (((com.bytedance.push.third.b) r100).setProfileId(this.f475773a, r102) == false) goto L20;
        b.b().getClass();
        b.c().Z(r102);
        return r102;
    L13:
        if (TextUtils.equals(r103, r102) == false) goto L16;
        f.b("ProfileIdServiceImpl", "needn't set profile id because lastProfileId==profileIdFromHost");
        return r103;
    L16:
        f.b("ProfileIdServiceImpl", "remove last profile id because lastProfileId!=profileIdFromHost");
        a(r100, false);
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(IPushAdapter r100, boolean r101) {
        if ((r100 instanceof com.bytedance.push.third.b) == true) goto L5;
        return;
    L5:
        if (this.f475774b.booleanValue() == true) goto L7;
        if (r101 == true) goto L7;
        return;
    L7:
        b.b().getClass();
        String r102 = b.c().T();
        if (TextUtils.isEmpty(r102) == true) goto L15;
        f.b("ProfileIdServiceImpl", "removeProfileId for " + r100);
        if (((com.bytedance.push.third.b) r100).deleteProfileId(this.f475773a, r102) == false) goto L16;
        b.b().getClass();
        b.c().Z("");
        return;
    L16:
        return;
    }
}
