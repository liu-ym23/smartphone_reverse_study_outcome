package z5c;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;

/* JADX INFO: loaded from: classes38.dex */
public final class l3 extends s5c.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s5c.a f570245c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s5c.a f570246d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l3 f570247e = null;

    static {
        l3 r100 = new l3();
        f570247e = r100;
        r100.a("on_to_off");
        r100.a("off_to_on");
        r100.a("to_multi");
        r100.a("to_selected");
        r100.a("to_unselected");
        r100.a("on");
        r100.a("off");
        r100.a("all");
        r100.a("ongoing");
        r100.a("completed");
        r100.a("start");
        r100.a(BitableAnalytic.SelectSceneClickType.COMPLETE);
        f570245c = r100.a("done_to_undone");
        f570246d = r100.a("undone_to_done");
        r100.a("done");
        r100.a("cancel");
        r100.a("fold");
        r100.a("wide");
        r100.a("narrow");
        r100.a("only_group_owner_and_admin");
        r100.a("close_to_open");
        r100.a("open_to_close");
        r100.a("success");
        r100.a("fail");
        r100.a("unfollow _to_follow");
        r100.a("follow_to unfollow");
        r100.a("1");
        r100.a("0");
        r100.a(BitableAnalytic.LinkSceneClickType.EXPAND);
        r100.a("half_expand");
    }

    public l3() {
        super("status");
    }
}
