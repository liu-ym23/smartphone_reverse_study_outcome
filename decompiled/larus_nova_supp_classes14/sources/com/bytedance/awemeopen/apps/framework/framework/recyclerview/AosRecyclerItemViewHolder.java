package com.bytedance.awemeopen.apps.framework.framework.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerItemViewHolder;", "Model", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosRecyclerItemViewHolder<Model> extends RecyclerView.ViewHolder {
    public Model a;
    public boolean b;

    public static final class a {
    }

    static {
    }

    public abstract void U3(Model r1, int r2);

    public abstract void V3();

    public final void W3() {
        if (this.b == true) goto L9;
        String r0 = getClass().getSimpleName().concat(" must bind before unbind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r1 = AoExceptionReporter.a;
        AoExceptionReporter.b(ErrorPriority.p1, "AosRecyclerItemViewHolder", null, r0, 20);
        goto L9
    L8:
        throw new RuntimeException(r0);
    L9:
        this.b = false;
        V3();
    }

    public AosRecyclerItemViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    public final <T extends View> T T3(int r2) {
        return (T) ((RecyclerView.ViewHolder) this).itemView.findViewById(r2);
    }
}
