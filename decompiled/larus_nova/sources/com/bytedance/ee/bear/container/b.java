package com.bytedance.ee.bear.container;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.b4;
import com.bytedance.ee.bear.document.container.DocumentImpl;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements bk5.b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // bk5.b
    public final boolean b(BearUrl r100, bk5.e r101, bk5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bearUrl");
        Intrinsics.checkNotNullParameter(r101, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        return true;
    }

    public final String toString() {
        return "BizContainerInitNode";
    }

    public static void c(bk5.a r100) {
        tt5.a.h("BizContainerInitNode", r100.getTAG() + ", loadError");
        Bundle r101 = r100.h9();
        if (r101 == null) goto L5;
        String r102 = r101.getString("plugin_host_callback_key");
    L6:
        ConcurrentHashMap<String, hk5.a> r103 = hk5.b.f485570a;
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r102, "key");
        hk5.a r104 = hk5.b.f485570a.remove(r102);
        if (r104 == null) goto L13;
        r104.onOpenFailedBeforeHost();
    L13:
        r100.terminate();
        return;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bk5.b
    public final Object a(BearUrl r110, bk5.e r111, bk5.a r112, Continuation<? super bk5.e> r210) {
        Activity r100 = r112.getActivity();
        if (r100 != null) goto L6;
        tt5.a.h("BizContainerInitNode", r112.getTAG() + ", activity is null");
        c(r112);
        return r111;
    L6:
        Serializable r101 = r112.h9().getSerializable("wiki_info");
        Map<String, String> r102 = null;
        if ((r101 instanceof WikiInfo) == false) goto L9;
        WikiInfo r103 = (WikiInfo) r101;
    L12:
        tt5.a.h("BizContainerInitNode", r112.getTAG() + ", wikiInfo " + r103 + ", loaderTypeBefore = " + r111);
        boolean r104 = false;
        if (Intrinsics.areEqual(r111, bk5.e.b.f19366b) == false) goto L46;
        if (r103 == null) goto L17;
        sbb.e r105 = sbb.e.d(r103.getObjType());
        if (r105 == null) goto L17;
    L18:
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L24;
        Map<sbb.e, v4> r113 = b4.f219150a;
        Intrinsics.checkNotNull(r105);
        Intrinsics.checkNotNullParameter(r105, "documentType");
        if (b4.f219150a.containsKey(r105) == true) goto L24;
        tt5.a.k("BizContainerInitNode", r112.getTAG() + ", unsupported OfficeSDK document type: " + r105);
        c(r112);
        return r111;
    L24:
        Bundle r106 = new Bundle(r112.h9());
        r106.putString("url", r110.f222564e);
        if (r103 == null) goto L32;
        if (r103.getInSpace() == false) goto L29;
        Serializable r107 = null;
    L30:
        r106.putSerializable("wiki_info", r107);
        goto L32
    L29:
        r107 = r103;
    L32:
        if (CCMOfficeSDKAssembleFG.a() == false) goto L34;
        WindowInsetsUtils.b(r112.getFragment()).o(true);
        WindowInsetsUtils.b(r112.getFragment()).c(true);
    L34:
        int r108 = DocumentImpl.f219393a;
        UserSession r109 = r112.e9();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "bearUrl");
        Intrinsics.checkNotNullParameter(r112, KtvSubElement.CONTAINER);
        Log.i("OfficeDocumentImpl", "==openDocs==render== createDocumentFragment start");
        if (r103 == null) goto L37;
        sbb.e r114 = sbb.e.d(r103.getObjType());
    L38:
        Map<sbb.e, v4> r115 = b4.f219150a;
        Intrinsics.checkNotNull(r114);
        v4 r116 = b4.a(r114);
        Intrinsics.checkNotNullParameter(r112, KtvSubElement.CONTAINER);
        ArrayList r117 = CollectionsKt.arrayListOf(new com.bytedance.ee.bear.browser.plugin.i[]{new com.bytedance.ee.bear.document.container.e(r112), new com.bytedance.ee.bear.document.container.f(r112)});
        Chameleon r118 = Chameleon.f411115a;
        Fragment r119 = Chameleon.a(r100, DocumentImpl.a(r116, r109, r117), null);
        Log.i("OfficeDocumentImpl", "==openDocs==render== createDocumentFragment end, fragment: " + r119.hashCode());
        if (r119.getArguments() != null) goto L41;
        r119.setArguments(new Bundle());
    L41:
        Bundle r120 = r119.getArguments();
        if (r120 == null) goto L44;
        r120.putAll(r106);
    L44:
        r112.f9(r119);
    L95:
        return r111;
    L37:
        r114 = sbb.e.e(r110.f222560a);
    L17:
        r105 = sbb.e.e(r110.f222560a);
        goto L18
    L46:
        if (Intrinsics.areEqual(r111, bk5.e.c.f19367b) == true) goto L48;
        c(r112);
        goto L95
    L48:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L50;
        WindowInsetsUtils.c(r100).o(false);
        WindowInsetsUtils.b(r112.getFragment()).o(true);
        WindowInsetsUtils.b(r112.getFragment()).c(true);
    L50:
        Bundle r121 = r112.h9();
        Bundle r122 = new Bundle(r121);
        if (r103 != null) goto L53;
    L57:
        if (r103 != null) goto L59;
    L61:
        boolean r123 = false;
    L62:
        if (r123 == false) goto L78;
        BearUrl r124 = s45.p.a().Z(s45.p.a().Le(r103.getObjTypeString(), r103.getObjToken(), r110.f222563d));
        SpaceFileOpenEntity r125 = new SpaceFileOpenEntity(r124.f222561b, "");
        r125.setUrl(r124.f222564e);
        r125.setOriginUrl(r121.getString("url"));
        r125.setAppId(BDLocationException.ERROR_SHAKE_UPLOAD);
        r125.setPreviewFrom("wiki");
        r125.setMountPoint("wiki");
        Map<String, String> r126 = r110.f222563d;
        if (r126 == null) goto L67;
        String r127 = r126.get("docId");
    L68:
        r125.setFeedId(r127);
        r125.setReminderBinder(r121.getBundle("remind_binder"));
        r125.setWikiUrl(s45.p.a().Le(sbb.e.f541303n.getType(), r103.getWikiToken(), r110.f222563d));
        Serializable r128 = r121.getSerializable("extra_data_map");
        boolean r129 = r128 instanceof Map;
        if (r129 == false) goto L75;
        if (r129 == false) goto L72;
        r102 = (Map) r128;
    L72:
        if (r102 == null) goto L75;
        r125.setExtra(r102);
    L75:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.watermark.filewatermark.remaining") == false) goto L77;
        r125.setBizScene(DriveBizScene.DriveBizScene_CCM);
        r125.setWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD);
    L77:
        r102 = r125;
        goto L78
    L67:
        r127 = null;
    L78:
        if (r102 == null) goto L80;
        r122.putParcelableArrayList("extra_drive_sdk_open_entity", CollectionsKt.arrayListOf(new BaseOpenEntity[]{r102}));
        r122.putInt("extra_drive_sdk_open_index", 0);
    L80:
        com.bytedance.ee.drive.render.a r130 = com.bytedance.ee.drive.render.a.f242723a;
        UserSession r131 = r112.e9();
        r130.getClass();
        Fragment r132 = com.bytedance.ee.drive.render.a.a(r100, r110, r103, r112, r131);
        if (r132 == null) goto L93;
        Bundle r133 = r132.getArguments();
        if (r133 != null) goto L85;
        r133 = new Bundle();
        r132.setArguments(r133);
    L85:
        ConcurrentHashMap<String, com.bytedance.ee.drive.render.j> r134 = x75.a.f562822a;
        String r135 = r133.getString("drive_open_strategy_key");
        r133.putAll(r122);
        if (r135 != null) goto L88;
    L89:
        r104 = true;
    L90:
        if (r104 == true) goto L92;
        r133.putString("drive_open_strategy_key", r135);
    L92:
        tt5.a.h("BizContainerInitNode", "run - DRIVE, addBizFragment: " + r132);
        r112.f9(r132);
        goto L95
    L88:
        if (r135.length() != 0) goto L90;
    L93:
        tt5.a.d("BizContainerInitNode", "run - DRIVE, fragment is null.");
        c(r112);
        goto L95
    L59:
        if (r103.getObjType() != 12) goto L61;
        r123 = true;
        goto L62
    L53:
        if (r103.getInSpace() == false) goto L55;
        Serializable r136 = null;
    L56:
        r122.putSerializable("wiki_info", r136);
        goto L57
    L55:
        r136 = r103;
        goto L56
    L9:
        if (r101 == null) goto L11;
        tt5.a.k("BizContainerInitNode", r112.getTAG() + ", wiki info argument type invalid: " + r101.getClass().getName());
    L11:
        r103 = null;
        goto L12
    }
}
