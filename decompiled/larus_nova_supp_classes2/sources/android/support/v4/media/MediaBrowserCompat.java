package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    static final boolean DEBUG = false;
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserImpl mImpl;

    public static class CallbackHandler extends Handler {
        private final WeakReference<MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        private WeakReference<Messenger> mCallbacksMessengerRef;

        public CallbackHandler(MediaBrowserServiceCallbackImpl r2) {
            this.mCallbackImplRef = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r11) {
            WeakReference<Messenger> r0 = this.mCallbacksMessengerRef;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() != null) goto L7;
            return;
        L7:
            if (this.mCallbackImplRef.get() == null) goto L33;
            Bundle r1 = r11.getData();
            MediaSessionCompat.ensureClassLoader(r1);
            MediaBrowserServiceCallbackImpl r2 = this.mCallbackImplRef.get();
            Messenger r8 = this.mCallbacksMessengerRef.get();
            int r3 = r11.what;     // Catch: BadParcelableException -> L22
            if (r3 != 1) goto L14;
            Bundle r4 = r1.getBundle("data_root_hints");     // Catch: BadParcelableException -> L22
            MediaSessionCompat.ensureClassLoader(r4);     // Catch: BadParcelableException -> L22
            r2.onServiceConnected(r8, r1.getString("data_media_item_id"), (MediaSessionCompat.Token) r1.getParcelable("data_media_session_token"), r4);     // Catch: BadParcelableException -> L22
        L26:
            return;
        L14:
            if (r3 != 2) goto L16;
            r2.onConnectionFailed(r8);     // Catch: BadParcelableException -> L22
            goto L26
        L16:
            if (r3 == 3) goto L18;
            r11.toString();     // Catch: BadParcelableException -> L22
            goto L26
        L18:
            Bundle r6 = r1.getBundle("data_options");     // Catch: BadParcelableException -> L22
            MediaSessionCompat.ensureClassLoader(r6);     // Catch: BadParcelableException -> L22
            Bundle r7 = r1.getBundle("data_notify_children_changed_options");     // Catch: BadParcelableException -> L22
            MediaSessionCompat.ensureClassLoader(r7);     // Catch: BadParcelableException -> L22
            r2.onLoadChildren(r8, r1.getString("data_media_item_id"), r1.getParcelableArrayList("data_media_item_list"), r6, r7);     // Catch: BadParcelableException -> L22
        L23:
            if (r11.what != 1) goto L32;
            r2.onConnectionFailed(r8);
            return;
        L32:
            return;
        }

        public void setCallbacksMessenger(Messenger r2) {
            this.mCallbacksMessengerRef = new WeakReference(r2);
        }
    }

    public static class ConnectionCallback {
        ConnectionCallbackInternal mConnectionCallbackInternal;
        final Object mConnectionCallbackObj;

        public interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback {
            final /* synthetic */ ConnectionCallback this$0;

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnected() {
                ConnectionCallbackInternal r0 = this.this$0.mConnectionCallbackInternal;
                if (r0 == null) goto L5;
                r0.onConnected();
            L5:
                this.this$0.onConnected();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionFailed() {
                ConnectionCallbackInternal r0 = this.this$0.mConnectionCallbackInternal;
                if (r0 == null) goto L5;
                r0.onConnectionFailed();
            L5:
                this.this$0.onConnectionFailed();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionSuspended() {
                ConnectionCallbackInternal r0 = this.this$0.mConnectionCallbackInternal;
                if (r0 == null) goto L5;
                r0.onConnectionSuspended();
            L5:
                this.this$0.onConnectionSuspended();
            }

            public StubApi21(ConnectionCallback r1) {
                this.this$0 = r1;
            }
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        public ConnectionCallback() {
            this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21(this));
        }

        public void setInternalConnectionCallback(ConnectionCallbackInternal r1) {
            this.mConnectionCallbackInternal = r1;
        }
    }

    public static abstract class CustomActionCallback {
        public CustomActionCallback() {
        }

        public void onError(String r1, Bundle r2, Bundle r3) {
        }

        public void onProgressUpdate(String r1, Bundle r2, Bundle r3) {
        }

        public void onResult(String r1, Bundle r2, Bundle r3) {
        }
    }

    public static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final CustomActionCallback mCallback;
        private final Bundle mExtras;

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r3, Bundle r4) {
            if (this.mCallback != null) goto L5;
            return;
        L5:
            MediaSessionCompat.ensureClassLoader(r4);
            if (r3 == (-1)) goto L13;
            if (r3 != 0) goto L9;
            this.mCallback.onResult(this.mAction, this.mExtras, r4);
            return;
        L9:
            if (r3 == 1) goto L11;
            Objects.toString(this.mExtras);
            Objects.toString(r4);
            return;
        L11:
            this.mCallback.onProgressUpdate(this.mAction, this.mExtras, r4);
            return;
        L13:
            this.mCallback.onError(this.mAction, this.mExtras, r4);
        }

        public CustomActionResultReceiver(String r1, Bundle r2, CustomActionCallback r3, Handler r4) {
            super(r4);
            this.mAction = r1;
            this.mExtras = r2;
            this.mCallback = r3;
        }
    }

    public static abstract class ItemCallback {
        final Object mItemCallbackObj;

        public class StubApi23 implements MediaBrowserCompatApi23.ItemCallback {
            final /* synthetic */ ItemCallback this$0;

            public StubApi23(ItemCallback r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onError(String r2) {
                this.this$0.onError(r2);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onItemLoaded(Parcel r2) {
                if (r2 != null) goto L4;
                this.this$0.onItemLoaded(null);
                return;
            L4:
                r2.setDataPosition(0);
                MediaItem r0 = MediaItem.CREATOR.createFromParcel(r2);
                r2.recycle();
                this.this$0.onItemLoaded(r0);
            }
        }

        public void onError(String r1) {
        }

        public void onItemLoaded(MediaItem r1) {
        }

        public ItemCallback() {
            if (Build.VERSION.SDK_INT < 23) goto L5;
            this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new StubApi23(this));
            return;
        L5:
            this.mItemCallbackObj = null;
        }
    }

    public static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r2, Bundle r3) {
            MediaSessionCompat.ensureClassLoader(r3);
            if (r2 != 0) goto L16;
            if (r3 == null) goto L16;
            if (r3.containsKey("media_item") == false) goto L16;
            Parcelable r4 = r3.getParcelable("media_item");
            if (r4 != null) goto L11;
        L14:
            this.mCallback.onItemLoaded((MediaItem) r4);
            return;
        L11:
            if ((r4 instanceof MediaItem) == true) goto L14;
            this.mCallback.onError(this.mMediaId);
            return;
        L16:
            this.mCallback.onError(this.mMediaId);
        }

        public ItemReceiver(String r1, ItemCallback r2, Handler r3) {
            super(r3);
            this.mMediaId = r1;
            this.mCallback = r2;
        }
    }

    public interface MediaBrowserImpl {
        void connect();

        void disconnect();

        Bundle getExtras();

        void getItem(String r1, ItemCallback r2);

        Bundle getNotifyChildrenChangedOptions();

        String getRoot();

        ComponentName getServiceComponent();

        MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(String r1, Bundle r2, SearchCallback r3);

        void sendCustomAction(String r1, Bundle r2, CustomActionCallback r3);

        void subscribe(String r1, Bundle r2, SubscriptionCallback r3);

        void unsubscribe(String r1, SubscriptionCallback r2);
    }

    public static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {
        protected final Object mBrowserObj;
        protected Messenger mCallbacksMessenger;
        final Context mContext;
        protected final CallbackHandler mHandler;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        protected final Bundle mRootHints;
        protected ServiceBinderWrapper mServiceBinderWrapper;
        protected int mServiceVersion;
        private final ArrayMap<String, Subscription> mSubscriptions;

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger r1) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger r1, String r2, MediaSessionCompat.Token r3, Bundle r4) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            MediaBrowserCompatApi21.connect(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            ServiceBinderWrapper r0 = this.mServiceBinderWrapper;
            if (r0 == null) goto L7;
            Messenger r1 = this.mCallbacksMessenger;
            if (r1 == null) goto L7;
            r0.unregisterCallbackMessenger(r1);     // Catch: RemoteException -> L9
        L7:
            MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getExtras() {
            return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public String getRoot() {
            return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken != null) goto L6;
            this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
        L6:
            return this.mMediaSessionToken;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            Bundle r0 = MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
            if (r0 != null) goto L5;
            return;
        L5:
            this.mServiceVersion = r0.getInt("extra_service_version", 0);
            IBinder r1 = BundleCompat.getBinder(r0, "extra_messenger");
            if (r1 == null) goto L11;
            this.mServiceBinderWrapper = new ServiceBinderWrapper(r1, this.mRootHints);
            this.mCallbacksMessenger = new Messenger(this.mHandler);
            this.mHandler.setCallbacksMessenger(this.mCallbacksMessenger);
            this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);     // Catch: RemoteException -> L10
        L11:
            IMediaSession r2 = IMediaSession.Stub.asInterface(BundleCompat.getBinder(r0, "extra_session_binder"));
            if (r2 == null) goto L17;
            this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj), r2);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(final String r4, final ItemCallback r5) {
            if (TextUtils.isEmpty(r4) == true) goto L21;
            if (r5 == null) goto L19;
            if (MediaBrowserCompatApi21.isConnected(this.mBrowserObj) == true) goto L10;
            this.mHandler.post(new AnonymousClass1(this, r5, r4));
            return;
        L10:
            if (this.mServiceBinderWrapper != null) goto L13;
            this.mHandler.post(new AnonymousClass2(this, r5, r4));
            return;
        L13:
            ItemReceiver r0 = new ItemReceiver(r4, r5, this.mHandler);
            this.mServiceBinderWrapper.getMediaItem(r4, r0, this.mCallbacksMessenger);     // Catch: RemoteException -> L16
            return;
        L16:
            this.mHandler.post(new AnonymousClass3(this, r5, r4));
            return;
        L19:
            throw new IllegalArgumentException("cb is null");
        L21:
            throw new IllegalArgumentException("mediaId is empty");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String r8, SubscriptionCallback r9) {
            Subscription r0 = (Subscription) this.mSubscriptions.get(r8);
            if (r0 != null) goto L5;
            return;
        L5:
            ServiceBinderWrapper r1 = this.mServiceBinderWrapper;
            if (r1 != null) goto L32;
            if (r9 != null) goto L9;
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, r8);
        L28:
            if (r0.isEmpty() == true) goto L30;
            if (r9 == null) goto L30;
            return;
        L30:
            this.mSubscriptions.remove(r8);
            return;
        L9:
            List<SubscriptionCallback> r2 = r0.getCallbacks();
            List<Bundle> r3 = r0.getOptionsList();
            int r4 = r2.size() - 1;
        L10:
            if (r4 < 0) goto L16;
            if (ListProtector.get(r2, r4) != r9) goto L14;
            ListProtector.remove(r2, r4);
            ListProtector.remove(r3, r4);
        L14:
            r4 = r4 - 1;
            goto L10
        L16:
            if (r2.size() != 0) goto L28;
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, r8);
            goto L28
        L32:
            if (r9 != null) goto L20;
            r1.removeSubscription(r8, null, this.mCallbacksMessenger);     // Catch: RemoteException -> L26
            goto L28
        L20:
            List<SubscriptionCallback> r5 = r0.getCallbacks();     // Catch: RemoteException -> L26
            List<Bundle> r6 = r0.getOptionsList();     // Catch: RemoteException -> L26
            int r7 = r5.size() - 1;     // Catch: RemoteException -> L26
        L21:
            if (r7 < 0) goto L28;
            if (ListProtector.get(r5, r7) != r9) goto L25;
            this.mServiceBinderWrapper.removeSubscription(r8, r9.mToken, this.mCallbacksMessenger);     // Catch: RemoteException -> L26
            ListProtector.remove(r5, r7);     // Catch: RemoteException -> L26
            ListProtector.remove(r6, r7);     // Catch: RemoteException -> L26
        L25:
            r7 = r7 - 1;
            goto L21
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(final String r4, final Bundle r5, final SearchCallback r6) {
            if (isConnected() == false) goto L14;
            if (this.mServiceBinderWrapper != null) goto L8;
            this.mHandler.post(new AnonymousClass4(this, r6, r4, r5));
            return;
        L8:
            SearchResultReceiver r0 = new SearchResultReceiver(r4, r5, r6, this.mHandler);
            this.mServiceBinderWrapper.search(r4, r5, r0, this.mCallbacksMessenger);     // Catch: RemoteException -> L11
            return;
        L11:
            this.mHandler.post(new AnonymousClass5(this, r6, r4, r5));
            return;
        L14:
            throw new IllegalStateException("search() called while not connected");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(final String r4, final Bundle r5, final CustomActionCallback r6) {
            if (isConnected() == false) goto L16;
            if (this.mServiceBinderWrapper != null) goto L17;
            if (r6 == null) goto L17;
            this.mHandler.post(new AnonymousClass6(this, r6, r4, r5));
        L17:
            this.mServiceBinderWrapper.sendCustomAction(r4, r5, new CustomActionResultReceiver(r4, r5, r6, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L11
            return;
        L11:
            Objects.toString(r5);
            if (r6 == null) goto L19;
            this.mHandler.post(new AnonymousClass7(this, r6, r4, r5));
            return;
        L19:
            return;
        L16:
            throw new IllegalStateException("Cannot send a custom action (" + r4 + ") with extras " + r5 + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String r3, Bundle r4, SubscriptionCallback r5) {
            Subscription r0 = (Subscription) this.mSubscriptions.get(r3);
            if (r0 != null) goto L5;
            r0 = new Subscription();
            this.mSubscriptions.put(r3, r0);
        L5:
            r5.setSubscription(r0);
            if (r4 != null) goto L8;
            Bundle r6 = null;
        L9:
            r0.putCallback(r6, r5);
            ServiceBinderWrapper r1 = this.mServiceBinderWrapper;
            if (r1 != null) goto L16;
            MediaBrowserCompatApi21.subscribe(this.mBrowserObj, r3, r5.mSubscriptionCallbackObj);
            return;
        L16:
            r1.addSubscription(r3, r5.mToken, r6, this.mCallbacksMessenger);     // Catch: RemoteException -> L14
            return;
        L15:
            return;
        L8:
            r6 = new Bundle(r4);
            goto L9
        }

        public MediaBrowserImplApi21(Context r3, ComponentName r4, ConnectionCallback r5, Bundle r6) {
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new ArrayMap();
            this.mContext = r3;
            if (r6 == null) goto L5;
            Bundle r0 = new Bundle(r6);
        L6:
            this.mRootHints = r0;
            r0.putInt("extra_client_version", 1);
            r5.setInternalConnectionCallback(this);
            this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(r3, r4, r5.mConnectionCallbackObj, r0);
            return;
        L5:
            r0 = new Bundle();
            goto L6
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger r2, String r3, List r4, Bundle r5, Bundle r6) {
            if (this.mCallbacksMessenger == r2) goto L5;
            return;
        L5:
            Subscription r7 = (Subscription) this.mSubscriptions.get(r3);
            if (r7 == null) goto L8;
            SubscriptionCallback r8 = r7.getCallback(r5);
            if (r8 != null) goto L14;
            return;
        L14:
            if (r5 != null) goto L18;
            if (r4 != null) goto L17;
            r8.onError(r3);
            return;
        L17:
            this.mNotifyChildrenChangedOptions = r6;
            r8.onChildrenLoaded(r3, r4);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L18:
            if (r4 != null) goto L20;
            r8.onError(r3, r5);
            return;
        L20:
            this.mNotifyChildrenChangedOptions = r6;
            r8.onChildrenLoaded(r3, r4, r5);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L8:
            if (MediaBrowserCompat.DEBUG == true) goto L10;
            return;
        }
    }

    public static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(String r2, ItemCallback r3) {
            if (this.mServiceBinderWrapper != null) goto L5;
            MediaBrowserCompatApi23.getItem(this.mBrowserObj, r2, r3.mItemCallbackObj);
            return;
        L5:
            super.getItem(r2, r3);
        }

        public MediaBrowserImplApi23(Context r1, ComponentName r2, ConnectionCallback r3, Bundle r4) {
            super(r1, r2, r3, r4);
        }
    }

    public static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String r3, SubscriptionCallback r4) {
            if (this.mServiceBinderWrapper != null) goto L5;
        L8:
            if (r4 != null) goto L10;
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, r3);
            return;
        L10:
            MediaBrowserCompatApi26.unsubscribe(this.mBrowserObj, r3, r4.mSubscriptionCallbackObj);
            return;
        L5:
            if (this.mServiceVersion < 2) goto L8;
            super.unsubscribe(r3, r4);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String r3, Bundle r4, SubscriptionCallback r5) {
            if (this.mServiceBinderWrapper != null) goto L5;
        L8:
            if (r4 != null) goto L10;
            MediaBrowserCompatApi21.subscribe(this.mBrowserObj, r3, r5.mSubscriptionCallbackObj);
            return;
        L10:
            MediaBrowserCompatApi26.subscribe(this.mBrowserObj, r3, r4, r5.mSubscriptionCallbackObj);
            return;
        L5:
            if (this.mServiceVersion < 2) goto L8;
            super.subscribe(r3, r4, r5);
        }

        public MediaBrowserImplApi26(Context r1, ComponentName r2, ConnectionCallback r3, Bundle r4) {
            super(r1, r2, r3, r4);
        }
    }

    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        final CallbackHandler mHandler;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        final Bundle mRootHints;
        private String mRootId;
        ServiceBinderWrapper mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        int mState;
        private final ArrayMap<String, Subscription> mSubscriptions;

        public class MediaServiceConnection implements ServiceConnection {
            final /* synthetic */ MediaBrowserImplBase this$0;

            public MediaServiceConnection(MediaBrowserImplBase r1) {
                this.this$0 = r1;
            }

            private void postOrRun(Runnable r3) {
                if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(this.this$0.mHandler.getLooper())) goto L5;
                r3.run();
                return;
            L5:
                this.this$0.mHandler.post(r3);
            }

            public boolean isCurrent(String r3) {
                MediaBrowserImplBase r4 = this.this$0;
                if (r4.mServiceConnection != this) goto L9;
                int r0 = r4.mState;
                if (r0 == 0) goto L9;
                if (r0 == 1) goto L9;
                return true;
            L9:
                int r1 = r4.mState;
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L16;
                Objects.toString(r4.mServiceComponent);
                Objects.toString(this.this$0.mServiceConnection);
                toString();
                return false;
            L16:
                return false;
            L15:
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName r2) {
                postOrRun(new AnonymousClass2(this, r2));
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName r2, final IBinder r3) {
                postOrRun(new AnonymousClass1(this, r2, r3));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new AnonymousClass2(this));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            int r0 = this.mState;
            if (r0 != 0) goto L5;
        L9:
            this.mState = 2;
            this.mHandler.post(new AnonymousClass1(this));
            return;
        L5:
            if (r0 == 1) goto L9;
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + ")");
        }

        public void dump() {
            Objects.toString(this.mServiceComponent);
            Objects.toString(this.mCallback);
            Objects.toString(this.mRootHints);
            getStateLabel(this.mState);
            Objects.toString(this.mServiceConnection);
            Objects.toString(this.mServiceBinderWrapper);
            Objects.toString(this.mCallbacksMessenger);
            Objects.toString(this.mMediaSessionToken);
        }

        public void forceCloseConnection() {
            MediaServiceConnection r0 = this.mServiceConnection;
            if (r0 == null) goto L5;
            this.mContext.unbindService(r0);
        L5:
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            if (this.mState != 3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getExtras() {
            if (isConnected() == false) goto L7;
            return this.mExtras;
        L7:
            throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public String getRoot() {
            if (isConnected() == false) goto L7;
            return this.mRootId;
        L7:
            throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            if (isConnected() == false) goto L7;
            return this.mServiceComponent;
        L7:
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token getSessionToken() {
            if (isConnected() == false) goto L7;
            return this.mMediaSessionToken;
        L7:
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        private static String getStateLabel(int r2) {
            if (r2 != 0) goto L4;
            return "CONNECT_STATE_DISCONNECTING";
        L4:
            if (r2 != 1) goto L6;
            return "CONNECT_STATE_DISCONNECTED";
        L6:
            if (r2 != 2) goto L8;
            return "CONNECT_STATE_CONNECTING";
        L8:
            if (r2 != 3) goto L10;
            return "CONNECT_STATE_CONNECTED";
        L10:
            if (r2 != 4) goto L12;
            return "CONNECT_STATE_SUSPENDED";
        L12:
            return "UNKNOWN/" + r2;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger r2) {
            Objects.toString(this.mServiceComponent);
            if (isCurrent(r2, "onConnectFailed") == true) goto L5;
            return;
        L5:
            int r3 = this.mState;
            if (r3 == 2) goto L9;
            getStateLabel(r3);
            return;
        L9:
            forceCloseConnection();
            this.mCallback.onConnectionFailed();
        }

        private boolean isCurrent(Messenger r2, String r3) {
            if (this.mCallbacksMessenger != r2) goto L9;
            int r4 = this.mState;
            if (r4 == 0) goto L9;
            if (r4 == 1) goto L9;
            return true;
        L9:
            int r5 = this.mState;
            if (r5 == 0) goto L15;
            if (r5 == 1) goto L16;
            Objects.toString(this.mServiceComponent);
            Objects.toString(this.mCallbacksMessenger);
            toString();
            return false;
        L16:
            return false;
        L15:
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(final String r4, final ItemCallback r5) {
            if (TextUtils.isEmpty(r4) == true) goto L17;
            if (r5 == null) goto L15;
            if (isConnected() == true) goto L9;
            this.mHandler.post(new AnonymousClass3(this, r5, r4));
            return;
        L9:
            ItemReceiver r0 = new ItemReceiver(r4, r5, this.mHandler);
            this.mServiceBinderWrapper.getMediaItem(r4, r0, this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L12:
            this.mHandler.post(new AnonymousClass4(this, r5, r4));
            return;
        L15:
            throw new IllegalArgumentException("cb is null");
        L17:
            throw new IllegalArgumentException("mediaId is empty");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String r8, SubscriptionCallback r9) {
            Subscription r0 = (Subscription) this.mSubscriptions.get(r8);
            if (r0 != null) goto L24;
            return;
        L24:
            if (r9 == null) goto L7;
            List<SubscriptionCallback> r1 = r0.getCallbacks();     // Catch: RemoteException -> L18
            List<Bundle> r2 = r0.getOptionsList();     // Catch: RemoteException -> L18
            int r3 = r1.size() - 1;     // Catch: RemoteException -> L18
        L10:
            if (r3 < 0) goto L20;
            if (ListProtector.get(r1, r3) != r9) goto L17;
            if (isConnected() == false) goto L16;
            this.mServiceBinderWrapper.removeSubscription(r8, r9.mToken, this.mCallbacksMessenger);     // Catch: RemoteException -> L18
        L16:
            ListProtector.remove(r1, r3);     // Catch: RemoteException -> L18
            ListProtector.remove(r2, r3);     // Catch: RemoteException -> L18
        L17:
            r3 = r3 - 1;
            goto L10
        L7:
            if (isConnected() == false) goto L20;
            this.mServiceBinderWrapper.removeSubscription(r8, null, this.mCallbacksMessenger);     // Catch: RemoteException -> L18
        L20:
            if (r0.isEmpty() == true) goto L22;
            if (r9 == null) goto L22;
            return;
        L22:
            this.mSubscriptions.remove(r8);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(final String r4, final Bundle r5, final SearchCallback r6) {
            if (isConnected() == false) goto L10;
            this.mServiceBinderWrapper.search(r4, r5, new SearchResultReceiver(r4, r5, r6, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L7
            return;
        L7:
            this.mHandler.post(new AnonymousClass5(this, r6, r4, r5));
            return;
        L10:
            throw new IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(final String r4, final Bundle r5, final CustomActionCallback r6) {
            if (isConnected() == false) goto L12;
            this.mServiceBinderWrapper.sendCustomAction(r4, r5, new CustomActionResultReceiver(r4, r5, r6, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L7
            return;
        L7:
            Objects.toString(r5);
            if (r6 == null) goto L15;
            this.mHandler.post(new AnonymousClass6(this, r6, r4, r5));
            return;
        L15:
            return;
        L12:
            throw new IllegalStateException("Cannot send a custom action (" + r4 + ") with extras " + r5 + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String r3, Bundle r4, SubscriptionCallback r5) {
            Subscription r0 = (Subscription) this.mSubscriptions.get(r3);
            if (r0 != null) goto L5;
            r0 = new Subscription();
            this.mSubscriptions.put(r3, r0);
        L5:
            if (r4 != null) goto L7;
            Bundle r6 = null;
        L8:
            r0.putCallback(r6, r5);
            if (isConnected() == false) goto L16;
            this.mServiceBinderWrapper.addSubscription(r3, r5.mToken, r6, this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L13:
            return;
        L16:
            return;
        L7:
            r6 = new Bundle(r4);
            goto L8
        }

        public MediaBrowserImplBase(Context r2, ComponentName r3, ConnectionCallback r4, Bundle r5) {
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new ArrayMap();
            this.mState = 1;
            if (r2 == null) goto L17;
            if (r3 == null) goto L15;
            if (r4 == null) goto L13;
            this.mContext = r2;
            this.mServiceComponent = r3;
            this.mCallback = r4;
            if (r5 != null) goto L9;
            Bundle r6 = null;
        L10:
            this.mRootHints = r6;
            return;
        L9:
            r6 = new Bundle(r5);
            goto L10
        L13:
            throw new IllegalArgumentException("connection callback must not be null");
        L15:
            throw new IllegalArgumentException("service component must not be null");
        L17:
            throw new IllegalArgumentException("context must not be null");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger r6, String r7, MediaSessionCompat.Token r8, Bundle r9) {
            if (isCurrent(r6, "onConnect") == true) goto L5;
            return;
        L5:
            int r10 = this.mState;
            if (r10 == 2) goto L9;
            getStateLabel(r10);
            return;
        L9:
            this.mRootId = r7;
            this.mMediaSessionToken = r8;
            this.mExtras = r9;
            this.mState = 3;
            if (MediaBrowserCompat.DEBUG == false) goto L12;
            dump();
        L12:
            this.mCallback.onConnected();
            Iterator r11 = this.mSubscriptions.entrySet().iterator();     // Catch: RemoteException -> L22
        L15:
            if (r11.hasNext() == false) goto L27;
            Map.Entry r12 = (Map.Entry) r11.next();     // Catch: RemoteException -> L22
            String r13 = (String) r12.getKey();     // Catch: RemoteException -> L22
            Subscription r14 = (Subscription) r12.getValue();     // Catch: RemoteException -> L22
            List<SubscriptionCallback> r15 = r14.getCallbacks();     // Catch: RemoteException -> L22
            List<Bundle> r16 = r14.getOptionsList();     // Catch: RemoteException -> L22
            int r0 = 0;
        L18:
            if (r0 >= r15.size()) goto L15;
            this.mServiceBinderWrapper.addSubscription(r13, ((SubscriptionCallback) ListProtector.get(r15, r0)).mToken, (Bundle) ListProtector.get(r16, r0), this.mCallbacksMessenger);     // Catch: RemoteException -> L22
            r0 = r0 + 1;
            goto L18
        L27:
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger r2, String r3, List r4, Bundle r5, Bundle r6) {
            if (isCurrent(r2, "onLoadChildren") == true) goto L5;
            return;
        L5:
            boolean r7 = MediaBrowserCompat.DEBUG;
            if (r7 == false) goto L8;
            Objects.toString(this.mServiceComponent);
        L8:
            Subscription r0 = (Subscription) this.mSubscriptions.get(r3);
            if (r0 != null) goto L13;
            if (r7 == true) goto L12;
            return;
        L12:
            return;
        L13:
            SubscriptionCallback r8 = r0.getCallback(r5);
            if (r8 != null) goto L16;
            return;
        L16:
            if (r5 != null) goto L20;
            if (r4 != null) goto L19;
            r8.onError(r3);
            return;
        L19:
            this.mNotifyChildrenChangedOptions = r6;
            r8.onChildrenLoaded(r3, r4);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L20:
            if (r4 != null) goto L22;
            r8.onError(r3, r5);
            return;
        L22:
            this.mNotifyChildrenChangedOptions = r6;
            r8.onChildrenLoaded(r3, r4, r5);
            this.mNotifyChildrenChangedOptions = null;
        }
    }

    public interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger r1);

        void onLoadChildren(Messenger r1, String r2, List r3, Bundle r4, Bundle r5);

        void onServiceConnected(Messenger r1, String r2, MediaSessionCompat.Token r3, Bundle r4);
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = null;
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Flags {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isPlayable() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        public MediaItem(Parcel r2) {
            this.mFlags = r2.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(r2);
        }

        public static MediaItem fromMediaItem(Object r2) {
            if (r2 == null) goto L5;
            int r0 = MediaBrowserCompatApi21.MediaItem.getFlags(r2);
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(MediaBrowserCompatApi21.MediaItem.getDescription(r2)), r0);
        L5:
            return null;
        }

        public static List<MediaItem> fromMediaItemList(List<?> r2) {
            if (r2 == null) goto L8;
            ArrayList r0 = new ArrayList(r2.size());
            Iterator<?> r3 = r2.iterator();
        L5:
            if (r3.hasNext() == false) goto L7;
            r0.add(fromMediaItem(r3.next()));
            goto L5
        L7:
            return r0;
        L8:
            return null;
        }

        public MediaItem(MediaDescriptionCompat r2, int r3) {
            if (r2 == null) goto L11;
            if (TextUtils.isEmpty(r2.getMediaId()) == true) goto L9;
            this.mFlags = r3;
            this.mDescription = r2;
            return;
        L9:
            throw new IllegalArgumentException("description must have a non-empty media id");
        L11:
            throw new IllegalArgumentException("description cannot be null");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeInt(this.mFlags);
            this.mDescription.writeToParcel(r2, r3);
        }
    }

    public static abstract class SearchCallback {
        public SearchCallback() {
        }

        public void onError(String r1, Bundle r2) {
        }

        public void onSearchResult(String r1, Bundle r2, List<MediaItem> r3) {
        }
    }

    public static class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r4, Bundle r5) {
            MediaSessionCompat.ensureClassLoader(r5);
            if (r4 != 0) goto L16;
            if (r5 == null) goto L16;
            if (r5.containsKey("search_results") == false) goto L16;
            Parcelable[] r6 = r5.getParcelableArray("search_results");
            if (r6 == null) goto L13;
            ArrayList r7 = new ArrayList();
            int r0 = r6.length;
            int r1 = 0;
        L11:
            if (r1 >= r0) goto L14;
            r7.add((MediaItem) r6[r1]);
            r1 = r1 + 1;
        L14:
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, r7);
            return;
        L13:
            r7 = null;
        L16:
            this.mCallback.onError(this.mQuery, this.mExtras);
        }

        public SearchResultReceiver(String r1, Bundle r2, SearchCallback r3, Handler r4) {
            super(r4);
            this.mQuery = r1;
            this.mExtras = r2;
            this.mCallback = r3;
        }
    }

    public static class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public void disconnect(Messenger r3) throws RemoteException {
            sendRequest(2, null, r3);
        }

        public void unregisterCallbackMessenger(Messenger r3) throws RemoteException {
            sendRequest(7, null, r3);
        }

        public ServiceBinderWrapper(IBinder r2, Bundle r3) {
            this.mMessenger = new Messenger(r2);
            this.mRootHints = r3;
        }

        public void connect(Context r3, Messenger r4) throws RemoteException {
            Bundle r0 = new Bundle();
            r0.putString("data_package_name", r3.getPackageName());
            r0.putBundle("data_root_hints", this.mRootHints);
            sendRequest(1, r0, r4);
        }

        public void registerCallbackMessenger(Context r3, Messenger r4) throws RemoteException {
            Bundle r0 = new Bundle();
            r0.putString("data_package_name", r3.getPackageName());
            r0.putBundle("data_root_hints", this.mRootHints);
            sendRequest(6, r0, r4);
        }

        private void sendRequest(int r2, Bundle r3, Messenger r4) throws RemoteException {
            Message r0 = Message.obtain();
            r0.what = r2;
            r0.arg1 = 1;
            r0.setData(r3);
            r0.replyTo = r4;
            this.mMessenger.send(r0);
        }

        public void getMediaItem(String r3, ResultReceiver r4, Messenger r5) throws RemoteException {
            Bundle r0 = new Bundle();
            r0.putString("data_media_item_id", r3);
            r0.putParcelable("data_result_receiver", r4);
            sendRequest(5, r0, r5);
        }

        public void removeSubscription(String r3, IBinder r4, Messenger r5) throws RemoteException {
            Bundle r0 = new Bundle();
            r0.putString("data_media_item_id", r3);
            BundleCompat.putBinder(r0, "data_callback_token", r4);
            sendRequest(4, r0, r5);
        }

        public void addSubscription(String r3, IBinder r4, Bundle r5, Messenger r6) throws RemoteException {
            Bundle r0 = new Bundle();
            r0.putString("data_media_item_id", r3);
            BundleCompat.putBinder(r0, "data_callback_token", r4);
            r0.putBundle("data_options", r5);
            sendRequest(3, r0, r6);
        }

        public void search(String r3, Bundle r4, ResultReceiver r5, Messenger r6) throws RemoteException {
            Bundle r0 = new Bundle();
            r0.putString("data_search_query", r3);
            r0.putBundle("data_search_extras", r4);
            r0.putParcelable("data_result_receiver", r5);
            sendRequest(8, r0, r6);
        }

        public void sendCustomAction(String r3, Bundle r4, ResultReceiver r5, Messenger r6) throws RemoteException {
            Bundle r0 = new Bundle();
            r0.putString("data_custom_action", r3);
            r0.putBundle("data_custom_action_extras", r4);
            r0.putParcelable("data_result_receiver", r5);
            sendRequest(9, r0, r6);
        }
    }

    public static class Subscription {
        private final List<SubscriptionCallback> mCallbacks;
        private final List<Bundle> mOptionsList;

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public Subscription() {
            this.mCallbacks = new ArrayList();
            this.mOptionsList = new ArrayList();
        }

        public List<SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public List<Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public SubscriptionCallback getCallback(Bundle r3) {
            int r0 = 0;
        L4:
            if (r0 >= this.mOptionsList.size()) goto L10;
            if (MediaBrowserCompatUtils.areSameOptions((Bundle) ListProtector.get(this.mOptionsList, r0), r3) == true) goto L8;
            r0 = r0 + 1;
            goto L4
        L8:
            return (SubscriptionCallback) ListProtector.get(this.mCallbacks, r0);
        L10:
            return null;
        }

        public void putCallback(Bundle r3, SubscriptionCallback r4) {
            int r0 = 0;
        L4:
            if (r0 >= this.mOptionsList.size()) goto L10;
            if (MediaBrowserCompatUtils.areSameOptions((Bundle) ListProtector.get(this.mOptionsList, r0), r3) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            ListProtector.set(this.mCallbacks, r0, r4);
            return;
        L10:
            this.mCallbacks.add(r4);
            this.mOptionsList.add(r3);
        }
    }

    public static abstract class SubscriptionCallback {
        final Object mSubscriptionCallbackObj;
        WeakReference<Subscription> mSubscriptionRef;
        final IBinder mToken;

        public class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback {
            final /* synthetic */ SubscriptionCallback this$0;

            public StubApi21(SubscriptionCallback r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onError(String r2) {
                this.this$0.onError(r2);
            }

            public List<MediaItem> applyOptions(List<MediaItem> r4, Bundle r5) {
                if (r4 != null) goto L5;
                return null;
            L5:
                int r0 = r5.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int r6 = r5.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (r0 != (-1)) goto L9;
                if (r6 != (-1)) goto L9;
                return r4;
            L9:
                int r1 = r6 * r0;
                int r2 = r1 + r6;
                if (r0 < 0) goto L22;
                if (r6 < 1) goto L22;
                if (r1 >= r4.size()) goto L22;
                if (r2 <= r4.size()) goto L20;
                r2 = r4.size();
            L20:
                return r4.subList(r1, r2);
            L22:
                return Collections.emptyList();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onChildrenLoaded(String r7, List<?> r8) {
                WeakReference<Subscription> r0 = this.this$0.mSubscriptionRef;
                if (r0 != null) goto L5;
                Subscription r1 = null;
            L6:
                if (r1 != null) goto L8;
                this.this$0.onChildrenLoaded(r7, MediaItem.fromMediaItemList(r8));
                return;
            L8:
                List<MediaItem> r9 = MediaItem.fromMediaItemList(r8);
                List<SubscriptionCallback> r2 = r1.getCallbacks();
                List<Bundle> r3 = r1.getOptionsList();
                int r4 = 0;
            L10:
                if (r4 >= r2.size()) goto L20;
                Bundle r5 = (Bundle) ListProtector.get(r3, r4);
                if (r5 != null) goto L14;
                this.this$0.onChildrenLoaded(r7, r9);
            L15:
                r4 = r4 + 1;
                goto L10
            L14:
                this.this$0.onChildrenLoaded(r7, applyOptions(r9, r5), r5);
                goto L15
            L20:
                return;
            L5:
                r1 = r0.get();
                goto L6
            }
        }

        public class StubApi26 extends StubApi21 implements MediaBrowserCompatApi26.SubscriptionCallback {
            final /* synthetic */ SubscriptionCallback this$0;

            public StubApi26(SubscriptionCallback r1) {
                this.this$0 = r1;
                super(r1);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onError(String r2, Bundle r3) {
                this.this$0.onError(r2, r3);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onChildrenLoaded(String r2, List<?> r3, Bundle r4) {
                this.this$0.onChildrenLoaded(r2, MediaItem.fromMediaItemList(r3), r4);
            }
        }

        public void onChildrenLoaded(String r1, List<MediaItem> r2) {
        }

        public void onChildrenLoaded(String r1, List<MediaItem> r2, Bundle r3) {
        }

        public void onError(String r1) {
        }

        public void onError(String r1, Bundle r2) {
        }

        public SubscriptionCallback() {
            this.mToken = new Binder();
            if (Build.VERSION.SDK_INT < 26) goto L5;
            this.mSubscriptionCallbackObj = MediaBrowserCompatApi26.createSubscriptionCallback(new StubApi26(this));
            return;
        L5:
            this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new StubApi21(this));
        }

        public void setSubscription(Subscription r2) {
            this.mSubscriptionRef = new WeakReference(r2);
        }
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    public String getRoot() {
        return this.mImpl.getRoot();
    }

    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void unsubscribe(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L7;
        this.mImpl.unsubscribe(r3, null);
        return;
    L7:
        throw new IllegalArgumentException("parentId is empty");
    }

    public void getItem(String r2, ItemCallback r3) {
        this.mImpl.getItem(r2, r3);
    }

    public void subscribe(String r3, SubscriptionCallback r4) {
        if (TextUtils.isEmpty(r3) == true) goto L10;
        if (r4 == null) goto L8;
        this.mImpl.subscribe(r3, null, r4);
        return;
    L8:
        throw new IllegalArgumentException("callback is null");
    L10:
        throw new IllegalArgumentException("parentId is empty");
    }

    public void unsubscribe(String r2, SubscriptionCallback r3) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        if (r3 == null) goto L8;
        this.mImpl.unsubscribe(r2, r3);
        return;
    L8:
        throw new IllegalArgumentException("callback is null");
    L10:
        throw new IllegalArgumentException("parentId is empty");
    }

    public void search(String r2, Bundle r3, SearchCallback r4) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        if (r4 == null) goto L8;
        this.mImpl.search(r2, r3, r4);
        return;
    L8:
        throw new IllegalArgumentException("callback cannot be null");
    L10:
        throw new IllegalArgumentException("query cannot be empty");
    }

    public void sendCustomAction(String r2, Bundle r3, CustomActionCallback r4) {
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.mImpl.sendCustomAction(r2, r3, r4);
        return;
    L7:
        throw new IllegalArgumentException("action cannot be empty");
    }

    public void subscribe(String r2, Bundle r3, SubscriptionCallback r4) {
        if (TextUtils.isEmpty(r2) == true) goto L13;
        if (r4 == null) goto L11;
        if (r3 == null) goto L9;
        this.mImpl.subscribe(r2, r3, r4);
        return;
    L9:
        throw new IllegalArgumentException("options are null");
    L11:
        throw new IllegalArgumentException("callback is null");
    L13:
        throw new IllegalArgumentException("parentId is empty");
    }

    public MediaBrowserCompat(Context r3, ComponentName r4, ConnectionCallback r5, Bundle r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L6;
        this.mImpl = new MediaBrowserImplApi26(r3, r4, r5, r6);
        return;
    L6:
        if (r0 < 23) goto L8;
        this.mImpl = new MediaBrowserImplApi23(r3, r4, r5, r6);
        return;
    L8:
        this.mImpl = new MediaBrowserImplApi21(r3, r4, r5, r6);
    }
}
