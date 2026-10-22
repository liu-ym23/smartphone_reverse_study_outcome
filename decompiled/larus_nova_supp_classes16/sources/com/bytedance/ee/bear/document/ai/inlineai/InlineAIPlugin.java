package com.bytedance.ee.bear.document.ai.inlineai;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.z;
import com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.ai.inlineai.bean.CallbackData;
import com.bytedance.ee.bear.document.ai.inlineai.bean.FeedbackData;
import com.bytedance.ee.bear.document.ai.inlineai.bean.JSInfoList;
import com.bytedance.ee.bear.document.ai.inlineai.bean.JSInlineAIPanel;
import com.bytedance.ee.bear.document.ai.inlineai.bean.JSPromptGroup;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.oops.OopsPluginV2;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.inline.ai.api.MentionType;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.inline.ai.api.ui.FeedbackConfig;
import com.ss.android.lark.inline.ai.api.ui.Operate;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.api.ui.TextResultContentList;
import com.ss.android.lark.insets.WindowInsetsUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ?2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0005?@ABCB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0002J \u0010\"\u001a\u00020\u001e2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0$H\u0016J\u0012\u0010&\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0006\u0010*\u001a\u00020\u0012J\"\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00104\u001a\u0002032\u0006\u00105\u001a\u000202H\u0002J\u0012\u00106\u001a\u0004\u0018\u0001032\u0006\u00105\u001a\u000202H\u0002J\b\u00107\u001a\u00020\u0012H\u0016J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020!H\u0002J\u0010\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u0012H\u0002J\b\u0010<\u001a\u00020\u0012H\u0016J\b\u0010=\u001a\u00020>H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002030$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/inlineai/InlineAIPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "inlineAISdk", "Lcom/ss/android/lark/inline/ai/api/ui/IInlineAIUISdk;", "currentPanelStyle", "", "mCallback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "getMCallback", "()Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "setMCallback", "(Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;)V", "mKeyboardShow", "", "getMKeyboardShow", "()Z", "setMKeyboardShow", "(Z)V", "keyboardHeightProvider", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "mFeedbackCallback", "Lcom/ss/android/lark/inline/ai/api/ui/IFeedbackCallback;", "editPanel", "Lcom/bytedance/ee/bear/document/ai/inlineai/InlineAIEditPanel;", "destroy", "", "ensureSdk", "jSInlineAIPanel", "Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSInlineAIPanel;", "getBridgeHandlers", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onDetachFromHost", "enableAiEditAt", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "keyboardObserverMap", "Lcom/ss/android/lark/inline/ai/api/ui/IKeyboardHeightProvider$IKeyboardHeightChangeListener;", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "getOrCreateKeyboardObserver", "onKeyboardHeightChangeListener", "removeAndGetKeyboardObserver", "shouldDisableLandscape", "hasnotifyOrientation", "handleOrientation", "notifyOrientationSupportPanelState", "isShowing", "onBackPressed", "getScenario", "Lcom/ss/android/lark/inline/ai/api/ScenarioType;", "Companion", "InlineAIShowHandler", "InlineAIMessageHandler", "InlineAIInfoListHandler", "InlineAIFeedbackHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InlineAIPlugin extends DocumentPluginV2 implements p, sa5.d, sa5.a {
    public static final a Companion = null;
    private static final String MENTION_ALL_ENABLE = "ccm.knowledge.inline_ai_mention_all_enable";
    private static final String TAG = "InlineAIPlugin";
    private String currentPanelStyle;
    private com.bytedance.ee.bear.document.ai.inlineai.a editPanel;
    private boolean hasnotifyOrientation;
    private wlb.c inlineAISdk;
    private pcb.a keyboardHeightProvider;
    private final Map<wlb.d.a, ocb.a> keyboardObserverMap;
    private m mCallback;
    private wlb.b mFeedbackCallback;
    private boolean mKeyboardShow;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<FeedbackData> {
        public final /* synthetic */ InlineAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(InlineAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r9, m r10) {
            FeedbackData r11 = (FeedbackData) r9;
            tt5.a.h(InlineAIPlugin.TAG, "inline AI InlineAIFeedbackHandler, data = " + r11);
            FeedbackConfig r12 = new FeedbackConfig(null, null, null, null, 15, null);
            String r0 = null;
            if (r11 == null) goto L5;
            String r1 = r11.getAiMessageId();
        L6:
            r12.setAiMessageId(r1);
            if (r11 == null) goto L9;
            String r2 = r11.getScenario();
        L10:
            r12.setScenario(r2);
            if (r11 == null) goto L13;
            String r3 = r11.getRequestRawdata();
        L14:
            r12.setRequestRawdata(r3);
            if (r11 == null) goto L17;
            r0 = r11.getAnswerRawdata();
        L17:
            r12.setAnswerRawdata(r0);
            wlb.b r13 = InlineAIPlugin.access$getMFeedbackCallback$p(this.a);
            if (r13 == null) goto L21;
            r13.a(r12);
            return;
        L21:
            return;
        L13:
            r3 = null;
            goto L14
        L9:
            r2 = null;
            goto L10
        L5:
            r1 = null;
            goto L6
        }
    }

    public final class c implements tb5.i<JSInfoList> {
        public final /* synthetic */ InlineAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(InlineAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r10, m r11) {
            JSInfoList r12 = (JSInfoList) r10;
            tt5.a.h(InlineAIPlugin.TAG, "inline AI info list, data = " + r12);
            String r1 = null;
            boolean r2 = true;
            wlb.c r3 = InlineAIPlugin.ensureSdk$default(this.a, null, 1, null);
            if (r3 != null) goto L5;
            tt5.a.d(InlineAIPlugin.TAG, "inline AI info list skipped, sdk unavailable");
            return;
        L5:
            if (r12 == null) goto L7;
            ArrayList<JSPromptGroup> r13 = r12.getData();
        L9:
            if (r13 == null) goto L17;
            ArrayList<JSPromptGroup> r14 = r12.getData();
            if (r14 != null) goto L13;
        L15:
            r2 = false;
        L16:
            if (r2 == true) goto L17;
        L18:
            int r16 = zz4.a.a;
            if (r12 == null) goto L21;
            ArrayList<JSPromptGroup> r17 = r12.getData();
        L22:
            ArrayList r4 = zz4.a.a(r17);
            if (r4 == null) goto L33;
            if (r12 == null) goto L26;
            r1 = r12.getMaskType();
        L26:
            String r5 = r1;
            if (r12 == null) goto L29;
            boolean r6 = r12.getUpdate();
        L30:
            wlb.c.a.a(r3, r4, r5, r6, null, 8);
            return;
        L29:
            r6 = false;
            goto L30
        L33:
            return;
        L21:
            r17 = null;
            goto L22
        L13:
            if (r14.size() != 0) goto L15;
        L17:
            r3.c();
            goto L18
        L7:
            r13 = null;
            goto L9
        }
    }

    public final class d implements tb5.i<String> {
        public final /* synthetic */ InlineAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(InlineAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            this.a.setMCallback(r2);
        }
    }

    public final class e implements tb5.i<JSInlineAIPanel> {
        public final /* synthetic */ InlineAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(InlineAIPlugin r1) {
            this.a = r1;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v0 ??, still in use, count: 1, list:
              (r5v0 ?? I:com.ss.android.lark.inline.ai.api.ui.Prompts) from 0x00ac: INVOKE (r5v0 ?? I:com.ss.android.lark.inline.ai.api.ui.Prompts), (r2v11 ?? I:java.util.ArrayList) VIRTUAL call: com.ss.android.lark.inline.ai.api.ui.Prompts.setData(java.util.ArrayList):void (LINE:33554604)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
            */
        @Override // tb5.i, tb5.o
        public final void handle(
        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v0 ??, still in use, count: 1, list:
              (r5v0 ?? I:com.ss.android.lark.inline.ai.api.ui.Prompts) from 0x00ac: INVOKE (r5v0 ?? I:com.ss.android.lark.inline.ai.api.ui.Prompts), (r2v11 ?? I:java.util.ArrayList) VIRTUAL call: com.ss.android.lark.inline.ai.api.ui.Prompts.setData(java.util.ArrayList):void (LINE:33554604)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r28v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
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
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.inlineai.InlineAIPlugin$ensureSdk$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.inlineai.InlineAIPlugin$ensureSdk$3", f = "InlineAIPlugin.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<wlb.c> $sdk;
        int label;
        final /* synthetic */ InlineAIPlugin this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.inlineai.InlineAIPlugin$ensureSdk$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ InlineAIPlugin a;

            public a(InlineAIPlugin r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                if (((Boolean) r2).booleanValue() == true) goto L6;
                ((com.bytedance.ee.bear.document.toolbar2.b) org.koin.java.a.c(com.bytedance.ee.bear.document.toolbar2.b.class, null, null, 6)).a(this.a.getHost());
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass3(Ref.ObjectRef<wlb.c> r1, InlineAIPlugin r2, Continuation<? super AnonymousClass3> r3) {
            this.$sdk = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.$sdk, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            wlb.c r6 = (wlb.c) this.$sdk.element;
            if (r6 == null) goto L18;
            i1 r7 = r6.isShowing();
            if (r7 == null) goto L18;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    public static final class f implements wlb.d {
        public final /* synthetic */ InlineAIPlugin a;

        public final int c() {
            pcb.a r0 = InlineAIPlugin.access$getKeyboardHeightProvider$p(this.a);
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getVisibleKeyboardHeight();
        }

        public final boolean isKeyboardShowing() {
            pcb.a r0 = InlineAIPlugin.access$getKeyboardHeightProvider$p(this.a);
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isKeyboardShowing();
        }

        public f(InlineAIPlugin r1) {
            this.a = r1;
        }

        public final void a(wlb.d.a r2) {
            Intrinsics.checkNotNullParameter(r2, "onKeyboardHeightChangeListener");
            ocb.a r3 = InlineAIPlugin.access$removeAndGetKeyboardObserver(this.a, r2);
            if (r3 == null) goto L8;
            pcb.a r0 = InlineAIPlugin.access$getKeyboardHeightProvider$p(this.a);
            if (r0 == null) goto L9;
            r0.b(r3);
            return;
        L9:
            return;
        }

        public final void b(wlb.d.a r3) {
            Intrinsics.checkNotNullParameter(r3, "onKeyboardHeightChangeListener");
            pcb.a r0 = InlineAIPlugin.access$getKeyboardHeightProvider$p(this.a);
            if (r0 == null) goto L6;
            r0.d(InlineAIPlugin.access$getOrCreateKeyboardObserver(this.a, r3));
            return;
        }
    }

    public static final class g implements wlb.f {
        public final /* synthetic */ Fragment a;

        public final int a() {
            return WindowInsetsUtils.b(this.a).a();
        }

        public g(Fragment r1) {
            this.a = r1;
        }

        public final void b(int r2) {
            WindowInsetsUtils.b(this.a).b(r2);
        }
    }

    public static final class h implements wlb.e {
        public final /* synthetic */ InlineAIPlugin a;
        public final /* synthetic */ JSInlineAIPanel b;

        public final void d() {
            tt5.a.h(InlineAIPlugin.TAG, "onImagesInsert");
            m r0 = this.a.getMCallback();
            if (r0 == null) goto L6;
            CallbackData.a r1 = CallbackData.Companion;
            boolean r2 = this.a.getMKeyboardShow();
            r1.getClass();
            r0.a(new CallbackData("imagesInsert", null, r2 ? 1 : 0));
            return;
        }

        public final void e() {
            tt5.a.h(InlineAIPlugin.TAG, "onClickStop");
            m r0 = this.a.getMCallback();
            if (r0 == null) goto L6;
            CallbackData.a r1 = CallbackData.Companion;
            boolean r2 = this.a.getMKeyboardShow();
            r1.getClass();
            r0.a(new CallbackData("stopBtnClick", null, r2 ? 1 : 0));
            return;
        }

        public final String g() {
            DocViewModel r0 = InlineAIPlugin.access$getDocViewModel(this.a);
            if (r0 == null) goto L6;
            String r1 = r0.getDocEncryptId();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return "";
        }

        public final void r() {
            m r0 = this.a.getMCallback();
            if (r0 == null) goto L6;
            CallbackData.a r1 = CallbackData.Companion;
            boolean r2 = this.a.getMKeyboardShow();
            r1.getClass();
            r0.a(new CallbackData("rangeClick", null, r2 ? 1 : 0));
            return;
        }

        public final void a(int r6) {
            tt5.a.h(InlineAIPlugin.TAG, "onHeightChange, height = " + r6);
            m r0 = this.a.getMCallback();
            if (r0 == null) goto L5;
            CallbackData.a r1 = CallbackData.Companion;
            boolean r2 = this.a.getMKeyboardShow();
            r1.getClass();
            r0.a(new CallbackData("changeHeight", Integer.valueOf(r6), r2 ? 1 : 0));
        L5:
            pcb.a r3 = InlineAIPlugin.access$getKeyboardHeightProvider$p(this.a);
            if (r3 == null) goto L8;
            int r4 = r3.getVisibleKeyboardHeight();
        L9:
            com.bytedance.ee.bear.document.ai.inlineai.a r5 = InlineAIPlugin.access$getEditPanel$p(this.a);
            if (r5 == null) goto L13;
            r5.a = r6 - r4;
            return;
        L13:
            return;
        L8:
            r4 = 0;
            goto L9
        }

        public final void b(boolean r5) {
            tt5.a.h(InlineAIPlugin.TAG, "onKeyboardChange, show = " + r5);
            this.a.setMKeyboardShow(r5);
            m r6 = this.a.getMCallback();
            if (r6 == null) goto L6;
            CallbackData.a r0 = CallbackData.Companion;
            boolean r1 = this.a.getMKeyboardShow();
            r0.getClass();
            r6.a(new CallbackData("changeKeyboard", null, r1 ? 1 : 0));
            return;
        }

        public final void f(String r5) {
            Intrinsics.checkNotNullParameter(r5, "url");
            tt5.a.h(InlineAIPlugin.TAG, "onLinkClicked, url = " + du5.b.f(r5));
            m r1 = this.a.getMCallback();
            if (r1 == null) goto L6;
            CallbackData.a r2 = CallbackData.Companion;
            boolean r3 = this.a.getMKeyboardShow();
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "url");
            HashMap r4 = new HashMap();
            r4.put("url", r5);
            r1.a(new CallbackData("openLink", r4, r3 ? 1 : 0));
            return;
        }

        public final void h(Object r6) {
            Intrinsics.checkNotNullParameter(r6, "text");
            if ((r6 instanceof String) == false) goto L8;
            StringBuilder r1 = new StringBuilder("onClickSend, String text length = ");
            String r7 = (String) r6;
            r1.append(r7.length());
            tt5.a.h(InlineAIPlugin.TAG, r1.toString());
            m r2 = this.a.getMCallback();
            if (r2 == null) goto L14;
            CallbackData.a r3 = CallbackData.Companion;
            boolean r4 = this.a.getMKeyboardShow();
            r3.getClass();
            Intrinsics.checkNotNullParameter(r7, "text");
            r2.a(new CallbackData("userPrompt", r7, r4 ? 1 : 0));
            return;
        L14:
            return;
        L8:
            if ((r6 instanceof TextResultContentList) == false) goto L12;
            tt5.a.h(InlineAIPlugin.TAG, "onClickSend, type: TextResultContentList");
            m r5 = this.a.getMCallback();
            if (r5 == null) goto L16;
            CallbackData.a r8 = CallbackData.Companion;
            TextResultContentList r9 = (TextResultContentList) r6;
            boolean r10 = this.a.getMKeyboardShow();
            r8.getClass();
            Intrinsics.checkNotNullParameter(r9, "text");
            r5.a(new CallbackData("userPrompt", r9, r10 ? 1 : 0));
            return;
        L16:
            return;
        L12:
            tt5.a.d(InlineAIPlugin.TAG, "onClickSend, err: unknown type");
        }

        public final void i(String r5) {
            Intrinsics.checkNotNullParameter(r5, "closeType");
            tt5.a.h(InlineAIPlugin.TAG, "onClosePanel, closeType = ".concat(r5));
            l35.k.d = false;
            InlineAIPlugin.access$notifyOrientationSupportPanelState(this.a, false);
            com.bytedance.ee.bear.document.ai.inlineai.a r6 = InlineAIPlugin.access$getEditPanel$p(this.a);
            if (r6 == null) goto L7;
            MutableLiveData<Boolean> r7 = r6.b;
            if (r7 == null) goto L7;
            r7.setValue(Boolean.FALSE);
        L7:
            m r8 = this.a.getMCallback();
            if (r8 == null) goto L11;
            CallbackData.a r0 = CallbackData.Companion;
            boolean r1 = this.a.getMKeyboardShow();
            r0.getClass();
            r8.a(new CallbackData("closePanel", null, r1 ? 1 : 0));
            return;
        }

        public final void j(Object r10) {
            Intrinsics.checkNotNullParameter("ccm_res", "type");
            Intrinsics.checkNotNullParameter(r10, "data");
            tt5.a.h(InlineAIPlugin.TAG, "onExtraOperation, type = ccm_res, data = " + r10);
            if (TextUtils.equals("ccm_res", "ccm_res") == false) goto L12;
            vv4.k r0 = this.a.getWebOrNull();
            if ((r0 instanceof z4) == false) goto L14;
            ConcurrentHashMap r11 = (ConcurrentHashMap) r10;
            ConcurrentHashMap<String, String> r1 = ((z4) r0).e();
            if (r1 == null) goto L15;
            Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();
        L10:
            if (r2.hasNext() == false) goto L16;
            Map.Entry<String, String> r3 = r2.next();
            String r4 = (String) r11.put((String) CollectionsKt.last(StringsKt.split$default(r3.getKey(), new String[]{"/"}, false, 0, 6, null)), r3.getValue());
            goto L10
        L16:
            return;
        L15:
            return;
        L14:
            return;
        }

        public final void k(Operate r5) {
            Intrinsics.checkNotNullParameter(r5, "operate");
            tt5.a.h(InlineAIPlugin.TAG, "onClickOperation, operate = " + r5);
            m r1 = this.a.getMCallback();
            if (r1 == null) goto L6;
            CallbackData.a r2 = CallbackData.Companion;
            boolean r3 = this.a.getMKeyboardShow();
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "operate");
            r1.a(new CallbackData("operate", r5, r3 ? 1 : 0));
            return;
        }

        public final void m(Prompt r5) {
            Intrinsics.checkNotNullParameter(r5, "prompt");
            m r1 = this.a.getMCallback();
            if (r1 == null) goto L6;
            CallbackData.Companion.getClass();
            Intrinsics.checkNotNullParameter(r5, "prompt");
            r1.a(new CallbackData("deleteHistoryPrompt", r5, 0));
            return;
        }

        public final void n(boolean r5) {
            tt5.a.h(InlineAIPlugin.TAG, "onNeedOnBoarding, needOnBoarding = " + r5);
            m r0 = this.a.getMCallback();
            if (r0 == null) goto L6;
            CallbackData.a r1 = CallbackData.Companion;
            boolean r2 = this.a.getMKeyboardShow();
            r1.getClass();
            r0.a(new CallbackData("onBoarding", Integer.valueOf(r5 ? 1 : 0), r2 ? 1 : 0));
            return;
        }

        public final void o(Map<String, Boolean> r8) {
            Intrinsics.checkNotNullParameter(r8, "downloadRes");
            tt5.a.h(InlineAIPlugin.TAG, "onImagesDownloadComplete, downloadRes = " + r8);
            m r1 = this.a.getMCallback();
            if (r1 == null) goto L11;
            CallbackData.a r2 = CallbackData.Companion;
            boolean r3 = this.a.getMKeyboardShow();
            r2.getClass();
            Intrinsics.checkNotNullParameter(r8, "downloadRes");
            ArrayList r0 = new ArrayList(r8.size());
            Iterator<Map.Entry<String, Boolean>> r9 = r8.entrySet().iterator();
        L6:
            if (r9.hasNext() == false) goto L8;
            Map.Entry<String, Boolean> r4 = r9.next();
            HashMap r5 = new HashMap();
            r5.put("id", r4.getKey());
            r5.put("success", r4.getValue());
            r0.add(r5);
            goto L6
        L8:
            r1.a(new CallbackData("imagesDownloadComplete", r0, r3 ? 1 : 0));
            return;
        }

        public final void onInputTextChange(String r5) {
            Intrinsics.checkNotNullParameter(r5, "text");
            tt5.a.h(InlineAIPlugin.TAG, "onInputTextChange, text length = " + r5.length());
            m r0 = this.a.getMCallback();
            if (r0 == null) goto L6;
            CallbackData.a r1 = CallbackData.Companion;
            boolean r2 = this.a.getMKeyboardShow();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r5, "input");
            r0.a(new CallbackData("changeInput", r5, r2 ? 1 : 0));
            return;
        }

        public final void p(boolean r5) {
            tt5.a.h(InlineAIPlugin.TAG, "onClickHistory, isNext = " + r5);
            m r0 = this.a.getMCallback();
            if (r0 == null) goto L10;
            CallbackData.a r1 = CallbackData.Companion;
            boolean r2 = this.a.getMKeyboardShow();
            r1.getClass();
            if (r5 == false) goto L7;
            String r6 = "next";
        L8:
            r0.a(new CallbackData("historyBtnClick", r6, r2 ? 1 : 0));
            return;
        L7:
            r6 = "pre";
            goto L8
        }

        public final void q(Prompt r5) {
            Intrinsics.checkNotNullParameter(r5, "prompt");
            tt5.a.h(InlineAIPlugin.TAG, "onClickPrompt, prompt = " + du5.b.k(r5.toString()));
            m r1 = this.a.getMCallback();
            if (r1 == null) goto L6;
            CallbackData.a r2 = CallbackData.Companion;
            boolean r3 = this.a.getMKeyboardShow();
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "prompt");
            r1.a(new CallbackData("prompt", r5, r3 ? 1 : 0));
            return;
        }

        public final void s(String r5) {
            Intrinsics.checkNotNullParameter(r5, "closeType");
            tt5.a.h(InlineAIPlugin.TAG, "onCloseConfirm, closeType = " + r5 + " ,jSInlineAIPanel = " + this.b);
            m r6 = this.a.getMCallback();
            if (r6 == null) goto L6;
            CallbackData.a r0 = CallbackData.Companion;
            boolean r1 = this.a.getMKeyboardShow();
            r0.getClass();
            r6.a(new CallbackData("closeConfirm", null, r1 ? 1 : 0));
            return;
        }

        public final void t(String r4) {
            Intrinsics.checkNotNullParameter(r4, "data");
            tt5.a.h(InlineAIPlugin.TAG, "onSendMessageToDocs, data = ".concat(r4));
            vv4.k r1 = this.a.getWebOrNull();
            if (r1 == null) goto L6;
            JSONObject r2 = new JSONObject();
            r2.put("data", r4);
            Unit r5 = Unit.INSTANCE;
            r1.j("javascript:window.lark.biz.inlineAI.messageFromRoadster", r2);
            return;
        }

        public h(InlineAIPlugin r1, JSInlineAIPanel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void c(String r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "id");
            tt5.a.h(InlineAIPlugin.TAG, "onImageCheck, id = " + r5 + ", checked = " + r6);
            m r1 = this.a.getMCallback();
            if (r1 == null) goto L6;
            CallbackData.a r2 = CallbackData.Companion;
            boolean r3 = this.a.getMKeyboardShow();
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "id");
            HashMap r4 = new HashMap();
            r4.put("id", r5);
            r4.put("checked", Boolean.valueOf(r6));
            r1.a(new CallbackData("imagesCheck", r4, r3 ? 1 : 0));
            return;
        }

        public final void l(boolean r4, wlb.b r5) {
            tt5.a.h(InlineAIPlugin.TAG, "onClickFeedback, like = " + r4);
            InlineAIPlugin.access$setMFeedbackCallback$p(this.a, r5);
            m r6 = this.a.getMCallback();
            if (r6 == null) goto L10;
            CallbackData.a r0 = CallbackData.Companion;
            boolean r1 = this.a.getMKeyboardShow();
            r0.getClass();
            if (r4 == false) goto L7;
            String r7 = "like";
        L8:
            r6.a(new CallbackData("feedbackClick", r7, r1 ? 1 : 0));
            return;
        L7:
            r7 = "unlike";
            goto L8
        }
    }

    public static final class i implements ocb.a {
        public final /* synthetic */ wlb.d.a a;

        public i(wlb.d.a r1) {
            this.a = r1;
        }

        public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
            this.a.a(r2);
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ InlineAIPlugin a;

        public j(InlineAIPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if (((Boolean) r1).booleanValue() == false) goto L6;
            this.a.destroy();
            return;
        }
    }

    public static final class k implements sy4.d {
        public final /* synthetic */ InlineAIPlugin a;

        public k(InlineAIPlugin r1) {
            this.a = r1;
        }

        @Override // sy4.d
        public final void a(sy4.b r2) {
            if ((r2 instanceof sy4.e) == true) goto L5;
            return;
        L5:
            if (((sy4.e) r2).b == false) goto L11;
            wlb.c r3 = InlineAIPlugin.access$getInlineAISdk$p(this.a);
            if (r3 == null) goto L12;
            r3.a();
            return;
        L12:
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public final void destroy() {
        tt5.a.h(TAG, "destroy=======");
        wlb.c r0 = this.inlineAISdk;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        wlb.c r1 = this.inlineAISdk;
        if (r1 == null) goto L9;
        r1.destroy();
        return;
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        wlb.c r0 = this.inlineAISdk;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onBackPressed();
    }

    public InlineAIPlugin() {
        this.keyboardObserverMap = new LinkedHashMap();
    }

    private final ScenarioType getScenario() {
        String r0 = getDocumentMetadata().getBearUrl().a;
        if (r0 == null) goto L23;
        switch(r0.hashCode()) {
            case -102775833: goto L19;
            case 99640: goto L15;
            case 3088960: goto L12;
            case 109403487: goto L8;
            default: goto L23;
        };
    L8:
        if (r0.equals("sheet") == false) goto L23;
        return ScenarioType.Sheet;
    L12:
        if (r0.equals("docx") == false) goto L23;
    L25:
        return ScenarioType.Doc;
    L15:
        if (r0.equals("doc") == true) goto L25;
    L19:
        if (r0.equals("bitable") == false) goto L23;
        return ScenarioType.Base;
    L23:
        return ScenarioType.UNKNOWN;
    }

    public final boolean enableAiEditAt() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L18;
        DocViewModel r2 = getDocViewModel();
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L18;
        return false;
    L12:
        if (r2.isDocumentType(sbb.e.o) != true) goto L14;
        r3 = true;
    L18:
        return true;
    L5:
        if (r0.isDocumentType(sbb.e.g) != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return !ku5.c.k(getContext());
    }

    public final m getMCallback() {
        return this.mCallback;
    }

    public final boolean getMKeyboardShow() {
        return this.mKeyboardShow;
    }

    public static final /* synthetic */ String access$getCurrentPanelStyle$p(InlineAIPlugin r0) {
        return r0.currentPanelStyle;
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(InlineAIPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.document.ai.inlineai.a access$getEditPanel$p(InlineAIPlugin r0) {
        return r0.editPanel;
    }

    public static final /* synthetic */ wlb.c access$getInlineAISdk$p(InlineAIPlugin r0) {
        return r0.inlineAISdk;
    }

    public static final /* synthetic */ pcb.a access$getKeyboardHeightProvider$p(InlineAIPlugin r0) {
        return r0.keyboardHeightProvider;
    }

    public static final /* synthetic */ wlb.b access$getMFeedbackCallback$p(InlineAIPlugin r0) {
        return r0.mFeedbackCallback;
    }

    private final wlb.c ensureSdk(JSInlineAIPanel r27) {
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        wlb.c r3 = this.inlineAISdk;
        r2.element = r3;
        if (r3 == null) goto L9;
        StringBuilder r4 = new StringBuilder("ensureSdk reuse sdk, style=");
        if (r27 == null) goto L7;
        String r0 = r27.getStyle();
    L8:
        r4.append(r0);
        r4.append(", scenario=");
        r4.append(getScenario());
        r4.append(", docType=");
        r4.append(getDocumentMetadata().getBearUrl().a);
        tt5.a.h(TAG, r4.toString());
        wlb.c r1 = (wlb.c) r2.element;
    L64:
        r2.element = r1;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getLifecycleOwner()), null, null, new AnonymousClass3(r2, this, null), 3, null);
        return (wlb.c) r2.element;
    L7:
        r0 = null;
        goto L8
    L9:
        DocViewModel r5 = getDocViewModel();
        if (r5 == null) goto L12;
        DocsOpenSource r6 = r5.getOpenSource();
    L14:
        if (r6 != DocsOpenSource.vc) goto L16;
        boolean r7 = true;
    L17:
        boolean r8 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        if (((dn4.a) getHost().getUserComponent().a(dn4.a.class)).a().isCurrentEnable(MENTION_ALL_ENABLE) == false) goto L20;
        MentionType r10 = MentionType.ALL;
    L21:
        boolean r11 = ForsetiHelper.s(getHost().getHostFragment());
        if (r27 == null) goto L24;
        String r12 = r27.getStyle();
    L25:
        boolean r13 = Intrinsics.areEqual(r12, JSInlineAIPanel.STYLE_FULLSCREEN);
        if (r7 == false) goto L28;
        ViewGroup r14 = getUIContainer().c(this);
    L30:
        ViewGroup r17 = r14;
    L66:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L57
        slb.b r18 = (slb.b) ClaymoreServiceLoader.loadFirst(slb.b.class);     // Catch: Throwable -> L57
        FragmentActivity r19 = getActivity();     // Catch: Throwable -> L57
        ScenarioType r110 = getScenario();     // Catch: Throwable -> L57
        Intrinsics.checkNotNullParameter(r19, "activity");     // Catch: Throwable -> L57
        Intrinsics.checkNotNullParameter(r110, "scenario");     // Catch: Throwable -> L57
        if (r13 == false) goto L35;
        slb.a r20 = new slb.a();     // Catch: Throwable -> L57
    L36:
        if (r8 == false) goto L39;
        if (r13 == false) goto L39;
        int r21 = 0;
    L40:
        if (r11 == false) goto L42;
        Fragment r9 = getHost().getHostFragment();     // Catch: Throwable -> L57
    L43:
        ((z) org.koin.java.a.c(z.class, null, null, 6)).isDebugEnabled(getContext());     // Catch: Throwable -> L57
        f r111 = new f(this);     // Catch: Throwable -> L57
        Intrinsics.checkNotNullParameter(r111, "keyboardHeightProvider");     // Catch: Throwable -> L57
        if (r7 == true) goto L46;
        boolean r22 = true;
    L47:
        wlb.a r112 = new wlb.a(r10, r22);     // Catch: Throwable -> L57
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L54;
        Fragment r23 = getHost().getHostFragment();     // Catch: Throwable -> L57
        if (r23 == null) goto L54;
        Fragment r24 = r23.getParentFragment();     // Catch: Throwable -> L57
        if (r24 == null) goto L54;
        g r26 = new g(r24);     // Catch: Throwable -> L57
    L55:
        wlb.c r28 = r18.createUISdk(new wlb.h(r19, r9, r17, r111, r112, r20, r21, false, r110, r26, true), new h(this, r27));     // Catch: Throwable -> L57
        this.inlineAISdk = r28;     // Catch: Throwable -> L57
        Object r29 = Result.constructor-impl(r28);     // Catch: Throwable -> L57
    L59:
        Throwable r30 = Result.exceptionOrNull-impl(r29);
        if (r30 == null) goto L63;
        tt5.a.e(TAG, "ensureSdk createUISdk failed, docType=" + getDocumentMetadata().getBearUrl().a + ", scenario=" + getScenario() + ", isOfficeSdk=" + r8 + ", reason=" + r30.getClass().getSimpleName() + ": " + r30.getMessage() + ". Likely missing IInlineAIApi implementation in host process.", r30, false);
        r29 = null;
    L63:
        r1 = (wlb.c) r29;
    L54:
        r26 = null;
        goto L55
    L46:
        r22 = false;
        goto L47
    L42:
        r9 = null;
    L39:
        r21 = -1;
        goto L40
    L35:
        r20 = null;
    L57:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L59
    L28:
        if (r11 == false) goto L31;
        r14 = getUIContainer().c(this);
        goto L30
    L31:
        r17 = null;
        goto L66
    L24:
        r12 = null;
        goto L25
    L20:
        r10 = MentionType.DOCUMENT;
        goto L21
    L16:
        r7 = false;
        goto L17
    L12:
        r6 = null;
        goto L14
    }

    private final ocb.a getOrCreateKeyboardObserver(wlb.d.a r3) {
        Map<wlb.d.a, ocb.a> r0 = this.keyboardObserverMap;
        ocb.a r1 = r0.get(r3);
        if (r1 != null) goto L6;
        r1 = new i(r3);
        r0.put(r3, r1);
    L6:
        return r1;
    }

    private final void handleOrientation(JSInlineAIPanel r3) {
        if (r3.getShow() == true) goto L5;
        this.hasnotifyOrientation = false;
        l35.k.d = false;
        notifyOrientationSupportPanelState(false);
        return;
    L5:
        if (this.hasnotifyOrientation == true) goto L7;
        notifyOrientationSupportPanelState(true);
    L7:
        l35.k.d = !TextUtils.isEmpty(r3.getContent());
        this.hasnotifyOrientation = true;
    }

    private final void notifyOrientationSupportPanelState(boolean r2) {
        BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r0 != null) goto L6;
        tt5.a.k(TAG, "can not find BaseUnspecifiedOrientationPlugin");
        return;
    L6:
        if (r2 == false) goto L8;
        r0.onOrientationSupportPanelShowing(this);
        return;
    L8:
        r0.onOrientationSupportPanelDismiss(this);
    }

    private final ocb.a removeAndGetKeyboardObserver(wlb.d.a r2) {
        return this.keyboardObserverMap.remove(r2);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.inlineAI.show", new e(this));
        r3.put("biz.inlineAI.message", new d(this));
        r3.put("biz.inlineAI.infoList", new c(this));
        r3.put("biz.inlineAI.feedback", new b(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r4) {
        super.onAttachToHost(r4);
        this.keyboardHeightProvider = pcb.a.a.b(getActivity());
        OopsPluginV2 r0 = (OopsPluginV2) findPlugin(OopsPluginV2.class);
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r1 = r0.getIsClickRefresh();
        if (r1 == null) goto L7;
        r1.observe(getLifecycleOwner(), new j(this));
    L7:
        FollowPlugin r2 = (FollowPlugin) findPlugin(FollowPlugin.class);
        if (r2 == null) goto L12;
        BaseFollowImpl r3 = r2.getDocumentFollow();
        if (r3 == null) goto L12;
        r3.registerDocFollowStateObserver(new k(this));
    L12:
        com.bytedance.ee.bear.document.ai.inlineai.a r5 = new com.bytedance.ee.bear.document.ai.inlineai.a();
        this.editPanel = r5;
        if (r4 == null) goto L15;
        Fragment r6 = r4.getHostFragment();
    L16:
        if (r6 == null) goto L25;
        Lazy r7 = FGDowngradeHelper.a;
        if (FGDowngradeHelper.b() == true) goto L25;
        LifecycleOwner r8 = r4.getHostFragment();
        if (r8 == null) goto L24;
        ((EditPanelsManager) new ViewModelProvider(getActivity()).get(EditPanelsManager.class)).registerEditPanel(r8, r5);
        return;
    L24:
        throw new IllegalArgumentException("Required value was null.".toString());
    L25:
        ((EditPanelsManager) new ViewModelProvider(getActivity()).get(EditPanelsManager.class)).registerEditPanel(getActivity(), r5);
        return;
    L15:
        r6 = null;
        goto L16
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r1) {
        super.onDetachFromHost(r1);
        destroy();
    }

    public final void setMCallback(m r1) {
        this.mCallback = r1;
    }

    public final void setMKeyboardShow(boolean r1) {
        this.mKeyboardShow = r1;
    }

    public static final /* synthetic */ wlb.c access$ensureSdk(InlineAIPlugin r0, JSInlineAIPanel r1) {
        return r0.ensureSdk(r1);
    }

    public static final /* synthetic */ ocb.a access$getOrCreateKeyboardObserver(InlineAIPlugin r0, wlb.d.a r1) {
        return r0.getOrCreateKeyboardObserver(r1);
    }

    public static final /* synthetic */ void access$handleOrientation(InlineAIPlugin r0, JSInlineAIPanel r1) {
        r0.handleOrientation(r1);
    }

    public static final /* synthetic */ void access$notifyOrientationSupportPanelState(InlineAIPlugin r0, boolean r1) {
        r0.notifyOrientationSupportPanelState(r1);
    }

    public static final /* synthetic */ ocb.a access$removeAndGetKeyboardObserver(InlineAIPlugin r0, wlb.d.a r1) {
        return r0.removeAndGetKeyboardObserver(r1);
    }

    public static final /* synthetic */ void access$setCurrentPanelStyle$p(InlineAIPlugin r0, String r1) {
        r0.currentPanelStyle = r1;
    }

    public static final /* synthetic */ void access$setInlineAISdk$p(InlineAIPlugin r0, wlb.c r1) {
        r0.inlineAISdk = r1;
    }

    public static final /* synthetic */ void access$setMFeedbackCallback$p(InlineAIPlugin r0, wlb.b r1) {
        r0.mFeedbackCallback = r1;
    }

    @Override // sa5.a
    public void onActivityResult(int r2, int r3, Intent r4) {
        wlb.c r0 = this.inlineAISdk;
        if (r0 == null) goto L6;
        r0.onActivityResult(r2, r3, r4);
        return;
    }

    public static /* synthetic */ wlb.c ensureSdk$default(InlineAIPlugin r0, JSInlineAIPanel r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.ensureSdk(r1);
    }
}
