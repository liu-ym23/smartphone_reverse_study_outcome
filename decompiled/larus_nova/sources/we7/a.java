package we7;

import android.content.Context;
import android.net.Uri;
import com.bytedance.forest.utils.h;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.l;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.storage.utils.b;
import com.bytedance.sdk.xbridge.cn.storage.utils.c;
import com.bytedance.sdk.xbridge.cn.storage.utils.d;
import com.bytedance.sdk.xbridge.cn.storage.utils.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements l {

    /* JADX INFO: renamed from: we7.a$a, reason: collision with other inner class name */
    public static final class C8102a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.ies.bullet.service.base.l
    public final Map<String, Object> a(Uri r110, Context r111) {
        if (r111 == null) goto L4;
        XBaseRuntime.f270095a.getClass();
        IHostUserDepend r100 = XBaseRuntime.f270103i;
        if (r100 == null) goto L8;
        Boolean r101 = Boolean.valueOf(r100.hasLogin());
    L10:
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L13;
        BulletLogger.k("GlobalPropsInject:getUserDomainStorageValuesFail.Fail. user is not login ", null, null, 6);
        return new LinkedHashMap();
    L13:
        IHostUserDepend r102 = XBaseRuntime.f270103i;
        if (r102 == null) goto L16;
        String r103 = r102.getUserId();
    L17:
        if (r103 != null) goto L19;
    L22:
        boolean r104 = true;
    L23:
        if (r104 == false) goto L26;
        BulletLogger.k("GlobalPropsInject:getUserDomainStorageValuesFail.Fail. userId is null or empty.", null, null, 6);
        return new LinkedHashMap();
    L26:
        LinkedHashMap r105 = new LinkedHashMap();
        if (r110 == null) goto L34;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter("user_domain_storage_keys", "key");
        if (r110.isHierarchical() == true) goto L32;
        r110 = null;
    L32:
        if (r110 == null) goto L34;
        String r112 = UriProtector.getQueryParameter(r110, "user_domain_storage_keys");
    L36:
        if (h.a(r112) == false) goto L50;
        ExecutorService r106 = BulletLogger.f247763a;
        BulletLogger.k("GlobalPropsInjectgetUserDomainStorageValues,keyList:" + r112, null, null, 6);
        if (r112 == null) goto L40;
        List r113 = StringsKt.split$default(Uri.decode(r112), new String[]{","}, false, 0, 6, null);
    L41:
        c r114 = g.a(r111);
        if (r113 == null) goto L49;
        Iterator r115 = r113.iterator();
    L45:
        if (r115.hasNext() == false) goto L49;
        String r107 = (String) r115.next();
        Triple<Boolean, Boolean, Object> r108 = r114.c(r103, r107, "getUserDomainStorageValues", "");
        r108.component1().booleanValue();
        r108.component2().booleanValue();
        Object r109 = r108.component3();
        if (r109 == null) goto L45;
        r105.put(r107, r109);
    L49:
        ExecutorService r116 = BulletLogger.f247763a;
        BulletLogger.k("GlobalPropsInject-getUserDomainStorageValues.user_domain_map:" + r105, null, null, 6);
        goto L50
    L40:
        r113 = null;
    L50:
        return r105;
    L34:
        r112 = null;
        goto L36
    L19:
        if (r103.length() == 0) goto L22;
        r104 = false;
        goto L23
    L16:
        r103 = null;
        goto L17
    L8:
        r101 = null;
        goto L10
    L4:
        return new LinkedHashMap();
    }

    @Override // com.bytedance.ies.bullet.service.base.l
    public final Map<String, Object> b(Uri r110, Context r111) {
        if (r111 == null) goto L4;
        LinkedHashMap r100 = new LinkedHashMap();
        if (r110 == null) goto L13;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter("bullet_storage_keys", "key");
        if (r110.isHierarchical() == true) goto L11;
        r110 = null;
    L11:
        if (r110 == null) goto L13;
        String r112 = UriProtector.getQueryParameter(r110, "bullet_storage_keys");
    L15:
        if (h.a(r112) == false) goto L23;
        List r113 = StringsKt.split$default(Uri.decode(r112), new String[]{","}, false, 0, 6, null);
        b r114 = d.a(r111);
        Iterator r115 = r113.iterator();
    L18:
        if (r115.hasNext() == false) goto L22;
        String r101 = (String) r115.next();
        Object r102 = r114.e(r101, "getStorageValues", "");
        if (r102 == null) goto L18;
        r100.put(r101, r102);
        goto L18
    L22:
        ExecutorService r116 = BulletLogger.f247763a;
        BulletLogger.k("GlobalPropsInject-getStorageValues.user_domain_map:" + r100, null, null, 6);
    L23:
        return r100;
    L13:
        r112 = null;
        goto L15
    L4:
        return new LinkedHashMap();
    }
}
