package com.ss.android.lark.chat.api.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.MessageSource;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.TranslateMessageUrlPreviewsRequest;
import com.bytedance.lark.pb.basic.v1.TranslateUrlPreviewContext;
import com.bytedance.lark.pb.im.v1.GetTranslateLanguagesRequest;
import com.bytedance.lark.pb.im.v1.SetAutoTranslateGlobalSwitchRequest;
import com.bytedance.lark.pb.im.v1.SetTranslateLanguageRequest;
import com.bytedance.lark.pb.im.v1.TranslateMessageContext;
import com.bytedance.lark.pb.im.v1.TranslateMessagesV3Request;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class TranslateService implements ITranslateService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nyb.b f411564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t0 f411565b;

    @Inject
    public TranslateService(t0 r100) {
        this.f411564a = new nyb.b();
        this.f411565b = r100;
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void getTranslateLanguages(IGetDataCallback r100) {
        s9(SyncDataStrategy.FORCE_SERVER, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.chat.api.service.impl.c2] */
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
    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void L4(String r100, final IGetDataCallback<Boolean> r101) {
        SetTranslateLanguageRequest.Builder r102 = new SetTranslateLanguageRequest.Builder().language(r100);
        this.f411565b.a(r102, new c2(), new AnonymousClass2(this, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.chat.api.service.impl.b2] */
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
    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void cb(boolean r100, IGetDataCallback<Boolean> r101) {
        SetAutoTranslateGlobalSwitchRequest.Builder r102 = new SetAutoTranslateGlobalSwitchRequest.Builder().is_open(Boolean.valueOf(r100));
        this.f411565b.e(r102, new b2(), r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.chat.api.service.impl.f2] */
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
    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void s9(SyncDataStrategy r100, final IGetDataCallback<TranslateLanguageSetting> r101) {
        GetTranslateLanguagesRequest.Builder r102 = new GetTranslateLanguagesRequest.Builder();
        r102.sync_data_strategy(r100);
        this.f411565b.c(r102, new f2(), new AnonymousClass1(this, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.api.service.impl.e2] */
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
    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void W4(boolean r100, Map<String, TranslateUrlPreviewContext> r101, final Map<String, Map<String, PreviewHangPoint>> r102, IGetDataCallback<Map<String, Map<String, PreviewHangPoint>>> r103) {
        HashMap r104 = (HashMap) r101;
        if (r104.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r105 = new ArrayList(r104.values());
        TranslateMessageUrlPreviewsRequest.Builder r106 = new TranslateMessageUrlPreviewsRequest.Builder().is_auto_translate(Boolean.valueOf(r100)).translate_contexts(r105);
        this.f411565b.d(r106, new e2(r102), r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.ss.android.lark.chat.api.service.impl.d2] */
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
    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void jf(List<String> r100, ITranslateService.TranslateTriggerType r101, String r110, List<MessageSource> r111, String r112, Map<String, Integer> r113, final boolean r114, IGetDataCallback<fcb.a> r115) {
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r112) == true) goto L24;
        ArrayList r102 = new ArrayList();
        final boolean r103 = false;
        int r104 = 0;
    L9:
        if (r104 >= r100.size()) goto L16;
        String r105 = (String) ListProtector.get(r100, r104);
        int r106 = r113.get(r105).intValue();
        if (r104 >= r111.size()) goto L13;
        MessageSource r107 = (MessageSource) ListProtector.get(r111, r104);
    L14:
        r102.add(new TranslateMessageContext.Builder().message_id(r105).message_source(r107).manual_target_language(r110).chat_id(r112).message_content_version(Integer.valueOf(r106)).build());
        r104 = r104 + 1;
        goto L9
    L13:
        r107 = null;
        goto L14
    L16:
        if (r101 == ITranslateService.TranslateTriggerType.AUTO) goto L18;
        r103 = true;
    L18:
        TranslateMessagesV3Request.Builder r108 = new TranslateMessagesV3Request.Builder().is_translate_by_user(Boolean.valueOf(r103)).is_from_message_update(Boolean.valueOf(r114)).translate_contexts(r102);
        this.f411565b.b(r108, new d2(this, r103, r114), r115);
        return;
    }
}
