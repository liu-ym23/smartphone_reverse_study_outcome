package uq3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.bytedance.android.ec.window.base.common.headlive.WindowV3LiveRoomVO;
import com.bytedance.android.ec.window.base.repository.vo.WindowAuthorReputationVO;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o {
    public static final a x = null;
    public String a;
    public WindowCartEntryConfig b;
    public String c;
    public Boolean d;
    public WindowAuthorReputationVO e;
    public WindowV3LiveRoomVO f;
    public ECUrlModel g;
    public Integer h;
    public String i;
    public Integer j;
    public String k;
    public String l;
    public ECUrlModel m;
    public WindowFansClubInfo n;
    public String o;
    public Boolean p;
    public Map<String, String> q;
    public List<p> r;
    public k s;
    public List<e> t;
    public boolean u;
    public m v;
    public Map<String, ? extends List<String>> w;

    public static final class a {
        public a() {
        }
    }

    static {
        x = new a();
    }

    public final boolean a() {
        Map<String, String> r0 = this.q;
        if (r0 == null) goto L5;
        String r1 = r0.get("header_living_state_optimize");
    L7:
        return Intrinsics.areEqual(r1, CommentScene.COMMENTSCENE_NO_AWEME);
    L5:
        r1 = null;
        goto L7
    }

    public o() {
        this.l = "的橱窗";
        this.p = Boolean.FALSE;
        this.w = MapsKt.emptyMap();
    }
}
