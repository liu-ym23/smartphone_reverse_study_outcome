package pt1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property<String> f530627b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Gson f530628c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Type f530629d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f530630e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Room f530631a;

    /* JADX INFO: renamed from: pt1.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"pt1/a$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C7244a extends TypeToken<ArrayList<Long>> {
        public C7244a() {
        }
    }

    public static final class b {
        public b() {
        }

        public static ArrayList a() {
            return (ArrayList) GsonProtectorUtils.fromJson(a.f530628c, a.f530627b.getValue(), a.f530629d);
        L4:
            e = move-exception;
            ALogger.e("ShareFansHelper", "sp get sharedRoomId error: " + e.getMessage());
            return null;
        }
    }

    static {
        f530630e = new b();
        f530627b = new Property("shared_long_press_panel", "shared_room_id", "");
        f530628c = new Gson();
        f530629d = new C7244a().getType();
    }

    public a(Room r100) {
        this.f530631a = r100;
    }
}
