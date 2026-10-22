package com.bytedance.awemeopen.apps.framework.feed.collect;

import android.content.Context;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002J0\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\rJ\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u001e\u0010\u001c\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0016\u0010\u001d\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\u0016\u0010\u001f\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0016R\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010!R\u0018\u0010,\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/collect/AosUserCollectFeedFragmentViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/FeedPagerListViewModel;", "Lh04/e;", "Ljz3/a;", "callback", "", "doRefresh", "Lh04/d;", "doLoadMore", "Landroid/content/Context;", "context", "", "userOpenId", "", UploadTypeInf.COUNT, "", "cursor", "Ls34/b;", "doLoadData", "getFromAweme", "getFromUserOpenId", "Lcom/bytedance/awemeopen/apps/framework/feed/collect/f$a;", "getFromUserProfileType", "copyFromTransientDataCache", "initIndex", "sceneId", "", "isFirst", "refreshData", "loadMoreData", "Lh04/c;", "loadForwardData", "pageCount", "I", "maxCursor", "J", "hasMore", "Z", "Ljava/lang/String;", "profileType", "Lcom/bytedance/awemeopen/apps/framework/feed/collect/f$a;", "", "cachedData", "Ljava/util/List;", "fromAweme", "Ljz3/a;", "Lo24/b;", "collectService", "Lo24/b;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosUserCollectFeedFragmentViewModel extends FeedPagerListViewModel {
    private List<jz3.a> cachedData;
    private final o24.b collectService;
    private jz3.a fromAweme;
    private boolean hasMore;
    private int initIndex;
    private long maxCursor;
    private int pageCount;
    private f.a profileType;
    private String userOpenId;

    public static final class a implements s34.b {
        public final /* synthetic */ AosUserCollectFeedFragmentViewModel a;
        public final /* synthetic */ h04.d<jz3.a> b;

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
                com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel r0 = r6.a
                long r2 = r7.e()
                com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel.access$setMaxCursor$p(r0, r2)
                com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel r0 = r6.a
                boolean r7 = r7.f()
                com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel.access$setHasMore$p(r0, r7)
                if (r1 != 0) goto L4d
                java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            L4d:
                h04.d<jz3.a> r7 = r6.b
                com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel r0 = r6.a
                boolean r0 = com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel.access$getHasMore$p(r0)
                r7.onSuccess(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel.a.a(s34.d):void");
        }

        public final void onFail(String r3) {
            h04.d<jz3.a> r0 = this.b;
            new RuntimeException(r3);
            r0.onFail();
        }

        public a(AosUserCollectFeedFragmentViewModel r1, h04.d<jz3.a> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements s34.b {
        public final /* synthetic */ AosUserCollectFeedFragmentViewModel a;
        public final /* synthetic */ h04.e<jz3.a> b;

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
                com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel r0 = r6.a
                long r2 = r7.e()
                com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel.access$setMaxCursor$p(r0, r2)
                com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel r0 = r6.a
                boolean r7 = r7.f()
                com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel.access$setHasMore$p(r0, r7)
                if (r1 != 0) goto L4d
                java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            L4d:
                h04.e<jz3.a> r7 = r6.b
                com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel r0 = r6.a
                boolean r0 = com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel.access$getHasMore$p(r0)
                r2 = 0
                r7.b(r1, r2, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.awemeopen.apps.framework.feed.collect.AosUserCollectFeedFragmentViewModel.b.a(s34.d):void");
        }

        public final void onFail(String r3) {
            this.b.a(new RuntimeException(r3), -1);
        }

        public b(AosUserCollectFeedFragmentViewModel r1, h04.e<jz3.a> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void loadForwardData(h04.c<jz3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public String sceneId() {
        return "collection_feed";
    }

    public final void copyFromTransientDataCache() {
        if (this.cachedData.size() != 0) goto L13;
        String r0 = f.a;
        this.pageCount = f.c;
        this.maxCursor = f.d;
        this.hasMore = f.e;
        this.userOpenId = f.a;
        this.profileType = f.b;
        this.cachedData.clear();
        List<jz3.a> r1 = this.cachedData;
        List<jz3.a> r2 = f.f;
        r1.addAll(r2);
        this.initIndex = f.g;
        if (this.cachedData.size() <= 0) goto L11;
        int r3 = this.initIndex;
        if (r3 < 0) goto L11;
        if (r3 >= this.cachedData.size()) goto L11;
        this.fromAweme = (jz3.a) ListProtector.get(this.cachedData, this.initIndex);
    L11:
        f.a = "";
        f.b = null;
        f.c = 20;
        f.d = 0;
        f.e = false;
        ((ArrayList) r2).clear();
        f.g = 0;
        return;
    }

    public AosUserCollectFeedFragmentViewModel() {
        this.pageCount = 20;
        this.userOpenId = "";
        this.cachedData = new ArrayList();
        d14.a r0 = b14.a.a;
        this.collectService = b14.a.a(o24.b.class);
    }

    public final jz3.a getFromAweme() {
        return this.fromAweme;
    }

    public final String getFromUserOpenId() {
        return this.userOpenId;
    }

    public final f.a getFromUserProfileType() {
        return this.profileType;
    }

    public final int initIndex() {
        return this.initIndex;
    }

    public static final /* synthetic */ boolean access$getHasMore$p(AosUserCollectFeedFragmentViewModel r0) {
        return r0.hasMore;
    }

    private final void doLoadMore(h04.d<jz3.a> r8) {
        doLoadData(getApplication(), this.userOpenId, this.pageCount, this.maxCursor, new a(this, r8));
    }

    private final void doRefresh(h04.e<jz3.a> r11) {
        if (this.cachedData.size() <= 0) goto L9;
        List<jz3.a> r0 = this.cachedData;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.add((jz3.a) r2.next());
        goto L6
    L8:
        r11.b(r1, false, this.hasMore);
        return;
    L9:
        doLoadData(getApplication(), this.userOpenId, this.pageCount, 0, new b(this, r11));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void loadMoreData(h04.d<jz3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        doLoadMore(r2);
    }

    public static final /* synthetic */ void access$setHasMore$p(AosUserCollectFeedFragmentViewModel r0, boolean r1) {
        r0.hasMore = r1;
    }

    public static final /* synthetic */ void access$setMaxCursor$p(AosUserCollectFeedFragmentViewModel r0, long r1) {
        r0.maxCursor = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void refreshData(h04.e<jz3.a> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "callback");
        doRefresh(r1);
    }

    private final void doLoadData(Context r4, String r5, int r6, long r7, s34.b r9) {
        if (Intrinsics.areEqual(this.profileType, f.a.C0071a.a) == false) goto L6;
        o24.b r0 = this.collectService;
        s34.c r1 = new s34.c();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r1.a = r5;
        r1.b = r6;
        r1.c = r7;
        Unit r8 = Unit.INSTANCE;
        r0.c3(r4, r1, r9);
        return;
    }
}
