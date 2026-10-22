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
import com.bytedance.ee.bear.middleground.comment.audio.ForegroundColorSpanForGray;
import com.bytedance.ee.bear.middleground.comment.export.bean.UserInfo;
import com.bytedance.ee.bear.widget.AtEditText;
import com.bytedance.supervisor.token.Token;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 @2\u00020\u0001:\u0002@AB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u0013J\u0014\u0010 \u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\"J\b\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u001dJ\u0006\u0010'\u001a\u00020\u001dJ\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0013H\u0002J\u001e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020.J\u0014\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0006\u00103\u001a\u00020\u001dJ\u0012\u00104\u001a\u00020\u00132\b\u00105\u001a\u0004\u0018\u000106H\u0014J\n\u00107\u001a\u0004\u0018\u000106H\u0014J\u0010\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u0013H\u0014J\b\u0010:\u001a\u00020\rH\u0014J\b\u0010;\u001a\u00020\rH\u0014J\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020>0=j\b\u0012\u0004\u0012\u00020>`?R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/widget/CommentEditText;", "Lcom/bytedance/ee/bear/widget/AtEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mKeyboardLoadingCallback", "Lcom/bytedance/ee/bear/middleground/comment/audio/RecordSpannableStringUtil$TextDrawableCallback;", "mAudio2TextContent", "", "initialStringBuilder", "Landroid/text/SpannableStringBuilder;", "mLastAudio2TextContent", "mOriginTextIndex", "isStop", "", "mLastAudioTextIndex", "forceStopUpdate", "originHint", "getOriginHint", "()Ljava/lang/String;", "setOriginHint", "(Ljava/lang/String;)V", "voiceInputTextUpdating", "reset", "", "onStartRecord", "isVoiceInputTextUpdating", "runVoiceInputTextUpdate", "block", "Lkotlin/Function0;", "getPresenter", "Lcom/bytedance/ee/bear/widget/AtEditTextPresenter;", "onStopRecord", "onInputHide", "onTextChangeByKeyboard", "updateHint", "recording", "updateAudioText", "recognizedText", "isFinish", "diffIndex", "", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "stopUpdateAudioText", "setPrimaryClip", "clip", "Landroid/content/ClipData;", "getPrimaryClip", "isFilterMenuWhiteList", "isWordOver", "getCopyToken", "getPasteToken", "getMentionUsers", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/UserInfo;", "Lkotlin/collections/ArrayList;", "Companion", "MyInputConnection", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentEditText extends AtEditText {
    public com.bytedance.ee.bear.middleground.comment.audio.k P1;
    public SpannableStringBuilder Q1;
    public String S1;
    public int T1;
    public boolean V1;
    public int b2;
    public boolean g2;
    public String h2;
    public boolean p2;

    public static final class a {
    }

    public final class b implements InputConnection {
        public final InputConnection a;
        public final /* synthetic */ CommentEditText b;

        @Override // android.view.inputmethod.InputConnection
        public final boolean beginBatchEdit() {
            return this.a.beginBatchEdit();
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean clearMetaKeyStates(int r2) {
            return this.a.clearMetaKeyStates(r2);
        }

        @Override // android.view.inputmethod.InputConnection
        public final void closeConnection() {
            this.a.closeConnection();
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean commitCompletion(CompletionInfo r2) {
            return this.a.commitCompletion(r2);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean commitContent(InputContentInfo r2, int r3, Bundle r4) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return this.a.commitContent(r2, r3, r4);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean commitCorrection(CorrectionInfo r2) {
            return this.a.commitCorrection(r2);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingTextInCodePoints(int r2, int r3) {
            return this.a.deleteSurroundingTextInCodePoints(r2, r3);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean endBatchEdit() {
            return this.a.endBatchEdit();
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean finishComposingText() {
            return this.a.finishComposingText();
        }

        @Override // android.view.inputmethod.InputConnection
        public final int getCursorCapsMode(int r2) {
            return this.a.getCursorCapsMode(r2);
        }

        @Override // android.view.inputmethod.InputConnection
        public final ExtractedText getExtractedText(ExtractedTextRequest r2, int r3) {
            return this.a.getExtractedText(r2, r3);
        }

        @Override // android.view.inputmethod.InputConnection
        public final Handler getHandler() {
            return this.a.getHandler();
        }

        @Override // android.view.inputmethod.InputConnection
        public final CharSequence getSelectedText(int r2) {
            return this.a.getSelectedText(r2);
        }

        @Override // android.view.inputmethod.InputConnection
        public final CharSequence getTextAfterCursor(int r2, int r3) {
            return this.a.getTextAfterCursor(r2, r3);
        }

        @Override // android.view.inputmethod.InputConnection
        public final CharSequence getTextBeforeCursor(int r2, int r3) {
            return this.a.getTextBeforeCursor(r2, r3);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean performContextMenuAction(int r2) {
            return this.a.performContextMenuAction(r2);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean performEditorAction(int r2) {
            return this.a.performEditorAction(r2);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean performPrivateCommand(String r2, Bundle r3) {
            return this.a.performPrivateCommand(r2, r3);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean reportFullscreenMode(boolean r2) {
            return this.a.reportFullscreenMode(r2);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean requestCursorUpdates(int r2) {
            return this.a.requestCursorUpdates(r2);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r2) {
            return this.a.sendKeyEvent(r2);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean setComposingRegion(int r2, int r3) {
            return this.a.setComposingRegion(r2, r3);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean setSelection(int r2, int r3) {
            return this.a.setSelection(r2, r3);
        }

        public b(CommentEditText r2, InputConnection r3) {
            Intrinsics.checkNotNullParameter(r3, "target");
            this.b = r2;
            this.a = r3;
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean commitText(CharSequence r3, int r4) {
            this.b.M();
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.comment_link_optimize") == false) goto L6;
            this.b.y1.onPaste(String.valueOf(r3));
        L6:
            return this.a.commitText(r3, r4);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r2, int r3) {
            this.b.M();
            return this.a.deleteSurroundingText(r2, r3);
        }

        @Override // android.view.inputmethod.InputConnection
        public final boolean setComposingText(CharSequence r2, int r3) {
            this.b.M();
            return this.a.setComposingText(r2, r3);
        }
    }

    static {
    }

    public CommentEditText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommentEditText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
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
        if (this.g2 == true) goto L9;
        tt5.a.h("Comment#CommentEditText", "edit by keyboard after stopping recording, so force stop update audio text");
        this.g2 = true;
        return;
    }

    public final void N() {
        tt5.a.h("Comment#CommentEditText", "reset");
        this.Q1 = null;
        this.S1 = "";
        this.V1 = false;
        this.g2 = false;
    }

    public final void P() {
        tt5.a.h("Comment#CommentEditText", "stopUpdateAudioText");
        Q("", true, new int[2]);
        this.g2 = true;
    }

    public final ArrayList<UserInfo> getMentionUsers() {
        ArrayList<UserInfo> r0 = new ArrayList();
        Editable r1 = getText();
        if (r1 == null) goto L13;
        Editable r2 = getText();
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.length();
    L8:
        un5.l[] r5 = (un5.l[]) r1.getSpans(0, r4, un5.l.class);
        if (r5 == null) goto L13;
        int r6 = r5.length;
    L11:
        if (r3 >= r6) goto L13;
        un5.l r7 = r5[r3];
        UserInfo r8 = new UserInfo();
        r8.setUserId(r7.d);
        r8.setAvatarUrl(r7.r);
        r8.setOwnerType(1);
        r8.setUserName(r7.f);
        r8.setExternal(r7.o);
        r0.add(r8);
        r3 = r3 + 1;
        goto L11
    L7:
        r4 = 0;
    L13:
        return r0;
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
        return this.h2;
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public final boolean A(ClipData r6) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();     // Catch: Throwable -> L6
        jg5.k.a.a.d(false, true);     // Catch: Throwable -> L6
        return ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).m(r6, this.p0, new Token("LARK-PSDA-ccm_android_comment_edit_text_set_clipboard"));
    L7:
        return super.A(r6);
    }

    public final void O(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.p2 = true;
        r2.invoke();     // Catch: Throwable -> L6
        this.p2 = false;
        return;
    L6:
        th = move-exception;
        this.p2 = false;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R(boolean r10) {
        if (r10 == false) goto L9;
        String r11 = getContext().getString(2131887634);
        Context r0 = getContext();
        com.bytedance.ee.bear.middleground.comment.audio.k r1 = this.P1;
        SpannableStringBuilder r2 = new SpannableStringBuilder(r11);
        r2.append(" ");
        int r3 = r2.length();
        r2.append(" ");
        int r12 = r2.length();
        pl.droidsonroids.gif.d r6 = new pl.droidsonroids.gif.d(r0.getResources(), 2131233306);     // Catch: IOException -> L6
        r6.setCallback(r1);     // Catch: IOException -> L6
        r6.setBounds(0, 0, com.bytedance.ee.util.ui.n.f(r0, 19), com.bytedance.ee.util.ui.n.f(r0, 3));     // Catch: IOException -> L6
        r2.setSpan(new ImageSpan(r6, 1), r3, r12, 33);     // Catch: IOException -> L6
    L8:
        r2.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(2131103456)), 0, r2.length(), 33);
        CharSequence r4 = r2;
    L10:
        setHint(r4);
        return;
    L6:
        e = move-exception;
        tt5.a.e("Comment#SpannableStringUtil", "getLoadingString(): ", e, false);
        goto L8
    L9:
        r4 = this.h2;
        goto L10
    }

    public final InputConnection onCreateInputConnection(EditorInfo r2) {
        InputConnection r3 = super/*androidx.appcompat.widget.AppCompatEditText*/.onCreateInputConnection(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new b(this, r3);
    }

    public final void setOriginHint(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h2 = r2;
    }

    public CommentEditText(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.S1 = "";
        this.h2 = "";
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.docx_comment_copy_atmention_support") == false) goto L6;
        setCopyAtMentionEnable(true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q(String r9, boolean r10, int[] r11) {
        Intrinsics.checkNotNullParameter(r9, "recognizedText");
        Intrinsics.checkNotNullParameter(r11, "diffIndex");
        tt5.a.h("Comment#CommentEditText", "updateAudioText, recognizedText: " + r9.length() + ", isFinish: " + r10 + ", diffIndex: " + r11 + ", forceStopUpdate = " + this.g2);
        if (this.S1.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        if (Intrinsics.areEqual(this.S1, r9) == false) goto L12;
        if (r10 == true) goto L12;
        return;
    L12:
        if (this.g2 == false) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r9) == true) goto L18;
        this.S1 = r9;
    L18:
        if (this.P1 != null) goto L21;
        this.P1 = new com.bytedance.ee.bear.middleground.comment.audio.k(this);
    L21:
        if (this.Q1 != null) goto L23;
        Editable r12 = getText();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        this.Q1 = (SpannableStringBuilder) r12;
        String.valueOf(getText());
        this.T1 = getSelectionStart();
    L23:
        SpannableStringBuilder r13 = this.Q1;
        if (r13 == null) goto L26;
        int r14 = r13.length();
    L28:
        if (this.T1 <= r14) goto L31;
        iu5.d.a("CommentEditText", new Throwable());
        return;
    L31:
        Object[] r6 = null;
        if (getSelectionStart() == this.b2) goto L59;
        if (this.V1 == false) goto L59;
        SpannableStringBuilder r15 = this.Q1;
        if (r15 == null) goto L38;
        r6 = (ForegroundColorSpanForGray[]) r15.getSpans(0, r14, ForegroundColorSpanForGray.class);
    L38:
        if (r6 == null) goto L57;
        int r16 = r6.length;
        int r17 = 0;
    L40:
        if (r17 >= r16) goto L111;
        Object r1 = r6[r17];
        SpannableStringBuilder r2 = this.Q1;
        if (r2 == null) goto L44;
        int r3 = r2.getSpanStart(r1);
    L45:
        SpannableStringBuilder r4 = this.Q1;
        if (r4 == null) goto L48;
        int r5 = r4.getSpanEnd(r1);
    L49:
        ForegroundColorSpan r7 = new ForegroundColorSpan(getContext().getResources().getColor(2131100641));
        if (r3 < 0) goto L56;
        if (r3 >= r5) goto L56;
        if (r5 > r14) goto L56;
        SpannableStringBuilder r8 = this.Q1;
        if (r8 == null) goto L56;
        r8.setSpan(r7, r3, r5, 33);
    L56:
        r17 = r17 + 1;
        goto L40
    L48:
        r5 = 0;
        goto L49
    L44:
        r3 = 0;
        goto L45
    L111:
        return;
    L57:
        return;
    L59:
        if (this.T1 > getSelectionStart()) goto L61;
        int r18 = getSelectionStart();
    L62:
        SpannableStringBuilder r19 = this.Q1;
        if (r19 != null) goto L65;
    L70:
        SpannableStringBuilder r20 = this.Q1;
        if (r20 == null) goto L73;
        r20.replace(this.T1, r18, this.S1);
    L73:
        SpannableStringBuilder r21 = this.Q1;
        if (r21 == null) goto L79;
        if (r21 == null) goto L77;
        int r22 = r21.length();
    L78:
        r6 = (ForegroundColorSpan[]) r21.getSpans(0, r22, ForegroundColorSpan.class);
        goto L79
    L77:
        r22 = 0;
    L79:
        if (r6 == null) goto L86;
        int r23 = r6.length;
        int r24 = 0;
    L81:
        if (r24 >= r23) goto L86;
        Object r25 = r6[r24];
        SpannableStringBuilder r26 = this.Q1;
        if (r26 == null) goto L85;
        r26.removeSpan(r25);
    L85:
        r24 = r24 + 1;
    L86:
        if (r10 == false) goto L88;
        return;
    L88:
        if (r11.length != 0) goto L90;
        boolean r27 = true;
    L92:
        if ((!r27) == false) goto L94;
        int r28 = r11[0];
    L95:
        int r29 = Math.max(r28, this.S1.length() - 2);
        Context r110 = getContext();
        SpannableStringBuilder r30 = this.Q1;
        int r31 = this.T1 + r29;
        int r32 = getSelectionStart();
        int r33 = Math.max(Math.min(r31, r30.length()), 0);
        int r34 = Math.min(r32, r30.length());
        if ((r34 - r33) <= 2) goto L98;
        r33 = r34 - 2;
    L98:
        if (r34 >= r33) goto L100;
        r33 = r34;
    L100:
        r30.setSpan(new ForegroundColorSpanForGray(r110.getResources().getColor(2131103456)), r33, r34, 33);
        this.b2 = getSelectionStart();
        tt5.a.b("Comment#CommentEditText", "updateAudioText spannable: " + r30 + ", partIndex: " + r29);
        return;
    L94:
        r28 = this.S1.length();
        goto L95
    L90:
        r27 = false;
        goto L92
    L65:
        if (r18 <= r19.length()) goto L68;
        r18 = r19.length();
    L68:
        if (this.T1 <= r19.length()) goto L70;
        this.T1 = r19.length();
        goto L70
    L61:
        r18 = this.T1;
        goto L62
    L26:
        r14 = 0;
        goto L28
    L5:
        r0 = false;
        goto L6
    }

    public /* synthetic */ CommentEditText(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
