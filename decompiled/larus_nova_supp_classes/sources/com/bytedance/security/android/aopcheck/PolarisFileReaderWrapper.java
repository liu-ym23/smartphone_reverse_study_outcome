package com.bytedance.security.android.aopcheck;

import android.util.EventsUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileReader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisFileReaderWrapper;", "Ljava/io/FileReader;", "fileName", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;)V", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "fd", "Ljava/io/FileDescriptor;", "(Ljava/io/FileDescriptor;)V", "Companion", "aopcheck_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_APP_USAGE})
public class PolarisFileReaderWrapper extends FileReader {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisFileReaderWrapper$Companion;", XmlPullParser.NO_NAMESPACE, "()V", "sanitizeFile", "Ljava/io/File;", "file", "sanitizeFileName", XmlPullParser.NO_NAMESPACE, "name", "aopcheck_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_APP_USAGE})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final File sanitizeFile(File r8) {
            if (PathTraversalChecker.check(r8.getAbsolutePath()) == false) goto L12;
            PathTraversalChecker r0 = PathTraversalChecker.INSTANCE;
            if (r0.getEnable() == false) goto L12;
            if (r0.getEnableIntercept() == false) goto L12;
            if (r0.getEnableFileReaderIntercept() == false) goto L12;
            return new File(StringsKt.replace$default(r8.getAbsolutePath(), "../", XmlPullParser.NO_NAMESPACE, false, 4, null));
        L12:
            return r8;
        }

        public final String sanitizeFileName(String r8) {
            if (PathTraversalChecker.check(r8) == false) goto L10;
            PathTraversalChecker r0 = PathTraversalChecker.INSTANCE;
            if (r0.getEnableIntercept() == true) goto L7;
            return r8;
        L7:
            if (r0.getEnableFileReaderIntercept() == true) goto L9;
            return r8;
        L9:
            return StringsKt.replace$default(r8, "../", XmlPullParser.NO_NAMESPACE, false, 4, null);
        L10:
            return r8;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PolarisFileReaderWrapper(File r2) {
        super(Companion.sanitizeFile(r2));
    }

    public PolarisFileReaderWrapper(String r2) {
        super(Companion.sanitizeFileName(r2));
    }

    public PolarisFileReaderWrapper(FileDescriptor r1) {
        super(r1);
    }
}
