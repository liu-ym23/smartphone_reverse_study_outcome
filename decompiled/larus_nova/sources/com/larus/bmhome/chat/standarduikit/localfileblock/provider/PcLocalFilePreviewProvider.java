package com.larus.bmhome.chat.standarduikit.localfileblock.provider;

import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/localfileblock/provider/PcLocalFilePreviewProvider;", "Landroidx/core/content/FileProvider;", "<init>", "()V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcLocalFilePreviewProvider extends FileProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f309429a = 0;

    public static final class a {
        public static String a(FragmentActivity r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return r100.getPackageName() + ".pc_local_file.fileprovider";
        }
    }

    static {
    }

    public PcLocalFilePreviewProvider() {
    }
}
