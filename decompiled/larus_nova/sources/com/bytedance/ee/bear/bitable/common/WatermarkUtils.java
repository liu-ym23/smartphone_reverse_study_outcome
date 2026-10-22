package com.bytedance.ee.bear.bitable.common;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class WatermarkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f209802a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/WatermarkUtils$AddWaterMarkStatus;", "", "<init>", "(Ljava/lang/String;I)V", "STATUS_SUCCESS_WITH_SRC_OBJ", "STATUS_SUCCESS_WITH_SRC_OBJ_INVALID", "STATUS_SUCCESS_WITH_EMPTY_SRC_OBJ", "STATUS_FAIL_WITH_EMPTY_VIEW", "STATUS_FAIL_WITH_EMPTY_DIALOG", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AddWaterMarkStatus extends Enum<AddWaterMarkStatus> {
        public static final AddWaterMarkStatus STATUS_FAIL_WITH_EMPTY_DIALOG = null;
        public static final AddWaterMarkStatus STATUS_FAIL_WITH_EMPTY_VIEW = null;
        public static final AddWaterMarkStatus STATUS_SUCCESS_WITH_EMPTY_SRC_OBJ = null;
        public static final AddWaterMarkStatus STATUS_SUCCESS_WITH_SRC_OBJ = null;
        public static final AddWaterMarkStatus STATUS_SUCCESS_WITH_SRC_OBJ_INVALID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AddWaterMarkStatus[] f209803a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f209804b = null;

        public static EnumEntries<AddWaterMarkStatus> getEntries() {
            return f209804b;
        }

        static {
            AddWaterMarkStatus r100 = new AddWaterMarkStatus("STATUS_SUCCESS_WITH_SRC_OBJ", 0);
            STATUS_SUCCESS_WITH_SRC_OBJ = r100;
            AddWaterMarkStatus r101 = new AddWaterMarkStatus("STATUS_SUCCESS_WITH_SRC_OBJ_INVALID", 1);
            STATUS_SUCCESS_WITH_SRC_OBJ_INVALID = r101;
            AddWaterMarkStatus r102 = new AddWaterMarkStatus("STATUS_SUCCESS_WITH_EMPTY_SRC_OBJ", 2);
            STATUS_SUCCESS_WITH_EMPTY_SRC_OBJ = r102;
            AddWaterMarkStatus r103 = new AddWaterMarkStatus("STATUS_FAIL_WITH_EMPTY_VIEW", 3);
            STATUS_FAIL_WITH_EMPTY_VIEW = r103;
            AddWaterMarkStatus r104 = new AddWaterMarkStatus("STATUS_FAIL_WITH_EMPTY_DIALOG", 4);
            STATUS_FAIL_WITH_EMPTY_DIALOG = r104;
            AddWaterMarkStatus[] r105 = {r100, r101, r102, r103, r104};
            f209803a = r105;
            f209804b = EnumEntriesKt.enumEntries(r105);
        }

        public static AddWaterMarkStatus[] values() {
            return (AddWaterMarkStatus[]) f209803a.clone();
        }

        public static AddWaterMarkStatus valueOf(String r100) {
            return (AddWaterMarkStatus) r27.a.a(AddWaterMarkStatus.class, r100);
        }

        public AddWaterMarkStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }

    public static AddWaterMarkStatus a(mr4.a r100, Dialog r101) {
        if (r101 != null) goto L4;
        tt5.a.k("WatermarkUtils", "can not add watermark for empty dialog");
        return AddWaterMarkStatus.STATUS_FAIL_WITH_EMPTY_DIALOG;
    L4:
        if (r100 == null) goto L29;
        String r102 = r100.f514980a;
        Integer r103 = r100.f514981b;
        if (TextUtils.isEmpty(r102) == true) goto L27;
        if (r103 == null) goto L27;
        Window r104 = r101.getWindow();
        if (r104 == null) goto L15;
        View r105 = r104.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L17;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r106 = ThreadMethodProxy.currentThread();
        if (r106 == com.larus.home.impl.utils.c.f346341a) goto L17;
        com.larus.home.impl.utils.c.a(r106, "getDecorView");
    L17:
        if ((r105 instanceof FrameLayout) == false) goto L19;
        FrameLayout r107 = (FrameLayout) r105;
    L20:
        if (r107 == null) goto L26;
        if (r102 == null) goto L24;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).l(r102, r103.intValue(), r107);
    L24:
        return AddWaterMarkStatus.STATUS_SUCCESS_WITH_SRC_OBJ;
    L26:
        return AddWaterMarkStatus.STATUS_FAIL_WITH_EMPTY_VIEW;
    L19:
        r107 = null;
        goto L20
    L15:
        r105 = null;
    L27:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(r101);
        return AddWaterMarkStatus.STATUS_SUCCESS_WITH_SRC_OBJ_INVALID;
    L29:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(r101);
        return AddWaterMarkStatus.STATUS_SUCCESS_WITH_EMPTY_SRC_OBJ;
    }

    public static void b(mr4.a r100, FrameLayout r101) {
        if (r101 == null) goto L13;
        if (r100 == null) goto L11;
        String r102 = r100.f514980a;
        Integer r103 = r100.f514981b;
        if (r102 == null) goto L9;
        if (r103 == null) goto L9;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).l(r102, r103.intValue(), r101);
        AddWaterMarkStatus r104 = AddWaterMarkStatus.STATUS_SUCCESS_WITH_SRC_OBJ;
        return;
    L9:
        AddWaterMarkStatus r105 = AddWaterMarkStatus.STATUS_SUCCESS_WITH_SRC_OBJ;
        return;
    L11:
        AddWaterMarkStatus r106 = AddWaterMarkStatus.STATUS_SUCCESS_WITH_SRC_OBJ;
        return;
    L13:
        tt5.a.k("WatermarkUtils", "can not add watermark for empty framelayout");
        AddWaterMarkStatus r107 = AddWaterMarkStatus.STATUS_SUCCESS_WITH_SRC_OBJ;
    }
}
