package dfb;

import com.larksuite.framework.thread.ThreadUtils;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f468332a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f468333a = null;

        static {
            int[] r100 = new int[FeedActionStatus.values().length];
            r100[FeedActionStatus.END.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[FeedActionStatus.START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f468333a = r100;
        }
    }

    public e(d r100) {
        Intrinsics.checkNotNullParameter(r100, "reseter");
        this.f468332a = r100;
    }

    public final void a(FeedActionStatus r100, FeedActionEvent r101) {
        int r102 = a.f468333a[r100.ordinal()];
        if (r102 != 1) goto L5;
        ThreadUtils.runOnUIThread(new f(r101, this));
        return;
    L5:
        if (r102 != 2) goto L11;
        this.f468332a.So();
        return;
    }

    public final void b(com.ss.android.lark.feed.export.feedcard.d r100, UIFeedCard r101, FeedActionStatus r102, FeedActionEvent r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "actionStatus");
        Intrinsics.checkNotNullParameter(r103, "event");
        if ((!FeedFolderCompat.INSTANCE.getTAG().isSameFolderWith(r100.f())) == true) goto L6;
        a(r102, r103);
    L6:
        if (a.f468333a[r102.ordinal()] == 1) goto L8;
    L11:
        a(r102, r103);
        return;
    L8:
        if (r101.isRemind() == false) goto L10;
        int r104 = qeb.a.f532707a;
        qeb.a.C7319a.a(ITTVideoEngineEventSource.KEY_MUTE, r101);
        goto L11
    L10:
        int r105 = qeb.a.f532707a;
        qeb.a.C7319a.a("unmute", r101);
        goto L11
    }
}
