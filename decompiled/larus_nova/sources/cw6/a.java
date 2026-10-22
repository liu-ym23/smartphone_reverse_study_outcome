package cw6;

import java.util.Iterator;
import mq6.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f465621a = 0;

    static {
    }

    public static void a(JSONObject r100, c r101) {
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.c(r103, r100.opt(r103));
        goto L4
    }
}
