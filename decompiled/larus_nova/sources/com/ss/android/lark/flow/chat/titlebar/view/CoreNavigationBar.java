package com.ss.android.lark.flow.chat.titlebar.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.model.GXAnimation;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\f\b\u0007\u0018\u0000 \u0087\u00012\u00020\u0001:\u000e\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001bJ\u0010\u0010.\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010\u0019J\u0010\u00100\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102J\u0010\u00103\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u000102J\u000e\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020\u0014J\u001c\u00107\u001a\u00020,2\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020,\u0018\u000109J\u001c\u0010:\u001a\u00020,2\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020,\u0018\u000109J\u001c\u0010;\u001a\u00020,2\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020,\u0018\u000109J\u0010\u0010<\u001a\u00020,2\b\u0010=\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020,2\u0006\u0010?\u001a\u00020@J\u000e\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\u000fJ\u000e\u0010D\u001a\u00020(2\u0006\u0010C\u001a\u00020\u000fJ\u0006\u0010E\u001a\u00020,J\u0006\u0010F\u001a\u00020,J\u0017\u0010G\u001a\u00020,2\n\b\u0001\u0010H\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010IJ\u000e\u0010J\u001a\u00020,2\u0006\u0010K\u001a\u00020(J\u0010\u0010L\u001a\u00020,2\b\b\u0001\u0010H\u001a\u00020\u0007J\u0010\u0010M\u001a\u00020,2\b\b\u0001\u0010H\u001a\u00020\u0007J\u0018\u0010N\u001a\u00020,2\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0007H\u0014J0\u0010Q\u001a\u00020,2\u0006\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u0007H\u0014J\u0010\u0010W\u001a\u00020,2\u0006\u0010X\u001a\u00020YH\u0014J\b\u0010Z\u001a\u00020[H\u0014J\u0012\u0010\\\u001a\u00020[2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020[H\u0014J\u0010\u0010^\u001a\u00020(2\u0006\u0010]\u001a\u00020[H\u0014J\u0018\u0010_\u001a\u00020,2\u0006\u0010?\u001a\u00020@2\u0006\u0010`\u001a\u00020(H\u0002J\u0018\u0010a\u001a\u00020(2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020(H\u0002J\u0010\u0010b\u001a\u00020,2\u0006\u0010`\u001a\u00020(H\u0002J\u0010\u0010c\u001a\u00020\u00142\u0006\u0010?\u001a\u00020@H\u0002J\u0016\u0010d\u001a\u00020,2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00140fH\u0002JF\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070h2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u000f0j2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140k2\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0002J(\u0010n\u001a\u00020,2\u0006\u0010o\u001a\u00020\u00142\u0006\u0010p\u001a\u00020q2\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0002J0\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020(H\u0002J0\u0010x\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020(H\u0002J\u0010\u0010z\u001a\u00020\u00072\u0006\u0010{\u001a\u00020|H\u0002J\u0012\u0010}\u001a\u00020,2\b\u00106\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010~\u001a\u00020,H\u0002J\b\u0010\u007f\u001a\u00020,H\u0002J\t\u0010\u0080\u0001\u001a\u00020,H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u001e\u001a\u00060\u001fR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010%R\u0012\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "minActionSizePx", "minBarHeightPx", "dividerHeightPx", "leftActionOrder", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "rightActionOrder", "leftActionViews", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "Lkotlin/collections/LinkedHashMap;", "rightActionViews", "centerView", "centerViewProvider", "Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$ViewProvider;", "centerAlignment", "Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$CenterHorizontalAlignment;", "titleStyleConfigure", "Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$ITitleStyleConfigure;", "defaultCenterView", "Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$DefaultCenterView;", "getDefaultCenterView", "()Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$DefaultCenterView;", "defaultCenterView$delegate", "Lkotlin/Lazy;", "iconTintColor", "Ljava/lang/Integer;", "dividerColor", "dividerVisible", "", "dividerPaint", "Landroid/graphics/Paint;", "setCenterHorizontalAlignment", "", "alignment", "setCenterViewProvider", ShortVideoSegments.KEY_PROP_PROVIDER, com.alipay.sdk.m.x.d.f25925o, "title", "", "setSubtitle", "subtitle", "setSubtitleView", "view", "setTitleClickListener", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function1;", "setTitleRowClickListener", "setSubTitleClickListener", "setTitleStyleConfigure", "configure", "addLeftAction", "action", "Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$Action;", "addRightAction", "removeLeftAction", "actionId", "removeRightAction", "clearLeftActions", "clearRightActions", "setIconTint", "color", "(Ljava/lang/Integer;)V", "setDividerVisible", "visible", "setDividerColor", "setNavigationBarBackgroundColor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "onDraw", "canvas", "Landroid/graphics/Canvas;", "generateDefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "p", "checkLayoutParams", "addActionInternal", "isLeft", "removeActionInternal", "clearActionsInternal", "resolveActionView", "applyTintToAutoCreatedActionViews", "views", "", "measureActions", "Lkotlin/Pair;", SlcCommonAction.KEY_ACTIONS, "", "", "parentWidth", "parentHeightSpec", "measureActionChild", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "lp", "Landroid/view/ViewGroup$MarginLayoutParams;", "layoutLeftActions", "startX", "top", "bottom", "centerY", "isRtl", "layoutRightActions", "endX", "dpToPx", "dp", "", "setCenterViewInternal", "ensureDefaultCenterAttachedIfNoCustomCenter", "ensureDefaultCenterAttached", "applyTitleStyleConfigure", "ViewProvider", "ITitleStyleConfigure", TTVideoEngineInterface.PLAY_API_KEY_ACTION, "SimpleAction", "CenterHorizontalAlignment", "DefaultCenterView", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoreNavigationBar extends ViewGroup {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f423112q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f423113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f423114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f423115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Object> f423116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Object> f423117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap<Object, View> f423118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap<Object, View> f423119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f423120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f423121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CenterHorizontalAlignment f423122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f423123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f423124l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f423125m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f423126n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f423127o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f423128p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$CenterHorizontalAlignment;", "", "<init>", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, "CENTER", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CenterHorizontalAlignment extends Enum<CenterHorizontalAlignment> {
        public static final CenterHorizontalAlignment CENTER = null;
        public static final CenterHorizontalAlignment START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CenterHorizontalAlignment[] f423129a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f423130b = null;

        public static EnumEntries<CenterHorizontalAlignment> getEntries() {
            return f423130b;
        }

        static {
            CenterHorizontalAlignment r100 = new CenterHorizontalAlignment(GXAnimation.STATE_START, 0);
            START = r100;
            CenterHorizontalAlignment r101 = new CenterHorizontalAlignment("CENTER", 1);
            CENTER = r101;
            CenterHorizontalAlignment[] r102 = {r100, r101};
            f423129a = r102;
            f423130b = EnumEntriesKt.enumEntries(r102);
        }

        public static CenterHorizontalAlignment[] values() {
            return (CenterHorizontalAlignment[]) f423129a.clone();
        }

        public static CenterHorizontalAlignment valueOf(String r100) {
            return (CenterHorizontalAlignment) r27.a.a(CenterHorizontalAlignment.class, r100);
        }

        public CenterHorizontalAlignment(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f423131a = null;

        static {
            f423131a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class b {
    }

    public final class c extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppCompatTextView f423132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AppCompatTextView f423133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppCompatImageView f423134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final FrameLayout f423135d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinearLayout f423136e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f423137f;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f423138a = null;

            static {
                int[] r100 = new int[CenterHorizontalAlignment.values().length];
                r100[CenterHorizontalAlignment.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[CenterHorizontalAlignment.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f423138a = r100;
            }
        }

        public final void a(CenterHorizontalAlignment r100) {
            Intrinsics.checkNotNullParameter(r100, "alignment");
            int[] r101 = a.f423138a;
            int r102 = r101[r100.ordinal()];
            int r103 = 8388627;
            if (r102 == 1) goto L8;
            if (r102 != 2) goto L7;
            int r104 = 17;
        L9:
            setGravity(r104);
            int r105 = r101[r100.ordinal()];
            if (r105 == 1) goto L15;
            if (r105 != 2) goto L14;
            int r106 = 4;
        L16:
            LinearLayout r107 = this.f423136e;
            int r108 = r101[r100.ordinal()];
            if (r108 == 1) goto L22;
            if (r108 != 2) goto L21;
            r103 = 17;
            goto L22
        L21:
            throw new NoWhenBranchMatchedException();
        L22:
            r107.setGravity(r103);
            this.f423132a.setTextAlignment(r106);
            this.f423133b.setTextAlignment(r106);
            View r109 = this.f423137f;
            if (r109 == null) goto L26;
            r109.setTextAlignment(r106);
            return;
        L26:
            return;
        L14:
            throw new NoWhenBranchMatchedException();
        L15:
            r106 = 5;
            goto L16
        L7:
            throw new NoWhenBranchMatchedException();
        L8:
            r104 = 8388627;
            goto L9
        }

        public c(CoreNavigationBar r110, Context r111) {
            Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r111);
            AppCompatTextView r100 = new AppCompatTextView(r111);
            this.f423132a = r100;
            AppCompatTextView r101 = new AppCompatTextView(r111);
            this.f423133b = r101;
            AppCompatImageView r102 = new AppCompatImageView(r111);
            this.f423134c = r102;
            FrameLayout r103 = new FrameLayout(r111);
            this.f423135d = r103;
            LinearLayout r104 = new LinearLayout(r111);
            this.f423136e = r104;
            setOrientation(1);
            setGravity(17);
            r104.setOrientation(0);
            r104.setGravity(16);
            r100.setMaxLines(1);
            r100.setEllipsize(TextUtils.TruncateAt.END);
            r100.setIncludeFontPadding(false);
            r100.setTextSize(2, 17.0f);
            r100.setTypeface(r100.getTypeface(), 1);
            r103.setId(R.id.flow_chat_tag_container);
            r103.setVisibility(8);
            int r105 = CoreNavigationBar.f423112q;
            int r112 = r110.e(12.0f);
            r102.setLayoutParams(new LinearLayout.LayoutParams(r112, r112));
            r102.setImageResource(R.drawable.ic_chevron_left_bold);
            r102.setVisibility(8);
            r101.setMaxLines(1);
            r101.setEllipsize(TextUtils.TruncateAt.END);
            r101.setIncludeFontPadding(false);
            r101.setTextSize(2, 11.0f);
            r101.setVisibility(8);
            LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-2, -2);
            r113.weight = 1.0f;
            Unit r106 = Unit.INSTANCE;
            r104.addView(r100, r113);
            LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(-2, -2);
            r114.setMarginStart(UIUtils.dp2px(r111, 4.0f));
            r104.addView(r103, r114);
            r104.addView(r102);
            addView(r104, new LinearLayout.LayoutParams(-2, -2));
            addView(r101, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    public interface d {
        void a(AppCompatTextView r100);

        void b(AppCompatImageView r100);

        void c(AppCompatTextView r100);
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f423139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable f423140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f423141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f f423142d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function1<View, Unit> f423143e;

        public e() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f423139a, r101.f423139a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f423140b, r101.f423140b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f423141c, r101.f423141c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f423142d, r101.f423142d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f423143e, r101.f423143e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f423139a.hashCode() * 31;
            Drawable r101 = this.f423140b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Integer r105 = this.f423141c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            f r108 = this.f423142d;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            Function1<View, Unit> r111 = this.f423143e;
            if (r111 == null) goto L19;
            r102 = r111.hashCode();
        L19:
            return r110 + r102;
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "SimpleAction(id=" + this.f423139a + ", iconDrawable=" + this.f423140b + ", iconResId=" + this.f423141c + ", iconViewProvider=" + this.f423142d + ", onClick=" + this.f423143e + ')';
        }

        public e(TitleBarActionKey r100, Drawable r101, f r102, Function1 r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r104 & 8) == 0) goto L9;
            r102 = null;
        L9:
            if ((r104 & 16) == 0) goto L11;
            r103 = null;
        L11:
            Intrinsics.checkNotNullParameter(r100, "id");
            this.f423139a = r100;
            this.f423140b = r101;
            this.f423141c = null;
            this.f423142d = r102;
            this.f423143e = r103;
        }
    }

    public interface f {
        View createView(Context r100);
    }

    public /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f423144a = null;

        static {
            int[] r100 = new int[CenterHorizontalAlignment.values().length];
            r100[CenterHorizontalAlignment.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CenterHorizontalAlignment.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f423144a = r100;
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f423145a;

        public h(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f423145a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View r100) {
            this.f423145a.invoke(r100);
        }
    }

    static {
    }

    public CoreNavigationBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CoreNavigationBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final c getDefaultCenterView() {
        return (c) this.f423124l.getValue();
    }

    public final void c() {
        d r100 = this.f423123k;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.c(getDefaultCenterView().f423132a);
        r100.a(getDefaultCenterView().f423133b);
        r100.b(getDefaultCenterView().f423134c);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public final void f() {
        getDefaultCenterView().a(this.f423122j);
        c();
        setCenterViewInternal(getDefaultCenterView());
    }

    private final void setCenterViewInternal(View r100) {
        View r101 = this.f423120h;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        removeView(r101);
    L7:
        this.f423120h = r100;
        if (r100 != null) goto L10;
    L13:
        requestLayout();
        return;
    L10:
        if (r100.getLayoutParams() != null) goto L12;
        r100.setLayoutParams(generateDefaultLayoutParams());
    L12:
        addView(r100);
        goto L13
    }

    public final void b(Collection<? extends View> r100) {
        Integer r101 = this.f423125m;
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        View r103 = (View) r102.next();
        if (Intrinsics.areEqual(r103.getTag(), "core_navigation_bar:auto_action_view") == false) goto L4;
        if ((r103 instanceof AppCompatImageView) == false) goto L4;
        if (r101 == null) goto L10;
        ((AppCompatImageView) r103).setColorFilter(r101.intValue());
        goto L4
    L10:
        ((AppCompatImageView) r103).clearColorFilter();
        goto L4
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        return r100 instanceof ViewGroup.MarginLayoutParams;
    }

    public final void d(boolean r100) {
        if (r100 == false) goto L4;
        ArrayList<Object> r101 = this.f423116d;
        LinkedHashMap<Object, View> r102 = this.f423118f;
    L5:
        Pair r103 = TuplesKt.to(r101, r102);
        ArrayList r104 = (ArrayList) r103.component1();
        LinkedHashMap r105 = (LinkedHashMap) r103.component2();
        Iterator r106 = r105.values().iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        removeView((View) r106.next());
        goto L7
    L9:
        r105.clear();
        r104.clear();
        requestLayout();
        return;
    L4:
        r101 = this.f423117e;
        r102 = this.f423119g;
        goto L5
    }

    public final int e(float r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        return new ViewGroup.MarginLayoutParams(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f423127o == true) goto L6;
        return;
    L6:
        if (this.f423115c > 0) goto L8;
        return;
    L8:
        this.f423128p.setColor(this.f423126n);
        r100.drawRect(0.0f, getHeight() - this.f423115c, getWidth(), getHeight(), this.f423128p);
    }

    public final void setCenterHorizontalAlignment(CenterHorizontalAlignment r100) {
        Intrinsics.checkNotNullParameter(r100, "alignment");
        if (this.f423122j == r100) goto L9;
        this.f423122j = r100;
        if (this.f423120h != getDefaultCenterView()) goto L7;
        getDefaultCenterView().a(r100);
    L7:
        requestLayout();
        return;
    }

    public final void setCenterViewProvider(f r100) {
        this.f423121i = r100;
        if (r100 != null) goto L6;
        f();
        return;
    L6:
        View r101 = r100.createView(getContext());
        ViewParent r102 = r101.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L9;
        ViewGroup r103 = (ViewGroup) r102;
    L10:
        if (r103 == null) goto L12;
        r103.removeView(r101);
    L12:
        setCenterViewInternal(r101);
        return;
    L9:
        r103 = null;
        goto L10
    }

    public final void setDividerColor(int r100) {
        if (this.f423126n == r100) goto L6;
        this.f423126n = r100;
        invalidate();
        return;
    }

    public final void setDividerVisible(boolean r100) {
        if (this.f423127o == r100) goto L6;
        this.f423127o = r100;
        invalidate();
        return;
    }

    public final void setIconTint(Integer r100) {
        if (Intrinsics.areEqual(this.f423125m, r100) == false) goto L5;
        return;
    L5:
        this.f423125m = r100;
        b(this.f423118f.values());
        b(this.f423119g.values());
        c r101 = getDefaultCenterView();
        if (r100 != null) goto L8;
        r101.f423134c.clearColorFilter();
    L9:
        invalidate();
        return;
    L8:
        r101.f423134c.setColorFilter(r100.intValue());
        goto L9
    }

    public final void setNavigationBarBackgroundColor(int r100) {
        setBackgroundColor(r100);
    }

    public final void setSubTitleClickListener(Function1<? super View, Unit> r100) {
        c r101 = getDefaultCenterView();
        if (r100 != null) goto L5;
        r101.f423133b.setOnClickListener(null);
        r101.f423133b.setClickable(false);
        return;
    L5:
        r101.f423133b.setClickable(true);
        r101.f423133b.setOnClickListener(new h(r100));
    }

    public final void setSubtitle(CharSequence r100) {
        c r101 = getDefaultCenterView();
        View r102 = r101.f423137f;
        if (r102 == null) goto L5;
        r101.removeView(r102);
    L5:
        r101.f423137f = null;
        if (r100 != null) goto L8;
    L11:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        r101.f423133b.setText(null);
        r101.f423133b.setVisibility(8);
        r101.f423132a.setTextSize(2, 17.0f);
    L17:
        if (this.f423121i != null) goto L21;
        f();
        return;
    L21:
        return;
    L15:
        r101.f423133b.setText(r100);
        r101.f423133b.setVisibility(0);
        r101.f423132a.setTextSize(2, 15.0f);
        goto L17
    L8:
        if (r100.length() == 0) goto L11;
        r103 = false;
        goto L13
    }

    public final void setSubtitleView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        c r101 = getDefaultCenterView();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "view");
        View r102 = r101.f423137f;
        if (r102 == r100) goto L13;
        if (r102 == null) goto L6;
        r101.removeView(r102);
    L6:
        ViewParent r103 = r100.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L9;
        ViewGroup r104 = (ViewGroup) r103;
    L10:
        if (r104 == null) goto L12;
        r104.removeView(r100);
    L12:
        r101.f423137f = r100;
        r101.addView(r100, new LinearLayout.LayoutParams(-2, -2));
        goto L13
    L9:
        r104 = null;
    L13:
        r101.f423133b.setText(null);
        r101.f423133b.setVisibility(8);
        r100.setVisibility(0);
        r100.setTextAlignment(r101.f423133b.getTextAlignment());
        r101.f423132a.setTextSize(2, 15.0f);
        if (this.f423121i != null) goto L18;
        f();
        return;
    }

    public final void setTitle(CharSequence r100) {
        getDefaultCenterView().f423132a.setText(r100);
        if (this.f423121i != null) goto L7;
        f();
        return;
    }

    public final void setTitleClickListener(Function1<? super View, Unit> r100) {
        c r101 = getDefaultCenterView();
        if (r100 != null) goto L5;
        r101.f423132a.setOnClickListener(null);
        r101.f423132a.setClickable(false);
        r101.f423134c.setVisibility(8);
    L7:
        if (this.f423121i != null) goto L11;
        f();
        return;
    L11:
        return;
    L5:
        r101.f423132a.setClickable(true);
        r101.f423132a.setOnClickListener(new h(r100));
        r101.f423134c.setVisibility(0);
        goto L7
    }

    public final void setTitleRowClickListener(Function1<? super View, Unit> r100) {
        LinearLayout r101 = getDefaultCenterView().f423136e;
        if (r100 == null) goto L5;
        h r102 = new h(r100);
    L6:
        r101.setOnClickListener(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setTitleStyleConfigure(d r100) {
        this.f423123k = r100;
        c();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.widget.ImageView, androidx.appcompat.widget.AppCompatImageView] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.ViewGroup, com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar] */
    public final void a(e r100, boolean r101) {
        if (r101 == false) goto L4;
        ArrayList<Object> r102 = this.f423116d;
        LinkedHashMap<Object, View> r103 = this.f423118f;
    L5:
        Pair r104 = TuplesKt.to(r102, r103);
        ArrayList r105 = (ArrayList) r104.component1();
        LinkedHashMap r106 = (LinkedHashMap) r104.component2();
        View r107 = (View) r106.get(r100.f423139a);
        if (r107 == null) goto L8;
        removeView(r107);
        r106.remove(r100.f423139a);
        r105.remove(r100.f423139a);
    L8:
        f r108 = r100.f423142d;
        h r109 = null;
        if (r108 == null) goto L16;
        ?? r110 = r108.createView(getContext());
        ViewParent r111 = r110.getParent();
        if ((r111 instanceof ViewGroup) == false) goto L13;
        ?? r112 = (ViewGroup) r111;
    L14:
        if (r112 == 0) goto L34;
        r112.removeView(r110);
    L34:
        r110.setMinimumWidth(Math.max(r110.getMinimumWidth(), this.f423113a));
        r110.setMinimumHeight(Math.max(r110.getMinimumHeight(), this.f423113a));
        Function1<View, Unit> r113 = r100.f423143e;
        if (r113 == null) goto L37;
        r109 = new h(r113);
    L37:
        r110.setOnClickListener(r109);
        if (r110.getLayoutParams() != null) goto L40;
        int r114 = this.f423113a;
        r110.setLayoutParams(new ViewGroup.MarginLayoutParams(r114, r114));
    L40:
        addView(r110);
        r105.add(r100.f423139a);
        r106.put(r100.f423139a, r110);
        requestLayout();
        return;
    L13:
        r112 = 0;
        goto L14
    L16:
        r110 = new AppCompatImageView(getContext());
        r110.setClickable(true);
        r110.setFocusable(true);
        r110.setScaleType(ImageView.ScaleType.CENTER);
        Drawable r115 = r100.f423140b;
        if (r115 == null) goto L19;
        r110.setImageDrawable(r115);
    L30:
        Integer r116 = this.f423125m;
        if (r116 == null) goto L33;
        r110.setColorFilter(r116.intValue());
    L33:
        r110.setTag("core_navigation_bar:auto_action_view");
        goto L34
    L19:
        Integer r117 = r100.f423141c;
        if (r117 == null) goto L30;
        if (r117 != null) goto L24;
    L25:
        Integer r118 = r100.f423141c;
        if (r118 == null) goto L28;
        int r119 = r118.intValue();
    L29:
        r110.setImageResource(r119);
        goto L30
    L28:
        r119 = 0;
        goto L29
    L24:
        if (r117.intValue() == 0) goto L30;
    L4:
        r102 = this.f423117e;
        r103 = this.f423119g;
        goto L5
    }

    public final boolean h(Object r100, boolean r101) {
        if (r101 == false) goto L4;
        ArrayList<Object> r102 = this.f423116d;
        LinkedHashMap<Object, View> r103 = this.f423118f;
    L5:
        Pair r104 = TuplesKt.to(r102, r103);
        ArrayList r105 = (ArrayList) r104.component1();
        View r106 = (View) ((LinkedHashMap) r104.component2()).remove(r100);
        if (r106 != null) goto L9;
        return false;
    L9:
        r105.remove(r100);
        removeView(r106);
        requestLayout();
        return true;
    L4:
        r102 = this.f423117e;
        r103 = this.f423119g;
        goto L5
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = View.MeasureSpec.getSize(r110);
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        int r102 = getPaddingRight();
    L9:
        if (r101 == false) goto L11;
        int r103 = getPaddingLeft();
    L12:
        int r104 = getPaddingTop();
        int r105 = getPaddingBottom();
        int r106 = Math.max(0, (r100 - r102) - r103);
        Pair<Integer, Integer> r112 = g(this.f423116d, this.f423118f, r106, r111);
        Pair<Integer, Integer> r113 = g(this.f423117e, this.f423119g, r106, r111);
        int r114 = r112.getFirst().intValue();
        int r115 = r113.getFirst().intValue();
        int r116 = Math.max(r114, r115);
        View r117 = this.f423120h;
        CenterHorizontalAlignment r107 = this.f423122j;
        int r108 = g.f423144a[r107.ordinal()];
        if (r108 != 1) goto L15;
        int r109 = 0;
        int r118 = Math.max(0, (r106 - r114) - r115);
    L20:
        if (r117 == null) goto L22;
        ViewGroup.LayoutParams r119 = r117.getLayoutParams();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r119;
        r117.measure(View.MeasureSpec.makeMeasureSpec(Math.max(r109, (r118 - r120.leftMargin) - r120.rightMargin), Integer.MIN_VALUE), ViewGroup.getChildMeasureSpec(r111, ((r104 + r105) + r120.topMargin) + r120.bottomMargin, r120.height));
        r117.getMeasuredWidth();
        r109 = (r117.getMeasuredHeight() + r120.topMargin) + r120.bottomMargin;
    L22:
        int r121 = Math.max(Math.max(r112.getSecond().intValue(), r113.getSecond().intValue()), r109);
        int r122 = ViewGroup.resolveSize(Math.max(this.f423114b, (r121 + r104) + r105), r111);
        setMeasuredDimension(ViewGroup.resolveSize(Math.max(r100, r102 + r103), r110), r122);
        return;
    L15:
        if (r108 != 2) goto L18;
        r109 = 0;
        r118 = Math.max(0, r106 - (r116 * 2));
        goto L20
    L18:
        throw new NoWhenBranchMatchedException();
    L11:
        r103 = getPaddingRight();
        goto L12
    L8:
        r102 = getPaddingLeft();
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    public CoreNavigationBar(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f423113a = e(44.0f);
        int r103 = e(44.0f);
        this.f423114b = r103;
        this.f423115c = Math.max(1, e(0.5f));
        this.f423116d = new ArrayList();
        this.f423117e = new ArrayList();
        this.f423118f = new LinkedHashMap();
        this.f423119g = new LinkedHashMap();
        this.f423122j = CenterHorizontalAlignment.CENTER;
        this.f423124l = LazyKt.lazy(new CoreNavigationBar$defaultCenterView$2(this, r100));
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.FILL);
        this.f423128p = r104;
        setMinimumHeight(r103);
        setClipToPadding(false);
        setWillNotDraw(false);
        f();
        setOnClickListener(a.f423131a);
    }

    public /* synthetic */ CoreNavigationBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final Pair<Integer, Integer> g(List<? extends Object> r110, Map<Object, ? extends View> r111, int r112, int r113) {
        Iterator<T> r114 = r110.iterator();
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r114.hasNext() == false) goto L15;
        LinkedHashMap r102 = (LinkedHashMap) r111;
        View r103 = (View) r102.get(r114.next());
        if (r103 == null) goto L4;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        int r106 = Math.max(0, (r112 - r105.leftMargin) - r105.rightMargin);
        int r107 = ViewGroup.getChildMeasureSpec(r113, ((getPaddingTop() + getPaddingBottom()) + r105.topMargin) + r105.bottomMargin, r105.height);
        r103.measure(View.MeasureSpec.makeMeasureSpec(r106, Integer.MIN_VALUE), r107);
        int r108 = Math.max(this.f423113a, r103.getMeasuredWidth());
        int r109 = Math.max(this.f423113a, r103.getMeasuredHeight());
        if (r103.getMeasuredWidth() == r108) goto L11;
    L12:
        r103.measure(View.MeasureSpec.makeMeasureSpec(Math.min(r108, r106), 1073741824), View.MeasureSpec.makeMeasureSpec(r109, 1073741824));
    L13:
        int r115 = (r103.getMeasuredWidth() + r105.leftMargin) + r105.rightMargin;
        r100 = r100 + r115;
        r101 = Math.max(r101, (r103.getMeasuredHeight() + r105.topMargin) + r105.bottomMargin);
        goto L4
    L11:
        if (r103.getMeasuredHeight() == r109) goto L13;
    L15:
        return TuplesKt.to(Integer.valueOf(r100), Integer.valueOf(r101));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        int r100 = r211 - r111;
        int r101 = r212 - r210;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        int r103 = getPaddingRight();
    L9:
        if (r102 == false) goto L11;
        int r104 = getPaddingLeft();
    L12:
        int r105 = r100 - r104;
        int r106 = (getPaddingTop() + (r101 - getPaddingBottom())) / 2;
        int r112 = -1;
        int r107 = this.f423116d.size() - 1;
        int r113 = r103;
    L14:
        if ((-1) >= r107) goto L24;
        View r114 = this.f423118f.get(ListProtector.get(this.f423116d, r107));
        if (r114 == null) goto L23;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        int r117 = r114.getMeasuredWidth();
        int r118 = r114.getMeasuredHeight();
        int r108 = r106 - (r118 / 2);
        int r119 = r118 + r108;
        int r120 = r113 + r116.leftMargin;
        int r109 = r120 + r117;
        if (r102 == true) goto L21;
        r114.layout(r120, r108, r109, r119);
    L22:
        r113 = r109 + r116.rightMargin;
        goto L23
    L21:
        int r121 = getWidth() - r120;
        r114.layout(r121 - r117, r108, r121, r119);
    L23:
        r107 = r107 - 1;
        goto L14
    L24:
        int r122 = this.f423117e.size() - 1;
        int r123 = r105;
    L25:
        if (r112 >= r122) goto L40;
        View r124 = this.f423119g.get(ListProtector.get(this.f423117e, r122));
        if (r124 == null) goto L39;
        if (r124.getVisibility() != 0) goto L32;
        boolean r125 = true;
    L33:
        if (r125 == false) goto L39;
        ViewGroup.LayoutParams r126 = r124.getLayoutParams();
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r127 = (ViewGroup.MarginLayoutParams) r126;
        int r128 = r124.getMeasuredWidth();
        int r129 = r124.getMeasuredHeight();
        int r130 = r106 - (r129 / 2);
        int r131 = r129 + r130;
        int r132 = r123 - r127.rightMargin;
        int r133 = r132 - r128;
        if (r102 == true) goto L37;
        r124.layout(r133, r130, r132, r131);
    L38:
        r123 = r133 - r127.leftMargin;
        goto L39
    L37:
        int r134 = getWidth() - r133;
        r124.layout(r134 - r128, r130, r134, r131);
        goto L38
    L32:
        r125 = false;
    L39:
        r122 = r122 - 1;
        r112 = -1;
        goto L25
    L40:
        View r135 = this.f423120h;
        if (r135 == null) goto L62;
        ViewGroup.LayoutParams r136 = r135.getLayoutParams();
        Intrinsics.checkNotNull(r136, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r137 = (ViewGroup.MarginLayoutParams) r136;
        int r138 = r135.getMeasuredWidth();
        int r139 = r135.getMeasuredHeight();
        int r140 = r106 - (r139 / 2);
        int r141 = r139 + r140;
        int r142 = g.f423144a[this.f423122j.ordinal()];
        if (r142 != 1) goto L45;
        int r143 = Math.min(r113 + r137.leftMargin, (r123 - r137.rightMargin) - r138);
    L50:
        int r144 = r143 + r138;
        if (r102 == true) goto L53;
        r135.layout(r143, r140, r144, r141);
        return;
    L53:
        int r145 = r100 - r143;
        r135.layout(r145 - r138, r140, r145, r141);
        return;
    L45:
        if (r142 != 2) goto L48;
        int r146 = Math.max(r113 - r103, r105 - r123);
        int r147 = r103 + r146;
        r143 = r147 + ((Math.max(0, (r105 - r146) - r147) - r138) / 2);
        goto L50
    L48:
        throw new NoWhenBranchMatchedException();
    L62:
        return;
    L11:
        r104 = getPaddingRight();
        goto L12
    L8:
        r103 = getPaddingLeft();
        goto L9
    L5:
        r102 = false;
        goto L6
    }
}
