package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.model.GifLoadConfig;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.ImageCellLoader;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.ImageCellPlaceHolderCal;
import com.ss.android.lark.chat.chatwindow.chat.message.cell.image.DelayDisplayFrameLayout;
import com.ss.android.lark.chat.chatwindow.chat.view.IMCircleLoadingView;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.MessageImageMonitor;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.MessengerImageLoadController;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chatbase.view.ChatImageGroup;
import com.ss.android.lark.chatbase.view.ChatImageView;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.mark.MarkView;
import com.ss.android.lark.widget.transformation.WhiteBgTransformation;
import java.util.ArrayList;
import jp.wasabeef.glide.transformations.CropTransformation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ImageContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<ImageContentVO>, ImageContentVO> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f412767i = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f412769h;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View>, ImageCellLoader.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f412770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LKUIRoundableLayout f412771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ChatImageGroup f412772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ChatImageView f412773d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final MarkView f412774e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final MarkView f412775f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final DelayDisplayFrameLayout f412776g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f412777h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final IMCircleLoadingView f412778i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ChatImageGroup f412779j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final ChatImageView f412780k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final MarkView f412781l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f412782m;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.ImageCellLoader.c
        public final MarkView a() {
            return this.f412781l;
        }

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412770a;
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412770a = r100;
            this.f412771b = (LKUIRoundableLayout) r100.findViewById(R.id.round_container);
            ChatImageGroup r101 = (ChatImageGroup) r100.findViewById(R.id.image);
            this.f412772c = r101;
            ChatImageView r102 = r101.f416893a;
            this.f412773d = r102;
            MarkView r103 = (MarkView) r101.findViewById(R.id.tv_image_tag);
            this.f412774e = r103;
            this.f412775f = (MarkView) r101.findViewById(R.id.resource_is_cleaned_tip);
            this.f412776g = (DelayDisplayFrameLayout) r100.findViewById(R.id.shadow);
            this.f412777h = (TextView) r100.findViewById(R.id.progress);
            this.f412778i = r101.f416902j;
            this.f412779j = r101;
            this.f412780k = r102;
            this.f412781l = r103;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412768g;
    }

    public ImageContentBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412768g = IMMessageKeys$Blocks.IMAGE_CONTENT;
        this.f412769h = LazyKt.lazy(new ImageContentBlock$loader$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ImageContentVO h(y6b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ImageContentVO r101 = (ImageContentVO) r100.b();
        if (r101.e() == false) goto L8;
        Object r102 = r101.f411957g;
        if (r102 == null) goto L9;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.ImageContentVO");
        return (ImageContentVO) r102;
    L9:
        return r101;
    L8:
        return r101;
    }

    public static void i(boolean r100, b r101) {
        if (r100 == true) goto L4;
        r101.f412778i.b();
        return;
    L4:
        if (r101.f412782m == false) goto L6;
        return;
    L6:
        r101.f412778i.a();
        r101.f412782m = true;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<ImageContentVO>> r100, com.ss.android.lark.blueprint.q<y6b.a<ImageContentVO>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        com.ss.android.lark.blueprint.k<?> r102 = r101.f(this.f412768g, IMMessageKeys$Slots.CONTENT);
        if ((r102 instanceof b) == false) goto L5;
        b r103 = (b) r102;
    L6:
        if (r103 == null) goto L9;
        r103.f412782m = false;
        r103.f412778i.b();
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<ImageContentVO>> r310, com.ss.android.lark.blueprint.q<y6b.a<ImageContentVO>> r311, final y6b.a<ImageContentVO> r312) {
        Intrinsics.checkNotNullParameter(r310, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r311, "layout");
        Intrinsics.checkNotNullParameter(r312, "data");
        final b r100 = (b) r311.c(this.f412768g, IMMessageKeys$Slots.CONTENT, ImageContentBlock$update$blockView$1.INSTANCE);
        ValidateIMFileResult r101 = r312.N();
        if (r101 == null) goto L5;
        IMFileResult r102 = r101.getResultType();
    L6:
        MessagePermissionUtil.ReceiveAuthorizationState r103 = MessagePermissionUtil.h(r102);
        int r104 = ((ImageCellLoader) this.f412769h.getValue()).a(r312, this.f412675e);
        int r105 = y9c.d.b(getContext(), 40.0f);
        i3b.d r106 = (i3b.d) this.f412671a.f410652c.a(i3b.d.class);
        if (r106 == null) goto L11;
        m2b.a r107 = r106.a();
        if (r107 == null) goto L11;
        com.ss.android.lark.biz.im.api.message.params.g r108 = (com.ss.android.lark.biz.im.api.message.params.g) r107.d0(com.ss.android.lark.biz.im.api.message.params.g.class);
    L13:
        if (r108 != null) goto L15;
    L17:
        boolean r110 = false;
    L18:
        if (r110 == false) goto L20;
        MarkView r111 = r100.f412774e;
        r111.f446462e = false;
        r111.f446463f = true;
    L20:
        ResourceCleanScene r112 = lpc.a.b(r312);
        if (r112 != null) goto L23;
    L25:
        boolean r113 = false;
    L27:
        if (r113 == false) goto L31;
        i(false, r100);
        j(r100, r104, r105, R.string.Lark_IM_FileRemovedByPolicy_Error);
    L29:
        b r109 = r100;
        ImageContentBlock r114 = this;
    L179:
        r109.f412771b.setOnClickListener(new n(r114, r109, r312));
        r109.f412771b.setOnLongClickListener(new o(r310, r114, r312));
        if (r114.f412673c.m() == true) goto L184;
        if (TextUtils.isEmpty(r312.F()) == true) goto L184;
    L185:
        r109.f412771b.setRadius(4.0f);
        r109.f412771b.setBorderWidth(0.0f);
    L193:
        r109.f412771b.setBorderColor(UIHelper.getColor(R.color.line_border_card));
        i3b.d r115 = (i3b.d) r114.f412671a.f410652c.a(i3b.d.class);
        if (r115 == null) goto L203;
        m2b.a r116 = r115.a();
        if (r116 == null) goto L203;
        com.ss.android.lark.biz.im.api.message.params.g r117 = (com.ss.android.lark.biz.im.api.message.params.g) r116.d0(com.ss.android.lark.biz.im.api.message.params.g.class);
        if (r117 == null) goto L203;
        r109.f412771b.setRadius(r117.f410348a);
        if (r117.f410349b == false) goto L203;
        r109.f412771b.setBorderColor(r117.f410351d);
        r109.f412771b.setBorderWidth(r117.f410350c);
    L203:
        if (r312.isPreMessage() == true) goto L205;
    L214:
        DelayDisplayFrameLayout r118 = r109.f412776g;
        r118.setTag(R.id.delay_framelayout_visible_tag, Boolean.FALSE);
        r118.removeCallbacks(r118.f412611a);
        r118.setVisibility(8);
        return;
    L205:
        if (r312.G() != SendStatus.SENDING) goto L214;
        ViewGroup.LayoutParams r119 = r109.f412776g.getLayoutParams();
        ViewGroup.LayoutParams r120 = r109.f412772c.getLayoutParams();
        r119.width = r120.width;
        r119.height = r120.height;
        r109.f412776g.setLayoutParams(r119);
        TextView r121 = r109.f412777h;
        StringBuilder r122 = new StringBuilder();
        r122.append((int) (((double) r312.b().f411908o) * 0.99d));
        r122.append('%');
        r121.setText(r122.toString());
        if (r109.f412776g.getVisibility() == 0) goto L216;
        DelayDisplayFrameLayout r123 = r109.f412776g;
        if ((System.currentTimeMillis() - (r312.getCreateTime() * ((long) 1000))) <= 2000) goto L212;
        int r124 = 0;
    L213:
        r123.setTag(R.id.delay_framelayout_visible_tag, Boolean.TRUE);
        r123.setVisibility(4);
        r123.postDelayed(r123.f412611a, r124);
        return;
    L212:
        r124 = h7b.l.c();
        goto L213
    L216:
        return;
    L184:
        if (r312.l() == true) goto L185;
        if (ReplyInThreadUtil.b(r312) == true) goto L189;
    L192:
        float[] r125 = com.ss.android.lark.chat.utils.f0.a(r312, 10.0f, 2.0f);
        r109.f412771b.setRadius(r125[0], r125[1], r125[2], r125[3]);
        r109.f412771b.setBorderWidth(0.5f);
        goto L193
    L189:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.message.thread_reply_bubble_optimize") == false) goto L192;
        r109.f412771b.setRadius(4.0f);
        r109.f412771b.setBorderWidth(0.5f);
        goto L193
    L31:
        if (MessagePermissionUtil.g(r103) == false) goto L43;
        if (r103 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L35;
        int r126 = R.string.Lark_IM_NoReceivingPermission_Text;
    L41:
        j(r100, r104, r105, r126);
        goto L29
    L35:
        if (r108 != null) goto L37;
    L39:
        boolean r127 = false;
    L40:
        i(r127, r100);
        r126 = R.string.Lark_IM_UnableToView_Empty;
        goto L41
    L37:
        if (r108.f410352e != true) goto L39;
        r127 = true;
        goto L40
    L43:
        if (MessagePermissionUtil.f(r312, this.f412673c.getChat(), null) == false) goto L178;
        ImageContentVO r128 = h(r312);
        Log.d("ImageContentBlock", "image key = " + ((String) r128.f411901h.getValue()));
        int r129 = ImageCellLoader.f412190e;
        if (ImageCellLoader.a.b(r128) != null) goto L47;
        com.ss.android.lark.chat.utils.g.f(getContext(), r100.f412773d);
        r100.f412774e.setVisibility(8);
    L101:
        r109 = r100;
    L177:
        r114 = this;
        goto L179
    L47:
        IGetDataCallback<int[]> r130 = new ImageContentBlock$load$resizedSizeCallback$1(this, r100, r312);
        i3b.d r131 = (i3b.d) this.f412671a.f410652c.a(i3b.d.class);
        if (r131 == null) goto L56;
        m2b.a r132 = r131.a();
        if (r132 == null) goto L56;
        com.ss.android.lark.biz.im.api.message.params.g r133 = (com.ss.android.lark.biz.im.api.message.params.g) r132.d0(com.ss.android.lark.biz.im.api.message.params.g.class);
        if (r133 == null) goto L56;
        if (r133.f410352e != true) goto L56;
        boolean r134 = true;
    L57:
        if (r134 == false) goto L59;
        m r210 = new m(this, r100);
    L60:
        ImageCellLoader r135 = (ImageCellLoader) this.f412769h.getValue();
        v4b.d r136 = this.f412675e;
        l r137 = new l(r128, this);
        Function0<Unit> r138 = new ImageContentBlock$load$2(this, r100);
        r135.getClass();
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r312, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r137, "dependency");
        Intrinsics.checkNotNullParameter(r130, "resizedSizeCallback");
        Intrinsics.checkNotNullParameter(r138, "loadDefault");
        Image r139 = (Image) r128.f411902i.getValue();
        if (r139 != null) goto L63;
        r138.invoke();
        goto L101
    L63:
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.f r140 = r135.f412192b;
        if (r140 == null) goto L66;
        Intrinsics.checkNotNull(r140, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.IImageCellParamCalculator");
    L67:
        Intrinsics.checkNotNullParameter(r139, "image");
        int r141 = r139.getWidth();
        int r142 = r139.getHeight();
        float r143 = DeviceUtils.getScreenDensity(r140.f412220a.getContext());
        int r144 = (int) (r141 * r143);
        int r145 = (int) (r142 * r143);
        int r146 = UIHelper.dp2px(240.0f);
        int r147 = r140.f412221b;
        if (r144 != 0) goto L70;
    L76:
        boolean r148 = false;
    L77:
        Log.i("ImageCellSizeCalV2", "imageWidth:" + r144 + ", imageHeight:" + r145 + ", isLargeImage:" + r148);
        if (r148 == false) goto L80;
        int r149 = UIHelper.dp2px(150.0f);
        int r150 = (int) (((r145 * 1.0f) / r144) * r149);
        r145 = UIHelper.dp2px(240.0f);
        boolean r151 = false;
        int r152 = r149;
    L92:
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.a r153 = new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.a(r149, r145, r152, r150, r148, r151);
        if (r149 == 0) goto L98;
        if (r145 == 0) goto L98;
        if (r152 == 0) goto L98;
        if (r150 == 0) goto L98;
        boolean r154 = true;
    L99:
        if (r154 == true) goto L102;
        r138.invoke();
        goto L101
    L102:
        r100.f412779j.setLayoutParams(new FrameLayout.LayoutParams(r149, r145));
        ChatImageGroup r155 = r100.f412779j;
        int r156 = r150;
        r155.f416895c.setVisibility(8);
        r155.f416893a.clearColorFilter();
        if (r148 == false) goto L105;
        r100.f412781l.setVisibility(0);
        r100.f412781l.setText(UIHelper.getString(R.string.Lark_Groups_PostPhotostrip));
    L105:
        if (r151 == false) goto L107;
        r100.f412780k.setScaleType(ImageView.ScaleType.CENTER);
    L108:
        ArrayList r157 = new ArrayList();
        if (r148 == false) goto L111;
        r157.add(new CropTransformation(r149, r145, CropTransformation.CropType.TOP));
    L111:
        r157.add(new WhiteBgTransformation());
        int[] r158 = {r149, r145};
        r130.onSuccess(r158);
        ImageCellPlaceHolderCal r159 = (ImageCellPlaceHolderCal) r135.f412193c.getValue();
        r159.getClass();
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r312, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r158, "resizeSize");
        if (r100.f412780k.getDrawable() != null) goto L114;
    L118:
        boolean r160 = false;
    L120:
        if (Intrinsics.areEqual(r312.getcId(), r100.f412780k.getTag(R.id.chat_window_image_cid)) == false) goto L125;
        if (r160 == false) goto L125;
        if (r312.isPreMessage() == true) goto L125;
        boolean r161 = true;
    L126:
        Drawable r162 = UIHelper.getDrawable(R.drawable.common_failed_chat_picture);
        if (r161 == false) goto L129;
        Drawable r163 = r100.f412780k.getDrawable();
    L131:
        if (r159.f412203b != null) goto L133;
        r159.f412203b = com.ss.android.lark.chat.utils.g.a(r159.f412202a.getContext(), r158[0], r158[1], 0);
    L133:
        if (r163 != null) goto L135;
        r163 = r159.f412203b;
    L135:
        Drawable r164 = r163;
        MessageIdentity r165 = r128.f411907n;
        if (r165 == null) goto L139;
        String r166 = r165.getMessageId();
        if (r166 == null) goto L139;
    L140:
        String r167 = r166;
        StringBuilder r168 = new StringBuilder("start image load, messageId=");
        r168.append(r167);
        r168.append(", imageKey=");
        Image r169 = ImageCellLoader.a.b(r128);
        if (r169 == null) goto L143;
        String r170 = r169.getKey();
    L144:
        r168.append(r170);
        Log.i("ImageCellLoader", r168.toString());
        ListenerParams.a r171 = new ListenerParams.a();
        r171.a(Biz.Messenger);
        r171.d(r137.a().f412213a);
        r171.c(ListenerParams.FromType.IMAGE);
        r171.f426312a = false;
        r171.f426313b = false;
        r171.f426314c = r152;
        r171.f426315d = r156;
        r171.f426325n = r167;
        Image r172 = ImageCellLoader.a.b(r128);
        if (r172 == null) goto L147;
        String r173 = r172.getKey();
    L148:
        r171.f426326o = r173;
        Image r174 = ImageCellLoader.a.b(r128);
        if (r174 == null) goto L151;
        String r175 = r174.getKey();
    L152:
        Intrinsics.checkNotNullParameter(r128, "<this>");
        Image r176 = (Image) r128.f411902i.getValue();
        if (r176 == null) goto L155;
        String r177 = r176.getKey();
    L156:
        r171.f426327p = TextUtils.equals(r175, r177);
        Image r178 = ImageCellLoader.a.b(r128);
        if (r178 == null) goto L159;
        String r179 = r178.getKey();
    L160:
        r171.f426319h = new ImageCellLoader.b(r135.f412191a, r100, r153, r167, r179, r210);
        LoadParams r180 = new LoadParams();
        r180.f426328a = r152;
        r180.f426329b = r156;
        r180.f426330c = r164;
        r180.f426331d = r162;
        DiskCacheStrategy r181 = r137.a().f412214b;
        if (r181 == DiskCacheStrategy.NONE) goto L166;
        if (r148 == false) goto L165;
        r181 = DiskCacheStrategy.SOURCE;
        goto L166
    L165:
        r181 = DiskCacheStrategy.ALL;
    L166:
        r180.f426335h = r181;
        r180.f426336i = r137.a().f412215c;
        r180.f426337j = false;
        r180.f426338k = ((Boolean) ((ImageCellPlaceHolderCal) r135.f412193c.getValue()).f412204c.getValue()).booleanValue();
        if (CollectionUtils.isNotEmpty(r157) == false) goto L170;
        ((ArrayList) r180.f426334g).addAll(r157);
    L170:
        if (z6b.a.f570633a == false) goto L172;
        r180.f426340m = 1;
        r180.f426342o = 1;
        r180.f426341n = 1;
    L173:
        r180.f426339l = r171.b();
        if (com.ss.android.lark.chat.utils.g.d(r312) == false) goto L176;
        r109 = r100;
        com.ss.android.lark.chat.utils.g.f(r135.f412191a.getContext(), r109.f412780k);
        r109.f412781l.setVisibility(8);
        goto L177
    L176:
        r109 = r100;
        com.ss.android.lark.chat.utils.g.g(r135.f412191a.getContext(), r109.f412780k, MessengerImageLoadController.c(MessageImageMonitor.Scene.IMAGE_MESSAGE.getValue(), ImageCellLoader.a.a(r128)), r180, ImageCellLoader.a.a(r128).getInlinePreview(), r210);
        r109.f412780k.setTag(R.id.chat_window_image_cid, r312.getcId());
        goto L177
    L172:
        GifLoadConfig r182 = (GifLoadConfig) SettingManager.getInstance().get(GifLoadConfig.class);
        int r183 = r182.component1();
        int r184 = r182.component2();
        r180.f426340m = r182.component3();
        r180.f426342o = r184;
        r180.f426341n = r183;
        goto L173
    L159:
        r179 = null;
        goto L160
    L155:
        r177 = null;
        goto L156
    L151:
        r175 = null;
        goto L152
    L147:
        r173 = null;
        goto L148
    L143:
        r170 = null;
    L139:
        r166 = "";
        goto L140
    L129:
        r163 = null;
    L125:
        r161 = false;
        goto L126
    L114:
        if ((r100.f412780k.getDrawable() instanceof GifDrawable) == true) goto L118;
        if ((r100.f412780k.getDrawable() instanceof WebpDrawable) == true) goto L118;
        r160 = true;
        goto L120
    L107:
        r100.f412780k.setScaleType(ImageView.ScaleType.FIT_CENTER);
    L98:
        r154 = false;
        goto L99
    L80:
        int r185 = UIHelper.dp2px(40.0f);
        int r186 = r140.f412221b;
        if (r144 > r186) goto L85;
        if (r145 > r146) goto L85;
        if (r144 <= 0) goto L85;
        if (r145 <= 0) goto L85;
    L86:
        if (r144 >= r185) goto L88;
        r149 = r185;
        boolean r187 = true;
    L89:
        if (r145 >= r185) goto L91;
        r150 = r145;
        r145 = r185;
        r152 = r144;
        r151 = true;
        goto L92
    L91:
        r152 = r144;
        r151 = r187;
        r150 = r145;
        goto L92
    L88:
        r149 = r144;
        r187 = false;
    L85:
        int[] r188 = ImageUtils.g(r144, r145, r186, r146, 1, 1);
        r144 = r188[0];
        r145 = r188[1];
        goto L86
    L70:
        if ((r145 / r144) < 3) goto L76;
        if (r144 <= UIHelper.dp2px(200.0f)) goto L76;
        if (r147 <= UIHelper.dp2px(150.0f)) goto L76;
        r148 = true;
        goto L77
    L66:
        r140 = new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.f(r135.f412191a, r135.a(r312, r136));
        r135.f412192b = r140;
        goto L67
    L59:
        r210 = null;
    L56:
        r134 = false;
        goto L57
    L178:
        r109 = r100;
        i(false, r109);
        r114 = this;
        r114.j(r109, r104, r105, R.string.Lark_IM_UnableToPreviewImage_Text);
        goto L179
    L23:
        if (r112.isCSAMDelete() != true) goto L25;
        r113 = true;
        goto L27
    L15:
        if (r108.f410352e != true) goto L17;
        r110 = true;
    L11:
        r108 = null;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }

    public final void j(b r100, int r101, int r102, int r103) {
        Pair<Integer, Integer> r104 = MessagePermissionUtil.l(r100.f412773d, r103);
        if (this.f412675e == null) goto L5;
        r104 = MessagePermissionUtil.i(r104, r101, r101, r102);
    L5:
        ViewGroup.LayoutParams r105 = r100.f412772c.getLayoutParams();
        r105.width = r104.getFirst().intValue();
        r105.height = r104.getSecond().intValue();
        r100.f412772c.setLayoutParams(r105);
    }
}
