package lx6;

import android.text.TextUtils;
import com.bytedance.locallife.common.utils.j;
import com.bytedance.locallife.dito.core.v;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements v.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f511221b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f511222a;

    /* JADX INFO: renamed from: lx6.a$a, reason: collision with other inner class name */
    public static final class C6748a {
    }

    static {
        f511221b = CollectionsKt.listOf(new String[]{"activity_id", "detail_enter_page", UniContext.KEY_OF_BIZ_CODE});
    }

    @Override // com.bytedance.locallife.dito.core.v.c
    public final JSONObject a() {
        return new JSONObject(MapsKt.mapOf(TuplesKt.to("generatedKey", this.f511222a)));
    }

    public final int hashCode() {
        return this.f511222a.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == false) goto L10;
        return TextUtils.equals(this.f511222a, ((a) r100).f511222a);
    L10:
        return super.equals(r100);
    }

    public a(List<String> r100, Map<String, String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "keyList");
        Intrinsics.checkNotNullParameter(r101, "params");
        StringBuilder r103 = new StringBuilder();
        int r104 = 0;
        if (r102 == null) goto L7;
        boolean r105 = true;
        if (j.a(r102) != true) goto L7;
    L8:
        if (r105 == false) goto L10;
        r103.append(r102);
    L10:
        Iterator<T> r106 = r100.iterator();
    L12:
        if (r106.hasNext() == false) goto L23;
        Object r107 = r106.next();
        int r108 = r104 + 1;
        if (r104 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        String r109 = (String) r107;
        if (r104 <= 0) goto L19;
        r103.append("&");
    L19:
        r103.append(r109);
        r103.append(ContainerUtils.KEY_VALUE_DELIMITER);
        String r110 = r101.get(r109);
        if (r110 != null) goto L22;
        r110 = "";
    L22:
        r103.append(r110);
        r104 = r108;
        goto L12
    L23:
        this.f511222a = r103.toString();
        return;
    L7:
        r105 = false;
        goto L8
    }
}
