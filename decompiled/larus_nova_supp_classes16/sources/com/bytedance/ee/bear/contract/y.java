package com.bytedance.ee.bear.contract;

import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.ee.bear.more.itemv2.ShortcutItemV2;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.doc.IDocCallback;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y implements x {
    public static IDocCallback a;
    public static lj5.a b;
    public static yj5.a c;

    public y() {
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final DefaultEmojiPanelData a() {
        cx4.a r0 = yn4.b.h;
        if (r0 != null) goto L7;
        tt5.a.d("SdkHostServiceImp", "getDefaultEmojiPanelData() fail : sReactionAgent == null");
        return null;
    L7:
        return r0.a();
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final List<String> f() {
        cx4.a r0 = yn4.b.h;
        if (r0 != null) goto L7;
        tt5.a.d("SdkHostServiceImp", "getRecentReactionList() fail : sReactionAgent == null");
        return new ArrayList();
    L7:
        return r0.f();
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final List<String> h() {
        cx4.a r0 = yn4.b.h;
        if (r0 != null) goto L7;
        tt5.a.d("SdkHostServiceImp", "getMRUReactionList() fail : sReactionAgent == null");
        return new ArrayList();
    L7:
        return r0.h();
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final List<String> o() {
        cx4.a r0 = yn4.b.h;
        if (r0 != null) goto L7;
        tt5.a.d("SdkHostServiceImp", "getAllRecentReactionList() fail : sReactionAgent == null");
        return new ArrayList();
    L7:
        return r0.o();
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void r() {
        lj5.a r0 = b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void x() {
        tt5.a.b("SdkHostServiceImp", "routeToLarkAbout");
        Bundle r0 = new Bundle();
        r0.putString("command", "mine_about");
        doCommand(r0);
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void A(int r4) {
        Bundle r0 = new Bundle();
        r0.putString("command", "tab_docs");
        r0.putInt("tab", r4);
        doCommand(r0);
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final Bundle doCommand(Bundle r3) {
        IDocCallback r0 = a;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.asBinder().isBinderAlive() == false) goto L15;
        return a.doCommand(r3);
    L8:
        e = move-exception;
        tt5.a.d("SdkHostServiceImp", " doCommand  RemoteException: " + e);
        return null;
    L15:
        return null;
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final boolean i(String r2) {
        yj5.a r0 = c;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.i(r2);
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final String u(String r7) {
        tt5.a.b("SdkHostServiceImp", "recognizeQRCode(), path:" + du5.b.g(r7));
        if (TextUtils.isEmpty(r7) == false) goto L6;
        tt5.a.d("SdkHostServiceImp", "recognizeQRCode(), photo path is null");
        return "";
    L6:
        Bundle r0 = new Bundle();
        r0.putString("command", "recognize_qr");
        r0.putString("photo_qr", r7);
        Bundle r8 = doCommand(r0);
        if (r8 != null) goto L11;
        tt5.a.d("SdkHostServiceImp", "recognizeQRCode(), is null");
        return "";
    L11:
        if (TextUtils.equals(r8.getString("command"), "recognize_qr") == true) goto L13;
        return "";
    L13:
        return r8.getString("result_qr");
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void v(String r4) {
        tt5.a.b("SdkHostServiceImp", "handleQrResult(), result:" + du5.b.g(r4));
        Bundle r0 = new Bundle();
        r0.putString("command", "handle_result_qr");
        r0.putString("result_qr", r4);
        doCommand(r0);
    }

    public static Bundle b(String r3, String r4) {
        Bundle r0 = new Bundle();
        r0.putString("command", "share");
        if (r3 == null) goto L5;
        r0.putString("android.intent.extra.TITLE", r3);
    L5:
        if (r4 == null) goto L7;
        r0.putString("android.intent.extra.TEXT", r4);
    L7:
        r0.putString("android.intent.extra.USER", "Docs");
        r0.putBoolean("android.intent.extra.LOCAL_ONLY", true);
        return r0;
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void q(String r3, IGetDataCallback<Integer> r4) {
        tt5.a.h("SdkHostServiceImp", "updateOrder(): reactionKey = " + r3);
        cx4.a r0 = yn4.b.h;
        if (r0 != null) goto L6;
        tt5.a.d("SdkHostServiceImp", "updateOrder() fail : sReactionAgent == null");
        return;
    L6:
        r0.q(r3, r4);
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void t(String r2, String r3) {
        Bundle r4 = b(r2, r3);
        r4.putBoolean("support_addition_note", true);
        r4.putString("android.intent.extra.MIME_TYPES", "text/plain");
        doCommand(r4);
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void y(String r4, Map<String, String> r5) {
        if (TextUtils.isEmpty(r4) == true) goto L11;
        Bundle r0 = new Bundle();
        r0.putString("command", "open_url");
        r0.putString("url", r4);
        if (r5 != null) goto L7;
    L9:
        doCommand(r0);
        return;
    L7:
        if (r5.isEmpty() == true) goto L9;
        r0.putSerializable("extra", (Serializable) r5);
        goto L9
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void z(String r3, ArrayList r4) {
        Bundle r5 = b(r3, null);
        r5.putBoolean("support_addition_note", true);
        r5.putString("android.intent.extra.MIME_TYPES", "image/*");
        if (r4 == null) goto L5;
        r5.putParcelableArrayList("android.intent.extra.STREAM", r4);
    L5:
        doCommand(r5);
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void s(boolean r2, String r3, ShortcutItemV2.a r4) {
        yj5.a r0 = c;
        if (r0 == null) goto L6;
        r0.s(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void w(String r4, String r5, boolean r6) {
        if (TextUtils.isEmpty(r4) == true) goto L6;
        Bundle r0 = new Bundle();
        r0.putString("command", "profile_main");
        r0.putString("user_id", r4);
        r0.putString("title", r5);
        r0.putBoolean("isMinutes", r6);
        doCommand(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void B(String r4, String r5, String r6, IBinder r7) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L9:
        tt5.a.h("SdkHostServiceImp", "notifyAnnouncementChange: chat id = " + r4 + ", url = " + du5.b.g(r5));
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L9;
        Bundle r0 = new Bundle();
        r0.putString("command", "notify_announcement_change");
        r0.putString("chat_id", r4);
        r0.putString(DocCallbackImpl.KEY_THUMBNAIL, r5);
        r0.putBoolean(DocCallbackImpl.KEY_IS_EDITED, false);
        r0.putString("announce_name", r6);
        r0.putBinder("announce_send_callback", r7);
        doCommand(r0);
    }
}
