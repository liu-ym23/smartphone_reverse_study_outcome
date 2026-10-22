package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public abstract class HuaweiApiClient implements AidlApiClient {

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f276942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Scope> f276943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<PermissionInfo> f276944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<Api<?>, Api.ApiOptions> f276945d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private OnConnectionFailedListener f276946e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ConnectionCallbacks f276947f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f276948g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Activity f276949h;

        public Builder applyDefaultAccount() {
            return this;
        }

        public Builder setAccountName(String r100) {
            return this;
        }

        public Builder setHandler(Handler r100) {
            return this;
        }

        public Builder setPopupsGravity(int r100) {
            return this;
        }

        public Builder setViewForPopups(View r100) {
            return this;
        }

        public HuaweiApiClient build() {
            addApi(new Api("Core.API"));
            HuaweiApiClientImpl r100 = new HuaweiApiClientImpl(this.f276942a);
            r100.setScopes(this.f276943b);
            r100.setPermissionInfos(this.f276944c);
            r100.setApiMap(this.f276945d);
            r100.setConnectionCallbacks(this.f276947f);
            r100.setConnectionFailedListener(this.f276946e);
            r100.setAutoLifecycleClientId(this.f276948g);
            if (this.f276948g < 0) goto L5;
            a(r100);
        L5:
            return r100;
        }

        public Builder(Context r100) throws NullPointerException {
            this.f276943b = new ArrayList();
            this.f276944c = new ArrayList();
            this.f276945d = new HashMap();
            Checker.checkNonNull(r100, "context must not be null.");
            Context r101 = r100.getApplicationContext();
            this.f276942a = r101;
            this.f276948g = -1;
            ResourceLoaderUtil.setmContext(r101);
            a(r100);
        }

        private void a(HuaweiApiClient r100) {
            AutoLifecycleFragment.getInstance(this.f276949h).startAutoMange(this.f276948g, r100);
        }

        public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> r100) {
            this.f276945d.put(r100, null);
            if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(r100.getApiName()) == false) goto L5;
            HiAnalyticsUtil.getInstance().onEvent(this.f276942a.getApplicationContext(), HiAnalyticsConstant.KeyAndValue.GAME_INIT_KEY, HiAnalyticsConstant.REPORT_VAL_SEPARATOR + System.currentTimeMillis());
        L5:
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks r100) {
            Checker.checkNonNull(r100, "listener must not be null.");
            this.f276947f = r100;
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener r100) {
            Checker.checkNonNull(r100, "listener must not be null.");
            this.f276946e = r100;
            return this;
        }

        public Builder addScope(Scope r100) {
            Checker.checkNonNull(r100, "scope must not be null.");
            this.f276943b.add(r100);
            return this;
        }

        private void a(Context r100) {
            HMSBIInitializer.getInstance(r100).initBI();
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> r100, O r101) {
            Checker.checkNonNull(r100, "Api must not be null");
            Checker.checkNonNull(r101, "Null options are not permitted for this Api");
            this.f276945d.put(r100, r101);
            if (r100.getOptions() == null) goto L5;
            List<Scope> r102 = r100.getOptions().getScopeList(r101);
            this.f276943b.addAll(r102);
            List<PermissionInfo> r103 = r100.getOptions().getPermissionInfoList(r101);
            this.f276944c.addAll(r103);
        L5:
            return this;
        }

        public Builder addApiWithScope(Api<? extends Api.ApiOptions.NotRequiredOptions> r100, Scope... r101) {
            Checker.checkNonNull(r100, "Api must not be null");
            Checker.checkNonNull(r101, "Scopes must not be null");
            this.f276945d.put(r100, null);
            ArrayList r102 = new ArrayList(Arrays.asList(r101));
            this.f276943b.addAll(r102);
            return this;
        }

        public Builder allowLifeCycleManagement(Activity r100, OnConnectionFailedListener r101) {
            return allowLifeCycleManagement(r100, 0, r101);
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiWithScope(Api<O> r100, O r101, Scope... r102) {
            Checker.checkNonNull(r100, "Api must not be null");
            Checker.checkNonNull(r101, "Null options are not permitted for this Api");
            Checker.checkNonNull(r102, "Scopes must not be null");
            this.f276945d.put(r100, r101);
            if (r100.getOptions() == null) goto L5;
            List<Scope> r103 = r100.getOptions().getScopeList(r101);
            this.f276943b.addAll(r103);
            List<PermissionInfo> r104 = r100.getOptions().getPermissionInfoList(r101);
            this.f276944c.addAll(r104);
        L5:
            ArrayList r105 = new ArrayList(Arrays.asList(r102));
            this.f276943b.addAll(r105);
            return this;
        }

        public Builder allowLifeCycleManagement(Activity r100, int r101, OnConnectionFailedListener r102) {
            if (r101 < 0) goto L6;
            this.f276948g = r101;
            this.f276949h = (Activity) Preconditions.checkNotNull(r100, "activity must not be Null.");
            return this;
        L6:
            throw new IllegalArgumentException("allowLifeCycleManagement id should be positive");
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int r100);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult r100);
    }

    public HuaweiApiClient() {
    }

    public abstract void checkUpdate(Activity r100, CheckUpdatelistener r101);

    public abstract void connect(Activity r100);

    public abstract void connectForeground();

    public abstract void disableLifeCycleManagement(Activity r100);

    public abstract PendingResult<Status> discardAndReconnect();

    public abstract void disconnect();

    public abstract Map<Api<?>, Api.ApiOptions> getApiMap();

    public abstract ConnectionResult getConnectionResult(Api<?> r100);

    public abstract List<PermissionInfo> getPermissionInfos();

    public abstract List<Scope> getScopes();

    public abstract Activity getTopActivity();

    public abstract boolean hasConnectedApi(Api<?> r100);

    public abstract boolean hasConnectionFailureListener(OnConnectionFailedListener r100);

    public abstract boolean hasConnectionSuccessListener(ConnectionCallbacks r100);

    public abstract ConnectionResult holdUpConnect();

    public abstract ConnectionResult holdUpConnect(long r100, TimeUnit r101);

    @Override // com.huawei.hms.support.api.client.ApiClient
    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void onPause(Activity r100);

    public abstract void onResume(Activity r100);

    public abstract void print(String r100, FileDescriptor r101, PrintWriter r102, String[] r103);

    public abstract void reconnect();

    public abstract void removeConnectionFailureListener(OnConnectionFailedListener r100);

    public abstract void removeConnectionSuccessListener(ConnectionCallbacks r100);

    public abstract void setConnectionCallbacks(ConnectionCallbacks r100);

    public abstract void setConnectionFailedListener(OnConnectionFailedListener r100);

    public abstract boolean setSubAppInfo(SubAppInfo r100);

    public void connect(int r100) {
        throw new UnsupportedOperationException();
    }
}
