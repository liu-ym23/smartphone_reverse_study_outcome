package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink.CustomLinkStrategy;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.keyboard.edittext2.list.EditorListApplier;
import com.ss.android.lark.keyboard.edittext2.utils.RichTextCopyUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/usecase/VoiceKeyboardFunctionEditText;", "Lcom/ss/android/lark/keyboard/edittext2/KeyboardFunctionEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isVoiceInputMarkdown", "", "beforeTextPaste", "handleUnSupportElement", "", "content", "Lcom/ss/android/lark/widget/richtext/RichText;", "setupListApplier", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceKeyboardFunctionEditText extends KeyboardFunctionEditText {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f430500k;

    public static final class a {
    }

    static {
    }

    public VoiceKeyboardFunctionEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VoiceKeyboardFunctionEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText
    public final boolean f() {
        ClipData r100 = RichTextCopyUtils.d(getContext());
        if (r100 != null) goto L7;
        return false;
    L7:
        return RichTextCopyUtils.h(r100, new VoiceKeyboardFunctionEditText$beforeTextPaste$1(this));
    }

    public VoiceKeyboardFunctionEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        boolean r103 = KeyboardVoiceFGUtils.g(KeyboardVoiceFGUtils.f429815a, "im.messenger.voice_input_markdown");
        this.f430500k = r103;
        if (r103 == false) goto L16;
        d(com.ss.android.lark.keyboard.edittext2.edittors.richText.a.class);
        d(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.class);
        d(com.ss.android.lark.keyboard.edittext2.edittors.richText.b.class);
        ((RichTextEditor) q(RichTextEditor.f429074t)).f429077e = true;
        if (KeyboardVoiceFGUtils.i() == false) goto L7;
        int r104 = com.ss.android.lark.keyboard.edittext2.list.b.f429157f;
        Context r105 = getContext();
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.ss.android.lark.keyboard.edittext2.list.b r106 = new com.ss.android.lark.keyboard.edittext2.list.b(getContext(), new com.ss.android.lark.keyboard.edittext2.list.b.c(-1, UIUtils.getColor(r105, R.color.ud_B500), -1.0f, 12));
    L8:
        float r107 = UIHelper.px2dp(getTextSize());
        com.ss.android.lark.keyboard.edittext2.list.b.C5095b.a r108 = new com.ss.android.lark.keyboard.edittext2.list.b.C5095b.a();
        r108.f429165a = Float.valueOf(r107);
        Integer r109 = r106.f429162e.f429164b;
        if (r109 == null) goto L11;
        r108.f429166b = Integer.valueOf(r109.intValue());
    L11:
        r106.f429162e = new com.ss.android.lark.keyboard.edittext2.list.b.C5095b(r108.f429165a, r108.f429166b);
        if (KeyboardVoiceFGUtils.i() == false) goto L14;
        EditorListApplier r110 = new com.ss.android.lark.keyboard.edittext2.list.a(this, r106);
    L15:
        r110.b();
        EditorListApplier.b r111 = new EditorListApplier.b(r110);
        Intrinsics.checkNotNullParameter(r111, "onKeyListener");
        this.f428954i.add(r111);
        goto L16
    L14:
        r110 = new EditorListApplier(this, r106);
        goto L15
    L7:
        r106 = new com.ss.android.lark.keyboard.edittext2.list.b(getContext());
    L16:
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) q(com.ss.android.lark.keyboard.edittext2.edittors.a.f428974e)).W(CollectionsKt.listOf(new VoiceAtStrategy()));
        ((eob.a) q(eob.a.f473406f)).U(CustomLinkStrategy.f428980b);
    }

    public /* synthetic */ VoiceKeyboardFunctionEditText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
