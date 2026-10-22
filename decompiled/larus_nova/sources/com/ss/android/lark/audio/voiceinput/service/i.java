package com.ss.android.lark.audio.voiceinput.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.CheckChattersInChatRequest;
import com.bytedance.lark.pb.im.v1.GetAudioMessageRecognitionRequest;
import com.bytedance.lark.pb.im.v1.SendSpeechRecognitionRequest;
import com.bytedance.lark.pb.im.v1.SpeechScene;
import com.bytedance.lark.pb.media.v1.AbortUploadAudioRequest;
import com.bytedance.lark.pb.media.v1.GetUploadIdRequest;
import com.bytedance.lark.pb.media.v1.UploadAudioDataRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.audio.voiceinput.utils.VoiceUtils$abortUploadAudio$1;
import com.ss.android.lark.keyboard.plugin.tool.voice.processor.RecognizeAudioData$process$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.entity.UserSession;
import javax.inject.Inject;
import okio.ByteString;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class i implements IAudioService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f409423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UserSession f409424b;

    @Inject
    public i(k r100, UserSession r101) {
        this.f409423a = r100;
        this.f409424b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.ss.android.lark.audio.voiceinput.service.f] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final boolean e3(String r100, final String r101) {
        String r102 = this.f409424b.f438138b;
        if (TextUtils.isEmpty(r102) == true) goto L9;
        if (TextUtils.equals(r102, r101) == false) goto L9;
        return true;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        CheckChattersInChatRequest.Builder r103 = new CheckChattersInChatRequest.Builder();     // Catch: Exception -> L15
        r103.chat_id = r100;     // Catch: Exception -> L15
        r103.chatter_ids.add(r101);     // Catch: Exception -> L15
        return this.f409423a.a(r103, new f(r101));
    L15:
        e = move-exception;
        Log.e("AudioService", "syncCheckUserIsInChat", e);
        return false;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.audio.voiceinput.service.e] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final void xa(String r100, VoiceUtils$abortUploadAudio$1 r101) {
        AbortUploadAudioRequest.Builder r102 = new AbortUploadAudioRequest.Builder().source_id(r100);
        this.f409423a.f(r102, new e(), r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.audio.voiceinput.service.h] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final void S4(String r100, String r101, IGetDataCallback r102) {
        GetAudioMessageRecognitionRequest.Builder r103 = new GetAudioMessageRecognitionRequest.Builder().message_id(r100).device_locale(r101).audio_rate(16000).audio_format("opus");
        this.f409423a.e(r103, new h(), r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.ss.android.lark.audio.voiceinput.service.g] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final String ec(String r100, String r101, String r102) {
        GetUploadIdRequest.Builder r103 = new GetUploadIdRequest.Builder().chat_id(r100).file_type("").path(r101).language(r102).chat_id(r100);
        return this.f409423a.b(r103, new g());
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final void jc(String r100, int r101, byte[] r102, boolean r103, IGetDataCallback r104) {
        UploadAudioDataRequest.Builder r105 = new UploadAudioDataRequest.Builder().upload_id(r100).sequence_id(Integer.valueOf(r101)).data(ByteString.of(r102)).need_recognize(Boolean.FALSE).finish(Boolean.valueOf(r103));
        this.f409423a.d(r105, r104);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final void Oc(String r110, int r111, String r112, String r113, byte[] r210, int r211, String r212, boolean r213, boolean r214, boolean r215, boolean r216, RecognizeAudioData$process$1 r217) {
        Jb(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, null, false, r217);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final void Jb(String r100, int r101, String r102, String r103, byte[] r104, int r105, String r106, boolean r107, boolean r110, boolean r111, boolean r112, SpeechScene r113, boolean r114, IGetDataCallback r115) {
        SendSpeechRecognitionRequest.Builder r108 = new SendSpeechRecognitionRequest.Builder().source_id(r100).sequence_id(Integer.valueOf(r101)).device_locale(r102).speech_locale(r103).audio_data(ByteString.of(r104)).action(SendSpeechRecognitionRequest.Action.fromValue(r105)).audio_rate(16000).audio_format("opus").should_diff_result(Boolean.TRUE).chat_id(r106).upload_audio(Boolean.valueOf(r107)).push_response(Boolean.valueOf(r110)).enable_ner(Boolean.valueOf(r111)).enable_format(Boolean.valueOf(r112)).enable_markdown(Boolean.valueOf(r114));
        if (r113 == null) goto L5;
        r108.speech_scene(r113);
    L5:
        this.f409423a.c(r108, r115);
    }
}
