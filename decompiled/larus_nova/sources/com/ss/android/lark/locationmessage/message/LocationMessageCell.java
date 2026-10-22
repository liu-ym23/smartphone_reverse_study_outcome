package com.ss.android.lark.locationmessage.message;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.message.params.k;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.content.LocationContent;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.chat.utils.f0;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.impl.LarkImageUtil;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class LocationMessageCell implements r5b.d<LocationContentVO>, u5b.a<LocationContentVO> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f431295h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f431296i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Token f431297j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r5b.a f431298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r5b.b<LocationContentVO> f431299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f431300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f431301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f431302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f431303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final mqb.a.InterfaceC6845a f431304g;

    public static class LocationMessageViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f431305a;

        @BindView(9425)
        public ImageView mImageView;

        @BindView(9433)
        public View mLoadingProgress;

        @BindView(9717)
        public LKUIRoundableLayout mRoundLayout;

        @BindView(9858)
        public TextView mSubTitleTv;

        @BindView(9943)
        public TextView mTitleTv;

        public LocationMessageViewHolder(View r100) {
            this.f431305a = r100;
            ButterKnife.bind(this, r100);
            zz7.a.d(this.mTitleTv, LarkFont.HEADLINE);
            zz7.a.d(this.mSubTitleTv, LarkFont.CAPTION0);
        }
    }

    public class LocationMessageViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LocationMessageViewHolder f431306a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            LocationMessageViewHolder r100 = this.f431306a;
            if (r100 == null) goto L7;
            this.f431306a = null;
            r100.mRoundLayout = null;
            r100.mTitleTv = null;
            r100.mSubTitleTv = null;
            r100.mImageView = null;
            r100.mLoadingProgress = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public LocationMessageViewHolder_ViewBinding(LocationMessageViewHolder r100, View r101) {
            this.f431306a = r100;
            r100.mRoundLayout = (LKUIRoundableLayout) Utils.findRequiredViewAsType(r101, R.id.round_container, "field 'mRoundLayout'", LKUIRoundableLayout.class);
            r100.mTitleTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.title_tv, "field 'mTitleTv'", TextView.class);
            r100.mSubTitleTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.sub_title_tv, "field 'mSubTitleTv'", TextView.class);
            r100.mImageView = (ImageView) Utils.findRequiredViewAsType(r101, R.id.location_iv, "field 'mImageView'", ImageView.class);
            r100.mLoadingProgress = Utils.findRequiredView(r101, R.id.location_message_image_loading, "field 'mLoadingProgress'");
        }
    }

    @Override // r5b.d
    public final void f(View r100) {
    }

    static {
        f431295h = UIHelper.dp2px(12.0f);
        f431296i = UIHelper.dp2px(8.0f);
        f431297j = new Token("LARK-PSDA-location_message_cell");
    }

    @Override // r5b.d
    public final Class<LocationContentVO> c() {
        return LocationContentVO.class;
    }

    public static BubbleStyle b(v5b.c<LocationContentVO> r100) {
        int r101 = 0;
        if (TextUtils.isEmpty(r100.i()) == true) goto L10;
        int[] r102 = new int[4];
        r102[0] = 0;
        r102[1] = f431296i;
        r102[2] = 0;
        if (r100.l() == false) goto L7;
        r101 = f431295h;
    L7:
        r102[3] = r101;
        BubbleStyle.a(12, null, r102);
        return BubbleStyle.f415420h;
    L10:
        if (r100.j() == false) goto L12;
    L17:
        BubbleStyle r103 = BubbleStyle.f415420h;
        r103.f415422b = null;
        r103.f415425e = 0;
        r103.f415426f = 0;
        r103.b();
        r103.f415423c = -1;
        r103.f415424d = -1;
        r103.f415427g = false;
        r103.f415425e = 12;
        r103.f415422b = new WeakReference(null);
        r103.b();
        return r103;
    L12:
        if (r100.m() == true) goto L17;
        if (r100.l() == false) goto L17;
        BubbleStyle.a(12, null, new int[]{0, 0, 0, 0});
        return BubbleStyle.f415420h;
    }

    @Override // u5b.a
    public final u5b.c i(v5b.c<LocationContentVO> r100) {
        if (r100.h() == false) goto L5;
        int r101 = v4b.a.f553171i;
    L7:
        if (r100.h() == false) goto L9;
        int r102 = v4b.a.f553171i;
    L11:
        if (r100.h() == false) goto L13;
        int r103 = v4b.a.f553186x;
    L14:
        Drawable r104 = UIHelper.getDrawable(r103);
        int r105 = f431295h;
        int[] r106 = {r105, f431296i, r105, 0};
        u5b.c r107 = u5b.c.f548903e;
        return u5b.c.a.a(r101, r102, r104, r106);
    L13:
        r103 = v4b.a.T;
        goto L14
    L9:
        r102 = v4b.a.H;
        goto L11
    L5:
        r101 = v4b.a.H;
        goto L7
    }

    public LocationMessageCell(r5b.a r100, p2b.b r101) {
        this.f431304g = lqb.b.f510384a.getImageDependency();
        this.f431298a = r100;
        this.f431299b = r101;
        int r102 = UIHelper.getWindowWidth(r100.getContext());
        this.f431300c = UIUtils.dp2px(r100.getContext(), 50.0f);
        double r103 = r102;
        this.f431301d = (int) (0.52d * r103);
        int r104 = (int) (r103 * 0.2d);
        this.f431302e = r104;
        this.f431303f = r104;
    }

    @Override // r5b.d
    public final View a(LayoutInflater r100, ViewGroup r101) {
        return r100.inflate(R.layout.location_content_item, r101, false);
    }

    @Override // u5b.a
    public final BubbleStyle d(v5b.c<LocationContentVO> r100, View r101) {
        return b(r100);
    }

    @Override // r5b.d
    public final void e(View r210, int r211, v5b.c<LocationContentVO> r212) {
        LocationMessageViewHolder r100 = (LocationMessageViewHolder) r210.getTag();
        if (r100 != null) goto L5;
        r100 = new LocationMessageViewHolder(r210);
        r210.setTag(r100);
    L5:
        LocationMessageViewHolder r101 = r100;
        LocationContent r102 = (LocationContent) ((LocationContentVO) r212.b()).f553338a;
        if (r102 == null) goto L94;
        FragmentActivity r103 = this.f431298a.getContext();
        if (TextUtils.isEmpty(r102.getName()) == false) goto L11;
        String r104 = UIHelper.mustacheFormat(R.string.Lark_Chat_MessageReplyStatusLocation, "title", "");
    L12:
        String r105 = r104;
        String r106 = r102.getDescription();
        r101.mTitleTv.setText(r105);
        if (TextUtils.isEmpty(r106) == false) goto L15;
        r101.mSubTitleTv.setVisibility(8);
    L16:
        ImageSet r107 = r102.getImage();
        if (r107 != null) goto L19;
        Image r110 = null;
    L29:
        if (r110 != null) goto L31;
        ImageView r108 = r101.mImageView;
        LruCache<String, Boolean> r109 = ImageUtils.f444663a;
        int r111 = UIUtils.dp2px(r103, 100.0f);
        ImageLoader.with(r103).load(Integer.valueOf(R.drawable.chat_window_image_item_holder)).override(r111, r111).centerCrop().into(r108);
    L76:
        if (TextUtils.isEmpty(r212.i()) == true) goto L78;
    L87:
        r101.mRoundLayout.setRadius(0.0f);
        r101.mRoundLayout.setBorderWidth(0.0f);
        r101.mRoundLayout.setBackground(null);
    L88:
        r101.f431305a.setOnClickListener(new d(this, r212, r102, r105, r106, r103));
        r101.f431305a.setOnLongClickListener(new e(this, r101, r212));
        RelativeLayout.LayoutParams r112 = (RelativeLayout.LayoutParams) r101.mTitleTv.getLayoutParams();
        if (TextUtils.isEmpty(r212.i()) == false) goto L91;
        int r113 = UIUtils.dp2px(this.f431298a.getContext(), 10.0f);
    L92:
        int r114 = f431295h;
        r112.setMargins(r114, r113, r114, 0);
        return;
    L91:
        r113 = 0;
        goto L92
    L78:
        if (r212.l() == true) goto L80;
    L82:
        int r115 = f0.f416667a;
        Intrinsics.checkNotNullParameter(r212, "messageVO");
        float[] r116 = f0.a(r212, 10.0f, 2.0f);
        r101.mRoundLayout.setRadius(r116[0], r116[1], r116[2], r116[3]);
        r101.mRoundLayout.setBorderWidth(1.0f);
        LKUIRoundableLayout r117 = r101.mRoundLayout;
        Integer r118 = Integer.valueOf(b(r212).f415425e);
        k r119 = (k) this.f431298a.d0(k.class);
        if (r118.intValue() != 19) goto L85;
        Integer r120 = Integer.valueOf(UIUtils.getColor(r103, R.color.line_border_card));
    L86:
        r117.setBorderColor(r120.intValue());
        r101.mRoundLayout.setBackgroundColor(UIUtils.getColor(this.f431298a.getContext(), R.color.bg_float));
        goto L88
    L85:
        r120 = Integer.valueOf(UIUtils.getColor(r103, R.color.imtoken_message_card_border));
        goto L86
    L80:
        if (this.f431298a.m() == true) goto L82;
    L31:
        if (CollectionUtils.isNotEmpty(r110.getUrls()) == false) goto L33;
        String r121 = (String) ListProtector.get(r110.getUrls(), 0);
    L33:
        Image r122 = r102.getImage().getOrigin();
        int r123 = r122.getWidth();
        int r124 = r122.getHeight();
        int r125 = this.f431300c;
        int r126 = this.f431301d;
        if (r125 <= r126) goto L36;
        int r127 = this.f431302e;
    L37:
        if (r125 <= r126) goto L39;
        int r128 = this.f431303f;
    L40:
        int[] r129 = ImageUtils.g(r123, r124, r126, r126, r127, r128);
        int r130 = r129[0];
        int r131 = r129[1];
        if (r212.getcId().equals(r101.mImageView.getTag(R.id.chat_window_image_cid)) == true) goto L43;
    L45:
        boolean r132 = false;
    L46:
        if (r132 == false) goto L48;
        Drawable r133 = r101.mImageView.getDrawable();
    L49:
        if (r133 == null) goto L51;
        Drawable r134 = r133;
    L52:
        if (r133 != null) goto L55;
        r133 = new ColorDrawable(ContextCompat.getColor(this.f431298a.getContext(), R.color.bg_filler));
    L55:
        View r135 = r101.mLoadingProgress;
        if (r132 == true) goto L58;
        int r136 = 0;
    L59:
        r135.setVisibility(r136);
        boolean r137 = this.f431298a.isSecretChat();
        if (r137 == false) goto L63;
        Scene r138 = Scene.SecretChat;
    L69:
        mqb.a.InterfaceC6845a r139 = this.f431304g;
        ImageView r140 = r101.mImageView;
        LoadParams r141 = new LoadParams();
        r141.f426328a = r130;
        r141.f426329b = r131;
        r141.f426330c = r134;
        r141.f426331d = r133;
        if (r137 == false) goto L72;
        DiskCacheStrategy r142 = DiskCacheStrategy.NONE;
    L73:
        r141.f426335h = r142;
        r141.f426336i = r137;
        ListenerParams.a r143 = new ListenerParams.a();
        r143.f426313b = true;
        r143.f426312a = true;
        r143.f426319h = new c(r101);
        r143.f426326o = r110.getKey();
        r143.f426327p = TextUtils.equals(r110.getKey(), r122.getKey());
        r143.d(r138);
        r141.f426339l = r143.b();
        ((com.ss.android.lark.integrator.im.message.a) r139).getClass();
        EncryptImage r144 = new EncryptImage(r110.getKey(), r110.getFsUnit(), r110.getCrypto());
        r144.setStoreToPrivatePath(r141.f426336i);
        LarkImageUtil.loadImage(r103, r140, r144, r141);
        r101.mImageView.setTag(R.id.chat_window_image_cid, r212.getcId());
        goto L76
    L72:
        r142 = DiskCacheStrategy.ALL;
        goto L73
    L63:
        if (this.f431298a.r() == false) goto L65;
    L68:
        r138 = Scene.Thread;
        goto L69
    L65:
        if (this.f431298a.q() == true) goto L68;
        r138 = Scene.Chat;
        goto L69
    L58:
        r136 = 8;
        goto L59
    L51:
        r134 = new ColorDrawable(ContextCompat.getColor(this.f431298a.getContext(), R.color.bg_body_overlay));
        goto L52
    L48:
        r133 = null;
        goto L49
    L43:
        if (r101.mImageView.getDrawable() == null) goto L45;
        r132 = true;
        goto L46
    L39:
        r128 = r125;
        goto L40
    L36:
        r127 = r125;
        goto L37
    L19:
        r110 = r107.getOrigin();
        if (r110 == null) goto L29;
        if (CollectionUtils.isEmpty(r110.getUrls()) == true) goto L29;
        if (URLUtil.isNetworkUrl((String) ListProtector.get(r110.getUrls(), 0)) == false) goto L29;
        r110 = r107.getThumbnail();
        goto L29
    L15:
        r101.mSubTitleTv.setVisibility(0);
        r101.mSubTitleTv.setText(r106);
        goto L16
    L11:
        r104 = r102.getName();
        goto L12
    }
}
