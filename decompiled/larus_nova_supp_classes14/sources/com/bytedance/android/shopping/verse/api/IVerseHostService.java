package com.bytedance.android.shopping.verse.api;

import android.app.Activity;
import android.app.Application;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0001H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/verse/api/IVerseHostService;", "", "", "getHostPlugins", "", "getLarkEmail", "eventName", "Lorg/json/JSONObject;", "params", "", "sendLogV3", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "interceptor", "", "injectNetWorkInterceptor", "isAiVerseCaptureEnabled", "captureItem", "onAiVerseNetworkCapture", "onAiVerseAppLogCapture", "Landroid/app/Activity;", "getCurrentActivity", "Landroid/app/Application$ActivityLifecycleCallbacks;", "callback", "registerActivityLifeCycleCallback", "ec-verse-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVerseHostService {
    Activity getCurrentActivity();

    List<Object> getHostPlugins();

    String getLarkEmail();

    void injectNetWorkInterceptor(Interceptor r1);

    boolean isAiVerseCaptureEnabled();

    void onAiVerseAppLogCapture(String r1, JSONObject r2);

    void onAiVerseNetworkCapture(Object r1);

    void registerActivityLifeCycleCallback(Application.ActivityLifecycleCallbacks r1);

    boolean sendLogV3(String r1, JSONObject r2);
}
