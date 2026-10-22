package com.bytedance.locallife.poi.poidetail.container.mob;

import android.text.TextUtils;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.HashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiMobHelper {

    public static final enum MemoryRestoreFailSceneType extends Enum<MemoryRestoreFailSceneType> {
        public static final MemoryRestoreFailSceneType FRAGMENT_ADD_FAIL = null;
        public static final MemoryRestoreFailSceneType FRAGMENT_MANAGER_NOT_READY = null;
        public static final MemoryRestoreFailSceneType SNAPSHOT_INVALID_FALLBACK_REQUEST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MemoryRestoreFailSceneType[] f263845a = null;
        private final int code;

        static {
            MemoryRestoreFailSceneType r100 = new MemoryRestoreFailSceneType("FRAGMENT_MANAGER_NOT_READY", 0, 0);
            FRAGMENT_MANAGER_NOT_READY = r100;
            MemoryRestoreFailSceneType r101 = new MemoryRestoreFailSceneType("FRAGMENT_ADD_FAIL", 1, 1);
            FRAGMENT_ADD_FAIL = r101;
            MemoryRestoreFailSceneType r102 = new MemoryRestoreFailSceneType("SNAPSHOT_INVALID_FALLBACK_REQUEST", 2, 2);
            SNAPSHOT_INVALID_FALLBACK_REQUEST = r102;
            f263845a = new MemoryRestoreFailSceneType[]{r100, r101, r102};
        }

        public static MemoryRestoreFailSceneType[] values() {
            return (MemoryRestoreFailSceneType[]) f263845a.clone();
        }

        public int getCode() {
            return this.code;
        }

        public static MemoryRestoreFailSceneType valueOf(String r100) {
            return (MemoryRestoreFailSceneType) r27.a.a(MemoryRestoreFailSceneType.class, r100);
        }

        public MemoryRestoreFailSceneType(String r100, int r101, int r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    public static void a(String r100, mq6.c r101) {
        String r102 = "0";
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r101.d("poi_device_samecity", "0");
        return;
    L6:
        r101.d("poi_city", r100);
        if (HostServiceUtilsKt.s().b(r100) == false) goto L9;
        r102 = "1";
    L9:
        r101.d("poi_device_samecity", r102);
    }

    public static void b(PoiBundle r100, MemoryRestoreFailSceneType r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        mq6.c r102 = new mq6.c();
        String r103 = r100.poiId;
        String r104 = "";
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        mq6.a r105 = mq6.c.a.f514894a;
        r102.g("poi_id", r103);
        String r106 = r100.from;
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        r102.g("enter_from", r106);
        String r107 = r100.enterMethod;
        if (r107 != null) goto L13;
        r107 = "";
    L13:
        r102.g("enter_method", r107);
        if (r101 == null) goto L17;
        r104 = String.valueOf(r101.getCode());
    L17:
        r102.g("poi_scene_type", r104);
        c(r100, "life_poi_restore_fail_tech", r102);
    }

    public static void c(PoiBundle r100, String r101, mq6.c r102) {
        if (r100 != null) goto L4;
    L10:
        HashMap<String, String> r103 = new HashMap(r102.f514893a);
        if (r100 != null) goto L13;
    L17:
        int r104 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c(r101, r103);
        return;
    L13:
        if (TextUtils.isEmpty(r100.sessionId) == true) goto L17;
        HashMap<String, yy6.a> r105 = yy6.a.f569482e;
        yy6.a r106 = yy6.a.C8403a.a(r100.sessionId);
        if (r106 == null) goto L17;
        r106.a(null, r103);
        goto L17
    L4:
        if (TextUtils.isEmpty(r100.backendType) == true) goto L7;
        r102.d("poi_backend_type", r100.backendType);
    L7:
        if (TextUtils.isEmpty(r100.bizCode) == true) goto L9;
        r102.d(UniContext.KEY_OF_BIZ_CODE, r100.bizCode);
    L9:
        a(r100.cityCode, r102);
        goto L10
    }
}
