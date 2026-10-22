package com.ss.android.lark.widget.photo.preview.image;

import android.content.Context;
import android.util.Base64;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.bdp.appbase.network.client.BdpOkClient;
import com.bytedance.lark.pb.media.v1.DownloadFileScene;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.lark.imageocr.ImageOCRKit;
import com.ss.android.lark.imageocr_export.OCRParams;
import com.ss.android.lark.imageocr_export.OCRScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.pan.ImageOCRResponse;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public final class ImageOCRController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageOCRController f446602a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Deferred<ImageOCRResponse>> f446603b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutexImpl f446604c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f446605d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f446606e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile VFSFile f446607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CoroutineScope f446608g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MutexImpl f446609h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static VFSFile f446610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f446611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f446612k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f446613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f446614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f446615c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f446613a, r101.f446613a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f446614b, r101.f446614b) == true) goto L15;
            return false;
        L15:
            if (this.f446615c == r101.f446615c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f446613a.hashCode() * 31) + this.f446614b.hashCode()) * 31;
            long r101 = this.f446615c;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "BatchCacheEntry(key=" + this.f446613a + ", data=" + this.f446614b + ", timestamp=" + this.f446615c + ')';
        }

        public a(String r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f446613a = r100;
            this.f446614b = r101;
            this.f446615c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, a> f446616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f446617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f446618c;

        public b() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f446616a, r101.f446616a) == true) goto L12;
            return false;
        L12:
            if (this.f446617b == r101.f446617b) goto L15;
            return false;
        L15:
            if (this.f446618c == r101.f446618c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f446616a.hashCode() * 31;
            long r101 = this.f446617b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f446618c;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "BatchCacheFile(entries=" + this.f446616a + ", totalSize=" + this.f446617b + ", createdTime=" + this.f446618c + ')';
        }

        public b(Object r100) {
            LinkedHashMap r101 = new LinkedHashMap();
            long r102 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r101, "entries");
            this.f446616a = r101;
            this.f446617b = 0;
            this.f446618c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f446619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f446620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f446621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f446622d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f446623e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f446624f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f446625g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f446626h;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f446619a == r101.f446619a) goto L12;
            return false;
        L12:
            if (this.f446620b == r101.f446620b) goto L15;
            return false;
        L15:
            if (this.f446621c == r101.f446621c) goto L18;
            return false;
        L18:
            if (this.f446622d == r101.f446622d) goto L21;
            return false;
        L21:
            if (this.f446623e == r101.f446623e) goto L24;
            return false;
        L24:
            if (this.f446624f == r101.f446624f) goto L27;
            return false;
        L27:
            if (this.f446625g == r101.f446625g) goto L30;
            return false;
        L30:
            if (this.f446626h == r101.f446626h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            return (((((((((((((this.f446619a * 31) + this.f446620b) * 31) + this.f446621c) * 31) + this.f446622d) * 31) + this.f446623e) * 31) + this.f446624f) * 31) + this.f446625g) * 31) + this.f446626h;
        }

        public final String toString() {
            return "CacheStats(saveCount=" + this.f446619a + ", loadCount=" + this.f446620b + ", hitCount=" + this.f446621c + ", missCount=" + this.f446622d + ", cleanupCount=" + this.f446623e + ", errorCount=" + this.f446624f + ", batchSaveCount=" + this.f446625g + ", batchHitCount=" + this.f446626h + ')';
        }

        public c(int r100) {
            this.f446619a = 0;
            this.f446620b = 0;
            this.f446621c = 0;
            this.f446622d = 0;
            this.f446623e = 0;
            this.f446624f = 0;
            this.f446625g = 0;
            this.f446626h = 0;
        }
    }

    public ImageOCRController() {
    }

    static {
        f446602a = new ImageOCRController();
        f446603b = new ConcurrentHashMap();
        f446604c = kotlinx.coroutines.sync.b.a();
        f446605d = new AtomicBoolean(false);
        f446606e = new c(0);
        f446608g = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f446609h = kotlinx.coroutines.sync.b.a();
    }

    public static void g() {
        VFSFile r100 = f446607f;
        if (r100 != null) goto L12;
        Log.e("ImageOCRController", "Cannot create new batch file: cache directory is null");
        return;
    L12:
        String r101 = "batch_" + System.currentTimeMillis() + ".ocr";     // Catch: Exception -> L9
        Log.d("ImageOCRController", "Creating new batch cache file: " + r101);     // Catch: Exception -> L9
        VFSFile r102 = VFSFiles.f444819b.D(r100, r101);     // Catch: Exception -> L9
        f446610i = r102;     // Catch: Exception -> L9
        f446611j = 0;     // Catch: Exception -> L9
        f446612k = 0;     // Catch: Exception -> L9
        Log.i("ImageOCRController", "Successfully created new batch cache file: " + r102.getName());     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Log.e("ImageOCRController", "Failed to create new batch cache file", e);
        f446610i = null;
        f446611j = 0;
        f446612k = 0;
    }

    public static final void a(ImageOCRController r110) {
        r110.getClass();
        VFSFile r111 = f446607f;
        if (r111 == null) goto L32;
        List r112 = ArraysKt.sortedWith(r111.listFiles(), new com.ss.android.lark.widget.photo.preview.image.a());
        Iterator r100 = r112.iterator();
        long r101 = 0;
        long r102 = 0;
    L6:
        if (r100.hasNext() == false) goto L8;
        r102 = r102 + ((VFSFile) r100.next()).length();
        goto L6
    L8:
        StringBuilder r103 = new StringBuilder("Starting size cleanup, current total size: ");
        long r104 = 1048576;
        r103.append(r102 / r104);
        r103.append("MB, max allowed: 10MB");
        Log.d("ImageOCRController", r103.toString());
        if (r102 > BdpOkClient.CACHE_MAX_SIZE) goto L11;
        Log.d("ImageOCRController", "Cache size is within limits, no cleanup needed");
        return;
    L11:
        Iterator r113 = r112.iterator();
        int r105 = 0;
    L13:
        if (r113.hasNext() == false) goto L21;
        VFSFile r106 = (VFSFile) r113.next();
        if (r102 <= 9437184) goto L16;
        long r107 = r106.length();
        if (r106.delete() == true) goto L19;
        Log.w("ImageOCRController", "Failed to delete file: " + r106.getName());
        goto L13
    L19:
        r102 = r102 - r107;
        r101 = r101 + r107;
        r105 = r105 + 1;
        Log.i("ImageOCRController", "Deleted file to free space: " + r106.getName() + ", size: " + (r107 / ((long) 1024)) + "KB");
        goto L13
    L16:
        Log.d("ImageOCRController", "Reached target size threshold, stopping cleanup");
    L21:
        if (r105 <= 0) goto L34;
        Log.i("ImageOCRController", "Size cleanup completed: deleted " + r105 + " files, freed " + (r101 / r104) + "MB, new size: " + (r102 / r104) + "MB");
        return;
    L34:
        return;
    }

    public static final void b(ImageOCRController r100) {
        r100.getClass();
        VFSFile r101 = f446607f;
        if (r101 == null) goto L25;
        VFSFile[] r102 = r101.listFiles();
        Log.d("ImageOCRController", "Starting expired cache cleanup, total files: " + r102.length);
        Iterator r103 = ArraysKt.take(r102, 100).iterator();
        int r104 = 0;
        long r105 = 0;
    L6:
        if (r103.hasNext() == false) goto L13;
        VFSFile r106 = (VFSFile) r103.next();
        f446602a.getClass();
        if (l(r106) == false) goto L6;
        long r107 = r106.length();
        if (r106.delete() == true) goto L11;
        Log.w("ImageOCRController", "Failed to delete expired file: " + r106.getName());
        goto L6
    L11:
        r104 = r104 + 1;
        r105 = r105 + r107;
        Log.i("ImageOCRController", "Deleted expired file: " + r106.getName());
        goto L6
    L13:
        if (r104 <= 0) goto L15;
        Log.i("ImageOCRController", "Expired cache cleanup completed: deleted " + r104 + " files, freed " + (r105 / ((long) 1024)) + "KB");
        return;
    L15:
        Log.d("ImageOCRController", "No expired files found, cleanup completed");
        return;
    }

    public static b h(byte[] r110) {
        DataInputStream r111 = new DataInputStream(new ByteArrayInputStream(r110));     // Catch: Exception -> L8
        b r100 = new b(null);     // Catch: Exception -> L8
        r100.f446618c = r111.readLong();     // Catch: Exception -> L8
        r100.f446617b = r111.readLong();     // Catch: Exception -> L8
        int r101 = r111.readInt();     // Catch: Exception -> L8
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L6;
        byte[] r103 = new byte[r111.readInt()];     // Catch: Exception -> L8
        r111.readFully(r103);     // Catch: Exception -> L8
        Charset r104 = Charsets.UTF_8;     // Catch: Exception -> L8
        String r105 = new String(r103, r104);     // Catch: Exception -> L8
        byte[] r106 = new byte[r111.readInt()];     // Catch: Exception -> L8
        r111.readFully(r106);     // Catch: Exception -> L8
        r100.f446616a.put(r105, new a(r105, new String(r106, r104), r111.readLong()));     // Catch: Exception -> L8
        r102 = r102 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        r111.close();     // Catch: Exception -> L8
        Log.i("ImageOCRController", "Deserialized batch cache, entries: " + r100.f446616a.size());     // Catch: Exception -> L8
        return r100;
    L8:
        e = move-exception;
        Log.e("ImageOCRController", "Failed to deserialize batch cache", e);
        return new b(null);
    }

    public static ImageOCRResponse i(String r100) {
        byte[] r101 = Base64.decode(r100, 2);     // Catch: Exception -> L5
        ByteString.a r102 = ByteString.Companion;     // Catch: Exception -> L5
        byte[] r103 = Arrays.copyOf(r101, r101.length);     // Catch: Exception -> L5
        r102.getClass();     // Catch: Exception -> L5
        return ImageOCRResponse.ADAPTER.decode(ByteString.a.c(r103));
    L5:
        e = move-exception;
        Log.e("ImageOCRController", "Failed to deserialize OCR response, data length: " + r100.length(), e);
        return null;
    }

    public static VFSFile k(String r100) {
        VFSFile r101 = f446607f;
        if (r101 == null) goto L5;
        String r102 = String.valueOf(r100.hashCode());
        return VFSFiles.f444819b.D(r101, r102 + ".ocr");
    L5:
        return null;
    }

    public static boolean l(VFSFile r100) {
        long r101 = r100.lastModified();
        if (r101 >= (System.currentTimeMillis() - 604800000)) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        Log.i("ImageOCRController", "Cache file expired: " + r100.getName() + ", lastModified: " + r101);
    L8:
        return r102;
    L5:
        r102 = false;
        goto L6
    }

    public static byte[] q(b r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L9
        DataOutputStream r102 = new DataOutputStream(r101);     // Catch: Exception -> L9
        r102.writeLong(r100.f446618c);     // Catch: Exception -> L9
        r102.writeLong(r100.f446617b);     // Catch: Exception -> L9
        r102.writeInt(r100.f446616a.size());     // Catch: Exception -> L9
        Iterator<Map.Entry<String, a>> r103 = r100.f446616a.entrySet().iterator();     // Catch: Exception -> L9
    L5:
        if (r103.hasNext() == false) goto L7;
        Map.Entry<String, a> r104 = r103.next();     // Catch: Exception -> L9
        String r105 = r104.getKey();     // Catch: Exception -> L9
        a r106 = r104.getValue();     // Catch: Exception -> L9
        Charset r107 = Charsets.UTF_8;     // Catch: Exception -> L9
        byte[] r108 = r105.getBytes(r107);     // Catch: Exception -> L9
        r102.writeInt(r108.length);     // Catch: Exception -> L9
        r102.write(r108);     // Catch: Exception -> L9
        byte[] r109 = r106.f446614b.getBytes(r107);     // Catch: Exception -> L9
        r102.writeInt(r109.length);     // Catch: Exception -> L9
        r102.write(r109);     // Catch: Exception -> L9
        r102.writeLong(r106.f446615c);     // Catch: Exception -> L9
        goto L5
    L7:
        r102.close();     // Catch: Exception -> L9
        byte[] r110 = r101.toByteArray();     // Catch: Exception -> L9
        Log.i("ImageOCRController", "Serialized batch cache, entries: " + r100.f446616a.size() + ", size: " + r110.length + " bytes");     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r110);     // Catch: Exception -> L9
        return r110;
    L9:
        e = move-exception;
        Log.e("ImageOCRController", "Failed to serialize batch cache", e);
        return new byte[0];
    }

    public static String r(ImageOCRResponse r100) {
        byte[] r101 = ImageOCRResponse.ADAPTER.encode(r100);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L5
        String r102 = Base64.encodeToString(r101, 2);     // Catch: Exception -> L5
        Log.i("ImageOCRController", "Serialized OCR response, size: " + r102.length() + " chars");     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        Log.e("ImageOCRController", "Failed to serialize OCR response", e);
        return "";
    }

    public static void f(OCRParams r100, ImageOCRResponse r101) {
        List<ImageOCRResponse.Region> r102 = r101.mregions;
        int r103 = 0;
        if (r102 == null) goto L15;
        List r104 = CollectionsKt.filterNotNull(r102);
        if (r104 == null) goto L15;
        Iterator r105 = r104.iterator();
        int r106 = 0;
    L8:
        if (r105.hasNext() == false) goto L14;
        String r107 = ((ImageOCRResponse.Region) r105.next()).mtext;
        if (r107 == null) goto L12;
        int r108 = r107.length();
    L13:
        r106 = r106 + r108;
        goto L8
    L12:
        r108 = 0;
        goto L13
    L14:
        r103 = r106;
    L15:
        Log.i("ImageOCRController", "OCR text audit - total length: " + r103 + ", remoteKey: " + r100.getRemoteImageKey());
        if (r103 <= 0) goto L18;
        llb.a r109 = ImageOCRKit.a();
        r100.getRemoteImageKey();
        String.valueOf(r103);
        r109.d();
        Log.d("ImageOCRController", "OCR audit completed");
        return;
    L18:
        Log.d("ImageOCRController", "No OCR text found for audit");
    }

    public static void p(String r100, String r101) {
        VFSFile r102 = f446607f;
        if (r102 != null) goto L5;
        return;
    L5:
        String r103 = String.valueOf(r100.hashCode());
        VFSFile r104 = VFSFiles.f444819b.D(r102, r103 + ".ocr");
        Log.d("ImageOCRController", "Saving single OCR cache to: " + r104.getAbsolutePath() + ", key: " + r100);
        FilesKt.writeText$default(r104, r101, null, 2, null);
        if (r104.exists() == true) goto L8;
    L12:
        Log.e("ImageOCRController", "Failed to verify saved single cache file: " + r104.getAbsolutePath());
        return;
    L8:
        if (r104.length() == 0) goto L12;
        Log.i("ImageOCRController", "Successfully saved single OCR cache: " + r104.getAbsolutePath() + ", size: " + r104.length() + 'B');
    }

    public final Object m(String r110, Continuation<? super ImageOCRResponse> r111) {
        if ((r111 instanceof ImageOCRController$loadFromBatchCache$1) == false) goto L7;
        ImageOCRController$loadFromBatchCache$1 r100 = (ImageOCRController$loadFromBatchCache$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) r100.L$1;
        String r104 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
        kotlinx.coroutines.sync.a r114 = r113;
        r110 = r104;
    L55:
        VFSFile r105 = f446607f;     // Catch: Throwable -> L43 Exception -> L45
        if (r105 == null) goto L50;
        VFSFile[] r106 = r105.listFiles();     // Catch: Throwable -> L43 Exception -> L45
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L43 Exception -> L45
        int r108 = r106.length;     // Catch: Throwable -> L43 Exception -> L45
        int r109 = 0;
    L21:
        if (r109 >= r108) goto L32;
        VFSFile r115 = r106[r109];     // Catch: Throwable -> L43 Exception -> L45
        if (StringsKt.startsWith$default(r115.getName(), "batch_", false, 2, null) == true) goto L25;
    L27:
        boolean r116 = false;
    L28:
        if (r116 == false) goto L30;
        r107.add(r115);     // Catch: Throwable -> L43 Exception -> L45
    L30:
        r109 = r109 + 1;     // Catch: Throwable -> L43 Exception -> L45
        goto L21
    L25:
        if (StringsKt.endsWith$default(r115.getName(), ".ocr", false, 2, null) == false) goto L27;
        r116 = true;
        goto L28
    L32:
        if (r107.isEmpty() == true) goto L50;
        Log.d("ImageOCRController", "Found " + r107.size() + " batch files, scanning for key: " + r110);     // Catch: Throwable -> L43 Exception -> L45
        Iterator r117 = CollectionsKt.take(r107, 20).iterator();     // Catch: Throwable -> L43 Exception -> L45
    L36:
        if (r117.hasNext() == false) goto L47;
        VFSFile r118 = (VFSFile) r117.next();     // Catch: Throwable -> L43 Exception -> L45
        f446602a.getClass();     // Catch: Throwable -> L43 Exception -> L45
        if (l(r118) == true) goto L39;
        ImageOCRResponse r119 = t(r110, r105, r118.getName());     // Catch: Throwable -> L43 Exception -> L45
        if (r119 == null) goto L36;
        Log.d("ImageOCRController", "Found OCR data in batch file: " + r118.getName());     // Catch: Throwable -> L43 Exception -> L45
    L51:
        r114.unlock(null);
        return r119;
    L39:
        Log.d("ImageOCRController", "Batch file expired, deleting: " + r118.getName());     // Catch: Throwable -> L43 Exception -> L45
        r118.delete();     // Catch: Throwable -> L43 Exception -> L45
        goto L36
    L47:
        Log.d("ImageOCRController", "OCR data not found in any batch file for key: " + r110);     // Catch: Throwable -> L43 Exception -> L45
    L50:
        r119 = null;
    L43:
        th = move-exception;
        r114.unlock(null);
        throw th;
    L45:
        e = move-exception;
        Log.e("ImageOCRController", "Failed to load from batch cache for key: " + r110, e);     // Catch: Throwable -> L43
        goto L50
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r114 = f446609h;
        r100.L$0 = r110;
        r100.L$1 = r114;
        r100.label = 1;
        if (r114.a(null, r100) != r102) goto L55;
        return r102;
    L7:
        r100 = new ImageOCRController$loadFromBatchCache$1(this, r111);
        goto L8
    }

    public static final Object c(ImageOCRController r100, OCRParams r101, Continuation r102) {
        r100.getClass();
        Log.d("ImageOCRController", "Starting OCR service call for messageId: " + r101.getMsgID());
        final kotlinx.coroutines.j r103 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r103.C();
        jlb.a.a(r101, new ImageOCRController$doOCR$2$1(r103));
        Object r104 = r103.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L5:
        return r104;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.lang.Object, kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r14v15, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r14v9, types: [kotlinx.coroutines.sync.a] */
    public static final Object d(ImageOCRController r110, String r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof ImageOCRController$loadFromDiskCache$1) == false) goto L7;
        ImageOCRController$loadFromDiskCache$1 r100 = (ImageOCRController$loadFromDiskCache$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L22;
        if (r102 == 1) goto L21;
        if (r102 != 2) goto L20;
        ?? r115 = (kotlinx.coroutines.sync.a) r100.L$1;
        String r116 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L15 Exception -> L17
        ?? r117 = r115;
    L42:
        ImageOCRResponse r118 = (ImageOCRResponse) r113;     // Catch: Throwable -> L15 Exception -> L17
        if (r118 == null) goto L46;
        f446606e.f446626h++;     // Catch: Throwable -> L15 Exception -> L17
        r117.unlock(null);
        return r118;
    L46:
        f446606e.f446622d++;     // Catch: Throwable -> L15 Exception -> L17
        Log.d("ImageOCRController", "Cache miss for key: " + r116);     // Catch: Throwable -> L15 Exception -> L17
        ?? r119 = r117;
    L52:
        r119.unlock(null);
        return null;
    L17:
        Exception e100 = e;
    L51:
        Log.e("ImageOCRController", "Failed to load OCR result from disk cache for key: " + r116, e100);     // Catch: Throwable -> L15
        c r120 = f446606e;     // Catch: Throwable -> L15
        r120.f446624f = r120.f446624f + 1;     // Catch: Throwable -> L15
        r120.f446622d++;     // Catch: Throwable -> L15
        r119 = r115;
        goto L52
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        kotlinx.coroutines.sync.a r121 = (kotlinx.coroutines.sync.a) r100.L$1;
        String r103 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
        ?? r122 = r121;
        r111 = r103;
    L58:
        ImageOCRController r104 = f446602a;     // Catch: Throwable -> L36 Exception -> L49
        r104.getClass();     // Catch: Throwable -> L36 Exception -> L49
        VFSFile r123 = k(r111);     // Catch: Throwable -> L36 Exception -> L49
        if (r123 != null) goto L28;
    L38:
        r100.L$0 = r111;     // Catch: Throwable -> L36 Exception -> L49
        r100.L$1 = r122;     // Catch: Throwable -> L36 Exception -> L49
        r100.label = 2;     // Catch: Throwable -> L36 Exception -> L49
        Object r105 = r104.m(r111, r100);     // Catch: Throwable -> L36 Exception -> L49
        if (r105 == r114) goto L62;
        r116 = r111;
        r117 = r122;
        r113 = r105;
        goto L42
    L62:
        return r114;
    L28:
        if (r123.exists() == false) goto L38;
        if (l(r123) == false) goto L32;
        Log.d("ImageOCRController", "Single cache file expired, deleting: " + r123.getAbsolutePath());     // Catch: Throwable -> L36 Exception -> L49
        r123.delete();     // Catch: Throwable -> L36 Exception -> L49
        c r106 = f446606e;     // Catch: Throwable -> L36 Exception -> L49
        int r107 = r106.f446622d;     // Catch: Throwable -> L36 Exception -> L49
        r106.f446622d = r107 + 1;     // Catch: Throwable -> L36 Exception -> L49
        Boxing.boxInt(r107);     // Catch: Throwable -> L36 Exception -> L49
        goto L38
    L32:
        ImageOCRResponse r108 = i(FilesKt.readText$default(r123, null, 1, null));     // Catch: Throwable -> L36 Exception -> L49
        if (r108 == null) goto L38;
        f446606e.f446621c++;     // Catch: Throwable -> L36 Exception -> L49
        Log.d("ImageOCRController", "Successfully loaded from single cache: " + r123.getAbsolutePath());     // Catch: Throwable -> L36 Exception -> L49
        r122.unlock(null);
        return r108;
    L49:
        e = move-exception;
        String r124 = r111;
        r115 = r122;
        e100 = e;
        r116 = r124;
    L36:
        Throwable th10 = th;
    L54:
        r122.unlock(null);
        throw th10;
    L22:
        ResultKt.throwOnFailure(r113);
        f446606e.f446620b++;
        Log.d("ImageOCRController", "Loading from disk cache for key: " + r111);
        MutexImpl r125 = f446604c;
        r100.L$0 = r111;
        r100.L$1 = r125;
        r100.label = 1;
        Object r109 = r125.a(null, r100);
        r122 = r125;
        if (r109 != r114) goto L58;
        return r114;
    L15:
        th = move-exception;
        th10 = th;
        r122 = r111;
    L7:
        r100 = new ImageOCRController$loadFromDiskCache$1(r110, r112);
        goto L8
    }

    public static ImageOCRResponse t(String r100, VFSFile r101, String r102) {
        VFSFile r103 = VFSFiles.f444819b.D(r101, r102);
        if (l(r103) == false) goto L15;
        Log.d("ImageOCRController", "Batch file expired, deleting: " + r103.getName());
        r103.delete();
        return null;
    L15:
        a r104 = h(r103.readBytes()).f446616a.get(r100);     // Catch: Exception -> L12
        if (r104 == null) goto L14;
        ImageOCRResponse r105 = i(r104.f446614b);     // Catch: Exception -> L12
        if (r105 == null) goto L14;
        f446603b.put(r100, CompletableDeferredKt.CompletableDeferred(r105));     // Catch: Exception -> L12
        Log.i("ImageOCRController", "Found OCR data in batch file: " + r103.getName() + ", key: " + r100);     // Catch: Exception -> L12
        return r105;
    L14:
        return null;
    L12:
        e = move-exception;
        Log.e("ImageOCRController", "Failed to load from batch file: " + r103.getName() + ", deleting file", e);
        r103.delete();
        goto L14
    }

    public final Object j(Context r210, boolean r211, Continuation<? super Unit> r212) {
        if ((r212 instanceof ImageOCRController$ensureDiskCache$1) == false) goto L7;
        ImageOCRController$ensureDiskCache$1 r100 = (ImageOCRController$ensureDiskCache$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 != 2) goto L18;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L15
    L44:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r106.unlock(null);
    L51:
        return Unit.INSTANCE;
    L15:
        th = th;
        kotlinx.coroutines.sync.a r110 = r106;
    L48:
        r110.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        boolean r108 = r100.Z$0;
        r110 = (kotlinx.coroutines.sync.a) r100.L$1;
        Context r111 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L52:
    L47:
        th = th;
        goto L48
    L27:
        if (f446607f != null) goto L43;
        long r112 = System.currentTimeMillis();     // Catch: Throwable -> L47
        VFSFiles r109 = VFSFiles.f444819b;     // Catch: Throwable -> L47
        int r113 = com.suite.lark.platform.component.storage.file.dirs.h.f460642c;     // Catch: Throwable -> L47
        VFSFile r114 = r109.v(com.suite.lark.platform.component.storage.file.dirs.h.a.a(r111).b(new com.suite.lark.platform.component.storage.file.dirs.e()).getRealPath(), "photo_picker/ocr_cache/image_ocr_cache");     // Catch: Throwable -> L47
        if (r114.exists() == true) goto L37;
        boolean r115 = r114.mkdirs();     // Catch: Throwable -> L47
        StringBuilder r116 = new StringBuilder("Created cache directory: ");     // Catch: Throwable -> L47
        r116.append(r114.getAbsolutePath());     // Catch: Throwable -> L47
        r116.append(", success: ");     // Catch: Throwable -> L47
        if (r115 == true) goto L36;
        r105 = false;
    L36:
        r116.append(r105);     // Catch: Throwable -> L47
        Log.i("ImageOCRController", r116.toString());     // Catch: Throwable -> L47
    L38:
        f446607f = r114;     // Catch: Throwable -> L47
        Log.d("ImageOCRController", "Cache initialization completed in " + (System.currentTimeMillis() - r112) + "ms");     // Catch: Throwable -> L47
        Deferred r117 = BuildersKt.async$default(f446608g, null, null, new ImageOCRController$ensureDiskCache$2$job$1(null), 3, null);     // Catch: Throwable -> L47
        if (r108 == false) goto L43;
        r100.L$0 = r110;     // Catch: Throwable -> L47
        r100.L$1 = null;     // Catch: Throwable -> L47
        r100.label = 2;     // Catch: Throwable -> L47
        if (r117.await(r100) != r103) goto L43;
        return r103;
    L37:
        Log.i("ImageOCRController", "Using existing cache directory: " + r114.getAbsolutePath());     // Catch: Throwable -> L47
    L43:
        r106 = r110;
        goto L44
    L20:
        ResultKt.throwOnFailure(r102);
        if (f446607f != null) goto L51;
        MutexImpl r118 = f446604c;
        r100.L$0 = r210;
        r100.L$1 = r118;
        r100.Z$0 = r211;
        r100.label = 1;
        if (r118.a(null, r100) != r103) goto L25;
        return r103;
    L25:
        r111 = r210;
        r108 = r211;
        r110 = r118;
    L7:
        r100 = new ImageOCRController$ensureDiskCache$1(this, r212);
        goto L8
    }

    public final Object o(String r110, String r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof ImageOCRController$saveToBatchCache$1) == false) goto L7;
        ImageOCRController$saveToBatchCache$1 r100 = (ImageOCRController$saveToBatchCache$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        kotlinx.coroutines.sync.a r114 = (kotlinx.coroutines.sync.a) r100.L$2;
        r111 = (String) r100.L$1;
        String r104 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
        kotlinx.coroutines.sync.a r115 = r114;
        r110 = r104;
    L59:
        int r105 = 0;
        if (f446610i != null) goto L20;
    L25:
        boolean r106 = true;
    L26:
        if (r106 == false) goto L32;
        Log.d("ImageOCRController", "Creating new batch file for key: " + r110 + " (entries: " + f446611j + ", size: " + f446612k + "B)");     // Catch: Throwable -> L28 Exception -> L30
        f446602a.getClass();     // Catch: Throwable -> L28 Exception -> L30
        g();     // Catch: Throwable -> L28 Exception -> L30
    L32:
        VFSFile r107 = f446610i;     // Catch: Throwable -> L28 Exception -> L30
        if (r107 != null) goto L38;
        ImageOCRController r108 = f446602a;     // Catch: Throwable -> L28 Exception -> L30
        Log.e("ImageOCRController", "Failed to create batch cache file, falling back to single cache for key: " + r110);     // Catch: Throwable -> L28 Exception -> L30
        r108.getClass();     // Catch: Throwable -> L28 Exception -> L30
        p(r110, r111);     // Catch: Throwable -> L28 Exception -> L30
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L28 Exception -> L30
        r115.unlock(null);
        return r116;
    L38:
        if (r107.exists() == true) goto L40;
    L42:
        b r109 = new b(null);     // Catch: Throwable -> L28 Exception -> L30
    L43:
        a r117 = new a(r110, r111, System.currentTimeMillis());     // Catch: Throwable -> L28 Exception -> L30
        int r118 = r109.f446616a.size();     // Catch: Throwable -> L28 Exception -> L30
        r109.f446616a.put(r110, r117);     // Catch: Throwable -> L28 Exception -> L30
        Iterator<T> r119 = r109.f446616a.values().iterator();     // Catch: Throwable -> L28 Exception -> L30
    L45:
        if (r119.hasNext() == false) goto L47;
        a r120 = (a) r119.next();     // Catch: Throwable -> L28 Exception -> L30
        r105 = r105 + (r120.f446614b.length() + r120.f446613a.length());     // Catch: Throwable -> L28 Exception -> L30
        goto L45
    L47:
        r109.f446617b = r105;     // Catch: Throwable -> L28 Exception -> L30
        f446602a.getClass();     // Catch: Throwable -> L28 Exception -> L30
        r107.writeBytes(q(r109));     // Catch: Throwable -> L28 Exception -> L30
        f446611j = r109.f446616a.size();     // Catch: Throwable -> L28 Exception -> L30
        f446612k = r107.length();     // Catch: Throwable -> L28 Exception -> L30
        f446606e.f446625g++;     // Catch: Throwable -> L28 Exception -> L30
        if (r118 != 0) goto L51;
        Log.i("ImageOCRController", "Batch cache saved: " + r107.getName() + ", key: " + r110 + ", entries: " + f446611j);     // Catch: Throwable -> L28 Exception -> L30
    L54:
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L28
        r115.unlock(null);
        return Unit.INSTANCE;
    L51:
        Log.i("ImageOCRController", "Batch cache updated: " + r107.getName() + ", key: " + r110 + ", entries: " + f446611j);     // Catch: Throwable -> L28 Exception -> L30
        goto L54
    L40:
        if (r107.length() <= 0) goto L42;
        byte[] r122 = r107.readBytes();     // Catch: Throwable -> L28 Exception -> L30
        f446602a.getClass();     // Catch: Throwable -> L28 Exception -> L30
        r109 = h(r122);     // Catch: Throwable -> L28 Exception -> L30
        goto L43
    L20:
        if (f446611j >= 50) goto L25;
        if (f446612k >= LynxResourceModule.DEFAULT_MEDIA_SIZE) goto L25;
        r106 = false;
    L28:
        th = move-exception;
        r115.unlock(null);
        throw th;
    L30:
        e = move-exception;
        Log.e("ImageOCRController", "Failed to save to batch cache for key: " + r110 + ", falling back to single cache", e);     // Catch: Throwable -> L28
        f446602a.getClass();     // Catch: Throwable -> L28
        p(r110, r111);     // Catch: Throwable -> L28
        goto L54
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        r115 = f446609h;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = r115;
        r100.label = 1;
        if (r115.a(null, r100) != r102) goto L59;
        return r102;
    L7:
        r100 = new ImageOCRController$saveToBatchCache$1(this, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public static final Object e(ImageOCRController r110, String r111, ImageOCRResponse r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof ImageOCRController$saveToDiskCache$1) == false) goto L7;
        ImageOCRController$saveToDiskCache$1 r100 = (ImageOCRController$saveToDiskCache$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L22;
        if (r104 == 1) goto L21;
        if (r104 != 2) goto L20;
        ?? r105 = (kotlinx.coroutines.sync.a) r100.L$2;
        ImageOCRResponse r106 = (ImageOCRResponse) r100.L$1;
        String r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L15 Exception -> L17
        ?? r108 = r105;
    L50:
        ImageOCRResponse r109 = r106;
        r105 = r108;
    L53:
        f446603b.put(r107, CompletableDeferredKt.CompletableDeferred(r109));     // Catch: Throwable -> L15 Exception -> L17
        Log.i("ImageOCRController", "Added response to memory cache for key: " + r107);     // Catch: Throwable -> L15 Exception -> L17
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L15 Exception -> L17
        ?? r115 = r105;
    L62:
        r115.unlock(null);
        BuildersKt.launch$default(f446608g, null, null, new ImageOCRController$saveToDiskCache$3(null), 3, null);
        return Unit.INSTANCE;
    L17:
        e = e;
        ?? r116 = r105;
        String r117 = r107;
    L60:
        Log.e("ImageOCRController", "Failed to save OCR result to disk cache for key: " + r117, e);     // Catch: Throwable -> L58
        c r118 = f446606e;     // Catch: Throwable -> L58
        int r119 = r118.f446624f;     // Catch: Throwable -> L58
        r118.f446624f = r119 + 1;     // Catch: Throwable -> L58
        Boxing.boxInt(r119);     // Catch: Throwable -> L58
        r115 = r116;
    L15:
        th = th;
    L64:
        r105.unlock(null);
        throw th;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        kotlinx.coroutines.sync.a r120 = (kotlinx.coroutines.sync.a) r100.L$2;
        r109 = (ImageOCRResponse) r100.L$1;
        r117 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r116 = r120;
    L66:
        VFSFile r121 = f446607f;     // Catch: Exception -> L56 Throwable -> L58
        if (r121 != null) goto L31;
        Log.e("ImageOCRController", "Cache directory is null, cannot save cache");     // Catch: Exception -> L56 Throwable -> L58
        f446606e.f446624f++;     // Catch: Exception -> L56 Throwable -> L58
        Unit r122 = Unit.INSTANCE;     // Catch: Exception -> L56 Throwable -> L58
    L29:
        Unit r123 = r122;
        r116.unlock(null);
        return r123;
    L31:
        if (r121.exists() == false) goto L33;
    L35:
        ImageOCRController r124 = f446602a;     // Catch: Exception -> L56 Throwable -> L58
        r124.getClass();     // Catch: Exception -> L56 Throwable -> L58
        String r125 = r(r109);     // Catch: Exception -> L56 Throwable -> L58
        if (r125.length() != 0) goto L38;
        boolean r126 = true;
    L39:
        if (r126 == false) goto L45;
        Log.w("ImageOCRController", "Serialized cache data is empty, skipping save");     // Catch: Exception -> L56 Throwable -> L58
        f446606e.f446624f++;     // Catch: Exception -> L56 Throwable -> L58
        r122 = Unit.INSTANCE;     // Catch: Exception -> L56 Throwable -> L58
        goto L29
    L45:
        if (r125.length() >= 10240) goto L51;
        Log.d("ImageOCRController", "Using batch cache for key: " + r117 + ", data size: " + r125.length());     // Catch: Exception -> L56 Throwable -> L58
        r100.L$0 = r117;     // Catch: Exception -> L56 Throwable -> L58
        r100.L$1 = r109;     // Catch: Exception -> L56 Throwable -> L58
        r100.L$2 = r116;     // Catch: Exception -> L56 Throwable -> L58
        r100.label = 2;     // Catch: Exception -> L56 Throwable -> L58
        if (r124.o(r117, r125, r100) == r103) goto L71;
        r108 = r116;
        r106 = r109;
        r107 = r117;
        goto L50
    L71:
        return r103;
    L51:
        Log.d("ImageOCRController", "Using single cache for key: " + r117 + ", data size: " + r125.length());     // Catch: Exception -> L56 Throwable -> L58
        p(r117, r125);     // Catch: Exception -> L56 Throwable -> L58
        r105 = r116;
        r107 = r117;
        goto L53
    L38:
        r126 = false;
        goto L39
    L33:
        if (r121.mkdirs() == true) goto L35;
        Log.e("ImageOCRController", "Failed to create cache directory: " + r121.getAbsolutePath());     // Catch: Exception -> L56 Throwable -> L58
        c r127 = f446606e;     // Catch: Exception -> L56 Throwable -> L58
        r127.f446624f = r127.f446624f + 1;     // Catch: Exception -> L56 Throwable -> L58
        r122 = Unit.INSTANCE;     // Catch: Exception -> L56 Throwable -> L58
    L56:
        e = e;
        goto L60
    L22:
        ResultKt.throwOnFailure(r102);
        f446606e.f446619a++;
        Log.d("ImageOCRController", "Starting saveToDiskCache for key: " + r111);
        MutexImpl r128 = f446604c;
        r100.L$0 = r111;
        r109 = r112;
        r100.L$1 = r109;
        r100.L$2 = r128;
        r100.label = 1;
        if (r128.a(null, r100) == r103) goto L72;
        r117 = r111;
        r116 = r128;
        goto L66
    L72:
        return r103;
    L58:
        th = th;
        r105 = r102;
    L7:
        r100 = new ImageOCRController$saveToDiskCache$1(r110, r113);
        goto L8
    }

    public final Object s(Context r110, PhotoItem r210, DownloadFileScene r211, Continuation<? super Unit> r212) {
        Context r100 = r110;
        PhotoItem r101 = r210;
        if ((r212 instanceof ImageOCRController$startOCR$1) == false) goto L7;
        ImageOCRController$startOCR$1 r102 = (ImageOCRController$startOCR$1) r212;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        String r107 = "";
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        OCRParams r108 = (OCRParams) r102.L$2;
        r101 = (PhotoItem) r102.L$1;
        Context r109 = (Context) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
        OCRParams r111 = r108;
        r100 = r109;
    L35:
        Object r112 = Result.m9449constructorimpl((ImageOCRResponse) r104);     // Catch: Throwable -> L37
    L39:
        Object r113 = r112;
        if (Result.m9455isFailureimpl(r113) == false) goto L42;
        Object r114 = null;
    L43:
        ImageOCRResponse r115 = (ImageOCRResponse) r114;
        if (Result.m9456isSuccessimpl(r113) == false) goto L47;
        if (r115 == null) goto L47;
        r101.getPhotoState().getOcrState().setValue(new com.ss.android.lark.widget.photopicker.entity.b.a(r115, true));
        f(r111, r115);
    L56:
        return Unit.INSTANCE;
    L47:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r113);
        if ((r116 instanceof ErrorResult) == false) goto L54;
        String r117 = ((ErrorResult) r116).getDisplayMsg();
        if (r117 == null) goto L53;
        r107 = r117;
    L53:
        UDToast.show(r100, r107);
    L54:
        r101.getPhotoState().getOcrState().setValue(null);
        Log.e("ImageOCRController", "ocrForPhotoItem error:" + Result.m9457toStringimpl(r113));
        goto L56
    L42:
        r114 = r113;
    L37:
        Throwable th10 = th;
    L38:
        Result.Companion r118 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
    L14:
        th10 = th;
        r111 = r108;
        r100 = r109;
        goto L38
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        com.ss.android.lark.widget.photopicker.entity.b r119 = r210.getPhotoState().getOcrState().getValue();
        OCRScene r120 = OCRScene.OCR;
        PhotoUtilsNew r121 = PhotoUtilsNew.f447142a;
        String r122 = PhotoUtilsNew.l(r210);
        if (r122 != null) goto L21;
        String r123 = "";
    L22:
        String r124 = PhotoUtilsNew.m(r210);
        if (r124 != null) goto L25;
        String r125 = "";
    L26:
        Log.d("ImageOCRController", "startOCR->getOCRParams for photo item - localPath: " + r123 + ", remoteKey: " + r125 + ", messageId: " + r210.getMessageId());
        r111 = r15;
        OCRParams r126 = new OCRParams(r123, r125, r210.getMessageId(), r211, false, r120);
        if ((r119 instanceof com.ss.android.lark.widget.photopicker.entity.b.a) == false) goto L29;
        MutableLiveData<com.ss.android.lark.widget.photopicker.entity.b> r127 = r210.getPhotoState().getOcrState();
        com.ss.android.lark.widget.photopicker.entity.b.a r128 = (com.ss.android.lark.widget.photopicker.entity.b.a) r119;
        boolean r129 = !r128.f447515b;
        ImageOCRResponse r130 = r128.f447514a;
        Intrinsics.checkNotNullParameter(r130, "ocrResponse");
        r127.setValue(new com.ss.android.lark.widget.photopicker.entity.b.a(r130, r129));
        f(r111, r128.f447514a);
        goto L56
    L29:
        Deferred r131 = n(r100, r101, r211, false, r120);
        if (r131.isCompleted() == true) goto L57;
        r210.getPhotoState().getOcrState().setValue(com.ss.android.lark.widget.photopicker.entity.b.C5418b.f447516a);
    L57:
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L37
        ImageOCRController$startOCR$ret$1$1 r133 = new ImageOCRController$startOCR$ret$1$1(r131, null);     // Catch: Throwable -> L37
        r102.L$0 = r100;     // Catch: Throwable -> L37
        r102.L$1 = r101;     // Catch: Throwable -> L37
        r102.L$2 = r111;     // Catch: Throwable -> L37
        r102.label = 1;     // Catch: Throwable -> L37
        r104 = CoroutineScopeKt.coroutineScope(r133, r102);     // Catch: Throwable -> L37
        if (r104 != r105) goto L35;
        return r105;
    L25:
        r125 = r124;
        goto L26
    L21:
        r123 = r122;
    L7:
        r102 = new ImageOCRController$startOCR$1(this, r212);
        goto L8
    }

    public static Deferred n(Context r100, PhotoItem r110, DownloadFileScene r111, boolean r112, OCRScene r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "photoItem");
        Intrinsics.checkNotNullParameter(r113, "ocrScene");
        PhotoUtilsNew r101 = PhotoUtilsNew.f447142a;
        String r102 = PhotoUtilsNew.l(r110);
        if (r102 != null) goto L5;
        String r103 = "";
    L6:
        String r104 = PhotoUtilsNew.m(r110);
        if (r104 != null) goto L9;
        String r105 = "";
    L10:
        Log.d("ImageOCRController", "Starting OCR for photo item - localPath: " + r103 + ", remoteKey: " + r105 + ", messageId: " + r110.getMessageId());
        OCRParams r106 = new OCRParams(r103, r105, r110.getMessageId(), r111, r112, r113);
        String r114 = r106.getLocalImagePath() + r106.getRemoteImageKey() + r106.getMsgID() + r106.getScene() + r106.getOcrScene();
        Log.i("ImageOCRController", "Generated hash key from params: " + r114);
        Log.d("ImageOCRController", "Polling OCR with key: " + r114);
        ConcurrentHashMap<String, Deferred<ImageOCRResponse>> r115 = f446603b;
        Deferred<ImageOCRResponse> r116 = r115.get(r114);
        if (r116 != null) goto L13;
    L17:
        r115.remove(r114);
        Deferred<ImageOCRResponse> r117 = BuildersKt.async$default(f446608g, null, null, new ImageOCRController$pollOCR$newJob$1(r114, r100, r106, null), 3, null);
        r115.put(r114, r117);
        Log.d("ImageOCRController", "Created new OCR task for key: " + r114);
        return r117;
    L13:
        if (r116.isActive() == false) goto L15;
    L16:
        Log.d("ImageOCRController", "Found existing OCR task for key: " + r114);
        return r116;
    L15:
        if (r116.isCancelled() == true) goto L17;
    L9:
        r105 = r104;
        goto L10
    L5:
        r103 = r102;
        goto L6
    }
}
