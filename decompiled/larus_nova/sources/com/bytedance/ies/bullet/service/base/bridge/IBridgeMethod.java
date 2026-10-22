package com.bytedance.ies.bullet.service.base.bridge;

import com.bytedance.ies.bullet.service.base.i0;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface IBridgeMethod extends i0, com.bytedance.ies.bullet.service.base.bridge.a {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "", "PUBLIC", "PRIVATE", "PROTECT", "SECURE", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Access extends Enum<Access> {
        public static final Access PRIVATE = null;
        public static final Access PROTECT = null;
        public static final Access PUBLIC = null;
        public static final Access SECURE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Access[] f247789a = null;

        public static Access valueOf(String r100) {
            return (Access) r27.a.a(Access.class, r100);
        }

        public static Access[] values() {
            return (Access[]) f247789a.clone();
        }

        static {
            Access r100 = new Access("PUBLIC", 0);
            PUBLIC = r100;
            Access r101 = new Access("PRIVATE", 1);
            PRIVATE = r101;
            Access r102 = new Access("PROTECT", 2);
            PROTECT = r102;
            Access r103 = new Access("SECURE", 3);
            SECURE = r103;
            f247789a = new Access[]{r100, r101, r102, r103};
        }

        public Access(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a extends com.bytedance.ies.bullet.service.base.bridge.a.InterfaceC3543a {
        void onComplete(JSONObject r100);

        void onError(int r100, String r101);

        void onError(String r100, JSONObject r101);
    }

    void b70(JSONObject r100, a r101);
}
