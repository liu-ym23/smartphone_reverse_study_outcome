package com.ss.android.lark.chat.api.service.request;

import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class PullUrlPreviewRequest {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f411710c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<UrlPreviewHangPoint>> f411711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f411712b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, List<UrlPreviewHangPoint>> f411713a;

        public a() {
            this.f411713a = new LinkedHashMap();
        }

        public final void a(String r100, UrlPreviewHangPoint r101) {
            Intrinsics.checkNotNullParameter(r100, "sourceId");
            Intrinsics.checkNotNullParameter(r101, "hangPoint");
            List<UrlPreviewHangPoint> r102 = (List) ((LinkedHashMap) this.f411713a).get(r100);
            if (r102 != null) goto L5;
            r102 = new ArrayList();
        L5:
            r102.add(r101);
            this.f411713a.put(r100, r102);
        }

        public final void b(String r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, "sourceId");
            Intrinsics.checkNotNullParameter(r101, "hangPoints");
            List<UrlPreviewHangPoint> r102 = (List) ((LinkedHashMap) this.f411713a).get(r100);
            if (r102 != null) goto L5;
            r102 = new ArrayList();
        L5:
            r102.addAll(r101);
            this.f411713a.put(r100, r102);
        }
    }

    public static final class b {
        public b() {
        }

        public static final String a(Map r100, String r101) {
            int r102 = PullUrlPreviewRequest.f411710c;
            String r103 = r101.concat(": ");
            Iterator r104 = r100.entrySet().iterator();
        L4:
            if (r104.hasNext() == false) goto L9;
            Map.Entry r105 = (Map.Entry) r104.next();
            r103 = r103 + "| msgId: " + ((String) r105.getKey());
            Iterator r106 = ((Iterable) r105.getValue()).iterator();
        L7:
            if (r106.hasNext() == false) goto L4;
            r103 = r103 + " previewId : " + ((UrlPreviewHangPoint) r106.next()).preview_id + ' ';
            goto L7
        L9:
            return r103;
        }
    }

    static {
        new b();
    }

    public PullUrlPreviewRequest() {
        throw null;
    }

    public final int hashCode() {
        return this.f411711a.hashCode();
    }

    public final String toString() {
        return (String) this.f411712b.getValue();
    }

    public PullUrlPreviewRequest(Map r100) {
        this.f411711a = r100;
        this.f411712b = LazyKt.lazy(new PullUrlPreviewRequest$logMessage$2(this));
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof PullUrlPreviewRequest) == true) goto L9;
        return false;
    L9:
        return Intrinsics.areEqual(this.f411711a, ((PullUrlPreviewRequest) r100).f411711a);
    }
}
