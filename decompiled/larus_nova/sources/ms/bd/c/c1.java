package ms.bd.c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes6.dex */
public final class c1 extends Binder implements IInterface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f515119d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f515120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y2 f515121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d1 f515122c;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    static {
        f515119d = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "2297c9", new byte[]{32, 63, 71, HTTP.CR, 84, 39, 57, 28, 102, 104, 49, 126, 73, 79, 83, 59, 53, 0, 109, 117, 53, 57, 73, 70, 18, 33, 48, 26, 108, 41, 10, 31, 107, 106, 120, HTTP.CR, 48, 31, 100, 69, 34, 51, 65});
    }

    public c1(d1 r100, y2 r101) {
        this.f515122c = r100;
        attachInterface(this, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "eac9a7", new byte[]{119, 108, 29, 3, 86, 41, 110, 79, 60, 102, 102, 45, 19, 65, 81, 53, 98, 83, 55, 123, 98, 106, 19, 72, 16, 47, 103, 73, 54, 39, 93, 76, 49, 100, 122, 3, 103, 76, 62, 75, 117, 96, 27}));
        this.f515120a = "";
        this.f515121b = r101;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
        String r104 = f515119d;
        if (r100 != 1) goto L5;
        r101.enforceInterface(r104);
        r101.readInt();
        r101.readLong();
        r101.readInt();
        r101.readFloat();
        r101.readDouble();
        r101.readString();
        r102.writeNoException();
        return true;
    L5:
        if (r100 != 2) goto L7;
        r101.enforceInterface(r104);
        int r105 = r101.readInt();
        if (r101.readInt() == 0) goto L15;
        Bundle r106 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
    L16:
        this.f515122c.getClass();
        if (r105 != 0) goto L22;
        if (r106 == null) goto L22;
        this.f515120a = r106.getString(this.f515122c.f515127a);
        y2 r107 = this.f515121b;
        if (r107 == null) goto L22;
        r107.f515441a.f515447a = this.f515120a;
    L22:
        r102.writeNoException();
        return true;
    L15:
        r106 = null;
        goto L16
    L7:
        if (r100 != 1598968902) goto L9;
        r102.writeString(r104);
        return true;
    L9:
        return super.onTransact(r100, r101, r102, r103);
    }
}
