package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.audio.voiceinput.VoiceInputMode;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.coremd.span.list.ListHeadType;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SuffixAsrSpan;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0088\u00012\u00020\u0001:\u0002\u0088\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\\\u001a\u00020]H\u0002J\u0010\u0010^\u001a\u00020]2\b\u0010_\u001a\u0004\u0018\u00010`J\u0006\u0010a\u001a\u00020\u001cJ\u0010\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020eJ\u0018\u0010f\u001a\u00020]2\u0006\u0010g\u001a\u00020h2\u0006\u0010d\u001a\u00020eH\u0002J\u0018\u0010i\u001a\u00020]2\u0006\u0010g\u001a\u00020h2\u0006\u0010d\u001a\u00020eH\u0002J\b\u0010j\u001a\u00020]H\u0002J\u0010\u0010k\u001a\u00020\u001c2\u0006\u0010l\u001a\u00020\u001aH\u0002J\u0012\u0010m\u001a\u00020]2\b\b\u0002\u0010n\u001a\u00020\u001eH\u0002J\u0014\u0010o\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020908H\u0002J\b\u0010p\u001a\u00020]H\u0002J\b\u0010q\u001a\u00020]H\u0002J\b\u0010r\u001a\u00020]H\u0002J\b\u0010s\u001a\u00020]H\u0002J\b\u0010t\u001a\u00020\u001cH\u0002J\b\u0010u\u001a\u00020]H\u0002J\b\u0010v\u001a\u00020]H\u0002J\u0012\u0010w\u001a\u00020]2\b\b\u0002\u0010x\u001a\u00020\u001cH\u0002J\b\u0010y\u001a\u00020]H\u0002J\u001a\u0010z\u001a\u00020\u001c2\u0006\u0010{\u001a\u00020|2\b\u0010}\u001a\u0004\u0018\u00010~H\u0002J\u0007\u0010\u007f\u001a\u00030\u0080\u0001J\u001d\u0010\u0081\u0001\u001a\u00020]2\u0007\u0010\u0082\u0001\u001a\u00020?2\t\b\u0002\u0010\u0083\u0001\u001a\u00020#H\u0002J\u0007\u0010\u0084\u0001\u001a\u00020#J\u0012\u0010\u0085\u0001\u001a\u00020]2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010#J\u0007\u0010\u0087\u0001\u001a\u00020]R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b%\u0010 R\u000e\u0010'\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b)\u0010 R\u001b\u0010+\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0018\u001a\u0004\b,\u0010 R\u001b\u0010.\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0018\u001a\u0004\b/\u0010 R\u001b\u00101\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0018\u001a\u0004\b2\u0010 R\u001b\u00104\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0018\u001a\u0004\b5\u0010 R\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020908X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010F\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0Gj\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c`HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u0018\u001a\u0004\bP\u0010QR\u001b\u0010S\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u0018\u001a\u0004\bU\u0010VR\u000e\u0010X\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0089\u0001"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/AsrInputVoiceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", ObricActionBarTrackType.KEY_BOARD, "Lcom/ss/android/lark/keyboard/IKeyBoard;", "voiceInputDependency", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceInputDependency;", "voiceInputConfig", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceInputConfig;", "observers", "", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceKeyboardEventObserver;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/IKeyBoard;Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceInputDependency;Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceInputConfig;Ljava/util/List;Landroid/util/AttributeSet;)V", "mContext", "mKeyboard", "mImmersiveVoiceViewModel", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel;", "getMImmersiveVoiceViewModel", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel;", "mImmersiveVoiceViewModel$delegate", "Lkotlin/Lazy;", "finalAsrRichText", "Lcom/ss/android/lark/widget/richtext/RichText;", "hasEnteredAdvanceMode", "", "mHintString", "", "getMHintString", "()Ljava/lang/String;", "mHintString$delegate", "hintBeforeRecord", "", "mWaitingForVoiceHint", "getMWaitingForVoiceHint", "mWaitingForVoiceHint$delegate", "currentHint", "mPoorNetworkPrompt", "getMPoorNetworkPrompt", "mPoorNetworkPrompt$delegate", "mCountDownTips", "getMCountDownTips", "mCountDownTips$delegate", "mShortRecordTimeToast", "getMShortRecordTimeToast", "mShortRecordTimeToast$delegate", "mNetworkUnavailableToast", "getMNetworkUnavailableToast", "mNetworkUnavailableToast$delegate", "mErrorToast", "getMErrorToast", "mErrorToast$delegate", "mTextBeforeRecord", "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "handler", "Landroid/os/Handler;", "isLongPress", "netUnavailable", "textLengthBeforeRecord", "", "loadingToastImpl", "Lcom/larksuite/component/universe_design/toast/UDToastImpl;", "recordStartTime", "", "punctuation", "punctuationRichText", "mSessionInterceptedSendMsg", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "overtimePrompt", "Landroid/widget/TextView;", "lastRecognizeResult", "button", "Landroid/widget/ImageButton;", "mVibrator", "Landroid/os/Vibrator;", "getMVibrator", "()Landroid/os/Vibrator;", "mVibrator$delegate", "longPressRunnable", "Ljava/lang/Runnable;", "getLongPressRunnable", "()Ljava/lang/Runnable;", "longPressRunnable$delegate", "loadingToast", "cancelLoadingToast", "mTouchThroughView", "Landroid/widget/FrameLayout;", "initView", "", "applyCustomMainButton", "buttonConfig", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/AdvanceVoiceButtonConfig;", "shouldInterceptSendMsg", "getEditorAndUpdateTarget", "Lcom/ss/android/lark/keyboard/edittext2/widget/RichTextFunctionEditText;", "richTextEditor", "Lcom/ss/android/lark/keyboard/edittext2/edittors/richText/RichTextEditor;", "asrResultRichTextCallBackLegacy", "asrResult", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/AsrRichTextResult;", "asrResultRichTextCallBack", "initObserver", "isRichTextEmpty", "richText", "showHintTextWithDot", "hintText", "getTwoPartsBeforeRecord", "onClickedRunnable", "afterLongPressed", "stopASRAndRecordIfNeed", "actionUpOrCancel", "triggerVoiceRecordOnLongPressed", "stopPlayingAudioMessage", "stopRecordAfterLongPressed", "resetViewModelState", "isClearVoiceDataAll", "vibrate", "checkTouchInSendButton", "event", "Landroid/view/MotionEvent;", PickerReporterConstants.KEY.TARGET, "Landroid/view/View;", "getTouchListener", "Landroid/view/View$OnTouchListener;", "showToastWithIcon", "iconSrc", "toastText", "getCurrentHint", "putCurrentHint", "hint", "whenAdvanceModeSend", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsrInputVoiceView extends ConstraintLayout {
    public ImageButton A;
    public final Lazy B;
    public final Lazy C;
    public final n D;
    public final d E;
    public final FrameLayout F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f430064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f430065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<z> f430066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f430067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.b f430068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f430069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f430070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f430071h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f430072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f430073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f430074k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f430075l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f430076m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f430077n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f430078o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f430079p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Pair<? extends SpannableStringBuilder, ? extends SpannableStringBuilder> f430080q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Handler f430081r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f430082s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f430083t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f430084u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.larksuite.component.universe_design.toast.c f430085v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f430086w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public RichText f430087x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashMap<String, Boolean> f430088y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TextView f430089z;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsrInputVoiceView f430090a;

        public b(AsrInputVoiceView r100) {
            this.f430090a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            if (r102 == 0) goto L31;
            if (r102 != 1) goto L6;
            ViewParent r103 = r100.getParent();
            if (r103 == null) goto L18;
            r103.requestDisallowInterceptTouchEvent(false);
        L18:
            AsrInputVoiceView r104 = this.f430090a;
            if (r104.f430082s == false) goto L22;
            Log.i("AsrInputVoiceView", "action_up, afterLongPressed");
            AsrInputVoiceView.S5(this.f430090a);
        L30:
            AsrInputVoiceView.R5(this.f430090a);
            this.f430090a.f430082s = false;
        L46:
            return true;
        L22:
            if (r104.f430083t == true) goto L30;
            Log.i("AsrInputVoiceView", "action_up, onClick");
            AsrInputVoiceView r105 = this.f430090a;
            r105.f430068e.v().a(ImmersiveVoiceInputComponent.f430093a, true);
            if (r105.f430068e.z().y() == false) goto L27;
            r105.f430068e.z().g();
        L27:
            if (r105.f430068e.z().B() == false) goto L29;
            r105.f430068e.z().a();
        L29:
            r100.performClick();
            goto L30
        L6:
            if (r102 != 3) goto L46;
            ViewParent r106 = r100.getParent();
            if (r106 == null) goto L12;
            r106.requestDisallowInterceptTouchEvent(false);
        L12:
            if (this.f430090a.f430082s == false) goto L14;
            Log.i("AsrInputVoiceView", "action_cancel");
            AsrInputVoiceView.S5(this.f430090a);
        L14:
            AsrInputVoiceView.R5(this.f430090a);
            this.f430090a.f430082s = false;
            goto L46
        L31:
            Log.i("AsrInputVoiceView", "action_down");
            ViewParent r107 = r100.getParent();
            if (r107 == null) goto L34;
            r107.requestDisallowInterceptTouchEvent(true);
        L34:
            AsrInputVoiceView r108 = this.f430090a;
            r108.f430082s = false;
            r108.f430083t = false;
            r108.f430084u = 0;
            if (Intrinsics.areEqual("", r108.f430072i) == false) goto L37;
            AsrInputVoiceView r109 = this.f430090a;
            r109.f430072i = r109.f430068e.L().c().getHint();
        L37:
            int r110 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
            if (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.h() == false) goto L41;
            Log.i("AsrInputVoiceView", "onActionDown / Network unavailable");
            AsrInputVoiceView r111 = this.f430090a;
            r111.f430083t = true;
            AsrInputVoiceView.C6(r111, AsrInputVoiceView.i6(r111));
            return true;
        L41:
            Iterator<T> r112 = this.f430090a.f430066c.iterator();
        L43:
            if (r112.hasNext() == false) goto L45;
            ((z) r112.next()).b();
            goto L43
        L45:
            AsrInputVoiceView r113 = this.f430090a;
            AsrInputVoiceView.u6(r113, !r113.f430070g);
            AsrInputVoiceView r114 = this.f430090a;
            System.currentTimeMillis();
            r114.getClass();
            AsrInputVoiceView r115 = this.f430090a;
            r115.f430081r.postDelayed(AsrInputVoiceView.V5(r115), 300);
            goto L46
        }
    }

    static {
    }

    public AsrInputVoiceView() {
        throw null;
    }

    private final Runnable getLongPressRunnable() {
        return (Runnable) this.C.getValue();
    }

    private final String getMCountDownTips() {
        return (String) this.f430076m.getValue();
    }

    private final String getMErrorToast() {
        return (String) this.f430079p.getValue();
    }

    private final String getMHintString() {
        return (String) this.f430071h.getValue();
    }

    private final ImmersiveVoiceViewModel getMImmersiveVoiceViewModel() {
        return (ImmersiveVoiceViewModel) this.f430069f.getValue();
    }

    private final String getMNetworkUnavailableToast() {
        return (String) this.f430078o.getValue();
    }

    private final String getMPoorNetworkPrompt() {
        return (String) this.f430075l.getValue();
    }

    private final String getMShortRecordTimeToast() {
        return (String) this.f430077n.getValue();
    }

    private final Vibrator getMVibrator() {
        return (Vibrator) this.B.getValue();
    }

    private final String getMWaitingForVoiceHint() {
        return (String) this.f430073j.getValue();
    }

    private final Pair<SpannableStringBuilder, SpannableStringBuilder> getTwoPartsBeforeRecord() {
        EditText r100 = this.f430068e.L().c();
        r100.setKeepScreenOn(true);
        this.f430084u = r100.getText().length();
        if (r100.hasFocus() == false) goto L5;
        r100.clearFocus();
    L5:
        int r101 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
        Pair r102 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.l(new SpannableStringBuilder(r100.getText()), r100.getSelectionEnd());
        SpannableStringBuilder r103 = new SpannableStringBuilder((CharSequence) r102.getFirst());
        SpannableStringBuilder r104 = new SpannableStringBuilder((CharSequence) r102.getSecond());
        Lazy r105 = SpannableStringUtils.f429999a;
        SpannableStringUtils.c(r103);
        SpannableStringUtils.c(r104);
        if (getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L8;
        this.f430087x = getMImmersiveVoiceViewModel().addPeriodForRichTextIfNeed(r100.getText().toString(), r100.getSelectionEnd());
    L9:
        Log.i("AsrInputVoiceView", "kbEditText.selectionEnd = " + r100.getSelectionEnd() + " mFirstPartOfContent = " + r103.length() + " mLastPartOfContent = " + r104.length() + " punctuation = " + this.f430086w);
        return TuplesKt.to(r103, r104);
    L8:
        this.f430086w = getMImmersiveVoiceViewModel().addPeriodIfNeed(r100.getText().toString(), r100.getSelectionEnd());
        goto L9
    }

    public final CharSequence getCurrentHint() {
        Log.i("AsrInputVoiceView", " get current hint: " + this.f430074k.length());
        return this.f430074k;
    }

    public final View.OnTouchListener getTouchListener() {
        return new b(this);
    }

    public static final boolean H6(AsrInputVoiceView r100) {
        r100.getMImmersiveVoiceViewModel().setMaxRecordTime(AudioRecordSettings.c().getAudioToText().getAudio2TextMaxDuration());
        r100.getMImmersiveVoiceViewModel().switch2VoiceAsr();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Map<String, com.ss.android.lark.audio.f> r102 = com.ss.android.lark.audio.f.f408976e;     // Catch: Throwable -> L9
        Context r103 = r100.getContext();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L9
        com.ss.android.lark.audio.f r104 = (com.ss.android.lark.audio.f) ((ConcurrentHashMap) com.ss.android.lark.audio.f.f408976e).get(r103.toString());     // Catch: Throwable -> L9
        if (r104 == null) goto L6;
        r104.d();     // Catch: Throwable -> L9
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L9
    L11:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L14;
        Log.e("AsrInputVoiceView", "stop playing audio message failed", r107);
    L14:
        VoiceInputMode r108 = VoiceInputMode.OnlyAsr;
        VoiceInputScene r109 = VoiceInputScene.AdvancedMode;
        com.ss.android.lark.audio.voiceinput.p r110 = new com.ss.android.lark.audio.voiceinput.p(r108, r109);
        EditText r111 = r100.f430068e.L().c();
        if ((r111 instanceof RichTextFunctionEditText) == false) goto L17;
        RichTextFunctionEditText r112 = (RichTextFunctionEditText) r111;
    L18:
        String r113 = com.ss.android.lark.keyboard.plugin.tool.voice.utils.c.a(r112);
        if (r100.f430070g == false) goto L21;
        r110 = new com.ss.android.lark.audio.voiceinput.p(VoiceInputMode.SecondVoice, r109);
        r100.getMImmersiveVoiceViewModel().setBeforeVoiceEditAsrResult(r113);
    L22:
        ImmersiveVoiceViewModel r114 = r100.getMImmersiveVoiceViewModel();
        int r115 = AudioAsrLanguageSwitcher.f429841i;
        if (r114.startVoiceRecord(r110, AudioAsrLanguageSwitcher.a.a(), r113) == true) goto L25;
        return false;
    L25:
        r100.getMImmersiveVoiceViewModel().whenVoiceInputStart();
        Log.i("AsrInputVoiceView", "startVoiceRecord");
        return true;
    L21:
        r100.getMImmersiveVoiceViewModel().setBeforeVoiceEditAsrResult(null);
        goto L22
    L17:
        r112 = null;
        goto L18
    L6:
        r105 = null;
    L9:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final void N6(AsrInputVoiceView r100) {
        r100.getMVibrator().vibrate(50);
    }

    public static final void R5(AsrInputVoiceView r100) {
        r100.getMImmersiveVoiceViewModel().whenReleaseOrCancelTouch();
        r100.f430081r.removeCallbacks(r100.getLongPressRunnable());
        r100.f430081r.removeCallbacks(r100.D);
        r100.f430081r.post(r100.E);
        TextView r101 = r100.f430089z;
        TextView r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("overtimePrompt");
        r101 = null;
    L6:
        if (r101.getVisibility() != 0) goto L13;
        TextView r103 = r100.f430089z;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("overtimePrompt");
    L11:
        r102.setVisibility(8);
        return;
    L10:
        r102 = r103;
        goto L11
    }

    public static final void S5(AsrInputVoiceView r100) {
        com.ss.android.lark.keyboard.keyboard2.d r101 = r100.f430068e.H();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.OverlayKeyboardMenu");
        ((com.ss.android.lark.keyboard.keyboard2.n) r101).a(null);
        r100.f430068e.v().e().l();
        Iterator<T> r102 = r100.f430066c.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((z) r102.next()).a();
        goto L4
    L6:
        r100.getMImmersiveVoiceViewModel().whenReleaseOrCancelTouch();
        r100.f430068e.L().c();
        boolean r103 = false;
        r100.setKeepScreenOn(false);
        if (r100.f430068e.z().y() == true) goto L9;
        r100.f430068e.z().z();
    L9:
        EditText r104 = r100.f430068e.L().c();
        if (r100.getMImmersiveVoiceViewModel().isAsrSessionRunning() == false) goto L20;
        Editable r105 = r104.getText();
        if (r105 != null) goto L14;
    L15:
        r103 = true;
    L16:
        if (r103 == false) goto L21;
        r100.f7("");
        return;
    L21:
        return;
    L14:
        if (r105.length() != 0) goto L16;
    }

    public static final /* synthetic */ Runnable V5(AsrInputVoiceView r100) {
        return r100.getLongPressRunnable();
    }

    public static boolean W6(RichText r100) {
        if (r100.getElements() != null) goto L5;
    L10:
        return true;
    L5:
        if (CollectionUtils.isEmpty(r100.getElements().getDictionary()) == true) goto L10;
        if (CollectionUtils.isEmpty(r100.getElementIds()) == true) goto L10;
        return false;
    }

    public static final /* synthetic */ String Y5(AsrInputVoiceView r100) {
        return r100.getMCountDownTips();
    }

    public static final /* synthetic */ String Z5(AsrInputVoiceView r100) {
        return r100.getMErrorToast();
    }

    public static final /* synthetic */ String b6(AsrInputVoiceView r100) {
        return r100.getMHintString();
    }

    public static final /* synthetic */ ImmersiveVoiceViewModel c6(AsrInputVoiceView r100) {
        return r100.getMImmersiveVoiceViewModel();
    }

    public static final /* synthetic */ String i6(AsrInputVoiceView r100) {
        return r100.getMNetworkUnavailableToast();
    }

    public static final /* synthetic */ String k6(AsrInputVoiceView r100) {
        return r100.getMPoorNetworkPrompt();
    }

    public static final /* synthetic */ String n6(AsrInputVoiceView r100) {
        return r100.getMShortRecordTimeToast();
    }

    public static final /* synthetic */ String o6(AsrInputVoiceView r100) {
        return r100.getMWaitingForVoiceHint();
    }

    public static final /* synthetic */ Pair s6(AsrInputVoiceView r100) {
        return r100.getTwoPartsBeforeRecord();
    }

    public final RichTextFunctionEditText V6(m r100) {
        Intrinsics.checkNotNullParameter(r100, "richTextEditor");
        EditText r101 = this.f430068e.L().c();
        if ((r101 instanceof RichTextFunctionEditText) == false) goto L5;
        RichTextFunctionEditText r102 = (RichTextFunctionEditText) r101;
    L6:
        if (r102 == null) goto L8;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f428958a = r102;
    L8:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public final void f7(String r100) {
        EditText r101 = this.f430068e.L().c();
        Lazy r102 = SpannableStringUtils.f429999a;
        SpannableStringBuilder r103 = SpannableStringUtils.a(getContext(), new SpannableStringBuilder(r100), new SpannableStringUtils.a(r101), null);
        int r104 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
        r103.setSpan(new ForegroundColorSpan(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.c(this, R.color.lkui_N500)), 0, r103.length(), 33);
        r101.setHint(r103);
        this.f430074k = r103;
        Log.i("AsrInputVoiceView", "current hint: " + this.f430074k.length());
    }

    public static final void C6(AsrInputVoiceView r100, CharSequence r101) {
        int r102 = com.ss.android.lark.c.a(r100.f430068e) + UIUtils.dp2px(r100.f430067d, 30.0f);
        Context r103 = r100.getContext();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        FlowToast.a r104 = FlowToast.a(r103);
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r101, "value");
        r104.f417628b = r101;
        r104.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r103, R.drawable.ud_icon_info_outlined));
        r104.c(80, 0, r102);
        r104.a().show();
    }

    public static final void u6(AsrInputVoiceView r100, boolean r101) {
        ImmersiveVoiceViewModel r102 = r100.getMImmersiveVoiceViewModel();
        r102.updateVoiceStateIfNeed(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.j());
        r102.resetLiveData(r101);
    }

    public static final void T5(final AsrInputVoiceView r110, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c r111, m r112) {
        r110.getClass();
        RichText r100 = r111.f430368a;
        SpannableStringBuilder r101 = r111.f430369b;
        String r102 = r111.f430372e;
        Boolean r103 = r111.f430371d;
        if (r103 == null) goto L5;
        boolean r104 = r103.booleanValue();
    L6:
        boolean r113 = r111.f430370c;
        final SpannableStringBuilder r114 = new SpannableStringBuilder();
        final RichTextFunctionEditText r105 = r110.V6(r112);
        if (r105 == null) goto L73;
        Pair<Integer, Integer> r106 = r110.getMImmersiveVoiceViewModel().getBeforeInsertSelectionV2().getValue();
        if (r106 != null) goto L11;
        r106 = new Pair(0, 0);
    L11:
        final Pair<Integer, Integer> r107 = r106;
        SpannableStringBuilder r108 = new SpannableStringBuilder();
        RichTextEditor r115 = r112;
        if (r110.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L14;
        r115 = (RichTextEditor) r105.q(RichTextEditor.f429074t);
    L14:
        r115.R(r100, r108);
        Character r109 = StringsKt.lastOrNull(r108);
        int r116 = 1;
        if (r109 != null) goto L18;
    L20:
        if (r113 == true) goto L25;
        if (r110.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L25;
        Lazy r117 = SpannableStringUtils.f429999a;
        SpannableStringUtils.e(r108, r102, new SuffixAsrSpan(UIUtils.getColor(r110.getContext(), R.color.ud_N900_40)));
    L25:
        if (r110.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == true) goto L27;
        r114.append(r110.f430086w);
    L38:
        if (r110.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L51;
        if (r104 == false) goto L51;
        if (r110.f430080q.getFirst().length() != 0) goto L43;
        boolean r118 = true;
    L44:
        if (r118 == true) goto L51;
        Character r119 = StringsKt.lastOrNull(r110.f430080q.getFirst());
        if (r119 != null) goto L49;
    L50:
        r114.append("\n");
        goto L51
    L49:
        if (r119.charValue() == '\n') goto L51;
    L43:
        r118 = false;
    L51:
        y9b.a[] r120 = (y9b.a[]) r108.getSpans(0, r108.length(), y9b.a.class);
        if (r120.length != 0) goto L54;
        boolean r121 = true;
    L56:
        if (r121 == false) goto L58;
        y9b.a r122 = null;
    L68:
        if (r122 == null) goto L70;
        r122.g(ListHeadType.VirtualHead);
    L70:
        r114.append(r108);
        r114.append(StringsKt.trim(r101));
        Lazy r123 = SpannableStringUtils.f429999a;
        SpannableStringUtils.a(r110.f430067d, r114, null, null);
        final p r124 = new p();
        r114.setSpan(r124, 0, r114.length(), 33);
        sob.c.d(r110, "updateAsrResult", new AsrInputVoiceView$asrResultRichTextCallBack$1$3(r105, r107, r114, r124, r110));
        Log.i("AsrInputVoiceView", "resultSpan: " + r114.length() + ", mTextBeforeRecord.first " + r110.f430080q.getFirst().length() + " mTextBeforeRecord.second: " + r110.f430080q.getSecond().length());
        return;
    L58:
        r122 = r120[0];
        int r125 = ArraysKt.getLastIndex(r120);
        if (r125 == 0) goto L68;
        int r126 = r108.getSpanStart(r122);
        if (1 > r125) goto L68;
    L63:
        y9b.a r127 = r120[r116];
        int r128 = r108.getSpanStart(r127);
        if (r126 <= r128) goto L66;
        r122 = r127;
        r126 = r128;
    L66:
        if (r116 == r125) goto L68;
        r116 = r116 + 1;
        goto L63
    L54:
        r121 = false;
        goto L56
    L27:
        if (W6(r100) == false) goto L34;
        if (StringsKt.trim(r101).length() != 0) goto L31;
        boolean r129 = true;
    L32:
        if (r129 == true) goto L38;
    L31:
        r129 = false;
    L34:
        if (com.ss.android.lark.widget.richtext.i.l(r110.f430087x) == true) goto L38;
        SpannableStringBuilder r130 = new SpannableStringBuilder();
        r115.R(r110.f430087x, r130);
        r114.append(r130);
        goto L38
    L18:
        if (r109.charValue() != '\n') goto L20;
        r108.delete(r108.length() - 1, r108.length());
        goto L20
    L73:
        return;
    L5:
        r104 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v16, types: [T, android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, android.text.SpannableStringBuilder] */
    public static final void U5(final AsrInputVoiceView r110, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c r111, m r112) {
        r110.getClass();
        RichText r100 = r111.f430368a;
        SpannableStringBuilder r101 = r111.f430369b;
        String r102 = r111.f430372e;
        Boolean r103 = r111.f430371d;
        boolean r104 = false;
        if (r103 == null) goto L5;
        boolean r105 = r103.booleanValue();
    L6:
        boolean r113 = r111.f430370c;
        final Ref.ObjectRef r106 = new Ref.ObjectRef();
        r106.element = new SpannableStringBuilder();
        final RichTextFunctionEditText r107 = r110.V6(r112);
        if (r107 == null) goto L49;
        SpannableStringBuilder r108 = new SpannableStringBuilder();
        RichTextEditor r114 = r112;
        if (r110.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L11;
        r114 = (RichTextEditor) r107.q(RichTextEditor.f429074t);
    L11:
        r114.R(r100, r108);
        Character r109 = StringsKt.lastOrNull(r108);
        if (r109 != null) goto L15;
    L17:
        if (r113 == false) goto L19;
    L21:
        ((SpannableStringBuilder) r106.element).append(r110.f430080q.getFirst());
        if (r110.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == true) goto L24;
        ((SpannableStringBuilder) r106.element).append(r110.f430086w);
    L35:
        if (r110.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L47;
        if (r105 == false) goto L47;
        if (r110.f430080q.getFirst().length() != 0) goto L40;
        r104 = true;
    L40:
        if (r104 == true) goto L47;
        Character r115 = StringsKt.lastOrNull(r110.f430080q.getFirst());
        if (r115 != null) goto L45;
    L46:
        ((SpannableStringBuilder) r106.element).append("\n");
        goto L47
    L45:
        if (r115.charValue() != '\n') goto L46;
    L47:
        ((SpannableStringBuilder) r106.element).append(r108);
        ((SpannableStringBuilder) r106.element).append(StringsKt.trim(r101));
        Lazy r116 = SpannableStringUtils.f429999a;
        ?? r117 = SpannableStringUtils.a(r110.f430067d, (SpannableStringBuilder) r106.element, null, null);
        r106.element = r117;
        r117.append(r110.f430080q.getSecond());
        sob.c.d(r110, "updateAsrResult", new AsrInputVoiceView$asrResultRichTextCallBackLegacy$1$1(r107, r106, r110));
        Log.i("AsrInputVoiceView", "resultSpan: " + ((SpannableStringBuilder) r106.element).length() + ", mTextBeforeRecord.first " + r110.f430080q.getFirst().length() + " mTextBeforeRecord.second: " + r110.f430080q.getSecond().length());
        return;
    L24:
        if (W6(r100) == false) goto L31;
        if (StringsKt.trim(r101).length() != 0) goto L28;
        boolean r118 = true;
    L29:
        if (r118 == true) goto L35;
    L28:
        r118 = false;
    L31:
        if (com.ss.android.lark.widget.richtext.i.l(r110.f430087x) == true) goto L35;
        SpannableStringBuilder r119 = new SpannableStringBuilder();
        r114.R(r110.f430087x, r119);
        ((SpannableStringBuilder) r106.element).append(r119);
        goto L35
    L19:
        if (r110.getMImmersiveVoiceViewModel().isVoiceInputMarkdownFg() == false) goto L21;
        Lazy r120 = SpannableStringUtils.f429999a;
        SpannableStringUtils.e(r108, r102, new SuffixAsrSpan(UIUtils.getColor(r110.getContext(), R.color.ud_N900_40)));
        goto L21
    L15:
        if (r109.charValue() != '\n') goto L17;
        r108.delete(r108.length() - 1, r108.length());
        goto L17
    L49:
        return;
    L5:
        r105 = false;
        goto L6
    }

    public AsrInputVoiceView(final Context r100, com.ss.android.lark.keyboard.b r101, x r102, w r103, List r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, ObricActionBarTrackType.KEY_BOARD);
        Intrinsics.checkNotNullParameter(r102, "voiceInputDependency");
        Intrinsics.checkNotNullParameter(r103, "voiceInputConfig");
        Intrinsics.checkNotNullParameter(r104, "observers");
        super(r100, null);
        this.f430064a = r102;
        this.f430065b = r103;
        this.f430066c = r104;
        this.f430067d = r100;
        this.f430068e = r101;
        this.f430069f = LazyKt.lazy(new AsrInputVoiceView$mImmersiveVoiceViewModel$2(this, r100));
        this.f430071h = LazyKt.lazy(new AsrInputVoiceView$mHintString$2(this));
        this.f430072i = "";
        this.f430073j = LazyKt.lazy(new AsrInputVoiceView$mWaitingForVoiceHint$2(this));
        this.f430074k = "";
        this.f430075l = LazyKt.lazy(new AsrInputVoiceView$mPoorNetworkPrompt$2(this));
        this.f430076m = LazyKt.lazy(new AsrInputVoiceView$mCountDownTips$2(this));
        this.f430077n = LazyKt.lazy(new AsrInputVoiceView$mShortRecordTimeToast$2(this));
        this.f430078o = LazyKt.lazy(new AsrInputVoiceView$mNetworkUnavailableToast$2(this));
        this.f430079p = LazyKt.lazy(new AsrInputVoiceView$mErrorToast$2(this));
        this.f430080q = new Pair(new SpannableStringBuilder(), new SpannableStringBuilder());
        this.f430081r = new Handler(Looper.getMainLooper());
        this.f430086w = "";
        this.f430087x = new RichText();
        this.f430088y = new HashMap();
        this.B = LazyKt.lazy(new AsrInputVoiceView$mVibrator$2(this));
        this.C = LazyKt.lazy(new AsrInputVoiceView$longPressRunnable$2(this));
        this.D = new n(this, r100);
        this.E = new d(this);
        FrameLayout r105 = new FrameLayout(r100);
        r105.setVisibility(8);
        r105.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        r105.setAlpha(0.0f);
        r105.setOnTouchListener(new o(this, r105));
        this.F = r105;
        LayoutInflater.from(r100).inflate(R.layout.layout_immersive_voive_popup_view_simple, this, true);
        if (h18.f.a(getContext()) == false) goto L5;
        int r106 = UIUtils.getColor(getContext(), R.color.advanced_voice_button_background_night);
    L6:
        this.f430089z = (TextView) findViewById(R.id.prompt_word);
        this.A = (ImageButton) findViewById(R.id.audio_with_text_popup_view_main_button);
        GradientDrawable r107 = new GradientDrawable();
        r107.setShape(0);
        r107.setColor(r106);
        r107.setCornerRadius(UIUtils.dp2px(r100, 10));
        ImageButton r108 = this.A;
        if (r108 == null) goto L9;
        r108.setBackground(r107);
    L9:
        Fragment r109 = r101.l().f429560d;
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        m r110 = new m();
        V6(r110);
        ImmersiveVoiceViewModel r111 = getMImmersiveVoiceViewModel();
        r111.getAudioAsrResult().observe(r109, new e(this, r110, r111));
        r111.getAsrResultRichText().observe(r109, new f(this, r110));
        r111.isRecordHardWareReady().observe(r109, new g(this, r111));
        r111.isAsrRecognizeFinish().observe(r109, new h(this, r110, r111));
        r111.getShouldShowPoorNetTips().observe(r109, new i(this));
        r111.getShouldShowAsrWaitingPoorNetTips().observe(r109, new j(this));
        r111.getVoiceRecordTooShort().observe(r109, new k(this));
        r111.isElapseCountDown().observe(r109, new l(this));
        getMImmersiveVoiceViewModel().injectIGetEditTextAndSelectionDependency(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.b(this));
        getMImmersiveVoiceViewModel().injectDependency(new c(r100, this));
        Log.i("AsrInputVoiceView", "SimpleImmersiveVoiceView init over");
        return;
    L5:
        r106 = UIUtils.getColor(getContext(), R.color.advanced_voice_button_background_light);
        goto L6
    }
}
