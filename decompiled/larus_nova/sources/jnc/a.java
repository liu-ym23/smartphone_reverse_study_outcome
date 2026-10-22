package jnc;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ixigua.lib.track.TrackParams;
import com.larus.platform.model.comment.CommentInfo;
import com.larus.platform.model.comment.UserInfo;
import com.larus.platform.service.AccountService;
import com.story.ai.biz.comment.api.InputType;
import com.story.ai.biz.comment.model.BaseComment;
import com.story.ai.biz.comment.model.CommentSection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f499793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f499794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f499795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static rq9.f f499796d;

    /* JADX INFO: renamed from: jnc.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6466a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f499797a = null;

        static {
            int[] r100 = new int[InputType.values().length];
            r100[InputType.AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[InputType.CLICK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[InputType.REPLY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f499797a = r100;
        }
    }

    static {
        f499793a = new LinkedHashSet();
    }

    public static void a(BaseComment r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        rq9.f r101 = f499796d;
        if (r101 == null) goto L19;
        Pair<String, JSONObject> r102 = r101.i();
        if (r102 == null) goto L20;
        by7.a r103 = b(r102);
        TrackParams r104 = new TrackParams().put(com.bytedance.android.ec.core.event.a.KEY_COMMENT_TYPE, c(r100));
        CommentInfo r105 = r100.getCommentData();
        String r106 = null;
        if (r105 == null) goto L11;
        UserInfo r107 = r105.h();
        if (r107 == null) goto L11;
        String r108 = r107.c();
    L12:
        if (r108 != null) goto L14;
        r108 = "";
    L14:
        TrackParams r109 = r104.put("to_user_type", d(r108));
        CommentInfo r110 = r100.getCommentData();
        if (r110 == null) goto L17;
        r106 = r110.d();
    L17:
        r103.f21463a.merge(r109.put("comment_id", r106));
        r103.b();
        return;
    L11:
        r108 = null;
        goto L12
    L20:
        return;
    }

    public static by7.a b(Pair r100) {
        JSONObject r101 = new JSONObject();
        Iterator<String> r102 = ((JSONObject) r100.getSecond()).keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, ((JSONObject) r100.getSecond()).opt(r103));
        goto L4
    L6:
        rq9.f r104 = f499796d;
        if (r104 == null) goto L10;
        JSONObject r105 = r104.f();
        if (r105 == null) goto L10;
    L11:
        Iterator<String> r106 = r105.keys();
    L13:
        if (r106.hasNext() == false) goto L20;
        String r107 = r106.next();
        rq9.f r108 = f499796d;
        if (r108 == null) goto L18;
        JSONObject r109 = r108.f();
        if (r109 == null) goto L18;
    L19:
        r101.put(r107, r109.opt(r107));
    L18:
        r109 = new JSONObject();
        goto L19
    L20:
        rq9.f r110 = f499796d;
        if (r110 == null) goto L23;
        r110.c(new Pair(r100.getFirst(), r101));
    L23:
        by7.a r111 = new by7.a((String) r100.getFirst());
        TrackParams r112 = new TrackParams().merge(r101);
        r111.f21463a.merge(r112);
        return r111;
    L10:
        r105 = new JSONObject();
        goto L11
    }

    public static String c(BaseComment r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r101 = true;
        if (r100.getCommentItemType() != CommentSection.CommentItemType.PARENT_COMMENT) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        return UGCMonitor.TYPE_POST;
    L9:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getCommentItemType() != CommentSection.CommentItemType.CHILD_COMMENT) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L27;
        CommentInfo r104 = r100.getCommentData();
        if (r104 == null) goto L17;
        String r105 = r104.q();
    L18:
        if (r105 != null) goto L20;
    L23:
        if (r101 == false) goto L25;
        return "reply";
    L25:
        return "reply_second";
    L20:
        if (r105.length() == 0) goto L23;
        r101 = false;
        goto L23
    L17:
        r105 = null;
        goto L18
    L27:
        return UGCMonitor.TYPE_POST;
    L12:
        r103 = false;
        goto L13
    L5:
        r102 = false;
        goto L7
    }

    public static String d(String r100) {
        if (Intrinsics.areEqual(r100, AccountService.f365697a.getUserId()) == false) goto L5;
        return "self";
    L5:
        return "others";
    }
}
