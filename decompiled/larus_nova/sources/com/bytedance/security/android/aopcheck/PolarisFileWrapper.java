package com.bytedance.security.android.aopcheck;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.File;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisFileWrapper;", "Ljava/io/File;", "pathname", "", "(Ljava/lang/String;)V", "parent", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/io/File;Ljava/lang/String;)V", "uri", "Ljava/net/URI;", "(Ljava/net/URI;)V", "Companion", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
public class PolarisFileWrapper extends File {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisFileWrapper$Companion;", "", "()V", "sanitize", "", "path", "sanitizeFile", "Ljava/io/File;", "parent", "sanitizeNull", "sanitzeURI", "Ljava/net/URI;", "uri", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String sanitize(String r100) {
            if (PathTraversalChecker.check(r100) == false) goto L10;
            PathTraversalChecker r101 = PathTraversalChecker.INSTANCE;
            if (r101.getEnableIntercept() == true) goto L7;
            return r100;
        L7:
            if (r101.getEnableFileIntercept() == true) goto L9;
            return r100;
        L9:
            return StringsKt.replace$default(r100, "../", "", false, 4, null);
        L10:
            return r100;
        }

        public final File sanitizeFile(File r100) {
            if (r100 != null) goto L5;
            return r100;
        L5:
            if (PathTraversalChecker.check(r100.getAbsolutePath()) == false) goto L12;
            PathTraversalChecker r101 = PathTraversalChecker.INSTANCE;
            if (r101.getEnableIntercept() == false) goto L12;
            if (r101.getEnableFileIntercept() == false) goto L12;
            return new File(StringsKt.replace$default(r100.getAbsolutePath(), "../", "", false, 4, null));
        L12:
            return r100;
        }

        public final String sanitizeNull(String r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return sanitize(r100);
        }

        public final URI sanitzeURI(URI r100) {
            if (PathTraversalChecker.check(r100) == false) goto L18;
            PathTraversalChecker r101 = PathTraversalChecker.INSTANCE;
            if (r101.getEnable() == false) goto L18;
            if (r101.getEnableIntercept() == false) goto L18;
            if (r101.getEnableFileIntercept() == false) goto L18;
            String r102 = r100.getPath();
            if (r102 == null) goto L15;
            String r103 = StringsKt.replace$default(r102, "../", "", false, 4, null);
            if (r103 == null) goto L15;
        L17:
            return new URI(r100.getScheme(), r100.getHost(), r103, r100.getFragment());
        L15:
            r103 = r100.getPath();
        L18:
            return r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PolarisFileWrapper(String r100) {
        super(Companion.sanitize(r100));
    }

    public PolarisFileWrapper(URI r100) {
        super(Companion.sanitzeURI(r100));
    }

    public PolarisFileWrapper(File r100, String r101) {
        Companion r102 = Companion;
        super(r102.sanitizeFile(r100), r102.sanitize(r101));
    }

    public PolarisFileWrapper(String r100, String r101) {
        Companion r102 = Companion;
        super(r102.sanitizeNull(r100), r102.sanitize(r101));
    }
}
