package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.f0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.audio.voiceinput.t;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceHitPoint;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.IconWithTitleItemId;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.ItemType;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SendType;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SwitchActionItemId;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.VoiceMoreActionAdapter;
import com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioChooseLanguageDialogAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.recognition.GetSpeechConfigRequest;
import com.ss.android.lark.pb.recognition.PutSpeechConfigRequest;
import com.ss.android.lark.pb.recognition.PutSpeechConfigResponse;
import com.ss.android.lark.pb.recognition.SpeechLang;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import rob.j;
import rob.k;
import z5c.r;

/* JADX INFO: loaded from: classes36.dex */
public final class AudioAsrLanguageSwitcher {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f429841i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f429842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f429843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f429844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f429845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f429846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f429847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f429848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDDialog f429849h;

    public static final class a {
        public static String a() {
            String r100 = com.ss.android.lark.im.base.a.a().getString("user_audio_2_text_locale_server_key", null);
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L12;
            return "un_auto";
        L12:
            return r100;
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }
    }

    public interface b {
        void a(j r100);

        void b(rob.e r100);

        void c(String r100, String r101, boolean r102);

        void d(SendType r100);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f429850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<SpeechLang> f429851b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f429852c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f429853d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Boolean f429854e;

        public c() {
            this(null, null, null, null, null, 31);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f429850a, r101.f429850a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f429851b, r101.f429851b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f429852c, r101.f429852c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f429853d, r101.f429853d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f429854e, r101.f429854e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f429850a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            List<SpeechLang> r104 = this.f429851b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            List<String> r107 = this.f429852c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            List<String> r110 = this.f429853d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Boolean r113 = this.f429854e;
            if (r113 == null) goto L23;
            r101 = r113.hashCode();
        L23:
            return r112 + r101;
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "SpeechConfig(chosenLangKey=" + this.f429850a + ", supportLanguageList=" + this.f429851b + ", defaultLangKeyList=" + this.f429852c + ", defaultLangNameList=" + this.f429853d + ", enableFormat=" + this.f429854e + ')';
        }

        public c(String r100, List r101, List r102, List r103, Boolean r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r103 = null;
        L15:
            if ((r105 & 16) == 0) goto L17;
            r104 = null;
        L17:
            this.f429850a = r100;
            this.f429851b = r101;
            this.f429852c = r102;
            this.f429853d = r103;
            this.f429854e = r104;
        }
    }

    public static final class d<T> implements SdkSender.IParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f429855a = null;

        static {
            f429855a = new d();
        }

        public d() {
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            PutSpeechConfigResponse.ADAPTER.decode(r100);
            return Boolean.TRUE;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioAsrLanguageSwitcher f429856a;

        public e(AudioAsrLanguageSwitcher r100) {
            this.f429856a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f429856a.b();
        }
    }

    public static final class f implements rob.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioAsrLanguageSwitcher f429857a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f429858a = null;

            static {
                int[] r100 = new int[SendType.values().length];
                r100[SendType.VoiceWithAsr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[SendType.OnlyText.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f429858a = r100;
            }
        }

        public f(AudioAsrLanguageSwitcher r100) {
            this.f429857a = r100;
        }

        @Override // rob.d
        public final void a(rob.e r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Iterator<T> r101 = this.f429857a.f429845d.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((b) r101.next()).b(r100);
            goto L4
        L6:
            this.f429857a.b();
        }

        @Override // rob.d
        public final void b(SendType r100) {
            Intrinsics.checkNotNullParameter(r100, "sendType");
            int r101 = a.f429858a[r100.ordinal()];
            if (r101 != 1) goto L5;
            t.b().putBoolean("key_support_voice_with_asr", true);
        L10:
            Iterator r102 = ((ArrayList) this.f429857a.f429845d).iterator();
        L12:
            if (r102.hasNext() == false) goto L14;
            ((b) r102.next()).d(r100);
            goto L12
        L14:
            this.f429857a.b();
            return;
        L5:
            if (r101 != 2) goto L8;
            t.b().putBoolean("key_support_voice_with_asr", false);
            goto L10
        L8:
            throw new NoWhenBranchMatchedException();
        }

        @Override // rob.d
        public final void c(j r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            if (r100.f538820d != SwitchActionItemId.PolishVoiceInput) goto L8;
            boolean r101 = !r100.f538819c;
            Map<String, Integer> r102 = com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.f430827a;
            if (KeyboardVoiceFGUtils.a("im.messenger.voice_input_polish", null) == false) goto L8;
            LarkKVStorage.q(com.ss.android.lark.im.base.a.f425879a, true).putBoolean("user_voice_input_polish_enabled_local_key", r101);
        L8:
            Iterator r103 = ((ArrayList) this.f429857a.f429845d).iterator();
        L10:
            if (r103.hasNext() == false) goto L12;
            ((b) r103.next()).a(r100);
            goto L10
        }

        @Override // rob.d
        public final void d(rob.b r100) {
            Intrinsics.checkNotNullParameter(r100, "curChoseAsrItem");
            List<SpeechLang> r101 = this.f429857a.c().f429851b;
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L19;
            int r103 = r100.f538805a;
            if (r103 == 0) goto L18;
            if (r103 != 1) goto L14;
            com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.c("zh_ch");
            goto L19
        L14:
            if (r103 != 2) goto L19;
            com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.c("en_us");
            goto L19
        L18:
            com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.c("un_auto");
        L19:
            String r104 = r100.f538806b;
            if (r104 == null) goto L26;
            String r105 = r100.f538807c;
            if (r105 == null) goto L26;
            String r106 = r100.f538808d;
            if (r106 == null) goto L26;
            AudioAsrLanguageSwitcher.a(this.f429857a, r104, r105, r106);
            return;
        L26:
            Log.e("AudioAsrLanguageSwitcher", "invalid params chosenLanguageKey:" + r100.f538806b + ", languageKey:" + r100.f538807c + ", languageName:" + r100.f538808d);
            return;
        L5:
            if (r101.isEmpty() == true) goto L8;
            r102 = false;
            goto L9
        }
    }

    public static final class g implements AudioChooseLanguageDialogAdapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioAsrLanguageSwitcher f429859a;

        public g(AudioAsrLanguageSwitcher r100) {
            this.f429859a = r100;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioChooseLanguageDialogAdapter.a
        public final void j4(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "beforeLang");
            Intrinsics.checkNotNullParameter(r101, "newLangKey");
            Intrinsics.checkNotNullParameter(r102, "newLangName");
            AudioAsrLanguageSwitcher.a(this.f429859a, r100, r101, r102);
        }
    }

    static {
        f429841i = 1;
    }

    public final void b() {
        UDDialog r100 = this.f429849h;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
    L21:
        this.f429849h = null;
    }

    public final c c() {
        return (c) this.f429848g.getValue();
    }

    public final void d() {
        final IGetDataCallback<c> r100 = new AudioAsrLanguageSwitcher$pullSpeechConfig$1(this);
        GetSpeechConfigRequest.Builder r101 = new GetSpeechConfigRequest.Builder();
        SdkSender.sendPassThroughRequest(Command.GET_SPEECH_CONFIG, r101, new AudioAsrLanguageSwitcher$getSpeechConfig$1(r100), com.ss.android.lark.keyboard.plugin.tool.voice.audio2.a.f429924a);
    }

    public AudioAsrLanguageSwitcher(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Lazy r101 = LazyKt.lazy(new AudioAsrLanguageSwitcher$defaultAsrLangName$2(r100));
        this.f429842a = r101;
        this.f429843b = CollectionsKt.listOf(new String[]{"un_auto", "zh_ch", "en_us"});
        this.f429844c = CollectionsKt.listOf(new String[]{(String) r101.getValue(), UIHelper.getString(R.string.Lark_Chat_AudioToChinese), UIHelper.getString(R.string.Lark_Chat_AudioToEnglish)});
        this.f429845d = new ArrayList();
        this.f429846e = a.a();
        String r102 = com.ss.android.lark.im.base.a.a().getString("user_audio_2_text_locale_server_name", null);
        if (r102 != null) goto L5;
        r102 = (String) r101.getValue();
    L5:
        this.f429847f = r102;
        this.f429848g = LazyKt.lazy(new AudioAsrLanguageSwitcher$mConfig$2(this));
        d();
    }

    public final void g(String r100) {
        this.f429846e = r100;
        c().f429850a = r100;
        com.ss.android.lark.im.base.a.a().putString("user_audio_2_text_locale_server_key", r100);
    }

    public final void h(String r100) {
        this.f429847f = r100;
        com.ss.android.lark.im.base.a.a().putString("user_audio_2_text_locale_server_name", r100);
    }

    public static /* synthetic */ void f(AudioAsrLanguageSwitcher r100, String r101) {
        AudioAsrLanguageSwitcher$putSpeechConfig$1 r102 = AudioAsrLanguageSwitcher$putSpeechConfig$1.INSTANCE;
        AudioAsrLanguageSwitcher$putSpeechConfig$2 r103 = AudioAsrLanguageSwitcher$putSpeechConfig$2.INSTANCE;
        r100.getClass();
        e(r101, null, r102, r103);
    }

    public static final void a(AudioAsrLanguageSwitcher r100, String r101, String r102, String r103) {
        if (Intrinsics.areEqual(r100.f429846e, r102) == false) goto L8;
        if (Intrinsics.areEqual(r100.f429847f, r103) == false) goto L8;
        Log.i("AudioAsrLanguageSwitcher", "showSwitchLanguageDialog / User select the current option again");
        return;
    L8:
        if (StringUtils.isEmpty(r102) == true) goto L14;
        Log.i("AudioAsrLanguageSwitcher", "showSwitchLanguageDialog / User switch language, name = " + r103);
        r100.g(r102);
        r100.h(r103);
        f(r100, r100.f429846e);
        Iterator r104 = ((ArrayList) r100.f429845d).iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        ((b) r104.next()).c(r100.f429847f, r100.f429846e, false);
        goto L11
    L13:
        int r105 = KeyboardVoiceHitPoint.f429822a;
        Intrinsics.checkNotNullParameter(r101, "beforeLang");
        Intrinsics.checkNotNullParameter(r102, "newLang");
        Log.i("KeyboardVoiceHitPoint", "sendSwitchLanguageEventNew / beforeLang = " + r101 + ", newLang = " + r102);
        Statistics.sendEvent("im_voice_switch_languae_click", s5c.d.b.b(z5c.h.f570211c.a(r101), r.f570318c3.a(r102)).toJson());
        r100.b();
        return;
    L14:
        Log.w("AudioAsrLanguageSwitcher", "showSwitchLanguageDialog / User select key is empty");
    }

    public static void e(String r100, Boolean r101, final Function0 r102, final Function0 r103) {
        if (f0.a(r100) == false) goto L5;
        return;
    L5:
        PutSpeechConfigRequest.Builder r104 = new PutSpeechConfigRequest.Builder();
        int r105 = f429841i;
        f429841i = r105 + 1;
        r104.request_no(String.valueOf(r105)).manual_conf_lang(r100.toLowerCase(Locale.ROOT));
        if (r101 == null) goto L8;
        r104.enable_format(Boolean.valueOf(r101.booleanValue()));
    L8:
        r104.build();
        SdkSender.sendPassThroughRequest(Command.PUT_SPEECH_CONFIG, r104, new AudioAsrLanguageSwitcher$putSpeechConfig$4(r102, r103), d.f429855a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.util.List] */
    public final void i(Context r210, boolean r211, boolean r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r100 = LayoutInflater.from(r210).inflate(R.layout.layout_audio_dialog_new_style, null);
        RecyclerView r101 = (RecyclerView) r100.findViewById(R.id.rv_language_option);
        ((AppCompatImageView) r100.findViewById(R.id.iv_back)).setOnClickListener(new e(this));
        LinearLayoutManager r102 = new LinearLayoutManager(r210, 1, false);
        c r103 = c();
        List<SpeechLang> r104 = r103.f429851b;
        if (r104 != null) goto L5;
        r104 = new ArrayList();
    L5:
        r103.f429851b = r104;
        String r105 = r103.f429850a;
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r103.f429850a = r105;
        if (r211 == false) goto L67;
        ((AppCompatTextView) r100.findViewById(R.id.tv_title)).setText(y9c.d.h(R.string.Lark_IM_AudioMsg_MoreActions_Title));
        com.ss.android.lark.storage.kv.repo.a r106 = t.b();
        if (r106.contains("key_support_voice_with_asr") == false) goto L13;
        boolean r107 = r106.getBoolean("key_support_voice_with_asr", false);
    L17:
        VoiceMoreActionAdapter r108 = new VoiceMoreActionAdapter();
        if (r212 == false) goto L22;
        r108.y2(new rob.c(y9c.d.h(R.string.Lark_IM_AudioMsg_SendContent_Title)));
        r108.y2(new rob.h(new rob.i(SendType.OnlyText, y9c.d.h(R.string.Lark_IM_AudioMsg_SendContent_Text_MenuItem), !r107)));
        r108.y2(new rob.h(new rob.i(SendType.VoiceWithAsr, y9c.d.h(R.string.Lark_IM_AudioMsg_SendContent_AudioText_MenuItem), r107)));
        if (KeyboardVoiceFGUtils.a("im.messenger.voice_submit_feedback", null) == false) goto L22;
        r108.y2(new rob.g(ItemType.Divider, new Object()));
    L22:
        r108.y2(new rob.c(y9c.d.h(R.string.Lark_IM_AudioMsg_SelectLan_Title)));
        List<SpeechLang> r109 = c().f429851b;
        List<String> r110 = c().f429852c;
        List<String> r111 = c().f429853d;
        String r112 = c().f429850a;
        if (r112 != null) goto L25;
        r112 = "un_auto";
    L25:
        ?? r113 = new ArrayList();
        if (r109 == null) goto L31;
        Iterator r114 = r109.iterator();
        int r115 = 0;
    L29:
        if (r114.hasNext() == false) goto L33;
        SpeechLang r116 = (SpeechLang) r114.next();
        r113.add(new rob.a(new rob.b(r115, r112, r116.mlangCode, r116.mlangName)));
        r114 = r114;
        r115 = r115 + 1;
    L33:
        if ((!r113.isEmpty()) == true) goto L42;
        if (r110 == null) goto L41;
        if (r111 == null) goto L41;
        int r117 = Math.min(r110.size(), r111.size());
        int r118 = 0;
    L39:
        if (r118 >= r117) goto L42;
        r113.add(new rob.a(new rob.b(r115, r112, (String) ListProtector.get(r110, r118), (String) ListProtector.get(r111, r118))));
        r118 = r118 + 1;
        r117 = r117;
        r110 = r110;
        r115 = r115 + 1;
    L41:
        r113 = CollectionsKt.emptyList();
    L42:
        Iterator r119 = ((Iterable) r113).iterator();
    L44:
        if (r119.hasNext() == false) goto L46;
        r108.y2((rob.a) r119.next());
        goto L44
    L46:
        KeyboardVoiceFGUtils r120 = KeyboardVoiceFGUtils.f429815a;
        boolean r121 = true;
        if (AudioRecordSettings.d().getAudioNewCanRevert() != 1) goto L49;
        boolean r122 = true;
    L50:
        if (r122 == false) goto L53;
        if (r213 == false) goto L53;
    L55:
        if (KeyboardVoiceFGUtils.a("im.messenger.voice_submit_feedback", null) == true) goto L57;
        if (r121 == true) goto L57;
    L59:
        if (KeyboardVoiceFGUtils.a("im.messenger.voice_input_polish", null) == false) goto L62;
        r108.y2(new k(new j(y9c.d.h(R.string.Lark_IM_VoiceInput_AutoFormatting_Switch), com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.b(), SwitchActionItemId.PolishVoiceInput)));
        r108.y2(new rob.g(ItemType.Divider, new Object()));
    L62:
        if (KeyboardVoiceFGUtils.a("im.messenger.voice_submit_feedback", null) == false) goto L64;
        r108.y2(new rob.f(new rob.e(R.drawable.ud_icon_feedback_outlined, y9c.d.h(R.string.Lark_IM_VoiceInput_ReportIssue_Button), IconWithTitleItemId.SubmitFeedback)));
    L64:
        if (r121 == false) goto L66;
        r108.y2(new rob.f(new rob.e(R.drawable.ud_icon_switch_outlined, y9c.d.h(R.string.Lark_IM_RevertOldVoiceInput_Button), IconWithTitleItemId.RollBackAudio)));
    L66:
        f r123 = new f(this);
        Intrinsics.checkNotNullParameter(r123, "listener");
        r108.f430183b = r123;
        RecyclerView.Adapter r124 = r108;
    L68:
        r101.setAdapter(r124);
        r101.setLayoutManager(r102);
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.a r125 = new com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.a(r210);
        r125.f430058a = r100;
        UDDialog r126 = ((UDActionPanelBuilder) ((UDActionPanelBuilder) new UDActionPanelBuilder(r210).controller(r125)).marginInDp(0)).build();
        if (DialogLancet.shouldBlockDialogShow(r126) == false) goto L76;
        DialogLancet.handleBlockedDialogShow(r126);
    L73:
        this.f429849h = r126;
        return;
    L76:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L75
    L72:
        DialogLancet.beforeDialogShow(r126);
        r126.show();
        DialogLancet.afterDialogShow(r126);
    L57:
        r108.y2(new rob.g(ItemType.Divider, new Object()));
    L53:
        r121 = false;
        goto L55
    L49:
        r122 = false;
        goto L50
    L31:
        r115 = 0;
        goto L33
    L13:
        KeyboardVoiceFGUtils r127 = KeyboardVoiceFGUtils.f429815a;
        if (AudioRecordSettings.d().getAudioUpdateRecordText() != 1) goto L16;
        r107 = true;
        goto L17
    L16:
        r107 = false;
        goto L17
    L67:
        AudioChooseLanguageDialogAdapter r128 = new AudioChooseLanguageDialogAdapter(c().f429851b, c().f429852c, c().f429853d, c().f429850a);
        g r129 = new g(this);
        Intrinsics.checkNotNullParameter(r129, "l");
        r128.f430816e = r129;
        r124 = r128;
        goto L68
    }
}
