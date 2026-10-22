package ew;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements bw.j {
    public n() {
    }

    @Override // bw.j
    public final void A0() {
    }

    @Override // bw.j
    public final void H1(String r100, String r101, String r102, String r103, String r104, Map r105) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter("anchor_page", "refer");
        Intrinsics.checkNotNullParameter(r104, "logExtra");
        Intrinsics.checkNotNullParameter(r105, "adExtraData");
    }

    @Override // bw.j
    public final String J0() {
        return "livesdk_";
    }

    @Override // bw.j
    public final void W(String r100) {
        Intrinsics.checkNotNullParameter("GameCpTargetUtils", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // bw.j
    public final Map<String, Object> getAdLogExtra() {
        return null;
    }

    @Override // bw.j
    public final Map<String, String> getFilterParamsByName(String r100) {
        return null;
    }

    @Override // bw.j
    public final void logV3(String r100, Map<String, String> r101) {
    }

    @Override // bw.j
    public final void logV3NoPrefix(String r100, Map<String, String> r101) {
    }

    @Override // bw.j
    public final void sendLiveAdLog(String r100, String r101, Long r102, JSONObject r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r101, "refer");
        Intrinsics.checkNotNullParameter(r103, "adExtraData");
    }

    @Override // bw.j
    public final void y1() {
    }
}
