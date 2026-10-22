package com.bytedance.awemeopen.apps.framework.feed.mix;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MixAwemeListViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f194957e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AoImageView f194958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f194959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f194960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f194961d;

    public static final class a {
    }

    static {
    }

    public MixAwemeListViewHolder(View r100, AoImageView r101, TextView r102, TextView r103, TextView r104) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "img");
        Intrinsics.checkNotNullParameter(r102, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r103, "time");
        Intrinsics.checkNotNullParameter(r104, "likeCount");
        super(r100);
        this.f194958a = r101;
        this.f194959b = r102;
        this.f194960c = r103;
        this.f194961d = r104;
    }
}
