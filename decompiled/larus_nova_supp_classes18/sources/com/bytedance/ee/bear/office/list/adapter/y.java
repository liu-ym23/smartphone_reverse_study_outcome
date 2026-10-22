package com.bytedance.ee.bear.office.list.adapter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.larksuite.component.universe_design.toast.UDToast;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y {
    public static final Set<OfficeLongPressMenuAction> f = null;
    public final Function0<Fragment> a;
    public final Function0<com.bytedance.ee.bear.list.list.d.b> b;
    public final Function0<String> c;
    public final Function0<Boolean> d;
    public final Function0<com.bytedance.ee.bear.more.office.e> e;

    public static final class a {
    }

    public static final class b {
        public final OfficeSpaceActionResult a;
        public final Integer b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Integer r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "DispatchOutcome(result=" + this.a + ", isAble=" + this.b + ')';
        }

        public b(OfficeSpaceActionResult r2, Integer r3) {
            Intrinsics.checkNotNullParameter(r2, "result");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeLongPressMenuAction.values().length];
            r0[OfficeLongPressMenuAction.SHARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r0[OfficeLongPressMenuAction.STAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r0[OfficeLongPressMenuAction.COPY_LINK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[OfficeLongPressMenuAction.MOVE_TO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[OfficeLongPressMenuAction.ADD_SHORTCUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r0[OfficeLongPressMenuAction.SECRET_SETTING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r0[OfficeLongPressMenuAction.DOWNLOAD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[OfficeLongPressMenuAction.EXPORT_AS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[OfficeLongPressMenuAction.RENAME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[OfficeLongPressMenuAction.MAKE_COPY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r0[OfficeLongPressMenuAction.DELETE_SOURCE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[OfficeLongPressMenuAction.REMOVE_RECENT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            a = r0;
        }
    }

    static {
        f = SetsKt.setOf(new OfficeLongPressMenuAction[]{OfficeLongPressMenuAction.SHARE, OfficeLongPressMenuAction.COPY_LINK, OfficeLongPressMenuAction.RENAME, OfficeLongPressMenuAction.MOVE_TO, OfficeLongPressMenuAction.DELETE_SOURCE});
    }

    public static String a(a0 r2) {
        StringBuilder r0 = new StringBuilder("token=");
        String r1 = r2.b.d;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.append(du5.b.k(r1));
        r0.append(", type=");
        r0.append(r2.b.getType());
        r0.append(", realType=");
        r0.append(r2.b.y1);
        r0.append(", nodeType=");
        r0.append(r2.b.M1);
        r0.append(", tab=");
        r0.append(r2.h);
        r0.append(", source=");
        r0.append(r2.g);
        r0.append(", moreInfo=");
        r0.append(r2.c.getClass().getSimpleName());
        r0.append(", moreType=");
        r0.append(r2.c.getType());
        r0.append(", moreRealType=");
        r0.append(r2.c.i());
        r0.append(", isShortcut=");
        r0.append(r2.c.E());
        return r0.toString();
    }

    public static String b(g0 r1) {
        if (Intrinsics.areEqual(r1, g0.c.a) == false) goto L6;
        return "Visible";
    L6:
        if (Intrinsics.areEqual(r1, g0.b.a) == false) goto L9;
        return "Hidden";
    L9:
        if ((r1 instanceof g0.a) == false) goto L13;
        return "Disabled";
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public static b d(View r2, String r3) {
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch long press action unavailable. reason=".concat(r3));
        UDToast.a r4 = UDToast.build(r2.getContext());
        r4.g(com.bytedance.ee.bear.more.office.f.c());
        r4.b.d = -1;
        r4.h();
        return new b(OfficeSpaceActionResult.NotHandled.INSTANCE, 0);
    }

    public static b c(View r2, g0 r3, String r4) {
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch long press action blocked by guard. reason=" + r4 + ", availability=" + b(r3));
        if ((r3 instanceof g0.a) == false) goto L6;
        UDToast.a r5 = UDToast.build(r2.getContext());
        r5.g(((g0.a) r3).a);
        r5.b.d = -1;
        r5.h();
    L6:
        return new b(OfficeSpaceActionResult.NotHandled.INSTANCE, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(Function0<? extends Fragment> r2, Function0<? extends com.bytedance.ee.bear.list.list.d.b> r3, Function0<String> r4, Function0<Boolean> r5, Function0<? extends com.bytedance.ee.bear.more.office.e> r6) {
        Intrinsics.checkNotNullParameter(r2, "ownerFragmentProvider");
        Intrinsics.checkNotNullParameter(r3, "menuItemClickListenerProvider");
        Intrinsics.checkNotNullParameter(r4, "moduleProvider");
        Intrinsics.checkNotNullParameter(r5, "isGridProvider");
        Intrinsics.checkNotNullParameter(r6, "larkActionServiceProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
