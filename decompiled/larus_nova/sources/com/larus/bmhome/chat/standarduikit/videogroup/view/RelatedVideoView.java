package com.larus.bmhome.chat.standarduikit.videogroup.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import zn8.k;
import zn8.l;
import zn8.o;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 B2\u00020\u00012\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003:\u0001BB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100+2\u0006\u0010,\u001a\u00020-H\u0002J\u001a\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u00020\u0010H\u0016J\u0018\u00102\u001a\u0002032\u0006\u00100\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u0002032\u0006\u0010,\u001a\u00020-H\u0002J(\u00106\u001a\u0002032\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020;2\u0006\u00104\u001a\u00020\u0005H\u0002J(\u0010<\u001a\u0002032\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020;2\u0006\u00104\u001a\u00020\u0005H\u0002J\u001a\u0010=\u001a\u0002032\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\u000bH\u0002J\u0006\u0010A\u001a\u000203R\u000e\u0010\u000e\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0018R\u0014\u0010#\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001cR\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/videogroup/view/RelatedVideoView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/IRelatedVideoView;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/VideoGroupViewInput;", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/VideoGroupViewOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "isTall", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "binding", "widgetHeight", "", "getWidgetHeight", "()I", "widgetWidth", "getWidgetWidth", "coverView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getCoverView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "tvImageCaption", "Landroid/widget/TextView;", "getTvImageCaption", "()Landroid/widget/TextView;", "ciciSourceIcon", "Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownSourceImageView;", "getCiciSourceIcon", "()Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownSourceImageView;", "dySourceLabelView", "getDySourceLabelView", "titleView", "getTitleView", "contentView", "Landroid/view/ViewGroup;", "getContentView", "()Landroid/view/ViewGroup;", "videoTitleHeight", "calculatePaddingValues", "Lkotlin/Pair;", "sizeData", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/SizeData;", "sizeThatFits", "Landroid/util/Size;", "input", "preferredMaxWidth", "bindData", "", BdpAppEventConstant.PARAMS_OUTPUT, "updateContainer", "updateIcon", "videoData", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/VideoData;", "isOversea", "trackData", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/TrackData;", "updateCoverImage", "updateTitle", "videoTitle", "", "showVideoTitle", "onRecycle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RelatedVideoView extends FrameLayout implements zn8.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f309842c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn8.a f309843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f309844b;

    public static final class a {
    }

    static {
    }

    public RelatedVideoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, false, 6);
    }

    public RelatedVideoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, false, 4);
    }

    @Override // zn8.a
    public MarkdownSourceImageView getCiciSourceIcon() {
        return this.f309843a.getCiciSourceIcon();
    }

    @Override // zn8.a
    public ViewGroup getContentView() {
        return this.f309843a.getContentView();
    }

    @Override // zn8.a
    public SimpleDraweeView getCoverView() {
        return this.f309843a.getCoverView();
    }

    @Override // zn8.a
    public SimpleDraweeView getDySourceLabelView() {
        return this.f309843a.getDySourceLabelView();
    }

    @Override // zn8.a
    public TextView getTitleView() {
        return this.f309843a.getTitleView();
    }

    @Override // zn8.a
    public TextView getTvImageCaption() {
        return this.f309843a.getTvImageCaption();
    }

    @Override // zn8.a
    public int getWidgetHeight() {
        return this.f309843a.getWidgetHeight();
    }

    @Override // zn8.a
    public int getWidgetWidth() {
        return this.f309843a.getWidgetWidth();
    }

    public static Pair a(l r100) {
        if (r100.f572962a == false) goto L6;
        return new Pair(Integer.valueOf(i5.Y()), Integer.valueOf(i5.q()));
    L6:
        if (r100.f572963b == false) goto L13;
        if (r100.f572964c == false) goto L10;
        int r101 = i5.r0();
    L11:
        Pair r102 = new Pair(Integer.valueOf(r101), Integer.valueOf(i5.Y()));
    L18:
        return r102;
    L10:
        r101 = i5.q();
        goto L11
    L13:
        if (r100.f572964c == false) goto L15;
        int r103 = i5.r0();
    L16:
        r102 = new Pair(Integer.valueOf(r103), Integer.valueOf(i5.q()));
        goto L18
    L15:
        r103 = i5.q();
        goto L16
    }

    public RelatedVideoView(Context r100, AttributeSet r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = false;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        if (r102 == false) goto L11;
        zn8.a r104 = new o(r100, this);
    L12:
        this.f309843a = r104;
        this.f309844b = ((int) we8.a.a(((Number) i5.f552558y.getValue()).intValue(), false)) + i5.q();
        return;
    L11:
        r104 = new k(r100, this);
        goto L12
    }
}
