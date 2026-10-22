package com.bytedance.awemeopen.apps.framework.feed.mix;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleColorBallAnimationView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeListLoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MixAwemeListLoadingViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int b = 0;
    public final DoubleColorBallAnimationView a;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.feed.mix.MixAwemeListLoadingViewHolder$a$a, reason: collision with other inner class name */
        public static final class C0078a extends IWrittenLayout {
            public DoubleColorBallAnimationView c;
            public final /* synthetic */ Context d;

            public final View f() {
                ViewGroup.LayoutParams r0 = new ViewGroup.LayoutParams(-1, -1);
                h(r0, 50.0f);
                final Context r2 = this.d;
                Function1<RelativeLayout, Unit> r1 = new MixAwemeListLoadingViewHolder$Companion$new$item$1$createView$1(this, r2);
                Intrinsics.checkNotNullParameter(r0, "lparams");
                Intrinsics.checkNotNullParameter(r0, "lparams");
                RelativeLayout r3 = new RelativeLayout(getContext());
                r3.setLayoutParams(r0);
                r1.invoke(r3);
                return r3;
            }

            public C0078a(Context r1) {
                this.d = r1;
                super(r1);
            }
        }

        public static MixAwemeListLoadingViewHolder a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            C0078a r0 = new C0078a(r2);
            View r1 = r0.j();
            DoubleColorBallAnimationView r3 = r0.c;
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("refreshView");
            r3 = null;
        L7:
            return new MixAwemeListLoadingViewHolder(r1, r3);
        }
    }

    static {
    }

    public MixAwemeListLoadingViewHolder(View r2, DoubleColorBallAnimationView r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "refreshView");
        super(r2);
        this.a = r3;
    }
}
