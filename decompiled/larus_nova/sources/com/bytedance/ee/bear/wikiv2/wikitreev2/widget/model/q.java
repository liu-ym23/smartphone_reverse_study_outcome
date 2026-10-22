package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f242003a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f242004b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Integer> f242005c = null;

    public q() {
    }

    static {
        HashMap r100 = new HashMap();
        f242003a = r100;
        HashMap r101 = new HashMap();
        f242004b = r101;
        HashMap r102 = new HashMap();
        f242005c = r102;
        r100.put("ADD", Integer.valueOf(R.string.Doc_Wiki_CreateDialog));
        r100.put("DEL", Integer.valueOf(R.string.Doc_Wiki_RemoveDialog));
        r100.put("MOV", Integer.valueOf(R.string.Doc_Wiki_MovePageMoving));
        Integer r103 = Integer.valueOf(R.string.CreationMobile_Wiki_CreateCopy_Creating_Toast);
        r100.put("SHORTCUT", r103);
        r100.put("MAKE_COPY", r103);
        r101.put("DEL", Integer.valueOf(R.string.LarkCCM_Workspace_DeletePage_Deleted_Toast));
        r101.put("MOV", Integer.valueOf(R.string.Doc_Wiki_MoveSuccess));
        r101.put("FAVORITE", Integer.valueOf(R.string.CreationMobile_Wiki_PageClipped_Toast));
        r101.put("UNFAVORITE", Integer.valueOf(R.string.CreationMobile_Wiki_PageUnclipped_Toast));
        r101.put("SHORTCUT", Integer.valueOf(R.string.CreationMobile_Wiki_Shortcuts_CreateSuccessfully_Toast));
        r101.put("MAKE_COPY", Integer.valueOf(R.string.CreationMobile_Wiki_CreateCopy_CreateSuccessfully_Toast));
        r102.put(a("EXPAND", 920004002), Integer.valueOf(R.string.Doc_Wiki_ExpandFailPageRemoved));
        r102.put(a("EXPAND", 920004004), Integer.valueOf(R.string.Doc_Wiki_ExpandFailNoPermission));
        String r104 = a("ADD", 920004002);
        Integer r110 = Integer.valueOf(R.string.Doc_Wiki_CreateFailFatherRemoved);
        r102.put(r104, r110);
        r102.put(a("ADD", 920004004), Integer.valueOf(R.string.LarkCCM_Docs_ActionFailed_NoTargetPermission_Mob));
        r102.put(a("ADD", 920004011), Integer.valueOf(R.string.Doc_Wiki_CreateFailMaximumLimited));
        String r111 = a("ADD", 10009);
        Integer r112 = Integer.valueOf(R.string.Doc_Review_Fail_Rename);
        r102.put(r111, r112);
        r102.put(a("ADD", 10013), r112);
        r102.put(a("DEL", 920004002), Integer.valueOf(R.string.Doc_Wiki_RemoveFailRepeat));
        String r113 = a("DEL", 920004004);
        Integer r114 = Integer.valueOf(R.string.CreationMobile_Wiki_NoPermissionToDelete_Toast);
        r102.put(r113, r114);
        r102.put(a("DEL", 233525001), r114);
        r102.put(a("DEL", 233525002), Integer.valueOf(R.string.CreationMobile_Wiki_CannotDeleteSubpages_Toast));
        r102.put(a("DEL_CURRENT_ONLY", 233525002), Integer.valueOf(R.string.LarkCCM_Workspace_DeletePageFail_NoPerm));
        r102.put(a("DEL_CURRENT_ONLY", 233525007), Integer.valueOf(R.string.LarkCCM_Workspace_DeletePageFail_OverLimit));
        r102.put(a("DEL_CURRENT_ONLY", -5), Integer.valueOf(R.string.LarkCCM_Workspace_DeletePage_OT_Toast));
        r102.put(a("MOV", 920004001), Integer.valueOf(R.string.Doc_Wiki_MoveFailTargetRemoved));
        r102.put(a("MOV", 920004002), Integer.valueOf(R.string.Doc_Wiki_MoveFailCurrentRemoved));
        String r115 = a("MOV", 920004004);
        Integer r116 = Integer.valueOf(R.string.CreationMobile_Wiki_Permission_NoPermissionToMove_Toast);
        r102.put(r115, r116);
        r102.put(a("MOV", 233525204), Integer.valueOf(R.string.CreationMobile_Wiki_Permission_NoRemovePermission_Toast));
        r102.put(a("MOV", 233525305), r116);
        r102.put(a("MAKE_COPY", 920004004), Integer.valueOf(R.string.CreationMobile_Error_NoPerm_CompleteAction));
        String r105 = a("SHORTCUT", 920004012);
        Integer r117 = Integer.valueOf(R.string.CreationMobile_Wiki_Shortcuts_ShortcutsRule_Tooltip);
        r102.put(r105, r117);
        r102.put(a("SHORTCUT", 920004003), r117);
        r102.put(a("SHORTCUT", 920004004), r117);
        r102.put(a("SHORTCUT", 920004007), r117);
        r102.put(a("SHORTCUT", 920004001), r110);
        r102.put(a("SHORTCUT", 920004002), r110);
        r102.put(a("SHORTCUT", 10009), r112);
        r102.put(a("SHORTCUT", 10013), r112);
        r102.put(a("FAVORITE", 100000002), Integer.valueOf(R.string.CreationMobile_Wiki_FailedToClip_Toast));
        r102.put(a("UNFAVORITE", 100000002), Integer.valueOf(R.string.CreationMobile_Wiki_FailedToUnClip_Toast));
        r102.put(a("SHORTCUT", 100000002), Integer.valueOf(R.string.CreationMobile_Wiki_Shortcuts_UnableToCreate_Toast));
        r102.put(a("MAKE_COPY", 100000002), Integer.valueOf(R.string.CreationMobile_Wiki_CreateCopy_UnableToCreate_Toast));
        r102.put(a("ADD", 100000002), Integer.valueOf(R.string.Doc_Facade_OperateFailed));
        r102.put(a("RENAME", 100000002), Integer.valueOf(R.string.Doc_Facade_RenameFailed));
    }

    public static int e(WikiAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Map<String, Integer> r101 = f242003a;
        HashMap r102 = (HashMap) r101;
        Integer r103 = (Integer) r102.get(r100.name());
        if (r103 != null) goto L7;
        return -1;
    L7:
        return r103.intValue();
    }

    public static int f(WikiAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Map<String, Integer> r101 = f242004b;
        HashMap r102 = (HashMap) r101;
        Integer r103 = (Integer) r102.get(r100.name());
        if (r103 != null) goto L7;
        return -1;
    L7:
        return r103.intValue();
    }

    public static String a(String r100, int r101) {
        return r100 + '-' + r101;
    }

    public static int b(WikiAction r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return c(r100, r101, R.string.Doc_Facade_OperateFailed);
    }

    public static /* synthetic */ int d(WikiAction r100, Throwable r101) {
        return c(r100, r101, R.string.Doc_Facade_OperateFailed);
    }

    public static int c(WikiAction r100, Throwable r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (tp5.b.d(r101) == false) goto L5;
        int r103 = 920004004;
    L7:
        if (r103 != 90003088) goto L11;
        return Integer.valueOf(R.string.LarkCCM_Unbundle_OwnerExpiredViewOnly_Tooltip).intValue();
    L11:
        if (r103 == (-1)) goto L15;
        Map<String, Integer> r104 = f242005c;
        HashMap r105 = (HashMap) r104;
        Integer r106 = (Integer) r105.get(a(r100.name(), r103));
        if (r106 != null) goto L17;
        r106 = (Integer) r105.get(a(r100.name(), 100000002));
    L17:
        if (r100 != WikiAction.DEL) goto L19;
    L20:
        r106 = Integer.valueOf(R.string.CreationMobile_Wiki_CannotRemove_Toast);
    L21:
        if (r106 == null) goto L23;
    L25:
        if (r106 != null) goto L27;
        return r102;
    L27:
        return r106.intValue();
    L23:
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L25;
        r106 = Integer.valueOf(R.string.Doc_Wiki_Network_Error);
        goto L25
    L19:
        if (r100 != WikiAction.DEL_CURRENT_ONLY) goto L21;
    L15:
        r106 = null;
        goto L17
    L5:
        r103 = tp5.b.a(r101);
        goto L7
    }
}
