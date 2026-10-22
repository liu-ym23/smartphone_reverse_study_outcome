package com.bytedance.awemeopen.apps.framework.framework.recyclerview;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerItemViewHolder;", ExifInterface.TAG_MODEL, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosRecyclerItemViewHolder<Model> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Model f197004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f197005b;

    public static final class a {
    }

    static {
    }

    public abstract void U3(Model r100, int r101);

    public abstract void V3();

    public final void W3() {
        if (this.f197005b == true) goto L9;
        String r100 = getClass().getSimpleName().concat(" must bind before unbind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r101 = AoExceptionReporter.f198706a;
        AoExceptionReporter.b(ErrorPriority.f198711p1, "AosRecyclerItemViewHolder", null, r100, 20);
        goto L9
    L8:
        throw new RuntimeException(r100);
    L9:
        this.f197005b = false;
        V3();
    }

    public AosRecyclerItemViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    public final <T extends View> T T3(int r100) {
        return (T) this.itemView.findViewById(r100);
    }
}
