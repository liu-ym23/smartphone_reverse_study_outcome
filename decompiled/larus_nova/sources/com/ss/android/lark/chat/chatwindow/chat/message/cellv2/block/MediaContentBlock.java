package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.chatwindow.chat.view.IMCircleLoadingView;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.MessageImageMonitor;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.MessengerImageLoadController;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.DonutProgress;
import com.ss.android.lark.widget.mark.MarkView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MediaContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<MediaContentVO>, MediaContentVO> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f412783l = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f412785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.larksuite.framework.callback.c f412786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f412787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f412788k;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f412789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f412790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DonutProgress f412791c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f412792d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f412793e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final MarkView f412794f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final View f412795g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final MarkView f412796h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final LKUIRoundableLayout f412797i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final View f412798j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final IMCircleLoadingView f412799k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f412800l;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412789a;
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412789a = r100;
            this.f412790b = (ImageView) r100.findViewById(R.id.media_cover);
            DonutProgress r101 = (DonutProgress) r100.findViewById(R.id.media_upload_progress);
            this.f412791c = r101;
            this.f412792d = (ImageView) r100.findViewById(R.id.media_media_play);
            this.f412793e = (ImageView) r100.findViewById(R.id.media_continue_upload);
            MarkView r102 = (MarkView) r100.findViewById(R.id.media_duration);
            this.f412794f = r102;
            this.f412795g = r100.findViewById(R.id.media_duration_shadow_view);
            MarkView r103 = (MarkView) r100.findViewById(R.id.resource_is_cleaned_tip);
            this.f412796h = r103;
            this.f412797i = (LKUIRoundableLayout) r100.findViewById(R.id.media_content);
            this.f412798j = r100.findViewById(R.id.media_cover_foreground);
            this.f412799k = (IMCircleLoadingView) r100.findViewById(R.id.loading_view);
            Context r104 = r100.getContext();
            r101.setShowText(false);
            r101.setFinishedStrokeColor(UIHelper.getColor(R.color.colorful_blue));
            r101.setUnfinishedStrokeColor(j08.b.c(r104, R.color.lkui_N00, 0.5f));
            float r105 = UIHelper.dp2px(2.0f);
            r101.setFinishedStrokeWidth(r105);
            r101.setUnfinishedStrokeWidth(r105);
            r101.setAttributeResourceId(R.drawable.video_ctrl_close);
            r101.setInnerBackgroundColor(j08.b.c(r104, R.color.lkui_N900, 0.5f));
            r101.setMax(100);
            Integer r106 = Integer.valueOf(R.color.static_white);
            r102.f446458a = Integer.valueOf(R.drawable.ud_icon_video_filled);
            r102.f446459b = r106;
            r102.a();
            r103.f446458a = null;
            r103.f446459b = null;
            r103.a();
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f412801a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f412802b = null;

        static {
            int[] r100 = new int[Message.FileDeletedStatus.values().length];
            r100[Message.FileDeletedStatus.FREED_UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[Message.FileDeletedStatus.RECALLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            f412801a = r100;
            int[] r101 = new int[SendStatus.values().length];
            r101[SendStatus.SENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r101[SendStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r101[SendStatus.FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            f412802b = r101;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaContentBlock f412803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f412804b;

        public d(MediaContentBlock r100, int r101) {
            this.f412803a = r100;
            this.f412804b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LKUIToast.show(this.f412803a.getContext(), this.f412804b);
        }
    }

    static {
    }

    public final int h() {
        if (this.f412673c.m() == true) goto L16;
        if (this.f412673c.Y() == true) goto L16;
        lya.a r100 = this.f412673c.l();
        if (r100 == null) goto L12;
        Integer r101 = r100.a();
        if (r101 == null) goto L12;
        int r102 = r101.intValue();
    L14:
        return (int) (r102 * 0.6f);
    L12:
        r102 = UIHelper.getWindowWidth(getContext());
    L16:
        return (int) (((double) DeviceUtils.getScreenHeight(this.f412673c.getContext())) * 0.6d);
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412784g;
    }

    public MediaContentBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412784g = IMMessageKeys$Blocks.MEDIA_CONTENT;
        this.f412785h = UIUtils.dp2px(getContext(), 120.0f);
        this.f412787j = LazyKt.lazy(new MediaContentBlock$mClickListener$2(this));
    }

    public static void j(boolean r100, b r101) {
        if (r100 == true) goto L4;
        r101.f412799k.b();
        return;
    L4:
        if (r101.f412800l == false) goto L6;
        return;
    L6:
        r101.f412800l = true;
        r101.f412799k.a();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<MediaContentVO>> r100, com.ss.android.lark.blueprint.q<y6b.a<MediaContentVO>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        com.ss.android.lark.blueprint.k<?> r102 = r101.f(this.f412784g, IMMessageKeys$Slots.CONTENT);
        if ((r102 instanceof b) == false) goto L5;
        b r103 = (b) r102;
    L6:
        if (r103 == null) goto L9;
        r103.f412800l = false;
        r103.f412799k.b();
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void i(b r100, int r101) {
        r100.f412792d.setVisibility(0);
        r100.f412793e.setVisibility(8);
        r100.f412791c.setVisibility(8);
        r100.f412792d.setImageResource(R.drawable.video_invalid);
        d r102 = new d(this, r101);
        r100.f412790b.setOnClickListener(r102);
        r100.f412792d.setOnClickListener(r102);
    }

    public final void k(b r100, int r101) {
        ImageView r102 = r100.f412790b;
        w4b.u r103 = MessagePermissionUtil.f416615a;
        Intrinsics.checkNotNullParameter(r102, "imageView");
        if (r101 != R.string.Lark_IM_UnableToView_Empty) goto L5;
        String r104 = "";
    L6:
        int r105 = com.ss.android.lark.widget.span.nopreview.a.f448735k;
        com.ss.android.lark.widget.span.nopreview.a.C5434a r106 = com.ss.android.lark.widget.span.nopreview.a.b.a(r102.getContext());
        Intrinsics.checkNotNullParameter(r104, "text");
        r106.f448752g = r104;
        com.ss.android.lark.widget.span.nopreview.a r107 = r106.a();
        r102.setImageDrawable(r107);
        Pair<Integer, Integer> r108 = TuplesKt.to(Integer.valueOf(r107.f448737b), Integer.valueOf(r107.f448738c));
        v4b.d r109 = this.f412675e;
        if (r109 == null) goto L21;
        if (r109 == null) goto L10;
        int r110 = r109.f553210d;
    L11:
        if (r110 > 0) goto L20;
        lya.a r111 = this.f412673c.l();
        if (r111 == null) goto L18;
        Integer r112 = r111.a();
        if (r112 == null) goto L18;
        int r113 = r112.intValue();
    L19:
        r110 = (int) (r113 * 0.6f);
    L18:
        r113 = UIHelper.getWindowWidth(getContext());
    L20:
        r108 = MessagePermissionUtil.i(r108, r110, h(), this.f412785h);
        goto L21
    L10:
        r110 = 0;
    L21:
        ViewGroup.LayoutParams r114 = r100.f412797i.getLayoutParams();
        r114.width = r108.getFirst().intValue();
        r114.height = r108.getSecond().intValue();
        r100.f412797i.setLayoutParams(r114);
        return;
    L5:
        r104 = r102.getContext().getString(r101);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v8 */
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
    public void update(com.ss.android.lark.blueprint.m<y6b.a<MediaContentVO>> r210, com.ss.android.lark.blueprint.q<y6b.a<MediaContentVO>> r211, y6b.a<MediaContentVO> r212) {
        Intrinsics.checkNotNullParameter(r210, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r211, "layout");
        Intrinsics.checkNotNullParameter(r212, "data");
        b r100 = (b) r211.c(this.f412784g, IMMessageKeys$Slots.CONTENT, MediaContentBlock$update$blockView$1.INSTANCE);
        MediaContentVO r101 = r212.b();
        ImageSet r102 = (ImageSet) r101.f411916f.getValue();
        Image r103 = MessengerImageLoadController.c(MessageImageMonitor.Scene.MEDIA_COVER.getValue(), r102);
        i3b.d r104 = (i3b.d) this.f412671a.f410652c.a(i3b.d.class);
        if (r104 == null) goto L7;
        m2b.a r105 = r104.a();
        if (r105 == null) goto L7;
        com.ss.android.lark.biz.im.api.message.params.j r110 = (com.ss.android.lark.biz.im.api.message.params.j) r105.d0(com.ss.android.lark.biz.im.api.message.params.j.class);
    L8:
        ValidateIMFileResult r106 = r212.N();
        if (r106 == null) goto L11;
        IMFileResult r107 = r106.getResultType();
    L12:
        MessagePermissionUtil.ReceiveAuthorizationState r111 = MessagePermissionUtil.h(r107);
        boolean r112 = MessagePermissionUtil.f(r212, this.f412673c.getChat(), null);
        ResourceCleanScene r113 = lpc.a.b(r212);
        if (r113 == null) goto L18;
        if (r113.isCSAMDelete() == false) goto L18;
        j(false, r100);
        k(r100, R.string.Lark_IM_FileRemovedByPolicy_Error);
    L26:
        String r108 = "MediaContentBlock";
        ?? r114 = 0;
    L74:
        if (TextUtils.isEmpty(r212.F()) == true) goto L76;
    L79:
        r100.f412797i.setRadius(4.0f);
        r100.f412797i.setBorderWidth(0.0f);
    L80:
        if (r110 == null) goto L82;
        Integer r109 = r110.f410361g;
    L83:
        if (r110 == null) goto L85;
        Integer r115 = r110.f410362h;
    L86:
        if (r109 == null) goto L89;
        if (r115 == null) goto L89;
        r100.f412797i.setBorderColor(r109.intValue());
        r100.f412797i.setBorderWidth(r115.intValue());
    L90:
        int r116 = (int) r101.e();
        if (r113 != null) goto L93;
    L95:
        if (r112 == true) goto L97;
    L126:
        r100.f412794f.setVisibility(8);
        r100.f412796h.setVisibility(8);
    L127:
        this.f412786i = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
        v r117 = new v(this, r100, r212);
        r100.f412790b.setOnClickListener(r117);
        r100.f412792d.setOnClickListener(r117);
        String r118 = r108;
        w r119 = new w(r210, this, r212);
        r100.f412790b.setOnLongClickListener(r119);
        r100.f412792d.setOnLongClickListener(r119);
        i3b.d r120 = (i3b.d) this.f412671a.f410652c.a(i3b.d.class);
        if (r120 == null) goto L134;
        m2b.a r121 = r120.a();
        if (r121 == null) goto L134;
        com.ss.android.lark.biz.im.api.message.params.j r122 = (com.ss.android.lark.biz.im.api.message.params.j) r121.d0(com.ss.android.lark.biz.im.api.message.params.j.class);
        if (r122 == null) goto L134;
        boolean r123 = r122.f410355a;
    L135:
        MediaContentVO r124 = r212.b();
        r100.f412792d.setVisibility(8);
        r100.f412793e.setVisibility(8);
        r100.f412791c.setVisibility(8);
        r100.f412798j.setVisibility(8);
        Log.d(r118, "media key = " + ((String) r124.f411912b.getValue()));
        ValidateIMFileResult r125 = r212.N();
        if (r125 == null) goto L138;
        IMFileResult r126 = r125.getResultType();
    L139:
        MessagePermissionUtil.ReceiveAuthorizationState r127 = MessagePermissionUtil.h(r126);
        ResourceCleanScene r128 = lpc.a.b(r212);
        if (r128 == null) goto L145;
        if (r128.isCSAMDelete() == false) goto L145;
        return;
    L145:
        if (MessagePermissionUtil.g(r127) == false) goto L148;
        return;
    L148:
        if (MessagePermissionUtil.f(r212, this.f412673c.getChat(), null) == false) goto L186;
        if (r128 != null) goto L152;
    L154:
        Message.FileDeletedStatus r129 = r124.f411927q;
        if (r124.f411926p == false) goto L157;
    L169:
        int r130 = c.f412801a[r129.ordinal()];
        if (r130 == 1) goto L178;
        if (r130 == 2) goto L177;
        w4b.j r131 = ChatCoreModule.a().getDownloadDependency();
        String r132 = r212.getId();
        String r133 = r124.f411924n;
        Message.SourceType r134 = r124.f411925o;
        if (r134 == null) goto L175;
        int r135 = r134.getNumber();
    L176:
        r131.c(r132, r133, r135, (String) r124.f411912b.getValue(), null);
        return;
    L175:
        r135 = 0;
        goto L176
    L177:
        i(r100, R.string.Lark_Legacy_VideoMessagePreviewInvalid);
        return;
    L178:
        i(r100, R.string.Lark_IM_ViewOrDownloadFile_FileDeleted_Text);
        return;
    L157:
        if (r129 != Message.FileDeletedStatus.NORMAL) goto L169;
        r100.f412792d.setImageResource(R.drawable.media_play);
        int r136 = c.f412802b[r212.G().ordinal()];
        if (r136 == 1) goto L167;
        if (r136 == 2) goto L165;
        if (r136 == 3) goto L165;
        if (r123 == true) goto L168;
        r100.f412792d.setVisibility(r114);
    L168:
        r100.f412791c.setOnClickListener(new x(this, r100, r212));
        return;
    L165:
        if (r123 == true) goto L168;
        r100.f412792d.setVisibility(r114);
        goto L168
    L167:
        r100.f412798j.setVisibility(r114);
        r100.f412791c.setVisibility(r114);
        r100.f412791c.setProgress(((Number) r124.f411918h.getValue()).intValue());
        goto L168
    L152:
        if (r128.isUnifiedRegularDelete() == false) goto L154;
        r100.f412792d.setVisibility(r114);
        return;
    L186:
        return;
    L138:
        r126 = null;
    L134:
        r123 = false;
        goto L135
    L97:
        if (MessagePermissionUtil.g(r111) == true) goto L126;
        if (r113 != null) goto L100;
    L102:
        r100.f412794f.setText(com.larksuite.framework.utils.e.g(r116));
        if (r110 == null) goto L105;
        boolean r137 = r110.f410358d;
    L106:
        r100.f412794f.f446463f = r137;
        if (r137 == false) goto L111;
        Drawable r138 = r110.f410359e;
        if (r138 == null) goto L111;
        r100.f412795g.setBackground(r138);
        r100.f412795g.setVisibility(r114);
    L112:
        if (r110 == null) goto L114;
        boolean r139 = r110.f410356b;
    L115:
        if (r139 == false) goto L118;
        MarkView r140 = r100.f412794f;
        r140.f446462e = r114;
        r140.f446458a = null;
        r140.f446459b = null;
        r140.a();
    L118:
        if (r110 == null) goto L120;
        int r141 = r110.f410357c;
    L121:
        if (r141 <= (-1)) goto L125;
        ViewGroup.LayoutParams r142 = r100.f412794f.getLayoutParams();
        if ((r142 instanceof ViewGroup.MarginLayoutParams) == false) goto L125;
        ((ViewGroup.MarginLayoutParams) r142).setMarginEnd(r141);
        MarkView r143 = r100.f412794f;
        r143.setLayoutParams(r143.getLayoutParams());
    L125:
        r100.f412794f.setVisibility(r114);
        r100.f412796h.setVisibility(8);
        goto L127
    L120:
        r141 = -1;
        goto L121
    L114:
        r139 = false;
    L111:
        r100.f412795g.setVisibility(8);
        goto L112
    L105:
        r137 = false;
        goto L106
    L100:
        if (r113.isUnifiedRegularDelete() == false) goto L102;
        r100.f412796h.setText(UIUtils.getString(getContext(), R.string.Lark_IM_FileExpiredByAdmin_Label));
        r100.f412796h.setVisibility(r114);
        r100.f412794f.setVisibility(8);
        goto L127
    L93:
        if (r113.isCSAMDelete() == false) goto L95;
        r100.f412794f.setVisibility(8);
        r100.f412796h.setVisibility(8);
    L89:
        r100.f412797i.setBorderColor(UIHelper.getColor(R.color.line_border_card));
        r100.f412797i.setBorderWidth(0.5f);
        goto L90
    L85:
        r115 = null;
        goto L86
    L82:
        r109 = null;
        goto L83
    L76:
        if (r212.l() == true) goto L79;
        float[] r144 = com.ss.android.lark.chat.utils.f0.a(r212, 10.0f, 2.0f);
        r100.f412797i.setRadius(r144[r114], r144[1], r144[2], r144[3]);
        r100.f412797i.setBorderWidth(0.5f);
    L18:
        if (MessagePermissionUtil.g(r111) == true) goto L20;
        if (r112 == true) goto L27;
        j(false, r100);
        k(r100, R.string.Lark_IM_UnableToPreviewVideo_Text);
        goto L26
    L27:
        if (r103 == null) goto L72;
        if (r102 == null) goto L72;
        if (com.ss.android.lark.chat.utils.g.d(r212) == true) goto L72;
        Image r145 = r102.getOrigin();
        Intrinsics.checkNotNull(r145);
        int r146 = r145.getWidth();
        int r147 = r145.getHeight();
        v4b.d r148 = this.f412675e;
        if (r148 == null) goto L34;
        int r149 = r148.f553210d;
    L35:
        if (r149 <= 0) goto L37;
    L36:
        int r213 = r149;
        int r214 = h();
        int r150 = this.f412785h;
        int[] r151 = ImageUtils.g(r146, r147, r213, r214, r150, r150);
        int r152 = r151[0];
        int r153 = r151[1];
        ViewGroup.LayoutParams r154 = r100.f412797i.getLayoutParams();
        r154.width = r152;
        r154.height = r153;
        r100.f412797i.setLayoutParams(r154);
        if (r212.h() == true) goto L47;
    L49:
        Drawable r155 = null;
    L50:
        if (r155 != null) goto L52;
        r155 = com.ss.android.lark.chat.utils.g.a(getContext(), r152, r153, 0);
    L52:
        Context r156 = getContext();
        GradientDrawable r157 = new GradientDrawable();
        r157.setShape(0);
        r157.setCornerRadius(0);
        r157.setColor(UIUtils.getColor(r156, R.color.bg_filler));
        r157.setSize(r152, r153);
        if (this.f412673c.isSecretChat() == false) goto L56;
        Scene r158 = Scene.SecretChat;
    L59:
        ListenerParams.a r159 = new ListenerParams.a();
        r159.a(Biz.Messenger);
        r159.d(r158);
        r159.c(ListenerParams.FromType.MEDIA);
        r159.f426312a = false;
        r159.f426313b = false;
        r159.f426314c = r152;
        r159.f426315d = r153;
        r159.f426326o = r103.getKey();
        r159.f426327p = TextUtils.equals(r103.getKey(), r145.getKey());
        if (r110 == null) goto L65;
        if (r110.f410363i != true) goto L65;
        boolean r160 = true;
    L66:
        if (r160 == false) goto L68;
        u r161 = new u(this, r100);
    L69:
        if (r161 == null) goto L71;
        r159.f426319h = new t(r161);
    L71:
        ListenerParams r162 = r159.b();
        LoadParams r163 = new LoadParams();
        r163.f426328a = r152;
        r163.f426329b = r153;
        r163.f426330c = r155;
        r163.f426331d = r157;
        r163.f426339l = r162;
        r108 = "MediaContentBlock";
        r114 = 0;
        com.ss.android.lark.chat.utils.g.g(getContext(), r100.f412790b, r103, r163, null, r161);
        Log.i(r108, "[setUpCover]imageKey:" + r103.getKey() + " fsUnit:" + r103.getFsUnit());
        r100.f412790b.setTag(R.id.chat_window_image_cid, r212.getcId());
        goto L74
    L68:
        r161 = null;
    L65:
        r160 = false;
        goto L66
    L56:
        if (this.f412673c.r() == false) goto L58;
        r158 = Scene.Thread;
        goto L59
    L58:
        r158 = Scene.Chat;
        goto L59
    L47:
        if (Intrinsics.areEqual(r212.getcId(), r100.f412790b.getTag(R.id.chat_window_image_cid)) == false) goto L49;
        r155 = r100.f412790b.getDrawable();
        goto L50
    L37:
        lya.a r164 = this.f412673c.l();
        if (r164 == null) goto L42;
        Integer r165 = r164.a();
        if (r165 == null) goto L42;
        int r166 = r165.intValue();
    L43:
        r149 = (int) (r166 * 0.6f);
    L42:
        r166 = UIHelper.getWindowWidth(getContext());
        goto L43
    L34:
        r149 = 0;
    L72:
        r108 = "MediaContentBlock";
        r114 = 0;
        j(false, r100);
        com.ss.android.lark.chat.utils.g.f(getContext(), r100.f412790b);
        goto L74
    L20:
        if (r111 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L22;
        int r167 = R.string.Lark_IM_NoReceivingPermission_Text;
    L23:
        k(r100, r167);
        goto L26
    L22:
        r167 = R.string.Lark_IM_UnableToView_Empty;
        goto L23
    L11:
        r107 = null;
    L7:
        r110 = null;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
