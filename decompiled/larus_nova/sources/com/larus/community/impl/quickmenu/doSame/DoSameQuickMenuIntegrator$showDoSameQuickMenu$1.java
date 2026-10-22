package com.larus.community.impl.quickmenu.doSame;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.community.impl.quickmenu.DismissReason;
import com.larus.community.impl.quickmenu.QuickMenuConfig;
import com.larus.community.impl.quickmenu.QuickMenuPanelFragment;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.Icon;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.uaigc.creation.ICreationService;
import com.larus.uaigc.service.IUgcAIGCService;
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
import o29.i;
import o29.j;
import org.json.JSONObject;
import sq9.b0;
import v19.h;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.quickmenu.doSame.DoSameQuickMenuIntegrator$showDoSameQuickMenu$1", f = "DoSameQuickMenuIntegrator.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {79}, m = "invokeSuspend", n = {"itemIds", "tplDetailInfo", "iconUrl", "showIconBorder", "showHighlightItem", "showUsePictureItem", "isDarkMode", "hasAvatar"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "Z$0", "Z$1"})
final class DoSameQuickMenuIntegrator$showDoSameQuickMenu$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function1<DismissReason, Unit> $onDismiss;
    final /* synthetic */ Function2<j, Integer, Unit> $onItemClick;
    final /* synthetic */ JSONObject $trackParams;
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
    public DoSameQuickMenuIntegrator$showDoSameQuickMenu$1(UserCreation r100, FragmentActivity r101, JSONObject r102, Function2<? super j, ? super Integer, Unit> r103, Function1<? super DismissReason, Unit> r104, Continuation<? super DoSameQuickMenuIntegrator$showDoSameQuickMenu$1> r105) {
        this.$userCreation = r100;
        this.$activity = r101;
        this.$trackParams = r102;
        this.$onItemClick = r103;
        this.$onDismiss = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoSameQuickMenuIntegrator$showDoSameQuickMenu$1(this.$userCreation, this.$activity, this.$trackParams, this.$onItemClick, this.$onDismiss, r101);
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
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
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
        String r109 = "res://" + AppHost.f326268a.getApplication().getPackageName() + "/2131241188";
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
        final Ref.ObjectRef r211 = r111;
    L141:
        final Ref.ObjectRef r121 = r112;
        List r122 = r113;
        final boolean r212 = r116;
        final boolean r123 = r115;
        r122.add(DoSameQuickMenuType.USE_PICTURE);
        r122.add("use_prompt");
        FragmentActivity r124 = this.$activity;
        if (r105 == 0) goto L146;
        final boolean r125 = true;
    L147:
        if (r117 == 0) goto L149;
        final boolean r213 = true;
    L150:
        final UserCreation r126 = this.$userCreation;
        final Function2<j, Integer, Unit> r127 = this.$onItemClick;
        final JSONObject r128 = this.$trackParams;
        final Function1<DismissReason, Unit> r129 = this.$onDismiss;
        Function1 r130 = new b(r125, r121, r211, r212, r210, r213, r126, r127, r123, r128, r129);
        Intrinsics.checkNotNullParameter(r124, "<this>");
        Intrinsics.checkNotNullParameter(r130, "builder");
        int r131 = com.larus.community.impl.quickmenu.a.f329733a;
        com.larus.community.impl.quickmenu.a.C4196a r132 = new com.larus.community.impl.quickmenu.a.C4196a();
        r130.invoke(r132);
        Intrinsics.checkNotNullParameter(r124, "activity");
        FragmentManager r133 = r124.getSupportFragmentManager();
        Intrinsics.checkNotNullParameter(r133, "fragmentManager");
        i r134 = r132.f329734a;
        r134.getClass();
        QuickMenuConfig r135 = new QuickMenuConfig(null, CollectionsKt.toList(r134.f521805a), r134.f521806b, r134.f521807c, 1, null);
        Intrinsics.checkNotNullParameter(r133, "fragmentManager");
        Intrinsics.checkNotNullParameter(r135, "config");
        int r136 = QuickMenuPanelFragment.f329725i;
        Intrinsics.checkNotNullParameter(r135, "config");
        QuickMenuPanelFragment r137 = new QuickMenuPanelFragment();
        r137.setArguments(new Bundle());
        r137.f329727e = r135;
        LandscapeRestrictionOperation r138 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r137, "QuickMenuPanelFragment", r138);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r133, r137, r138) == false) goto L158;
    L155:
        Lazy r139 = e.f329751a;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DoSameQuickMenuIntegrator$reportUseTemplateMenuElementShow$1(r122, this.$userCreation, r123, this.$trackParams, null), 3, null);
        return Unit.INSTANCE;
    L158:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L157
    L154:
        r137.show(r133, "QuickMenuPanelFragment");
        goto L155
    L149:
        r213 = false;
        goto L150
    L146:
        r125 = false;
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
        CreationDynamicInfo r140 = this.$userCreation.f364994h;
        String r141 = null;
        if (r140 == null) goto L13;
        TplInfo r142 = r140.f364915e;
        if (r142 == null) goto L13;
        TplDetail r143 = r142.f364973b;
    L15:
        if (r143 == null) goto L33;
        if (r140 == null) goto L20;
        TplInfo r144 = r140.f364915e;
        if (r144 == null) goto L20;
        TplDetail r145 = r144.f364974c;
    L21:
        if (r145 == null) goto L33;
        List r146 = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(2), Boxing.boxInt(1)});
        CreationDynamicInfo r147 = this.$userCreation.f364994h;
        if (r147 == null) goto L29;
        TplInfo r148 = r147.f364915e;
        if (r148 == null) goto L29;
        TplDetail r149 = r148.f364973b;
        if (r149 == null) goto L29;
        Integer r150 = r149.f364959a;
    L31:
        if (CollectionsKt.contains(r146, r150) == false) goto L33;
        r105 = 1;
    L34:
        b0 r151 = e.a();
        if (r151 == null) goto L37;
        String r152 = r151.useImageShowName;
    L38:
        if (r152 != null) goto L40;
    L43:
        boolean r153 = true;
    L44:
        if (r153 == true) goto L79;
        b0 r154 = e.a();
        if (r154 == null) goto L48;
        String r155 = r154.useImageShowDesc;
    L49:
        if (r155 != null) goto L51;
    L54:
        boolean r156 = true;
    L55:
        if (r156 == true) goto L79;
        b0 r157 = e.a();
        if (r157 == null) goto L59;
        String r158 = r157.usePromptShowName;
    L60:
        if (r158 != null) goto L62;
    L65:
        boolean r159 = true;
    L66:
        if (r159 == true) goto L79;
        b0 r160 = e.a();
        if (r160 == null) goto L70;
        String r161 = r160.usePromptShowDesc;
    L71:
        if (r161 != null) goto L73;
    L76:
        boolean r162 = true;
    L77:
        if (r162 == true) goto L79;
        r117 = 1;
    L80:
        r112 = new Ref.ObjectRef();
        r119 = new Ref.ObjectRef();
        r119.element = "";
        Ref.BooleanRef r163 = new Ref.BooleanRef();
        boolean r164 = h.f552477a;
        r116 = h.b(this.$activity);
        r115 = IUgcAIGCService.f373945a.v();
        if (r105 == 0) goto L142;
        if (r115 == false) goto L88;
        CreationDynamicInfo r165 = this.$userCreation.f364994h;
        if (r165 == null) goto L93;
        TplInfo r166 = r165.f364915e;
        if (r166 == null) goto L93;
        ?? r167 = r166.f364974c;
    L94:
        r112.element = r167;
        if (r116 == false) goto L100;
        if (r167 == 0) goto L104;
        Icon r168 = r167.f364964f;
        if (r168 == null) goto L104;
        r141 = r168.f364939b;
    L104:
        if (r141 != null) goto L106;
    L109:
        boolean r169 = true;
    L110:
        if (r169 == false) goto L139;
        TplDetail r170 = (TplDetail) r112.element;
        if (r170 == null) goto L119;
        Integer r171 = r170.f364959a;
        if (r171 == null) goto L119;
        if (r171.intValue() != 2) goto L119;
        boolean r172 = true;
    L120:
        if (r172 == false) goto L138;
        if (r115 == false) goto L137;
        ICreationService.Companion r173 = ICreationService.f372787a;
        this.L$0 = r113;
        this.L$1 = r112;
        this.L$2 = r119;
        this.L$3 = r163;
        this.L$4 = r119;
        this.I$0 = r105;
        this.I$1 = r117;
        this.Z$0 = r116;
        this.Z$1 = r115;
        this.label = 1;
        r107 = r173.a(this);
        if (r107 != r100) goto L125;
        return r100;
    L125:
        r104 = r117;
        r106 = r119;
        r103 = r116;
        r102 = r115;
        r110 = r163;
        r111 = r106;
        goto L126
    L137:
        r141 = "res://" + AppHost.f326268a.getApplication().getPackageName() + "/2131241188";
        goto L139
    L138:
        r163.element = true;
        r141 = this.$userCreation.e();
    L119:
        r172 = false;
    L139:
        r120 = r141;
        r118 = r163;
        r111 = r119;
        goto L140
    L106:
        if (StringsKt.isBlank(r141) == true) goto L109;
        r169 = false;
        goto L110
    L100:
        if (r167 == 0) goto L104;
        Icon r174 = r167.f364964f;
        if (r174 == null) goto L104;
        r141 = r174.f364938a;
    L93:
        r167 = 0;
        goto L94
    L88:
        CreationDynamicInfo r175 = this.$userCreation.f364994h;
        if (r175 == null) goto L93;
        TplInfo r176 = r175.f364915e;
        if (r176 == null) goto L93;
        r167 = r176.f364973b;
        goto L94
    L142:
        r211 = r119;
        r210 = r163;
        goto L141
    L73:
        if (r161.length() == 0) goto L76;
        r162 = false;
        goto L77
    L70:
        r161 = null;
        goto L71
    L62:
        if (r158.length() == 0) goto L65;
        r159 = false;
        goto L66
    L59:
        r158 = null;
        goto L60
    L51:
        if (r155.length() == 0) goto L54;
        r156 = false;
        goto L55
    L48:
        r155 = null;
    L79:
        r117 = 0;
        goto L80
    L40:
        if (r152.length() == 0) goto L43;
        r153 = false;
        goto L44
    L37:
        r152 = null;
    L29:
        r150 = null;
    L20:
        r145 = null;
    L33:
        r105 = 0;
    L13:
        r143 = null;
        goto L15
    }
}
