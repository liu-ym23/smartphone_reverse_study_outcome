package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.preview.components.view.SpinButton;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.FontType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
public final class ExcelMessagePermissionBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f412733p = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<String> f412735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f412736i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final jdb.g f412737j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f412738k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f412739l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f412740m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f412741n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f412742o;

    public static final class a implements com.ss.android.lark.blueprint.k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f412743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f412744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SpinButton f412745c;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412743a;
        }

        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412743a = r100;
            this.f412744b = (TextView) r100.findViewById(R.id.excel_permission_name);
            this.f412745c = (SpinButton) r100.findViewById(R.id.excel_permission_button);
        }
    }

    public static final class b {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock$update$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock$update$1", f = "ExcelMessagePermissionBlock.kt", i = {}, l = {101, 109}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $blockView;
        final /* synthetic */ y6b.c<?> $item;
        final /* synthetic */ com.ss.android.lark.blueprint.q<y6b.a<?>> $layout;
        int label;
        final /* synthetic */ ExcelMessagePermissionBlock this$0;

        public AnonymousClass1(ExcelMessagePermissionBlock r100, a r101, y6b.c<?> r102, com.ss.android.lark.blueprint.q<y6b.a<?>> r103, Continuation<? super AnonymousClass1> r104) {
            this.this$0 = r100;
            this.$blockView = r101;
            this.$item = r102;
            this.$layout = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$blockView, this.$item, this.$layout, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ResultKt.throwOnFailure(r110);
        L52:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r110);
        L14:
            if (Intrinsics.areEqual(this.$blockView.f412743a.getTag(R.id.file_ability), Boxing.boxInt(1)) == false) goto L50;
            ExcelMessagePermissionBlock r111 = this.this$0;
            a r102 = this.$blockView;
            Boolean r103 = Boxing.boxBoolean(this.$item.f566492i);
            int r104 = ExcelMessagePermissionBlock.f412733p;
            r111.getClass();
            TextView r105 = r102.f412744b;
            r105.setVisibility(0);
            if (h18.f.a(r111.getContext()) == false) goto L19;
            r105.setTextColor(com.ss.android.lark.chat.utils.p.b(r111.getContext()));
        L19:
            if (r111.f412673c.isAIChat() == false) goto L26;
            boolean r106 = Intrinsics.areEqual(r102.f412743a.getTag(R.id.file_permission), 1);
            Context r112 = r111.getContext();
            if (r106 == false) goto L23;
            String r113 = r112.getString(R.string.Lark_Docs_YouCanEdit);
        L24:
            r105.setText(r113);
        L43:
            if (this.$item.f566492i == true) goto L45;
        L49:
            this.$blockView.f412745c.setVisibility(8);
            goto L52
        L45:
            if (this.this$0.f412673c.isAIChat() == true) goto L49;
            ExcelMessagePermissionBlock r114 = this.this$0;
            a r107 = this.$blockView;
            y6b.c<?> r108 = this.$item;
            this.label = 2;
            if (ExcelMessagePermissionBlock.h(r114, r107, r108, this) != r100) goto L52;
            return r100;
        L23:
            r113 = r112.getString(R.string.Lark_Docs_YouCanView);
            goto L24
        L26:
            if (Intrinsics.areEqual(r103, Boolean.TRUE) == true) goto L28;
            boolean r109 = Intrinsics.areEqual(r102.f412743a.getTag(R.id.file_permission), 1);
            Context r115 = r111.getContext();
            if (r109 == false) goto L40;
            String r116 = r115.getString(R.string.Lark_Docs_YouCanEdit);
        L41:
            r105.setText(r116);
            goto L43
        L40:
            r116 = r115.getString(R.string.Lark_Docs_YouCanView);
            goto L41
        L28:
            if (r111.f412673c.isGroup() == false) goto L31;
            r105.setText(r111.getContext().getString(R.string.Lark_Chat_CardPart1));
            goto L43
        L31:
            if (r111.f412673c.d() == false) goto L43;
            Chat r117 = r111.f412673c.getChat();
            if (r117 == null) goto L35;
            String r118 = r117.getName();
        L36:
            r105.setText(r118);
            goto L43
        L35:
            r118 = null;
            goto L36
        L50:
            ExcelMessagePermissionBlock r119 = this.this$0;
            r119.g(this.$layout, r119.f412734g, IMMessageKeys$Slots.FOOTER);
            goto L52
        L10:
            ResultKt.throwOnFailure(r110);
            ExcelMessagePermissionBlock r120 = this.this$0;
            a r121 = this.$blockView;
            y6b.c<?> r122 = this.$item;
            this.label = 1;
            int r123 = ExcelMessagePermissionBlock.f412733p;
            if (r120.k(r121, r122, this) != r100) goto L14;
            return r100;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412734g;
    }

    public ExcelMessagePermissionBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412734g = IMMessageKeys$Blocks.EXCEL_PERMISSION;
        ArrayList<String> r101 = new ArrayList();
        this.f412735h = r101;
        LinkedHashMap r102 = new LinkedHashMap();
        this.f412736i = r102;
        this.f412737j = com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.f412673c).C();
        this.f412738k = "";
        this.f412739l = "";
        r101.add(getContext().getString(R.string.Lark_Docs_ChatDocPermissionEdit));
        r101.add(getContext().getString(R.string.Lark_Docs_ChatDocPermissionRead));
        r102.put(MimeType.XLSX, "xlsx");
        r102.put(MimeType.XLS, "xls");
    }

    public final String i(y6b.c<?> r100) {
        if (r100 == null) goto L4;
        Object r101 = r100.f566500o;
    L6:
        if ((r101 instanceof FileContentVO) == false) goto L9;
        FileContentVO r102 = (FileContentVO) r101;
        this.f412738k = r102.e();
        Map<String, String> r103 = this.f412736i;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        this.f412739l = String.valueOf(r104.get((String) r102.f411892r.getValue()));
    L9:
        return this.f412738k;
    L4:
        r101 = null;
        goto L6
    }

    public final void j(a r110) {
        Object r100 = r110.f412743a.getTag(R.id.cur_spin_button_index);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Int");
        int r101 = ((Integer) r100).intValue();
        Log.i("ExcelMessagePermissionBlock", "setSpinButtonData: index = " + r101);
        int r102 = (int) (((float) UIHelper.dp2px(10.0f)) * zz7.b.d().getMultiplier());
        r110.f412745c.c((String) ListProtector.get(this.f412735h, r101), null, new FontLevel(FontType.BODY, 2), null, Integer.valueOf(R.drawable.ud_icon_down_bold_outlined), r102, r102);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f412734g, IMMessageKeys$Slots.FOOTER);
    }

    public final Object k(a r110, y6b.c<?> r111, Continuation<? super Unit> r112) {
        String r100 = i(r111);
        r110.f412743a.setTag(R.id.file_key, r100);
        SafeContinuation r101 = new SafeContinuation(IntrinsicsKt.intercepted(r112));
        Log.i("ExcelMessagePermissionBlock", "hasChangePermission() execute");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f412673c.getContext()), null, null, new ExcelMessagePermissionBlock$hasChangePermission$2$1(r110, this, r111, r101, null), 3, null);
        Object r113 = r101.getOrThrow();
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r112);
    L6:
        if (r113 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        r113 = Unit.INSTANCE;
    L10:
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r113;
    L13:
        return Unit.INSTANCE;
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r110, com.ss.android.lark.blueprint.q<y6b.a<?>> r111, y6b.a<?> r112) {
        Intrinsics.checkNotNullParameter(r110, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r111, "layout");
        Intrinsics.checkNotNullParameter(r112, "data");
        if ((r112 instanceof y6b.c) == false) goto L5;
        y6b.c r100 = (y6b.c) r112;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        T r113 = r100.f566500o;
        boolean r101 = false;
        if ((r113 instanceof FileContentVO) == false) goto L36;
        FileContentVO r114 = (FileContentVO) r113;
        String r115 = r114.f();
        boolean r102 = com.ss.android.lark.chat.utils.s.b(this.f412737j, r115);
        boolean r103 = MessagePermissionUtil.f(r100, this.f412673c.getChat(), null);
        StringBuilder r104 = new StringBuilder("canShowBlock: name = ");
        r104.append(r115);
        r104.append(", filePreviewEnable = ");
        r104.append(r102);
        r104.append(", hasFileReadPerm = ");
        r104.append(r103);
        r104.append("hasPreviewBodyAndUrl = ");
        r104.append(com.ss.android.lark.chat.utils.s.a(r114));
        r104.append("isAbilityUnsupport = ");
        FileContent.FileAbility r116 = (FileContent.FileAbility) r114.f411899y.getValue();
        FileContent.FileAbility r105 = FileContent.FileAbility.SUPPORT_EDIT;
        if (r105 != r116) goto L13;
    L17:
        boolean r117 = false;
    L18:
        r104.append(r117);
        Log.i("ExcelMessagePermissionBlock", r104.toString());
        if (r102 == false) goto L36;
        if (com.ss.android.lark.chat.utils.s.a(r114) == false) goto L36;
        if (this.f412673c.b0() == true) goto L36;
        if (r103 == false) goto L36;
        FileContent.FileAbility r118 = (FileContent.FileAbility) r114.f411899y.getValue();
        if (r105 != r118) goto L28;
    L32:
        boolean r119 = false;
    L33:
        if (r119 == true) goto L36;
        r101 = true;
        goto L36
    L28:
        if (FileContent.FileAbility.SUPPORT_PREVIEW == r118) goto L32;
        if (FileContent.FileAbility.NOT_SUPPORT_PREVIEW == r118) goto L32;
        r119 = true;
        goto L33
    L13:
        if (FileContent.FileAbility.SUPPORT_PREVIEW == r116) goto L17;
        if (FileContent.FileAbility.NOT_SUPPORT_PREVIEW == r116) goto L17;
        r117 = true;
    L36:
        if (r101 == true) goto L39;
        g(r111, this.f412734g, IMMessageKeys$Slots.FOOTER);
        return;
    L39:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f412673c.getContext()), null, null, new AnonymousClass1(this, (a) r111.c(this.f412734g, IMMessageKeys$Slots.FOOTER, new ExcelMessagePermissionBlock$update$blockView$1(this)), r100, r111, null), 3, null);
        return;
    L5:
        r100 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }

    public static final Object h(final ExcelMessagePermissionBlock r100, final a r101, final y6b.c r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof ExcelMessagePermissionBlock$setupSpinButton$1) == false) goto L7;
        ExcelMessagePermissionBlock$setupSpinButton$1 r104 = (ExcelMessagePermissionBlock$setupSpinButton$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        SpinButton r109 = (SpinButton) r104.L$2;
        r102 = (y6b.c) r104.L$1;
        a r110 = (a) r104.L$0;
        ResultKt.throwOnFailure(r106);
        final SpinButton r111 = r109;
        r101 = r110;
    L17:
        r100.j(r101);
        r111.setOnClickListener(new ExcelMessagePermissionBlock$setupSpinButton$2(r100, r101, r102, r111));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        r111 = r101.f412745c;
        r111.setVisibility(0);
        r104.L$0 = r101;
        r104.L$1 = r102;
        r104.L$2 = r111;
        r104.label = 1;
        if (r100.k(r101, r102, r104) != r107) goto L17;
        return r107;
    L7:
        r104 = new ExcelMessagePermissionBlock$setupSpinButton$1(r100, r103);
        goto L8
    }
}
