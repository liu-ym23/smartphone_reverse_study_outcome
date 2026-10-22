package com.lynx.clay.embedding.engine.plugins.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class ClayTextEmojiAdapterBridge {
    private static final String TAG = "ClayTextEmojiAdapter";
    private static final WeakHashMap<Context, WeakReference<Object>> sAdapters = null;
    private static final Map<Long, WeakReference<Context>> sContexts = null;
    private static EmojiAdapterProvider sEmojiAdapterProvider;
    private static EmojiAdapterProviderLoader sEmojiAdapterProviderLoader;
    private static boolean sNativeClassRegistered;

    public interface EmojiAdapterProvider {
        Object createAdapter(Context r100);

        Drawable getRealDrawable(Object r100, Context r101, String r102);

        boolean isValidEmojiText(Object r100, String r101);
    }

    public interface EmojiAdapterProviderLoader {
        EmojiAdapterProvider createProvider();
    }

    public static final class ResolvedEmoji {
        public final int height;
        public final float layoutHeight;
        public final float layoutWidth;
        public final byte[] pixels;
        public final int rowBytes;
        public final int width;

        public ResolvedEmoji(int r100, int r101, int r102, float r103, float r104, byte[] r105) {
            this.width = r100;
            this.height = r101;
            this.rowBytes = r102;
            this.layoutWidth = r103;
            this.layoutHeight = r104;
            this.pixels = r105;
        }
    }

    private ClayTextEmojiAdapterBridge() {
    }

    private static native void nativeRegisterBridgeClass(Class<?> r100);

    static {
        sContexts = new HashMap();
        sAdapters = new WeakHashMap();
        sNativeClassRegistered = false;
        sEmojiAdapterProvider = null;
        sEmojiAdapterProviderLoader = null;
    }

    public static synchronized void ensureNativeRegistered() {
        monitor-enter(ClayTextEmojiAdapterBridge.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sNativeClassRegistered == false) goto L16;
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return;
    L16:
        nativeRegisterBridgeClass(ClayTextEmojiAdapterBridge.class);     // Catch: Throwable -> L10
        sNativeClassRegistered = true;     // Catch: Throwable -> L10
    L11:
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return;
    L10:
        goto L11
    }

    private static synchronized EmojiAdapterProvider getEmojiAdapterProvider() {
        monitor-enter(ClayTextEmojiAdapterBridge.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (sEmojiAdapterProvider != null) goto L11;
        EmojiAdapterProviderLoader r100 = sEmojiAdapterProviderLoader;     // Catch: Throwable -> L14
        if (r100 == null) goto L11;
        sEmojiAdapterProvider = r100.createProvider();     // Catch: Throwable -> L10
    L10:
        sEmojiAdapterProviderLoader = null;     // Catch: Throwable -> L14
    L11:
        EmojiAdapterProvider r101 = sEmojiAdapterProvider;     // Catch: Throwable -> L14
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return r101;
    }

    private static synchronized Context getContext(long r100) {
        monitor-enter(ClayTextEmojiAdapterBridge.class);
        Map<Long, WeakReference<Context>> r101 = sContexts;     // Catch: Throwable -> L12
        WeakReference<Context> r102 = r101.get(Long.valueOf(r100));     // Catch: Throwable -> L12
        if (r102 == null) goto L7;
        Context r103 = r102.get();     // Catch: Throwable -> L12
    L8:
        if (r103 != null) goto L10;
        r101.remove(Long.valueOf(r100));     // Catch: Throwable -> L12
    L10:
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return r103;
    L7:
        r103 = null;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized void unregister(long r100) {
        monitor-enter(ClayTextEmojiAdapterBridge.class);
        WeakReference<Context> r101 = sContexts.remove(Long.valueOf(r100));     // Catch: Throwable -> L12
        if (r101 == null) goto L7;
        Context r102 = r101.get();     // Catch: Throwable -> L12
    L8:
        if (r102 == null) goto L10;
        sAdapters.remove(r102);     // Catch: Throwable -> L12
    L10:
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return;
    L7:
        r102 = null;
    L12:
        th = move-exception;
        throw th;
    }

    private static synchronized Object getAdapter(Context r100, EmojiAdapterProvider r101) {
        monitor-enter(ClayTextEmojiAdapterBridge.class);
        WeakHashMap<Context, WeakReference<Object>> r102 = sAdapters;     // Catch: Throwable -> L20
        WeakReference<Object> r103 = r102.get(r100);     // Catch: Throwable -> L20
        if (r103 == null) goto L8;
        Object r104 = r103.get();     // Catch: Throwable -> L20
    L9:
        if (r104 == null) goto L24;
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return r104;
    L24:
        Object r105 = r101.createAdapter(r100);     // Catch: Throwable -> L17
        if (r105 == null) goto L15;
        r102.put(r100, new WeakReference(r105));     // Catch: Throwable -> L20
    L15:
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return r105;
    L17:
        sAdapters.remove(r100);     // Catch: Throwable -> L20
        return null;
    L8:
        r104 = null;
    L20:
        th = move-exception;
        throw th;
    }

    private static int premultiply(int r100, int r101) {
        return ((r100 * r101) + 127) / 255;
    }

    private static ResolvedEmoji rasterize(Drawable r110, float r210) {
        int r100 = r110.getIntrinsicWidth();
        int r101 = r110.getIntrinsicHeight();
        if (r210 <= 0.0f) goto L5;
        float r102 = r210;
    L6:
        if (r100 <= 0) goto L9;
        if (r101 <= 0) goto L9;
        float r103 = (r100 * r102) / r101;
    L10:
        int r104 = Math.max(1, Math.round(r103));
        int r105 = Math.max(1, Math.round(r102));
        Rect r106 = r110.copyBounds();
        Bitmap r107 = Bitmap.createBitmap(r104, r105, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L19
        Canvas r108 = new Canvas(r107);     // Catch: Throwable -> L18
        int r109 = 0;
        r110.setBounds(0, 0, r104, r105);     // Catch: Throwable -> L18
        r110.draw(r108);     // Catch: Throwable -> L18
        int r111 = r104 * r105;     // Catch: Throwable -> L18
        int[] r112 = new int[r111];     // Catch: Throwable -> L18
        r107.getPixels(r112, 0, r104, 0, 0, r104, r105);     // Catch: Throwable -> L18
        byte[] r113 = new byte[r111 * 4];     // Catch: Throwable -> L18
    L13:
        if (r109 >= r111) goto L15;
        int r114 = r112[r109];     // Catch: Throwable -> L18
        int r115 = (r114 >>> 24) & 255;     // Catch: Throwable -> L18
        int r116 = r109 * 4;     // Catch: Throwable -> L18
        r113[r116] = (byte) premultiply((r114 >>> 16) & 255, r115);     // Catch: Throwable -> L18
        r113[r116 + 1] = (byte) premultiply((r114 >>> 8) & 255, r115);     // Catch: Throwable -> L18
        r113[r116 + 2] = (byte) premultiply(r114 & 255, r115);     // Catch: Throwable -> L18
        r113[r116 + 3] = (byte) r115;     // Catch: Throwable -> L18
        r109 = r109 + 1;     // Catch: Throwable -> L18
        goto L13
    L15:
        ResolvedEmoji r117 = new ResolvedEmoji(r104, r105, r104 * 4, r103, r102, r113);     // Catch: Throwable -> L18
        r110.setBounds(r106);
        r107.recycle();
        return r117;
    L20:
        r110.setBounds(r106);
        if (r107 == null) goto L23;
        r107.recycle();
    L23:
        return null;
    L19:
        r107 = null;
    L9:
        r103 = r102;
        goto L10
    L5:
        r102 = 14.0f;
        goto L6
    }

    public static synchronized void register(long r100, Context r101, EmojiAdapterProviderLoader r102) {
        monitor-enter(ClayTextEmojiAdapterBridge.class);
        if (r100 == 0) goto L17;
        if (r101 == null) goto L17;
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sEmojiAdapterProviderLoader == r102) goto L11;
        sEmojiAdapterProviderLoader = r102;     // Catch: Throwable -> L14
        sEmojiAdapterProvider = null;     // Catch: Throwable -> L14
        sAdapters.clear();     // Catch: Throwable -> L14
    L11:
        sContexts.put(Long.valueOf(r100), new WeakReference(r101));     // Catch: Throwable -> L14
        sAdapters.remove(r101);     // Catch: Throwable -> L14
        monitor-exit(ClayTextEmojiAdapterBridge.class);
        return;
    L17:
        monitor-exit(ClayTextEmojiAdapterBridge.class);
    }

    public static ResolvedEmoji resolve(long r100, String r101, float r102) {
        Context r103 = getContext(r100);
        if (r103 == null) goto L40;
        if (r101 == null) goto L40;
        if (r101.length() == 0) goto L40;
        EmojiAdapterProvider r104 = getEmojiAdapterProvider();
        if (r104 != null) goto L11;
        return null;
    L11:
        Object r105 = getAdapter(r103, r104);
        if (r105 != null) goto L41;
        return null;
    L41:
        if (r104.isValidEmojiText(r105, r101) == true) goto L43;
        return null;
    L43:
        Drawable r106 = r104.getRealDrawable(r105, r103, r101);     // Catch: Throwable -> L22
        if (r106 != null) goto L21;
        return null;
    L21:
        return rasterize(r106, r102);
    L23:
        monitor-enter(ClayTextEmojiAdapterBridge.class);
        sAdapters.remove(r103);     // Catch: Throwable -> L28
        return null;
    L28:
        th = move-exception;
        throw th;
    L32:
        monitor-enter(ClayTextEmojiAdapterBridge.class);
        sAdapters.remove(r103);     // Catch: Throwable -> L37
        return null;
    L37:
        th = move-exception;
        throw th;
    L40:
        return null;
    }
}
