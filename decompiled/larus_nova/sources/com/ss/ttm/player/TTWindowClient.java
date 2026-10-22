package com.ss.ttm.player;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.larus.dora.api.model.FlowDoraWifiScene;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
class TTWindowClient implements TTAVWindowClient {
    private long mCWindowShellHandle;
    private ClientType mClientType;
    private WeakReference<TTAVWindowClient.ExternalInterface> mExternalRef;
    private final ReentrantLock mLock;
    private WeakReference<MediaPlayerClient> mMediaPlayerClientRef;
    private long mNativeWindowHandle;
    private WindowClientOnInfoCallback mOnInfoCallback;
    private ITTRenderView mRenderView;
    private WeakReference<TTPlayer> mTTPlayerRef;
    private int mWindowUsage;

    /* JADX INFO: renamed from: com.ss.ttm.player.TTWindowClient$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType = null;

        static {
            int[] r100 = new int[ClientType.values().length];
            $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType = r100;
            r100[ClientType.TT_PLAYER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[ClientType.C_WINDOW_SHELL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[ClientType.OTHER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[ClientType.EXTERNAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum ClientType extends Enum<ClientType> {
        private static final /* synthetic */ ClientType[] $VALUES = null;
        public static final ClientType C_WINDOW_SHELL = null;
        public static final ClientType EXTERNAL = null;
        public static final ClientType OTHER = null;
        public static final ClientType TT_PLAYER = null;
        public static final ClientType UN_KNOWN = null;

        static {
            ClientType r100 = new ClientType("UN_KNOWN", 0);
            UN_KNOWN = r100;
            ClientType r101 = new ClientType("TT_PLAYER", 1);
            TT_PLAYER = r101;
            ClientType r102 = new ClientType("C_WINDOW_SHELL", 2);
            C_WINDOW_SHELL = r102;
            ClientType r103 = new ClientType(FlowDoraWifiScene.OTHER, 3);
            OTHER = r103;
            ClientType r104 = new ClientType("EXTERNAL", 4);
            EXTERNAL = r104;
            $VALUES = new ClientType[]{r100, r101, r102, r103, r104};
        }

        public static ClientType[] values() {
            return (ClientType[]) $VALUES.clone();
        }

        public static ClientType valueOf(String r100) {
            return (ClientType) r27.a.a(ClientType.class, r100);
        }

        private ClientType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface WindowClientOnInfoCallback {
        void onInfo(int r100, int r101);
    }

    public static /* synthetic */ void a(WindowClientOnInfoCallback r100, boolean r101) {
        lambda$windowChangeBindInternal$2(r100, r101);
    }

    public static /* synthetic */ void b(WindowClientOnInfoCallback r100, int r101, int r102) {
        lambda$onInfo$1(r100, r101, r102);
    }

    public static /* synthetic */ void c(WindowClientOnInfoCallback r100, int r101, int r102) {
        lambda$updateVideoSize$0(r100, r101, r102);
    }

    private native long nativeCreateWindow(Surface r100, TTWindowClient r101);

    private native void nativeOnNewWindowAvailable(long r100, long r101);

    private native void nativeOnWindowChanged(long r100, int r101, int r102, int r103);

    private native void nativeOnWindowDestroyed(long r100);

    private native void nativeSetWindowUsage(long r100, int r101);

    private native void nativeWindowBindPlayer(long r100, long r101);

    private native void nativeWindowHandleIncRef(long r100);

    private void clearAllWeakReference() {
        WeakReference<TTPlayer> r100 = this.mTTPlayerRef;
        if (r100 == null) goto L5;
        r100.clear();
        this.mTTPlayerRef = null;
    L5:
        WeakReference<MediaPlayerClient> r101 = this.mMediaPlayerClientRef;
        if (r101 == null) goto L8;
        r101.clear();
        this.mMediaPlayerClientRef = null;
    L8:
        WeakReference<TTAVWindowClient.ExternalInterface> r102 = this.mExternalRef;
        if (r102 == null) goto L12;
        r102.clear();
        this.mExternalRef = null;
        return;
    }

    private TTAVWindowClient.ExternalInterface getExternal() {
        WeakReference<TTAVWindowClient.ExternalInterface> r100 = this.mExternalRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.get();
    }

    private MediaPlayerClient getMediaPlayerClient() {
        WeakReference<MediaPlayerClient> r100 = this.mMediaPlayerClientRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.get();
    }

    private TTPlayer getTTPlayer() {
        WeakReference<TTPlayer> r100 = this.mTTPlayerRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void windowChangeBindInternal() {
        if (this.mOnInfoCallback != null) goto L6;
        return;
    L6:
        if (this.mClientType != ClientType.EXTERNAL) goto L8;
        final ?? r100 = 1;
    L9:
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client bing changed neededFixedSize: " + r100);
        if (Looper.myLooper() == Looper.getMainLooper()) goto L14;
        Handler r101 = new Handler(Looper.getMainLooper());
        final WindowClientOnInfoCallback r102 = this.mOnInfoCallback;
        if (r102 == null) goto L16;
        r101.postAtFrontOfQueue(new j(r102, r100));
        return;
    L16:
        return;
    L14:
        this.mOnInfoCallback.onInfo(7, 0);
        this.mOnInfoCallback.onInfo(6, r100);
        return;
    L8:
        r100 = 0;
        goto L9
    }

    private void windowDestroyInternal() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[this.mClientType.ordinal()];
        if (r100 != 3) goto L5;
        MediaPlayerClient r101 = getMediaPlayerClient();
        if (r101 == null) goto L20;
        r101.setSurface(null);
        return;
    L20:
        return;
    L5:
        if (r100 == 4) goto L10;
        long r102 = this.mNativeWindowHandle;
        if (0 != r102) goto L9;
        return;
    L9:
        nativeOnWindowDestroyed(r102);
        this.mNativeWindowHandle = 0;
        return;
    L10:
        TTAVWindowClient.ExternalInterface r103 = getExternal();
        if (r103 == null) goto L18;
        r103.onWindowDestroyed();
        return;
    }

    public void onWindowDestroyed() {
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client destroyed type:  " + TTPlayerViewHelper.objectToString(this) + ", " + this.mClientType);
        this.mLock.lock();
        windowDestroyInternal();     // Catch: Throwable -> L6
        this.mLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void newWindowAvailableInternal(Surface r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        windowDestroyInternal();
        int r101 = AnonymousClass1.$SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[this.mClientType.ordinal()];
        if (r101 != 1) goto L7;
        TTPlayer r102 = getTTPlayer();
        if (r102 != null) goto L32;
        return;
    L32:
        if (reCreateNativeWindow(r100) == true) goto L34;
        return;
    L34:
        nativeWindowBindPlayer(this.mNativeWindowHandle, r102.getNativePlayer());
        nativeSetWindowUsage(this.mNativeWindowHandle, this.mWindowUsage);
        return;
    L7:
        if (r101 == 2) goto L22;
        if (r101 != 3) goto L11;
        MediaPlayerClient r103 = getMediaPlayerClient();
        if (r103 != null) goto L20;
        return;
    L20:
        r103.setSurface(r100);
        return;
    L11:
        if (r101 != 4) goto L39;
        TTAVWindowClient.ExternalInterface r104 = getExternal();
        if (r104 != null) goto L16;
        return;
    L16:
        r104.onNewWindowAvailable(r100);
        return;
    L39:
        return;
    L22:
        if (0 != this.mCWindowShellHandle) goto L25;
        return;
    L25:
        if (reCreateNativeWindow(r100) == true) goto L27;
        return;
    L27:
        nativeOnNewWindowAvailable(this.mCWindowShellHandle, this.mNativeWindowHandle);
    }

    private boolean reCreateNativeWindow(Surface r100) {
        long r101 = nativeCreateWindow(r100, this);
        this.mNativeWindowHandle = r101;
        if (0 == r101) goto L5;
        return true;
    L5:
        return false;
    }

    private void setExternal(TTAVWindowClient.ExternalInterface r100) {
        this.mExternalRef = new WeakReference(r100);
    }

    private void setMediaPlayerClient(MediaPlayerClient r100) {
        this.mMediaPlayerClientRef = new WeakReference(r100);
    }

    private void setTTPlayer(TTPlayer r100) {
        this.mTTPlayerRef = new WeakReference(r100);
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void bindExternal(TTAVWindowClient.ExternalInterface r100) {
        this.mLock.lock();
        TTAVWindowClient.ExternalInterface r101 = getExternal();     // Catch: Throwable -> L16
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client bind external " + TTPlayerViewHelper.objectToString(this) + ",  curr: " + TTPlayerViewHelper.objectToString(r101) + ", target: " + TTPlayerViewHelper.objectToString(r100));     // Catch: Throwable -> L16
        if (r100 != r101) goto L7;
    L5:
        this.mLock.unlock();
        return;
    L7:
        windowDestroyInternal();     // Catch: Throwable -> L16
        this.mClientType = ClientType.EXTERNAL;     // Catch: Throwable -> L16
        clearAllWeakReference();     // Catch: Throwable -> L16
        windowChangeBindInternal();     // Catch: Throwable -> L16
        if (r100 == null) goto L5;
        setExternal(r100);     // Catch: Throwable -> L16
        Surface r102 = this.mRenderView.getSurface();     // Catch: Throwable -> L16
        if (r102 == null) goto L5;
        r100.onNewWindowAvailable(r102);     // Catch: Throwable -> L16
        r100.onWindowChanged(this.mRenderView.getView().getWidth(), this.mRenderView.getView().getHeight());     // Catch: Throwable -> L16
        this.mLock.unlock();
        return;
    L16:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void bindMediaClient(MediaPlayerClient r100) {
        this.mLock.lock();
        MediaPlayerClient r101 = getMediaPlayerClient();     // Catch: Throwable -> L16
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client bind media client " + TTPlayerViewHelper.objectToString(this) + ",  curr: " + TTPlayerViewHelper.objectToString(r100) + ", target: " + TTPlayerViewHelper.objectToString(r101));     // Catch: Throwable -> L16
        if (r101 != r100) goto L7;
    L5:
        this.mLock.unlock();
        return;
    L7:
        windowDestroyInternal();     // Catch: Throwable -> L16
        this.mClientType = ClientType.OTHER;     // Catch: Throwable -> L16
        clearAllWeakReference();     // Catch: Throwable -> L16
        windowChangeBindInternal();     // Catch: Throwable -> L16
        if (r100 == null) goto L5;
        setMediaPlayerClient(r100);     // Catch: Throwable -> L16
        Surface r102 = this.mRenderView.getSurface();     // Catch: Throwable -> L16
        if (r102 == null) goto L5;
        r100.setSurface(r102);     // Catch: Throwable -> L16
        this.mLock.unlock();
        return;
    L16:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public void bindPlayer(TTPlayer r100) {
        this.mLock.lock();
        TTPlayer r101 = getTTPlayer();     // Catch: Throwable -> L27
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client bind player  " + TTPlayerViewHelper.objectToString(this) + ", curr: " + TTPlayerViewHelper.objectToString(r101) + ", target: " + TTPlayerViewHelper.objectToString(r100));     // Catch: Throwable -> L27
        if (r100 != r101) goto L7;
    L5:
        this.mLock.unlock();
        return;
    L7:
        ClientType r102 = ClientType.TT_PLAYER;     // Catch: Throwable -> L27
        if (r102 == this.mClientType) goto L10;
        windowDestroyInternal();     // Catch: Throwable -> L27
    L10:
        this.mClientType = r102;     // Catch: Throwable -> L27
        clearAllWeakReference();     // Catch: Throwable -> L27
        windowChangeBindInternal();     // Catch: Throwable -> L27
        if (r100 == null) goto L5;
        setTTPlayer(r100);     // Catch: Throwable -> L27
        if (0 != this.mNativeWindowHandle) goto L24;
        ITTRenderView r103 = this.mRenderView;     // Catch: Throwable -> L27
        if (r103 == null) goto L5;
        Surface r104 = r103.getSurface();     // Catch: Throwable -> L27
        if (r104 == null) goto L5;
        if (reCreateNativeWindow(r104) == false) goto L5;
    L24:
        nativeWindowBindPlayer(this.mNativeWindowHandle, r100.getNativePlayer());     // Catch: Throwable -> L27
        nativeSetWindowUsage(this.mNativeWindowHandle, this.mWindowUsage);     // Catch: Throwable -> L27
        nativeOnWindowChanged(this.mNativeWindowHandle, this.mRenderView.getView().getWidth(), this.mRenderView.getView().getHeight(), 1);     // Catch: Throwable -> L27
        this.mLock.unlock();
        return;
    L27:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public void onNewWindowAvailable(Surface r100) {
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client available  " + TTPlayerViewHelper.objectToString(this) + ", type: " + this.mClientType + ", surface: " + TTPlayerViewHelper.objectToString(r100));
        this.mLock.lock();
        newWindowAvailableInternal(r100);     // Catch: Throwable -> L6
        this.mLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void setWindowUsage(int r100) {
        this.mLock.lock();
        this.mWindowUsage = r100;     // Catch: Throwable -> L8
        long r101 = this.mNativeWindowHandle;     // Catch: Throwable -> L8
        if (r101 == 0) goto L6;
        nativeSetWindowUsage(r101, r100);     // Catch: Throwable -> L8
    L6:
        this.mLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void unbindExternal(TTAVWindowClient.ExternalInterface r100) {
        this.mLock.lock();
        TTAVWindowClient.ExternalInterface r101 = getExternal();     // Catch: Throwable -> L14
        if (r101 == null) goto L12;
        if (r101 != r100) goto L12;
        r101.onWindowDestroyed();     // Catch: Throwable -> L14
        WeakReference<TTAVWindowClient.ExternalInterface> r102 = this.mExternalRef;     // Catch: Throwable -> L14
        if (r102 == null) goto L10;
        r102.clear();     // Catch: Throwable -> L14
        this.mExternalRef = null;     // Catch: Throwable -> L14
    L10:
        this.mLock.unlock();
        return;
    L12:
        this.mLock.unlock();
        return;
    L14:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void unbindMediaClient(MediaPlayerClient r100) {
        this.mLock.lock();
        MediaPlayerClient r101 = getMediaPlayerClient();     // Catch: Throwable -> L14
        if (r101 == null) goto L12;
        if (r101 != r100) goto L12;
        r101.setSurfaceTimeOut(null, 0);     // Catch: Throwable -> L14
        WeakReference<MediaPlayerClient> r102 = this.mMediaPlayerClientRef;     // Catch: Throwable -> L14
        if (r102 == null) goto L10;
        r102.clear();     // Catch: Throwable -> L14
        this.mMediaPlayerClientRef = null;     // Catch: Throwable -> L14
    L10:
        this.mLock.unlock();
        return;
    L12:
        this.mLock.unlock();
        return;
    L14:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public TTWindowClient(ITTRenderView r100, WindowClientOnInfoCallback r101) {
        this.mCWindowShellHandle = 0;
        this.mNativeWindowHandle = 0;
        this.mOnInfoCallback = null;
        this.mClientType = ClientType.UN_KNOWN;
        this.mTTPlayerRef = null;
        this.mMediaPlayerClientRef = null;
        this.mExternalRef = null;
        this.mRenderView = null;
        this.mWindowUsage = 0;
        this.mLock = new ReentrantLock();
        this.mRenderView = r100;
        this.mOnInfoCallback = r101;
    }

    private static /* synthetic */ void lambda$windowChangeBindInternal$2(WindowClientOnInfoCallback r100, boolean r101) {
        r100.onInfo(7, 0);
        r100.onInfo(6, r101 ? 1 : 0);
    }

    private long setWindowShellHandle(long r100, boolean r101) {
        this.mLock.lock();
        if (r101 == true) goto L24;
    L9:
        this.mCWindowShellHandle = r100;     // Catch: Throwable -> L21
        if (0 == r100) goto L7;
        this.mClientType = ClientType.C_WINDOW_SHELL;     // Catch: Throwable -> L21
        if (this.mRenderView == null) goto L7;
        windowChangeBindInternal();     // Catch: Throwable -> L21
        if (0 != this.mNativeWindowHandle) goto L18;
        this.mNativeWindowHandle = nativeCreateWindow(this.mRenderView.getSurface(), this);     // Catch: Throwable -> L21
    L18:
        nativeWindowHandleIncRef(this.mNativeWindowHandle);     // Catch: Throwable -> L21
        long r102 = this.mNativeWindowHandle;     // Catch: Throwable -> L21
        this.mLock.unlock();
        return r102;
    L21:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L7:
        this.mLock.unlock();
        return 0;
    L24:
        if (r100 == this.mCWindowShellHandle) goto L9;
        goto L7
    }

    public void onInfo(final int r100, final int r101) {
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client onInfo " + TTPlayerViewHelper.objectToString(this) + ", what: " + r100 + ", parameter: " + r101);
        Handler r102 = new Handler(Looper.getMainLooper());
        final WindowClientOnInfoCallback r103 = this.mOnInfoCallback;
        if (r103 == null) goto L6;
        r102.postAtFrontOfQueue(new g(r103, r100, r101));
        return;
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void snapshotBitmap(boolean r100, final TTAVWindowClient.SnapshotListener r101) {
        this.mLock.lock();
        if (r101 != null) goto L25;
    L4:
        this.mLock.unlock();
        return;
    L25:
        ITTRenderView r102 = this.mRenderView;     // Catch: Throwable -> L22
        if (r102 == null) goto L4;
        if (Build.VERSION.SDK_INT < 24) goto L12;
    L19:
        Objects.requireNonNull(r101);     // Catch: Throwable -> L22
        r102.snapshotBitmap(r100, new i(r101));     // Catch: Throwable -> L22
    L20:
        this.mLock.unlock();
        return;
    L12:
        if ((r102 instanceof TTTextureView) == true) goto L19;
        TTAVWindowClient.ExternalInterface r103 = getExternal();     // Catch: Throwable -> L22
        if (ClientType.EXTERNAL != this.mClientType) goto L18;
        if (r103 == null) goto L18;
        r103.snapshotBitmap(r101);     // Catch: Throwable -> L22
    L18:
        r101.onResult(-1, null);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void updateVideoSize(final int r100, final int r101) {
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client updateVideoSize " + TTPlayerViewHelper.objectToString(this) + ",  width: " + r100 + ", height: " + r101);
        if (this.mOnInfoCallback != null) goto L6;
        return;
    L6:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L10;
        Handler r102 = new Handler(Looper.getMainLooper());
        final WindowClientOnInfoCallback r103 = this.mOnInfoCallback;
        if (r103 == null) goto L12;
        r102.postAtFrontOfQueue(new h(r103, r100, r101));
        return;
    L12:
        return;
    L10:
        this.mOnInfoCallback.onInfo(5, (r100 << 16) + r101);
    }

    private static /* synthetic */ void lambda$onInfo$1(WindowClientOnInfoCallback r100, int r101, int r102) {
        r100.onInfo(r101, r102);
    }

    private static /* synthetic */ void lambda$updateVideoSize$0(WindowClientOnInfoCallback r100, int r101, int r102) {
        r100.onInfo(5, (r101 << 16) + r102);
    }

    private void windowChangedInternal(int r100, int r110, boolean r111) {
        int r101 = AnonymousClass1.$SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[this.mClientType.ordinal()];
        if (r101 != 3) goto L5;
        return;
    L5:
        if (r101 == 4) goto L10;
        long r102 = this.mNativeWindowHandle;
        if (0 != r102) goto L9;
        return;
    L9:
        nativeOnWindowChanged(r102, r100, r110, r111 ? 1 : 0);
        return;
    L10:
        TTAVWindowClient.ExternalInterface r112 = getExternal();
        if (r112 == null) goto L16;
        r112.onWindowChanged(r100, r110);
        return;
    }

    public void onWindowChanged(int r100, int r101, boolean r102) {
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client changed " + TTPlayerViewHelper.objectToString(this) + ", type: " + this.mClientType + ", w: " + r100 + ", h: " + r101 + ", crop: " + r102);
        this.mLock.lock();
        windowChangedInternal(r100, r101, r102);     // Catch: Throwable -> L6
        this.mLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }
}
