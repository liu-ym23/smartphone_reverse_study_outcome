package rib;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<SearchBaseInfo> f537929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SearchBaseInfo> f537930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f537931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f537932d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<SearchBaseInfo> f537933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<SearchBaseInfo> f537934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f537935c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f537936d;

        public final b a() {
            com.ss.android.lark.forwardv3.utils.b.d();
            List r100 = CollectionsKt.plus(this.f537933a, this.f537934b);
            LinkedHashMap r101 = new LinkedHashMap();
            Iterator r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L9;
            Object r103 = r102.next();
            String r104 = ((SearchBaseInfo) r103).getId();
            Object r105 = r101.get(r104);
            if (r105 != null) goto L8;
            r105 = new ArrayList();
            r101.put(r104, r105);
        L8:
            ((List) r105).add(r103);
            goto L4
        L9:
            ArrayList r106 = new ArrayList();
            Iterator r107 = r101.entrySet().iterator();
        L11:
            if (r107.hasNext() == false) goto L28;
            Iterator r108 = ((List) ((Map.Entry) r107.next()).getValue()).iterator();
            if (r108.hasNext() == true) goto L15;
            Object r109 = null;
        L25:
            SearchBaseInfo r110 = (SearchBaseInfo) r109;
            if (r110 == null) goto L11;
            r106.add(r110);
            goto L11
        L15:
            Object r111 = r108.next();
            if (r108.hasNext() == true) goto L18;
        L17:
            r109 = r111;
            goto L25
        L18:
            long r112 = ((SearchBaseInfo) r111).getTimeStamp();
        L19:
            Object r113 = r108.next();
            long r114 = ((SearchBaseInfo) r113).getTimeStamp();
            if (r112 >= r114) goto L23;
            r111 = r113;
            r112 = r114;
        L23:
            if (r108.hasNext() == true) goto L19;
        L28:
            List r115 = CollectionsKt.sortedWith(r106, new rib.a());
            ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
            Iterator r117 = r115.iterator();
        L30:
            if (r117.hasNext() == false) goto L32;
            SearchBaseInfo r118 = (SearchBaseInfo) r117.next();
            r116.add(TuplesKt.to(r118.getId(), Long.valueOf(r118.getTimeStamp())));
            goto L30
        L32:
            List r119 = CollectionsKt.take(r116, 30);
            Log.i("ChatPickerRecommendData", "merge_forward_list size: " + r119.size() + ", " + r119);
            Iterator r120 = r115.iterator();
        L34:
            if (r120.hasNext() == false) goto L37;
            SearchBaseInfo r121 = (SearchBaseInfo) r120.next();
            WeakReference<Message> r122 = ForwardDataUtils.f425557a;
            Intrinsics.checkNotNullParameter(r121, "<this>");
            r121.setHeaderId(0);
            r121.setHeaderLabel(ForwardDataUtils.f425560d);
            goto L34
        L37:
            return new b(CollectionsKt.toMutableList(CollectionsKt.take(r115, 60)), this.f537934b, this.f537935c, this.f537936d);
        }

        public a() {
            this.f537933a = new ArrayList();
            this.f537934b = new ArrayList();
        }
    }

    /* JADX INFO: renamed from: rib.b$b, reason: collision with other inner class name */
    public static final class C7487b {
    }

    static {
    }

    public final boolean a() {
        if (CollectionUtils.isEmpty(this.f537930b) == true) goto L5;
    L9:
        return false;
    L5:
        if (CollectionUtils.isEmpty(this.f537929a) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.f537929a.size() >= 3) goto L9;
        goto L8
    }

    public b(List<SearchBaseInfo> r100, List<SearchBaseInfo> r101, long r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "recentVisitData");
        Intrinsics.checkNotNullParameter(r101, "recentForwardData");
        this.f537929a = r100;
        this.f537930b = r101;
        this.f537931c = r102;
        this.f537932d = r103;
    }
}
