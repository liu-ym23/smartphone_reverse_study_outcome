package zn8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.mainbot.impl.databinding.LarusMdVideoGroupShortBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusMdVideoGroupShortBinding f572959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f572960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f572961c;

    @Override // zn8.a
    public final MarkdownSourceImageView getCiciSourceIcon() {
        return this.f572959a.f358764d;
    }

    @Override // zn8.a
    public final ViewGroup getContentView() {
        return this.f572959a.f358761a;
    }

    @Override // zn8.a
    public final SimpleDraweeView getCoverView() {
        return this.f572959a.f358762b;
    }

    @Override // zn8.a
    public final SimpleDraweeView getDySourceLabelView() {
        return this.f572959a.f358763c;
    }

    @Override // zn8.a
    public final TextView getTitleView() {
        return this.f572959a.f358766f;
    }

    @Override // zn8.a
    public final TextView getTvImageCaption() {
        return this.f572959a.f358765e;
    }

    @Override // zn8.a
    public final int getWidgetHeight() {
        return ((Number) this.f572960b.getValue()).intValue();
    }

    @Override // zn8.a
    public final int getWidgetWidth() {
        return ((Number) this.f572961c.getValue()).intValue();
    }

    public k(Context r100, ViewGroup r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "parent");
        View r101 = LayoutInflater.from(r100).inflate(R.layout.larus_md_video_group_short, r110, false);
        r110.addView(r101);
        int r111 = R.id.md_video_group_cover;
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.md_video_group_cover);
        if (r102 == null) goto L15;
        LinearLayout r103 = (LinearLayout) r101;
        r111 = R.id.md_video_group_source_label;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.md_video_group_source_label);
        if (r104 == null) goto L15;
        r111 = R.id.sourceIcon;
        MarkdownSourceImageView r105 = (MarkdownSourceImageView) ViewBindings.findChildViewById(r101, R.id.sourceIcon);
        if (r105 == null) goto L15;
        r111 = R.id.tvMdBottomCaption;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r101, R.id.tvMdBottomCaption);
        if (r106 == null) goto L15;
        r111 = R.id.videoTitle;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r101, R.id.videoTitle);
        if (r107 == null) goto L15;
        this.f572959a = new LarusMdVideoGroupShortBinding(r103, r102, r104, r105, r106, r107);
        this.f572960b = LazyKt.lazy(new i(this));
        this.f572961c = LazyKt.lazy(new j(this));
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r111)));
    }
}
