package com.larus.uaigc.chat.block.create.horizontal;

import android.content.Context;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.chat.ChatParam;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.uaigc.chat.block.create.AbsCreationBlockView;
import com.larus.uaigc.chat.block.widget.container.LocalCreationItemListAdapter;
import com.larus.uaigc.chat.markdown.helper.LocalCreationChatItemClickHelper;
import com.larus.uaigc.chat.markdown.helper.f1;
import com.larus.uaigc.chat.markdown.helper.g1;
import com.larus.uaigc.chat.markdown.helper.h1;
import com.larus.uaigc.impl.databinding.LarusLayoutCreationHorizontalScrollViewBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kc8.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 Q2\u00020\u0001:\u0001QB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0083\u0001\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\t2\u001a\u00100\u001a\u0016\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020!\u0018\u0001012\b\u00103\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0002\u00105J\b\u00106\u001a\u00020!H\u0016J\u0010\u00107\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0017H\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020209H\u0002J\u0010\u0010:\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0017H\u0002J\u0012\u0010;\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010<\u001a\u00020!H\u0002J\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020!0>2\u0006\u0010?\u001a\u00020@H\u0002¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u00020\u00172\u0006\u0010D\u001a\u00020EH\u0002J(\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u0002022\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010KJ\b\u0010L\u001a\u00020!H\u0016J\b\u0010M\u001a\u00020!H\u0002J\b\u0010N\u001a\u00020!H\u0002J\u0010\u0010O\u001a\u00020P2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006R"}, d2 = {"Lcom/larus/uaigc/chat/block/create/horizontal/LocalCreationHorizontalGroup;", "Lcom/larus/uaigc/chat/block/create/AbsCreationBlockView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutCreationHorizontalScrollViewBinding;", "isFirstBind", "", "scrollAdapter", "Lcom/larus/uaigc/chat/block/widget/container/LocalCreationItemListAdapter;", "getScrollAdapter", "()Lcom/larus/uaigc/chat/block/widget/container/LocalCreationItemListAdapter;", "setScrollAdapter", "(Lcom/larus/uaigc/chat/block/widget/container/LocalCreationItemListAdapter;)V", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "curMaxWidth", "", "itemSize", "Landroid/util/Size;", "getItemSize", "()Landroid/util/Size;", "setItemSize", "(Landroid/util/Size;)V", "asView", "Landroid/view/View;", "bindData", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "isLongPicShare", "blockLongClickHandler", "Lcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;", "message", "Lcom/larus/im/bean/message/Message;", "blockModel", "Lcom/larus/uaigc/chat/block/create/ICreationBizModel;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "maxContentWidth", "isLastBlockModel", "disableCreateImagePreview", "onItemLongClick", "Lkotlin/Function2;", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "(Landroidx/fragment/app/Fragment;ZLcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;Lcom/larus/im/bean/message/Message;Lcom/larus/uaigc/chat/block/create/ICreationBizModel;Lcom/larus/bmhome/chat/ChatParam;IZLjava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;)V", "onRecycle", "refreshViewState", "generateViewDataList", "", "updateSize", "initView", "binObservers", "handleCanvasAnchorEvent", "Lkotlin/Result;", "event", "Lcom/larus/canvas/service/bean/CanvasAnchorEvent;", "handleCanvasAnchorEvent-IoAF18A", "(Lcom/larus/canvas/service/bean/CanvasAnchorEvent;)Ljava/lang/Object;", "findPositionForSelectedData", "data", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "onClickItem", "itemData", "videoPlayParams", "Lcom/larus/uaigc/bean/chat/VideoPlayParams;", RootDescription.ROOT_ELEMENT, "(Lcom/larus/uaigc/chat/block/widget/CreationItemData;Lcom/larus/uaigc/bean/chat/VideoPlayParams;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reloadFailedImages", "preGenerateLocalImagePreviewCaches", "recycleResource", "provideScreenshotParams", "Lorg/json/JSONObject;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalCreationHorizontalGroup extends AbsCreationBlockView {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f370524w = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LarusLayoutCreationHorizontalScrollViewBinding f370525r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f370526s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LocalCreationItemListAdapter f370527t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f370528u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Size f370529v;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final View a() {
        return this.f370525r.f373215a;
    }

    public final LinearLayoutManager p() {
        return (LinearLayoutManager) this.f370528u.getValue();
    }

    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final void j() {
        super.j();
        int r100 = p().getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L13;
        View r102 = p().getChildAt(r101);
        if (r102 == null) goto L12;
        Object r103 = this.f370525r.f373216b.getChildViewHolder(r102);
        if ((r103 instanceof cz9.g) == false) goto L9;
        cz9.g r104 = (cz9.g) r103;
    L10:
        if (r104 == null) goto L12;
        r104.f();
        goto L12
    L9:
        r104 = null;
    L12:
        r101 = r101 + 1;
        goto L3
    }

    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final void k() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO().plus(e()), null, new LocalCreationHorizontalGroup$reloadFailedImages$1(this, null), 2, null);
    }

    public LocalCreationHorizontalGroup(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f370525r = LarusLayoutCreationHorizontalScrollViewBinding.a(LayoutInflater.from(r100));
        this.f370526s = true;
        this.f370528u = LazyKt.lazy(LazyThreadSafetyMode.NONE, new q(r100));
        this.f370529v = new Size(0, 0);
    }

    @Override // bd8.d
    public final JSONObject m(Message r210) {
        Intrinsics.checkNotNullParameter(r210, "message");
        JSONObject r100 = new JSONObject();
        List<CreationItem> r101 = com.larus.im.bean.message.a.l(r210);
        ArrayList r110 = new ArrayList();
        Iterator<T> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = ((CreationItem) r102.next()).f346620id;
        if (r103 == null) goto L4;
        r110.add(r103);
        goto L4
    L8:
        r100.put("ai_creation_message_id", r210.getMessageId());
        Integer r104 = null;
        String r105 = CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, null, 62, null);
        r100.put("creation_task_id", r105);
        RecyclerView.LayoutManager r106 = this.f370525r.f373216b.getLayoutManager();
        if ((r106 instanceof LinearLayoutManager) == false) goto L11;
        LinearLayoutManager r107 = (LinearLayoutManager) r106;
    L12:
        if (r107 != null) goto L14;
        return r100;
    L14:
        Integer r108 = Integer.valueOf(r107.findFirstCompletelyVisibleItemPosition());
        if (r108.intValue() == (-1)) goto L17;
        boolean r109 = true;
    L18:
        if (r109 == true) goto L21;
        r108 = null;
    L21:
        if (r108 == null) goto L23;
        int r111 = r108.intValue();
    L24:
        Integer r112 = Integer.valueOf(r107.findLastCompletelyVisibleItemPosition());
        if (r112.intValue() == (-1)) goto L27;
        boolean r113 = true;
    L28:
        if (r113 == false) goto L30;
        r104 = r112;
    L30:
        if (r104 == null) goto L32;
        int r114 = r104.intValue();
    L33:
        if (r111 == (-1)) goto L47;
        if (r114 == (-1)) goto L47;
        int r115 = RangesKt.coerceAtLeast(r111, 0);
        int r116 = RangesKt.coerceAtMost(r114, r110.size() - 1);
        if (r115 > r116) goto L47;
        List r117 = r110.subList(r115, r116 + 1);
        ArrayList r118 = new ArrayList();
        Iterator r119 = r117.iterator();
    L39:
        if (r119.hasNext() == false) goto L46;
        Object r120 = r119.next();
        if (((String) r120).length() <= 0) goto L43;
        boolean r121 = true;
    L44:
        if (r121 == false) goto L39;
        r118.add(r120);
        goto L39
    L43:
        r121 = false;
        goto L44
    L46:
        r105 = CollectionsKt.joinToString$default(r118, ",", null, null, 0, null, null, 62, null);
    L47:
        r100.put("creation_task_id", r105);
        return r100;
    L32:
        r114 = r107.findLastVisibleItemPosition();
        goto L33
    L27:
        r113 = false;
        goto L28
    L23:
        r111 = r107.findFirstVisibleItemPosition();
        goto L24
    L17:
        r109 = false;
        goto L18
    L11:
        r107 = null;
        goto L12
    }

    public static final Object o(LocalCreationHorizontalGroup r210, cz9.b r211, iy9.b r212, View r213, Continuation r214) {
        r210.getClass();
        if ((r214 instanceof LocalCreationHorizontalGroup$onClickItem$1) == false) goto L7;
        LocalCreationHorizontalGroup$onClickItem$1 r100 = (LocalCreationHorizontalGroup$onClickItem$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L57:
        r210.k();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        CreationItem r104 = r211.a();
        if (r104 != null) goto L18;
        return Unit.INSTANCE;
    L18:
        if (bz9.c.e(r104) != true) goto L60;
        kc8.q r105 = r210.f370464f;
        if (r105 == null) goto L23;
        Function1<Integer, Unit> r106 = r105.f502558m;
    L24:
        if (r106 == null) goto L30;
        if (r105 == null) goto L61;
        Function1<Integer, Unit> r107 = r105.f502558m;
        if (r107 == null) goto L61;
        r107.invoke(Boxing.boxInt(r211.b()));
    L61:
        return Unit.INSTANCE;
    L30:
        LocalCreationChatItemClickHelper r108 = LocalCreationChatItemClickHelper.f370900a;
        ImageCardNestedScrollableHost r109 = r210.f370525r.f373215a;
        ChatParam r111 = r210.f370465g;
        if (r111 == null) goto L33;
        String r112 = r111.f296892d;
    L34:
        if (r111 == null) goto L36;
        String r113 = r111.f296891c;
    L37:
        boolean r114 = r210.h();
        kc8.q r115 = r210.f370464f;
        Message r116 = r210.f370463e;
        if (r116 == null) goto L40;
        String r117 = r116.getMessageId();
    L41:
        if (r117 != null) goto L43;
        r117 = "";
    L43:
        String r118 = r117;
        Message r119 = r210.f370463e;
        CreationItem r120 = r211.a();
        if (r120 == null) goto L62;
        r r121 = new r(r210);
        LifecycleCoroutineScope r122 = LifecycleOwnerKt.getLifecycleScope(r210);
        com.larus.uaigc.chat.markdown.image.component.a r123 = r210.f();
        com.larus.uaigc.chat.markdown.image.component.k r215 = r210.g();
        if (r212 != null) goto L53;
        kc8.q r124 = r210.f370464f;
        if (r124 == null) goto L51;
        rd8.b r125 = r124.f502552g;
    L52:
        iy9.b r216 = new iy9.b(new f1(r125), new g1(r125), new h1(r125), null, null);
    L54:
        Boolean r126 = Boxing.boxBoolean(r114);
        r100.label = 1;
        if (r108.i("LocalCreationHorizontalGroup", r109, r213, r112, r113, r126, r115, r118, r120, r121, r122, r123, r215, r216, r119, r100) != r110) goto L57;
        return r110;
    L51:
        r125 = null;
        goto L52
    L53:
        r216 = r212;
        goto L54
    L62:
        return Unit.INSTANCE;
    L40:
        r117 = null;
        goto L41
    L36:
        r113 = null;
        goto L37
    L33:
        r112 = null;
        goto L34
    L23:
        r106 = null;
        goto L24
    L60:
        return Unit.INSTANCE;
    L7:
        r100 = new LocalCreationHorizontalGroup$onClickItem$1(r210, r214);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.larus.uaigc.chat.block.create.horizontal.n] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.larus.uaigc.chat.block.create.horizontal.o] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.uaigc.chat.block.create.horizontal.p] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.util.ArrayList] */
    @Override // com.larus.uaigc.chat.block.create.AbsCreationBlockView
    public final void b(Fragment r110, boolean r111, final z r112, Message r113, com.larus.uaigc.chat.block.create.i r210, ChatParam r211, int r212, boolean r213, Boolean r214, com.larus.uaigc.chat.block.create.f r215, kc8.q r216) {
        Intrinsics.checkNotNullParameter(r113, "message");
        Intrinsics.checkNotNullParameter(r210, "blockModel");
        super.b(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216);
        this.f370471m = bz9.c.b(r210);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO().plus(e()), null, new LocalCreationHorizontalGroup$preGenerateLocalImagePreviewCaches$1(this, null), 2, null);
        LarusLayoutCreationHorizontalScrollViewBinding r100 = this.f370525r;
        int r101 = 0;
        if (this.f370526s == false) goto L6;
        this.f370526s = false;
        r100.f373215a.setOnLongClickListener(new m(r112));
        r100.f373216b.setLayoutManager(p());
        ExposureTrackerExtKt.b(r100.f373216b);
        LocalCreationItemListAdapter r102 = new LocalCreationItemListAdapter(LifecycleOwnerKt.getLifecycleScope(this), f(), g(), this.f370464f, new n(this), new o(this), new p(this), new LocalCreationHorizontalGroup$initView$1$5(this, null), new LocalCreationHorizontalGroup$initView$1$6(this, null));
        this.f370527t = r102;
        r100.f373216b.setAdapter(r102);
        r100.f373216b.setItemAnimator(null);
        r100.f373216b.addItemDecoration(new LocalCreationHorizontalGroup$initView$1$7());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new LocalCreationHorizontalGroup$binObservers$1(this, null), 3, null);
    L6:
        LarusLayoutCreationHorizontalScrollViewBinding r103 = this.f370525r;
        List<CreationItem> r104 = this.f370471m;
        if (r104 == null) goto L9;
        CreationItem r105 = (CreationItem) CollectionsKt.firstOrNull(r104);
    L10:
        if (r105 == null) goto L16;
        List<CreationItem> r106 = this.f370471m;
        if (r106 == null) goto L14;
        int r107 = r106.size();
    L15:
        Size r108 = bz9.c.a(r105, r212, r107);
    L17:
        this.f370529v = r108;
        ImageCardNestedScrollableHost r109 = r103.f373215a;
        ViewGroup.LayoutParams r114 = r109.getLayoutParams();
        if (r114 == null) goto L50;
        r114.height = (this.f370529v.getHeight() + r103.f373215a.getPaddingTop()) + r103.f373215a.getPaddingBottom();
        r109.setLayoutParams(r114);
        List<CreationItem> r115 = this.f370471m;
        if (r115 == null) goto L35;
        List r116 = new ArrayList();
        Iterator<T> r117 = r115.iterator();
    L23:
        if (r117.hasNext() == false) goto L36;
        CreationItem r118 = (CreationItem) r117.next();
        Message r119 = this.f370463e;
        com.larus.uaigc.chat.block.create.i r120 = this.f370468j;
        if (r120 == null) goto L29;
        Block r121 = r120.f498145a;
        if (r121 == null) goto L29;
        String r122 = r121.getBlockId();
    L30:
        if (r122 != null) goto L32;
        r122 = "";
    L32:
        cz9.b r123 = bz9.c.n(r118, r119, r122, this.f370529v.getWidth(), this.f370529v.getHeight(), this.f370467i);
        if (r123 == null) goto L23;
        r116.add(r123);
    L29:
        r122 = null;
    L36:
        if (r116 != 0) goto L38;
        r116 = CollectionsKt.emptyList();
    L38:
        ImageCardNestedScrollableHost r124 = this.f370525r.f373215a;
        if (this.f370529v.getHeight() > 0) goto L41;
    L43:
        boolean r125 = false;
    L44:
        if (r125 == true) goto L47;
        r101 = 8;
    L47:
        r124.setVisibility(r101);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new LocalCreationHorizontalGroup$refreshViewState$1(this, r116, null), 2, null);
        return;
    L41:
        if (this.f370529v.getWidth() <= 0) goto L43;
        r125 = true;
        goto L44
    L35:
        r116 = 0;
        goto L36
    L50:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        r107 = 0;
        goto L15
    L16:
        r108 = new Size(0, 0);
        goto L17
    L9:
        r105 = null;
        goto L10
    }
}
