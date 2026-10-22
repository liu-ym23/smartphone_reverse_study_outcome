package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.lark.pb.im.v1.GenerateUrlPreviewEntityRequest;
import com.bytedance.lark.pb.im.v1.GenerateUrlPreviewEntityResponse;
import com.bytedance.lark.pb.im.v1.GetMessagePreviewsRequest;
import com.bytedance.lark.pb.im.v1.GetMessagePreviewsResponse;
import com.bytedance.lark.pb.im.v1.HideMessageUrlPreviewRequest;
import com.bytedance.lark.pb.im.v1.HideMessageUrlPreviewResponse;
import com.bytedance.lark.pb.url.v1.MGetUrlPreviewRequest;
import com.bytedance.lark.pb.url.v1.MGetUrlPreviewResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class PreviewRepositoryV2 implements a2b.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f411555a;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<GenerateUrlPreviewEntityResponse, UrlInlinePreviewEntity> f411556a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super GenerateUrlPreviewEntityResponse, UrlInlinePreviewEntity> r100) {
            this.f411556a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
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
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.lark.rustclient.api.x r101 = (com.bytedance.lark.rustclient.api.x) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return this.f411556a.invoke(r101.f253935c);
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<HideMessageUrlPreviewResponse, a2b.b> f411557a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super HideMessageUrlPreviewResponse, ? extends a2b.b> r100) {
            this.f411557a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
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
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.lark.rustclient.api.x r101 = (com.bytedance.lark.rustclient.api.x) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return this.f411557a.invoke(r101.f253935c);
        }
    }

    @Inject
    public PreviewRepositoryV2(com.bytedance.lark.rustclient.api.l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f411555a = r100;
    }

    @Override // a2b.e
    public final Pair<Map<String, Map<String, UrlCardPreviewEntity>>, LinkedHashMap<String, MessageLink>> a(GetMessagePreviewsRequest.Builder r110, final Function1<? super GetMessagePreviewsResponse, ? extends Pair<? extends Map<String, ? extends Map<String, UrlCardPreviewEntity>>, ? extends LinkedHashMap<String, MessageLink>>> r111, final Function1<? super ErrorResult, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, GetMessagePreviewsResponse.ADAPTER, Command.GET_MESSAGE_PREVIEWS, null, null, null, null, 248);
        return (Pair) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.f411555a.h(r100).execute(), new PreviewRepositoryV2$getMessagePreviews$1(r111)), new PreviewRepositoryV2$getMessagePreviews$2(r112));
    }

    @Override // a2b.e
    public final void b(GenerateUrlPreviewEntityRequest.Builder r110, Function1<? super GenerateUrlPreviewEntityResponse, UrlInlinePreviewEntity> r111, IGetDataCallback<UrlInlinePreviewEntity> r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, GenerateUrlPreviewEntityResponse.ADAPTER, Command.GENERATE_URL_PREVIEW_ENTITY, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f411555a.h(r100).a()).map(new a(r111)), r112);
    }

    @Override // a2b.e
    public final void c(HideMessageUrlPreviewRequest.Builder r110, Function1<? super HideMessageUrlPreviewResponse, ? extends a2b.b> r111, IGetDataCallback<a2b.b> r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, HideMessageUrlPreviewResponse.ADAPTER, Command.HIDE_MESSAGE_URL_PREVIEW, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f411555a.h(r100).a()).map(new b(r111)), r112);
    }

    @Override // a2b.e
    public final void d(MGetUrlPreviewRequest.Builder r110, com.ss.android.lark.sdk.h r111, PreviewService$getUrlPreViewEntityList$2 r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, MGetUrlPreviewResponse.ADAPTER, Command.MGET_URL_PREVIEW, null, r111, null, null, 216);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f411555a.h(r100).a()).map(a1.f411567a), r112);
    }
}
