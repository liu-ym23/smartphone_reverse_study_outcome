package com.larus.profile.impl.creation;

import com.larus.nova.R;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class w3 implements zp9.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProfileCreationListFragmentV2 f366394a;

    public w3(ProfileCreationListFragmentV2 r100) {
        this.f366394a = r100;
    }

    @Override // zp9.s
    public final List a(UserCreationModel r910) {
        Intrinsics.checkNotNullParameter(r910, "userCreationModel");
        n3 r100 = this.f366394a.f366232m;
        if (r100 == null) goto L41;
        Intrinsics.checkNotNullParameter(r910, "userCreationModel");
        List<UserCreation> r101 = r910.b();
        if (r101 == null) goto L47;
        UserCreation r102 = (UserCreation) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L47;
        Integer r103 = r102.f364990d;
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        ArrayList r105 = new ArrayList();
        Integer r106 = r102.f364989c;
        if (r106 != null) goto L20;
    L21:
        if (r104 == true) goto L23;
    L25:
        r105.add(new com.larus.bmhome.view.screenmenu.l0(R.string.larus_creation_share, R.string.larus_creation_share, null, null, null, Integer.valueOf(R.color.larus_neutral_100), null, Integer.valueOf(R.drawable.larus_creation_share_icon), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, NetError.ERR_SSL_CLIENT_AUTH_CERT_BAD_FORMAT, 127));
        if (r100.f366333b == true) goto L28;
        return r105;
    L28:
        if (r104 == false) goto L30;
        int r107 = R.string.larus_ccMob_PreviewPage_btn_makePublic;
    L31:
        if (r104 == false) goto L33;
        int r110 = R.string.larus_ccMob_PreviewPage_btn_makePublic;
    L34:
        Integer r111 = Integer.valueOf(R.color.larus_neutral_100);
        if (r104 == false) goto L37;
        int r108 = R.drawable.larus_creation_publish_icon;
    L38:
        r105.add(new com.larus.bmhome.view.screenmenu.l0(r107, r110, null, null, null, r111, null, Integer.valueOf(r108), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, NetError.ERR_SSL_CLIENT_AUTH_CERT_BAD_FORMAT, 127));
        r105.add(new com.larus.bmhome.view.screenmenu.l0(R.string.larus_ccMob_PreviewPage_menuBtn_delete, R.string.larus_ccMob_PreviewPage_menuBtn_delete, null, null, null, Integer.valueOf(R.color.larus_danger_50), null, Integer.valueOf(R.drawable.larus_ugc_profile_creation_icon_delete), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, NetError.ERR_SSL_CLIENT_AUTH_CERT_BAD_FORMAT, 127));
        return r105;
    L37:
        r108 = R.drawable.larus_creation_private_icon;
        goto L38
    L33:
        r110 = R.string.larus_add_creation_public_to_private_btn;
        goto L34
    L30:
        r107 = R.string.larus_add_creation_public_to_private_btn;
        goto L31
    L23:
        if (com.larus.bmhome.utils.u.e() == false) goto L25;
        r105.add(new com.larus.bmhome.view.screenmenu.l0(R.string.larus_ccMob_PreviewPage_menuBtn_delete, R.string.larus_ccMob_PreviewPage_menuBtn_delete, null, null, null, Integer.valueOf(R.color.larus_danger_50), null, Integer.valueOf(R.drawable.larus_ugc_profile_creation_icon_delete), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, NetError.ERR_SSL_CLIENT_AUTH_CERT_BAD_FORMAT, 127));
        return r105;
    L20:
        if (r106.intValue() != 5) goto L21;
        r105.add(new com.larus.bmhome.view.screenmenu.l0(R.string.larus_ccMob_PreviewPage_menuBtn_delete, R.string.larus_ccMob_PreviewPage_menuBtn_delete, null, null, null, Integer.valueOf(R.color.larus_danger_50), null, Integer.valueOf(R.drawable.larus_ugc_profile_creation_icon_delete), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, NetError.ERR_SSL_CLIENT_AUTH_CERT_BAD_FORMAT, 127));
        return r105;
    L13:
        if (r103.intValue() != 2) goto L15;
        r104 = true;
    L47:
        return CollectionsKt.emptyList();
    L41:
        return null;
    }
}
