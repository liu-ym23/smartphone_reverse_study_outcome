package t53;

import android.content.Context;
import cc3.k;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.model.response.PromotionProductCommentAppendDTO;
import com.bytedance.android.ec.model.response.PromotionProductCommentPhotoDTO;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import jd3.o;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p53.i;
import u53.f;
import u53.h;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f544622a = null;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f544623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f544624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f544625c;

        public a(Context r100, k r101) {
            this.f544623a = 2;
            this.f544624b = r100;
            this.f544625c = r101;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            f r100 = new f();
            k r101 = this.f544625c;
            if (r101.f23239a != 1) goto L5;
            String r102 = "video";
        L6:
            r100.f548817a = r102;
            String r103 = r101.f23244f;
            String r104 = "";
            if (r103 != null) goto L9;
            r103 = "";
        L9:
            r100.f548818b = r103;
            r100.f548819c = Integer.valueOf(r101.f23240b);
            r100.f548824h = Integer.valueOf(this.f544625c.f23246h);
            r100.f548821e = Integer.valueOf(this.f544625c.f23241c);
            r100.f548820d = Integer.valueOf(this.f544625c.f23242d);
            String r105 = this.f544625c.f23243e;
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            r100.f548823g = r105;
            String r106 = this.f544625c.f23245g;
            if (r106 == null) goto L13;
            r104 = r106;
        L13:
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r100.f548822f = r104;
            r100.f548825i = true;
            String r107 = o53.b.f522096a;
            Intrinsics.checkNotNullParameter(r107, "<set-?>");
            r100.f548826j = r107;
            Intrinsics.checkNotNullParameter("-1", "<set-?>");
            r100.f548827k = "-1";
            int r108 = this.f544623a;
            if (r108 != 0) goto L16;
            e.b(r100, this.f544624b);
        L20:
            r100.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
            r100.appendParam("async_ab", "1", com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
            return r100;
        L16:
            if (r108 != 2) goto L20;
            e.a(r100, this.f544624b);
            goto L20
        L5:
            r102 = "picture";
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public b() {
    }

    static {
        f544622a = new b();
    }

    public static void d(Context r100, k r101) {
        Intrinsics.checkNotNullParameter(r101, "commentInfo");
        Single.fromCallable(new a(r100, r101)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(c.f544626a, d.f544627a);
    }

    public static void c(Context r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == false) goto L5;
        String r103 = "comment_to_top_btn_show";
    L6:
        o r104 = new o(r103);
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r104.f498393a = r102;
        String r105 = o53.b.f522096a;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f498394b = r105;
        e.c(r104, r100, null);
        return;
    L5:
        r103 = "comment_to_top_btn_click";
        goto L6
    }

    public static void a(CommentNodeVO r100, Context r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "commentSwitchType");
        jd3.f r104 = new jd3.f();
        r104.f498308k = "全部";
        r104.f498310m = String.valueOf(r100.getId());
        if (r100.getLiked() == false) goto L5;
        String r105 = IStrategyStateSupplier.KEY_INFO_LIKE;
    L6:
        r104.f498311n = r105;
        List<PromotionProductCommentAppendDTO> r106 = r100.getAppendComment();
        if (r106 == null) goto L9;
        int r107 = r106.size();
    L10:
        String r108 = "1";
        if (r107 <= 0) goto L13;
        String r109 = "1";
    L14:
        r104.f498313p = r109;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r104.f498314q = r102;
        if (r103 == true) goto L18;
        r108 = "0";
    L18:
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r104.f498315r = r108;
        String r110 = o53.b.f522096a;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r104.f498316s = r110;
        Intrinsics.checkNotNullParameter("-1", "<set-?>");
        r104.f498317t = "-1";
        e.c(r104, r101, CollectionsKt.listOf(new String[]{com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, com.bytedance.android.ec.core.event.a.KEY_WITH_SAME_COMMENT}));
        return;
    L13:
        r109 = "0";
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r105 = "cancel";
        goto L6
    }

    public static void b(CommentParams r100, String r101, String r102, Context r103) {
        Intrinsics.checkNotNullParameter(r101, "clickArea");
        Intrinsics.checkNotNullParameter(r102, "confirmStatus");
        h r104 = new h();
        r104.f548831a = o53.b.f522096a;
        if (r100 == null) goto L5;
        String r105 = r100.getProductId();
    L6:
        r104.f548832b = r105;
        r104.f548834d = r102;
        r104.f548833c = r101;
        e.c(r104, r103, null);
        return;
    L5:
        r105 = null;
        goto L6
    }

    public static void e(int r100, int r101, int r102, CommentNodeVO r103, String r104, Context r105) {
        Intrinsics.checkNotNullParameter(r103, "commentNodeVO");
        Intrinsics.checkNotNullParameter(r104, "commentSwitchType");
        yb3.b r106 = new yb3.b();
        if (r100 != 1) goto L5;
        String r107 = "video";
    L6:
        r106.f567077a = r107;
        r106.f567078b = String.valueOf(r103.getId());
        r106.f567079c = Integer.valueOf(r101);
        r106.f567082f = Integer.valueOf(r102);
        List<PromotionVideoInfo> r108 = r103.getVideoInfo();
        int r109 = 0;
        if (r108 == null) goto L9;
        int r110 = r108.size();
    L10:
        r106.f567081e = Integer.valueOf(r110);
        List<PromotionProductCommentPhotoDTO> r111 = r103.getImagesInfos();
        if (r111 == null) goto L13;
        r109 = r111.size();
    L13:
        r106.f567080d = Integer.valueOf(r109);
        r106.f567084h = r104;
        List<i> r112 = r103.getTagsInfo();
        if (r112 == null) goto L25;
        Iterator<T> r113 = r112.iterator();
    L17:
        if (r113.hasNext() == false) goto L21;
        Object r114 = r113.next();
        if (Intrinsics.areEqual(((i) r114).f527781a, "2") == false) goto L17;
    L22:
        i r115 = (i) r114;
        if (r115 == null) goto L25;
        r106.f567085i = String.valueOf(r115.f527782b);
        goto L25
    L21:
        r114 = null;
    L25:
        r106.f567086j = Integer.valueOf(r101);
        e.c(r106, r105, null);
        return;
    L9:
        r110 = 0;
        goto L10
    L5:
        r107 = "picture";
        goto L6
    }
}
