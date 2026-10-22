package ml9;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.music.h;
import com.larus.music.i;
import com.larus.music.qq.QQMusicManager;
import com.larus.platform.api.QQMusicSong;
import com.larus.platform.api.QQPlayStatus;
import com.larus.platform.api.i1;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l3.d;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514377a = 0;

    /* JADX INFO: renamed from: ml9.a$a, reason: collision with other inner class name */
    public static final class C6828a implements i1 {
        public C6828a() {
        }

        @Override // com.larus.platform.api.i1
        public final void a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "songId");
            int r102 = a.f514377a;
            Intrinsics.checkNotNullParameter(r100, "songId");
            Lazy r103 = d.f507201a;
            JsonObject r104 = new JsonObject();
            r104.addProperty("id", r100);
            r104.addProperty("isCollected", Boolean.valueOf(r101));
            Unit r105 = Unit.INSTANCE;
            d.c(new l3.a("QQMusic.favouriteStatusChanged", r104, 4));
        }

        @Override // com.larus.platform.api.i1
        public final void b(QQMusicSong r100, QQPlayStatus r101) {
            Intrinsics.checkNotNullParameter(r101, "status");
            int r102 = a.f514377a;
            Intrinsics.checkNotNullParameter(r101, "status");
            Lazy r103 = d.f507201a;
            JsonObject r104 = new JsonObject();
            r104.addProperty("status", r101.getValue());
            r104.add(Keys.API_EVENT_KEY_SONG, GsonProtectorUtils.toJsonTree(new Gson(), r100));
            Unit r105 = Unit.INSTANCE;
            d.c(new l3.a("QQMusic.playStatusChanged", r104, 4));
        }
    }

    static {
        i r100 = i.f359475a;
        C6828a r101 = new C6828a();
        Intrinsics.checkNotNullParameter(r101, "callback");
        QQMusicManager r102 = QQMusicManager.f359498a;
        h r103 = new h(r101);
        Intrinsics.checkNotNullParameter(r103, "callback");
        List<com.larus.music.qq.a> r104 = QQMusicManager.f359505h;
        if (r104 == null) goto L6;
        ((ArrayList) r104).add(r103);
        return;
    }
}
