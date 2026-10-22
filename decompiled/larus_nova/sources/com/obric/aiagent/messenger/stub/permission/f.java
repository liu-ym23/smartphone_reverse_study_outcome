package com.obric.aiagent.messenger.stub.permission;

import android.app.Application;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f384950a = 0;

    static {
    }

    public static boolean a(List r100) {
        Application r101 = AppHost.f326268a.getApplication();
        List r102 = r100;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L23;
        if (ContextCompat.checkSelfPermission(r101, (String) r103.next()) != 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == true) goto L9;
        return false;
    L13:
        r104 = false;
        goto L14
    L23:
        return true;
    L5:
        if (r102.isEmpty() == false) goto L7;
        return true;
    }
}
