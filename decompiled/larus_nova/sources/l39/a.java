package l39;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.doc.api.IDocService;
import com.larus.utils.f;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements q97.a {

    /* JADX INFO: renamed from: l39.a$a, reason: collision with other inner class name */
    public static final class C6644a {
    }

    static {
    }

    public a() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        int r101 = k0.f375428a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L9:
        return Intrinsics.areEqual(k0.a(r103), "//flow/doc/biz_page");
    L7:
        r103 = null;
        goto L9
    }

    @Override // q97.a
    public final boolean a(Context r110, com.bytedance.router.c r111) {
        Uri r100 = null;
        if (r111 == null) goto L7;
        Uri r101 = r111.f267530d;
        if (r101 == null) goto L7;
        String r102 = UriProtector.getQueryParameter(r101, "docToken");
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L53;
        if (r110 == null) goto L53;
        if (r111 == null) goto L22;
        Uri r104 = r111.f267530d;
        if (r104 == null) goto L22;
        String r105 = UriProtector.getQueryParameter(r104, "docTitle");
    L23:
        if (r111 == null) goto L27;
        Uri r106 = r111.f267530d;
        if (r106 == null) goto L27;
        String r107 = UriProtector.getQueryParameter(r106, "conversationId");
    L28:
        if (r111 == null) goto L32;
        Uri r108 = r111.f267530d;
        if (r108 == null) goto L32;
        String r109 = UriProtector.getQueryParameter(r108, "artifactMetaId");
    L33:
        if (r111 == null) goto L37;
        Uri r112 = r111.f267530d;
        if (r112 == null) goto L37;
        String r113 = UriProtector.getQueryParameter(r112, "artifactVersionId");
    L38:
        if (r111 == null) goto L42;
        Uri r114 = r111.f267530d;
        if (r114 == null) goto L42;
        String r115 = UriProtector.getQueryParameter(r114, "artifactType");
    L43:
        if (r115 == null) goto L45;
        Integer r116 = StringsKt.toIntOrNull(r115);
    L46:
        FLogger r117 = FLogger.f375446a;
        StringBuilder r118 = new StringBuilder("onInterceptRoute ");
        if (r111 == null) goto L49;
        r100 = r111.f267530d;
    L49:
        r118.append(r100);
        r118.append("token:");
        r118.append(r102);
        r118.append(", title:");
        r118.append(r105);
        r118.append(", conversationId:");
        r118.append(r107);
        r118.append(", artifactMetaId:");
        r118.append(r109);
        r118.append(", artifactVersionId:");
        r118.append(r113);
        r118.append(", artifactType:");
        r118.append(r115);
        r117.i("DocDetailRouterInterceptor", r118.toString());
        Bundle r119 = f.c(new Pair[]{TuplesKt.to("key_doc_id", r102), TuplesKt.to("artifact_meta_id", r109), TuplesKt.to("argConversationId", r107), TuplesKt.to("key_artifact_version_id", r113)});
        if (r116 == null) goto L52;
        r119.putInt("resource_type", r116.intValue());
    L52:
        IDocService.f330931a.Z9(r110, r119, "schema");
        goto L53
    L45:
        r116 = null;
    L42:
        r115 = null;
    L37:
        r113 = null;
    L32:
        r109 = null;
    L27:
        r107 = null;
    L22:
        r105 = null;
    L53:
        return true;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
    L7:
        r102 = null;
        goto L9
    }
}
