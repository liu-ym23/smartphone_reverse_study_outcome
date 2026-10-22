package com.larus.flowskill.impl.actionbar;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.taskskill.k2;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s1a.d;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements com.larus.bmhome.view.actionbar.custom.router.b {

    /* JADX INFO: renamed from: com.larus.flowskill.impl.actionbar.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C4315a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f343488a = null;

        static {
            int[] r100 = new int[TaskModeActionBarAction.values().length];
            r100[TaskModeActionBarAction.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[TaskModeActionBarAction.FOLDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[TaskModeActionBarAction.DEVICE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[TaskModeActionBarAction.CANCEL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[TaskModeActionBarAction.MERGED_DEVICE_FOLDER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[TaskModeActionBarAction.CONNECTOR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f343488a = r100;
        }
    }

    public a() {
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUrl");
        return StringsKt.startsWith$default(r100, "//flow/task_skill_actionbar", false, 2, null);
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean a(BaseContentWidget r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r101, "schemaUrl");
        Intrinsics.checkNotNullParameter(r102, "commonArgs");
        boolean r103 = false;
        if (r100 == null) goto L55;
        t1a.b r104 = d.a(r100);
        if (r104 == null) goto L56;
        be8.a r105 = (be8.a) r104.getAbility(be8.a.class);
        if (r105 == null) goto L59;
        Uri r106 = UriProtector.parse(r101);
        TaskModeActionBarAction.a r107 = TaskModeActionBarAction.Companion;
        String r108 = r106.getLastPathSegment();
        r107.getClass();
        Iterator<TaskModeActionBarAction> r109 = TaskModeActionBarAction.getEntries().iterator();
    L10:
        String r110 = null;
        if (r109.hasNext() == false) goto L15;
        TaskModeActionBarAction r111 = r109.next();
        if (Intrinsics.areEqual(r111.getAction(), r108) == false) goto L10;
    L16:
        TaskModeActionBarAction r112 = r111;
        if (r112 != null) goto L19;
        int r113 = -1;
    L20:
        String r114 = "selected";
        switch(r113) {
            case -1: goto L57;
            case 0: goto L23;
            case 1: goto L49;
            case 2: goto L48;
            case 3: goto L40;
            case 4: goto L30;
            case 5: goto L26;
            case 6: goto L24;
            default: goto L23;
        };
    L24:
        r105.RV();
    L50:
        return true;
    L30:
        String r115 = UriProtector.getQueryParameter(r106, "skill_id");
        if (r115 != null) goto L33;
    L38:
        if (r110 != null) goto L50;
        return false;
    L33:
        if ((!StringsKt.isBlank(r115)) == true) goto L36;
        r115 = null;
    L36:
        if (r115 == null) goto L38;
        r105.U40(r115);
        r110 = r115;
        goto L38
    L40:
        int r116 = k2.f314331a;
        String r117 = r105.dC();
        if (r117 != null) goto L43;
    L44:
        r103 = true;
    L45:
        if (r103 == false) goto L47;
        r114 = "not_selected";
    L47:
        k2.a(r114);
        r105.Y20();
        goto L50
    L43:
        if (StringsKt.isBlank(r117) == false) goto L45;
    L48:
        r105.ER();
        goto L50
    L49:
        r105.aH();
        goto L50
    L57:
        return false;
    L23:
        throw new NoWhenBranchMatchedException();
    L26:
        if (r105.getSelectedFolder() == null) goto L29;
        r114 = "selected_workspace";
    L29:
        k2.a(r114);
        r105.H70();
        goto L50
    L19:
        r113 = C4315a.f343488a[r112.ordinal()];
        goto L20
    L15:
        r111 = null;
        goto L16
    L59:
        return false;
    L56:
        return false;
    L55:
        return false;
    }
}
