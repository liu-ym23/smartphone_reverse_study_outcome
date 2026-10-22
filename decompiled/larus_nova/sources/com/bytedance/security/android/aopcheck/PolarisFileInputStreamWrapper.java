package com.bytedance.security.android.aopcheck;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisFileInputStreamWrapper;", "Ljava/io/FileInputStream;", "name", "", "(Ljava/lang/String;)V", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "fd", "Ljava/io/FileDescriptor;", "(Ljava/io/FileDescriptor;)V", "Companion", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
public class PolarisFileInputStreamWrapper extends FileInputStream {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisFileInputStreamWrapper$Companion;", "", "()V", "sanitizeFile", "Ljava/io/File;", "file", "sanitizeFileName", "", "name", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final File sanitizeFile(File r100) {
            if (PathTraversalChecker.check(r100.getAbsolutePath()) == false) goto L12;
            PathTraversalChecker r101 = PathTraversalChecker.INSTANCE;
            if (r101.getEnable() == false) goto L12;
            if (r101.getEnableIntercept() == false) goto L12;
            if (r101.getEnableFileInputStreamIntercept() == false) goto L12;
            return new File(StringsKt.replace$default(r100.getAbsolutePath(), "../", "", false, 4, null));
        L12:
            return r100;
        }

        public final String sanitizeFileName(String r100) {
            if (PathTraversalChecker.check(r100) == false) goto L10;
            PathTraversalChecker r101 = PathTraversalChecker.INSTANCE;
            if (r101.getEnableIntercept() == true) goto L7;
            return r100;
        L7:
            if (r101.getEnableFileInputStreamIntercept() == true) goto L9;
            return r100;
        L9:
            return StringsKt.replace$default(r100, "../", "", false, 4, null);
        L10:
            return r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PolarisFileInputStreamWrapper(File r100) {
        super(Companion.sanitizeFile(r100));
    }

    public PolarisFileInputStreamWrapper(String r100) {
        super(Companion.sanitizeFileName(r100));
    }

    public PolarisFileInputStreamWrapper(FileDescriptor r100) {
        super(r100);
    }
}
