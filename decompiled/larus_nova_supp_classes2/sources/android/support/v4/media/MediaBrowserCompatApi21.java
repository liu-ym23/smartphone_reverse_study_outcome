package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class MediaBrowserCompatApi21 {
    static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

    public interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    public static class ConnectionCallbackProxy<T extends ConnectionCallback> extends MediaBrowser.ConnectionCallback {
        protected final T mConnectionCallback;

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.mConnectionCallback.onConnected();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.mConnectionCallback.onConnectionFailed();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.mConnectionCallback.onConnectionSuspended();
        }

        public ConnectionCallbackProxy(T r1) {
            this.mConnectionCallback = r1;
        }
    }

    public static class MediaItem {
        private MediaItem() {
        }

        public static Object getDescription(Object r0) {
            return ((MediaBrowser.MediaItem) r0).getDescription();
        }

        public static int getFlags(Object r0) {
            return ((MediaBrowser.MediaItem) r0).getFlags();
        }
    }

    public interface SubscriptionCallback {
        void onChildrenLoaded(String r1, List<?> r2);

        void onError(String r1);
    }

    public static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowser.SubscriptionCallback {
        protected final T mSubscriptionCallback;

        public SubscriptionCallbackProxy(T r1) {
            this.mSubscriptionCallback = r1;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String r2) {
            this.mSubscriptionCallback.onError(r2);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String r2, List<MediaBrowser.MediaItem> r3) {
            this.mSubscriptionCallback.onChildrenLoaded(r2, r3);
        }
    }

    private MediaBrowserCompatApi21() {
    }

    public static void connect(Object r0) {
        ((MediaBrowser) r0).connect();
    }

    public static Object createConnectionCallback(ConnectionCallback r1) {
        return new ConnectionCallbackProxy(r1);
    }

    public static Object createSubscriptionCallback(SubscriptionCallback r1) {
        return new SubscriptionCallbackProxy(r1);
    }

    public static void disconnect(Object r0) {
        ((MediaBrowser) r0).disconnect();
    }

    public static Bundle getExtras(Object r0) {
        return ((MediaBrowser) r0).getExtras();
    }

    public static String getRoot(Object r0) {
        return ((MediaBrowser) r0).getRoot();
    }

    public static ComponentName getServiceComponent(Object r0) {
        return ((MediaBrowser) r0).getServiceComponent();
    }

    public static Object getSessionToken(Object r0) {
        return ((MediaBrowser) r0).getSessionToken();
    }

    public static boolean isConnected(Object r0) {
        return ((MediaBrowser) r0).isConnected();
    }

    public static void unsubscribe(Object r0, String r1) {
        ((MediaBrowser) r0).unsubscribe(r1);
    }

    public static void subscribe(Object r0, String r1, Object r2) {
        ((MediaBrowser) r0).subscribe(r1, (MediaBrowser.SubscriptionCallback) r2);
    }

    public static Object createBrowser(Context r1, ComponentName r2, Object r3, Bundle r4) {
        return new MediaBrowser(r1, r2, (MediaBrowser.ConnectionCallback) r3, r4);
    }
}
