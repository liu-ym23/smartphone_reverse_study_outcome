package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.at.MentionData;
import com.bytedance.ee.bear.at.MentionTitleResult;
import com.bytedance.ee.bear.at.MentionTitleResultList;
import com.bytedance.ee.bear.contract.NetService;
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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
public final class b2 extends gn4.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f231903m = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.uitls.p f231904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.control.t f231905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CommentInputRequest f231906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f231907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f231908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f231909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f231910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f231911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> f231912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SmartReplyDataForInsert f231913l;

    public static final class a {
    }

    static {
    }

    public final boolean f() {
        if (this.f231904c.f232246v == false) goto L5;
    L13:
        boolean r100 = true;
    L14:
        if (r100 == false) goto L18;
        this.f231904c.f232232h.getClass();
        if (((com.bytedance.ee.bear.contract.b0) org.koin.java.a.c(com.bytedance.ee.bear.contract.b0.class, null, null, 6)).f() == true) goto L18;
        return true;
    L18:
        return false;
    L5:
        if (com.bytedance.ee.bear.middleground.comment.export.e.c() != CommentVoiceHostPolicy.Route.UNIFIED_COMPONENT) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
    L12:
        r100 = false;
        goto L14
    L10:
        if (this.f231904c.f232243s == true) goto L12;
    L7:
        r101 = false;
        goto L8
    }

    public final boolean j() {
        return this.f231906e.isEdit();
    }

    public static final void d(b2 r100) {
        r100.getClass();
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L5;
        tt5.a.h("Comment#InputViewModel", "cancelRecord: voiceInputFG=on, skip legacy CommentAudio.cancelRecord");
        r100.f231908g = true;
        r100.f231909h = "";
        r100.f231910i = "";
        r100.f231911j = "";
        return;
    L5:
        r100.f231908g = true;
        r100.f231909h = "";
        r100.f231910i = "";
        r100.f231911j = "";
        int r101 = com.bytedance.ee.bear.middleground.comment.audio.c.f230335a;
        ((com.bytedance.ee.bear.middleground.audio.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.audio.h.class, null, null, 6)).a();
    }

    public static List e(List r100) {
        ArrayList r101 = new ArrayList();
        if (r100 == null) goto L8;
        r100.isEmpty();
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        FileBean r103 = (FileBean) r102.next();
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r104 = new CommentBean.CommentDetail.ExtraEntity.CommentImageEntity();
        r104.setSrc(r103.getPath());
        r104.setUuid(r103.getUuid());
        r101.add(r104);
    L8:
        return r101;
    }

    public final void l(CommentInputRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        String r101 = r100.content;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f231909h = r101;
        this.f231906e = r100;
    }

    public final void g(com.bytedance.ee.bear.middleground.comment.control.z r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "commentListeners");
        tt5.a.e("Comment#InputViewModel", "send comment error", r101, false);
        String r102 = "";
        r100.H().invoke("", this.f231906e, Boolean.FALSE);
        if (Intrinsics.areEqual(this.f231904c.f232235k, sbb.e.f541296g) == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f231904c.f232235k, sbb.e.f541303n) == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(this.f231904c.f232235k, sbb.e.f541297h) == false) goto L9;
        return;
    L9:
        if ((r101 instanceof ReviewException) == false) goto L12;
        ((com.bytedance.ee.bear.review.a) org.koin.java.a.c(com.bytedance.ee.bear.review.a.class, null, null, 6)).h(this.f231904c.getActivity());
        return;
    L12:
        if (this.f231904c.f232244t == true) goto L14;
        return;
    L14:
        if (this.f231906e.need_loading == true) goto L36;
        int r103 = com.bytedance.ee.bear.middleground.comment.uitls.n.f232215a;
        if (r101 == null) goto L21;
        String r104 = r101.getMessage();
        if (r104 == null) goto L21;
        r102 = r104;
    L21:
        DataEntity.Entity.BodyEntity r105 = com.bytedance.ee.bear.middleground.comment.uitls.n.b(r102);
        if (r105 != null) goto L24;
    L26:
        boolean r106 = false;
    L27:
        if (r106 == false) goto L29;
        Toast.showFailureText(this.f231904c.getActivity(), this.f231904c.getActivity().getString(R.string.LarkCCM_Security_Report_CommentFunctionPausedSafety_Toast), 0);
        return;
    L29:
        Toast.showFailureText(this.f231904c.getActivity(), this.f231904c.getActivity().getString(R.string.Doc_Comment_CommentSendFailed), 0);
        return;
    L24:
        if (r105.getCode() != 90500) goto L26;
        r106 = true;
        goto L27
    }

    public b2(com.bytedance.ee.bear.middleground.comment.uitls.p r100, com.bytedance.ee.bear.middleground.comment.control.t r101, com.bytedance.ee.bear.middleground.comment.control.z r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "dataControl");
        Intrinsics.checkNotNullParameter(r102, "commentListeners");
        this.f231904c = r100;
        this.f231905d = r101;
        this.f231906e = new CommentInputRequest();
        this.f231908g = true;
        this.f231909h = "";
        this.f231910i = "";
        this.f231911j = "";
        this.f231912k = new ArrayList();
    }

    public final void h(String r100, final Function2<? super BearUrl, ? super MentionTitleResult, Unit> r101, final Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "failCallback");
        this.f231904c.f232232h.getClass();
        if (s45.p.a().v6(r100) == false) goto L5;
        final BearUrl r103 = s45.p.a().Z(r100);
        Disposable r104 = ((com.bytedance.ee.bear.d) org.koin.java.a.a(com.bytedance.ee.bear.d.class)).f(r103, (NetService) org.koin.java.a.a(NetService.class)).subscribe(new com.bytedance.ee.bear.middleground.comment.m(r101, r103), new com.bytedance.ee.bear.middleground.comment.n(r102));
    L6:
        a(r104);
        return;
    L5:
        r102.invoke();
        r104 = null;
        goto L6
    }

    public final void i(List<String> r100, final Function3<? super List<String>, ? super List<? extends BearUrl>, ? super MentionTitleResultList, Unit> r101, final Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "urls");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "failCallback");
        this.f231904c.f232232h.getClass();
        final ArrayList r103 = new ArrayList();
        final ArrayList r104 = new ArrayList();
        Iterator<String> r105 = r100.iterator();
    L4:
        if (r105.hasNext() == false) goto L9;
        String r106 = r105.next();
        if (s45.p.a().v6(r106) == false) goto L4;
        r103.add(s45.p.a().Z(r106));
        r104.add(r106);
        goto L4
    L9:
        if (hu5.a.d(r103) == true) goto L11;
        Disposable r107 = ((com.bytedance.ee.bear.d) org.koin.java.a.a(com.bytedance.ee.bear.d.class)).g(r103, (NetService) org.koin.java.a.a(NetService.class)).subscribe(new com.bytedance.ee.bear.middleground.comment.k(r101, r104, r103), new com.bytedance.ee.bear.middleground.comment.l(r102));
    L12:
        a(r107);
        return;
    L11:
        r102.invoke();
        r107 = null;
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
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: IGET (r2v2 ?? I:DATA extends java.io.Serializable) = (r33v0 com.bytedance.ee.bear.at.MentionTitleResult) A[DECLARE_VAR] (LINE:67108886) com.bytedance.ee.bear.contract.Result.data java.io.Serializable in method: com.bytedance.ee.bear.middleground.comment.input.b2.m(java.lang.String, com.bytedance.ee.bear.domain.BearUrl, com.bytedance.ee.bear.at.MentionTitleResult, com.bytedance.ee.bear.middleground.comment.widget.CommentEditText):void, file: classes18.dex
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

    public final void n(List r100, List r101, MentionTitleResultList r102, CommentEditText r110) {
        Intrinsics.checkNotNullParameter(r100, "originList");
        Intrinsics.checkNotNullParameter(r101, "bearUrls");
        if (r110 == null) goto L38;
        if (r102 == null) goto L6;
        ArrayList r103 = (ArrayList) r102.data;
    L7:
        if (r103 != null) goto L10;
        return;
    L10:
        if (r100.size() == r101.size()) goto L12;
    L32:
        tt5.a.d("Comment#InputViewModel", "transformUrl2TitleForSpanSBV2 but list length does not match");
        return;
    L12:
        if (r100.size() != ((ArrayList) r102.data).size()) goto L32;
        ArrayList r104 = (ArrayList) r102.data;
        if (r104 != null) goto L17;
        return;
    L17:
        Iterator r105 = r101.iterator();
        int r106 = 0;
    L19:
        if (r105.hasNext() == false) goto L31;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        BearUrl r109 = (BearUrl) r107;
        String r111 = (String) CollectionsKt.getOrNull(r100, r106);
        if (r111 == null) goto L30;
        MentionData r112 = (MentionData) CollectionsKt.getOrNull(r104, r106);
        if (r112 == null) goto L30;
        MentionTitleResult r113 = new MentionTitleResult();
        r113.data = r112;
        r113.code = r102.code;
        r113.msg = r102.msg;
        m(r111, r109, r113, r110);
    L30:
        r106 = r108;
        goto L19
    L31:
        return;
    L6:
        r103 = null;
        goto L7
    }

    public final void k(CommentEditText r110, Function4 r111, boolean r112, Function1 r113, boolean r114, String r210, List r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r111, "sendCallBack");
        Disposable r115 = null;
        if (this.f231908g == false) goto L6;
    L9:
        if (r211 != null) goto L11;
        List r116 = this.f231912k;
    L12:
        if (r210 == null) goto L15;
        Flowable<String> r100 = Flowable.just(r210);
        if (r100 == null) goto L15;
    L20:
        if (r100 == null) goto L26;
        Flowable<String> r117 = r100.filter(new c2(r116, this));
        if (r117 == null) goto L26;
        Flowable<R> r101 = r117.flatMap(new d2(this, r212, r110, r112, r210, r116, r114));
        if (r101 == 0) goto L26;
        Flowable r102 = r101.map(new e2(this, r116));
    L27:
        Flowable<String> r103 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(r102, r113);
        if (r103 == null) goto L32;
        Flowable<R> r104 = r103.map(new g2(this));
        if (r104 == 0) goto L32;
        r115 = r104.subscribe(new h2(r111, this), new i2(this, r111), new j2(r111, this));
    L32:
        a(r115);
        return;
    L26:
        r102 = null;
    L15:
        if (r110 == null) goto L19;
        Single<String> r105 = r110.getRichText();
        if (r105 == null) goto L19;
        r100 = r105.toFlowable();
    L19:
        r100 = null;
        goto L20
    L11:
        r116 = r211;
        goto L12
    L6:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L8;
        tt5.a.h("Comment#InputViewModel", "stopRecord: voiceInputFG=on, skip legacy CommentAudio.stopRecord");
        this.f231908g = true;
        goto L9
    L8:
        this.f231909h += this.f231910i;
        this.f231910i = "";
        this.f231908g = true;
        int r106 = com.bytedance.ee.bear.middleground.comment.audio.c.f230335a;
        ((com.bytedance.ee.bear.middleground.audio.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.audio.h.class, null, null, 6)).stopRecord();
        goto L9
    }
}
