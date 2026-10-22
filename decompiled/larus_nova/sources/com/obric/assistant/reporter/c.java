package com.obric.assistant.reporter;

import android.os.Bundle;
import by7.g;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f391352a = 0;

    static {
    }

    public static void a(Bundle r100, boolean r101) {
        g r102 = g.f21473d;
        JSONObject r103 = new JSONObject();
        if (r100 == null) goto L10;
        Set<String> r104 = r100.keySet();
        if (r104 == null) goto L10;
        Iterator<T> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        String r106 = (String) r105.next();
        r103.put(r106, r100.get(r106));
    L10:
        r103.put("is_success", r101 ? 1 : 0);
        Unit r107 = Unit.INSTANCE;
        r102.onEvent("obric_lockscreen_auth_result", r103);
    }
}
