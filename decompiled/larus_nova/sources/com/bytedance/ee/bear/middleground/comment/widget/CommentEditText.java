package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ee.bear.middleground.comment.audio.ForegroundColorSpanForGray;
import com.bytedance.ee.bear.middleground.comment.export.bean.UserInfo;
import com.bytedance.ee.bear.widget.AtEditText;
import com.bytedance.supervisor.token.Token;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 @2\u00020\u0001:\u0002@AB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u0013J\u0014\u0010 \u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\"J\b\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u001dJ\u0006\u0010'\u001a\u00020\u001dJ\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0013H\u0002J\u001e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020.J\u0014\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0006\u00103\u001a\u00020\u001dJ\u0012\u00104\u001a\u00020\u00132\b\u00105\u001a\u0004\u0018\u000106H\u0014J\n\u00107\u001a\u0004\u0018\u000106H\u0014J\u0010\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u0013H\u0014J\b\u0010:\u001a\u00020\rH\u0014J\b\u0010;\u001a\u00020\rH\u0014J\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020>0=j\b\u0012\u0004\u0012\u00020>`?R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/widget/CommentEditText;", "Lcom/bytedance/ee/bear/widget/AtEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mKeyboardLoadingCallback", "Lcom/bytedance/ee/bear/middleground/comment/audio/RecordSpannableStringUtil$TextDrawableCallback;", "mAudio2TextContent", "", "initialStringBuilder", "Landroid/text/SpannableStringBuilder;", "mLastAudio2TextContent", "mOriginTextIndex", "isStop", "", "mLastAudioTextIndex", "forceStopUpdate", "originHint", "getOriginHint", "()Ljava/lang/String;", "setOriginHint", "(Ljava/lang/String;)V", "voiceInputTextUpdating", BasicTestActionHandler.TEST_ACTION_RESET, "", "onStartRecord", "isVoiceInputTextUpdating", "runVoiceInputTextUpdate", "block", "Lkotlin/Function0;", "getPresenter", "Lcom/bytedance/ee/bear/widget/AtEditTextPresenter;", "onStopRecord", "onInputHide", "onTextChangeByKeyboard", "updateHint", "recording", "updateAudioText", "recognizedText", "isFinish", "diffIndex", "", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "stopUpdateAudioText", "setPrimaryClip", "clip", "Landroid/content/ClipData;", "getPrimaryClip", "isFilterMenuWhiteList", "isWordOver", "getCopyToken", "getPasteToken", "getMentionUsers", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/UserInfo;", "Lkotlin/collections/ArrayList;", "Companion", "MyInputConnection", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentEditText extends AtEditText {
    public com.bytedance.ee.bear.middleground.comment.audio.k P1;
    public SpannableStringBuilder Q1;
    public String S1;
    public int T1;
    public boolean V1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public int f232273b2;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public boolean f232274g2;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public String f232275h2;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public boolean f232276p2;

    public static final class a {
    }

    public final class b implements InputConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputConnection f232277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommentEditText f232278b;

        @Override // android.view.inputmethod.InputConnection
        public final boolean beginBatchEdit() {
            return this.f232277a.beginBatchEdit();
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean clearMetaKeyStates(int r100) {
            return this.f232277a.clearMetaKeyStates(r100);
        }

        @Override // android.view.inputmethod.InputConnection
        public final void closeConnection() {
            this.f232277a.closeConnection();
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean commitCompletion(CompletionInfo r100) {
            return this.f232277a.commitCompletion(r100);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean commitContent(InputContentInfo r100, int r101, Bundle r102) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            return this.f232277a.commitContent(r100, r101, r102);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean commitCorrection(CorrectionInfo r100) {
            return this.f232277a.commitCorrection(r100);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingTextInCodePoints(int r100, int r101) {
            return this.f232277a.deleteSurroundingTextInCodePoints(r100, r101);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean endBatchEdit() {
            return this.f232277a.endBatchEdit();
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean finishComposingText() {
            return this.f232277a.finishComposingText();
        }

        @Override // android.view.inputmethod.InputConnection
        public final int getCursorCapsMode(int r100) {
            return this.f232277a.getCursorCapsMode(r100);
        }

        @Override // android.view.inputmethod.InputConnection
        public final ExtractedText getExtractedText(ExtractedTextRequest r100, int r101) {
            return this.f232277a.getExtractedText(r100, r101);
        }

        @Override // android.view.inputmethod.InputConnection
        public final Handler getHandler() {
            return this.f232277a.getHandler();
        }

        @Override // android.view.inputmethod.InputConnection
        public final CharSequence getSelectedText(int r100) {
            return this.f232277a.getSelectedText(r100);
        }

        @Override // android.view.inputmethod.InputConnection
        public final CharSequence getTextAfterCursor(int r100, int r101) {
            return this.f232277a.getTextAfterCursor(r100, r101);
        }

        @Override // android.view.inputmethod.InputConnection
        public final CharSequence getTextBeforeCursor(int r100, int r101) {
            return this.f232277a.getTextBeforeCursor(r100, r101);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean performContextMenuAction(int r100) {
            return this.f232277a.performContextMenuAction(r100);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean performEditorAction(int r100) {
            return this.f232277a.performEditorAction(r100);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean performPrivateCommand(String r100, Bundle r101) {
            return this.f232277a.performPrivateCommand(r100, r101);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean reportFullscreenMode(boolean r100) {
            return this.f232277a.reportFullscreenMode(r100);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean requestCursorUpdates(int r100) {
            return this.f232277a.requestCursorUpdates(r100);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r100) {
            return this.f232277a.sendKeyEvent(r100);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean setComposingRegion(int r100, int r101) {
            return this.f232277a.setComposingRegion(r100, r101);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean setSelection(int r100, int r101) {
            return this.f232277a.setSelection(r100, r101);
        }

        public b(CommentEditText r100, InputConnection r101) {
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            this.f232278b = r100;
            this.f232277a = r101;
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean commitText(CharSequence r100, int r101) {
            this.f232278b.M();
            if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.comment_link_optimize") == false) goto L6;
            this.f232278b.f239856y1.onPaste(String.valueOf(r100));
        L6:
            return this.f232277a.commitText(r100, r101);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r100, int r101) {
            this.f232278b.M();
            return this.f232277a.deleteSurroundingText(r100, r101);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean setComposingText(CharSequence r100, int r101) {
            this.f232278b.M();
            return this.f232277a.setComposingText(r100, r101);
        }
    }

    static {
    }

    public CommentEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public String getCopyToken() {
        return "LARK-PSDA-ccm_android_comment_edit_text_set_clipboard";
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public String getPasteToken() {
        return "LARK-PSDA-ccm_android_comment_edit_text_get_clipboard";
    }

    public final void K() {
        tt5.a.h("Comment#CommentEditText", "onStartRecord");
        R(true);
    }

    public final void L() {
        tt5.a.h("Comment#CommentEditText", "onStopRecord");
        this.V1 = true;
        R(false);
    }

    public final void M() {
        if (this.V1 == true) goto L5;
        return;
    L5:
        if (this.f232274g2 == true) goto L9;
        tt5.a.h("Comment#CommentEditText", "edit by keyboard after stopping recording, so force stop update audio text");
        this.f232274g2 = true;
        return;
    }

    public final void N() {
        tt5.a.h("Comment#CommentEditText", BasicTestActionHandler.TEST_ACTION_RESET);
        this.Q1 = null;
        this.S1 = "";
        this.V1 = false;
        this.f232274g2 = false;
    }

    public final void P() {
        tt5.a.h("Comment#CommentEditText", "stopUpdateAudioText");
        Q("", true, new int[2]);
        this.f232274g2 = true;
    }

    public final ArrayList<UserInfo> getMentionUsers() {
        ArrayList<UserInfo> r100 = new ArrayList();
        Editable r101 = getText();
        if (r101 == null) goto L13;
        Editable r102 = getText();
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.length();
    L8:
        un5.l[] r105 = (un5.l[]) r101.getSpans(0, r104, un5.l.class);
        if (r105 == null) goto L13;
        int r106 = r105.length;
    L11:
        if (r103 >= r106) goto L13;
        un5.l r107 = r105[r103];
        UserInfo r108 = new UserInfo();
        r108.setUserId(r107.f550815d);
        r108.setAvatarUrl(r107.f550829r);
        r108.setOwnerType(1);
        r108.setUserName(r107.f550817f);
        r108.setExternal(r107.f550826o);
        r100.add(r108);
        r103 = r103 + 1;
        goto L11
    L7:
        r104 = 0;
    L13:
        return r100;
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText
    public com.bytedance.ee.bear.widget.l getPresenter() {
        if (this.V0 != null) goto L6;
        this.V0 = new f(this);
    L6:
        return this.V0;
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public ClipData getPrimaryClip() {
        return ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).l(new Token("LARK-PSDA-ccm_android_comment_edit_text_get_clipboard"));
    }

    public final String getOriginHint() {
        return this.f232275h2;
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public final boolean A(ClipData r100) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();     // Catch: Throwable -> L6
        jg5.k.a.f499019a.d(false, true);     // Catch: Throwable -> L6
        return ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).m(r100, this.f240349p0, new Token("LARK-PSDA-ccm_android_comment_edit_text_set_clipboard"));
    L7:
        return super.A(r100);
    }

    public final void O(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f232276p2 = true;
        r100.invoke();     // Catch: Throwable -> L6
        this.f232276p2 = false;
        return;
    L6:
        th = move-exception;
        this.f232276p2 = false;
        throw th;
    }

    public final void R(boolean r110) {
        if (r110 == false) goto L9;
        String r111 = getContext().getString(R.string.Doc_Comment_SpeakNow);
        Context r100 = getContext();
        com.bytedance.ee.bear.middleground.comment.audio.k r101 = this.P1;
        SpannableStringBuilder r102 = new SpannableStringBuilder(r111);
        r102.append(" ");
        int r103 = r102.length();
        r102.append(" ");
        int r112 = r102.length();
        pl.droidsonroids.gif.d r104 = new pl.droidsonroids.gif.d(r100.getResources(), R.drawable.comment_anim_keyboard_dot_loading);     // Catch: IOException -> L6
        r104.setCallback(r101);     // Catch: IOException -> L6
        r104.setBounds(0, 0, com.bytedance.ee.util.ui.n.f(r100, 19), com.bytedance.ee.util.ui.n.f(r100, 3));     // Catch: IOException -> L6
        r102.setSpan(new ImageSpan(r104, 1), r103, r112, 33);     // Catch: IOException -> L6
    L8:
        r102.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.lkui_N500)), 0, r102.length(), 33);
        CharSequence r105 = r102;
    L10:
        setHint(r105);
        return;
    L6:
        e = move-exception;
        tt5.a.e("Comment#SpannableStringUtil", "getLoadingString(): ", e, false);
        goto L8
    L9:
        r105 = this.f232275h2;
        goto L10
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        InputConnection r101 = super.onCreateInputConnection(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new b(this, r101);
    }

    public final void setOriginHint(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f232275h2 = r100;
    }

    public CommentEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.S1 = "";
        this.f232275h2 = "";
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.docx_comment_copy_atmention_support") == false) goto L6;
        setCopyAtMentionEnable(true);
        return;
    }

    public final void Q(String r100, boolean r110, int[] r111) {
        Intrinsics.checkNotNullParameter(r100, "recognizedText");
        Intrinsics.checkNotNullParameter(r111, "diffIndex");
        tt5.a.h("Comment#CommentEditText", "updateAudioText, recognizedText: " + r100.length() + ", isFinish: " + r110 + ", diffIndex: " + r111 + ", forceStopUpdate = " + this.f232274g2);
        if (this.S1.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L12;
        if (Intrinsics.areEqual(this.S1, r100) == false) goto L12;
        if (r110 == true) goto L12;
        return;
    L12:
        if (this.f232274g2 == false) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r100) == true) goto L18;
        this.S1 = r100;
    L18:
        if (this.P1 != null) goto L21;
        this.P1 = new com.bytedance.ee.bear.middleground.comment.audio.k(this);
    L21:
        if (this.Q1 != null) goto L23;
        Editable r102 = getText();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        this.Q1 = (SpannableStringBuilder) r102;
        String.valueOf(getText());
        this.T1 = getSelectionStart();
    L23:
        SpannableStringBuilder r103 = this.Q1;
        if (r103 == null) goto L26;
        int r104 = r103.length();
    L28:
        if (this.T1 <= r104) goto L31;
        iu5.d.a("CommentEditText", new Throwable());
        return;
    L31:
        Object[] r105 = null;
        if (getSelectionStart() == this.f232273b2) goto L59;
        if (this.V1 == false) goto L59;
        SpannableStringBuilder r112 = this.Q1;
        if (r112 == null) goto L38;
        r105 = (ForegroundColorSpanForGray[]) r112.getSpans(0, r104, ForegroundColorSpanForGray.class);
    L38:
        if (r105 == null) goto L57;
        int r113 = r105.length;
        int r114 = 0;
    L40:
        if (r114 >= r113) goto L111;
        Object r106 = r105[r114];
        SpannableStringBuilder r107 = this.Q1;
        if (r107 == null) goto L44;
        int r108 = r107.getSpanStart(r106);
    L45:
        SpannableStringBuilder r109 = this.Q1;
        if (r109 == null) goto L48;
        int r115 = r109.getSpanEnd(r106);
    L49:
        ForegroundColorSpan r116 = new ForegroundColorSpan(getContext().getResources().getColor(R.color.black));
        if (r108 < 0) goto L56;
        if (r108 >= r115) goto L56;
        if (r115 > r104) goto L56;
        SpannableStringBuilder r117 = this.Q1;
        if (r117 == null) goto L56;
        r117.setSpan(r116, r108, r115, 33);
    L56:
        r114 = r114 + 1;
        goto L40
    L48:
        r115 = 0;
        goto L49
    L44:
        r108 = 0;
        goto L45
    L111:
        return;
    L57:
        return;
    L59:
        if (this.T1 > getSelectionStart()) goto L61;
        int r118 = getSelectionStart();
    L62:
        SpannableStringBuilder r119 = this.Q1;
        if (r119 != null) goto L65;
    L70:
        SpannableStringBuilder r120 = this.Q1;
        if (r120 == null) goto L73;
        r120.replace(this.T1, r118, this.S1);
    L73:
        SpannableStringBuilder r121 = this.Q1;
        if (r121 == null) goto L79;
        if (r121 == null) goto L77;
        int r122 = r121.length();
    L78:
        r105 = (ForegroundColorSpan[]) r121.getSpans(0, r122, ForegroundColorSpan.class);
        goto L79
    L77:
        r122 = 0;
    L79:
        if (r105 == null) goto L86;
        int r123 = r105.length;
        int r124 = 0;
    L81:
        if (r124 >= r123) goto L86;
        Object r125 = r105[r124];
        SpannableStringBuilder r126 = this.Q1;
        if (r126 == null) goto L85;
        r126.removeSpan(r125);
    L85:
        r124 = r124 + 1;
    L86:
        if (r110 == false) goto L88;
        return;
    L88:
        if (r111.length != 0) goto L90;
        boolean r127 = true;
    L92:
        if ((!r127) == false) goto L94;
        int r128 = r111[0];
    L95:
        int r129 = Math.max(r128, this.S1.length() - 2);
        Context r130 = getContext();
        SpannableStringBuilder r131 = this.Q1;
        int r132 = this.T1 + r129;
        int r133 = getSelectionStart();
        int r134 = Math.max(Math.min(r132, r131.length()), 0);
        int r135 = Math.min(r133, r131.length());
        if ((r135 - r134) <= 2) goto L98;
        r134 = r135 - 2;
    L98:
        if (r135 >= r134) goto L100;
        r134 = r135;
    L100:
        r131.setSpan(new ForegroundColorSpanForGray(r130.getResources().getColor(R.color.lkui_N500)), r134, r135, 33);
        this.f232273b2 = getSelectionStart();
        tt5.a.b("Comment#CommentEditText", "updateAudioText spannable: " + r131 + ", partIndex: " + r129);
        return;
    L94:
        r128 = this.S1.length();
        goto L95
    L90:
        r127 = false;
        goto L92
    L65:
        if (r118 <= r119.length()) goto L68;
        r118 = r119.length();
    L68:
        if (this.T1 <= r119.length()) goto L70;
        this.T1 = r119.length();
        goto L70
    L61:
        r118 = this.T1;
        goto L62
    L26:
        r104 = 0;
        goto L28
    L5:
        r101 = false;
        goto L6
    }

    public /* synthetic */ CommentEditText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
