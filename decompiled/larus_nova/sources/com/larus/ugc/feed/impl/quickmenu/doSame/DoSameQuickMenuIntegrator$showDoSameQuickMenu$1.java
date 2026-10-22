package com.larus.ugc.feed.impl.quickmenu.doSame;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.Icon;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.uaigc.creation.ICreationService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.ugc.feed.impl.quickmenu.DismissReason;
import com.larus.ugc.feed.impl.quickmenu.QuickMenuConfig;
import com.larus.ugc.feed.impl.quickmenu.QuickMenuPanelFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import sq9.b0;
import v19.h;
import x0a.i;
import x0a.j;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ugc.feed.impl.quickmenu.doSame.DoSameQuickMenuIntegrator$showDoSameQuickMenu$1", f = "DoSameQuickMenuIntegrator.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {85}, m = "invokeSuspend", n = {"itemIds", "tplDetailInfo", "iconUrl", "showIconBorder", "showHighlightItem", "showUsePictureItem", "isDarkMode", "hasAvatar"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "Z$0", "Z$1"})
final class DoSameQuickMenuIntegrator$showDoSameQuickMenu$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function1<DismissReason, Unit> $onDismiss;
    final /* synthetic */ Function2<j, Integer, Unit> $onItemClick;
    final /* synthetic */ String $recommendFrom;
    final /* synthetic */ String $showFrom;
    final /* synthetic */ o0a.a $tracker;
    final /* synthetic */ UserCreation $userCreation;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    boolean Z$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DoSameQuickMenuIntegrator$showDoSameQuickMenu$1(UserCreation r100, FragmentActivity r101, o0a.a r102, String r103, String r104, Function2<? super j, ? super Integer, Unit> r105, Function1<? super DismissReason, Unit> r106, Continuation<? super DoSameQuickMenuIntegrator$showDoSameQuickMenu$1> r107) {
        this.$userCreation = r100;
        this.$activity = r101;
        this.$tracker = r102;
        this.$recommendFrom = r103;
        this.$showFrom = r104;
        this.$onItemClick = r105;
        this.$onDismiss = r106;
        super(2, r107);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new DoSameQuickMenuIntegrator$showDoSameQuickMenu$1(this.$userCreation, this.$activity, this.$tracker, this.$recommendFrom, this.$showFrom, this.$onItemClick, this.$onDismiss, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoSameQuickMenuIntegrator$showDoSameQuickMenu$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [T, com.larus.platform.api.creation.TplDetail] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r310) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        boolean r102 = this.Z$1;
        boolean r103 = this.Z$0;
        int r104 = this.I$1;
        int r105 = this.I$0;
        Ref.ObjectRef r106 = (Ref.ObjectRef) this.L$4;
        Ref.BooleanRef r110 = (Ref.BooleanRef) this.L$3;
        Ref.ObjectRef r111 = (Ref.ObjectRef) this.L$2;
        Ref.ObjectRef r112 = (Ref.ObjectRef) this.L$1;
        List r113 = (List) this.L$0;
        ResultKt.throwOnFailure(r310);
        Object r107 = r310;
    L126:
        String r108 = (String) r107;
        if (r108 != null) goto L129;
    L132:
        boolean r114 = true;
    L133:
        if (r114 == false) goto L135;
        String r109 = "res://" + AppHost.f326268a.getApplication().getPackageName() + "/2131241189";
    L136:
        boolean r115 = r102;
        boolean r116 = r103;
        int r117 = r104;
        Ref.BooleanRef r118 = r110;
        Ref.ObjectRef r119 = r106;
        T r120 = r109;
    L140:
        r119.element = r120;
        r113.add(DoSameQuickMenuType.REPLACE_PIC);
        final Ref.BooleanRef r210 = r118;
        final Ref.ObjectRef r121 = r111;
    L141:
        final Ref.ObjectRef r122 = r112;
        final boolean r211 = r116;
        r113.add(DoSameQuickMenuType.USE_PICTURE);
        r113.add("use_prompt");
        FragmentActivity r123 = this.$activity;
        if (r105 == 0) goto L146;
        final boolean r124 = true;
    L147:
        if (r117 == 0) goto L149;
        final boolean r212 = true;
    L150:
        final UserCreation r125 = this.$userCreation;
        final Function2<j, Integer, Unit> r126 = this.$onItemClick;
        final o0a.a r127 = this.$tracker;
        final String r128 = this.$recommendFrom;
        final String r129 = this.$showFrom;
        final Function1<DismissReason, Unit> r130 = this.$onDismiss;
        final boolean r213 = r115;
        Function1 r131 = new b(r124, r122, r121, r211, r210, r212, r125, r126, r127, r128, r129, r213, r130);
        Intrinsics.checkNotNullParameter(r123, "<this>");
        Intrinsics.checkNotNullParameter(r131, "builder");
        int r132 = com.larus.ugc.feed.impl.quickmenu.a.f374876a;
        com.larus.ugc.feed.impl.quickmenu.a.C4513a r133 = new com.larus.ugc.feed.impl.quickmenu.a.C4513a();
        r131.invoke(r133);
        Intrinsics.checkNotNullParameter(r123, "activity");
        FragmentManager r134 = r123.getSupportFragmentManager();
        Intrinsics.checkNotNullParameter(r134, "fragmentManager");
        i r135 = r133.f374877a;
        r135.getClass();
        QuickMenuConfig r136 = new QuickMenuConfig(null, CollectionsKt.toList(r135.f562066a), r135.f562067b, r135.f562068c, 1, null);
        Intrinsics.checkNotNullParameter(r134, "fragmentManager");
        Intrinsics.checkNotNullParameter(r136, "config");
        int r137 = QuickMenuPanelFragment.f374868i;
        Intrinsics.checkNotNullParameter(r136, "config");
        QuickMenuPanelFragment r138 = new QuickMenuPanelFragment();
        r138.setArguments(new Bundle());
        r138.f374870e = r136;
        LandscapeRestrictionOperation r139 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r138, "QuickMenuPanelFragment", r139);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r134, r138, r139) == false) goto L158;
    L155:
        Lazy r140 = e.f374898a;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1(r113, this.$tracker, this.$recommendFrom, this.$userCreation, this.$showFrom, r115, null), 3, null);
        return Unit.INSTANCE;
    L158:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L157
    L154:
        r138.show(r134, "QuickMenuPanelFragment");
        goto L155
    L149:
        r212 = false;
        goto L150
    L146:
        r124 = false;
        goto L147
    L135:
        r110.element = true;
        r109 = r108;
        goto L136
    L129:
        if (StringsKt.isBlank(r108) == true) goto L132;
        r114 = false;
        goto L133
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r310);
        r113 = new ArrayList();
        CreationDynamicInfo r141 = this.$userCreation.f364994h;
        String r142 = null;
        if (r141 == null) goto L13;
        TplInfo r143 = r141.f364915e;
        if (r143 == null) goto L13;
        TplDetail r144 = r143.f364973b;
    L15:
        if (r144 == null) goto L33;
        if (r141 == null) goto L20;
        TplInfo r145 = r141.f364915e;
        if (r145 == null) goto L20;
        TplDetail r146 = r145.f364974c;
    L21:
        if (r146 == null) goto L33;
        List r147 = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(2), Boxing.boxInt(1)});
        CreationDynamicInfo r148 = this.$userCreation.f364994h;
        if (r148 == null) goto L29;
        TplInfo r149 = r148.f364915e;
        if (r149 == null) goto L29;
        TplDetail r150 = r149.f364973b;
        if (r150 == null) goto L29;
        Integer r151 = r150.f364959a;
    L31:
        if (CollectionsKt.contains(r147, r151) == false) goto L33;
        r105 = 1;
    L34:
        b0 r152 = e.a();
        if (r152 == null) goto L37;
        String r153 = r152.useImageShowName;
    L38:
        if (r153 != null) goto L40;
    L43:
        boolean r154 = true;
    L44:
        if (r154 == true) goto L79;
        b0 r155 = e.a();
        if (r155 == null) goto L48;
        String r156 = r155.useImageShowDesc;
    L49:
        if (r156 != null) goto L51;
    L54:
        boolean r157 = true;
    L55:
        if (r157 == true) goto L79;
        b0 r158 = e.a();
        if (r158 == null) goto L59;
        String r159 = r158.usePromptShowName;
    L60:
        if (r159 != null) goto L62;
    L65:
        boolean r160 = true;
    L66:
        if (r160 == true) goto L79;
        b0 r161 = e.a();
        if (r161 == null) goto L70;
        String r162 = r161.usePromptShowDesc;
    L71:
        if (r162 != null) goto L73;
    L76:
        boolean r163 = true;
    L77:
        if (r163 == true) goto L79;
        r117 = 1;
    L80:
        r112 = new Ref.ObjectRef();
        r119 = new Ref.ObjectRef();
        r119.element = "";
        Ref.BooleanRef r164 = new Ref.BooleanRef();
        boolean r165 = h.f552477a;
        r116 = h.b(this.$activity);
        r115 = IUgcAIGCService.f373945a.v();
        if (r105 == 0) goto L142;
        if (r115 == false) goto L88;
        CreationDynamicInfo r166 = this.$userCreation.f364994h;
        if (r166 == null) goto L93;
        TplInfo r167 = r166.f364915e;
        if (r167 == null) goto L93;
        ?? r168 = r167.f364974c;
    L94:
        r112.element = r168;
        if (r116 == false) goto L100;
        if (r168 == 0) goto L104;
        Icon r169 = r168.f364964f;
        if (r169 == null) goto L104;
        r142 = r169.f364939b;
    L104:
        if (r142 != null) goto L106;
    L109:
        boolean r170 = true;
    L110:
        if (r170 == false) goto L139;
        TplDetail r171 = (TplDetail) r112.element;
        if (r171 == null) goto L119;
        Integer r172 = r171.f364959a;
        if (r172 == null) goto L119;
        if (r172.intValue() != 2) goto L119;
        boolean r173 = true;
    L120:
        if (r173 == false) goto L138;
        if (r115 == false) goto L137;
        ICreationService.Companion r174 = ICreationService.f372787a;
        this.L$0 = r113;
        this.L$1 = r112;
        this.L$2 = r119;
        this.L$3 = r164;
        this.L$4 = r119;
        this.I$0 = r105;
        this.I$1 = r117;
        this.Z$0 = r116;
        this.Z$1 = r115;
        this.label = 1;
        r107 = r174.a(this);
        if (r107 != r100) goto L125;
        return r100;
    L125:
        r104 = r117;
        r106 = r119;
        r103 = r116;
        r102 = r115;
        r110 = r164;
        r111 = r106;
        goto L126
    L137:
        r142 = "res://" + AppHost.f326268a.getApplication().getPackageName() + "/2131241189";
        goto L139
    L138:
        r164.element = true;
        r142 = this.$userCreation.e();
    L119:
        r173 = false;
    L139:
        r120 = r142;
        r118 = r164;
        r111 = r119;
        goto L140
    L106:
        if (StringsKt.isBlank(r142) == true) goto L109;
        r170 = false;
        goto L110
    L100:
        if (r168 == 0) goto L104;
        Icon r175 = r168.f364964f;
        if (r175 == null) goto L104;
        r142 = r175.f364938a;
    L93:
        r168 = 0;
        goto L94
    L88:
        CreationDynamicInfo r176 = this.$userCreation.f364994h;
        if (r176 == null) goto L93;
        TplInfo r177 = r176.f364915e;
        if (r177 == null) goto L93;
        r168 = r177.f364973b;
        goto L94
    L142:
        r121 = r119;
        r210 = r164;
        goto L141
    L73:
        if (r162.length() == 0) goto L76;
        r163 = false;
        goto L77
    L70:
        r162 = null;
        goto L71
    L62:
        if (r159.length() == 0) goto L65;
        r160 = false;
        goto L66
    L59:
        r159 = null;
        goto L60
    L51:
        if (r156.length() == 0) goto L54;
        r157 = false;
        goto L55
    L48:
        r156 = null;
    L79:
        r117 = 0;
        goto L80
    L40:
        if (r153.length() == 0) goto L43;
        r154 = false;
        goto L44
    L37:
        r153 = null;
    L29:
        r151 = null;
    L20:
        r146 = null;
    L33:
        r105 = 0;
    L13:
        r144 = null;
        goto L15
    }
}
