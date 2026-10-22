package ec8;

import android.content.Context;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.markdown.richtext.n;
import com.larus.business.markdown.impl.markwon.MarkwonStruct;
import com.larus.business.markdown.impl.widget.MarkdownMultiWidgetHelper;
import com.larus.business.markdown.impl.widget.f;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes25.dex */
public final class b implements dc8.b<bd8.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<BaseCompositeTextCell<? extends xc8.b>, C5767b> f472117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, tg8.a> f472118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f472119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f472120d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f472121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<uvc.b> f472122b;

        public a() {
            this(null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f472121a, r101.f472121a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f472122b, r101.f472122b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f472121a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            List<uvc.b> r104 = this.f472122b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "CacheInfo(streamIndex=" + this.f472121a + ", nodeList=" + this.f472122b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Integer r100, List<? extends uvc.b> r101) {
            this.f472121a = r100;
            this.f472122b = r101;
        }
    }

    /* JADX INFO: renamed from: ec8.b$b, reason: collision with other inner class name */
    public static final class C5767b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseCompositeTextCell<? extends xc8.b> f472123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xc8.b f472124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<bd8.b> f472125c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5767b) == true) goto L8;
            return false;
        L8:
            C5767b r101 = (C5767b) r100;
            if (Intrinsics.areEqual(this.f472123a, r101.f472123a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f472124b, r101.f472124b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f472125c, r101.f472125c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f472123a.hashCode() * 31) + this.f472124b.hashCode()) * 31) + this.f472125c.hashCode();
        }

        public final String toString() {
            return "CellContextInfo(cell=" + this.f472123a + ", state=" + this.f472124b + ", components=" + this.f472125c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C5767b(BaseCompositeTextCell<? extends xc8.b> r100, xc8.b r101, List<? extends bd8.b> r102) {
            Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
            Intrinsics.checkNotNullParameter(r101, "state");
            Intrinsics.checkNotNullParameter(r102, "components");
            this.f472123a = r100;
            this.f472124b = r101;
            this.f472125c = r102;
        }
    }

    public static final class c {
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final uvc.b f472126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f472127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f472128c;

        public d() {
            this(false, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f472126a, r101.f472126a) == true) goto L12;
            return false;
        L12:
            if (this.f472127b == r101.f472127b) goto L15;
            return false;
        L15:
            if (this.f472128c == r101.f472128c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            uvc.b r100 = this.f472126a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            int r103 = 1231;
            if (this.f472127b == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r102 + r104) * 31;
            if (this.f472128c == true) goto L15;
            r103 = 1237;
        L15:
            return r105 + r103;
        L9:
            r104 = 1237;
            goto L10
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "NodeInfo(node=" + this.f472126a + ", needUpdate=" + this.f472127b + ", isLastNode=" + this.f472128c + ')';
        }

        public /* synthetic */ d(boolean r100, int r101) {
            if ((r101 & 2) == 0) goto L5;
            r100 = true;
        L5:
            this(null, r100, false);
        }

        public d(uvc.b r100, boolean r101, boolean r102) {
            this.f472126a = r100;
            this.f472127b = r101;
            this.f472128c = r102;
        }
    }

    static {
    }

    @Override // dc8.b
    public final boolean isEmpty() {
        return this.f472117a.isEmpty();
    }

    public b() {
        this.f472117a = new LinkedHashMap();
        this.f472118b = new LinkedHashMap();
        this.f472119c = new a(null, null);
        this.f472120d = new a(null, null);
    }

    public final <T extends tg8.a> T d(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Object r101 = ((LinkedHashMap) this.f472118b).get(r100);
        if ((r101 instanceof tg8.a) == true) goto L7;
        return null;
    L7:
        return (T) r101;
    }

    public final void h(String r100) {
        if (AppHost.f326268a.isDebug() == false) goto L6;
        FLogger.f375446a.d("TextComponentContextImpl", r100);
        return;
    }

    @Override // dc8.b
    public final void s(BaseCompositeTextCell<? extends xc8.b> r100) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        this.f472117a.remove(r100);
        if (this.f472117a.isEmpty() == false) goto L6;
        ((LinkedHashMap) this.f472117a).clear();
        ((LinkedHashMap) this.f472118b).clear();
        this.f472119c = new a(null, null);
        this.f472120d = new a(null, null);
        return;
    }

    @Override // dc8.b
    public final boolean t(BaseCompositeTextCell<? extends xc8.b> r100) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        return this.f472117a.containsKey(r100);
    }

    public final <T extends tg8.a> void b(T r100, Class<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r101.isInterface() == false) goto L10;
        if (this.f472118b.containsKey(r101) == false) goto L7;
        this.f472118b.remove(r101);
    L7:
        this.f472118b.put(r101, r100);
        return;
    L10:
        throw new IllegalArgumentException("ability clazz must be an interface".toString());
    }

    public final d e(int r100, uvc.b r101, boolean r102) {
        List<uvc.b> r103 = this.f472120d.f472122b;
        if (r103 == null) goto L5;
        uvc.b r104 = (uvc.b) CollectionsKt.getOrNull(r103, r100);
    L6:
        List<uvc.b> r105 = this.f472120d.f472122b;
        if (r105 != null) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r104 != null) goto L14;
        h("getCacheInfoResult need update.[0]");
        return new d(r104, true, r106);
    L14:
        if (r102 == false) goto L16;
    L18:
        h("getCacheInfoResult should update.[2]");
        f.g(r104);
        return new d(r104, true, r106);
    L16:
        if (f.b(r101, r104) == false) goto L18;
        h("getCacheInfoResult no need update.[1]");
        return new d(r101, false, r106);
    L9:
        if (r100 != (r105.size() - 1)) goto L11;
        r106 = true;
        goto L12
    L5:
        r104 = null;
        goto L6
    }

    @Override // dc8.b
    public final void r(BaseCompositeTextCell<? extends xc8.b> r100, xc8.b r101, List<? extends bd8.b> r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r102, "components");
        this.f472117a.put(r100, new C5767b(r100, r101, r102));
    }

    public final List f(Context r110, final Message r111, boolean r112, MarkwonStruct r113) {
        gw8.c.f483071a.getClass();
        gw8.c r100 = gw8.c.a.b();
        if (r100 != null) goto L5;
        return null;
    L5:
        long r114 = System.currentTimeMillis();
        String r101 = (String) l0.a("", new ec8.a(r111));
        if (com.larus.bmhome.chat.bean.d.f0(r111) == false) goto L11;
        if (StringsKt.endsWith$default(r101, "\n\n", false, 2, null) == false) goto L11;
        r101 = r101 + Typography.nbsp;
    L11:
        if (z2.f365865a.enableMessageMention() == false) goto L14;
        Regex r102 = n.f307218a;
        r101 = n.k(r101);
    L14:
        long r115 = System.currentTimeMillis();
        uvc.b r103 = gw8.c.b.c(r100, r110, r101, !r112, null, r113, null, null, 104);
        if (r103 != null) goto L17;
        return null;
    L17:
        long r104 = System.currentTimeMillis();
        List r105 = MarkdownMultiWidgetHelper.a(r103);
        h("getNodeList getContent:" + (r115 - r114) + " createNode:" + (r104 - r115) + " cutIntoNodeList:" + (System.currentTimeMillis() - r104));
        return r105;
    }

    public final uvc.b g(Context r100, Message r101, com.larus.bmhome.chat.list.cell.text.cells.base.c r102, boolean r103, MarkwonStruct r104) {
        Object r105 = r102.f306026f.get("pipe_line_node");
        if ((r105 instanceof uvc.b) == false) goto L5;
        uvc.b r106 = (uvc.b) r105;
    L6:
        if (r106 == null) goto L9;
        f.g(r106);
        h("use pipe_line_node.");
        return r106;
    L9:
        h("create node to return.");
        int r107 = RangesKt.coerceAtLeast(r102.f306022b, 0);
        List r108 = f(r100, r101, r103, r104);
        if (r108 != null) goto L12;
        return null;
    L12:
        return (uvc.b) CollectionsKt.getOrNull(r108, r107);
    L5:
        r106 = null;
        goto L6
    }
}
