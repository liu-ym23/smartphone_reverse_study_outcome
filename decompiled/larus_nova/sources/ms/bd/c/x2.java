package ms.bd.c;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
public final class x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f515431a;

    public final String a() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 <= 28) goto L18;
        ContentProviderClient r101 = b(this.f515431a.getContentResolver(), UriProtector.parse((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a78c74", new byte[]{115, 58, 69, 3, HTTP.CR, 45, 118, 76, 38, 124, 115, 59, 5, 25, 29, 33, 107, 23, 39, 58, 116, 48, 69, 3, 1, 55, 123, 89, 96, 55, 117, 59, 95, 30, 28, 58})));     // Catch: Exception -> L19
        Bundle r102 = r101.call((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "6fdea0", new byte[]{32, 97, 3, 62, ByteCompanionObject.MAX_VALUE, 14, 17}), null, null);     // Catch: Exception -> L19
        if (r100 < 24) goto L8;
        r101.close();     // Catch: Exception -> L19
    L9:
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102.getInt((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e72224", new byte[]{119, 58, 69, 67}), -1) == 0) goto L14;
        r102.getString((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "48a911", new byte[]{40, 63, 1, 94, 15, 33, 50}));     // Catch: Exception -> L19
        goto L16
    L14:
        return r102.getString((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "cda7ab", new byte[]{123, 98}));
    L8:
        r101.release();     // Catch: Exception -> L19
    L16:
        return null;
    L18:
        return null;
    }

    public x2(Context r100) {
        this.f515431a = r100;
    }

    public static ContentProviderClient b(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, null, r112, false);
        return (ContentProviderClient) r113.f474983b;
    L6:
        ContentProviderClient r114 = r110.acquireContentProviderClient(r111);
        r100.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, r114, r112, true);
        return r114;
    }
}
