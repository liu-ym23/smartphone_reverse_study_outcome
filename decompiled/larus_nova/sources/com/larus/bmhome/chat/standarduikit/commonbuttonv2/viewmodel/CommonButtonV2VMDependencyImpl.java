package com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel;

import android.content.Context;
import androidx.lifecycle.FlowLiveDataConversions;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes26.dex */
public final class CommonButtonV2VMDependencyImpl implements com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f309003b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f309004a;

    public static final class a {
    }

    public static final class b implements IIMCallback<List<? extends Message>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f309005a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        public b(Function0<Unit> r100) {
            this.f309005a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Function0<Unit> r101 = this.f309005a;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(List<? extends Message> r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bmhome/chat/standarduikit/commonbuttonv2/viewmodel/CommonButtonV2VMDependencyImpl$sendCreationMsg$relyInfo$1$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/CreationBtnReplayInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<wj8.b> {
        public c() {
        }
    }

    static {
    }

    public CommonButtonV2VMDependencyImpl() {
        this.f309004a = LazyKt.lazy(new com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.c());
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.b
    public final void a(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r100) {
        Intrinsics.checkNotNullParameter(r100, "vmData");
        Map<String, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d> r101 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.f308995a;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d r102 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a(r100.f309012g);
        if (r102 == null) goto L6;
        r102.d(r100);
        return;
    }

    public final Object c(Continuation<? super wc9.e> r100) {
        if ((r100 instanceof CommonButtonV2VMDependencyImpl$getMainBotConversation$1) == false) goto L7;
        CommonButtonV2VMDependencyImpl$getMainBotConversation$1 r101 = (CommonButtonV2VMDependencyImpl$getMainBotConversation$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L23:
        return (wc9.e) r103;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        ILaunchCacheService r106 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r106 == null) goto L19;
        wc9.e r107 = r106.b();
        if (r107 == null) goto L19;
        return r107;
    L19:
        Flow r108 = FlowLiveDataConversions.asFlow(AuthModelDelegate.f297134b.y());
        CommonButtonV2VMDependencyImpl$getMainBotConversation$cvs$2 r109 = new CommonButtonV2VMDependencyImpl$getMainBotConversation$cvs$2(null);
        r101.label = 1;
        r103 = kotlinx.coroutines.flow.e.t(r108, r109, r101);
        if (r103 != r104) goto L23;
        return r104;
    L7:
        r101 = new CommonButtonV2VMDependencyImpl$getMainBotConversation$1(this, r100);
        goto L8
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.b
    public final void b(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r100, Context r110) {
        Intrinsics.checkNotNullParameter(r100, "vmData");
        Map<String, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d> r101 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.f308995a;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d r102 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a(r100.f309012g);
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L9:
        if (r104 == false) goto L12;
        FLogger.f375446a.i("CommonButtonV2", "[onClickCommonButton] scene(" + r100.f309012g + ") is intercepted");
        return;
    L12:
        Integer r105 = r100.f309011f;
        String r106 = "";
        if (r105 != null) goto L16;
    L17:
        Message r107 = r100.f309014i;
        if (r107 == null) goto L23;
        Intrinsics.checkNotNullParameter(r107, "message");
        IChatRepoService r108 = zh8.a.f572196a;
        String r109 = r107.getLocalMessageId();
        if (r109 != null) goto L22;
        r109 = "";
    L22:
        r108.r1(r109, new f());
    L23:
        FLogger.f375446a.i("CommonButtonV2", "onClick, data=" + r100);
        Integer r111 = r100.f309011f;
        if (r111 == null) goto L44;
        if (r111.intValue() != 1) goto L44;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d r112 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a(r100.f309012g);
        String r113 = r100.f309010e;
        if (r113 == null) goto L33;
        r106 = r113;
    L33:
        if (r106.length() <= 0) goto L35;
        r103 = true;
    L35:
        if (r103 == false) goto L41;
        if (r110 == null) goto L41;
        i r114 = SmartRouter.buildRoute(r110, r106);
        if (r112 == null) goto L40;
        Intrinsics.checkNotNull(r114);
        r112.h(r114, r100);
    L40:
        r114.d();
    L41:
        if (r112 == null) goto L66;
        r112.a(r100);
        return;
    L66:
        return;
    L44:
        if (r111 != null) goto L47;
    L58:
        if (r111 != null) goto L61;
        return;
    L61:
        if (r111.intValue() != 2) goto L70;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO())), null, null, new CommonButtonV2VMDependencyImpl$onClickCommonButton$4(this, r100, null), 3, null);
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d r115 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a(r100.f309012g);
        if (r115 == null) goto L71;
        r115.a(r100);
        return;
    L71:
        return;
    L70:
        return;
    L47:
        if (r111.intValue() != 3) goto L58;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d r116 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a(r100.f309012g);
        Message r117 = r100.f309014i;
        if (r117 == null) goto L55;
        IChatRepoService r118 = zh8.a.f572196a;
        String r119 = r117.getLocalMessageId();
        if (r119 == null) goto L54;
        r106 = r119;
    L54:
        r118.r1(r106, new e());
    L55:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO())), null, null, new CommonButtonV2VMDependencyImpl$onClickCommonButton$3(this, r100, null), 3, null);
        if (r116 == null) goto L68;
        r116.a(r100);
        return;
    L68:
        return;
    L16:
        if (r105.intValue() == 1) goto L23;
    L5:
        if (r102.f(r100) != true) goto L7;
        r104 = true;
        goto L9
    }

    public final Object d(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r210, boolean r310, Function0<Unit> r311, Continuation<? super Unit> r312) {
        if ((r312 instanceof CommonButtonV2VMDependencyImpl$sendCreationMsg$1) == false) goto L7;
        CommonButtonV2VMDependencyImpl$sendCreationMsg$1 r100 = (CommonButtonV2VMDependencyImpl$sendCreationMsg$1) r312;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L19;
        if (r104 == 1) goto L18;
        if (r104 == 2) goto L17;
        if (r104 != 3) goto L16;
        boolean r105 = r100.Z$0;
        Message r106 = (Message) r100.L$5;
        wj8.b r107 = (wj8.b) r100.L$4;
        String r108 = (String) r100.L$3;
        wc9.e r109 = (wc9.e) r100.L$2;
        Function0<Unit> r110 = (Function0) r100.L$1;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r111 = (com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r112 = r108;
    L14:
        wc9.e r113 = r109;
        Message r114 = (Message) r102;
        LinkedHashMap r115 = new LinkedHashMap();
        if (r106 == null) goto L73;
        Map<String, String> r116 = r106.getExt();
        if (r116 == null) goto L73;
        String r117 = r116.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
        if (r117 == null) goto L73;
    L74:
        r115.put(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION, r117);
        Map<String, String> r118 = r111.f309013h;
        if (r118 == null) goto L78;
        String r119 = r118.get("creation_btn_rely_info");
        if (r119 == null) goto L78;
    L79:
        r115.put("creation_btn_rely_info", r119);
        r115.put("enter_method_trace", "chat_video_guide_button");
        if (r107 == null) goto L86;
        Long r120 = r107.c();
        if (r120 == null) goto L86;
        if (qq9.a.a(r120) != true) goto L86;
        boolean r121 = true;
    L87:
        if (r121 == false) goto L134;
        List<Long> r122 = r107.a();
        if (r122 == null) goto L95;
        Long r123 = (Long) CollectionsKt.firstOrNull(r122);
        if (r123 == null) goto L95;
        if (qq9.a.a(r123) != true) goto L95;
        boolean r124 = true;
    L96:
        if (r124 == false) goto L134;
        ArrayList r125 = new ArrayList();
        if (r114 == null) goto L100;
        NestedFileContent r126 = com.larus.bmhome.chat.bean.d.f(r114);
    L101:
        NestedFileContent r127 = r126;
        int r128 = wf9.b.f559489a;
        ai8.f r129 = new ai8.f(r127, com.flow.kmp.common.util.i.a(), null, null, r115, null, false, MessageStatus.MessageStatus_INVISIBLE, r111.f309022q, null, 620);
        if (r105 == true) goto L104;
        String r130 = r111.f309007b;
    L125:
        if (r130 != null) goto L127;
        String r131 = "";
    L128:
        int r132 = wf9.b.f559489a;
        String r133 = com.flow.kmp.common.util.i.a();
        if (r105 == false) goto L131;
        MessageStatus r134 = MessageStatus.MessageStatus_INVISIBLE;
    L132:
        Map r211 = null;
        ai8.h r135 = new ai8.h(r131, r133, r134, null, r115, r211, false, false, r111.f309022q, null, TTVideoEngineInterface.PLAYER_OPTION_SET_AUDIOTRACK_CONTENTTYPE);
        r125.add(r129);
        r125.add(r135);
        u1.a.e(RepoDispatcherDelegate.f307737b.e().u1(), r113, r112, "router_auto_send", r125, "router_auto_send", new b(r110), false, false, null, BDVideoUploaderBase.KeyIsDynamicSliceLowSize);
        FLogger.f375446a.i("CommonButtonV2VMDependencyImpl", "sendCreationMsg, isHiddenMsg: " + r105);
        goto L134
    L131:
        r134 = MessageStatus.MessageStatus_AVAILABLE;
        goto L132
    L127:
        r131 = r130;
        goto L128
    L104:
        if (r106 == null) goto L124;
        List<Block> r136 = r106.getContentBlock();
        if (r136 == null) goto L124;
        Iterator<T> r137 = r136.iterator();
    L109:
        if (r137.hasNext() == false) goto L116;
        Object r138 = r137.next();
        if (((Block) r138).getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L113;
        boolean r139 = true;
    L114:
        if (r139 == false) goto L109;
    L117:
        Block r140 = (Block) r138;
        if (r140 == null) goto L124;
        BlockContent r141 = r140.getContent();
        if (r141 == null) goto L124;
        TextBlock r142 = r141.getTextBlock();
        if (r142 == null) goto L124;
        r130 = r142.text;
        goto L125
    L113:
        r139 = false;
        goto L114
    L116:
        r138 = null;
    L124:
        r130 = null;
        goto L125
    L100:
        r126 = new NestedFileContent(null, null, false, null, 15, null);
    L95:
        r124 = false;
    L134:
        return Unit.INSTANCE;
    L86:
        r121 = false;
    L78:
        r119 = "";
    L73:
        r117 = "";
        goto L74
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r105 = r100.Z$0;
        r107 = (wj8.b) r100.L$4;
        String r143 = (String) r100.L$3;
        wc9.e r144 = (wc9.e) r100.L$2;
        Function0<Unit> r145 = (Function0) r100.L$1;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r146 = (com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r112 = r143;
        r109 = r144;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r147 = r146;
    L57:
        Message r148 = (Message) r102;
        IChatRepoService r149 = RepoDispatcherDelegate.f307737b.e();
        if (r107 == null) goto L62;
        List<Long> r150 = r107.a();
        if (r150 == null) goto L62;
        Long r151 = (Long) CollectionsKt.firstOrNull(r150);
    L63:
        String r152 = String.valueOf(r151);
        r100.L$0 = r147;
        r100.L$1 = r145;
        r100.L$2 = r109;
        r100.L$3 = r112;
        r100.L$4 = r107;
        r100.L$5 = r148;
        r100.Z$0 = r105;
        r100.label = 3;
        Object r153 = r149.E1(r152, r100);
        if (r153 != r103) goto L66;
        return r103;
    L66:
        r106 = r148;
        r102 = r153;
        r111 = r147;
        r110 = r145;
    L62:
        r151 = null;
        goto L63
    L18:
        boolean r154 = r100.Z$0;
        Function0<Unit> r155 = (Function0) r100.L$1;
        r147 = (com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L25:
        wc9.e r156 = (wc9.e) r102;
        boolean r157 = r154;
    L27:
        if (r156 != null) goto L32;
        if (r155 == null) goto L31;
        r155.invoke();
    L31:
        return Unit.INSTANCE;
    L32:
        String r158 = r147.f309017l;
        if (r158 != null) goto L37;
        r158 = r156.f559198a;
        if (r158 != null) goto L37;
        r112 = "";
    L135:
        Result.Companion r159 = Result.Companion;     // Catch: Throwable -> L44
        Gson r160 = (Gson) this.f309004a.getValue();     // Catch: Throwable -> L44
        Map<String, String> r161 = r147.f309013h;     // Catch: Throwable -> L44
        if (r161 == null) goto L41;
        String r162 = r161.get("creation_btn_rely_info");     // Catch: Throwable -> L44
    L42:
        Object r163 = Result.m9449constructorimpl((wj8.b) r160.fromJson(r162, new c().getType()));     // Catch: Throwable -> L44
    L47:
        if (Result.m9455isFailureimpl(r163) == false) goto L49;
        r163 = null;
    L49:
        wj8.b r164 = (wj8.b) r163;
        IChatRepoService r165 = RepoDispatcherDelegate.f307737b.e();
        if (r164 == null) goto L52;
        Long r166 = r164.c();
    L53:
        String r167 = String.valueOf(r166);
        r100.L$0 = r147;
        r100.L$1 = r155;
        r100.L$2 = r156;
        r100.L$3 = r112;
        r100.L$4 = r164;
        r100.Z$0 = r157;
        r100.label = 2;
        Object r168 = r165.E1(r167, r100);
        if (r168 != r103) goto L56;
        return r103;
    L56:
        r109 = r156;
        r145 = r155;
        r107 = r164;
        r105 = r157;
        r102 = r168;
        goto L57
    L52:
        r166 = null;
        goto L53
    L41:
        r162 = null;
    L44:
        th = move-exception;
        Result.Companion r169 = Result.Companion;
        r163 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L37:
        r112 = r158;
        goto L135
    L19:
        ResultKt.throwOnFailure(r102);
        wc9.e r170 = r210.f309016k;
        if (r170 != null) goto L26;
        r100.L$0 = r210;
        r155 = r311;
        r100.L$1 = r155;
        r100.Z$0 = r310;
        r100.label = 1;
        r102 = c(r100);
        if (r102 != r103) goto L24;
        return r103;
    L24:
        r147 = r210;
        r154 = r310;
        goto L25
    L26:
        r155 = r311;
        r156 = r170;
        r157 = r310;
        r147 = r210;
    L7:
        r100 = new CommonButtonV2VMDependencyImpl$sendCreationMsg$1(this, r312);
        goto L8
    }
}
