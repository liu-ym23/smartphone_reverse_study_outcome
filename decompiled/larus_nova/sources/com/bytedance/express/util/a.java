package com.bytedance.express.util;

import com.bytedance.express.ExprRunner;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f243211a = 0;

    /* JADX INFO: renamed from: com.bytedance.express.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes19.dex */
    public static final class C3487a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f243212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f243213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Throwable f243214c;

        public C3487a() {
            this.f243213b = "RulerLog";
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f243215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public JSONObject f243216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JSONObject f243217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f243218d;

        public b() {
            this.f243215a = "default";
        }
    }

    static {
    }

    public static void a(int r100, Function1 r101) {
        ExprRunner.f243177f.getClass();
        com.bytedance.express.b r102 = ExprRunner.f243176e;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }
}
