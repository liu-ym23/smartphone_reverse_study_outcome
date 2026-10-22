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

/* JADX INFO: loaded from: classes16.dex */
public final class y implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IDocCallback f217209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static lj5.a f217210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static yj5.a f217211c;

    public y() {
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final DefaultEmojiPanelData a() {
        cx4.a r100 = yn4.b.f568532h;
        if (r100 != null) goto L7;
        tt5.a.d("SdkHostServiceImp", "getDefaultEmojiPanelData() fail : sReactionAgent == null");
        return null;
    L7:
        return r100.a();
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final List<String> f() {
        cx4.a r100 = yn4.b.f568532h;
        if (r100 != null) goto L7;
        tt5.a.d("SdkHostServiceImp", "getRecentReactionList() fail : sReactionAgent == null");
        return new ArrayList();
    L7:
        return r100.f();
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final List<String> h() {
        cx4.a r100 = yn4.b.f568532h;
        if (r100 != null) goto L7;
        tt5.a.d("SdkHostServiceImp", "getMRUReactionList() fail : sReactionAgent == null");
        return new ArrayList();
    L7:
        return r100.h();
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final List<String> o() {
        cx4.a r100 = yn4.b.f568532h;
        if (r100 != null) goto L7;
        tt5.a.d("SdkHostServiceImp", "getAllRecentReactionList() fail : sReactionAgent == null");
        return new ArrayList();
    L7:
        return r100.o();
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void r() {
        lj5.a r100 = f217210b;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void x() {
        tt5.a.b("SdkHostServiceImp", "routeToLarkAbout");
        Bundle r100 = new Bundle();
        r100.putString("command", "mine_about");
        doCommand(r100);
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void A(int r100) {
        Bundle r101 = new Bundle();
        r101.putString("command", "tab_docs");
        r101.putInt("tab", r100);
        doCommand(r101);
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final Bundle doCommand(Bundle r100) {
        IDocCallback r101 = f217209a;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.asBinder().isBinderAlive() == false) goto L15;
        return f217209a.doCommand(r100);
    L8:
        e = move-exception;
        tt5.a.d("SdkHostServiceImp", " doCommand  RemoteException: " + e);
        return null;
    L15:
        return null;
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final boolean i(String r100) {
        yj5.a r101 = f217211c;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.i(r100);
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final String u(String r100) {
        tt5.a.b("SdkHostServiceImp", "recognizeQRCode(), path:" + du5.b.g(r100));
        if (TextUtils.isEmpty(r100) == false) goto L6;
        tt5.a.d("SdkHostServiceImp", "recognizeQRCode(), photo path is null");
        return "";
    L6:
        Bundle r101 = new Bundle();
        r101.putString("command", "recognize_qr");
        r101.putString("photo_qr", r100);
        Bundle r102 = doCommand(r101);
        if (r102 != null) goto L11;
        tt5.a.d("SdkHostServiceImp", "recognizeQRCode(), is null");
        return "";
    L11:
        if (TextUtils.equals(r102.getString("command"), "recognize_qr") == true) goto L13;
        return "";
    L13:
        return r102.getString("result_qr");
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void v(String r100) {
        tt5.a.b("SdkHostServiceImp", "handleQrResult(), result:" + du5.b.g(r100));
        Bundle r101 = new Bundle();
        r101.putString("command", "handle_result_qr");
        r101.putString("result_qr", r100);
        doCommand(r101);
    }

    public static Bundle b(String r100, String r101) {
        Bundle r102 = new Bundle();
        r102.putString("command", "share");
        if (r100 == null) goto L5;
        r102.putString("android.intent.extra.TITLE", r100);
    L5:
        if (r101 == null) goto L7;
        r102.putString("android.intent.extra.TEXT", r101);
    L7:
        r102.putString("android.intent.extra.USER", "Docs");
        r102.putBoolean("android.intent.extra.LOCAL_ONLY", true);
        return r102;
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void q(String r100, IGetDataCallback<Integer> r101) {
        tt5.a.h("SdkHostServiceImp", "updateOrder(): reactionKey = " + r100);
        cx4.a r102 = yn4.b.f568532h;
        if (r102 != null) goto L6;
        tt5.a.d("SdkHostServiceImp", "updateOrder() fail : sReactionAgent == null");
        return;
    L6:
        r102.q(r100, r101);
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void t(String r100, String r101) {
        Bundle r102 = b(r100, r101);
        r102.putBoolean("support_addition_note", true);
        r102.putString("android.intent.extra.MIME_TYPES", "text/plain");
        doCommand(r102);
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void y(String r100, Map<String, String> r101) {
        if (TextUtils.isEmpty(r100) == true) goto L11;
        Bundle r102 = new Bundle();
        r102.putString("command", "open_url");
        r102.putString("url", r100);
        if (r101 != null) goto L7;
    L9:
        doCommand(r102);
        return;
    L7:
        if (r101.isEmpty() == true) goto L9;
        r102.putSerializable("extra", (Serializable) r101);
        goto L9
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void z(String r100, ArrayList r101) {
        Bundle r102 = b(r100, null);
        r102.putBoolean("support_addition_note", true);
        r102.putString("android.intent.extra.MIME_TYPES", "image/*");
        if (r101 == null) goto L5;
        r102.putParcelableArrayList("android.intent.extra.STREAM", r101);
    L5:
        doCommand(r102);
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void s(boolean r100, String r101, ShortcutItemV2.a r102) {
        yj5.a r103 = f217211c;
        if (r103 == null) goto L6;
        r103.s(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void w(String r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        Bundle r103 = new Bundle();
        r103.putString("command", "profile_main");
        r103.putString("user_id", r100);
        r103.putString("title", r101);
        r103.putBoolean("isMinutes", r102);
        doCommand(r103);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.x
    public final void B(String r100, String r101, String r102, IBinder r103) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        tt5.a.h("SdkHostServiceImp", "notifyAnnouncementChange: chat id = " + r100 + ", url = " + du5.b.g(r101));
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        Bundle r104 = new Bundle();
        r104.putString("command", "notify_announcement_change");
        r104.putString("chat_id", r100);
        r104.putString(DocCallbackImpl.KEY_THUMBNAIL, r101);
        r104.putBoolean(DocCallbackImpl.KEY_IS_EDITED, false);
        r104.putString("announce_name", r102);
        r104.putBinder("announce_send_callback", r103);
        doCommand(r104);
    }
}
