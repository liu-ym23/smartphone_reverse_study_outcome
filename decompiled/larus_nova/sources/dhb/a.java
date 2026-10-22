package dhb;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.flow.feed.component.loading.FlowLoadingView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends FeedCardComponent<C5673a, FlowLoadingView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f468666c;

    /* JADX INFO: renamed from: dhb.a$a, reason: collision with other inner class name */
    public static final class C5673a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function2<FlowLoadingView, View, View> f468667a;

        /* JADX WARN: Multi-variable type inference failed */
        public C5673a(Function2<? super FlowLoadingView, ? super View, ? extends View> r100) {
            this.f468667a = r100;
        }
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        return new FlowLoadingView(getContext());
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public Context getContext() {
        return this.f468666c;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f468666c = r100;
    }
}
