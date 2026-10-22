package com.bytedance.ee.bear.office.list.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public static boolean b(Fragment r1) {
        if (r1.isAdded() == true) goto L5;
    L9:
        return false;
    L5:
        if (r1.getView() == null) goto L9;
        if (r1.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L9;
        return true;
    }

    public static boolean a(OfficeSpaceTab r3, com.bytedance.ee.bear.office.list.i r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "tab");
        Intrinsics.checkNotNullParameter(r4, "capability");
        Fragment r6 = r4.a();
        if (r6 != null) goto L5;
        return false;
    L5:
        if (r5 == false) goto L16;
        Bundle r1 = r6.getArguments();
        if (r1 == null) goto L9;
        String r2 = r1.getString(ResourceData.KEY_TOKEN);
    L10:
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        if (StringsKt.isBlank(r2) == false) goto L16;
        return false;
    L9:
        r2 = null;
    L16:
        if (r5 == false) goto L26;
        Bundle r7 = r6.getArguments();
        if (r7 != null) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == true) goto L26;
        return false;
    L20:
        if (r7.getInt("permission", 0) != 2) goto L22;
        r8 = true;
    L26:
        if (r6.getActivity() == null) goto L38;
        com.bytedance.ee.bear.office.list.m r9 = r4.g;
        if (r9 == null) goto L34;
        Function0<Boolean> r10 = r9.f;
        if (r10 == null) goto L34;
        if (((Boolean) r10.invoke()).booleanValue() != true) goto L34;
        boolean r11 = true;
    L35:
        if (r11 == false) goto L39;
        return true;
    L39:
        return false;
    L34:
        r11 = false;
        goto L35
    L38:
        return false;
    }

    public static void c(Fragment r7, OfficeSpaceTab r8, String r9) {
        if (b(r7) == true) goto L6;
        tt5.a.k("OfficeCreateFolderAction", "[OfficeCreatePerf] stage=create_folder_skip_select_mine_after_create sourceTab=" + r8 + " reason=owner_inactive trigger=" + r9);
        return;
    L6:
        Bundle r0 = r7.getArguments();
        if (r0 == null) goto L9;
        String r1 = r0.getString("office_list_runtime_id");
    L10:
        StringBuilder r2 = new StringBuilder("[OfficeCreatePerf] stage=create_folder_before_request_select_mine sourceTab=");
        r2.append(r8);
        r2.append(" trigger=");
        r2.append(r9);
        r2.append(" ownerState=");
        r2.append(r7.getLifecycle().getCurrentState());
        r2.append(" mineReady=");
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r5 = com.bytedance.ee.bear.office.list.h.a;
        OfficeSpaceTab r6 = OfficeSpaceTab.MINE;
        r2.append(com.bytedance.ee.bear.office.list.h.e(r1, r6));
        tt5.a.h("OfficeCreateFolderAction", r2.toString());
        Intrinsics.checkNotNullParameter(r6, "tab");
        Function1<OfficeSpaceTab, Boolean> r3 = com.bytedance.ee.bear.office.list.h.e.get(com.bytedance.ee.bear.office.list.h.g(r1));
        if (r3 == null) goto L15;
        boolean r10 = true;
        if (((Boolean) r3.invoke(r6)).booleanValue() != true) goto L15;
    L16:
        boolean r4 = com.bytedance.ee.bear.office.list.h.j(r1, r6);
        tt5.a.h("OfficeCreateFolderAction", "[OfficeCreatePerf] stage=create_folder_after_request_select_mine sourceTab=" + r8 + " trigger=" + r9 + " requested=" + r10 + " refreshed=" + r4 + " ownerState=" + r7.getLifecycle().getCurrentState());
        if (r4 == true) goto L20;
        tt5.a.k("OfficeCreateFolderAction", "refresh mine root after create folder failed, sourceTab=" + r8);
        return;
    L20:
        return;
    L15:
        r10 = false;
        goto L16
    L9:
        r1 = null;
        goto L10
    }

    public static boolean d(final OfficeSpaceTab r20, com.bytedance.ee.bear.office.list.i r21, final boolean r22) {
        Intrinsics.checkNotNullParameter(r20, "tab");
        Intrinsics.checkNotNullParameter(r21, "capability");
        final Fragment r10 = r21.a();
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.getActivity() != null) goto L9;
        return false;
    L9:
        if (a(r20, r21, r22) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(r21.a, "my_root_folder") == false) goto L14;
        String r2 = WikiSpaceType.PERSONAL;
    L15:
        final String r11 = r2;
        if (r22 == false) goto L24;
        Bundle r3 = r10.getArguments();
        if (r3 == null) goto L20;
        String r4 = r3.getString(ResourceData.KEY_TOKEN);
    L21:
        if (r4 != null) goto L23;
        r4 = "";
    L23:
        String r13 = r4;
    L25:
        if (r22 == true) goto L27;
        qc5.a.i(r21.c);
        final boolean r6 = true;
    L32:
        if (r22 == false) goto L34;
    L36:
        boolean r0 = false;
    L38:
        if (r0 == false) goto L40;
        tt5.a.h("OfficeCreateFolderAction", "[OfficeCreatePerf] stage=create_folder_defer_select_mine_until_success sourceTab=" + r20 + " ownerState=" + r10.getLifecycle().getCurrentState());
    L40:
        tt5.a.h("OfficeCreateFolderAction", "[OfficeCreatePerf] stage=create_folder_show_dialog_start tab=" + r20 + " isFolderPage=" + r22 + " module=" + r11 + " parentTokenBlank=" + StringsKt.isBlank(r13) + " isSpaceV2=" + r6);
        FragmentActivity r5 = r10.getActivity();
        if (r5 != null) goto L43;
        tt5.a.k("OfficeCreateFolderAction", "[OfficeCreatePerf] stage=create_folder_skip_show_dialog tab=" + r20 + " isFolderPage=" + r22 + " reason=activity_null ownerState=" + r10.getLifecycle().getCurrentState());
        return true;
    L43:
        tt5.a.h("OfficeCreateFolderAction", "[OfficeCreatePerf] stage=create_folder_dialog_show_before tab=" + r20 + " isFolderPage=" + r22 + " owner=" + r10.getClass().getSimpleName() + " ownerState=" + r10.getLifecycle().getCurrentState() + " activityFinishing=" + r5.isFinishing() + " activityDestroyed=" + r5.isDestroyed());
        if (r22 == false) goto L46;
    L48:
        boolean r16 = false;
    L49:
        final String r7 = r13;
        final boolean r8 = r16;
        t0.I(r5, r11, "", r13, new OfficeCreateFolderHeaderAction$showCreateFolderDialog$1(r20, r22, r10, r7, r11, r6, r8));
        tt5.a.h("OfficeCreateFolderAction", "[OfficeCreatePerf] stage=create_folder_dialog_show_after tab=" + r20 + " isFolderPage=" + r22 + " owner=" + r10.getClass().getSimpleName() + " ownerState=" + r10.getLifecycle().getCurrentState());
        return true;
    L46:
        if (r20 == OfficeSpaceTab.MINE) goto L48;
        r16 = true;
        goto L49
    L34:
        if (r20 == OfficeSpaceTab.MINE) goto L36;
        r0 = true;
        goto L38
    L27:
        Bundle r1 = r10.getArguments();
        if (r1 == null) goto L30;
        int r9 = r1.getInt("owner_type", 0);
    L31:
        FolderVersion.a r12 = FolderVersion.Companion;
        Integer r14 = Integer.valueOf(r9);
        r12.getClass();
        r6 = FolderVersion.a.c(r14);
        goto L32
    L30:
        r9 = 0;
        goto L31
    L20:
        r4 = null;
        goto L21
    L24:
        r13 = "";
        goto L25
    L14:
        r2 = r21.a;
        goto L15
    }
}
