package com.larus.bmhome.utils;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.bmhome.chat.model.repo.UserSettingRepoDelegate;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    public static final boolean c(int r100) {
        if (r100 == (-1)) goto L7;
        if (r100 == 0) goto L6;
        if (r100 != 1) goto L6;
        return true;
    L6:
        return false;
    L7:
        lq9.i0 r101 = com.larus.platform.service.z2.f365865a.U0().f();
        if (r101 == null) goto L6;
        if (r101.a() != true) goto L6;
        return true;
    }

    public static final boolean f(wc9.e r100) {
        Integer r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f559198a;
    L6:
        if (r100 == null) goto L9;
        r101 = r100.f559219v;
    L9:
        return e(r102, r101);
    L5:
        r102 = null;
        goto L6
    }

    public static final boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        IAuthModelService r101 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        String r102 = null;
        if (r101 == null) goto L7;
        LiveData<wc9.e> r103 = r101.y();
        if (r103 == null) goto L7;
        wc9.e r104 = r103.getValue();
    L9:
        if (r100.length() <= 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L18;
        if (r104 == null) goto L16;
        r102 = r104.f559198a;
    L16:
        if (Intrinsics.areEqual(r100, r102) == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r105 = false;
    L7:
        r104 = null;
        goto L9
    }

    public static final boolean h(wc9.e r100) {
        if (f(r100) == true) goto L5;
        return false;
    L5:
        if (r100 == null) goto L12;
        Integer r101 = r100.f559219v;
        if (r101 == null) goto L12;
        if (r101.intValue() != 3) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L17;
        return true;
    L17:
        return false;
    L12:
        r102 = false;
        goto L13
    }

    public static final String b(String r100, String r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        if (r101 != null) goto L17;
        r101 = "";
    L17:
        r103.append(r101);
        return r103.toString();
    L11:
        if (r101 != null) goto L19;
        r101 = "";
    L19:
        return "@".concat(r101);
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L9
    }

    public static final boolean e(String r100, Integer r101) {
        IAuthModelService r102 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r102 == null) goto L21;
        LiveData<wc9.e> r103 = r102.y();
        if (r103 == null) goto L22;
        wc9.e r104 = r103.getValue();
        if (r104 != null) goto L10;
        return false;
    L10:
        if (com.larus.utils.o0.d(r100) == true) goto L12;
    L15:
        if (r101 != null) goto L18;
        return false;
    L18:
        if (r101.intValue() != 3) goto L23;
    L19:
        return true;
    L23:
        return false;
    L12:
        if (com.larus.utils.o0.d(r104.f559198a) == false) goto L15;
        if (Intrinsics.areEqual(r100, r104.f559198a) == true) goto L19;
    L22:
        return false;
    L21:
        return false;
    }

    public static final String a(Context r100, String r101, String r102) {
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L21;
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        if (r100 == null) goto L14;
        String r105 = r100.getString(R.string.larus_created_by_username);
    L15:
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        Object[] r106 = new Object[1];
        if (r102 != null) goto L20;
        r102 = "";
    L20:
        r106[0] = r102;
        return String.format(r105, Arrays.copyOf(r106, 1));
    L14:
        r105 = null;
        goto L15
    L21:
        StringBuilder r107 = new StringBuilder();
        r107.append(r101);
        if (r102 != null) goto L24;
        r102 = "";
    L24:
        r107.append(r102);
        return r107.toString();
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public static final boolean d(int r100, boolean r101, String r102) {
        if (r100 == (-1)) goto L7;
        if (r100 == 0) goto L6;
        if (r100 != 1) goto L6;
        return true;
    L6:
        return false;
    L7:
        if (r101 == true) goto L14;
        UserSettingRepoDelegate r103 = UserSettingRepoDelegate.f307761b;
        if (r103.a(r102) == (-1)) goto L14;
        if (r103.a(r102) != 1) goto L6;
        return true;
    L14:
        lq9.i0 r104 = com.larus.platform.service.z2.f365865a.U0().f();
        if (r104 == null) goto L6;
        if (r104.a() != true) goto L6;
        return true;
    }
}
