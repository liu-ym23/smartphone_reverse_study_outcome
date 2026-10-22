package qe5;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends XCoreBridgeMethod {
    public final String a;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ g a;
        public final /* synthetic */ XBridgeMethod.Callback b;

        public b(g r1, XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            tt5.a.h("ccm-lynx: CCMShowAnyOneLinkShareDialogMethod", "showAnyOneLinkShareTipsDialog()...click confirm.");
            XCoreBridgeMethod.onSuccess$default(this.a, this.b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", "confirm")}), null, 4, null);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ g a;
        public final /* synthetic */ XBridgeMethod.Callback b;

        public c(g r1, XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            tt5.a.h("ccm-lynx: CCMShowAnyOneLinkShareDialogMethod", "showAnyOneLinkShareTipsDialog()...click cancel.");
            XCoreBridgeMethod.onSuccess$default(this.a, this.b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", DocFeed$Value$Result.CANCEL)}), null, 4, null);
        }
    }

    static {
    }

    public g() {
        this.a = "ccm.permission.showAnyOneLinkShareTipsDialog";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r18, XBridgeMethod.Callback r19, XBridgePlatformType r20) {
        Intrinsics.checkNotNullParameter(r18, "params");
        Intrinsics.checkNotNullParameter(r19, "callback");
        Intrinsics.checkNotNullParameter(r20, ResourceData.KEY_TYPE);
        Context r6 = (Context) provideContext(Context.class);
        if (r6 != null) goto L6;
        tt5.a.d("ccm-lynx: CCMShowAnyOneLinkShareDialogMethod", "handle()...context is null");
        return;
    L6:
        int r7 = r18.getInt(ResourceData.KEY_TYPE);
        String r8 = s.f(r18, ResourceData.KEY_TOKEN, "");
        String r9 = s.f(r18, "subType", "");
        int r10 = 0;
        boolean r3 = s.b(r18, "isWiki", false);
        boolean r11 = s.b(r18, "isRead", true);
        if (r18.hasKey("scene") == false) goto L9;
        Integer r15 = Integer.valueOf(r18.getInt("scene"));
    L11:
        if (r18.hasKey("customBodyText") == false) goto L13;
        String r16 = s.f(r18, "customBodyText", "");
    L14:
        StringBuilder r1 = new StringBuilder("handle()...type = ");
        r1.append(r7);
        r1.append(", token = ");
        r1.append(du5.b.g(r8));
        r1.append(", subType = ");
        r1.append(r9);
        r1.append(", isWiki = ");
        r1.append(r3);
        r1.append(", isRead = ");
        r1.append(r11);
        r1.append(", scene = ");
        r1.append(r15);
        r1.append(", customBodyTextLength = ");
        if (r16 == null) goto L17;
        r10 = r16.length();
    L17:
        r1.append(r10);
        tt5.a.h("ccm-lynx: CCMShowAnyOneLinkShareDialogMethod", r1.toString());
        if (com.bytedance.ee.bear.middleground.permission.b.m() == false) goto L20;
        c r2 = new c(this, r19);
    L21:
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).le(r6, r7, r8, r9, r3, r11, "from_share_link", new b(this, r19), r2, r15, r16);
        return;
    L20:
        r2 = null;
        goto L21
    L13:
        r16 = null;
        goto L14
    L9:
        r15 = null;
        goto L11
    }
}
