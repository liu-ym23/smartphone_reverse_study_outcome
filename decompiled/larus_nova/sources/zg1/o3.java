package zg1;

import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseUser f571896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f571897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f571898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f571899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f571900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f571901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LocateGiftInfo f571902g;

    public o3(IBaseUser r100, LocateGiftInfo r101, Bundle r102, String r103) {
        this.f571901f = System.currentTimeMillis();
        this.f571902g = LocateGiftInfo.getDefault(0);
        this.f571902g = r101;
        this.f571896a = r100;
        this.f571897b = r102;
        this.f571898c = null;
        this.f571899d = r103;
        this.f571900e = true;
    }

    public o3(IBaseUser r100, LocateGiftInfo r101, Bundle r102, String r103, JSONObject r104) {
        this.f571901f = System.currentTimeMillis();
        this.f571902g = LocateGiftInfo.getDefault(0);
        this.f571902g = r101;
        this.f571896a = r100;
        this.f571897b = r102;
        this.f571898c = r104;
        this.f571899d = r103;
    }
}
