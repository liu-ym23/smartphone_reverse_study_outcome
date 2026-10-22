package com.oplus.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.api.Api.ApiOptions;
import com.oplus.ocs.base.internal.ClientSettings;

/* JADX INFO: loaded from: classes34.dex */
public class Api<O extends ApiOptions> {
    private AbstractClientBuilder<?, O> mClientBuilder;
    private ClientKey<?> mClientKey;
    private boolean mIsAuth;
    private String mName;

    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        public abstract T buildClient(Context r100, Looper r101, ClientSettings r102, O r103);

        public AbstractClientBuilder() {
        }
    }

    public interface AnyClient {
    }

    public static class AnyClientKey<C extends AnyClient> {
        public AnyClientKey() {
        }
    }

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public static class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public static abstract class BaseClientBuilder<T extends AnyClient, O> {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public BaseClientBuilder() {
        }
    }

    public interface Client extends AnyClient {
        <T> void addQueue(TaskListenerHolder<T> r100);

        void connect();

        void disconnect();

        AuthResult getAuthResult();

        Looper getLooper();

        int getMinApkVersion();

        IBinder getRemoteService();

        boolean isConnected();

        boolean isConnecting();

        void setOnCapabilityAuthListener(i r100);

        void setOnClearListener(j r100);

        void setOnConnectionFailedListener(OnConnectionFailedListener r100, Handler r101);

        void setOnConnectionSucceedListener(OnConnectionSucceedListener r100, Handler r101);
    }

    public static class ClientKey<C extends Client> extends AnyClientKey<C> {
        public ClientKey() {
        }
    }

    public interface SimpleClient<T extends IInterface> extends AnyClient {
        T createServiceInterface(IBinder r100);

        Context getContext();

        String getServiceDescriptor();

        String getStartServiceAction();

        void setState(int r100, T r101);
    }

    public AbstractClientBuilder<?, O> getClientBuilder() {
        if (this.mClientBuilder == null) goto L5;
        boolean r100 = true;
    L6:
        com.oplus.ocs.base.utils.d.a(r100, "The ClientBuilder is null");
        return this.mClientBuilder;
    L5:
        r100 = false;
        goto L6
    }

    public ClientKey<?> getClientKey() {
        ClientKey<?> r100 = this.mClientKey;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("This API was constructed with null clientKey.");
    }

    public BaseClientBuilder<?, O> getBaseClientBuilder() {
        return this.mClientBuilder;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isAuth() {
        return this.mIsAuth;
    }

    public <C extends Client> Api(String r100, AbstractClientBuilder<C, O> r101, ClientKey<C> r102) {
        this(r100, r101, r102, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends Client> Api(String r100, AbstractClientBuilder<C, O> r101, ClientKey<C> r102, boolean r103) {
        com.oplus.ocs.base.utils.d.a(r101, "can not construct whit the null AbstractClientBuilder");
        com.oplus.ocs.base.utils.d.a(r102, "can not construct with the null ClientKey");
        this.mName = r100;
        this.mClientBuilder = r101;
        this.mClientKey = r102;
        this.mIsAuth = r103;
    }
}
