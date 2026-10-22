package qc5;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f532475a = 0;

    static {
    }

    @JvmStatic
    public static final boolean f() {
        return h();
    }

    @JvmStatic
    public static final boolean a() {
        c r100 = c.a.f206237a;
        boolean r101 = r100.h("ccm.space.ainotes");
        boolean r102 = r100.h("ccm.space.ainotes_mobile");
        tt5.a.h("SpaceFeatureGatingV2", "isAiNotesEnabled: " + r101 + ", isAINotesMobileEnable: " + r102);
        if (r101 == false) goto L6;
        if (r102 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean c() {
        ce5.a r100 = new ce5.a();
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        boolean r101 = ex4.a.a(r100.f23449d);
        tt5.a.h("SpaceFeatureGatingV2", "isMyLibraryEnable()...enable = " + r101);
        if (r101 == false) goto L5;
        j();
        return true;
    L5:
        return false;
    }

    public static boolean d() {
        ce5.a r100 = new ce5.a();
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        boolean r101 = r100.f23449d.isCurrentEnable("ccm.space.newsharespace");
        tt5.a.h("SpaceFeatureGatingV2", "isNewSharedSpaceEnable()...enable = " + r101);
        return r101;
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
        ce5.a r100 = new ce5.a();
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        boolean r101 = r100.f23449d.isEnable("ccm.workspace.custom_space_icon");
        tt5.a.h("SpaceFeatureGatingV2", "isWikiCustomSpaceIconEnable()...enable = " + r101);
        return r101;
    }

    @JvmStatic
    public static final boolean b(int r100) {
        FolderVersion.a r101 = FolderVersion.Companion;
        Integer r102 = Integer.valueOf(r100);
        r101.getClass();
        boolean r103 = FolderVersion.a.c(r102);
        tt5.a.h("SpaceFeatureGatingV2", "isApplyDeleteEnable()...enable = " + r103);
        return r103;
    }

    @JvmStatic
    public static final boolean e(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        boolean r101 = r100.f23449d.isCurrentEnable("ccm.mobile.pin_folder_enable");
        tt5.a.h("SpaceFeatureGatingV2", "isPinFolderEnable()...enable = " + r101);
        return r101;
    }

    @JvmStatic
    public static final boolean g(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        boolean r101 = ex4.a.a(r100.f23449d);
        tt5.a.h("SpaceFeatureGatingV2", "isSidebarEnable()...enable = " + r101);
        return r101;
    }

    @JvmStatic
    public static final void i(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        tt5.a.h("SpaceFeatureGatingV2", "isSpaceV2()...enable = true");
    }

    @JvmStatic
    public static final boolean m(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        boolean r101 = r100.f23449d.isCurrentEnable("ccm.workspace.next.sidebar_shared");
        tt5.a.h("SpaceFeatureGatingV2", "isWikiSupportSharedEnable()...enable = " + r101);
        return r101;
    }
}
