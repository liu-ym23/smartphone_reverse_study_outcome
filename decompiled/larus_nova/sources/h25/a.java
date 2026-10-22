package h25;

import android.os.Parcelable;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements tb5.i<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f483590b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DocViewModel f483591a;

    /* JADX INFO: renamed from: h25.a$a, reason: collision with other inner class name */
    public static final class C6093a {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    static {
        f483590b = "CheckSyncStateHandler";
    }

    public a(DocViewModel r100) {
        Intrinsics.checkNotNullParameter("Web", "tag");
        this.f483591a = r100;
        f483590b += "Web" + Integer.toHexString(hashCode());
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, tb5.m r101) {
        JSONObject r102 = new JSONObject();
        DocViewModel r103 = this.f483591a;
        if (r103 == null) goto L15;
        String r104 = r103.getToken();
        Parcelable.Creator<Document> r105 = Document.CREATOR;
        if (lbb.a.a(r104) == true) goto L15;
        r102.put("objToken", this.f483591a.getToken());
        if (this.f483591a.getWikiInfo() == null) goto L9;
        boolean r106 = true;
    L10:
        r102.put("isWiki", Boolean.valueOf(r106));
        WikiInfo r107 = this.f483591a.getWikiInfo();
        if (r107 == null) goto L13;
        String r108 = r107.getWikiToken();
    L14:
        r102.put(WikiFolderPushPlugin.WIKI_TOKEN, r108);
        goto L15
    L13:
        r108 = null;
        goto L14
    L9:
        r106 = false;
    L15:
        if (r101 == null) goto L18;
        r101.b(r102);
        return;
    }
}
