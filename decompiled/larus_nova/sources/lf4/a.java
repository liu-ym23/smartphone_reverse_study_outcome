package lf4;

import com.android.ttcjpaysdk.base.service.IUpdateConfig;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wd4.c;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends GeckoUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IUpdateConfig f509054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f509055b;

    /* JADX INFO: renamed from: lf4.a$a, reason: collision with other inner class name */
    public static final class C6687a {
    }

    static {
    }

    public final Map<String, Object> a() {
        Pair[] r100 = new Pair[5];
        IUpdateConfig r101 = this.f509054a;
        Integer r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getGeckoAppName();
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r100[0] = TuplesKt.to("gecko_app_name", r103);
        IUpdateConfig r104 = this.f509054a;
        if (r104 == null) goto L13;
        List<String> r105 = r104.getChannelList();
        if (r105 == null) goto L13;
        String r106 = CollectionsKt.joinToString$default(r105, null, null, null, 0, null, null, 63, null);
    L14:
        r100[1] = TuplesKt.to("channels", r106);
        IUpdateConfig r107 = this.f509054a;
        if (r107 == null) goto L17;
        Integer r108 = Integer.valueOf(r107.getUpdateLevel());
    L18:
        r100[2] = TuplesKt.to("update_level", r108);
        IUpdateConfig r109 = this.f509054a;
        if (r109 == null) goto L21;
        Boolean r110 = Boolean.valueOf(r109.disableThrottle());
    L22:
        r100[3] = TuplesKt.to("disable_throttle", r110);
        IUpdateConfig r111 = this.f509054a;
        if (r111 == null) goto L25;
        r102 = Integer.valueOf(r111.getLoopLevel());
    L25:
        r100[4] = TuplesKt.to("loop_level", r102);
        return MapsKt.mutableMapOf(r100);
    L21:
        r110 = null;
        goto L22
    L17:
        r108 = null;
    L13:
        r106 = null;
        goto L14
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateFinish() {
        super.onUpdateFinish();
        c r100 = this.f509055b;
        Map<String, Object> r101 = a();
        r101.put("callback_name", "onUpdateFinish");
        Unit r102 = Unit.INSTANCE;
        r100.onReport("wallet_rd_gecko_update_event", r101);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onActivateSuccess(UpdatePackage r100) {
        super.onActivateSuccess(r100);
        c r101 = this.f509055b;
        Map<String, Object> r102 = a();
        r102.put("callback_name", "onActivateSuccess");
        if (r100 == null) goto L5;
        String r103 = r100.toString();
    L6:
        r102.put("update_package_info", r103);
        Unit r104 = Unit.INSTANCE;
        r101.onReport("wallet_rd_gecko_update_event", r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onClean(String r100) {
        super.onClean(r100);
        c r101 = this.f509055b;
        Map<String, Object> r102 = a();
        r102.put("callback_name", "onClean");
        r102.put("callback_channel", r100);
        Unit r103 = Unit.INSTANCE;
        r101.onReport("wallet_rd_gecko_update_event", r102);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onDownloadSuccess(UpdatePackage r100) {
        super.onDownloadSuccess(r100);
        c r101 = this.f509055b;
        Map<String, Object> r102 = a();
        r102.put("callback_name", "onDownloadSuccess");
        if (r100 == null) goto L5;
        String r103 = r100.toString();
    L6:
        r102.put("update_package_info", r103);
        Unit r104 = Unit.INSTANCE;
        r101.onReport("wallet_rd_gecko_update_event", r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onLocalNewestVersion(LocalPackageModel r100) {
        super.onLocalNewestVersion(r100);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateStart(UpdatePackage r100) {
        super.onUpdateStart(r100);
        c r101 = this.f509055b;
        Map<String, Object> r102 = a();
        r102.put("callback_name", "onUpdateStart");
        if (r100 == null) goto L5;
        String r103 = r100.toString();
    L6:
        r102.put("update_package_info", r103);
        Unit r104 = Unit.INSTANCE;
        r101.onReport("wallet_rd_gecko_update_event", r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdating(String r100) {
        super.onUpdating(r100);
        c r101 = this.f509055b;
        Map<String, Object> r102 = a();
        r102.put("callback_name", "onUpdating");
        r102.put("callback_channel", r100);
        Unit r103 = Unit.INSTANCE;
        r101.onReport("wallet_rd_gecko_update_event", r102);
    }

    public a(IUpdateConfig r100, c r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f509054a = r100;
        this.f509055b = r101;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onActivateFail(UpdatePackage r100, Throwable r101) {
        super.onActivateFail(r100, r101);
        c r102 = this.f509055b;
        Map<String, Object> r103 = a();
        r103.put("callback_name", "onActivateFail");
        String r104 = null;
        if (r100 == null) goto L5;
        String r105 = r100.toString();
    L6:
        r103.put("update_package_info", r105);
        if (r101 == null) goto L9;
        r104 = r101.getMessage();
    L9:
        r103.put("error_msg", r104);
        Unit r106 = Unit.INSTANCE;
        r102.onReport("wallet_rd_gecko_update_event", r103);
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionFail(Map<String, List<android.util.Pair<String, Long>>> r110, Throwable r111) {
        super.onCheckServerVersionFail(r110, r111);
        IUpdateConfig r100 = this.f509054a;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getAk();
    L6:
        if (r110 == null) goto L21;
        List<android.util.Pair<String, Long>> r103 = r110.get(r102);
        if (r103 == null) goto L21;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L11:
        if (r105.hasNext() == false) goto L22;
        Object r106 = r105.next();
        android.util.Pair r107 = (android.util.Pair) r106;
        IUpdateConfig r108 = this.f509054a;
        if (r108 == null) goto L15;
        List<String> r109 = r108.getChannelList();
    L16:
        if (r109 != null) goto L19;
        r109 = CollectionsKt.emptyList();
    L19:
        if (r109.contains(r107.first) == false) goto L11;
        r104.add(r106);
        goto L11
    L15:
        r109 = null;
    L22:
        c r112 = this.f509055b;
        Map<String, Object> r113 = a();
        r113.put("callback_name", "onCheckServerVersionFail");
        if (r104 == null) goto L25;
        String r114 = CollectionsKt.joinToString$default(r104, null, null, null, 0, null, null, 63, null);
    L26:
        r113.put("callback_channels", r114);
        if (r111 == null) goto L29;
        r101 = r111.getMessage();
    L29:
        if (r101 != null) goto L31;
        r101 = "";
    L31:
        r113.put("error_msg", r101);
        Unit r115 = Unit.INSTANCE;
        r112.onReport("wallet_rd_gecko_update_event", r113);
        return;
    L25:
        r114 = null;
    L21:
        r104 = null;
        goto L22
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionSuccess(Map<String, List<android.util.Pair<String, Long>>> r210, Map<String, List<UpdatePackage>> r211) {
        super.onCheckServerVersionSuccess(r210, r211);
        IUpdateConfig r100 = this.f509054a;
        if (r100 == null) goto L40;
        List<String> r101 = r100.getChannelList();
        if (r101 == null) goto L40;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L25;
        Object r104 = r103.next();
        String r110 = (String) r104;
        if (r211 == null) goto L12;
        List<UpdatePackage> r111 = r211.get(this.f509054a.getAk());
    L13:
        if (r111 == null) goto L18;
        List<UpdatePackage> r112 = r111;
        List r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r114 = r112.iterator();
    L16:
        if (r114.hasNext() == false) goto L19;
        r113.add(((UpdatePackage) r114.next()).getChannel());
    L19:
        if (r113 != null) goto L21;
        r113 = CollectionsKt.emptyList();
    L21:
        Boolean r115 = Boolean.valueOf(r113.contains(r110));
        Object r116 = r102.get(r115);
        if (r116 != null) goto L24;
        r116 = new ArrayList();
        r102.put(r115, r116);
    L24:
        ((List) r116).add(r104);
        goto L8
    L18:
        r113 = null;
        goto L19
    L12:
        r111 = null;
        goto L13
    L25:
        c r105 = this.f509055b;
        Map<String, Object> r106 = a();
        r106.put("callback_name", "onCheckServerVersionSuccess");
        List r117 = (List) r102.get(Boolean.TRUE);
        if (r117 == null) goto L28;
        String r118 = CollectionsKt.joinToString$default(r117, null, null, null, 0, null, null, 63, null);
    L29:
        String r119 = "";
        if (r118 != null) goto L32;
        r118 = "";
    L32:
        r106.put("callback_channels", r118);
        List r107 = (List) r102.get(Boolean.FALSE);
        if (r107 == null) goto L35;
        String r108 = CollectionsKt.joinToString$default(r107, null, null, null, 0, null, null, 63, null);
    L36:
        if (r108 == null) goto L39;
        r119 = r108;
    L39:
        r106.put("callback_fail_channels", r119);
        Unit r109 = Unit.INSTANCE;
        r105.onReport("wallet_rd_gecko_update_event", r106);
        goto L40
    L35:
        r108 = null;
        goto L36
    L28:
        r118 = null;
    L40:
        IUpdateConfig r120 = this.f509054a;
        if (r120 == null) goto L80;
        List<String> r121 = r120.getChannelList();
        if (r121 == null) goto L81;
        ArrayList r122 = new ArrayList();
        Iterator<T> r123 = r121.iterator();
    L46:
        if (r123.hasNext() == false) goto L66;
        Object r124 = r123.next();
        String r125 = (String) r124;
        if (r211 == null) goto L50;
        List<UpdatePackage> r126 = r211.get(this.f509054a.getAk());
    L51:
        if (r126 == null) goto L60;
        Iterator<T> r127 = r126.iterator();
    L54:
        if (r127.hasNext() == false) goto L58;
        Object r128 = r127.next();
        if (Intrinsics.areEqual(((UpdatePackage) r128).getChannel(), r125) == false) goto L54;
    L59:
        UpdatePackage r129 = (UpdatePackage) r128;
    L61:
        if (r129 == null) goto L63;
        boolean r130 = true;
    L64:
        if (r130 == true) goto L46;
        r122.add(r124);
        goto L46
    L63:
        r130 = false;
        goto L64
    L58:
        r128 = null;
        goto L59
    L60:
        r129 = null;
        goto L61
    L50:
        r126 = null;
        goto L51
    L66:
        c r131 = this.f509055b;
        Map<String, Object> r132 = a();
        r132.put("callback_name", "onCheckServerVersionSuccess");
        r132.put("callback_channels", CollectionsKt.joinToString$default(r122, null, null, null, 0, null, null, 63, null));
        Unit r133 = Unit.INSTANCE;
        r131.onReport("wallet_rd_gecko_update_event", r132);
        return;
    L81:
        return;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onDownloadFail(UpdatePackage r100, Throwable r101) {
        super.onDownloadFail(r100, r101);
        c r102 = this.f509055b;
        Map<String, Object> r103 = a();
        r103.put("callback_name", "onDownloadFail");
        String r104 = null;
        if (r100 == null) goto L5;
        String r105 = r100.toString();
    L6:
        r103.put("update_package_info", r105);
        if (r101 == null) goto L9;
        r104 = r101.getMessage();
    L9:
        r103.put("error_msg", r104);
        Unit r106 = Unit.INSTANCE;
        r102.onReport("wallet_rd_gecko_update_event", r103);
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateFailed(UpdatePackage r100, Throwable r101) {
        super.onUpdateFailed(r100, r101);
        c r102 = this.f509055b;
        Map<String, Object> r103 = a();
        r103.put("callback_name", "onUpdateFailed");
        String r104 = null;
        if (r100 == null) goto L5;
        String r105 = r100.toString();
    L6:
        r103.put("update_package_info", r105);
        if (r101 == null) goto L9;
        r104 = r101.getMessage();
    L9:
        r103.put("error_msg", r104);
        Unit r106 = Unit.INSTANCE;
        r102.onReport("wallet_rd_gecko_update_event", r103);
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateSuccess(UpdatePackage r100, long r101) {
        super.onUpdateSuccess(r100, r101);
        c r102 = this.f509055b;
        Map<String, Object> r103 = a();
        r103.put("callback_name", "onUpdateSuccess");
        if (r100 == null) goto L5;
        String r104 = r100.toString();
    L6:
        r103.put("update_package_info", r104);
        r103.put("version", Long.valueOf(r101));
        Unit r105 = Unit.INSTANCE;
        r102.onReport("wallet_rd_gecko_update_event", r103);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckRequestIntercept(int r100, Map<String, List<android.util.Pair<String, Long>>> r101, Throwable r102) {
        super.onCheckRequestIntercept(r100, r101, r102);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onDownloadProgress(UpdatePackage r100, long r101, long r102) {
        super.onDownloadProgress(r100, r101, r102);
    }
}
