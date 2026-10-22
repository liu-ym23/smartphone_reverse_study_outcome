package z5c;

import com.alibaba.gaiax.render.view.GXViewKey;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.ss.android.cert.manager.constants.BytedCertConstant;

/* JADX INFO: loaded from: classes38.dex */
public final class e4 extends s5c.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s5c.a f570193c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s5c.a f570194d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e4 f570195e = null;

    static {
        e4 r100 = new e4();
        f570195e = r100;
        r100.a("square");
        f570193c = r100.a("list");
        r100.a(BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY);
        r100.a("threeday");
        r100.a("week");
        r100.a(BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH);
        r100.a("meeting");
        r100.a("no_value");
        f570194d = r100.a("speech_to_text");
        r100.a("speech_plus_text");
        r100.a("recording_view");
        r100.a("kanban");
        r100.a(GXViewKey.VIEW_TYPE_CONTAINER_GRID);
        r100.a("gallery");
        r100.a("gantt");
        r100.a("form");
        r100.a("add_shared_scene");
        r100.a("share_scene");
        r100.a("stop_scene");
        r100.a("new_create_scene");
        r100.a("explore");
        r100.a("my_scene");
        r100.a("delete_scene");
        r100.a("start_scene");
        r100.a("manual");
        r100.a("auto");
        r100.a("1");
        r100.a("2");
        r100.a("regenerate");
        r100.a("go_auth");
        r100.a("contact_admin");
        r100.a("contact_to_upgrade");
        r100.a("i_know");
        r100.a("go_upgrade");
        r100.a("none");
    }

    public e4() {
        super(BytedCertConstant.IntentKey.VIEW_TYPE);
    }
}
