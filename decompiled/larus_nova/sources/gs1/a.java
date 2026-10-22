package gs1;

import com.bytedance.android.livesdk.clearscreen.h;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenManagerAbility;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen.IClearScreenManagerFactory;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f482437a = 0;

    /* JADX INFO: renamed from: gs1.a$a, reason: collision with other inner class name */
    public static final class C6062a implements IClearScreenManagerFactory {
        public C6062a() {
        }

        @Override // com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen.IClearScreenManagerFactory
        public final jg1.b create(String r100) {
            return new h(r100);
        }
    }

    public static final class b implements IClearScreenManagerFactory {
        public b() {
        }

        @Override // com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen.IClearScreenManagerFactory
        public final jg1.b create(String r100) {
            return new h(ClearScreenManagerAbility.DEFAULT_CLEAR_SCREEN_UNIQUE_ID);
        }
    }

    public static h b() {
        ClearScreenManagerAbility r100 = ClearScreenManagerAbility.INSTANCE;
        r100.setFactory(new b());
        jg1.b r101 = r100.getInstance(ClearScreenManagerAbility.DEFAULT_CLEAR_SCREEN_UNIQUE_ID);
        if ((r101 instanceof h) == true) goto L6;
        r101 = null;
    L6:
        return (h) r101;
    }

    static {
    }

    public static h a(String r100) {
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L5;
        ClearScreenManagerAbility r101 = ClearScreenManagerAbility.INSTANCE;
        r101.setFactory(new C6062a());
        jg1.b r102 = r101.getInstance(r100);
        if ((r102 instanceof h) == true) goto L10;
        r102 = null;
    L10:
        return (h) r102;
    L5:
        return b();
    }
}
