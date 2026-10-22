package com.ss.android.lark.chatwindow.view.preview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.PreviewVideo;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements c<b, h2b.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f417044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.OnLongClickListener f417045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f417046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.chatwindow.view.preview.b f417047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BrowserDependency f417048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w4b.a f417049f;

    public interface a {
        boolean a();

        String b();

        boolean isGroup();
    }

    public static final class b extends c.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinearLayout f417050b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f417051c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f417052d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f417053e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImageView f417054f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ImageView f417055g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ImageView f417056h;

        public b(ViewGroup r100, com.ss.android.lark.chatwindow.view.preview.b r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "extraProvider");
            super(r100);
            this.f417050b = (LinearLayout) r100.findViewById(R.id.url_preview_layout);
            this.f417051c = r100.findViewById(R.id.divider_preview);
            TextView r102 = (TextView) r100.findViewById(R.id.url_title);
            this.f417052d = r102;
            TextView r103 = (TextView) r100.findViewById(R.id.url_description);
            this.f417053e = r103;
            ImageView r104 = (ImageView) r100.findViewById(R.id.url_icon);
            this.f417054f = r104;
            this.f417055g = (ImageView) r100.findViewById(R.id.video_preview);
            this.f417056h = (ImageView) r100.findViewById(R.id.play_video);
            zz7.a.a(r104, r101.b());
            zz7.a.d(r102, r101.c());
            zz7.a.d(r103, r101.a());
        }
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final int getPreviewType() {
        return 1;
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final void a(h2b.a r210, c.a r211) {
        h2b.d r100 = (h2b.d) r210;
        b r101 = (b) r211;
        ImageView r102 = null;
        if (r100 == null) goto L5;
        MessageUrlPreview r103 = r100.f483641a;
    L6:
        boolean r104 = true;
        if (r103 == null) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L99;
        if (r100 == null) goto L96;
        MessageUrlPreview r110 = r100.f483641a;
        if (r110 == null) goto L97;
        ImageSet r106 = r110.getIcon();
        if (CollectionUtils.isNotEmpty(r106.getOrigin().getUrls()) == false) goto L18;
        String r107 = (String) ListProtector.get(r106.getOrigin().getUrls(), 0);
        int r108 = R.drawable.url_preview_icon;
    L19:
        String r109 = r110.getTitle();
        String r111 = r110.getDescription();
        Context r112 = this.f417044a;
        if ((r112 instanceof Activity) == true) goto L22;
    L23:
        IRequestCreator r113 = ImageLoader.with(this.f417044a).load(r107).error(r108);
        if (r101 == null) goto L26;
        ImageView r114 = r101.f417054f;
    L27:
        r113.into(r114);
    L28:
        if (r101 == null) goto L32;
        TextView r115 = r101.f417052d;
        if (r115 == null) goto L32;
        r115.setText(r109);
    L32:
        int r116 = 8;
        if (r101 == null) goto L41;
        TextView r117 = r101.f417052d;
        if (r117 == null) goto L41;
        if (TextUtils.isEmpty(r109) == true) goto L39;
        int r118 = 0;
    L40:
        r117.setVisibility(r118);
        goto L41
    L39:
        r118 = 8;
    L41:
        if (r101 == null) goto L45;
        TextView r119 = r101.f417053e;
        if (r119 == null) goto L45;
        r119.setText(r111);
    L45:
        if (r101 == null) goto L53;
        TextView r120 = r101.f417053e;
        if (r120 == null) goto L53;
        if (TextUtils.isEmpty(r111) == true) goto L51;
        int r121 = 0;
    L52:
        r120.setVisibility(r121);
        goto L53
    L51:
        r121 = 8;
    L53:
        if (r101 == null) goto L61;
        TextView r122 = r101.f417053e;
        if (r122 == null) goto L61;
        boolean r123 = this.f417046c.a();
        int r124 = p3b.a.W;
        if (r123 == false) goto L59;
        int r125 = v4b.a.f553183u;
    L60:
        r122.setTextColor(r125);
        goto L61
    L59:
        r125 = v4b.a.R;
    L61:
        ImageSet r126 = r110.getCoverImage();
        String r127 = r110.getUrl();
        View.OnLongClickListener r128 = this.f417045b;
        if (r126 != null) goto L64;
    L77:
        r104 = false;
    L78:
        if (r101 == null) goto L82;
        LinearLayout r129 = r101.f417050b;
        if (r129 == null) goto L82;
        r129.setOnClickListener(new e(this, r110, r104, r127));
    L82:
        if (r101 == null) goto L98;
        LinearLayout r130 = r101.f417050b;
        r130.setVisibility(0);
        ImageView r131 = r101.f417055g;
        if (r104 == false) goto L86;
        int r132 = 0;
    L87:
        r131.setVisibility(r132);
        ImageView r133 = r101.f417056h;
        if (r104 == false) goto L90;
        r116 = 0;
    L90:
        r133.setVisibility(r116);
        View r134 = r101.f417051c;
        boolean r135 = this.f417046c.a();
        int r136 = p3b.a.W;
        if (r135 == false) goto L93;
        int r137 = v4b.a.f553170h;
    L94:
        r134.setBackgroundColor(r137);
        r130.setPadding(0, UIHelper.dp2px(7.5f), 0, 0);
        return;
    L93:
        r137 = v4b.a.G;
        goto L94
    L86:
        r132 = 8;
        goto L87
    L98:
        return;
    L64:
        if (CollectionUtils.isNotEmpty(r126.getOrigin().getUrls()) == false) goto L77;
        Drawable r138 = UIHelper.getDrawable(R.drawable.common_chat_window_image_item_holder);
        LoadParams r139 = new LoadParams();
        r139.f426330c = r138;
        r139.f426331d = r138;
        r139.f426332e = ImageView.ScaleType.FIT_CENTER;
        r139.f426335h = DiskCacheStrategy.ALL;
        ListenerParams.a r140 = new ListenerParams.a();
        r140.a(Biz.Messenger);
        r140.d(Scene.Chat);
        r140.c(ListenerParams.FromType.URL_PREVIEW);
        r139.f426339l = r140.b();
        Context r141 = this.f417044a;
        if (r101 == null) goto L68;
        r102 = r101.f417055g;
    L68:
        com.ss.android.lark.chat.utils.g.g(r141, r102, r126.getOrigin(), r139, null, null);
        PreviewVideo r142 = r110.getPreviewVideo();
        if (r101 == null) goto L73;
        ImageView r143 = r101.f417055g;
        if (r143 == null) goto L73;
        r143.setOnLongClickListener(r128);
    L73:
        if (r101 == null) goto L78;
        ImageView r144 = r101.f417055g;
        if (r144 == null) goto L78;
        r144.setOnClickListener(new f(this, r127, r142, r126, r101));
        goto L78
    L26:
        r114 = null;
        goto L27
    L22:
        if (((Activity) r112).isFinishing() == true) goto L28;
    L18:
        r107 = null;
        r108 = 0;
        goto L19
    L97:
        return;
    L96:
        return;
    L99:
        return;
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final c.a b(h2b.a r100, ViewGroup r101) {
        h2b.d r102 = (h2b.d) r100;
        Intrinsics.checkNotNullParameter(r101, "parent");
        if (r102 == null) goto L5;
        MessageUrlPreview r103 = r102.f483641a;
    L6:
        if (r103 == null) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L12;
        return null;
    L12:
        return new b(r101, this.f417047d);
    L8:
        r104 = false;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public d(FragmentActivity r100, View.OnLongClickListener r101, m7b.d r102, m7b.e r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "dataProvider");
        Intrinsics.checkNotNullParameter(r103, "extraProvider");
        this.f417044a = r100;
        this.f417045b = r101;
        this.f417046c = r102;
        this.f417047d = r103;
        this.f417048e = ChatCoreModule.a().getBrowserDependency();
        this.f417049f = ChatCoreModule.a().getAuditDependency();
    }
}
