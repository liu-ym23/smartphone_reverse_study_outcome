package jd6;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f498619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f498620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498621c;

    /* JADX INFO: renamed from: jd6.a$a, reason: collision with other inner class name */
    public static final class C6417a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f498622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f498623b;

        public C6417a() {
            this.f498622a = new ArrayList();
            this.f498623b = new ArrayList();
        }

        public final void a(Map r100) {
            if (r100 == null) goto L7;
            Iterator r101 = r100.entrySet().iterator();
        L5:
            if (r101.hasNext() == false) goto L9;
            Map.Entry r102 = (Map.Entry) r101.next();
            String r103 = (String) r102.getKey();
            String r104 = (String) r102.getValue();
            Intrinsics.checkNotNullParameter(r103, "name");
            Intrinsics.checkNotNullParameter(r104, "value");
            List<String> r105 = this.f498622a;
            ArrayList r106 = (ArrayList) r105;
            r106.add(com.bytedance.kmp.network.f.b(r103));
            List<String> r107 = this.f498623b;
            ArrayList r108 = (ArrayList) r107;
            r108.add(com.bytedance.kmp.network.f.b(r104));
            goto L5
        L9:
            return;
        }
    }

    @Override // jd6.d
    public final String contentType() {
        return "application/x-www-form-urlencoded";
    }

    public final void a() {
        if (this.f498621c.length() <= 0) goto L5;
        return;
    L5:
        int r100 = this.f498619a.size();
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L10;
        if (r101 <= 0) goto L9;
        this.f498621c += Typography.amp;
    L9:
        this.f498621c += ((String) ListProtector.get(this.f498619a, r101));
        this.f498621c += com.alipay.sdk.m.n.a.f25612h;
        this.f498621c += ((String) ListProtector.get(this.f498620b, r101));
        r101 = r101 + 1;
        goto L6
    }

    @Override // jd6.d
    public final long contentLength() {
        a();
        return this.f498621c.length();
    }

    @Override // jd6.d
    public final void writeTo(BufferedSink r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        a();
        r100.writeUtf8(this.f498621c);
    }

    public a(List r100, List r101) {
        this.f498619a = CollectionsKt.toList(r100);
        this.f498620b = CollectionsKt.toList(r101);
        this.f498621c = "";
    }
}
