package com.bytedance.ee.lark.component;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import org.json.JSONException;

/* JADX INFO: loaded from: classes19.dex */
public abstract class AbstractNativeComponent implements tr5.a {
    private static final String BRIDGE_FUNCTION_NATIVE_CALL_BACK = "LarkWebViewJavaScriptBridge.nativeCallBack(%s)";
    private static final String TAG = "AbstractNativeComponent";
    private ViewGroup mContainer;
    private Context mContext;
    private JSONObject mData;
    private JSONObject mDataExtra;
    private ur5.a mNativeComponentContext;
    private yr5.a mNativeComponentModel;
    private String mViewId;
    private String mViewType;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f242766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f242767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractNativeComponent f242768c;

        /* JADX INFO: renamed from: com.bytedance.ee.lark.component.AbstractNativeComponent$a$a, reason: collision with other inner class name */
        public class C3474a implements ValueCallback<String> {
            public C3474a() {
            }

            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(String r100) {
                Log.i(AbstractNativeComponent.TAG, "onReceiveValue, value = " + r100);
            }
        }

        public final void a() {
            org.json.JSONObject r100 = new org.json.JSONObject();     // Catch: JSONException -> L5
            org.json.JSONObject r101 = new org.json.JSONObject();     // Catch: JSONException -> L5
            r101.put("type", this.f242768c.getViewType());     // Catch: JSONException -> L5
            r101.put("event", this.f242766a);     // Catch: JSONException -> L5
            r101.put("id", this.f242768c.getViewId());     // Catch: JSONException -> L5
            r101.put("data", this.f242767b);     // Catch: JSONException -> L5
            r100.put("callbackID", "nativeComponentAction");     // Catch: JSONException -> L5
            r100.put("data", r101);     // Catch: JSONException -> L5
            r100.put("callbackType", "continued");     // Catch: JSONException -> L5
            org.json.JSONObject r102 = new org.json.JSONObject();     // Catch: JSONException -> L5
            r102.put("bizDomain", "open_platform");     // Catch: JSONException -> L5
            r100.put("extra", r102);     // Catch: JSONException -> L5
            AbstractNativeComponent.access$000(this.f242768c).f551380b.a(String.format(AbstractNativeComponent.BRIDGE_FUNCTION_NATIVE_CALL_BACK, new Object[]{r100.toString()}), new C3474a());     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            Log.e(AbstractNativeComponent.TAG, "fireEvent, JSON exception = " + e.getMessage());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AbstractNativeComponent r100, String r101, JSONObject r102) {
            this.f242768c = r100;
            this.f242766a = r101;
            this.f242767b = r102;
        }
    }

    public abstract /* synthetic */ String getComponentViewType();

    @Override // tr5.a
    public abstract /* synthetic */ View onCreateView(Context r100, JSONObject r101);

    @Override // tr5.a
    public abstract /* synthetic */ void onRemove();

    @Override // tr5.a
    public abstract /* synthetic */ void onUpdateView(View r100, JSONObject r101);

    @Override // tr5.a
    public abstract /* synthetic */ void performAction(String r100, JSONObject r101);

    @Override // tr5.a
    public int getHeight() {
        if (this.mNativeComponentModel != null) goto L7;
        return 0;
    L7:
        return Math.round(INVOKEVIRTUAL_com_bytedance_ee_lark_component_AbstractNativeComponent_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).density * this.mNativeComponentModel.f568916f);
    }

    @Override // tr5.a
    public int getWidth() {
        if (this.mNativeComponentModel != null) goto L7;
        return 0;
    L7:
        return Math.round(INVOKEVIRTUAL_com_bytedance_ee_lark_component_AbstractNativeComponent_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).density * this.mNativeComponentModel.f568915e);
    }

    @Override // tr5.a
    public int getZIndex() {
        yr5.a r100 = this.mNativeComponentModel;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f568914d;
    }

    @Override // tr5.a
    public ViewGroup getContainer() {
        return this.mContainer;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // tr5.a
    public JSONObject getData() {
        return this.mData;
    }

    public JSONObject getDataExtra() {
        return this.mDataExtra;
    }

    @Override // tr5.a
    public String getViewId() {
        return this.mViewId;
    }

    @Override // tr5.a
    public String getViewType() {
        return this.mViewType;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_ee_lark_component_AbstractNativeComponent_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ ur5.a access$000(AbstractNativeComponent r100) {
        return r100.mNativeComponentContext;
    }

    @Override // tr5.a
    public void bindContainer(ViewGroup r100) {
        this.mContainer = r100;
    }

    @Override // tr5.a
    public void bindData(yr5.a r100) {
        if (r100 != null) goto L4;
    L6:
        Log.e(TAG, "component model data is invalid");
        return;
    L4:
        if (r100.f568913c == null) goto L6;
        this.mNativeComponentModel = r100;
        this.mDataExtra = null;
        this.mData = r100.f568913c;
    }

    @Override // tr5.a
    public void updateData(JSONObject r100) {
        yr5.a r101 = this.mNativeComponentModel;
        if (r101 == null) goto L9;
        if (r100 == null) goto L6;
        r101.f568913c = r100;
    L7:
        this.mData = r100;
        return;
    L6:
        r101.getClass();
        goto L7
    }

    public void fireEvent(String r100, JSONObject r101) {
        this.mContainer.post(new a(this, r100, r101));
    }

    @Override // tr5.a
    public void setWidthAndHeight(int r100, int r101) {
        if (this.mNativeComponentModel != null) goto L5;
        return;
    L5:
        float r102 = INVOKEVIRTUAL_com_bytedance_ee_lark_component_AbstractNativeComponent_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).density;
        float r103 = r100 / r102;
        float r104 = r101 / r102;
        yr5.a r105 = this.mNativeComponentModel;
        r105.f568915e = r103;
        r105.f568916f = r104;
    }

    public AbstractNativeComponent(ur5.a r100, String r101, String r102) {
        this.mViewId = r101;
        this.mViewType = r102;
        this.mNativeComponentContext = r100;
        this.mContext = r100.getContext();
    }
}
