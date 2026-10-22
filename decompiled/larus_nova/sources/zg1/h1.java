package zg1;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IRoom f571838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f571839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, String> f571840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f571841f;

    public h1(Room r100) {
        this.f571837b = false;
        this.f571841f = null;
        this.f571836a = 37;
        this.f571838c = r100;
        this.f571837b = true;
    }

    public h1(int r100) {
        this.f571837b = false;
        this.f571841f = null;
        this.f571836a = r100;
    }

    public h1(int r100, IRoom r101) {
        this.f571837b = false;
        this.f571841f = null;
        this.f571836a = r100;
        this.f571838c = r101;
    }
}
