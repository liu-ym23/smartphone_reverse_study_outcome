package com.bytedance.awemeopen.apps.framework.collect.works;

import android.app.Application;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.FeedRecyclerListViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 72\u00020\u0001:\u000289B\u0007¢\u0006\u0004\b5\u00106J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\fH\u0016J\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00122\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00182\u0006\u0010\u0017\u001a\u00020\fJ\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00182\u0006\u0010\u0017\u001a\u00020\fJ\b\u0010\u001b\u001a\u00020\u0005H\u0014R\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010\"\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010!\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\"\u0010/\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010!\u001a\u0004\b0\u0010$\"\u0004\b1\u0010&R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0003028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u0006:"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/works/UserCollectWorksFragmentViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/FeedRecyclerListViewModel;", "Lh04/d;", "Ljz3/a;", "callback", "", "doRefresh", "doLoadMore", "", "count", "setPageCount", "resetPageCount2Default", "", "openId", "setUserOpenId", "getUserOpenId", "", "maxCursor", "", "hasMore", "sceneId", "refresh", "loadData", "aid", "Lkotlin/Pair;", "unCollectItem", "collectItem", "onCleared", "pageCount", "I", "J", "Z", "mUserOpenId", "Ljava/lang/String;", "enterAid", "getEnterAid", "()Ljava/lang/String;", "setEnterAid", "(Ljava/lang/String;)V", "enterIsLive", "getEnterIsLive", "()Z", "setEnterIsLive", "(Z)V", "hideLongPressTab", "getHideLongPressTab", "setHideLongPressTab", "hostEnterFrom", "getHostEnterFrom", "setHostEnterFrom", "", "unCollectList", "Ljava/util/List;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserCollectWorksFragmentViewModel extends FeedRecyclerListViewModel {
    public static final a Companion = null;
    public static final int DEFAULT_PAGE_COUNT = 20;
    private String enterAid;
    private boolean enterIsLive;
    private boolean hasMore;
    private boolean hideLongPressTab;
    private String hostEnterFrom;
    private String mUserOpenId;
    private long maxCursor;
    private int pageCount;
    private final List<jz3.a> unCollectList;

    public static final class a {
        public a() {
        }
    }

    public final class b implements s34.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f194009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s34.b f194010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UserCollectWorksFragmentViewModel f194011c;

        @Override // s34.b
        public final void a(s34.d r100) {
            Intrinsics.checkNotNullParameter(r100, "collectListResult");
            if (Intrinsics.areEqual(this.f194009a, UserCollectWorksFragmentViewModel.access$getMUserOpenId$p(this.f194011c)) == false) goto L8;
            s34.b r101 = this.f194010b;
            if (r101 == null) goto L9;
            r101.a(r100);
            return;
        L9:
            return;
        }

        @Override // s34.b
        public final void onFail(String r100) {
            if (Intrinsics.areEqual(this.f194009a, UserCollectWorksFragmentViewModel.access$getMUserOpenId$p(this.f194011c)) == false) goto L8;
            s34.b r101 = this.f194010b;
            if (r101 == null) goto L9;
            r101.onFail(r100);
            return;
        L9:
            return;
        }

        public b(UserCollectWorksFragmentViewModel r100, String r101, s34.b r102) {
            Intrinsics.checkNotNullParameter(r101, "inputUserOpenId");
            this.f194011c = r100;
            this.f194009a = r101;
            this.f194010b = r102;
        }
    }

    public static final class c implements s34.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserCollectWorksFragmentViewModel f194012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h04.d<jz3.a> f194013b;

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v5 java.util.List<? extends jz3.a>
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // s34.b
        public final void a(s34.d r7) {
            /*  JADX ERROR: Simple mode code generation failed
                jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v5 java.util.List<? extends jz3.a>
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                */
            /*
                r6 = this;
                java.lang.String r0 = "collectListResult"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.util.List r0 = r7.g()
                r1 = 0
                if (r0 == 0) goto L35
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r2 = new java.util.ArrayList
                r3 = 10
                int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
                r2.<init>(r3)
                java.util.Iterator r0 = r0.iterator()
            L1d:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L34
                java.lang.Object r3 = r0.next()
                r14.c r3 = (r14.c) r3
                jz3.a r4 = new jz3.a
                r5 = 14
                r4.<init>(r3, r1, r5)
                r2.add(r4)
                goto L1d
            L34:
                r1 = r2
            L35:
                com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel r0 = r6.f194012a
                long r2 = r7.e()
                com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel.access$setMaxCursor$p(r0, r2)
                com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel r0 = r6.f194012a
                boolean r7 = r7.f()
                com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel.access$setHasMore$p(r0, r7)
                if (r1 != 0) goto L4d
                java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            L4d:
                h04.d<jz3.a> r7 = r6.f194013b
                com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel r0 = r6.f194012a
                boolean r0 = com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel.access$getHasMore$p(r0)
                r7.onSuccess(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel.c.a(s34.d):void");
        }

        @Override // s34.b
        public final void onFail(String r100) {
            h04.d<jz3.a> r101 = this.f194013b;
            new RuntimeException(r100);
            r101.onFail();
        }

        public c(UserCollectWorksFragmentViewModel r100, h04.d<jz3.a> r101) {
            this.f194012a = r100;
            this.f194013b = r101;
        }
    }

    public static final class d implements s34.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserCollectWorksFragmentViewModel f194014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h04.d<jz3.a> f194015b;

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v5 java.util.List<? extends jz3.a>
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // s34.b
        public final void a(s34.d r7) {
            /*  JADX ERROR: Simple mode code generation failed
                jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v5 java.util.List<? extends jz3.a>
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                */
            /*
                r6 = this;
                java.lang.String r0 = "collectListResult"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.util.List r0 = r7.g()
                r1 = 0
                if (r0 == 0) goto L35
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r2 = new java.util.ArrayList
                r3 = 10
                int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
                r2.<init>(r3)
                java.util.Iterator r0 = r0.iterator()
            L1d:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L34
                java.lang.Object r3 = r0.next()
                r14.c r3 = (r14.c) r3
                jz3.a r4 = new jz3.a
                r5 = 14
                r4.<init>(r3, r1, r5)
                r2.add(r4)
                goto L1d
            L34:
                r1 = r2
            L35:
                com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel r0 = r6.f194014a
                long r2 = r7.e()
                com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel.access$setMaxCursor$p(r0, r2)
                com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel r0 = r6.f194014a
                boolean r7 = r7.f()
                com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel.access$setHasMore$p(r0, r7)
                if (r1 != 0) goto L4d
                java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            L4d:
                h04.d<jz3.a> r7 = r6.f194015b
                com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel r0 = r6.f194014a
                boolean r0 = com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel.access$getHasMore$p(r0)
                r7.onSuccess(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragmentViewModel.d.a(s34.d):void");
        }

        @Override // s34.b
        public final void onFail(String r100) {
            h04.d<jz3.a> r101 = this.f194015b;
            new RuntimeException(r100);
            r101.onFail();
        }

        public d(UserCollectWorksFragmentViewModel r100, h04.d<jz3.a> r101) {
            this.f194014a = r100;
            this.f194015b = r101;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.FeedRecyclerListViewModel
    public String sceneId() {
        return "collect_works";
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.unCollectList.clear();
        super.onCleared();
    }

    public final void resetPageCount2Default() {
        this.pageCount = 20;
    }

    public UserCollectWorksFragmentViewModel() {
        this.pageCount = 20;
        this.mUserOpenId = "";
        this.enterAid = "";
        this.hostEnterFrom = "";
        this.unCollectList = new ArrayList();
    }

    public final String getEnterAid() {
        return this.enterAid;
    }

    public final boolean getEnterIsLive() {
        return this.enterIsLive;
    }

    public final boolean getHideLongPressTab() {
        return this.hideLongPressTab;
    }

    public final String getHostEnterFrom() {
        return this.hostEnterFrom;
    }

    public final String getUserOpenId() {
        return this.mUserOpenId;
    }

    public final boolean hasMore() {
        return this.hasMore;
    }

    public final long maxCursor() {
        return this.maxCursor;
    }

    public static final /* synthetic */ boolean access$getHasMore$p(UserCollectWorksFragmentViewModel r100) {
        return r100.hasMore;
    }

    public static final /* synthetic */ String access$getMUserOpenId$p(UserCollectWorksFragmentViewModel r100) {
        return r100.mUserOpenId;
    }

    private final void doLoadMore(h04.d<jz3.a> r100) {
        d14.a r101 = b14.a.f16924a;
        o24.b r102 = (o24.b) b14.a.a(o24.b.class);
        Application r103 = getApplication();
        s34.c r104 = new s34.c();
        String r105 = this.mUserOpenId;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f540463a = r105;
        r104.f540464b = this.pageCount;
        r104.f540465c = this.maxCursor;
        Unit r106 = Unit.INSTANCE;
        r102.c3(r103, r104, new b(this, this.mUserOpenId, new c(this, r100)));
    }

    private final void doRefresh(h04.d<jz3.a> r100) {
        d14.a r101 = b14.a.f16924a;
        o24.b r102 = (o24.b) b14.a.a(o24.b.class);
        Application r103 = getApplication();
        s34.c r104 = new s34.c();
        String r105 = this.mUserOpenId;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f540463a = r105;
        r104.f540464b = this.pageCount;
        r104.f540465c = 0;
        Unit r106 = Unit.INSTANCE;
        r102.c3(r103, r104, new b(this, this.mUserOpenId, new d(this, r100)));
    }

    public final Pair<Boolean, Boolean> collectItem(String r100) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        if (this.unCollectList.size() > 0) goto L6;
        Boolean r101 = Boolean.FALSE;
        return new Pair(r101, r101);
    L6:
        ListState<List<jz3.a>> r102 = getDataList().getValue();
        if (r102 == null) goto L17;
        List<jz3.a> r103 = r102.f196927a;
        if (r103 == null) goto L17;
        Iterator<jz3.a> r104 = this.unCollectList.iterator();
    L12:
        if (r104.hasNext() == false) goto L17;
        jz3.a r105 = r104.next();
        if (Intrinsics.areEqual(r100, r105.f501173a.c()) == false) goto L12;
        this.unCollectList.remove(r105);
        ArrayList r106 = new ArrayList();
        r106.addAll(r103);
        ListProtector.add(r106, 0, r105);
        replaceListData(r106);
        return new Pair(Boolean.TRUE, Boolean.FALSE);
    L17:
        Boolean r107 = Boolean.FALSE;
        return new Pair(r107, r107);
    }

    public final void setEnterAid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterAid = r100;
    }

    public final void setEnterIsLive(boolean r100) {
        this.enterIsLive = r100;
    }

    public final void setHideLongPressTab(boolean r100) {
        this.hideLongPressTab = r100;
    }

    public final void setHostEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostEnterFrom = r100;
    }

    public final void setPageCount(int r100) {
        this.pageCount = r100;
    }

    public final void setUserOpenId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.mUserOpenId = r100;
    }

    public final Pair<Boolean, Boolean> unCollectItem(String r100) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        ListState<List<jz3.a>> r101 = getDataList().getValue();
        if (r101 == null) goto L24;
        List<jz3.a> r102 = r101.f196927a;
        if (r102 == null) goto L24;
        Iterator<jz3.a> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L24;
        jz3.a r104 = r103.next();
        if (Intrinsics.areEqual(r100, r104.f501173a.c()) == false) goto L8;
        this.unCollectList.add(r104);
        ArrayList r105 = new ArrayList();
        ListState<List<jz3.a>> r106 = getDataList().getValue();
        if (r106 == null) goto L14;
        List<jz3.a> r107 = r106.f196927a;
    L15:
        Intrinsics.checkNotNull(r107);
        r105.addAll(r107);
        r105.remove(r104);
        replaceListData(r105);
        Boolean r108 = Boolean.TRUE;
        ListState<List<jz3.a>> r109 = getDataList().getValue();
        boolean r110 = false;
        if (r109 == null) goto L23;
        List<jz3.a> r111 = r109.f196927a;
        if (r111 == null) goto L23;
        if (r111.size() != 0) goto L23;
        r110 = true;
    L23:
        return new Pair(r108, Boolean.valueOf(r110));
    L14:
        r107 = null;
    L24:
        Boolean r112 = Boolean.FALSE;
        return new Pair(r112, r112);
    }

    public static final /* synthetic */ void access$setHasMore$p(UserCollectWorksFragmentViewModel r100, boolean r101) {
        r100.hasMore = r101;
    }

    public static final /* synthetic */ void access$setMaxCursor$p(UserCollectWorksFragmentViewModel r100, long r101) {
        r100.maxCursor = r101;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListViewModel
    public void loadData(boolean r100, h04.d<jz3.a> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r100 == false) goto L5;
        doRefresh(r101);
        return;
    L5:
        doLoadMore(r101);
    }
}
