package ms.bd.c;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.ttm.player.MediaPlayer;
import java.util.Locale;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes6.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f515397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f515398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f515399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f515400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f515401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f515402f;

    static {
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4e6456", new byte[]{1, 104, 80, 121, 3, 47, 27, 77, 113, 97});
    }

    public final String toString() {
        return String.format(Locale.US, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "5570fb", new byte[]{33, 37, 86, 30, 28, 102, 42, 17, 104, 97, 38, 59, 65, 64, 3, 48, 37, 8, 35, 100, 104, 114, 64, 8, 28, 113}), new Object[]{Boolean.valueOf(this.f515401e), Boolean.valueOf(this.f515402f), Integer.valueOf(this.f515397a), Integer.valueOf(this.f515398b), Integer.valueOf(this.f515399c)});
    }

    public v1() {
        this.f515397a = 0;
        this.f515398b = 0;
        this.f515399c = 0;
        this.f515400d = 0;
        this.f515401e = false;
        this.f515402f = false;
        String r100 = (String) p2.a(16777224, 0, 0, null, null);
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a94b2f", new byte[]{95, 41, 78, 17, 4, ByteCompanionObject.MAX_VALUE, 99, 20, 37, 49, ByteCompanionObject.MAX_VALUE, 53, 65, 31, 10, 43, 34, 93, 118});
        if (TextUtils.isEmpty(r100) == false) goto L6;
        this.f515401e = true;
        Object r102 = p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f8fdd7", new byte[]{71, 59, 7, 3, 94, 96, 102, 22, 57, 50, 126, Base64.padSymbol, 85, 22, 90, 41, 105, 28, 51, 116, 120, 40, 85, 4, 83, 37, 37, 26, 56, 58, 113, 51, 18, 80, 76, 33, 118, 89, 57, 59, 99, 122, 6, 21, 79, 110});
    L5:
        String r103 = (String) r102;
    L21:
        String r104 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "41c5e4", new byte[]{1, 60, 5, 120, 83, 45, 27, 25, 36, 96});
        String r105 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "7b7a27", new byte[]{21, 101, 80, 1, 4, 46, 51, 80, 38, 34, 50, 97, 80, 0, 30, 122, 116, 6, 117});
        if (this.f515402f == false) goto L25;
        this.f515400d = this.f515397a - this.f515398b;
        return;
    L25:
        return;
    L6:
        String[] r106 = r100.split((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "7acdf4", new byte[]{26, ByteCompanionObject.MAX_VALUE}));
        if (r106.length == 3) goto L9;
        this.f515401e = true;
        r102 = p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "dd709b", new byte[]{86, 105, 74, 66, 15, 114, 39, 82, 103, 115, 53, 111, 74, 4, 18, 125, 98, 5, 113, 114, 122, 104, 67, 4, 0, 122, 117, 72, 103, 116, 59});
        goto L5
    L9:
        int r107 = CastIntegerProtector.parseInt(r106[0]);
        this.f515397a = r107;
        int r108 = CastIntegerProtector.parseInt(r106[1]);
        this.f515398b = r108;
        int r109 = CastIntegerProtector.parseInt(r106[2]);
        this.f515399c = r109;
        if (r107 < 0) goto L19;
        if (r108 < 0) goto L19;
        if (r107 < r108) goto L19;
        if (r109 == 0) goto L19;
        if (r108 != 0) goto L18;
        if (r107 != 0) goto L18;
        Object r110 = p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "620ed8", new byte[]{4, 63, 77, 23, 82, 40, 117, 4, 96, 38, 103, 35, 70, 5, 27, 43, 60, 0, 96, 55, 43, 53, 71, 95});
    L20:
        String r111 = (String) r110;
    L18:
        this.f515402f = true;
    L19:
        this.f515401e = true;
        r110 = p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b78485", new byte[]{80, 58, 69, 70, 14, 37, 33, 1, 104, 119, 51, 38, 78, 84, 71, 43, 111, 86, 125, 108, 118, 117, 92, 82, 8, 44, 102, 86, 126, 101, 106, 123});
        goto L20
    }
}
