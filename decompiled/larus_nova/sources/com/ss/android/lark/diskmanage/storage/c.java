package com.ss.android.lark.diskmanage.storage;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.l;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f420487a = 0;

    public static final class a {
        @JvmStatic
        public static String a(Context r100, String r101, Storage.Type r102, String... r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "bizRootDictionary");
            Intrinsics.checkNotNullParameter("", "bizChildPath");
            Intrinsics.checkNotNullParameter(r102, "type");
            Intrinsics.checkNotNullParameter(r103, "paths");
            int r104 = b.f420485a;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "bizRootDictionary");
            Intrinsics.checkNotNullParameter("", "bizChildPath");
            Intrinsics.checkNotNullParameter(r102, "type");
            int r105 = b.a.C4955a.f420486a[r102.ordinal()];
            boolean r106 = true;
            if (r105 != 1) goto L5;
            String r107 = d.i(r100) + File.separator;
        L25:
            String r108 = r107 + r101;
            if (TextUtils.isEmpty("") == true) goto L29;
            r108 = r108 + File.separator + "";
        L29:
            if (r103.length != 0) goto L31;
            boolean r109 = true;
        L33:
            if ((!r109) == true) goto L36;
            r106 = false;
        L36:
            if (r106 == false) goto L41;
            Iterator r110 = ArrayIteratorKt.iterator(r103);
        L39:
            if (r110.hasNext() == false) goto L41;
            r108 = r108 + File.separator + r110.next();
        L41:
            return r108;
        L31:
            r109 = false;
            goto L33
        L5:
            if (r105 != 2) goto L7;
            StringBuilder r111 = new StringBuilder();
            int r112 = d.f420488a;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            r111.append(l.a(r100));
            r111.append(File.separator);
            r107 = r111.toString();
            goto L25
        L7:
            if (r105 != 3) goto L9;
            r107 = d.j(r100) + File.separator;
            goto L25
        L9:
            if (r105 != 4) goto L11;
            StringBuilder r113 = new StringBuilder();
            int r114 = d.f420488a;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            File r115 = r100.getExternalFilesDir(null);
            if (r115 != null) goto L18;
            r115 = r100.getFilesDir();
        L18:
            if (r115 == null) goto L20;
            String r116 = r115.getPath();
        L21:
            r113.append(r116);
            r113.append(File.separator);
            r107 = r113.toString();
            goto L25
        L20:
            r116 = "";
            goto L21
        L11:
            if (r105 != 5) goto L14;
            r107 = d.l(r100);
            goto L25
        L14:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
        new HashMap();
    }
}
