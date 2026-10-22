package h25;

import android.os.Parcelable;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.list.dto.Document;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements tb5.i<Object> {
    public static String b;
    public final DocViewModel a;

    /* JADX INFO: renamed from: h25.a$a, reason: collision with other inner class name */
    public static final class C0235a {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    static {
        b = "CheckSyncStateHandler";
    }

    public a(DocViewModel r3) {
        Intrinsics.checkNotNullParameter("Web", "tag");
        this.a = r3;
        b += "Web" + Integer.toHexString(hashCode());
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r3, tb5.m r4) {
        JSONObject r5 = new JSONObject();
        DocViewModel r0 = this.a;
        if (r0 == null) goto L15;
        String r1 = r0.getToken();
        Parcelable.Creator r2 = Document.CREATOR;
        if (lbb.a.a(r1) == true) goto L15;
        r5.put("objToken", this.a.getToken());
        if (this.a.getWikiInfo() == null) goto L9;
        boolean r6 = true;
    L10:
        r5.put("isWiki", Boolean.valueOf(r6));
        WikiInfo r7 = this.a.getWikiInfo();
        if (r7 == null) goto L13;
        String r8 = r7.getWikiToken();
    L14:
        r5.put("wikiToken", r8);
        goto L15
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = false;
    L15:
        if (r4 == null) goto L18;
        r4.b(r5);
        return;
    }
}
