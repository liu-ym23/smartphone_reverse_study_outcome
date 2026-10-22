package com.bytedance.push;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.common.push.BaseJson;
import com.larus.bmhome.music.applet.MusicAppletPage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b0 extends BaseJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f266752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f266753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f266754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f266755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f266756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f266757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f266758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PushBody f266759h;

    public final PushBody b() {
        if (this.f266759h != null) goto L9;
        this.f266759h = new PushBody(new JSONObject(this.f266758g));     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        return this.f266759h;
    }

    public final ContentValues c() {
        ContentValues r100 = new ContentValues();
        r100.put(MusicAppletPage.KEY_MESSAGE_ID, Long.valueOf(this.f266753b));
        r100.put("arrive_time", Long.valueOf(this.f266754c));
        r100.put("client_intelligence_expire_time", Long.valueOf(this.f266755d));
        r100.put("sender", Integer.valueOf(this.f266752a));
        r100.put("handle_by_sdk", Integer.valueOf(this.f266756e ? 1 : 0));
        r100.put("has_been_shown", Integer.valueOf(this.f266757f ? 1 : 0));
        if (TextUtils.isEmpty(this.f266758g) == false) goto L11;
        PushBody r101 = this.f266759h;
        if (r101 == null) goto L11;
        JSONObject r102 = r101.f266722k;
        if (r102 == null) goto L9;
        String r103 = r102.toString();
    L10:
        this.f266758g = r103;
        goto L11
    L9:
        r103 = null;
    L11:
        r100.put("push_body", this.f266758g);
        return r100;
    }

    public b0(Cursor r100) {
        boolean r101 = false;
        this.f266753b = r100.getLong(0);
        this.f266754c = r100.getLong(1);
        this.f266755d = r100.getLong(2);
        this.f266752a = r100.getInt(3);
        if (r100.getInt(4) != 1) goto L5;
        boolean r102 = true;
    L6:
        this.f266756e = r102;
        if (r100.getInt(5) != 1) goto L9;
        r101 = true;
    L9:
        this.f266757f = r101;
        String r103 = r100.getString(6);
        this.f266758g = r103;
        if (TextUtils.isEmpty(r103) == true) goto L18;
        this.f266759h = new PushBody(new JSONObject(this.f266758g));     // Catch: JSONException -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        this.f266759h = null;
        return;
    L18:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public b0(int r100, long r101, long r102, long r103, boolean r104, String r105) {
        this.f266752a = r100;
        this.f266753b = r101;
        this.f266754c = r102;
        this.f266755d = r103;
        this.f266756e = r104;
        this.f266757f = false;
        this.f266758g = r105;
    }
}
