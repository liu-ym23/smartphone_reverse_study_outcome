package com.larus.bmhome.view.actionbar.edit.kmp;

import android.content.ClipData;
import android.content.Context;
import android.widget.LinearLayout;
import androidx.fragment.app.CompatKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.t1;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.bigimg.BigImagePhotoViewerDialog;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.api.IGaokaoPreferenceService;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.s;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.ButtonRouterTargetPageStarter;
import com.larus.bmhome.view.actionbar.edit.component.j2;
import com.larus.bmhome.view.actionbar.edit.component.p1;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpCommandWidget;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.home.impl.sdk.i1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.h0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import cq8.z0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import wa8.b0;
import wa8.c0;

/* JADX INFO: loaded from: classes26.dex */
public final class l implements dq8.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.bmhome.view.actionbar.edit.c f316585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KmpInstructionEditorViewFactory f316586b;

    @Override // dq8.g
    public final void a(boolean r100) {
        com.larus.bmhome.view.actionbar.edit.c r101 = this.f316585a;
        if (r101 == null) goto L6;
        r101.setImageStyleRadioSelected(r100);
        return;
    }

    @Override // dq8.g
    public final void b(dq8.a r210) {
        Intrinsics.checkNotNullParameter(r210, "event");
        a r100 = (a) this.f316586b.f316559o.getValue();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "event");
        String r101 = r210.f469686b.f294948c;
        FragmentActivity r102 = null;
        if (r101 == null) goto L5;
        String r103 = StringsKt.substringBefore$default(r101, "?", null, 2, null);
    L7:
        if (Intrinsics.areEqual(r103, "sslocal://flow/music_creation/write_lyrics") == false) goto L11;
        wy9.b r104 = (wy9.b) s1a.d.a(r100.f316563c).getAbility(wy9.b.class);
        if (r104 == null) goto L11;
        aq8.f r105 = r100.f316564d.ki(new aq8.c.b(null));
        if ((r105 instanceof aq8.f.c) == false) goto L15;
        aq8.f.c r106 = (aq8.f.c) r105;
    L16:
        if (r106 == null) goto L18;
        Object r107 = r106.f15953a;
    L20:
        if ((r107 instanceof List) == false) goto L22;
        List<u> r108 = (List) r107;
    L23:
        boolean r109 = r104.oX(r108);
    L24:
        if (r109 == false) goto L26;
        r100.c(r210);
        return;
    L26:
        Fragment r110 = r100.f316562b;
        if (r110 == null) goto L29;
        FragmentActivity r111 = r110.getActivity();
    L31:
        if ((r111 instanceof FragmentActivity) == true) goto L34;
        r111 = null;
    L34:
        if (r111 != null) goto L41;
        Context r112 = r100.f316561a.invoke();
        if ((r112 instanceof FragmentActivity) == false) goto L38;
        r102 = (FragmentActivity) r112;
    L38:
        if (r102 != null) goto L40;
        FLogger.f375446a.e("KmpInstructionButtonRouterDispatcher", "launchTargetPage failed, activity is null");
    L49:
        r100.c(r210);
        return;
    L40:
        r111 = r102;
    L41:
        ButtonRouterTargetPageStarter.a r113 = ButtonRouterTargetPageStarter.f316039f;
        String r114 = r210.f469686b.f294948c;
        String r115 = "";
        if (r114 != null) goto L44;
        r114 = "";
    L44:
        String r116 = r210.f469687c;
        if (r116 == null) goto L48;
        r115 = r116;
    L48:
        z0 r117 = r210.f469688d;
        j2 r118 = new j2(r114, r115, new p1(r117.f465010d, r117.f465012f, r117.f465013g, "chat", r117.f465009c, r117.f465007a, r100.b(), r117.f465016j, r210.f469686b.f294947b));
        b r119 = new b(r100, r210);
        r113.getClass();
        ButtonRouterTargetPageStarter.a.a(r111, r118, r119);
        goto L49
    L29:
        r111 = null;
        goto L31
    L22:
        r108 = null;
        goto L23
    L18:
        r107 = null;
        goto L20
    L15:
        r106 = null;
    L11:
        r109 = false;
        goto L24
    L5:
        r103 = null;
        goto L7
    }

    @Override // dq8.g
    public final void d(dq8.b r310) {
        Intrinsics.checkNotNullParameter(r310, "event");
        a r100 = (a) this.f316586b.f316559o.getValue();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r310, "event");
        z0 r101 = r310.f469692c;
        com.larus.bmhome.actionbar.model.a r102 = r310.f469691b;
        Map<String, b0> r103 = c0.f558840a;
        c0.b(r102.f294949d, ActionBarItemLocation.DETAIL_PANEL, null);
        String r104 = r101.f465007a;
        String r105 = r101.f465009c;
        String r106 = r101.f465010d;
        String r110 = r101.f465012f;
        String r111 = r101.f465013g;
        String r112 = r102.f294947b;
        String r113 = String.valueOf(r102.f294946a);
        Boolean r107 = r101.f465015i;
        String r108 = r101.f465014h;
        String r210 = r100.b();
        tx9.b.f(r104, r105, r106, r110, r111, null, null, r112, r113, 0, 0, null, null, null, r100.a(), "chat", null, null, null, r210, r108, r107, 964704);
    }

    @Override // dq8.g
    public final void e(String r100) {
        FLogger.f375446a.i("KmpInstructionEditorViewFactory", "[onMediaSelectorRemove] identifier=" + r100);
        KmpInstructionEditorViewFactory r101 = this.f316586b;
        int r102 = KmpInstructionEditorViewFactory.f316544p;
        com.larus.bmhome.instruction.kmp.a r103 = r101.o();
        if (r103 == null) goto L6;
        r103.nf(r100);
        return;
    }

    @Override // dq8.g
    public final void f(i0 r100) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        com.larus.bmhome.view.actionbar.edit.c r101 = this.f316585a;
        if (r101 == null) goto L6;
        r101.onTabSelected(r100);
        return;
    }

    @Override // dq8.g
    public final void i(boolean r100) {
        FLogger.f375446a.i("KmpInstructionEditorViewFactory", "[onMediaSelectorOpenAlbum] isReplace=" + r100);
        KmpInstructionEditorViewFactory r101 = this.f316586b;
        int r102 = KmpInstructionEditorViewFactory.f316544p;
        com.larus.bmhome.instruction.kmp.a r103 = r101.o();
        if (r103 == null) goto L6;
        r103.g80(r100);
        return;
    }

    @Override // dq8.g
    public final void j(int r100) {
        com.larus.bmhome.view.actionbar.edit.c r101 = this.f316585a;
        if (r101 == null) goto L6;
        r101.selectInstructionMenu(r100);
        return;
    }

    @Override // dq8.g
    public final void k(List<w> r100) {
        Intrinsics.checkNotNullParameter(r100, "optionList");
        com.larus.bmhome.view.actionbar.edit.c r101 = this.f316585a;
        if (r101 == null) goto L6;
        r101.setRatioOptionList(r100);
        return;
    }

    @Override // dq8.g
    public final void l(Long r100) {
        com.larus.bmhome.view.actionbar.edit.c r101 = this.f316585a;
        if (r101 == null) goto L6;
        r101.setDefaultSelectedImageStyleId(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.larus.bmhome.view.actionbar.edit.kmp.d] */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.larus.bmhome.view.actionbar.edit.kmp.c] */
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
    @Override // dq8.g
    public final void n(dq8.i r210) {
        Intrinsics.checkNotNullParameter(r210, "toHostCommand");
        final f r100 = (f) this.f316586b.f316557m.getValue();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "toHostCommand");
        String r101 = "";
        FragmentActivity r102 = null;
        Integer r103 = null;
        String r104 = null;
        if ((r210 instanceof dq8.i.c) == false) goto L57;
        dq8.i.c r105 = (dq8.i.c) r210;
        com.larus.bmhome.actionbar.model.c r106 = r105.f469701b;
        HashMap<String, String> r107 = r106.f295020c;
        if (r107 == null) goto L10;
        String r108 = r107.get(TTDelegateActivity.MESSAGE_TEXT);
        if (r108 == null) goto L10;
        String r109 = r108;
    L12:
        if (o0.d(r109) == false) goto L54;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L20
        y r111 = r100.f316574d.invoke();     // Catch: Throwable -> L20
        if (r111 == null) goto L17;
        String r112 = r111.Y1();     // Catch: Throwable -> L20
    L18:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r113) == false) goto L25;
        r113 = null;
    L25:
        String r114 = (String) r113;
        if (r114 != null) goto L28;
        String r115 = "";
    L29:
        String r116 = UUID.randomUUID().toString();
        s r117 = ILegacyChatUiServiceDelegate.f297164b.t8();
        if (r117 == null) goto L32;
        r117.d(r116);
    L32:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KmpInstructionCommandDispatcher$handleSendUserMessage$1(r115, null), 3, null);
        com.larus.bmhome.instruction.g r118 = r100.f316575e.invoke();
        Map<String, String> r119 = r100.f316579i.invoke(r106);
        Integer r120 = r106.f295018a;
        if (r120 == null) goto L35;
        String r121 = r120.toString();
    L36:
        if (r121 == null) goto L39;
        r101 = r121;
    L39:
        r119.put("action_bar_command_id", r101);
        if (r118 == null) goto L44;
        Map<String, String> r122 = r118.nK(null);
        if (r122 == null) goto L44;
        r119.putAll(r122);
    L44:
        if (r118 == null) goto L46;
        r103 = Integer.valueOf(r118.Q1());
    L46:
        if (r103 != null) goto L49;
    L51:
        String r123 = "chat_action_bar";
    L52:
        u1.a.f(zh8.a.f572196a.getSender(), r109, r115, r123, r119, null, null, r116, false, null, "KmpInstructionCommandDispatcher#handleSendUserMessage", null, (ChatPageContext) s1a.d.a(r100.f316578h).a(ChatPageContext.class), null, false, 27496);
        goto L54
    L49:
        if (r103.intValue() != 21) goto L51;
        r123 = "deep_research_sug";
        goto L52
    L35:
        r121 = null;
        goto L36
    L28:
        r115 = r114;
        goto L29
    L17:
        r112 = null;
    L20:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L54:
        if (Intrinsics.areEqual(r105.f469701b.f295027j, Boolean.TRUE) == true) goto L202;
        r100.f316572b.invoke();
        return;
    L202:
        return;
    L10:
        r109 = "";
        goto L12
    L57:
        if (Intrinsics.areEqual(r210, dq8.i.e.f469703b) == false) goto L64;
        IFlowSdkDepend r125 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r125 == null) goto L204;
        FlowAppletServiceImpl r126 = r125.g0();
        if (r126 == null) goto L205;
        h0.a.a(r126, new e(r100));
        return;
    L205:
        return;
    L204:
        return;
    L64:
        if ((r210 instanceof dq8.i.f) == false) goto L108;
        dq8.i.f r127 = (dq8.i.f) r210;
        AbsKmpInstructionWidget r128 = r100.f316571a.get(r127.f469704b);
        if ((r128 instanceof KmpCommandWidget) == false) goto L68;
        KmpCommandWidget r129 = (KmpCommandWidget) r128;
    L69:
        com.larus.bmhome.actionbar.model.c r130 = r127.f469705c;
        z0 r131 = r127.f469706d;
        zb8.e r132 = (zb8.e) s1a.d.a(r100.f316578h).getAbility(zb8.e.class);
        com.larus.bmhome.instruction.g r133 = r100.f316575e.invoke();
        HashMap r134 = new HashMap();
        if (r133 == null) goto L72;
        r134.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, String.valueOf(r133.Q1()));
    L72:
        String r135 = r131.f465013g;
        if (r135 == null) goto L75;
        r134.put("action_bar_key", r135);
    L75:
        String r136 = r131.f465010d;
        if (r136 == null) goto L78;
        r134.put("action_bar_template_type", r136);
    L78:
        Map<String, String> r137 = r100.f316579i.invoke(r130);
        HashMap<String, String> r138 = r130.f295020c;
        if (r138 == null) goto L83;
        String r139 = r138.get("disable_text_check");
        if (r139 == null) goto L83;
        r137.put("disable_text_check", r139);
    L83:
        HashMap<String, String> r140 = r130.f295020c;
        if (r140 == null) goto L87;
        String r141 = r140.get("scene");
        if (r141 == null) goto L87;
    L88:
        String r142 = r141;
        Integer r143 = r130.f295018a;
        if (r143 == null) goto L91;
        r104 = r143.toString();
    L91:
        if (r104 == null) goto L94;
        r101 = r104;
    L94:
        r137.put("action_bar_command_id", r101);
        if (Intrinsics.areEqual(r137.get("college_entrance_examination"), "1") == false) goto L97;
        r137.put("ban_action_bar_auto_shift", "1");
    L97:
        r134.put("extra_params", r137);
        HashMap<String, String> r144 = r130.f295020c;
        if (r144 == null) goto L101;
        String r145 = r144.get("click_from");
        if (r145 == null) goto L101;
    L102:
        r134.put("click_from", r145);
        if (r132 == null) goto L105;
        zb8.e.a.b(r132, r142, r134, null, null, null, false, 120);
    L105:
        if (r129 == null) goto L207;
        ViewExtKt.g(r129);
        return;
    L207:
        return;
    L101:
        r145 = "health_explain";
    L87:
        r141 = "health_second_camera";
        goto L88
    L68:
        r129 = null;
        goto L69
    L108:
        if (Intrinsics.areEqual(r210, dq8.i.b.f469700b) == false) goto L149;
        ICoreInputAbility r146 = r100.f316576f.invoke();
        boolean r147 = true;
        if (r146 == null) goto L113;
        r146.g2(1, true);
    L113:
        if (r146 == null) goto L115;
        ICoreInputAbility.b.e(r146, "KmpInstructionCommandDispatcher.PASTE_URL", null, false, 6);
    L115:
        Context r148 = r100.f316573c.invoke();
        if (r148 == null) goto L214;
        Result.Companion r149 = Result.Companion;     // Catch: Throwable -> L143
        IFlowSdkDepend r150 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L143
        if (r150 == null) goto L141;
        r150.d0();     // Catch: Throwable -> L143
        ClipData r151 = i1.f346188a.e(r148, "bpea-ai-podcast");     // Catch: Throwable -> L143
        if (r151 == null) goto L141;
        if (r151.getItemCount() <= 0) goto L138;
        CharSequence r152 = r151.getItemAt(0).getText();     // Catch: Throwable -> L143
        if (r152 != null) goto L129;
        CharSequence r153 = r101;
    L131:
        if (r153.length() <= 0) goto L133;
        boolean r154 = true;
    L134:
        if (r154 == false) goto L138;
        va8.o r155 = r100.f316577g.invoke();     // Catch: Throwable -> L143
        if (r155 == null) goto L139;
        r155.Ug(r153.toString());     // Catch: Throwable -> L143
    L139:
        if (r147 == true) goto L141;
        t19.s.f544207a.getClass();     // Catch: Throwable -> L143
        t19.s.t(r148, "Clipboard is empty");     // Catch: Throwable -> L143
        goto L141
    L133:
        r154 = false;
        goto L134
    L129:
        r153 = r152;
    L138:
        r147 = false;
    L141:
        Object r156 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L143
    L146:
        if (Result.m9452exceptionOrNullimpl(r156) == null) goto L209;
        t19.s.f544207a.getClass();
        t19.s.t(r148, "Paste failed");
        return;
    L209:
        return;
    L143:
        th = move-exception;
        Result.Companion r157 = Result.Companion;
        r156 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L146
    L214:
        return;
    L149:
        if ((r210 instanceof dq8.i.d) == false) goto L158;
        com.larus.bmhome.actionbar.model.c r158 = ((dq8.i.d) r210).f469702b;
        n r159 = n.f316589a;
        com.larus.bmhome.view.actionbar.edit.n r160 = n.f316590b;
        if (r160 == null) goto L211;
        String r161 = r158.f295021d;
        String r162 = r101;
        if (r161 == null) goto L156;
        r162 = r161;
    L156:
        r160.a(r162);
        return;
    L211:
        return;
    L158:
        if ((r210 instanceof dq8.i.a) == false) goto L195;
        dq8.i.a r163 = (dq8.i.a) r210;
        AbsKmpInstructionWidget r164 = r100.f316571a.get(r163.f469698b);
        if ((r164 instanceof KmpCommandWidget) == false) goto L162;
        KmpCommandWidget r165 = (KmpCommandWidget) r164;
    L163:
        final com.larus.bmhome.actionbar.model.c r166 = r163.f469699c;
        Context r167 = r100.f316573c.invoke();
        if (r167 != null) goto L170;
        if (r165 == null) goto L167;
        r167 = r165.getContext();
    L168:
        if (r167 != null) goto L170;
        return;
    L167:
        r167 = null;
    L170:
        final Context r168 = r167;
        Result.Companion r169 = Result.Companion;     // Catch: Throwable -> L177
        if (r165 == null) goto L174;
        Fragment r170 = CompatKt.findFragment(r165);     // Catch: Throwable -> L177
    L175:
        Object r171 = Result.m9449constructorimpl(r170);     // Catch: Throwable -> L177
    L180:
        if (Result.m9455isFailureimpl(r171) == false) goto L182;
        r171 = null;
    L182:
        Fragment r172 = (Fragment) r171;
        if (r172 == null) goto L216;
        FragmentActivity r173 = r172.getActivity();
        if ((r173 instanceof FragmentActivity) == false) goto L188;
        r102 = r173;
    L188:
        if (r102 == null) goto L217;
        LifecycleOwner r174 = r172.getViewLifecycleOwner();
        IGaokaoPreferenceService r175 = (IGaokaoPreferenceService) ServiceManager.get().getService(IGaokaoPreferenceService.class);
        if (r175 == 0) goto L213;
        r175.a(r102, r174, new c(r100, r166), new d(r168));
        return;
    L213:
        return;
    L217:
        return;
    L216:
        return;
    L174:
        r170 = null;
    L177:
        th = move-exception;
        Result.Companion r176 = Result.Companion;
        r171 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L180
    L162:
        r165 = null;
        goto L163
    L195:
        throw new NoWhenBranchMatchedException();
    }

    @Override // dq8.g
    public final void onInstructionMusicTemplateSelected(bq8.a r100) {
        com.larus.bmhome.view.actionbar.edit.c r101 = this.f316585a;
        if (r101 == null) goto L6;
        r101.onInstructionMusicTemplateSelected(r100);
        return;
    }

    public l(com.larus.bmhome.view.actionbar.edit.c r100, KmpInstructionEditorViewFactory r101) {
        this.f316585a = r100;
        this.f316586b = r101;
    }

    @Override // dq8.g
    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "from");
        if (Intrinsics.areEqual(this.f316586b.f316554j, r100) == true) goto L5;
        return;
    L5:
        this.f316586b.f316554j = null;
        com.larus.bmhome.view.actionbar.edit.c r102 = this.f316585a;
        if (r102 != null) goto L8;
        return;
    L8:
        r r103 = r102.getCurrentInstructionConf();
        if (r103 == null) goto L14;
        h1 r104 = r103.f295410c;
        if (r104 == null) goto L14;
        String r105 = r104.f295180a;
        if (r105 == null) goto L14;
    L15:
        r102.onInputHintChanged(r105, r101);
        return;
    L14:
        r105 = this.f316586b.f316553i;
        goto L15
    }

    @Override // dq8.g
    public final void g(t1 r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "paramFilterConf");
        com.larus.bmhome.view.actionbar.edit.c r102 = this.f316585a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101 == false) goto L7;
        r102.setOptionParamFilterConf(r100);
        return;
    L7:
        r102.onParamFilterConfChanged(r100);
    }

    @Override // dq8.g
    public final void h(String r210, String r211) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[onMediaSelectorPreview] hasUrl=");
        boolean r102 = true;
        if (r210 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        r101.append(!r103);
        r100.i("KmpInstructionEditorViewFactory", r101.toString());
        LinearLayout r104 = this.f316586b.f316552h;
        if (r104 != null) goto L13;
        return;
    L13:
        if (r211 != null) goto L15;
    L23:
        if (r210 != null) goto L25;
    L30:
        String r105 = null;
    L31:
        if (r105 != null) goto L33;
        return;
    L33:
        String r106 = r105;
    L42:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L36
        new BigImagePhotoViewerDialog(r104.getContext(), CollectionsKt.listOf(new n1(r106)), null, new uo8.k(MapsKt.emptyMap(), null), false, null, null, null, null, null, null, false, false, false, 32756).v(0, r104, "KmpInstructionEditorViewFactory");     // Catch: Throwable -> L36
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L38:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L44;
        FLogger.f375446a.e("KmpInstructionEditorViewFactory", "[onMediaSelectorPreview] error=" + r109.getMessage());
        return;
    L44:
        return;
    L36:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L25:
        if (r210.length() > 0) goto L28;
        r102 = false;
    L28:
        if (r102 == false) goto L30;
        r105 = r210;
        goto L31
    L15:
        if (r211.length() <= 0) goto L17;
        boolean r111 = true;
    L18:
        if (r111 == false) goto L20;
        r106 = r211;
    L21:
        if (r106 == null) goto L23;
    L20:
        r106 = null;
        goto L21
    L17:
        r111 = false;
        goto L18
    L5:
        if (StringsKt.isBlank(r210) == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // dq8.g
    public final void onInputHintChanged(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
        com.larus.bmhome.view.actionbar.edit.c r102 = this.f316585a;
        if (r102 == null) goto L6;
        r102.onInputHintChanged(r100, r101);
        return;
    }

    @Override // dq8.g
    public final void m(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "hint");
        Intrinsics.checkNotNullParameter(r102, "from");
        this.f316586b.f316554j = r100;
        com.larus.bmhome.view.actionbar.edit.c r103 = this.f316585a;
        if (r103 == null) goto L6;
        r103.onInputHintChanged(r101, r102);
        return;
    }
}
