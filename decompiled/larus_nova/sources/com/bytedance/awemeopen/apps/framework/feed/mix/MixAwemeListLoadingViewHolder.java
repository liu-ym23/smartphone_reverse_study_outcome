package com.bytedance.awemeopen.apps.framework.feed.mix;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleColorBallAnimationView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeListLoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MixAwemeListLoadingViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f194953b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoubleColorBallAnimationView f194954a;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.feed.mix.MixAwemeListLoadingViewHolder$a$a, reason: collision with other inner class name */
        public static final class C2805a extends IWrittenLayout {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public DoubleColorBallAnimationView f194955c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Context f194956d;

            @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
            public final View f() {
                ViewGroup.LayoutParams r100 = new ViewGroup.LayoutParams(-1, -1);
                h(r100, 50.0f);
                final Context r101 = this.f194956d;
                Function1<RelativeLayout, Unit> r102 = new MixAwemeListLoadingViewHolder$Companion$new$item$1$createView$1(this, r101);
                Intrinsics.checkNotNullParameter(r100, "lparams");
                Intrinsics.checkNotNullParameter(r100, "lparams");
                RelativeLayout r103 = new RelativeLayout(getContext());
                r103.setLayoutParams(r100);
                r102.invoke(r103);
                return r103;
            }

            public C2805a(Context r100) {
                this.f194956d = r100;
                super(r100);
            }
        }

        public static MixAwemeListLoadingViewHolder a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            C2805a r101 = new C2805a(r100);
            View r102 = r101.j();
            DoubleColorBallAnimationView r103 = r101.f194955c;
            if (r103 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("refreshView");
            r103 = null;
        L7:
            return new MixAwemeListLoadingViewHolder(r102, r103);
        }
    }

    static {
    }

    public MixAwemeListLoadingViewHolder(View r100, DoubleColorBallAnimationView r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "refreshView");
        super(r100);
        this.f194954a = r101;
    }
}
