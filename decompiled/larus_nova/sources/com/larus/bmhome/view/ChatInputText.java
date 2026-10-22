package com.larus.bmhome.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.appcompat.widget.AppCompatEditText;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.input.api.EnterKeyAction;
import com.larus.bmhome.input.api.EnterKeyBehaviorServiceDelegate;
import com.larus.bmhome.social.MentionedUserInfo;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001*\u0018\u0000 Z2\u00020\u0001:\u0002Z[B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020%J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020%J\u0012\u0010,\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u000e\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\nJ0\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\n2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\n0\u001b2\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001bJ\u0010\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u0014J\u0010\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u000209H\u0002J\u001a\u0010:\u001a\u0016\u0012\u0004\u0012\u00020;\u0012\f\u0012\n\u0012\u0004\u0012\u00020=\u0018\u00010<0\u0016J\u000e\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020=J\u0006\u0010@\u001a\u00020\u000eJ\u000e\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020;J\u0018\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u0017H\u0014J\b\u0010F\u001a\u00020\u000eH\u0014J\b\u0010G\u001a\u00020\u000eH\u0014J\u000e\u0010H\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\nJ\u001a\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010KH\u0016J\u0018\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u0017H\u0002J\u0014\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\u0012\u0010S\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u00010TH\u0016J\u001a\u0010U\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010KH\u0016J\u0018\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u0017H\u0014R7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+¨\u0006\\"}, d2 = {"Lcom/larus/bmhome/view/ChatInputText;", "Landroidx/appcompat/widget/AppCompatEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "visibilityChangeCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "", "getVisibilityChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setVisibilityChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "inputMentionMediator", "Lcom/larus/bmhome/social/InputMentionMediator;", "mentionSearchAreaRange", "Lkotlin/Pair;", "", "inputIsFromActionBar", "isImeUseSendOption", "onImeHide", "Lkotlin/Function0;", "getOnImeHide", "()Lkotlin/jvm/functions/Function0;", "setOnImeHide", "(Lkotlin/jvm/functions/Function0;)V", "onEnterKeySend", "getOnEnterKeySend", "setOnEnterKeySend", "deleteSurroundingTextInterceptors", "", "Lcom/larus/bmhome/view/ChatInputText$DeleteSurroundingTextInterceptor;", "addDeleteSurroundingTextInterceptor", "interceptor", "removeDeleteSurroundingTextInterceptor", "textWatcher", "com/larus/bmhome/view/ChatInputText$textWatcher$1", "Lcom/larus/bmhome/view/ChatInputText$textWatcher$1;", "spanCountLog", "p0", "", "adjustFontSize", "isImmersive", "configCustomCopyAndSendActionMode", "enable", "needPasteAndSend", "onPasteAndSend", "setInputMentionMediator", "mediator", "mentionNotify", "event", "Lcom/larus/bmhome/social/InputMentionEvent;", "prepareContentWithMention", "", "", "Lcom/larus/bmhome/social/MentionedUserInfo;", "insertMentionSpan", "mentionedUserInfo", "clearSearchString", "clearMentionSpan", "id", "onSelectionChanged", "selStart", "selEnd", "onAttachedToWindow", "onDetachedFromWindow", "imeUseSendOption", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "sanitizeImeDeleteLength", "requestedLength", "editableLength", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDragEvent", "Landroid/view/DragEvent;", "onKeyPreIme", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "Companion", "DeleteSurroundingTextInterceptor", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInputText extends AppCompatEditText {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final hq9.f0 f315413h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f315414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Pair<Integer, Integer> f315415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f315416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f315417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f315418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<b> f315419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f315420g;

    public static final class a {
    }

    public interface b {
        boolean y9(int r100, int r101);

        boolean z9(int r100, int r101);
    }

    public static final class c extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatInputText f315421a;

        public c(InputConnection r100, ChatInputText r101) {
            this.f315421a = r101;
            super(r100, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean commitText(CharSequence r100, int r101) {
            if (r100 != null) goto L6;
            FLogger.f375446a.w("ChatInputTextLog", "commitText ignored because IME supplied null text");
            return false;
        L6:
            return super.commitText(r100, r101);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r100, int r101) {
            List<b> r102 = this.f315421a.f315419f;
            if ((r102 instanceof Collection) == true) goto L5;
        L7:
            Iterator r103 = ((ArrayList) r102).iterator();
        L9:
            if (r103.hasNext() == false) goto L13;
            if (((b) r103.next()).y9(r100, r101) == false) goto L9;
            boolean r104 = true;
        L14:
            if (r104 == false) goto L17;
            return true;
        L17:
            if (com.larus.platform.service.z2.f365865a.enableChatInputDeleteOverflowFix() == false) goto L19;
            Editable r105 = this.f315421a.getText();
            if (r105 == null) goto L23;
            int r106 = r105.length();
        L24:
            this.f315421a.getClass();
            int r107 = RangesKt.coerceIn(r100, 0, r106);
            this.f315421a.getClass();
            return super.deleteSurroundingText(r107, RangesKt.coerceIn(r101, 0, r106));
        L23:
            r106 = 0;
            goto L24
        L19:
            return super.deleteSurroundingText(r100, r101);
        L13:
            r104 = false;
            goto L14
        L5:
            if (((ArrayList) r102).isEmpty() == false) goto L7;
            goto L7
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingTextInCodePoints(int r100, int r101) {
            List<b> r102 = this.f315421a.f315419f;
            if ((r102 instanceof Collection) == true) goto L5;
        L7:
            Iterator r103 = ((ArrayList) r102).iterator();
        L9:
            if (r103.hasNext() == false) goto L13;
            if (((b) r103.next()).z9(r100, r101) == false) goto L9;
            boolean r104 = true;
        L14:
            if (r104 == false) goto L17;
            return true;
        L17:
            if (com.larus.platform.service.z2.f365865a.enableChatInputDeleteOverflowFix() == false) goto L19;
            Editable r105 = this.f315421a.getText();
            if (r105 == null) goto L23;
            int r106 = Character.codePointCount(r105, 0, r105.length());
        L24:
            this.f315421a.getClass();
            int r107 = RangesKt.coerceIn(r100, 0, r106);
            this.f315421a.getClass();
            return super.deleteSurroundingTextInCodePoints(r107, RangesKt.coerceIn(r101, 0, r106));
        L23:
            r106 = 0;
            goto L24
        L19:
            return super.deleteSurroundingTextInCodePoints(r100, r101);
        L13:
            r104 = false;
            goto L14
        L5:
            if (((ArrayList) r102).isEmpty() == false) goto L7;
            goto L7
        }
    }

    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatInputText f315422a;

        public d(ChatInputText r100) {
            this.f315422a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            g2a.d.b(r100);
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
            g2a.d.b(r100);
            if (r102 <= r103) goto L26;
            Editable r104 = this.f315422a.getText();
            if (r104 == null) goto L27;
            ChatInputText r105 = this.f315422a;
            int r106 = r102 + r101;
            if (Intrinsics.areEqual(r104.subSequence(r101, r106).toString(), "@") == false) goto L10;
            int r107 = ur8.d.f551387a;
            hq9.f0 r108 = ChatInputText.f315413h;
            r105.getClass();
            return;
        L10:
            z1[] r109 = (z1[]) r104.getSpans(r101, r106, z1.class);
            ArrayList r110 = new ArrayList();
            Intrinsics.checkNotNull(r109);
            int r111 = r109.length;
            int r112 = 0;
        L11:
            if (r112 >= r111) goto L21;
            Object r113 = r109[r112].a();
            if ((r113 instanceof MentionedUserInfo) == false) goto L15;
            MentionedUserInfo r114 = (MentionedUserInfo) r113;
        L16:
            if (r114 == null) goto L28;
            String r115 = r114.getId();
            if (r115 == null) goto L29;
            r110.add(r115);
            r112 = r112 + 1;
            goto L11
        L29:
            return;
        L28:
            return;
        L15:
            r114 = null;
            goto L16
        L21:
            new ur8.c(r110);
            hq9.f0 r116 = ChatInputText.f315413h;
            r105.getClass();
            return;
        L27:
            return;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r110, int r111, int r112, int r113) {
            g2a.d.b(r110);
            ChatInputText r100 = this.f315422a;
            hq9.f0 r101 = ChatInputText.f315413h;
            r100.getClass();
            boolean r102 = r110 instanceof Spannable;
            Pair<Integer, Integer> r103 = null;
            if (r102 == false) goto L5;
            Spannable r104 = (Spannable) r110;
        L7:
            if (r104 == null) goto L9;
            z1[] r105 = (z1[]) r104.getSpans(0, r104.length(), z1.class);
            int r106 = r104.getSpans(0, r104.length(), ForegroundColorSpan.class).length;
        L9:
            if (r102 == false) goto L11;
            Spannable r114 = (Spannable) r110;
        L12:
            if (r114 == null) goto L62;
            ChatInputText r107 = this.f315422a;
            z1[] r108 = (z1[]) r114.getSpans(0, r111, z1.class);
            Intrinsics.checkNotNull(r108);
            z1 r109 = (z1) ArraysKt.lastOrNull(r108);
            if (r109 == null) goto L16;
            int r115 = r114.getSpanEnd(r109);
        L17:
            if (r112 != 0) goto L20;
            if (r113 <= r112) goto L20;
            r111 = r111 + r113;
        L25:
            if (r115 > r111) goto L56;
            z1[] r116 = (z1[]) r114.getSpans(r115, r111, z1.class);
            if (StringsKt.startsWith$default(r114, "@", false, 2, null) == true) goto L30;
        L32:
            Intrinsics.checkNotNull(r116);
            if (r116.length != 0) goto L35;
            boolean r117 = true;
        L37:
            if ((!r117) == false) goto L39;
            this.f315422a.f315416c = true;
            goto L56
        L39:
            CharSequence r118 = r114.subSequence(r115, r111);
            int r119 = r118.length() - 1;
            if (r119 < 0) goto L50;
        L41:
            int r120 = r119 - 1;
            if (r118.charAt(r119) != '@') goto L44;
            boolean r121 = true;
        L45:
            if (r121 == true) goto L51;
            if (r120 < 0) goto L50;
            r119 = r120;
        L51:
            if (r119 == (-1)) goto L56;
            if (StringsKt.contains$default(r118.subSequence(r119, r118.length()).toString(), " ", false, 2, null) == true) goto L56;
            int r122 = r119 + r115;
            r114.subSequence(r122, r118.length() + r115).toString();
            r103 = new Pair(Integer.valueOf(r122), Integer.valueOf(r118.length() + r115));
            goto L56
        L44:
            r121 = false;
        L50:
            r119 = -1;
            goto L51
        L35:
            r117 = false;
            goto L37
        L30:
            if (StringsKt.endsWith$default(r114, " ", false, 2, null) == false) goto L32;
            ChatInputText r123 = this.f315422a;
            int r124 = ur8.d.f551387a;
            r123.getClass();
        L56:
            r107.f315415b = r103;
            if (r103 == null) goto L63;
            new ur8.e(StringsKt.removePrefix(r114.subSequence(r103.getFirst().intValue(), r103.getSecond().intValue()).toString(), "@"));
            return;
        L63:
            return;
        L20:
            if (r113 != 0) goto L23;
            if (r113 < r112) goto L25;
        L23:
            r111 = r115;
            goto L25
        L16:
            r115 = 0;
            goto L17
        L62:
            return;
        L11:
            r114 = null;
            goto L12
        L5:
            r104 = null;
            goto L7
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent r100) {
        return false;
    }

    public final void setInputMentionMediator(ur8.b r100) {
    }

    static {
        f315413h = com.larus.platform.service.z2.f365865a.chatInputOptConfig();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (f315413h.a() == false) goto L5;
        return;
    L5:
        addTextChangedListener(this.f315420g);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (f315413h.a() == false) goto L5;
        return;
    L5:
        removeTextChangedListener(this.f315420g);
    }

    public final Function0<Unit> getOnEnterKeySend() {
        return this.f315418e;
    }

    public final Function0<Unit> getOnImeHide() {
        return this.f315417d;
    }

    public final Function1<Boolean, Unit> getVisibilityChangeCallback() {
        return this.f315414a;
    }

    public ChatInputText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        InputConnection r101 = super.onCreateInputConnection(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        FLogger r102 = FLogger.f375446a;
        r102.i("ChatInputTextLog", "onCreateInputConnection");
        if (r100 == null) goto L22;
        if (r100.extras != null) goto L11;
        r100.extras = new Bundle();
    L11:
        Bundle r103 = r100.extras;
        boolean r104 = true;
        if (r103 == null) goto L15;
        r103.putBoolean("IS_DOUBAO_CHAT_EDITOR", true);
    L15:
        if (EnterKeyBehaviorServiceDelegate.f311788b.a() == EnterKeyAction.SEND) goto L18;
        r104 = false;
    L18:
        if (r104 == false) goto L20;
        r102.d("ChatInputTextLog", "before imeOptions:" + r100.imeOptions);
        r100.imeOptions = ((r100.imeOptions & (-1073741825)) & (-256)) | 4;
        r100.inputType = r100.inputType & (-131073);
        r102.d("ChatInputTextLog", "after imeOptions:" + r100.imeOptions);
        goto L22
    L20:
        r100.imeOptions = (r100.imeOptions & (-256)) | 1073741824;
    L22:
        return new c(r101, this);
    }

    public final void setOnEnterKeySend(Function0<Unit> r100) {
        this.f315418e = r100;
    }

    public final void setOnImeHide(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f315417d = r100;
    }

    public final void setVisibilityChangeCallback(Function1<? super Boolean, Unit> r100) {
        this.f315414a = r100;
    }

    public ChatInputText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f315417d = new a0();
        this.f315419f = new ArrayList();
        this.f315420g = new d(this);
        setText(null);
        if (f315413h.a() == true) goto L6;
        setEditableFactory(new v3(new NoCopySpan[]{new g4(Reflection.getOrCreateKotlinClass(z1.class))}));
        setOnKeyListener(new b0());
        return;
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        if (r100 != 66) goto L22;
        if (r101 == null) goto L22;
        if (r101.isShiftPressed() == true) goto L22;
        EnterKeyAction r102 = EnterKeyBehaviorServiceDelegate.f311788b.a();
        if (r101.isCtrlPressed() == false) goto L16;
        if (r102 == EnterKeyAction.SEND) goto L22;
        Function0<Unit> r103 = this.f315418e;
        if (r103 == null) goto L14;
        r103.invoke();
    L14:
        return true;
    L16:
        if (r102 != EnterKeyAction.SEND) goto L22;
        Function0<Unit> r104 = this.f315418e;
        if (r104 == null) goto L20;
        r104.invoke();
    L20:
        return true;
    L22:
        return super.onKeyDown(r100, r101);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int r100, KeyEvent r101) {
        if (r100 != 4) goto L12;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == false) goto L12;
        this.f315417d.invoke();
        goto L12
    L7:
        if (r101.getAction() != 1) goto L9;
        r102 = true;
    L12:
        return super.onKeyPreIme(r100, r101);
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        if (r100 == r101) goto L5;
        return;
    L5:
        Pair<Integer, Integer> r102 = this.f315415b;
        if (r102 == null) goto L11;
        if (r102.getSecond().intValue() == r101) goto L11;
        this.f315415b = null;
        int r103 = ur8.d.f551387a;
    L11:
        if (this.f315416c == false) goto L14;
        int r104 = ur8.d.f551387a;
        this.f315416c = false;
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        Function1<? super Boolean, Unit> r102 = this.f315414a;
        if (r102 == null) goto L9;
        if (r101 != 0) goto L6;
        boolean r103 = true;
    L7:
        r102.invoke(Boolean.valueOf(r103));
        return;
    L6:
        r103 = false;
        goto L7
    }
}
