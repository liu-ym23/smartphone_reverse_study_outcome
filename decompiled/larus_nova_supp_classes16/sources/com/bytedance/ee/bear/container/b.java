package com.bytedance.ee.bear.container;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.b4;
import com.bytedance.ee.bear.document.container.DocumentImpl;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.entity.UserSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements bk5.b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final boolean b(BearUrl r2, bk5.e r3, bk5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        Intrinsics.checkNotNullParameter(r3, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r4, "container");
        return true;
    }

    public final String toString() {
        return "BizContainerInitNode";
    }

    public static void c(bk5.a r2) {
        tt5.a.h("BizContainerInitNode", r2.getTAG() + ", loadError");
        Bundle r0 = r2.h9();
        if (r0 == null) goto L5;
        String r1 = r0.getString("plugin_host_callback_key");
    L6:
        ConcurrentHashMap r3 = hk5.b.a;
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r1, "key");
        hk5.a r4 = (hk5.a) hk5.b.a.remove(r1);
        if (r4 == null) goto L13;
        r4.onOpenFailedBeforeHost();
    L13:
        r2.terminate();
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(BearUrl r17, bk5.e r18, bk5.a r19, Continuation<? super bk5.e> r20) {
        Activity r3 = r19.getActivity();
        if (r3 != null) goto L6;
        tt5.a.h("BizContainerInitNode", r19.getTAG() + ", activity is null");
        c(r19);
        return r18;
    L6:
        Serializable r5 = r19.h9().getSerializable("wiki_info");
        Map<String, String> r8 = null;
        if ((r5 instanceof WikiInfo) == false) goto L9;
        WikiInfo r6 = (WikiInfo) r5;
    L12:
        tt5.a.h("BizContainerInitNode", r19.getTAG() + ", wikiInfo " + r6 + ", loaderTypeBefore = " + r18);
        boolean r9 = false;
        if (Intrinsics.areEqual(r18, bk5.e.b.b) == false) goto L46;
        if (r6 == null) goto L17;
        sbb.e r7 = sbb.e.d(r6.getObjType());
        if (r7 == null) goto L17;
    L18:
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L24;
        Map<sbb.e, v4> r12 = b4.a;
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNullParameter(r7, "documentType");
        if (b4.a.containsKey(r7) == true) goto L24;
        tt5.a.k("BizContainerInitNode", r19.getTAG() + ", unsupported OfficeSDK document type: " + r7);
        c(r19);
        return r18;
    L24:
        Bundle r10 = new Bundle(r19.h9());
        r10.putString("url", r17.e);
        if (r6 == null) goto L32;
        if (r6.getInSpace() == false) goto L29;
        WikiInfo r4 = null;
    L30:
        r10.putSerializable("wiki_info", r4);
        goto L32
    L29:
        r4 = r6;
    L32:
        if (CCMOfficeSDKAssembleFG.a() == false) goto L34;
        WindowInsetsUtils.b(r19.getFragment()).o(true);
        WindowInsetsUtils.b(r19.getFragment()).c(true);
    L34:
        int r11 = DocumentImpl.a;
        UserSession r13 = r19.e9();
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r17, "bearUrl");
        Intrinsics.checkNotNullParameter(r19, "container");
        Log.i("OfficeDocumentImpl", "==openDocs==render== createDocumentFragment start");
        if (r6 == null) goto L37;
        sbb.e r0 = sbb.e.d(r6.getObjType());
    L38:
        Map<sbb.e, v4> r14 = b4.a;
        Intrinsics.checkNotNull(r0);
        v4 r1 = b4.a(r0);
        Intrinsics.checkNotNullParameter(r19, "container");
        ArrayList r16 = CollectionsKt.arrayListOf(new com.bytedance.ee.bear.browser.plugin.i[]{new com.bytedance.ee.bear.document.container.e(r19), new com.bytedance.ee.bear.document.container.f(r19)});
        Chameleon r21 = Chameleon.a;
        Fragment r2 = Chameleon.a(r3, DocumentImpl.a(r1, r13, r16), null);
        Log.i("OfficeDocumentImpl", "==openDocs==render== createDocumentFragment end, fragment: " + r2.hashCode());
        if (r2.getArguments() != null) goto L41;
        r2.setArguments(new Bundle());
    L41:
        Bundle r22 = r2.getArguments();
        if (r22 == null) goto L44;
        r22.putAll(r10);
    L44:
        r19.f9(r2);
    L95:
        return r18;
    L37:
        r0 = sbb.e.e(r17.a);
    L17:
        r7 = sbb.e.e(r17.a);
        goto L18
    L46:
        if (Intrinsics.areEqual(r18, bk5.e.c.b) == true) goto L48;
        c(r19);
        goto L95
    L48:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L50;
        WindowInsetsUtils.c(r3).o(false);
        WindowInsetsUtils.b(r19.getFragment()).o(true);
        WindowInsetsUtils.b(r19.getFragment()).c(true);
    L50:
        Bundle r23 = r19.h9();
        Bundle r110 = new Bundle(r23);
        if (r6 != null) goto L53;
    L57:
        if (r6 != null) goto L59;
    L61:
        boolean r24 = false;
    L62:
        if (r24 == false) goto L78;
        BearUrl r26 = s45.p.a().Z(s45.p.a().Le(r6.getObjTypeString(), r6.getObjToken(), r17.d));
        SpaceFileOpenEntity r111 = new SpaceFileOpenEntity(r26.b, "");
        r111.setUrl(r26.e);
        r111.setOriginUrl(r23.getString("url"));
        r111.setAppId("56");
        r111.setPreviewFrom(FileInfoPuller.CALLER_WIKI);
        r111.setMountPoint(FileInfoPuller.CALLER_WIKI);
        Map<String, String> r27 = r17.d;
        if (r27 == null) goto L67;
        String r28 = r27.get("docId");
    L68:
        r111.setFeedId(r28);
        r111.setReminderBinder(r23.getBundle("remind_binder"));
        r111.setWikiUrl(s45.p.a().Le(sbb.e.n.getType(), r6.getWikiToken(), r17.d));
        Serializable r29 = r23.getSerializable("extra_data_map");
        boolean r30 = r29 instanceof Map;
        if (r30 == false) goto L75;
        if (r30 == false) goto L72;
        r8 = (Map) r29;
    L72:
        if (r8 == null) goto L75;
        r111.setExtra(r8);
    L75:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.watermark.filewatermark.remaining") == false) goto L77;
        r111.setBizScene(DriveBizScene.DriveBizScene_CCM);
        r111.setWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD);
    L77:
        r8 = r111;
        goto L78
    L67:
        r28 = null;
    L78:
        if (r8 == null) goto L80;
        r110.putParcelableArrayList("extra_drive_sdk_open_entity", CollectionsKt.arrayListOf(new BaseOpenEntity[]{r8}));
        r110.putInt("extra_drive_sdk_open_index", 0);
    L80:
        com.bytedance.ee.drive.render.a r31 = com.bytedance.ee.drive.render.a.a;
        UserSession r32 = r19.e9();
        r31.getClass();
        UserContainerDriveMainFragment r33 = com.bytedance.ee.drive.render.a.a(r3, r17, r6, r19, r32);
        if (r33 == null) goto L93;
        Bundle r34 = r33.getArguments();
        if (r34 != null) goto L85;
        r34 = new Bundle();
        r33.setArguments(r34);
    L85:
        ConcurrentHashMap<String, com.bytedance.ee.drive.render.j> r36 = x75.a.a;
        String r37 = r34.getString("drive_open_strategy_key");
        r34.putAll(r110);
        if (r37 != null) goto L88;
    L89:
        r9 = true;
    L90:
        if (r9 == true) goto L92;
        r34.putString("drive_open_strategy_key", r37);
    L92:
        tt5.a.h("BizContainerInitNode", "run - DRIVE, addBizFragment: " + r33);
        r19.f9(r33);
        goto L95
    L88:
        if (r37.length() != 0) goto L90;
    L93:
        tt5.a.d("BizContainerInitNode", "run - DRIVE, fragment is null.");
        c(r19);
        goto L95
    L59:
        if (r6.getObjType() != 12) goto L61;
        r24 = true;
        goto L62
    L53:
        if (r6.getInSpace() == false) goto L55;
        WikiInfo r112 = null;
    L56:
        r110.putSerializable("wiki_info", r112);
        goto L57
    L55:
        r112 = r6;
        goto L56
    L9:
        if (r5 == null) goto L11;
        tt5.a.k("BizContainerInitNode", r19.getTAG() + ", wiki info argument type invalid: " + r5.getClass().getName());
    L11:
        r6 = null;
        goto L12
    }
}
