package com.ss.android.lark.voiceinput.impl.service.repository;

import b38.b;
import com.bytedance.lark.pb.voice.GetSpeechRecognitionPostProcessResultClientRequest;
import com.bytedance.lark.pb.voice.GetSpeechRecognitionPostProcessResultClientResponse;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.voiceinput.api.data.context.VoiceScene;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class VoiceRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.voiceinput.impl.service.repository.a f445126a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f445127a = null;

        static {
            int[] r100 = new int[VoiceScene.values().length];
            r100[VoiceScene.Default.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[VoiceScene.IM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[VoiceScene.DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f445127a = r100;
        }
    }

    public VoiceRepository() {
        com.ss.android.lark.voiceinput.impl.service.repository.a r100 = (com.ss.android.lark.voiceinput.impl.service.repository.a) b.f17382a.create(com.ss.android.lark.voiceinput.impl.service.repository.a.class);
        Intrinsics.checkNotNullParameter(r100, "sdkService");
        this.f445126a = r100;
    }

    public final Object a(String r100, String r101, VoiceScene r102, Continuation<? super RichText> r103) {
        if ((r103 instanceof VoiceRepository$handleSpeechRecognitionResult$1) == false) goto L7;
        VoiceRepository$handleSpeechRecognitionResult$1 r104 = (VoiceRepository$handleSpeechRecognitionResult$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
    L28:
        com.larksuite.rucket.job.base.b r109 = (com.larksuite.rucket.job.base.b) r106;
        r109.getClass();
        if ((r109 instanceof com.larksuite.rucket.job.base.b.C3939b) == true) goto L36;
        com.bytedance.lark.pb.basic.v1.RichText r110 = ((GetSpeechRecognitionPostProcessResultClientResponse) r109.b()).rich_text_result;
        if (r110 != null) goto L34;
        return null;
    L34:
        return g0.e(r110, null);
    L36:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        com.ss.android.lark.voiceinput.impl.service.repository.a r111 = this.f445126a;
        GetSpeechRecognitionPostProcessResultClientRequest.Builder r112 = new GetSpeechRecognitionPostProcessResultClientRequest.Builder().context_id(r100).recognition_text(r101);
        int r113 = a.f445127a[r102.ordinal()];
        if (r113 != 1) goto L17;
        GetSpeechRecognitionPostProcessResultClientRequest.Scene r114 = GetSpeechRecognitionPostProcessResultClientRequest.Scene.UNKNOWN_SCENE;
    L25:
        RucketJob<GetSpeechRecognitionPostProcessResultClientResponse> r115 = r111.handleSpeechRecognitionResult(r112.scene(r114).markdown_enable(Boolean.TRUE).build());
        r104.label = 1;
        r106 = r115.awaitGet(r104);
        if (r106 != r107) goto L28;
        return r107;
    L17:
        if (r113 != 2) goto L19;
        r114 = GetSpeechRecognitionPostProcessResultClientRequest.Scene.DOUBAO_IM;
        goto L25
    L19:
        if (r113 != 3) goto L22;
        r114 = GetSpeechRecognitionPostProcessResultClientRequest.Scene.DOUBAO_DOC;
        goto L25
    L22:
        throw new NoWhenBranchMatchedException();
    L7:
        r104 = new VoiceRepository$handleSpeechRecognitionResult$1(this, r103);
        goto L8
    }
}
