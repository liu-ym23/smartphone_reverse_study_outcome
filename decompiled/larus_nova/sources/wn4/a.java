package wn4;

import a05.c;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.d;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.node.l;
import com.bytedance.ee.bear.document.render.node.q;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements l {

    /* JADX INFO: renamed from: wn4.a$a, reason: collision with other inner class name */
    public static final class C8137a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WikiInfo f560465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f560466b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f560465a, r101.f560465a) == true) goto L12;
            return false;
        L12:
            if (this.f560466b == r101.f560466b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f560465a.hashCode() * 31) + this.f560466b;
        }

        public final String toString() {
            return "WikiInjectInfo(wikiInfo=" + this.f560465a + ", hasInfoCache=" + this.f560466b + ')';
        }

        public b(WikiInfo r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "wikiInfo");
            this.f560465a = r100;
            this.f560466b = r101;
        }
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r100, Continuation r101) {
        d r102 = r100.getDocumentMetadata();
        BearUrl r103 = r102.getOriginBearUrl();
        b r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.f222560a;
    L6:
        e r106 = e.f541303n;
        if (TextUtils.equals(r105, r106.getType()) == true) goto L11;
        q.f221388a.getClass();
        return new q.c();
    L11:
        if ((r102 instanceof y3) == false) goto L13;
        y3 r107 = (y3) r102;
    L14:
        if (r107 == null) goto L16;
        WikiInfo r108 = r107.getWikiInfo();
    L17:
        BearUrl r109 = r102.getOriginBearUrl();
        if (r109 == null) goto L20;
        String r110 = r109.f222560a;
    L22:
        if (Intrinsics.areEqual(r110, r106.getType()) == false) goto L32;
        if (r108 == null) goto L28;
        boolean r111 = true;
        if (r108.isValidObjInfo() != true) goto L28;
    L29:
        if (r111 == true) goto L31;
        tt5.a.h("WikiLoaderNode", "isValidObjInfo is false or null");
        goto L32
    L31:
        r104 = new b(r108, r108.from_cache ? 1 : 0);
    L28:
        r111 = false;
    L32:
        if (r104 != null) goto L35;
        tt5.a.h("WikiLoaderNode", r100.f221320i + "skip wiki loader node");
        q.f221388a.getClass();
        return new q.c();
    L35:
        AtomicBoolean r112 = c.f1283r;
        c.f1289x = r104.f560466b;
        int r113 = r104.f560465a.getObjType();
        Map<String, Set<String>> r114 = d25.d.f466514a;
        d25.d.f466521h = e.f(r113);
        r100.f221319h.a("wikiInfo", r104.f560465a);
        tt5.a.h("WikiLoaderNode", r100.f221320i + "inject wikiInfo, objType=" + r104.f560465a.getObjType() + ", fromCache=" + r104.f560465a.from_cache);
        q.f221388a.getClass();
        return new q.c();
    L20:
        r110 = null;
        goto L22
    L16:
        r108 = null;
        goto L17
    L13:
        r107 = null;
        goto L14
    L5:
        r105 = null;
        goto L6
    }
}
