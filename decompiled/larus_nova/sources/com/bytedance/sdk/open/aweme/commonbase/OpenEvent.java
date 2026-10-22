package com.bytedance.sdk.open.aweme.commonbase;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.OpenEventService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.aweme.utils.OpenUtils;
import com.bytedance.sdk.open.aweme.utils.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class OpenEvent {
    private static final String TAG = "OpenEvent";
    private static volatile OpenEventService inst;
    private final String eventName;
    private final c paramsProvider;
    private final long timestamp;

    public static class Builder {
        private final String eventName;
        private final b paramsBuilder;
        private final long timestamp;

        public Builder(String r100) {
            this.timestamp = System.currentTimeMillis();
            this.eventName = r100;
            this.paramsBuilder = new b();
            addCommonParam();
        }

        private void addCommonParam() {
            this.paramsBuilder.a("sdk_version", "5.21.1-rc.0");
            if (DouYinSdkContext.inst().getClientKey() == null) goto L5;
            this.paramsBuilder.a("client_key", DouYinSdkContext.inst().getClientKey());
        L5:
            this.paramsBuilder.a("is_open", Integer.valueOf(!OpenUtils.isInternal() ? 1 : 0));
            Context r100 = DouYinSdkContext.inst().getContext();     // Catch: Exception -> L12
            b r101 = this.paramsBuilder;     // Catch: Exception -> L12
            r101.a("douyin_install", Integer.valueOf(AppUtil.isAppInstalled(r100, "com.ss.android.ugc.aweme") ? 1 : 0));     // Catch: Exception -> L12
            b r102 = this.paramsBuilder;     // Catch: Exception -> L12
            r102.a("dylite_install", Integer.valueOf(AppUtil.isAppInstalled(r100, "com.ss.android.ugc.aweme.lite") ? 1 : 0));     // Catch: Exception -> L12
            return;
        }

        public Builder addKVJsonObject(JSONObject r100) {
            this.paramsBuilder.a(r100);
            return this;
        }

        public OpenEvent build() {
            return new OpenEvent(this.timestamp, this.eventName, this.paramsBuilder, null);
        }

        public Builder kv(String r100, Object r101) {
            this.paramsBuilder.a(r100, r101);
            return this;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OpenEvent f269614a;

        public a(OpenEvent r100) {
            this.f269614a = r100;
        }

        public void com_bytedance_sdk_open_aweme_commonbase_OpenEvent$a__run$___twin___() {
            JSONObject r100 = new JSONObject();
            if (OpenEvent.access$000(this.f269614a) == null) goto L6;
            OpenEvent.access$100(r100, OpenEvent.access$000(this.f269614a).a());     // Catch: Throwable -> L15
        L6:
            OpenEventService r101 = OpenEvent.access$200();     // Catch: Throwable -> L15
            if (r101 == null) goto L9;
            r101.sendEventV3(OpenEvent.access$300(this.f269614a), r100);     // Catch: Throwable -> L15
            return;
        L9:
            if (OpenUtils.isInternal() == true) goto L11;
            return;
        L11:
            LogUtils.e(OpenEvent.TAG, new Object[]{"please implement OpenEventService"});     // Catch: Throwable -> L15
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_sdk_open_aweme_commonbase_OpenEvent$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_sdk_open_aweme_commonbase_OpenEvent$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_bytedance_sdk_open_aweme_commonbase_OpenEvent$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f269615a;

        public b() {
        }

        public b a(String r100, Object r101) {
            if (r100 == null) goto L8;
            if (r101 == null) goto L8;
            if (this.f269615a != null) goto L7;
            this.f269615a = new JSONObject();     // Catch: JSONException -> L9
        L7:
            this.f269615a.put(r100, r101);     // Catch: JSONException -> L9
        L8:
            return this;
        }

        public b a(JSONObject r100) {
            if (this.f269615a != null) goto L5;
            this.f269615a = new JSONObject();
        L5:
            OpenEvent.access$100(this.f269615a, r100);
            return this;
        }

        @Override // com.bytedance.sdk.open.aweme.commonbase.OpenEvent.c
        public JSONObject a() {
            return this.f269615a;
        }
    }

    public interface c {
        JSONObject a();
    }

    private OpenEvent(long r100, String r101, c r102) {
        this.timestamp = r100;
        this.eventName = r101;
        this.paramsProvider = r102;
    }

    public /* synthetic */ OpenEvent(long r100, String r101, c r102, a r103) {
        this(r100, r101, r102);
    }

    public static /* synthetic */ c access$000(OpenEvent r100) {
        return r100.paramsProvider;
    }

    public static /* synthetic */ void access$100(JSONObject r100, JSONObject r101) {
        putAll(r100, r101);
    }

    public static /* synthetic */ OpenEventService access$200() {
        return getEventService();
    }

    public static /* synthetic */ String access$300(OpenEvent r100) {
        return r100.eventName;
    }

    private static OpenEventService getEventService() {
        if (inst != null) goto L15;
        monitor-enter(OpenEvent.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (inst != null) goto L9;
        inst = (OpenEventService) OpenServiceManager.getInst().getService(OpenEventService.class);     // Catch: Throwable -> L11
    L9:
        monitor-exit(OpenEvent.class);     // Catch: Throwable -> L11
    L15:
        return inst;
    }

    private static void putAll(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L16;
        Iterator<String> r102 = r101.keys();     // Catch: Throwable -> L11
    L7:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();     // Catch: Throwable -> L11
        r100.put(r103, r101.get(r103));     // Catch: Throwable -> L11
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public void flush() {
        if (TextUtils.isEmpty(this.eventName) == false) goto L5;
        return;
    L5:
        ThreadUtils.summit(new a(this));
    }
}
