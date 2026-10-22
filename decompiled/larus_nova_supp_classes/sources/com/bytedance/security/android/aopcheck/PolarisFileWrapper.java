package com.bytedance.security.android.aopcheck;

import android.util.EventsUtils;
import com.volcengine.zeus.provider.ContentProviderManager;
import java.io.File;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisFileWrapper;", "Ljava/io/File;", "pathname", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;)V", "parent", "child", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/io/File;Ljava/lang/String;)V", ContentProviderManager.PROVIDER_URI, "Ljava/net/URI;", "(Ljava/net/URI;)V", "Companion", "aopcheck_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_APP_USAGE})
public class PolarisFileWrapper extends File {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisFileWrapper$Companion;", XmlPullParser.NO_NAMESPACE, "()V", "sanitize", XmlPullParser.NO_NAMESPACE, "path", "sanitizeFile", "Ljava/io/File;", "parent", "sanitizeNull", "sanitzeURI", "Ljava/net/URI;", ContentProviderManager.PROVIDER_URI, "aopcheck_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_APP_USAGE})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final String sanitize(String r8) {
            if (PathTraversalChecker.check(r8) == false) goto L10;
            PathTraversalChecker r0 = PathTraversalChecker.INSTANCE;
            if (r0.getEnableIntercept() == true) goto L7;
            return r8;
        L7:
            if (r0.getEnableFileIntercept() == true) goto L9;
            return r8;
        L9:
            return StringsKt.replace$default(r8, "../", XmlPullParser.NO_NAMESPACE, false, 4, null);
        L10:
            return r8;
        }

        public final File sanitizeFile(File r8) {
            if (r8 != null) goto L5;
            return r8;
        L5:
            if (PathTraversalChecker.check(r8.getAbsolutePath()) == false) goto L12;
            PathTraversalChecker r0 = PathTraversalChecker.INSTANCE;
            if (r0.getEnableIntercept() == false) goto L12;
            if (r0.getEnableFileIntercept() == false) goto L12;
            return new File(StringsKt.replace$default(r8.getAbsolutePath(), "../", XmlPullParser.NO_NAMESPACE, false, 4, null));
        L12:
            return r8;
        }

        public final String sanitizeNull(String r1) {
            if (r1 != null) goto L6;
            return null;
        L6:
            return sanitize(r1);
        }

        public final URI sanitzeURI(URI r8) {
            if (PathTraversalChecker.check(r8) == false) goto L18;
            PathTraversalChecker r0 = PathTraversalChecker.INSTANCE;
            if (r0.getEnable() == false) goto L18;
            if (r0.getEnableIntercept() == false) goto L18;
            if (r0.getEnableFileIntercept() == false) goto L18;
            String r1 = r8.getPath();
            if (r1 == null) goto L15;
            String r2 = StringsKt.replace$default(r1, "../", XmlPullParser.NO_NAMESPACE, false, 4, null);
            if (r2 == null) goto L15;
        L17:
            return new URI(r8.getScheme(), r8.getHost(), r2, r8.getFragment());
        L15:
            r2 = r8.getPath();
        L18:
            return r8;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PolarisFileWrapper(String r2) {
        super(Companion.sanitize(r2));
    }

    public PolarisFileWrapper(URI r2) {
        super(Companion.sanitzeURI(r2));
    }

    public PolarisFileWrapper(File r2, String r3) {
        Companion r0 = Companion;
        super(r0.sanitizeFile(r2), r0.sanitize(r3));
    }

    public PolarisFileWrapper(String r2, String r3) {
        Companion r0 = Companion;
        super(r0.sanitizeNull(r2), r0.sanitize(r3));
    }
}
