package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.popwindow.EmojiPreviewPopWindow;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public class FaceNewAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Sticker> f429658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f429659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EmojiPreviewPopWindow f429660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseBooleanArray f429661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f429662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f429663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f429664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f429665h;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f429666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f429667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f429668c;

        public ViewHolder(View r100) {
            super(r100);
            this.f429666a = (ImageView) r100.findViewById(R.id.display_image);
            this.f429667b = r100.findViewById(R.id.image_mask);
            this.f429668c = (ImageView) r100.findViewById(R.id.loading_image);
        }
    }

    public class a extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f429669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FaceNewAdapter f429670b;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            return this.f429669a.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            return ((ArrayList) this.f429670b.f429658a).size();
        }

        public a(FaceNewAdapter r100, List r101) {
            this.f429670b = r100;
            this.f429669a = r101;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            return ((Sticker) ListProtector.get(this.f429670b.f429658a, r100)).isContentSame((Sticker) ListProtector.get(this.f429669a, r101));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            return ((Sticker) ListProtector.get(this.f429670b.f429658a, r100)).isItemSame((Sticker) ListProtector.get(this.f429669a, r101));
        }
    }

    public static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<FaceNewAdapter> f429671a;

        public b(FaceNewAdapter r100) {
            this.f429671a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            FaceNewAdapter r101 = this.f429671a.get();
            if (r101 == null) goto L20;
            View r102 = (View) r100.obj;
            int r103 = r100.getData().getInt("key_sticker_index");
            int r104 = 1;
            r101.f429661d.put(r103, true);
            if (r103 >= ((ArrayList) r101.f429658a).size()) goto L9;
            if (r103 < 0) goto L9;
            Sticker r105 = (Sticker) ListProtector.get(r101.f429658a, r103);
        L10:
            if (r105 == null) goto L21;
            EmojiPreviewPopWindow.b r106 = new EmojiPreviewPopWindow.b(r102, r105.getOriginImageKey());
            r106.f447987e = r105.getDesc();
            int r107 = FacePageNewFragment2.f429672n;
            int r108 = r103 % 4;
            if (r108 != 0) goto L16;
            r104 = 0;
        L18:
            r106.f447986d = r104;
            r106.f447985c = r105.getStickerSetId();
            r101.f429660c.b(r106);
            return;
        L16:
            if (r108 != 3) goto L18;
            r104 = 2;
            goto L18
        L21:
            return;
        L9:
            r105 = null;
            goto L10
        }
    }

    public interface c {
        void a();

        void b(com.ss.android.lark.keyboard.plugin.tool.face.d r100);
    }

    public interface d {
        void a(Context r100, int r101, int r102, String r103, ImageView r104, int r105);
    }

    public interface e {
        com.ss.android.lark.keyboard.plugin.tool.face.d a(String r100, int r101, int r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f429658a).size();
    }

    public FaceNewAdapter(Context r100) {
        this.f429658a = new ArrayList();
        this.f429661d = new SparseBooleanArray();
        this.f429662e = new b(this);
        this.f429659b = r100;
    }

    public final void setData(List<Sticker> r100) {
        if (CollectionUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (this.f429660c == null) goto L8;
        Log.i("FaceNewAdapter", "newEmojiPreviewPopWindow called. destroy");
        EmojiPreviewPopWindow r101 = this.f429660c;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
        EmojiPreviewPopWindow r102 = this.f429660c;
        r102.f447977b = null;
        r102.f447978c = null;
        r102.f447980e = null;
        r102.f447982g = null;
        this.f429660c = null;
    L8:
        EmojiPreviewPopWindow r103 = new EmojiPreviewPopWindow(this.f429659b);
        this.f429660c = r103;
        r103.f447982g = new com.ss.android.lark.keyboard.plugin.tool.face.sticker.a(this);
        DiffUtil.calculateDiff(new a(this, r100)).dispatchUpdatesTo(this);
        ((ArrayList) this.f429658a).clear();
        ((ArrayList) this.f429658a).addAll(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        final ViewHolder r112 = (ViewHolder) r110;
        if (r111 >= ((ArrayList) this.f429658a).size()) goto L7;
        if (r111 < 0) goto L7;
        Sticker r113 = (Sticker) ListProtector.get(this.f429658a, r111);
    L9:
        if (r113 != null) goto L11;
        Log.e("FaceNewAdapter", "onBindViewHolder called. sticker is null.");
        return;
    L11:
        r112.f429668c.setVisibility(8);
        if (r113.getImageSet() == null) goto L14;
        int r100 = UIUtils.dp2px(this.f429659b, 74);
        d r101 = this.f429665h;
        if (r101 == null) goto L20;
        r101.a(this.f429659b, r100, r100, r113.getImageKey(), r112.f429666a, R.drawable.kb_emoji_load_holder);
    L21:
        r112.f429666a.setOnTouchListener(new com.ss.android.lark.keyboard.plugin.tool.face.sticker.b(this, r112));
        r112.f429666a.setOnClickListener(new f(this, r113));
        return;
    L20:
        Log.e("FaceNewAdapter", "onBindViewHolder called. GlideStickerLoader is null.");
        goto L21
    L14:
        if ("-1".equals(r113.getStickerId()) == false) goto L16;
        r112.f429666a.setImageDrawable(null);
        r112.f429668c.setVisibility(0);
        return;
    L16:
        ImageLoader.clear(r112.f429666a);
        r112.f429666a.setImageDrawable(UIHelper.getDrawable(R.drawable.ic_icon_empty_sticker_add));
        r112.f429668c.setVisibility(8);
        r112.f429666a.setOnClickListener(new com.ss.android.lark.keyboard.plugin.tool.face.sticker.c(this));
        return;
    L7:
        r113 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Context r102 = this.f429659b;
        RelativeLayout r103 = new RelativeLayout(r102);
        ViewGroup.MarginLayoutParams r104 = new ViewGroup.MarginLayoutParams(-2, -2);
        int r105 = UIUtils.dp2px(r102, 15.0f);
        r104.setMargins(r105, r105, r105, r105);
        int r106 = UIUtils.dp2px(r102, 74);
        r103.setGravity(17);
        r103.setLayoutParams(r104);
        ImageView r107 = new ImageView(r102);
        r107.setId(R.id.display_image);
        RelativeLayout.LayoutParams r108 = new RelativeLayout.LayoutParams(r106, r106);
        r108.addRule(13, -1);
        r107.setContentDescription(null);
        r107.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r103.addView(r107, r108);
        View r109 = new View(r102);
        r109.setId(R.id.image_mask);
        RelativeLayout.LayoutParams r110 = new RelativeLayout.LayoutParams(r106, r106);
        r110.addRule(13, -1);
        r103.addView(r109, r110);
        ImageView r111 = new ImageView(r102);
        r111.setId(R.id.loading_image);
        RelativeLayout.LayoutParams r112 = new RelativeLayout.LayoutParams(r106, r106);
        r112.addRule(13, -1);
        r111.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r111.setImageDrawable(UIUtils.getDrawable(r102, R.drawable.kb_emoji_loading_im));
        r111.setVisibility(8);
        r103.addView(r111, r112);
        return new ViewHolder(r103);
    }
}
