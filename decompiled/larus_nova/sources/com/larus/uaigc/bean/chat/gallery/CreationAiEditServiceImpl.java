package com.larus.uaigc.bean.chat.gallery;

import android.os.Bundle;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationAiEditService;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hy9.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jy9.b;
import jy9.c;
import jy9.g;
import jy9.h;
import jy9.i;
import jy9.j;
import jy9.l;
import jy9.m;
import jy9.n;
import jy9.o;
import jy9.p;
import jy9.q;
import jy9.s;
import jy9.t;
import jy9.y;
import jy9.z;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010\u000e\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00110\u000f*\u00020\u0007H\u0002J \u0010\u0012\u001a\u00020\u0013*\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002J4\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001e\u0010\u001d\u001a\u00020\u001e*\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u001c\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\"H\u0002J\u001c\u0010#\u001a\u0004\u0018\u00010\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\"H\u0002J\u0014\u0010)\u001a\u00020\u0017*\u00020\u00072\u0006\u0010(\u001a\u00020\"H\u0002JN\u0010*\u001a\u00020+*\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010,\u001a\u0004\u0018\u00010\t2\"\u0010-\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00110\u000fH\u0002JN\u0010.\u001a\u00020+*\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\"\u0010-\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00110\u000fH\u0002J,\u0010/\u001a\u00020+*\u00020\u00072\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\"H\u0002J\u0016\u00106\u001a\u00020+*\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002¨\u00068"}, d2 = {"Lcom/larus/uaigc/bean/chat/gallery/CreationAiEditServiceImpl;", "Lcom/larus/uaigc/service/ICreationAiEditService;", "<init>", "()V", "getCreationAiEditParams", "Lcom/larus/uaigc/bean/chat/gallery/CreationAiEditParams;", "aiEditContext", "Lcom/larus/uaigc/bean/chat/gallery/AiEditFeatureContext;", "generateImageEditParams", "Lcom/larus/uaigc/bean/chat/gallery/EditorDependency;", "botId", "", "generateImageGenerationParams", "generateVideoEditParams", "buildReplyTrackMapResolver", "Lkotlin/Function1;", "Lcom/larus/im/bean/message/Message;", "", "buildBeautifyEnv", "Lcom/larus/uaigc/bean/chat/gallery/BeautifyEnv;", "imageEditConfig", "curBotId", "reportEditFunctionClick", "", "report", "Lcom/larus/uaigc/bean/chat/gallery/EditFunctionReport;", "replyTrackMap", "creationTaskId", "reportEditFunctionShow", "buildHitPoint", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "enterMethod", "resolveCreatePageBotId", "openNewChatPage", "", "resolveCreatePageConversationId", "curCvsId", "shouldRetainCreationHomeMemoryForHostDetail", "buildDetailEditExtraBundle", "Landroid/os/Bundle;", "retainCreationHomeMemory", "dismissSourceDetailBeforeHostRoute", "buildVideoEditParams", "Lcom/larus/bmhome/chat/bean/AIEditParams;", "videoEditConfig", "replyTrackMapResolver", "buildImageEditParams", "buildImageBeautifyParams", "beautifyConfig", "Lcom/larus/uaigc/bean/chat/gallery/BeautifyConfig;", "instructionId", "", "buttonNameRes", "showAiEditFunction", "buildVideoExtendParams", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationAiEditServiceImpl implements ICreationAiEditService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f370346b = 0;

    public static final class a {
    }

    static {
    }

    public CreationAiEditServiceImpl() {
    }

    public static Bundle b(boolean r100) {
        Bundle r101 = f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "generated_img_edit")});
        if (r100 == false) goto L5;
        r101.putBoolean("retain_ai_creation_home_memory", true);
    L5:
        return r101;
    }

    public static z e(String r110) {
        e0 r100 = AuthModelDelegate.f297134b.e().getValue();
        if (r100 == null) goto L7;
        LaunchInfo r101 = r100.f297186a;
        if (r101 == null) goto L7;
        String r102 = r101.W();
    L8:
        IActionBarService r103 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r110 != null) goto L11;
        String r104 = "";
    L12:
        List<z0> r105 = r103.f(r104);
        boolean r106 = true;
        boolean r107 = false;
        if (r105 == null) goto L31;
        Iterator<T> r108 = r105.iterator();
    L16:
        if (r108.hasNext() == false) goto L28;
        Object r109 = r108.next();
        r r111 = ((z0) r109).f295621q;
        if (r111 == null) goto L25;
        Integer r112 = r111.f295408a;
        if (r112 == null) goto L25;
        if (r112.intValue() != 16) goto L25;
        boolean r113 = true;
    L26:
        if (r113 == false) goto L16;
    L29:
        z0 r114 = (z0) r109;
        if (r114 == null) goto L31;
    L49:
        if (r114 == null) goto L51;
    L93:
        r106 = false;
    L94:
        if (r114 == null) goto L98;
        r r115 = r114.f295621q;
        if (r115 == null) goto L98;
        r107 = Intrinsics.areEqual(r115.f295415h, Boolean.TRUE);
    L98:
        if (r107 == true) goto L100;
        return null;
    L100:
        return new z(r114, r106);
    L51:
        if (Intrinsics.areEqual(r102, r110) == true) goto L93;
        List<z0> r116 = r103.f(r102);
        if (r116 == null) goto L73;
        Iterator<T> r117 = r116.iterator();
    L56:
        if (r117.hasNext() == false) goto L68;
        Object r118 = r117.next();
        r r119 = ((z0) r118).f295621q;
        if (r119 == null) goto L65;
        Integer r120 = r119.f295408a;
        if (r120 == null) goto L65;
        if (r120.intValue() != 16) goto L65;
        boolean r121 = true;
    L66:
        if (r121 == false) goto L56;
    L69:
        z0 r122 = (z0) r118;
        if (r122 == null) goto L73;
        r114 = r122;
    L91:
        if (r114 == null) goto L93;
    L65:
        r121 = false;
        goto L66
    L68:
        r118 = null;
    L73:
        if (r116 == null) goto L90;
        Iterator<T> r123 = r116.iterator();
    L76:
        if (r123.hasNext() == false) goto L88;
        Object r124 = r123.next();
        r r125 = ((z0) r124).f295621q;
        if (r125 == null) goto L85;
        Integer r126 = r125.f295408a;
        if (r126 == null) goto L85;
        if (r126.intValue() != 4) goto L85;
        boolean r127 = true;
    L86:
        if (r127 == false) goto L76;
    L89:
        r114 = (z0) r124;
    L85:
        r127 = false;
        goto L86
    L88:
        r124 = null;
        goto L89
    L90:
        r114 = null;
    L25:
        r113 = false;
        goto L26
    L28:
        r109 = null;
    L31:
        if (r105 == null) goto L48;
        Iterator<T> r128 = r105.iterator();
    L34:
        if (r128.hasNext() == false) goto L46;
        Object r129 = r128.next();
        r r130 = ((z0) r129).f295621q;
        if (r130 == null) goto L43;
        Integer r131 = r130.f295408a;
        if (r131 == null) goto L43;
        if (r131.intValue() != 4) goto L43;
        boolean r132 = true;
    L44:
        if (r132 == false) goto L34;
    L47:
        r114 = (z0) r129;
    L43:
        r132 = false;
        goto L44
    L46:
        r129 = null;
        goto L47
    L48:
        r114 = null;
        goto L49
    L11:
        r104 = r110;
    L7:
        r102 = null;
        goto L8
    }

    public static void g(y r210) {
        d r100 = ICreationReportService.f373922a.j();
        String r101 = r210.f501062b;
        String r102 = r210.f501061a;
        String r103 = r210.f501063c;
        z r104 = r210.f501064d;
        if (r104 == null) goto L11;
        z0 r105 = r104.f501067a;
        if (r105 == null) goto L11;
        r r106 = r105.f295621q;
        if (r106 == null) goto L11;
        Integer r107 = r106.f295408a;
        if (r107 == null) goto L11;
        String r110 = r107.toString();
    L12:
        z r108 = r210.f501064d;
        if (r108 == null) goto L19;
        z0 r109 = r108.f501067a;
        if (r109 == null) goto L19;
        r r111 = r109.f295621q;
        if (r111 == null) goto L19;
        String r112 = r111.f295414g;
    L20:
        LruCache<String, e> r113 = ko8.a.f504531a;
        String r114 = ko8.a.h(ko8.a.f504535e);
        Message r115 = r210.f501065e;
        if (r115 == null) goto L23;
        Boolean r116 = Boolean.valueOf(com.larus.im.bean.message.a.C0(r115));
    L24:
        Message r117 = r210.f501065e;
        if (r117 == null) goto L27;
        String r118 = tz9.a.a(r117);
    L28:
        d.a.b(r100, r102, null, r210.f501066f, "picture_detail", r101, r103, null, r110, r112, r114, r116, r118, null, null, null, null, null, null, 1044546);
        return;
    L27:
        r118 = null;
        goto L28
    L23:
        r116 = null;
    L19:
        r112 = null;
    L11:
        r110 = null;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r0v30, types: [jy9.p] */
    /* JADX WARN: Type inference failed for: r15v0, types: [jy9.q] */
    @Override // com.larus.uaigc.service.ICreationAiEditService
    public final jy9.e a(final jy9.a r310) {
        Intrinsics.checkNotNullParameter(r310, "aiEditContext");
        BotModel r100 = r310.i();
        Function1 r101 = null;
        if (r100 == null) goto L5;
        final String r102 = r100.getBotId();
    L6:
        e0 r103 = AuthModelDelegate.f297134b.e().getValue();
        if (r103 == null) goto L11;
        LaunchInfo r104 = r103.f297186a;
        if (r104 == null) goto L11;
        String r105 = r104.W();
    L12:
        IActionBarService r106 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r102 != null) goto L15;
        String r107 = "";
    L16:
        List<z0> r108 = r106.f(r107);
        if (Intrinsics.areEqual(z2.f365865a.getCreationEditControlConfig().b(), Boolean.TRUE) == true) goto L19;
    L76:
        z r109 = e(r102);
    L77:
        final z r110 = r109;
        z r111 = e(r102);
        IActionBarService r112 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r102 != null) goto L80;
        String r113 = "";
    L81:
        List<z0> r114 = r112.f(r113);
        if (r114 == null) goto L99;
        Iterator<T> r115 = r114.iterator();
    L85:
        if (r115.hasNext() == false) goto L97;
        Object r116 = r115.next();
        r r117 = ((z0) r116).f295621q;
        if (r117 == null) goto L94;
        Integer r118 = r117.f295408a;
        if (r118 == null) goto L94;
        if (r118.intValue() != 24) goto L94;
        boolean r119 = true;
    L95:
        if (r119 == false) goto L85;
    L98:
        z0 r120 = (z0) r116;
    L100:
        if (r120 != null) goto L129;
        e0 r121 = AuthModelDelegate.f297134b.e().getValue();
        if (r121 == null) goto L106;
        LaunchInfo r122 = r121.f297186a;
        if (r122 == null) goto L106;
        String r123 = r122.W();
    L108:
        if (Intrinsics.areEqual(r123, r102) == true) goto L129;
        List<z0> r124 = r112.f(r123);
        if (r124 == null) goto L127;
        Iterator<T> r125 = r124.iterator();
    L113:
        if (r125.hasNext() == false) goto L125;
        Object r126 = r125.next();
        r r127 = ((z0) r126).f295621q;
        if (r127 == null) goto L122;
        Integer r128 = r127.f295408a;
        if (r128 == null) goto L122;
        if (r128.intValue() != 24) goto L122;
        boolean r129 = true;
    L123:
        if (r129 == false) goto L113;
    L126:
        r120 = (z0) r126;
    L128:
        boolean r130 = true;
    L130:
        if (r120 == null) goto L134;
        r r131 = r120.f295621q;
        if (r131 == null) goto L134;
        boolean r132 = Intrinsics.areEqual(r131.f295415h, Boolean.TRUE);
    L135:
        if (r132 == false) goto L137;
        final z r133 = new z(r120, r130);
    L138:
        final ?? r134 = new q(r310);
        c r135 = r310.a();
        if (r135 != null) goto L178;
        final q0 r136 = r310.getAdapter();
        if (r136 != null) goto L143;
        r135 = new c("", "", null, null, null, null, new jy9.r());
        goto L178
    L143:
        String r137 = r136.getChatParam().f296889a;
        if (r137 != null) goto L146;
        r137 = "";
    L146:
        Function0<Fragment> r138 = r136.getHostFragment();
        if (r138 == null) goto L149;
        final Fragment r139 = r138.invoke();
    L150:
        q0.a r140 = r136.getProvider();
        if (r140 == null) goto L155;
        com.larus.bmhome.chat.component.cvs.y r141 = r140.u0();
        if (r141 == null) goto L155;
        e r142 = r141.h();
    L156:
        q0.a r143 = r136.getProvider();
        if (r143 == null) goto L159;
        final u7 r210 = r143.u3();
    L160:
        if (r139 == null) goto L162;
        final IChatDoubleTabAbility r211 = (IChatDoubleTabAbility) s1a.a.g(r139).getAbility(IChatDoubleTabAbility.class);
    L163:
        q0.a r144 = r136.getProvider();
        if (r144 == null) goto L166;
        final ICoreInputAbility r145 = r144.v0();
    L167:
        if (r145 == null) goto L169;
        Function1 r146 = new s(r145);
    L170:
        if (r139 == null) goto L172;
        final Fragment r147 = r139;
        final String r148 = r137;
        final ICoreInputAbility r212 = r145;
        Function4 r213 = new t(r147, r148, r136, r210, r211, r212);
    L173:
        if (r139 == null) goto L177;
        final FragmentManager r149 = r139.getParentFragmentManager();
        if (r149 == null) goto L177;
        r101 = new g(r310, r149);
    L177:
        String r150 = r137;
        c r151 = new c(r150, r136.getChatParam().f296890b, r142, r146, r213, r101, new h(r310, r139));
    L179:
        b r152 = new b(r102, r111, r134, r151);
        final String r153 = r151.f500973a;
        if (r133 == null) goto L182;
        boolean r154 = true;
    L183:
        final String r155 = r102;
        final z r156 = r133;
        ic8.d r214 = new ic8.d(r154, new m(this, r310, r155, r156, r134, r153), new n(this, r310, r102, r133), false, null, null, 56);
        final String r157 = r151.f500973a;
        if (r110 == null) goto L186;
        boolean r158 = true;
    L187:
        final String r159 = r102;
        ic8.d r160 = new ic8.d(r158, new i(this, r310, r159, r110, r134, r157), new j(this, r310, r102, r110), false, null, null, 56);
        if (r111 == null) goto L194;
        z0 r161 = r111.f501067a;
        if (r161 == null) goto L194;
        r r162 = r161.f295621q;
        if (r162 == null) goto L194;
        boolean r163 = Intrinsics.areEqual(r162.f295415h, Boolean.TRUE);
    L195:
        ic8.d r215 = c(r310, r152, 3, R.string.larus_imageDetail_btn_remove, r163);
        if (r111 == null) goto L202;
        z0 r164 = r111.f501067a;
        if (r164 == null) goto L202;
        r r165 = r164.f295621q;
        if (r165 == null) goto L202;
        boolean r166 = Intrinsics.areEqual(r165.f295415h, Boolean.TRUE);
    L203:
        if (r166 == false) goto L212;
        Message r167 = r310.getMessage();
        if (r167 != null) goto L207;
    L209:
        boolean r168 = false;
    L210:
        if (r168 == true) goto L212;
        boolean r169 = true;
    L213:
        ic8.d r170 = c(r310, r152, 2, R.string.larus_imageDetail_btn_outpaint, r169);
        if (r111 == null) goto L220;
        z0 r171 = r111.f501067a;
        if (r171 == null) goto L220;
        r r172 = r171.f295621q;
        if (r172 == null) goto L220;
        boolean r173 = Intrinsics.areEqual(r172.f295415h, Boolean.TRUE);
    L221:
        if (r173 == false) goto L230;
        Message r174 = r310.getMessage();
        if (r174 != null) goto L225;
    L227:
        boolean r175 = false;
    L228:
        if (r175 == true) goto L230;
        boolean r176 = true;
    L232:
        return new jy9.e(r214, r160, r170, r215, c(r310, r152, 1, R.string.larus_imageDetail_btn_upscale, r176), new ic8.d(z2.f365865a.getCreationExtendVideoConfig().b(), null, new o(), false, null, new p(r310), 26));
    L225:
        if (com.larus.bmhome.chat.bean.d.y(r174) != true) goto L227;
        r175 = true;
    L230:
        r176 = false;
    L220:
        r173 = false;
        goto L221
    L207:
        if (com.larus.bmhome.chat.bean.d.y(r167) != true) goto L209;
        r168 = true;
    L212:
        r169 = false;
    L202:
        r166 = false;
    L194:
        r163 = false;
        goto L195
    L186:
        r158 = false;
        goto L187
    L182:
        r154 = false;
        goto L183
    L172:
        r213 = null;
        goto L173
    L169:
        r146 = null;
        goto L170
    L166:
        r145 = null;
        goto L167
    L162:
        r211 = null;
        goto L163
    L159:
        r210 = null;
    L155:
        r142 = null;
        goto L156
    L149:
        r139 = null;
    L178:
        r151 = r135;
        goto L179
    L137:
        r133 = null;
    L134:
        r132 = false;
    L122:
        r129 = false;
        goto L123
    L125:
        r126 = null;
        goto L126
    L127:
        r120 = null;
    L106:
        r123 = null;
    L129:
        r130 = false;
    L94:
        r119 = false;
        goto L95
    L97:
        r116 = null;
        goto L98
    L99:
        r120 = null;
        goto L100
    L80:
        r113 = r102;
        goto L81
    L19:
        if (r108 == null) goto L47;
        Iterator<T> r177 = r108.iterator();
    L22:
        if (r177.hasNext() == false) goto L34;
        Object r178 = r177.next();
        r r179 = ((z0) r178).f295621q;
        if (r179 == null) goto L31;
        Integer r180 = r179.f295408a;
        if (r180 == null) goto L31;
        if (r180.intValue() != 28) goto L31;
        boolean r181 = true;
    L32:
        if (r181 == false) goto L22;
    L35:
        z0 r182 = (z0) r178;
        if (r182 == null) goto L47;
        r r183 = r182.f295621q;
        if (r183 == null) goto L40;
        boolean r184 = Intrinsics.areEqual(r183.f295415h, Boolean.TRUE);
    L41:
        if (r184 == true) goto L44;
        r182 = null;
    L44:
        if (r182 == null) goto L47;
        r109 = new z(r182, false);
        goto L77
    L40:
        r184 = false;
    L31:
        r181 = false;
        goto L32
    L34:
        r178 = null;
    L47:
        if (Intrinsics.areEqual(r105, r102) == true) goto L76;
        List<z0> r185 = r106.f(r105);
        if (r185 == null) goto L73;
        Iterator<T> r186 = r185.iterator();
    L52:
        if (r186.hasNext() == false) goto L64;
        Object r187 = r186.next();
        r r188 = ((z0) r187).f295621q;
        if (r188 == null) goto L61;
        Integer r189 = r188.f295408a;
        if (r189 == null) goto L61;
        if (r189.intValue() != 28) goto L61;
        boolean r190 = true;
    L62:
        if (r190 == false) goto L52;
    L65:
        z0 r191 = (z0) r187;
        if (r191 == null) goto L73;
        r r192 = r191.f295621q;
        if (r192 == null) goto L70;
        boolean r193 = Intrinsics.areEqual(r192.f295415h, Boolean.TRUE);
    L71:
        if (r193 == false) goto L73;
    L74:
        if (r191 == null) goto L76;
        r109 = new z(r191, true);
        goto L77
    L70:
        r193 = false;
    L61:
        r190 = false;
        goto L62
    L64:
        r187 = null;
    L73:
        r191 = null;
        goto L74
    L15:
        r107 = r102;
    L11:
        r105 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public static void d(jy9.a r100, boolean r101) {
        if (r101 == true) goto L33;
        return;
    L33:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L27
        r100.b();     // Catch: Throwable -> L27
        Fragment r103 = r100.g();     // Catch: Throwable -> L27
        if (r103 == null) goto L8;
        FragmentActivity r104 = r103.getActivity();     // Catch: Throwable -> L27
        if (r104 == null) goto L8;
    L16:
        if (r104 == null) goto L25;
        FragmentManager r105 = r104.getSupportFragmentManager();     // Catch: Throwable -> L27
        if (r105 == null) goto L25;
        Fragment r106 = r105.findFragmentByTag("ChatGalleryDialog");     // Catch: Throwable -> L27
        if (r106 != null) goto L23;
        r106 = r105.findFragmentByTag("ChatCreationPagerFragment");     // Catch: Throwable -> L27
    L23:
        if (r106 == null) goto L25;
        FragmentTransaction r107 = r105.beginTransaction();     // Catch: Throwable -> L27
        r107.remove(r106);     // Catch: Throwable -> L27
        r107.commitAllowingStateLoss();     // Catch: Throwable -> L27
    L25:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L35;
        FLogger.f375446a.e("CreationAiEditHelper", "dismiss source detail before host route failed", r109);
        return;
    L35:
        return;
    L8:
        q0 r110 = r100.getAdapter();     // Catch: Throwable -> L27
        if (r110 == null) goto L15;
        Function0<Fragment> r111 = r110.getHostFragment();     // Catch: Throwable -> L27
        if (r111 == null) goto L15;
        Fragment r112 = r111.invoke();     // Catch: Throwable -> L27
        if (r112 == null) goto L15;
        r104 = r112.getActivity();     // Catch: Throwable -> L27
    L15:
        r104 = null;
    L27:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    }

    public static void f(y r210, Map r211, String r212) {
        d r100 = ICreationReportService.f373922a.j();
        String r101 = r210.f501061a;
        String r102 = r210.f501062b;
        String r103 = r210.f501063c;
        z r104 = r210.f501064d;
        if (r104 == null) goto L11;
        z0 r105 = r104.f501067a;
        if (r105 == null) goto L11;
        r r106 = r105.f295621q;
        if (r106 == null) goto L11;
        Integer r107 = r106.f295408a;
        if (r107 == null) goto L11;
        String r110 = r107.toString();
    L12:
        z r108 = r210.f501064d;
        if (r108 == null) goto L19;
        z0 r109 = r108.f501067a;
        if (r109 == null) goto L19;
        r r111 = r109.f295621q;
        if (r111 == null) goto L19;
        String r112 = r111.f295414g;
    L20:
        LruCache<String, e> r113 = ko8.a.f504531a;
        String r114 = ko8.a.h(ko8.a.f504535e);
        Message r115 = r210.f501065e;
        if (r115 == null) goto L23;
        Boolean r116 = Boolean.valueOf(com.larus.im.bean.message.a.C0(r115));
    L24:
        Message r117 = r210.f501065e;
        if (r117 == null) goto L27;
        String r118 = tz9.a.a(r117);
    L28:
        String r119 = r210.f501066f;
        if (r211 == null) goto L31;
        String r120 = (String) r211.get("recommend_from");
    L32:
        if (r211 == null) goto L34;
        String r121 = (String) r211.get("from_template_id");
    L35:
        if (r211 == null) goto L37;
        String r122 = (String) r211.get("template_rec_extra");
    L38:
        if (r211 == null) goto L40;
        String r123 = (String) r211.get("template_rec_req_id");
    L41:
        d.a.a(r100, r101, null, r119, "picture_detail", r102, r103, null, r110, r112, r114, r116, r118, r120, r121, r123, r122, null, r212, null, null, null, 3997762);
        return;
    L40:
        r123 = null;
        goto L41
    L37:
        r122 = null;
        goto L38
    L34:
        r121 = null;
        goto L35
    L31:
        r120 = null;
        goto L32
    L27:
        r118 = null;
        goto L28
    L23:
        r116 = null;
    L19:
        r112 = null;
    L11:
        r110 = null;
        goto L12
    }

    public final ic8.d c(final jy9.a r110, final b r111, final int r112, final int r113, boolean r114) {
        z r100 = r111.f500970b;
        if (r100 != null) goto L5;
    L7:
        final boolean r101 = false;
    L9:
        return new ic8.d(r114, new jy9.f(r112, r110, r111, r101, this, r113), new l(this, r110, r113, r111, r112), false, null, null, 56);
    L5:
        if (r100.f501068b != true) goto L7;
        r101 = true;
        goto L9
    }
}
