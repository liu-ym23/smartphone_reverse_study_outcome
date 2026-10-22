package com.bytedance.bdturing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.f;

/* JADX INFO: loaded from: classes12.dex */
public class SmarterVerifyButton extends VerifyWebView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.bdturing.a f201699l;

    public class a implements com.bytedance.bdturing.a.InterfaceC2906a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmarterVerifyButton f201700a;

        public a(SmarterVerifyButton r100) {
            this.f201700a = r100;
        }

        @Override // com.bytedance.bdturing.a.InterfaceC2906a
        public final void a(JSONObject r100) {
            SmarterVerifyButton r101 = this.f201700a;     // Catch: JSONException -> L4
            long r102 = r101.f201699l.f201738a;     // Catch: JSONException -> L4
            r101.getClass();     // Catch: JSONException -> L4
            r100.put("operate_duration", r102 - 0);     // Catch: JSONException -> L4
            JSONArray r103 = JSONObjectProtectorUtils.getJSONArray(r100, "click_coordinate");     // Catch: JSONException -> L4
            r103.put(this.f201700a.getWidth());     // Catch: JSONException -> L4
            r103.put(this.f201700a.getHeight());     // Catch: JSONException -> L4
            r100.toString();     // Catch: JSONException -> L4
            this.f201700a.getClass();     // Catch: JSONException -> L4
            ac4.c.b("bytedcert.verifyData", r100, "bytedcert.verifyData");     // Catch: JSONException -> L4
            throw null;     // Catch: JSONException -> L4
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public void setCallback(f r100) {
    }

    public SmarterVerifyButton(Context r100) {
        super(r100);
        this.f201699l = new com.bytedance.bdturing.a();
    }

    @Override // com.bytedance.bdturing.VerifyWebView, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (qb4.b.c.f532315a.f532303b == true) goto L5;
    L13:
        return true;
    L5:
        if (this.f201725c == false) goto L13;
        int r101 = r100.getAction();
        if (r101 != 0) goto L9;
        com.bytedance.bdturing.a r102 = this.f201699l;
        r102.getClass();
        r102.f201738a = System.currentTimeMillis();
    L12:
        return super.onTouchEvent(r100);
    L9:
        if (r101 != 1) goto L12;
        this.f201699l.a(r100, new a(this));
        goto L12
    }

    public SmarterVerifyButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f201699l = new com.bytedance.bdturing.a();
    }
}
