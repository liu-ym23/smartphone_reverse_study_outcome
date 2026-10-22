package com.bytedance.lark.sdk;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f254118c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f254120b;

    /* JADX INFO: renamed from: com.bytedance.lark.sdk.a$a, reason: collision with other inner class name */
    public static final class C3611a {
        public static String a(String r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "headers");
            if (TextUtils.isEmpty(r100) == true) goto L11;
            Iterator r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L16;
            a r103 = (a) r102.next();
            if (TextUtils.equals(r103.f254119a.toLowerCase(), r100.toLowerCase()) == false) goto L6;
            return r103.f254120b;
        L16:
            return "";
        L11:
            return "";
        }
    }

    static {
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f254119a = "";
        this.f254120b = "";
        this.f254119a = r100;
        this.f254120b = r101;
    }
}
