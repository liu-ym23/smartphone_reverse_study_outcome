package com.ss.android.ainote.list;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ainote.AINoteEditEnterSource;
import com.ss.android.ainote.AINoteRichTextAdapter;
import com.ss.android.ainote.VCAINoteEditText;
import com.ss.android.ainote.model.AINoteContentState;
import com.ss.android.ainote.model.AINoteType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u009e\u00012\u00020\u0001:\u0002\u009e\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ4\u0010^\u001a\u00020\u00192\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020d2\b\b\u0002\u0010e\u001a\u00020@2\b\b\u0002\u0010f\u001a\u00020@J\u0010\u0010g\u001a\u00020!2\u0006\u0010_\u001a\u00020`H\u0002J\u0014\u0010h\u001a\u00020\u00192\f\u0010i\u001a\b\u0012\u0004\u0012\u0002000jJ\u0006\u0010k\u001a\u00020\u0019J\u0006\u0010l\u001a\u00020!J\u0006\u0010m\u001a\u00020nJ\u0006\u0010o\u001a\u00020@J\u0017\u0010p\u001a\u00020\u00192\b\b\u0002\u0010q\u001a\u00020rH\u0000¢\u0006\u0002\bsJ\u001f\u0010t\u001a\u00020\u00192\u0006\u0010u\u001a\u00020\u00072\b\b\u0002\u0010q\u001a\u00020rH\u0000¢\u0006\u0002\bvJ\u0006\u0010w\u001a\u00020\u0019J\u0006\u0010x\u001a\u00020\u0019J\u000e\u0010y\u001a\u00020\u00192\u0006\u0010z\u001a\u00020@J\u0006\u0010{\u001a\u00020\u0019J\u0006\u0010|\u001a\u00020\u0019J\u0006\u0010}\u001a\u00020@J\u0006\u0010~\u001a\u00020@J\b\u0010\u007f\u001a\u00020\u0019H\u0002J\u0011\u0010\u0080\u0001\u001a\u00020n2\u0006\u0010_\u001a\u00020`H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020n2\u0007\u0010\u0082\u0001\u001a\u00020!H\u0002J\t\u0010\u0083\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0084\u0001\u001a\u00020!H\u0002J\t\u0010\u0085\u0001\u001a\u00020\u0019H\u0002J\u0012\u0010\u0086\u0001\u001a\u00020@2\u0007\u0010\u0087\u0001\u001a\u00020!H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020!2\u0007\u0010\u0082\u0001\u001a\u00020!H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020\u00192\u0007\u0010\u008a\u0001\u001a\u00020!H\u0002J\t\u0010\u008b\u0001\u001a\u00020\u0019H\u0002J;\u0010\u008c\u0001\u001a\u00020@2\u0007\u0010\u008d\u0001\u001a\u00020Q2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010O2\u0006\u0010f\u001a\u00020@2\u0007\u0010\u008f\u0001\u001a\u00020@2\u000b\b\u0002\u0010\u0090\u0001\u001a\u0004\u0018\u00010!H\u0002J\t\u0010\u0091\u0001\u001a\u00020@H\u0002J\u0010\u0010\u0092\u0001\u001a\u00020\u00192\u0007\u0010\u0093\u0001\u001a\u00020@J\u0007\u0010\u0094\u0001\u001a\u00020\u0019J\u0007\u0010\u0095\u0001\u001a\u00020\u0012J\t\u0010\u0096\u0001\u001a\u00020\u0019H\u0002J#\u0010\u0097\u0001\u001a\u00020\u00192\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020dH\u0002J\f\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0002J\u0012\u0010\u009a\u0001\u001a\u00020!2\u0007\u0010\u009b\u0001\u001a\u00020 H\u0002J\r\u0010\u009c\u0001\u001a\u00020@*\u00020`H\u0002J\r\u0010\u009d\u0001\u001a\u00020@*\u00020`H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR.\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010&\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R.\u0010)\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R.\u0010,\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R.\u0010/\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R(\u00103\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0019\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R.\u00109\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R(\u0010<\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0019\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00106\"\u0004\b>\u00108R\"\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001dR.\u0010C\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010#\"\u0004\bE\u0010%R.\u0010F\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010#\"\u0004\bH\u0010%R\u000e\u0010I\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009f\u0001"}, d2 = {"Lcom/ss/android/ainote/list/AINoteItemView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", KtvSubElement.CONTAINER, "Landroid/widget/LinearLayout;", "timeContainer", "timeView", "Landroid/widget/TextView;", "contentContainer", "textStack", "editText", "Lcom/ss/android/ainote/VCAINoteEditText;", "shineOverlayView", "Lcom/ss/android/ainote/list/AINoteShineOverlayView;", "galleryView", "Lcom/ss/android/ainote/list/AINoteGalleryView;", "onActivated", "Lkotlin/Function0;", "", "getOnActivated", "()Lkotlin/jvm/functions/Function0;", "setOnActivated", "(Lkotlin/jvm/functions/Function0;)V", "onBlur", "Lkotlin/Function2;", "", "", "getOnBlur", "()Lkotlin/jvm/functions/Function2;", "setOnBlur", "(Lkotlin/jvm/functions/Function2;)V", "onInputChanged", "getOnInputChanged", "setOnInputChanged", "onImageDelete", "getOnImageDelete", "setOnImageDelete", "onImageRetry", "getOnImageRetry", "setOnImageRetry", "onImageClick", "Lcom/ss/android/ainote/model/AINoteGalleryImage;", "getOnImageClick", "setOnImageClick", "onGalleryBlankClick", "Lkotlin/Function1;", "getOnGalleryBlankClick", "()Lkotlin/jvm/functions/Function1;", "setOnGalleryBlankClick", "(Lkotlin/jvm/functions/Function1;)V", "onDeleteNote", "getOnDeleteNote", "setOnDeleteNote", "onLongClickMenuRequest", "getOnLongClickMenuRequest", "setOnLongClickMenuRequest", "onEditClickIntercept", "", "getOnEditClickIntercept", "setOnEditClickIntercept", "onAiPolishDisplayed", "getOnAiPolishDisplayed", "setOnAiPolishDisplayed", "onFinishToUseAnimationConsumed", "getOnFinishToUseAnimationConsumed", "setOnFinishToUseAnimationConsumed", "noteId", "suppressInputChanged", "ignoreNextClickAfterLongPress", "editBlockedByAiPolish", "hideTextRegionWhenIdle", "lastBoundContentState", "Lcom/ss/android/ainote/model/AINoteContentState;", "lastBoundNoteType", "Lcom/ss/android/ainote/model/AINoteType;", "lastBoundLiveRewritingEnabled", "lastBoundInputLength", "lastBoundInputMarkdownLength", "lastBoundAiMarkdownLength", "lastBoundGalleryCount", "lastBoundHasDisplayedContent", "hasUserEditedSinceBind", "pendingPrePolishBlurShine", "longPressHighlighted", "restoreHighlighted", "clearRestoreHighlightRunnable", "Ljava/lang/Runnable;", "bind", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/ainote/model/AINoteBlockModel;", "delegate", "Lcom/ss/android/ainote/IAINoteDelegate;", "scene", "Lcom/ss/android/ainote/model/AINoteScene;", "useEmptyListHint", "liveRewritingEnabled", "markPolishPlaceholderText", "updateGalleryImages", "images", "", "insertTimeMark", "exportInputContent", "exportInputRichText", "Lcom/ss/android/lark/widget/richtext/RichText;", "shouldFlushInputSnapshot", "requestEditMode", "source", "Lcom/ss/android/ainote/AINoteEditEnterSource;", "requestEditMode$ai_note_release", "requestEditModeAt", "offset", "requestEditModeAt$ai_note_release", "clearEditMode", "prepareForRemoval", "setHighlighted", "highlighted", "showRestoreHighlight", "clearRestoreHighlight", "hasEditFocus", "isEditBlocked", "showEditorForEditing", "resolveInputRichText", "plainTextToRichText", "text", "resolveMarkShineTextColor", "trimTrailingWhitespaceOnBlur", "updateIdleTextRegionVisibility", "hasSemanticCurrentText", "currentInputText", "normalizeEditorContent", "queuePrePolishBlurShineIfNeeded", "blurredContent", "playPendingPrePolishBlurShineIfNeeded", "shouldShowPrePolishBlurShine", "noteType", "contentState", "hasCurrentText", "blurReason", "canOpenLongClickMenu", "setSuppressSelectionActionMode", "enabled", "clearSelectionUi", "getEditorView", "updateContentBackground", "bindHeader", "findParentListView", "Lcom/ss/android/ainote/list/AINoteListView;", "formatDuration", "durationMs", "hasDisplayText", "shouldHideTextRegion", "Companion", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AINoteItemView extends FrameLayout {
    public static final Regex M = null;
    public static final Regex N = null;
    public AINoteType A;
    public boolean B;
    public int C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f406925J;
    public boolean K;
    public final e L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f406926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f406927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f406928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f406929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f406930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VCAINoteEditText f406931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AINoteShineOverlayView f406932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AINoteGalleryView f406933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f406934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function2<? super Long, ? super String, Unit> f406935j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function2<? super Long, ? super String, Unit> f406936k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function2<? super Long, ? super String, Unit> f406937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function2<? super Long, ? super String, Unit> f406938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function2<? super Long, ? super xra.b, Unit> f406939n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super Long, Unit> f406940o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function2<? super Long, ? super String, Unit> f406941p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function1<? super Long, Unit> f406942q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function0<Boolean> f406943r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function2<? super Long, ? super Long, Unit> f406944s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function2<? super Long, ? super Long, Unit> f406945t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f406946u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f406947v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f406948w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f406949x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f406950y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AINoteContentState f406951z;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteItemView f406952a;

        public a(AINoteItemView r100) {
            this.f406952a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            int r101 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.a("AINoteItemView", "container click, noteId=" + this.f406952a.f406946u + ", ignoreNextClickAfterLongPress=" + this.f406952a.f406948w + ", hasEditFocus=" + this.f406952a.f() + ", blocked=" + this.f406952a.h());
            AINoteItemView r102 = this.f406952a;
            boolean r103 = false;
            if (r102.f406948w == false) goto L6;
            r102.f406948w = false;
            return;
        L6:
            Function0<Boolean> r104 = r102.getOnEditClickIntercept();
            if (r104 != null) goto L9;
        L11:
            if (r103 == false) goto L15;
            com.ss.android.ainote.t.a("AINoteItemView", "container click intercepted, noteId=" + this.f406952a.f406946u);
            return;
        L15:
            if (this.f406952a.f() == false) goto L18;
            com.ss.android.ainote.t.a("AINoteItemView", "container click ignored, noteId=" + this.f406952a.f406946u + ", already editing");
            return;
        L18:
            this.f406952a.k(AINoteEditEnterSource.USER);
            return;
        L9:
            if (r104.invoke().booleanValue() != true) goto L11;
            r103 = true;
            goto L11
        }
    }

    public static final class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteItemView f406953a;

        public b(AINoteItemView r100) {
            this.f406953a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            int r101 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.a("AINoteItemView", "container longClick, noteId=" + this.f406953a.f406946u + ", canOpenLongClickMenu=" + AINoteItemView.a(this.f406953a) + ", hasEditFocus=" + this.f406953a.f() + ", blocked=" + this.f406953a.h());
            if (AINoteItemView.a(this.f406953a) == false) goto L7;
            AINoteItemView r102 = this.f406953a;
            r102.f406948w = true;
            Function1<Long, Unit> r103 = r102.getOnLongClickMenuRequest();
            if (r103 == null) goto L9;
            r103.invoke(Long.valueOf(this.f406953a.f406946u));
            return true;
        L9:
            return true;
        L7:
            return false;
        }
    }

    public static final class c implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteItemView f406954a;

        public c(AINoteItemView r100) {
            this.f406954a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r110, boolean r111) {
            int r112 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.a("AINoteItemView", "editText focusChange, noteId=" + this.f406954a.f406946u + ", hasFocus=" + r111 + ", inLongPressSelectionMode=" + this.f406954a.f406931f.f406660q + ", blocked=" + this.f406954a.h() + ", inputLength=" + this.f406954a.d().length());
            if (r111 == false) goto L10;
            this.f406954a.c();
            if (this.f406954a.f406931f.f406660q == false) goto L7;
            com.ss.android.ainote.t.a("AINoteItemView", "selection focus gained, noteId=" + this.f406954a.f406946u + ", inputLength=" + this.f406954a.d().length());
            return;
        L7:
            com.ss.android.ainote.t.a("AINoteItemView", "focus gained, noteId=" + this.f406954a.f406946u + ", inputLength=" + this.f406954a.d().length());
            Function0<Unit> r113 = this.f406954a.getOnActivated();
            if (r113 == null) goto L35;
            r113.invoke();
            return;
        L35:
            return;
        L10:
            AINoteItemView r114 = this.f406954a;
            if (r114.f406946u <= 0) goto L37;
            VCAINoteEditText r115 = r114.f406931f;
            if (r115.f406660q == false) goto L15;
            com.ss.android.ainote.t.a("AINoteItemView", "selection focus lost, noteId=" + this.f406954a.f406946u + ", inputLength=" + this.f406954a.d().length());
            this.f406954a.f406931f.o();
            return;
        L15:
            Editable r116 = r115.getEditableText();
            if (r116 != null) goto L18;
            String r117 = r114.d();
        L22:
            AINoteItemView r118 = this.f406954a;
            AINoteType r100 = r118.A;
            AINoteContentState r101 = r118.f406951z;
            boolean r102 = r118.B;
            boolean r103 = AINoteItemView.g(r117);
            AINoteListView r104 = r118.e();
            if (r104 == null) goto L25;
            String r105 = r104.B(r118.f406946u);
        L26:
            boolean r106 = r118.l(r100, r101, r102, r103, r105);
            r118.I = r106;
            if (r106 == false) goto L30;
            r118.post(new n(r118));
        L30:
            this.f406954a.n();
            com.ss.android.ainote.t.a("AINoteItemView", "focus lost, noteId=" + this.f406954a.f406946u + ", inputLength=" + r117.length() + ", pendingPrePolishBlurShine=" + this.f406954a.I);
            Function2<Long, String, Unit> r119 = this.f406954a.getOnBlur();
            if (r119 == null) goto L39;
            r119.invoke(Long.valueOf(this.f406954a.f406946u), r117);
            return;
        L39:
            return;
        L25:
            r105 = null;
            goto L26
        L18:
            r117 = r116.toString();
            String r107 = AINoteItemView.M.replace(r117, "");
            if (Intrinsics.areEqual(r107, r117) == true) goto L22;
            r116.delete(r107.length(), r116.length());
            r117 = r107;
            goto L22
        }
    }

    public static final class d {
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteItemView f406955a;

        public e(AINoteItemView r100) {
            this.f406955a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AINoteItemView r100 = this.f406955a;     // Catch: Throwable -> L4
            r100.K = false;     // Catch: Throwable -> L4
            r100.m();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteItemView f406956a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public f(AINoteItemView r100) {
            this.f406956a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            AINoteItemView r101 = this.f406956a;
            if (r101.f406947v == false) goto L5;
            return;
        L5:
            if (r101.f406946u <= 0) goto L17;
            r101.H = true;
            Function2<Long, String, Unit> r102 = r101.getOnInputChanged();
            if (r102 == null) goto L18;
            Long r103 = Long.valueOf(this.f406956a.f406946u);
            if (r100 == null) goto L11;
            String r104 = r100.toString();
        L12:
            if (r104 != null) goto L14;
            r104 = "";
        L14:
            r102.invoke(r103, r104);
            return;
        L11:
            r104 = null;
            goto L12
        L18:
            return;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteItemView f406957a;

        public g(AINoteItemView r100) {
            this.f406957a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f406957a.f406931f.isFocused() == false) goto L9;
            AINoteListView r101 = this.f406957a.e();
            if (r101 == null) goto L7;
            String r102 = "time_container_self:" + this.f406957a.f406946u;
            Intrinsics.checkNotNullParameter(r102, "reason");
            r101.l(r102);
            return;
        L7:
            this.f406957a.b();
            return;
        L9:
            AINoteListView r103 = this.f406957a.e();
            if (r103 == null) goto L12;
            Long r104 = r103.getEditingNoteId();
        L13:
            if (r104 == null) goto L17;
            String r105 = "time_container_other:" + this.f406957a.f406946u;
            r103.getClass();
            Intrinsics.checkNotNullParameter(r105, "reason");
            r103.l(r105);
            return;
        L17:
            return;
        L12:
            r104 = null;
            goto L13
        }
    }

    public AINoteItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AINoteItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        M = new Regex("[\\t\\n\\r ]+$");
        N = new Regex("[\\t\\n\\r \\u00A0\\u200B\\u200C\\u200D\\u2060\\uFEFF\\uFFFC]+");
    }

    public final void b() {
        int r100 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.a("AINoteItemView", "clearEditMode, noteId=" + this.f406946u + ", hasEditFocus=" + f() + ", inSelectionMode=" + this.f406931f.f406660q);
        this.f406931f.m();
        n();
    }

    public final void c() {
        removeCallbacks(this.L);
        if (this.K == true) goto L5;
        return;
    L5:
        this.K = false;
        m();
    }

    public final String d() {
        Editable r100 = this.f406931f.getText();
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean f() {
        if (this.f406931f.isFocused() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f406931f.f406660q == true) goto L7;
        return true;
    }

    public final boolean h() {
        if (this.f406949x == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f406931f.f406658o == false) goto L8;
        return false;
    }

    public final void m() {
        if (this.f406925J == false) goto L6;
        this.f406929d.setBackgroundResource(R.drawable.ai_note_item_longpress_bg);
        return;
    L6:
        if (this.K == false) goto L8;
        this.f406929d.setBackgroundResource(R.drawable.ai_note_item_restore_bg);
        return;
    L8:
        this.f406929d.setBackground(null);
    }

    public final AINoteListView e() {
        Object r100 = getParent();
    L4:
        if (r100 == null) goto L16;
        if ((r100 instanceof AINoteListView) == true) goto L8;
        if ((r100 instanceof View) == false) goto L12;
        View r101 = (View) r100;
    L13:
        if (r101 == null) goto L14;
        r100 = r101.getParent();
        goto L4
    L14:
        return null;
    L12:
        r101 = null;
        goto L13
    L8:
        return (AINoteListView) r100;
    L16:
        return null;
    }

    public final void n() {
        String r100 = d();
        boolean r101 = g(r100);
        AINoteListView r102 = e();
        if (r102 == null) goto L5;
        String r103 = r102.B(this.f406946u);
    L6:
        int r104 = 0;
        if (this.F > 0) goto L10;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == true) goto L19;
    L21:
        int r106 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteItemView", "updateIdleTextRegionVisibility, noteId=" + this.f406946u + ", state=" + this.f406951z + ", hideTextRegionWhenIdle=" + this.f406950y + ", shouldHideWhenIdle=" + r105 + ", blurReason=" + r103 + ", isFocused=" + this.f406931f.isFocused() + ", hasCurrentText=" + r101 + ", currentInputLen=" + r100.length() + ", boundHasDisplayedContent=" + this.G + ", boundInputLen=" + this.C + ", boundInputMarkdownLen=" + this.D + ", boundAiMarkdownLen=" + this.E + ", boundGalleryCount=" + this.F + ", targetVisibility=" + r104);
        this.f406930e.setVisibility(r104);
        return;
    L19:
        if (this.f406931f.isFocused() == true) goto L21;
        r104 = 8;
        goto L21
    L10:
        if (Intrinsics.areEqual(r103, "remote_override_higher_version") == true) goto L12;
        if (r101 == true) goto L16;
    L15:
        r105 = true;
        goto L17
    L12:
        if (this.G == true) goto L16;
    L5:
        r103 = null;
        goto L6
    }

    public final VCAINoteEditText getEditorView() {
        return this.f406931f;
    }

    public final Function0<Unit> getOnActivated() {
        return this.f406934i;
    }

    public final Function2<Long, Long, Unit> getOnAiPolishDisplayed() {
        return this.f406944s;
    }

    public final Function2<Long, String, Unit> getOnBlur() {
        return this.f406935j;
    }

    public final Function2<Long, String, Unit> getOnDeleteNote() {
        return this.f406941p;
    }

    public final Function0<Boolean> getOnEditClickIntercept() {
        return this.f406943r;
    }

    public final Function2<Long, Long, Unit> getOnFinishToUseAnimationConsumed() {
        return this.f406945t;
    }

    public final Function1<Long, Unit> getOnGalleryBlankClick() {
        return this.f406940o;
    }

    public final Function2<Long, xra.b, Unit> getOnImageClick() {
        return this.f406939n;
    }

    public final Function2<Long, String, Unit> getOnImageDelete() {
        return this.f406937l;
    }

    public final Function2<Long, String, Unit> getOnImageRetry() {
        return this.f406938m;
    }

    public final Function2<Long, String, Unit> getOnInputChanged() {
        return this.f406936k;
    }

    public final Function1<Long, Unit> getOnLongClickMenuRequest() {
        return this.f406942q;
    }

    public static final boolean a(AINoteItemView r100) {
        if (r100.f406946u > 0) goto L5;
    L11:
        return false;
    L5:
        if (r100.f() == true) goto L11;
        if (r100.h() == true) goto L14;
        return true;
    L14:
        return r100.f406949x;
    }

    public static boolean g(String r100) {
        if (N.replace(r100, "").length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static RichText j(String r100) {
        RichText r101 = AINoteRichTextAdapter.h(AINoteRichTextAdapter.b(r100));
        if (r101 == null) goto L5;
        return r101;
    L5:
        return new RichText();
    }

    public final String i(xra.a r100) {
        if (r100.f564904i == AINoteType.SUBTITLE) goto L7;
        return getContext().getString(R.string.View_PersonalNotes_HighlightSavedAIRefining_Text);
    L7:
        return getContext().getString(R.string.View_PersonalNotes_MarkedTranscriptAISummarizing_Text);
    }

    public final void k(AINoteEditEnterSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        int r101 = 0;
        this.f406948w = false;
        Function0<Boolean> r102 = this.f406943r;
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.invoke().booleanValue() != true) goto L7;
    L9:
        if (r103 == false) goto L12;
        int r104 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.a("AINoteItemView", "requestEditMode intercepted, noteId=" + this.f406946u);
        return;
    L12:
        c();
        this.f406932g.d();
        this.f406930e.setVisibility(0);
        int r105 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.a("AINoteItemView", "requestEditMode, noteId=" + this.f406946u + ", source=" + r100 + ", blocked=" + h() + ", editInteractionEnabled=" + this.f406931f.f406658o + ", hasEditFocus=" + f() + ", inSelectionMode=" + this.f406931f.f406660q);
        VCAINoteEditText r106 = this.f406931f;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r100, "source");
        Editable r107 = r106.getText();
        if (r107 == null) goto L15;
        r101 = r107.length();
    L15:
        r106.D(r101, r100);
        return;
    L7:
        r103 = false;
        goto L9
    }

    public final void setHighlighted(boolean r100) {
        this.f406925J = r100;
        m();
    }

    public final void setOnActivated(Function0<Unit> r100) {
        this.f406934i = r100;
    }

    public final void setOnAiPolishDisplayed(Function2<? super Long, ? super Long, Unit> r100) {
        this.f406944s = r100;
    }

    public final void setOnBlur(Function2<? super Long, ? super String, Unit> r100) {
        this.f406935j = r100;
    }

    public final void setOnDeleteNote(Function2<? super Long, ? super String, Unit> r100) {
        this.f406941p = r100;
    }

    public final void setOnEditClickIntercept(Function0<Boolean> r100) {
        this.f406943r = r100;
    }

    public final void setOnFinishToUseAnimationConsumed(Function2<? super Long, ? super Long, Unit> r100) {
        this.f406945t = r100;
    }

    public final void setOnGalleryBlankClick(Function1<? super Long, Unit> r100) {
        this.f406940o = r100;
    }

    public final void setOnImageClick(Function2<? super Long, ? super xra.b, Unit> r100) {
        this.f406939n = r100;
    }

    public final void setOnImageDelete(Function2<? super Long, ? super String, Unit> r100) {
        this.f406937l = r100;
    }

    public final void setOnImageRetry(Function2<? super Long, ? super String, Unit> r100) {
        this.f406938m = r100;
    }

    public final void setOnInputChanged(Function2<? super Long, ? super String, Unit> r100) {
        this.f406936k = r100;
    }

    public final void setOnLongClickMenuRequest(Function1<? super Long, Unit> r100) {
        this.f406942q = r100;
    }

    public final void setSuppressSelectionActionMode(boolean r100) {
        this.f406931f.setSuppressSelectionActionMode(r100);
    }

    public AINoteItemView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LinearLayout r113 = new LinearLayout(r110);
        r113.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r113.setOrientation(1);
        int r100 = 0;
        r113.setFocusable(false);
        r113.setFocusableInTouchMode(false);
        r113.setPadding(com.ss.android.ainote.util.a.b(r110, 12), 0, com.ss.android.ainote.util.a.b(r110, 12), 0);
        this.f406926a = r113;
        FrameLayout r114 = new FrameLayout(r110);
        r114.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r114.setFocusable(false);
        r114.setFocusableInTouchMode(false);
        r114.setMinimumHeight(com.ss.android.ainote.util.a.b(r110, 22));
        r114.setPadding(com.ss.android.ainote.util.a.b(r110, 8), 0, 0, 0);
        r114.setOnClickListener(new g(this));
        this.f406927b = r114;
        TextView r115 = new TextView(r110);
        r115.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r115.setTextSize(14.0f);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        r115.setTextColor(ContextCompat.getColor(r110, R.color.function_info_600));
        r115.setPadding(0, 0, com.ss.android.ainote.util.a.b(r110, 8), 0);
        this.f406928c = r115;
        LinearLayout r116 = new LinearLayout(r110);
        r116.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r116.setOrientation(1);
        r116.setFocusable(false);
        r116.setFocusableInTouchMode(false);
        r116.setPadding(com.ss.android.ainote.util.a.b(r110, 8), 0, com.ss.android.ainote.util.a.b(r110, 8), 0);
        this.f406929d = r116;
        FrameLayout r117 = new FrameLayout(r110);
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-1, -2);
        r101.topMargin = com.ss.android.ainote.util.a.b(r110, 4);
        r101.bottomMargin = com.ss.android.ainote.util.a.b(r110, 4);
        r117.setLayoutParams(r101);
        this.f406930e = r117;
        AttributeSet r102 = null;
        int r103 = 6;
        VCAINoteEditText r118 = new VCAINoteEditText(r110, r102, r103, r100);
        r118.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r118.setHint(r110.getString(R.string.View_PersonalNotes_RecordNewContent_Placeholder));
        r118.setTextSize(16.0f);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        r118.setTextColor(ContextCompat.getColor(r110, R.color.text_title));
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        r118.setHintTextColor(ContextCompat.getColor(r110, R.color.text_placeholder));
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r118, "textView");
        Drawable r104 = AppCompatResources.getDrawable(r110, R.drawable.ai_note_text_cursor_drawable);
        if (r104 == null) goto L17;
        Drawable r105 = r104.mutate();
        if (r105 == null) goto L17;
        int r106 = Build.VERSION.SDK_INT;
        if (r106 <= 28) goto L20;
        r118.setTextCursorDrawable(r105);
        r118.invalidate();
        goto L17
    L20:
        Field r119 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L19
        r119.setAccessible(true);     // Catch: Throwable -> L19
        Object r120 = r119.get(r118);     // Catch: Throwable -> L19
        if (r120 == null) goto L17;
        if (r106 < 28) goto L15;
        Field r107 = r120.getClass().getDeclaredField("mDrawableForCursor");     // Catch: Throwable -> L19
    L16:
        r107.setAccessible(true);     // Catch: Throwable -> L19
        r107.set(r120, new Drawable[]{r105, r105});     // Catch: Throwable -> L19
        r118.invalidate();     // Catch: Throwable -> L19
        goto L17
    L15:
        r107 = r120.getClass().getDeclaredField("mCursorDrawable");     // Catch: Throwable -> L19
    L17:
        r118.setLinkClickPriorityEnabled(true);
        r118.setAutoEnterEditOnNonLinkClick(true);
        this.f406931f = r118;
        AINoteShineOverlayView r108 = new AINoteShineOverlayView(r110, r102, r103, r100);
        r108.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r108.setVisibility(8);
        this.f406932g = r108;
        AINoteGalleryView r109 = new AINoteGalleryView(r110, null, 6, 0);
        r109.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r109.setPadding(0, com.ss.android.ainote.util.a.b(r110, 8), 0, com.ss.android.ainote.util.a.b(r110, 8));
        r109.setVisibility(8);
        this.f406933h = r109;
        this.A = AINoteType.REGULAR;
        this.B = true;
        this.L = new e(this);
        Intrinsics.checkNotNullParameter(r118, "textView");
        r108.f407041o = r118;
        this.f406927b.addView(this.f406928c);
        this.f406926a.addView(this.f406927b);
        this.f406930e.addView(r118);
        this.f406930e.addView(r108);
        this.f406929d.addView(this.f406930e);
        this.f406929d.addView(r109);
        this.f406926a.addView(this.f406929d);
        addView(this.f406926a);
        this.f406926a.setOnClickListener(new a(this));
        this.f406926a.setOnLongClickListener(new b(this));
        r118.setNonEditingLongClickListener(new AnonymousClass3(this));
        r118.setOnFocusChangeListener(new c(this));
        r118.addTextChangedListener(new f(this));
        r109.setOnImageDelete(new AnonymousClass6(this));
        r109.setOnImageRetry(new AnonymousClass7(this));
        r109.setOnBlankClick(new AnonymousClass8(this));
        r109.setCanHandleLongPress(new AnonymousClass9(this));
        r109.setOnImageLongClick(new AnonymousClass10(this));
        r109.setOnBlankLongClick(new AnonymousClass11(this));
        r109.setOnImageClick(new AnonymousClass12(this));
    }

    public /* synthetic */ AINoteItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final boolean l(AINoteType r100, AINoteContentState r101, boolean r102, boolean r103, String r104) {
        if (Intrinsics.areEqual(r104, "remote_override_higher_version") == false) goto L5;
        return false;
    L5:
        if (r103 == true) goto L7;
        return false;
    L7:
        if (this.f406931f.isFocused() == false) goto L10;
        return false;
    L10:
        if (r100 != AINoteType.REGULAR) goto L18;
        if (r102 == true) goto L14;
        return false;
    L14:
        if (r101 != AINoteContentState.NEED) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    }
}
