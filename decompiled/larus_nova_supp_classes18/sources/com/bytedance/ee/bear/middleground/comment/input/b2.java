package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.at.MentionData;
import com.bytedance.ee.bear.at.MentionTitleResult;
import com.bytedance.ee.bear.at.MentionTitleResultList;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.bear.middleground.comment.export.CommentVoiceHostPolicy;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.DataEntity;
import com.bytedance.ee.bear.middleground.comment.export.bean.ReviewException;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b2 extends gn4.a {
    public static final /* synthetic */ int m = 0;
    public final com.bytedance.ee.bear.middleground.comment.uitls.p c;
    public final com.bytedance.ee.bear.middleground.comment.control.t d;
    public CommentInputRequest e;
    public boolean f;
    public boolean g;
    public String h;
    public String i;
    public String j;
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> k;
    public SmartReplyDataForInsert l;

    public static final class a {
    }

    static {
    }

    public final boolean f() {
        if (this.c.v == false) goto L5;
    L13:
        boolean r0 = true;
    L14:
        if (r0 == false) goto L18;
        this.c.h.getClass();
        if (((com.bytedance.ee.bear.contract.b0) org.koin.java.a.c(com.bytedance.ee.bear.contract.b0.class, null, null, 6)).f() == true) goto L18;
        return true;
    L18:
        return false;
    L5:
        if (com.bytedance.ee.bear.middleground.comment.export.e.c() != CommentVoiceHostPolicy.Route.UNIFIED_COMPONENT) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
    L12:
        r0 = false;
        goto L14
    L10:
        if (this.c.s == true) goto L12;
    L7:
        r1 = false;
        goto L8
    }

    public final boolean j() {
        return this.e.isEdit();
    }

    public static final void d(b2 r4) {
        r4.getClass();
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L5;
        tt5.a.h("Comment#InputViewModel", "cancelRecord: voiceInputFG=on, skip legacy CommentAudio.cancelRecord");
        r4.g = true;
        r4.h = "";
        r4.i = "";
        r4.j = "";
        return;
    L5:
        r4.g = true;
        r4.h = "";
        r4.i = "";
        r4.j = "";
        int r5 = com.bytedance.ee.bear.middleground.comment.audio.c.a;
        ((com.bytedance.ee.bear.middleground.audio.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.audio.h.class, null, null, 6)).a();
    }

    public static List e(List r4) {
        ArrayList r0 = new ArrayList();
        if (r4 == null) goto L8;
        r4.isEmpty();
        Iterator r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        FileBean r1 = (FileBean) r5.next();
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r2 = new CommentBean.CommentDetail.ExtraEntity.CommentImageEntity();
        r2.setSrc(r1.getPath());
        r2.setUuid(r1.getUuid());
        r0.add(r2);
    L8:
        return r0;
    }

    public final void l(CommentInputRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        String r0 = r2.content;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.h = r0;
        this.e = r2;
    }

    public final void g(com.bytedance.ee.bear.middleground.comment.control.z r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r5, "commentListeners");
        tt5.a.e("Comment#InputViewModel", "send comment error", r6, false);
        String r3 = "";
        r5.H().invoke("", this.e, Boolean.FALSE);
        if (Intrinsics.areEqual(this.c.k, sbb.e.g) == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.c.k, sbb.e.n) == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(this.c.k, sbb.e.h) == false) goto L9;
        return;
    L9:
        if ((r6 instanceof ReviewException) == false) goto L12;
        ((com.bytedance.ee.bear.review.a) org.koin.java.a.c(com.bytedance.ee.bear.review.a.class, null, null, 6)).h(this.c.getActivity());
        return;
    L12:
        if (this.c.t == true) goto L14;
        return;
    L14:
        if (this.e.need_loading == true) goto L36;
        int r7 = com.bytedance.ee.bear.middleground.comment.uitls.n.a;
        if (r6 == null) goto L21;
        String r8 = r6.getMessage();
        if (r8 == null) goto L21;
        r3 = r8;
    L21:
        DataEntity.Entity.BodyEntity r9 = com.bytedance.ee.bear.middleground.comment.uitls.n.b(r3);
        if (r9 != null) goto L24;
    L26:
        boolean r10 = false;
    L27:
        if (r10 == false) goto L29;
        Toast.showFailureText(this.c.getActivity(), this.c.getActivity().getString(2131889734), 0);
        return;
    L29:
        Toast.showFailureText(this.c.getActivity(), this.c.getActivity().getString(2131887611), 0);
        return;
    L24:
        if (r9.getCode() != 90500) goto L26;
        r10 = true;
        goto L27
    }

    public b2(com.bytedance.ee.bear.middleground.comment.uitls.p r2, com.bytedance.ee.bear.middleground.comment.control.t r3, com.bytedance.ee.bear.middleground.comment.control.z r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "dataControl");
        Intrinsics.checkNotNullParameter(r4, "commentListeners");
        this.c = r2;
        this.d = r3;
        this.e = new CommentInputRequest();
        this.g = true;
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = new ArrayList();
    }

    public final void h(String r3, final Function2<? super BearUrl, ? super MentionTitleResult, Unit> r4, final Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "failCallback");
        this.c.h.getClass();
        if (s45.p.a().v6(r3) == false) goto L5;
        final BearUrl r6 = s45.p.a().Z(r3);
        Disposable r7 = ((com.bytedance.ee.bear.d) org.koin.java.a.a(com.bytedance.ee.bear.d.class)).f(r6, (NetService) org.koin.java.a.a(NetService.class)).subscribe(new com.bytedance.ee.bear.middleground.comment.m(r4, r6), new com.bytedance.ee.bear.middleground.comment.n(r5));
    L6:
        a(r7);
        return;
    L5:
        r5.invoke();
        r7 = null;
        goto L6
    }

    public final void i(List<String> r5, final Function3<? super List<String>, ? super List<? extends BearUrl>, ? super MentionTitleResultList, Unit> r6, final Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, "urls");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r7, "failCallback");
        this.c.h.getClass();
        final ArrayList r0 = new ArrayList();
        final ArrayList r1 = new ArrayList();
        Iterator<String> r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        String r2 = r8.next();
        if (s45.p.a().v6(r2) == false) goto L4;
        r0.add(s45.p.a().Z(r2));
        r1.add(r2);
        goto L4
    L9:
        if (hu5.a.d(r0) == true) goto L11;
        Disposable r9 = ((com.bytedance.ee.bear.d) org.koin.java.a.a(com.bytedance.ee.bear.d.class)).g(r0, (NetService) org.koin.java.a.a(NetService.class)).subscribe(new com.bytedance.ee.bear.middleground.comment.k(r6, r1, r0), new com.bytedance.ee.bear.middleground.comment.l(r7));
    L12:
        a(r9);
        return;
    L11:
        r7.invoke();
        r9 = null;
        goto L12
    }

    /* JADX WARN: Failed to calculate best type for var: r1v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v6 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r26v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r26v0 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r26v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r26v1 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r26v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r26v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v12 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v12 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v13 ??, new type: java.lang.CharSequence
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v28 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v28 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v12 ??, new type: java.lang.CharSequence
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderAllow(TypeUpdate.java:66)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryWiderObjects(FixTypesVisitor.java:795)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:249)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public final void m(java.lang.String r31, com.bytedance.ee.bear.domain.BearUrl r32, com.bytedance.ee.bear.at.MentionTitleResult r33, com.bytedance.ee.bear.middleground.comment.widget.CommentEditText r34) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00fe: IGET (r2v28 ?? I:java.lang.String) = (r2v11 com.bytedance.ee.bear.at.MentionData) A[DECLARE_VAR] (LINE:67109118) com.bytedance.ee.bear.at.MentionData.icon_info java.lang.String in method: com.bytedance.ee.bear.middleground.comment.input.b2.m(java.lang.String, com.bytedance.ee.bear.domain.BearUrl, com.bytedance.ee.bear.at.MentionTitleResult, com.bytedance.ee.bear.middleground.comment.widget.CommentEditText):void, file: /private/tmp/nixiang/classes18.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.ee.bear.middleground.comment.input.b2.m(java.lang.String, com.bytedance.ee.bear.domain.BearUrl, com.bytedance.ee.bear.at.MentionTitleResult, com.bytedance.ee.bear.middleground.comment.widget.CommentEditText):void");
    }

    public final void n(List r7, List r8, MentionTitleResultList r9, CommentEditText r10) {
        Intrinsics.checkNotNullParameter(r7, "originList");
        Intrinsics.checkNotNullParameter(r8, "bearUrls");
        if (r10 == null) goto L38;
        if (r9 == null) goto L6;
        ArrayList r0 = (ArrayList) ((Result) r9).data;
    L7:
        if (r0 != null) goto L10;
        return;
    L10:
        if (r7.size() == r8.size()) goto L12;
    L32:
        tt5.a.d("Comment#InputViewModel", "transformUrl2TitleForSpanSBV2 but list length does not match");
        return;
    L12:
        if (r7.size() != ((ArrayList) ((Result) r9).data).size()) goto L32;
        ArrayList r1 = (ArrayList) ((Result) r9).data;
        if (r1 != null) goto L17;
        return;
    L17:
        Iterator r11 = r8.iterator();
        int r2 = 0;
    L19:
        if (r11.hasNext() == false) goto L31;
        Object r3 = r11.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        BearUrl r5 = (BearUrl) r3;
        String r6 = (String) CollectionsKt.getOrNull(r7, r2);
        if (r6 == null) goto L30;
        MentionData r12 = (MentionData) CollectionsKt.getOrNull(r1, r2);
        if (r12 == null) goto L30;
        MentionTitleResult r13 = new MentionTitleResult();
        ((Result) r13).data = r12;
        ((Result) r13).code = ((Result) r9).code;
        ((Result) r13).msg = ((Result) r9).msg;
        m(r6, r5, r13, r10);
    L30:
        r2 = r4;
        goto L19
    L31:
        return;
    L6:
        r0 = null;
        goto L7
    }

    public final void k(CommentEditText r15, Function4 r16, boolean r17, Function1 r18, boolean r19, String r20, List r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r16, "sendCallBack");
        Disposable r10 = null;
        if (this.g == false) goto L6;
    L9:
        if (r21 != null) goto L11;
        List r11 = this.k;
    L12:
        if (r20 == null) goto L15;
        Flowable r0 = Flowable.just(r20);
        if (r0 == null) goto L15;
    L20:
        if (r0 == null) goto L26;
        Flowable r12 = r0.filter(new c2(r11, this));
        if (r12 == null) goto L26;
        Flowable r1 = r12.flatMap(new d2(this, r22, r15, r17, r20, r11, r19));
        if (r1 == null) goto L26;
        Flowable r2 = r1.map(new e2(this, r11));
    L27:
        Flowable<String> r3 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(r2, r18);
        if (r3 == null) goto L32;
        Flowable r4 = r3.map(new g2(this));
        if (r4 == null) goto L32;
        r10 = r4.subscribe(new h2(r16, this), new i2(this, r16), new j2(r16, this));
    L32:
        a(r10);
        return;
    L26:
        r2 = null;
    L15:
        if (r15 == null) goto L19;
        Single<String> r5 = r15.getRichText();
        if (r5 == null) goto L19;
        r0 = r5.toFlowable();
    L19:
        r0 = null;
        goto L20
    L11:
        r11 = r21;
        goto L12
    L6:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L8;
        tt5.a.h("Comment#InputViewModel", "stopRecord: voiceInputFG=on, skip legacy CommentAudio.stopRecord");
        this.g = true;
        goto L9
    L8:
        this.h += this.i;
        this.i = "";
        this.g = true;
        int r6 = com.bytedance.ee.bear.middleground.comment.audio.c.a;
        ((com.bytedance.ee.bear.middleground.audio.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.audio.h.class, null, null, 6)).stopRecord();
        goto L9
    }
}
