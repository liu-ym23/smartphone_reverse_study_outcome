package com.larus.bmhome.chat.list.cell.prompt;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class t0 implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f305703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f305704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PromptCell f305705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f305706d;

    public /* synthetic */ t0(boolean r100, String r101, PromptCell r102, String r103) {
        this.f305703a = r100;
        this.f305704b = r101;
        this.f305705c = r102;
        this.f305706d = r103;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object r510, Object r511, Object r512) {
        boolean r100 = this.f305703a;
        String r101 = this.f305704b;
        PromptCell r102 = this.f305705c;
        String r103 = this.f305706d;
        BotModel r104 = (BotModel) r510;
        boolean r105 = ((Boolean) r511).booleanValue();
        String r106 = (String) r512;
        if (r100 == false) goto L6;
        FLogger.f375446a.d("WcbSugPromptCell", "preLoad botInfo success >>>  botId " + r101 + "  ,message >> " + r106);
        return Unit.INSTANCE;
    L6:
        if (r105 == false) goto L101;
        FLogger r107 = FLogger.f375446a;
        r107.d("WcbSugPromptCell", "requireBot >>>  botId " + r101 + "  ,message >> " + r106);
        if (r104 == null) goto L100;
        Keva r108 = PromptCell.Y;
        r102.getClass();
        String r109 = r104.getBotId();
        if (r109 != null) goto L12;
        String r110 = "";
    L13:
        Integer r111 = r104.getBotType();
        BotIconImage r112 = r104.getIconImage();
        if (r112 == null) goto L16;
        String r113 = r112.getOriginUrl();
    L17:
        BotIconImage r114 = r104.getIconImage();
        if (r114 == null) goto L20;
        String r115 = r114.getUri();
    L21:
        BotIconImage r116 = r104.getIconImage();
        if (r116 == null) goto L24;
        String r117 = r116.getTinyUrl();
    L25:
        if (r117 != null) goto L27;
    L30:
        boolean r118 = true;
    L31:
        if (r118 == false) goto L35;
        BotIconImage r119 = r104.getIconImage();
        if (r119 == null) goto L39;
        String r120 = r119.getOriginUrl();
    L38:
        String r121 = r120;
    L40:
        BotIconImage r122 = new BotIconImage(r115, r121, r113, null, null, 24, null);
        String r123 = r104.getName();
        if (r123 != null) goto L43;
        String r124 = "";
    L44:
        BotOnBoarding r125 = r104.getOnBoarding();
        if (r125 == null) goto L50;
        String r126 = r125.getPrologue();
        if (r126 == null) goto L50;
        String r127 = r126;
    L51:
        BotOnBoarding r128 = r104.getOnBoarding();
        if (r128 == null) goto L54;
        List<String> r129 = r128.getSuggests();
    L55:
        BotOnBoarding r130 = r104.getOnBoarding();
        if (r130 == null) goto L61;
        String r131 = r130.getContent();
        if (r131 == null) goto L61;
        String r132 = r131;
    L62:
        com.larus.bmhome.chat.bean.BotOnBoarding r210 = new com.larus.bmhome.chat.bean.BotOnBoarding(r127, r129, r132, 2, 16);
        BotCreatorInfo r133 = r104.getBotCreatorInfo();
        if (r133 == null) goto L66;
        String r134 = r133.getName();
        if (r134 == null) goto L66;
    L67:
        BotCreatorInfo r135 = r104.getBotCreatorInfo();
        if (r135 == null) goto L71;
        String r136 = r135.getId();
        if (r136 == null) goto L71;
    L72:
        BotCreatorInfo r137 = r104.getBotCreatorInfo();
        if (r137 == null) goto L80;
        BotIconImage r138 = r137.getAvatar();
        if (r138 == null) goto L80;
        String r139 = r138.getUri();
        if (r139 == null) goto L80;
        String r410 = r139;
    L81:
        BotCreatorInfo r140 = r104.getBotCreatorInfo();
        if (r140 == null) goto L89;
        BotIconImage r141 = r140.getAvatar();
        if (r141 == null) goto L89;
        String r142 = r141.getTinyUrl();
        if (r142 == null) goto L89;
        String r411 = r142;
    L90:
        BotCreatorInfo r143 = r104.getBotCreatorInfo();
        if (r143 == null) goto L98;
        BotIconImage r144 = r143.getAvatar();
        if (r144 == null) goto L98;
        String r145 = r144.getOriginUrl();
        if (r145 == null) goto L98;
        String r412 = r145;
    L99:
        BotCreatorInfo r146 = new BotCreatorInfo(r134, r136, new BotIconImage(r410, r411, r412, null, null, 24, null));
        RecommendFrom r147 = new RecommendFrom("chat_suggestedprompt_click", r103, null, 4);
        String r310 = r104.getBgImgColor();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PromptCell$goToOtherChatPage$1(r102, new RecommendBot(r110, r124, r111, null, r122, 0, 0, 0, false, null, r210, r146, null, null, null, null, null, null, null, null, null, null, null, r104.getBgImgUrl(), r310, null, r104.getBgImgUri(), r104.getBgImgInfo(), null, null, null, null, null, null, false, r147, -1811949608, 7167), null), 3, null);
    L103:
        return Unit.INSTANCE;
    L98:
        r412 = "";
    L89:
        r411 = "";
    L80:
        r410 = "";
    L71:
        r136 = "";
    L66:
        r134 = "";
    L61:
        r132 = "";
        goto L62
    L54:
        r129 = null;
    L50:
        r127 = "";
        goto L51
    L43:
        r124 = r123;
    L39:
        r121 = null;
        goto L40
    L35:
        BotIconImage r148 = r104.getIconImage();
        if (r148 == null) goto L39;
        r120 = r148.getTinyUrl();
        goto L38
    L27:
        if (r117.length() == 0) goto L30;
        r118 = false;
        goto L31
    L24:
        r117 = null;
        goto L25
    L20:
        r115 = null;
        goto L21
    L16:
        r113 = null;
        goto L17
    L12:
        r110 = r109;
        goto L13
    L100:
        r107.d("WcbSugPromptCell", "error botModel is null >>>  botId " + r101 + " ,message >> " + r106);
        goto L103
    L101:
        FLogger.f375446a.d("WcbSugPromptCell", "error >>>  botId " + r101 + " ,message >> " + r106);
        goto L103
    }
}
