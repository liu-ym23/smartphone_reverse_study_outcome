package com.larus.bmhome.chat.markdown.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sh8.o;
import sh8.p;
import sh8.q;
import sh8.r;
import sh8.s;
import th8.f;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJa\u0010(\u001a\u00020)2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\"\b\u0002\u0010/\u001a\u001c\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u00020302\u0012\u0004\u0012\u00020)\u0018\u000100¢\u0006\u0002\u00104JB\u00105\u001a\b\u0012\u0004\u0012\u000203022\u0006\u0010,\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010+2 \u0010/\u001a\u001c\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u00020302\u0012\u0004\u0012\u00020)\u0018\u000100H\u0002J\u001e\u00106\u001a\u00020)2\f\u00107\u001a\b\u0012\u0004\u0012\u000203022\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010:\u001a\u00020)2\u0006\u00109\u001a\u00020\u0012H\u0002J\u0012\u0010;\u001a\u0002012\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0012\u0010<\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J,\u0010=\u001a\u0004\u0018\u0001032\u0006\u0010<\u001a\u00020\u00122\u0006\u0010>\u001a\u0002012\u0006\u0010,\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J0\u0010?\u001a\b\u0012\u0004\u0012\u0002030@2\u0006\u0010<\u001a\u00020\u00122\u0006\u0010>\u001a\u0002012\u0006\u0010,\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J&\u0010A\u001a\b\u0012\u0004\u0012\u000203022\f\u0010B\u001a\b\u0012\u0004\u0012\u0002030@2\b\u0010C\u001a\u0004\u0018\u000103H\u0002J\b\u0010D\u001a\u00020\bH\u0016J\b\u0010E\u001a\u00020\u0012H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0011\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0017\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001a\u0010\u0013R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b!\u0010\u0013R\u000e\u0010#\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'¨\u0006G"}, d2 = {"Lcom/larus/bmhome/chat/markdown/view/VlmMixedMediaCardView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/larus/bmhome/chat/markdown/vlm/IVlmImageWidgetService;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "sizeConfig", "Lcom/larus/bmhome/chat/markdown/vlm/VlmSizeCalculateInterfaceImpl$SizeConfig;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/larus/bmhome/chat/markdown/vlm/VlmSizeCalculateInterfaceImpl$SizeConfig;)V", "IMAGE_CONTINAER_MARGIN", "IMAGE_BETWEEN_MARGIN", "vlmImageAdapter", "Lcom/larus/bmhome/chat/markdown/vlm/VlmImageAdapter;", "isRelatedVideoEnabled", "", "()Z", "isRelatedVideoEnabled$delegate", "Lkotlin/Lazy;", "showVideoFirst", "getShowVideoFirst", "showVideoFirst$delegate", "showImageFirst", "getShowImageFirst", "showImageFirst$delegate", "sizeCalculator", "Lcom/larus/bmhome/chat/markdown/vlm/VlmSizeCalculateInterfaceImpl;", "getSizeCalculator", "()Lcom/larus/bmhome/chat/markdown/vlm/VlmSizeCalculateInterfaceImpl;", "sizeCalculator$delegate", "isDeepThinking", "isDeepThinking$delegate", "isInited", "toolType", "Lcom/larus/bmhome/chat/markdown/reference/ToolType;", "cardPosition", "Ljava/lang/Integer;", "bindData", "", "data", "Lcom/larus/im/bean/message/VLMMixerSearchResult;", "maxWidth", "markdownDataManager", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "onRenderModelCallback", "Lkotlin/Function2;", "Lcom/larus/bmhome/chat/markdown/vlm/FlowVLMContainerViewType;", "", "Lcom/larus/bmhome/chat/markdown/vlm/VlmImageRenderInfo;", "(Ljava/lang/Integer;Lcom/larus/im/bean/message/VLMMixerSearchResult;ILcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;Lcom/larus/bmhome/chat/markdown/reference/ToolType;Lkotlin/jvm/functions/Function2;)V", "processRenderUIModelList", "refreshUIRenderList", "renderList", "tryInitRecyclerView", "isSingleImage", "setupRecyclerViewItemDecoration", "processShowType", "isVideoAndImageMix", "generateVideoRenderInfo", "flowVLMContainerViewType", "generateImageRenderInfo", "", "generateFinialRenderList", "imageRenderInfoList", "videoRenderInfo", "getWidgetOrder", "isDeepThinkVlm", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VlmMixedMediaCardView extends RecyclerView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f307308h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f307309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f307310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f307311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f307312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f307313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f307314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f307315g;

    public static final class a {
    }

    static {
    }

    public VlmMixedMediaCardView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public VlmMixedMediaCardView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public VlmMixedMediaCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public int getWidgetOrder() {
        return -1;
    }

    private final boolean getShowImageFirst() {
        return ((Boolean) this.f307313e.getValue()).booleanValue();
    }

    private final boolean getShowVideoFirst() {
        return ((Boolean) this.f307312d.getValue()).booleanValue();
    }

    private final f getSizeCalculator() {
        return (f) this.f307314f.getValue();
    }

    private final void setupRecyclerViewItemDecoration(final boolean r100) {
        addItemDecoration(new AnonymousClass1(r100, this));
    }

    public VlmMixedMediaCardView(Context r100, AttributeSet r101, int r102, int r103) {
        final f.b r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r104 = new f.b(false, c7.b(400), c7.b(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME)), c7.b(150));
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "sizeConfig");
        super(r100, r101, r102);
        this.f307309a = c7.b(16);
        this.f307310b = c7.b(8);
        this.f307311c = LazyKt.lazy(new o());
        this.f307312d = LazyKt.lazy(new p());
        this.f307313e = LazyKt.lazy(new q());
        this.f307314f = LazyKt.lazy(new r(r104));
        this.f307315g = LazyKt.lazy(new s(r104));
    }
}
