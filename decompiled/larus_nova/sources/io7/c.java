package io7;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.network.model.GetSignInfoResponse;
import com.google.gson.GsonBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import jn7.i;
import oo7.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShareContent f495226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShareContentType f495227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f495228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f495229d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f495230a;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f495230a.f495229d;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((un7.c) r100).a(true, "");     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(c r100) {
            this.f495230a = r100;
        }
    }

    public interface b {
    }

    public final void b() {
        ShareContent r100 = this.f495226a;     // Catch: Throwable -> L28
        if (r100 != null) goto L5;
    L26:
        a(new Throwable("params error"));     // Catch: Throwable -> L28
        return;
    L5:
        if (r100.getShareChanelType() == null) goto L26;
        if (this.f495227b == null) goto L26;
        JSONObject r101 = this.f495228c;     // Catch: Throwable -> L28
        if (r101 == null) goto L26;
        if (r101.length() <= 0) goto L26;
        String r102 = ko7.a.b("/share_strategy/v1/check_and_sign/");     // Catch: Throwable -> L28
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L28
        r103.put("share_channel", ShareChannelType.getShareItemTypeName(this.f495226a.getShareChanelType()));     // Catch: Throwable -> L28
        r103.put("share_type", this.f495227b.getTypeName());     // Catch: Throwable -> L28
        r103.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, this.f495228c);     // Catch: Throwable -> L28
        String r104 = ko7.a.a(r102);     // Catch: Throwable -> L28
        i r105 = eo7.a.b.f473353a.f473330d;     // Catch: Throwable -> L28
        if (r105 == null) goto L16;
        String r106 = r105.a(r104, r103);     // Catch: Throwable -> L28
    L18:
        if (TextUtils.isEmpty(r106) == false) goto L21;
        a(new Throwable("response == null"));     // Catch: Throwable -> L28
        return;
    L21:
        GetSignInfoResponse r107 = (GetSignInfoResponse) new GsonBuilder().create().fromJson(r106, GetSignInfoResponse.class);     // Catch: Throwable -> L28
        if (r107 != null) goto L25;
        a(new Throwable("GetSignInfoResponse == null"));     // Catch: Throwable -> L28
        return;
    L25:
        k.e("GetSignInfoThread", "callSuccessOnMainThread()...");     // Catch: Throwable -> L28
        new Handler(Looper.getMainLooper()).post(new io7.b(this, r107));     // Catch: Throwable -> L28
        go7.b.i(this.f495226a, this.f495227b, r107, "");     // Catch: Throwable -> L28
        return;
    L16:
        r106 = null;
    L28:
        th = move-exception;
        a(th);
        i r108 = eo7.a.b.f473353a.f473330d;
        if (r108 == null) goto L35;
        r108.checkResponseException(th);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final void a(Throwable r100) {
        k.d("GetSignInfoThread", "callFailedOnMainThread()...", r100);
        new Handler(Looper.getMainLooper()).post(new a(this));
        go7.b.i(this.f495226a, this.f495227b, null, r100.toString());
    }

    public c(ShareContent r100, ShareContentType r101, JSONObject r102, un7.c r103) {
        this.f495226a = r100;
        this.f495227b = r101;
        this.f495228c = r102;
        this.f495229d = r103;
    }
}
