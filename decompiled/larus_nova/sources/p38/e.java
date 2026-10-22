package p38;

import com.larus.login.impl.s3;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import n38.s;

/* JADX INFO: loaded from: classes24.dex */
public final class e extends va7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f527600a;

    public e(s3 r100) {
        this.f527600a = r100;
    }

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        xa7.e r101 = (xa7.e) r100;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("getAvailableVerifyWays isHasOauth:");
        List<String> r104 = null;
        if (r101 == null) goto L5;
        Boolean r105 = Boolean.valueOf(r101.f563076s);
    L6:
        r103.append(r105);
        r103.append(" oauthPlatforms:");
        if (r101 == null) goto L9;
        List<String> r106 = r101.f563080w;
    L10:
        r103.append(r106);
        r103.append(" token:");
        if (r101 == null) goto L13;
        String r107 = r101.f563081x;
    L14:
        r103.append(r107);
        r102.i("ChangePhoneManager", r103.toString());
        boolean r108 = false;
        if (r101 != null) goto L17;
    L19:
        boolean r109 = false;
    L20:
        if (r109 == false) goto L34;
        if (r101 == null) goto L27;
        List<String> r110 = r101.f563080w;
        if (r110 == null) goto L27;
        int r111 = f.f527601a;
        if (r110.contains("aweme_v2") != true) goto L27;
        r108 = true;
    L27:
        if (r108 == false) goto L34;
        s r112 = this.f527600a;
        if (r101 == null) goto L31;
        r104 = r101.f563080w;
    L31:
        if (r104 != null) goto L33;
        r104 = CollectionsKt.emptyList();
    L33:
        r112.onSuccess(r104);
        return;
    L34:
        this.f527600a.onFailed();
        return;
    L17:
        if (r101.f563076s != true) goto L19;
        r109 = true;
        goto L20
    L13:
        r107 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        xa7.e r102 = (xa7.e) r100;
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("getAvailableVerifyWays error:");
        r104.append(r101);
        r104.append(':');
        if (r102 == null) goto L5;
        String r105 = r102.f549255i;
    L6:
        r104.append(r105);
        r103.w("ChangePhoneManager", r104.toString());
        this.f527600a.onFailed();
        return;
    L5:
        r105 = null;
        goto L6
    }
}
