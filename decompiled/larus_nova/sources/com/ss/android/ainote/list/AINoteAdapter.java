package com.ss.android.ainote.list;

import android.content.Context;
import android.os.SystemClock;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.ainote.AINoteEditEnterSource;
import com.ss.android.ainote.AINoteRichTextAdapter;
import com.ss.android.ainote.VCAINoteEditText;
import com.ss.android.ainote.model.AINoteContentState;
import com.ss.android.ainote.model.AINoteCreateSource;
import com.ss.android.ainote.model.AINoteScene;
import com.ss.android.ainote.model.AINoteType;
import com.ss.android.ainote.r0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004cdefB¡\u0002\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\b\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\b\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\b\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010+\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010,\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 J\u0015\u0010-\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u001cJ\u0018\u00102\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u000104J\u001e\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a072\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0014\u00108\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a07J\"\u00109\u001a\b\u0012\u0004\u0012\u00020\u001a072\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a072\u0006\u0010:\u001a\u00020\u0005J\u001e\u0010;\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a072\u0006\u0010<\u001a\u00020\u001cH\u0002J#\u0010=\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010>\u001a\u00020$H\u0000¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010/J\u000e\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u001cJ\u000e\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020)J\u0006\u0010F\u001a\u00020)J\u0006\u0010G\u001a\u00020\u001cJ\u000e\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020\u001aJ\u0006\u0010J\u001a\u00020)J\b\u0010K\u001a\u00020)H\u0016J\u0010\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020)H\u0016J\u0010\u0010N\u001a\u00020)2\u0006\u0010M\u001a\u00020)H\u0016J\u0018\u0010O\u001a\u00020\u00022\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020)H\u0016J\u0018\u0010S\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u00022\u0006\u0010M\u001a\u00020)H\u0016J&\u0010S\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u00022\u0006\u0010M\u001a\u00020)2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u0019H\u0016J\u0010\u0010W\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u0002H\u0016J\u0010\u0010X\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u0002H\u0016J \u0010Y\u001a\u00020\u00062\u0006\u0010T\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u001a2\u0006\u0010M\u001a\u00020)H\u0002J \u0010\\\u001a\u00020\u00062\u0006\u0010]\u001a\u00020^2\u0006\u0010[\u001a\u00020\u001a2\u0006\u0010M\u001a\u00020)H\u0002J\u0010\u0010_\u001a\u00020\u00062\u0006\u0010T\u001a\u00020`H\u0002J \u0010a\u001a\u00020\u00062\u0006\u0010T\u001a\u00020Z2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\tH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010&\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/ss/android/ainote/list/AINoteAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onItemActivated", "Lkotlin/Function1;", "", "", "onItemBlur", "Lkotlin/Function2;", "", "onItemInputChanged", "onItemImageDelete", "onItemImageRetry", "onItemImageClick", "Lcom/ss/android/ainote/model/AINoteGalleryImage;", "onItemGalleryBlankClick", "onItemDelete", "onItemLongClickMenuRequest", "onItemAiPolishDisplayed", "onItemFinishToUseAnimationConsumed", "onFooterClick", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "items", "", "Lcom/ss/android/ainote/model/AINoteBlockModel;", "showFooter", "", "delegate", "Lcom/ss/android/ainote/IAINoteDelegate;", "scene", "Lcom/ss/android/ainote/model/AINoteScene;", "desiredFocusNoteId", "Ljava/lang/Long;", "desiredFocusSource", "Lcom/ss/android/ainote/AINoteEditEnterSource;", "highlightedNoteId", "footerHintVisible", "editingNoteId", "footerBlankHeightPx", "", "liveRewritingEnabled", "setDelegate", "setScene", "setEditingNoteId", "noteId", "(Ljava/lang/Long;)V", "setLiveRewritingEnabled", "enabled", "syncCachedInput", "inputRichText", "Lcom/ss/android/lark/widget/richtext/RichText;", "setItemsFromSession", "newItems", "", "syncItemsFromSessionSilently", "syncItemsFromSessionPreservingItem", "protectedStableUiId", "mergeItemsFromSession", "notifyChanged", "setDesiredFocus", "source", "setDesiredFocus$ai_note_release", "(Ljava/lang/Long;Lcom/ss/android/ainote/AINoteEditEnterSource;)V", "setHighlightedNoteId", "setFooterHintVisible", "visible", "setFooterBlankHeight", "heightPx", "getFooterBlankHeight", "isFooterHintVisible", "indexOfNote", "note", "footerPosition", "getItemCount", "getItemId", "position", "getItemViewType", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "onViewRecycled", "onViewAttachedToWindow", "bindNote", "Lcom/ss/android/ainote/list/AINoteViewHolder;", MapController.ITEM_LAYER_TAG, "applyNoteItemMargins", "itemView", "Landroid/view/View;", "bindFooter", "Lcom/ss/android/ainote/list/AINoteAdapter$FooterViewHolder;", "requestDesiredFocusIfNeeded", "reason", "Companion", "NoteBindingSnapshot", "PositionBindingSnapshot", "FooterViewHolder", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AINoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Long, Unit> f406840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Long, String, Unit> f406841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Long, String, Unit> f406842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Long, String, Unit> f406843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<Long, String, Unit> f406844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<Long, xra.b, Unit> f406845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<Long, Unit> f406846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<Long, String, Unit> f406847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<Long, Unit> f406848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function2<Long, Long, Unit> f406849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function2<Long, Long, Unit> f406850k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Unit> f406851l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<xra.a> f406852m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f406853n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public r0 f406854o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AINoteScene f406855p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Long f406856q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AINoteEditEnterSource f406857r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Long f406858s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f406859t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Long f406860u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f406861v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f406862w;

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f406863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f406864b;

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f406863a = (TextView) r100.findViewById(R.id.ai_note_footer_hint);
            this.f406864b = r100.findViewById(R.id.ai_note_footer_blank);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final /* synthetic */ int f406865p = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f406866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AINoteCreateSource f406867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RichText f406868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f406869d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RichText f406870e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f406871f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<xra.b> f406872g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AINoteType f406873h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f406874i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f406875j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final AINoteContentState f406876k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f406877l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final long f406878m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final long f406879n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f406880o;

        public static final class a {
            public static c a(xra.a r210) {
                Intrinsics.checkNotNullParameter(r210, MapController.ITEM_LAYER_TAG);
                return new c(r210.c(), r210.f564898c, r210.f564899d, r210.f564900e, r210.f564901f, r210.f564902g, r210.f564903h, r210.f564904i, r210.f564905j, r210.f564906k, r210.f564908m, r210.f564911p, r210.f564912q, r210.f564914s, r210.f564918w);
            }
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f406866a == r101.f406866a) goto L12;
            return false;
        L12:
            if (this.f406867b == r101.f406867b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f406868c, r101.f406868c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f406869d, r101.f406869d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f406870e, r101.f406870e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f406871f, r101.f406871f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f406872g, r101.f406872g) == true) goto L30;
            return false;
        L30:
            if (this.f406873h == r101.f406873h) goto L33;
            return false;
        L33:
            if (this.f406874i == r101.f406874i) goto L36;
            return false;
        L36:
            if (this.f406875j == r101.f406875j) goto L39;
            return false;
        L39:
            if (this.f406876k == r101.f406876k) goto L42;
            return false;
        L42:
            if (this.f406877l == r101.f406877l) goto L45;
            return false;
        L45:
            if (this.f406878m == r101.f406878m) goto L48;
            return false;
        L48:
            if (this.f406879n == r101.f406879n) goto L51;
            return false;
        L51:
            if (this.f406880o == r101.f406880o) goto L53;
            return false;
        L53:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f406866a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            AINoteCreateSource r102 = this.f406867b;
            int r103 = 0;
            if (r102 != null) goto L5;
            int r104 = 0;
        L6:
            int r105 = (r101 + r104) * 31;
            RichText r106 = this.f406868c;
            if (r106 != null) goto L9;
            int r107 = 0;
        L10:
            int r108 = (r105 + r107) * 31;
            String r109 = this.f406869d;
            if (r109 != null) goto L13;
            int r110 = 0;
        L14:
            int r111 = (r108 + r110) * 31;
            RichText r112 = this.f406870e;
            if (r112 != null) goto L17;
            int r113 = 0;
        L18:
            int r114 = (r111 + r113) * 31;
            String r115 = this.f406871f;
            if (r115 == null) goto L22;
            r103 = r115.hashCode();
        L22:
            int r116 = (((((r114 + r103) * 31) + this.f406872g.hashCode()) * 31) + this.f406873h.hashCode()) * 31;
            long r117 = this.f406874i;
            int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
            long r119 = this.f406875j;
            int r120 = (((r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31) + this.f406876k.hashCode()) * 31;
            long r121 = this.f406877l;
            int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
            long r123 = this.f406878m;
            int r124 = (r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31;
            long r125 = this.f406879n;
            int r126 = (r124 + ((int) (r125 ^ (r125 >>> 32)))) * 31;
            if (this.f406880o == false) goto L25;
            int r127 = 1231;
        L27:
            return r126 + r127;
        L25:
            r127 = 1237;
            goto L27
        L17:
            r113 = r112.hashCode();
            goto L18
        L13:
            r110 = r109.hashCode();
            goto L14
        L9:
            r107 = r106.hashCode();
            goto L10
        L5:
            r104 = r102.hashCode();
            goto L6
        }

        public final String toString() {
            return "NoteBindingSnapshot(identity=" + this.f406866a + ", noteSource=" + this.f406867b + ", inputRichText=" + this.f406868c + ", inputMarkdown=" + this.f406869d + ", aiRichText=" + this.f406870e + ", aiMarkdown=" + this.f406871f + ", galleryImages=" + this.f406872g + ", noteType=" + this.f406873h + ", version=" + this.f406874i + ", clientTime=" + this.f406875j + ", contentState=" + this.f406876k + ", createRelMeetingTime=" + this.f406877l + ", createRelAudioTime=" + this.f406878m + ", audioLocationTime=" + this.f406879n + ", shouldAnimateFinishToUseOnce=" + this.f406880o + ')';
        }

        public c(long r100, AINoteCreateSource r101, RichText r110, String r111, RichText r112, String r113, List<xra.b> r114, AINoteType r115, long r116, long r117, AINoteContentState r210, long r211, long r212, long r213, boolean r214) {
            Intrinsics.checkNotNullParameter(r114, "galleryImages");
            Intrinsics.checkNotNullParameter(r115, "noteType");
            Intrinsics.checkNotNullParameter(r210, "contentState");
            this.f406866a = r100;
            this.f406867b = r101;
            this.f406868c = r110;
            this.f406869d = r111;
            this.f406870e = r112;
            this.f406871f = r113;
            this.f406872g = r114;
            this.f406873h = r115;
            this.f406874i = r116;
            this.f406875j = r117;
            this.f406876k = r210;
            this.f406877l = r211;
            this.f406878m = r212;
            this.f406879n = r213;
            this.f406880o = r214;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int f406881e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f406882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f406883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f406884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f406885d;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f406882a == r101.f406882a) goto L12;
            return false;
        L12:
            if (this.f406883b == r101.f406883b) goto L15;
            return false;
        L15:
            if (this.f406884c == r101.f406884c) goto L18;
            return false;
        L18:
            if (this.f406885d == r101.f406885d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f406882a * 31;
            int r101 = 1231;
            if (this.f406883b == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f406884c == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            if (this.f406885d == true) goto L15;
            r101 = 1237;
        L15:
            return r105 + r101;
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "PositionBindingSnapshot(position=" + this.f406882a + ", isFirst=" + this.f406883b + ", isLast=" + this.f406884c + ", isOnly=" + this.f406885d + ')';
        }

        public d(int r100, boolean r101, boolean r102, boolean r103) {
            this.f406882a = r100;
            this.f406883b = r101;
            this.f406884c = r102;
            this.f406885d = r103;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteAdapter f406886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f406887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AINoteViewHolder f406888c;

        public e(AINoteAdapter r100, long r101, AINoteViewHolder r102) {
            this.f406886a = r100;
            this.f406887b = r101;
            this.f406888c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Long r100 = this.f406886a.f406856q;     // Catch: Throwable -> L11
            long r101 = this.f406887b;     // Catch: Throwable -> L11
            if (r100 != null) goto L6;
            return;
        L6:
            if (r100.longValue() == r101) goto L8;
            return;
        L8:
            if (this.f406888c.f407053a.f() == true) goto L19;
            this.f406888c.f407053a.k(this.f406886a.f406857r);     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f406852m).size() + (this.f406853n ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        if (getItemViewType(r100) == 1) goto L6;
        return Long.MIN_VALUE;
    L6:
        return ((xra.a) ListProtector.get(this.f406852m, r100)).f564896a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 >= ((ArrayList) this.f406852m).size()) goto L5;
        return 1;
    L5:
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewAttachedToWindow(r100);
        if ((r100 instanceof AINoteViewHolder) == true) goto L5;
        return;
    L5:
        AINoteViewHolder r101 = (AINoteViewHolder) r100;
        int r102 = r101.getBindingAdapterPosition();
        if (r102 != (-1)) goto L9;
        return;
    L9:
        if (getItemViewType(r102) == 1) goto L11;
        return;
    L11:
        xra.a r103 = (xra.a) CollectionsKt.getOrNull(this.f406852m, r102);
        if (r103 != null) goto L14;
        return;
    L14:
        A2(r101, r103.f564896a, LynxViewpagerItem.BIND_ON_ATTACH);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewRecycled(r100);
        if ((r100 instanceof AINoteViewHolder) == false) goto L5;
        AINoteViewHolder r101 = (AINoteViewHolder) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        r101.f407053a.setOnActivated(null);
        r101.f407053a.setOnBlur(null);
        r101.f407053a.setOnInputChanged(null);
        r101.f407053a.setOnImageDelete(null);
        r101.f407053a.setOnImageRetry(null);
        r101.f407053a.setOnImageClick(null);
        r101.f407053a.setOnGalleryBlankClick(null);
        r101.f407053a.setOnDeleteNote(null);
        r101.f407053a.setOnLongClickMenuRequest(null);
        r101.f407053a.b();
        r101.f407053a.f406931f.o();
        r101.f407053a.setHighlighted(false);
        r101.f407053a.setOnAiPolishDisplayed(null);
        r101.f407053a.setOnFinishToUseAnimationConsumed(null);
        return;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v68 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r310, int r311) {
        Intrinsics.checkNotNullParameter(r310, "holder");
        int r100 = getItemViewType(r311);
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L367;
        b r101 = (b) r310;
        TextView r102 = r101.f406863a;
        if (this.f406859t == false) goto L9;
        int r103 = 0;
    L10:
        r102.setVisibility(r103);
        View r104 = r101.f406864b;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.height = this.f406861v;
        r104.setLayoutParams(r105);
        com.ss.android.ainote.b r106 = com.ss.android.ainote.b.f406680a;
        r106.d(r101.itemView);
        r106.d(r101.f406864b);
        r106.d(r101.f406863a);
        r101.itemView.setOnClickListener(new com.ss.android.ainote.list.a(this));
        r101.f406864b.setOnClickListener(new com.ss.android.ainote.list.b(this));
        r101.f406863a.setOnClickListener(new com.ss.android.ainote.list.c(this));
        goto L367
    L9:
        r103 = 8;
    L367:
        return;
    L12:
        final AINoteViewHolder r107 = (AINoteViewHolder) r310;
        final xra.a r108 = (xra.a) ListProtector.get(this.f406852m, r311);
        y2(r107.itemView, r108, r311);
        final long r110 = r108.f564896a;
        com.ss.android.ainote.b r109 = com.ss.android.ainote.b.f406680a;
        AINoteItemView r111 = r107.f407053a;
        String r112 = r108.f564904i.name();
        String r113 = r108.f564908m.name();
        int r114 = r108.f564903h.size();
        boolean r115 = com.ss.android.ainote.list.d.c(r108);
        Intrinsics.checkNotNullParameter(r112, "noteType");
        Intrinsics.checkNotNullParameter(r113, "contentState");
        com.ss.android.ainote.b.b(r111, "vc-personal-notes-note-item", "Personal Notes Note Item", "Tap to edit or long press to open note actions", "vc-personal-notes-note-item", com.ss.android.ainote.b.f(r110, Integer.valueOf(r311), r112, r113, r114, r115));
        r107.f407053a.setOnActivated(new AINoteAdapter$bindNote$1(this, r110));
        r107.f407053a.setOnBlur(new AINoteAdapter$bindNote$2(this));
        r107.f407053a.setOnInputChanged(new AINoteAdapter$bindNote$3(this));
        r107.f407053a.setOnImageDelete(new AINoteAdapter$bindNote$4(this));
        r107.f407053a.setOnImageRetry(new AINoteAdapter$bindNote$5(this));
        r107.f407053a.setOnImageClick(new AINoteAdapter$bindNote$6(this));
        r107.f407053a.setOnGalleryBlankClick(new AINoteAdapter$bindNote$7(this));
        r107.f407053a.setOnDeleteNote(new AINoteAdapter$bindNote$8(this));
        r107.f407053a.setOnLongClickMenuRequest(new AINoteAdapter$bindNote$9(this));
        r107.f407053a.setOnEditClickIntercept(new AINoteAdapter$bindNote$10(r107));
        r107.f407053a.setOnAiPolishDisplayed(new AINoteAdapter$bindNote$11(this));
        r107.f407053a.setOnFinishToUseAnimationConsumed(new AINoteAdapter$bindNote$12(this));
        AINoteItemView r116 = r107.f407053a;
        Long r117 = this.f406858s;
        if (r117 != null) goto L16;
    L18:
        boolean r118 = false;
    L19:
        r116.setHighlighted(r118);
        if (r311 == 0) goto L22;
    L24:
        boolean r119 = false;
    L25:
        final AINoteItemView r120 = r107.f407053a;
        r0 r121 = this.f406854o;
        AINoteScene r122 = this.f406855p;
        boolean r123 = this.f406862w;
        r120.getClass();
        Intrinsics.checkNotNullParameter(r108, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r122, "scene");
        r120.setVisibility(0);
        long r124 = r120.f406946u;
        int r125 = r120.d().length();
        if (r124 > 0) goto L28;
    L30:
        boolean r126 = false;
    L31:
        int r127 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteItemView", "bind item, holder=" + System.identityHashCode(r120) + ", oldNoteId=" + r124 + ", newNoteId=" + r108.f564896a + ", isFocused=" + r120.f406931f.isFocused() + ", hasFocus=" + r120.f406931f.hasFocus() + ", currentEditorTextLength=" + r125 + ", itemInputLength=" + r108.d().length() + ", galleryCount=" + r108.f564903h.size());
        if (r126 == false) goto L35;
        long r128 = r120.f406946u;
        r120.f406946u = 0;
        r120.H = false;
        r120.I = false;
        r120.c();
        r120.f406925J = false;
        r120.f406932g.d();
        r120.f406947v = true;
        r120.f406931f.o();
        r120.f406931f.m();
        r120.f406947v = false;
        com.ss.android.ainote.t.d("AINoteItemView", "bind reset reused holder, holder=" + System.identityHashCode(r120) + ", oldNoteId=" + r128);
    L35:
        long r129 = r108.f564896a;
        r120.f406946u = r129;
        VCAINoteEditText r130 = r120.f406931f;
        String r131 = r108.f564904i.name();
        String r132 = r108.f564908m.name();
        int r210 = r108.f564903h.size();
        boolean r312 = com.ss.android.ainote.list.d.c(r108);
        Intrinsics.checkNotNullParameter(r131, "noteType");
        Intrinsics.checkNotNullParameter(r132, "contentState");
        com.ss.android.ainote.b.b(r130, "vc-personal-notes-note-editor", "Personal Notes Note Editor", "Edit personal note text", "vc-personal-notes-note-item", com.ss.android.ainote.b.f(r129, null, r131, r132, r210, r312));
        r120.f406931f.setDelegate(r121);
        Long r133 = Long.valueOf(r108.f564906k);
        if (r133.longValue() <= 0) goto L38;
        boolean r134 = true;
    L39:
        RichText r211 = null;
        if (r134 == true) goto L43;
        r133 = null;
    L43:
        if (r133 == null) goto L45;
        long r135 = r133.longValue();
    L46:
        long r136 = r135;
        Long r137 = Long.valueOf(r108.f564911p);
        if (r137.longValue() <= 0) goto L49;
        boolean r138 = true;
    L50:
        if (r138 == true) goto L53;
        r137 = null;
    L53:
        if (r137 == null) goto L55;
        long r212 = r137.longValue();
    L56:
        Long r139 = Long.valueOf(r108.f564912q);
        if (r139.longValue() <= 0) goto L59;
        boolean r140 = true;
    L60:
        if (r140 == true) goto L63;
        r139 = null;
    L63:
        if (r139 == null) goto L65;
        long r141 = r139.longValue();
    L66:
        TextView r142 = r120.f406928c;
        long r143 = RangesKt.coerceAtLeast(r141, 0) / 1000;
        long r313 = r143 / TimeUtils.SECONDS_PER_HOUR;
        long r213 = (r143 % TimeUtils.SECONDS_PER_HOUR) / 60;
        long r144 = r143 % 60;
        if (r313 <= 0) goto L69;
        StringCompanionObject r145 = StringCompanionObject.INSTANCE;
        String r146 = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r313), Long.valueOf(r213), Long.valueOf(r144)}, 3));
    L70:
        r142.setText(r146);
        r120.f406928c.setOnClickListener(new m(r120, r108, r121, r136, r212, r141, r122));
        r120.f406933h.a(r108.f564903h);
        boolean r147 = com.ss.android.ainote.list.d.c(r108);
        if (r147 == false) goto L73;
    L75:
        boolean r148 = false;
    L76:
        boolean r149 = com.ss.android.ainote.list.d.e(r108);
        Intrinsics.checkNotNullParameter(r108, "note");
        if (com.ss.android.ainote.list.d.e(r108) == false) goto L80;
    L89:
        boolean r150 = false;
    L90:
        boolean r151 = com.ss.android.ainote.list.d.g(r108, r148);
        if (r123 == false) goto L94;
        String r152 = r120.getContext().getString(R.string.View_PersonalNotes_RecordIdeasAIComplete_Placeholder);
    L97:
        Intrinsics.checkNotNull(r152);
        if (r151 == false) goto L100;
        r152 = r120.i(r108);
    L104:
        Context r153 = r120.getContext();
        int r154 = com.ss.android.ainote.util.a.f407220a;
        Intrinsics.checkNotNullParameter(r153, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r155 = ContextCompat.getColor(r153, R.color.text_title);
        Context r156 = r120.getContext();
        Intrinsics.checkNotNullParameter(r156, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r157 = ContextCompat.getColor(r156, R.color.text_placeholder);
        if ((r120.getResources().getConfiguration().uiMode & 48) != 32) goto L107;
        boolean r158 = true;
    L108:
        if (r158 == false) goto L110;
        int r159 = ColorProtector.parseColor("#757575");
    L111:
        boolean r160 = com.ss.android.ainote.list.d.h(r108);
        r120.f406931f.setHint(r152);
        VCAINoteEditText r161 = r120.f406931f;
        if (r160 == false) goto L114;
        r155 = r159;
    L114:
        r161.setTextColor(r155);
        VCAINoteEditText r162 = r120.f406931f;
        if (r160 == false) goto L117;
        r157 = r159;
    L117:
        r162.setHintTextColor(r157);
        r120.f406949x = r150;
        boolean r163 = !r150;
        r120.f406931f.setEditInteractionEnabled(r163);
        r120.f406931f.setAutoEnterEditOnNonLinkClick(r163);
        Intrinsics.checkNotNullParameter(r108, "note");
        if (com.ss.android.ainote.list.d.g(r108, r148) == false) goto L120;
        String r164 = r120.i(r108);
    L121:
        if (r164 == null) goto L123;
        RichText r165 = AINoteRichTextAdapter.h(AINoteRichTextAdapter.b(r164));
    L124:
        String r166 = com.ss.android.ainote.list.d.a(r108);
        Intrinsics.checkNotNullParameter(r108, "note");
        AINoteContentState r167 = r108.f564908m;
        AINoteContentState r168 = AINoteContentState.USE;
        String r169 = "";
        if (r167 != r168) goto L133;
        String r170 = r108.a();
        if (StringsKt.isBlank(r170) == false) goto L137;
        if (com.ss.android.ainote.list.d.f(r108) == true) goto L134;
        r170 = r108.d();
    L134:
        r170 = "";
    L137:
        if (r108.f564908m != r168) goto L141;
        boolean r171 = true;
        if ((!StringsKt.isBlank(r166)) == false) goto L142;
        RichText r172 = AINoteRichTextAdapter.a(r166);
    L143:
        if (r172 != null) goto L155;
        if (r165 == null) goto L146;
        r172 = r165;
        goto L155
    L146:
        if ((StringsKt.isBlank(r170) ^ r171) == true) goto L149;
        r170 = null;
    L149:
        if (r170 == null) goto L151;
        r172 = AINoteItemView.j(r170);
    L152:
        if (r172 != null) goto L155;
        r172 = new RichText();
        goto L155
    L151:
        r172 = null;
    L155:
        String r173 = r108.f564902g;
        if (r173 != null) goto L158;
    L165:
        RichText r174 = r108.f564901f;
        if (r174 != null) goto L168;
        RichText r175 = r172;
    L169:
        String r176 = r108.f564902g;
        if (r176 != null) goto L172;
    L175:
        boolean r177 = true;
    L176:
        boolean r178 = !r177;
        String r179 = r108.f564900e;
        if (r179 != null) goto L179;
        r179 = "";
    L179:
        String r180 = r108.f564902g;
        if (r180 == null) goto L183;
        r169 = r180;
    L183:
        boolean r181 = Intrinsics.areEqual(r179, r169);
        boolean r182 = !StringsKt.isBlank(r120.d());
        if (r149 == false) goto L186;
    L192:
        boolean r183 = false;
    L194:
        if (r108.f564904i.isMark() == false) goto L200;
        if (r149 == false) goto L197;
    L199:
        boolean r184 = false;
    L202:
        if (com.ss.android.ainote.list.d.h(r108) == false) goto L206;
        boolean r314 = r183;
        if (r120.f406931f.isFocused() == true) goto L207;
        boolean r185 = true;
    L208:
        if (r149 == false) goto L210;
    L219:
        boolean r186 = r185;
    L220:
        boolean r187 = false;
    L221:
        boolean r188 = r120.f406931f.isFocused();
        Intrinsics.checkNotNullParameter(r108, "note");
        boolean r189 = !r108.f564904i.isMark();
        boolean r190 = r187;
        if (r108.f564908m != r168) goto L224;
        boolean r191 = true;
    L225:
        boolean r192 = r108.f564918w;
        final RichText r214 = r175;
        boolean r193 = !r188;
        if (r184 == false) goto L234;
        if (r189 == false) goto L234;
        if (r191 == false) goto L234;
        if (r192 == false) goto L234;
        if (r178 == false) goto L234;
        if (r182 == false) goto L234;
        if (r193 == false) goto L234;
        boolean r194 = true;
    L235:
        com.ss.android.ainote.t.d("AINoteDisplayPolicy", "shouldAnimatePolishReplace, noteId=" + r108.c() + ", version=" + r108.f564905j + ", noteType=" + r108.f564904i + ", state=" + r108.f564908m + ", liveRewritingEnabled=" + r184 + ", notMark=" + r189 + ", isUseState=" + r191 + ", shouldAnimateFinishToUseOnce=" + r192 + ", hasAiText=" + r178 + ", currentEditorHasText=" + r182 + ", isFocused=" + r188 + ", notFocused=" + r193 + ", result=" + r194);
        r120.f406951z = r108.f564908m;
        r120.A = r108.f564904i;
        r120.B = r184;
        r120.C = r108.d().length();
        String r195 = r108.f564900e;
        if (r195 == null) goto L238;
        int r196 = r195.length();
    L239:
        r120.D = r196;
        String r197 = r108.f564902g;
        if (r197 == null) goto L242;
        int r198 = r197.length();
    L243:
        r120.E = r198;
        r120.F = r108.f564903h.size();
        r120.G = r147;
        if ((!r108.f564903h.isEmpty()) == true) goto L246;
    L248:
        boolean r199 = false;
    L249:
        r120.f406950y = r199;
        if (r120.I == false) goto L258;
        AINoteType r200 = r108.f564904i;
        AINoteContentState r201 = r108.f564908m;
        AINoteListView r202 = r120.e();
        boolean r215 = r184;
        if (r202 == null) goto L254;
        String r315 = r202.B(r108.c());
    L255:
        boolean r316 = r215;
        String r203 = ", currentEditorHasText=";
        boolean r204 = r314;
        boolean r317 = r178;
        boolean r1100 = r186;
        boolean r1101 = r147;
        boolean r216 = r1100;
        boolean r1102 = r182;
        if (r120.l(r200, r201, r316, r182, r315) == false) goto L259;
        boolean r205 = true;
    L261:
        if (r120.I == false) goto L264;
        if (r205 == true) goto L264;
        r120.I = false;
    L264:
        StringBuilder r206 = new StringBuilder("bind polish animation, noteId=");
        r206.append(r108.c());
        r206.append(", version=");
        r206.append(r108.f564905j);
        r206.append(", noteType=");
        r206.append(r108.f564904i);
        r206.append(", state=");
        r206.append(r108.f564908m);
        r206.append(", inputLen=");
        r206.append(r108.d().length());
        r206.append(", aiMarkdownLen=");
        String r1103 = r108.f564902g;
        if (r1103 == null) goto L267;
        int r1104 = r1103.length();
    L268:
        r206.append(r1104);
        r206.append(", hasAiMarkdown=");
        String r1105 = r108.f564902g;
        if (r1105 != null) goto L271;
    L274:
        boolean r1106 = true;
    L275:
        r206.append(!r1106);
        r206.append(", sameMarkdown=");
        r206.append(r181);
        r206.append(r203);
        r206.append(r1102);
        r206.append(", isFocused=");
        r206.append(r120.f406931f.isFocused());
        r206.append(", hasMarkPlaceholder=");
        r206.append(r204);
        r206.append(", liveRewritingEnabled=");
        r206.append(r316);
        r206.append(", shouldAnimateFinishToUseOnce=");
        r206.append(r108.f564918w);
        r206.append(", shouldAnimate=");
        r206.append(r194);
        r206.append(", shouldShowMarkContinuousShine=");
        boolean r207 = r216;
        r206.append(r207);
        r206.append(", shouldPlayPendingPrePolishBlurShine=");
        r206.append(r205);
        r206.append(", shouldAckFinishedPolishingMark=");
        r206.append(r190);
        com.ss.android.ainote.t.d("AINoteItemView", r206.toString());
        StringBuilder r208 = new StringBuilder("bind text region, noteId=");
        r208.append(r108.c());
        r208.append(", state=");
        r208.append(r108.f564908m);
        r208.append(", galleryCount=");
        r208.append(r108.f564903h.size());
        r208.append(", hasDisplayedContent=");
        r208.append(r1101);
        r208.append(", hideTextRegionWhenIdle=");
        r208.append(r120.f406950y);
        r208.append(", inputMarkdownLen=");
        String r1107 = r108.f564900e;
        if (r1107 == null) goto L278;
        int r1108 = r1107.length();
    L279:
        r208.append(r1108);
        r208.append(", aiMarkdownLen=");
        String r209 = r108.f564902g;
        if (r209 == null) goto L282;
        int r217 = r209.length();
    L283:
        r208.append(r217);
        com.ss.android.ainote.t.d("AINoteItemView", r208.toString());
        if (r120.f406931f.isFocused() == false) goto L286;
        if (r126 == true) goto L286;
    L294:
        ?? r218 = 0;
    L295:
        if (r205 == false) goto L297;
        r120.I = r218;
        r120.f406930e.setVisibility(r218);
        r120.f406932g.e(r120.f406931f.getCurrentTextColor(), new AINoteItemView$bind$1(r120, r108));
    L361:
        if (r190 == false) goto L365;
        Function2<? super Long, ? super Long, Unit> r219 = r120.f406944s;
        if (r219 == null) goto L365;
        r219.invoke(Long.valueOf(r120.f406946u), Long.valueOf(r108.f564905j));
        Unit r220 = Unit.INSTANCE;
    L365:
        A2(r107, r110, "bind");
        return;
    L297:
        if (r207 == false) goto L315;
        r120.f406930e.setVisibility(r218);
        AINoteShineOverlayView r221 = r120.f406932g;
        int r222 = r120.f406931f.getCurrentTextColor();
        if (r221.f407040n == r222) goto L301;
    L303:
        r221.f407040n = r222;
        r221.f();
    L305:
        if (r221.f407038l == 2000) goto L307;
    L312:
        boolean r223 = true;
    L313:
        r221.f407031e = true;
        r221.f407033g = true;
        r221.f407038l = 2000;
        r221.f407039m = -r221.f407036j;
        r221.invalidate();
        r221.setVisibility(0);
        r221.g(r223);
        goto L361
    L307:
        if (r221.f407032f == false) goto L312;
        if (r221.f407034h == false) goto L312;
        r223 = false;
        goto L313
    L301:
        if (r221.f407029c == null) goto L303;
    L315:
        if (r108.f564918w == false) goto L321;
        if (r1102 == true) goto L321;
        com.ss.android.ainote.t.d("AINoteItemView", "consume finishToUse animation without play, noteId=" + r108.c() + ", version=" + r108.f564905j + r203 + r1102 + ", galleryCount=" + r108.f564903h.size() + ", state=" + r108.f564908m);
        r108.f564918w = false;
        Function2<? super Long, ? super Long, Unit> r224 = r120.f406945t;
        if (r224 == null) goto L320;
        r224.invoke(Long.valueOf(r108.c()), Long.valueOf(r108.f564905j));
        Unit r225 = Unit.INSTANCE;
    L320:
        r120.f406932g.d();
        r120.n();
    L321:
        if (r194 == false) goto L353;
        r108.f564918w = false;
        Function2<? super Long, ? super Long, Unit> r226 = r120.f406945t;
        if (r226 == null) goto L325;
        r226.invoke(Long.valueOf(r108.c()), Long.valueOf(r108.f564905j));
        Unit r227 = Unit.INSTANCE;
    L325:
        AINoteType r228 = r108.f564904i;
        if (r228 != AINoteType.SUBTITLE) goto L328;
    L341:
        if (r165 != 0) goto L343;
        RichText r229 = AINoteItemView.j(r120.i(r108));
    L345:
        if (Intrinsics.areEqual(r120.f406931f.w(), r229) == true) goto L351;
        r120.f406947v = true;
        r120.f406931f.setDraftRichText(r229);
        VCAINoteEditText r230 = r120.f406931f;
        Editable r231 = r230.getText();
        if (r231 == null) goto L349;
        int r232 = r231.length();
    L350:
        r230.setSelection(r232);
        int r233 = 0;
        r120.f406947v = false;
        r120.H = false;
    L352:
        r120.f406930e.setVisibility(r233);
        r120.f406932g.e(r120.f406931f.getCurrentTextColor(), new AINoteItemView$bind$2(r120, r108, r214));
        goto L361
    L349:
        r232 = 0;
        goto L350
    L351:
        r233 = 0;
        goto L352
    L343:
        r229 = r165;
        goto L345
    L328:
        if (r228.isMark() == true) goto L330;
    L332:
        RichText r234 = r108.f564899d;
        if (r234 != null) goto L340;
        String r235 = r108.f564900e;
        if (r235 == null) goto L337;
        r211 = AINoteRichTextAdapter.a(r235);
    L337:
        if (r211 != null) goto L339;
        r234 = AINoteItemView.j(r108.d());
        goto L340
    L339:
        r229 = r211;
    L340:
        r229 = r234;
        goto L345
    L330:
        if (StringsKt.isBlank(r108.d()) == false) goto L332;
    L353:
        r120.f406932g.d();
        r120.n();
        if (r108.f564908m != AINoteContentState.FINISH) goto L361;
        if (r317 == false) goto L361;
        if (r120.f406931f.isFocused() == true) goto L361;
        Function2<? super Long, ? super Long, Unit> r236 = r120.f406944s;
        if (r236 == null) goto L361;
        r236.invoke(Long.valueOf(r120.f406946u), Long.valueOf(r108.f564905j));
        Unit r237 = Unit.INSTANCE;
    L286:
        if (r194 == true) goto L294;
        RichText r238 = r172;
        if (Intrinsics.areEqual(r120.f406931f.w(), r238) == true) goto L294;
        r120.f406947v = true;
        r120.f406931f.setDraftRichText(r238);
        VCAINoteEditText r239 = r120.f406931f;
        Editable r240 = r239.getText();
        if (r240 == null) goto L292;
        int r241 = r240.length();
    L293:
        r239.setSelection(r241);
        r218 = 0;
        r120.f406947v = false;
        r120.H = false;
        goto L295
    L292:
        r241 = 0;
        goto L293
    L282:
        r217 = 0;
        goto L283
    L278:
        r1108 = 0;
        goto L279
    L271:
        if (StringsKt.isBlank(r1105) == true) goto L274;
        r1106 = false;
        goto L275
    L267:
        r1104 = 0;
    L259:
        r205 = false;
        goto L261
    L254:
        r315 = null;
        goto L255
    L258:
        r316 = r184;
        r203 = ", currentEditorHasText=";
        r216 = r186;
        r1101 = r147;
        r204 = r314;
        r317 = r178;
        r1102 = r182;
        goto L259
    L246:
        if (com.ss.android.ainote.list.d.c(r108) == true) goto L248;
        r199 = true;
        goto L249
    L242:
        r198 = 0;
        goto L243
    L238:
        r196 = 0;
    L234:
        r194 = false;
        goto L235
    L224:
        r191 = false;
        goto L225
    L210:
        if (r108.f564904i.isMark() == false) goto L219;
        if (r108.f564904i.needsPolish() == false) goto L219;
        r186 = r185;
        if (r108.f564908m != AINoteContentState.FINISH) goto L220;
        if (r178 == false) goto L220;
        if (r120.f406931f.isFocused() == true) goto L220;
        r187 = true;
    L207:
        r185 = false;
        goto L208
    L206:
        r314 = r183;
        goto L207
    L197:
        if (r108.f564904i.needsPolish() == false) goto L199;
        r184 = true;
        goto L202
    L200:
        r184 = r123;
        goto L202
    L186:
        if (r108.f564904i.isMark() == false) goto L192;
        if (r108.f564904i.needsPolish() == false) goto L192;
        if ((!StringsKt.isBlank(r120.i(r108))) == false) goto L192;
        r183 = true;
        goto L194
    L172:
        if (StringsKt.isBlank(r176) == true) goto L175;
        r177 = false;
    L168:
        r175 = r174;
        goto L169
    L158:
        if ((!StringsKt.isBlank(r173)) == true) goto L161;
        r173 = null;
    L161:
        if (r173 == null) goto L165;
        r174 = AINoteRichTextAdapter.a(r173);
        if (r174 == null) goto L165;
    L142:
        r172 = com.ss.android.ainote.list.d.b(r108);
        goto L143
    L141:
        r171 = true;
        goto L142
    L133:
        if (com.ss.android.ainote.list.d.f(r108) == true) goto L134;
        r170 = r108.d();
        goto L137
    L123:
        r165 = null;
        goto L124
    L120:
        r164 = null;
        goto L121
    L110:
        r159 = ColorProtector.parseColor("#8F959E");
        goto L111
    L107:
        r158 = false;
        goto L108
    L100:
        if (r119 == false) goto L103;
        if (r147 == false) goto L104;
    L103:
        r152 = r120.getContext().getString(R.string.View_PersonalNotes_RecordNewContent_Placeholder);
        goto L104
    L94:
        if (r122 != AINoteScene.Meeting) goto L96;
        r152 = r120.getContext().getString(R.string.View_PersonalNotes_EnterSaveKeyMeetingPointsAIComplete_Placeholder);
        goto L97
    L96:
        r152 = r120.getContext().getString(R.string.View_PersonalNotes_RecordIdeasGenerateDoc_Placeholder);
        goto L97
    L80:
        if (r108.f564904i.isMark() == false) goto L89;
        if (r108.f564904i.needsPolish() == false) goto L89;
        AINoteContentState r242 = r108.f564908m;
        if (r242 != AINoteContentState.NEED) goto L87;
    L88:
        r150 = true;
        goto L90
    L87:
        if (r242 != AINoteContentState.FINISH) goto L89;
    L73:
        if (r108.f564903h.isEmpty() == false) goto L75;
        r148 = true;
        goto L76
    L69:
        StringCompanionObject r243 = StringCompanionObject.INSTANCE;
        r146 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r213), Long.valueOf(r144)}, 2));
        goto L70
    L65:
        r141 = r212;
        goto L66
    L59:
        r140 = false;
        goto L60
    L55:
        r212 = r136;
        goto L56
    L49:
        r138 = false;
        goto L50
    L45:
        r135 = System.currentTimeMillis();
        goto L46
    L38:
        r134 = false;
        goto L39
    L28:
        if (r124 == r108.f564896a) goto L30;
        r126 = true;
        goto L31
    L22:
        if (((ArrayList) this.f406852m).size() != 1) goto L24;
        r119 = true;
        goto L25
    L16:
        if (r117.longValue() != r110) goto L18;
        r118 = true;
        goto L19
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r102 = 0;
        if (r101 != 1) goto L5;
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ai_note_list_item, r100, false);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r104 = (ViewGroup) r103;
        AINoteItemView r105 = new AINoteItemView(r100.getContext(), null, 6, r102);
        r104.addView(r105);
        return new AINoteViewHolder(r104, r105);
    L5:
        if (r101 != 2) goto L8;
        View r106 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ai_note_create_footer_item, r100, false);
        Intrinsics.checkNotNull(r106);
        return new b(r106);
    L8:
        throw new IllegalStateException(("unknown viewType=" + r101).toString());
    }

    public final void z2(List<xra.a> r210, boolean r211) {
        long r100 = SystemClock.elapsedRealtime();
        List<xra.a> r101 = this.f406852m;
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator r103 = ((ArrayList) r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Object r104 = r103.next();
        r102.put(Long.valueOf(((xra.a) r104).f564896a), r104);
        goto L4
    L6:
        HashSet r105 = new HashSet(r210.size() * 2);
        ArrayList r106 = new ArrayList(r210.size());
        int r107 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteAdapter", "mergeItemsFromSession, oldCount=" + ((ArrayList) this.f406852m).size() + ", newCount=" + r210.size() + ", editingNoteId=" + this.f406860u + ", notifyChanged=" + r211);
        Iterator<xra.a> r108 = r210.iterator();
    L8:
        if (r108.hasNext() == false) goto L59;
        xra.a r110 = r108.next();
        long r111 = r110.f564896a;
        if (r105.add(Long.valueOf(r111)) == false) goto L11;
        xra.a r112 = (xra.a) r102.get(Long.valueOf(r111));
        if (r112 == null) goto L57;
        int r113 = r112.d().length();
        int r114 = r110.d().length();
        boolean r115 = true;
        HashSet r116 = r105;
        if (r113 <= 0) goto L34;
        if (r114 != 0) goto L34;
        Iterator<xra.a> r117 = r108;
        String r109 = r110.f564900e;
        if (r109 != null) goto L20;
    L23:
        boolean r118 = true;
    L24:
        if (r118 == false) goto L35;
        int r119 = com.ss.android.ainote.t.f407207a;
        StringBuilder r120 = new StringBuilder("incoming empty input may overwrite, id=");
        r120.append(r111);
        r120.append(", oldLen=");
        r120.append(r113);
        r120.append(", editing=");
        Long r121 = this.f406860u;
        if (r121 != null) goto L29;
    L31:
        boolean r122 = false;
    L32:
        r120.append(r122);
        com.ss.android.ainote.t.e("AINoteAdapter", r120.toString());
        goto L35
    L29:
        if (r121.longValue() != r111) goto L31;
        r122 = true;
    L35:
        Long r123 = this.f406860u;
        if (r123 != null) goto L39;
    L56:
        r112.e(r110);
        r106.add(r112);
    L58:
        r108 = r117;
        r105 = r116;
        r100 = r100;
        goto L8
    L39:
        if (r123.longValue() != r111) goto L56;
        Intrinsics.checkNotNullParameter(r110, "other");
        if (r110.f564896a != r112.f564896a) goto L55;
        int r124 = r112.d().length();
        int r125 = r110.d().length();
        if (r124 <= 0) goto L54;
        if (r125 != 0) goto L54;
        String r126 = r110.f564900e;
        if (r126 != null) goto L49;
    L52:
        if (r115 == false) goto L54;
        int r127 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteBlockModel", "preserveInput keeps local input, cid=" + r112.f564896a + ", oldLen=" + r124 + ", incomingLen=" + r125 + ", incomingVersion=" + r110.f564905j);
        goto L54
    L49:
        if (StringsKt.isBlank(r126) == true) goto L52;
        r115 = false;
    L54:
        r112.f564897b = r110.f564897b;
        r112.f564898c = r110.f564898c;
        r112.f564901f = r110.f564901f;
        r112.f564902g = r110.f564902g;
        r112.f564903h = r110.f564903h;
        r112.f564904i = r110.f564904i;
        r112.f564905j = r110.f564905j;
        r112.f564906k = r110.f564906k;
        r112.f564907l = r110.f564907l;
        r112.f564908m = r110.f564908m;
        r112.f564909n = r110.f564909n;
        r112.f564910o = r110.f564910o;
        r112.f564911p = r110.f564911p;
        r112.f564912q = r110.f564912q;
        r112.f564913r = r110.f564913r;
        r112.f564914s = r110.f564914s;
        r112.f564915t = r110.f564915t;
        r112.f564916u = r110.f564916u;
        r112.f564917v = r110.f564917v;
        r112.f564918w = r110.f564918w;
    L55:
        r106.add(r112);
        goto L58
    L20:
        if (StringsKt.isBlank(r109) == true) goto L23;
        r118 = false;
    L34:
        r117 = r108;
        goto L35
    L57:
        r100 = r100;
        r116 = r105;
        r117 = r108;
        r106.add(r110);
        goto L58
    L11:
        int r128 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.e("AINoteAdapter", "duplicate note dropped, stableUiId=" + r111);
        goto L8
    L59:
        long r212 = r100;
        ((ArrayList) this.f406852m).clear();
        ((ArrayList) this.f406852m).addAll(r106);
        if (r211 == false) goto L62;
        notifyDataSetChanged();
    L62:
        int r129 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteAdapter", "[timing][mergeItemsFromSession], oldCount=" + r102.size() + ", newCount=" + r210.size() + ", mergedCount=" + r106.size() + ", notifyChanged=" + r211 + " costMs=" + (SystemClock.elapsedRealtime() - r212));
    }

    public final void A2(AINoteViewHolder r100, long r101, String r102) {
        Long r103 = this.f406856q;
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.longValue() == r101) goto L8;
        return;
    L8:
        if (r100.f407053a.f() == true) goto L14;
        int r104 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteAdapter", "request desired focus on " + r102 + ", noteId=" + r101);
        r100.f407053a.post(new e(this, r101, r100));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        boolean r103 = true;
        if ((!r102.isEmpty()) == true) goto L5;
    L29:
        onBindViewHolder(r100, r101);
        return;
    L5:
        if ((r100 instanceof AINoteViewHolder) == false) goto L29;
        if (getItemViewType(r101) != 1) goto L29;
        List<Object> r104 = r102;
        if ((r104 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r105 = r104.iterator();
    L15:
        if (r105.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(r105.next(), "images_only") == false) goto L15;
        boolean r106 = true;
    L19:
        if (r106 == false) goto L29;
        xra.a r107 = (xra.a) ListProtector.get(this.f406852m, r101);
        y2(r100.itemView, r107, r101);
        AINoteViewHolder r108 = (AINoteViewHolder) r100;
        AINoteItemView r109 = r108.f407053a;
        List<xra.b> r110 = r107.f564903h;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "images");
        r109.f406933h.a(r110);
        AINoteItemView r111 = r108.f407053a;
        Long r112 = this.f406858s;
        long r113 = r107.f564896a;
        if (r112 != null) goto L24;
    L26:
        r103 = false;
    L27:
        r111.setHighlighted(r103);
        return;
    L24:
        if (r112.longValue() != r113) goto L26;
    L12:
        r106 = false;
        goto L19
    L11:
        if (r104.isEmpty() == false) goto L13;
        goto L12
    }

    public final void y2(View r100, xra.a r101, int r102) {
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L6:
        if (r104 == null) goto L20;
        int r105 = 0;
        if (r102 != 0) goto L10;
        int r106 = com.ss.android.ainote.util.a.b(r100.getContext(), 16);
    L11:
        r104.topMargin = r106;
        if (r102 != CollectionsKt.getLastIndex(this.f406852m)) goto L15;
    L18:
        r104.bottomMargin = r105;
        r100.setLayoutParams(r104);
        return;
    L15:
        if ((!r101.f564903h.isEmpty()) == false) goto L17;
        r105 = com.ss.android.ainote.util.a.b(r100.getContext(), 12);
        goto L18
    L17:
        r105 = com.ss.android.ainote.util.a.b(r100.getContext(), 20);
        goto L18
    L10:
        r106 = 0;
        goto L11
    L20:
        return;
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AINoteAdapter(Function1<? super Long, Unit> r100, Function2<? super Long, ? super String, Unit> r101, Function2<? super Long, ? super String, Unit> r102, Function2<? super Long, ? super String, Unit> r103, Function2<? super Long, ? super String, Unit> r104, Function2<? super Long, ? super xra.b, Unit> r105, Function1<? super Long, Unit> r106, Function2<? super Long, ? super String, Unit> r107, Function1<? super Long, Unit> r110, Function2<? super Long, ? super Long, Unit> r111, Function2<? super Long, ? super Long, Unit> r112, Function0<Unit> r113) {
        Intrinsics.checkNotNullParameter(r100, "onItemActivated");
        Intrinsics.checkNotNullParameter(r101, "onItemBlur");
        Intrinsics.checkNotNullParameter(r102, "onItemInputChanged");
        Intrinsics.checkNotNullParameter(r103, "onItemImageDelete");
        Intrinsics.checkNotNullParameter(r104, "onItemImageRetry");
        Intrinsics.checkNotNullParameter(r105, "onItemImageClick");
        Intrinsics.checkNotNullParameter(r106, "onItemGalleryBlankClick");
        Intrinsics.checkNotNullParameter(r107, "onItemDelete");
        Intrinsics.checkNotNullParameter(r110, "onItemLongClickMenuRequest");
        Intrinsics.checkNotNullParameter(r111, "onItemAiPolishDisplayed");
        Intrinsics.checkNotNullParameter(r112, "onItemFinishToUseAnimationConsumed");
        Intrinsics.checkNotNullParameter(r113, "onFooterClick");
        this.f406840a = r100;
        this.f406841b = r101;
        this.f406842c = r102;
        this.f406843d = r103;
        this.f406844e = r104;
        this.f406845f = r105;
        this.f406846g = r106;
        this.f406847h = r107;
        this.f406848i = r110;
        this.f406849j = r111;
        this.f406850k = r112;
        this.f406851l = r113;
        this.f406852m = new ArrayList();
        this.f406853n = true;
        this.f406855p = AINoteScene.UNKNOWN;
        this.f406857r = AINoteEditEnterSource.USER;
        this.f406859t = true;
        this.f406862w = true;
        setHasStableIds(true);
    }
}
