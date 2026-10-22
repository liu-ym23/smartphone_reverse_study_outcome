package com.larus.bmhome.chat.markdown.reference;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.auth.DeepThinkingConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.adapter.MessageReferenceAdapter;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.layout.widget.AtMostHeightLinearLayout;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import com.larus.mainbot.impl.databinding.LarusMdThinkEmphasizeSearchReferenceBinding;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoRef;
import fh8.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.d6;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 j2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001jB\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00108\u001a\u00020\u000bH\u0002JW\u00109\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010\u00022\u0006\u0010;\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010<\u001a\u0004\u0018\u00010\r2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\b\u0010>\u001a\u0004\u0018\u00010?2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010AH\u0016¢\u0006\u0002\u0010CJ>\u00109\u001a\u00020\u00192\u0006\u0010D\u001a\u0002072\u0006\u0010E\u001a\u00020F2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\r2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u0014\u0018\u00010HH\u0016J9\u0010J\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A2\b\u0010<\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010KJ5\u0010L\u001a\u00020B2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010MJ.\u0010N\u001a\u00020B2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u0014\u0018\u00010H2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010D\u001a\u000207H\u0002J\u0012\u0010O\u001a\u00020B2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\b\u0010P\u001a\u00020BH\u0002J\b\u0010Q\u001a\u00020BH\u0002J\b\u0010R\u001a\u00020BH\u0002J5\u0010S\u001a\u00020B2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A2\n\b\u0003\u0010<\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010MJ\b\u0010T\u001a\u00020BH\u0002J\u0018\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020XH\u0002J\u0010\u0010Y\u001a\u00020I2\u0006\u0010V\u001a\u00020\rH\u0002J\u0018\u0010Z\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020XH\u0002J\b\u0010[\u001a\u00020IH\u0002J\b\u0010\\\u001a\u00020BH\u0002J\b\u0010]\u001a\u00020^H\u0002J\b\u0010_\u001a\u00020BH\u0002J\b\u0010`\u001a\u00020BH\u0002J\b\u0010a\u001a\u00020BH\u0002J\b\u0010b\u001a\u00020BH\u0002J\b\u0010c\u001a\u00020\u000bH\u0002J\b\u0010d\u001a\u00020BH\u0002J\b\u0010e\u001a\u00020fH\u0002J\b\u0010g\u001a\u00020hH\u0016J\b\u0010i\u001a\u00020BH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b*\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R?\u00100\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u0002 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u0002\u0018\u000101018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\"\u001a\u0004\b3\u00104R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/larus/bmhome/chat/markdown/reference/MarkdownReferenceWidget;", "Lcom/larus/bmhome/chat/markdown/reference/AbsSearchResultBlockWidget;", "Lcom/larus/bmhome/chat/markdown/reference/SearchReferenceData;", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isUserClick", "", "lastStage", "", "Ljava/lang/Integer;", "toolType", "Lcom/larus/bmhome/chat/markdown/reference/ToolType;", "referenceData", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "spanSize", "Landroid/util/Size;", "haveInflateView", "haveReportCardShow", "lastOnItemCompletelyShowCallBackWrapper", "Lcom/larus/common_ui/utils/OnItemCompletelyShowCallBackWrapper;", "enableTrackerOptimize", "getEnableTrackerOptimize", "()Z", "enableTrackerOptimize$delegate", "Lkotlin/Lazy;", "markDownReferenceView", "Lcom/larus/bmhome/chat/markdown/reference/EmphasizeReferenceViewImpl;", "getMarkDownReferenceView", "()Lcom/larus/bmhome/chat/markdown/reference/EmphasizeReferenceViewImpl;", "markDownReferenceView$delegate", "referenceListZoomInView", "Lcom/larus/bmhome/chat/markdown/reference/ReferenceListZoomInView;", "getReferenceListZoomInView", "()Lcom/larus/bmhome/chat/markdown/reference/ReferenceListZoomInView;", "referenceListZoomInView$delegate", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "isFold", "typeToken", "Lcom/google/gson/reflect/TypeToken;", "kotlin.jvm.PlatformType", "getTypeToken", "()Lcom/google/gson/reflect/TypeToken;", "typeToken$delegate", "currentTextView", "Landroid/widget/TextView;", "isHaveSearchKeywordsAndReference", "bindData", "data", "maxWidth", "backgroundResource", "forceHideArrow", "blockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "onClickInterceptor", "Lkotlin/Function0;", "", "(Lcom/larus/bmhome/chat/markdown/reference/SearchReferenceData;ILcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;Lkotlin/jvm/functions/Function0;)Landroid/util/Size;", "textView", "text", "Landroid/text/Spanned;", WsConstants.KEY_PAYLOAD, "", "", "internalBindData", "(ILjava/lang/Boolean;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;)Landroid/util/Size;", "refreshWidgetUI", "(Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;)V", "parseAndInitData", "initData", "tryInitWidgetLayout", "initReferenceBinding", "updateMarkdownLoading", "updateReferenceTitle", "initReferenceList", "itemShowFilter", "index", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemCardId", "itemShowCallBack", "transformCardType", "updateReferenceList", "createReferenceListAdapter", "Lcom/larus/bmhome/chat/adapter/MessageReferenceAdapter;", "mobCardShow", "clickSearchInWebSearchAndScholarSearch", "clickSearchInLinkReader", "generateDataListSource", "shouldHideMarkdownReference", "refreshReferenceWidget", "provideChatParam", "Lcom/larus/bmhome/chat/ChatParam;", "asView", "Landroid/view/View;", "onRecycle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownReferenceWidget extends AbsSearchResultBlockWidget<SearchReferenceData> implements usc.f {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f307130r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f307131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f307132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ToolType f307133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SearchReferenceData f307134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Object> f307135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public usc.e f307136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Size f307137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f307138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f307139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d6 f307140j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f307141k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f307142l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f307143m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public fh8.f f307144n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f307145o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f307146p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f307147q;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f307148a = null;

        static {
            int[] r100 = new int[ToolType.values().length];
            r100[ToolType.LinkReader.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ToolType.SearchPlugin.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ToolType.ScholarSearch.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f307148a = r100;
        }
    }

    static {
    }

    @Override // usc.f
    public final void a() {
    }

    @Override // usc.f
    public final View asView() {
        return this;
    }

    @Override // usc.f
    public final Integer b(Size r100, TextView r101, Canvas r102, Paint r103) {
        return null;
    }

    @Override // usc.f
    public final Size c(TextView r100, usc.e r101, Map<String, ? extends Object> r102) {
        return null;
    }

    @Override // usc.f
    public final void e() {
    }

    @Override // usc.f
    public final void f() {
        this.f307131a = false;
        this.f307139i = false;
        getMarkDownReferenceView().b();
    }

    private final boolean getEnableTrackerOptimize() {
        return ((Boolean) this.f307141k.getValue()).booleanValue();
    }

    private final e getMarkDownReferenceView() {
        return (e) this.f307142l.getValue();
    }

    private final ReferenceListZoomInView getReferenceListZoomInView() {
        return (ReferenceListZoomInView) this.f307143m.getValue();
    }

    private final TypeToken<SearchReferenceData> getTypeToken() {
        return (TypeToken) this.f307146p.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.bmhome.chat.markdown.reference.n] */
    public final void k() {
        if (r.b(this.f307134d) == true) goto L6;
        return;
    L6:
        if (this.f307139i == false) goto L8;
        return;
    L8:
        this.f307139i = true;
        final ?? r100 = new n(this);
        if (getEnableTrackerOptimize() == false) goto L11;
        t0.a(new o(r100));
        return;
    L11:
        Unit r101 = (Unit) r100.invoke();
    }

    public final ChatParam l() {
        fh8.f r100 = this.f307144n;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f477076f;
    L6:
        if (r100 == null) goto L9;
        r101 = r100.f477071a;
    L9:
        return new ChatParam(null, null, r102, "chat", r101, VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL);
    L5:
        r102 = null;
        goto L6
    }

    public MarkdownReferenceWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void i(fh8.f r100) {
        this.f307144n = r100;
        ToolType.a r101 = ToolType.Companion;
        SearchReferenceData r102 = this.f307134d;
        List<Reference> r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getToolType();
    L6:
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r101.getClass();
        ToolType r105 = ToolType.a.a(r104);
        this.f307133c = r105;
        if (r.d(r105) == false) goto L37;
        SearchReferenceData r106 = this.f307134d;
        if (r106 == null) goto L13;
        List<String> r107 = r106.getQueries();
    L14:
        List<String> r108 = r107;
        boolean r109 = false;
        if (r108 != null) goto L17;
    L20:
        boolean r110 = true;
    L21:
        if (r110 == false) goto L36;
        SearchReferenceData r111 = this.f307134d;
        if (r111 == null) goto L25;
        r103 = r111.getReference();
    L25:
        List<Reference> r112 = r103;
        if (r112 != null) goto L28;
    L31:
        boolean r113 = true;
    L32:
        if (r113 == false) goto L36;
        if (r.d(this.f307133c) == false) goto L36;
        r109 = true;
        goto L36
    L28:
        if (r112.isEmpty() == true) goto L31;
        r113 = false;
    L36:
        if (r109 == true) goto L37;
        return;
    L17:
        if (r108.isEmpty() == true) goto L20;
        r110 = false;
        goto L21
    L13:
        r107 = null;
    L37:
        this.f307145o = true;
        return;
    L5:
        r104 = null;
        goto L6
    }

    public MarkdownReferenceWidget(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f307132b = -1;
        this.f307133c = ToolType.None;
        this.f307135e = new ArrayList();
        this.f307137g = new Size(0, 0);
        this.f307141k = LazyKt.lazy(new h());
        this.f307142l = LazyKt.lazy(new i());
        this.f307143m = LazyKt.lazy(new j(r100));
        e0 r102 = AuthModelDelegate.f297134b.e().getValue();
        if (r102 == null) goto L9;
        LaunchInfo r103 = r102.f297186a;
        if (r103 == null) goto L9;
        DeepThinkingConfig r104 = r103.S();
        if (r104 == null) goto L9;
        boolean r105 = r104.b();
    L10:
        this.f307145o = r105;
        this.f307146p = LazyKt.lazy(new k());
        return;
    L9:
        r105 = true;
        goto L10
    }

    public final Size j(int r210, Boolean r211, final Function0<Unit> r212, Integer r213) {
        Integer r100 = null;
        boolean r101 = true;
        int r102 = 0;
        if (this.f307134d == null) goto L27;
        fh8.f r103 = this.f307144n;
        if (r103 == null) goto L10;
        Message r104 = r103.f477072b;
        if (r104 == null) goto L10;
        Integer r105 = Integer.valueOf(r104.getMessageStatusLocal());
    L11:
        if (r105 != null) goto L14;
    L15:
        if (r105 != null) goto L18;
    L20:
        boolean r106 = false;
    L23:
        if (r.c(this.f307134d) == false) goto L26;
        if (r106 == true) goto L27;
    L26:
        if (r.a(this.f307134d) == true) goto L27;
        boolean r107 = false;
    L29:
        if (r107 == false) goto L32;
        this.f307137g = new Size(0, 0);
        getMarkDownReferenceView().b();
        return this.f307137g;
    L32:
        LarusMdThinkEmphasizeSearchReferenceBinding r108 = getMarkDownReferenceView().f307157a;
        if (r108 == null) goto L37;
        AtMostHeightLinearLayout r109 = r108.f358754a;
        if (r109 == null) goto L37;
        e1.x(r109);
    L37:
        this.f307135e.clear();
        SearchReferenceData r110 = this.f307134d;
        if (r110 == null) goto L51;
        List<Reference> r111 = r110.getReference();
        if (r111 == null) goto L51;
        Iterator<T> r112 = r111.iterator();
    L43:
        if (r112.hasNext() == false) goto L51;
        Reference r113 = (Reference) r112.next();
        TextCard r114 = r113.getTextCard();
        if (r114 == null) goto L47;
        this.f307135e.add(r114);
    L47:
        VideoCard r115 = r113.getVideoCard();
        if (r115 == null) goto L43;
        this.f307135e.add(r115);
    L51:
        if (this.f307138h == true) goto L64;
        AtMostHeightLinearLayout r116 = getMarkDownReferenceView().c(getContext(), this);
        if (r116 == null) goto L60;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        if (r117 == null) goto L59;
        r117.width = -1;
        r117.height = -1;
        r116.setLayoutParams(r117);
        goto L60
    L59:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L60:
        AtMostHeightRecyclerView r118 = getMarkDownReferenceView().a();
        if (r118 == null) goto L63;
        r118.setLayoutManager(new LinearLayoutManager(getContext()));
        r118.addItemDecoration(new MarkdownReferenceWidget$initReferenceList$1$1(this));
        y6.h(r118, this.f307140j);
        this.f307140j = y6.e(r118, new MarkdownReferenceWidget$initReferenceList$1$3(this), new MarkdownReferenceWidget$initReferenceList$1$2(this), new MarkdownReferenceWidget$initReferenceList$1$4(this));
    L63:
        k();
        this.f307138h = true;
    L64:
        Integer r119 = this.f307132b;
        int r120 = Stage.Searching.getValue();
        if (r119 != null) goto L68;
    L70:
        boolean r121 = false;
    L71:
        if (r121 == true) goto L73;
    L75:
        boolean r122 = false;
    L76:
        AtMostHeightRecyclerView r123 = getMarkDownReferenceView().a();
        if (r123 == null) goto L121;
        if (r.b(this.f307134d) == true) goto L81;
    L83:
        boolean r124 = false;
    L84:
        if (r124 == false) goto L86;
        int r125 = 0;
    L87:
        r123.setVisibility(r125);
        if (AccountService.f365697a.isEnterpriseAccount() == false) goto L114;
        ArrayList<Object> r126 = this.f307135e;
        if ((r126 instanceof Collection) == true) goto L92;
    L94:
        Iterator<Object> r127 = r126.iterator();
    L96:
        if (r127.hasNext() == false) goto L111;
        Object r128 = r127.next();
        boolean r129 = r128 instanceof TextCard;
        if (r129 == false) goto L108;
        if (r129 == false) goto L101;
        TextCard r130 = (TextCard) r128;
    L102:
        if (r130 == null) goto L104;
        String r131 = r130.getIconUrl();
    L106:
        if (o0.d(r131) == false) goto L108;
        boolean r132 = true;
    L109:
        if (r132 == true) goto L96;
        boolean r133 = false;
    L112:
        if (r133 == false) goto L114;
        boolean r134 = true;
    L115:
        ArrayList<Object> r135 = this.f307135e;
        Function1 r136 = new l(this);
        Context r137 = getContext();
        boolean r138 = false;
        fh8.f r139 = this.f307144n;
        if (r139 == null) goto L118;
        String r140 = r139.f477071a;
    L119:
        r123.setAdapter(new MessageReferenceAdapter(r134, r135, r136, r137, r138, r140, true, false, new m(this)));
        getMarkDownReferenceView().g(r122, this.f307145o);
        goto L121
    L118:
        r140 = null;
        goto L119
    L104:
        r131 = null;
        goto L106
    L101:
        r130 = null;
    L108:
        r132 = false;
    L111:
        r133 = true;
        goto L112
    L92:
        if (r126.isEmpty() == false) goto L94;
    L114:
        r134 = false;
        goto L115
    L86:
        r125 = 8;
        goto L87
    L81:
        if (this.f307145o == true) goto L83;
        r124 = true;
    L121:
        if (r.c(this.f307134d) == false) goto L135;
        usc.e r141 = this.f307136f;
        if (r141 == null) goto L125;
        r141.j();
    L125:
        fh8.f r142 = this.f307144n;
        if (r142 == null) goto L130;
        String r143 = r142.f477080j;
        if (r143 == null) goto L130;
        com.larus.bmhome.chat.markdown.imagegroup.c.b(r143);
    L130:
        e r144 = getMarkDownReferenceView();
        boolean r145 = this.f307145o;
        ToolType r146 = this.f307133c;
        SearchReferenceData r147 = this.f307134d;
        r144.getClass();
        Intrinsics.checkNotNullParameter(r146, "toolType");
        DeepThinkCommonToolHeader r148 = r144.f307158b;
        if (r148 == null) goto L133;
        r148.c(com.larus.bmhome.chat.markdown.reference.a.b(r147));
    L133:
        r144.f(r213);
        r144.d(r145, r146, r147, r211);
    L137:
        TextView r149 = this.f307147q;
        if (r149 == null) goto L142;
        ViewParent r150 = r149.getParent();
        if (r150 == null) goto L142;
        ViewParent r151 = r150.getParent();
    L144:
        if ((r151 instanceof ViewGroup) == false) goto L146;
        ViewGroup r152 = (ViewGroup) r151;
    L147:
        if (r152 == null) goto L149;
        Object r153 = r152.getTag(R.id.single_loading_span);
    L151:
        if ((r153 instanceof v0) == true) goto L153;
    L158:
        e r154 = getMarkDownReferenceView();
        SearchReferenceData r155 = this.f307134d;
        boolean r156 = this.f307145o;
        int r157 = y.a(r210);
        r154.getClass();
        if (r155 == null) goto L163;
        List<String> r158 = r155.getQueries();
        if (r158 == null) goto L163;
        int r159 = r158.size();
    L164:
        boolean r160 = r.c(r155);
        int r161 = View.MeasureSpec.makeMeasureSpec(r157, Integer.MIN_VALUE);
        DeepThinkCommonToolHeader r162 = r154.f307158b;
        if (r162 == null) goto L167;
        r162.measure(r161, 0);
    L167:
        DeepThinkCommonToolHeader r163 = r154.f307158b;
        if (r163 == null) goto L178;
        Integer r164 = Integer.valueOf(r163.getMeasuredHeight());
        if (r164.intValue() <= 0) goto L172;
        boolean r165 = true;
    L173:
        if (r165 == true) goto L176;
        r164 = null;
    L176:
        if (r164 == null) goto L178;
        int r166 = r164.intValue();
    L179:
        if (r156 == true) goto L183;
        if (r160 == true) goto L183;
        boolean r167 = false;
    L184:
        if (r156 == false) goto L186;
    L191:
        boolean r168 = true;
    L192:
        int r169 = View.MeasureSpec.makeMeasureSpec(r157 - (i5.c() * 2), Integer.MIN_VALUE);
        if (r168 == true) goto L204;
        LarusMdThinkEmphasizeSearchReferenceBinding r170 = r154.f307157a;
        if (r170 == null) goto L199;
        TextView r171 = r170.f358756c;
        if (r171 == null) goto L199;
        r171.measure(r169, 0);
    L199:
        LarusMdThinkEmphasizeSearchReferenceBinding r172 = r154.f307157a;
        if (r172 == null) goto L204;
        TextView r173 = r172.f358756c;
        if (r173 == null) goto L204;
        int r174 = r173.getMeasuredHeight();
    L205:
        if (r167 == true) goto L216;
        LarusMdThinkEmphasizeSearchReferenceBinding r175 = r154.f307157a;
        if (r175 == null) goto L211;
        AtMostHeightRecyclerView r176 = r175.f358757d;
        if (r176 == null) goto L211;
        r176.measure(r161, 0);
    L211:
        LarusMdThinkEmphasizeSearchReferenceBinding r177 = r154.f307157a;
        if (r177 == null) goto L216;
        AtMostHeightRecyclerView r178 = r177.f358757d;
        if (r178 == null) goto L216;
        int r179 = r178.getMeasuredHeight();
    L217:
        int r180 = (r166 + r174) + r179;
        if (r156 == false) goto L220;
        if (r160 == true) goto L220;
    L226:
        DeepThinkCommonToolHeader r181 = r154.f307158b;
        if (r181 == null) goto L230;
        r102 = r181.getMeasuredWidth();
    L230:
        this.f307137g = new Size(r102, r180);
        k();
        SearchReferenceData r182 = this.f307134d;
        if (r182 == null) goto L233;
        r100 = r182.getStage();
    L233:
        this.f307132b = r100;
        return this.f307137g;
    L220:
        if (r155 != null) goto L222;
    L224:
        r101 = false;
    L225:
        if (r101 == true) goto L226;
        r102 = r157;
        goto L230
    L222:
        if (r155.isHeaderWrapContent() != true) goto L224;
    L216:
        r179 = 0;
    L204:
        r174 = 0;
        goto L205
    L186:
        if (((Boolean) r154.f307160d.getValue()).booleanValue() == false) goto L191;
        if (r159 == 0) goto L191;
        if (r160 == true) goto L191;
        r168 = false;
    L183:
        r167 = true;
        goto L184
    L172:
        r165 = false;
    L178:
        r166 = ((Number) r154.f307159c.getValue()).intValue();
    L163:
        r159 = 0;
        goto L164
    L153:
        if (r.c(this.f307134d) == false) goto L156;
        v0 r183 = (v0) r153;
        r183.f305293o = true;
        r183.a();
        r183.f305288j = 0;
        goto L158
    L156:
        if (r.b(this.f307134d) == false) goto L158;
        v0 r184 = (v0) r153;
        r184.f305293o = false;
        r184.b();
        goto L158
    L149:
        r153 = null;
        goto L151
    L146:
        r152 = null;
    L142:
        r151 = null;
        goto L144
    L135:
        if (r.b(this.f307134d) == false) goto L137;
        getMarkDownReferenceView().e(this.f307133c, this.f307131a, this.f307134d, this.f307135e, getContext(), this.f307145o, r213, r211, new g(r212, this));
        goto L137
    L73:
        if (r.b(this.f307134d) == false) goto L75;
        r122 = true;
        goto L76
    L68:
        if (r119.intValue() != r120) goto L70;
        r121 = true;
        goto L71
    L18:
        if (r105.intValue() != 22) goto L20;
    L21:
        r106 = true;
        goto L23
    L14:
        if (r105.intValue() == 23) goto L21;
    L10:
        r105 = null;
    L27:
        r107 = true;
        goto L29
    }

    @Override // usc.f
    public final Size d(TextView r100, Spanned r101, final usc.e r102, int r103, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "span");
        fh8.f r104 = fh8.h.b(r110);
        final TypeToken<SearchReferenceData> r105 = getTypeToken();
        if (r104 == null) goto L5;
        final Message r106 = r104.f477072b;
    L6:
        Intrinsics.checkNotNullParameter("MarkdownReferenceWidget", "source");
        Intrinsics.checkNotNullParameter(r102, "span");
        Intrinsics.checkNotNullParameter(r105, "data");
        Object r107 = fh8.b.a(r102, new lh8.a(r106, r102, r105));     // Catch: Exception -> L9
    L11:
        this.f307134d = (SearchReferenceData) r107;
        this.f307147q = r100;
        this.f307136f = r102;
        i(fh8.h.b(r110));
        return j(r103, null, null, null);
    L9:
        e = move-exception;
        FLogger.f375446a.e("MarkdownReferenceWidget", "bindData called failed, " + e.getMessage());
        EnsureManager.ensureNotReachHere(e);
        r107 = null;
        goto L11
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.markdown.reference.AbsSearchResultBlockWidget
    public final Size g(SearchReferenceData r100, int r101, fh8.f r102, Integer r103, Boolean r104, Function0 r105) {
        this.f307134d = r100;
        i(r102);
        return j(r101, r104, r105, r103);
    }
}
