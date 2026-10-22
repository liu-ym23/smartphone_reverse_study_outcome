package com.ss.android.lark.sdk;

import android.content.Context;
import com.ss.android.lark.log.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f439881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f439882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f439883c;

    public class a implements e {
        public a() {
        }

        @Override // com.ss.android.lark.sdk.e
        public final String a(String r100) {
            return r100;
        }

        @Override // com.ss.android.lark.sdk.e
        public final void b(JSONObject r100) {
        }

        @Override // com.ss.android.lark.sdk.e
        public final void w(String r100) {
            Log.w("sdk", r100);
        }
    }

    public class b {
        public b() {
        }
    }

    static {
        f439881a = new a();
        new b();
    }

    public static Context getContext() {
        return com.larksuite.framework.utils.b.f285948a;
    }
}
