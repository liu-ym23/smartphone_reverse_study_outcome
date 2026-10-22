package com.bytedance.bdturing;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Objects;
import jc4.o;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.f;

/* JADX INFO: loaded from: classes12.dex */
public class SmarterVerifyView extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f201701c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f201702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.bdturing.a f201703b;

    public class a implements com.bytedance.bdturing.a.InterfaceC2906a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmarterVerifyView f201704a;

        public a(SmarterVerifyView r100) {
            this.f201704a = r100;
        }

        @Override // com.bytedance.bdturing.a.InterfaceC2906a
        public final void a(JSONObject r100) {
            JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, "click_coordinate");     // Catch: JSONException -> L15
            r101.put(this.f201704a.getWidth());     // Catch: JSONException -> L15
            r101.put(this.f201704a.getHeight());     // Catch: JSONException -> L15
            Objects.toString(r100);     // Catch: JSONException -> L15
            SmarterVerifyView r102 = this.f201704a;     // Catch: JSONException -> L15
            int r103 = SmarterVerifyView.f201701c;     // Catch: JSONException -> L15
            r102.getClass();     // Catch: JSONException -> L15
            qb4.b r104 = qb4.b.c.f532315a;     // Catch: JSONException -> L15
            o r105 = new o(r100);     // Catch: JSONException -> L15
            r105.f498092c = false;     // Catch: JSONException -> L15
            Context r106 = r102.getContext();     // Catch: JSONException -> L15
            Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: JSONException -> L15
            Activity r107 = null;
            if ((r106 instanceof ContextWrapper) == false) goto L13;
            ContextWrapper r108 = (ContextWrapper) r106;     // Catch: JSONException -> L15
        L7:
            if ((r108 instanceof Activity) == true) goto L12;
            Context r109 = r108.getBaseContext();     // Catch: JSONException -> L15
            if ((r109 instanceof ContextWrapper) == false) goto L13;
            r108 = (ContextWrapper) r109;     // Catch: JSONException -> L15
            goto L7
        L12:
            r107 = (Activity) r108;     // Catch: JSONException -> L15
        L13:
            r104.i(r107, r105, r102.f201702a);     // Catch: JSONException -> L15
            return;
        L15:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public SmarterVerifyView(Context r100) {
        super(r100);
        this.f201703b = new com.bytedance.bdturing.a();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (qb4.b.c.f532315a.f532303b == true) goto L5;
        return true;
    L5:
        int r101 = r100.getAction();
        if (r101 != 0) goto L8;
        com.bytedance.bdturing.a r102 = this.f201703b;
        r102.getClass();
        r102.f201738a = System.currentTimeMillis();
        return false;
    L8:
        if (r101 != 1) goto L13;
        this.f201703b.a(r100, new a(this));
        return false;
    L13:
        return false;
    }

    public void setCallBack(f r100) {
        this.f201702a = r100;
    }

    public SmarterVerifyView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f201703b = new com.bytedance.bdturing.a();
    }

    public SmarterVerifyView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f201703b = new com.bytedance.bdturing.a();
    }
}
