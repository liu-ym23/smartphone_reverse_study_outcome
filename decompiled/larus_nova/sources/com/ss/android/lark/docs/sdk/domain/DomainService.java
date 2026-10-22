package com.ss.android.lark.docs.sdk.domain;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.EncryptUtil;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class DomainService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f420498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f420499b;

    public static final class a {
    }

    static {
    }

    public DomainService() {
        Lazy r100 = LazyKt.lazy(DomainService$domainMap$2.INSTANCE);
        this.f420498a = r100;
        Lazy r101 = LazyKt.lazy(DomainService$pathPrefixList$2.INSTANCE);
        this.f420499b = r101;
        ((Map) r100.getValue()).put(EDomainType.DOCS_API, CollectionsKt.listOf("internal-api-space.feishu.cn"));
        ((Map) r100.getValue()).put(EDomainType.DRIVE_STREAM, CollectionsKt.listOf("internal-api-drive-stream.feishu.cn"));
        ((List) r101.getValue()).clear();
        ((List) r101.getValue()).add("space");
    }

    public final Uri a(EDomainType r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "domainType");
        String r100 = "";
        if (r111 != null) goto L5;
        String r101 = "";
    L40:
        Uri r102 = UriProtector.parse(r101);     // Catch: Exception -> L37
        String r103 = r102.getPath();     // Catch: Exception -> L37
        if (r103 != null) goto L11;
        Log.e("DomainService", "standardizeUrl, rawPath is empty, rawUrl: " + EncryptUtil.maskAllToken(r111));     // Catch: Exception -> L37
        return null;
    L11:
        Intrinsics.checkNotNullParameter(r110, "domainType");     // Catch: Exception -> L37
        List r112 = (List) ((Map) this.f420498a.getValue()).get(r110);     // Catch: Exception -> L37
        if (r112 == null) goto L15;
        String r113 = (String) CollectionsKt.firstOrNull(r112);     // Catch: Exception -> L37
        if (r113 == null) goto L15;
    L16:
        String r104 = (String) CollectionsKt.firstOrNull((List) this.f420499b.getValue());     // Catch: Exception -> L37
        if (r104 == null) goto L21;
        r100 = r104;
    L21:
        if (r100.length() != 0) goto L23;
        boolean r105 = true;
    L24:
        if (r105 == false) goto L27;
    L36:
        return r102.buildUpon().scheme("https").authority(r113).path(r103).build();
    L27:
        if (StringsKt.startsWith$default(r103, r100, false, 2, null) == true) goto L36;
        if (StringsKt.startsWith$default(r103, HTTP.URL_DEFAULT.concat(r100), false, 2, null) == true) goto L36;
        if (StringsKt.startsWith$default(r103, HTTP.URL_DEFAULT, false, 2, null) == false) goto L34;
        r103 = r100.concat(r103);     // Catch: Exception -> L37
        goto L36
    L34:
        r103 = r100 + '/' + r103;     // Catch: Exception -> L37
        goto L36
    L23:
        r105 = false;
    L15:
        r113 = "";
    L37:
        e = move-exception;
        Log.e("DomainService", "standardizeUrl, error: ", e);
        return null;
    L5:
        r101 = r111;
        goto L40
    }
}
