package com.bytedance.ug.sdk.luckycat.utils;

import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.larus.nova.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f271564a = 0;

    public static class a {
        public a() {
        }
    }

    public static class b extends a {
        public static HashMap a() {
            m r100 = m.a.f271349a;
            ti7.a r101 = r100.f271342j;
            if (r101 == null) goto L19;
            String r102 = r101.f546212g;
            String r103 = r101.f546211f;
            if (TextUtils.isEmpty(r102) == true) goto L13;
            if (TextUtils.isEmpty(r103) == true) goto L13;
            if (r100.f271344l == false) goto L11;
            Toast.makeText(r100.f(), R.string.debug_boe_ppe_excpetion_tips, 0).show();
        L11:
            return null;
        L13:
            if (TextUtils.isEmpty(r102) == true) goto L16;
            HashMap r104 = new HashMap();
            r104.put("X-TT-ENV", r102);
            r104.put("X-USE-PPE", "1");
            return r104;
        L16:
            if (TextUtils.isEmpty(r103) == true) goto L21;
            HashMap r105 = new HashMap();
            r105.put("X-TT-ENV", r103);
            return r105;
        L21:
            return null;
        L19:
            return null;
        }

        public b() {
        }
    }

    static {
        new b();
    }
}
