package com.larus.bmhome.chat.trace;

import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileLocalPath;
import com.larus.im.bean.message.SendFile;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import yc9.n1;

/* JADX INFO: loaded from: classes26.dex */
public final class ChatMessageTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChatMessageTrace f310037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f310038b = null;

    public ChatMessageTrace() {
    }

    static {
        f310037a = new ChatMessageTrace();
        f310038b = LazyKt.lazy(new t());
    }

    public static final String a(List r100) {
        List r101 = r100;
        Iterator r102 = r101.iterator();
    L3:
        Object r103 = null;
        if (r102.hasNext() == false) goto L8;
        Object r104 = r102.next();
        if (com.larus.bmhome.chat.bean.d.G0((Message) r104) == false) goto L3;
    L9:
        Message r105 = (Message) r104;
        Iterator r106 = r101.iterator();
    L11:
        if (r106.hasNext() == false) goto L15;
        Object r107 = r106.next();
        if ((!com.larus.bmhome.chat.bean.d.G0((Message) r107)) == false) goto L11;
        r103 = r107;
    L15:
        Message r108 = (Message) r103;
        if (r105 == null) goto L19;
        if (r108 == null) goto L19;
        return "user_and_bot";
    L19:
        if (r105 == null) goto L21;
        return "user";
    L21:
        return "bot";
    L8:
        r104 = null;
        goto L9
    }

    public static final Object b(ChatMessageTrace r100, String r101, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof ChatMessageTrace$getVoice$1) == false) goto L7;
        ChatMessageTrace$getVoice$1 r102 = (ChatMessageTrace$getVoice$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        ChatMessageTrace$getVoice$1 r104 = r102;
        Object r105 = r104.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L29:
        BotModel r107 = (BotModel) r105;
        if (r107 != null) goto L34;
    L32:
        return null;
    L34:
        return r107.getVoiceType();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (r101 != null) goto L17;
    L20:
        boolean r108 = true;
    L21:
        if (r108 == true) goto L32;
        RepoDispatcher.f307729a.getClass();
        BotRepo r109 = RepoDispatcher.f307735g;
        if (r101 == null) goto L32;
        r104.label = 1;
        r105 = IBotRepoService.b.a(r109, r101, false, null, false, r104, 30);
        if (r105 != r111) goto L29;
        return r111;
    L17:
        if (r101.length() == 0) goto L20;
        r108 = false;
    L7:
        r102 = new ChatMessageTrace$getVoice$1(r100, r110);
        goto L8
    }

    public static void e(List r110, String r111, String r112, Integer r113, JSONObject r114) {
        Intrinsics.checkNotNullParameter(r110, "messages");
        Intrinsics.checkNotNullParameter(r111, "clickFrom");
        Intrinsics.checkNotNullParameter(r112, "botId");
        Intrinsics.checkNotNullParameter(r114, "traceInfo");
        if (r110.size() <= 1) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ChatMessageTrace$onMultipleMessageDelete$1(r114, r110, r112, r113, r111, null), 2, null);
        return;
    L5:
        Message r100 = (Message) CollectionsKt.firstOrNull(r110);
        if (r100 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r111, "clickFrom");
        Intrinsics.checkNotNullParameter(r112, "botId");
        Intrinsics.checkNotNullParameter(r114, "traceInfo");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ChatMessageTrace$onMessageDelete$1(r100, r112, r114, r113, r111, null), 2, null);
    }

    public static void d(List r110, String r111, Integer r112, boolean r113, String r114, JSONObject r115) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "botId");
        Intrinsics.checkNotNullParameter(r115, "traceInfo");
        if (r110.isEmpty() == false) goto L6;
        return;
    L6:
        if (r110.size() <= 1) goto L8;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ChatMessageTrace$onMultiMessageDeleteResult$1(r115, r110, r113, r111, r112, r114, null), 2, null);
        return;
    L8:
        Message r100 = (Message) CollectionsKt.firstOrNull(r110);
        if (r100 != null) goto L11;
        return;
    L11:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ChatMessageTrace$onSingleMessageDeleteResult$1(r100, r115, r113, r111, r112, r114, null), 2, null);
    }

    public static void c(final Message r110, final String r111, final String r112, final String r113, final String r114, final String r115, final String r116) {
        Intrinsics.checkNotNullParameter(r110, "message");
        Intrinsics.checkNotNullParameter(r111, "botId");
        Intrinsics.checkNotNullParameter(r112, "scene");
        ArrayList r100 = null;
        if (r110.getContentType() != 6) goto L21;
        List<Image> r101 = com.larus.bmhome.chat.bean.d.g(r110).imageList;
        if (r101 == null) goto L12;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        String r104 = ((Image) r103.next()).localResPath;
        if (r104 == null) goto L8;
        r102.add(r104);
    L13:
        if (r101 == null) goto L18;
        List<Image> r105 = r101;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L16:
        if (r107.hasNext() == false) goto L19;
        r106.add(((Image) r107.next()).key);
    L19:
        Pair r108 = new Pair(r102, r106);
    L75:
        List r117 = (List) r108.component1();
        List r109 = (List) r108.component2();
        Function0 r118 = new u(r110, r111, r112, r113, r114, r115, r116);
        int r119 = 0;
        if (r117 == null) goto L84;
        ArrayList r120 = new ArrayList();
        Iterator r121 = r117.iterator();
    L79:
        if (r121.hasNext() == false) goto L83;
        Object r122 = r121.next();
        if ((!StringsKt.contains$default((String) r122, (String) f310038b.getValue(), false, 2, null)) == false) goto L79;
        r120.add(r122);
        goto L79
    L83:
        r100 = r120;
    L84:
        if (r100 != null) goto L86;
    L88:
        boolean r123 = false;
    L90:
        if (r123 == false) goto L92;
        JSONObject r124 = (JSONObject) r118.invoke();
        r124.put("type", 0);
        r124.put("local_res_path", r100.toString());
        r124.put("illegal_count", r100.size());
        com.larus.platform.service.o.f365780a.reportEvent("dev_illegal_send_image_path", r124);
    L92:
        if (r109 == null) goto L113;
        List r125 = r109;
        if ((r125 instanceof Collection) == true) goto L96;
    L98:
        Iterator r126 = r125.iterator();
        int r127 = 0;
    L100:
        if (r126.hasNext() == false) goto L112;
        String r128 = (String) r126.next();
        if (r128 != null) goto L104;
    L107:
        boolean r129 = true;
    L108:
        if (r129 == false) goto L100;
        r127 = r127 + 1;
        if (r127 >= 0) goto L100;
        CollectionsKt.throwCountOverflow();
        goto L100
    L104:
        if (r128.length() == 0) goto L107;
        r129 = false;
        goto L108
    L112:
        r119 = r127;
        goto L113
    L96:
        if (r125.isEmpty() == false) goto L98;
    L113:
        if (r119 <= 0) goto L149;
        JSONObject r130 = (JSONObject) r118.invoke();
        r130.put("type", 1);
        r130.put("illegal_count", r119);
        com.larus.platform.service.o.f365780a.reportEvent("dev_illegal_send_image_path", r130);
        return;
    L149:
        return;
    L86:
        if ((!r100.isEmpty()) != true) goto L88;
        r123 = true;
        goto L90
    L18:
        r106 = null;
        goto L19
    L12:
        r102 = null;
        goto L13
    L21:
        if (r110.getContentType() != 7) goto L39;
        List<SendFile> r131 = com.larus.bmhome.chat.sendimage.e.f(r110.getContent()).getFileList();
        if (r131 == null) goto L30;
        ArrayList r132 = new ArrayList();
        Iterator<T> r133 = r131.iterator();
    L26:
        if (r133.hasNext() == false) goto L31;
        String r134 = ((SendFile) r133.next()).getLocalResPath();
        if (r134 == null) goto L26;
        r132.add(r134);
    L31:
        if (r131 == null) goto L36;
        List<SendFile> r135 = r131;
        ArrayList r136 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10));
        Iterator<T> r137 = r135.iterator();
    L34:
        if (r137.hasNext() == false) goto L37;
        r136.add(((SendFile) r137.next()).getTosKey());
    L37:
        r108 = new Pair(r132, r136);
        goto L75
    L36:
        r136 = null;
        goto L37
    L30:
        r132 = null;
        goto L31
    L39:
        if (lr8.c.a(r110) == false) goto L74;
        Map<String, String> r138 = r110.getBusinessExt();
        if (r138 == null) goto L52;
        String r139 = r138.get("nested_file_local_path_list");
        if (r139 == null) goto L52;
        List<NestedFileLocalPath> r140 = com.larus.bmhome.chat.sendimage.e.g(r139);
        if (r140 == null) goto L52;
        ArrayList r141 = new ArrayList();
        Iterator<T> r142 = r140.iterator();
    L48:
        if (r142.hasNext() == false) goto L53;
        String r143 = ((NestedFileLocalPath) r142.next()).getPath();
        if (r143 == null) goto L48;
        r141.add(r143);
    L53:
        List<UplinkFileEntity> r144 = com.larus.bmhome.chat.bean.d.f(r110).getEntities();
        if (r144 == null) goto L72;
        List<UplinkFileEntity> r145 = r144;
        ArrayList r146 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r145, 10));
        Iterator<T> r147 = r145.iterator();
    L57:
        if (r147.hasNext() == false) goto L73;
        UplinkFileEntity r148 = (UplinkFileEntity) r147.next();
        if (n1.d(r148) == false) goto L65;
        UplinkEntityContent r149 = r148.getUplinkEntityContent();
        if (r149 == null) goto L70;
        Image r150 = r149.getUplinkImageInfo();
        if (r150 == null) goto L70;
        String r151 = r150.key;
    L71:
        r146.add(r151);
    L70:
        r151 = null;
        goto L71
    L65:
        UplinkEntityContent r152 = r148.getUplinkEntityContent();
        if (r152 == null) goto L70;
        UplinkFileInfo r153 = r152.getUplinkFileInfo();
        if (r153 == null) goto L70;
        r151 = r153.getTosKey();
    L73:
        r108 = new Pair(r141, r146);
        goto L75
    L72:
        r146 = null;
    L52:
        r141 = null;
        goto L53
    L74:
        r108 = new Pair(null, null);
        goto L75
    }
}
