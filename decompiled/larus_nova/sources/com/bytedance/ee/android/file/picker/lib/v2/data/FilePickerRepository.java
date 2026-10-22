package com.bytedance.ee.android.file.picker.lib.v2.data;

import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.e;
import um4.b;

/* JADX INFO: loaded from: classes15.dex */
public final class FilePickerRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f206009a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/data/FilePickerRepository$LoadFileFailedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadFileFailedException extends RuntimeException {
        public LoadFileFailedException(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    @Inject
    public FilePickerRepository(b r100) {
        Intrinsics.checkNotNullParameter(r100, "mDataSourceFactory");
        this.f206009a = r100;
    }

    public final c a(Set r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSourceTypes");
        return e.g(new FilePickerRepository$loadFiles$1(r100, this, null));
    }
}
