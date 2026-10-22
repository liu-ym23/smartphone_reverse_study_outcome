package com.bytedance.ee.drive.render;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.z5;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.drive.preview.DrivePreviewOpenRequest;
import com.bytedance.ee.drive.preview.DrivePreviewResType;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final a a = null;

    /* JADX INFO: renamed from: com.bytedance.ee.drive.render.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0206a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DrivePreviewResType.values().length];
            r0[DrivePreviewResType.LOCAL_FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DrivePreviewResType.SPACE_FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DrivePreviewResType.THIRD_PARTY_FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new a();
    }

    public a() {
    }

    public static String b(DrivePreviewOpenItem r5) {
        String r0 = r5.getFileExt();
        boolean r1 = false;
        String r3 = null;
        if (r0 != null) goto L5;
    L13:
        String r6 = r5.getTitle();
        if (r6 == null) goto L22;
        String r7 = StringsKt.substringAfterLast(r6, '.', "");
        if (r7 == null) goto L22;
        if (r7.length() <= 0) goto L20;
        r1 = true;
    L20:
        if (r1 == false) goto L22;
        r3 = r7;
    L22:
        if (r3 != null) goto L25;
        return "";
    L25:
        return r3;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        return r0;
    L7:
        r4 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static UserContainerDriveMainFragment a(Context r16, BearUrl r17, WikiInfo r18, bk5.a r19, UserSession r20) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "bearUrl");
        Intrinsics.checkNotNullParameter(r19, "container");
        if (r18 == null) goto L6;
        sbb.e r3 = sbb.e.d(r18.getObjType());
        if (r3 == null) goto L6;
    L7:
        boolean r5 = true;
        if (r3.b != 12) goto L10;
        boolean r4 = true;
    L11:
        String r8 = null;
        if (r4 == true) goto L16;
        r3 = null;
    L16:
        if (r3 != null) goto L23;
        StringBuilder r0 = new StringBuilder("createContainerFragment, type invalid, wikiInfoPresent=");
        if (r18 != null) goto L21;
        r5 = false;
    L21:
        r0.append(r5);
        r0.append(", bearType=");
        r0.append(r17.a);
        tt5.a.d("DriveContainerManager", r0.toString());
        return null;
    L23:
        final String r6 = r17.b;
        if (r6 != null) goto L26;
    L124:
        StringBuilder r1 = new StringBuilder("createContainerFragment, token is null or empty, wikiInfoPresent=");
        if (r18 == null) goto L127;
        boolean r7 = true;
    L128:
        r1.append(r7);
        r1.append(", bearType=");
        r1.append(r17.a);
        tt5.a.d("DriveContainerManager", r1.toString());
        return null;
    L127:
        r7 = false;
        goto L128
    L26:
        if (r6.length() <= 0) goto L28;
        boolean r10 = true;
    L29:
        if (r10 == true) goto L32;
        r6 = null;
    L32:
        if (r6 == null) goto L124;
        Bundle r2 = r19.h9();
        r2.setClassLoader(DrivePreviewOpenRequest.class.getClassLoader());
        Serializable r9 = r2.getSerializable(DrivePreviewOpenRequest.EXTRA_KEY);
        if ((r9 instanceof DrivePreviewOpenRequest) == false) goto L37;
        final DrivePreviewOpenRequest r11 = (DrivePreviewOpenRequest) r9;
    L39:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L42;
        if (r11 == null) goto L42;
        List<DrivePreviewOpenItem> r12 = r11.normalizedFileList();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L45:
        if (r14.hasNext() == false) goto L57;
        Object r110 = r14.next();
        DrivePreviewOpenItem r111 = (DrivePreviewOpenItem) r110;
        if (r111.getToken().length() <= 0) goto L49;
        boolean r112 = true;
    L50:
        if (r112 == true) goto L52;
    L54:
        boolean r113 = false;
    L55:
        if (r113 == false) goto L45;
        r13.add(r110);
        goto L45
    L52:
        if (r111.getObjType() != 12) goto L54;
        r113 = true;
        goto L55
    L49:
        r112 = false;
        goto L50
    L57:
        int r21 = f.a;
        DriveContainerManager$createOpenEntitiesFromRequest$result$1 r22 = DriveContainerManager$createOpenEntitiesFromRequest$result$1.INSTANCE;
        final Function1<DrivePreviewOpenItem, BaseOpenEntity> r23 = new DriveContainerManager$createOpenEntitiesFromRequest$result$2(r11);
        Function0<BaseOpenEntity> r114 = new DriveContainerManager$createOpenEntitiesFromRequest$result$3(r6);
        Intrinsics.checkNotNullParameter(r13, "fileList");
        Intrinsics.checkNotNullParameter(r6, "currentToken");
        Intrinsics.checkNotNullParameter(r22, "tokenResolver");
        Intrinsics.checkNotNullParameter(r23, "entityConverter");
        Intrinsics.checkNotNullParameter(r114, "fallbackEntity");
        Iterator r115 = r13.iterator();
    L59:
        if (r115.hasNext() == false) goto L63;
        final Object r116 = r115.next();
        if (Intrinsics.areEqual(r22.invoke(r116), r6) == false) goto L59;
    L64:
        if (r116 != null) goto L66;
        tt5.a.k("DriveOpenEntityListUtils", "filterSameCategoryEntities, can't find current item, just add token to open");
        f.a r24 = new f.a(CollectionsKt.arrayListOf(new BaseOpenEntity[]{r114.invoke()}), 0);
    L71:
        Pair r26 = new Pair(r24.a, Integer.valueOf(r24.b));
    L72:
        if (r26 == null) goto L74;
        ArrayList<? extends Parcelable> r27 = (ArrayList) r26.getFirst();
        int r28 = ((Number) r26.getSecond()).intValue();
    L75:
        Bundle r29 = new Bundle();
        if (r20 != null) goto L78;
        UserSession r117 = ContainerConstsKt.a();
    L79:
        PassportcConvention.h(r29, r117);
        r29.putParcelableArrayList("extra_drive_sdk_open_entity", r27);
        r29.putInt("extra_drive_sdk_open_index", r28);
        Bundle r118 = r19.h9();
        ConcurrentHashMap<String, j> r119 = x75.a.a;
        String r120 = r118.getString("drive_open_strategy_key");
        if (r120 == null) goto L82;
        j r121 = x75.a.a(r120);
    L83:
        com.bytedance.ee.drive.preview.f r122 = (com.bytedance.ee.drive.preview.f) org.koin.java.a.c(com.bytedance.ee.drive.preview.f.class, null, null, 6);
        o r123 = r122.l6();
        StringBuilder r124 = new StringBuilder("createContainerFragment, requestPresent=");
        if (r11 == null) goto L86;
        boolean r30 = true;
    L87:
        r124.append(r30);
        r124.append(", hasHostPluginProvider=");
        if (r123 == null) goto L90;
        boolean r31 = true;
    L91:
        r124.append(r31);
        r124.append(", hasInputStrategy=");
        if (r121 == null) goto L94;
        boolean r32 = true;
    L95:
        r124.append(r32);
        tt5.a.h("DriveContainerManager", r124.toString());
        if (r121 != null) goto L98;
        j r33 = r122.U4(r16);
    L99:
        if (r123 == null) goto L102;
        r33 = new d(r33, r123);
    L102:
        k r34 = r33.b();
        k.a r36 = r34.getContainer();
        if (r36 != null) goto L105;
    L107:
        boolean r37 = false;
    L108:
        if (r37 == false) goto L110;
        r19.x();
    L110:
        r33.d().c(i.class, new b(r19));
        r33.d().c(l.class, new c(r34));
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L113;
        r33.d().c(z5.class, new h(r19));
    L113:
        if (r120 == null) goto L121;
        if (r121 == null) goto L117;
        if (r123 != null) goto L117;
        boolean r38 = true;
    L118:
        if (r38 == false) goto L120;
        r8 = r120;
    L120:
        if (r8 == null) goto L121;
    L122:
        r29.putString("drive_open_strategy_key", r8);
        UserContainerDriveMainFragment r39 = new UserContainerDriveMainFragment();
        r39.setArguments(r29);
        tt5.a.h("DriveContainerManager", "createContainerFragment, openEntityCount=" + r27.size() + ", openIndex=" + r28 + ", fragment=" + r39);
        return r39;
    L117:
        r38 = false;
    L121:
        r8 = x75.a.b(r33);
        goto L122
    L105:
        if (r36.a == true) goto L107;
        r37 = true;
        goto L108
    L98:
        r33 = r121;
        goto L99
    L94:
        r32 = false;
        goto L95
    L90:
        r31 = false;
        goto L91
    L86:
        r30 = false;
        goto L87
    L82:
        r121 = null;
        goto L83
    L78:
        r117 = r20;
        goto L79
    L74:
        r27 = CollectionsKt.arrayListOf(new BaseOpenEntity[]{new SpaceFileOpenEntity(r6, "")});
        r28 = 0;
        goto L75
    L66:
        int r125 = g.a;
        g.a r40 = g.a(r13, r6, r22, new DriveOpenEntityListUtils$filterSameCategoryEntities$result$1(r23), new DriveOpenEntityListUtils$filterSameCategoryEntities$result$2(r116));
        AbstractCollection r126 = r40.a;
        ArrayList r127 = new ArrayList(r40.a.size());
        Iterator r128 = r126.iterator();
    L68:
        if (r128.hasNext() == false) goto L70;
        r127.add(r23.invoke(r128.next()));
        goto L68
    L70:
        r24 = new f.a(r127, r40.b);
        goto L71
    L63:
        r116 = null;
    L42:
        r26 = null;
        goto L72
    L37:
        r11 = null;
        goto L39
    L28:
        r10 = false;
        goto L29
    L10:
        r4 = false;
    L6:
        r3 = sbb.e.e(r17.a);
        goto L7
    }
}
