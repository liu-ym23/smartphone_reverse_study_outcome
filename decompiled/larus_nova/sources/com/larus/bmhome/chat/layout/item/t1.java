package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.nestedfile.INestedFileCacheManagerService;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.chat.common.databinding.LarusLayoutImageNonComplianceBinding;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.im.bean.message.ExpiredInfo;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.bean.message.block.BizMergeForwardBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.nova.R;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.ICreationAttachmentService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.IObricChatMessageBgService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class t1 extends h38.d {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f304627t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f304628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f304629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f304630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l1 f304631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h38.c f304632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final mt8.a f304633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LarusLayoutImageNonComplianceBinding f304634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Message f304635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f304636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<Integer> f304637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f304638k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f304639l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f304640m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f304641n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super Message, Unit> f304642o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super Message, Unit> f304643p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f304644q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f304645r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final p1 f304646s;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f304647a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f304648b = null;

        static {
            int[] r100 = new int[INestedFileCacheManagerService.FileEvent.values().length];
            r100[INestedFileCacheManagerService.FileEvent.INSERT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[INestedFileCacheManagerService.FileEvent.REMOVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[INestedFileCacheManagerService.FileEvent.UPDATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            f304647a = r100;
            int[] r101 = new int[ResourceType.values().length];
            r101[ResourceType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r101[ResourceType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            f304648b = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/larus/bmhome/chat/layout/item/NestedFileView$bindData$1$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<ArrayList<Integer>> {
        public c() {
        }
    }

    static {
    }

    private final Gson getGson() {
        return (Gson) this.f304638k.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Message r100 = this.f304635h;
        if (r100 == null) goto L39;
        int r101 = com.larus.utils.p0.f375454a;
        String r102 = com.larus.utils.p0.a(r100.getLocalMessageId());
        if (r102 == null) goto L40;
        List<UplinkFileEntity> r103 = com.larus.bmhome.chat.bean.d.f(r100).getEntities();
        boolean r104 = false;
        if (r103 == null) goto L30;
        List<UplinkFileEntity> r105 = r103;
        if ((r105 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L27;
        Integer r107 = ((UplinkFileEntity) r106.next()).getUpLinkStatus();
        int r108 = UpLinkState.PROCESSING.getValue();
        if (r107 != null) goto L22;
    L24:
        boolean r109 = false;
    L25:
        if (r109 == false) goto L17;
        boolean r110 = true;
    L28:
        if (r110 != true) goto L30;
        r104 = true;
        goto L30
    L22:
        if (r107.intValue() != r108) goto L24;
        r109 = true;
    L27:
        r110 = false;
        goto L28
    L13:
        if (r105.isEmpty() == false) goto L15;
    L30:
        if (r104 == false) goto L38;
        FLogger.f375446a.i("NestedFileView", "[tryResumeUplinkProgressObserver] resume localMessageId:".concat(r102));
        com.larus.utils.y.c(new r1(r102, this));
        return;
    L38:
        return;
    L40:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f304630c.removeCallbacks(this.f304631d);
        Message r100 = this.f304635h;
        if (r100 == null) goto L10;
        String r101 = r100.getLocalMessageId();
        if (r101 == null) goto L11;
        String r102 = com.larus.utils.p0.a(r101);
        if (r102 == null) goto L12;
        com.larus.utils.y.c(new q1(r102, this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final Integer getBotType() {
        return this.f304641n;
    }

    public final boolean getEnableEditVideoForSingleVideo() {
        return this.f304640m;
    }

    public final Function1<Message, Unit> getOnEditImageBtnShown() {
        return this.f304642o;
    }

    public final Function1<Message, Unit> getOnEditVideoBtnShown() {
        return this.f304643p;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.layout.item.l1] */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.larus.bmhome.chat.layout.item.p1] */
    public t1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f304630c = new Handler(Looper.getMainLooper());
        this.f304631d = new l1(this);
        mt8.a r101 = InputViewCreatorDelegate.f298409b.e(r100);
        this.f304633f = r101;
        this.f304637j = new ArrayList();
        this.f304638k = LazyKt.lazy(new m1());
        this.f304642o = new n1();
        this.f304643p = new o1();
        IObricChatMessageBgService r102 = (IObricChatMessageBgService) ServiceManager.get().getService(IObricChatMessageBgService.class);
        if (r102 == null) goto L5;
        r102.configNestedFileViewBackground(r101.getView());
    L5:
        LarusLayoutImageNonComplianceBinding r103 = LarusLayoutImageNonComplianceBinding.a(LayoutInflater.from(r100), this);
        this.f304634g = r103;
        addView(r101.getView(), new ViewGroup.LayoutParams(-1, -1));
        GradientMaskView r104 = new GradientMaskView(getContext(), null, 6, 0);
        addView(r104, new ViewGroup.LayoutParams(-1, -1));
        r104.bringToFront();
        addView(r103.f324000a, new FrameLayout.LayoutParams(-2, -2));
        this.f304646s = new p1(this);
    }

    public static BizMergeForwardBlock b(Message r100) {
        List<Block> r101 = r100.getContentBlock();
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        List<Block> r102 = r101;
        if (r102.isEmpty() == false) goto L8;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r102 = vd9.r.a(r100);
    L8:
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L23;
        Object r104 = r103.next();
        Block r105 = (Block) r104;
        if (r105.getBlockType() == BlockType.BLOCK_TYPE_BIZ_MERGE_FORWARD.getValue()) goto L20;
        BlockContent r106 = r105.getContent();
        if (r106 == null) goto L16;
        BizMergeForwardBlock r107 = r106.getBizMergeForwardBlock();
    L17:
        if (r107 != null) goto L20;
        boolean r108 = false;
    L21:
        if (r108 == false) goto L10;
    L24:
        Block r109 = (Block) r104;
        if (r109 == null) goto L35;
        BlockContent r110 = r109.getContent();
        if (r110 != null) goto L29;
        return null;
    L29:
        return r110.getBizMergeForwardBlock();
    L35:
        return null;
    L16:
        r107 = null;
    L20:
        r108 = true;
        goto L21
    L23:
        r104 = null;
        goto L24
    }

    public static boolean d(Message r100) {
        Map<String, String> r101 = r100.getExt();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        String r103 = PollingConfigService.f326423a.f("lottry_image_mask_enable");
        if (com.larus.utils.o0.d(r103) == true) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r102 == false) goto L18;
        if (r104 == false) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L11:
        if (tx9.l3.e(r103, 1) != 1) goto L13;
        r104 = true;
        goto L14
    L5:
        if (Intrinsics.areEqual(r101.get("chat_raf_option"), "1") == false) goto L7;
        r102 = true;
        goto L8
    }

    public final ResourceBarConfig c(Message r110) {
        if (r110.getMessageStatusLocal() != 12) goto L5;
        int r100 = 0;
    L6:
        Mode r101 = Mode.SHOW;
        final BizMergeForwardBlock r102 = b(r110);
        if (r102 != null) goto L9;
        HashMap r103 = new HashMap();
    L11:
        return new ResourceBarConfig(r101, false, r100, 0, r103, MapsKt.mapOf(TuplesKt.to("key_message", r110)), 10, null);
    L9:
        r103 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ResourceType.CUSTOM.getValue()), new s1(this, r102))});
        goto L11
    L5:
        r100 = i5.h();
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getActionMasked());
    L6:
        if (r101 != null) goto L9;
    L11:
        if (r101 != null) goto L14;
    L24:
        this.f304630c.removeCallbacks(this.f304631d);
    L26:
        return super.dispatchTouchEvent(r100);
    L14:
        if (r101.intValue() != 2) goto L24;
        float r102 = Math.abs(r100.getX() - this.f304628a);
        float r103 = Math.abs(r100.getY() - this.f304629b);
        if (r102 <= 10.0f) goto L18;
    L19:
        this.f304630c.removeCallbacks(this.f304631d);
    L21:
        if (r102 <= r103) goto L23;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L26
    L23:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L26
    L18:
        if (r103 <= 10.0f) goto L21;
    L9:
        if (r101.intValue() != 0) goto L11;
        this.f304628a = r100.getX();
        this.f304629b = r100.getY();
        this.f304630c.postDelayed(this.f304631d, ViewConfiguration.getLongPressTimeout());
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L26
    L4:
        r101 = null;
        goto L6
    }

    public final void setBotType(Integer r100) {
        this.f304641n = r100;
    }

    public final void setEnableEditVideoForSingleVideo(boolean r100) {
        this.f304640m = r100;
    }

    public final void setOnEditImageBtnShown(Function1<? super Message, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f304642o = r100;
    }

    public final void setOnEditVideoBtnShown(Function1<? super Message, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f304643p = r100;
    }

    public final void setUpCompactMaxWidth(Integer r100) {
        if (r100 != null) goto L5;
    L10:
        r100 = null;
    L11:
        this.f304645r = r100;
        return;
    L5:
        if (r100.intValue() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
    L7:
        r101 = false;
        goto L8
    }

    @Override // h38.d
    public void setUpEnableEditImageForSingleImg(boolean r100) {
        this.f304639l = r100;
    }

    @Override // h38.d
    public void setUpImmersiveStyle(boolean r100) {
        this.f304644q = r100;
    }

    @Override // h38.d
    public void setupDelegateCallback(h38.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f304632e = r100;
    }

    @Override // h38.d
    public final void a(Message r510, NestedFileContent r511, BaseResourceViewHolder.a r512) {
        Intrinsics.checkNotNullParameter(r510, "data");
        Intrinsics.checkNotNullParameter(r511, "content");
        Intrinsics.checkNotNullParameter(r512, "callback");
        this.f304635h = r510;
        Map<String, String> r100 = r510.getExt();
        int r101 = 1;
        if (r100 == null) goto L9;
        String r102 = r100.get("white_tee_index_list");
        if (r102 == null) goto L9;
        if (com.larus.utils.o0.d(r102) != true) goto L9;
        boolean r103 = true;
    L10:
        this.f304636i = r103;
        Gson r104 = getGson();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L17
        Map<String, String> r106 = r510.getExt();     // Catch: Throwable -> L17
        if (r106 == null) goto L14;
        String r107 = r106.get("white_tee_index_list");     // Catch: Throwable -> L17
    L15:
        Object r108 = Result.m9449constructorimpl((ArrayList) r104.fromJson(r107, new c().getType()));     // Catch: Throwable -> L17
    L20:
        if (Result.m9452exceptionOrNullimpl(r108) == null) goto L23;
        r108 = new ArrayList();
    L23:
        ArrayList<Integer> r109 = (ArrayList) r108;
        if (r109 != null) goto L26;
        r109 = new ArrayList();
    L26:
        this.f304637j = r109;
        ArrayList<ResourceItemBean> r110 = new ArrayList();
        BizMergeForwardBlock r111 = b(r510);
        String r112 = "";
        if (r111 != null) goto L29;
        ResourceItemBean r113 = null;
    L48:
        if (r113 == null) goto L50;
        r110.add(r113);
    L50:
        List<UplinkFileEntity> r114 = r511.getEntities();
        if (r114 == null) goto L246;
        Iterator r115 = r114.iterator();
        boolean r116 = false;
        int r117 = 0;
        int r118 = 0;
    L54:
        if (r115.hasNext() == false) goto L245;
        UplinkFileEntity r119 = (UplinkFileEntity) r115.next();
        r117 = r117 + r101;
        FLogger r120 = FLogger.f375446a;
        r120.i("NestedFileView", "[bindData] messageStatusLocal:" + r510.getMessageStatusLocal() + ", entity:" + r119);
        if (r510.getMessageStatusLocal() != 0) goto L109;
        Integer r121 = r119.getUpLinkStatus();
        int r122 = UpLinkState.PROCESSING.getValue();
        if (r121 != null) goto L61;
    L108:
        Iterator r310 = r115;
        String r311 = r112;
        r116 = r116;
    L154:
        CreationNoWatermarkManager r123 = CreationNoWatermarkManager.f373832a;
        if (r119 != null) goto L158;
        r123.getClass();
        UplinkFileEntity r124 = null;
    L190:
        if (r124 != null) goto L193;
        r124 = r119;
    L193:
        if (yc9.n1.d(r124) == false) goto L201;
        Image r125 = yc9.l1.c(r124);
        if (r125 == null) goto L201;
        String r126 = r119.getFileIdentifier();
        if (r126 != null) goto L199;
        r126 = r311;
    L199:
        r125.localResPath = com.larus.bmhome.chat.sendimage.e.h(r510, r126);
    L201:
        if (yc9.n1.d(r124) == false) goto L203;
    L206:
        int r127 = i5.d();
    L208:
        if (hp8.a.c(r510) == true) goto L210;
    L220:
        int r128 = i5.w0();
    L221:
        ResourceItemBean r129 = com.larus.bmhome.chat.c.a(r124, Mode.SHOW, r127, r128, 32);
        if (this.f304637j.contains(Integer.valueOf(r117 - 1)) == false) goto L224;
        r118 = r118 + 1;
    L224:
        r129.setSubscriptIndex(r117 - r118);
        if (d(r510) == false) goto L243;
        Integer r130 = r119.getFileReviewStatus();
        int r131 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r130 != null) goto L230;
    L232:
        Integer r132 = r119.getFileReviewStatus();
        int r133 = FileReviewState.ACCESS.getValue();
        if (r132 != null) goto L236;
    L238:
        r129.setExt(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("ext_spring_review_mode", Boolean.TRUE)}));
        if (r129.getStatus() == ItemStatus.INSPECT_FAILED) goto L241;
    L242:
        r116 = true;
    L244:
        r110.add(r129);
        r115 = r310;
        r112 = r311;
        r101 = 1;
        goto L54
    L241:
        if (r129.getStatus() == ItemStatus.SUCCESS) goto L243;
    L236:
        if (r132.intValue() != r133) goto L238;
        r129.setStatus(ItemStatus.SUCCESS);
        goto L238
    L230:
        if (r130.intValue() != r131) goto L232;
        r129.setStatus(ItemStatus.INSPECT_FAILED);
    L243:
        r116 = r116;
        goto L244
    L210:
        if (yc9.n1.d(r124) == false) goto L220;
        Image r134 = yc9.l1.c(r124);
        if (r134 == null) goto L214;
        ImageObj r135 = r134.imageOri;
    L215:
        if (r135 == null) goto L219;
        int r136 = r135.width;
        if (r136 <= 0) goto L219;
        r128 = (r135.height * r127) / r136;
    L219:
        r128 = (r127 * 4) / 3;
        goto L221
    L214:
        r135 = null;
        goto L215
    L203:
        if (yc9.n1.e(r124) == true) goto L206;
        r127 = i5.y();
        goto L208
    L158:
        if (r123.D() == true) goto L161;
    L189:
        r124 = r119;
        goto L190
    L161:
        if (yc9.n1.d(r119) == false) goto L174;
        UplinkEntityContent r137 = r119.getUplinkEntityContent();
        if (r137 == null) goto L189;
        Image r138 = r137.getUplinkImageInfo();
        if (r138 == null) goto L189;
        Image r139 = r123.S(r138, new String[]{r138.key, r138.identifier, r119.getFileIdentifier()}).f373863a;
        if (r139 == null) goto L172;
        r138 = r139;
    L172:
        r124 = UplinkFileEntity.copy$default(r119, null, UplinkEntityContent.copy$default(r137, null, r138, 1, null), null, null, null, null, null, null, null, false, null, null, null, null, 16381, null);
        goto L190
    L174:
        if (yc9.n1.e(r119) == false) goto L189;
        UplinkEntityContent r140 = r119.getUplinkEntityContent();
        if (r140 == null) goto L189;
        UplinkFileInfo r312 = r140.getUplinkFileInfo();
        if (r312 == null) goto L189;
        VideoExtension r141 = r312.getVideo();
        if (r141 == null) goto L189;
        VideoExtension r142 = r123.g0(r141);
        if (r142 != null) goto L187;
        VideoExtension r410 = r141;
    L188:
        r124 = UplinkFileEntity.copy$default(r119, null, UplinkEntityContent.copy$default(r140, UplinkFileInfo.copy$default(r312, null, null, null, null, null, null, r410, null, null, null, 959, null), null, 2, null), null, null, null, null, null, null, null, false, null, null, null, null, 16381, null);
        goto L190
    L187:
        r410 = r142;
        goto L188
    L61:
        if (r121.intValue() != r122) goto L108;
        String r143 = r119.getFileIdentifier();
        if (r143 != null) goto L65;
        r143 = r112;
    L65:
        String r144 = r510.getLocalMessageId();
        if (r144 != null) goto L68;
        r144 = r112;
    L68:
        UplinkFileEntity r145 = NestedFileCacheManagerService.f313409b.a(r144, r143);
        if (r145 != null) goto L71;
        boolean r146 = true;
    L72:
        if (r145 == null) goto L76;
        Integer r147 = r145.getUpLinkProcess();
        if (r147 == null) goto L76;
        int r148 = r147.intValue();
    L77:
        ResourceUploader r149 = ResourceUploader.f314736a;
        r310 = r115;
        Intrinsics.checkNotNullParameter(r143, LocationMonitorConst.IDENTIFIER);
        ConcurrentHashMap<String, mr9.j> r150 = com.larus.bmhome.upload.sdk.g.f314834a;
        Intrinsics.checkNotNullParameter(r143, LocationMonitorConst.IDENTIFIER);
        if (com.larus.bmhome.upload.sdk.g.f314834a.containsKey(r143) == false) goto L80;
    L83:
        boolean r151 = true;
    L84:
        if (r151 == false) goto L86;
    L88:
        boolean r152 = false;
    L89:
        r311 = r112;
        ye8.c r153 = ChatInputService.f303327b.g();
        if (r152 == true) goto L92;
    L94:
        boolean r154 = false;
    L95:
        if (r146 == true) goto L101;
        if (r154 == true) goto L98;
    L100:
        boolean r155 = false;
    L102:
        r120.i("NestedFileView", "[isUploadingAlreadyFailed] alreadyFailed:" + r155 + ", " + r146 + ':' + r152 + ':' + r154 + ':' + r148);
        if (r155 == false) goto L154;
        r119.setUpLinkStatus(Integer.valueOf(UpLinkState.FAIL.getValue()));
        RepoDispatcher.f307729a.getClass();
        ChatRepo r156 = RepoDispatcher.f307732d;
        String r157 = r510.getLocalMessageId();
        if (r157 != null) goto L107;
        r157 = r311;
    L107:
        r156.r1(r157, new j1());
        goto L154
    L98:
        if (r148 >= 99) goto L100;
    L101:
        r155 = true;
        goto L102
    L92:
        if (r153.a(r143) != null) goto L94;
        r154 = true;
        goto L95
    L86:
        if (ICreationAttachmentService.f373904a.O(r143) == true) goto L88;
        r152 = true;
        goto L89
    L80:
        if (com.larus.bmhome.upload.sdk.g.f314835b.containsKey(r143) == true) goto L83;
        r151 = false;
    L76:
        r148 = 0;
        goto L77
    L71:
        r146 = false;
        goto L72
    L109:
        r310 = r115;
        r311 = r112;
        r116 = r116;
        if (r510.getMessageStatusLocal() != 14) goto L112;
    L153:
        r120.i("NestedFileView", "[bindData] SEND_COMPLIANT");
        r119.setFileReviewStatus(Integer.valueOf(FileReviewState.NOT_COMPLIANT.getValue()));
        goto L154
    L112:
        if (r510.getMessageStatus() == MessageStatus.MessageStatus_NOTCOMPLIANT) goto L153;
        if (r510.getMessageStatusLocal() != 13) goto L118;
        r119.setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
        goto L154
    L118:
        if (r510.getMessageStatusLocal() != 11) goto L151;
        Map<String, String> r158 = r119.getExtra();
        if (r158 == null) goto L122;
        String r159 = r158.get("local_item_attachment");
    L124:
        if (Intrinsics.areEqual(r159, "1") == true) goto L149;
        String r160 = yc9.l1.h(r119);
        if (r160 != null) goto L128;
    L131:
        boolean r161 = true;
    L132:
        if (r161 == false) goto L149;
        UplinkEntityContent r162 = r119.getUplinkEntityContent();
        if (r162 == null) goto L140;
        UplinkFileInfo r163 = r162.getUplinkFileInfo();
        if (r163 == null) goto L140;
        VideoExtension r164 = r163.getVideo();
        if (r164 == null) goto L140;
        String r165 = r164.getVid();
    L141:
        if (r165 != null) goto L143;
    L146:
        boolean r166 = true;
    L147:
        if (r166 == false) goto L149;
        r119.setUpLinkStatus(Integer.valueOf(UpLinkState.FAIL.getValue()));
        goto L154
    L143:
        if (r165.length() == 0) goto L146;
        r166 = false;
    L140:
        r165 = null;
        goto L141
    L128:
        if (r160.length() == 0) goto L131;
        r161 = false;
    L149:
        r119.setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
        goto L154
    L122:
        r159 = null;
        goto L124
    L151:
        if (r510.getMessageStatusLocal() != 21) goto L154;
        r119.setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
        goto L154
    L245:
        String r313 = r112;
    L247:
        Map<String, String> r167 = r510.getExt();
        if (r167 == null) goto L250;
        String r168 = r167.get("chat_raf_option");
    L252:
        if (Intrinsics.areEqual(r168, "1") == false) goto L261;
        JSONObject r169 = new JSONObject();
        String r170 = r510.getLocalMessageId();
        if (r170 != null) goto L256;
        r170 = r313;
    L256:
        r169.put("local_message_id", r170);
        if (r116 == false) goto L259;
        String r171 = "1";
    L260:
        r169.put("has_mask", r171);
        FLogger.f375446a.i("NestedFileView", "[bindData] hasMask = " + r116 + ", id = " + r510.getLocalMessageId());
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("image_spring_mask_show", r169, null, null);
    L263:
        if (r110.isEmpty() == true) goto L271;
        Iterator<ResourceItemBean> r172 = r110.iterator();
    L267:
        if (r172.hasNext() == false) goto L271;
        ResourceItemBean r173 = r172.next();
        if (hp8.a.b(r510) == false) goto L267;
        boolean r174 = true;
    L272:
        if (r174 == false) goto L297;
        FLogger r175 = FLogger.f375446a;
        StringBuilder r176 = new StringBuilder("pic expired, ");
        String r177 = r510.getContent();
        if (r177 == null) goto L282;
        List<UplinkFileEntity> r178 = hp8.a.a(r177).getEntities();
        if (r178 == null) goto L282;
        UplinkFileEntity r179 = (UplinkFileEntity) ListProtector.get(r178, 0);
        if (r179 == null) goto L282;
        ExpiredInfo r180 = r179.getExpiredInfo();
        if (r180 == null) goto L282;
        Long r181 = r180.getExpireTime();
    L283:
        r176.append(r181);
        r176.append(", ");
        String r182 = r510.getContent();
        if (r182 == null) goto L292;
        List<UplinkFileEntity> r183 = hp8.a.a(r182).getEntities();
        if (r183 == null) goto L292;
        UplinkFileEntity r184 = (UplinkFileEntity) ListProtector.get(r183, 0);
        if (r184 == null) goto L292;
        ExpiredInfo r185 = r184.getExpiredInfo();
        if (r185 == null) goto L292;
        Long r186 = r185.getTtl();
    L293:
        r176.append(r186);
        r175.i("dora_e_pic", r176.toString());
        ResourceItemBean r187 = (ResourceItemBean) CollectionsKt.firstOrNull(r110);
        if (r187 == null) goto L297;
        r110.clear();
        r110.add(r187);
    L292:
        r186 = null;
    L282:
        r181 = null;
    L297:
        if (d(r510) == false) goto L300;
    L312:
        boolean r188 = false;
    L416:
        if (r188 == true) goto L418;
    L426:
        com.larus.utils.e1.o(this.f304634g.f324000a);
        com.larus.utils.e1.x(this.f304633f.getView());
        this.f304633f.h(c(r510), r110, r512);
        h38.c r189 = this.f304632e;
        if (r189 == null) goto L429;
        r189.a();
    L429:
        Map<String, String> r190 = r510.getExt();
        if (r190 != null) goto L432;
    L434:
        boolean r191 = false;
    L435:
        if (r191 == false) goto L462;
        ArrayList r192 = new ArrayList();
        Iterator<ResourceItemBean> r193 = r110.iterator();
    L438:
        if (r193.hasNext() == false) goto L443;
        ResourceItemBean r194 = r193.next();
        if ((!this.f304637j.contains(Integer.valueOf(r110.indexOf(r194)))) == false) goto L438;
        r192.add(r194);
        goto L438
    L443:
        if (r192.size() != 1) goto L445;
        ((ResourceItemBean) ListProtector.get(r192, 0)).setShowSubscriptView(false);
    L452:
        ArrayList r195 = new ArrayList();
        Iterator<ResourceItemBean> r196 = r110.iterator();
    L454:
        if (r196.hasNext() == false) goto L458;
        ResourceItemBean r197 = r196.next();
        if (this.f304637j.contains(Integer.valueOf(r110.indexOf(r197))) == false) goto L454;
        r195.add(r197);
        goto L454
    L458:
        Iterator r198 = r195.iterator();
    L460:
        if (r198.hasNext() == false) goto L462;
        ResourceItemBean r199 = (ResourceItemBean) r198.next();
        HashMap<String, Object> r200 = new HashMap();
        r200.put("ext_avatar_subscript_desc", ContextCompat.getString(getContext(), R.string.larus_replica_upload_preview_img_tag_replica));
        r199.setShowSubscriptView(true);
        r199.setExt(r200);
        r199.setResourceType(ResourceType.AVATAR);
        goto L460
    L445:
        Iterator r201 = r192.iterator();
        int r202 = 0;
    L447:
        if (r201.hasNext() == false) goto L452;
        Object r203 = r201.next();
        int r204 = r202 + 1;
        if (r202 >= 0) goto L451;
        CollectionsKt.throwIndexOverflow();
    L451:
        ((ResourceItemBean) r203).setShowSubscriptView(true);
        r202 = r204;
    L462:
        int r205 = r510.getMessageStatusLocal();
        if (r205 != 0) goto L465;
    L471:
        String r206 = r510.getLocalMessageId();
        if (r206 != null) goto L474;
        String r207 = r313;
    L475:
        com.larus.utils.y.c(new r1(r207, this));
        return;
    L474:
        r207 = r206;
        goto L475
    L465:
        if (r205 == 10) goto L471;
        String r208 = r510.getLocalMessageId();
        if (r208 != null) goto L469;
        String r209 = r313;
    L470:
        com.larus.utils.y.c(new q1(r209, this));
        return;
    L469:
        r209 = r208;
        goto L470
    L432:
        if (r190.containsKey(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION) != true) goto L434;
        r191 = true;
        goto L435
    L418:
        if (((ResourceItemBean) ListProtector.get(r110, 0)).getStatus() != ItemStatus.INSPECT_FAILED) goto L426;
        if (((ResourceItemBean) CollectionsKt.first(r110)).getResourceType() != ResourceType.VIDEO) goto L422;
        this.f304634g.f324001b.setText(R.string.larus_file_upload_safety_reject);
    L423:
        com.larus.utils.e1.x(this.f304634g.f324000a);
        com.larus.utils.e1.o(this.f304633f.getView());
        h38.c r210 = this.f304632e;
        if (r210 == null) goto L429;
        r210.c();
        goto L429
    L422:
        this.f304634g.f324001b.setText(R.string.larus_image_upload_safety_error);
        goto L423
    L300:
        if (r110.size() == 1) goto L302;
    L306:
        r188 = false;
    L307:
        if (r188 == false) goto L416;
        ResourceType r211 = ((ResourceItemBean) ListProtector.get(r110, 0)).getResourceType();
        int[] r212 = b.f304648b;
        int r213 = r212[r211.ordinal()];
        if (r213 != 1) goto L311;
        Image r214 = ((ResourceItemBean) ListProtector.get(r110, 0)).getImage();
    L318:
        int r215 = r212[((ResourceItemBean) ListProtector.get(r110, 0)).getResourceType().ordinal()];
        if (r215 != 1) goto L321;
    L334:
        Pair r216 = null;
    L335:
        com.larus.bmhome.utils.q1 r217 = com.larus.bmhome.utils.q1.f315097a;
        Context r218 = getContext();
        boolean r219 = this.f304644q;
        Integer r220 = this.f304645r;
        if (r220 == null) goto L343;
        int r221 = r220.intValue();
        ResourceBarConfig r1100 = c(r510);
        Integer r222 = Integer.valueOf((r221 - r1100.getMarginStart()) - r1100.getMarginEnd());
        if (r222.intValue() <= 0) goto L340;
        boolean r1101 = true;
    L341:
        if (r1101 == false) goto L343;
    L344:
        r217.getClass();
        Pair r223 = com.larus.bmhome.utils.q1.a(r218, r214, r219, r216, r222);
        int r224 = ((Number) r223.component1()).intValue();
        int r225 = ((Number) r223.component2()).intValue();
        ((ResourceItemBean) ListProtector.get(r110, 0)).setItemWidth(r224 + i5.r0());
        ((ResourceItemBean) ListProtector.get(r110, 0)).setItemHeight(r225);
        if (this.f304644q == false) goto L350;
        this.f304633f.getView().setBackground(null);
        h38.c r226 = this.f304632e;
        if (r226 == null) goto L349;
        r226.b();
    L349:
        ((ResourceItemBean) ListProtector.get(r110, 0)).setImmersiveStyle(this.f304644q);
    L350:
        String r227 = r510.getConversationId();
        if (r227 != null) goto L354;
        r227 = r313;
    L354:
        if (com.larus.bmhome.utils.i.g(r227) == false) goto L356;
        boolean r228 = this.f304639l;
    L372:
        if (((ResourceItemBean) ListProtector.get(r110, 0)).getResourceType() != ResourceType.IMAGE) goto L396;
        String r229 = r510.getConversationId();
        if (r229 != null) goto L377;
        r229 = r313;
    L377:
        if (com.larus.bmhome.utils.i.g(r229) == false) goto L379;
        boolean r230 = this.f304640m;
    L394:
        if (r230 == false) goto L396;
        boolean r231 = true;
    L397:
        boolean r232 = Intrinsics.areEqual(PollingConfigService.f326423a.f("cre_sc_dg"), "1");
        ResourceItemBean r233 = (ResourceItemBean) ListProtector.get(r110, 0);
        if (r228 == true) goto L400;
    L403:
        boolean r234 = false;
    L404:
        r233.setShowEditImageBtn(r234);
        ResourceItemBean r235 = (ResourceItemBean) ListProtector.get(r110, 0);
        if (r231 == true) goto L407;
    L410:
        boolean r236 = false;
    L411:
        r235.setShowEditVideoBtn(r236);
        if (r228 == false) goto L414;
        this.f304642o.invoke(r510);
    L414:
        if (r231 == false) goto L416;
        this.f304643p.invoke(r510);
        goto L416
    L407:
        if (hp8.a.c(r510) == true) goto L410;
        if (r232 == true) goto L410;
        r236 = true;
        goto L411
    L400:
        if (hp8.a.c(r510) == true) goto L403;
        if (r232 == true) goto L403;
        r234 = true;
        goto L404
    L379:
        List r237 = CollectionsKt.listOf(new Integer[]{16, 4, 18});
        Map<String, String> r238 = r510.getExt();
        if (r238 == null) goto L384;
        Integer r239 = ic8.j.c(r238);
        if (r239 == null) goto L384;
        int r240 = r239.intValue();
    L386:
        if (r237.contains(Integer.valueOf(r240)) == false) goto L393;
        sq9.y r241 = com.larus.platform.service.z2.f365865a.getCreationEditControlConfig().c();
        if (r241 == null) goto L390;
        boolean r242 = Intrinsics.areEqual(r241.b(), Boolean.TRUE);
    L391:
        if (r242 == false) goto L393;
        r230 = true;
        goto L394
    L390:
        r242 = false;
    L393:
        r230 = false;
    L384:
        r240 = 0;
    L396:
        r231 = false;
        goto L397
    L356:
        List r243 = CollectionsKt.listOf(new Integer[]{16, 4, 18});
        Map<String, String> r244 = r510.getExt();
        if (r244 == null) goto L361;
        Integer r245 = ic8.j.c(r244);
        if (r245 == null) goto L361;
        int r246 = r245.intValue();
    L363:
        if (r243.contains(Integer.valueOf(r246)) == false) goto L370;
        sq9.y r247 = com.larus.platform.service.z2.f365865a.getCreationEditControlConfig().c();
        if (r247 == null) goto L367;
        boolean r248 = Intrinsics.areEqual(r247.a(), Boolean.FALSE);
    L368:
        if (r248 == true) goto L370;
        r228 = true;
        goto L372
    L367:
        r248 = false;
    L370:
        r228 = false;
    L361:
        r246 = 0;
        goto L363
    L340:
        r1101 = false;
    L343:
        r222 = null;
        goto L344
    L321:
        if (r215 != 2) goto L334;
        mt8.b r249 = ((ResourceItemBean) ListProtector.get(r110, 0)).getVideo();
        if (r249 == null) goto L326;
        int r250 = r249.f515652c;
    L327:
        mt8.b r251 = ((ResourceItemBean) ListProtector.get(r110, 0)).getVideo();
        if (r251 == null) goto L330;
        int r252 = r251.f515653d;
    L331:
        if (r250 == 0) goto L334;
        if (r252 == 0) goto L334;
        r216 = TuplesKt.to(Integer.valueOf(r250), Integer.valueOf(r252));
        goto L335
    L330:
        r252 = 0;
        goto L331
    L326:
        r250 = 0;
        goto L327
    L311:
        if (r213 != 2) goto L312;
        mt8.b r253 = ((ResourceItemBean) ListProtector.get(r110, 0)).getVideo();
        if (r253 == null) goto L316;
        r214 = r253.f515650a;
        goto L318
    L316:
        r214 = null;
        goto L318
    L302:
        if (CollectionsKt.listOf(new ResourceType[]{ResourceType.IMAGE, ResourceType.VIDEO}).contains(((ResourceItemBean) ListProtector.get(r110, 0)).getResourceType()) == false) goto L306;
        if (this.f304636i == true) goto L306;
        r188 = true;
    L271:
        r174 = false;
        goto L272
    L259:
        r171 = "0";
        goto L260
    L261:
        FLogger.f375446a.i("NestedFileView", "[bindData] isNotChatRafMsg, not to report, id = " + r510.getLocalMessageId());
        goto L263
    L250:
        r168 = null;
        goto L252
    L246:
        r313 = "";
        r116 = false;
        goto L247
    L29:
        String r254 = r111.getBrief();
        if (r254 != null) goto L32;
    L36:
        r254 = r510.getBrief();
        if (r254 != null) goto L39;
    L41:
        r254 = null;
    L42:
        if (r254 != null) goto L44;
        r254 = getContext().getString(R.string.larus_bot_chatHistory_entrance);
    L44:
        String r1102 = r254;
        String r1103 = r510.getLocalMessageId();
        if (r1103 != null) goto L47;
        r1103 = "";
    L47:
        r113 = new ResourceItemBean("human_merge_forward_card_".concat(r1103), r1102, null, null, null, null, 0, null, false, ResourceType.CUSTOM, i5.y(), i5.w0(), 0, 0, false, false, false, false, 0, null, 1032700, null);
        goto L48
    L39:
        if ((!StringsKt.isBlank(r254)) == false) goto L41;
    L32:
        if ((!StringsKt.isBlank(r254)) == true) goto L35;
        r254 = null;
    L35:
        if (r254 != null) goto L44;
    L14:
        r107 = null;
    L17:
        th = move-exception;
        Result.Companion r255 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L9:
        r103 = false;
        goto L10
    }
}
