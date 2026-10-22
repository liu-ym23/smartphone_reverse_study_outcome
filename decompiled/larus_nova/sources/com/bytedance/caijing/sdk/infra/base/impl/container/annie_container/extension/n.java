package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension;

import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f202423c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f202424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<i> f202425b;

    public static final class a {
        public a() {
        }

        public static n a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "jsonObject");
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
            n r102 = new n(0);     // Catch: Throwable -> L12
            r102.f202424a = r100.optBoolean("enable", false);     // Catch: Throwable -> L12
            JSONArray r103 = r100.optJSONArray("rules");     // Catch: Throwable -> L12
            if (r103 == null) goto L11;
            int r104 = r103.length();     // Catch: Throwable -> L12
            int r105 = 0;
        L6:
            if (r105 >= r104) goto L11;
            JSONObject r106 = r103.optJSONObject(r105);     // Catch: Throwable -> L12
            if (r106 == null) goto L10;
            ArrayList<i> r107 = r102.f202425b;     // Catch: Throwable -> L12
            int r108 = i.f202412g;     // Catch: Throwable -> L12
            r107.add(i.a.a(r106));     // Catch: Throwable -> L12
        L10:
            r105 = r105 + 1;
        L11:
            return r102;
        L12:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return new n(0);
        }
    }

    static {
        f202423c = new a();
    }

    public n(int r100) {
        ArrayList<i> r101 = new ArrayList();
        Intrinsics.checkNotNullParameter(r101, "rules");
        this.f202424a = false;
        this.f202425b = r101;
    }
}
