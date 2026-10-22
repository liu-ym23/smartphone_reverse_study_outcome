package o7;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f522238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f522239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f522240c;

    public f(Context r100, String r101, String r102) {
        this.f522238a = r100;
        this.f522239b = r101;
        this.f522240c = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Object> r100) {
        int r101 = k.f522251a;
        Context r102 = this.f522238a;
        String r103 = this.f522239b;
        String r104 = this.f522240c;
        Uri r105 = BdMediaFileSystem.createImageUri(r102, DigestUtils.md5Hex(r103) + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT);
        OutputStream r106 = null;
        PolarisFileInputStreamWrapper r107 = null;
        OutputStream r108 = ContentResolverWrapper.openOutputStream(r102.getContentResolver(), r105);     // Catch: Throwable -> L21
        PolarisFileInputStreamWrapper r109 = new PolarisFileInputStreamWrapper(r104);     // Catch: Throwable -> L40
    L50:
        int r110 = r109.read();     // Catch: Throwable -> L19
        if (r110 == (-1)) goto L9;
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L19
        r108.write(r110);     // Catch: Throwable -> L19
        goto L50
    L9:
        if (r108 == null) goto L46;
        r108.close();     // Catch: Throwable -> L38
    L46:
        r109.close();     // Catch: Throwable -> L13
    L14:
        Intent r111 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        r111.setData(r105);
        r102.sendBroadcast(r111);
        PolarisFileWrapper r112 = new PolarisFileWrapper(r104);
        if (r112.exists() == true) goto L17;
        return;
    L17:
        if (r112.isFile() == false) goto L65;
        r112.delete();
        return;
    L65:
        return;
    L19:
        r107 = r109;
    L20:
        PolarisFileInputStreamWrapper r113 = r107;
        r106 = r108;
    L60:
        k.b(r102);     // Catch: Throwable -> L30
        if (r106 != null) goto L48;
    L27:
        if (r113 == null) goto L67;
        r113.close();     // Catch: Throwable -> L39
        return;
    L68:
        return;
    L67:
        return;
    L48:
        r106.close();     // Catch: Throwable -> L26
    L30:
        th = move-exception;
        if (r106 != null) goto L44;
    L35:
        if (r113 == null) goto L69;
        r113.close();     // Catch: Throwable -> L41
        throw th;
    L70:
        throw th;
    L69:
        throw th;
    L44:
        r106.close();     // Catch: Throwable -> L34
    L21:
        r113 = null;
        goto L60
    }
}
