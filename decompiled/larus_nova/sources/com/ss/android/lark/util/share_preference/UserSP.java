package com.ss.android.lark.util.share_preference;

import android.content.Context;
import android.text.TextUtils;
import b1c.c;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.g;
import com.ss.android.lark.sp.AbstractSharedPreferences;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public class UserSP extends AbstractSharedPreferences {
    public static final String TAG = "UserSP";
    public static final String TEMP_NAME = "unlogin";
    private static volatile UserSP instance;
    private static b sUserIdGetter;
    private static final ConcurrentHashMap<String, UserSP> userSPCache = null;
    private String mSpName;

    public class a implements b {
        public a() {
        }
    }

    public interface b {
    }

    static {
        sUserIdGetter = new a();
        userSPCache = new ConcurrentHashMap();
        instance = null;
    }

    public static synchronized UserSP getInstance() {
        monitor-enter(UserSP.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L7;
        instance = new UserSP();     // Catch: Throwable -> L10
    L7:
        UserSP r100 = instance;     // Catch: Throwable -> L10
        monitor-exit(UserSP.class);
        return r100;
    }

    public static synchronized void resetInstance() {
        monitor-enter(UserSP.class);
        instance = new UserSP();     // Catch: Throwable -> L7
        monitor-exit(UserSP.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String getSpNameSuffix() {
        g.a r100 = g.f425765a;
        if (r100 == null) goto L9;
        String r101 = r100.getUserId();
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return TEMP_NAME;
    L10:
        return r101;
    L9:
        throw new IllegalStateException("sp not init exactly");
    }

    private UserSP() {
        String r100 = getSpNameSuffix();
        setBaseSharedPreferences(createBaseSharedPreference(r100));
        userSPCache.put(r100, this);
    }

    private g5c.a createBaseSharedPreference() {
        return createBaseSharedPreference(getSpNameSuffix());
    }

    @Override // com.ss.android.lark.sp.AbstractSharedPreferences
    public String getSpName() {
        return this.mSpName;
    }

    private UserSP(String r100) {
        setBaseSharedPreferences(createBaseSharedPreference(r100));
        userSPCache.put(r100, this);
    }

    private g5c.a createBaseSharedPreference(String r100) {
        c r101 = null;
        m4c.a.C6771a r102 = null;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Context r103 = g.getContext();
        b1c.b r104 = new b1c.b(r103);
        String r105 = r104.a(r100);
        if (DevEnvUtil.isDebugMode(r103) == true) goto L13;
        v8b.a.a().getClass();     // Catch: GeneralSecurityException -> L9
        r102 = m4c.b.a.f511910a.b();     // Catch: GeneralSecurityException -> L9
    L11:
        r101 = new c(r103, r102, r105);
    L9:
        e = move-exception;
        e.printStackTrace();
    L13:
        return g5c.c.a(r103, r100, r101, r104);
    }

    public static synchronized UserSP getUserSPById(String r100) {
        monitor-enter(UserSP.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        monitor-exit(UserSP.class);
        return null;
    L9:
        UserSP r101 = userSPCache.get(r100);     // Catch: Throwable -> L15
        if (r101 != null) goto L13;
        r101 = new UserSP(r100);     // Catch: Throwable -> L15
    L13:
        monitor-exit(UserSP.class);
        return r101;
    }

    public static void init(b r100) {
        sUserIdGetter = r100;
    }

    public static List<File> getUserSPFiles(String r100, Context r101) {
        String r102 = new String(w28.a.a(x28.a.a(r100)));
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101.getFilesDir().getParent() + File.separator + "shared_prefs");
        ArrayList r104 = new ArrayList();
        if (r103.exists() == true) goto L5;
    L12:
        return r104;
    L5:
        if (r103.isDirectory() == false) goto L12;
        File[] r105 = r103.listFiles();
        int r106 = r105.length;
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L12;
        File r108 = r105[r107];
        if (r108.getName().startsWith(r102) == false) goto L11;
        r104.add(r108);
    L11:
        r107 = r107 + 1;
        goto L7
    }
}
