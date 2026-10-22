package com.bytedance.bdp.service.plug.map.listener;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\bJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/listener/BdpMapCallback;", "", "animationEnd", "", "onFail", "scene", "Lcom/bytedance/bdp/service/plug/map/listener/BdpMapCallback$Fail;", "onSuccess", CheckStatus.FAIL, "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
public interface BdpMapCallback {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 18})
    public static final class DefaultImpls {
        public static void animationEnd(BdpMapCallback r100) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/listener/BdpMapCallback$Fail;", "", "(Ljava/lang/String;I)V", "MARKER_ID_INVALID", "MULTI_CALL", "PATH_INVALID", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
    public static final enum Fail extends Enum<Fail> {
        private static final /* synthetic */ Fail[] $VALUES = null;
        public static final Fail MARKER_ID_INVALID = null;
        public static final Fail MULTI_CALL = null;
        public static final Fail PATH_INVALID = null;

        static {
            Fail r100 = new Fail("MARKER_ID_INVALID", 0);
            MARKER_ID_INVALID = r100;
            Fail r101 = new Fail("MULTI_CALL", 1);
            MULTI_CALL = r101;
            Fail r102 = new Fail("PATH_INVALID", 2);
            PATH_INVALID = r102;
            $VALUES = new Fail[]{r100, r101, r102};
        }

        public static Fail valueOf(String r100) {
            return (Fail) a.a(Fail.class, r100);
        }

        public static Fail[] values() {
            return (Fail[]) $VALUES.clone();
        }

        private Fail(String r100, int r101) {
            super(r100, r101);
        }
    }

    void animationEnd();

    void onFail(Fail r100);

    void onSuccess();
}
