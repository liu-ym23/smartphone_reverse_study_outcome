package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.popwindow.EmojiPreviewPopWindow;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public class StickerPageAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Sticker> f429683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f429684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EmojiPreviewPopWindow f429685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseBooleanArray f429686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f429687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f429688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f429689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f429690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f429691i;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f429692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f429693b;

        public ViewHolder(View r100) {
            super(r100);
            this.f429692a = (ImageView) r100.findViewById(R.id.display_image);
            this.f429693b = (TextView) r100.findViewById(R.id.itemText);
        }
    }

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<StickerPageAdapter> f429694a;

        public a(StickerPageAdapter r100) {
            this.f429694a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            StickerPageAdapter r101 = this.f429694a.get();
            if (r101 == null) goto L20;
            View r102 = (View) r100.obj;
            int r103 = r100.getData().getInt("key_sticker_index");
            int r104 = 1;
            r101.f429686d.put(r103, true);
            if (r103 >= ((ArrayList) r101.f429683a).size()) goto L9;
            if (r103 < 0) goto L9;
            Sticker r105 = (Sticker) ListProtector.get(r101.f429683a, r103);
        L10:
            if (r105 == null) goto L21;
            EmojiPreviewPopWindow.b r106 = new EmojiPreviewPopWindow.b(r102, r105.getOriginImageKey());
            r106.f447987e = r105.getDesc();
            int r107 = StickerPageFragment.f429695s;
            int r108 = r103 % 4;
            if (r108 != 0) goto L16;
            r104 = 0;
        L18:
            r106.f447986d = r104;
            r106.f447985c = r105.getStickerSetId();
            r101.f429685c.b(r106);
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

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f429683a).size();
    }

    public StickerPageAdapter(Context r100) {
        this.f429683a = new ArrayList();
        this.f429686d = new SparseBooleanArray();
        this.f429687e = new a(this);
        this.f429684b = r100;
        EmojiPreviewPopWindow r101 = new EmojiPreviewPopWindow(r100);
        this.f429685c = r101;
        r101.f447982g = new l(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        final ViewHolder r112 = (ViewHolder) r110;
        if (r111 >= ((ArrayList) this.f429683a).size()) goto L7;
        if (r111 < 0) goto L7;
        Sticker r113 = (Sticker) ListProtector.get(this.f429683a, r111);
    L9:
        if (r113 != null) goto L11;
        Log.e("StickerPageAdapter", "onBindViewHolder called. sticker is null.");
        return;
    L11:
        r112.f429693b.setText(r113.getDesc());
        int r100 = UIUtils.dp2px(this.f429684b, 50.0f);
        if (this.f429690h == null) goto L20;
        Log.d("StickerPage", "onBindViewHolder " + r113.getThumbnailImageKey());
        e r101 = this.f429691i;
        if (r101 == null) goto L19;
        String r102 = r113.getThumbnailImageKey();
        StickerPageFragment r103 = ((s) r101).f429735a;
        if (((HashMap) r103.f429702j).containsKey(r102) == true) goto L19;
        ((HashMap) r103.f429702j).put(r102, Long.valueOf(System.currentTimeMillis()));
        r103.f429706n++;
    L19:
        ((t) this.f429690h).a(this.f429684b, r100, r100, r113.getThumbnailImageKey(), r112.f429692a, R.drawable.kb_ic_icon_sticker_item_default, r113.getStickerSetId());
    L21:
        r112.f429692a.setOnTouchListener(new m(this, r112));
        r112.f429692a.setOnClickListener(new p(this, r113));
        return;
    L20:
        Log.e("StickerPageAdapter", "onBindViewHolder called. GlideStickerLoader is null.");
    L7:
        r113 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
        Context r112 = r110.getContext();
        int r113 = UIUtils.dp2px(r112, 50);
        LinearLayout r100 = new LinearLayout(r112);
        ViewGroup.LayoutParams r101 = new ViewGroup.MarginLayoutParams(-1, -2);
        r100.setGravity(17);
        r100.setOrientation(1);
        r100.setPadding(0, UIUtils.dp2px(r112, 12.0f), 0, 0);
        r100.setLayoutParams(r101);
        FrameLayout r102 = new FrameLayout(r112);
        ViewGroup.LayoutParams r103 = new LinearLayout.LayoutParams(r113, r113);
        ImageView r114 = new ImageView(r112);
        r114.setId(R.id.display_image);
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-1, -1);
        r114.setImageDrawable(UIUtils.getDrawable(r112, R.drawable.kb_ic_icon_sticker_item_default));
        r104.gravity = 17;
        r114.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r114.setAdjustViewBounds(true);
        r102.addView(r114);
        View r115 = new View(r112);
        r115.setBackgroundColor(r112.getResources().getColor(R.color.fill_img_mask));
        r102.addView(r115, new FrameLayout.LayoutParams(-1, -1));
        r100.addView(r102, r103);
        TextView r116 = new TextView(r112);
        r116.setId(R.id.itemText);
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(-1, -2);
        int r106 = UIUtils.dp2px(r112, 10.0f);
        r105.setMargins(r106, UIUtils.dp2px(r112, 4.0f), r106, 0);
        r105.gravity = 17;
        r116.setGravity(17);
        r116.setTextColor(UIUtils.getColor(r112, R.color.text_caption));
        r116.setLines(1);
        r116.setEllipsize(TextUtils.TruncateAt.END);
        r116.setTextSize(12.0f);
        r100.addView(r116, r105);
        return new ViewHolder(r100);
    }
}
