package com.ss.android.lark.jsruntime.vmsdk;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.jsbridge.Message;
import com.ss.android.lark.officesdk.utils.ReflectUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb5.m;

/* JADX INFO: loaded from: classes36.dex */
public final class e extends tb5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f428158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, tb5.i<?>> f428159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final tb5.f.b f428160c;

    public static final class a {
        public static void a(String r100, tb5.i r101, m r102) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, "handler");
            Class r103 = ReflectUtils.a(r101);
            if (r103 != null) goto L5;
            r103 = ReflectUtils.b(r101);
        L5:
            Object r104 = null;
            if (r103 != null) goto L17;
            r101.handle(null, r102);
            return;
        L17:
        L13:
            th = move-exception;
            com.ss.android.lark.officesdk.utils.di.j.b("Bridge", "handleJSMsg PARSE_DATA_ERR  data： " + r100 + "    clazz： " + r103 + "  e: " + th);
        L15:
            r101.handle(r104, r102);
            return;
        L9:
            if (Intrinsics.areEqual(r103, String.class) == false) goto L11;
            Object r105 = r100;
        L12:
            r104 = r105;
            goto L15
        L11:
            r105 = JSON.parseObject(r100, r103);     // Catch: Throwable -> L13
            goto L12
        }
    }

    static {
    }

    public e(tb5.f.b r100) {
        this.f428158a = "JSRuntimeBridge#" + Integer.toHexString(hashCode());
        this.f428159b = new ConcurrentHashMap();
        this.f428160c = r100;
    }

    public final void c(Message r100) {
        m r101 = a(r100.f227150a);     // Catch: Throwable -> L11
        String r102 = r100.f227154e;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r102) == false) goto L6;
        com.ss.android.lark.officesdk.utils.di.j.b(this.f428158a, "handlerName is empty");     // Catch: Throwable -> L11
        tb5.i r103 = null;
    L7:
        if (r103 == null) goto L9;
        a.a(r100.f227153d, r103, r101);     // Catch: Throwable -> L11
        return;
    L9:
        com.ss.android.lark.officesdk.utils.di.j.f(this.f428158a, "dispatchMsgFromJS " + r100.f227154e);     // Catch: Throwable -> L11
        return;
    L6:
        r103 = (tb5.i) ((ConcurrentHashMap) this.f428159b).get(r102);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        String r104 = this.f428158a;
        String r105 = th.getMessage();
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        com.ss.android.lark.officesdk.utils.di.j.b(r104, r105);
    }

    public final void prompt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Message r101 = Message.c(r100);     // Catch: Throwable -> L10
        if (r100.length() <= 2097152) goto L7;
        com.ss.android.lark.officesdk.utils.di.j.b("ReportCrashUtils_" + this.f428158a, r100.length() + tb2.c.DEFAULT_TEXT + r101.f227154e);     // Catch: Throwable -> L10
    L7:
        if (TextUtils.isEmpty(r101.f227151b) == false) goto L18;
        c(r101);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L10:
        th = move-exception;
        String r102 = this.f428158a;
        String r103 = th.getMessage();
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        com.ss.android.lark.officesdk.utils.di.j.b(r102, r103);
    }

    @Override // tb5.a
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "callbackId");
        Intrinsics.checkNotNullParameter(r101, "data");
        if (this.f428160c == null) goto L32;
        String r102 = StringsKt.trimIndent("\n                LarkWebViewJavaScriptBridge.nativeCallBack({\n                callbackID: '" + r100 + "',\n                callbackType: 'success',\n                data: " + r101 + "\n                });\n                ");
        tb5.f.b r103 = this.f428160c;
        int r104 = r102.length() - 1;
        int r105 = 0;
        boolean r106 = false;
    L5:
        if (r105 > r104) goto L20;
        if (r106 == true) goto L8;
        int r107 = r105;
    L10:
        if (Intrinsics.compare(r102.charAt(r107), 32) > 0) goto L12;
        boolean r108 = true;
    L13:
        if (r106 == false) goto L14;
        if (r108 == false) goto L20;
        r104 = r104 - 1;
        goto L5
    L14:
        if (r108 == false) goto L15;
        r105 = r105 + 1;
        goto L5
    L15:
        r106 = true;
        goto L5
    L12:
        r108 = false;
        goto L13
    L8:
        r107 = r104;
    L20:
        r103.b(r102.subSequence(r105, r104 + 1).toString());
        return;
    }
}
