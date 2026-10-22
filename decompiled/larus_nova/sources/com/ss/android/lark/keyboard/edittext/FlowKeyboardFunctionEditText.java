package com.ss.android.lark.keyboard.edittext;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.DragEvent;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.UIUtils;
import com.larus.feishu.office.im.impl.officemention.OfficeMentionServiceImpl;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.biz.mention.FetchAllDataAtStrategy;
import com.ss.android.lark.keyboard.biz.mention.IMCommonAtStrategy;
import com.ss.android.lark.keyboard.editor.input.l;
import com.ss.android.lark.keyboard.editor.input.m;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink.CustomLinkStrategy;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlinePreviewConfig;
import com.ss.android.lark.keyboard.edittext2.edittors.image.ImageEditor;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.keyboard.edittext2.list.EditorListApplier;
import com.ss.android.lark.keyboard.edittext2.span.ClickLinkMovementMethod;
import com.ss.android.lark.keyboard.edittext2.utils.RichTextCopyUtils;
import com.ss.android.lark.keyboard.viewmodel.KeyboardModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0003`abB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u00106\u001a\u00020\bJ\u0016\u00107\u001a\u00020\u00122\u0006\u00108\u001a\u00020\fH\u0096@¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020\u00122\u0006\u00108\u001a\u00020\fH\u0096@¢\u0006\u0002\u00109J\u0010\u0010;\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010<J\u0017\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0002\b@J\u0010\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020\u0012H\u0014J\u0010\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\bH\u0014J\b\u0010G\u001a\u00020>H\u0002J\b\u0010H\u001a\u00020>H\u0002J\b\u0010I\u001a\u00020>H\u0002J\b\u0010J\u001a\u00020>H\u0002J\b\u0010K\u001a\u00020>H\u0002J\b\u0010L\u001a\u00020>H\u0002J\b\u0010M\u001a\u00020>H\u0002J\b\u0010N\u001a\u00020>H\u0014J\b\u0010O\u001a\u00020>H\u0014J\u0010\u0010P\u001a\u00020>2\b\u0010Q\u001a\u0004\u0018\u00010!J\u0010\u0010R\u001a\u00020>2\b\u0010Q\u001a\u0004\u0018\u00010#J\u0010\u0010S\u001a\u00020>2\b\u0010T\u001a\u0004\u0018\u00010'J\u0006\u0010U\u001a\u00020>J\u0016\u0010V\u001a\u00020>2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020XJ\b\u0010Z\u001a\u00020>H\u0002J\u0012\u0010[\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0002J\b\u0010^\u001a\u00020>H\u0002J\b\u0010_\u001a\u00020>H\u0002R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b0\u00101¨\u0006c"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext/FlowKeyboardFunctionEditText;", "Lcom/ss/android/lark/keyboard/edittext2/KeyboardFunctionEditText;", "Lcom/ss/android/lark/keyboard/edittext/IMarkdownInputContent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "curChatId", "", "getCurChatId", "()Ljava/lang/String;", "setCurChatId", "(Ljava/lang/String;)V", "curChatIsPrivate", "", "getCurChatIsPrivate", "()Z", "setCurChatIsPrivate", "(Z)V", "htmlClipCoordinator", "Lcom/ss/android/lark/keyboard/edittext/FunctionEditTextCopyCoordinator;", "localImagePasteCoordinator", "Lcom/ss/android/lark/keyboard/edittext/KeyboardLocalImagePasteCoordinator;", "richTextPasteCoordinator", "Lcom/ss/android/lark/keyboard/edittext/KeyboardRichTextPasteCoordinator;", "editTextController", "", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/v2/IEditTextController;", "onPasteImageListener", "Lcom/ss/android/lark/keyboard/edittext/FlowKeyboardFunctionEditText$OnPasteImageListener;", "onPasteUriListener", "Lcom/ss/android/lark/keyboard/edittext/FlowKeyboardFunctionEditText$OnPasteUriListener;", "dragEventHandler", "Lcom/ss/android/lark/keyboard/edittext/FlowKeyboardDragEventHandler;", "urlInlinePreviewConfig", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/urlinline/UrlInlinePreviewConfig;", "keyboardModel", "Lcom/ss/android/lark/keyboard/viewmodel/KeyboardModel;", "getKeyboardModel", "()Lcom/ss/android/lark/keyboard/viewmodel/KeyboardModel;", "keyboardModel$delegate", "Lkotlin/Lazy;", "markdownInputContentDelegate", "Lcom/ss/android/lark/keyboard/edittext/MarkdownInputContentDelegate;", "getMarkdownInputContentDelegate", "()Lcom/ss/android/lark/keyboard/edittext/MarkdownInputContentDelegate;", "markdownInputContentDelegate$delegate", "getRichText", "Lcom/ss/android/lark/widget/richtext/RichText;", "start", "end", "setMarkdownContent", "markdown", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appendMarkdownContent", "getMarkdownContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDragEventHandler", "", "handler", "setDragEventHandler$keyboard_assembler_productionChinaRelease", "onDragEvent", "event", "Landroid/view/DragEvent;", "beforeTextPaste", "beforeTextCopy", "id", "setupIMImageAndMedia", "setupListApplier", "setupIMRichTextEditor", "setupIMRichTextGenerator", "setupAnchorStrategies", "setupAtEditor", "setupInlineCodeApplier", "onAttachedToWindow", "onDetachedFromWindow", "setOnPasteImageListener", "listener", "setOnPasteUriListener", "setUrlInlinePreviewConfig", "config", "useLarkUrlInlinePreview", "useLarkTempPreview", "appId", "", "type", "setupTextSelection", "handleAfterTextChangeForController", "editable", "Landroid/text/Editable;", "setupAnchorV2", "setupRichTextEditor", "Companion", "OnPasteImageListener", "OnPasteUriListener", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowKeyboardFunctionEditText extends KeyboardFunctionEditText {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f428918v = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f428919k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f428920l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.edittext.b f428921m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.edittext.d f428922n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.edittext.e f428923o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.c> f428924p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c f428925q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.ss.android.lark.keyboard.edittext.a f428926r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public UrlInlinePreviewConfig f428927s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f428928t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f428929u;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
        boolean a(List<? extends Uri> r100);
    }

    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowKeyboardFunctionEditText f428930a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public d(FlowKeyboardFunctionEditText r100) {
            this.f428930a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            FlowKeyboardFunctionEditText r101 = this.f428930a;
            int r102 = FlowKeyboardFunctionEditText.f428918v;
            r101.getClass();
            Log.d("FlowKeyboardFunctionEditText", "handleAfterTextChangeForController");
            Iterator r103 = ((ArrayList) r101.f428924p).iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.c) r103.next()).afterTextChanged(r100);
            goto L4
        }
    }

    public static final class e implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowKeyboardFunctionEditText f428931a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public e(FlowKeyboardFunctionEditText r100) {
            this.f428931a = r100;
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (Build.VERSION.SDK_INT < 26) goto L6;
            this.f428931a.setDefaultFocusHighlightEnabled(false);
            return;
        }
    }

    static {
    }

    public FlowKeyboardFunctionEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FlowKeyboardFunctionEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setOnPasteImageListener(b r100) {
    }

    private final KeyboardModel getKeyboardModel() {
        return (KeyboardModel) this.f428928t.getValue();
    }

    private final f getMarkdownInputContentDelegate() {
        return (f) this.f428929u.getValue();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText
    public final boolean f() {
        ClipData r100 = RichTextCopyUtils.d(getContext());
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        final com.ss.android.lark.keyboard.edittext.e r102 = this.f428923o;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "clp");
        final Ref.BooleanRef r103 = new Ref.BooleanRef();
        final b r104 = null;
        RichTextCopyUtils.h(r100, new KeyboardRichTextPasteCoordinator$handleRichTextClipIfNeed$1(r102, r104, r103));
        if (r103.element == true) goto L97;
        com.ss.android.lark.keyboard.edittext.b r105 = this.f428921m;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "clipData");
        Log.i("FunctionEditTextCopyCoordinator", "handleClipDataIfNeed");
        if (r105.f428934c == true) goto L10;
    L9:
        boolean r106 = false;
    L23:
        if (r106 == true) goto L97;
        com.ss.android.lark.keyboard.edittext.d r107 = this.f428922n;
        c r108 = this.f428925q;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r100, "clp");
        if (r108 != null) goto L27;
    L26:
        boolean r109 = false;
    L54:
        if (r109 == true) goto L97;
        com.ss.android.lark.keyboard.edittext.d r110 = this.f428922n;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "clp");
        Context r111 = r110.f428938a.getContext();
        Intrinsics.checkNotNull(r111);
        new HashMap();
        int r112 = StoragePermissionUtils.a(r111, StoragePermissionUtils.d(r111, 2));
        StoragePermissionUtils.a(r111, StoragePermissionUtils.d(r111, 4));
        StoragePermissionUtils.d(r111, 8);
        StoragePermissionUtils.e(r111);
        if (r112 == 2) goto L58;
        boolean r113 = true;
    L59:
        if (r113 == true) goto L62;
        Log.i("KeyboardLocalImagePasteCoordinator", "handleClipUriIfNeed: no storage permission");
    L61:
        boolean r114 = false;
    L96:
        if (r114 == true) goto L97;
    L98:
        Log.d("FlowKeyboardFunctionEditText", "beforeTextPaste " + r101);
        return r101;
    L62:
        int r115 = 0;
    L64:
        if (r115 >= r100.getDescription().getMimeTypeCount()) goto L72;
        String r116 = r100.getDescription().getMimeType(r115);
        if (Intrinsics.areEqual(r116, "text/uri-list") == true) goto L70;
        Intrinsics.checkNotNull(r116);
        if (StringsKt.startsWith$default(r116, "image/", false, 2, null) == true) goto L70;
        r115 = r115 + 1;
    L70:
        boolean r117 = true;
    L73:
        if (r117 == false) goto L61;
        int r118 = 0;
    L77:
        if (r118 >= r100.getItemCount()) goto L86;
        ClipData.Item r119 = r100.getItemAt(r118);
        Uri r120 = r119.getUri();
        if (r120 == null) goto L81;
        String r121 = r120.getScheme();
    L83:
        if (TextUtils.equals("content", r121) == true) goto L84;
        r118 = r118 + 1;
        goto L77
    L84:
        Uri r122 = r119.getUri();
    L87:
        if (r122 == null) goto L61;
        ContentResolver r123 = r111.getContentResolver();
        String[] r124 = {DBDefinition.ID, "_data", "mime_type", "width", "height", "_size"};
        sf7.a r125 = sf7.a.f541727a;
        Intrinsics.checkNotNull(r123);
        final Cursor r126 = r125.query(r123, r122, r124, null, null, null, new Token("LARK-PSDA-paste_local_img_query_content"));
        if (r126 == null) goto L61;
        BuildersKt.launch$default(r110.f428939b, null, null, new KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1(r110, r126, null, null), 3, null).invokeOnCompletion(new KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$1(r126));
        Editable r127 = r110.f428938a.getText();
        if (r127 == null) goto L95;
        r127.append("\u200b");
        r127.delete(r127.length() - 1, r127.length());
    L95:
        r114 = true;
        goto L96
    L81:
        r121 = null;
        goto L83
    L86:
        r122 = null;
        goto L87
    L72:
        r117 = false;
        goto L73
    L58:
        r113 = false;
        goto L59
    L27:
        int r128 = r100.getDescription().getMimeTypeCount();
        int r129 = 0;
    L28:
        if (r129 >= r128) goto L36;
        String r130 = r100.getDescription().getMimeType(r129);
        if (Intrinsics.areEqual(r130, "text/uri-list") == true) goto L35;
        Intrinsics.checkNotNull(r130);
        if (StringsKt.startsWith$default(r130, "image/", false, 2, null) == true) goto L35;
        r129 = r129 + 1;
    L35:
        boolean r131 = true;
    L37:
        if (r131 == false) goto L26;
        ArrayList r132 = new ArrayList();
        int r133 = r100.getItemCount();
        int r134 = 0;
    L40:
        if (r134 >= r133) goto L51;
        Uri r135 = r100.getItemAt(r134).getUri();
        if (r135 == null) goto L49;
        if (TextUtils.equals("content", r135.getScheme()) == true) goto L47;
        r135 = null;
    L47:
        if (r135 == null) goto L49;
        r132.add(r135);
    L49:
        r134 = r134 + 1;
        goto L40
    L51:
        if (r132.isEmpty() == true) goto L26;
        r109 = r108.a(r132);
        goto L54
    L36:
        r131 = false;
        goto L37
    L10:
        ClipData.Item r136 = r100.getItemAt(0);
        if (r136 == null) goto L9;
        String r137 = r136.getHtmlText();
        if (r137 != null) goto L16;
    L19:
        boolean r138 = true;
    L20:
        if (r138 == true) goto L9;
        CharSequence r139 = r136.getText();
        Log.i("FunctionEditTextCopyCoordinator", "handleClipDataIfNeed: html is not empty, trying to transform html to richText");
        Log.d("FunctionEditTextCopyCoordinator", "htmlToRichText: html is " + r137);
        BuildersKt.launch$default(r105.f428935d, null, null, new FunctionEditTextCopyCoordinator$handleClipDataIfNeed$1(r105, r137, r139, null, null), 3, null);
        r106 = true;
        goto L23
    L16:
        if (r137.length() == 0) goto L19;
        r138 = false;
    L97:
        r101 = true;
        goto L98
    }

    public final void k() {
        ArrayList r100 = new ArrayList();
        r100.add(com.ss.android.lark.keyboard.edittext2.edittors.anchor.tasklink.b.f428991a);
        r100.add(CustomLinkStrategy.f428980b);
        r100.add(com.ss.android.lark.keyboard.edittext2.edittors.anchor.possiblelink.b.f428988a);
        r100.add(new com.ss.android.lark.keyboard.edittext2.edittors.anchor.widecharurl.a(this.f428927s));
        ((eob.a) q(eob.a.f473406f)).Y(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<T> r100 = this.f428924p.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.c) r100.next()).b(this);
        goto L4
    L6:
        this.f428921m.f428934c = true;
        this.f428923o.getClass();
        this.f428922n.getClass();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<T> r100 = this.f428924p.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.c) r100.next()).unbind();
        goto L4
    L6:
        com.ss.android.lark.keyboard.edittext.b r101 = this.f428921m;
        r101.f428934c = false;
        CoroutineScopeKt.cancel$default(r101.f428935d, null, 1, null);
        CoroutineScopeKt.cancel$default(this.f428922n.f428939b, null, 1, null);
        CoroutineScopeKt.cancel$default(this.f428923o.f428942b, null, 1, null);
    }

    public final String getCurChatId() {
        return this.f428919k;
    }

    public final boolean getCurChatIsPrivate() {
        return this.f428920l;
    }

    public static final /* synthetic */ KeyboardModel h(FlowKeyboardFunctionEditText r100) {
        return r100.getKeyboardModel();
    }

    public static RichText i(FlowKeyboardFunctionEditText r100) {
        int r101 = r100.length();
        return ((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) com.ss.android.lark.keyboard.edittext2.utils.e.a(r100.q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.f429100g), FlowKeyboardFunctionEditText$getRichText$1.INSTANCE)).i(0, r101);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText
    public final boolean e(int r110) {
        com.ss.android.lark.keyboard.edittext.b r100 = this.f428921m;
        if (r100.f428934c == true) goto L5;
        boolean r101 = false;
    L6:
        if (r101 == false) goto L8;
        return false;
    L8:
        return super.e(r110);
    L5:
        BuildersKt.launch$default(r100.f428935d, null, null, new FunctionEditTextCopyCoordinator$asyncWriteRichTextHtmlIfNeed$1(r100, null), 3, null);
        r101 = true;
        goto L6
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f428926r == null) goto L6;
        Handler r101 = OfficeMentionServiceImpl.f343210b;
        Intrinsics.checkNotNullParameter(r100, "it");
        return false;
    L6:
        return super.onDragEvent(r100);
    }

    public final void setCurChatId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428919k = r100;
    }

    public final void setCurChatIsPrivate(boolean r100) {
        this.f428920l = r100;
    }

    public final void setDragEventHandler$keyboard_assembler_productionChinaRelease(com.ss.android.lark.keyboard.edittext.a r100) {
        this.f428926r = r100;
    }

    public final void setOnPasteUriListener(c r100) {
        this.f428925q = r100;
    }

    public final void setUrlInlinePreviewConfig(UrlInlinePreviewConfig r100) {
        if (r100 != null) goto L4;
        int r101 = UrlInlinePreviewConfig.f428993b;
        r100 = UrlInlinePreviewConfig.a.a();
    L4:
        this.f428927s = r100;
        k();
    }

    public FlowKeyboardFunctionEditText(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f428919k = "";
        this.f428921m = new com.ss.android.lark.keyboard.edittext.b(this);
        this.f428922n = new com.ss.android.lark.keyboard.edittext.d(this);
        this.f428923o = new com.ss.android.lark.keyboard.edittext.e(this);
        this.f428924p = new ArrayList();
        int r103 = UrlInlinePreviewConfig.f428993b;
        this.f428927s = UrlInlinePreviewConfig.a.a();
        this.f428928t = LazyKt.lazy(FlowKeyboardFunctionEditText$keyboardModel$2.INSTANCE);
        this.f428929u = LazyKt.lazy(new FlowKeyboardFunctionEditText$markdownInputContentDelegate$2(this, r100));
        addTextChangedListener(new e(this));
        addTextChangedListener(new d(this));
        setHighlightColor(UIUtils.getAlphaColor(R.color.primary_fill_default, 0.2d));
        k();
        RichTextEditor.a r104 = RichTextEditor.f429074t;
        q(r104);
        d(dob.b.class);
        com.ss.android.lark.keyboard.edittext2.edittors.a.C5088a r105 = com.ss.android.lark.keyboard.edittext2.edittors.a.f428974e;
        q(r105);
        d(dob.a.class);
        setMovementMethod(new ClickLinkMovementMethod(this));
        ArrayList r106 = new ArrayList();
        r106.add(new FetchAllDataAtStrategy(new FlowKeyboardFunctionEditText$setupAtEditor$1(this)));
        r106.add(new IMCommonAtStrategy(new FlowKeyboardFunctionEditText$setupAtEditor$2(this)));
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) q(r105)).W(r106);
        q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.f429100g);
        d(dob.c.class);
        q(r104);
        d(dob.b.class);
        EditorListApplier r107 = new EditorListApplier(this, new com.ss.android.lark.keyboard.edittext2.list.b(getContext()));
        r107.b();
        EditorListApplier.b r108 = new EditorListApplier.b(r107);
        Intrinsics.checkNotNullParameter(r108, "onKeyListener");
        this.f428954i.add(r108);
        q(com.ss.android.lark.keyboard.edittext2.edittors.e.f429054e);
        d(m.class);
        q(ImageEditor.f429058c);
        d(l.class);
        ((RichTextEditor) q(r104)).f429082j = true;
    }

    public /* synthetic */ FlowKeyboardFunctionEditText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
