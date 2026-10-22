package com.ss.android.lark.widget.richtext.codeblockv2;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Annotation;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.IActionTitlebar$Action;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.codeblock.theme.CodeBlockV2ThemeManager;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.select.m;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005*\u0002\u0016\u001c\u0018\u0000 \\2\u00020\u0001:\u0002\\]B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0014J\b\u0010<\u001a\u000209H\u0002J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002J\u0010\u0010?\u001a\u0002092\u0006\u0010@\u001a\u000206H\u0002J\u0010\u0010A\u001a\u0002092\u0006\u0010@\u001a\u000206H\u0002J\b\u0010B\u001a\u000209H\u0002J\u0018\u0010C\u001a\u0002092\u0006\u0010D\u001a\u0002062\u0006\u0010E\u001a\u000206H\u0002J\b\u0010F\u001a\u000209H\u0002J\b\u0010G\u001a\u000209H\u0002J\u0010\u0010H\u001a\u0002092\u0006\u0010I\u001a\u00020*H\u0002J\u0014\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110KH\u0002J\b\u0010L\u001a\u00020\u0011H\u0002J\b\u0010M\u001a\u000206H\u0002J\b\u0010N\u001a\u00020%H\u0002J\b\u0010O\u001a\u000209H\u0002J\u0012\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010SH\u0002J\b\u0010T\u001a\u00020UH\u0002J\u0018\u0010V\u001a\b\u0012\u0004\u0012\u00020W002\b\u0010X\u001a\u0004\u0018\u00010YH\u0002J\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020W002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\b\u0010Z\u001a\u000209H\u0002J\b\u0010[\u001a\u000209H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001a\u001a\u0004\b&\u0010'R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020705X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/ss/android/lark/widget/richtext/codeblockv2/CodeBlockV2DetailActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "copyToken", "Lcom/bytedance/supervisor/token/Token;", "codeBlockLayout", "Landroid/view/View;", "codeBlockDetailView", "Lcom/ss/android/lark/widget/richtext/codeblockv2/CodeBlockV2DetailView;", "lineNumView", "loadingLayout", "loadingIv", "Landroidx/appcompat/widget/AppCompatImageView;", "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "loadingStatus", "", "errorLayout", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "wordWrapAction", "com/ss/android/lark/widget/richtext/codeblockv2/CodeBlockV2DetailActivity$wordWrapAction$2$1", "getWordWrapAction", "()Lcom/ss/android/lark/widget/richtext/codeblockv2/CodeBlockV2DetailActivity$wordWrapAction$2$1;", "wordWrapAction$delegate", "Lkotlin/Lazy;", "wordWrapFalseAction", "com/ss/android/lark/widget/richtext/codeblockv2/CodeBlockV2DetailActivity$wordWrapFalseAction$2$1", "getWordWrapFalseAction", "()Lcom/ss/android/lark/widget/richtext/codeblockv2/CodeBlockV2DetailActivity$wordWrapFalseAction$2$1;", "wordWrapFalseAction$delegate", "normalMargin", "maxWidthWordWrap", "codeBlockEachLineHeight", "codeStartMargin", "selectCopyWindow", "Landroid/widget/PopupWindow;", "getSelectCopyWindow", "()Landroid/widget/PopupWindow;", "selectCopyWindow$delegate", "currentSelectionInfo", "Lcom/ss/android/lark/widget/select/SelectedTextInfo;", "selectionHelper", "Lcom/ss/android/lark/widget/select/TextSelectHelper;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "lineContents", "", "Lcom/ss/android/lark/widget/codeblock/entity/LineContent;", "codeBlockProcessParams", "Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams;", "processResultMap", "", "", "Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ParserResult;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "readDataFromBundle", "initCommonParams", "fetchWordWrapSetting", "onWordWrapChanged", "wordWrap", "processLineContents", "initView", "handleLoadingVisible", "loadingVisible", "errorVisible", "showTextSelect", "dismissCopyWindow", "handleTextSelect", "info", "getPopupWindowContentSize", "Lkotlin/Pair;", "getSelectionEnd", "selectedIsSameLine", "prepareSelectionWindow", "handleSelectionTextCopy", "encodePbRichText", "", "richText", "Lcom/bytedance/lark/pb/basic/v1/RichText;", "genRichText", "Lcom/ss/android/lark/widget/richtext/RichText;", "genRichTextElements", "Lcom/ss/android/lark/widget/richtext/RichTextElement;", "selectedText", "", "handleSelectionWindowDismiss", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "LoadingStatus", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeBlockV2DetailActivity extends BaseFragmentActivity {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f448258w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Token f448259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f448260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CodeBlockV2DetailView f448261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CodeBlockV2DetailView f448262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f448263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppCompatImageView f448264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDLoadingDrawable f448265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f448266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f448267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CommonTitleBar f448268j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f448269k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f448270l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f448271m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f448272n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f448273o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f448274p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.ss.android.lark.widget.select.g f448275q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public m f448276r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CoroutineScope f448277s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<LineContent> f448278t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CodeBlockV2ProcessParams f448279u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<Boolean, bcc.a> f448280v;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/widget/richtext/codeblockv2/CodeBlockV2DetailActivity$LoadingStatus;", "", "Companion", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LoadingStatus {
        public static final a Companion = null;
        public static final int HIDE = 1;
        public static final int LOADING_DELAY = 2;
        public static final int UNKNOWN = -1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f448281a = null;

            static {
                f448281a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f448281a;
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CodeBlockV2DetailActivity f448282a;

        public b(CodeBlockV2DetailActivity r100) {
            this.f448282a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CodeBlockV2DetailActivity r100 = this.f448282a;     // Catch: Throwable -> L14
            if (r100.f448266h != 2) goto L17;
            UDLoadingDrawable r101 = r100.f448265g;     // Catch: Throwable -> L14
            View r102 = null;
            if (r101 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");     // Catch: Throwable -> L14
            r101 = null;
        L8:
            r101.start();     // Catch: Throwable -> L14
            View r103 = this.f448282a.f448263e;     // Catch: Throwable -> L14
            if (r103 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");     // Catch: Throwable -> L14
        L12:
            r102.setVisibility(0);     // Catch: Throwable -> L14
            return;
        L11:
            r102 = r103;
            goto L12
        L17:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A1() {
        com.ss.android.lark.widget.select.g r100 = this.f448275q;
        if (r100 == null) goto L5;
        CharSequence r101 = r100.f448425a;
    L6:
        boolean r102 = true;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L104;
        SpannableStringBuilder r104 = new SpannableStringBuilder(r101.toString());
        com.ss.android.lark.widget.select.g r105 = this.f448275q;
        if (r105 != null) goto L17;
    L19:
        boolean r106 = false;
    L20:
        if (r106 == false) goto L70;
        List<LineContent> r107 = this.f448278t;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("lineContents");
        r107 = null;
    L24:
        final ArrayList r108 = new ArrayList();
        final StringBuilder r109 = new StringBuilder();
        final Ref.ObjectRef r110 = new Ref.ObjectRef();
        List<LineContent> r111 = r107;
        Iterator<T> r112 = r111.iterator();
    L26:
        if (r112.hasNext() == false) goto L69;
        LineContent r113 = (LineContent) r112.next();
        if (r113.getContents() == null) goto L30;
        boolean r114 = true;
    L31:
        if (r114 == false) goto L26;
        List<LineContent.Content> r115 = r113.getContents();
        if (r115 == null) goto L35;
        T r116 = (LineContent.Content) CollectionsKt.first(r115);
    L36:
        r110.element = r116;
        Iterator<T> r117 = r111.iterator();
        int r118 = 0;
    L38:
        if (r117.hasNext() == false) goto L67;
        Object r119 = r117.next();
        int r120 = r118 + 1;
        if (r118 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        List<LineContent.Content> r121 = ((LineContent) r119).getContents();
        Function1<LineContent.Content, Unit> r122 = new CodeBlockV2DetailActivity$genRichTextElements$2$consumeAction$1(r109, r110, r108);
        if (r121 == null) goto L64;
        Iterator<T> r123 = r121.iterator();
        int r124 = 0;
    L46:
        if (r123.hasNext() == false) goto L64;
        Object r125 = r123.next();
        int r126 = r124 + 1;
        if (r124 >= 0) goto L50;
        CollectionsKt.throwIndexOverflow();
    L50:
        LineContent.Content r127 = (LineContent.Content) r125;
        LineContent.Content r128 = (LineContent.Content) r110.element;
        if (r128 == null) goto L53;
        Map<String, String> r129 = r128.getStyle();
    L55:
        if (Intrinsics.areEqual(r129, r127.getStyle()) == true) goto L57;
        r122.invoke(r127);
    L57:
        r109.append(r127.getOriginText());
        if (r118 != CollectionsKt.getLastIndex(r107)) goto L62;
        if (r124 != CollectionsKt.getLastIndex(r121)) goto L62;
        r122.invoke(r127);
    L62:
        r124 = r126;
        goto L46
    L53:
        r129 = null;
    L64:
        if (r118 >= CollectionsKt.getLastIndex(r107)) goto L66;
        r109.append("\n");
    L66:
        r118 = r120;
        goto L38
    L67:
        r108.add(RichTextElementCreator.d());
        List r130 = r108;
    L83:
        if (r130.isEmpty() == false) goto L85;
    L88:
        RichText r131 = com.ss.android.lark.widget.richtext.c.a();
        Intrinsics.checkNotNull(r131);
    L89:
        com.bytedance.lark.pb.basic.v1.RichText r132 = g0.d(r131);
        if (r132 != null) goto L106;
    L96:
        String r133 = "";
    L97:
        r104.setSpan(new Annotation("com.lartsuite.im.RichTextCopyUtils", r133), 0, r104.length(), 33);
        Object r134 = getSystemService(DataType.CLIPBOARD);
        Intrinsics.checkNotNull(r134, "null cannot be cast to non-null type android.content.ClipboardManager");
        qf7.a.f532746a.a((ClipboardManager) r134, ClipData.newPlainText("", r104), this.f448259a);     // Catch: Exception -> L100 SensitiveAPIException -> L102
        UDToast.show(this, R.string.Lark_Legacy_CopySuccess);     // Catch: Exception -> L100 SensitiveAPIException -> L102
    L102:
        e = move-exception;
        Log.e(this.PARENT_TAG, "copy failed: " + e.getMessage());
        UDToast.show(this, R.string.Lark_IM_CopyContent_CopyingIsForbidden_Toast);
    L100:
        e = move-exception;
        Log.e("CodeBlockV2DetailActivity", e.toString());
        goto L104
    L106:
        byte[] r135 = r132.encode();     // Catch: Exception -> L94
        ByteString.a r136 = ByteString.Companion;     // Catch: Exception -> L94
        Intrinsics.checkNotNull(r135);     // Catch: Exception -> L94
        r133 = ByteString.a.e(r136, r135).base64();     // Catch: Exception -> L94
    L94:
        e = move-exception;
        Log.e("CodeBlockV2DetailActivity", "encodePbRichText: encode error: " + ExceptionsKt.stackTraceToString(e));
        goto L96
    L85:
        if (r130.size() > 6000) goto L88;
        r131 = com.ss.android.lark.widget.richtext.c.b(r130);
        Intrinsics.checkNotNull(r131);
        goto L89
    L35:
        r116 = 0;
        goto L36
    L30:
        r114 = false;
        goto L31
    L69:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L70:
        if (r105 == null) goto L72;
        CharSequence r137 = r105.f448425a;
    L73:
        if (r137 != null) goto L75;
    L78:
        if (r102 == false) goto L80;
        List<RichTextElement> r138 = CollectionsKt.emptyList();
    L81:
        r130 = r138;
        goto L83
    L80:
        r138 = RichTextElementCreator.g(r137, CodeBlockV2DetailActivity$genRichTextElements$1.INSTANCE);
        goto L81
    L75:
        if (r137.length() == 0) goto L78;
        r102 = false;
        goto L78
    L72:
        r137 = null;
        goto L73
    L17:
        if (r105.f448431g == true) goto L19;
        r106 = true;
    L104:
        PopupWindow r139 = (PopupWindow) this.f448274p.getValue();
        PopupWindowLancet.handleDismissBeforeOrigin(r139);
        r139.dismiss();
        return;
    L9:
        if (r101.length() == 0) goto L12;
        r103 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CodeBlockV2DetailActivity.class.getName()));
    L5:
        super.onDestroy();
        ((LinkedHashMap) this.f448280v).clear();
        CodeBlockV2ThemeManager.a();
        TextLayoutBuilder.b();
        CoroutineScopeKt.cancel$default(this.f448277s, null, 1, null);
    }

    public CodeBlockV2DetailActivity() {
        this.f448259a = new Token("LARK-PSDA-messenger-android-copy-codeblockdetail");
        this.f448266h = -1;
        this.f448269k = LazyKt.lazy(new CodeBlockV2DetailActivity$wordWrapAction$2(this));
        this.f448270l = LazyKt.lazy(new CodeBlockV2DetailActivity$wordWrapFalseAction$2(this));
        this.f448274p = LazyKt.lazy(new CodeBlockV2DetailActivity$selectCopyWindow$2(this));
        this.f448277s = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f448280v = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(CodeBlockV2DetailActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public final void B1(boolean r110) {
        CommonTitleBar r100 = this.f448268j;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r100 = null;
    L5:
        r100.removeAllActions();
        if (r110 == false) goto L8;
        IActionTitlebar$Action r101 = (CodeBlockV2DetailActivity$wordWrapFalseAction$2.a) this.f448270l.getValue();
    L9:
        CommonTitleBar r102 = this.f448268j;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r102 = null;
    L12:
        r102.addAction(r101);
        Function1<bcc.a, Unit> r103 = new CodeBlockV2DetailActivity$processLineContents$action$1(this);
        bcc.a r104 = (bcc.a) ((LinkedHashMap) this.f448280v).get(Boolean.valueOf(r110));
        if (r104 == null) goto L15;
        r103.invoke(r104);
        return;
    L15:
        z1(true, false);
        BuildersKt.launch$default(this.f448277s, Dispatchers.getIO(), null, new CodeBlockV2DetailActivity$processLineContents$1$1(this, r110, r103, null), 2, null);
        return;
    L8:
        r101 = (CodeBlockV2DetailActivity$wordWrapAction$2.a) this.f448269k.getValue();
        goto L9
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        Bundle r101 = getIntent().getExtras();
        if (r101 == null) goto L14;
        String r102 = r101.getString("key_code_block_line_contents");
        if (r102 == null) goto L14;
    L15:
        Map<String, List<LineContent>> r103 = h.f448298a;
        if (r102.length() != 0) goto L18;
        boolean r104 = true;
    L19:
        UDLoadingDrawable r105 = null;
        if (r104 == false) goto L22;
        List<LineContent> r106 = null;
    L23:
        List<LineContent> r107 = r106;
        if (r107 != null) goto L26;
    L29:
        boolean r108 = true;
    L30:
        if (r108 == false) goto L32;
        Log.e("CodeBlockV2DetailActivity", "enter code block v2 detail failed: line contents is empty");
        UDToast.show(this, R.string.Lark_Legacy_ErrorMessageTip);
        finish();
    L32:
        if (r106 != null) goto L34;
        r106 = CollectionsKt.emptyList();
    L34:
        this.f448278t = r106;
        Bundle r109 = getIntent().getExtras();
        if (r109 == null) goto L37;
        Serializable r110 = r109.getSerializable("key_code_block_process_params");
    L39:
        if ((r110 instanceof CodeBlockV2ProcessParams) == false) goto L41;
        CodeBlockV2ProcessParams r111 = (CodeBlockV2ProcessParams) r110;
    L42:
        if (r111 != null) goto L44;
        CodeBlockV2ProcessParams.b r112 = CodeBlockV2ProcessParams.Companion;
        int r113 = (int) UIHelper.sp2px(14.0f);
        r112.getClass();
        r111 = CodeBlockV2ProcessParams.b.a(r113);
    L44:
        this.f448279u = r111;
        setContentView(R.layout.activity_rich_text_code_block_v2_detail);
        this.f448271m = UIUtils.dp2px(this, 8.0f);
        Resources r114 = getResources();
        this.f448272n = WindowDisplayMetricsOverride.apply(r114, r114.getDisplayMetrics()).widthPixels - (this.f448271m * 2);
        UIUtils.dp2px(this, 24.0f);
        this.f448268j = (CommonTitleBar) findViewById(R.id.titlebar);
        this.f448260b = findViewById(R.id.content_layout);
        CodeBlockV2DetailView r115 = (CodeBlockV2DetailView) findViewById(R.id.code_block_content_view);
        this.f448261c = r115;
        if (r115 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("codeBlockDetailView");
        r115 = null;
    L47:
        r115.setOnLongClickListener(new c(this));
        CodeBlockV2DetailView r116 = (CodeBlockV2DetailView) findViewById(R.id.code_block_line_num_view);
        this.f448262d = r116;
        if (r116 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("lineNumView");
        r116 = null;
    L50:
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L53;
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r117;
    L54:
        if (r118 == null) goto L59;
        CodeBlockV2ProcessParams r119 = this.f448279u;
        if (r119 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("codeBlockProcessParams");
        r119 = null;
    L58:
        r118.setMarginEnd(r119.getCodeZoneParams().getLineNumEndMargin());
    L59:
        this.f448263e = findViewById(R.id.fetch_loading);
        this.f448264f = (AppCompatImageView) findViewById(R.id.fetch_loading_iv);
        UDLoadingDrawable r120 = new UDLoadingDrawable(this);
        r120.setColorSchemeColors(new int[]{UIUtils.getColor(this, R.color.primary_fill_default)});
        this.f448265g = r120;
        AppCompatImageView r121 = this.f448264f;
        if (r121 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("loadingIv");
        r121 = null;
    L62:
        UDLoadingDrawable r122 = this.f448265g;
        if (r122 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
    L66:
        r121.setImageDrawable(r105);
        this.f448267i = findViewById(R.id.process_failed_layout);
        z1(true, false);
        B1(xbc.d.a().getCodeBlockWordWrapSetting());
        return;
    L65:
        r105 = r122;
        goto L66
    L53:
        r118 = null;
        goto L54
    L41:
        r111 = null;
        goto L42
    L37:
        r110 = null;
        goto L39
    L26:
        if (r107.isEmpty() == true) goto L29;
        r108 = false;
        goto L30
    L22:
        r106 = h.f448298a.remove(r102);
        goto L23
    L18:
        r104 = false;
    L14:
        r102 = "";
        goto L15
    }

    public final void z1(boolean r100, boolean r101) {
        int r102 = 8;
        View r103 = null;
        if (r100 == false) goto L8;
        this.f448266h = 2;
        View r104 = this.f448263e;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        r104 = null;
    L7:
        r104.postDelayed(new b(this), 200);
    L15:
        View r105 = this.f448267i;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("errorLayout");
        r105 = null;
    L19:
        if (r101 == false) goto L21;
        int r106 = 0;
    L22:
        r105.setVisibility(r106);
        View r107 = this.f448260b;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("codeBlockLayout");
    L26:
        if (r100 == true) goto L30;
        if (r101 == true) goto L30;
        r102 = 0;
    L30:
        r103.setVisibility(r102);
        return;
    L25:
        r103 = r107;
        goto L26
    L21:
        r106 = 8;
        goto L22
    L8:
        UDLoadingDrawable r108 = this.f448265g;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        r108 = null;
    L11:
        r108.stop();
        View r109 = this.f448263e;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        r109 = null;
    L14:
        r109.setVisibility(8);
        this.f448266h = 1;
        goto L15
    }
}
