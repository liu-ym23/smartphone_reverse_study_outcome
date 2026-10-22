package com.ss.android.lark.storage.file;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/storage/file/RootDirResolver;", "Ljava/io/Serializable;", "getRootDir", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", ITTVideoEngineEventSource.KEY_VOLUME, "Lcom/ss/android/lark/storage/file/IVolume;", "spaceName", "getRootDirs", "", "getSpaceDirName", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RootDirResolver extends Serializable {

    public static final class a {
        public static String a(RootDirResolver r100, Context r101, b r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, ITTVideoEngineEventSource.KEY_VOLUME);
            Intrinsics.checkNotNullParameter(r103, "spaceName");
            String r104 = r100.getRootDirs(r101, r103).get(r102);
            if (r104 == null) goto L6;
            return r104;
        L6:
            throw new UnsupportedOperationException("cannot found this volume:" + r102.getName() + " in space: " + r103);
        }
    }

    String getRootDir(Context r100, b r101, String r102);

    Map<b, String> getRootDirs(Context r100, String r101);

    String getSpaceDirName(Context r100, String r101);
}
