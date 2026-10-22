package com.bytedance.ee.bear.secret;

import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\u001c\u0010\u0012\u001a\u00020\n2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J,\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/secret/ApprovalDialogCallbacks;", "Ljava/io/Serializable;", "callback", "Lcom/bytedance/ies/xbridge/XBridgeMethod$Callback;", "deduplicate", "", "<init>", "(Lcom/bytedance/ies/xbridge/XBridgeMethod$Callback;Z)V", "hasCallback", "onConfirm", "", "onCancel", "onApproval", "instanceCode", "", "onSuccessResult", "onFail", "errorMessage", "onSuccessIfNeeded", WikiFolderPushPlugin.DATA, "", "", "onSuccess", "msg", "Companion", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApprovalDialogCallbacks implements Serializable {
    public static final a Companion = null;
    private final XBridgeMethod.Callback callback;
    private final boolean deduplicate;
    private boolean hasCallback;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final void onCancel() {
        Log.i("ApprovalDialogCallbacks", "click cancel.");
        a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", DocFeed$Value$Result.CANCEL)}));
    }

    public final void onConfirm() {
        Log.i("ApprovalDialogCallbacks", "click confirm.");
        a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", "confirm")}));
    }

    public final void a(Map<String, Object> r8) {
        if (this.deduplicate == true) goto L5;
    L8:
        this.hasCallback = true;
        onSuccess$default(this, this.callback, r8, null, 4, null);
        return;
    L5:
        if (this.hasCallback == false) goto L8;
        Log.i("ApprovalDialogCallbacks", "callback already invoked.");
    }

    public final void onApproval(String r5) {
        Log.i("ApprovalDialogCallbacks", "approval submitted.");
        boolean r0 = true;
        Map<String, Object> r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", "approval")});
        if (r5 != null) goto L5;
    L8:
        if (r0 == true) goto L10;
        r1.put("instanceCode", r5);
    L10:
        a(r1);
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r0 = false;
        goto L8
    }

    public final void onFail(String r5) {
        Log.i("ApprovalDialogCallbacks", "approval failed.");
        boolean r0 = true;
        Map<String, Object> r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", DocFeed$Value$Result.FAIL)});
        if (r5 != null) goto L5;
    L8:
        if (r0 == true) goto L10;
        r1.put("errorMessage", r5);
    L10:
        a(r1);
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r0 = false;
        goto L8
    }

    public final void onSuccessResult(String r5) {
        Log.i("ApprovalDialogCallbacks", "success submitted.");
        boolean r0 = true;
        Map<String, Object> r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", "success")});
        if (r5 != null) goto L5;
    L8:
        if (r0 == true) goto L10;
        r1.put("instanceCode", r5);
    L10:
        a(r1);
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r0 = false;
        goto L8
    }

    public ApprovalDialogCallbacks(XBridgeMethod.Callback r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.callback = r2;
        this.deduplicate = r3;
    }

    public final void onSuccess(XBridgeMethod.Callback r6, Map<String, Object> r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r7, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r8, "msg");
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("code", 1);
        r2.put("msg", r8);
        r2.put(WikiFolderPushPlugin.DATA, r7);
        r6.invoke(r2);
    }

    public /* synthetic */ ApprovalDialogCallbacks(XBridgeMethod.Callback r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ void onApproval$default(ApprovalDialogCallbacks r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.onApproval(r1);
    }

    public static /* synthetic */ void onFail$default(ApprovalDialogCallbacks r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.onFail(r1);
    }

    public static /* synthetic */ void onSuccessResult$default(ApprovalDialogCallbacks r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.onSuccessResult(r1);
    }

    public static /* synthetic */ void onSuccess$default(ApprovalDialogCallbacks r0, XBridgeMethod.Callback r1, Map r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "";
    L5:
        r0.onSuccess(r1, r2, r3);
    }
}
