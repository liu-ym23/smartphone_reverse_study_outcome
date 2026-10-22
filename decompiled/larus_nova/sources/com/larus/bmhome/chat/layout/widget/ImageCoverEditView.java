package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.common.databinding.LarusLayoutImageCoverEditBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ImageCoverEditView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutImageCoverEditBinding;", "bindView", "", "viewData", "Lcom/larus/bmhome/chat/layout/widget/ImageCoverEditViewData;", "actionListener", "Lcom/larus/bmhome/chat/layout/widget/IImageCoverEditActionListener;", "setActionListener", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageCoverEditView extends LinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f304823b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutImageCoverEditBinding f304824a;

    public ImageCoverEditView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ImageCoverEditView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setActionListener(final i0 r100) {
        Intrinsics.checkNotNullParameter(r100, "actionListener");
        this.f304824a.f323998e.setOnClickListener(new j0(r100));
        this.f304824a.f323995b.setOnClickListener(new k0(r100));
    }

    public final void a(n0 r100, final i0 r101) {
        Intrinsics.checkNotNullParameter(r100, "viewData");
        if (r101 == null) goto L5;
        this.f304824a.f323998e.setOnClickListener(new l0(r101));
        this.f304824a.f323995b.setOnClickListener(new m0(r101));
    L5:
        Boolean r102 = r100.f305233a;
        Boolean r103 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r103) == false) goto L11;
        if (Intrinsics.areEqual(r100.f305234b, r103) == false) goto L11;
        com.larus.utils.e1.x(this.f304824a.f323998e);
        com.larus.utils.e1.x(this.f304824a.f323995b);
        com.larus.utils.e1.x(this.f304824a.f323999f);
        com.larus.utils.e1.o(this.f304824a.f323997d);
        return;
    L11:
        if (Intrinsics.areEqual(r100.f305233a, r103) == false) goto L16;
        if (Intrinsics.areEqual(r100.f305234b, r103) == true) goto L16;
        com.larus.utils.e1.x(this.f304824a.f323998e);
        com.larus.utils.e1.o(this.f304824a.f323995b);
        com.larus.utils.e1.o(this.f304824a.f323999f);
        return;
    L16:
        if (Intrinsics.areEqual(r100.f305233a, r103) == false) goto L18;
    L20:
        com.larus.utils.e1.o(this.f304824a.f323998e);
        com.larus.utils.e1.o(this.f304824a.f323995b);
        return;
    L18:
        if (Intrinsics.areEqual(r100.f305234b, r103) == false) goto L20;
        com.larus.utils.e1.o(this.f304824a.f323998e);
        com.larus.utils.e1.x(this.f304824a.f323995b);
        com.larus.utils.e1.o(this.f304824a.f323996c);
    }

    public ImageCoverEditView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_image_cover_edit, this);
        int r102 = R.id.image_ai_beautify;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.image_ai_beautify);
        if (r103 == null) goto L17;
        r102 = R.id.image_ai_beautify_icon;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.image_ai_beautify_icon);
        if (r104 == null) goto L17;
        r102 = R.id.image_ai_beautify_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.image_ai_beautify_text);
        if (r105 == null) goto L17;
        r102 = R.id.image_ai_video;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.image_ai_video);
        if (r106 == null) goto L17;
        r102 = R.id.image_ai_video_icon;
        AppCompatImageView r107 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.image_ai_video_icon);
        if (r107 == null) goto L17;
        r102 = R.id.image_ai_video_text;
        if (((TextView) ViewBindings.findChildViewById(this, R.id.image_ai_video_text)) == null) goto L17;
        this.f304824a = new LarusLayoutImageCoverEditBinding(this, r103, r104, r105, r106, r107);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public /* synthetic */ ImageCoverEditView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
