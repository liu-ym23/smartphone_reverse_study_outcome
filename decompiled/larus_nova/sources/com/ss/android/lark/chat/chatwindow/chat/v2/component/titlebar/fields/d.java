package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v2.GetUserChatWindowFieldsRequest;
import com.bytedance.lark.pb.contact.v2.GetUserChatWindowFieldsResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class d implements com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f414400a;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<GetUserChatWindowFieldsResponse, c> f414401a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super GetUserChatWindowFieldsResponse, c> r100) {
            this.f414401a = r100;
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
            x r101 = (x) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return this.f414401a.invoke(r101.f253935c);
        }
    }

    @Inject
    public d(l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f414400a = r100;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a
    public final void a(GetUserChatWindowFieldsRequest.Builder r110, IGetDataCallback<c> r111, Function1<? super GetUserChatWindowFieldsResponse, c> r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r112, "respMapper");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, GetUserChatWindowFieldsResponse.ADAPTER, Command.GET_USER_CHAT_WINDOW_FIELDS, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(t.b(this.f414400a.h(r100).a()).map(new a(r112)), r111);
    }
}
