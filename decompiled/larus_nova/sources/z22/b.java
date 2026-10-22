package z22;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.downloadlib.constants.MimeType;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f569776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f569777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f569778c;

    public b(String r100, Context r101, boolean r102) {
        this.f569776a = r100;
        this.f569777b = r101;
        this.f569778c = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Uri> r100) {
        Intrinsics.checkNotNullParameter(r100, "emmit");
        if (FileUtils.isFileEmpty(this.f569776a) == false) goto L6;
        r100.onError(new IllegalArgumentException("文件有问题"));
        return;
    L6:
        Uri r101 = BdMediaFileSystem.createVideoUri(this.f569777b, "live_dy_record_" + System.currentTimeMillis() + ".mp4", MimeType.MP4, Environment.DIRECTORY_DCIM);
        OutputStream r102 = null;
        Throwable r103 = null;
        r103 = null;
        PolarisFileInputStreamWrapper r104 = null;
        OutputStream r105 = null;
        OutputStream r106 = null;
        OutputStream r107 = null;
        OutputStream r108 = ContentResolverWrapper.openOutputStream(this.f569777b.getContentResolver(), r101);     // Catch: Throwable -> L44 NullPointerException -> L60 IOException -> L75 FileNotFoundException -> L90
    L133:
        PolarisFileInputStreamWrapper r109 = new PolarisFileInputStreamWrapper(this.f569776a);     // Catch: Throwable -> L36 NullPointerException -> L38 IOException -> L40 FileNotFoundException -> L42
    L135:
        byte[] r110 = new byte[1048576];     // Catch: Throwable -> L28 NullPointerException -> L30 IOException -> L32 FileNotFoundException -> L34
    L11:
        int r111 = r109.read(r110);     // Catch: Throwable -> L28 NullPointerException -> L30 IOException -> L32 FileNotFoundException -> L34
        if (r111 < 0) goto L16;
        if (r108 == null) goto L11;
        r108.write(r110, 0, r111);     // Catch: Throwable -> L28 NullPointerException -> L30 IOException -> L32 FileNotFoundException -> L34
    L16:
        if (r108 != null) goto L127;
    L121:
        r109.close();     // Catch: IOException -> L23
    L26:
        if (this.f569778c == true) goto L105;
    L107:
        if (r103 == null) goto L109;
        r100.onError(r103);
        return;
    L109:
        r100.onNext(r101);
        r100.onComplete();
        Unit r112 = Unit.INSTANCE;
        return;
    L105:
        int r113 = c.f569779a;
        c.b(this.f569776a);
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L26
    L127:
        r108.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L34:
        e = move-exception;
        e = e;
        r105 = r108;
    L92:
        if (r105 != null) goto L129;
    L97:
        if (r109 == null) goto L103;
        r109.close();     // Catch: IOException -> L100
    L100:
        e = move-exception;
        e.printStackTrace();
    L103:
        if (this.f569778c == false) goto L106;
    L104:
        r103 = e;
    L106:
        r103 = e;
        goto L107
    L129:
        r105.close();     // Catch: IOException -> L95
    L95:
        e = move-exception;
        e.printStackTrace();
    L32:
        e = move-exception;
        e = e;
        r106 = r108;
    L77:
        if (r106 != null) goto L125;
    L82:
        if (r109 == null) goto L88;
        r109.close();     // Catch: IOException -> L85
    L85:
        e = move-exception;
        e.printStackTrace();
    L88:
        if (this.f569778c == false) goto L106;
    L125:
        r106.close();     // Catch: IOException -> L80
    L80:
        e = move-exception;
        e.printStackTrace();
    L30:
        e = move-exception;
        e = e;
        r107 = r108;
    L62:
        if (r107 != null) goto L119;
    L67:
        if (r109 == null) goto L73;
        r109.close();     // Catch: IOException -> L70
    L70:
        e = move-exception;
        e.printStackTrace();
    L73:
        if (this.f569778c == false) goto L106;
    L119:
        r107.close();     // Catch: IOException -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = th;
        r104 = r109;
    L37:
        PolarisFileInputStreamWrapper r114 = r104;
        r102 = r108;
    L46:
        if (r102 != null) goto L123;
    L51:
        if (r114 == null) goto L57;
        r114.close();     // Catch: IOException -> L54
    L54:
        e = move-exception;
        e.printStackTrace();
    L57:
        if (this.f569778c == false) goto L142;
        int r115 = c.f569779a;
        c.b(this.f569776a);
        throw th;
    L142:
        throw th;
    L123:
        r102.close();     // Catch: IOException -> L49
    L49:
        e = move-exception;
        e.printStackTrace();
    L42:
        e = move-exception;
        r109 = null;
        r105 = r108;
        e = e;
    L40:
        e = move-exception;
        r109 = null;
        r106 = r108;
        e = e;
    L38:
        e = move-exception;
        r109 = null;
        r107 = r108;
        e = e;
    L36:
        th = th;
    L90:
        e = e;
        r109 = null;
    L75:
        e = e;
        r109 = null;
    L60:
        e = e;
        r109 = null;
    L44:
        th = th;
        r114 = null;
        goto L46
    }
}
