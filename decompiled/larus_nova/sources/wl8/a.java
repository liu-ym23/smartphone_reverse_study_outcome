package wl8;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.uaigc.music.ILyricsToSongBoxWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f560206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ILyricsToSongBoxWrapper f560207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f560208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f560209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f560210e;

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f560206a = r100;
        ILyricsToSongBoxWrapper r101 = (ILyricsToSongBoxWrapper) ServiceManager.get().getService(ILyricsToSongBoxWrapper.class);
        this.f560207b = r101;
        this.f560208c = r101.b(r100);
    }
}
