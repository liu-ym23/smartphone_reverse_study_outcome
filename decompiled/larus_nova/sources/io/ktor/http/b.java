package io.ktor.http;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class b extends l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f491832f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f491833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f491834e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f491835a = null;

        static {
            String r100 = "application";
            new b(r100, "*");
            new b(r100, "atom+xml");
            new b(r100, "cbor");
            new b(r100, "json");
            new b(r100, "hal+json");
            new b(r100, "javascript");
            f491835a = new b(r100, "octet-stream");
            new b(r100, "rss+xml");
            new b(r100, "xml");
            new b(r100, "xml-dtd");
            new b(r100, "zip");
            new b(r100, DownloadHelper.GZIP);
            new b(r100, "x-www-form-urlencoded");
            new b(r100, ExportFileExtension.PDF);
            new b(r100, "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            new b(r100, "vnd.openxmlformats-officedocument.wordprocessingml.document");
            new b(r100, "vnd.openxmlformats-officedocument.presentationml.presentation");
            new b(r100, "protobuf");
            new b(r100, "wasm");
            new b(r100, "problem+json");
            new b(r100, "problem+xml");
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.b$b, reason: collision with other inner class name */
    public static final class C6310b {
        public static b a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            if (StringsKt.isBlank(r100) == true) goto L5;
            int r101 = l.f491886c;
            j r102 = (j) CollectionsKt.last(q.a(r100));
            String r103 = r102.f491875a;
            List<k> r104 = r102.f491876b;
            int r105 = StringsKt.indexOf$default(r103, '/', 0, false, 6, null);
            if (r105 == (-1)) goto L9;
            String r106 = StringsKt.trim(r103.substring(0, r105)).toString();
            boolean r107 = true;
            if (r106.length() != 0) goto L17;
            boolean r108 = true;
        L18:
            if (r108 == true) goto L37;
            String r109 = StringsKt.trim(r103.substring(r105 + 1)).toString();
            if (StringsKt.contains$default(r106, ' ', false, 2, null) == true) goto L35;
            if (StringsKt.contains$default(r109, ' ', false, 2, null) == true) goto L35;
            if (r109.length() == 0) goto L27;
            r107 = false;
        L27:
            if (r107 == true) goto L33;
            if (StringsKt.contains$default(r109, '/', false, 2, null) == true) goto L33;
            return new b(r106, r109, r104);
        L33:
            throw new BadContentTypeFormatException(r100);
        L35:
            throw new BadContentTypeFormatException(r100);
        L37:
            throw new BadContentTypeFormatException(r100);
        L17:
            r108 = false;
            goto L18
        L9:
            if (Intrinsics.areEqual(StringsKt.trim(r103).toString(), "*") == false) goto L13;
            return b.f491832f;
        L13:
            throw new BadContentTypeFormatException(r100);
        L5:
            return b.f491832f;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f491836a = null;

        static {
            String r100 = "text";
            new b(r100, "*");
            f491836a = new b(r100, "plain");
            new b(r100, GXTemplateKey.GAIAX_CSS);
            new b(r100, "csv");
            new b(r100, "html");
            new b(r100, "javascript");
            new b(r100, "vcard");
            new b(r100, "xml");
            new b(r100, "event-stream");
        }
    }

    static {
        String r100 = "*";
        f491832f = new b(r100, r100);
    }

    public final int hashCode() {
        String r100 = this.f491833d;
        Locale r101 = Locale.ROOT;
        int r102 = r100.toLowerCase(r101).hashCode();
        return (r102 + ((r102 * 31) + this.f491834e.toLowerCase(r101).hashCode())) + (this.f491888b.hashCode() * 31);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == false) goto L11;
        b r101 = (b) r100;
        if (StringsKt.equals(this.f491833d, r101.f491833d, true) == false) goto L11;
        if (StringsKt.equals(this.f491834e, r101.f491834e, true) == false) goto L11;
        if (Intrinsics.areEqual(this.f491888b, r101.f491888b) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public /* synthetic */ b(String r100, String r101) {
        this(r100, r101, CollectionsKt.emptyList());
    }

    public b(String r100, String r101, List<k> r102) {
        Intrinsics.checkNotNullParameter(r100, "contentType");
        Intrinsics.checkNotNullParameter(r101, "contentSubtype");
        Intrinsics.checkNotNullParameter(r102, "parameters");
        this(r100, r101, r100 + '/' + r101, r102);
    }

    public b(String r100, String r101, String r102, List<k> r103) {
        super(r102, r103);
        this.f491833d = r100;
        this.f491834e = r101;
    }
}
