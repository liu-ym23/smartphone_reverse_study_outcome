package com.larus.uaigc.chat.markdown.video;

import android.content.Context;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.markdown.AbsCustomCreationDataWidget;
import com.larus.uaigc.chat.markdown.helper.j0;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010*\u001a\u00020+H\u0016JR\u0010,\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020%2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000200\u0018\u00010/H\u0014J(\u00105\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010-\u001a\u00020%H\u0002J\u0010\u00106\u001a\u00020+2\u0006\u0010-\u001a\u00020%H\u0002J\u0010\u00107\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020+H\u0002J\u0016\u00109\u001a\u00020\u00152\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R*\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020302j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000203`4X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/uaigc/chat/markdown/video/MDMultiVideoWidget;", "Lcom/larus/uaigc/chat/markdown/AbsCustomCreationDataWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "spanSize", "Landroid/util/Size;", "containerLayout", "Landroid/widget/LinearLayout;", "message", "Lcom/larus/im/bean/message/Message;", "markDownData", "Lcom/larus/uaigc/chat/markdown/bean/CreationPlaceholderData;", "creationContentData", "Lcom/larus/bmhome/creative/messagecard/bean/CreationMsgContentData;", "botId", "", "isCollectMode", "", "Ljava/lang/Boolean;", "currentPage", "previousPage", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "isLongPicShare", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "lastMaxWidth", "", "Ljava/lang/Integer;", "observeMessageChangeJob", "Lkotlinx/coroutines/Job;", "hasInit", "onRecycle", "", "bindData", "maxWidth", WsConstants.KEY_PAYLOAD, "", "", "taskIdViewMap", "Ljava/util/HashMap;", "Lcom/larus/uaigc/chat/markdown/video/MDSingleVideoWidget;", "Lkotlin/collections/HashMap;", "refreshViewState", "updateSizeInfo", "initView", "addMessageChangeObserver", "judgeAnyTaskChanged", "newTasks", "", "Lcom/larus/bmhome/creative/messagecard/bean/CreationTask;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MDMultiVideoWidget extends AbsCustomCreationDataWidget {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f371182w = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AttributeSet f371183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Size f371184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f371185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Message f371186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public fz9.b f371187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CreationMsgContentData f371188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f371189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f371190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f371191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f371192l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public q0.a f371193m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ChatPageContext f371194n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f371195o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f371196p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Spanned f371197q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public usc.e f371198r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f371199s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Job f371200t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f371201u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap<String, MDSingleVideoWidget> f371202v;

    public static final class a implements Function0<ChatPageContext> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f371203a;

        public a(AttachReceiver r100) {
            this.f371203a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.bean.ChatPageContext, t1a.c] */
        @Override // kotlin.jvm.functions.Function0
        public final ChatPageContext invoke() {
            AttachReceiver r100 = this.f371203a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).g(Reflection.getOrCreateKotlinClass(ChatPageContext.class));
        }
    }

    @Override // com.larus.uaigc.chat.markdown.AbsCustomCreationDataWidget
    public final void c() {
        super.c();
        Job r100 = this.f371200t;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f371200t = null;
        Iterator<Map.Entry<String, MDSingleVideoWidget>> r101 = this.f371202v.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().getValue().f();
        goto L7
    L9:
        this.f371202v.clear();
    }

    public MDMultiVideoWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f371183c = r101;
        this.f371184d = new Size(0, 0);
        LinearLayout r102 = new LinearLayout(r100, r101);
        r102.setOrientation(1);
        this.f371185e = r102;
        this.f371190j = Boolean.FALSE;
        this.f371202v = new HashMap();
    }

    public final void e(TextView r210, Spanned r211, usc.e r212, int r213) {
        List<CreationTask> r100 = j0.e(this.f371187g, this.f371188h);
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        Set<String> r101 = this.f371202v.keySet();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L6:
        int r104 = 0;
        if (r103.hasNext() == false) goto L22;
        Object r105 = r103.next();
        String r106 = (String) r105;
        List<CreationTask> r107 = r100;
        if ((r107 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r108 = r107.iterator();
    L15:
        if (r108.hasNext() == false) goto L20;
        if (Intrinsics.areEqual(((CreationTask) r108.next()).f310760id, r106) == false) goto L15;
        r104 = 1;
    L20:
        if ((r104 ^ 1) == 0) goto L6;
        r102.add(r105);
        goto L6
    L11:
        if (r107.isEmpty() == false) goto L13;
    L22:
        Iterator r109 = r102.iterator();
    L24:
        if (r109.hasNext() == false) goto L28;
        String r110 = (String) r109.next();
        MDSingleVideoWidget r111 = this.f371202v.get(r110);
        if (r111 == null) goto L24;
        this.f371185e.removeView(r111);
        r111.f();
        this.f371202v.remove(r110);
        goto L24
    L28:
        Iterator<T> r112 = r100.iterator();
    L30:
        if (r112.hasNext() == false) goto L42;
        Object r113 = r112.next();
        int r114 = r104 + 1;
        if (r104 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        CreationTask r115 = (CreationTask) r113;
        String r116 = r115.f310760id;
        if (r116 != null) goto L37;
        String r117 = "";
    L38:
        MDSingleVideoWidget r118 = this.f371202v.get(r116);
        if (r118 != null) goto L41;
        r118 = new MDSingleVideoWidget(getContext(), this.f371183c);
        this.f371202v.put(r117, r118);
        this.f371185e.addView(r118, r104, new LinearLayout.LayoutParams(-1, -2));
    L41:
        r118.R5(LifecycleOwnerKt.getLifecycleScope(this), r115, r210, r211, r212, this.f371186f, r213, this.f371189i, this.f371191k, this.f371192l, this.f371190j, this.f371193m, this.f371195o, this.f371194n);
        r104 = r114;
        goto L30
    L37:
        r117 = r116;
        goto L38
    }

    @Override // com.larus.uaigc.chat.markdown.AbsCustomCreationDataWidget
    public final Size b(final TextView r100, Spanned r101, usc.e r110, Message r111, fz9.b r112, int r113, Map<String, ? extends Object> r114) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r110, "span");
        this.f371186f = r111;
        this.f371187g = r112;
        if (r111 == null) goto L5;
        CreationMsgContentData r115 = dp8.e.c(r111);
    L6:
        this.f371188h = r115;
        if (r114 == null) goto L9;
        fh8.f r116 = fh8.h.b(r114);
    L10:
        if (r116 == null) goto L12;
        String r117 = r116.f477074d;
    L13:
        this.f371189i = r117;
        if (r116 == null) goto L16;
        String r118 = r116.f477075e;
    L17:
        this.f371191k = r118;
        if (r116 == null) goto L20;
        String r119 = r116.f477076f;
    L21:
        this.f371192l = r119;
        if (r116 == null) goto L24;
        Boolean r120 = r116.f477078h;
    L25:
        this.f371190j = r120;
        if (r116 == null) goto L28;
        q0.a r121 = r116.f477084n;
    L29:
        this.f371193m = r121;
        if (r116 == null) goto L36;
        AttachReceiver r122 = r116.f477085o;
        if (r122 == null) goto L36;
        Lazy r123 = LazyKt.lazy(new a(r122));
        if (r123 == null) goto L36;
        ChatPageContext r124 = (ChatPageContext) r123.getValue();
    L37:
        this.f371194n = r124;
        if (r116 == null) goto L40;
        Object r125 = r116.f477086p;
    L42:
        if ((r125 instanceof ry8.d) == false) goto L44;
        ry8.d r126 = (ry8.d) r125;
    L45:
        int r127 = 0;
        if (r126 == null) goto L48;
        boolean r128 = true;
    L49:
        this.f371195o = r128;
        this.f371196p = r100;
        this.f371197q = r101;
        this.f371198r = r110;
        if (this.f371201u == true) goto L56;
        this.f371201u = true;
        this.f371185e.setOnLongClickListener(new com.larus.uaigc.chat.markdown.video.a(r100));
        removeAllViews();
        LinearLayout r129 = this.f371185e;
        r129.removeAllViews();
        addView(r129);
        Job r130 = this.f371200t;
        if (r130 == null) goto L55;
        Job.DefaultImpls.cancel$default(r130, null, 1, null);
    L55:
        this.f371200t = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new MDMultiVideoWidget$addMessageChangeObserver$1(this, null), 2, null);
    L56:
        e(r100, r101, r110, r113);
        this.f371199s = Integer.valueOf(r113);
        if (this.f371202v.isEmpty() == false) goto L59;
        this.f371184d = new Size(0, 0);
    L67:
        return this.f371184d;
    L59:
        Iterator<T> r102 = this.f371202v.values().iterator();
    L61:
        if (r102.hasNext() == false) goto L63;
        r127 = r127 + ((MDSingleVideoWidget) r102.next()).f371206a.getHeight();
        goto L61
    L63:
        LinearLayout r103 = this.f371185e;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L69;
        r104.width = r113;
        r104.height = r127;
        r103.setLayoutParams(r104);
        this.f371184d = new Size(r113, r127);
        goto L67
    L69:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L48:
        r128 = false;
        goto L49
    L44:
        r126 = null;
        goto L45
    L40:
        r125 = null;
    L36:
        r124 = null;
        goto L37
    L28:
        r121 = null;
        goto L29
    L24:
        r120 = null;
        goto L25
    L20:
        r119 = null;
        goto L21
    L16:
        r118 = null;
        goto L17
    L12:
        r117 = null;
        goto L13
    L9:
        r116 = null;
        goto L10
    L5:
        r115 = null;
        goto L6
    }
}
