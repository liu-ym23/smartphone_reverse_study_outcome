package qc5;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean f() {
        return h();
    }

    @JvmStatic
    public static final boolean a() {
        c r0 = c.a.a;
        boolean r1 = r0.h("ccm.space.ainotes");
        boolean r2 = r0.h("ccm.space.ainotes_mobile");
        tt5.a.h("SpaceFeatureGatingV2", "isAiNotesEnabled: " + r1 + ", isAINotesMobileEnable: " + r2);
        if (r1 == false) goto L6;
        if (r2 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean c() {
        ce5.a r0 = new ce5.a();
        Intrinsics.checkNotNullParameter(r0, "userComponentAbility");
        boolean r1 = ex4.a.a(r0.d);
        tt5.a.h("SpaceFeatureGatingV2", "isMyLibraryEnable()...enable = " + r1);
        if (r1 == false) goto L5;
        j();
        return true;
    L5:
        return false;
    }

    public static boolean d() {
        ce5.a r0 = new ce5.a();
        Intrinsics.checkNotNullParameter(r0, "userComponentAbility");
        boolean r1 = r0.d.isCurrentEnable("ccm.space.newsharespace");
        tt5.a.h("SpaceFeatureGatingV2", "isNewSharedSpaceEnable()...enable = " + r1);
        return r1;
    }

    public static /* synthetic */ boolean h() {
        return g(new ce5.a());
    }

    public static /* synthetic */ void j() {
        i(new ce5.a());
    }

    @JvmStatic
    public static final void k() {
        tt5.a.h("SpaceFeatureGatingV2", "isTitlebarCreateEnable()...enable = false");
    }

    public static boolean l() {
        ce5.a r0 = new ce5.a();
        Intrinsics.checkNotNullParameter(r0, "userComponentAbility");
        boolean r1 = r0.d.isEnable("ccm.workspace.custom_space_icon");
        tt5.a.h("SpaceFeatureGatingV2", "isWikiCustomSpaceIconEnable()...enable = " + r1);
        return r1;
    }

    @JvmStatic
    public static final boolean b(int r2) {
        FolderVersion.a r0 = FolderVersion.Companion;
        Integer r3 = Integer.valueOf(r2);
        r0.getClass();
        boolean r4 = FolderVersion.a.c(r3);
        tt5.a.h("SpaceFeatureGatingV2", "isApplyDeleteEnable()...enable = " + r4);
        return r4;
    }

    @JvmStatic
    public static final boolean e(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        boolean r3 = r2.d.isCurrentEnable("ccm.mobile.pin_folder_enable");
        tt5.a.h("SpaceFeatureGatingV2", "isPinFolderEnable()...enable = " + r3);
        return r3;
    }

    @JvmStatic
    public static final boolean g(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        boolean r3 = ex4.a.a(r2.d);
        tt5.a.h("SpaceFeatureGatingV2", "isSidebarEnable()...enable = " + r3);
        return r3;
    }

    @JvmStatic
    public static final void i(ce5.a r1) {
        Intrinsics.checkNotNullParameter(r1, "userComponentAbility");
        tt5.a.h("SpaceFeatureGatingV2", "isSpaceV2()...enable = true");
    }

    @JvmStatic
    public static final boolean m(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        boolean r3 = r2.d.isCurrentEnable("ccm.workspace.next.sidebar_shared");
        tt5.a.h("SpaceFeatureGatingV2", "isWikiSupportSharedEnable()...enable = " + r3);
        return r3;
    }
}
