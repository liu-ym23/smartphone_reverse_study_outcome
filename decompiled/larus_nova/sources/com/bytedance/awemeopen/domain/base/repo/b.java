package com.bytedance.awemeopen.domain.base.repo;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f198240b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f198241a;

    public static final class a {
        public static String a(String r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "map");
            b r102 = new b();
            ((LinkedHashMap) r102.f198241a).clear();
            r102.f198241a.putAll(r101);
            Intrinsics.checkNotNullParameter(r100, "url");
            Uri.Builder r103 = UriProtector.parse(r100).buildUpon();
            Iterator r104 = ((LinkedHashMap) r102.f198241a).entrySet().iterator();
        L4:
            if (r104.hasNext() == false) goto L9;
            Map.Entry r105 = (Map.Entry) r104.next();
            Object r106 = r105.getValue();
            if (r106 == null) goto L4;
            r103.appendQueryParameter((String) r105.getKey(), r106.toString());
            goto L4
        L9:
            return r103.build().toString();
        }
    }

    static {
    }

    public b() {
        this.f198241a = new LinkedHashMap();
    }
}
