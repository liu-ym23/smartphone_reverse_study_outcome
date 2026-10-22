package com.larus.voicecall.impl.subtitle;

import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusItemRecyclerSubtitleBlockBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v19.i5;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 32\u00020\u0001:\u00013B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010)\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u0016\u0010.\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0006\u0012\u0004\u0018\u0001010/H\u0002J\u0006\u00102\u001a\u00020\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$¨\u00064"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/SubtitleBlockHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerSubtitleBlockBinding;", "paramProvider", "Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderAbilityProvider;", "selectCallBack", "Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;", "actionProvider", "Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderActionProvider;", "<init>", "(Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerSubtitleBlockBinding;Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderAbilityProvider;Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderActionProvider;)V", "getBinding", "()Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerSubtitleBlockBinding;", "getParamProvider", "()Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderAbilityProvider;", "getSelectCallBack", "()Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;", "getActionProvider", "()Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderActionProvider;", "data", "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "mainHandler", "Landroid/os/Handler;", "containerView", "Lcom/larus/mainbot/api/block/ui/AbsBlockContainerView;", "getContainerView", "()Lcom/larus/mainbot/api/block/ui/AbsBlockContainerView;", "onMsgInterrupt", "", "updateIsLastMsg", "isLastMessage", "", "markdownClickProcessor", "Lcom/larus/bmhome/chat/service/MarkdownClickProcessorApi;", "getMarkdownClickProcessor", "()Lcom/larus/bmhome/chat/service/MarkdownClickProcessorApi;", "markdownClickProcessor$delegate", "Lkotlin/Lazy;", "generateBlockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "bindText", "filterBlocks", "", "Lcom/larus/im/bean/message/block/Block;", "blocks", "generateMobParam", "", "", "", "onViewDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubtitleBlockHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f378807i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemRecyclerSubtitleBlockBinding f378808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f378809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u1 f378810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f378811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f378812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f378813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public hk9.a f378814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f378815h;

    public static final class a {
    }

    static {
    }

    public final hk9.a U3() {
        if (this.f378814g != null) goto L6;
        int r100 = ra8.a.f536852a;
        hk9.a r101 = ra8.a.a(this.f378808a.f378238a.getContext());
        this.f378808a.f378239b.addView(r101, new FrameLayout.LayoutParams(-1, -2));
        this.f378814g = r101;
    L6:
        return this.f378814g;
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [com.larus.voicecall.impl.subtitle.a1] */
    public final void T3(final c r610, final boolean r611) {
        Intrinsics.checkNotNullParameter(r610, "data");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        this.f378813f.post(new z0(this, r610, r611));
        return;
    L6:
        final List<Block> r100 = r610.f378855b;
        if (r100 != null) goto L10;
        FLogger.f375446a.e("SubtitleBlockHolder", "blockData is null");
        return;
    L10:
        this.f378812e = r610;
        Block r101 = (Block) CollectionsKt.lastOrNull(r100);
        if (r101 == null) goto L13;
        boolean r102 = r101.isFinish();
    L15:
        if (r102 == true) goto L21;
        if (r611 == false) goto L21;
        if (this.f378809b.c() == false) goto L21;
        boolean r103 = false;
    L22:
        final ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r100.iterator();
    L24:
        if (r105.hasNext() == false) goto L33;
        Object r106 = r105.next();
        Block r110 = (Block) r106;
        if (r110.getBlockType() == com.larus.bmhome.chat.deepresearch.view.j.f302411e) goto L28;
    L30:
        boolean r111 = false;
    L31:
        if (r111 == false) goto L24;
        r104.add(r106);
        goto L24
    L28:
        if (r110.getParentId() != null) goto L30;
        r111 = true;
        goto L31
    L33:
        kc8.f r112 = new kc8.f(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null), Boolean.valueOf(r103), true, false, null, null, 504);
        ra8.b r107 = new ra8.b(null, null, null, false, Boolean.valueOf(r103), null, 111);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r112.f502482h = r107;
        hk9.a r108 = U3();
        if (r108 == null) goto L36;
        int r113 = kc8.y.f502619J;
        kc8.y.a r114 = new kc8.y.a();
        r114.f502661p = new d1();
        r114.f502662q = Boolean.FALSE;
        r114.f502667v = new e1(this);
        r114.f502654i = new f1();
        kc8.y r115 = r114.a();
        int r116 = kc8.v0.f502580p;
        kc8.v0.a r117 = new kc8.v0.a();
        int r118 = com.larus.utils.m0.f375450a;
        r117.f502597b = Integer.valueOf(com.larus.utils.m0.b(this.f378808a.f378238a.getContext()) - i5.p0());
        r117.f502596a = Boolean.TRUE;
        r117.f502605j = new g1(this);
        r117.f502598c = true;
        r117.f502599d = true;
        r117.f502602g = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        r117.f502604i = new i1(this);
        r117.f502603h = new h1(this, r610);
        kc8.v0 r109 = r117.a();
        int r119 = kc8.b.f502424y;
        kc8.b.a r120 = new kc8.b.a();
        r120.f502449a = r109;
        r120.f502450b = r115;
        r108.b(kc8.b.class, r120.a());
    L36:
        final boolean r121 = r103;
        final ?? r122 = new a1(r121, r100, r611, this, r104);
        final Ref.BooleanRef r123 = new Ref.BooleanRef();
        if (AppHost.f326268a.isTestChannel() == false) goto L39;
        long r124 = 50;
    L40:
        com.larus.voicecall.impl.utils.t.a("SubtitleBlockHolder_render", r124, new b1(r123, r122));
        if (r103 == false) goto L46;
        if (r123.element == true) goto L46;
        r122.invoke();
    L46:
        if (c78.a.f22663g.getBoolean("key_realtime_subtitle_holder_debug_flag", false) == false) goto L48;
        com.larus.utils.e1.x(this.f378808a.f378240c);
    L49:
        hk9.a r125 = U3();
        if (r125 == null) goto L58;
        ra8.a.d(r125, r104, r112, false);
        return;
    L58:
        return;
    L48:
        com.larus.utils.e1.o(this.f378808a.f378240c);
        goto L49
    L39:
        r124 = 300;
    L21:
        r103 = true;
        goto L22
    L13:
        r102 = false;
        goto L15
    }

    public SubtitleBlockHolder(LarusItemRecyclerSubtitleBlockBinding r100, f r101, u1 r102, g r103) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r101, "paramProvider");
        Intrinsics.checkNotNullParameter(r102, "selectCallBack");
        Intrinsics.checkNotNullParameter(r103, "actionProvider");
        super(r100.f378238a);
        this.f378808a = r100;
        this.f378809b = r101;
        this.f378810c = r102;
        this.f378811d = r103;
        this.f378813f = new Handler(Looper.getMainLooper());
        this.f378815h = LazyKt.lazy(new c1());
    }
}
