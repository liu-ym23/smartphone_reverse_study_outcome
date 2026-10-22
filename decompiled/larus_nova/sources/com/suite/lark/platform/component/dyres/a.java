package com.suite.lark.platform.component.dyres;

import android.text.TextUtils;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.log.Log;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f460587a = 0;

    /* JADX INFO: renamed from: com.suite.lark.platform.component.dyres.a$a, reason: collision with other inner class name */
    public static class C5526a implements npb.a {
        public C5526a() {
        }

        @Override // npb.a
        public final void a() {
        }

        @Override // npb.a
        public final String getTag() {
            return "DyResSettingHandler";
        }

        @Override // npb.a
        public final Collection<AbstractBaseSettingHandler> b() {
            int r100 = a.f460587a;
            return new HashSet(Collections.singletonList(b.f460588a));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f460588a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Map<String, String> f460589b = null;

        static {
            f460588a = new c();
            f460589b = new HashMap();
        }
    }

    public static class c extends AbstractBaseSettingHandler {
        @Override // com.ss.android.lark.larkconfig.export.handler.a
        public final String a() {
            return "guide_config_data";
        }

        @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
        public final String f() {
            return "ResHandler";
        }

        public c() {
            AbstractBaseSettingHandler.a r100 = this.f431105d;
            r100.c(new poc.b(this));
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f431107f = r100;
        }

        public static void j(JSONObject r100) {
            if (r100 != null) goto L5;
            Log.e("ResHandler", "parseRes dataObj is null");
            return;
        L5:
            Iterator<String> r101 = r100.keys();
        L7:
            if (r101.hasNext() == false) goto L12;
            String r102 = r101.next();
            String r103 = r100.optString(r102);
            if (TextUtils.isEmpty(r103) == true) goto L7;
            ((HashMap) b.f460589b).put(r102, r103);
            goto L7
        }
    }

    static {
        DyResUtils.b.a r100 = DyResUtils.b.f460581a;
        DyResUtils.b r101 = new poc.a();
        r100.getClass();
        DyResUtils.b.a.f460583b = r101;
    }
}
