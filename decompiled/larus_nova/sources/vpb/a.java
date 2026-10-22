package vpb;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.larkicon.util.BizDomainConfig;
import com.ss.android.lark.larkicon.util.BizPathConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f556708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f556709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f556710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f556711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Drawable f556712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f556713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f556714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f556715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<xpb.b> f556716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<xpb.c> f556717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IconScene f556718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Long f556719l;

    /* JADX INFO: renamed from: vpb.a$a, reason: collision with other inner class name */
    public static final class C8032a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f556720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f556721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f556722c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f556723d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Drawable f556724e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Drawable f556725f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ArrayList<xpb.b> f556726g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ArrayList<xpb.c> f556727h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f556728i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Integer f556729j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public IconScene f556730k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Long f556731l;

        public final Flowable<Bitmap> a() {
            a r110 = new a(this.f556720a, this.f556721b, this.f556722c, this.f556723d, this.f556724e, this.f556725f, this.f556728i, this.f556729j, this.f556726g, this.f556727h, this.f556730k, this.f556731l);
            Long r100 = r110.f556719l;
            if (r100 == null) goto L5;
            long r101 = r100.longValue();
        L6:
            d r102 = new d();
            IconScene r103 = r110.f556718k;
            if (r103 != null) goto L9;
            r103 = IconScene.UNKNOW;
        L9:
            r102.f556741e = r103;
            if (r110.f556712e == null) goto L18;
            d r104 = new d();
            int r105 = ypb.b.f568733a;
            Bitmap r106 = ypb.b.a(r110.f556712e);
            Intrinsics.checkNotNullParameter(r106, SimplayerImageStrategy.RESULT_BITMAP);
            r104.f556739c = new wpb.c(r106);
            r110.a(r104);
            IconScene r107 = r110.f556718k;
            if (r107 != null) goto L14;
            r107 = IconScene.UNKNOW;
        L14:
            r104.f556741e = r107;
            wpb.e r108 = r104.f556739c;
            if (r108 == null) goto L17;
            Flowable r109 = r108.a(r104.f556740d).map(new e(r104));
        L19:
            Integer r111 = r110.f556714g;
            if (r111 == null) goto L22;
            int r112 = r111.intValue();
        L23:
            Integer r113 = r110.f556715h;
            if (r113 == null) goto L26;
            int r114 = r113.intValue();
        L27:
            int r115 = r110.f556708a;
            if (r115 != 1) goto L30;
            String r116 = r110.f556709b;
            Intrinsics.checkNotNullParameter(r116, "unicode");
            r102.f556739c = new wpb.d(r116, r112, r114, r102.f556741e);
        L46:
            r102.f556740d = r110.f556713f;
            r110.a(r102);
            wpb.e r117 = r102.f556739c;
            if (r117 == null) goto L49;
            Publisher r118 = r117.a(r102.f556740d).map(new e(r102));
        L51:
            return Flowable.merge(r109, r118).doOnComplete(new vpb.b(r110, r101)).doOnError(new c(r110, r101));
        L49:
            r118 = Flowable.empty();
            goto L51
        L30:
            if (r115 != 2) goto L32;
            String r119 = ypb.a.f568732a;
            String r120 = r110.f556709b;
            Intrinsics.checkNotNullParameter(r120, "path");
            StringBuilder r121 = new StringBuilder("http://");
        L42:
            e = move-exception;
            Log.e("IconConfig", "getImageDomain error " + e);
        L44:
            r121.append(ypb.a.f568732a);
            r121.append(r120);
            String r122 = r121.toString();
            Intrinsics.checkNotNullParameter(r122, "url");
            r102.f556739c = new wpb.a(r122, r112, r114, r102.f556741e);
            goto L46
        L37:
            if (idb.f.a().isCurrentEnable("ccm.mobile.ark_domain") == false) goto L39;
            String r123 = ((String) ListProtector.get(jcb.b.c().b(IDomainConfigService.DomainAlias.DOCS_REACTION_BUCKET_PREX), 0)) + '/';     // Catch: Exception -> L42
        L40:
            ypb.a.f568732a = r123;     // Catch: Exception -> L42
            goto L44
        L39:
            String r124 = SettingManager.getInstance().getString(BizDomainConfig.class);     // Catch: Exception -> L42
            r123 = new JSONObject(r124).optJSONArray("cdn").get(0) + '/' + ((BizPathConfig) SettingManager.getInstance().get(BizPathConfig.class)).a() + '/';     // Catch: Exception -> L42
            goto L40
        L32:
            if (r115 != 3) goto L46;
            String r125 = r110.f556709b;
            Integer r126 = r110.f556710c;
            Intrinsics.checkNotNullParameter(r125, "text");
            r102.f556739c = new wpb.f(r125, r112, r114, r126);
            xpb.a r127 = new xpb.a(r110.f556711d, UIUtils.dp2px(LarkContext.getApplication(), 10.0f), r110.f556710c, 1.0f);
            Intrinsics.checkNotNullParameter(r127, "transform");
            r102.f556737a.add(r127);
            goto L46
        L26:
            r114 = r102.f556742f;
            goto L27
        L22:
            r112 = r102.f556742f;
            goto L23
        L17:
            r109 = Flowable.empty();
            goto L19
        L18:
            r109 = Flowable.empty();
            goto L19
        L5:
            r101 = System.nanoTime();
            goto L6
        }

        public C8032a(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "iconKey");
            this.f556726g = new ArrayList();
            this.f556727h = new ArrayList();
            this.f556730k = IconScene.UNKNOW;
            this.f556720a = r100;
            this.f556721b = r101;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void a(d r100) {
        List<xpb.b> r101 = this.f556716i;
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        xpb.b r103 = (xpb.b) r102.next();
        Intrinsics.checkNotNullParameter(r103, "transform");
        r100.f556737a.add(r103);
    L8:
        List<xpb.c> r104 = this.f556717j;
        if (r104 == null) goto L14;
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L17;
        xpb.c r106 = (xpb.c) r105.next();
        Intrinsics.checkNotNullParameter(r106, "transform");
        r100.f556738b.add(r106);
        goto L12
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r100, String r101, Integer r102, Integer r103, Drawable r104, Drawable r105, Integer r106, Integer r107, List<? extends xpb.b> r110, List<? extends xpb.c> r111, IconScene r112, Long r113) {
        Intrinsics.checkNotNullParameter(r101, "iconKey");
        Intrinsics.checkNotNullParameter(r112, "scene");
        this.f556708a = r100;
        this.f556709b = r101;
        this.f556710c = r102;
        this.f556711d = r103;
        this.f556712e = r104;
        this.f556713f = r105;
        this.f556714g = r106;
        this.f556715h = r107;
        this.f556716i = r110;
        this.f556717j = r111;
        this.f556718k = r112;
        this.f556719l = r113;
    }
}
