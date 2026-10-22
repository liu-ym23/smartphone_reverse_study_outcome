package com.bytedance.ee.bear.office.list;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.office.export.space.OfficeFolderActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeFolderListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeFolderPagePayload;
import com.bytedance.ee.bear.office.export.space.OfficeFolderPageRequest;
import com.bytedance.ee.bear.office.export.space.OfficeFolderSource;
import com.bytedance.ee.bear.office.export.space.OfficeListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeListDisplayMode;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import uc5.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final e a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeFolderActionResult.values().length];
            r0[OfficeFolderActionResult.Handled.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[OfficeFolderActionResult.Rejected.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[OfficeFolderActionResult.NotHandled.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new e();
    }

    public e() {
    }

    @JvmStatic
    public static final boolean b(Fragment r9, Document r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "host");
        Intrinsics.checkNotNullParameter(r10, "document");
        Intrinsics.checkNotNullParameter(r11, "currentModule");
        Context r0 = r9.getContext();
        if (r0 != null) goto L5;
        return false;
    L5:
        e r2 = a;
        Bundle r3 = r9.getArguments();
        r2.getClass();
        OfficeFolderPageRequest r4 = a(r3, r10, r11, r0);
        Bundle r5 = r9.getArguments();
        if (r5 == null) goto L8;
        String r6 = r5.getString("office_list_runtime_id");
    L9:
        com.bytedance.ee.bear.office.export.space.h r7 = com.bytedance.ee.bear.office.export.space.m.a(r6);
        if ((r7 instanceof com.bytedance.ee.bear.office.export.space.c) == false) goto L12;
        com.bytedance.ee.bear.office.export.space.c r8 = (com.bytedance.ee.bear.office.export.space.c) r7;
    L13:
        if (r8 == null) goto L16;
        OfficeFolderActionResult r12 = r8.j1(r4);
        if (r12 == null) goto L16;
    L17:
        int r13 = a.a[r12.ordinal()];
        if (r13 != 1) goto L20;
    L66:
        return true;
    L20:
        if (r13 != 2) goto L22;
        tt5.a.h("OfficeFolderNavigator", "folder root navigation rejected, tokenHash=" + r4.getFolderToken().hashCode());
        goto L66
    L22:
        if (r13 != 3) goto L64;
        tt5.a.k("OfficeFolderNavigator", "folder root navigation not handled. tokenHash=" + r4.getFolderToken().hashCode());
        if (r4.getPayload().getListConfig().getDisableInternalFolderFallback() == false) goto L27;
        tt5.a.d("OfficeFolderNavigator", "folder root navigation not handled and internal fallback disabled. tokenHash=" + r4.getFolderToken().hashCode() + ", host=" + r9.getClass().getSimpleName());
        return true;
    L27:
        Bundle r14 = r9.getArguments();
        int r15 = com.bytedance.ee.bear.office.list.a.a;
        Bundle r16 = com.bytedance.ee.bear.office.list.a.a(a(r14, r10, r11, r0), null, false);
        if (r14 == null) goto L39;
        Object r17 = r14.get("office_list_tab");
        if ((r17 instanceof Serializable) == false) goto L33;
        r16.putSerializable("office_list_tab", (Serializable) r17);
    L33:
        Object r18 = r14.get("office_list_config");
        if ((r18 instanceof Serializable) == false) goto L36;
        r16.putSerializable("office_list_config", (Serializable) r18);
    L36:
        String r1 = r14.getString("office_list_runtime_id");
        if (TextUtils.isEmpty(r1) == true) goto L39;
        r16.putString("office_list_runtime_id", r1);
    L39:
        tt5.a.k("OfficeFolderNavigator", "open folder activity factory missing, fallback to office fragment host. host=".concat(r9.getClass().getSimpleName()));
        uc5.k r19 = d1.a(r9);
        if (r19 != null) goto L42;
        tt5.a.k("OfficeFolderNavigator", "skip open folder fallback because current fragment is not in office folder host tree. host=" + r9);
        return false;
    L42:
        int r20 = r19.mc();
        if (r20 == (-1)) goto L61;
        if (r20 == 0) goto L61;
        int r21 = OfficeFolderDetailHostFragment.t;
        Intrinsics.checkNotNullParameter(r16, "args");
        OfficeFolderDetailHostFragment r22 = new OfficeFolderDetailHostFragment();
        r22.setArguments(new Bundle(r16));
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L52
        FragmentTransaction r111 = r19.lf().beginTransaction();     // Catch: Throwable -> L52
        r111.setReorderingAllowed(true);     // Catch: Throwable -> L52
        String r23 = "office_folder_detail_host_" + d1.d(r10);     // Catch: Throwable -> L52
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r111, r22, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r23, r20) == true) goto L50;
        r111.replace(r20, r22, r23);     // Catch: Throwable -> L52
    L50:
        r111.addToBackStack("office_folder_detail_host_" + d1.d(r10));     // Catch: Throwable -> L52
        r111.commit();     // Catch: Throwable -> L52
        Object r24 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L52
    L54:
        Throwable r112 = Result.exceptionOrNull-impl(r24);
        if (r112 == null) goto L57;
        tt5.a.e("OfficeFolderNavigator", "open office folder fallback host failed", r112, false);
    L57:
        Boolean r113 = Boolean.FALSE;
        if (Result.isFailure-impl(r24) == false) goto L70;
        r24 = r113;
    L70:
        return ((Boolean) r24).booleanValue();
    L52:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
    L61:
        tt5.a.k("OfficeFolderNavigator", "skip open folder fallback because office host container id is invalid. host=" + r9);
        return false;
    L64:
        throw new NoWhenBranchMatchedException();
    L16:
        r12 = OfficeFolderActionResult.NotHandled;
        goto L17
    L12:
        r8 = null;
        goto L13
    L8:
        r6 = null;
        goto L9
    }

    public static OfficeFolderPageRequest a(Bundle r22, Document r23, String r24, Context r25) {
        Intrinsics.checkNotNullParameter(r23, "document");
        Intrinsics.checkNotNullParameter(r24, "currentModule");
        Intrinsics.checkNotNullParameter(r25, "context");
        OfficeListConfig r3 = null;
        if (r22 == null) goto L5;
        Serializable r4 = r22.getSerializable("office_list_tab");
    L7:
        if ((r4 instanceof OfficeSpaceTab) == false) goto L9;
        OfficeSpaceTab r13 = (OfficeSpaceTab) r4;
    L10:
        if (r22 == null) goto L12;
        Serializable r5 = r22.getSerializable("office_list_config");
    L14:
        if ((r5 instanceof OfficeListConfig) == false) goto L16;
        r3 = (OfficeListConfig) r5;
    L16:
        String r16 = d1.d(r23);
        String r2 = t0.g(r25, r23);
        boolean r6 = false;
        if (r22 != null) goto L19;
        int r7 = 0;
    L20:
        int r17 = r7 + 1;
        if (r13 == null) goto L24;
        OfficeFolderSource r8 = b.a(r13);
        if (r8 == null) goto L24;
    L25:
        OfficeFolderSource r18 = r8;
        String r19 = "folder_" + System.currentTimeMillis();
        Integer r9 = Integer.valueOf(r23.L1);
        int r10 = r23.U;
        if (r10 > 0) goto L38;
        if (r22 == null) goto L30;
        r10 = r22.getInt("permission", 0);
    L31:
        if (r10 > 0) goto L38;
        if (r13 != OfficeSpaceTab.MINE) goto L36;
        r10 = 2;
        goto L38
    L36:
        r10 = 0;
        goto L38
    L30:
        r10 = 0;
    L38:
        if (r22 != null) goto L40;
        String r0 = "";
    L41:
        String r11 = r23.m;
        String r12 = String.valueOf(r23.getType());
        boolean r14 = r23.x;
        int r15 = r23.L1;
        boolean r1 = r23.P1;
        FolderVersion.a r110 = FolderVersion.Companion;
        Integer r21 = Integer.valueOf(r15);
        r110.getClass();
        if (FolderVersion.a.c(r21) == false) goto L45;
        if (r1 == false) goto L46;
    L47:
        boolean r111 = false;
    L49:
        if (r3 == null) goto L52;
        OfficeListDisplayMode r20 = r3.getDisplayMode();
        if (r20 == null) goto L52;
    L53:
        if (r3 == null) goto L55;
        boolean r26 = r3.getEnableMultiSelect();
    L56:
        if (r3 == null) goto L59;
        r6 = r3.getDisableInternalFolderFallback();
    L59:
        return new OfficeFolderPageRequest(r16, r2, r17, r18, r19, new OfficeFolderPagePayload(r9, r10, r0, r11, r24, r12, r14, r111, r13, new OfficeFolderListConfig(r20, r26, r6)));
    L55:
        r26 = false;
    L52:
        r20 = OfficeListDisplayMode.FLOW;
    L46:
        r111 = true;
        goto L49
    L45:
        if (r15 != 0) goto L47;
    L40:
        r0 = r22.getString(ResourceData.KEY_TOKEN, "");
    L24:
        r8 = OfficeFolderSource.FOLDER_CHILD;
        goto L25
    L19:
        r7 = r22.getInt("depth", 0);
        goto L20
    L12:
        r5 = null;
        goto L14
    L9:
        r13 = null;
        goto L10
    L5:
        r4 = null;
        goto L7
    }
}
