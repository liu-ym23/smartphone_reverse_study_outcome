package com.larus.bmhome.interactionpanel;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.thread.ThreadData;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class h1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ThreadInteractionPanelMessageSourceComponent f312351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f312352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f312353c;

    public /* synthetic */ h1(ThreadInteractionPanelMessageSourceComponent r100, String r101, List r102) {
        this.f312351a = r100;
        this.f312352b = r101;
        this.f312353c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.bmhome.interactionpanel.ThreadInteractionPanelMessageSourceComponent] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.bmhome.interactionpanel.g] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
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
    @Override // java.lang.Runnable
    public final void run() {
        ?? r100 = this.f312351a;
        String r101 = this.f312352b;
        List r102 = this.f312353c;
        ThreadData r103 = r100.f312316n;
        w r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getSourceConversationId();
    L6:
        String r106 = "";
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        if (StringsKt.isBlank(r105) == false) goto L20;
        fe8.c r107 = r100.h3();
        if (r107 == null) goto L16;
        ThreadData r108 = r107.VE();
        if (r108 == null) goto L16;
        r105 = r108.getSourceConversationId();
    L17:
        if (r105 != null) goto L20;
        r105 = "";
    L16:
        r105 = null;
    L20:
        if (StringsKt.isBlank(r105) == false) goto L27;
        fe8.a r109 = r100.Y2();
        if (r109 == null) goto L24;
        r105 = r109.K();
    L25:
        if (r105 != null) goto L27;
        r105 = "";
        goto L27
    L24:
        r105 = null;
    L27:
        ThreadData r110 = r100.f312316n;
        if (r110 == null) goto L30;
        String r111 = r110.getThreadId();
    L31:
        if (r111 != null) goto L34;
        r111 = "";
    L34:
        if (StringsKt.isBlank(r111) == false) goto L44;
        fe8.c r112 = r100.h3();
        if (r112 == null) goto L40;
        ThreadData r113 = r112.VE();
        if (r113 == null) goto L40;
        r111 = r113.getThreadId();
    L41:
        if (r111 != null) goto L44;
        r111 = "";
    L40:
        r111 = null;
    L44:
        if (StringsKt.isBlank(r111) == false) goto L51;
        fe8.a r114 = r100.Y2();
        if (r114 == null) goto L48;
        r111 = r114.Kd();
    L49:
        if (r111 != null) goto L51;
    L53:
        if (StringsKt.isBlank(r105) == false) goto L55;
    L97:
        FLogger.f375446a.w("ThreadInteractionPanelSource", "[" + r101 + "] skip sync, conversationId=" + r105 + ", threadId=" + r106);
        return;
    L55:
        if (StringsKt.isBlank(r106) == true) goto L97;
        String r115 = r100.f312317o;
        String r116 = r100.f312318p;
        boolean r117 = false;
        if (r115 != null) goto L60;
    L63:
        boolean r118 = true;
    L64:
        if (r118 == true) goto L77;
        if (r116 != null) goto L67;
    L68:
        r117 = true;
    L69:
        if (r117 == true) goto L77;
        if (Intrinsics.areEqual(r115, r105) == true) goto L74;
    L76:
        r100.f312319q = CollectionsKt.emptyList();
        r100.f312315m.i(r115, r116, CollectionsKt.emptyList(), r101 + "_thread_scope_changed");
        goto L77
    L74:
        if (Intrinsics.areEqual(r116, r106) == false) goto L76;
    L67:
        if (StringsKt.isBlank(r116) == false) goto L69;
    L77:
        boolean r119 = e.a(r102);
        if (r119 == false) goto L85;
        ?? r120 = new ArrayList();
        Iterator r121 = r102.iterator();
    L81:
        if (r121.hasNext() == false) goto L86;
        Object r122 = r121.next();
        if ((!com.larus.bmhome.chat.bean.d.j0((Message) r122)) == false) goto L81;
        r120.add(r122);
    L86:
        fe8.a r123 = r100.Y2();
        if (r123 == null) goto L89;
        r104 = r123.vF();
    L89:
        w r124 = r104;
        if (r119 == true) goto L92;
        List<o> r125 = CollectionsKt.distinct(CollectionsKt.plus(r100.f312319q, r100.p3(r105, r106, r102, r124)));
        r100.f312315m.m(r105, r106, r125, r101 + "_streaming_finished");
    L92:
        r100.f312317o = r105;
        r100.f312318p = r106;
        if (r119 == false) goto L95;
        List<o> r126 = r100.p3(r105, r106, r120, r124);
    L96:
        r100.f312319q = r126;
        r100.f312315m.k(r105, r106, r120, r101, r124);
        FLogger.f375446a.d("ThreadInteractionPanelSource", "[" + r101 + "] sync thread message snapshot, messageCount=" + r120.size());
        return;
    L95:
        r126 = CollectionsKt.emptyList();
        goto L96
    L85:
        r120 = CollectionsKt.emptyList();
        goto L86
    L60:
        if (StringsKt.isBlank(r115) == true) goto L63;
        r118 = false;
        goto L64
    L48:
        r111 = null;
    L51:
        r106 = r111;
        goto L53
    L30:
        r111 = null;
        goto L31
    L5:
        r105 = null;
        goto L6
    }
}
